<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 07.12.2020
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container-fluid pl-5 pr-5">

        <div class="row">
            <div class="col-sm-12 text-sm-center">
                <h5 class="d-inline-block border-top border-bottom mb-5">INVESTOR COMPANIES</h5>
            </div>

        </div>

        <div class="text-center w-75 p-5 m-auto">
        <c:forEach items="${investorsAll}" var="investor">
            <div class="card d-inline-block m-1" style="width: 300px; height: 250px">
                <div class="card-header">
                    <h5>${investor.name} ${investor.companyType}</h5>
                </div>
                <div class="card-body p-3 text-left">
                    <h5>${investor.companyAddress.country}</h5>
                    <p>
                        ${investor.companyAddress.postalCode} ${investor.companyAddress.city}<br>
                        ${investor.companyAddress.street}<span class="font-italic"> No.</span> ${investor.companyAddress.streetNo}
                    </p>
                    <%-- TEST --%>
                    <div class="row m-0 p-0 text-center" style="font-size: xx-small">
                        <div class="col-sm-6 p-0 m-0">
                            <span>Hospital investments: ${investor.hospitalList.size()}</span>
                            <%--<c:forEach items="${investor.hospitalList}" var="hospital">
                                <p style="font-size: xx-small" class="p-0 m-0">${hospital.name}</p>
                            </c:forEach>--%>
                        </div>
                        <div class="col-sm-6 p-0 m-0">
                            <span>Employees: ${investor.employeeList.size()}</span>
                            <%--<c:forEach items="${investor.employeeList}" var="employee">
                                <p style="font-size: xx-small" class="p-0 m-0">${employee.nameFirst} ${employee.nameLast}</p>
                            </c:forEach>--%>
                        </div>
                    </div>
                    <%-- END TEST --%>
                </div>
                <div class="card-footer text-right">
                    <a href="/investors/details/${investor.id}" class="disabled">DETAILS</a>
                </div>
            </div>
        </c:forEach>
        </div>

    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
