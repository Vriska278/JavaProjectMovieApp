<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="ISO-8859-1">
<title>Movie Details</title>
</head>
<body>
	<div class="container mt-2">
	<form:form action="/api/process/search/${book.id}" modelAttribute="book" method="post"></form:form>
		<div class="row gap-1">
			<c:forEach items="${list}" var="i">
			<div class="col gap-1">
				<div class="card">
					<div class="card-header">
						<c:out value="${i.title} "/>
					</div>
					<div class="card-body">
						<p>${i.id}</p>
						<img class="align-self-center mb-2 shadow" src="https://image.tmdb.org/t/p/w200${i.poster_path}" alt="No Cover image found"/>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>