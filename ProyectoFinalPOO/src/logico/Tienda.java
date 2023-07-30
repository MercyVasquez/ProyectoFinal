package logico;

import java.util.ArrayList;

public class Tienda {
    private ArrayList<Cliente> misclientes;
    private ArrayList<Componente> componentes;
    private ArrayList<Combo> misCombos;
    private ArrayList<Factura> factura;
	private static int generaridcli=1;
    public static int cantComp;
    public static int cantCombo;
    public static int cantClientes;

    public Tienda() {
        misclientes = new ArrayList<>();
        componentes = new ArrayList<>();
        misCombos = new ArrayList<>();
        factura = new ArrayList<>();
        cantCombo = 0;
        cantComp = 0;
        cantClientes = 0;
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

	public static int getCantComp() {
		return cantComp;
	}

	public static void setCantComp(int cantComp) {
		Tienda.cantComp = cantComp;
	}

	public static int getCantCombo() {
		return cantCombo;
	}

	public static void setCantCombo(int cantCombo) {
		Tienda.cantCombo = cantCombo;
	}
	public static int getCantClientes() {
		return cantClientes;
	}

	public static void setCantClientes(int cantClientes) {
		Tienda.cantClientes = cantClientes;
	}
	public static int getGgeneraridcli() {
		return generaridcli;
	}

	public static void setGeneraridcli(int generaridcli) {
		Tienda.generaridcli = generaridcli;
	}
	
	
	//metodos
	public void agregarCliente(Cliente cliente) {
        misclientes.add(cliente);
        cantClientes++;
        generaridcli++;
    }

    public void agregarFactura(Factura nuevaFactura) {
        factura.add(nuevaFactura);
    }

    public void agregarCombo(Combo nuevoCombo) {
        misCombos.add(nuevoCombo);
        cantCombo++;
    }

    public void verFacturas() {
        for (Factura fac : factura) {
            System.out.println(fac.toString());
        }
    }

    public Componente componenteMasVendido() {
        Componente masVendido = null;
        int maxCantidad = 0;
        for (Factura fac : factura) {
            for (Componente comp : fac.getComponente()) {
                int cantidad = comp.getCantidadExistente();
                if (cantidad > maxCantidad) {
                    maxCantidad = cantidad;
                    masVendido = comp;
                }
            }
        }
        return masVendido;
    }

    public void agregarComponente(Componente nuevoComponente) {
        componentes.add(nuevoComponente);
        cantComp++;
    }
    
	private int indexBycodigo(String codigo) {
		Componente[] micomp = new Componente[50];
		boolean encontrado = false;
		int i = 0;
		int index = -1;
		while (!encontrado && i< cantComp) {
			if(micomp[i].getIdcomp().equalsIgnoreCase(codigo)){
				encontrado = true;
				index = i;
				
			}
			i++;
		}
		return index;
	}
	public void eliminarComponente(String identificador) {
		Componente[] micomp = new Componente[50];
		int index = -1;
		int i= 0;
		if(indexBycodigo(identificador)>-1){
			index = indexBycodigo(identificador);
			i = index;
				while(i<cantComp-1){
				  micomp[i]=micomp[i+1];
				  i++;
				}
			cantComp--;	
		}

	}
	public void modificarComponente(Componente miscomp) {
		Componente[] micomp = new Componente[50];
		int index = indexBycodigo(miscomp.getIdcomp());
		micomp[index] = miscomp;
		
	}
}
