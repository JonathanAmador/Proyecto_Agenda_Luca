<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
					<li>OPCION3</li>
					<li>OPCION2</li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- First Container -->
	<div class="container-fluid bg-1 text-center">
		<h3>Lista de contactos</h3>
		<c:forEach var="contact" items="${listContact}">
			<form method="POST" action="showContact">
				<div class="product-body">
					<h4 class="contact-name">${contact.name}</h4>
					<h4 class="contact-surname">${contact.surname}</h4>
				</div>
			</form>
		</c:forEach>
		<div>
                <table>
                	<c:forEach var="user" items="${userList}" varStatus="status">
	                	<tr>
	                        <td>${contact.name}</td>
	                        <td>${contact.surname}</td>
	                        <td><a href="edit?id=${contact.id}">Modificar</a></td>
							<td><a href="delete?id=${user.id}">Eliminar</a></td>
							<td></td>
	                    </tr>
                	</c:forEach>             
                </table> 
        </div>
	</div>



	<!-- Footer -->
	<footer class="container-fluid bg-4 text-center">
		<p>
			Referencia <a href="https://www.w3schools.com">www.w3schools.com</a>
		</p>
	</footer>

</body>
</html>