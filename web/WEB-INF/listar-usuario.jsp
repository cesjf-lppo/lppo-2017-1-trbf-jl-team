

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Usuarios</title>
        <link rel="stylesheet" href="/CSS/estilo.css" />
    </head>
    <body>
        <%@include file = "jspf/menu.jspf" %>
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
                    <td>${usuario.nome}</td>
                    <td>${usuario.email}</td>
                    <td>${usuario.senha}</td>
                    <td><a href="excluir-usuario.html?id=${usuario.id}"> X </a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
