<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 25.09.2020
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CADMDB</title>
</head>
<body>

    <div class="container-sm">

        <jsp:include page="../header.jsp"/>

        <section class="content-main">

            <%-- MAIN INFO ABOUT USER --%>
            <div class="row">
                <div class="col-3">
                    <img src="/resources/img/avatars/img_avatar_someone.png" alt="AVATAR" width="100%"/>
                </div>
                <div class="col-9">
                    <h5>${user.nameFirst} ${user.nameLast}</h5>
                    <h6>${user.userCategory.name}</h6>
                    <hr>
                    <p>${user.email}</p>
                </div>
            </div>


        </section>

        <jsp:include page="../footer.jsp"/>

    </div>

</body>
</html>
