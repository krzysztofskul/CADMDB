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

     <!--jQuery-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
    
	<!--JS files-->
    <script src="<c:url value="/resources/js/departments/new.js"/>" type="text/javascript"></script>
	

</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">
        <form:form modelAttribute="department" method="post">
            <input type="hidden" value="${backToPage}">
            <div class="card">
                <div class="card-header text-center font-weight-bold">
                    <h4>ADD NEW DEPARTMENT TO THE HOSPITAL FORM</h4>
                    <h5>FORMULARZ DODAWANIA DZIAŁU/ODDZIAŁU DO SZPITALA</h5>
                </div>
                <div class="card-body">
                    <form:hidden path="id"/>
                    <div class="form-group">
                        <label for="hospital">
                        	<h5>HOSPITAL NAME:</h5>
                        	<h6>NAZWA SZPITALA:</h6>
                        
                        </label>
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
                    <div class="form-group mt-5">
                        <label for="departmentCategory">
                        	<h5>DEPARTEMNT CATEGORY:</h5>
                        	<h6>KATEGORIA DZIAŁU/ODDZIAŁU:</h6>
                       	</label>
                        <form:select path="departmentCategory.id" id="departmentCategory" cssClass="form-control">
                            <c:forEach items="${departmentCategoryList}" var="departmentCategory">
                                <form:option value="${departmentCategory.id}" label="${departmentCategory.code} ${departmentCategory.name}"/>
                            </c:forEach>
                        </form:select>
                    </div>
                    <div class="form-group mt-5">
                        <c:set var="freeBudgetForNewDepartment" value="${department.hospital.budget - department.hospital.costOfDepartments}"/>
                        <label for="inputBudget">
                        	<h5>BUDGET:</h5>
                        	<h6>BUDŻET:</h6>
                       	</label>
                        <form:input 
                                path="budget"
                                type="number"
                                step="0.01"
                                cssClass="form-control mb-2"
                                id="inputBudget"
                                placeholder="max ${freeBudgetForNewDepartment} zł"
                        />
                        <input type="range" class="form-range w-100" min="0" max="${freeBudgetForNewDepartment}" step="${freeBudgetForNewDepartment/10}" id="inputBudgetRange">
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
