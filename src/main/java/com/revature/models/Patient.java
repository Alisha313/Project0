package com.revature.models;

import java.util.Date;

public class Patient {

    private int patient_id;
    private String first_name;
    private String last_name;
    private Date date_of_birth;
    private String reason_of_visit;
    private String patient_gender;
    private int doctor_id_fk;


    public Patient(int patient_id, String first_name, String last_name, Date date_of_birth, String reason_of_visit, String patient_gender, int doctor_id_fk) {
        this.patient_id = patient_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.reason_of_visit = reason_of_visit;
        this.patient_gender = patient_gender;
        this.doctor_id_fk = doctor_id_fk;
    }

    public Patient() {
        
    }

    public Patient(int patientId, String firstName, String lastName, java.sql.Date dateOfBirth, String reason_of_visit, String patient_gender, Doctor doctorIdFk) {
    }

    public String getFirst_name() {

        return first_name;
    }

    public void setFirst_name(String first_name) {

        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {

        this.last_name = last_name;
    }

    public Date getDate_of_birth() {

        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {

        this.date_of_birth = date_of_birth;
    }

    public String getReason_of_visit() {

        return reason_of_visit;
    }

    public void setReason_of_visit(String reason_of_visit) {

        this.reason_of_visit = reason_of_visit;
    }

    public String getPatient_gender() {

        return patient_gender;
    }

    public void setPatient_gender(String patient_gender) {

        this.patient_gender = patient_gender;
    }

    public int getDoctor_id_fk() {

        return doctor_id_fk;
    }

    public void setDoctor_id_fk(int doctor_id_fk) {

        this.doctor_id_fk = doctor_id_fk;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id=" + patient_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", reason_of_visit='" + reason_of_visit + '\'' +
                ", patient_gender='" + patient_gender + '\'' +
                ", doctor_id_fk=" + doctor_id_fk +
                '}';
    }
}

