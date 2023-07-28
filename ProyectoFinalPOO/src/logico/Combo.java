package logico;

import java.util.ArrayList;

public class Combo {
    private ArrayList<Componente> componentes;
    private String idCombo;

    public Combo(String idCombo) {
        this.idCombo = idCombo;
        componentes = new ArrayList<>();
    }
    

    public ArrayList<Componente> getComponentes() {
		return componentes;
	}


	
    public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}


	public String getIdCombo() {
		return idCombo;
	}


	public void setIdCombo(String idCombo) {
		this.idCombo = idCombo;
	}


	public void agregarComponente(Componente componente) {
        componentes.add(componente);
    }

    public void eliminarComponente(int indice) {
        if (indice >= 0 && indice < componentes.size()) {
            componentes.remove(indice);
        } else {
            System.out.println("Índice inválido. No se encontró el componente.");
        }
    }

    public void vaciarCombo() {
        componentes.clear();
    }

    public double obtenerPrecioTotal() {
        double precioTotal = 0.0;
        for (Componente componente : componentes) {
            precioTotal += componente.getPrecio();
        }
        return precioTotal;
    }

    public int obtenerCantidadTotalComponentes() {
        return componentes.size();
    }

    public String obtenerInformacionCombo() {
        StringBuilder infoCombo = new StringBuilder();
        infoCombo.append("ID del Combo: ").append(idCombo).append("\n");
        infoCombo.append("Componentes del Combo:\n");
        for (Componente componente : componentes) {
            infoCombo.append("- ").append(componente.getTipo()).append(", Modelo: ").append(componente.getModelo())
                    .append(", Precio: ").append(componente.getPrecio()).append("\n");
        }
        infoCombo.append("Precio Total del Combo: ").append(obtenerPrecioTotal());
        return infoCombo.toString();
    }

  
}