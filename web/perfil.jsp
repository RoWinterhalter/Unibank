<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <link rel="stylesheet" href="dropdown.css" type="text/css"/>
        <link rel="stylesheet" href="tooltip.css" type="text/css"/>
        <title>Perfil - Unibank</title>
        <style>
            input{
                width: 20%;
            }
        </style>
    </head>
    <body>
        <table class="header">
            <tr>
                <td style="width: 20%">
                    <a href="home.jsp"><img src="logo2_transparent.png" /></a>
                </td>
                <td style="width: 60%">
                    <div class="dropdown">
                        <span>Menu</span>
                        <div class="dropdown-content">
                            <p><a href="transfer.jsp">Perfil</a></p>
                            <p><a href="withdraw.jsp">Sacar</a></p>
                            <p><a href="deposit.jsp">Depositar</a></p>
                            <p><a href="transfer.jsp">Transferir</a></p>
                        </div>
                    </div> 
                </td>
                <td style="width: 20%; text-align: right;">
                    <a href="index.jsp">Olá ${loginUser.nome_completo}!<br>Clique aqui caso deseja sair.</a>
                </td>
            </tr>
        </table>

        <div style="text-align: center;">
            <form action="Update" method="post" name="update">
                <p>Seu perfil</p>
                <p><input name="nomeCompleto" type="text" value="${loginUser.nome_completo}" placeholder="Nome completo"></p>
                <p><input name="cpf" type="text" value="${loginUser.cpf}" placeholder="CPF"></p>
                <p><input name="email" type="text" value="${loginUser.email}" placeholder="Email"></p>
                <p><input name="login" type="text" value="${loginUser.login}" placeholder="Login"></p>
                <p><input name="password" type="text" value="${loginUser.senha}" placeholder="Senha"></p>
                <p><input name="password2" type="text" value="${loginUser.senha}" placeholder="Senha"></p>
                <p><input type="submit" value="SALVAR ALTERAÇÕES"></p>
            </form>
            <br>
            <div style="text-align: center;">
                <form action="Delete" method="post" name="delete">
                    <input name="login" type="hidden" value="${loginUser.login}">
                    <input type="submit" value="DELETAR CONTA">
                </form>
            </div>
        </div>

        <div style="text-align: center; font-weight: bold; color: red;">
            <c:if test="${erro != null}">
                <c:out value="${erro}" />
            </c:if>
        </div>
    </body>
</html>
