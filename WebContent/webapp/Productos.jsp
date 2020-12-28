<%@page import="model.Producto"%>
<%@page import="java.util.List" %>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos</title>
</head>
<body>
	<%
		List<Producto> listProductos = (List<Producto>) request.getAttribute("productos");;
		if(listProductos.isEmpty()){
			out.print("No hay productos disponibles");
		}
		for (Producto productos : listProductos) {
	%>
		<div>
		<h1> <% out.print(productos.getNombre()); %></h1>
		<p> <% out.print(productos.getDescripcion()); %></p>
		</div>
	<% 
		}
	%>
</body>
</html>