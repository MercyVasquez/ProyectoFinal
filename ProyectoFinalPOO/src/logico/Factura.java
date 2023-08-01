package logico;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
	private static int generarcod;
	private String codigo;
	private double impuesto;
	private Date fechaHora;
	private ArrayList<Componente> componente;
	private ArrayList<Combo> misCombos;
	
	public Factura(String codigo) {
		super();
		this.codigo = codigo;
		impuesto = 0.18;
		fechaHora = new Date();
		componente = new ArrayList<>();
		misCombos = new ArrayList<>();
	}

	public static int getGenerarcod() {
		return generarcod;
	}

	public static void setGenerarcod(int generarcod) {
		Factura.generarcod = generarcod;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public ArrayList<Componente> getComponente() {
		return componente;
	}

	public void setComponente(ArrayList<Componente> componente) {
		this.componente = componente;
	}

	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}

	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}
	public void generarCodigo() {
		generarcod++;
	}
	public double calcularTotalVenta() {
		double total = 0.0;
		for (Combo combo : misCombos) {
			total += combo.obtenerPrecioTotal();
		
		}
		for (Componente producto : componente) {
			total += producto.getPrecio();
			producto.disminuirCantidad();
		}
		total += total;
		return total;
	}
	public void agregarComponenteFac(Componente componente, int cantidad) {
        if (componente.revisarExistencia() && cantidad <= componente.getCantidadExistente()) {
            for (int i = 0; i < cantidad; i++) {
                this.componente.add(componente);
            }
            componente.setCantidadExistente(componente.getCantidadExistente() - cantidad);
        } else {
            System.out.println("No hay suficiente stock para la cantidad solicitada del componente: " + componente.getIdcomp());
        }
    }
    public void agregarComboFac(Combo combo, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            this.misCombos.add(combo);
        }
    }
}
