package model;

import java.io.Serializable;

public class Producto implements Serializable, Comparable<Producto> {
	//se usa para tener compatibilidad entre distintas versiones serializadas.
	private static final long serialVersionUID = 1L;
	private String codigo; //primary key
	private String nombre;
	private String descripcion;
	private int precio;
	
	public Producto() {
		this.codigo = "";
		this.nombre = "";
		this.descripcion = "";
		this.precio = -1;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public int compareTo(Producto otroUsuario) {
		int estado=-1;
		if( this.codigo.equals(otroUsuario.getCodigo()) &&
				this.precio == otroUsuario.getPrecio()
				){
			// Los objetos son iguales
			estado = 0;
		}else{
			// Los objetos no son iguales
		    estado = 1;
		}
		
		return estado;
	}
	
	public boolean equals(String codigo) {
		boolean estado = false;
		if(this.codigo.equals(codigo)){
			// Los objetos son iguales
			estado = true;
		}
		return estado;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ precio + "]";
	}

}
