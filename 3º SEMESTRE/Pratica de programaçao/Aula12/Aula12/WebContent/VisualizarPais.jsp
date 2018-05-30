<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" href="css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carregar Pais</title>
</head>
<body>
	<!-- Modal -->
	<div class="modal" id="delete-modal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="modalLabel">Excluir Pais</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Deseja realmente excluir este pais?</div>
				<div class="modal-footer">
					<form action="controller.do" method="post">
						<input type="hidden" name="id" value="${pais.id }" />
						<button type="submit" class="btn btn-primary" name="command"
							value="ExcluirCliente">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->

	<c:import url="menu.jsp" />
	<div id="main" class="container">
	<div class="col-6" id="cadastro">
		<h3 class="page-header">Visualizar Paises ${pais.id }</h3>
		<div class="row">
			<div class="col-md-12">
				<h3 class="page-header">
					<strong style="font-size: 20px">Nome</strong>
				</h3>

				<p>${pais.nome }</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<h3 class="page-header">
					<strong style="font-size: 20px">População</strong>
				</h3>

				<p>${pais.populacao }</p>
			</div>
			<div class="col-md-6">
				<h3 class="page-header">
					<strong style="font-size: 20px">Area</strong>
				</h3>

				<p>${pais.area }</p>
			</div>
		</div>
		</div>
		<hr  style="margin-top: 0rem; margin-bottom: 0rem;">
		<div id="actions" class="row conteudoB">
			<div class="col-md-12" style="text-align: right;">
				<a href="controller.do?command=EditarPais&id=${pais.id }"
					class="btn btn-primary">Editar</a> <a href="#"
					class="btn btn-danger" data-toggle="modal"
					data-target="#delete-modal">Excluir</a> <a href="ListarPais.jsp"
					class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
