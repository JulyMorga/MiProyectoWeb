package infrastructure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enums.Tables;
import model.Nacionalidad;
import utiles.Database;

public class NacionalidadDatabases extends Database{
	
	List <Nacionalidad> nacionalidades = null;
	int count = 0;
	@Override
	public boolean procesarConsulta(ResultSet resultado) {
		nacionalidades = new ArrayList<Nacionalidad>();
		try {
			// nos movemos a la siguiente fila y preguntamos si hay información válida
			while (resultado.next()) { 
				Nacionalidad nacionalidad = new Nacionalidad();
				nacionalidad.setId(resultado.getInt(1));
				nacionalidad.setNombre(resultado.getString(2));
				nacionalidades.add(nacionalidad);
			}
		} catch (SQLException e) {
			System.out.println("Error procesando consulta " + e );
		}
		return !nacionalidades.isEmpty();
	}
	
	/**
	 * Devuelve la lista de nacionalidades
	 * @return List<Nacionalidad>
	 * @throws SQLException 
	 */
	public List<Nacionalidad> obtenerNacionalidadesBD() throws SQLException {
		conectar();
		consulta("SELECT * FROM " + Tables.NACIONALIDAD + ";");
		desconectar();
		if(!nacionalidades.isEmpty())
			return nacionalidades;
		return null;
	}
	
	public boolean crearUsuarioBD(String name) throws SQLException {
		conectar();
		boolean res = operacion("INSERT INTO " + Tables.NACIONALIDAD + 
					" (`nacionalidad`) VALUES (\"" + name + "\")");
		desconectar();
		return res;
	}
	

	public static void main(String[] args) {
		NacionalidadDatabases db = new NacionalidadDatabases();
		List<Nacionalidad> nacionalidades = null;
		try {
			db.crearUsuarioBD("Brasil");
			nacionalidades = db.obtenerNacionalidadesBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(nacionalidades !=null) {
			for (Nacionalidad nacionalidad : nacionalidades) {
				System.out.println("nacionalidad: " + nacionalidad);
				if(nacionalidad.getNombre().equals("Brasil"))
					System.out.println("todo Ok");
			}
			
		}
		
	}
}
