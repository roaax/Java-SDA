<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body class="bg-light">

		
		<div class="container mt-4"	>
		<div class="card center" style="width: 50rem;">
		  <h3 class="card-header">Project Details</h3>
		  <div class="card-body">
		    <p class="card-title">Project ${project.title}</p>
		    <p class="card-title">Description ${project.description}</p>
		    <p class="card-title">Due Date  <fmt:formatDate pattern = "yyyy-MM-dd" value="${project.date}" /></p>
		    <div class="d-flex col-6 justify-content-evenly">
		    <p><a href="/dashboard" class="btn btn-primary">Back to Dashboard</a></p>
		    
		    <form action="/deleteproject/${project.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" value="Delete" class="btn btn-danger">
			</form>
			<p><a href="/projects/${project.id}/tasks" class="btn btn-warning">See Tasks</a></p>	
		   </div>
		  </div>
		</div>
		</div>
</body>
</html>