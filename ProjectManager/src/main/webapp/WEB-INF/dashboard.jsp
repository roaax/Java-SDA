
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login & Registration</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous"></head>
</head>
<body>
  
<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
    <h1 class="text-dark mt-4">Welcome, <c:out value="${user.userName}" />!</h1>
    
    <div class="d-flex col justify-content-evenly">
    <div>
     <span><a href="/projects/new" class="btn btn-outline-success">+ new project</a></span>
     </div>
     <div>
     <a href="/logout" class="btn btn-danger">Logout</a>
     </div>
 </div>
 
  </div>
</nav>

    <div class="container d-flex row justify-content-center p-4">  
    <p class="text-center">All projects</p>                 
                        <table class="table table-bordered table-striped text-center">
                            <tr >
                                <th>Project</th>
                                <th>Team Lead</th>
                                <th>Due Date</th>
                                <th>Action</th>
                            </tr>
                            <c:forEach var="project" items="${otherProjets}">
                            	<c:if test="${project.user.id != user.id}">                 
                                    <tr>
                                        <td>
                                            <a href="/projects/${project.id}">
                                                <c:out value="${project.title}" />
                                            </a>
                                        </td>
                                        <td>
                                            <c:out value="${project.user.userName}" />
                                        </td>
                                        <td>
                                            <fmt:formatDate pattern="MMM dd" value="${project.date}"  />
                                        </td>
                                        <td class="d-flex align-items-center justify-content-around">

                                            <form action="/projects/join/${project.id}" method="post">
                                                <input type="submit" value="Join team"
                                                    class="btn text-decoration-underline text-primary">
                                            </form>
                                        </td>
                                    </tr>
                              </c:if>
                            </c:forEach>
                        </table>

                        <p class="text-center">Your Projects</p>
                        <p>

                        </p>

                        <table class="table table-bordered table-striped text-center">
                            <tr >
                                <th>Project</th>
                                <th>Team Lead</th>
                                <th>Due Date</th>
                                <th>Action</th>
                            </tr>

                            <c:forEach var="project" items="${userProjects}">
                                <tr>
                                    <td>
                                        <a href="/projects/${project.id}">
                                            <c:out value="${project.title}" />
                                        </a>
                                    </td>
                                    <td>
                                        <c:out value="${project.user.userName}" />
                                    </td>
                                    <td>
                                        <fmt:formatDate pattern="MMM dd" value="${project.date}"  />
                                    </td>
                                    <td class="d-flex align-items-center justify-content-around">


                                        <c:if test="${project.user.id == user.id}">
                                            <a href="/projects/edit/${project.id}">edit</a>
                                        </c:if>
                                        <c:if test="${project.user.id != user.id}">
                                            <form action="/projects/leave/${project.id}" method="post">
                                                <input type="submit" value="Leave team"
                                                    class="btn text-decoration-underline text-primary">
                                            </form>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
       
            </table>
            </div>
               <%--  <div class="d-flex col-10 justify-content-evenly">
            <table class="table table-bordered table-striped text-center">
                            <tr class="table-secondary">
                                <th>Project</th>
                                <th>Team Lead</th>
                                <th>Due Date</th>
                                <th>Actions</th>
                            </tr>
                            <c:forEach var="project" items="${otherProjets}">
                            <c:if test="${project.user.id != User_id}">
                                <tr>
                                    <td>
                                        <a href="/projects/${project.id}"><c:out value="${project.title}" /></a>
                                    </td>
                                    <td>
                                        <c:out value="${project.user.userName}" />
                                    </td>
                                    <td>
                                        <fmt:formatDate pattern = "MMM dd" value="${project.date}" />
                                    </td>
                                    <td>
                                    <form action="/projects/join/${project.id}" method="post" >
									<input type="submit" value="Join Team" class="btn btn-primary">
									</form>
                                    </td>
                                </tr>
                                </c:if>
                            </c:forEach>
                        </table>
            
            </div>
            
    
    <p class="text-center">Your Projects</p>
    <div class="d-flex col-10 justify-content-evenly">
    <form:form action="/projects/new" method="post" modelAttribute="newUser">
            <table class="table table-bordered table-striped text-center">
                            <tr class="table-secondary">
                                <th>Project</th>
                                <th>Team Lead</th>
                                <th>Due Date</th>
                                <th>Actions</th>
                            </tr>
                            <c:forEach var="project" items="${userProjects}">
                                <tr>
                                    <td>
                                        <a href="/projects/${project.id}"><c:out  value="${project.title}" /></a>
                                    </td>
                                    <td>
                                        <c:out  value="${project.user.userName}" />
                                    </td>
                                    <td >
                                       <fmt:formatDate pattern = "MMM dd" value="${project.date}" />
                                    </td>
                                    <td>
                                    	
                                    	<c:if test="${project.user.id == user.id }">
                                    			<a href="/projects/edit/${project.id}">Edit</a> 
                                    	</c:if>
                                    	<c:if test="${project.user.id != User.id}" >
                                    		<form action="/projects/leave/${project.id}" method="post">                                 
											<input type="submit" value="Leave Team" class="btn btn-primary">
											</form>
                                    	</c:if> 
                                    	
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
            </form:<%--  
            </div>
            </div> --%>
  
</body>
</html>

