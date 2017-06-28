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
                <h1>Listar Usuarios</h1>
                <table border="1">
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Senha</th>
                        <th>Excluir</th>
                    </tr>
                    <c:forEach var = "usuario"  items = "${usuarios}">
                        <tr>
                            <td><a href="editar-usuario.html?id=${usuario.id}"> ${usuario.id}</a></td>
                            <td><a href="kanban.html?idUsuario=${usuario.id}">${usuario.nome}</a></td>
                            <td>${usuario.email}</td>
                            <td>${usuario.senha}</td>
                            <td><a href="excluir-usuario.html?id=${usuario.id}"> X </a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div id="rodape">
                <%@include file = "jspf/rodape.jspf" %>
            </div>
        </div>
    </center>        
    </body>
</html>