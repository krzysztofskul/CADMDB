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

    <form:form modelAttribute="hospital" method="post" action="/hospitals/details/">
        <div class="container">

            <%-- CHECK THE USER'S CATEGORY --%>

            <c:set var="userCategoryList" value="${sessionScope.userLoggedIn.userCategoryList}" scope="session"/>
            <c:set var="isUserLoggadInInvestor" value="false"/>

            <c:forEach items="${userCategoryList}" var="userCategory">
                <c:if test="${userCategory.code eq 'INVESTOR' || userCategory.code eq 'INVESTOR (GUEST)'}">
                    <c:set var="isUserLoggadInInvestor" value="true"/>
                </c:if>
            </c:forEach>

            <%----%>

            <div class="card">

                <%-- HOSPITAL STRUCTURE --%>
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/hospitals/all">Hospitals</a></li>
                        <li class="breadcrumb-item"><a href="#">${hospital.name}</a></li>
                    </ol>
                </nav>

                <%-- HEADER 1 ( HOSPITAL NAME | MENU ) --%>
                <div class="card-header">
                    <div class="row">
                        <%-- HOSPITAL NAME ETC. --%>
                        <div class="col-sm-1 border-right text-center mt-auto mb-auto h4">
                            <%--${hospital.number}--%>
                        </div>
                        <div class="col-sm-6 mt-auto mb-auto">
                            <c:choose>
                                <c:when test="${param.containsKey('edit')}">
                                    <form:hidden path="id"/>
                                    <form:hidden path="investor.id"/>
                                    <h4><form:input path="name"/></h4>
                                    <c:forEach items="${validationErrors}" var="validationError">
                                        <c:if test="${validationError.field eq 'name'}">
                                            <p class="text-danger font-italic">${validationError.defaultMessage}</p>
                                        </c:if>
                                    </c:forEach>
                                    <p class="text-danger font-italic"><form:errors path="name"/></p>
                                    <h6><form:input path="country" cssClass="w-25"/>, <form:input path="postalCode" cssClass="w-25"/> <form:input path="city" cssClass="w-25"/></h6>
                                    <c:forEach items="${validationErrors}" var="validationError">
                                        <c:if test="${validationError.field eq 'country'}">
                                            <p class="text-danger font-italic">${validationError.defaultMessage}</p>
                                        </c:if>
                                        <c:if test="${validationError.field eq 'city'}">
                                            <p class="text-danger font-italic">${validationError.defaultMessage}</p>
                                        </c:if>
                                    </c:forEach>
                                    <h6><form:input path="street"/> street, No. <form:input path="streetNo" cssClass="w-25"/></h6>
                                    <h6><span class="d-inline-block" style="width: 50px">&#9742;: </span><form:input path="phone"/></h6>
                                    <h6><span class="d-inline-block" style="width: 50px">@: </span><form:input path="email"/></h6>
                                    <h6><span class="d-inline-block" style="width: 50px">WEB: </span><form:input path="www"/></h6>
                                </c:when>
                                <c:otherwise>
                                    <h4>${hospital.name}</h4>
                                    <h6>${hospital.country}, ${hospital.postalCode} ${hospital.city}</h6>
                                    <h6>${hospital.street} street, No. ${hospital.streetNo}</h6>
                                    <h6>&#9742;: ${hospital.phone}</h6>
                                    <h6>@: ${hospital.email}</h6>
                                    <h6>WEB: ${hospital.www}</h6>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <%-- MENU --%>
                        <div class="col-sm-3">
                            <c:if test="${param.containsKey('content') && param.containsValue('info') || !param.get('contains')}">
                                <a href="/hospitals/details/${hospital.id}?content=info&edit=true&editUsers=true" class="btn float-right">
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
                                <a href="/departments/new?hospitalId=${hospital.id}&backToPage=/hospitals/details/${hospital.id}" class="dropdown-item" type="button">
                                    <svg class="text-success bi bi-plus-square-fill" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4a.5.5 0 0 0-1 0v3.5H4a.5.5 0 0 0 0 1h3.5V12a.5.5 0 0 0 1 0V8.5H12a.5.5 0 0 0 0-1H8.5V4z"/>
                                    </svg>
                                    <span class="small ml-2">ADD NEW DEPARTMENT</span>
                                </a>
                                <a href="/hospitals/details/${hospital.id}?content=info" class="dropdown-item" type="button">
                                    <svg class="text-info bi bi-info-square" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                        <path d="M8.93 6.588l-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588z"/>
                                        <circle cx="8" cy="4.5" r="1"/>
                                    </svg>
                                    <span class="small ml-2">INFO</span>
                                </a>
                                <a href="/hospitals/details/${hospital.id}?content=departmentList" class="dropdown-item" type="button">
                                    <svg class="text-info bi bi-card-list" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M14.5 3h-13a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h13a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
                                        <path fill-rule="evenodd" d="M5 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 5 8zm0-2.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm0 5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5z"/>
                                        <circle cx="3.5" cy="5.5" r=".5"/>
                                        <circle cx="3.5" cy="8" r=".5"/>
                                        <circle cx="3.5" cy="10.5" r=".5"/>
                                    </svg>
                                    <span class="small ml-2">DEPARTMENTS LIST</span>
                                </a>
                                <a href="/hospitals/details/${hospital.id}?content=analysis" class="dropdown-item" type="button">
                                    <svg class="text-info bi bi-graph-up" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M0 0h1v16H0V0zm1 15h15v1H1v-1z"/>
                                        <path fill-rule="evenodd" d="M14.39 4.312L10.041 9.75 7 6.707l-3.646 3.647-.708-.708L7 5.293 9.959 8.25l3.65-4.563.781.624z"/>
                                        <path fill-rule="evenodd" d="M10 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-1 0V4h-3.5a.5.5 0 0 1-.5-.5z"/>
                                    </svg>
                                    <span class="small ml-2">ANALYSIS</span>
                                </a>
                                <div class="dropdown-divider"></div>
                                <a href="/hospitals/delete/${hospital.id}" class="dropdown-item" type="button">
                                    <svg class="text-danger bi bi-trash" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                        <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                    </svg>
                                    <span class="small ml-2">DELETE HOSPITAL</span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <c:if test="${param.get('content') ne null && param.get('content').toString() eq 'info' || !param.containsKey('content')}">
                <%-- AREA / BUDGET ETC.  --%>
                <div class="card-header">
                    <div class="row">
                        <div class="col-sm-2 p-0 border-right">
                            <div class="myTitleSmall small m-0 pl-1">AREA:</div>
                            <div class="mt-2 mb-2 h5 text-center">
                                <c:choose>
                                    <c:when test="${param.containsKey('edit')}">
                                        <form:input path="area" cssClass="w-75"/> <span>m<sup>2</sup></span>
                                        <p class="text-danger font-italic"><form:errors path="area"/></p>
                                        <c:forEach items="${validationErrors}" var="validationError">
                                            <c:if test="${validationError.field eq 'area'}">
                                                <p class="text-danger font-italic">${validationError.defaultMessage}</p>
                                            </c:if>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        ${hospital.area} <span>m<sup>2</sup></span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                        <div class="col-sm-3 p-0 border-right">
                            <div class="myTitleSmall small m-0 pl-1">INITIAL BUDGET:</div>
                            <div class="mt-2 mb-2 h5 text-center">
                                <c:choose>
                                    <c:when test="${param.containsKey('edit')}">
                                        <form:input path="budget" cssClass="w-75"/> <span>m<sup>2</sup></span>
                                    </c:when>
                                    <c:otherwise>
                                        <fmt:formatNumber
                                                type="currency"
                                                maxIntegerDigits="12"
                                                minIntegerDigits="1"
                                                maxFractionDigits="2"
                                                minFractionDigits="2"
                                                currencySymbol="zł"
                                                value="${hospital.budget}"
                                        />
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </div>
                <%-- REMARKS --%>
                <div class="card-header">
                    <div class="row">
                    <div class="col-sm-12 p-0">
                        <div class="myTitleSmall small m-0 pl-1">REMARKS:</div>
                        <div class="mt-2 mb-2 h5 text-justify p-2">
                            <c:choose>
                                <c:when test="${param.containsKey('edit')}">
                                    <form:textarea path="remarks" cssClass="w-100"/>
                                </c:when>
                                <c:otherwise>
                                    ${hospital.remarks}
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
                </c:if>

                <%-- HEADER 2 ( BUDGET INFO ) --%>
                <c:if test="${param.get('content') ne null && param.get('content').toString() eq 'departmentList'}"> <%--if depratment list page--%>
                <div class="card-header">
                    <div>
                        <div class="col-sm-12 text-right mt-auto mb-auto">
                            <c:set var="costOfDepartments" value="${0}"/>
                            <c:forEach items="${hospital.departmentList}" var="department">
                                <c:forEach items="${department.roomList}" var="room">
                                    <c:forEach items="${room.productList}" var="product">
                                        <c:set var="costOfDepartments" value="${costOfDepartments + product.price}"/>
                                    </c:forEach>
                                </c:forEach>
                            </c:forEach>
                            <span>HOSPITAL INITIAL BUDGET:</span>
                            <fmt:formatNumber
                                    type="currency"
                                    maxIntegerDigits="12"
                                    minIntegerDigits="1"
                                    maxFractionDigits="2"
                                    minFractionDigits="2"
                                    currencySymbol="zł"
                                    value="${hospital.budget+costOfDepartments}"
                            />
                            <br>
                            <span>HOSPITAL ACTUAL BUDGET:</span>
                            <fmt:formatNumber
                                    type="currency"
                                    maxIntegerDigits="12"
                                    minIntegerDigits="1"
                                    maxFractionDigits="2"
                                    minFractionDigits="2"
                                    currencySymbol="zł"
                                    value="${hospital.budget}"
                            />
                        </div>
                    </div>
                </div>
                </c:if>

                <%-- MAIN CONTENT --%>
                <div id="mainContent" class="container">
                    <!-- SUB-PAGES -->
                    <%--<c:choose>--%>

                        <%-- INFO / EDIT PAGE--%>
                        <c:if test="${param.containsKey('content') && param.get('content').toString() eq 'info' || !param.containsKey('content')}">
                            <%-- EDIT PAGE --%>
                            <c:if test="${param.containsKey('edit')}">
<%--                                <form:hidden path="id"/>--%>
<%--                                <form:hidden path="name"/>--%>
<%--                                <form:hidden path="budget"/>--%>
<%--                                <form:hidden path="country"/>--%>
<%--                                <form:hidden path="postalCode"/>--%>
<%--                                <form:hidden path="city"/>--%>
<%--                                <form:hidden path="street"/>--%>
<%--                                <form:hidden path="streetNo"/>--%>
<%--                                <form:hidden path="phone"/>--%>
<%--                                <form:hidden path="www"/>--%>
<%--                                <form:hidden path="email"/>--%>
                                <c:forEach items="${hospital.departmentList}" var="department">
                                    <form:hidden path="departmentList" value="${department.id}" checked="checked"/>
                                </c:forEach>
                                <input type="hidden" name="backToPage" value="/hospitals/details/${hospital.id}?content=info">
                                <div class="row mt-2">
                                    <div class="col-sm-12">
                                        <a href="/hospitals/details/${hospital.id}?content=info" class="btn btn-outline-warning float-left d-inline-block">
                                            CANCEL
                                        </a>
                                        <form:button class="btn btn-outline-success float-right d-inline-block">
                                            SAVE
                                        </form:button>
                                    </div>
                                </div>
                            </c:if>
                        <%-- INFO PAGE --%>
                        <div class="generalInfo">
                            <%-- MANAGER ROW --%>
                            <div class="row pb-2">
                                <div class="col-sm-12 p-0">
                                    <div class="myTitleSmall small m-0 pl-1">MANAGER:</div>
                                    <div class="row mt-2 mb-2 h5 border-0">
                                        <c:if test="${hospital.manager eq null}">
                                            <div class="col-8">NO MANAGER</div>
                                            <div class="col-4">
                                                <a href="/hospitals/${hospital.id}/setManager" class="text-success">&#10010; SET MANAGER</a>
                                            </div>
                                        </c:if>
                                        <c:if test="${hospital.manager ne null}">
                                            <div class="col-8">${hospital.manager.nameFirst} ${hospital.manager.nameLast}</div>
                                            <div class="col-2">
                                                <a href="/hospitals/${hospital.id}/setManager" class="text-primary">&#8646; CHANGE MANAGER</a>
                                            </div>
                                            <div class="col-2">
                                                <a href="/hospitals/${hospital.id}/dismissManager" class="text-danger">&#10006; DISMISS MANAGER</a>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                                <%-- USERS ROW --%>
                            <div class="row border-bottom pb-2">
                                <div class="col-sm-12 p-0">
                                    <div class="myTitleSmall small m-0 pl-1">USERS / EMPLOYEES:</div>
                                    <div class="row mt-2 mb-2 h5 border-0">
                                        <c:if test="${hospital.userList eq null || hospital.userList.size() == 0}">
                                            <div class="col-8">NO USERS / EMPLOYEES</div>
                                            <div class="col-4">
                                                <a href="#" class="text-success">&#10010; ADD USERS / EMPLOYEES</a>
                                            </div>
                                        </c:if>
                                        <c:if test="${hospital.userList ne null &&  hospital.userList.size() != 0}">
                                            <div class="col-8">${hospital.userList.size()} users / employees</div>
                                            <div class="col-4">
                                                <a href="#" class="text-primary">&#8646; EDIT USERS / EMPLOYEES</a>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </c:if>

                        <%-- ANALYSIS PAGE --%>
                        <c:if test="${param.get('content') ne null && param.get('content').toString() eq 'analysis'}">

                            <c:set var="ratioCostOfProductsToHospitalBudget" value="${costOfDepartments / (hospital.budget+costOfDepartments) * 100}"/>
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

                            <div class="m-5">
                                <div class="ml-5 mt-5">COST OF PRODUCTS IN THIS HOSPITAL / HOSPITAL INITIAL BUDGET [%]</div>
                                <div class="progress ml-5 mr-5" style="height: 50px">
                                    <div class="progress-bar ${progressBarHospital}" role="progressbar" style="width: ${costOfDepartments / (hospital.budget+costOfRooms) * 100}%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
                                        <p class="position-absolute mt-auto mb-auto text-dark font-weight-bold ml-1">${ratioCostOfProductsToHospitalBudget} %</p>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <%-- DEPARTMENTS PAGE --%>
                        <c:if test="${param.containsKey('content') && param.get('content').toString() eq 'departmentList'}">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col text-center">
                                        LIST OF DEPARTMENTS INSIDE THE HOSPITAL
                                    </div>
                                </div>
                            </div>
                            <c:forEach items="${hospital.departmentList}" var="department">
                                <div class="card-body">
                                        <div class="row border-top pt-3">
                                        <a href="/departments/details/${department.id}" class="col-sm-2">
                                                ${department.name}
                                        </a>
                                        <a href="/departments/details/${department.id}" class="col-sm-4">
                                                ${department.departmentCategory.name}
                                        </a>
                                        <div class="col-sm-4">
                                                ${department.name}
                                        </div>
                                        <div class="col-sm-2 text-right">
                                            <c:set var="costOfDepartment" value="${0}"/>
                                            <c:forEach items="${department.roomList}" var="room">
                                                <c:forEach items="${room.productList}" var="product">
                                                    <c:set var="costOfDepartment" value="${costOfDepartment + product.price}"/>
                                                </c:forEach>
                                            </c:forEach>
                                            <fmt:formatNumber
                                                    type="currency"
                                                    maxIntegerDigits="12"
                                                    minIntegerDigits="1"
                                                    maxFractionDigits="2"
                                                    minFractionDigits="2"
                                                    currencySymbol="zł"
                                                    value="${costOfDepartment}"
                                            />
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-sm-8"></div>
                                        <div class="col-sm-1"><%--DEPARTMENTS INFO --%>
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
                                        <a href="/departments/delete/${department.id}?backToPage=/hospitals/details/${hospital.id}" class="col-sm-1"><%--DEL ROOM --%>
                                            <svg class="bi bi-x-square" width="25px" height="25px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                                <path fill-rule="evenodd" d="M11.854 4.146a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708-.708l7-7a.5.5 0 0 1 .708 0z"/>
                                                <path fill-rule="evenodd" d="M4.146 4.146a.5.5 0 0 0 0 .708l7 7a.5.5 0 0 0 .708-.708l-7-7a.5.5 0 0 0-.708 0z"/>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>

                        <%--</c:choose>--%>
                </div>

                <%-- FOOTER --%>
                <div class="card-footer">
                    <c:if test="${param.containsKey('content') && param.get('content') eq 'departmentList'}">
                        <div class="row">
                            <div class="col-sm-12 text-right">
                                TOTAL COST OF DEPARTMENTS:
                                <fmt:formatNumber
                                        type="currency"
                                        maxIntegerDigits="12"
                                        minIntegerDigits="1"
                                        maxFractionDigits="2"
                                        minFractionDigits="2"
                                        currencySymbol="zł"
                                        value="${costOfDepartments}"
                                />
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>

        </div>

    </form:form>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
