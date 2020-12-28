<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8"/>
        <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
        <title>
            Login
        </title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="styles/styles.css" rel="stylesheet"/>
    </head>
    <body class="text-center">
    	<% if(request.getParameter("email") == null
		&& request.getParameter("password") == null) { 
		%>
		<form action="../sigin" class="form-signin" method="POST" action="index.jsp">
            <h1>
                Plataforma Cloud
            </h1>
            <h2>
                Bienvenido! Ingresá tus datos de acceso
            </h2>
            <label class="sr-only" for="inputEmail">
                Tu Email o usuario
            </label>
            <input autofocus class="form-control" id="inputEmail" name="email" placeholder="Ingrese su correo electrónico" required type="email"/>
            <label class="sr-only" for="inputPassword">
                Tu Clave / Contraseña
            </label>
            <input class="form-control" id="inputPassword" name="password" placeholder="Ingrese su contraseña" required type="password"/>
            <div class="mr-2">
                <input name="" type="checkbox"/>
                <label>
                    Recuerdame
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">
                Ingresar
            </button>
            <div class="form-adicional">
                <a href="" id="registrarme">
                    Registrate Gratis!
                </a>
                <a href="" id="olvide_clave">
                    Olvidé mi clave
                </a>
            </div>
        </form>
        <% }%>
    </body>
</html>