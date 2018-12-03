<g:set var='securityConfig' value='${applicationContext.springSecurityService.securityConfig}'/>
<html>
<head>
	<meta name="layout" content="main"/>
	<!--->
	<link href="https://fonts.googleapis.com/css?family=Arimo" rel="stylesheet">
	<asset:stylesheet src="navbar.css" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<style>
body{
	font-family:'Arimo', sans-serif;
}
#container-login{
	background-image:url("${resource(dir:"images",file:"hospital-waiting-room.jpg")}");
	background-repeat: no-repeat;
	background-size:100%;
}
.login-form{
	border-radius:10px;
	background-color:#ffffff;
	height:500px;
	width:400px;
	margin: 50px auto 20px auto;
	padding:30px 70px 0px 70px;
}
.btn-login {
	margin-top:10px;
	/*margin-left: 5.5%;*/
	background-color:#21d192;
	-moz-border-radius:7px;
	-webkit-border-radius:7px;
	border-radius:7px;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-size:15px;
	font-weight:bold;
	padding:5px 25px;
	text-decoration:none;
}
.btn-login:hover {
	background-color:#21d175;
}
.btn-login:active {
	position:relative;
	top:1px;
}
.form-control{
	margin-bottom: 10px;
}
.form-control:focus {
	border-color:#CCC;
	box-shadow: inset 0 1px 1px rgba(50, 50, 50, 0.03), 0 0 8px rgba(33,209,117,0.5);
}
</style>
</head>
<body>
<div class="container-fluid" id="container-navbar">
	<nav class="navbar navbar-expand-lg">
		<a class="navbar-brand" href="#">Gestion de Turnos</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="navbar-collapse collapse w-100 order-3">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active">
					<a class="nav-link" href="#">INICIO<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">INICIAR SESION</a>
				</li>
			</ul>
		</div>
	</nav>
</div>
<div class="container-fluid" id="container-login">
	<!-- columna para login -->
	<div class="row">
			<s2ui:form type='login' focus='username' class="login-form">

				<h1 class="h2">Login</h1>
				<div class="form-group">
					<label for="username">Usuario</label>
					<input type="text" name="${securityConfig.apf.usernameParameter}" id="username" class='form-control' size="20"/>
				</div>
				<div class="form-group">
					<label for="password">Contraseña</label>
				    <input type="password" name="${securityConfig.apf.passwordParameter}" id="password" class="form-control" size="20"/>
				</div>
				<div class="form-check">
					<input type="checkbox" class="checkbox form-check-input" name="${securityConfig.rememberMe.parameter}" id="remember_me" checked="checked"/>
					<label for='remember_me' class="form-check-label">Recordar mi cuenta</label>
				</div>
				<div class="text-center">
					<s2ui:submitButton class="btn btn-login" elementId='loginButton' messageCode='spring.security.ui.login.login'/>
					<s2ui:linkButton class="link" elementId='register' controller='register' messageCode='spring.security.ui.login.register'/>
					<span class="forgot-link">
						<g:link controller='register' action='forgotPassword'>Recuperar Contraseña</g:link>
					</span>
				</div>
			</s2ui:form>
		</div>
</div>
<!-- Footer -->
<footer class="page-footer font-small blue-grey lighten-5">
	<div class="container-fluid" style="background-color: #21d192;">
		<br>
	</div>
	<!-- Footer Links -->
	<div class="container text-center text-md-left mt-5">
		<!-- Grid row -->
		<div class="row mt-3 dark-grey-text">
			<!-- Grid column -->
			<div class="col-md-3 col-lg-4 col-xl-3 mb-4">
				<!-- Content -->
				<h6 class="text-uppercase font-weight-bold">Sistema Gestion</h6>
				<hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
				<p>Para más información, dirigirse a www.sgt.com.ar</p>
			</div>
			<!-- Grid column -->
			<div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
				<!-- Links -->
				<h6 class="text-uppercase font-weight-bold">ayuda</h6>
				<hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
				<p>
					<a class="dark-grey-text" href="#!">Crear turno</a>
				</p>
				<p>
					<a class="dark-grey-text" href="#!">Crear una cuenta</a>
				</p>
				<p>
					<a class="dark-grey-text" href="#!">Cancelar turno</a>
				</p>
				<p>
					<a class="dark-grey-text" href="#!">Preguntas Frecuentes</a>
				</p>

			</div>
			<!-- Grid column -->
			<!-- Grid column -->

			<!-- Grid column -->
			<!-- Grid column -->
			<div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
				<!-- Links -->
				<h6 class="text-uppercase font-weight-bold">Contacto</h6>
				<hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
				<p>
					<!-- acá debería ir un logo de flat icon-->TDF, Calle 123, Argentina</p>
				<p>
					<!-- acá debería ir un logo -->sgt@gmail.com</p>
				<p>
					<!-- acá debería ir un logo -->+ 54 2091 000000</p>
			</div>
			<!-- Grid column -->
		</div>
		<!-- Grid row -->
	</div>
	<!-- Footer Links -->
</footer>

<!-- Footer -->

</body>
</html>
