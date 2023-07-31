package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Componente;
import logico.Microprocesador;
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

public class RegistrarMicroprocesador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton cancelarbtn;
	private JTextField txtcodigo;
	private JLabel label4;
	private JLabel lblNombre;
	private JTextField txtmarca;
	private Tienda mitienda = null;
	private Microprocesador micomp = null;
	private JTextField txtprecio;
	private JTextField txtNumSerie;
	private JTextField txtmodelo;
	private JSpinner spncantEx;
	private JComboBox cbxTipoconx;
	private JLabel lblVelProcesador;
	private JTextField txtvel;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public RegistrarMicroprocesador(Tienda tienda,Microprocesador comp) {
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
			lblNewLabel.setIcon(new ImageIcon(RegistrarMicroprocesador.class.getResource("/media/icon.png")));
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
			txtcodigo.setText("CPU00_"+Tienda.getInstance().getGenerarcodcli());
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
			
			JLabel lblMarca = new JLabel("Marca:");
			lblMarca.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblMarca.setBounds(28, 160, 87, 19);
			panel.add(lblMarca);
			
			txtmodelo = new JTextField();
			txtmodelo.setBounds(118, 195, 254, 22);
			panel.add(txtmodelo);
			txtmodelo.setColumns(10);
			
			JLabel lblTipoDeConexion = new JLabel("Tipo de conexion:");
			lblTipoDeConexion.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblTipoDeConexion.setBounds(28, 246, 141, 19);
			panel.add(lblTipoDeConexion);
			
			cbxTipoconx = new JComboBox();
			cbxTipoconx.setModel(new DefaultComboBoxModel(new String[] {"<Selecciona:>", "LGA 1151", "LGA 2066", "LGA 1200", "LGA 1700", "Socket AM3+", "Socket FM2+", "Socket AM4"}));
			cbxTipoconx.setBounds(216, 245, 156, 22);
			panel.add(cbxTipoconx);
			
			lblVelProcesador = new JLabel("Vel. procesador:");
			lblVelProcesador.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblVelProcesador.setBounds(28, 295, 141, 19);
			panel.add(lblVelProcesador);
			
			txtvel = new JTextField();
			txtvel.setBounds(185, 294, 187, 22);
			panel.add(txtvel);
			txtvel.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
                JButton btnaceptar = new JButton("");
                if(micomp==null){
                    btnaceptar.setText("Registrar");
                }else{
                    btnaceptar.setText("Modificar");
                } 
                btnaceptar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(micomp==null){
                        Componente comp = new Microprocesador(txtcodigo.getText(),Double.parseDouble(txtprecio.getText()),(int)spncantEx.getValue(),txtNumSerie.getText(),txtmarca.getText(),txtmodelo.getText(),cbxTipoconx.getSelectedItem().toString(),txtvel.getText());
                        Tienda.getInstance().agregarComponente(comp);
                        JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Registrado", JOptionPane.INFORMATION_MESSAGE);
                        Clean();
                        }else{
                        	
                        	micomp.setPrecio(Double.parseDouble(txtprecio.getText()));
                        	micomp.setCantidadExistente((int)spncantEx.getValue());
                        	micomp.setNumeroSerie(txtNumSerie.getText());
                        	micomp.setMarca(txtmarca.getText());
                        	micomp.setModelo(txtmodelo.getText());
                        	micomp.setTipoConexion(cbxTipoconx.getSelectedItem().toString());
                        	micomp.setVelocidadProcesamiento(txtvel.getText());
                            ListarDiscoDuro.loadDiscoD(0);
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
				cancelarbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelarbtn.setActionCommand("Cancel");
				buttonPane.add(cancelarbtn);
			}
			loadDiscoD();
		}
	}
	private void Clean() {
		txtcodigo.setText("CPU00_"+Tienda.getInstance().getGenerarcodcomp());
    	txtprecio.setText("");
    	spncantEx.setValue(new Integer ("1"));
    	txtNumSerie.setText("");
    	txtmarca.setText("");
    	txtmodelo.setText("");
    	cbxTipoconx.setSelectedIndex(0);
    	txtvel.setText("");
	}
	private void loadDiscoD() {
        if(micomp!=null){
    		txtcodigo.setText(micomp.getIdcomp());
    		txtprecio.setText(String.valueOf(micomp.getPrecio()));
        	spncantEx.setValue(micomp.getCantidadExistente());
        	txtNumSerie.setText(micomp.getNumeroSerie());
        	txtmarca.setText(micomp.getMarca());
        	txtmodelo.setText(micomp.getModelo());
        	cbxTipoconx.setSelectedItem(micomp.getTipoConexion().toString());
        	txtvel.setText(micomp.getVelocidadProcesamiento());

        }
    }
}

