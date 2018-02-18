<%@page import="Model.Profesor"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Perfil Profesor</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"><!-- Google web font "Open Sans", https://www.google.com/fonts/specimen/Open+Sans -->
        <link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css"> <!-- Font Awesome, https://fortawesome.github.io/Font-Awesome/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css">                       <!-- Bootstrap style, http://v4-alpha.getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">  
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script><!-- Templatemo style -->
        <script rel="javascript" type="text/javascript" href="js/jquery-1.11.3.min.js"></script>
        <script src="js/funciones.js"></script>
    </head>
    <body>

        <%@include file="header.jsp" %>
        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">

                </div>
                <div class="col-sm-8 text-left"> 
                    <h1>Perfil Profesor</h1>
                    <p></p>

                    <div class="container">  

                        <div class="form-group">
                            <label for="idequipo">ID Profesor:</label>
                            <input  class="form-control" name="id_profesor">
                        </div>

                        <br>

                        <button  onclick="Listar()"  class="btn btn-default" name="Enviar">Buscar</button>

                        <p id="profesor">

                        </p>
                    </div>

                </div>

            </div>
        </div>
        <p></p>


    </body>
</html>