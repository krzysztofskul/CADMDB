<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <c:forEach items="${hospitals}" var="hospital">
                        <div class="row bg-light font-weight-bold mt-2 border-top border-bottom">
                            <div class="col-8">
                                ID: ${hospital.id} | ${hospital.name} | ${hospital.budget}
                            </div>
                            <div class="col-4">
                                <a href="/departments/new?hospitalId=${hospital.id}">ADD DEPARTMENT</a>
                            </div>
                        </div>
                        <c:forEach items="${hospital.departmentList}" var="department">
                            <div class="row bg-light">
                                <div class="col-8 ml-2">
                                    ID: ${department.id} | ${department.departmentCategory.name}
                                </div>
                                <div class="col-2">
                                    <a href="/rooms/new?departmentId=${department.id}">ADD ROOM</a>
                                </div>
                            </div>
                            <c:forEach items="${department.roomList}" var="room">
                                <div class="row">
                                    <div class="col-8 ml-4">
                                        ID: ${room.id} | ${room.roomCategory.name}
                                    </div>
                                    <div class="col-3">
                                        <a href="/rooms/addProduct?roomId=${room.id}">ADD PRODUCT</a>
                                    </div>
                                </div>
                                <c:forEach items="${room.productList}" var="product">
                                    <div class="col-12 ml-lg-5">ID: ${product.id} | ${product.productCategory.name} ${product.manufacturer.name} ${product.modelName} ${product.price}</div>
                                </c:forEach>
                            </c:forEach>
                        </c:forEach>
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
