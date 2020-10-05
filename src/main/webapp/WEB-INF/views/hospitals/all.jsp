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
                <div class="card card-hospital mb-3 border-dark">
                    <%-- HOSPITAL HEADER --%>
                    <div class="card-header card border-bottom border-dark">
                        <div class="row">
                            <div class="col-sm-2">
                                <img src="/resources/img/icons/hospital-001.png" width="50px" height="50px" alt="ICON"/>
                            </div>
                            <div class="col-sm-8">
                                <div class="card-title"><h5>
                                        <a href="/hospitals/details/${hospital.id}">${hospital.name}</a>
                                </h5></div>
                                <div class="card-title"><small class="font-italic">${hospital.remarks}</small></div>
                                <div class="card-subtitle">
                                    <span>Hospital manager:</span>
                                    <a href="/users/details/${hospital.manager.id}">
                                        ${hospital.manager.nameFirst} ${hospital.manager.nameLast}
                                    </a>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <span>
                                    <button class="btn btn-outline-dark btn-hospital w-75 float-right">
                                        <small>EXPAND</small>
                                    </button>
                                </span>
                            </div>
                        </div>
                    </div>

                    <%-- CARD DEPARTMENT --%>
                    <div class="card-body card-department">
                        <c:forEach items="${hospital.departmentList}" var="department">
                            <div class="card card-department mb-3">
                                <%-- DEPARTMENT HEADER --%>
                                <div class="card-header">
                                    <div class="row">
                                        <div class="col-sm-2">
                                            <img src="/resources/img/icons/department-001.png" width="40px" height="40px" alt="ICON"/>
                                        </div>
                                        <div class="col-sm-8">
                                            <div class="card-title">
                                                <h5>
                                                    <a href="/departments/details/${department.id}">
                                                        ${department.departmentCategory.name}
                                                    </a>
                                                </h5>
                                            </div>
                                            <div class="card-text">
                                                <c:choose>
                                                    <c:when test="${department.userManager eq null}">
                                                        <span>Department manager: NONE</span>
                                                        <a href="#" class="border-dark border-left pl-1 disabled">SET NEW MANAGER</a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span>Department manager:</span>
                                                        <a href="/users/details/${department.userManager.id}">
                                                            ${department.userManager.nameFirst} ${department.userManager.nameLast}
                                                        </a>

                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                        </div>
                                        <div class="col-sm-2">
                                            <span>
                                                <button class="btn btn-outline-dark btn-department w-75 float-right">
                                                    <small>EXPAND</small>
                                                </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <%-- DEPARTMENT CARD BODY --%>
                                <div class="card-body">
                                    <c:set var="productsCostInDepartment" value="0"/>
                                    <c:forEach items="${department.roomList}" var="room">
                                        <%-- CARD ROOM --%>
                                        <div class="card card-room mb-3">
                                            <%-- ROOM HEADER --%>
                                            <div class="card-header card-room">
                                                <div class="row">
                                                    <div class="col-sm-2">
                                                        <img src="/resources/img/icons/room-001.png" width="30px" height="30px" alt="ICON"/>
                                                    </div>
                                                    <div class="col-sm-8">
                                                        <div class="card-title">
                                                            <h5>
                                                                <a href="/rooms/details/${room.id}">
                                                                    ${room.roomCategory.name}
                                                                </a>
                                                            </h5>
                                                        </div>
                                                        <div class="card-text">
                                                            <c:choose>
                                                                <c:when test="${room.userManager eq null}">
                                                                    <span>Room manager: NONE</span>
                                                                    <a href="#" class="disabled border-dark border-left p-1">
                                                                        SET NEW MANAGER
                                                                    </a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <p>Room manager: ${room.userManager.nameFirst} ${room.userManager.nameLast}</p>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-2">
                                                    <span>
                                                        <button class="btn btn-outline-dark btn-room w-75 float-right">
                                                            <small>EXPAND</small>
                                                        </button>
                                                    </span>
                                                    </div>
                                                </div>
                                            </div>
                                            <%-- ROOM BODY --%>
                                            <div class="card-body">
                                                <c:set var="productsCostInRoom" value="0"/>
                                                <c:forEach items="${room.productList}" var="product">
                                                    <c:set var="productsCostInRoom" value="${productsCostInRoom + product.price}"/>
                                                    <div class="card mb-3">
                                                        <div class="card-header card-product">
                                                            <div class="row">
                                                                <div class="col-sm-2">
                                                                    <img src="/resources/img/icons/product-001.png" width="20px" height="20px" alt="ICON"/>
                                                                </div>
                                                                <div class="col-sm-6">
                                                                    <div class="card-title">${product.productCategory.nameSingular}</div>
                                                                </div>
                                                                <div class="col-sm-4 text-right">
                                                                    <fmt:formatNumber
                                                                        type="currency"
                                                                        currencySymbol="zł"
                                                                        minFractionDigits="2"
                                                                        maxFractionDigits="2"
                                                                        value="${product.price}"
                                                                    />
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="card-body"></div>
                                                        <div class="card-footer"></div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                            <%-- ROOM FOOTER --%>
                                            <div class="card-footer">
                                                <div class="card-text">
                                                    <div class="row">
                                                        <div class="col-sm-9 text-right">Room initial budget:</div>
                                                        <div class="col-sm-3 text-right">
                                                            <fmt:formatNumber
                                                                    type="currency"
                                                                    value="${room.budget}"
                                                                    minFractionDigits="2"
                                                                    maxFractionDigits="2"
                                                                    currencySymbol="zł"
                                                            />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-text">
                                                    <div class="row">
                                                        <div class="col-sm-9 text-right">Room actual budget:</div>
                                                        <div class="col-sm-3 text-right">
                                                            <fmt:formatNumber
                                                                    type="currency"
                                                                    value="${room.budget - productsCostInRoom}"
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
                                <%-- DEPARTMENT FOOTER --%>
                                <div class="card-footer">
                                    <div class="card-text">
                                        <div class="row">
                                            <div class="col-sm-9 text-right">Department initial budget:</div>
                                            <div class="col-sm-3 text-right">
                                                <fmt:formatNumber
                                                        type="currency"
                                                        value="${department.budget}"
                                                        minFractionDigits="2"
                                                        maxFractionDigits="2"
                                                        currencySymbol="zł"
                                                />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card-text">
                                        <div class="row">
                                            <div class="col-sm-9 text-right">Department actual budget:</div>
                                            <div class="col-sm-3 text-right">
                                                <c:forEach items="${department.roomList}" var="room">
                                                    <c:forEach items="${room.productList}" var="product">
                                                        <c:set var="productsCostInDepartment" value="${productsCostInDepartment + product.price}"/>
                                                    </c:forEach>
                                                </c:forEach>
                                                <fmt:formatNumber
                                                        type="currency"
                                                        value="${department.budget - productsCostInDepartment}"
                                                        minFractionDigits="2"
                                                        maxFractionDigits="2"
                                                        currencySymbol="zł"
                                                />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <c:forEach items="${department.roomList}" var="room">
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
                                <div class="col-sm-9 text-right">Hospital initial budget:</div>
                                <div class="col-sm-3 text-right">
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
                                <div class="col-sm-9 text-right">Hospital actual budget:</div>
                                <div class="col-sm-3 text-right">
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
