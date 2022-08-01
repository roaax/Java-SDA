<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${dojo.name}"/></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
		<div class="text-dark card position-absolute top-50 start-50 translate-middle mt-4" style="width: 40rem;">
		
		<h1 class="text-center text-darck mt-4"><c:out value="${Dojo.name}"/> Ninjas</h1>
				<div class=" card-body">
				<div>
					<table class="table table-bordered table-striped text-center">
                            <tr class="table-secondary">
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Age</th>
                            </tr>
                            <c:forEach var="ninja" items="${Dojo.ninjas}">
                                <tr>
                                    <td>
                                        <c:out value="${ninja.firstName}" />
                                    </td>
                                                                        <td>
                                        <c:out value="${ninja.lastName}" />
                                    </td>
                                    <td>
                                        <c:out value="${ninja.age}" />
                                    </td>
                                </tr>
                            </c:forEach>
                    </table>
		</div>
    </div>
    </div>
    
</body>
</html>