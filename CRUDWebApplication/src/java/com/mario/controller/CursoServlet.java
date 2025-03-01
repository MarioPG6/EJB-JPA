package com.mario.controller;

import com.mario.dao.CursoDaoLocal;
import com.mario.model.Curso;
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
@WebServlet(name = "CursoServlet", urlPatterns = {"/CursoServlet"})
public class CursoServlet extends HttpServlet {

    @EJB
    private CursoDaoLocal cursoDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String cursoIdStr = request.getParameter("cursoId");
        int cursoId = 0;
        if (cursoIdStr != null && !cursoIdStr.isEmpty()) {
            cursoId = Integer.parseInt(cursoIdStr);
        }

        String nombreCurso = request.getParameter("nombreCurso");

        String numCreditosStr = request.getParameter("numCreditos");
        int numCreditos = 0;
        if (numCreditosStr != null && !numCreditosStr.isEmpty()) {
            numCreditos = Integer.parseInt(numCreditosStr);
        }

        String semestreStr = request.getParameter("semestre");
        int semestre = 0;
        if (semestreStr != null && !semestreStr.isEmpty()) {
            semestre = Integer.parseInt(semestreStr);
        }

        String numEstudiantesStr = request.getParameter("numEstudiantesAdmitidos");
        int numEstudiantesAdmitidos = 0;
        if (numEstudiantesStr != null && !numEstudiantesStr.isEmpty()) {
            numEstudiantesAdmitidos = Integer.parseInt(numEstudiantesStr);
        }

        Curso curso = new Curso(nombreCurso, numCreditos, semestre, numEstudiantesAdmitidos);

        if ("Add".equalsIgnoreCase(action)) {
            cursoDao.addCurso(curso);
        } else if ("Edit".equalsIgnoreCase(action)) {
            cursoDao.editCurso(curso);
        } else if ("Delete".equalsIgnoreCase(action)) {
            cursoDao.deleteCurso(cursoId);
        } else if ("Search".equalsIgnoreCase(action)) {
            curso = cursoDao.getCurso(cursoId);
        }

        request.setAttribute("curso", curso);
        request.setAttribute("allCursos", cursoDao.getAllCursos());
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

