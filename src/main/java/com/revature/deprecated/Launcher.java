package com.revature.deprecated;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.daos.PatientsDAO;
import com.revature.daos.DoctorsDAO;
import com.revature.models.Patient;
import com.revature.utils.ConnectionUtil;

public class Launcher {

    public static void main(String[] args) {

        try (Connection ignored = ConnectionUtil.getConnection()){
            System.out.println("CONNECTION SUCCESSFUL :)");
        }
        catch(SQLException e){
            System.out.println("Connection Failed :(" );
        }

        DoctorsDAO dDAO = new DoctorsDAO();

        System.out.println(dDAO.updateDoctorSpecialty());
        System.out.println(dDAO.getDoctorsById());

        PatientsDAO pDAO = new PatientsDAO();

        Patient John = new Patient();

        System.out.println(pDAO.insertPatient(John));

        ArrayList<Patient> patientList = pDAO.getAllPatient();

        for(Patient p : patientList){
            System.out.println(p);
        }


    }


}