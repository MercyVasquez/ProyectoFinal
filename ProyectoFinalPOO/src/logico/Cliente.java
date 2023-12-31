package logico;

import java.util.ArrayList;

public class Cliente {
	private String id;
	private String nombre;
	private String direccion;
	private String telefono;
	private ArrayList<Factura> factura;
	
	public Cliente(String id, String nombre, String direccion, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		factura = new ArrayList<Factura>();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Factura> getFactura() {
		return factura;
	}

	public void setFactura(ArrayList<Factura> factura) {
		this.factura = factura;
	}
}
