<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Perfil Profesor</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"><!-- Google web font "Open Sans", https://www.google.com/fonts/specimen/Open+Sans -->
        <link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css"> <!-- Font Awesome, https://fortawesome.github.io/Font-Awesome/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css">                       <!-- Bootstrap style, http://v4-alpha.getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">                    <!-- Templatemo style -->

    </head>
    <body>

<%@include file="header.jsp" %>
        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">

                </div>
                <div class="col-sm-8 text-left"> 
                    <h1>Login</h1>
                    <p></p>
                    <hr>
                    <div class="container">   
                        <form class="form-inline" action="Loginn" method="POST">
                            <div class="form-group">
                                <label for="idequipo">Usuario:</label>
                                <input  class="form-control" name="usuario">
                            </div>
                            <div class="form-group">
                                <label for="nombre">Contrasena:</label>
                                <input  class="form-control" name="contrasena">
                            </div>
                            <button type="submit" class="btn btn-default" name="Enviar">Enviar</button>
                        </form>
                    </div>
                    <div class="row"> 

                        <section class="tm-section-intro">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                                <div class="tm-wrapper-center">
                                    <h1 class="tm-section-intro-title">Bienvenido</h1>
                                    <p><a class="tm-btn-white-big" href="ReporteSer" role="button">Consultar</a></p>
                                </div>            
                            </div>
                        </section>    

                    </div>

                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                            <p class="text-xs-center tm-copyright-text">Óscar Romero © (2017)</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <footer class="container-fluid text-center">
            <p>Universidad Sergio Arboleda</p>
        </footer>

    </body>
</html>