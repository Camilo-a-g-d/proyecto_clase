package com.mycompany.odontologia;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/editarLibro")
public class EditarLibroServlet extends HttpServlet {
    private final LibroDAO libroDAO = new LibroDAO();
    private final CategoriaDAO categoriaDAO = new CategoriaDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Libro libro = libroDAO.buscarPorId(id);
        req.setAttribute("libro", libro);
        req.setAttribute("categorias", categoriaDAO.listarTodas());
        req.getRequestDispatcher("pages/elibro.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String titulo = req.getParameter("titulo");
        String autor = req.getParameter("autor");
        int cantidad = Integer.parseInt(req.getParameter("cantidad"));
        int categoriaId = Integer.parseInt(req.getParameter("categoria"));

        Categoria categoria = categoriaDAO.buscarPorId(categoriaId);
        Libro libro = libroDAO.buscarPorId(id);

        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setCantidad(cantidad);
        libro.setCategoria(categoria);

        libroDAO.actualizar(libro);
        resp.sendRedirect("inventario");
    }
}
