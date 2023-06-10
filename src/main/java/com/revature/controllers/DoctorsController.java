package com.revature.controllers;

import com.revature.models.Doctor;
import com.revature.service.DoctorsService;
import io.javalin.http.Context;

import java.util.ArrayList;

public class DoctorsController {

    private static final DoctorsService doctorsService = new DoctorsService();

    public static void getDoctorsById(Context ctx){
        int id;
        try{
            id = Integer.parseInt(ctx.pathParam("id"));
        }catch (NumberFormatException e){
            ctx.status(400);
            return;
        }

        Doctor doc = DoctorsService.getDoctorById(id);
        if (doc != null){
            ctx.status(200);
            ctx.json(doc);
        } else{
            ctx.status(404);
        }
    }

    public static void getAllDoctors(Context ctx){
        ArrayList<Doctor> doctors = doctorsService.getAllDoctors();
        ctx.json(doctors);

    }

    public static void insertDoctors(Context ctx){
        Doctor doctor  = ctx.bodyAsClass(Doctor.class);

        Doctor returnedDoctors = DoctorsService.createNewDoctor(doctor);

        if (returnedDoctors != null){
            ctx.status(200);
            ctx.json(returnedDoctors);
        } else{
            ctx.status(400);
        }
    }

    public static void updateDoctorsSalary(Context ctx){

        Doctor submittedDoctor  = ctx.bodyAsClass(Doctor.class);
        Doctor updateSuccessful = DoctorsService.updateDoctorsSalary(submittedDoctor);
        if (updateSuccessful != null){
            ctx.status(200);
            ctx.json(updateSuccessful);
        } else{
            ctx.status(400);
        }
    }

    public static void deleteDoctors(Context ctx){
        int id;
        try{
            id = Integer.parseInt(ctx.pathParam("id"));
        } catch (NumberFormatException e) {
            ctx.status(400).result("Invalid doctor ID.");
            return ;
        }
         if (id > 0) {
             doctorsService.deleteDoctor(id);
             ctx.status(204);
         } else {
             ctx.status(400);
         }
    }

}
