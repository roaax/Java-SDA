<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit My Task</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
<div class="container">
		<div class="text-dark card position-absolute top-50 start-50 translate-middle mt-4" style="width: 40rem;">
				<div class="card-body ">
					<div class="flex d-flex justify-contenet-between">
					 <h1 class="text-primary mt-4 mb-4">Edit Expense</h1>
					         <div><a href="/expenses" class="position-absolute top-0 end-0 btn btn-warning text-secondary mt-4 ">Go back</a></div>
					 
					 
					 </div>
    <form:form action="/expenses/${expen.id}" method="put" modelAttribute="expen">
        <input type="hidden" name="_method" value="put">
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