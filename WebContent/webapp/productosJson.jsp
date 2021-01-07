<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
    <head>
		<title>
		    Productos
		</title>
		<%@include file= "common/head.html" %>
    </head>
    <body>
        <main>
        	<%@include file= "nav.jsp" %>
        	<div class="container">
                <section class="mb-3">
                    <h2 class="mt-4">
                        Productos
                    </h2>
                </section>
	            <div class="d-flex flex-wrap mt-3 justify-content-center" id="mostrarProductos">
	            </div>
        	</div>
        </main>
        <script>
            let lote = <% out.print( (request.getParameter("lote")!=null ? request.getParameter("lote") : 1));	%>;
            let cantAMostrar = <% out.print( (request.getParameter("cantMostrar")!=null ? request.getParameter("cantMostrar") : 9));	%>
        </script>
        <script src="script/product.js"></script>
        <script crossorigin="anonymous" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" src="https://code.jquery.com/jquery-3.3.1.slim.min.js">
        </script>
        <script crossorigin="anonymous" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js">
        </script>
        <script crossorigin="anonymous" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js">
        </script>
    </body>
</html>