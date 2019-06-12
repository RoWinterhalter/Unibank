<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login - Unibank</title>
    </head>
    <body>
        <form action="Login" method="post" name="login">
            <table class="header">
                <tr>
                    <td style="width: 20%">
                        <img src="logo2_transparent.png" />
                    </td>
                    <td style="width: 45%">

                    </td>
                    <td style="width: 45%; text-align: right;">
                        <input type="text" name="login" placeholder="Digite seu Login">
                        <input type="password" name="pass" placeholder="Digite sua senha">
                        <input type="submit" value="LOGIN"><br>
                        <a href="register.jsp">Nao tem uma conta? Cadastre-se</a>
                    </td>
                </tr>
            </table>
        </form>
        
        <div style="text-align: center; font-weight: bold; color: red;">
            <c:if test="${erro != null}">
                <c:out value="${erro}" />
            </c:if>
        </div>
        
        <div style="text-align: center; font-weight: bold; color: green;">
            <c:if test="${sucesso != null}">
                <c:out value="${sucesso}" />
            </c:if>
        </div>
    </body>
</html>
