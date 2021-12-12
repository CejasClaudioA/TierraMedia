<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="username" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="username" name="username"
			required value="${user.getUsername()}">
	</div>
	<div class="mb-3">
		<label for="coins"
			class='col-form-label ${user.errors.get("coins") != null ? "is-invalid" : "" }'>Monedas:</label>
		<input class="form-control" type="number" id="coins" name="coins"
			required value="${user.getCoins()}"></input>
		<div class="invalid-feedback">
			<c:out value='${user.errors.get("coins")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="time"
			class='col-form-label ${user.errors.get("time") != null ? "is-invalid" : "" }'>Tiempo:</label>
		<input class="form-control" type="number" id="time" name="time"
			required value="${user.getTime()}"></input>
		<div class="invalid-feedback">
			<c:out value='${user.errors.get("time")}'></c:out>
		</div>
	</div>
</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
