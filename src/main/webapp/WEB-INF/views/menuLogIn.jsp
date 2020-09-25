<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: krzysztofskul--%>
<%--  Date: 25.09.2020--%>
<%--  Time: 17:35--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>CADMDB</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>

<section class="container border-top border-bottom">

    <c:choose>
        <c:when test="${sessionScope.userLoggedIn eq null}">
            <%-- if login user == null --%>
            <a href="/#login">LOG IN</a>
            <a href="/#register">REGISTER</a>
        </c:when>
        <c:otherwise>
            <%-- if login user != null --%>
            <div>
                Hello, <span class="font-weight-bold">${userLoggedIn.nameFirst} ${userLoggedIn.nameLast}</span>!
            </div>
            <a href="/#users/profile/${userLogedIn.id}">MY PROFILE</a>
            <a href="/#logout">LOG OUT</a>

        </c:otherwise>
    </c:choose>

</section>
