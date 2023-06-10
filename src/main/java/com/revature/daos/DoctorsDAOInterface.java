package com.revature.daos;

import com.revature.models.Doctor;

import java.util.ArrayList;

public interface DoctorsDAOInterface {

    Doctor getDoctorById(int id);
    Doctor insertDoctor(Doctor d);
    ArrayList<Doctor> getAllDoctors();
    void deleteDoctor(int doctor_id);
    boolean getDoctorsById();
    Doctor updateDoctorsSalary(Doctor doctor);
}
