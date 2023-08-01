package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Cliente;
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

public class RegistrarCliente extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JButton cancelarbtn;
    private JTextField codigotxt;
    private JLabel lblDireccion;
    private JLabel lblNombre;
    private JLabel lblTelefono;
    private JTextField nombretxt;
    private JTextField telefonotxt;
    private Tienda mitienda = null;
    private Cliente micliente = null;
    private JTextArea direcciontxt;

    /**
     * Create the dialog.
     */
    public RegistrarCliente(Tienda tienda, Cliente cliente) {
        this.mitienda = tienda;
        this.micliente = cliente;
        if (micliente == null) {
            setTitle("Registrar cliente");
        } else {
            setTitle("Modificar: " + micliente.getNombre());
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

            JLabel lblNewLabel = new JLabel("Registrar cliente");
            lblNewLabel.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/media/icon.png")));
            lblNewLabel.setBounds(426, 0, 469, 413);
            panel.add(lblNewLabel);

            JLabel lblNewLabel_1 = new JLabel("Codigo:");
            lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
            lblNewLabel_1.setBounds(28, 86, 78, 19);
            panel.add(lblNewLabel_1);

            lblDireccion = new JLabel("Direccion: ");
            lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 15));
            lblDireccion.setBounds(28, 183, 87, 19);
            panel.add(lblDireccion);

            codigotxt = new JTextField();
            codigotxt.setText("CL00_" + Tienda.getInstance().getGenerarcodcli());
            codigotxt.setEditable(false);
            codigotxt.setBounds(123, 85, 254, 22);
            panel.add(codigotxt);
            codigotxt.setColumns(10);

            lblNombre = new JLabel("Nombre: ");
            lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
            lblNombre.setBounds(28, 137, 78, 19);
            panel.add(lblNombre);

            lblTelefono = new JLabel("Telefono: ");
            lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 15));
            lblTelefono.setBounds(28, 293, 87, 19);
            panel.add(lblTelefono);

            nombretxt = new JTextField();
            nombretxt.setBounds(123, 136, 254, 22);
            panel.add(nombretxt);
            nombretxt.setColumns(10);

            telefonotxt = new JTextField();
            telefonotxt.setBounds(123, 292, 254, 22);
            panel.add(telefonotxt);
            telefonotxt.setColumns(10);

            direcciontxt = new JTextArea();
            direcciontxt.setBackground(SystemColor.menu);
            direcciontxt.setLineWrap(true);
            direcciontxt.setBounds(123, 182, 254, 85);
            panel.add(direcciontxt);
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
                if (micliente == null) {
                    btnaceptar.setText("Registrar");
                } else {
                    btnaceptar.setText("Modificar");
                }
                btnaceptar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (micliente == null) {
                            Cliente cli = new Cliente(codigotxt.getText(), nombretxt.getText(), direcciontxt.getText(),
                                    telefonotxt.getText());
                            mitienda.agregarCliente(cli);
                            JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Registrado",
                                    JOptionPane.INFORMATION_MESSAGE);
                            Clean();
                        } else {
                            micliente.setNombre(nombretxt.getText());
                            micliente.setDireccion(direcciontxt.getText());
                            micliente.setTelefono(telefonotxt.getText());
                            mitienda.modificarCliente(micliente);
                            JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Modificado",
                                    JOptionPane.INFORMATION_MESSAGE);
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
            loadCliente();
        }
    }

    private void Clean() {
        codigotxt.setText("CL00_" + Tienda.getInstance().getGenerarcodcli());
        nombretxt.setText("");
        direcciontxt.setText("");
        telefonotxt.setText("");
    }

    private void loadCliente() {
        if (micliente != null) {
            codigotxt.setText(micliente.getId());
            nombretxt.setText(micliente.getNombre());
            direcciontxt.setText(micliente.getDireccion());
            telefonotxt.setText(micliente.getTelefono());
        }
    }
}
