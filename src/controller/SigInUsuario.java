package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import infrastructure.UsuarioDatabases;

/**
 * Servlet implementation class LoginUsuario
 */
@WebServlet("/sigin")
public class SigInUsuario extends HttpServlet {
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
        response.setContentType("apllication/json;charset=UTF-8");
        
        String email = request.getParameter("email"); 
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int nacionalidad = Integer.parseInt(request.getParameter("nacionalidad"));
        boolean respuestaBd = false;
        UsuarioDatabases usuario_db = new UsuarioDatabases();
        try {
        	respuestaBd = usuario_db.crearUsuarioBD(email, password, name, surname, nacionalidad);
		} catch (Exception e) {
			//response.getWriter().append("No pudo crear al usuario").append(request.getContextPath());
		}
        if (!respuestaBd) {
            /*
               No se pudo crear correctamente.
            */ 
        	getServletContext().setAttribute("error", "No pudo crear al usuario");
            response.sendRedirect("webapp/sigin.jsp");
            return;
        }
        
       response.sendRedirect("webapp/login.jsp");
    }
        
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
