package infrastructure;

import java.sql.ResultSet;
import java.sql.SQLException;

import enums.Tables;
import model.Usuario;
import utiles.Database;

public class UsuarioDatabases extends Database {

	Usuario usuario = null;
	@Override
	public boolean procesarConsulta(ResultSet resultado) {
		try {
			// nos movemos a la siguiente fila y preguntamos si hay información válida
			if (resultado.next()) {
				usuario = new Usuario();
				usuario.setEmail(resultado.getString(1));
				usuario.setPassword(resultado.getString(2));
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error procesando consulta " + e );
		}
		return false;
	}
	
	public Usuario obtenerUsuarioBD(String email, String password) throws SQLException {
		conectar();
		consulta("SELECT mail, contraseña FROM " + Tables.USUARIO+ " where mail=\""+ email +"\"");
		desconectar();
		if(usuario.equals(email, password))
			return usuario;
		return null;
	}
	
	public boolean crearUsuarioBD(String email, String password, String name, String surname, int nacionalidad) throws SQLException {
		conectar();
		boolean res = operacion("INSERT INTO " + Tables.USUARIO + 
					" (`mail`,`contraseña`,`nombre`,`apellido`,`nacionalidad`)"
					+ " VALUES (\"" + email + "\",\"" + password +"\",\""+ name 
					+ "\",\"" + surname + "\",\"" + nacionalidad + "\")");
		desconectar();
		return res;
	}

	public static void main(String[] args) {
		UsuarioDatabases db = new UsuarioDatabases();
		Usuario usu = null;
		try {
			db.crearUsuarioBD("coco@hotmail.com","1234a","coco","gonzales",1);
			usu = db.obtenerUsuarioBD("coco@hotmail.com","1234a");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(usu !=null)
			System.out.println("todo Ok");
		
	}
}
