import java.util.ArrayList;

public class Tienda {
    private ArrayList<Cliente> misclientes;
    private ArrayList<Componente> componentes;
    private ArrayList<Combo> misCombos;
    private ArrayList<Factura> factura;

    public Tienda() {
        misclientes = new ArrayList<>();
        componentes = new ArrayList<>();
        misCombos = new ArrayList<>();
        factura = new ArrayList<>();
    }
    
    
    
    public ArrayList<Cliente> getMisclientes() {
		return misclientes;
	}



	public void setMisclientes(ArrayList<Cliente> misclientes) {
		this.misclientes = misclientes;
	}



	public ArrayList<Componente> getComponentes() {
		return componentes;
	}



	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}



	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}



	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}



	public ArrayList<Factura> getFactura() {
		return factura;
	}



	public void setFactura(ArrayList<Factura> factura) {
		this.factura = factura;
	}



	public void AgregarCliente(Cliente cliente) {
        misclientes.add(cliente);
    }

    public void AgregarFactura(Factura nuevaFactura) {
        factura.add(nuevaFactura);
    }

    public void AgregarCombo(Combo nuevoCombo) {
        misCombos.add(nuevoCombo);
    }

    public void VerFacturas() {
        for (Factura fac : factura) {
            System.out.println(fac.toString());
        }
    }

    public Componente ComponenteMasVendido() {
        Componente masVendido = null;
        int maxCantidad = 0;
        for (Factura fac : factura) {
            for (Componente comp : fac.getComponentes()) {
                int cantidad = comp.getCantidad();
                if (cantidad > maxCantidad) {
                    maxCantidad = cantidad;
                    masVendido = comp;
                }
            }
        }
        return masVendido;
    }

    public void AgregarComponente(Componente nuevoComponente) {
        componentes.add(nuevoComponente);
    }
}
