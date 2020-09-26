<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 25.09.2020
  Time: 09:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CADMDB</title>
</head>
<body>

    <div class="container">

        <jsp:include page="../header.jsp"/>

        <section id="content-main" class="text-justify">
            <c:forEach items="${userList}" var="user">
                <div class="card mb-3 d-inline-block" style="min-width: 300px; max-width: 300px">
                    <div class="row no-gutters">
                        <div class="col-sm-3 border-right bg-light" style="max-width: 75px">
                            <img src="/resources/img/avatars/img_avatar_someone.png" class="card-img" alt="AVATAR" width="75px" height="75px">
                        </div>
                        <div class="col-sm-9 p-1">
                            <p class="card-title">${user.nameFirst} ${user.nameLast}</p>
                            <c:forEach items="${user.userCategoryList}" var="userCategory">
                                <small class="card-text">${userCategory.name}</small>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="row no-gutters border-top">
                        <div class="col-sm-12 text-center">
                            <p class="card-text">
                                <a href="/users/details/${user.id}">DETAILS</a>
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </section>

        <jsp:include page="../footer.jsp"/>

    </div>

</body>
</html>
