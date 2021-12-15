<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<link href="assets/stylesheets/index/index.css" rel="stylesheet" type="text/css">
<link href="https://allfont.es/allfont.css?fonts=ringbearer-medium" rel="stylesheet" type="text/css" />
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
	<jsp:include page="partials/nav.jsp"></jsp:include>
	<main class="container">
		<div class="bg-light p-4 rounded">
			<h1>
				Bienvenido, <c:out value="${user.username}" />!
			</h1>
		</div>
	</main>
</body>

</html>
