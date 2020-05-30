<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 28.05.2020
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">
        <div class="card">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                    <li class="breadcrumb-item"><a href="#">${room.department.hospital.name}</a></li>
                    <li class="breadcrumb-item"><a href="#">${room.department.departmentCategory.name}</a></li>
                    <li class="breadcrumb-item active" aria-current="page">${room.number} ${room.roomCategory.name} ${room.name}</li>
                </ol>
            </nav>
            <%-- HEADER 1 --%>
            <div class="card-header">
                <div class="row">
                    <div class="col-sm-2 border-right text-center mt-auto mb-auto h4">
                        ${room.number}
                    </div>
                    <div class="col-sm-8 mt-auto mb-auto">
                        ${room.roomCategory.name} ${room.name}
                    </div>
                    <%-- MENU --%>
                    <div class="col-sm-2 dropdown">
                        <button class="btn <%--dropdown-toggle--%>" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <svg class="bi bi-list" width="4em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M2.5 11.5A.5.5 0 0 1 3 11h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4A.5.5 0 0 1 3 7h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4A.5.5 0 0 1 3 3h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
                            </svg>
                            <span>MENU</span>
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                            <button class="dropdown-item" type="button">
                                <svg class="text-success bi bi-plus-square-fill" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4a.5.5 0 0 0-1 0v3.5H4a.5.5 0 0 0 0 1h3.5V12a.5.5 0 0 0 1 0V8.5H12a.5.5 0 0 0 0-1H8.5V4z"/>
                                </svg>
                                <span class="small ml-2">ADD NEW PRODUCT</span>
                            </button>
                            <a href="/rooms/details/${room.id}?content=info" class="dropdown-item" type="button">
                                <svg class="text-primary bi bi-info-square" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                    <path d="M8.93 6.588l-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588z"/>
                                    <circle cx="8" cy="4.5" r="1"/>
                                </svg>
                                <span class="small ml-2">INFO</span>
                            </a>
                            <a href="/rooms/details/${room.id}?content=productList" class="dropdown-item" type="button">
                                <svg class="bi bi-card-list" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M14.5 3h-13a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h13a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
                                    <path fill-rule="evenodd" d="M5 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 5 8zm0-2.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm0 5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5z"/>
                                    <circle cx="3.5" cy="5.5" r=".5"/>
                                    <circle cx="3.5" cy="8" r=".5"/>
                                    <circle cx="3.5" cy="10.5" r=".5"/>
                                </svg>
                                <span class="small ml-2">PRODUCTS LIST</span>
                            </a>
                            <a href="/rooms/details/${room.id}?content=analysis" class="dropdown-item" type="button">
                                <svg class="text-info bi bi-graph-up" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M0 0h1v16H0V0zm1 15h15v1H1v-1z"/>
                                    <path fill-rule="evenodd" d="M14.39 4.312L10.041 9.75 7 6.707l-3.646 3.647-.708-.708L7 5.293 9.959 8.25l3.65-4.563.781.624z"/>
                                    <path fill-rule="evenodd" d="M10 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-1 0V4h-3.5a.5.5 0 0 1-.5-.5z"/>
                                </svg>
                                <span class="small ml-2">ANALYSIS</span>
                            </a>
                            <div class="dropdown-divider"></div>
                            <button class="dropdown-item" type="button">
                                <svg class="text-danger bi bi-trash" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                    <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                </svg>
                                <span class="small ml-2">DELETE ROOM</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <%-- HEADER 2 --%>
            <div class="card-header">
                <div>
                    <div class="col-sm-12 text-right mt-auto mb-auto">
                        <span>ROOM BUDGET:</span>
                        <fmt:formatNumber
                                type="currency"
                                maxIntegerDigits="12"
                                minIntegerDigits="1"
                                maxFractionDigits="2"
                                minFractionDigits="2"
                                currencySymbol="zł"
                                value="${room.budget}"
                        />
                    </div>
                </div>

            </div>
            <%-- MAIN CONTENT --%>
            <div id="mainContent" class="container">
                <c:set var="costOfProducts" value="${0}"/>
                <c:forEach items="${room.productList}" var="product">
                    <c:set var="costOfProducts" value="${costOfProducts + product.price}"/>
                </c:forEach>
                <c:choose>
                    <c:when test="${content eq 'analysis'}">
<%--                        <c:forEach items="${room.productList}" var="product">--%>
<%--                            <c:set var="costOfProducts" value="${costOfProducts + product.price}"/>--%>
<%--                        </c:forEach>--%>

                        <c:set var="ratioCostOfProductsToHospitalBudget" value="${costOfProducts / room.department.hospital.budget * 100}"/>
                        <c:choose>
                            <c:when test="${ratioCostOfProductsToHospitalBudget > 100}">
                                <c:set var="progressBarHospital" value="bg-danger border border-dark"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToHospitalBudget >= 100}">
                                <c:set var="progressBarHospital" value="bg-danger"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToHospitalBudget < 100 && ratioCostOfProductsToHospitalBudget > 75}">
                                <c:set var="progressBarHospital" value="bg-warning"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToHospitalBudget < 75}">
                                <c:set var="progressBarHospital" value="bg-success"/>
                            </c:when>
                        </c:choose>

                        <c:set var="ratioCostOfProductsToDepartmentBudget" value="${costOfProducts / room.department.budget * 100}"/>
                        <c:choose>
                            <c:when test="${ratioCostOfProductsToDepartmentBudget > 100}">
                                <c:set var="progressBarDepartment" value="bg-danger border border-dark"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToDepartmentBudget == 100}">
                                <c:set var="progressBarDepartment" value="bg-danger"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToDepartmentBudget < 100 && ratioCostOfProductsToDepartmentBudget > 75}">
                                <c:set var="progressBarDepartment" value="bg-warning"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToDepartmentBudget < 75}">
                                <c:set var="progressBarDepartment" value="bg-success"/>
                            </c:when>
                        </c:choose>

                        <c:set var="ratioCostOfProductsToRoomBudget" value="${costOfProducts / room.budget * 100}"/>
                        <c:choose>
                            <c:when test="${ratioCostOfProductsToRoomBudget > 100}">
                                <c:set var="progressBarRoom" value="bg-danger border border-dark"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToRoomBudget == 100}">
                                <c:set var="progressBarRoom" value="bg-danger"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToRoomBudget < 100 && ratioCostOfProductsToRoomBudget > 75}">
                                <c:set var="progressBarRoom" value="bg-warning"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToRoomBudget < 75}">
                                <c:set var="progressBarRoom" value="bg-success"/>
                            </c:when>
                        </c:choose>



                        <div class="m-5">
                            <div class="ml-5 mt-5">COST OF PRODUCTS IN THE ROOM / HOSPITAL BUDGET [%]</div>
                            <div class="progress ml-5 mr-5" style="height: 50px">
                                <div class="progress-bar ${progressBarHospital}" role="progressbar" style="width: ${costOfProducts / room.department.hospital.budget * 100}%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
                                    <p class="position-absolute mt-auto mb-auto text-dark font-weight-bold ml-1">${ratioCostOfProductsToHospitalBudget} %</p>
                                </div>
                            </div>
                            <div class="ml-5 mt-5">COST OF PRODUCTS IN THE ROOM / DEPARTMENT BUDGET [%]</div>
                            <div class="progress ml-5 mr-5" style="height: 50px">
                                <div class="progress-bar ${progressBarDepartment}" role="progressbar" style="width: ${costOfProducts / room.department.budget * 100}%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
                                    <p class="position-absolute mt-auto mb-auto text-dark font-weight-bold ml-3">
                                            ${ratioCostOfProductsToDepartmentBudget} %
                                    </p>
                                </div>
                            </div>
                            <div class="ml-5 mt-5">COST OF PRODUCTS IN THE ROOM / ROOM BUDGET [%]</div>
                            <div class="progress ml-5 mr-5" style="height: 50px">
                                <div class="progress-bar ${progressBarRoom}" role="progressbar" style="width: ${costOfProducts / room.budget * 100}%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
                                    <p class="position-absolute mt-auto mb-auto text-dark font-weight-bold ml-5">
                                            ${ratioCostOfProductsToRoomBudget} %
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:when test="${content eq 'info'}">
                        <div class="row border-bottom">
                            <div class="col-sm-12 p-0">
                                <div class="small m-0 pl-1">MANAGER:</div>
                                <div class="m-0 pl-5 h5">
                                    Lorem Ipsum
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2 p-0">
                                <div class="small m-0 pl-1">AREA:</div>
                                <div class="m-0 pl-5 h5">
                                        ${room.area} <span>m<sup>2</sup></span>
                                </div>
                            </div>
                            <div class="col-sm-2 p-0">
                                <div class="small m-0 pl-1">HEIGHT:</div>
                                <div class="m-0 pl-5 h5">
                                        ${room.height} <span>m</span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2 p-0">
                                <div class="small m-0 pl-1">TEMPERATURE:</div>
                                <div class="m-0 pl-5 h5">
                                        0 <span>&#176;</span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2 p-0">
                                <div class="small m-0 pl-1">LIGHTNING:</div>
                                <div class="m-0 pl-5 h5">
                                    ...
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2 p-0">
                                <div class="small m-0 pl-1">FLOOR:</div>
                                <div class="m-0 pl-5 h5">
                                    ...
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2 p-0">
                                <div class="small m-0 pl-1">CEILING:</div>
                                <div class="m-0 pl-5 h5">
                                    ...
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2 p-0">
                                <div class="small m-0 pl-1">WALLS:</div>
                                <div class="m-0 pl-5 h5">
                                    ...
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="card-body">
                            <div class="row">
                                <div class="col text-center">
                                    PRODUCTS
                                </div>
                            </div>
                        </div>
                        <c:forEach items="${room.productList}" var="product">
                            <div class="card-body">
                                <div class="row hover">
                                    <div class="col-sm-2">
                                        ${product.productCategory.code}
                                    </div>
                                    <div class="col-sm-4">
                                        ${product.productCategory.name}
                                    </div>
                                    <div class="col-sm-2">
                                        ${product.manufacturer.name}
                                    </div>
                                    <div class="col-sm-2">
                                        ${product.modelName}
                                    </div>
                                    <div class="col-sm-2 text-right">
                                        <fmt:formatNumber
                                                type="currency"
                                                maxIntegerDigits="12"
                                                minIntegerDigits="1"
                                                maxFractionDigits="2"
                                                minFractionDigits="2"
                                                currencySymbol="zł"
                                                value="${product.price}"
                                        />
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
            <%-- FOOTER --%>
            <div class="card-footer">
                <div class="row">
                    <div class="col-sm-12 text-right">
                        TOTAL COST OF PRODUCTS:
                        <fmt:formatNumber
                                type="currency"
                                maxIntegerDigits="12"
                                minIntegerDigits="1"
                                maxFractionDigits="2"
                                minFractionDigits="2"
                                currencySymbol="zł"
                                value="${costOfProducts}"
                        />
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>