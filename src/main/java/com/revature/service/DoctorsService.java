package com.revature.service;

import com.revature.daos.DoctorsDAO;
import com.revature.daos.DoctorsDAOInterface;
import com.revature.models.Doctor;

import java.util.ArrayList;

public class DoctorsService {

    private static final DoctorsDAOInterface DoctorsDAO =  new DoctorsDAO();

    public static Doctor getDoctorById(int id){

        if (id > 0){
            return DoctorsDAO.getDoctorById(id);
        } else{
            return null;
        }
    }

    public static Doctor createNewDoctor(Doctor doctor) {
        return doctor;
    }


    public boolean updateSalary(int salary, String title) {

        if (title == null || title.trim().equals("")) {
            return false;
        }
        char[] titleArray = title.toLowerCase().toCharArray();
        String formattedTitle = "";
        formattedTitle += Character.toUpperCase(titleArray[0]);
        for (int i = 1; i < titleArray.length; i++) {
            if (titleArray[i - 1] == ' ') {
                formattedTitle += Character.toUpperCase(titleArray[i]);
            } else {
                formattedTitle += titleArray[i];
            }
        }
        if (salary > 0) {
            return DoctorsDAO.updateDoctorSalary(salary, formattedTitle);
        }


        return false;

    }

    public ArrayList<Doctor> getAllDoctors() {

        return null;
    }

    public void deleteDoctor() {
    }

    public boolean updateSalary(int doctorSalary, int doctorId, String doctorSpecialty, String doctorTitle) {
        return false;
    }
}




