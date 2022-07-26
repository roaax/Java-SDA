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
 	 <div class="text-center">
		<h1 class="text-primary text-center">Welcome ${name}! </h1>
		<a href="/your_server/counter" class="btn btn-outline-warning mt-4">Lets count our visits!</a>			
 	 </div>
	</div>
 </div>

</body>
</html>