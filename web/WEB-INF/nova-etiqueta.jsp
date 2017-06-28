<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%><html>
    <head>
        <title></title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="estilo.css" />
    </head>
    <body>
    <center>
        <div id="pagina">
            <div id="logotipo">
                <%@include file = "jspf/logotipo.jspf" %>
            </div>
            <div id="menus">
                <%@include file = "jspf/menu.jspf" %>
            </div>
            <div id="conteudo">
                <h1>Nova Etiqueta</h1>
                <form method="post">
                    <table>
                        <tr>
                            <td>Usuário: </td>
                            <td>
                                <select name="idUsuario">
                                    <c:forEach var="usuario" items="${usuarios}">
                                        <option value="${usuario.id}">${usuario.nome}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Tarefa </td>
                            <td>
                                <select name="idTarefa">
                                    <c:forEach var="tarefa" items="${tarefas}">
                                        <option value="${tarefa.id}">${tarefa.titulo}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Titulo: </td>
                            <td>
                                <input type="text" name="titulo" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="right">
                                <button type="submit">Enviar</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <div id="rodape">
                Trabalho desenvolvido por: 
                <a href="mailto:je_barbosaa@hotmail.com">Jéssica Barbosa</a> e 
                <a href="mailto:luiz.santos89@yahoo.com.br">Luiz Santos</a>
            </div>
        </div>
    </center>        
</body>
</html>