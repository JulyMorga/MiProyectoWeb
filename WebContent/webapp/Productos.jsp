<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Producto"%>
<%@page import="java.util.List" %>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<!DOCTYPE html>
<html>
	<head>
		<%@include file= "common/head.jsp" %>
	<title>Productos</title>
	</head>
	<body>
		<%@include file= "nav.jsp" %>
		<div class="container d-flex flex-wrap mt-3 justify-content-center">
		<%
		// TO-DO problema si se pone la url /Productos.jsp
		List<Producto> listProductos = (List<Producto>) request.getSession().getAttribute("productos");
		if(listProductos == null){
			out.print("No hay productos disponibles");
		}else {
			for (Producto productos : listProductos) {
		%>
			<div class="element-product col-3">
				<h2> <% out.print(productos.getNombre()); %></h2>
				<p> <% out.print(productos.getDescripcion()); %></p>
				<h3> $<% out.print(productos.getPrecio()); %></h3>
			</div>
		<% 
			}
		%>
			</div>
			<div class="btn-toolbar justify-content-center mt-3" role="toolbar">
				<div class="btn-group">
					<button type="button" class="btn btn-default">1</button>
					<button type="button" class="btn btn-default">2</button>
					<button type="button" class="btn btn-default">3</button>
					<button type="button" class="btn btn-default">4</button>
				</div>
			</div>
		<%
		}
		%>
	</body>
</html>