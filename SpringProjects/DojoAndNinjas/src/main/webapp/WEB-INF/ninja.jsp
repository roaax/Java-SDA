<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>

		<div class="text-dark card position-absolute top-50 start-50 translate-middle mt-4" style="width: 18rem;">
		
		<h1 class="text-center text-darck mt-4">New Ninja</h1>
				<div class=" card-body">
		<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
		
		<p>
			<form:label path="dojo">Select Dojo </form:label>
			<form:select path="dojo">
			<c:forEach var="dojo" items="${dojo}">
			<option value="${dojo.id}">${dojo.name}</option>
			</c:forEach>
			</form:select>
			</p>
        <p>
            <form:label path="firstName">First Name </form:label>
            <form:input path="firstName" />
            <span class="text-danger"><form:errors path="firstName" /></span>
        </p>
        <p>
            <form:label path="lastName">Last Name </form:label>
            <form:input path="lastName" />
            <span class="text-danger"><form:errors path="lastName" /></span>
        </p>
        <p>
            <form:label path="age">Age </form:label>
            <form:input path="age" />
            <span class="text-danger"><form:errors path="age" /></span>
        </p>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <input class="btn btn-primary tme-md-2" type="submit" value="Create">
        </div>
    </form:form>
    </div>
    </div>
    
</body>
</html>