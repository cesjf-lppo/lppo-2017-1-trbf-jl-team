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
                <h1>Usuário: ${usuario.nome}</h1>
                <div id="etiqueta">
                    <h3>A Fazer: </h3>
                    <c:forEach items="${etiquetas}" var="etiqueta">
                        <c:if test="${etiqueta.titulo == 'A Fazer'}">
                            <div id="tarefa">
                                 #${etiqueta.tarefa.id} - ${etiqueta.tarefa.titulo}
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <div id="etiqueta">
                    <h3>Fazendo: </h3>
                    <c:forEach items="${etiquetas}" var="etiqueta">
                        <c:if test="${etiqueta.titulo == 'Fazendo'}">
                            <div id="tarefa">
                                 #${etiqueta.tarefa.id} - ${etiqueta.tarefa.titulo}
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <div id="etiqueta">
                    <h3>Bloqueado: </h3>
                    <c:forEach items="${etiquetas}" var="etiqueta">
                        <c:if test="${etiqueta.titulo == 'Bloqueado'}">
                            <div id="tarefa">
                                 #${etiqueta.tarefa.id} - ${etiqueta.tarefa.titulo}
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <div id="etiqueta">
                    <h3>Finalizado: </h3>
                    <c:forEach items="${etiquetas}" var="etiqueta">
                        <c:if test="${etiqueta.titulo == 'Finalizado'}">
                            <div id="tarefa">
                                 #${etiqueta.tarefa.id} - ${etiqueta.tarefa.titulo}
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
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