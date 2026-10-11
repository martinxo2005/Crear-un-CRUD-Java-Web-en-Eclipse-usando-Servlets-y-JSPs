<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Crear Persona</title>
</head>
<body>
    <h2>Añadir Nueva Persona</h2>
    <form action="${pageContext.request.contextPath}/persona" method="POST">
        <input type="hidden" name="opcion" value="guardar">
        
        <label>Nombre:</label><br>
        <input type="text" name="nombre" required><br><br>

        <label>Apellidos:</label><br>
        <input type="text" name="apellidos" required><br><br>

        <label>Email:</label><br>
        <input type="email" name="email" required><br><br>

        <label>Edad:</label><br>
        <input type="number" name="edad" required><br><br>

        <button type="submit">Guardar</button>
        <a href="${pageContext.request.contextPath}/persona?opcion=listar">Cancelar</a>
    </form>
</body>
</html>