<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <title>Simple Receipt</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">      
    </head>
<body>
<div class="container">
	<div class="position-absolute top-50 start-50 translate-middle">
     <h1>Customer Name: <c:out value="${name}"/></h1>
        <h2>Item name: <c:out value="${itemName}"/></h2> 
       <h2>Price: $<c:out value="${price}"/></h2>  
       <h2>Description: <c:out value="${description}"/></h2>   
       <h2>Vendor: <c:out value="${vendor}"/></h2> 
       </div>
       </div>
</body>
</html>