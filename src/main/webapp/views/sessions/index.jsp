<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<style>
	body {
	    background-image: url("assets/images/backgrounds/bg3.jpg");
	    background-attachment: fixed;
	    background-position: center center;
	    background-size: cover;
	}
	
	h1 {
		font-family: 'Ringbearer Medium', arial;
        font-size: 48px;
        text-shadow: 4px 4px 4px #aaa; 
	}
	
	h5 {
		font-family: 'Ringbearer Medium', arial;
        font-size: 24px;
        text-shadow: 4px 4px 4px #aaa; 
	}
</style>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">

		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errors != null}">
						<ul>
							<c:forEach items="${errors}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>

		<div class="bg-light p-4 mb-3 rounded">
			<h1>Estas son las atraciones que has comprado</h1>
		</div>

		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th></th>
					<th>Atracci&oacute;n</th>
					<th>Costo</th>
					<th>Duraci&oacute;n</th>
					<th>Cupo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${attractions}" var="attraction">
					<tr>
						<td><img src="<c:url value="${attraction.getImg()}"/>" alt="n/a" width="200" height="125"/></td>
						<td><strong><c:out value="${attraction.name}"></c:out></strong>
							<p>${attraction.getDesc()}</p></td>
						<td><c:out value="${attraction.cost}"></c:out></td>
						<td><c:out value="${attraction.duration}"></c:out></td>
						<td><c:out value="${attraction.capacity}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>