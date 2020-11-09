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
        <form:form method="post" modelAttribute="hospital">
        <div class="card">
            <div class="card-header font-weight-bold text-center">
                NEW HOSPITAL FORM
            </div>
            <div class="card-body">
                <form:hidden path="id"/>
                <form:hidden path="investor.id"/>

                <div class="form-group">
                    <label for="name">NAME:</label>
                    <form:input type="text" cssClass="form-control" id="name" path="name"/>
                </div>
                <div class="form-group">
                    <label for="name">COUNTRY:</label>
                    <form:input type="text" cssClass="form-control" id="country" path="country"/>
                    <p class="text-danger font-italic"><form:errors path="country"/></p>
                </div>
                <div class="form-group">
                    <label for="name">POSTAL CODE:</label>
                    <form:input type="text" cssClass="form-control" id="postalCode" path="postalCode"/>
                </div>
                <div class="form-group">
                    <label for="name">CITY:</label>
                    <form:input type="text" cssClass="form-control" id="city" path="city"/>
                    <p class="text-danger font-italic"><form:errors path="city"/></p>
                </div>
                <div class="form-group">
                    <label for="name">STREET:</label>
                    <form:input type="text" cssClass="form-control" id="street" path="street"/>
                </div>
                <div class="form-group">
                    <label for="name">STREET NO.:</label>
                    <form:input type="number" step="1" cssClass="form-control" id="streetNo" path="streetNo"/>
                </div>
                <div class="form-group">
                    <label for="name">WWW:</label>
                    <form:input type="text" cssClass="form-control" id="www" path="www"/>
                </div>
                <div class="form-group">
                    <label for="name">EMAIL:</label>
                    <form:input type="text" cssClass="form-control" id="email" path="email"/>
                </div>
                <div class="form-group">
                    <label for="name">PHONE:</label>
                    <form:input type="text" cssClass="form-control" id="phone" path="phone"/>
                </div>
                <div class="form-group">
                    <label for="name">AREA [m<span class="text-uppercase">2</span>]:</label>
                    <form:input type="number" step="1" cssClass="form-control" id="area" path="area"/>
                    <p class="text-danger font-italic"><form:errors path="area"/></p>
                </div>

                <div class="form-group">
                    <label for="budget">BUDGET:</label>
                    <form:input type="number" step="0.01" cssClass="form-control" id="budget" path="budget"/>
                </div>

                <div class="form-group">
                    <label for="name">REMARKS (DESCRIPTION):</label>
                    <form:textarea type="text" rows="3"  cssClass="form-control" id="remarks" path="remarks"/>
                    <p class="text-danger font-italic"><form:errors path="remarks"/></p>
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
