<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruity Loop</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	
	<div class="container">
        <div class="d-flex row ">
            <h1 class="text-secondary text-center" >Fruit Store</h1>
			  <table class=" table table table-primary table-stripedr text-center ">
				<thead>
					<tr>
						<th>Name</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="x" items="${fruits}">
						<tr>
							<td>
									<c:out value="${x.name}"/>
							</td>	
							
							<td>
									<c:out value="${x.price}"/>
							</td>			
						</tr>
					</c:forEach>
				</tbody>					
			</table>
		</div>
		</div>
</body>
</html>