<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<c:set var="path" value="${pageContext.request.contextPath}" scope="request" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="${path}/static/js/jugador.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</head>
<body>
<h1>esto es listado de jugador</h1>
	<h1>${titulo}</h1>

	<table
		class="table table-hover table-condensed table-striped table-bordered">
		<thead>
			<tr>
				<td style="width: 10%">#</td>
				<td style="width: 30%">Nombre</td>
				<td style="width: 20%">Edad</td>
				<td style="width: 10%">Goles</td>
				<td style="width: 10%">Equipo</td>
				<td style="width: 10%">Editar</td>
				<td style="width: 10%">borrar</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${jugadores}" var="jugador">
				<tr data-id="${jugador.id}">
					<td>${jugador.id}</td>
					<td>${jugador.nombre}</td>
					<td>${jugador.edad}</td>
					<td>${jugador.goles}</td>
					<td>
					${jugador.equipo.nombre}
					</td>
					<td><button type="submit" class="btn btn-warning btn-editar">Editar</button></td>
					<td><button type="button" class="btn btn-danger btn-borrar-1">borrar</button></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">Jugador registrada: <span
					id="cantidades-jugador">${jugadores.size()}</span></td>
			</tr>
			<tr>
				<td colspan="5">
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#modal-jugador">Registrar Jugador</button>
				</td>
			</tr>
		</tfoot>
	</table>
	<div class="modal fade" id="modal-jugador" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="form-jugador" method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">Informacion de jugador</h4>
					</div>
					<div class="modal-body">
							<label for="nombre">Nombre: </label>
							 <input id="nombre" name="nombre" class="form-control"/> 
							
							<label for="nombre">Edad: </label> 
							<input id="edad" name="edad" class="form-control"/> 
							
							<label for="nombre">Goles: </label> 
							<input id="goles" name="goles" class="form-control"/>
							
							<label for="equipos">Equipos: </label> 
							
							<select id="equipo" name="equipo" class="form-control">
								
							<c:forEach items="${equipos}" var="equipo">
								<option value="${equipo.id}">${equipo.nombre}</option>
							</c:forEach>
							
						
						<input id="id" name="id" type="hidden" value=""/>
						
						<input id="csrf" name="_csrf" type="hidden" value="${_csrf.token}">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<button id="btn-salvar" type="submit" class="btn btn-primary">Guardar
							informacion</button>
					</div>
				</form>
			</div>
		</div>
	</div>
<div class="modal fade" id="modal-jugador-1" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="form-jugador" method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">borrar de jugador.....</h4>
					</div>
					<div class="modal-body">
						
						<input id="id-borrar" name="id" type="hidden" value=""/>
						
						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<button id="btn-borrar" type="button" class="btn btn-danger">Confirmar borrar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>