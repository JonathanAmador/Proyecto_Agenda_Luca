<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de contactos</title>
</head>

<body>
	<var ="contact" items="${contact}">
		<h1>${contact.name}</h1>
		<h3>${contact.surname1}</h3>
		<h3>${contact.surname2}</h3>
		<h3>${contact.dni}</h3>

		<c:forEach var="contact" items="${contact.phone}">
		<h3>${contact.phone}</h3>
		</c:forEach>

		<h3>${contact.department}</h3>
		<h3>${contact.category}</h3>
		<h3>${contact.address}</h3>
		<h3>${contact.postalCode}</h3>
		<h3>${contact.location}</h3>
		<h3>${contact.province}</h3>
		<h3>${contact.empCode}</h3>
		<h3>${contact.salary}</h3>
		<h3>${contact.hiringDate}</h3>
</body>

</html>