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
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body>

    <div class="container-sm">

        <jsp:include page="../header.jsp"/>

        <section class="content-main border-bottom">

            <%-- MAIN INFO ABOUT USER --%>
            <div class="card border-0">
                <div class="card-header">
                    <h3 class="text-right">PERSONAL INFO</h3>
                </div>
                <div class="card-body">
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
                </div>
            </div>

            <c:forEach items="${sessionScope.userLoggedIn.userCategoryList}" var="userLoggedInCategory">
            <c:forEach items="${user.userCategoryList}" var="userCategory">
            <c:if test="${userLoggedInCategory.code eq 'INVESTOR (GUEST)' && userLoggedInCategory.code eq userCategory.code}">
                <%-- INVESTMENT COMPANY WHERE USER IS HIRED (USER'S EMPLOYER) --%>
                <div class="card border-0">
                    <div class="card-header">
                        <h3 class="text-right">MY INVESTMENT COMPANY INFO</h3>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-3">
                                <img src="/resources/img/logo_002.png" alt="AVATAR" width="100%" style="border: 2px black solid"/>
                            </div>
                            <div class="col-9">
                                <h5>${user.investmentCompany.name}</h5>
                                <hr>
                                <p>
                                    ${user.investmentCompany.companyAddress.country} <br>
                                    ${user.investmentCompany.companyAddress.postalCode} ${user.investmentCompany.companyAddress.city}, <br>
                                    ${user.investmentCompany.companyAddress.street} no. ${user.investmentCompany.companyAddress.streetNo}
                                </p>
                                <hr>
                                <div><a href="/investors/details/${user.investmentCompany.id}">DETAILS</a></div>
                            </div>
                        </div>
                    </div>
                </div>
                <%-- THE LIST OF HOSPITALS WHERE THE USER APPEARS AS AN INVESTOR --%>
                <div class="card border-0">
                    <div class="card-header">
                        <h3 class="text-right">MY HOSPITAL INVESTMENTS</h3>
                    </div>
                    <div class="card-body ml-auto mr-auto text-center">
                        <c:forEach items="${user.hospitalListAsInvestor}" var="hospital">
                            <div class="card m-2 mb-5 border d-inline-block" style="width: 300px; height: 300px">
                                <div class="card-header" style="height: 200px">
                                    <p class="card-title font-weight-bold">${hospital.name}</p>
                                    <p class="card-text font-italic">${hospital.country}</p>
                                    <p class="card-text font-italic text-left">${hospital.postalCode} ${hospital.city}, ${hospital.street} street, No. ${hospital.streetNo}</p>
                                    <div class="text-right">
                                        <a href="/hospitals/details/${hospital.id}?content=info">DETAILS</a>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <p class="card-text text-right">
                                        Budget:
                                    </p>
                                    <p class="card-text text-right">
                                        <fmt:formatNumber
                                                type="currency"
                                                currencySymbol="zł"
                                                minFractionDigits="2"
                                                maxFractionDigits="2"
                                                value="${hospital.budget}"
                                        />
                                    </p>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="card m-2 mb-5 border d-inline-block" style="width: 300px; height: 300px">
                            <div class="card-header text-center" style="height: 200px">
                                <a href="/hospitals/new?investorId=${user.id}&demo=true&backToPage=/users/details/5">
                                    <img src="/resources/img/icons/plus-001.png" width="128" alt="ADD NEW HOSPITAL"/>
                                </a>
                            </div>
                            <div class="card-body">
                                <p class="card-text text-right">
                                    Budget:
                                </p>
                                <p class="card-text text-right">
                                    <fmt:formatNumber
                                            type="currency"
                                            currencySymbol="zł"
                                            minFractionDigits="2"
                                            maxFractionDigits="2"
                                            value="0"
                                    />
                                </p>
                            </div>
                        </div>

                    </div>
                </div>
            </c:if>
            <c:if test="${userLoggedInCategory.code eq 'HOSPITAL MANAGER (GUEST)' && userLoggedInCategory.code eq userCategory.code}">
                <%-- THE LIST OF HISPITALS THAT USER IS CONNECTED WITH --%>
                <div class="card border-0">
                    <div class="card-header">
                        <h3 class="text-right">MY HOSPITALS</h3>
                    </div>
                </div>
                <div class="card-body ml-auto mr-auto text-center">
                    <c:forEach items="${user.hospitalManagingList}" var="hospital">
                        <div class="card m-2 mb-5 border d-inline-block" style="width: 300px; height: 300px">
                            <div class="card-header" style="height: 200px">
                                <p class="card-title font-weight-bold">${hospital.name}</p><br>
                                <p class="card-text font-italic">${hospital.country}</p>
                                <p class="card-text font-italic text-left">${hospital.postalCode} ${hospital.city}, ${hospital.street} street, No. ${hospital.streetNo}</p>
                                <div class="text-right">
                                    <a href="/hospitals/details/${hospital.id}">DETAILS</a>
                                </div>
                            </div>
                            <div class="card-body">
                                <p class="card-text text-right">
                                    Budget:
                                </p>
                                <p class="card-text text-right">
                                    <fmt:formatNumber
                                        type="currency"
                                        currencySymbol="zł"
                                        minFractionDigits="2"
                                        maxFractionDigits="2"
                                        value="${hospital.budget}"
                                    />
                                </p>
                            </div>
                        </div>
                    </c:forEach>
                </div>

            </c:if>
            </c:forEach>
            </c:forEach>

        </section>

        <jsp:include page="../footer.jsp"/>

    </div>

</body>
</html>
