package com.revature.daos;

import com.revature.models.Patient;
import io.javalin.http.Context;

import java.util.ArrayList;

public interface PatientsDAOInterface {
    ArrayList<Patient> getAllPatient();
    Patient insertPatient(Patient p);

    Patient updatePatientReasonOfVisit(int patient_id, String reason_of_visit);

    void deletePatient(int patient_id);
    Patient updatePatientReasonOfVisit(Patient patient);

}
