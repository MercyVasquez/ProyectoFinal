package logico;

public class TarjetaMadre extends Componente{
	private String marca;
	private String modelo;
	private String tipoConector;
	private String tipoRam;
	private String conexionAceptada;
	
	public TarjetaMadre(double precio, int cantidadExistente, String numeroSerie, String marca, String modelo,
			String tipoConector, String tipoRam, String conexionAceptada) {
		super(precio, cantidadExistente, numeroSerie);
		this.marca = marca;
		this.modelo = modelo;
		this.tipoConector = tipoConector;
		this.tipoRam = tipoRam;
		this.conexionAceptada = conexionAceptada;
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

	public String getTipoConector() {
		return tipoConector;
	}

	public void setTipoConector(String tipoConector) {
		this.tipoConector = tipoConector;
	}

	public String getTipoRam() {
		return tipoRam;
	}

	public void setTipoRam(String tipoRam) {
		this.tipoRam = tipoRam;
	}

	public String getConexionAceptada() {
		return conexionAceptada;
	}

	public void setConexionAceptada(String conexionAceptada) {
		this.conexionAceptada = conexionAceptada;
	}
	
	
}
