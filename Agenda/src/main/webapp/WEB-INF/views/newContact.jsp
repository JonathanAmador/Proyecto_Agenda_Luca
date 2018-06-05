<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<spring:url value="/resources/css/estilos.css" var="estilos" />
<link href="${estilos}" rel="stylesheet" />
<!-- Theme Made By www.w3schools.com - No Copyright -->
<title>Bootstrap Theme Simply Me</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

	<!-- Navbar -->
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Me</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><form>Ver Contactos: no funcional</form></li>
					<li>OPCION3</li>
					<li>OPCION2</li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- First Container -->
		<div align="center">
		<h1>FORMULARIO DE USUARIOS (add/edit)</h1>
		<table>
			<form:form action="save" method="post" modelAttribute="user">
				<form:hidden path="idPersona" />
				<tr>
					<td>Usuario:</td>
					<td><form:input path="nombre" /></td>
				</tr>
				<tr>
					<td>Apellidos:</td>
					<td><form:input path="Apellido1" /></td>
				</tr>
				<tr>
					<td>DNI:</td>
					<td><form:password path="dni" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Guardar Registro"></td>
				</tr>
			</form:form>
		</table>
	</div>



	<!-- Footer -->
	<footer class="container-fluid bg-4 text-center">
		<p>
			Referencia <a href="https://www.w3schools.com">www.w3schools.com</a>
		</p>
	</footer>

</body>
</html>