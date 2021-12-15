<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<link href="assets/stylesheets/login/login.css" rel="stylesheet" type="text/css">
<link href="https://allfont.es/allfont.css?fonts=ringbearer-medium" rel="stylesheet" type="text/css" />
<style>
	body {
	    background-image: url("assets/images/backgrounds/bg4.jpg");
	    background-attachment: fixed;
	    background-position: center center;
	    background-size: cover; 
	}
	h1 {
		font-family: 'Ringbearer Medium', arial;
        text-align: center;
        color: #ffd700;
        position : center; 
	}
</style>
</head>
<body>
	<div class="col-lg-5 mx-auto p-3 py-md-5">
		<main>
			<h1>Turismo</h1>
			<h1>en la</h1>
			<h1>Tierra Media</h1></br>
			<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>
			<div class="bg-light p-4 rounded">
				<form action="login" method="post">
	
					<div class="mb-3">
						<label for="username" class="form-label">Usuario</label> <input
							class="form-control" name="username">
					</div>
	
					<div class="mb-3">
						<label for="password" class="form-label">Contraseña</label> <input
							type="password" class="form-control" name="password">
					</div>
	
					<div class="d-grid gap-2">
						<button type="submit" class="btn btn-lg btn-primary">Ingresar</button>
					</div>
				</form>
			</div>
		</main>
	</div>
</body>
</html>