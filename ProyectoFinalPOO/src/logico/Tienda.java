package logico;

import java.util.ArrayList;

public class Tienda {
    private ArrayList<Cliente> misclientes;
    private ArrayList<Componente> componentes;
    private ArrayList<Combo> misCombos;
    private ArrayList<Factura> factura;
	private static int generarcodcli=1;
	private static int generarcodcomp=1;
	private static int generarcodcomb=1;
    public static int cantComp;
    public static int cantCombo;
    public static int cantClientes;
    public static Tienda tienda = null;

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
	public static int getGenerarcodcli() {
		return generarcodcli;
	}

	public static void setGenerarcodcli(int generarcodcli) {
		Tienda.generarcodcli = generarcodcli;
	}
	public static int getGenerarcodcomp() {
		return generarcodcomp;
	}

	public static void setGenerarcodcomp(int generarcodcomp) {
		Tienda.generarcodcomp = generarcodcomp;
	}
	public static int getGenerarcodcomb() {
		return generarcodcomb;
	}

	public static void setGenerarcodcomb(int generarcodcomb) {
		Tienda.generarcodcomb = generarcodcomb;
	}
	
	//metodos
	public void agregarCliente(Cliente cliente) {
        misclientes.add(cliente);
        cantClientes++;
        generarcodcli++;
    }

    public void agregarFactura(Factura nuevaFactura) {
        factura.add(nuevaFactura);
    }

    public void agregarCombo(Combo nuevoCombo) {
        misCombos.add(nuevoCombo);
        cantCombo++;
        generarcodcomb++;
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
        generarcodcomp++;
    }
    private int indexBycodigo(String codigo) {
        componentes = Tienda.getInstance().getComponentes();
        for (int i = 0; i < componentes.size(); i++) {
            Componente comp = componentes.get(i);
            if (comp.getIdcomp().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1; 
    }

    private int indexBycodigoCli(String codigo) {
        misclientes = Tienda.getInstance().getMisclientes();
        for (int i = 0; i < misclientes.size(); i++) {
            Cliente cli = misclientes.get(i);
            if (cli.getId().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1; 
    }
    private int indexBycodigoCombo(String codigo) {
        misCombos = Tienda.getInstance().getMisCombos();
        for (int i = 0; i < misCombos.size(); i++) {
            Combo comb = misCombos.get(i);
            if (comb.getIdCombo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1; 
    }
    public void eliminarCombo(String identificador) {
        misCombos = Tienda.getInstance().getMisCombos();
        int index = indexBycodigoCombo(identificador);
        if (index != -1) {
            componentes.remove(index);
            cantCombo--;
        }
    }

    public void eliminarComponente(String identificador) {
        componentes = Tienda.getInstance().getComponentes();
        int index = indexBycodigo(identificador);
        if (index != -1) {
            componentes.remove(index);
            cantComp--;
        }
    }
	public void modificarComponente(Componente miscomp) {
		Componente[] micomp = new Componente[50];
		int index = indexBycodigo(miscomp.getIdcomp());
		micomp[index] = miscomp;
		
	}

	public void modificarCliente(Cliente cliente) {
	    misclientes = Tienda.getInstance().getMisclientes();
	    int index = indexBycodigoCli(cliente.getId());
	    if (index != -1) {
	        misclientes.set(index, cliente);
	    }
	}
	public void eliminarCliente(String identificador) {
	    Cliente cliente = buscarCliente(identificador);
	    if (cliente != null) {
	        misclientes.remove(cliente);
	        cantClientes--;
	    }
	}
	public Cliente buscarCliente(String id) {
	    for (Cliente cliente : misclientes) { 
	        if (cliente.getId().equalsIgnoreCase(id)) {
	            return cliente;
	        }
	    }
	    return null;
	}
	public Combo buscarCombo(String id) {
	    for (Combo combo : misCombos) { 
	        if (combo.getIdCombo().equalsIgnoreCase(id)) {
	            return combo;
	        }
	    }
	    return null;
	}
	public Componente buscarComp(String id) {
	    Componente aux = null;
	    boolean encontrado = false;
	    int i = 0;
	    while (!encontrado && i < componentes.size()) {
	        if (componentes.get(i).getIdcomp().equalsIgnoreCase(id)) {
	            aux = componentes.get(i);
	            encontrado = true;
	        }
	        i++;
	    }
	    return aux;
	}
	public static Tienda  getInstance() {
        if(tienda == null)
        tienda = new Tienda();
        return tienda;
    }
}
