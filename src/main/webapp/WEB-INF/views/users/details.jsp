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
                    <c:forEach items="${user.userCategoryList}" var="userCategory">
                        <h6>${userCategory.name}</h6>
                    </c:forEach>
                    <hr/>
                    <p>${user.email}</p>
                </div>
            </div>

            <hr>

            <c:forEach items="${sessionScope.userLoggedIn.userCategoryList}" var="userLoggedInCategory">
            <c:forEach items="${user.userCategoryList}" var="userCategory">

            <c:if test="${userLoggedInCategory.code eq 'INVESTOR (GUEST)' && userLoggedInCategory.code eq userCategory.code}">
                <%-- HOSPITALS WHERE USER IS AN INVESTOR (USER'S INVESTMENTS) --%>
                <div class="row">
                    <div class="col-12">
                        <h5>MY INVESTMENTS:</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <c:forEach items="${user.hospitalListAsInvestor}" var="hospital">
                            <div class="card ml-1 mr-1 border d-inline-block" style="width: 275px">
                                <div class="card-header" style="height: 175px">
                                    <p class="card-title font-weight-bold">${hospital.name}</p>
                                    <p class="card-text font-italic">${hospital.country}, ${hospital.postalCode} ${hospital.city}</p>
                                    <p class="card-text font-italic">${hospital.street} street, No. ${hospital.streetNo}</p>
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
                        <div class="card ml-1 mr-1 mt-5 border" style="width: 275px; height: 250px">
                            <div class="card-body text-center pt-5">
                                <a href="/hospitals/new?investorId=${user.id}&demo=true&backToPage=/users/details/5"><img src="/resources/img/icons/plus-001.png" width="128" alt="ADD NEW HOSPITAL"/></a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>

            <c:if test="${userLoggedInCategory.code eq 'HOSPITAL MANAGER (GUEST)' && userLoggedInCategory.code eq userCategory.code}">
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
                                <p class="card-title font-weight-bold">${hospital.name}</p>
                                <p class="card-text font-italic">${hospital.country}, ${hospital.postalCode} ${hospital.city}</p>
                                <p class="card-text font-italic">${hospital.street} street, No. ${hospital.streetNo}</p>
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
            </c:forEach>
            </c:forEach>

        </section>

        <jsp:include page="../footer.jsp"/>

    </div>

</body>
</html>
