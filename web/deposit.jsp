<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
    <head>
        <title>Depósito - Unibank</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <link rel="stylesheet" href="dropdown.css" type="text/css"/>
        <link rel="stylesheet" href="tooltip.css" type="text/css"/>
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
                            <p><a href="perfil.jsp">Perfil</a></p>
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
            <form action="Deposit" method="post" name="deposit">
                <p>Por favor, digite abaixo o valor do depósito e confirme com sua senha.</p>
                <p><input name="deposito" type="number" value="" placeholder="Valor do depósito"></p>
                <p><input name="password" type="password" value="" placeholder="Confirme a senha"></p>
                <p><input type="submit" value="DEPOSITAR"></p>
            </form>
        </div>

        <div style="text-align: center; font-weight: bold; color: red;">
            <c:if test="${erro != null}">
                <c:out value="${erro}" />
            </c:if>
        </div>
    </body>
</html>
