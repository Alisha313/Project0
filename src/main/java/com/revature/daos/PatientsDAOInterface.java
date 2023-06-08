package com.revature.daos;

import com.revature.models.Patient;

import java.util.ArrayList;

public interface PatientsDAOInterface {
    ArrayList<Patient> getAllPatient();

    Patient insertPatient(Patient p);
}
