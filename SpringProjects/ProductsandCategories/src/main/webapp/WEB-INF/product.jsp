<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
		<div class="text-dark card position-absolute top-50 start-50 translate-middle mt-4" style="width: 40rem;">
		<h1 class="text-center text-primary mt-4"><c:out value="${product.name}"/> Product</h1>
				<div class=" card-body">		
						<h1 >Categories</h1>
							<c:forEach var="category" items="${product.categories}">
							<p>${category.name}</p>
							</c:forEach>
						</div>
			  	<div>
				
				 <form action="/products/${product.id}" method="post" >
				 	  <label>Select Category </label>
				 		   <select name="category">
									<c:forEach var="category" items="${categories}">
										<option value="${category.id}">${category.name}</option>
									</c:forEach>
							</select>                       
	                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
						             <input class="btn btn-primary tme-md-2" type="submit" value="add">
						        </div>
			     </form>                        
		</div>
    </div>
</body>
</html>