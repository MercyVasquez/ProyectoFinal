package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import logico.Componente;
import logico.Tienda;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class MasVendidos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField masvendidotxt;
	private JButton Actualizarbtn;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MasVendidos dialog = new MasVendidos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MasVendidos() {
		Tienda tienda = new Tienda();
		setBackground(Color.GRAY);
		setTitle("Productos mas vendidos");
		setResizable(false);
		setBounds(100, 100, 901, 524);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(882, 438, -874, -435);
			contentPanel.add(panel);
			panel.setLayout(null);
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MasVendidos.class.getResource("/media/icon.png")));
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 26));
		lblNewLabel.setBounds(384, 0, 511, 454);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mas vendido");
		lblNewLabel_1.setFont(new Font("Book Antiqua", Font.BOLD, 23));
		lblNewLabel_1.setBounds(121, 149, 139, 36);
		contentPanel.add(lblNewLabel_1);
		
		masvendidotxt = new JTextField();
		masvendidotxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		masvendidotxt.setHorizontalAlignment(SwingConstants.CENTER);
		masvendidotxt.setEditable(false);
		masvendidotxt.setForeground(Color.BLACK);
		//("");
        Componente masVendido = tienda.componenteMasVendido();

        if (masVendido != null) {
        	masvendidotxt.setText("El componente más vendido es: " + masVendido.getIdcomp());
        } else {
        	masvendidotxt.setText("No hay componentes vendidos aún.");
        }
		masvendidotxt.setBounds(47, 231, 289, 36);
		contentPanel.add(masvendidotxt);
		masvendidotxt.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				Actualizarbtn = new JButton("Actualizar");
				Actualizarbtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
				Actualizarbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						repaint();
					}
				});
				Actualizarbtn.setForeground(Color.BLACK);
				Actualizarbtn.setBackground(SystemColor.control);
				Actualizarbtn.setActionCommand("OK");
				buttonPane.add(Actualizarbtn);
				getRootPane().setDefaultButton(Actualizarbtn);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setForeground(Color.BLACK);
				cancelButton.setBackground(SystemColor.control);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
