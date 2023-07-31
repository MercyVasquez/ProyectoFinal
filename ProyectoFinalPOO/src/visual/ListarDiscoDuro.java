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

import logico.Componente;
import logico.DiscoDuro;
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

public class ListarDiscoDuro extends JDialog {

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
	public ListarDiscoDuro(Tienda tienda) {
		setBackground(SystemColor.window);
		this.mitienda = tienda;
		setResizable(false);
		setTitle("Listado de discos duros");
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
					String[] header = {"Código","Precio","Existencia","Numero serie","Marca","Modelo","Capacidad","Tipo Conexion"};
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
			buttonPane.setBackground(SystemColor.desktop);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnmodificar = new JButton("Modificar");
				btnmodificar.setBackground(SystemColor.control);
				btnmodificar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
				btnmodificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
					}
				});
				btnmodificar.setEnabled(false);
				btnmodificar.setActionCommand("OK");
				buttonPane.add(btnmodificar);
				getRootPane().setDefaultButton(btnmodificar);
			}
			{
				btneliminar = new JButton("Eliminar");
				btneliminar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
				btneliminar.setBackground(SystemColor.control);
				btneliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
		loadDiscoD(0);
	}

	public static void loadDiscoD(int index) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		if(index == 0){
			for (Componente comp : Tienda.getInstance().getComponentes()) {
			    if (comp instanceof DiscoDuro) {
			        DiscoDuro discoDuro = (DiscoDuro) comp;
			        row[0] = discoDuro.getIdcomp();
			        row[1] = discoDuro.getPrecio();
			        row[2] = discoDuro.getCantidadExistente();
			        row[3] = discoDuro.getNumeroSerie();
			        row[4] = discoDuro.getMarca();
			        row[5] = discoDuro.getModelo();
			        row[6] = discoDuro.getCapacidad();
			        row[7] = discoDuro.getTipoConexion();
			        model.addRow(row);
			    }
			}
		}
	}
}