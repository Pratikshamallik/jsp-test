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
<nav class='navbar navbar-dark bg-primary' >
	<a href='#' class='navbar-brand'>
	Pratiksha's Project
	</a>
	<ul class='navbar-nav' >
		<li class='nav-item' ><a class='nav-link' href="login.jsp">Login</a></li>
	</ul>
</nav>

<div class='container'>

<div class="card mt-5">
  <h5 class="card-header bg-info">New Registration</h5>
  <div class="card-body">
    <h5 class="card-title text-white">Register yourself</h5>
	<form action="Register" method="post">
		<div class='form-group'>
			<input placeholder='Username'  class='form-control' type="text" name="uname" pattern="[A-Za-z ]*">
			<small>eg: Only alphabets allowed</small>
		</div>
		
		<div class='form-group'>
	  		<input placeholder='Mobile Number'  class='form-control' type="tel" name="phone" pattern="[6-9]{1}[0-9]{9}" required> 
	  		<small>eg: 9834524567</small>
	  	</div>
		
		<div class='form-group'>
			<input placeholder='Age' class='form-control' type="number" id="age" name="age" min="1" max="999">
			<small>eg: age must be between 1-999</small>
			
		</div>
	  
	 	<div class='form-group'>
	 	<select  class='form-control' name="gender">
	 			<option value="male"> Male</option>
	 			<option value="female"> Female</option>
	 			<option value="other"> Other</option>
	 			</select></td>
	 	</div>
	
		<div class='form-group'>
				<input placeholder='Address' class='form-control' type="text" name="address" pattern="[A-Za-z0-9 ]{1,200}">
				<small>eg: Only Alphabets and Numbers allowed. Below 200 characters</small>
	
		</div>
	  
		<div class='form-group'>
			<input placeholder='Password'  class='form-control' type="password" name="password" placeholder="at least eight character and one special character" pattern="(?=.*?[#?!@$%^&*-]).{8,}">
			<small>eg: Must have at least 8 characters with special characters</small>
			
		</div>
	
		<div class='form-group'>
			<td></td>
			<td><input class='btn btn-success' type="submit" value="Register">
			</td>
		</div>
	
	</form>
  </div>
</div>

</div>
</body>
</html>