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
import logico.Microprocesador;
import logico.TarjetaMadre;
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

public class ListarMotherboard extends JDialog {

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
	public ListarMotherboard(Tienda tienda) {
		this.mitienda = tienda;
		setResizable(false);
		setTitle("Listado de Motherboard");
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
					String[] header = {"C�digo","Precio","Existencia","Numero serie","Marca","Modelo","Tipo Conexion","Tipo RAM","Conx CPU aceptada"};
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
						if (!id.equals("")) {
						    Componente aux = tienda.buscarComp(id);
						    if(aux!=null) {
						    if (aux instanceof TarjetaMadre) {
						    	TarjetaMadre TarjetaMadreAux = (TarjetaMadre) aux;
						        RegistrarMotherboard regcli = new RegistrarMotherboard(tienda, TarjetaMadreAux);
						        regcli.setModal(true);
						        regcli.setVisible(true);
						    }
						    }else {
                	            JOptionPane.showMessageDialog(null, "El Motherboard no existe en la lista.", "Error",
                	                    JOptionPane.ERROR_MESSAGE);
                	        }
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
	                       if (!id.equals("")) {
	                            Componente aux = tienda.buscarComp(id);
	                            if (aux != null) {
	                                int confirm = JOptionPane.showConfirmDialog(null,
	                                        "Est� seguro que desea eliminar el Motherboard: " + aux.getIdcomp(), "Confirmar",
	                                        JOptionPane.YES_NO_OPTION);
	                                if (confirm == JOptionPane.YES_OPTION) {
	                                    tienda.eliminarComponente(id);
	                                    loadMotherb(0);
	                                    btneliminar.setEnabled(false);
	                                    btnmodificar.setEnabled(false);
	                                }
	                            }
	                        }else {
	            	            JOptionPane.showMessageDialog(null, "El Motherboard no existe en la lista.", "Error",
	            	                    JOptionPane.ERROR_MESSAGE);
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
		loadMotherb(0);
	}

	public static void loadMotherb(int index) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		if(index == 0){
			for (Componente comp : mitienda.getComponentes()) {
			    if (comp instanceof TarjetaMadre) {
			    	TarjetaMadre mb = (TarjetaMadre) comp;
			        row[0] = mb.getIdcomp();
			        row[1] = mb.getPrecio();
			        row[2] = mb.getCantidadExistente();
			        row[3] = mb.getNumeroSerie();
			        row[4] = mb.getMarca();
			        row[5] = mb.getModelo();
			        row[6] = mb.getTipoConexion();
			        row[7] = mb.getTipoRam();
			        row[8] = mb.getConexionAceptada();
			        model.addRow(row);
			    }
			}
		}
	}
}