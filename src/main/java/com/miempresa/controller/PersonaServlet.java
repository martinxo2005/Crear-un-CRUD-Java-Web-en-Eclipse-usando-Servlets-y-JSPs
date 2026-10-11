package com.miempresa.controller;

import java.io.IOException;
import java.util.List;

import com.miempresa.dao.PersonaDAO;
import com.miempresa.model.Persona;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "PersonaServlet", urlPatterns = {"/persona"})
public class PersonaServlet extends HttpServlet {

    private final PersonaDAO personaDAO = new PersonaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String opcion = request.getParameter("opcion");
        if (opcion == null) {
            opcion = "listar";
        }

        switch (opcion) {
            case "crear":
                request.getRequestDispatcher("/views/crear.jsp").forward(request, response);
                break;

            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                // Buscar la persona seleccionada de la lista
                List<Persona> lista = personaDAO.obtenerTodas();
                Persona personaEncontrada = null;
                for (Persona p : lista) {
                    if (p.getId() == idEditar) {
                        personaEncontrada = p;
                        break;
                    }
                }
                request.setAttribute("persona", personaEncontrada);
                request.getRequestDispatcher("/views/editar.jsp").forward(request, response);
                break;

            case "listar":
            default:
                List<Persona> personas = personaDAO.obtenerTodas();
                request.setAttribute("listaPersonas", personas);
                request.getRequestDispatcher("/views/listar.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcion = request.getParameter("opcion");

        if ("guardar".equals(opcion)) {
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String email = request.getParameter("email");
            int edad = Integer.parseInt(request.getParameter("edad"));

            Persona persona = new Persona(nombre, apellidos, email, edad);
            personaDAO.guardar(persona);

            // Redirigir al listado para refrescar los datos
            response.sendRedirect(request.getContextPath() + "/persona?opcion=listar");

        } else if ("actualizar".equals(opcion)) {
            // Nota: Aquí se implementaría el método actualizar en el DAO si se desea
            response.sendRedirect(request.getContextPath() + "/persona?opcion=listar");
        } else {
            response.sendRedirect(request.getContextPath() + "/persona?opcion=listar");
        }
    }
}