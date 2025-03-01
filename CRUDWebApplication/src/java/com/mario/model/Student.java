/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mario.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author mario
 */
@Entity
@Table
@NamedQueries(@NamedQuery(name = "Student.getAll", query = "SELECT e FROM Student e"))
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int studentId;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private int yearLevel;

    @ManyToMany
    @JoinTable(
        name = "STUDENT_CURSOS",
        joinColumns = @JoinColumn(name = "studentId"),
        inverseJoinColumns = @JoinColumn(name = "cursoId")
    )
    private Set<Curso> cursos;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public Student(int studentId, String firstname, String lastname, int yearLevel) {
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearLevel = yearLevel;
    }

    public Student() {
    }
}
