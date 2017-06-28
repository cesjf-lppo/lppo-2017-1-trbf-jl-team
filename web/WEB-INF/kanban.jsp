<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title></title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" type="text/css" href="CSS/estilo.css" />
        <style>
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
                <a href="listar-usuario.html">Trabalho Final LPPO</a>
            </div>
            <div id="conteudo">
                <h1>${usuario.nome}</h1>
                <dir id="etiqueta">
                    <h3>A Fazer: </h3>
                    <c:forEach items="${etiquetas}" var="etiqueta">
                        <c:if test="${etiqueta.titulo == 'A Fazer'}">
                            <div id="tarefa">
                                 #${etiqueta.tarefa.id} - ${etiqueta.tarefa.titulo}
                            </div>
                        </c:if>
                    </c:forEach>
                </dir>
                <dir id="etiqueta">
                    <h3>Fazendo: </h3>
                    <c:forEach items="${etiquetas}" var="etiqueta">
                        <c:if test="${etiqueta.titulo == 'Fazendo'}">
                            <div id="tarefa">
                                 #${etiqueta.tarefa.id} - ${etiqueta.tarefa.titulo}
                            </div>
                        </c:if>
                    </c:forEach>
                </dir>
                <dir id="etiqueta">
                    <h3>Bloqueado: </h3>
                    <c:forEach items="${etiquetas}" var="etiqueta">
                        <c:if test="${etiqueta.titulo == 'Bloqueado'}">
                            <div id="tarefa">
                                 #${etiqueta.tarefa.id} - ${etiqueta.tarefa.titulo}
                            </div>
                        </c:if>
                    </c:forEach>
                </dir>
                <dir id="etiqueta">
                    <h3>Finalizado: </h3>
                    <c:forEach items="${etiquetas}" var="etiqueta">
                        <c:if test="${etiqueta.titulo == 'Finalizado'}">
                            <div id="tarefa">
                                 #${etiqueta.tarefa.id} - ${etiqueta.tarefa.titulo}
                            </div>
                        </c:if>
                    </c:forEach>
                </dir>
            </div>
        </div>
    </center>        
</body>
</html>