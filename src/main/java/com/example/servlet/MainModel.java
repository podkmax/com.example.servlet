package com.example.servlet;

import java.sql.*;
import java.util.ArrayList;

public class MainModel {

    static private String username = "postgres";
    static private String password = "mebxbylx1";
    static private String connectionURL = "jdbc:postgresql://localhost:5432/mydb";

    private static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionURL, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static ArrayList<Doctor> getAllDoctors() {
        ArrayList<Doctor> listDoc = new ArrayList<>();
        Connection connection = connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM doctors");
            while (resultSet.next()) {
                Doctor doctor = new Doctor();
                doctor.setName(resultSet.getString(2));
                doctor.setPosition(resultSet.getString(3));
                listDoc.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return listDoc;
    }

    public static void addDoctor(Doctor doctor) {
        Connection connection = connect();
        String sql = "INSERT INTO doctors(name,position) VALUES (?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getPosition());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
