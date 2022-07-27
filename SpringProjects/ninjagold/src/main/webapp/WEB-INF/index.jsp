<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	 <div class="container ">
	 <div class="d-flex mt-4">
            <h2>Your Gold:</h2>
                <h2><input type="hidden" name="gold" value="gold" /> <c:out value="${gold}"/></h2>
                 
                </div>
        <div class="d-flex justify-content-evenly text-center mt-4 mb-4">
        <div class="card"style="width: 18rem;">
         <h2>Farm</h2>
                <p>(earns 10-20 gold!)</p>
                <form action="/Gold/process" method="post">
                    <input type="hidden" name="place" value="farm" />
                    <div class="text-center mt-4 mb-4">
                    <button type="submit" class="btn btn-primary">Find Gold!</button>
                    </div>
                </form>
            </div>       
        <div class="card" style="width: 18rem;"> 
                <h2>Cave</h2>
                <p>(earns 5-10 gold!)</p>
                <form action="/Gold/process" method="post">
                    <input type="hidden" name="place" value="cave"/>
                    <div class="text-center mt-4 mb-4">
                    <button type="submit" class="btn btn-primary">Find Gold!</button>
                    </div>
                </form>
            </div>

            <div class="card" style="width: 18rem;"> 
                <h2>House</h2>
                <p>(earns 2-5 gold!)</p>
                <form action="/Gold/process" method="post">
                    <input type="hidden" name="place" value="house"/>
                    <div class="text-center mt-4 mb-4">
                    <button type="submit" class="btn btn-primary">Find Gold!</button>
                    </div>
                </form>
            </div>

            <div class="card" style="width: 18rem;"> 
                <h2>Casino</h2>
                <p>(earns/takes 0-50 gold!)</p>
                <form action="/Gold/process" method="post">
                    <input type="hidden" name="place" value="casino" />
                    <div class="text-center mt-4 mb-4">
                    <button type="submit" class="btn btn-primary">Find Gold!</button>
                    </div>
                </form>
            </div>
        </div>
        

        
            <h2>Activities:</h2>
            	<div name="activity" class="card d-flex p-2">
				<div class="container">
					<div class="overflow-auto p-3 mb-3 mb-md-0 mr-md-3 bg-light"
						style="max-width: 100%; max-height: 200px;">
							<c:forEach var="x" items="${activity}">
								<c:if test="${x.contains('gain')}">
									<p class="text-success"><c:out value="${x}" /></p>
								</c:if>
								<c:if test="${x.contains('lost')}">
									<p class="text-danger"><c:out value="${x}"/></p>
								</c:if>
						</c:forEach>
				<%-- <c:forEach var="gold" items="${activity}">
                    <p style="margin: 0px;"><c:out value="${gold}" /></p>
                </c:forEach> --%>
					
					</div>
      		  </div>
		</div>
    <div>
       		 <form action="/Gold/reset" method="post">
				<button class="btn btn-primary mt-4 col-1">reset</button>
			</form> 
		</div>
	</div>
</body>
</html>