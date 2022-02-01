<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: z0041nhm
  Date: 01.02.2022
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
    <jsp:include page="../../header.jsp"/>

    <div class="container-fluid">
        <header class="text-center">
            <h2>Lista ustandaryzowanych kategorii oddziałów szpitalnych</h2>
            <h3>The list of standardised departments' categories</h3>
        </header>

        <main class="text-center">
            <c:forEach items="${departmentsCategories}" var="departmentCategory">

                <div class="card border-dark m-3 d-inline-block" style="width: 18rem; height: 12rem; overflow: hidden">
                    <div class="card-header">${departmentCategory.name}</div>
                    <div class="card-body text-dark">
                        <h5 class="card-title">Lorem ipsum</h5>
                        <p class="card-text">Lorem ipsum</p>
                    </div>
                </div>

            </c:forEach>
        </main>
    </div>

    <jsp:include page="../../footer.jsp"/>
</body>
</html>
