<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 01.06.2020
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <form:form modelAttribute="department" method="post" action="/departments/new">
    <div class="container">

        <div class="card">

            <%-- DEPARTMENT IN HOSPITAL STRUCTURE --%>
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/hospitals/all">Hospitals</a></li>
                    <li class="breadcrumb-item"><a href="/hospitals/details/${department.hospital.id}">${department.hospital.name}</a></li>
                    <li class="breadcrumb-item"><a href="#">${department.departmentCategory.name}</a></li>
                </ol>
            </nav>

            <%-- HEADER 1 ( DEPARTMENT NO. | CATEGORY | MENU ) --%>
            <div class="card-header">
                <div class="row">
                    <div class="col-sm-2 border-right text-center mt-auto mb-auto h4">
                        <%--${department.number}--%>
                    </div>
                    <div class="col-sm-6 mt-auto mb-auto">
                        <h3>${department.departmentCategory.name}</h3>
                    </div>
                    <%-- MENU --%>
                    <div class="col-sm-2">
                        <c:if test="${param.containsKey('content') && param.containsValue('info')}">
                            <a href="/departments/details/${department.id}?content=info&edit=true" class="btn float-right">
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
                            <a href="/rooms/new?departmentId=${department.id}&backToPage=/departments/details/${department.id}" class="dropdown-item" type="button">
                                <svg class="text-success bi bi-plus-square-fill" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4a.5.5 0 0 0-1 0v3.5H4a.5.5 0 0 0 0 1h3.5V12a.5.5 0 0 0 1 0V8.5H12a.5.5 0 0 0 0-1H8.5V4z"/>
                                </svg>
                                <span class="small ml-2">ADD NEW ROOM</span>
                            </a>
                            <a href="/departments/details/${department.id}?content=info" class="dropdown-item" type="button">
                                <svg class="text-info bi bi-info-square" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                    <path d="M8.93 6.588l-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588z"/>
                                    <circle cx="8" cy="4.5" r="1"/>
                                </svg>
                                <span class="small ml-2">INFO</span>
                            </a>
                            <a href="/departments/details/${department.id}?content=roomList" class="dropdown-item" type="button">
                                <svg class="text-info bi bi-card-list" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M14.5 3h-13a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h13a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
                                    <path fill-rule="evenodd" d="M5 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 5 8zm0-2.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm0 5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5z"/>
                                    <circle cx="3.5" cy="5.5" r=".5"/>
                                    <circle cx="3.5" cy="8" r=".5"/>
                                    <circle cx="3.5" cy="10.5" r=".5"/>
                                </svg>
                                <span class="small ml-2">ROOMS LIST</span>
                            </a>
                            <a href="/departments/details/${department.id}?content=analysis" class="dropdown-item" type="button">
                                <svg class="text-info bi bi-graph-up" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M0 0h1v16H0V0zm1 15h15v1H1v-1z"/>
                                    <path fill-rule="evenodd" d="M14.39 4.312L10.041 9.75 7 6.707l-3.646 3.647-.708-.708L7 5.293 9.959 8.25l3.65-4.563.781.624z"/>
                                    <path fill-rule="evenodd" d="M10 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-1 0V4h-3.5a.5.5 0 0 1-.5-.5z"/>
                                </svg>
                                <span class="small ml-2">ANALYSIS</span>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a href="/departments/delete/${department.id}?backToPage=/hospitals/all" class="dropdown-item" type="button">
                                <svg class="text-danger bi bi-trash" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                    <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                </svg>
                                <span class="small ml-2">DELETE DEPARTMENT</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <%-- HEADER 2 ( BUDGET INFO ) --%>
                <div class="card-header">
                    <div>
                        <div class="col-sm-12 text-right mt-auto mb-auto">
                            <c:set var="costOfRooms" value="${0}"/>
                            <c:forEach items="${department.roomList}" var="room">
                                <c:forEach items="${room.productList}" var="product">
                                    <c:set var="costOfRooms" value="${costOfRooms + product.price}"/>
                                </c:forEach>
                            </c:forEach>
                            <span>DEPARTMENT INITIAL BUDGET:</span>
                            <fmt:formatNumber
                                    type="currency"
                                    maxIntegerDigits="12"
                                    minIntegerDigits="1"
                                    maxFractionDigits="2"
                                    minFractionDigits="2"
                                    currencySymbol="zł"
                                    value="${department.budget+costOfRooms}"
                            />
                            <br>
                            <span>DEPARTMENT ACTUAL BUDGET:</span>
                            <fmt:formatNumber
                                    type="currency"
                                    maxIntegerDigits="12"
                                    minIntegerDigits="1"
                                    maxFractionDigits="2"
                                    minFractionDigits="2"
                                    currencySymbol="zł"
                                    value="${department.budget}"
                            />
                        </div>
                    </div>

                </div>
                <%-- MAIN CONTENT --%>
                <div id="mainContent" class="container">
                    <!-- SUB-PAGES -->
                    <c:choose>
<%--                        <c:when test="${content eq 'analysis'}">--%>
                        <c:when test="${param.get('content') ne null && param.get('content').toString() eq 'analysis'}">

                            <c:set var="ratioCostOfProductsToHospitalBudget" value="${costOfRooms / (department.hospital.budget+costOfRooms) * 100}"/>
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

                            <c:set var="ratioCostOfProductsToDepartmentBudget" value="${costOfRooms / (department.budget+costOfRooms) * 100}"/>
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

                            <div class="m-5">
                                <div class="ml-5 mt-5">COST OF PRODUCTS IN THIS DEPARTMENT / HOSPITAL INITIAL BUDGET [%]</div>
                                <div class="progress ml-5 mr-5" style="height: 50px">
                                    <div class="progress-bar ${progressBarHospital}" role="progressbar" style="width: ${costOfRooms / (department.hospital.budget+costOfRooms) * 100}%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
                                        <p class="position-absolute mt-auto mb-auto text-dark font-weight-bold ml-1">${ratioCostOfProductsToHospitalBudget} %</p>
                                    </div>
                                </div>
                                <div class="ml-5 mt-5">COST OF PRODUCTS IN THIS DEPARTMENT / DEPARTMENT INITIAL BUDGET [%]</div>
                                <div class="progress ml-5 mr-5" style="height: 50px">
                                    <div class="progress-bar ${progressBarDepartment}" role="progressbar" style="width: ${costOfRooms / (department.budget+costOfRooms) * 100}%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
                                        <p class="position-absolute mt-auto mb-auto text-dark font-weight-bold ml-2">
                                                ${ratioCostOfProductsToDepartmentBudget} %
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </c:when>

                        <c:when test="${param.containsKey('content') && param.get('content').toString() eq 'info'}">

                            <c:if test="${param.containsKey('edit')}">
                                <form:hidden path="id"/>
                                <form:hidden path="name"/>
                                <form:hidden path="budget"/>
                                <form:hidden path="hospital.id"/>
                                <form:hidden path="departmentCategory.id"/>
                                <%--<form:hidden path="productList"/>--%>
                                <c:forEach items="${department.roomList}" var="room">
                                    <form:hidden path="roomList" value="${room.id}" checked="checked"/>
                                </c:forEach>
                                <input type="hidden" name="backToPage" value="/departments/details/${department.id}?content=info">
                                <div class="row mt-2">
                                    <div class="col-sm-12">
                                        <a href="/departments/details/${department.id}?content=info" class="btn btn-outline-warning float-left d-inline-block">
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
                                                    ${department.userManager.nameFirst} ${department.userManager.nameLast}
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-3 p-0">
                                        <div class="myTitleSmall small m-0 pl-1">AREA PLANNED:</div>
                                        <div class="mt-2 mb-2 h5 text-center">
                                            <c:choose>
                                                <c:when test="${param.containsKey('edit')}">
                                                    <form:input path="area" cssClass="w-75"/> <span>m<sup>2</sup></span>
                                                </c:when>
                                                <c:otherwise>
                                                    ${department.area} <span>m<sup>2</sup></span>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                    <div class="col-sm-3 p-0">
                                        <div class="myTitleSmall small m-0 pl-1">AREA USED BY ROOMS:</div>
                                        <div class="mt-2 mb-2 h5 text-center">
                                            <c:set var="areaOfRooms" value="${0}"/>
                                            <c:forEach items="${department.roomList}" var="room">
                                                <c:set var="areaOfRooms" value="${areaOfRooms+room.area}"/>
                                            </c:forEach>
                                            <c:set var="areaUsedTextColor" value="text-dark"/>
                                            <c:choose>
                                                <c:when test="${areaOfRooms > department.area}">
                                                    <c:set var="areaUsedTextColor" value="text-danger"/>
                                                </c:when>
                                            </c:choose>
                                            <span class="${areaUsedTextColor}">${areaOfRooms} <span>m<sup>2</sup></span></span>
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
                                                    ${department.remarks}
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col text-center">
                                        LIST OF ROOMS INSIDE THE DEPARTMENT
                                    </div>
                                </div>
                            </div>
                            <c:forEach items="${department.roomList}" var="room">
                                <div class="card-body">
                                        <div class="row border-top pt-3">
                                        <%--<a href="/rooms/details/${room.id}" class="col-sm-2">
                                                ${room.number}
                                        </a>--%>
                                        <a href="/rooms/details/${room.id}" class="col-sm-10">
                                                ${room.roomCategory.name}
                                        </a>
                                        <%--<div class="col-sm-4">
                                                ${room.name}
                                        </div>--%>
                                        <div class="col-sm-2 text-right">
                                            <c:set var="costOfRoom" value="${0}"/>
                                            <c:forEach items="${room.productList}" var="product">
                                                <c:set var="costOfRoom" value="${costOfRoom + product.price}"/>
                                            </c:forEach>
                                            <fmt:formatNumber
                                                    type="currency"
                                                    maxIntegerDigits="12"
                                                    minIntegerDigits="1"
                                                    maxFractionDigits="2"
                                                    minFractionDigits="2"
                                                    currencySymbol="zł"
                                                    value="${costOfRoom}"
                                            />
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-sm-8"></div>
                                        <div class="col-sm-1"><%--ROOM INFO --%>
                                            <svg class="bi bi-info-square" width="25px" height="25px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                                <path d="M8.93 6.588l-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588z"/>
                                                <circle cx="8" cy="4.5" r="1"/>
                                            </svg>
                                        </div>
                                        <div href="#/rooms/changeProduct?roomId=${department.id}&productId=${product.id}&category=${product.productCategory.code}"  class="col-sm-1"> <%--CHANGE ROOM FROM THE SAME CATEGORY --%>
                                            <svg class="bi bi-arrow-left-right" width="25px" height="25px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd" d="M10.146 7.646a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L12.793 11l-2.647-2.646a.5.5 0 0 1 0-.708z"/>
                                                <path fill-rule="evenodd" d="M2 11a.5.5 0 0 1 .5-.5H13a.5.5 0 0 1 0 1H2.5A.5.5 0 0 1 2 11zm3.854-9.354a.5.5 0 0 1 0 .708L3.207 5l2.647 2.646a.5.5 0 1 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 0 1 .708 0z"/>
                                                <path fill-rule="evenodd" d="M2.5 5a.5.5 0 0 1 .5-.5h10.5a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
                                            </svg>
                                        </div>
                                        <a href="/rooms/delete/${room.id}?backToPage=/departments/details/${department.id}" class="col-sm-1"><%--DEL ROOM --%>
                                            <svg class="bi bi-x-square" width="25px" height="25px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                                <path fill-rule="evenodd" d="M11.854 4.146a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708-.708l7-7a.5.5 0 0 1 .708 0z"/>
                                                <path fill-rule="evenodd" d="M4.146 4.146a.5.5 0 0 0 0 .708l7 7a.5.5 0 0 0 .708-.708l-7-7a.5.5 0 0 0-.708 0z"/>
                                            </svg>
                                        </a>
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
                        TOTAL COST OF ROOMS:
                        <fmt:formatNumber
                                type="currency"
                                maxIntegerDigits="12"
                                minIntegerDigits="1"
                                maxFractionDigits="2"
                                minFractionDigits="2"
                                currencySymbol="zł"
                                value="${costOfRooms}"
                        />
                    </div>
                </div>
            </div>
        </div>

    </div>

    </form:form>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
