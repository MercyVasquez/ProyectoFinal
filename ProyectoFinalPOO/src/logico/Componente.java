package logico;

public class Componente {
	protected double precio;
	protected int cantidadExistente;
	protected String numeroSerie;
	
	public Componente(double precio, int cantidadExistente, String numeroSerie) {
		super();
		this.precio = precio;
		this.cantidadExistente = cantidadExistente;
		this.numeroSerie = numeroSerie;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidadExistente() {
		return cantidadExistente;
	}

	public void setCantidadExistente(int cantidadExistente) {
		this.cantidadExistente = cantidadExistente;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
}
