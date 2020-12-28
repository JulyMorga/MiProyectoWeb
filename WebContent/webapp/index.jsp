<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="model.Usuario"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8"/>
        <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
        <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" rel="stylesheet"/>
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
        <link href="styles/styles.css" rel="stylesheet"/>
        <title>
            LogIn
        </title>
    </head>
	<body id="body">
	<% 	
	if(!session.isNew()){
		Usuario usuario = (Usuario) session.getAttribute("Usuario");
		if(usuario == null){
			response.sendRedirect("login.jsp");
		}else {			
			request.setAttribute("email", usuario.getEmail());
			request.setAttribute("password", usuario.getPassword());
			//out.print(request.getAttribute("email"));
		}
	} else {
		response.sendRedirect("login.jsp");
	}
    %>
		<%@include file= "nav.jsp" %>
		<%@include file= "home.jsp" %>
       	<%@include file= "about.html" %>
       	<%@include file= "servicios.html" %>
       	<%@include file= "contactenos.html" %>
       	<script src="main.js"></script>
	</body>
</html>
