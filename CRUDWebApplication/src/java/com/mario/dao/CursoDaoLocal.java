/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.mario.dao;

import com.mario.model.Curso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mario
 */
@Local
public interface CursoDaoLocal {

    void addCurso(Curso curso);

    void editCurso(Curso curso);

    void deleteCurso(int cursoId);

    Curso getCurso(int cursoId);

    List<Curso> getAllCursos();
}
