<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous"></head>
<body>
<div class="container col-7 ">

		<div class="  test-center text-primary mt-4 mb-3">
  			  <table class="table table-striped table-hover">
				    <thead>
				        <tr>
				            <th>Name</th>
				            <th>Creator</th>
				            <th>Version</th>
				            <th>Action</th>
				        </tr>
							    <c:forEach var="l" items="${lang}">
			            <tr>
			                <td><a href="/languages/${l.id}"><c:out value="${l.name}"/></a></td>
			                <td><c:out value="${l.creator}" /></td>
			                <td><c:out value="${l.version}" /></td>
			                <td><form action="/languages/${l.id}/edit" method="post">
                   			 <input type="hidden" name="_method" value="edit">
                 			  <input class="btn btn-primary tme-md-2"  type="submit" value="edit">
			                </form></td>
			                <td><form action="/languages/${l.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input class="btn btn-danger tme-md-2" type="submit" value="Delete">
								</form>			              
			                </td>
						            </tr>
			        </c:forEach>
				</table>
				</div>
				
				<div class="text-dark card   mt-4" style="width: 40rem;">
				<div class="card-body">
    <form:form action="/languages" method="post" modelAttribute="language">
        <p>
            <form:label path="name">Name: </form:label>
            <form:input path="name" />
            <span class="text-danger"><form:errors path="name" /></span>
        </p>
         <p>
            <form:label path="creator">Creator: </form:label>
            <form:input path="creator" />
            <span class="text-danger"><form:errors path="creator" /></span>
        </p>
        <p>
            <form:label path="version">Version: </form:label>
            <form:input path="version" />
            <span class="text-danger"><form:errors path="version" /></span>
        </p>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <input class="btn btn-primary tme-md-2" type="submit" value="Submit">
        </div>
    </form:form>
    </div>
    </div>
    </div>
</body>
</html>