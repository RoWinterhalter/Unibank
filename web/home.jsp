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
        <title>Home - Unibank</title>
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
            <div style="width: 60%">
                <fieldset class="saldo"><legend>Saldo da conta</legend>
                    <fmt:formatNumber value="${loginUser.saldo}" type="currency" />
                    &nbsp
                    <div class="tooltip">
                        <span class="tooltiptext">Atualizar</span>
                        <a href="UpdateBalance">
                            <img src="update.png" style="height: 24px; width: auto;">
                        </a>
                    </div>
                </fieldset>
            </div>
        </div>

        <div style="text-align: center; font-weight: bold; color: green;">
            <c:if test="${sucesso != null}">
                <c:out value="${sucesso}" />
            </c:if>
        </div>
    </body>
</html>
