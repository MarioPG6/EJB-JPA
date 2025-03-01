/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.mario.dao;

import com.mario.model.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mario
 */
@Stateless
public class StudentDao implements StudentDaoLocal {
    @PersistenceContext
    private EntityManager em;
           
    @Override
    public void addStudent(Student student) {
        em.persist(student);
    }

    @Override
    public void editStudent(Student student) {
        em.merge(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        em.remove(getStudent(studentId));
    }

    @Override
    public Student getStudent(int studentId) {
        return em.find(Student.class, studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return em.createNamedQuery("Student.getAll").getResultList(); 
    }
    
}
