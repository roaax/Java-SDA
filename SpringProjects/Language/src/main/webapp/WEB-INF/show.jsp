<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${language.name}</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">      
    </head>
<body>
	<div class="container">
		<div class="text-dark card position-absolute top-50 start-50 translate-middle mt-4" style="width: 40rem;">
				<div class="card-body ">
					<div class="justify-contenet-between">
  			  <h3 class="mt-4"><c:out value="${language.name}"/></h3>
       		  <h3><c:out value="${language.creator}"/></h3> 
       		  <h3><c:out value="${language.version}"/></h3>  	
       		     
         <div><a href="/languages" class="position-absolute top-0 end-0 btn btn-warning d-flex text-secondary mt-4 ">Dashboard</a></div> 
          <div><a href="/languages/${language.id}/edit" class=" btn btn-success  mt-4 ">Edit</a></div>        	  	
               	  	
         <div><form action="/languages/${language.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input class="btn btn-danger d-flex mb-4" type="submit" value="Delete">
								</form></div>			   
        </div>
        </div>
        </div>
  </div>
</body>
</html>