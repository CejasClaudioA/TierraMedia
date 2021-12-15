<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <link href="https://allfont.es/allfont.css?fonts=ringbearer-medium" rel="stylesheet" type="text/css" />
    <style>
      h3 {
        font-family: 'Ringbearer Medium', arial;
      }
    </style>
  </head>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
	<div class="container-fluid">
		<a class="navbar-brand" href="/TierraMedia/index.jsp"><h3>Turismo en la Tierra Media</h3></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-md-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/TierraMedia/attractions/index.do"> <h5 style="color:#ffd700">Atracciones</h5> </a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/TierraMedia/promotions/index.do"><h5 style="color:#ffd700">Promociones</h5></a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/TierraMedia/sessions/index.do"><h5 style="color:#ffd700">Itinerario</h5></a></li>
			</ul>
					
			<ul class="navbar-nav">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						<c:if test="${user.admin}">
							<h6 style="color:#ffff00">(Admin)</h6>
						</c:if>
						<img src="<c:url value="${user.getImg()}"/>" alt="n/a" width="50" height="50"/>
						<c:out value="${user.username}"></c:out>
					</a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item disabled" style="color: black;">
							<i title="monedas" style="color: green;" class="bi bi-cash-coin"></i> <c:out value="${user.coins}"></c:out>
						</a></li>
						<li><a class="dropdown-item disabled" style="color: black;">
							<i title="tiempo" style="color: black;" class="bi bi-clock-fill"></i> <c:out value="${user.time}h"></c:out>
						</a></li>
						<li><hr class="dropdown-divider"></li>
						<c:if test="${user.admin}">
							<li class="nav-item"><a class="dropdown-item"
								aria-current="page" href="/TierraMedia/sessions/itinerary.do">Itinerario de cada usuario</a></li>
							<li class="nav-item"><a class="dropdown-item"
								aria-current="page" href="/TierraMedia/users/index.do">Editar Usuarios</a></li> 
						</c:if>
						<li><a href="/TierraMedia/logout" class="dropdown-item">Salir</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>
