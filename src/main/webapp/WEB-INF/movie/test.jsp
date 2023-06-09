<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
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
		
		<div class="card shadow">
			<div class="card-header mb-2">
			<h1 class=""><c:out value="${movie.title}"/></h1>
			</div>
			<div class="card-body d-flex flex-column">
			<img class="align-self-center mb-2 shadow" src="https://image.tmdb.org/t/p/w200${movie.poster_path}"/>
			<ul class="list-group mb-2">
				<li class="list-group-item">Average Rating: <c:out value="${movie.vote_average}"/> /10</li>
				<li class="list-group-item">Description: <c:out value="${movie.overview}"/></li>
				<li class="list-group-item">Released: <c:out value="${movie.release_date}"/></li>
				<li class="list-group-item">Runtime: <c:out value="${movie.runtime}"/></li>
				<li class="list-group-item">Genres: <c:forEach items="${movie.genres}" var="i"><c:out value="${i.name} "/></c:forEach></li>
			</ul>
			<button class="btn btn-success w-25 align-self-end">Add To My Watch-list</button>
			</div>
		</div>
	</div>
</body>
</html>