<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>select-multiple</title>
<style>
       /* option:checked:before { content: "✓" } */
       option:before { content: "☐ " }
       option:checked:before { content: "☑ " }s
</style>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">
		<form action="/TierraMedia/promotions/fill.do" method="post">
		<input type="hidden" name="type" value="${promotion.getType()}">
		<input type="hidden" name="typeP" value="${promotion.getTypeProm()}">
		<input type="hidden" name="name" value="${promotion.name}">
			<div class="modal-body">
				<div class="mb-3">
					<label for="attraction" class="col-form-label">Atracciones:</label></br> 
					<select name="myselect" multiple="multiple" class="form-control">
			            <c:forEach items="${attractionsList}" var="attraction">
			                <option name="attraction" value="${attraction.getId()}"> ${attraction.getName()} </option>
			            </c:forEach>
			        </select>
				</div>
			</div>
				<c:if test="${promotion.isPORCENTUAL()}">
					<div>
						<div class="mb-3">
						<label for="discount"
							class='col-form-label ${promotion.errors.get("discount") != null ? "is-invalid" : "" }'>Descuento:</label>
						<input class="form-control" type="number" id="discount" name="discount"
							required value="${promotion.getDiscount()}"></input>
						<div class="invalid-feedback">
							<c:out value='${attraction.errors.get("discount")}'></c:out>
						</div>
					</div>
				</c:if>
			<div>
				<button type="submit" class="btn btn-primary">Guardar</button>
				<a onclick="window.history.back();" class="btn btn-secondary"
					role="button">Cancelar</a>
			</div>
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
