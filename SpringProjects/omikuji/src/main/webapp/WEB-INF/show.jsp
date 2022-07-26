<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<div class=" container">
<div class=" justify-content-evenly position-absolute top-50 start-50 translate-middle">
<h1 class="text-center">Here's Your Omikuji</h1>
<div class="card" style="width: 25rem;">
<h1 class="text-primary text-center">In <c:out value="${num}"/> years, you will live in
<c:out value="${city}"/> with <c:out value="${person}"/>
as your roomate, <c:out value="${hobby}"/> for a living .
The next time you see a <c:out value="${living}"/> ,
you will have good luck. Also,<c:out value="${text}"/></h1>
</div>
<div class="d-flex justify-content-evenly mt-4">
<a href="/omikuji" class="btn btn-outline-success">Go Back</a>
</div>
</div>
</div>
</body>
</html>