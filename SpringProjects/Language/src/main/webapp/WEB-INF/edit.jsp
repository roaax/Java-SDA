<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit My Task</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
<div class="container">
		<div class="text-dark card position-absolute top-50 start-50 translate-middle mt-4" style="width: 40rem;">
				<div class="card-body ">
					<div class="flex d-flex justify-contenet-between">
					         <div><a href="/languages" class="position-absolute top-0 end-0 btn btn-warning text-secondary mt-4 ">Dashboard</a></div>
					         <div><form action="/languages/${language.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input class="btn btn-danger tme-md-2 mb-4" type="submit" value="Delete">
								</form></div>
					 
					 
					 </div>
    <form:form action="/languages/${language.id}" method="put" modelAttribute="language">
        <input type="hidden" name="_method" value="put">
        <p>
            <form:label path="name">Name: </form:label>
            <form:input path="name" />
            <span class="text-danger"><form:errors path="name" /></span>
        </p>
         <p>
            <form:label path="creator">Creator: </form:label>
            <form:input path="creator" />
            <span class="text-danger"><form:errors path="creator" /></span>
        </p>
        <p>
            <form:label path="version">Version: </form:label>
            <form:input path="version" />
            <span class="text-danger"><form:errors path="version" /></span>
        </p>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <input class="btn btn-primary tme-md-2" type="submit" value="Submit">
        </div>
    </form:form>
    </div>
    </div>
    </div>
</body>
</html>