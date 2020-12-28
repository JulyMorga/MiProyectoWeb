package infrastructure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enums.Tables;
import model.Producto;
import utiles.Database;

public class ProductoDatabases extends Database {

	List <Producto> productos = null;
	int count = 0;
	@Override
	public boolean procesar_consulta(ResultSet resultado) {
		productos = new ArrayList<Producto>();
		try {
			// nos movemos a la siguiente fila y preguntamos si hay información válida
			while (resultado.next()) { 
				Producto producto = new Producto();
				producto.setCodigo(resultado.getString(1));
				producto.setNombre(resultado.getString(2));
				producto.setDescripcion(resultado.getString(3));
				producto.setPrecio(resultado.getInt(4));
				productos.add(producto);
			}
		} catch (SQLException e) {
			System.out.println("Error procesando consulta " + e );
		}
		return !productos.isEmpty();
	}
	
	/**
	 * Devuelve la lista de productos de un lote de 20 productos
	 * @param lote  -  Arranca en el lote 1.
	 * @return
	 * @throws SQLException 
	 */
	public List<Producto> obtenerProductosBD(int lote) throws SQLException {
		int loteInicio = ((lote-1) * 20);
		int loteFin = loteInicio + 20;
		conectar();
		//TO-DO OJO CON EL FINAL DE LOTE.
		consulta("SELECT * FROM " + Tables.PRODUCTO  + " WHERE codigo > " + loteInicio + " AND codigo <= " + loteFin);
		desconectar();
		if(!productos.isEmpty())
			return productos;
		return null;
	}

}
