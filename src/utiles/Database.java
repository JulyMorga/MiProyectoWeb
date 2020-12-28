package utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import constants.Constant;

public abstract class Database {
    private String bd_url = "jdbc:mysql://";
    private String host = Constant.host_db;
    private String bd_user = Constant.user_db;
    private String bd_password = Constant.password_db;
    private String bd_nombre = Constant.name_db;
    private Connection mysql = null;
    
    public Database(String host, String usuario, String clave, String nombre) {

        /* Asignamos los atributos */
        this.host = host;
        this.bd_user = usuario;
        this.bd_password = clave;
        this.bd_nombre = nombre;

        /* Creamos la URL */
        this.bd_url = Constant.conector_db + host + "/" + this.bd_nombre;

    }
    
    /**
     * Contructor por defecto.
     */
    public Database() {
        /* Creamos la URL */
        this.bd_url = Constant.conector_db + host + "/" + this.bd_nombre;

    }
    
    /**
     * Este metodo inicia la conexion a la base de datos
     *
     * @return boolean Resultado de la operacion TRUE si se conecto
     * exitosamente, FALSE en caso contrario.
     */
    public boolean conectar() {
    	 try {
             // Conexión
    		 Class.forName("com.mysql.cj.jdbc.Driver");
             this.mysql = DriverManager.getConnection(bd_url, bd_user, bd_password);
             return true;
         } catch (Exception error) {
         	System.out.println("Error al Conectar " + error);
         }
    	 return false;
    }
    
    /**
     * Se encarga de ejecutar una consulta, que arrojara algun resultado
     * (SELECT).
     * 
     * @param consulta Consulta a ejecutar
     * @return boolean Resultado de la operacion TRUE si se desconecto
     * exitosamente, FALSE en caso contrario.
     */
    public boolean consulta(String consulta) throws SQLException {
    	Statement statement = mysql.createStatement();
    	ResultSet resultado = statement.executeQuery(consulta);
    	return procesar_consulta(resultado);

    }
    
    /**
     * Se encarga de ejecutar una consulta, que no arrojara ningun resultado
     * (INSERT, UPDATE, DELETE).
     * 
     * @param consulta Consulta a ejecutar
     * @return boolean Resultado de la operacion TRUE si se desconecto
     * exitosamente, FALSE en caso contrario.
     */
    public boolean operacion(String operacion) throws SQLException {
    	Statement statement = mysql.createStatement();
    	return statement.executeUpdate(operacion) > -2 ? true : false;
    }
    
    
    /**
     * Metodo para procesar la consulta en sus hijos.
     * @param resultado
     * @return
     */
    public abstract boolean procesar_consulta(ResultSet resultado);
    
    /**
     * Realiza la desconexion del Database
     *
     * @return boolean Resultado de la operacion TRUE si se desconecto
     * exitosamente, FALSE en caso contrario.
     */
    public boolean desconectar() {
    	 try {
             // Desconexión
             this.mysql.close();
             return true;
         } catch (SQLException error) {
         	System.out.println("Error al desconectar " + error);
         }
    	 return false;
    }
    
}
