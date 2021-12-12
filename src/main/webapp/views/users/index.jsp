<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
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
			<h1>Estas son las atracciones de la Tierra Media</h1>
		</div>
		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th></th>
					<th>Nombre de Usuario</th>
					<th>Monedas</th>
					<th>Tiempo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><img src="<c:url value="${user.getImg()}"/>" alt="n/a" width="50" height="50"/></td>
						<td><strong><c:out value="${user.getUsername()}"></c:out></strong></td>
						<td><strong><c:out value="${user.getTime()}"></c:out></strong></td>
						<td><strong><c:out value="${user.getCoins()}"></c:out></strong></td>
						<td>
							<a href="/TierraMedia/users/edit.do?id=${user.getId()}"
								class="btn btn-light rounded-0" role="button"><i
								class="bi bi-pencil-fill"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</main>

</body>
</html>