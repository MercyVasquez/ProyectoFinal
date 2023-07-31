package visual;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import logico.Combo;
import logico.Componente;
import logico.Tienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarCombo extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private DefaultComboBoxModel<Componente> componentesComboBoxModel;
    private DefaultComboBoxModel<Componente> componentesListModel;
    private Combo combo;
    private JTextField txtcodigo;

    /**
     * Create the dialog.
     */
    public RegistrarCombo() {
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
        componentesComboBoxModel.addAll(Tienda.getInstance().getComponentes());
        componentesListModel = new DefaultComboBoxModel<>();
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 895, 454);
        contentPanel.add(panel);
        panel.setLayout(null);
        
        JLabel label = new JLabel("C\u00F3digo:");
        label.setBounds(83, 146, 56, 19);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(label);
        
        txtcodigo = new JTextField();
        txtcodigo.setEnabled(false);
        txtcodigo.setText("CMB00_"+Tienda.getInstance().getGenerarcodcomb());
        txtcodigo.setBounds(165, 145, 180, 22);
        txtcodigo.setColumns(10);
        panel.add(txtcodigo);
        
        JLabel label_3 = new JLabel("Componentes:");
        label_3.setBounds(83, 200, 105, 19);
        label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(label_3);
        
        JComboBox<Componente> comboBox = new JComboBox<Componente>();
        comboBox.setBounds(200, 199, 145, 22);
        panel.add(comboBox);
        
        JList<Componente> list = new JList<Componente>();
        list.setBounds(-34, 221, 0, 0);
        panel.add(list);
        
        JButton button = new JButton("Agregar");
        button.setBounds(266, 262, 79, 25);
        panel.add(button);

        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(Color.WHITE);
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = txtcodigo.getText();
                DefaultListModel<Componente> componentes = (DefaultListModel<Componente>) listComponentes.getModel();

                combo = new Combo(codigo);
                for (int i = 0; i < componentes.getSize(); i++) {
                    Componente componente = componentes.getElementAt(i);
                    combo.agregarComponente(componente);
                }
                Tienda.getInstance().agregarCombo(combo);

                JOptionPane.showMessageDialog(null, "Combo registrado correctamente", "Registro Exitoso",
                        JOptionPane.INFORMATION_MESSAGE);
                clean();
            }
        });
        btnRegistrar.setActionCommand("OK");
        buttonPane.add(btnRegistrar);
        getRootPane().setDefaultButton(btnRegistrar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancelar.setActionCommand("Cancel");
        buttonPane.add(btnCancelar);
    }

    private void clean() {
        codigotxt.setText("");
        nombretxt.setText("");
        preciotxt.setText("");
        componentesListModel.clear();
    }
}
