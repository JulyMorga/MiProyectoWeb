package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario implements Serializable, Comparable<Usuario> {
	//se usa para tener compatibilidad entre distintas versiones serializadas.
	private static final long serialVersionUID = 1L;
	private String email; //primary key
	private String password;
	private int idUsuario;
	
	public Usuario() {
		this.password = null;
		this.email = null;
		this.idUsuario = -1;
	}
	
	public Usuario(String email, String password, int idUsuario) {
		this.password = password;
		this.email = email;
		this.idUsuario = idUsuario;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int id) {
		this.idUsuario = id;
	}
	
	public static Usuario obtenerUsuarioBD(String email, String password) {
		Usuario nuevoUsuario = new Usuario();
		// Conexión
        String bdUrl = "jdbc:mysql://localhost:3306/mydb";
        String bdUser = "root";
        String bdPassword = "1234";
        String consultaPreparedStatement = "SELECT * FROM login where email=?"; // acá adentro vamos a poner la consulta
        
        try {
            // Conexión
            Connection mysql = DriverManager.getConnection(bdUrl, bdUser, bdPassword);
            System.out.println("Conexion Ok");

            PreparedStatement queryPrepared = mysql.prepareStatement(consultaPreparedStatement);
            queryPrepared.setString(1, email);
            ResultSet resultado = queryPrepared.executeQuery();
            while (resultado.next()) { // nos movemos a la siguiente fila y preguntamos si hay información válida
            	nuevoUsuario.email = resultado.getString(2);
            	nuevoUsuario.password = resultado.getString(3);
             
            	if(nuevoUsuario.equals(email, password)) {
            		nuevoUsuario.idUsuario = resultado.getInt(1);
            		
            	} else {
            		nuevoUsuario.idUsuario = -1;
            		nuevoUsuario.password = password;
            	}            	
            }
            mysql.close();
        } catch (SQLException error) {
        	System.out.println("Error al desconectar " + error);
        } 
            
        
		return nuevoUsuario;
	}

	@Override
	public int compareTo(Usuario otroUsuario) {
		int estado=-1;
		if(this.email.equals(otroUsuario.getEmail()) &&
				this.password.equals(otroUsuario.getPassword())){
			// Los objetos son iguales
			estado = 0;
		}else{
			// Los objetos no son iguales
		    estado = 1;
		}
		
		return estado;
	}
	
	public boolean equals(String email, String password) {
		boolean estado = false;
		if(this.email.equals(email) &&
				this.password.equals(password)){
			// Los objetos son iguales
			estado = true;
		}
		return estado;
	}
	
	public static void main(String[] args) {
		Usuario usuario = Usuario.obtenerUsuarioBD("julianmorganella@hotmail.com", "contraseñafacil");
		System.out.println("Si se visualiza correctamente, significa que existe ese registro en la tabla.");
		System.out.println("nuevoUsuario.email: "+usuario.email+"   nuevoUsuario.password: "+usuario.password);
		System.out.println("El idUsuario debe ser 1, y es: " + usuario.getIdUsuario());
	}
	
}
