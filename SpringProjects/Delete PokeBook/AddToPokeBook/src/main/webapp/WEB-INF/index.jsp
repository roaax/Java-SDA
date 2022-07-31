<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="container col-7 ">

		<div class="  test-center text-primary mt-4 mb-3">
		
  			  <h1>PokeBook</h1>
  			  <table class="table table-striped table-hover">
				    <thead>
				        <tr>
				            <th>Expense</th>
				            <th>Vendor</th>
				            <th>Amount</th>
				        </tr>
							    <c:forEach var="expense" items="${expenses}">
			            <tr>
			                <td><a href="/expenses/${expense.id}"><c:out value="${expense.name}"/></a></td>
			                <td><c:out value="${expense.vendor}" /></td>
			                <td><c:out value="${expense.amount}" /></td>
			                <td><form action="/expenses/edit/${expense.id}" method="post">
                   			 <input type="hidden" name="_method" value="edit">
                 			  <input class="btn btn-primary tme-md-2"  type="submit" value="edit">
			                </form></td>
			                <td><form action="/expenses/delete/${expense.id}" method="post">
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
	 <h1 class="text-primary mt-4 mb-4">Track an Expense</h1>
    <form:form action="/expenses" method="post" modelAttribute="expense">
        <p>
            <form:label path="name">Expense Name</form:label>
            <form:input path="name" />
            <span class="text-danger"><form:errors path="name" /></span>
        </p>
         <p>
            <form:label path="vendor">Vendor: </form:label>
            <form:input path="vendor" />
            <span class="text-danger"><form:errors path="vendor" /></span>
        </p>
        <p>
            <form:label path="amount">Amount: </form:label>
            <form:input path="amount" />
            <span class="text-danger"><form:errors path="amount" /></span>
        </p>
        <p>
            <form:label path="description">Description: </form:label>
            <form:input path="description" />
            <span class="text-danger"><form:errors path="description" /></span>
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