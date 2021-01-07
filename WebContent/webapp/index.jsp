<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="model.Usuario"%>
<!DOCTYPE html>
<html lang="es">
    <head>
    	<%@include file= "common/head.html" %>
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
       	</script>
        <script crossorigin="anonymous" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" src="https://code.jquery.com/jquery-3.3.1.slim.min.js">
        </script>
        <script crossorigin="anonymous" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js">
        </script>
        <script crossorigin="anonymous" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js">
        </script>
       	<script src="script/main.js"></script>
	</body>
</html>
