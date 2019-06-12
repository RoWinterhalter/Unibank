<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registre-se - Unisoft</title>
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
                    <a href="index.jsp"><img src="logo2_transparent.png" /></a>
                </td>
                <td style="width: 45%">
                </td>
                <td style="width: 45%; text-align: right;">
                </td>
            </tr>
        </table>
        
        <div style="text-align: center;">
            <form action="Register" method="post" name="register">
                <p>Preencha os campos abaixo para completar seu cadastro.</p>
                <p><input name="nomeCompleto" type="text" value="" placeholder="Nome completo"></p>
                <p><input name="cpf" type="text" value="" placeholder="CPF"></p>
                <p><input name="email" type="text" value="" placeholder="Email"></p>
                <p><input name="login" type="text" value="" placeholder="Login"></p>
                <p><input name="password" type="password" value="" placeholder="Senha"></p>
                <p><input name="password2" type="password" value="" placeholder="Confirme a senha"></p>
                <p><input type="submit" value="CADASTRAR"></p>
            </form>
        </div>
        
        <div style="text-align: center; font-weight: bold; color: red;">
            <c:if test="${erro != null}">
                <c:out value="${erro}" />
            </c:if>
        </div>
    </body>
</html>
