<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<style>
	/* option:checked:before { content: "✓" } */
	option:before { content: "☐ " }
	option:checked:before { content: "☑ " }
</style>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">

		<c:if test="${promotion != null && !promotion.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al actualizar la promocion.</p>
			</div>
		</c:if>

		<form action="/TierraMedia/promotions/edit.do" method="post">
			<input type="hidden" name="id" value="${promotion.id}">
			<input type="hidden" name="typeP" value="${promotion.getTypeProm()}">
			<jsp:include page="/views/promotions/formEdit.jsp"></jsp:include>
		</form>
	</main>
	<script>
		$('option').mousedown(function(e) {
	    	e.preventDefault();
	   		$(this).prop('selected', !$(this).prop('selected'));
	    	return false;
		});
	</script>
</body>
</html>
