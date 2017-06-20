<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
    </head>
    <body>
        
        <h1>Editar Ususario</h1>
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
                    <td><input type="text" name="senha" value="${usuario.senha}"/> ${usuario.senha}</td>
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
