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
		<div class="text-dark card position-absolute top-50 start-50 translate-middle mt-4" style="width: 70rem;">
				<div class="card-body ">
					<div class="justify-contenet-between">
					<c:choose>
         
         <c:when test="${book.user.id == user}">
            <div class="d-md-flex justify-content-md-end"><a href="/books" class="btn btn-warning ">Back to the shelves</a></div>
				<h1 class="text-primary"><c:out value="${book.title}"/></h1>
  		     	<h3 class="mt-4"><span class="text-danger" >You read </span><span class="text-warning"><c:out  value="${book.title}"/></span> by <span class="text-success" ><c:out value="${book.authorName}" /></span></h3>
       		    <h5>Here are your thoughts: </h5> 
       		    
       		    <p>------------------------------------</p>
       		    <p><c:out value="${book.thoughts}"/></p>  
              	<p>------------------------------------</p>
          
         </c:when>
 
         <c:otherwise>
			<div class="d-md-flex justify-content-md-end"><a href="/books" class="btn btn-warning ">Back to the shelves</a></div>
				<h1 class="text-primary"><c:out value="${book.title}"/></h1>
  		     	<h3 class="mt-4"><span class="text-danger" ><c:out  value="${book.user.userName}" /> </span>read <span class="text-warning"><c:out  value="${book.title}"/></span> by <span class="text-success" ><c:out value="${book.authorName}" /></span></h3>
       		    <h5>Here are <c:out value="${book.user.userName}" /> thoughts: </h5> 
       		    
       		    <p>------------------------------------</p>
       		    <p><c:out value="${book.thoughts}"/></p>  
              	<p>------------------------------------</p>
              	
    		          
         </c:otherwise>
      </c:choose>
		</div>
        </div>
        </div>
  </div>
</body>
</html>