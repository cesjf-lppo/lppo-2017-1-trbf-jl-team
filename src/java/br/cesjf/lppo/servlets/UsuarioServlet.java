package br.cesjf.lppo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

    private void doListarrGet(HttpServletRequest request, HttpServletResponse response)            
            throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doExcluirGet(HttpServletRequest request, HttpServletResponse response)            throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doEditarGet(HttpServletRequest request, HttpServletResponse response)            throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doCriarPost(HttpServletRequest request, HttpServletResponse response)            throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doEditarPost(HttpServletRequest request, HttpServletResponse response)            throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
