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
import javax.swing.JTextField;


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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/media/icon.png")));
		setTitle("Tienda de componentes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 524);
		setLocationRelativeTo(null); 
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 5, 0, 5));
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		JMenu Componentemn = new JMenu("Componente");
		Componentemn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		menuBar.add(Componentemn);
		
		JMenuItem ListarDiscoD = new JMenuItem("Listar Disco Duro");
		ListarDiscoD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarDiscoDuro listardd = new ListarDiscoDuro(tienda);
				listardd.setModal(true);
				listardd.setVisible(true);
			}
		});
		ListarDiscoD.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Componentemn.add(ListarDiscoD);
		
		JMenuItem RegistrarDD = new JMenuItem("Registrar Disco Duro");
		RegistrarDD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarDiscoDuro regdd = new RegistrarDiscoDuro(tienda, null);
				regdd.setModal(true);
				regdd.setVisible(true);
			}
		});
		RegistrarDD.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Componentemn.add(RegistrarDD);
		
		JMenuItem listarRam = new JMenuItem("Listar Memoria RAM");
		listarRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarRAM listram = new ListarRAM(tienda);
				listram.setModal(true);
				listram.setVisible(true);
			}
		});
		listarRam.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Componentemn.add(listarRam);
		
		JMenuItem registrarRam = new JMenuItem("Registrar Memoria RAM");
		registrarRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarRAM regram = new RegistrarRAM(tienda, null);
				regram.setModal(true);
				regram.setVisible(true);
			}
		});
		registrarRam.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Componentemn.add(registrarRam);
		
		JMenuItem lisMicroprocesador = new JMenuItem("Listar Microprocesador");
		lisMicroprocesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarMicroprocesador listmicrop = new ListarMicroprocesador(tienda);
				listmicrop.setModal(true);
				listmicrop.setVisible(true);
			}
		});
		lisMicroprocesador.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Componentemn.add(lisMicroprocesador);
		
		JMenuItem regMicroprocesador = new JMenuItem("Registrar Microprocesador");
		regMicroprocesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarMicroprocesador regmc = new RegistrarMicroprocesador(tienda, null);
				regmc.setModal(true);
				regmc.setVisible(true);
			}
		});
		regMicroprocesador.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Componentemn.add(regMicroprocesador);
		
		JMenuItem lisTarjetaMadre = new JMenuItem("Listar Tarjeta Madre");
		lisTarjetaMadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarMotherboard mb = new ListarMotherboard(tienda);
				mb.setModal(true);
				mb.setVisible(true);
			}
		});
		lisTarjetaMadre.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Componentemn.add(lisTarjetaMadre);
		
		JMenuItem mntmRegistrarTarjetaMadre = new JMenuItem("Registrar Tarjeta Madre");
		mntmRegistrarTarjetaMadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarMotherboard mb = new RegistrarMotherboard(tienda,null);
				mb.setModal(true);
				mb.setVisible(true);
			}
		});
		mntmRegistrarTarjetaMadre.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Componentemn.add(mntmRegistrarTarjetaMadre);
		
		JMenu Combomn = new JMenu("Combo");
		Combomn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		menuBar.add(Combomn);
		
		JMenuItem Listarcomb = new JMenuItem("Listar");
		Listarcomb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCombo comb = new ListarCombo(tienda);
				comb.setModal(true);
				comb.setVisible(true);
			}
		});
		Listarcomb.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Combomn.add(Listarcomb);
		
		JMenuItem Registrarcomb = new JMenuItem("Registrar");
		Registrarcomb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCombo regcomb = new RegistrarCombo(tienda,null);
				regcomb.setModal(true);
				regcomb.setVisible(true);
			}
		});
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
		masvendido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturar fac = new Facturar(tienda);
				fac.setModal(true);
				fac.setVisible(true);
			}
		});
		masvendido.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Ventamn.add(masvendido);
		
		JMenuItem facturar = new JMenuItem("Mas vendidos");
		facturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasVendidos ms = new MasVendidos(tienda);
				ms.setModal(true);
				ms.setVisible(true);
			}
		});
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
		Icono.setIcon(new ImageIcon(Principal.class.getResource("/media/icon.png")));
		Icono.setBounds(188, 25, 414, 374);
		panel_2.add(Icono);
	}
}

