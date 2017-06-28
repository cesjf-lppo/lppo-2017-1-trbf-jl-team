<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%><html>
    <head>
        <title></title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="estilo.css" /><style>
            #etiqueta {
                width: 150px;
                float: left;
            }
            
            #tarefa {
                width: 115px;
                background-color: darkkhaki;
                color: black;
                font-weight: bold;
                text-align: left;
                padding: 5px;
                font-style: italic;
            } 
        </style>
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
                <h1>Selecione o usuário para montar o Kanban:</h1>
                
                <form method="post">
                    Usuário: 
                    <select name="idUsuario">
                        <c:forEach items="${usuarios}" var="usuario">
                            <option value="${usuario.id}">${usuario.nome}</option>
                        </c:forEach>
                    </select>
                    <button type="submit">Montar</button>
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