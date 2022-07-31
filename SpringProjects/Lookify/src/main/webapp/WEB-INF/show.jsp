<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Expense</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">      
    </head>
<body>
	<div class="container">
		<div class="text-dark card position-absolute top-50 start-50 translate-middle mt-4" style="width: 40rem;">
				<div class="card-body ">
					<div class="justify-contenet-between">
			<div class="d-md-flex justify-content-md-end"><a href="/dashboard" class="btn btn-warning ">Dashboard</a></div>
				<h1 class="text-primary">Details</h1>
  		     	<h3 class="mt-4">Title:  <c:out value="${lookify.title}"/></h3>
       		    <h3>Artist:  <c:out value="${lookify.artist}"/></h3> 
       		    <h3>Rating (1-10):  <c:out value="${lookify.rating}"/></h3>  
               <form action="/dashboard/${lookify.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<input class="btn btn-danger tme-md-2" type="submit" value="Delete">
				</form> 
		</div>
        </div>
        </div>
  </div>
</body>
</html>