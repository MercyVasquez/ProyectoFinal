package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Font;


public class Principal extends JFrame {
	private JPanel contentPane;
	private Tienda mitienda = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda tienda = new Tienda();
					Principal frame = new Principal(tienda);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal(Tienda tienda) {
		this.mitienda = tienda;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\FISM\\Downloads\\Black And White Modern Vintage Retro Brand Logo.png"));
		setTitle("Tienda de componentes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 524);
		setLocationRelativeTo(null); //hola
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 5, 0, 5));
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		JMenu Componentemn = new JMenu("Componente");
		Componentemn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		menuBar.add(Componentemn);
		
		JMenuItem Listarcomp = new JMenuItem("Listar");
		Listarcomp.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Componentemn.add(Listarcomp);
		
		JMenuItem Registrarcomp = new JMenuItem("Registrar");
		Registrarcomp.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Componentemn.add(Registrarcomp);
		
		JMenu Combomn = new JMenu("Combo");
		Combomn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		menuBar.add(Combomn);
		
		JMenuItem Listarcomb = new JMenuItem("Listar");
		Listarcomb.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Combomn.add(Listarcomb);
		
		JMenuItem Registrarcomb = new JMenuItem("Registrar");
		Registrarcomb.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Combomn.add(Registrarcomb);
		
		JMenu Clientemn = new JMenu("Cliente");
		Clientemn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		menuBar.add(Clientemn);
		
		JMenuItem Agregarcli = new JMenuItem("Agregar clientes");
		Agregarcli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCliente registrarcli = new RegistrarCliente(tienda, null);
				registrarcli.setModal(true);
				registrarcli.setVisible(true);
				
			}
		});
		Agregarcli.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Clientemn.add(Agregarcli);
		
		JMenuItem Listarcli = new JMenuItem("Listar clientes");
		Listarcli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCliente listarcli = new ListarCliente(tienda);
				listarcli.setModal(true);
				listarcli.setVisible(true);
			}
		});
		Listarcli.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Clientemn.add(Listarcli);
		
		JMenu Ventamn = new JMenu("Venta");
		Ventamn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		menuBar.add(Ventamn);
		
		JMenuItem masvendido = new JMenuItem("Facturar");
		masvendido.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Ventamn.add(masvendido);
		
		JMenuItem facturar = new JMenuItem("Mas vendidos");
		facturar.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Ventamn.add(facturar);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 884, 15);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 435, 884, 16);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 13, 884, 425);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel Icono = new JLabel("");
		Icono.setIcon(new ImageIcon("C:\\Users\\FISM\\Downloads\\Black And White Modern Vintage Retro Brand Logo.png"));
		Icono.setBounds(176, 25, 414, 374);
		panel_2.add(Icono);
	}
}

