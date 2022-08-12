<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Project Details</h1>
				<div class="text-dark card   mt-4" style="width: 40rem;">
				<div class="card-body">
		   <form:form action="/projects/new" method="post" modelAttribute="project">
 		   
 		   
        <p>
            <form:label path="title">Project Title</form:label>
            <form:input path="title" />
            <span class="text-danger"><form:errors path="title" /></span>
        </p>
         <p>
            <form:label path="description">Project Description: </form:label>
            <form:input path="description" />
            <span class="text-danger"><form:errors path="description" /></span>
        </p>
        <p>
            <form:label path="date">Due Date: </form:label>
            <form:input path="date" type="date" />
            <span class="text-danger"><form:errors path="date" /></span>
        </p>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <form:input path="user" type="hidden" value="${user.id}"/>    
        <input class="btn btn-primary tme-md-2" type="submit" value="Submit">
        <span><a href="/dashboard" class="btn btn-warning">Cancel</a></span>
        </div>
    </form:form>
    </div>
    </div>
    </div>
</body>
</html>