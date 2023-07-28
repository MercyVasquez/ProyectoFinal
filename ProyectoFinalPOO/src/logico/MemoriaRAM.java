package logico;

public class MemoriaRAM extends Componente{

	private String cantMemoria;
	private String tipoMemoria;
	
	public MemoriaRAM(String idcomp, double precio, int cantidadExistente, String numeroSerie, String marca, String cantMemoria,
			String tipoMemoria) {
		super(idcomp ,precio, cantidadExistente, numeroSerie, marca);
		this.cantMemoria = cantMemoria;
		this.tipoMemoria = tipoMemoria;
	}

	public String getCantMemoria() {
		return cantMemoria;
	}

	public void setCantMemoria(String cantMemoria) {
		this.cantMemoria = cantMemoria;
	}

	public String getTipoMemoria() {
		return tipoMemoria;
	}

	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}

}
