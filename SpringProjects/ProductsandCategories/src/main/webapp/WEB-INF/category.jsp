<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
		<div class="text-dark card position-absolute top-50 start-50 translate-middle mt-4" style="width: 30rem;">
		
		<h1 class="text-center text-darck mt-4">New Category</h1>
				<div class=" card-body">
		<form:form action="/categories/new" method="post" modelAttribute="category">
        <p>
            <form:label path="name">Name: </form:label>
            <form:input path="name" />
            <span class="text-danger"><form:errors path="name" /></span>
        </p>
      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <input class="btn btn-primary tme-md-2" type="submit" value="Create">
        </div>
    </form:form>
    </div>
    </div>
    
</body>
</html>