package visual;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Combo;
import logico.Componente;
import logico.Tienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListarCombo extends JDialog {

    private JTable combosTable;
    private JButton btnEliminar;
    private JButton btncancelar;
    private String id = "";
    private static Tienda mitienda;

    /**
     * Create the dialog.
     */
    public ListarCombo(Tienda tienda) {
    	this.mitienda = tienda;
    	setResizable(false);
        setTitle("Listado de Combos");
        setBounds(100, 100, 901, 524);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        String[] Header = { "Codigo", "Componentes", "Precio Total" };
        ArrayList<Combo> combos = mitienda.getMisCombos();
        Object[][] data = new Object[combos.size()][3];

        for (int i = 0; i < combos.size(); i++) {
            Combo combo = combos.get(i);
            data[i][0] = combo.getIdCombo();
            data[i][1] = obtenerCodigosComponentes(combo);
            data[i][2] = combo.obtenerPrecioTotal();
        }
        DefaultTableModel tableModel = new DefaultTableModel(data, Header);

        combosTable = new JTable(tableModel);
		combosTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(combosTable.getSelectedRow()>-1){
					int index = combosTable.getSelectedRow();
					btnEliminar.setEnabled(true);
					id = String.valueOf(combosTable.getValueAt(index, 0));
					
				}
			}
		});
        JScrollPane scrollPane = new JScrollPane(combosTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        btnEliminar = new JButton("Eliminar Combo");
        btnEliminar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                if (!id.equals("")) {
                    Combo aux = tienda.buscarCombo(id);
                    if (aux != null) {
                        int confirm = JOptionPane.showConfirmDialog(null,
                                "Está seguro que desea eliminar el combo: " + aux.getIdCombo(), "Confirmar",
                                JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            tienda.eliminarCombo(id);;
                            Loadcombo();
                            btnEliminar.setEnabled(false);
                        }
                    }
                }else {
    	            JOptionPane.showMessageDialog(null, "El combo no existe en la lista.", "Error",
    	                    JOptionPane.ERROR_MESSAGE);
    	        }
        	}
        });
        btnEliminar.setEnabled(false);
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

    private void Loadcombo() {
        ArrayList<Combo> combos = mitienda.getMisCombos();
        DefaultTableModel tableModel = (DefaultTableModel) combosTable.getModel();
        tableModel.setRowCount(0);

        for (Combo combo : combos) {
            Object[] rowData = { combo.getIdCombo(), obtenerCodigosComponentes(combo), combo.obtenerPrecioTotal() };
            tableModel.addRow(rowData);
        }
    }
}