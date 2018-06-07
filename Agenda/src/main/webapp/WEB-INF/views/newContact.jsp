
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Agenda de contactos LucaTic</title>

<spring:url
	value="/https://fonts.googleapis.com/css?family=Hind:400,700"
	var="fonts" />
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
	<!-- HEADER -->
	<header>
		<!-- top Header -->
		<div id="top-header">
			<div class="container">
				<div class="pull-left">
					<span>Proyecto Spring Java</span>
				</div>

			</div>
		</div>
		<!-- /top Header -->

		<!-- header -->
		<div id="header">
			<div class="container">
				<div class="pull-left">
					<!-- Logo -->
					<div class="header-logo">
						<a class="logo" href="#">
							<h1>Agenda de contactos</h1>
						</a>
					</div>

					<img alt=""
						src="http://www.apexunderwriting.com/images/inner-banner-6.jpg">
					<!-- /Logo -->
				</div>
			</div>
			<!-- header -->
		</div>
		<!-- container -->
	</header>
	<!-- /HEADER -->

	<!-- NAVIGATION -->
	<div id="navigation">
		<!-- container -->
		<div class="container">
			<div id="responsive-nav">
				<!-- category nav -->
				<div class="category-nav"> <span class="category-header">Categorias
					<i class="fa fa-list"></i>
				</span>
				<form method="POST" action="FilmListSelect.do">
					<ul class="category-list">


						<li><a href="showCategory?id=1">Programador</a></li>
						<li><a href="showCategory?id=2">Anal�sta</a></li>
						<li><a href="showCategory?id=3">T�cnico Recursos Humanos</a></li>
						<li><a href="showCategory?id=4">Secretaria</a></li>
						<li><a href="showCategory?id=5">Recepcionista</a></li>
						<li><a href="showCategory?id=6">Master del Universo</a></li>

					</ul>
				</form>
			</div>
			<!-- /category nav -->

			<!-- menu nav -->
			<div class="menu-nav">
				<span class="menu-header">Menu <i class="fa fa-bars"></i></span>
				<ul class="menu-list">
					<li><a href="new">Nuevo contacto</a></li>
					<li><a href="listar">Lista de Contactos</a></li>

				</ul>
			</div>
			<!-- menu nav -->
		</div>
	</div>
	<!-- /container -->
	</div>
	<!-- /NAVIGATION -->

	<!-- HOME -->
	<div id="home">
		<!-- container -->
		<div class="container">
			<!-- home wrap -->
			<div class="home-wrap">
				<!-- home slick -->

				<!-- BREADCRUMB -->
				<div class="header-search">
					<form method="post" commandName="persona" action="showListContact">
						<input name="consulta" class="input search-input" type="text"
							placeholder="Introduce el nombre del contacto" size="100">
						<button type="submit" class="search-btn" value="buscar">
							<a class="buscar"> Buscar</a>
						</button>
					</form>
				</div>
				<!-- /BREADCRUMB -->
				<h1>Nuevo Usuario</h1>

				<form:form method="post" commandName="persona" action="save">
					<table>
						<tr>
							<td><form:label path="nombre">Nombre</form:label></td>
							<td><form:input path="nombre" /></td>
						</tr>
						<tr>
							<td><form:label path="apellido1">Apellido 1</form:label></td>
							<td><form:input path="apellido1" /></td>
						</tr>
						<tr>
							<td><form:label path="apellido2">Apellido 2</form:label></td>
							<td><form:input path="apellido2" /></td>
						</tr>
						<tr>
							<td><form:label path="dni">DNI</form:label></td>
							<td><form:input path="dni" /></td>
						</tr>
						<tr>
							<td><form:label path="fechaNacimiento">Fecha nacimiento</form:label></td>
							<td><form:input path="fechaNacimiento" /></td>
						</tr>
						<tr>
							<td><form:label path="direcciones.idDireccion">Id direccion</form:label></td>
							<td><form:input path="direcciones.idDireccion" /></td>
						</tr>
						<tr>
							<td><form:label path="direcciones.direccion">Direccion</form:label></td>
							<td><form:input path="direcciones.direccion" /></td>
						</tr>
						<tr>
							<td><form:label path="direcciones.codPostal">Codigo Postal</form:label></td>
							<td><form:input path="direcciones.codPostal" /></td>
						</tr>
						<tr>
							<td><form:label path="direcciones.localidad">Localidad</form:label></td>
							<td><form:input path="direcciones.localidad" /></td>
						</tr>
						<tr>
							<td><form:label path="direcciones.provincia">Provincia</form:label></td>
							<td><form:input path="direcciones.provincia" /></td>
						</tr>
						<tr>
							<td><form:label path="idEmpleado.idEmpleado">Id empleado</form:label></td>
							<td><form:input path="idEmpleado.idEmpleado" /></td>
						</tr>
						<tr>
							<td><form:label path="idEmpleado.codEmpleado">C�digo empleado</form:label></td>
							<td><form:input path="idEmpleado.codEmpleado" /></td>
						</tr>
						<tr>
							<td><form:label path="idEmpleado.salario">Salario</form:label></td>
							<td><form:input path="idEmpleado.salario" /></td>
						</tr>
						<tr>
							<td><form:label path="idEmpleado.fechaAlta">Fecha  de alta</form:label></td>
							<td><form:input path="idEmpleado.fechaAlta" /></td>
						</tr>
						<tr>
							<td>
							<form:select path="idEmpleado.departamentos.iddepartamento">
								
								<form:option items="idEmpleado.departamentos.iddepartamento" value="1">RRHH</form:option>
								<form:option items="idEmpleado.departamentos.iddepartamento" value="2">Informatica</form:option>
								<form:option items="idEmpleado.departamentos.iddepartamento" value="3">Log�stica</form:option>
								<form:option items="idEmpleado.departamentos.iddepartamento" value="4">Direcci�n</form:option>
							</form:select></td>
							
						</tr>
						<tr>
							<td>
							<form:select path="idEmpleado.categorias.idcategorias">
								<form:option value="1">Programador</form:option>
								<form:option value="2">Anal�sta</form:option>
								<form:option value="3">T�cnico Recursos Humanos</form:option>
								<form:option value="4">Secretaria</form:option>
								<form:option value="5">Recepcionista</form:option>
								<form:option value="6">Master del Universo</form:option>
							</form:select></td>
						</tr>
					</table>
					<br />
					
						<input type="submit" value="Dar de alta" />
				</form:form>



				<!-- /home slick -->
			</div>
			<!-- /home wrap -->
		</div>
		<!-- /container -->
	</div>
	<!-- /HOME -->

	<!-- section -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row"></div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>


	<!-- FOOTER -->
	<footer id="footer" class="section section-grey">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row"></div>
			<!-- /row -->
			<hr>
			<!-- row -->
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<!-- footer copyright -->
					<div class="footer-copyright">
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;
						<script>
							document.write(new Date().getFullYear());
						</script>
						Todos derechos reservados | por <a href="https://colorlib.com"
							target="_blank">Grupo A LucaTic</a>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</div>
					<!-- /footer copyright -->
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</footer>
	<!-- /FOOTER -->

</body>

</html>
