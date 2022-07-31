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
		<h1 class="text-primary">Expense Details</h1>
  			  <h3 class="mt-4">Expense Name:  <c:out value="${expen.name}"/></h3>
       		  <h3>Description:  <c:out value="${expen.description}"/></h3> 
       		  <h3>Vendor:  <c:out value="${expen.vendor}"/></h3>  
        	  <h3>Amount Spent:  <c:out value="${expen.amount}"/></h3>  
        	  	<div class="d-grid gap-2 d-md-flex justify-content-md-end"><a href="/expenses" class=" btn btn-warning text-secondary ">Go back</a></div>			   
        </div>
        </div>
        </div>
  </div>
</body>
</html>