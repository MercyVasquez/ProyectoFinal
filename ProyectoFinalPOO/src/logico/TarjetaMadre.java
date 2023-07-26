package logico;

import java.util.ArrayList;

public class TarjetaMadre {
	private String Marca;
	private String Modelo;
	private String TipoConector;
	private String TipoRam;
	private ArrayList<DiscoDuro> DiscosAceptados;
	
	public TarjetaMadre(String marca, String modelo, String tipoConector, String tipoRam,
			ArrayList<DiscoDuro> discosAceptados) { /*Revisar si se puede poner el arraylist adentro*/
		super();
		Marca = marca;
		Modelo = modelo;
		TipoConector = tipoConector;
		TipoRam = tipoRam;
		DiscosAceptados = discosAceptados;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public String getTipoConector() {
		return TipoConector;
	}

	public void setTipoConector(String tipoConector) {
		TipoConector = tipoConector;
	}

	public String getTipoRam() {
		return TipoRam;
	}

	public void setTipoRam(String tipoRam) {
		TipoRam = tipoRam;
	}

	public ArrayList<DiscoDuro> getDiscosAceptados() {
		return DiscosAceptados;
	}

	public void setDiscosAceptados(ArrayList<DiscoDuro> discosAceptados) {
		DiscosAceptados = discosAceptados;
	}
	
	
}
