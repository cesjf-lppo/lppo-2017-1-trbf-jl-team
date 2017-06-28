<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title></title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" type="text/css" href="CSS/estilo.css" />
    </head>
    <body>
    <center>
        <div id="pagina">
            <div id="logotipo">
                Trabalho Final LPPO
            </div>
            <div id="barramenu">
                <%@include file = "jspf/menu.jspf" %>
            </div>
            <div id="conteudo">
                <h1>Listar Etiqueta</h1>
                <table border='1'>
                    <tr>
                        <th>Id</th>
                        <th>Id Autor</th>
                        <th>Id Tarefa</th>
                        <th>Titulo</th>
                        <th>Excluir</th>
                    </tr>
                    <c:forEach var="etiqueta" items="${etiquetas}">
                        <tr>
                            <td><a href="editar-etiqueta.html?id=${etiqueta.id}">${etiqueta.id}</a></td>
                            <td><a href="listar-etiqueta.html?idAutor=${etiqueta.idAutor}">${etiqueta.idAutor}</td>
                            <td>${etiqueta.idTarefa}</td>
                            <td><a href="listar-etiqueta.html?titulo=${etiqueta.titulo}">${etiqueta.titulo}</td>
                            <td><a href="excluir-etiqueta.html?id=${etiqueta.id}">X</a></td>
                        </tr>    
                    </c:forEach>        
                </table>
                <a href="listar-etiqueta.html">Visualizar todas as etiquetas</a>
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