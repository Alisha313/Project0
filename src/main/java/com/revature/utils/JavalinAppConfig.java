package com.revature.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.controllers.PatientsController;
import com.revature.controllers.DoctorsController;
import io.javalin.Javalin;
import io.javalin.json.JsonMapper;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinAppConfig {

    Gson gson = new GsonBuilder().create();
    JsonMapper gsonMapper = new JsonMapper() {
        @Override
        public String toJsonString(@NotNull Object obj, @NotNull Type type) {

            return gson.toJson(obj, type);
        }

        @Override
        public <T> T fromJsonString(@NotNull String json, @NotNull Type targetType) {
            return gson.fromJson(json, targetType);
        }
    };

    private Javalin app = Javalin.create(config -> config.jsonMapper(gsonMapper))

            .routes(() -> {
                path("Patients", () -> {
                    get(PatientsController::getAllPatients);
                    post(PatientsController::insertPatients);
                    put(PatientsController::updatePatients);
                    delete(PatientsController::deletePatients);
                    path("{id}", () -> {
                        get(PatientsController::getPatientsById);
                    });
                });
                path("Doctors", () -> {
                    get(DoctorsController::getAllDoctors);
                    post(DoctorsController::insertDoctors);
                    put(DoctorsController::updateDoctors);
                    delete(DoctorsController::deleteDoctors);
                    path("{id}", () -> {
                        get(DoctorsController::getDoctorsById);
                    });
                });
            });

    public void start (int port){

        app.start(port);
    }

}


