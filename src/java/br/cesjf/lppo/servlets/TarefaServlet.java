package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Etiqueta;
import br.cesjf.lppo.Tarefa;
import br.cesjf.lppo.Usuario;
import br.cesjf.lppo.dao.EtiquetaJpaController;
import br.cesjf.lppo.dao.TarefaJpaController;
import br.cesjf.lppo.dao.UsuarioJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@WebServlet(name = "TarefaServlet", urlPatterns = {"/criar-tarefa.html","/listar-tarefa.html","/editar-tarefa.html","/excluir-tarefa.html"})
public class TarefaServlet extends HttpServlet {
    
    @PersistenceUnit(unitName = "trbflppo-2017-1PU")
    EntityManagerFactory emf;
    
    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getServletPath().contains("/criar-tarefa.html")) {
            doCriarGet(request,response);
        } else if (request.getServletPath().contains("/listar-tarefa.html")) {
            doListarGet(request,response);
        } else if (request.getServletPath().contains("/editar-tarefa.html")) {
            doEditarGet(request,response);
        } else if (request.getServletPath().contains("/excluir-tarefa.html")) {
            doExcluirGet(request,response);
        } 
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        if (request.getServletPath().contains("/criar-tarefa.html")) {
            doCriarPost(request,response);
        } else if (request.getServletPath().contains("/editar-tarefa.html")) {
            doEditarPost(request,response);
        } 
        
    }

    private void doCriarGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{        
        request.getRequestDispatcher("WEB-INF/nova-tarefa.jsp").forward(request, response);
        
    }

    private void doListarGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Tarefa> tarefas;
        
        TarefaJpaController dao = new TarefaJpaController(ut, emf);
        tarefas = dao.findTarefaEntities();
        
        request.setAttribute("tarefas", tarefas);
        request.getRequestDispatcher("WEB-INF/listar-tarefa.jsp").forward(request, response);
    }

    private void doEditarGet(HttpServletRequest request, HttpServletResponse response) 
             throws ServletException, IOException {
         try {
            TarefaJpaController dao = new TarefaJpaController(ut, emf);

            Long id = Long.parseLong(request.getParameter("id"));
            Tarefa tarefa = dao.findTarefa(id);
            request.setAttribute("tarefa", tarefa);
            request.getRequestDispatcher("WEB-INF/editar-tarefa.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("WEB-INF/erro.jsp");
        }
    }

    private void doExcluirGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException{
                try {
            TarefaJpaController dao = new TarefaJpaController(ut, emf);        
            Long id = Long.parseLong(request.getParameter("id"));
            dao.destroy(id);
        } catch (Exception ex) {
            response.sendRedirect("WEB-INF/erro.jsp");
        }
        response.sendRedirect("listar-tarefa.html");
    }

    private void doCriarPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(request.getParameter("titulo"));
        tarefa.setDescricao(request.getParameter("descricao"));
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            tarefa.setDataConcluir(format.parse(request.getParameter("dataConcluir")));
        } catch (ParseException ex) {
            Logger.getLogger(TarefaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        TarefaJpaController dao = new TarefaJpaController(ut,emf);
        
        try {
            dao.create(tarefa);
            response.sendRedirect("listar-tarefa.html");
        } catch (Exception ex) {
            Logger.getLogger(TarefaServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("WEB-INF/erro.jsp");
        }
    }

    private void doEditarPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
           try {
        TarefaJpaController dao = new TarefaJpaController(ut, emf);
        
        Long id = Long.parseLong(request.getParameter("id"));
        Tarefa tarefa = dao.findTarefa(id);
        tarefa.setTitulo(request.getParameter("titulo"));
        tarefa.setDescricao(request.getParameter("descricao"));
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            tarefa.setDataConcluir(format.parse(request.getParameter("dataConcluir")));
        } catch (ParseException ex) {
            Logger.getLogger(TarefaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tarefa.setDataConclusao(format.parse(request.getParameter("dataConclusao")));
        } catch (ParseException ex) {
            Logger.getLogger(TarefaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.edit(tarefa);
        response.sendRedirect("listar-tarefa.html");       
    } catch (Exception e) {
        response.sendRedirect("WEB-INF/erro.jsp");
    }
    }
}
