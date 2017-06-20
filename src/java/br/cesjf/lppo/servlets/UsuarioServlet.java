package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Usuario;
import br.cesjf.lppo.dao.UsuarioJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/criar-usuario.html","/listar-usuario.html","/editar-usuario.html","/excluir-usuario.html"})
public class UsuarioServlet extends HttpServlet {
    
    @PersistenceUnit(unitName = "trbflppo-2017-1PU")
    EntityManagerFactory emf;
    
    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getServletPath().contains("/criar-usuario.html")) {
            doCriarGet(request,response);
        } else if (request.getServletPath().contains("/listar-usuario.html")) {
            doListarrGet(request,response);
        } else if (request.getServletPath().contains("/editar-usuario.html")) {
            doEditarGet(request,response);
        } else if (request.getServletPath().contains("/excluir-usuario.html")) {
            doExcluirGet(request,response);
        } 
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().contains("/criar-usuario.html")) {
            doCriarPost(request,response);
        } else if (request.getServletPath().contains("/editar-usuario.html")) {
            doEditarPost(request,response);
        } 
    }

    private void doCriarGet(HttpServletRequest request, HttpServletResponse response)            
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/novo-usuario.jsp").forward(request, response);
    }
    
     private void doCriarPost(HttpServletRequest request, HttpServletResponse response)           
             throws ServletException, IOException {
        Usuario usuario1 = new Usuario();
        usuario1.setNome(request.getParameter("nome"));
        usuario1.setEmail(request.getParameter("email"));
        usuario1.setSenha(request.getParameter("senha"));

        UsuarioJpaController dao = new UsuarioJpaController(ut, emf);
        try {
            dao.create(usuario1);
            response.sendRedirect("listar-usuario.html");
        } catch (Exception ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       
    
        private void doListarrGet(HttpServletRequest request, HttpServletResponse response)            
            throws ServletException, IOException {
         List<Usuario> usuarios;
        
        UsuarioJpaController dao = new UsuarioJpaController(ut, emf);
        usuarios = dao.findUsuarioEntities();
        
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("WEB-INF/listar-usuario.jsp").forward(request, response);
    }
    
    private void doEditarGet(HttpServletRequest request, HttpServletResponse response)          
            throws ServletException, IOException {
         try {
        UsuarioJpaController dao = new UsuarioJpaController(ut, emf);
        
        Long id = Long.parseLong(request.getParameter("id"));
        Usuario usuario = dao.findUsuario(id);
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("WEB-INF/editar-usuario.jsp").forward(request, response);
    } catch (Exception e) {
        response.sendRedirect("listar-usuario.html");
    }
}

    private void doEditarPost(HttpServletRequest request, HttpServletResponse response)            
            throws ServletException, IOException {
           try {
        UsuarioJpaController dao = new UsuarioJpaController(ut, emf);
        
        Long id = Long.parseLong(request.getParameter("id"));
        Usuario usuario = dao.findUsuario(id);
        usuario.setNome(request.getParameter("nome"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));
        dao.edit(usuario);
        response.sendRedirect("listar-usuario.html");
       
    } catch (Exception e) {
        response.sendRedirect("listar-usuario.html");
    }
 }
     private void doExcluirGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {
            UsuarioJpaController dao = new UsuarioJpaController(ut, emf);
        
            Long id = Long.parseLong(request.getParameter("id"));
            dao.destroy(id);
        } catch (Exception ex) {
        }
        response.sendRedirect("listar-usuario.html");
    }
    
}
