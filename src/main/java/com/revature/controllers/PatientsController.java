package com.revature.controllers;


import com.revature.models.Patient;
import com.revature.service.PatientsService;
import io.javalin.http.Context;
import java.util.ArrayList;

public class PatientsController {

    private static final  PatientsService patientsService = new PatientsService();

    public static void getAllPatients(Context ctx){
        ArrayList<Patient> patients = PatientsService.getAllPatient();
        ctx.json(patients);
    }

    public static void insertPatients(Context ctx){

        Patient p  = ctx.bodyAsClass(Patient.class);

        Patient returnedPatients = PatientsService.createNewPatient(p);

        if (returnedPatients != null){
            ctx.status(200);
            ctx.json(returnedPatients);
        } else{
            ctx.status(400);
        }
    }

    public static void getPatientsById(Context ctx){
        int id;
        try{
            id = Integer.parseInt(ctx.pathParam("id"));
        }catch (NumberFormatException e){
            ctx.status(400);
            return;
        }


        Patient patient = PatientsService.getPatientById();
        if (patient != null){
            ctx.status(200);
            ctx.json(patient);
        } else{
            ctx.status(404);
        }
    }

    public static void updatePatients(Context ctx){

        boolean updateSuccessful = patientsService.updatePatientId();

        if (updateSuccessful){
            ctx.status(200);
        } else{
            ctx.status(400);
        }
    }

    public static void deletePatients(Context ctx){
        try {
            patientsService.deletePatient();
            ctx.status(204);
        } catch (NumberFormatException e) {
            ctx.status(400).result("Invalid patient ID.");
        }
    }

}




