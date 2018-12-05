<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Logueado como Administrador</title>
    <link href="https://fonts.googleapis.com/css?family=Arimo" rel="stylesheet">
    <asset:stylesheet src="navbar.css" />
    <link rel="stylesheet" href="css/flaticon/font/flaticon.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.48.0/mapbox-gl.js'></script>
    <link href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.48.0/mapbox-gl.css' rel='stylesheet' />
<style>
    body{
       font-family:'Arimo', sans-serif;
    }
    .link-acceso{
        color:black;
    }
    .link-acceso:hover{
        text-decoration:none;
        color:#21d192;
    }
    .imagen-acceso{
        margin-bottom: 20px;
        margin-top: 10px;
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
                            <li class="nav-item">
                                <!-- no sé porqué me lo lleva al login -->
                                <a class="nav-link" href="/indexControllers">indexControllers</a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="#">INICIO<span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="login/auth">INICIAR SESION</a>
                            </li>
                        </ul>
                    </div>
                  </nav>
              </div>    
            <div class="container-fluid">
                <h1>LOGUEADO COMO ADMINISTRADOR, EN UN MOMENTO SERA REDIRIGIDO</h1>
            </div>
</body>
</html>