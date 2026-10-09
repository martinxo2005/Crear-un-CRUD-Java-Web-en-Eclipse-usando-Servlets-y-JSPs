<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.miempresa.model.Persona"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalles de Persona</title>
</head>
<body>
    <%
        // Obtener la instancia enviada por el Servlet
        Persona p = (Persona) request.getAttribute("personaGuardada");
    %>

    <h2>¡Persona registrada con éxito!</h2>

    <% if (p != null) { %>
        <ul>
            <li><strong>Nombre:</strong> <%= p.getNombre() %></li>
            <li><strong>Apellidos:</strong> <%= p.getApellidos() %></li>
            <li><strong>Email:</strong> <%= p.getEmail() %></li>
            <li><strong>Edad:</strong> <%= p.getEdad() %> años</li>
        </ul>
    <% } else { %>
        <p>No se encontraron datos de la persona.</p>
    <% } %>

    <a href="index.html">Volver al formulario</a>
</body>
</html>