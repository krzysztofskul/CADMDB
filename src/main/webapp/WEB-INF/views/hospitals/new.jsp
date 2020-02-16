<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 16.02.2020
  Time: 01:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">
        <form:form method="post" modelAttribute="hospitalNew">
        <div class="card">
            <div class="card-header font-weight-bold text-center">
                NEW HOSPITAL FORM
            </div>
            <div class="card-body">
                <form:hidden path="id"/>
                <div class="form-group">
                    <label for="name">NAME:</label>
                    <form:input type="text" cssClass="form-control" id="name" path="name"/>
                </div>
                <div class="form-group">
                    <label for="budget">BUDGET:</label>
                    <form:input type="number" step="0.01" cssClass="form-control" id="budget" path="budget"/>
                </div>
            </div>
            <div class="card-footer">
                <form:button type="submit" class="btn btn-success float-right">SAVE</form:button>
            </div>
        </div>
        </form:form>
    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
