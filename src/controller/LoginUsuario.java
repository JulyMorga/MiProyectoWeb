package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import infrastructure.UsuarioDatabases;
import model.Usuario;

/**
 * Servlet implementation class LoginUsuario
 */
@WebServlet("/login")
public class LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    /* el método processRequest de la clase HttpServlet recibe como parámetros 
       al objeto request y al objeto response */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
    	/* seteamos la configuración, 
        indicamos que vamos a generar una respuesta en formato JSON */
        response.setContentType("text/html;charset=UTF-8");
        
        String email = request.getParameter("email"); 
        String password = request.getParameter("password");
        
        Usuario usuario = null;
        UsuarioDatabases usuario_db = new UsuarioDatabases();
        
        try {
			usuario = usuario_db.obtenerUsuarioBD(email, password);
		} catch (Exception e) {
			
		}
        if (usuario == null) {
            /*
               si el usuario es nulo enviamos un mensaje de que no existe
            */ 
        	getServletContext().setAttribute("invalido", "invalido");
        	response.sendRedirect("webapp/login.jsp");
        	return;
        	
        }
        
        HttpSession session = request.getSession(); // guardamos la sesión 
        session.setMaxInactiveInterval(60*10);
        session.setAttribute("Usuario", usuario);
        
        request.setAttribute("email", usuario.getEmail());
        request.setAttribute("contraseña", usuario.getPassword());
       
        // pongo la url del jsp siguiente
        response.sendRedirect("webapp/index.jsp");
    }
        
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
