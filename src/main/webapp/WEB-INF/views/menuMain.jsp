<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 07.02.2020
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <div class="container">

        <jsp:include page="menuLogIn.jsp"/>

        <nav class="nav border-top">
            <a class="nav-link active" href="/">HOME</a>
            <c:choose>
                <c:when test="${sessionScope.initDB eq null}">
                    <c:set var="status" value="active"/>
                </c:when>
                <c:otherwise>
                    <c:set var="status" value="disabled"/>
                </c:otherwise>
            </c:choose>
            <a class="nav-link ${status}" href="/initTestDB">INIT. TEST DB</a>
            <a class="nav-link active" href="/hospitals/all">HOSPITALS</a>
            <a class="nav-link active" href="/manufacturers/all">MANUFACTURERS</a>
            <a class="nav-link active" href="/products/all">PRODUCTS</a>
            <a class="nav-link active" href="/users/all">USERS</a>
        </nav>

    </div>

</body>
</html>
