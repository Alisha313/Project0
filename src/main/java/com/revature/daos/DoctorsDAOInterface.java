package com.revature.daos;

import com.revature.models.Doctor;

public interface DoctorsDAOInterface {

    Doctor getDoctorById(int id);

    boolean updateDoctorSalary(int salary, String title);

    boolean updateDoctorSpecialty(String specialty);
}
