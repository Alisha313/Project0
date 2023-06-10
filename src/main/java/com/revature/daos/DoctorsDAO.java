package com.revature.daos;

import com.revature.models.Doctor;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;


public class DoctorsDAO implements DoctorsDAOInterface{

    @Override
    public Doctor getDoctorById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM doctors WHERE doctor_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new Doctor(
                        rs.getInt("doctor_id"),
                        rs.getString("doctor_title"),
                        rs.getString("doctor_specialty"),
                        rs.getInt("doctor_salary")
                );
            }
        } catch(SQLException e){
            System.out.println("error getting doctor");
            e.printStackTrace();
        }
        return null;
    }

    //Insert doctor
    public Doctor insertDoctor(Doctor d) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO doctors (doctor_id, doctor_title, doctor_specialty, doctor_salary) VALUES (?, ?, ?) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, d.getDoctor_id());
            ps.setString(2, d.getDoctor_title());
            ps.setString(3, d.getDoctor_specialty());
            ps.setInt(4, d.getDoctor_salary());
            ps.executeUpdate();
            return d;
        } catch(SQLException ps){
            System.out.println("Insert doctors failed!");
            ps.printStackTrace();
        }
        return null;
    }

// Get all doctors
    @Override
    public ArrayList<Doctor> getAllDoctors() {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM doctors";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            ArrayList<Doctor> doctorList = new ArrayList<>();
            while(rs.next()){
                Doctor doctor = new Doctor(
                        rs.getInt("doctor_id"),
                        rs.getString("doctor_title"),
                        rs.getString("doctor_specialty"),
                        rs.getInt("doctor_salary")
                );
                System.out.println(doctor);
                doctorList.add(doctor);
            }
            return doctorList;
        } catch (SQLException doctor) {
            System.out.println("Failed to get all doctors");
            doctor.printStackTrace();
        }
        return null;
    }

//Delete Doctor
    @Override
    public void deleteDoctor(int doctor_id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "DELETE FROM doctors WHERE doctor_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, doctor_id);
            ps.executeUpdate();
            System.out.println("delete doctor id: " + doctor_id);
        } catch (SQLException ps) {
            System.out.println("Failed to delete doctor id: " + doctor_id);
            ps.printStackTrace();
        }

    }

    @Override
    public boolean getDoctorsById() {

        return false;
    }

    @Override
    public Doctor updateDoctorsSalary(Doctor doctor) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE doctors SET doctor_salary = ? , doctor_title = ?, doctor_specialty =? WHERE doctor_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(4, (doctor.getDoctor_id()));
            ps.setInt(1,(doctor.getDoctor_salary()));
            ps.setString(2, doctor.getDoctor_title());
            ps.setString(3, doctor.getDoctor_specialty());
            ps.executeUpdate();
            return doctor;

        } catch (SQLException ps) {
            System.out.println("Update failed!!");
            ps.printStackTrace();
        }

        return null;
    }


}

