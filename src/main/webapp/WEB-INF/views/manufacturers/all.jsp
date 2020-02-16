<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 15.02.2020
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">
        <div class="row">
            <div class="col-12">
                <a href="#" class="btn btn-success float-right">NEW</a>
            </div>
        </div>
        <c:forEach items="${manufacturers}" var="manufacturer">
            <div class="row bg-light font-weight-bold">
                <div class="col-12">
                    ID: ${manufacturer.id} | ${manufacturer.name}
                </div>
            </div>
            <c:forEach items="${manufacturer.productList}" var="product">
                <div class="row bg-light">
                    <div class="col-12 ml-2">
                        ID: ${product.id} | ${product.productCategory.name} ${product.manufacturer.name} ${product.modelName} ${product.price}
                    </div>
                </div>
            </c:forEach>
        </c:forEach>
    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
