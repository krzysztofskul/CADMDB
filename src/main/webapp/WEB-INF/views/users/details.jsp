<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                    <hr/>
                    <p>${user.email}</p>
                </div>
            </div>

            <hr>

            <c:if test="${sessionScope.userLoggedIn.userCategory.code eq 'HOSPITAL MANAGER (GUEST)' && sessionScope.userLoggedIn.userCategory.code eq user.userCategory.code}">
                <%-- USER'S CONNECTED HOSPITALS --%>
                <div class="row">
                    <div class="col-12">
                        <h5>MY HOSPITALS:</h5>
                    </div>
                </div>
                <div class="card-group">
                <c:forEach items="${user.hospitalManagingList}" var="hospital">
                        <div class="card ml-1 mr-1 border" style="max-width: 275px">
                            <div class="card-header">
                                <p class="card-title">${hospital.name}</p>
                            </div>
                            <div class="card-body">
                                <p class="card-text">
                                    Budget:
                                    <fmt:formatNumber
                                        type="currency"
                                        currencySymbol="zł"
                                        minFractionDigits="2"
                                        maxFractionDigits="2"
                                        value="${hospital.budget}"
                                    />
                                </p>
                            </div>
                            <div class="card-footer">
                                <a href="/hospitals/details/${hospital.id}">DETAILS</a>
                            </div>
                        </div>
                </c:forEach>
                </div>

                <hr>

                <%-- USER'S CONNECTED DEPARTMENTS --%>
                <div class="row">
                    <div class="col-12">
                        <h5>MY DEPARTMENTS:</h5>
                    </div>
                </div>
                <c:forEach items="${user.departmentManagingList}" var="department">
                    <div class="card ml-1 mr-1 border d-inline-block" style="max-width: 275px">
                        <div class="card-header">
                            <p class="card-title">${department.departmentCategory.name}</p>
                        </div>
                        <div class="card-body">
                            <p class="card-text">
                                Budget:
                                <fmt:formatNumber
                                        type="currency"
                                        currencySymbol="zł"
                                        minFractionDigits="2"
                                        maxFractionDigits="2"
                                        value="${department.budget}"
                                />
                            </p>
                        </div>
                        <div class="card-footer">
                            <a href="/departments/details/${department.id}">DETAILS</a>
                        </div>
                    </div>
                </c:forEach>

            </c:if>


        </section>

        <jsp:include page="../footer.jsp"/>

    </div>

</body>
</html>
