<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="name" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="name" name="name"
			required value="${promotion.getName()}">
	</div>
	<div class="mb-3">
		<label for="typeAtracction" class="col-form-label">Tipo de Atraccion:</label></br> 
		<select name="typeAttraction" class="form-control">
			<option selected disabled>Eligir uno</option>
            <c:forEach items="${typeAttractions}" var="typeAttraction">
                <option name="typeAttraction" value="${typeAttraction.getDesc()}"> ${typeAttraction.getDesc()} </option>
            </c:forEach>
        </select>
	</div>
	<div class="mb-3">
		<label for="typePromotion" class="col-form-label">Tipo de Promocion:</label></br> 
		<select name="typePromotion" class="form-control">
			<option selected disabled>Eligir uno</option>
            <c:forEach items="${typePromotions}" var="typePromotion">
                <option name="typePromotion" value="${typePromotion.getDesc()}"> ${typePromotion.getDesc()} </option>
            </c:forEach>
        </select>
</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
