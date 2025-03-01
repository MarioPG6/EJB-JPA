/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mario.dao;

import com.mario.model.Curso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author mario
 */
@Stateless
public class CursoDao implements CursoDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addCurso(Curso curso) {
        em.persist(curso);
    }

    @Override
    public void editCurso(Curso curso) {
        em.merge(curso);
    }

    @Override
    public void deleteCurso(int cursoId) {
        Curso curso = em.find(Curso.class, cursoId);
        if (curso != null) {
            em.remove(curso);
        }
    }

    @Override
    public Curso getCurso(int cursoId) {
        return em.find(Curso.class, cursoId);
    }

    @Override
    public List<Curso> getAllCursos() {
        TypedQuery<Curso> query = em.createNamedQuery("Curso.getAll", Curso.class);
        return query.getResultList();
    }
}
