<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="ISO-8859-1">
<title>Movie App</title>
</head>
<body>
	<div class="container w-50 mt-2 d-flex flex-column">
		<h1 class="text-primary align-self-center text-decoration-underline">Watchlist Organizer</h1>
		<h3 class="align-self-center">A simple app for keeping track of movies you have watched and plan to watch!</h3>
		<div class="mt-2 d-flex gap-3 justify-content-center">
			<div class="card w-50 shadow p-2">
				<h2>Register</h2>
				<form:form action="/users/process/register" method="post" modelAttribute="newUser">
				    <div class="form-group">
				        <label>Name</label>
				        <form:input path="userName" class="form-control" />
				        <form:errors path="userName" class="text-danger" />
				    </div>
				    <div class="form-group">
				        <label>Email</label>
				        <form:input path="email" class="form-control" />
				        <form:errors path="email" class="text-danger" />
				    </div>
				    <div class="form-group">
				        <label>Password</label>
				        <form:input path="password" class="form-control" />
				        <form:errors path="password" class="text-danger" />
				    </div>
				    <div class="form-group">
				        <label>Confirm Password</label>
				        <form:input path="confirm" class="form-control" />
				        <form:errors path="confirm" class="text-danger" />
				    </div>
				    <div class="d-flex justify-content-end mt-2">
				    	<input type="submit" value="Register" class="btn btn-primary" />
				    </div>
				</form:form>
			</div>
			<div class="card w-50 shadow p-2">
			<h2>login</h2>
			<form:form action="/users/process/login" method="post" modelAttribute="loginUser">
				    <form:errors path="email" class="text-danger" />
				    <div class="form-group">
				        <form:label path="email">Email</form:label>
				        <form:input path="email" class="form-control" />
				    </div>
				    <div class="form-group">
				        <label>Password</label>
				        <form:input path="password" class="form-control" />
				    </div>
				    <div class="d-flex justify-content-end mt-2">
				    	<input type="submit" value="Login" class="btn btn-primary" />
				    </div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>