package com.revature.daos;

import com.revature.models.Patient;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class PatientsDAO implements PatientsDAOInterface {


    @Override
    public ArrayList<Patient> getAllPatient() {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM patients";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            ArrayList<Patient> patientList = new ArrayList<>();
            DoctorsDAO dDAO = new DoctorsDAO();
            while (rs.next()) {
                Patient patient = new Patient(
                        rs.getInt("patient_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("date_of_birth"),
                        rs.getString("reason_of_visit"),
                        rs.getString("patient_gender"),
                        dDAO.getDoctorById(rs.getInt("doctor_id_fk"))
                );
                System.out.println(patient);
                patientList.add(patient);
            }
            return patientList;

        } catch (SQLException p) {
            System.out.println("Failed to get all patients");
            p.printStackTrace();
        }

        return null;
    }

    @Override
    public Patient insertPatient(Patient p) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO patients (first_name, last_name, date_of_birth, reason_of_visit, patient_gender, doctor_id_fk) VALUES (?, ?, ?, ?, ?, ?) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getFirst_name());
            ps.setString(2, p.getLast_name());
            ps.setString(3, p.getDate_of_birth());
            ps.setString(4, p.getReason_of_visit());
            ps.setString(5, p.getPatient_gender());
            ps.setInt(6, p.getDoctor_id_fk());
            ps.executeUpdate();
            return p;
        } catch (SQLException ps) {
            System.out.println("Insert patients failed!");
            ps.printStackTrace();
        }

        return null;
    }

    @Override
    public Patient updatePatientReasonOfVisit(int patient_id, String reason_of_visit) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE patients SET patient_id WHERE reason_of_visit = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, patient_id);
            ps.setString(2, reason_of_visit);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to update patient id and reason of visit");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deletePatient(int patient_id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "DELETE FROM patients WHERE patient_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, patient_id);
            ps.executeUpdate();
            System.out.println("delete doctor id: " + patient_id);
        } catch (SQLException e) {
            System.out.println("Failed to delete doctor id: " + patient_id);
            e.printStackTrace();
        }

    }

    @Override
    public Patient updatePatientReasonOfVisit(Patient patient) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE patients SET first_name = ?, last_name = ?, date_of_birth = ?, patient_gender = ?, reason_of_visit = ?, doctor_id_fk = ? WHERE patient_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, patient.getFirst_name());
            ps.setString(2, patient.getLast_name());
            ps.setString(3, patient.getDate_of_birth());
            ps.setString(4, patient.getPatient_gender());
            ps.setString(5, patient.getReason_of_visit());
            ps.setInt(6, patient.getDoctor_id_fk());
            ps.setInt(7, patient.getPatient_id());
            ps.executeUpdate();
            return patient;
        } catch (SQLException e) {
            System.out.println("Failed to update patient id and reason of visit");
            e.printStackTrace();
        }
        return null;

    }
}


