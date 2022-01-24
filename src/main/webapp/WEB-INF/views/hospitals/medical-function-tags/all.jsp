<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: z0041nhm
  Date: 22.01.2022
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

    <jsp:include page="../../header.jsp"/>

    <div class="container-sm">
        <c:forEach items="${medicalFunctionTags}" var="medicalFunctionTag">
            <div class="card d-inline-block m-2" style="width: 350px; height: 165px;">
                <div class="row no-gutters">
                    <div class="col-sm-3 bg-light" style="height: 162px">
                        <%--<img class="card-img" src="#" alt="TAG">--%>
                        <div class="bg-light"></div>
                    </div>
                    <div class="col-sm-8">
                        <div class="card-body">
                            <h5 class="card-title">${medicalFunctionTag.namePL}</h5>
                            <p class="card-title">${medicalFunctionTag.nameEN}</p>
                            <%--<p class="card-text">Suresh Dasari is a founder and technical lead developer in tutlane.</p>
                            <a href="#" class="btn btn-primary">View Profile</a>--%>
                        </div>
                    </div>
                    <div class="col-1">
                        <a href="/medical-function-tags/delete/${medicalFunctionTag.id}" class="text-danger">DEL</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <jsp:include page="../../footer.jsp"/>

</body>
</html>
