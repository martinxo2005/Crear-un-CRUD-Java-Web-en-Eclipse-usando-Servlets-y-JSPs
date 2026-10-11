<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.miempresa.model.Persona"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Persona</title>
</head>
<body>
    <%
        Persona p = (Persona) request.getAttribute("persona");
    %>
    <h2>Editar Persona #<%= p != null ? p.getId() : "" %></h2>
    <form action="${pageContext.request.contextPath}/persona" method="POST">
        <input type="hidden" name="opcion" value="actualizar">
        <input type="hidden" name="id" value="<%= p != null ? p.getId() : "" %>">

        <label>Nombre:</label><br>
        <input type="text" name="nombre" value="<%= p != null ? p.getNombre() : "" %>" required><br><br>

        <label>Apellidos:</label><br>
        <input type="text" name="apellidos" value="<%= p != null ? p.getApellidos() : "" %>" required><br><br>

        <label>Email:</label><br>
        <input type="email" name="email" value="<%= p != null ? p.getEmail() : "" %>" required><br><br>

        <label>Edad:</label><br>
        <input type="number" name="edad" value="<%= p != null ? p.getEdad() : "" %>" required><br><br>

        <button type="submit">Actualizar</button>
        <a href="${pageContext.request.contextPath}/persona?opcion=listar">Cancelar</a>
    </form>
</body>
</html>