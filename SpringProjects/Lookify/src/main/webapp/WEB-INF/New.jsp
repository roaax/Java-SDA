<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Song</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	
	
	
	<div class="text-dark card   mt-4" style="width: 40rem;">
				<div class="card-body">
				<div class="d-md-flex justify-content-md-end"><a href="/dashboard" class="btn btn-warning ">Dashboard</a></div>
    <form:form action="/songs/new" method="post" modelAttribute="look">
        <p>
            <form:label path="title">Title</form:label>
            <form:input path="title" />
            <span class="text-danger"><form:errors path="title" /></span>
        </p>
         <p>
            <form:label path="artist">Artist: </form:label>
            <form:input path="artist" />
            <span class="text-danger"><form:errors path="artist" /></span>
        </p>
        <p>
            <form:label path="rating">Rating: </form:label>
            <form:input type="number" min="1" max="10" path="rating" />
            <span class="text-danger"><form:errors path="rating" /></span>
        </p>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <input class="btn btn-primary tme-md-2" type="submit" value="Add Song">
        </div>
    </form:form>
    </div>
    </div>
</body>
</html>