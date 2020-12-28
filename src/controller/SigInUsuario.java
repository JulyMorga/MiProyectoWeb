package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import infrastructure.UsuarioDatabases;
import model.Usuario;

/**
 * Servlet implementation class LoginUsuario
 */
@WebServlet("/sigIn")
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
        String nacionalidad = request.getParameter("nacionalidad");
        Gson gson = new Gson();
        boolean respuestaBd = false;
        UsuarioDatabases usuario_db = new UsuarioDatabases();
        
        try {
        	respuestaBd = usuario_db.crearUsuarioBD(email, password, name, surname);
		} catch (Exception e) {
			response.getWriter().append("No existe el usuario").append(request.getContextPath());
		}
        if (!respuestaBd) {
            /*
               No se pudo crear correctamente.
            */ 
        	getServletContext().setAttribute("error", "No pudo crear.");
            response.sendRedirect("webapp/sigin.jsp"); 
        }
        
//        HttpSession session = request.getSession(); // guardamos la sesión 
//        session.setMaxInactiveInterval(60*10);
//        session.setAttribute("Usuario", usuario);
//        String json = gson.toJson(usuario);
//        System.out.println("Json:   "+json);
//        PrintWriter out = response.getWriter(); 
//        out.println(json);
        
//        request.setAttribute("email", usuario.getEmail());
//        request.setAttribute("contraseña", usuario.getPassword());
//        // pongo la url del jsp siguiente
        response.sendRedirect("webapp/login.jsp");
    }
        
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
