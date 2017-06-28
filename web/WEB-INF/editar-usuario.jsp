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
                <h1>Editar Usuário</h1>
                <form method="post">
                    <table>
                        <tr>
                            <td>Id: </td>
                            <td> <input type="hidden" name="id" value="${usuario.id}"/> ${usuario.id} </td>
                        </tr>
                        <tr>
                            <td>Nome: </td>
                            <td><input type="text" name="nome" value="${usuario.nome}" /> ${usuario.nome}</td>
                        </tr>
                        <tr>
                            <td>Email: </td>
                            <td><input type="text" name="email" value="${usuario.email}"/> ${usuario.email}</td>
                        </tr>
                        <tr>
                            <td>Senha: </td>
                            <td><input type="password" name="senha" value="${usuario.senha}"/> ${usuario.senha}</td>
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