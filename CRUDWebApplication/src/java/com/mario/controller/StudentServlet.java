/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mario.controller;

import com.mario.dao.StudentDaoLocal;
import com.mario.model.Student;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mario
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    @EJB
    private StudentDaoLocal studentDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String studentIdStr = request.getParameter("studentId");
        int studentId = 0;
        if (studentIdStr != null && !studentIdStr.equals("")) {
            studentId = Integer.parseInt(studentIdStr);
        }
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String yearLevelStr = request.getParameter("yearLevel");
        int yearLevel = 0;
        if (yearLevelStr != null && !yearLevelStr.equals("")) {
            yearLevel = Integer.parseInt(yearLevelStr);
        }
        Student student = new Student(studentId, firstname, lastname, yearLevel);

        if ("Add".equalsIgnoreCase(action)) {
            studentDao.addStudent(student);
        } else if ("Edit".equalsIgnoreCase(action)) {
            studentDao.editStudent(student);
        } else if ("Delete".equalsIgnoreCase(action)) {
            studentDao.deleteStudent(studentId);
        } else if ("Search".equalsIgnoreCase(action)) {
            student = studentDao.getStudent(studentId);
        }
        request.setAttribute("student", student);
        request.setAttribute("allStudent", studentDao.getAllStudents());
        request.getRequestDispatcher("studentinfo.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
