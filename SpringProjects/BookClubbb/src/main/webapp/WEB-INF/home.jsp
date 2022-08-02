<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous"></head>

</head>
<body> <ul class="navbar navbar-inverse nav-fill bg-secondary h-50">
        <li class="nav-item">
            <h1 class="text-light">Welcome, <c:out value="${user.userName}" /></h1>
        </li>
        <li class="nav-item">
            <a class="btn btn-outline-light" href="logout">Log Out</a>
        </li>
        <li class="nav-item">
            <a class="btn btn-outline-light" href="/books/new">+ Add a to my shelf!</a>
        </li>
    </ul>
    
    <div class="container">
        <h1>Books from everyone's shelves:</h1>
        <div class="mt-4">
            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author Name</th>
                        <th>Posted By</th>
                    </tr>
                </thead>
                <tbody>
						 <c:forEach var="l" items="${book}">
			            <tr>
			            	<td><c:out value="${l.id}"/></td>
			                <td><a href="/books/${l.id}"><c:out value="${l.title}"/></a></td>
			                <td><c:out value="${l.authorName}" /></td>	
			                <td><c:out value="${l.user.userName}" /></td>	
			                		                
				  </tr>
			        </c:forEach>
                  
                </tbody>
            </table>
            
        </div>
    </div>
</body>
</html>