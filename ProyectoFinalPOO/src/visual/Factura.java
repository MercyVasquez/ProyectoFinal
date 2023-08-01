package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Combo;
import logico.Componente;

public class Factura extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable table;
    private DefaultTableModel model;
    private JButton btnCalcular;
    private JButton btnCerrar;
    private JLabel lblSubtotal;
    private JLabel lblTotal;
    private ArrayList<Componente> componentesSeleccionados;
    private Combo comboSeleccionado;
    private Cliente clienteSeleccionado;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            Factura dialog = new Factura(null, null, null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public Factura(Cliente cliente, ArrayList<Componente> componentes, Combo combo) {
        this.clienteSeleccionado = cliente;
        this.componentesSeleccionados = componentes;
        this.comboSeleccionado = combo;

        setResizable(false);
        setTitle("Factura");
        setBounds(100, 100, 600, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPanel.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        model = new DefaultTableModel();
        String[] header = { "ID", "Descripción", "Precio" };
        model.setColumnIdentifiers(header);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPanel.add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT));

        btnCalcular = new JButton("Calcular");
        btnCalcular.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel_1.add(btnCalcular);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel_1.add(btnCerrar);

        JLabel lblNewLabel = new JLabel("Subtotal:");
        panel_1.add(lblNewLabel);

        lblSubtotal = new JLabel("0.0");
        panel_1.add(lblSubtotal);

        JLabel lblNewLabel_1 = new JLabel("Total:");
        panel_1.add(lblNewLabel_1);

        lblTotal = new JLabel("0.0");
        panel_1.add(lblTotal);

        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularFactura();
            }
        });

        loadData();
    }

    private void loadData() {
        if (clienteSeleccionado != null) {
            String[] row = { clienteSeleccionado.getId(), clienteSeleccionado.getNombre(),
                    String.valueOf(clienteSeleccionado.getDireccion()), String.valueOf(clienteSeleccionado.getTelefono()) };
            model.addRow(row);
        }

        if (componentesSeleccionados != null) {
            for (Componente componente : componentesSeleccionados) {
                String[] row = { componente.getIdcomp(), componente.getMarca(), String.valueOf(componente.getPrecio()) };
                model.addRow(row);
            }
        }

        if (comboSeleccionado != null) {
            for (Componente componente : comboSeleccionado.getComponentes()) {
                String[] row = { componente.getIdcomp(), componente.getMarca(), String.valueOf(componente.getPrecio()) };
                model.addRow(row);
            }
        }
    }

    private void calcularFactura() {
        double subtotal = 0.0;

        for (int i = 0; i < model.getRowCount(); i++) {
            subtotal += Double.parseDouble(model.getValueAt(i, 2).toString());
        }

        double impuesto = subtotal * 0.18;
        double total = subtotal + impuesto;

        DecimalFormat df = new DecimalFormat("#.##");
        lblSubtotal.setText(df.format(subtotal));
        lblTotal.setText(df.format(total));
    }
}
