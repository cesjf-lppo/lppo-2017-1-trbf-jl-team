<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Tarefa</title>
    </head>
    <body>
        <%@include file = "jspf/menu.jspf" %>
        <h1>Editar Tarefa</h1>
        <form method="post">
            <table>
                 <tr>
                    <td>Id: </td>
                    <td> <input type="hidden" name="id" value="${tarefa.id}"/>${tarefa.id}</td>
                </tr>
                <tr>
                    <td>Titulo: </td>
                    <td><input type="text" name="titulo" value="${tarefa.titulo}" /></td>
                </tr>
                <tr>
                    <td>Descrição: </td>
                    <td><input type="text" name="descricao" value="${tarefa.descricao}"/> </td>
                </tr>
                <tr>
                    <td>Data prevista concluir: </td>
                    <td><input type="text" name="dataConcluir" value="${tarefa.dataConcluir}"/> </td>
                </tr>
                <tr>
                    <td>Data de conclusão </td>
                    <td><input type="text" name="dataConclusao" value="${tarefa.dataConclusao}"/> </td>
                </tr>
                <tr>
                    <td colspan="2" align="right">
                        <button type="submit">Enviar</button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
