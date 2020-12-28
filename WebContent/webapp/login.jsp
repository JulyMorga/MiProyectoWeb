<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="model.Usuario"%>
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
    	<% 
    	Usuario usuario = (Usuario) session.getAttribute("Usuario");
		if(usuario != null){
			response.sendRedirect("index.jsp");
		}
    	%> 
		<form action="../login" class="form-signin" method="POST" action="index.jsp">
		<% 
			Object resp = null;
			resp = getServletContext().getAttribute("invalido");
			if(resp != null){
				getServletContext().removeAttribute("invalido");
		%>
		<div class="alert alert-danger" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		 	<span><%out.print(resp); %></span>
		</div>
		<% } %>
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
                <a href="sigin.jsp" id="registrarme">
                    Registrate Gratis!
                </a>
                <a href="" id="olvide_clave">
                    Olvidé mi clave
                </a>
            </div>
        </form>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js">
        </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
        </script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">
        </script>
    </body>
</html>
