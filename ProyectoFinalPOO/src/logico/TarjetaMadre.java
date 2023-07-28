package logico;

public class TarjetaMadre extends Componente{

	private String modelo;
	private String tipoConexion;
	private String tipoRam;
	private String conexionAceptada;
	
	public TarjetaMadre(String idcomp, double precio, int cantidadExistente, String numeroSerie, String marca, String modelo,
			String tipoConexion, String tipoRam, String conexionAceptada) {
		super(idcomp, precio, cantidadExistente, numeroSerie, marca);
		this.modelo = modelo;
		this.tipoConexion = tipoConexion;
		this.tipoRam = tipoRam;
		this.conexionAceptada = conexionAceptada;
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
