/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Etiqueta;
import br.cesjf.lppo.Tarefa;
import br.cesjf.lppo.Usuario;
import br.cesjf.lppo.dao.EtiquetaJpaController;
import br.cesjf.lppo.dao.TarefaJpaController;
import br.cesjf.lppo.dao.UsuarioJpaController;
import br.cesjf.lppo.dao.exceptions.RollbackFailureException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

/**
 *
 * @author Jessica Barbosa
 */
@WebServlet(name = "EtiquetaServlet", urlPatterns = {"/criar-etiqueta.html","/listar-etiqueta.html","/editar-etiqueta.html","/excluir-etiqueta.html"})
public class EtiquetaServlet extends HttpServlet {

    @PersistenceUnit(unitName = "trbflppo-2017-1PU")
    EntityManagerFactory emf;
    
    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getServletPath().contains("/criar-etiqueta.html")) {
            doCriarGet(request,response);
        } else if (request.getServletPath().contains("/listar-etiqueta.html")) {
            doListarGet(request,response);
        } else if (request.getServletPath().contains("/editar-etiqueta.html")) {
            doEditarGet(request,response);
        } else if (request.getServletPath().contains("/excluir-etiqueta.html")) {
            doExcluirGet(request,response);
        } 
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().contains("/criar-etiqueta.html")) {
            doCriarPost(request,response);
        } else if (request.getServletPath().contains("/editar-etiqueta.html")) {
            doEditarPost(request,response);
        } 
    }

    
    
    
    private void doCriarGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Usuario> usuarios;
        List<Tarefa> tarefas;
        UsuarioJpaController usuarioDao = new UsuarioJpaController(ut,emf);
        TarefaJpaController tarefaDao = new TarefaJpaController(ut, emf);
        usuarios = usuarioDao.findUsuarioEntities();
        tarefas = tarefaDao.findTarefaEntities();
        
        request.setAttribute("usuarios", usuarios);
        request.setAttribute("tarefas",tarefas);
       request.getRequestDispatcher("WEB-INF/nova-etiqueta.jsp").forward(request, response);
    }

    private void doCriarPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        Etiqueta etiqueta1 = new Etiqueta();
        etiqueta1.setTitulo(request.getParameter("titulo"));
        etiqueta1.setIdAutor(Long.parseLong(request.getParameter("idUsuario")));
        etiqueta1.setIdTarefa(Long.parseLong(request.getParameter("idTarefa")));
        
        EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);
        try {
            dao.create(etiqueta1);
            response.sendRedirect("listar-etiqueta.html");
        } catch (Exception ex) {
            Logger.getLogger(EtiquetaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void doListarGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        List<Etiqueta> etiquetas;        
        EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);
        etiquetas = dao.findEtiquetaEntities();
        
        request.setAttribute("etiquetas", etiquetas);
        request.getRequestDispatcher("WEB-INF/listar-etiqueta.jsp").forward(request, response);
       
    }

    private void doEditarGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException{
        Long id = Long.parseLong(request.getParameter("id"));
        Etiqueta etiqueta;
        
        EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);
        etiqueta = dao.findEtiqueta(id);
        
        request.setAttribute("etiqueta",etiqueta);
        request.getRequestDispatcher("WEB-INF/editar-etiqueta.jsp").forward(request, response);
    }

    private void doEditarPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
        try {
            EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);
            
            Long id = Long.parseLong(request.getParameter("id"));
            Etiqueta etiqueta = dao.findEtiqueta(id);
            etiqueta.setTitulo(request.getParameter("titulo"));
            dao.edit(etiqueta);   
            response.sendRedirect("listar-etiqueta.html");
        } catch (RollbackFailureException ex) {
            Logger.getLogger(EtiquetaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EtiquetaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void doExcluirGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException{
                try {
            EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);        
            Long id = Long.parseLong(request.getParameter("id"));
            dao.destroy(id);
        } catch (Exception ex) {
            response.sendRedirect("WEB-INF/erro.jsp");
        }
        response.sendRedirect("listar-etiqueta.html");
    }

    

}