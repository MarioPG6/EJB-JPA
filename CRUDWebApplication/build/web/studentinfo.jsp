<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student & Course Management</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./StudentServlet" method="POST">
            <table>
                <tr>
                    <td>Student ID</td>
                    <td><input type="text" name="studentId" value="${student.studentId}"/></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstname" value="${student.firstname}"/></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastname" value="${student.lastname}"/></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="yearLevel" value="${student.yearLevel}"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table> 
        </form>
        
        <h2>Student List</h2>
        <table border="1">
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
            <c:forEach items="${allStudent}" var="stud">
                <tr>
                    <td>${stud.studentId}</td>
                    <td>${stud.firstname}</td>
                    <td>${stud.lastname}</td>
                    <td>${stud.yearLevel}</td>
                </tr>
            </c:forEach>
        </table>
        
        <h1>Course Management</h1>
        <form action="./CursoServlet" method="POST">
            <table>
                <tr>
                    <td>Course ID</td>
                    <td><input type="text" name="cursoId" value="${curso.cursoId}"/></td>
                </tr>
                <tr>
                    <td>Course Name</td>
                    <td><input type="text" name="nombreCurso" value="${curso.nombreCurso}"/></td>
                </tr>
                <tr>
                    <td>Credits</td>
                    <td><input type="text" name="numCreditos" value="${curso.numCreditos}"/></td>
                </tr>
                <tr>
                    <td>Semester</td>
                    <td><input type="text" name="semestre" value="${curso.semestre}"/></td>
                </tr>
                <tr>
                    <td>Admitted Students</td>
                    <td><input type="text" name="numEstudiantesAdmitidos" value="${curso.numEstudiantesAdmitidos}"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        
        <h2>Course List</h2>
        <table border="1">
            <th>ID</th>
            <th>Name</th>
            <th>Credits</th>
            <th>Semester</th>
            <th>Admitted Students</th>
            <c:forEach items="${allCursos}" var="curso">
                <tr>
                    <td>${curso.cursoId}</td>
                    <td>${curso.nombreCurso}</td>
                    <td>${curso.numCreditos}</td>
                    <td>${curso.semestre}</td>
                    <td>${curso.numEstudiantesAdmitidos}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
