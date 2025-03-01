package com.mario.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author mario
 */
@Entity
@Table(name = "CURSOS")  // Especifica el nombre correcto de la tabla en la BD
@NamedQueries(
        @NamedQuery(name = "Curso.getAll", query = "SELECT c FROM Curso c"))
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Usa IDENTITY en lugar de AUTO
    @Column(name = "CURSOID")
    private int cursoId;

    @Column(name = "NOMBRECURSO", nullable = false)
    private String nombreCurso;

    @Column(name = "NUMCREDITOS", nullable = false)
    private int numCreditos;

    @Column(name = "SEMESTRE", nullable = false)
    private int semestre;

    @Column(name = "NUMESTUDIANTESADMITIDOS", nullable = false)
    private int numEstudiantesAdmitidos;

    @ManyToMany(mappedBy = "cursos")
    private Set<Student> estudiantes;

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getNumCreditos() {
        return numCreditos;
    }

    public void setNumeroCreditos(int numeroCreditos) {
        this.numCreditos = numeroCreditos;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getNumEstudiantesAdmitidos() {
        return numEstudiantesAdmitidos;
    }

    public void setNumEstudiantesAdmitidos(int numEstudiantesAdmitidos) {
        this.numEstudiantesAdmitidos = numEstudiantesAdmitidos;
    }

    public Set<Student> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Set<Student> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Curso(String nombreCurso, int numeroCreditos, int semestre, int numEstudiantesAdmitidos) {
        this.nombreCurso = nombreCurso;
        this.numCreditos = numeroCreditos;
        this.semestre = semestre;
        this.numEstudiantesAdmitidos = numEstudiantesAdmitidos;
    }

    public Curso() {
    }
}
