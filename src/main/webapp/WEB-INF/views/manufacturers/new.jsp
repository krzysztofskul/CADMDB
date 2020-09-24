<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 17.02.2020
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">

        <form:form method="post" modelAttribute="newManufacturer">
            <div class="card">

                <div class="card-header text-center font-weight-bold">
                    NEW MANUFACTURER FORM
                </div>

                <div class="card-body">
                    <form:hidden path="id"/>

                    <div class="form-group">
                        <label for="name">NAME:</label>
                        <form:input id="name" cssClass="form-control" path="name"/>
                    </div>

                    <div class="form-group">
                        <label for="details">DETAILS:</label>
                        <form:textarea id="details" cssClass="form-control" path="description"/>
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
