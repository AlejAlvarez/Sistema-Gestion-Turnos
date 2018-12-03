<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Página Bienvenida</title>
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
                                <a class="nav-link" href="indexControllers">indexControllers</a>
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
                <div class="row">
                    <img class="img-responsive img" src="${resource(dir:"images",file:"hospitalbannerverde.jpg")}" width="100%" height="350px"/>
                </div>
                <div class="row text-center" style="margin-top:20px;">
                    <div class="col-md-4">
                        <a class="link-acceso" href="#">
                            <!--icono para sacar turno --> 
                            <img class=" img img-responsive imagen-acceso" src="${resource(dir:"images",file:"001-clinic.png")}" />
                            <h2>Turnos</h2>
                            <p>Reservar un turno de manera on-line</p></a>
                    </div> 
   
                    <div class="col-md-4">
                        <a class="link-acceso" href="#">
                        <!-- icono para ver los horarios de especialidades -->
                        <img class="img img-responsive imagen-acceso" src="${resource(dir:"images",file:"002-doctor.png")}" />
                        <h2>Especialidades</h2>
                        <p>Puede observar los horarios de cada especialidad</p></a>
                    </div>
                    <div class="col-md-4">
                        <a class="link-acceso" href="#">
                        <!-- icono para informacion de atencion y contacto: (Teléfono, correo, etc ) -->
                        <img class="img img-responsive imagen-acceso" src="${resource(dir:"images",file:"003-hospital.png")}" />
                        <h2>Contacto</h2>
                        <p>Información de contacto: teléfono, e-mail, etc.</p></a>
                    </div>
                </div>
            </div>  
            <div class="container">
                        <div id="map" style="height:500px;width:1000px;margin:auto;"></div>
                        <script>
                               mapboxgl.accessToken = 'pk.eyJ1IjoiZ3JvbG9uIiwiYSI6ImNqbGR6bmxvMzAwdDAzdmw1dnk5Mzl5bWYifQ.FSVBSNw_PPQLZ9BU4WFDBg';
                               var map = new mapboxgl.Map({
                                   container: 'map', // container id
                                   style: 'mapbox://styles/mapbox/streets-v9', // stylesheet location
                                   center: ['-54.6111107', '-25.5097198'], // starting position [lng, lat]
                                   zoom: 9 // starting zoom
                               });
                        </script>       
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
                <!-- Copyright
                 Copyright -->
              </footer>
              <!-- Footer -->
</body>
</html>