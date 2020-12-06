<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 05.12.2020
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

    <div class="container">
        <jsp:include page="../header.jsp"/>

        <div class="card">

            <div class="card-header">
                SETTING A MANAGER OF THE HOSPITAL: ${hospital.name}
            </div>

            <div class="card-body">

                <c:forEach items="${users}" var="user">
                    <div class="row mt-1 mb-1 border-top border-bottom">
                        <div class="col-sm-2">${user.id}</div>
                        <div class="col-sm-7">${user.nameFirst} ${user.nameLast}</div>
                        <c:choose>
                            <c:when test="${hospital.manager.id ne user.id}">
                                <div class="col-sm-3"><a href="/hospitals/${hospital.id}/setManager?userId=${user.id}" class="btn btn-success">SET AS MANAGER</a></div>
                            </c:when>
                            <c:otherwise>
                                <div class="col-sm-3"><a href="/hospitals/${hospital.id}/setManager?userId=${user.id}" class="btn btn-success disabled">SET AS MANAGER</a></div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </c:forEach>

            </div>

            <div class="card-footer">

            </div>

        </div>

        <jsp:include page="../footer.jsp"/>
    </div>


</body>
</html>
