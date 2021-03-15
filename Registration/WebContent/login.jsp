<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://bootswatch.com/4/yeti/bootstrap.min.css">
<title>Pratiksha's Project</title>
</head>
<body>
<nav class='navbar navbar-expand justify-content-between navbar-dark bg-primary'>
	<a class='navbar-brand' href='index.jsp'>Pratiksha's Project</a>
	<ul class='navbar-nav navbar-right'>
		<li class='nav-item'><a class='nav-link'  href="index.jsp">Register</a></li>
	</ul>
</nav>
<div class='container'>
	<div class='card mt-5'>
		<h4 class='card-header bg-info'> Login form</h4>
		<div class='card-body'>
			<form action ="login" method="post">
			 <div class='form-group'><label>Mobile Number: </label><input class='form-control' type="tel" name="phone"></div>
			 <div class='form-group'><label>Password: </label><input  class='form-control' type="password" name="password"></div>
			 <div class='form-group'><input  class='btn btn-success' type="submit" value="Login"></div>
			</form>
		</div>
	</div>
</div>
</body>
</html>