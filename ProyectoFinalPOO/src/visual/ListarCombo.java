package visual;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Combo;
import logico.Componente;
import logico.Tienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListarCombo extends JDialog {

    private JTable combosTable;
    private JButton btnEliminar;
    private JButton btncancelar;

    /**
     * Create the dialog.
     */
    public ListarCombo() {
    	setResizable(false);
        setTitle("Listado de Combos");
        setBounds(100, 100, 901, 524);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        String[] Header = { "Codigo", "Componentes", "Precio Total" };
        ArrayList<Combo> combos = Tienda.getInstance().getMisCombos();
        Object[][] data = new Object[combos.size()][3];

        for (int i = 0; i < combos.size(); i++) {
            Combo combo = combos.get(i);
            data[i][0] = combo.getIdCombo();
            data[i][1] = obtenerCodigosComponentes(combo);
            data[i][2] = combo.obtenerPrecioTotal();
        }
        DefaultTableModel tableModel = new DefaultTableModel(data, Header);

        combosTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(combosTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        btnEliminar = new JButton("Eliminar Combo");
        btnEliminar.setBackground(SystemColor.control);
        btnEliminar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));

        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(Color.WHITE);
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        buttonPane.add(btnEliminar);
        
        btncancelar = new JButton("Cancelar");
        btncancelar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        btncancelar.setBackground(SystemColor.control);
        btncancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        buttonPane.add(btncancelar);
    }

    private String obtenerCodigosComponentes(Combo combo) {
        StringBuilder codigos = new StringBuilder();
        ArrayList<Componente> componentes = combo.getComponentes();

        for (int i = 0; i < componentes.size(); i++) {
            Componente componente = componentes.get(i);
            codigos.append(componente.getIdcomp());
            if (i < componentes.size() - 1) {
                codigos.append(", ");
            }
        }

        return codigos.toString();
    }

    private void actualizarTabla() {
        ArrayList<Combo> combos = Tienda.getInstance().getMisCombos();
        DefaultTableModel tableModel = (DefaultTableModel) combosTable.getModel();
        tableModel.setRowCount(0);

        for (Combo combo : combos) {
            Object[] rowData = { combo.getIdCombo(), obtenerCodigosComponentes(combo), combo.obtenerPrecioTotal() };
            tableModel.addRow(rowData);
        }
    }
}