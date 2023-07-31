package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Tienda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.SystemColor;
import java.awt.Font;

public class ListarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;
	private static Tienda mitienda;
	private String id = "";
	private JButton btnmodificar;
	private JButton btneliminar;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ListarCliente(Tienda tienda) {
		this.mitienda = tienda;
		setResizable(false);
		setTitle("Listado de clientes");
		setBounds(100, 100, 901, 524);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
		        JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					
					model = new DefaultTableModel();
					String[] header = {"Código","Nombre","Direccion","Telefono"};
					model.setColumnIdentifiers(header);
					table = new JTable(model);
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
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnmodificar = new JButton("Modificar");
				btnmodificar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
				btnmodificar.setBackground(SystemColor.control);
				btnmodificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!id.equals("")){
							   Cliente aux = tienda.buscarCliente(id);
							   RegistrarCliente regcli = new RegistrarCliente(tienda,aux);
							   regcli.setModal(true);
							   regcli.setVisible(true);
						}	
					}
				});
				btnmodificar.setEnabled(false);
				btnmodificar.setActionCommand("OK");
				buttonPane.add(btnmodificar);
				getRootPane().setDefaultButton(btnmodificar);
			}
			{
				btneliminar = new JButton("Eliminar");
				btneliminar.setBackground(SystemColor.control);
				btneliminar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
				btneliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!id.equals("")){
							   Cliente aux = tienda.buscarCliente(id);
							   int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el Cliente: " + aux.getNombre(),"Información",JOptionPane.WARNING_MESSAGE);
								  if(option == JOptionPane.OK_OPTION){
									tienda.eliminarCliente(id);
									loadCliente(0);
									btneliminar.setEnabled(false);
									btnmodificar.setEnabled(false);	
								  }
							 						 
							}
					}
				});
				btneliminar.setEnabled(false);
				buttonPane.add(btneliminar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
				btnCancelar.setBackground(SystemColor.control);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadCliente(0);
	}

	public static void loadCliente(int index) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		if(index == 0){
			for (Cliente cliente : Tienda.getInstance().getMisclientes()) {
				if(cliente != null){	
					row[0] = cliente.getId();
					row[1] = cliente.getNombre();
					row[2] = cliente.getTelefono();
					row[3] = cliente.getDireccion();
					model.addRow(row);
				}
			}
		}
	}
}