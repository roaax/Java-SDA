<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Share</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Add a Book To Your Shelf!</h1>
				<div class="text-dark card   mt-4" style="width: 40rem;">
				<div class="card-body">
				<div class="d-md-flex justify-content-md-end"><a href="/books" class="btn btn-warning ">Back to the shelf</a></div>
 		   <form:form action="/books/new" method="post" modelAttribute="book">
 		   
 		   
        <p>
            <form:label path="title">Title</form:label>
            <form:input path="title" />
            <span class="text-danger"><form:errors path="title" /></span>
        </p>
         <p>
            <form:label path="authorName">Artist: </form:label>
            <form:input path="authorName" />
            <span class="text-danger"><form:errors path="authorName" /></span>
        </p>
        <p>
            <form:label path="thoughts">My Thoughts: </form:label>
            <form:input path="thoughts" />
            <span class="text-danger"><form:errors path="thoughts" /></span>
        </p>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <form:input path="user" type="hidden" value="${user.id}"/>
        
        <input class="btn btn-primary tme-md-2" type="submit" value="Submit">
        </div>
    </form:form>
    </div>
    </div>
    </div>
</body>
</html>