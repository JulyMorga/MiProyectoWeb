<%@page import="model.Usuario"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler" data-target="#navbarNavDropdown" data-toggle="collapse" type="button">
        <span class="navbar-toggler-icon">
        </span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#index">
                    Inicio
                    <span class="sr-only">
                        (current)
                    </span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#servicios">
                    Servicios
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#about">
                    Acerca de
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#contactenos">
                    Contacto
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="productosJson.jsp">
                    Productos
                </a>
            </li>
        </ul>
        <span class="nav-item my-2 my-lg-0 mr-sm-2">
        <% 
		Usuario usuario = (Usuario) session.getAttribute("Usuario");
		if(usuario != null){
		%>
       		<a class="nav-link" href="../logout">Salir<em class="fas fa-sign-out-alt">  </em></a>
       	<%
		}else {
		%>
		<a class="nav-link" href="../sigIn">Registrar<em class="fas fa-sign-out-alt">  </em></a>
		<%
		}
		%>
        </span>
    </div>
</nav>
