<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">      
    </head>
<body>
	<div class="container">
		<div class="position-absolute top-50 start-50 translate-middle text-primary">
		
  			  <h1>All Books</h1>
  			  <table class="table table-striped table-hover">
				    <thead>
				        <tr>
				            <th>ID</th>
				            <th>Title</th>
				            <th>Language</th>
				            <th>Pages</th>
				        </tr>
							    <c:forEach var="book" items="${books}">
			            <tr>
			            	<td><c:out value="${book.id}" /></td>
			                <td><a href="/books/${book.id}"><c:out value="${book.title}" /></a></td>
			                <td><c:out value="${book.language}" /></td>
			                <td><c:out value="${book.numberOfPages}" /></td>
			            </tr>
			        </c:forEach>
				</table>
       		 <%--  <h2>Description: <c:out value="${book.description}"/></h2> 
       		  <h2>Language: <c:out value="${book.language}"/></h2>  
        	  <h2>Number of Page: <c:out value="${book.numberOfPages}"/></h2>   --%> 
        </div>
  </div>
</body>
</html>
