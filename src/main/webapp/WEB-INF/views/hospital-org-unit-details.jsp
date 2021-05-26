<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 19.05.2021
  Time: 08:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
    <body>

    <jsp:include page="./header.jsp"/>

    <form:form modelAttribute="hospitalOrgUnit" method="post" action="/${hospitalOrgUnit}/details/">

        <%-- CHECK THE USER'S CATEGORY --%>
        <c:set var="userCategoryList" value="${sessionScope.userLoggedIn.userCategoryList}" scope="session"/>
        <c:set var="isUserLoggadInInvestor" value="false"/>
        <c:forEach items="${userCategoryList}" var="userCategory">
            <c:if test="${userCategory.code eq 'INVESTOR' || userCategory.code eq 'INVESTOR (GUEST)'}">
                <c:set var="isUserLoggadInInvestor" value="true"/>
            </c:if>
        </c:forEach>

        <%-- SET LOCAL VARIABLES --%>
        <c:if test="${hospitalOrgUnit.className eq 'hospital'}">
            <c:set var="link" value="/hospitals/details/${hospitalOrgUnit.id}?content=departmentList"/>
            <c:set var="subOrgUnits" value="DEPARTMENTS"/>
            <c:set var="subOrgUnit" value="DEPARTMENT"/>
        </c:if>
        <c:if test="${hospitalOrgUnit.className eq 'department'}">
            <c:set var="link" value="/departments/details/${hospitalOrgUnit.id}?content=roomList"/>
            <c:set var="subOrgUnits" value="ROOMS"/>
            <c:set var="subOrgUnit" value="ROOM"/>
        </c:if>
        <c:if test="${hospitalOrgUnit.className eq 'room'}">
            <c:set var="link" value="/rooms/details/${hospitalOrgUnit.id}?content=productList"/>
            <c:set var="subOrgUnits" value="PRODUCTS"/>
            <c:set var="subOrgUnit" value="PRODUCT"/>
        </c:if>

        <div class="container">

            <div class="card">

                <%-- HOSPITAL ORG UNIT STRUCTURE/PATH --%>
                <div class="card-header">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">

                            <li class="breadcrumb-item"><a href="/hospitals/all">Hospitals</a></li>

                            <c:if test="${hospitalOrgUnit.className eq 'hospital'}">
                            <li class="breadcrumb-item"><p>${hospitalOrgUnit.name}</p></li>
                            </c:if>

                            <c:if test="${hospitalOrgUnit.className eq 'department'}">
                            <li class="breadcrumb-item"><a href="/hospitals/details/${hospitalOrgUnit.hospital.id}">${hospitalOrgUnit.hospital.name}</a></li>
                            <li class="breadcrumb-item"><p>${hospitalOrgUnit.departmentCategory.name}</p></li>
                            </c:if>

                            <c:if test="${hospitalOrgUnit.className eq 'room'}">
                            <li class="breadcrumb-item"><a href="/hospitals/details/${hospitalOrgUnit.department.hospital.id}" >${hospitalOrgUnit.department.hospital.name}</a></li>
                            <li class="breadcrumb-item"><a href="/departments/details/${hospitalOrgUnit.department.id}?content=info">${hospitalOrgUnit.department.departmentCategory.name}</a></li>
                            <li class="breadcrumb-item disabled" aria-current="page"><p>${hospitalOrgUnit.number} ${hospitalOrgUnit.roomCategory.name}</p></li>
                            </c:if>

                        </ol>
                    </nav>
                </div>

                <%-- HOSPITAL ORG UNIT INFORMATION + MENU ) --%>
                <div class="card-header">
                    <%-- INFORMATION: NAME ETC. + MENU--%>
                    <div class="row">
                        <%-- INFORMATION: NAME ETC. --%>
                        <div class="col-sm-1 border-right text-center mt-auto mb-auto h4">
                                <%--${hospital.number}--%>
                        </div>
                        <div class="col-sm-6 mt-auto mb-auto">
                            <c:choose>
                                <c:when test="${param.containsKey('edit')}">
                                    <form:hidden path="id"/>
                                    <form:hidden path="investor.id"/>
                                    <form:hidden path="investmentCompany.id"/>
                                    <form:hidden path="manager.id"/>
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
                                    <h4>${hospitalOrgUnit.name}</h4>
                                    <h6>${hospitalOrgUnit.country}, ${hospitalOrgUnit.postalCode} ${hospitalOrgUnit.city}</h6>
                                    <h6>${hospitalOrgUnit.street} street, No. ${hospitalOrgUnit.streetNo}</h6>
                                    <h6>&#9742;: ${hospitalOrgUnit.phone}</h6>
                                    <h6>@: ${hospitalOrgUnit.email}</h6>
                                    <h6>WEB: ${hospitalOrgUnit.www}</h6>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <%-- MENU --%>
                        <div class="col-sm-3">
                            <c:if test="${param.containsKey('content') && param.containsValue('info') || !param.get('contains')}">
                                <a href="/hospitals/details/${hospitalOrgUnit.id}?content=info&edit=true&editUsers=true" class="btn float-right">
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
                                <a href="/departments/new?hospitalId=${hospitalOrgUnit.id}&backToPage=/hospitals/details/${hospitalOrgUnit.id}" class="dropdown-item" type="button">
                                    <svg class="text-success bi bi-plus-square-fill" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4a.5.5 0 0 0-1 0v3.5H4a.5.5 0 0 0 0 1h3.5V12a.5.5 0 0 0 1 0V8.5H12a.5.5 0 0 0 0-1H8.5V4z"/>
                                    </svg>
                                    <span class="small ml-2">ADD NEW ${subOrgUnit}</span>
                                </a>
                                <a href="/${hospitalOrgUnit.className}s/details/${hospitalOrgUnit.id}?content=info" class="dropdown-item" type="button">
                                    <svg class="text-info bi bi-info-square" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                        <path d="M8.93 6.588l-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588z"/>
                                        <circle cx="8" cy="4.5" r="1"/>
                                    </svg>
                                    <span class="small ml-2">INFO</span>
                                </a>
                                <a href="${link}" class="dropdown-item" type="button">
                                    <svg class="text-info bi bi-card-list" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M14.5 3h-13a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h13a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
                                        <path fill-rule="evenodd" d="M5 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 5 8zm0-2.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm0 5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5z"/>
                                        <circle cx="3.5" cy="5.5" r=".5"/>
                                        <circle cx="3.5" cy="8" r=".5"/>
                                        <circle cx="3.5" cy="10.5" r=".5"/>
                                    </svg>
                                    <span class="small ml-2">${subOrgUnits} LIST</span>
                                </a>
                                <a href="/${hospitalOrgUnit.className}s/details/${hospitalOrgUnit.id}?content=analysis" class="dropdown-item" type="button">
                                    <svg class="text-info bi bi-graph-up" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M0 0h1v16H0V0zm1 15h15v1H1v-1z"/>
                                        <path fill-rule="evenodd" d="M14.39 4.312L10.041 9.75 7 6.707l-3.646 3.647-.708-.708L7 5.293 9.959 8.25l3.65-4.563.781.624z"/>
                                        <path fill-rule="evenodd" d="M10 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-1 0V4h-3.5a.5.5 0 0 1-.5-.5z"/>
                                    </svg>
                                    <span class="small ml-2">ANALYSIS</span>
                                </a>
                                <div class="dropdown-divider"></div>
                                <a href="/hospitals/delete/${hospitalOrgUnit.id}" class="dropdown-item" type="button">
                                    <svg class="text-danger bi bi-trash" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                        <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                    </svg>
                                    <span class="small ml-2">DELETE ${hospitalOrgUnit.className.toUpperCase()}</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <%-- HOSPITAL INVESTOR ROW --%>
                    <c:if test="${hospitalOrgUnit.className eq 'hospital'}">
                    <div class="row pb-2 border-top">
                        <div class="col-sm-12 p-0">
                            <div class="myTitleSmall small m-0 pl-1">HOSPITAL INVESTOR:</div>
                            <div class="row mt-2 mb-2 h5 border-0">
                                <div class="col-sm-8">
                                        ${hospitalOrgUnit.investmentCompany.name}
                                </div>
                                <div>
                                    <a href="/investors/details/${hospitalOrgUnit.investmentCompany.id}" class="text-primary">DETAILS</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:if>
                </div>

                <%-- HOSPITAL ORG UNIT SUMMARY (COSTS/BUDGET/AREA) AND REMARKS --%>
                <div class="card-header">
                    <c:if test="${param.get('content') ne null && param.get('content').toString() eq 'info' || !param.containsKey('content')}">
                        <%-- AREA --%>
                        <div class="row mt-1">
                            <div class="col-sm-2 p-0 border-right">
                                <div class="myTitleSmall small m-0 pl-1">AREA PLANNED:</div>
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
                                            ${hospitalOrgUnit.area} <span>m<sup>2</sup></span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                            <div class="col-sm-3 p-0 border-right">
                                <div class="myTitleSmall small m-0 pl-1 ml-1">AREA USED BY DEPARTMENTS:</div>
                                <div class="mt-2 mb-2 h5 text-center">
                                    <c:set var="areaOfDepartments" value="${0}"/>
                                    <c:forEach items="${hospital.departmentList}" var="department">
                                        <c:set var="areaOfDepartments" value="${areaOfDepartments+department.area}"/>
                                    </c:forEach>
                                    <c:set var="areaUsedTextColor" value="text-dark"/>
                                    <c:choose>
                                        <c:when test="${areaOfDepartments > hospital.area}">
                                            <c:set var="areaUsedTextColor" value="text-danger"/>
                                        </c:when>
                                    </c:choose>
                                    <span class="${areaUsedTextColor}">${areaOfDepartments} <span>m<sup>2</sup></span></span>
                                </div>
                            </div>
                        </div>
                        <%-- BUDGET ETC.--%>
                        <div class="row mt-1 pt-2 border-top">
                            <div class="col-sm-3 p-0 border-right">
                                <div class="myTitleSmall small m-0 pl-1">INITIAL BUDGET FOR MEDICAL EQUIPMENT:</div>
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
                                                    value="${hospitalOrgUnit.budget}"
                                            />
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                            <div class="col-sm-3 p-0 border-right">
                                <div class="myTitleSmall small m-0 pl-1">COST OF MEDICAL EQUIPMENT:</div>
                                <div class="mt-2 mb-2 h5 text-center">
                                    <c:set var="hospitalCostOfProducts" value="${0}"/>
                                    <c:forEach items="${hospital.departmentList}" var="department">
                                        <c:forEach items="${department.roomList}" var="room">
                                            <c:forEach items="${room.productList}" var="product">
                                                <c:set var="hospitalCostOfProducts" value="${hospitalCostOfProducts + product.price}"/>
                                            </c:forEach>
                                        </c:forEach>
                                    </c:forEach>
                                    <c:set var="hospitalActualBudgetColor" value="text-dark"/>
                                    <c:choose>
                                        <c:when test="${hospital.budget < hospitalCostOfProducts}">
                                            <c:set var="hospitalActualBudgetColor" value="text-danger"/>
                                        </c:when>
                                    </c:choose>
                                    <span class="${hospitalActualBudgetColor}">
                                        <fmt:formatNumber
                                                type="currency"
                                                maxIntegerDigits="12"
                                                minIntegerDigits="1"
                                                maxFractionDigits="2"
                                                minFractionDigits="2"
                                                currencySymbol="zł"
                                                value="${hospitalOrgUnit.costOfProductsActual}"
                                        />
                                    </span>
                                </div>
                            </div>
                        </div>
                        <%-- REMARKS --%>
                        <div class="row border-top mt-1">
                            <div class="col-sm-12 p-0">
                                <div class="myTitleSmall small m-0 pl-1 border-top">REMARKS:</div>
                                <div class="mt-2 mb-2 h5 text-justify p-2">
                                    <c:choose>
                                        <c:when test="${param.containsKey('edit')}">
                                            <form:textarea path="remarks" cssClass="w-100"/>
                                        </c:when>
                                        <c:otherwise>
                                            ${hospitalOrgUnit.remarks}
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </div>

                <%--MAIN CONTENT--%>
                <%--<div id="mainContent" class="container">--%>
                <div class="card-body">

                    <%-- SUB-PAGES: INFO & EDIT PAGE--%>
                    <c:if test="${param.containsKey('content') && param.get('content').toString() eq 'info' || !param.containsKey('content')}">

                        <%-- EDIT PAGE --%> <%--todo--%>
                        <%--<c:if test="${param.containsKey('edit')}">
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
                        </c:if>--%>

                        <%-- INFO PAGE --%>
                        <div class="generalInfo">
                            <%-- MANAGER ROW --%>
                            <div class="row pb-2">
                                <div class="col-sm-12 p-0">
                                    <div class="myTitleSmall small m-0 pl-1">MANAGER:</div>
                                    <div class="row mt-2 mb-2 h5 border-0">
                                        <c:if test="${hospitalOrgUnit.className eq 'hospital'}">
                                            <c:if test="${hospitalOrgUnit.manager eq null}">
                                                <div class="col-8">NO MANAGER</div>
                                                <div class="col-4">
                                                    <a href="/hospitals/${hospitalOrgUnit.id}/setManager" class="text-success">&#10010; SET MANAGER</a>
                                                </div>
                                            </c:if>
                                            <c:if test="${hospitalOrgUnit.manager ne null}">
                                                <div class="col-8">${hospitalOrgUnit.manager.nameFirst} ${hospitalOrgUnit.manager.nameLast}</div>
                                                <div class="col-2">
                                                    <a href="/hospitals/${hospitalOrgUnit.id}/setManager" class="text-primary">&#8646; CHANGE MANAGER</a>
                                                </div>
                                                <div class="col-2">
                                                    <a href="/hospitals/${hospitalOrgUnit.id}/dismissManager" class="text-danger">&#10006; DISMISS MANAGER</a>
                                                </div>
                                            </c:if>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                            <%-- USERS ROW --%>
                            <div class="row pb-2">
                                <div class="col-sm-12 p-0">
                                    <div class="myTitleSmall small m-0 pl-1">USERS/EMPLOYEES:</div>
                                    <div class="row mt-2 mb-2 h5 border-0">
                                        <div class="col-sm-12 border-0">
                                            <c:if test="${hospitalOrgUnit.className eq 'hospital'}">
                                                <c:if test="${hospitalOrgUnit.employeeList eq null || hospitalOrgUnit.employeeList.size() == 0}">
                                                    <div class="row border-0">
                                                        <div class="col-sm-8">NO USERS / EMPLOYEES</div>
                                                        <div class="col-sm-4">
                                                            <a href="/hospitals/${hospitalOrgUnit.id}/addEmployee" class="text-success">&#10010; ADD USER / EMPLOYEE</a>
                                                        </div>
                                                    </div>
                                                </c:if>
                                                <c:if test="${hospitalOrgUnit.employeeList ne null &&  hospitalOrgUnit.employeeList.size() != 0}">
                                                    <div class="row border-0">
                                                        <div class="col-sm-8">${hospitalOrgUnit.employeeList.size()} users / employees</div>
                                                        <div class="col-sm-4">
                                                                <%--<a href="#" class="text-primary">&#8646; EDIT USERS / EMPLOYEES</a>--%>
                                                            <a href="/hospitals/${hospitalOrgUnit.id}/addEmployee" class="text-success">&#10010; ADD USER / EMPLOYEE</a>
                                                        </div>
                                                    </div>
                                                    <c:forEach items="${hospitalOrgUnit.employeeList}" var="employee">
                                                        <div class="row pt-1 pb-1 m-auto">
                                                            <div class="col-sm-1 text-black-50">
                                                                    ${employee.id}
                                                            </div>
                                                            <div class="col-sm-9">
                                                                    ${employee.nameFirst} ${employee.nameLast}
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <a href="/hospitals/${hospitalOrgUnit.id}/dismissEmployee?userId=${employee.id}" class="btn btn-danger">DISMISS</a>
                                                            </div>
                                                        </div>
                                                    </c:forEach>
                                                </c:if>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </c:if>

                    <%-- SUB-PAGES: LIST OF SUB- HOSPITAL ORGANIZATIONAL UNITS PAGE --%>
                    <c:if test="${
                                    param.containsKey('content') && param.get('content').toString() eq 'departmentList' ||
                                    param.containsKey('content') && param.get('content').toString() eq 'roomList' ||
                                    param.containsKey('content') && param.get('content').toString() eq 'productList'

                                    }">
                        <div class="card-body">
                            <div class="row">
                                <div class="col text-center">
                                    <%--<c:if test="${hospitalOrgUnit.className eq 'hospital'}">
                                        <c:set var="subOrgUnits" value="DEPARTMENTS"/>
                                    </c:if>
                                    <c:if test="${hospitalOrgUnit.className eq 'department'}">
                                        <c:set var="subOrgUnits" value="ROOMS"/>
                                    </c:if>
                                    <c:if test="${hospitalOrgUnit.className eq 'room'}">
                                        <c:set var="subOrgUnits" value="PRODUCTS"/>
                                    </c:if>--%>
                                    LIST OF ${subOrgUnits}
                                </div>
                            </div>
                        </div>

                        <c:if test="${hospitalOrgUnit.className eq 'hospital'}">
                        <c:forEach items="${hospitalOrgUnit.departmentList}" var="department">
                        <div class="card-body">
                            <div class="row border-top pt-3">
                                <a href="/departments/details/${department.id}?content=info" class="col-sm-7">
                                    <h5>${department.departmentCategory.name}</h5>
                                </a>
                                <div class="col-sm-2 border border-right-0 bg-light text-right" style="font-size: 14px">COSTS OF PRODUCTS IN THE DEPRTMENT:</div>
                                    <%--<div class="col-sm-3 text-right border border-left-0">
                                        <c:set var="costOfDepartment" value="${0}"/>
                                        <c:forEach items="${department.roomList}" var="room">
                                            <c:forEach items="${room.productList}" var="product">
                                                <c:set var="costOfDepartment" value="${costOfDepartment + product.price}"/>
                                            </c:forEach>
                                        </c:forEach>--%>
                                        <h5>
                                            <fmt:formatNumber
                                                    type="currency"
                                                    maxIntegerDigits="12"
                                                    minIntegerDigits="1"
                                                    maxFractionDigits="2"
                                                    minFractionDigits="2"
                                                    currencySymbol="zł"
                                                    value="${department.costOfProductsActual}"
                                            />
                                        </h5>
                                    <%--</div>--%>
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
                                <a href="/departments/delete/${department.id}?backToPage=/hospitals/details/${hospitalOrgUnit.id}" class="col-sm-1 text-danger"><%--DEL ROOM --%>
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

                        <c:if test="${hospitalOrgUnit.className eq 'department'}">
                            <c:forEach items="${hospitalOrgUnit.roomList}" var="room">
                                <div class="card-body">
                                    <div class="row border-top pt-3">
                                        <a href="/rooms/details/${room.id}?content=info" class="col-sm-7">
                                            <h5>${room.number} ${room.name}</h5>
                                        </a>
                                        <div class="col-sm-2 border border-right-0 bg-light text-right" style="font-size: 14px">COSTS OF PRODUCTS:</div>
                                            <div class="col-sm-3 text-right border border-left-0">
                                                <%--<c:set var="costOfDepartment" value="${0}"/>
                                                <c:forEach items="${department.roomList}" var="room">
                                                    <c:forEach items="${room.productList}" var="product">
                                                        <c:set var="costOfDepartment" value="${costOfDepartment + product.price}"/>
                                                    </c:forEach>
                                                </c:forEach>--%>
                                                <h5>
                                                    <fmt:formatNumber
                                                            type="currency"
                                                            maxIntegerDigits="12"
                                                            minIntegerDigits="1"
                                                            maxFractionDigits="2"
                                                            minFractionDigits="2"
                                                            currencySymbol="zł"
                                                            value="${room.costOfProductsActual}"
                                                    />
                                                </h5>
                                            </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-sm-8"></div>
                                        <div class="col-sm-1"><%--ROOMS INFO --%>
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
                                        <a href="/departments/delete/${department.id}?backToPage=/hospitals/details/${hospitalOrgUnit.id}" class="col-sm-1 text-danger"><%--DEL ROOM --%>
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

                        <c:if test="${hospitalOrgUnit.className eq 'room'}">
                            <c:forEach items="${hospitalOrgUnit.productList}" var="product">
                                <div class="card-body">
                                    <div class="row border-top pt-3">
                                        <div class="col-sm-9">
                                            <a href="/products/${product.id}" class="col-sm-7">
                                                <h5>${product.productCategory.nameSingular}</h5>
                                                <h6>${product.manufacturer.name} ${product.modelName}</h6>
                                            </a>
                                        </div>
                                        <div class="col-sm-3">
                                            <h5>
                                                <fmt:formatNumber
                                                        type="currency"
                                                        maxIntegerDigits="12"
                                                        minIntegerDigits="1"
                                                        maxFractionDigits="2"
                                                        minFractionDigits="2"
                                                        currencySymbol="zł"
                                                        value="${product.price}"
                                                />
                                            </h5>
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
                                        <a href="/departments/delete/${department.id}?backToPage=/hospitals/details/${hospitalOrgUnit.id}" class="col-sm-1 text-danger"><%--DEL ROOM --%>
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

                    </c:if>

                    <%-- SUB-PAGES: ANALYSIS PAGE --%>
                    <c:if test="${param.get('content') ne null && param.get('content').toString() eq 'analysis'}">

                        <c:set var="ratioCostOfProducts" value="${hospitalOrgUnit.costOfProductsActual / hospitalOrgUnit.budget * 100}"/>
                        <c:choose>
                            <c:when test="${ratioCostOfProducts > 100}">
                                <c:set var="progressBarHospital" value="bg-danger"/>
                            </c:when>
                            <c:when test="${ratioCostOfProducts.toString() eq '100.00'}">
                                <c:set var="progressBarHospital" value="bg-warning border border-danger"/>
                            </c:when>
                            <c:when test="${ratioCostOfProducts < 100 && ratioCostOfProducts > 75}">
                                <c:set var="progressBarHospital" value="bg-warning"/>
                            </c:when>
                            <c:when test="${ratioCostOfProducts < 75}">
                                <c:set var="progressBarHospital" value="bg-success"/>
                            </c:when>
                            <c:otherwise>
                                <c:set var="progressBarHospital" value="bg-info"/>
                            </c:otherwise>
                        </c:choose>

                        <div class="m-5">
                            <div class="ml-5 mt-5">COST OF PRODUCTS IN THIS ${hospitalOrgUnit.className.toUpperCase()} / ${hospitalOrgUnit.className.toUpperCase()} INITIAL BUDGET [%]</div>
                            <div class="progress ml-5 mr-5" style="height: 50px">
                                <div class="progress-bar ${progressBarHospital}" role="progressbar" style="width: ${ratioCostOfProducts}%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
                                    <p class="position-absolute mt-auto mb-auto text-dark font-weight-bold ml-1">${ratioCostOfProducts} %</p>
                                </div>
                            </div>
                        </div>
                    </c:if>

                </div>

                <%-- HOSPITAL ORG UNIT SUMMARY (EG. COSTS/BUDGET) --%>
                <div class="card-footer">
                    <c:if test="${param.containsKey('content') && param.get('content') eq 'departmentList'}">
                        <div class="row">
                            <div class="col-sm-12 text-right">
                                TOTAL COST OF PRODUCTS INSIDE DEPARTMENTS OF THIS HOSPITAL:
                                <fmt:formatNumber
                                        type="currency"
                                        maxIntegerDigits="12"
                                        minIntegerDigits="1"
                                        maxFractionDigits="2"
                                        minFractionDigits="2"
                                        currencySymbol="zł"
                                        value="${hospitalOrgUnit.costOfProductsActual}"
                                />
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${param.containsKey('content') && param.get('content') eq 'roomList'}">
                        <div class="row">
                            <div class="col-sm-12 text-right">
                                TOTAL COST OF PRODUCTS INSIDE ROOMS OF THIS DEPARTMENT:
                                    <fmt:formatNumber
                                            type="currency"
                                            maxIntegerDigits="12"
                                            minIntegerDigits="1"
                                            maxFractionDigits="2"
                                            minFractionDigits="2"
                                            currencySymbol="zł"
                                            value="${hospitalOrgUnit.costOfProductsActual}"
                                    />
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${param.containsKey('content') && param.get('content') eq 'productList'}">
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
                                            value="${hospitalOrgUnit.costOfProductsActual}"
                                    />
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>

        </div>

    </form:form>

    <jsp:include page="./footer.jsp"/>

    </body>
</html>
