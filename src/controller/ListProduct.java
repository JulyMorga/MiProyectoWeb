package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import infrastructure.ProductoDatabases;
import model.Producto;

/**
 * Servlet implementation class ListProduct
 */
@WebServlet("/ListProduct")
public class ListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // Defino el estado del DataSource, igual que en el context.xml
	@Resource(name="jdbc/productos")
	private DataSource miPool; 
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    response.setContentType("text/plain;charset=UTF-8");
	    
	    String lote = (String) request.getParameter("lote");
	    String cantMostrar = (String) request.getParameter("cantMostrar");
	    
	    // Obtengo el lote
	    if(lote == null) {
	    	lote = "1";
	    }
    	int ilote = Integer.parseInt(lote);
    	//request.getSession().setAttribute("Lote", ""+(ilote));
    	
    	// Obtengo la cantidad a mostrar.
    	if(cantMostrar == null) {
	    	cantMostrar = "9";
	    }
    	int icantMostrar = Integer.parseInt(cantMostrar);	
	      
	    List<Producto> productos = null;
        ProductoDatabases dbProducto = new ProductoDatabases();
    
        try {
			productos = dbProducto.obtenerProductosBD(ilote, icantMostrar);
			if(productos == null) {
//        		response.sendError(404, "No existen productos");
				System.out.println("No existen productos");
			}
			
		} catch (SQLException e) {
			System.out.println("No es una operación valida");
//			response.sendError(404, "No es una operación valida");
		}			

//        request.setAttribute("productos", productos);
//	    String json = gson.toJson(productos); 
//	    
//	    PrintWriter out = response.getWriter(); 
//	    /* ahora generamos la respuesta, 
//	   el método.getWriter nos da un objeto de PrintWriter que va a escribir la 
//	   respuesta que vamos a dar al momento de realizar una petición en javascript */
//	   
//	    out.println(json);  // acá damos la respuesta del objeto que creamos
//      pongo la url del jsp siguiente
        request.getSession().setAttribute("lote", lote);
        request.getSession().setAttribute("productos", productos);
        request.getSession().setAttribute("cantProductos", dbProducto.obtenerCantidadProductos());
        request.getSession().setAttribute("lote", lote);
        response.sendRedirect("webapp/Productos.jsp");
	}
	
    /*
     * Obtener respuesta si hago lo de json.
    let div = document.querySelector("#mostrarProductos");
        fetch(`${allproducts}`)
            .then((respuesta) => respuesta.json())
            .then((data) => 
		data.forEach((product) => {
	            div.innerHTML += 
			`
				<div>
			    	<h1>${product.name}</h1>
                	<p> ${product.description} </p>
	         		<p> ${product.price} </p>
			  	</div>
			`;
		})
	);
    */
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
