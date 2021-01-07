<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="model.Nacionalidad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Usuario"%>
<%@page import="java.sql.SQLException"%>

<%@page import="infrastructure.NacionalidadDatabases"%>
<!DOCTYPE html>
<html lang="es">
    <head>
    	<%@include file= "common/head.html" %>
        <title>
            Registrarme
        </title>
    </head>
    <body class="text-center">
       	<%	
		    Usuario usuario = (Usuario) session.getAttribute("Usuario");
			if(usuario != null){
				response.sendRedirect("index.jsp");
			}
		%>
		<form action="../sigin" class="form-signin" method="POST" action="index.jsp">
         	<% 
				Object resp = null;
				resp = getServletContext().getAttribute("error");
				if(resp != null){
					getServletContext().removeAttribute("error");
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
                Registrate ingresando tus datos
            </h2>
            <label class="sr-only" for="inputName">
                Nombre
            </label>
            <input autofocus class="form-control" id="inputSurname" name="surname" placeholder="Ingrese su nombre" required type="text"/>
            
            <label class="sr-only" for="inputSurname">
                Apellido
            </label>
            <input autofocus class="form-control" id="inputName" name="name" placeholder="Ingrese su apellido" required type="text"/>
            <label class="sr-only" for="inputEmail">
                Tu Email o usuario
            </label>
            <input autofocus class="form-control" id="inputEmail" name="email" placeholder="Ingrese su correo electrónico" required type="email"/>
            <label class="sr-only" for="inputPassword">
                Tu Clave / Contraseña
            </label>
            <input class="form-control" id="inputPassword" name="password" placeholder="Ingrese su contraseña" required type="password"/>
			
			<div class="form-group d-flex justify-content-between mb-3">
				<label class="d-flex align-items-center" for="selectNacional">
	                País de origen
	            </label>
	            <select class="form-control col-sm-8" name="nacionalidad"  id="selectNacional">
	            	<%
		        		NacionalidadDatabases db = new NacionalidadDatabases();
		        		List<Nacionalidad> nacionalidades = null;
		        		try {
		        			
		        			nacionalidades = db.obtenerNacionalidadesBD();
		        			
		        			// Muestro las nacionalidades
			        		if(nacionalidades !=null) {
			        			for (Nacionalidad nacionalidad : nacionalidades) {
									out.println("<option value=\"" + nacionalidad.getId() + "\">" + nacionalidad.getNombre() + "</option>");
			        			}
			        		}
							
		        		} catch (SQLException e) {
		        			out.println("<option value=\"-1\">ERROR</option>");
		        		}
	            	%>
				</select>
			</div>
			
            <button class="btn btn-lg btn-primary btn-block" type="submit">
                Registrar
            </button>
            <div class="form-adicional">
                <a href="login.jsp" id="registrarme">
                    Iniciar sesión
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