<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reading Books</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">      
    </head>
<body>
	<div class="container">
		<div class="position-absolute top-50 start-50 translate-middle text-dark">
  			  <h1 class="text-primary"><c:out value="${book.title}"/></h1>
       		  <h3>Description: <c:out value=" ${book.description}"/></h3> 
       		  <h3>Language: <c:out value=" ${book.language}"/></h3>  
        	  <h3>Number of Page: <c:out value=" ${book.numberOfPages}"/></h3>   
        </div>
  </div>
</body>
</html>
