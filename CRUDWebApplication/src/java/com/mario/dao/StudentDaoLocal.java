/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.mario.dao;

import com.mario.model.Student;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mario
 */
@Local
public interface StudentDaoLocal {

    void addStudent(Student student);

    void editStudent(Student student);

    void deleteStudent(int student);

    Student getStudent(int studentId);

    List<Student> getAllStudents();
    
}
