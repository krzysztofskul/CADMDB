<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <form:form modelAttribute="room" method="post" action="/rooms/new">
    <div class="container">
        <div class="card">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/hospitals/all">Hospitals</a></li>
                    <li class="breadcrumb-item"><a href="/hospitals/details/${room.department.hospital.id}" >${room.department.hospital.name}</a></li>
                    <li class="breadcrumb-item"><a href="/departments/details/${room.department.id}">${room.department.departmentCategory.name}</a></li>
                    <li class="breadcrumb-item active" aria-current="page">${room.number} ${room.roomCategory.name} ${room.name}</li>
                </ol>
            </nav>
            <%-- HEADER 1 --%>
            <div class="card-header">
                <div class="row">
                    <div class="col-sm-2 border-right text-center mt-auto mb-auto">
                        <div class="myTitleSmall">ROOM NUMBER</div>
                        <h3>${room.number}</h3>
                    </div>
                    <div class="col-sm-6 mt-auto mb-auto">
                        <div class="myTitleSmall">ROOM CATEGORY NAME</div>
                        <h3>${room.roomCategory.name}</h3>
                    </div>
                    <%-- MENU --%>
                    <div class="col-sm-2">
                        <c:if test="${param.containsKey('content') && param.containsValue('info')}">
                        <a href="/rooms/details/${room.id}?content=info&edit=true" class="btn float-right">
                            <span>EDIT</span><br>
                            <svg class="bi bi-pencil" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M11.293 1.293a1 1 0 0 1 1.414 0l2 2a1 1 0 0 1 0 1.414l-9 9a1 1 0 0 1-.39.242l-3 1a1 1 0 0 1-1.266-1.265l1-3a1 1 0 0 1 .242-.391l9-9zM12 2l2 2-9 9-3 1 1-3 9-9z"/>
                                <path fill-rule="evenodd" d="M12.146 6.354l-2.5-2.5.708-.708 2.5 2.5-.707.708zM3 10v.5a.5.5 0 0 0 .5.5H4v.5a.5.5 0 0 0 .5.5H5v.5a.5.5 0 0 0 .5.5H6v-1.5a.5.5 0 0 0-.5-.5H5v-.5a.5.5 0 0 0-.5-.5H3z"/>
                            </svg>
                        </a>
                        </c:if>
                    </div>
                    <div class="col-sm-2 dropdown p-0 m-0 float-right">
                        <button class="btn <%--dropdown-toggle--%>" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span>MENU</span><br>
                            <svg class="bi bi-list" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M2.5 11.5A.5.5 0 0 1 3 11h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4A.5.5 0 0 1 3 7h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4A.5.5 0 0 1 3 3h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
                            </svg>

                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                            <a href="/rooms/addProduct?roomId=${room.id}&backToPage=/rooms/details/${room.id}" class="dropdown-item" type="button">
                                <svg class="text-success bi bi-plus-square-fill" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4a.5.5 0 0 0-1 0v3.5H4a.5.5 0 0 0 0 1h3.5V12a.5.5 0 0 0 1 0V8.5H12a.5.5 0 0 0 0-1H8.5V4z"/>
                                </svg>
                                <span class="small ml-2">ADD NEW PRODUCT</span>
                            </a>
                            <a href="/rooms/details/${room.id}?content=info" class="dropdown-item" type="button">
                                <svg class="text-info bi bi-info-square" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                    <path d="M8.93 6.588l-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588z"/>
                                    <circle cx="8" cy="4.5" r="1"/>
                                </svg>
                                <span class="small ml-2">INFO</span>
                            </a>
                            <a href="/rooms/details/${room.id}?content=productList" class="dropdown-item" type="button">
                                <svg class="text-info bi bi-card-list" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
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
                            <a href="/rooms/delete/${room.id}?backToPage=/departments/details/${room.department.id}" class="dropdown-item" type="button">
                                <svg class="text-danger bi bi-trash" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                    <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                </svg>
                                <span class="small ml-2">DELETE ROOM</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <%-- HEADER 2 --%>
            <div class="card-header">
                <div>
                    <div class="col-sm-12 text-right mt-auto mb-auto">
                        <c:set var="costOfProducts" value="${0}"/>
                        <c:set var="weightOfProducts" value="${0}"/>
                        <c:set var="powerConnectionNeededOfProducts" value="${0}"/>
                        <c:forEach items="${room.productList}" var="product">
                            <c:set var="costOfProducts" value="${costOfProducts + product.price}"/>
                            <c:set var="weightOfProducts" value="${weightOfProducts + product.weight}"/>
                            <c:set var="powerConnectionNeededOfProducts" value="${powerConnectionNeededOfProducts + product.powerConnectionNeeded}"/>
                        </c:forEach>
                        <div class="row">
                            <div class="col-sm-12">
                                <span>ROOM INITIAL BUDGET:</span>
                                <fmt:formatNumber
                                        type="currency"
                                        maxIntegerDigits="12"
                                        minIntegerDigits="1"
                                        maxFractionDigits="2"
                                        minFractionDigits="2"
                                        currencySymbol="zł"
                                        value="${room.budget+costOfProducts}"
                                />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-8">
                                <span>COST OF PRODUCTS:</span>
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
                            <div class="col-sm-4">
                                <span>ROOM ACTUAL BUDGET:</span>
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
                </div>

            </div>
            <%-- MAIN CONTENT --%>
            <div id="mainContent" class="container">
                <!-- SUB-PAGES -->
                <c:choose>
                    <c:when test="${content eq 'analysis'}">

                        <c:set var="ratioCostOfProductsToHospitalBudget" value="${costOfProducts / (room.department.hospital.budget+costOfProducts) * 100}"/>
                        <c:choose>
                            <c:when test="${ratioCostOfProductsToHospitalBudget > 100}">
                                <c:set var="progressBarHospital" value="bg-danger"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToHospitalBudget.toString() eq '100.00'}">
                                <c:set var="progressBarHospital" value="bg-warning border border-danger"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToHospitalBudget < 100 && ratioCostOfProductsToHospitalBudget > 75}">
                                <c:set var="progressBarHospital" value="bg-warning"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToHospitalBudget < 75}">
                                <c:set var="progressBarHospital" value="bg-success"/>
                            </c:when>
                            <c:otherwise>
                                <c:set var="progressBarHospital" value="bg-info"/>
                            </c:otherwise>
                        </c:choose>

                        <c:set var="ratioCostOfProductsToDepartmentBudget" value="${costOfProducts / (room.department.budget+costOfProducts) * 100}"/>
                        <c:choose>
                            <c:when test="${ratioCostOfProductsToDepartmentBudget > 100}">
                                <c:set var="progressBarDepartment" value="bg-danger"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToDepartmentBudget.toString() eq '100.00'}">
                                <c:set var="progressBarDepartment" value="bg-warning border border-danger"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToDepartmentBudget < 100 && ratioCostOfProductsToDepartmentBudget > 75}">
                                <c:set var="progressBarDepartment" value="bg-warning"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToDepartmentBudget < 75}">
                                <c:set var="progressBarDepartment" value="bg-success"/>
                            </c:when>
                            <c:otherwise>
                                <c:set var="progressBarDepartment" value="bg-info"/>
                            </c:otherwise>
                        </c:choose>

                        <c:set var="ratioCostOfProductsToRoomBudget" value="${costOfProducts / (room.budget+costOfProducts) * 100}"/>
                        <c:choose>
                            <c:when test="${ratioCostOfProductsToRoomBudget > 100}">
                                <c:set var="progressBarRoom" value="bg-danger"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToRoomBudget.toString() eq '100.00'}">
                                <c:set var="progressBarRoom" value="bg-warning border border-danger"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToRoomBudget < 100 && ratioCostOfProductsToRoomBudget > 75}">
                                <c:set var="progressBarRoom" value="bg-warning"/>
                            </c:when>
                            <c:when test="${ratioCostOfProductsToRoomBudget < 75}">
                                <c:set var="progressBarRoom" value="bg-success"/>
                            </c:when>
                            <c:otherwise>
                                <c:set var="progressBarRoom" value="bg-info"/>
                            </c:otherwise>
                        </c:choose>



                        <div class="m-5">
                            <div class="ml-5 mt-5">COST OF PRODUCTS IN THIS ROOM / HOSPITAL INITIAL BUDGET [%]</div>
                            <div class="progress ml-5 mr-5" style="height: 50px">
                                <div class="progress-bar ${progressBarHospital}" role="progressbar" style="width: ${costOfProducts / (room.department.hospital.budget+costOfProducts) * 100}%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
                                    <p class="position-absolute mt-auto mb-auto text-dark font-weight-bold ml-1">${ratioCostOfProductsToHospitalBudget} %</p>
                                </div>
                            </div>
                            <div class="ml-5 mt-5">COST OF PRODUCTS IN THIS ROOM / DEPARTMENT INITIAL BUDGET [%]</div>
                            <div class="progress ml-5 mr-5" style="height: 50px">
                                <div class="progress-bar ${progressBarDepartment}" role="progressbar" style="width: ${costOfProducts / (room.department.budget+costOfProducts) * 100}%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
                                    <p class="position-absolute mt-auto mb-auto text-dark font-weight-bold ml-2">
                                            ${ratioCostOfProductsToDepartmentBudget} %
                                    </p>
                                </div>
                            </div>
                            <div class="ml-5 mt-5">COST OF PRODUCTS IN THIS ROOM / ROOM INITIAL BUDGET [%]</div>
                            <div class="progress ml-5 mr-5" style="height: 50px">
                                <div class="progress-bar ${progressBarRoom}" role="progressbar" style="width: ${costOfProducts / (room.budget+costOfProducts) * 100}%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
                                    <p class="position-absolute mt-auto mb-auto text-dark font-weight-bold ml-3">
                                            ${ratioCostOfProductsToRoomBudget} %
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:when test="${content eq 'info'}">
                        <c:if test="${param.containsKey('edit')}">
                            <form:hidden path="id"/>
                            <form:hidden path="name"/>
                            <form:hidden path="budget"/>
                            <form:hidden path="number"/>
                            <form:hidden path="fullPath"/>
                            <form:hidden path="department.id"/>
                            <form:hidden path="roomCategory.id"/>
                            <%--<form:hidden path="productList"/>--%>
                            <c:forEach items="${room.productList}" var="product">
                                <form:hidden path="productList" value="${product.id}" checked="checked"/>
                            </c:forEach>
                            <input type="hidden" name="backToPage" value="/rooms/details/${room.id}?content=info">
                            <div class="row mt-2">
                                <div class="col-sm-12">
                                    <a href="/rooms/details/${room.id}?content=info" class="btn btn-outline-warning float-left d-inline-block">
                                        CANCEL
                                    </a>
                                    <form:button class="btn btn-outline-success float-right d-inline-block">
                                        SAVE
                                    </form:button>
                                </div>
                            </div>
                        </c:if>
                        <div class="generalInfo">
                            <div class="row border-bottom pb-2">
                                <c:choose>
                                    <c:when test="${param.containsKey('edit')}">
                                        <form:select path="organizationStatus.id" cssClass="w-100">
                                            <c:forEach items="${organizationStatusList}" var="organizationStatus">
                                                <form:option value="${organizationStatus.id}" label="${organizationStatus.toString()}"/>
                                            </c:forEach>
                                        </form:select>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="col-sm-12 p-0">
                                            <div class="myTitleSmall">STATUS</div>
                                            <div>${room.organizationStatus.toString()}</div>
                                        </div>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                            <div class="row border-bottom pb-2">
                                <div class="col-sm-12 p-0">
                                    <div class="myTitleSmall small m-0 pl-1">MANAGER:</div>
                                    <div class="mt-2 mb-2 h5">
                                        <c:choose>
                                            <c:when test="${param.containsKey('edit')}">
                                                <form:select path="userManager.id" cssClass="w-100">
                                                    <c:forEach items="${userHospitalManagerList}" var="user">
                                                        <form:option value="${user.id}" label="${user.nameFirst} ${user.nameLast}"/>
                                                    </c:forEach>
                                                </form:select>
                                            </c:when>
                                            <c:otherwise>
                                                ${room.userManager.nameFirst} ${room.userManager.nameLast}
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-2 p-0">
                                    <div class="myTitleSmall small m-0 pl-1">AREA:</div>
                                    <div class="mt-2 mb-2 h5 text-center">
                                        <c:choose>
                                            <c:when test="${param.containsKey('edit')}">
                                                <form:input path="area" cssClass="w-75"/> <span>m<sup>2</sup></span>
                                            </c:when>
                                            <c:otherwise>
                                                ${room.area} <span>m<sup>2</sup></span>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                                <div class="col-sm-2 p-0 border-left border-right">
                                    <div class="myTitleSmall small m-0 pl-1">HEIGHT:</div>
                                    <div class="mt-2 mb-2 h5 text-center">
                                        <c:choose>
                                            <c:when test="${param.containsKey('edit')}">
                                                <form:input path="height" cssClass="w-75"/> <span>m</span>
                                            </c:when>
                                            <c:otherwise>
                                                ${room.height} <span>m</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                                <div class="col-sm-2 p-0 border-left border-right">
                                    <div class="myTitleSmall small m-0 pl-1">TEMPERATURE:</div>
                                    <div class="mt-2 mb-2 h5 text-center">
                                        <c:choose>
                                            <c:when test="${param.containsKey('edit')}">
                                                <form:input path="temperature" cssClass="w-75"/> <span>&#176;</span>
                                            </c:when>
                                            <c:otherwise>
                                                ${room.temperature} <span>&#176;</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                                <div class="col-sm-2 p-0 border-left border-right">
                                    <div class="myTitleSmall small m-0 pl-1">ILLUMINATION:</div>
                                    <div class="mt-2 mb-2 h5 text-center">
                                        <c:choose>
                                            <c:when test="${param.containsKey('edit')}">
                                                <form:input path="illumination" cssClass="w-75"/> <span>LUX</span>
                                            </c:when>
                                            <c:otherwise>
                                                ${room.illumination} <span>LUX</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                                <div class="col-sm-2 p-0 border-left border-right">
                                    <div class="myTitleSmall small m-0 pl-1">AIR CHANGES:</div>
                                    <div class="mt-2 mb-2 h5 text-center">
                                        <c:choose>
                                            <c:when test="${param.containsKey('edit')}">
                                                <form:input path="airChanges" cssClass="w-75"/> <span>per Hour</span>
                                            </c:when>
                                            <c:otherwise>
                                                ${room.airChanges} <span>per Hour</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                                <div class="col-sm-2 p-0 border-left">
                                    <div class="myTitleSmall small m-0 pl-1">AIR CONDITIONING:</div>
                                    <div class="mt-2 mb-2 h5 text-center">
                                        <c:choose>
                                            <c:when test="${param.containsKey('edit')}">
                                                <form:checkbox path="airConditioning" cssClass="w-75"/>
                                            </c:when>
                                            <c:otherwise>
                                                <c:if test="${room.airConditioning eq true}">
                                                    YES
                                                </c:if>
                                                <c:if test="${room.airConditioning ne true}">
                                                    NO
                                                </c:if>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 p-0">
                                    <div class="myTitleSmall small m-0 pl-1">FLOOR:</div>
                                    <div class="mt-2 mb-2 h5 text-justify">
                                        <c:choose>
                                            <c:when test="${param.containsKey('edit')}">
                                                <form:textarea path="floor" cssClass="w-100"/>
                                            </c:when>
                                            <c:otherwise>
                                                ${room.floor}
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 p-0">
                                    <div class="myTitleSmall small m-0 pl-1">CEILING:</div>
                                    <div class="mt-2 mb-2 h5 text-justify">
                                        <c:choose>
                                            <c:when test="${param.containsKey('edit')}">
                                                <form:textarea path="ceiling" cssClass="w-100"/>
                                            </c:when>
                                            <c:otherwise>
                                                ${room.ceiling}
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 p-0">
                                    <div class="myTitleSmall small m-0 pl-1">WALLS:</div>
                                    <div class="mt-2 mb-2 h5 text-justify">
                                        <c:choose>
                                            <c:when test="${param.containsKey('edit')}">
                                                <form:textarea path="walls" cssClass="w-100"/>
                                            </c:when>
                                            <c:otherwise>
                                                ${room.walls}
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 p-0">
                                    <div class="myTitleSmall small m-0 pl-1">REMARKS:</div>
                                    <div class="mt-2 mb-2 h5 text-justify">
                                        <c:choose>
                                            <c:when test="${param.containsKey('edit')}">
                                                <form:textarea path="remarks" cssClass="w-100"/>
                                            </c:when>
                                            <c:otherwise>
                                                ${room.remarks}
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise> <%-- info page --%>
                        <div class="card-body">
                            <div class="row">
                                <div class="col text-center">
                                    PRODUCTS
                                </div>
                            </div>
                        </div>
                        <c:forEach items="${room.productList}" var="product">
                            <div class="card-body">
                                <div class="row h4 border-top border-bottom bg-light">
                                    <div class="col-sm-2">
                                        ${product.productCategory.code}
                                    </div>
                                    <div class="col-sm-10">
                                        ${product.productCategory.nameSingular}
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <div class="myTitleSmall">MANUFACTURER</div>
                                        <h4>${product.manufacturer.name}</h4>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="myTitleSmall">MODEL</div>
                                        <h4>${product.modelName}</h4>
                                    </div>
                                    <div class="col-sm-3 text-center">
                                        <div class="myTitleSmall">ACTIONS</div>
                                        <div>
                                            <a href="#" class="col-sm-1 disabled"> <%--PRODUCT INFO --%>
                                                <svg class="bi bi-info-square" width="25px" height="25px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                    <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                                    <path d="M8.93 6.588l-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588z"/>
                                                    <circle cx="8" cy="4.5" r="1"/>
                                                </svg>
                                            </a>
                                            <a href="/rooms/changeProduct?roomId=${room.id}&productId=${product.id}&category=${product.productCategory.code}"  class="col-sm-1"> <%--CHANGE PRODUCT FROM THE SAME CATEGORY --%>
                                                <svg class="bi bi-arrow-left-right" width="25px" height="25px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                    <path fill-rule="evenodd" d="M10.146 7.646a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L12.793 11l-2.647-2.646a.5.5 0 0 1 0-.708z"/>
                                                    <path fill-rule="evenodd" d="M2 11a.5.5 0 0 1 .5-.5H13a.5.5 0 0 1 0 1H2.5A.5.5 0 0 1 2 11zm3.854-9.354a.5.5 0 0 1 0 .708L3.207 5l2.647 2.646a.5.5 0 1 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 0 1 .708 0z"/>
                                                    <path fill-rule="evenodd" d="M2.5 5a.5.5 0 0 1 .5-.5h10.5a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
                                                </svg>
                                            </a>
                                            <a href="/rooms/delete/${room.id}/${product.id}?backToPage=rooms/details/${room.id}" class="col-sm-1 text-danger"><%--DEL PRODUCT --%>
                                                <svg class="bi bi-x-square" width="25px" height="25px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                    <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                                    <path fill-rule="evenodd" d="M11.854 4.146a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708-.708l7-7a.5.5 0 0 1 .708 0z"/>
                                                    <path fill-rule="evenodd" d="M4.146 4.146a.5.5 0 0 0 0 .708l7 7a.5.5 0 0 0 .708-.708l-7-7a.5.5 0 0 0-.708 0z"/>
                                                </svg>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 border-top">
                                        Cost:
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
                                <div class="row">
                                    <div class="col-sm-6">
                                        Weight: ${product.weight} kg
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6">
                                        Installation type: ${product.installationType.toString()}
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        Power connection: ${product.powerConnectionNeeded} W
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
                    <div class="col-sm-10 text-right">
                        TOTAL COST OF PRODUCTS IN THIS ROOM:
                    </div>
                    <div class="col-sm-2">
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
                    <div class="col-sm-10 text-right">
                        TOTAL WEIGHT OF PRODUCTS IN THIS ROOM:
                    </div>
                    <div class="col-sm-2">
                    <fmt:formatNumber
                                type="number"
                                maxIntegerDigits="12"
                                minIntegerDigits="1"
                                maxFractionDigits="0"
                                minFractionDigits="0"
                                value="${weightOfProducts}"
                        /> kg
                    </div>
                    <div class="col-sm-10 text-right">
                        TOTAL POWER CONNECTION NEEDED FOR PRODUCTS IN THIS ROOM:
                    </div>
                    <div class="col-sm-2">
                        <fmt:formatNumber
                                type="number"
                                maxIntegerDigits="12"
                                minIntegerDigits="1"
                                maxFractionDigits="0"
                                minFractionDigits="0"
                                value="${powerConnectionNeededOfProducts}"
                        /> W
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form:form>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
