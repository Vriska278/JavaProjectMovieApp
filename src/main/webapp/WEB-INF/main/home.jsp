<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="ISO-8859-1">
<title>Baby Home</title>
</head>
<body>
	<div class="container w50 mt-2">
		<div class="d-flex justify-content-between align-items-center">
			<h1>Welcome, <c:out value="${loggedInUser.userName}"/>. Search for movies and shows and add them to your watchlist!</h1>
			<a class="btn btn-warning h-50" href="/users/logout">Logout</a>
		</div>
	</div>
</body>
</html>