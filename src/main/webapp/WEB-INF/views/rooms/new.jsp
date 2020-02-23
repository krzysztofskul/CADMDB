<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 17.02.2020
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">
        <form:form method="post" modelAttribute="newRoom">
            <div class="card">
                <div class="card-header font-weight-bold text-center">
                    NEW ROOM FORM
                </div>
                <div class="card-body">

                    <form:hidden path="id"/>

                    <form:hidden path="fullPath"/>

                    <div class="form-group">
                        <label for="department">DEPARTMENT:</label>
                        <c:set var="disabled" value="false"/>
                        <c:if test="${newRoom.department ne null}">
                            <form:hidden path="department.id"/>
                            <c:set var="disabled" value="true"/>
                        </c:if>
                        <form:select id="department" cssClass="form-control" path="department.id" disabled="${disabled}">
                            <c:forEach items="${newRoom.department.hospital.departmentList}" var="department">
                                <form:option value="${department.id}" label="${department.departmentCategory.code} ${department.departmentCategory.name}"/>
                            </c:forEach>
                        </form:select>
                    </div>

                    <div class="form-group">
                        <label for="roomCategory">ROOM CATEGORY:</label>
                        <form:select id="roomCategory" cssClass="form-control" path="roomCategory.id">
                            <c:forEach items="${allRoomCategories}" var="roomCategory">
                                <form:option value="${roomCategory.id}" label="${roomCategory.code} ${roomCategory.name}"/>
                            </c:forEach>
                        </form:select>
                    </div>

                    <div class="form-group">
                        <label for="number">ROOM NUMBER:</label>
                        <form:input id="number" cssClass="form-control" path="number"/>
                    </div>

                    <div class="form-group">
                        <label for="budget">BUDGET: </label>
                        <form:input id="budget" cssClass="form-control" type="number" step="0.01" path="budget"/>
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
