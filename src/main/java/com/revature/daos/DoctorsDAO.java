package com.revature.daos;

import com.revature.models.Doctor;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DoctorsDAO implements DoctorsDAOInterface{

    @Override
    public Doctor getDoctorById(int id) {


        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM doctors WHERE doctor_id = ?";


            PreparedStatement ps = conn.prepareStatement(sql);


            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();


            if(rs.next()) {


                Doctor doc = new Doctor(
                        rs.getInt("doctor_id"),
                        rs.getString("doctor_title"),
                        rs.getString("doctor_specialty"),
                        rs.getInt("doctor_salary")
                );

                return doc;

            }

        } catch(SQLException e){
            System.out.println("error getting Role");
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public boolean updateDoctorSalary(int salary, String title) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "UPDATE doctors SET doctor_salary = ? where doctor_title = ?";


            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, title);
            ps.setInt(2, salary);

            ps.executeUpdate();

            return true;

        } catch(SQLException e){
            System.out.println("Update failed!!");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateDoctorSpecialty(String specialty) {
        return false;
    }

    public boolean getDoctorsById() {

        return false;
    }

    public boolean updateDoctorSpecialty() {

        return false;
    }
}

