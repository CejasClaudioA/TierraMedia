<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mb-3">
	<label for="name" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="name" name="name"
		required value="${promotion.getName()}">
</div>
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
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>


	