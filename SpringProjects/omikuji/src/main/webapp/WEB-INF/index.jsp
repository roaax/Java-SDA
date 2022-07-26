<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>omikuji</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
 
<div class="d-flex justify-content-evenly text-center"><h1>Send an Omikuji!</h1>
</div>
 <div class="d-flex justify-content-evenly position-absolute top-50 start-50 translate-middle ">
    <form class="row g-3 needs-validation" action="/login" method="post">
        <div class="col-8">
        <label>Pick any number from 5 to 25:</label>
       <input type="number" name="num" min="5" max="25">
		  </div>
		  <div class="col-8">
		<label for="exampleFormControlInput1" class="form-label">Enter the name of any city:</label>
        <input type="text" name="city" class="form-control" id="exampleFormControlInput1">		  
		  </div>	  
		    <div class="col-8">
        <label for="exampleFormControlInput1" class="form-label">Enter a name of any real person:</label>
        <input type="text" name="person">
        </div>
          <div class="col-8">
        <label for="exampleFormControlInput1" class="form-label">Enter professional endeavor or hobby:</label>
        <input type="text" name="hobby">
        </div>
          <div class="col-8">
        <label for="exampleFormControlInput1" class="form-label">Enter any type of living thing:</label>
        <input type="text" name="living">
        </div>
          <div class="col-8">
        <label for="exampleFormControlInput1" class="form-label">Say something nice to someone:</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"  name="text"></textarea>
        </div>
        
        <h5>Send and show a friend</h5>
        <div class="col-8 " >
        <input type="submit" value="send" class="btn btn-primary">
        </div>
    </form> 
    </div> 
</body>
</html>