<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date</title>
<script type="text/javascript" src="/js/date.js"></script>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="btn-group d-flex justify-content-evenly position-absolute bottom-0 start-50 translate-middle-x mb-4 ">
		<a href="/date" class="btn btn-outline-danger">Date Template</a>
		<a href="/time" class="btn btn-outline-danger">Time Template</a>
		</div>
	<div class="container">
		<h1 class="date text-primary text-center position-absolute top-50 start-50 translate-middle"><fmt:formatDate pattern= "EEEE, 'the' d 'of' MMMM, y" value= "${date}"/></h1>
 	<%--  <h1>${ date}</h1> --%>
	</div>
</body>
</html>