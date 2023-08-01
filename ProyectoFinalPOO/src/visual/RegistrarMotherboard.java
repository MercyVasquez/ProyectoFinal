package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Componente;
import logico.TarjetaMadre;
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

public class RegistrarMotherboard extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton cancelarbtn;
	private JTextField txtcodigo;
	private JLabel label4;
	private JLabel lblNombre;
	private JTextField txtmarca;
	private Tienda mitienda = null;
	private TarjetaMadre micomp = null;
	private JTextField txtprecio;
	private JTextField txtNumSerie;
	private JTextField txtmodelo;
	private JSpinner spncantEx;
	private JComboBox cbxTipoconx;
	private JLabel label6;
	private JLabel lblConexionCpuQue;
	private JComboBox cbxram;
	private JComboBox cbxconxcpu;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public RegistrarMotherboard(Tienda tienda,TarjetaMadre comp) {
		this.mitienda = tienda;
		this.micomp = comp;
		if(micomp==null) {
			setTitle("Registrar Motherboard");
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
			lblNewLabel.setIcon(new ImageIcon(RegistrarMotherboard.class.getResource("/media/icon.png")));
			lblNewLabel.setBounds(426, 0, 469, 413);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Codigo:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(28, 52, 78, 19);
			panel.add(lblNewLabel_1);
			
			label4 = new JLabel("Modelo:");
			label4.setFont(new Font("Tahoma", Font.BOLD, 15));
			label4.setBounds(28, 196, 156, 19);
			panel.add(label4);
			
			txtcodigo = new JTextField();
			txtcodigo.setText("MB00_"+Tienda.getInstance().getGenerarcodcli());
			txtcodigo.setEditable(false);
			txtcodigo.setBounds(118, 51, 254, 22);
			panel.add(txtcodigo);
			txtcodigo.setColumns(10);
			
			lblNombre = new JLabel("Precio:");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNombre.setBounds(28, 84, 78, 19);
			panel.add(lblNombre);
			
			txtmarca = new JTextField();
			txtmarca.setBounds(118, 159, 254, 22);
			panel.add(txtmarca);
			txtmarca.setColumns(10);
			
			JLabel label2 = new JLabel("Existencia: ");
			label2.setFont(new Font("Tahoma", Font.BOLD, 15));
			label2.setBounds(28, 116, 87, 19);
			panel.add(label2);
			
			txtprecio = new JTextField();
			txtprecio.setBounds(118, 86, 254, 22);
			panel.add(txtprecio);
			txtprecio.setColumns(10);
			
			spncantEx = new JSpinner();
			spncantEx.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
			spncantEx.setBounds(118, 116, 30, 22);
			panel.add(spncantEx);
			
			JLabel lblNumSerie = new JLabel("Num. Serie:");
			lblNumSerie.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNumSerie.setBounds(168, 118, 95, 19);
			panel.add(lblNumSerie);
			
			txtNumSerie = new JTextField();
			txtNumSerie.setBounds(266, 115, 106, 22);
			panel.add(txtNumSerie);
			txtNumSerie.setColumns(10);
			
			JLabel label7 = new JLabel("Marca:");
			label7.setFont(new Font("Tahoma", Font.BOLD, 15));
			label7.setBounds(28, 160, 87, 19);
			panel.add(label7);
			
			txtmodelo = new JTextField();
			txtmodelo.setBounds(118, 195, 254, 22);
			panel.add(txtmodelo);
			txtmodelo.setColumns(10);
			
			JLabel label0 = new JLabel("Tipo de conector:");
			label0.setFont(new Font("Tahoma", Font.BOLD, 15));
			label0.setBounds(28, 246, 141, 19);
			panel.add(label0);
			
			cbxTipoconx = new JComboBox();
			cbxTipoconx.setModel(new DefaultComboBoxModel(new String[] {"<Selecciona:>", "LGA 1151 (Socket H4)", "LGA 1200 (Socket H5)", "Socket AM4", "LGA 2066 (Socket R4)", "Socket AM5"}));
			cbxTipoconx.setBounds(168, 245, 204, 22);
			panel.add(cbxTipoconx);
			
			label6 = new JLabel("Tipo de RAM:");
			label6.setFont(new Font("Tahoma", Font.BOLD, 15));
			label6.setBounds(28, 278, 141, 19);
			panel.add(label6);
			
			lblConexionCpuQue = new JLabel("Conexion CPU que acepta:");
			lblConexionCpuQue.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblConexionCpuQue.setBounds(28, 316, 212, 19);
			panel.add(lblConexionCpuQue);
			
			cbxram = new JComboBox();
			cbxram.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "DDR3", "DDR4", "LPDDR3", "LPDDR4", "DDR4X"}));
			cbxram.setBounds(137, 280, 235, 22);
			panel.add(cbxram);
			
			cbxconxcpu = new JComboBox();
			cbxconxcpu.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "LGA 1151", "LGA 1200", "AM4", "LGA 2066", "TR4"}));
			cbxconxcpu.setBounds(226, 315, 146, 22);
			panel.add(cbxconxcpu);
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
                        Componente comp = new TarjetaMadre(txtcodigo.getText(),Double.parseDouble(txtprecio.getText()),(int)spncantEx.getValue(),txtNumSerie.getText(),txtmarca.getText(),txtmodelo.getText(),cbxTipoconx.getSelectedItem().toString(),cbxram.getSelectedItem().toString(),cbxconxcpu.getSelectedItem().toString());
                        mitienda.agregarComponente(comp);
                        JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Registrado", JOptionPane.INFORMATION_MESSAGE);
                        Clean();
                        }else{
                        	
                        	micomp.setPrecio(Double.parseDouble(txtprecio.getText()));
                        	micomp.setCantidadExistente((int)spncantEx.getValue());
                        	micomp.setNumeroSerie(txtNumSerie.getText());
                        	micomp.setMarca(txtmarca.getText());
                        	micomp.setModelo(txtmodelo.getText());
                        	micomp.setTipoConexion(cbxTipoconx.getSelectedItem().toString());
                        	micomp.setTipoRam(cbxram.getSelectedItem().toString());
                        	micomp.setConexionAceptada(cbxconxcpu.getSelectedItem().toString());
                            ListarMotherboard.loadMotherb(0);
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
				cancelarbtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
				cancelarbtn.setBackground(SystemColor.control);
				cancelarbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelarbtn.setActionCommand("Cancel");
				buttonPane.add(cancelarbtn);
			}
			loadmb();
		}
	}
	private void Clean() {
		txtcodigo.setText("MB00_"+Tienda.getInstance().getGenerarcodcomp());
    	txtprecio.setText("");
    	spncantEx.setValue(new Integer ("1"));
    	txtNumSerie.setText("");
    	txtmarca.setText("");
    	txtmodelo.setText("");
    	cbxTipoconx.setSelectedIndex(0);
    	cbxram.setSelectedIndex(0);
    	cbxconxcpu.setSelectedIndex(0);
	}
	private void loadmb() {
        if(micomp!=null){
    		txtcodigo.setText(micomp.getIdcomp());
    		txtprecio.setText(String.valueOf(micomp.getPrecio()));
        	spncantEx.setValue(micomp.getCantidadExistente());
        	txtNumSerie.setText(micomp.getNumeroSerie());
        	txtmarca.setText(micomp.getMarca());
        	txtmodelo.setText(micomp.getModelo());
        	cbxTipoconx.setSelectedItem(micomp.getTipoConexion().toString());
        	cbxram.setSelectedItem(micomp.getTipoRam().toString());
        	cbxconxcpu.setSelectedItem(micomp.getConexionAceptada().toString());

        }
    }
}

