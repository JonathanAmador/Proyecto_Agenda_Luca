<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Agenda de contactos LucaTic</title>
 
<spring:url value="/https://fonts.googleapis.com/css?family=Hind:400,700" var="fonts" />
<link href="${fonts}" rel="stylesheet" />

<spring:url value="/static/css/bootstrap.min.css" var="estilos1" />
<link href="${estilos1}" rel="stylesheet" />

<spring:url value="static/css/style.css" var="style" />
<link href="${style}" rel="stylesheet" />

<spring:url value="css/bootstrap.min.css" var="estilos2" />
<link href="${estilos2}" rel="stylesheet" />

<link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"></link>



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