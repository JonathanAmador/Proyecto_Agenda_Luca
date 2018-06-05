<!-- 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
-->
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Agenda de contactos LucaTic</title>

<!-- Google font -->
<link href="https://fonts.googleapis.com/css?family=Hind:400,700"
	rel="stylesheet">

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

<!-- Font Awesome Icon -->
<link rel="stylesheet" href="css/font-awesome.min.css">

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="css/style.css" />

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
				<div class="category-nav">
					<span class="category-header">Categorias <i
						class="fa fa-list"></i></span>
					<form method="POST" action="FilmListSelect.do">
						<ul class="category-list">


							<li><a href="#">Programador</a></li>
							<li><a href="#">Analísta</a></li>
							<li><a href="#">Técnico Recursos Humanos</a></li>
							<li><a href="#">Secretaria</a></li>
							<li><a href="#">Recepcionista</a></li>
							<li><a href="#">Master del Universo</a></li>

						</ul>
					</form>
				</div>
				<!-- /category nav -->

				<!-- menu nav -->
				<div class="menu-nav">
					<span class="menu-header">Menu <i class="fa fa-bars"></i></span>
					<ul class="menu-list">
						<li><a href="new">Nuevo contacto</a></li>

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
				<!-- Search -->
				<div class="header-search">
					<form>
						<input class="input search-input" type="text"
							placeholder="Introduce el nombre del contacto" size="100">
						<button class="search-btn">
							<i class="fa fa-search"></i>
						</button>
					</form>
				</div>
				<!-- /Search -->
				<!-- /BREADCRUMB -->
				<h1>Lista de contactos</h1>

				<table>
					<tr>
						<th>Nombre</th>
						<th>Apellidos</th>
						<th>Teléfono</th>
						<th>Departamento</th>
						<th>Categoría</th>

					</tr>

					<c:forEach var="contact" items="${listContact}" varStatus="status">
						<tr>
							<td>${contact.nombre}</td>
							<td>${contact.apellido1},${contact.apellido2}</td>
							<td><c:forEach  var="entry" items="${contact.telefonos}">
    								 ${entry.telefono}<br>
								</c:forEach> 
							</td>
							<td>${contact.idEmpleado.departamentos.nombre}</td>
							<td>${contact.idEmpleado.categorias.nombre }</td>
							<td><a href="edit?id">Modificar</a></td>
							<td><a href="deleted?id">Eliminar</a></td>
						</tr>
					</c:forEach>




				</table>





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
