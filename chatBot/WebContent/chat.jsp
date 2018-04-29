<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@page import="pacote.Cliente"%>
<%@page import="pacote.ChatB"%>
<%@ page import="pacote.Conversa"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; harset=UTF-8">
<title>ChatBot</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body background="img/books.jpg">


	<nav id="mainNav"
		class="navbar navbar-default navbar-fixed-top navbar-custom">
	<div class="container">
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> Menu <i
					class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand" href="home.html"><a href="#menu-toggle"
				class="btn btn-secondary p1" id="menu-toggle">Cartório</a></a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="page-scroll"><a href="index.html">Cadastrar-se</a></li>
			</ul>
		</div>
	</div>
	</nav>


	<h6>
		<%
			Cliente cli = (Cliente) session.getAttribute("cliente");
		%>
		id :=
		<%=cli.getId()%><br> Nome: =
		<%=cli.getNome()%><br> email: =
		<%=cli.getEmail()%><br>
	</h6>
	<center>
		<font color="white"><h3>
				Bem-Vindo ao Chat Boot<br>
				<%=cli.getNome()%><br></font>

		</h3>
	</center>
	<hr>



	<form name="chatBController.do" action="chatBController.do"
		method="post">

		<div class="row">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<form name="sentMessage" id="contactForm" novalidate>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<font color="white"> </font> <input type="text" id="pergunta"
									class="form-control" placeholder="Faça sua pergunta"
									name="pergunta">
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<textarea class="form-control" name="txtMessage" rows="20"
									cols="70">
         	<%
         		out.println(" ");
         		String MENSSAGEM_DE_ENTRADA = "Bot:  Ola, " + cli.getNome() + "! Qual a sua duvida? ";
         		ChatB chat = (ChatB) session.getAttribute("chat");
         		out.println(MENSSAGEM_DE_ENTRADA);
         		for (Conversa conversa : chat.getConversas()) {
         			out.println(cli.getNome() + ": " + conversa.getPergunta());
         			out.println("Bot: " + conversa.getResposta());
         		}
         	%>
         </textarea>
							</div>
						</div>
						<div id="success">
							<center>
								<div class="row">

									<div class="form-group col-xs-12">
										<button type="submit" value="Enviar" name="cmdSend"
											class="btn btn-success btn-lg">Enviar</button>
									</div>

								</div>
							</center>
						</div>
					</form>
				</div>
			</div>
		</div>


		</section>

		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
</body>
</html>