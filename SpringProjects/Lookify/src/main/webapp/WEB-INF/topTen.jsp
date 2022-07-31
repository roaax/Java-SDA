<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="container ">
			
				<div class=" test-center text-primary mt-4 mb-3">	
				<h1>Top Ten Songs</h1>
				<div class="d-md-flex justify-content-md-end"><a href="/dashboard" class="btn btn-warning ">Dashboard</a></div>
  			  <table class="table table-striped table-hover">
				    <thead>
				        <tr>
				            <th>Name</th>
				            <th>Rating</th>
				            <th>Actions</th>
				        </tr>
							    <c:forEach var="l" items="${song}">
			            <tr>
			                <td><a href="/songs/${l.id}"><c:out value="${l.title}"/></a></td>
			                <td><c:out value="${l.rating}" /></td>
			                <td><form action="/dashboard/${l.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input class="btn btn-danger tme-md-2" type="submit" value="Delete">
								</form>				              
			                </td>
						            </tr>
			        </c:forEach>
				</table>
				</div>
    </div>
</body>
</html>