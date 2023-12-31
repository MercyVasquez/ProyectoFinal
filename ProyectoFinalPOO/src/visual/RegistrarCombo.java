package visual;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import logico.Cliente;
import logico.Combo;
import logico.Componente;
import logico.Tienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrarCombo extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private DefaultComboBoxModel<Componente> componentesComboBoxModel;
    private DefaultListModel<Componente> componentesListModel;
    private Combo combo;
    private JTextField txtcodigo;
    private Tienda mitienda = null;
    private Combo micombo = null;
    private JButton btnRegistrar;

    /**
     * Create the dialog.
     */
    public RegistrarCombo(Tienda tienda, Combo combo) {
        this.mitienda = tienda;
        this.micombo = combo;
        setTitle("Registrar combo");
        setResizable(false);
        setTitle("Registrar Combo");
        setBounds(100, 100, 901, 524);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        componentesComboBoxModel = new DefaultComboBoxModel<>();
        for (Componente componente : mitienda.getComponentes()) {
            componentesComboBoxModel.addElement(componente);
        }
        componentesListModel = new DefaultListModel<>();

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 895, 454);
        contentPanel.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("C�digo:");
        label.setBounds(40, 88, 56, 19);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(label);

        txtcodigo = new JTextField();
        txtcodigo.setEnabled(false);
        txtcodigo.setText("CMB00_" + Tienda.getInstance().getGenerarcodcomb());
        txtcodigo.setBounds(108, 87, 194, 22);
        txtcodigo.setColumns(10);
        panel.add(txtcodigo);

        JLabel label_3 = new JLabel("Componentes:");
        label_3.setBounds(40, 132, 105, 19);
        label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(label_3);

        JComboBox<Componente> cbxComp = new JComboBox<>();
        cbxComp.setModel(componentesComboBoxModel);
        cbxComp.setBounds(157, 131, 145, 22);
        panel.add(cbxComp);

        JList<Componente> list = new JList<>();
        list.setBackground(SystemColor.menu);
        list.setModel(componentesListModel);
        list.setBounds(40, 217, 349, 161);
        panel.add(list);

        JButton button = new JButton("Agregar");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Componente componenteSeleccionado = (Componente) cbxComp.getSelectedItem();
                componentesListModel.addElement(componenteSeleccionado);
            }
        });
        button.setBounds(292, 179, 97, 25);
        panel.add(button);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(434, 0, 461, 454);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(RegistrarCombo.class.getResource("/media/icon.png")));
        lblNewLabel.setBounds(0, 0, 461, 454);
        panel_1.add(lblNewLabel);

        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(Color.WHITE);
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        btnRegistrar.setBackground(SystemColor.control);
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = txtcodigo.getText();
                ArrayList<Componente> componentes = new ArrayList<>();
                for (int i = 0; i < componentesListModel.size(); i++) {
                    Componente componente = componentesListModel.getElementAt(i);
                    componentes.add(componente);
                }

                micombo = new Combo(codigo);
                for (Componente componente : componentes) {
                    micombo.agregarComponente(componente);
                }
                mitienda.agregarCombo(micombo);

                JOptionPane.showMessageDialog(null, "Combo registrado correctamente", "Registro Exitoso",
                        JOptionPane.INFORMATION_MESSAGE);
                clean();
            }
        });
        btnRegistrar.setActionCommand("OK");
        buttonPane.add(btnRegistrar);
        getRootPane().setDefaultButton(btnRegistrar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(SystemColor.control);
        btnCancelar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancelar.setActionCommand("Cancel");
        buttonPane.add(btnCancelar);
    }

    private void clean() {
        txtcodigo.setText("CMB00_"+Tienda.getInstance().getGenerarcodcomb());
        componentesListModel.clear();
    }
}