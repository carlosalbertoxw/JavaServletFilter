<%-- 
    Document   : index
    Created on : Mar 18, 2019, 11:05:08 PM
    Author     : Carlos
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Acceso</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Acceso</h1>
        <form action="User" method="post">
        <p>
            <c:if test="${sessionScope.message != null}">
                ${message}
                <c:remove scope="session" var="message"></c:remove>
            </c:if>
        </p>
        <label>Usuario</label><input type="text" name="user">
        <label>Contraseña</label><input type="password" name="password">
        <input type="submit" value="Enviar">
    </form>
</body>
</html>
