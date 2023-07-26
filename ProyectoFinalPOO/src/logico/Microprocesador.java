package logico;

public class Microprocesador extends Componente{
	private String marca;
	private String modelo;
	private String tipoConexion;
	private String velocidadProcesamiento;
	
	public Microprocesador(double precio, int cantidadExistente, String numeroSerie, String marca, String modelo,
			String tipoConexion, String velocidadProcesamiento) {
		super(precio, cantidadExistente, numeroSerie);
		this.marca = marca;
		this.modelo = modelo;
		this.tipoConexion = tipoConexion;
		this.velocidadProcesamiento = velocidadProcesamiento;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

	public String getVelocidadProcesamiento() {
		return velocidadProcesamiento;
	}

	public void setVelocidadProcesamiento(String velocidadProcesamiento) {
		this.velocidadProcesamiento = velocidadProcesamiento;
	}
	
}
