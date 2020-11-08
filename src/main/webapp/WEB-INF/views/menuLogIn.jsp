<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container border-top border-bottom pt-1 pb-1 text-right">

    <c:choose>
        <c:when test="${sessionScope.userLoggedIn eq null}">
            <%-- if logged in user == null --%>
            <div class="btn-group">
                <a href="/#login" type="button" class="btn btn-primary">LOG IN</a>
                <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span class="sr-only">Toggle Dropdown</span>
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/loginAsGuest/hospital-manager-guest">LOG IN AS A GUEST: HOSPITAL MANAGER</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item disabled" href="/loginAsGuest/hospital-employee-guest">LOG IN AS A GUEST: HOSPITAL EMPLOYEE</a>
                    <a class="dropdown-item" href="/loginAsGuest/investor-guest">LOG IN AS A GUEST: INVESTOR</a>
                    <a class="dropdown-item disabled" href="/#">LOG IN AS A GUEST: DESIGNER</a>
                    <a class="dropdown-item disabled" href="/#">LOG IN AS A GUEST: BUILDING CONTRACTOR</a>
                    <a class="dropdown-item disabled" href="/#">LOG IN AS A GUEST: MANUFACTURER</a>
                    <a class="dropdown-item disabled" href="#">...</a>
                </div>
            </div>

            <a class="btn btn-secondary" href="/#register">REGISTER</a>

        </c:when>
        <c:otherwise>
            <%-- if logged in user != null --%>
            <div>
                Hello, <span class="font-weight-bold">${userLoggedIn.nameFirst} ${userLoggedIn.nameLast}</span>!
            </div>
            <a href="/users/details/${userLoggedIn.id}">MY PROFILE</a>
            <a href="/logout">LOG OUT</a>

        </c:otherwise>
    </c:choose>

</section>
