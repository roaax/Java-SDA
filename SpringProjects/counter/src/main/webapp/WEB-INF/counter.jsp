 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Visit Count</title>

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<div class="position-absolute top-50 start-50 translate-middle">
		<div>
			<h3 class="text-primary text-center text-dark ">You have visited
			<a href="/your_server/counter " class="text-primary text-center text-primary "> http://your_server </a>
			<c:out value=" ${count}"/> times</h3>
		</div>
		
		<div class="btn-group d-flex justify-content-evenly mb-4 ">
			<a href="/your_server" class="btn btn-outline-danger">Test another visit?</a>
			<a href="/your_server/counter_zero" class="btn btn-outline-success">Delete Your Session!</a>
			<a href="/your_server/increment_by_two" class="btn btn-outline-warning">Increment the count by 2!</a>	
		</div>
	</div>
</div>
</body>
</html> 