package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Componente;
import logico.MemoriaRAM;
import logico.Tienda;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistrarRAM extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton cancelarbtn;
	private JTextField txtcodigo;
	private JLabel lblCantidadMemoria;
	private JLabel lblNombre;
	private JTextField txtmarca;
	private Tienda mitienda = null;
	private MemoriaRAM micomp = null;
	private JTextField txtprecio;
	private JTextField txtNumSerie;
	private JTextField txtcantmemoria;
	private JSpinner spncantEx;
	private JComboBox cbxTipoconx;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public RegistrarRAM(Tienda tienda,MemoriaRAM comp) {
		this.mitienda = tienda;
		this.micomp = comp;
		if(micomp==null) {
			setTitle("Registrar Memoria RAM");
		}else {
			setTitle("Modificar: "+micomp.getIdcomp()); 
		}
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setBounds(100, 100, 901, 524);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 13, 895, 413);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(RegistrarRAM.class.getResource("/media/icon.png")));
			lblNewLabel.setBounds(426, 0, 469, 413);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Codigo:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(28, 101, 78, 19);
			panel.add(lblNewLabel_1);
			
			lblCantidadMemoria = new JLabel("Cantidad memoria:");
			lblCantidadMemoria.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblCantidadMemoria.setBounds(28, 244, 156, 19);
			panel.add(lblCantidadMemoria);
			
			txtcodigo = new JTextField();
			txtcodigo.setText("RM00_"+Tienda.getInstance().getGenerarcodcli());
			txtcodigo.setEditable(false);
			txtcodigo.setBounds(118, 100, 254, 22);
			panel.add(txtcodigo);
			txtcodigo.setColumns(10);
			
			lblNombre = new JLabel("Precio:");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNombre.setBounds(28, 139, 78, 19);
			panel.add(lblNombre);
			
			txtmarca = new JTextField();
			txtmarca.setBounds(118, 205, 254, 22);
			panel.add(txtmarca);
			txtmarca.setColumns(10);
			
			JLabel label2 = new JLabel("Existencia: ");
			label2.setFont(new Font("Tahoma", Font.BOLD, 15));
			label2.setBounds(28, 171, 87, 19);
			panel.add(label2);
			
			txtprecio = new JTextField();
			txtprecio.setBounds(118, 135, 254, 22);
			panel.add(txtprecio);
			txtprecio.setColumns(10);
			
			spncantEx = new JSpinner();
			spncantEx.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
			spncantEx.setBounds(118, 170, 30, 22);
			panel.add(spncantEx);
			
			JLabel lblNumSerie = new JLabel("Num. Serie:");
			lblNumSerie.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNumSerie.setBounds(171, 173, 95, 19);
			panel.add(lblNumSerie);
			
			txtNumSerie = new JTextField();
			txtNumSerie.setBounds(266, 170, 106, 22);
			panel.add(txtNumSerie);
			txtNumSerie.setColumns(10);
			
			JLabel lblMarca = new JLabel("Marca:");
			lblMarca.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblMarca.setBounds(28, 206, 87, 19);
			panel.add(lblMarca);
			
			txtcantmemoria = new JTextField();
			txtcantmemoria.setBounds(182, 243, 190, 22);
			panel.add(txtcantmemoria);
			txtcantmemoria.setColumns(10);
			
			JLabel lblTipoDeConexion = new JLabel("Tipo:");
			lblTipoDeConexion.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblTipoDeConexion.setBounds(28, 279, 141, 19);
			panel.add(lblTipoDeConexion);
			
			cbxTipoconx = new JComboBox();
			cbxTipoconx.setModel(new DefaultComboBoxModel(new String[] {"<Selecciona:>", "DDR", "DDR-2", "DDR-3"}));
			cbxTipoconx.setBounds(118, 278, 254, 22);
			panel.add(cbxTipoconx);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
                JButton btnaceptar = new JButton("");
                btnaceptar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
                btnaceptar.setBackground(SystemColor.control);
                if(micomp==null){
                    btnaceptar.setText("Registrar");
                }else{
                    btnaceptar.setText("Modificar");
                } 
                btnaceptar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(micomp==null){
                        Componente comp = new MemoriaRAM(txtcodigo.getText(),Double.parseDouble(txtprecio.getText()),(int)spncantEx.getValue(),txtNumSerie.getText(),txtmarca.getText(),txtcantmemoria.getText(),cbxTipoconx.getSelectedItem().toString());
                        mitienda.agregarComponente(comp);
                        JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Registrado", JOptionPane.INFORMATION_MESSAGE);
                        Clean();
                        }else{
                        	
                        	micomp.setPrecio(Double.parseDouble(txtprecio.getText()));
                        	micomp.setCantidadExistente((int)spncantEx.getValue());
                        	micomp.setNumeroSerie(txtNumSerie.getText());
                        	micomp.setMarca(txtmarca.getText());
                        	micomp.setCantMemoria(txtcantmemoria.getText());
                        	micomp.setTipoMemoria(cbxTipoconx.getSelectedItem().toString());
                            ListarRAM.loadram(0);
                            dispose();
                        }
                    }


                });
                btnaceptar.setActionCommand("OK");
                buttonPane.add(btnaceptar);
                getRootPane().setDefaultButton(btnaceptar);
            }
			{
				cancelarbtn = new JButton("Cancelar");
				cancelarbtn.setBackground(SystemColor.control);
				cancelarbtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
				cancelarbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelarbtn.setActionCommand("Cancel");
				buttonPane.add(cancelarbtn);
			}
			loadRAM();
		}
	}
	private void Clean() {
		txtcodigo.setText("RM00_"+Tienda.getInstance().getGenerarcodcomp());
    	txtprecio.setText("");
    	spncantEx.setValue(new Integer ("1"));
    	txtNumSerie.setText("");
    	txtmarca.setText("");
    	txtcantmemoria.setText("");
    	cbxTipoconx.setSelectedIndex(0);
	}
	private void loadRAM() {
        if(micomp!=null){
    		txtcodigo.setText(micomp.getIdcomp());
    		txtprecio.setText(String.valueOf(micomp.getPrecio()));
        	spncantEx.setValue(micomp.getCantidadExistente());
        	txtNumSerie.setText(micomp.getNumeroSerie());
        	txtmarca.setText(micomp.getMarca());
        	txtcantmemoria.setText(micomp.getCantMemoria());
        	cbxTipoconx.setSelectedItem(micomp.getTipoMemoria().toString());

        }
    }
}

