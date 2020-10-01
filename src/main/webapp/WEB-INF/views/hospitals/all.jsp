<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 01.10.2020
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CADMDB</title>
</head>
<body>

    <%-- JQUERY --%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>

    <%-- JS scripts --%>
    <script type="text/javascript" src="<c:url value="/resources/js/hospitals/all.js"/>"></script>

</body>

    <div class="container-sm">

        <jsp:include page="../header.jsp"/>

        <div class="content-main">

            <c:set var="productsCostInHospital" value="0"/>
            <c:forEach items="${hospitals}" var="hospital">
                <%-- CARD HOSPITAL --%>
                <div class="card card-hospital mb-3 border-dark" id="hospital-${hospital.id}">
                    <%-- HOSPITAL HEADER --%>
                    <div class="card-header card border-bottom border-dark">
                        <div class="row">
                            <div class="col-sm-2">
                                <img src="/resources/img/icons/hospital-001.png" width="50px" height="50px" alt="ICON"/>
                            </div>
                            <div class="col-sm-8">
                                <div class="card-title"><h5>${hospital.name}</h5></div>
                                <div class="card-subtitle">Manager: ${hospital.manager.nameFirst} ${hospital.manager.nameLast}</div>
                            </div>
                            <div class="col-sm-2">
                                <span>
                                    <button class="btn btn-outline-dark btn-hospital">
                                        <small id="${hospital.id}">EXPAND</small>
                                    </button>
                                </span>
                            </div>
                        </div>
                    </div>

                    <%-- HOSPITAL CARD BODY --%>
                    <%-- CARD DEPARTMENT --%>
                    <div class="card-body card-department">
                        <c:forEach items="${hospital.departmentList}" var="depratment">
                            <div class="card card-department">
                                <div class="card-header">
                                    <div class="card-title">Department name: ${depratment.departmentCategory.name} (ID: ${depratment.id})</div>
                                </div>
                                <div class="card-body"></div>
                                <div class="card-footer"></div>
                            </div>
                            <c:forEach items="${depratment.roomList}" var="room">
                                <c:forEach items="${room.productList}" var="product">
                                    <c:set var="productsCostInHospital" value="${productsCostInHospital + product.price}"/>
                                </c:forEach>
                            </c:forEach>
                        </c:forEach>
                    </div>

                    <%-- HOSPITAL FOOTER --%>
                    <div class="card-footer">
                        <div class="card-text">
                            <div class="row">
                                <div class="col-sm-10 text-right"> Initial budget:</div>
                                <div class="col-sm-2 text-right">
                                        <fmt:formatNumber
                                                type="currency"
                                                value="${hospital.budget}"
                                                minFractionDigits="2"
                                                maxFractionDigits="2"
                                                currencySymbol="zł"
                                        />
                                </div>
                            </div>
                        </div>
                        <div class="card-text">
                            <div class="row">
                                <div class="col-sm-10 text-right">
                                    Actual budget:
                                </div>
                                <div class="col-sm-2 text-right">
                                    <fmt:formatNumber
                                            type="currency"
                                            value="${hospital.budget - productsCostInHospital}"
                                            minFractionDigits="2"
                                            maxFractionDigits="2"
                                            currencySymbol="zł"
                                    />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>

        <jsp:include page="../footer.jsp"/>

    </div>

</html>
