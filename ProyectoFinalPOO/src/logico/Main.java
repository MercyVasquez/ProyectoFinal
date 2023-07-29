package logico;

public class Main {

    public static void main(String[] args) {
        Tienda tienda = new Tienda();

        Componente componente1 = new DiscoDuro("DD1", 100.0, 10, "123456789", "Seagate", "Modelo1", "1TB", "SATA");
        Componente componente2 = new MemoriaRAM("RAM1", 50.0, 20, "987654321", "Kingston", "8GB", "DDR4");
        Componente componente3 = new Microprocesador("CPU1", 200.0, 5, "456789123", "Intel", "Modelo2", "Socket1", "3.5 GHz");
        Componente componente4 = new TarjetaMadre("MB1", 150.0, 8, "321654987", "ASUS", "Modelo3", "Socket2", "DDR4", "PCIe");

        tienda.agregarComponente(componente1);
        tienda.agregarComponente(componente2);
        tienda.agregarComponente(componente3);
        tienda.agregarComponente(componente4);

        Combo combo1 = new Combo("Combo1");

        combo1.agregarComponente(componente1);
        combo1.agregarComponente(componente2);

        tienda.agregarCombo(combo1);

        Cliente cliente1 = new Cliente("Juan Perez", "1234567890", "juan@example.com", "809-456-7890");

        tienda.agregarCliente(cliente1);

        Factura factura1 = new Factura("FAC1");

        factura1.agregarComponenteFac(componente1, 2);; //100 + 18%
        factura1.agregarComponenteFac(componente3, 1); //200 + 18%
        factura1.agregarComboFac(combo1, 2);; //150 + 18%

        tienda.agregarFactura(factura1);

        System.out.println(combo1.obtenerInformacionCombo());

        double totalVenta = factura1.calcularTotalVenta();
        System.out.println("Total de venta de la factura: " + totalVenta);
    }
}
