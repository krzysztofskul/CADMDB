<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 24.09.2020
  Time: 13:51
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

        <div class="content">
            <h5>LOREM IPSUM</h5>
            <p>${manufacturer.id} | ${manufacturer.name} ${manufacturer.companyType}</p>
        </div>

        <jsp:include page="../footer.jsp"/>

    </div>

</body>
</html>
