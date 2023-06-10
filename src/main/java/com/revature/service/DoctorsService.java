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

    public static Doctor createNewDoctor(Doctor d) {

        return DoctorsDAO.insertDoctor(d);
    }

    public static Doctor updateDoctorsSalary(Doctor submittedDoctor) {

        if (submittedDoctor != null) {
            return DoctorsDAO.updateDoctorsSalary(submittedDoctor);
        }
        return null;
    }

    public ArrayList<Doctor> getAllDoctors() {

        return DoctorsDAO.getAllDoctors();
    }

    public void deleteDoctor(int doctor_id) {

        DoctorsDAO.deleteDoctor(doctor_id);
    }


}





