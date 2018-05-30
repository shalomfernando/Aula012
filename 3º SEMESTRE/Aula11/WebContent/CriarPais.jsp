<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
	integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" href="css/style.css" />
<title>Cadastro de Pais</title>
</head>
<body>
<c:import url="menu.jsp"/> 
<div class="col-6" id="cadastro">
	<nav class="container-fluid">
		
			<h3>Cadastro de Pais</h3>
			<h5>
			
				<form action="controller.do" method="post">

					<div class="form-group row">
						<label for="example-text-input" class="col-2 col-form-label"
							name="nome">Nome:</label><br>
						<div class="col-10">
							<input name="nome" class="form-control" type="text"
								placeholder="França" id="example-text-input">
						</div>
					</div>
					<div class="form-group row">
						<label for="example-text-input" class="col-2 col-form-label"
							type="text" name="populacao" id="populacao">Populacão:</label><br>
						<div class="col-10">
							<input name="populacao" class="form-control" type="text"placeholder="66000000" id="example-text-input">
						</div>
					</div>
					<div class="form-group row">
						<label for="example-text-input" class="col-2 col-form-label"
							type="text" name="area" id="area">Area:</label><br>
						<div class="col-10">
							<input name="area" class="form-control"  type="text"
								placeholder="643.801" id="example-text-input">
						</div>
					</div>
					<button class="btn btn-success" type="submit" name="command" value="CriarPais">Enviar</button>
						<a href="INDEX.jsp" class="btn btn-default">Cancelar</a>
				</form>
			</h5>
			</nav>
		</div>
		

  <script src="js/jquery.min.js"></script>     <script src="js/bootstrap.min.js"></script> 
</body>
</html>