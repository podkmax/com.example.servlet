package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("")
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Doctor> doctors = MainModel.getAllDoctors();

        req.setAttribute("doctors", doctors);
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Doctor doctor = new Doctor();
        doctor.setName(req.getParameter("name"));
        doctor.setPosition(req.getParameter("position"));

        MainModel.addDoctor(doctor);

        ArrayList<Doctor> doctors = MainModel.getAllDoctors();
        req.setAttribute("doctors", doctors);
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }
}