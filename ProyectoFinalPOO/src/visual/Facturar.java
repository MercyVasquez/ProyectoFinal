package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.TitledBorder;

import logico.Combo;
import logico.Componente;
import logico.Factura;
import logico.Tienda;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Facturar extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private DefaultComboBoxModel<Componente> componentesComboBoxModel;
    private DefaultListModel<Componente> componentesListModel;
    private DefaultComboBoxModel<Combo> comboComboBoxModel;
    private DefaultListModel<Combo> comboListModel;
    private JTextField txtfecha;
    private JTextField txtcodigo;
    private JTextField txtSubtotal;
    private JTextField txtItbs;
    private JTextField txtTotal;
    private Tienda mitienda;
    private Combo combo;
    private Date fechahora;
    private Factura factura;
    private JSpinner snpCantComp;
    private JSpinner spnCantCombo;
    private JComboBox<Componente> cbxComponente;
    private JComboBox<Combo> cbxCombo;
    private JButton btnagregarcomp;
    private JButton btnagregarcomb;
    private JList<Componente> listcomp;
    private JList<Combo> listcomb;
    private JPanel panel_1;
    private JPanel panel_2;

    /**
     * Launch the application.
     */

    /**
     * Create the dialog.
     */
    public Facturar(Tienda tienda) {
		setTitle("Facturar");
    	setResizable(false);
        this.mitienda = tienda;
        factura = new Factura("FAC00_" + Tienda.getInstance().getGenerarcodFac());
        setBounds(100, 100, 901, 524);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            panel.setBounds(0, 0, 883, 442);
            contentPanel.add(panel);
            panel.setLayout(null);

            txtfecha = new JTextField();
            txtfecha.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));

            txtfecha.setEnabled(false);
            fechahora = new Date();
            txtfecha.setText(fechahora.toString());
            txtfecha.setBounds(83, 15, 204, 22);
            panel.add(txtfecha);
            txtfecha.setColumns(10);

            JLabel lblNewLabel = new JLabel("Fecha:");
            lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
            lblNewLabel.setBounds(12, 16, 100, 16);
            panel.add(lblNewLabel);
            {
                JLabel lblCodigo = new JLabel("Codigo:");
                lblCodigo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
                lblCodigo.setBounds(735, 16, 72, 21);
                panel.add(lblCodigo);
            }
            {
                txtcodigo = new JTextField();
                txtcodigo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
                txtcodigo.setEnabled(false);
                txtcodigo.setText("FAC00_" + Tienda.getInstance().getGenerarcodFac());
                txtcodigo.setBounds(808, 15, 63, 22);
                panel.add(txtcodigo);
                txtcodigo.setColumns(10);
            }
            {
                JLabel lblNewLabel_1 = new JLabel("Electronic Component Gymer");
                lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 21));
                lblNewLabel_1.setBounds(290, 91, 291, 34);
                panel.add(lblNewLabel_1);
            }
            componentesComboBoxModel = new DefaultComboBoxModel<>();
            for (Componente componente : mitienda.getComponentes()) {
                componentesComboBoxModel.addElement(componente);
            }
            componentesListModel = new DefaultListModel<>();

            cbxComponente = new JComboBox<>();
            cbxComponente.setModel(componentesComboBoxModel);
            cbxComponente.setBounds(160, 184, 126, 22);
            panel.add(cbxComponente);

            comboComboBoxModel = new DefaultComboBoxModel<>();
            for (Combo combo : mitienda.getMisCombos()) {
                comboComboBoxModel.addElement(combo);
            }
            comboListModel = new DefaultListModel<>();

            cbxCombo = new JComboBox<>();
            cbxCombo.setModel(comboComboBoxModel);
            cbxCombo.setBounds(160, 261, 127, 22);
            panel.add(cbxCombo);
            {
                JLabel lblComponente = new JLabel("Componente:");
                lblComponente.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
                lblComponente.setBounds(43, 185, 126, 16);
                panel.add(lblComponente);
            }
            {
                JLabel lblCombo = new JLabel("Combo:");
                lblCombo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
                lblCombo.setBounds(43, 262, 100, 16);
                panel.add(lblCombo);
            }
            {
                JLabel lblNewLabel_2 = new JLabel("Total:");
                lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
                lblNewLabel_2.setBounds(43, 383, 56, 16);
                panel.add(lblNewLabel_2);
            }
            {
                JLabel lblNewLabel_3 = new JLabel("Impuesto:");
                lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
                lblNewLabel_3.setBounds(43, 344, 69, 16);
                panel.add(lblNewLabel_3);
            }
            {
                JLabel lblNewLabel_4 = new JLabel("Subtotal:");
                lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
                lblNewLabel_4.setBounds(195, 344, 56, 16);
                panel.add(lblNewLabel_4);
            }
            {
                txtSubtotal = new JTextField();
                txtSubtotal.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
                txtSubtotal.setEnabled(false);
                txtSubtotal.setBounds(259, 341, 63, 22);
                panel.add(txtSubtotal);
                txtSubtotal.setColumns(10);
            }
            {
                txtItbs = new JTextField();
                double impuesto = factura.getImpuesto();
                txtItbs.setText(String.valueOf(impuesto));
                txtItbs.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
                txtItbs.setEnabled(false);
                txtItbs.setColumns(10);
                txtItbs.setBounds(120, 341, 63, 22);
                panel.add(txtItbs);
            }
            {
                txtTotal = new JTextField();
                txtTotal.setText("");
                txtTotal.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
                txtTotal.setEnabled(false);
                txtTotal.setColumns(10);
                txtTotal.setBounds(120, 380, 63, 22);
                panel.add(txtTotal);
            }
            {
                listcomb = new JList<>();
                comboListModel = new DefaultListModel<>();
                listcomb.setModel(comboListModel);
                listcomb.setBackground(SystemColor.menu);
                listcomb.setBounds(632, 184, 198, 215);
                panel.add(listcomb);
            }

            btnagregarcomp = new JButton("+");
            btnagregarcomp.setBackground(SystemColor.control);
            btnagregarcomp.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Componente componenteSeleccionado = (Componente) cbxComponente.getSelectedItem();
                    componentesListModel.addElement(componenteSeleccionado);
                    actualizarSubtotal();
                }
            });
            btnagregarcomp.setBounds(280, 219, 41, 25);
            panel.add(btnagregarcomp);

            btnagregarcomb = new JButton("+");
            btnagregarcomb.setBackground(SystemColor.control);
            btnagregarcomb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Combo comboSeleccionado = (Combo) cbxCombo.getSelectedItem();
                    comboListModel.addElement(comboSeleccionado);
                    actualizarSubtotal();
                }
            });
            btnagregarcomb.setBounds(280, 287, 41, 25);
            panel.add(btnagregarcomb);

            {
                listcomp = new JList<>();
                listcomp.setModel(componentesListModel);
                listcomp.setBackground(SystemColor.menu);
                listcomp.setBounds(433, 184, 198, 215);
                panel.add(listcomp);
            }
            
            snpCantComp = new JSpinner();
            snpCantComp.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
            snpCantComp.setBounds(290, 184, 30, 22);
            panel.add(snpCantComp);
            
            spnCantCombo = new JSpinner();
            spnCantCombo.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
            spnCantCombo.setBounds(290, 261, 30, 22);
            panel.add(spnCantCombo);
            {
            	panel_1 = new JPanel();
            	panel_1.setBackground(SystemColor.activeCaptionBorder);
            	panel_1.setBounds(12, 98, 266, 10);
            	panel.add(panel_1);
            	panel_1.setLayout(null);
            }
            {
            	panel_2 = new JPanel();
            	panel_2.setBackground(SystemColor.activeCaptionBorder);
            	panel_2.setLayout(null);
            	panel_2.setBounds(593, 98, 278, 10);
            	panel.add(panel_2);
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(SystemColor.desktop);
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton btnFac = new JButton("Facturar");
                btnFac.setBackground(SystemColor.control);
                btnFac.setActionCommand("OK");
                btnFac.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String codigoFactura = "FAC00_" + Tienda.getInstance().getGenerarcodFac();

                        factura.setCodigo(codigoFactura);
                        ArrayList<Componente> componentesSeleccionados = new ArrayList<>();
                        for (int i = 0; i < componentesListModel.size(); i++) {
                            Componente componente = (Componente) componentesListModel.getElementAt(i);
                            int cantidad = (Integer) snpCantComp.getValue();
                            for (int j = 0; j < cantidad; j++) {
                                componentesSeleccionados.add(componente);
                            }
                        }
                        ArrayList<Combo> combosSeleccionados = new ArrayList<>();
                        for (int i = 0; i < comboListModel.size(); i++) {
                            Combo combo = (Combo) comboListModel.getElementAt(i);
                            int cantidad = (Integer) spnCantCombo.getValue();
                            for (int j = 0; j < cantidad; j++) {
                                combosSeleccionados.add(combo);
                            }
                        }
                        factura.setComponente(componentesSeleccionados);
                        factura.setMisCombos(combosSeleccionados);
                        mitienda.agregarFactura(factura);
                        JOptionPane.showMessageDialog(null, "Factura registrada correctamente", "Registro Exitoso",
                                JOptionPane.INFORMATION_MESSAGE);
                        Clean();
                    }

                    
                });
                buttonPane.add(btnFac);
                getRootPane().setDefaultButton(btnFac);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setBackground(SystemColor.control);
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

    private void actualizarSubtotal() {
        double subtotal = calcularSubtotal();
        txtSubtotal.setText(String.valueOf(subtotal));
        double total = subtotal + (subtotal * factura.getImpuesto());
        txtTotal.setText(String.valueOf(total));

    }
    private void Clean() {
        txtcodigo.setText("FAC00_"+Tienda.getInstance().getGenerarcodFac());
        componentesListModel.clear();
        comboListModel.clear();
    }


    private double calcularSubtotal() {
        double subtotal = 0.0;
        
        for (int i = 0; i < componentesListModel.size(); i++) {
            Componente componente = (Componente) componentesListModel.getElementAt(i);
            subtotal += componente.getPrecio()* (Integer) snpCantComp.getValue();
        }
        for (int i = 0; i < comboListModel.size(); i++) {
            Combo combo = (Combo) comboListModel.getElementAt(i);
            subtotal += combo.obtenerPrecioTotal()*(Integer) spnCantCombo.getValue();
        }
        
        return subtotal;
    }
}
