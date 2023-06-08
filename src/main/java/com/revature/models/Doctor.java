package com.revature.models;

public class Doctor {

    private int doctor_id;
    private String doctor_title;
    private String doctor_specialty;
    private int doctor_salary;

    public Doctor(int doctor_id, String doctor_title, String doctor_specialty, int doctor_salary) {
        this.doctor_id = doctor_id;
        this.doctor_title = doctor_title;
        this.doctor_specialty = doctor_specialty;
        this.doctor_salary = doctor_salary;
    }

    public Doctor() {

    }


    public Doctor(int doctorId, String doctorTitle, int doctorSalary, String doctorSpecialty) {
    }


    public int getDoctor_id() {

        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {

        this.doctor_id = doctor_id;
    }

    public String getDoctor_title() {

        return doctor_title;
    }

    public void setDoctor_title(String doctor_title) {

        this.doctor_title = doctor_title;
    }

    public String getDoctor_specialty() {

        return doctor_specialty;
    }

    public void setDoctor_specialty(String doctor_specialty) {

        this.doctor_specialty = doctor_specialty;
    }

    public int getDoctor_salary() {

        return doctor_salary;
    }

    public void setDoctor_salary(int doctor_salary) {

        this.doctor_salary = doctor_salary;
    }

    //toString() lets us print out our objects in String form (instead of memory address)
    @Override
    public String toString() {
        return "Doctor{" +
                "doctor_id=" + doctor_id +
                ", doctor_title='" + doctor_title + '\'' +
                ", doctor_specialty='" + doctor_specialty + '\'' +
                ", doctor_salary=" + doctor_salary +
                '}';
    }
}
