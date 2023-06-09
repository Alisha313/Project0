package com.revature.service;

import com.revature.daos.PatientsDAO;
import com.revature.daos.PatientsDAOInterface;
import com.revature.models.Patient;

import java.util.ArrayList;

public class PatientsService {


    private static final PatientsDAOInterface PatientsDao = new PatientsDAO();

    public static ArrayList<Patient> getAllPatient() {

        return PatientsDao.getAllPatient();
    }

    public static Patient createNewPatient(Patient p) {
        return PatientsDao.insertPatient(p);

    }

    public static Patient getPatientById() {
        return null;
    }

    public boolean deletePatient(int id) {
        if ((id > 0)) {
            PatientsDao.deletePatient(id);
            return true;
        }
        System.out.println("Failed to delete patient id " + id);
        return false;
    }

    public static Patient updatePatientReasonOfVisit(Patient submittedPatient) {

        if (submittedPatient != null) {
            return PatientsDao.updatePatientReasonOfVisit(submittedPatient);
        }
        return null;
    }

}

