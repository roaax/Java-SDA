
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Props Page </title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous"></head>
</head>
<body>
<div class="container">
  
    <h1 class="text-dark mt-4">Project, <c:out value="${project.title}" />!</h1>
    <form class="d-flex">
    <div class="d-flex col justify-content-between">
     <p>Project Lead: <c:out value="${project.user.userName }"></c:out></p>
 </div>
  </form>
		<p>Add a task ticket for this team :</p>

   		
  		<div class="row mx-5 p-4">
                                <div class="col-9">
                                    <form:form action="/projects/${project.id}/tasks" method="post" modelAttribute="task">

                                        <div class="form-group my-3">
                                            <form:label path="message">Add a task ticket for this team:</form:label>
                                            <form:input path="message" class="form-control" />
                                            <form:errors path="message" class="text-danger" />
                                        </div>
                                        <div class="form-group my-3 d-flex justify-content-between">
                                            <input type="submit" value="Submit" class="btn btn-primary " />
                                        </div>
                                    </form:form>
                                </div>
                                <div>
                                    <c:forEach var="task" items="${tasks}">
                                        <h5>Added by
                                            <c:out value="${task.creator.userName}" /> at                                            
                                            <fmt:formatDate pattern="hh:mm a MMM dd" value="${task.createdAt}"  />
                                        </h5>
                                        <p>
                                            <c:out value="${task.message}" />
                                        </p>
                                    </c:forEach>
                                </div>
                                <span><a href="/dashboard" class="btn btn-warning">Back to Dashboard</a></span>

                            </div>
                      
 </div>
</body>
</html>

