
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <h1>Lista de Tarefas:</h1>
                <table border='1'>
                    <tr>
                        <th>Id: </th>
                        <th>Título: </th>
                        <th>Descrição:</th>
                        <th>Data Prevista Conclusão: </th>
                        <th>Data de Conclusão:</th>
                        <th>Excluir</th>
                    </tr>
                    <c:forEach var="tarefa" items="${tarefas}">
                        <tr>
                            <td><a href="editar-tarefa.html?id=${tarefa.id}">${tarefa.id}</a></td>
                            <td>${tarefa.titulo}</td>
                            <td>${tarefa.descricao}</td>
                            <td><fmt:formatDate value="${tarefa.dataConcluir}" type="date" dateStyle="default" /></td>
                            <td><fmt:formatDate value="${tarefa.dataConclusao}" type="date" dateStyle="default" /></td>
                            <td><a href="excluir-tarefa.html?id=${tarefa.id}"> X </a></td>
                        </tr>
                    </c:forEach>
                </table>
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