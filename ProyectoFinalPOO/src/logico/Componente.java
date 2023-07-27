package logico;

public class Componente {
	protected double precio;
	protected int cantidadExistente;
	protected String numeroSerie;
	protected String marca;
	
	public Componente(double precio, int cantidadExistente, String numeroSerie, String marca) {
		super();
		this.precio = precio;
		this.cantidadExistente = cantidadExistente;
		this.numeroSerie = numeroSerie;
		this.marca = marca;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}
