<div id="index" class="active">
    <div class="div_contenedor">
		<%! String email, password; %>
		<%  
			email = (String)  request.getAttribute("email");
			password = (String) request.getAttribute("password"); 
		%>
      		<h2>Bienvenido al Sistema</h2>
       	<div id="div_datos">
       		<p id="datos_ingresados">Los datos ingresados son:</p>
       		<p>Tu usuario:  <%= email%>
       		<br/>
       		Tu clave:  <%= password %>
       		</p>
       	</div>
    </div>
</div>