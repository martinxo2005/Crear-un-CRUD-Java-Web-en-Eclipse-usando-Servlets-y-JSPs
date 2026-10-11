<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.miempresa.model.Persona"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Personas</title>
</head>
<body>
    <h2>Listado de Personas Registradas</h2>
    <a href="${pageContext.request.contextPath}/persona?opcion=crear">Crear Nueva Persona</a>
    <br><br>
    <table border="1" cellpadding="8">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Email</th>
                <th>Edad</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Persona> lista = (List<Persona>) request.getAttribute("listaPersonas");
                if (lista != null && !lista.isEmpty()) {
                    for (Persona p : lista) {
            %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getNombre() %></td>
                <td><%= p.getApellidos() %></td>
                <td><%= p.getEmail() %></td>
                <td><%= p.getEdad() %></td>
                <td>
                    <a href="${pageContext.request.contextPath}/persona?opcion=editar&id=<%= p.getId() %>">Editar</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="6">No hay personas registradas.</td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>