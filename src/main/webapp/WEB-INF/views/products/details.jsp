<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 24.09.2020
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CADMDB</title>
</head>
<body>

    <div class="container">

        <jsp:include page="../header.jsp"/>

        <div class="card">

            <div class="card-header">
                <%--<div class="row">
                    <div class="col-12">
                        <h4>${product.id}</h4>
                    </div>
                </div>--%>
                <div class="row">
                    <div class="col-4">
                        <h4>${product.productCategory.name} (${product.productCategory.code})</h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col-4">
                        <h4>${product.manufacturer.name} ${product.modelName}</h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <h4>${product.installationType.toString()}</h4>
                    </div>
                    <div class="col-3">
                        <h4>${product.powerConnectionNeeded} Watt</h4>
                    </div>
                    <div class="col-3">
                        <h4>${product.weight} kg</h4>
                    </div>
                    <div class="col-3">
                        <h4>
                            <fmt:formatNumber
                            type="currency"
                            minFractionDigits="0"
                            maxFractionDigits="2"
                            currencySymbol="zł"
                            value="${product.price}"
                            />
                        </h4>
<%--                        <h4>${product.price} zł</h4>--%>
                    </div>
                </div>
                <div class="row">

                </div>
            </div>

            <div class="card-body">
                <section id="roomListSection">
                    <div class="row border-top border-bottom pt-2" id="roomListHeader">
                        <h5>PRODUCT EXIST IN THIS ROOMS:</h5>
                    </div>
                    <c:forEach items="${product.roomList}" var="room">
                        <div class="row">
                            <div class="col-3">
                                ${room.department.hospital.name}
                            </div>
                            <div class="col-3">
                                ${room.department.departmentCategory.name} ${room.department.name}
                            </div>
                            <div class="col-4">
                                    ${room.roomCategory.name} ${room.name}
                            </div>
                            <div class="col-2">
                                ${room.number}
                            </div>
                        </div>
                    </c:forEach>
                    <div class="row border-bottom"></div>
                </section>
            </div>

            <div class="card-footer">
                <div class="row">
                    <div class="col-4">
                        <a href="#">ADD THIS PRODUCT TO ROOM</a>
                    </div>
                    <div class="col-3">
                        <a href="#">EDIT PRODUCT</a>
                    </div>
                    <div class="col-2">
                        <a href="#"></a>
                    </div>
                    <div class="col-3">
                        <a href="#">DELETE PRODUCT</a>
                    </div>
                </div>
            </div>

        </div>

        <jsp:include page="../footer.jsp"/>

    </div>

</body>
</html>
