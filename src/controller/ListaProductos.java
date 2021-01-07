package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import infrastructure.ProductoDatabases;
import model.Producto;

/**
 * Servlet implementation class ListProduct
 */
@WebServlet("/ListaProductos")
public class ListaProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // Defino el estado del DataSource, igual que en el context.xml
	@Resource(name="jdbc/productos")
	private DataSource miPool; 
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    response.setContentType("apllication/json;");
	    response.setCharacterEncoding("UTF-8");
	    
	    String lote = request.getParameter("lote");
	    String cantMostrar = request.getParameter("cantMostrar");
	    String obtenerCantMostrar = request.getParameter("cantidadProductos");

	    int cantidadTotal = 0;
	    ProductoDatabases dbProducto = new ProductoDatabases();
	    
	    // Verifico si quieren saber la cantidad de productos.
	    if(obtenerCantMostrar != null) {
	    	cantidadTotal = dbProducto.obtenerCantidadProductos();
	    }
	    
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
        try {
			productos = dbProducto.obtenerProductosBD(ilote, icantMostrar);
			if(productos == null) {
//        		response.sendError(404, "No existen productos");
				System.out.println("No existen productos");								
			}
			
		} catch (SQLException e) {
			System.out.println("No es una operación valida");
		}			

        Gson gson = new Gson();
	    String json = gson.toJson(productos); 
//	    String json2 = gson.toJson(cantidad); 
	    
	    PrintWriter out = response.getWriter(); 
	    
//	    out.println("\"productos\":" +json+ " , \"cantMostrar\":"+ json2);
	    out.println(json);			// Damos la respuesta del objeto que creamos
	    System.out.println(json);
	    out.flush();
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
