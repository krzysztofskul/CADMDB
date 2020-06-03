<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 16.02.2020
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">
        <form:form modelAttribute="department" method="post">
            <div class="card">
                <div class="card-header text-center font-weight-bold">
                    NEW DEPARTMENT FORM
                </div>
                <div class="card-body">
                    <form:hidden path="id"/>
                    <div class="form-group">
                        <label for="hospital">HOSPITAL:</label>
                        <c:if test="${department.hospital.id eq null}">
                            <c:set var="disabled" value="false"/>
                        </c:if>
                        <c:if test="${department.hospital.id ne null}">
                            <c:set var="disabled" value="true"/>
                            <form:hidden path="hospital.id"/>
                        </c:if>
                            <form:select path="hospital.id" id="hospital" cssClass="form-control" disabled="${disabled}">
                                <c:forEach items="${hospitalList}" var="hospital">
                                    <form:option value="${hospital.id}" label="${hospital.name}"/>
                                </c:forEach>
                            </form:select>
                    </div>
                    <div class="form-group">
                        <label for="departmentCategory">DEPARTEMNT CATEGORY:</label>
                        <form:select path="departmentCategory.id" id="departmentCategory" cssClass="form-control">
                            <c:forEach items="${departmentCategoryList}" var="departmentCategory">
                                <form:option value="${departmentCategory.id}" label="${departmentCategory.code} ${departmentCategory.name}"/>
                            </c:forEach>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <c:set var="freeBudgetForNewDepartment" value="${department.hospital.budget}"/>
                        <label for="budget">BUDGET:</label>
                        <form:input
                                path="budget"
                                type="number"
                                step="0.01"
                                cssClass="form-control"
                                id="budget"
                                placeholder="max ${freeBudgetForNewDepartment} zł"
                        />
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
