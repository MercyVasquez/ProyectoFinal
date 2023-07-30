package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Tienda;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ListarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel model;
    private static Object[] row;
    private static Tienda tienda;
    private String id = "";
    private JButton btnmodificar;
    private JButton btneliminar;
    private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ListarCliente(Tienda tienda) {
		this.tienda = tienda;
		setBounds(100, 100, 901, 524);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 883, 442);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 10, 861, 419);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPane.setBounds(0, 417, 861, -410);
			panel.add(scrollPane);
			{
				table = new JTable();
				table.setBounds(369, 13, 1, 1);
				panel.add(table);
				model = new DefaultTableModel();
                String[] header = {"Código","Nombre","Direccion","Telefono"};
                model.setColumnIdentifiers(header);
                table.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(table.getSelectedRow()>-1){
                            int index = table.getSelectedRow();
                            btneliminar.setEnabled(true);
                            btnmodificar.setEnabled(true);
                            id = String.valueOf(table.getValueAt(index, 0));

                        }
                    }
                });
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 442, 883, 35);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton btnmodificar = new JButton("Modificar");
				btnmodificar.setEnabled(false);
				btnmodificar.setActionCommand("OK");
				buttonPane.add(btnmodificar);
				getRootPane().setDefaultButton(btnmodificar);
			}
			{
				JButton btneliminar = new JButton("Eliminar");
				btneliminar.setEnabled(false);
				buttonPane.add(btneliminar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadCliente();
	}
	public static void loadCliente() {
	    model.setRowCount(0); // Suponiendo que model es un DefaultTableModel previamente inicializado
	    ArrayList<Object> row;
	    for (int i = 0; i < tienda.getCantClientes(); i++) {
	        row = new ArrayList<>();
	        row.add(tienda.getMisclientes().get(i).getId());
	        row.add(tienda.getMisclientes().get(i).getNombre());
	        row.add(tienda.getMisclientes().get(i).getDireccion());
	        row.add(tienda.getMisclientes().get(i).getTelefono());
	        model.addRow(row.toArray());
	    }
	}
}
