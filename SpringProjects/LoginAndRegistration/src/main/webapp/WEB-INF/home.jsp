<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login & Registration</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous"></head>

</head>
<body>
		<h1 class="text-center text-primary">Welcome, <c:out value="${user.userName}" /></h1>
		<p class="text-center">This is your dashboard, Nothing to see here yet.</p>
		<p class="text-center"><a href="/logout" class="btn btn-danger text-center">Logout</a></p>
</body>
</html>