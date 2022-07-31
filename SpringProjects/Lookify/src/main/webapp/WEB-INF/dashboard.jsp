<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify!</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="container">

		<div class=" text-primary mt-4 mb-3">
	
		<div><a href="/songs/new" class="btn btn-warning ">Add New</a></div>
		</div>
		<div class="input-group " >
			<form action="/search" >
	  		<input type="search"  name="artist" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" required/>
	  		<button type="submit" class="btn btn-outline-primary">search Artist</button>
	 		</form>
	 		</div>
	 		<div><a href="/search/topTen" class="btn btn-warning ">Top Songs</a></div>
	 		
  			  <table class="table table-striped table-hover">
				    <thead>
				        <tr>
				            <th>Name</th>
				            <th>Rating</th>
				            <th>Actions</th>
				        </tr>
							    <c:forEach var="l" items="${lookify}">
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
</body>
</html>