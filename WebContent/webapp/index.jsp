<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="model.Usuario"%>
<!DOCTYPE html>
<html lang="es">
    <head>
    	<%@include file= "common/head.jsp" %>
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
