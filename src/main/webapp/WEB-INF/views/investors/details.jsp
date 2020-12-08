<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 08.12.2020
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container-fluid">

        <div class="card">

            <div class="card-header">
                <h5>${investor.name}</h5>
                <h6>${investor.companyAddress.country}</h6>
                <h6>${investor.companyAddress.postalCode} ${investor.companyAddress.city}</h6>
                <h6>${investor.companyAddress.street} ${investor.companyAddress.streetNo}</h6>
            </div>

            <div class="card-body">

                <%-- HOSPITAL LIST --%>
                <div>
                    <h5 class="border-bottom bg-light">HOSPITAL INVESTMENT LIST:</h5>
                    <c:forEach items="${investor.hospitalList}" var="hospital">
                        <div class="row border-bottom">
                            <div class="col-sm-8">
                                <p>${hospital.name}</p>
                            </div>
                            <div class="col-sm-2">
                                <a href="/hospitals/details/${hospital.id}" class="text-primary">DETAILS</a>
                            </div>
                            <div class="col-sm-2">
                                <a href="#" class="text-danger">DELETE</a>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="row">
                        <div class="col-sm-10"></div>
                        <div class="col-sm-2">
                            <a href="#" class="text-success">CREATE NEW INVESTMENT</a>
                        </div>
                    </div>
                </div>

                <%-- EMPLOYEE LIST --%>
                <div>
                    <h5 class="border-bottom mt-5 bg-light">EMPLOYEE LIST:</h5>
                    <c:forEach items="${investor.employeeList}" var="employee">
                        <div class="row border-bottom">
                            <div class="col-sm-8">
                                <p>${employee.nameFirst} ${employee.nameLast}</p>
                            </div>
                            <div class="col-sm-2">
                                <a href="/users/details/${employee.id}" class="text-info">DETAILS</a>
                            </div>
                            <div class="col-sm-2">
                                <a href="#" class="text-danger">DISMISS</a>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="row">
                        <div class="col-sm-10"></div>
                        <div class="col-sm-2">
                            <a href="#" class="text-success">HIRE NEW EMPLOYEE</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="card-footer">

            </div>

        </div>

    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
