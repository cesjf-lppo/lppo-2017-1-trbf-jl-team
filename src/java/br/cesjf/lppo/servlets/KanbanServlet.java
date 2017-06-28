
package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Etiqueta;
import br.cesjf.lppo.Usuario;
import br.cesjf.lppo.dao.EtiquetaJpaController;
import br.cesjf.lppo.dao.UsuarioJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet(name = "KanbanServlet", urlPatterns = {"/kanban.html"})
public class KanbanServlet extends HttpServlet {

    @PersistenceUnit(unitName = "trbflppo-2017-1PU")
    EntityManagerFactory emf;
    
    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("idUsuario"));
        
        Usuario usuario = new Usuario();
        UsuarioJpaController usuarioDao = new UsuarioJpaController(ut, emf);
        usuario = usuarioDao.findUsuario(id);
        
        List<Etiqueta> etiquetas;
        EtiquetaJpaController etiquetaDao = new EtiquetaJpaController(ut, emf);
        etiquetas = etiquetaDao.getEtiquetaByAutor(id);
        
        request.setAttribute("usuario", usuario);
        request.setAttribute("etiquetas", etiquetas);
       request.getRequestDispatcher("WEB-INF/kanban.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
