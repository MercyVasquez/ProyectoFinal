package visual;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
        componentesListModel = new DefaultListModel<>();

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 895, 454);
        contentPanel.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("Código:");
        label.setBounds(83, 146, 56, 19);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(label);

        txtcodigo = new JTextField();
        txtcodigo.setEnabled(false);
        txtcodigo.setText("CMB00_" + Tienda.getInstance().getGenerarcodcomb());
        txtcodigo.setBounds(165, 145, 180, 22);
        txtcodigo.setColumns(10);
        panel.add(txtcodigo);

        JLabel label_3 = new JLabel("Componentes:");
        label_3.setBounds(83, 200, 105, 19);
        label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(label_3);

        JComboBox<Componente> comboBox = new JComboBox<>();
        comboBox.setModel(componentesComboBoxModel);
        comboBox.setBounds(200, 199, 145, 22);
        panel.add(comboBox);

        JList<Componente> list = new JList<>();
        list.setModel(componentesListModel);
        list.setBounds(370, 90, 280, 250);
        panel.add(list);

        JButton button = new JButton("Agregar");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Componente componenteSeleccionado = (Componente) comboBox.getSelectedItem();
                componentesListModel.addElement(componenteSeleccionado);
            }
        });
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
                ArrayList<Componente> componentes = new ArrayList<>();
                for (int i = 0; i < componentesListModel.size(); i++) {
                    Componente componente = componentesListModel.getElementAt(i);
                    componentes.add(componente);
                }

                combo = new Combo(codigo);
                for (Componente componente : componentes) {
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
        txtcodigo.setText("CMB00_" + Tienda.getInstance().getGenerarcodcomb());
        componentesListModel.clear();
    }
}
