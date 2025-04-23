package com.mycompany.odontologia;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/libros")
public class LibroServlet extends HttpServlet {

    private final LibroDAO libroDAO = new LibroDAO();
    private final CategoriaDAO categoriaDAO = new CategoriaDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Libro> libros = libroDAO.listarTodos();
        List<Categoria> categorias = categoriaDAO.listarTodas();

        req.setAttribute("libros", libros);
        req.setAttribute("categorias", categorias);

        req.getRequestDispatcher("pages/blibros.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titulo = req.getParameter("titulo");
        String autor = req.getParameter("autor");
        int cantidad = Integer.parseInt(req.getParameter("cantidad"));
        int categoriaId = Integer.parseInt(req.getParameter("categoria"));

        Categoria categoria = categoriaDAO.buscarPorId(categoriaId);

        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setCantidad(cantidad);
        libro.setCategoria(categoria);

        libroDAO.guardar(libro);
        resp.sendRedirect("libros");
    }
}
