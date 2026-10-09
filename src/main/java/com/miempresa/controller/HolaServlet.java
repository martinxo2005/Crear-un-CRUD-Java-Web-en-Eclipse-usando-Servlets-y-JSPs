package com.miempresa.controller;

import com.miempresa.model.Persona;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HolaServlet", urlPatterns = {"/hola"})
public class HolaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Obtener parámetros del formulario
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        int edad = Integer.parseInt(request.getParameter("edad"));

        // 2. Instanciar el POJO con los datos recibidos
        Persona persona = new Persona(nombre, apellidos, email, edad);

        // 3. Pasar el objeto Persona a la solicitud (request)
        request.setAttribute("personaGuardada", persona);

        // 4. Redirigir la petición a la vista JSP resultado.jsp
        request.getRequestDispatcher("/resultado.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirigir las peticiones GET al formulario principal
        response.sendRedirect("index.html");
    }
}