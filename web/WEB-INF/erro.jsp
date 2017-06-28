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
                HOUVE UM ERRO !
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