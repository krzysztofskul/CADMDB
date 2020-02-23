<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 15.02.2020
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

        <div class="container">

            <div class="card">
                <div class="card-header text-center font-weight-bold">
                    ALL HOSPITALS LIST
                </div>
                <div class="card-body">
                    <div class="row font-weight-bold mb-3">
                        <div class="col-1">
                            ID
                        </div>
                        <div class="col-6">
                            HOSPITAL/DEPARTMENT/ROOM NAME
                        </div>
                        <div class="col-3">
                            BUDGET / PRODUCT PRICE
                        </div>
                        <div class="col-2">
                            OPTIONSi
                        </div>
                    </div>
                    <c:forEach items="${hospitals}" var="hospital">
                        <div class="mb-5">
                        <div class="row bg-light border-dark font-weight-bold mt-1 mb-1 border-top border-bottom">
                            <div class="col-1">
                                    ${hospital.id}
                            </div>
                            <div class="col-6">
                                    ${hospital.name}
                            </div>
                            <div class="col-3">
                                <fmt:formatNumber type="currency"
                                                  minFractionDigits="2"
                                                  maxFractionDigits="2"
                                                  currencySymbol="zł"
                                                  value="${empty hospital.budget ? 0 : hospital.budget}"
                                />
                            </div>
                            <div class="col-2">
                                <a href="#">DETAILS</a>
                                <a href="#" class="text-danger">DEL</a>
                            </div>
                        </div>
                        <c:forEach items="${hospital.departmentList}" var="department">
                            <div class="row bg-light border-bottom border-top border-dark">
                                <div class="col-1">
                                    ${department.id}
                                </div>
                                <div class="col-6">
                                    ${department.departmentCategory.name}
                                </div>
                                <div class="col-3">
                                    <fmt:formatNumber type="currency"
                                                      minFractionDigits="2"
                                                      maxFractionDigits="2"
                                                      currencySymbol="zł"
                                                      value="${empty department.budget ? 0 : department.budget}"
                                    />
                                </div>
                                <div class="col-2">
                                    <a href="#">DETAILS</a>
                                    <a href="#" class="text-danger">DEL</a>
                                </div>
                            </div>
                            <c:forEach items="${department.roomList}" var="room">
                                <div class="row">
                                    <div class="col-1">
                                        ${room.id}
                                    </div>
                                    <div class="col-6">
                                        ${room.roomCategory.name}
                                    </div>
                                    <div class="col-3">
                                        <fmt:formatNumber type="currency"
                                                          minFractionDigits="2"
                                                          maxFractionDigits="2"
                                                          currencySymbol="zł"
                                                          value="${empty room.budget ? 0 : room.budget}"
                                        />
                                    </div>
                                    <div class="col-2">
                                        <a href="#">DETAILS</a>
                                        <a href="#" class="text-danger">DEL</a>
                                    </div>
                                </div>
                                <c:forEach items="${room.productList}" var="product">
                                    <div class="row font-italic text-black-50">
                                        <div class="col-1">
                                            ${product.id}
                                        </div>
                                        <div class="col-6">
                                            ${product.productCategory.name} ${product.manufacturer.name} ${product.modelName}
                                        </div>
                                        <div class="col-3">
                                            <fmt:formatNumber type="currency"
                                                              minFractionDigits="2"
                                                              maxFractionDigits="2"
                                                              currencySymbol="zł"
                                                              value="${empty product.price ? 0 : product.price}"
                                            />
                                        </div>
                                        <div class="col-2">
                                            <a href="#">DETAILS</a>
                                            <a href="#" class="text-danger">DEL</a>
                                        </div>
                                    </div>
                                </c:forEach>
                                <div class="row">
                                    <div class="col-1">
                                    </div>
                                    <div class="col-3">
                                        <a href="/rooms/addProduct?roomId=${room.id}" class="text-success">
                                            ADD PRODUCT
                                        </a>
                                    </div>
                                </div>
                            </c:forEach>
                            <div class="row">
                                <div class="col-1">
                                </div>
                                <div class="col-3">
                                    <a href="/rooms/new?departmentId=${department.id}" class="text-success">
                                        ADD ROOM
                                    </a>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="row bg-light font-weight-bold">
                            <div class="col-1">
                            </div>
                            <div class="col-3">
                                <a href="/departments/new?hospitalId=${hospital.id}" class="text-success">
                                    ADD DEPARTMENT
                                </a>
                            </div>
                        </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="card-header">
                    <a href="/hospitals/new" class="btn btn-success float-right">NEW HOSPITAL</a>
                </div>
            </div>

        </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
