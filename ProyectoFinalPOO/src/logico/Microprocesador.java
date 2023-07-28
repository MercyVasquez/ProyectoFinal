package logico;

public class Microprocesador extends Componente{
	
	private String modelo;
	private String tipoConexion;
	private String velocidadProcesamiento;
	
	public Microprocesador(String idcomp, double precio, int cantidadExistente, String numeroSerie, String marca, String modelo,
			String tipoConexion, String velocidadProcesamiento) {
		super(idcomp, precio, cantidadExistente, numeroSerie, marca);
		this.modelo = modelo;
		this.tipoConexion = tipoConexion;
		this.velocidadProcesamiento = velocidadProcesamiento;
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
