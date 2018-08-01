/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uptc.softMin.gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Cl_Bieniawski extends JDialog implements ActionListener {

    private MainWindow mainWindow;
    private JLabel lbA_Classification;
    private JLabel lbTitleA;
    private ButtonGroup btnGroup;
    private JRadioButton rbSpotCharge;
    private JRadioButton rblCompression;
    private JTextField txSpotCharge;
    private JTextField txCompression;

    private JLabel lbB_Classification;
    private JLabel lbTitleB;
    private JTextField txB_Classification;

    public Cl_Bieniawski(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        setTitle("Clasificacion Bieniawski ");
        setResizable(false);
        setModal(true);
        setResizable(false);
        setLayout(null);
        setSize(700, 550);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("resours/images/icMineria.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
        beginComponents();
        addComponents();
    }

    private void beginComponents() {

        lbA_Classification = new JLabel("A. Parámetros de clasificación con sus valores");
        lbA_Classification.setBounds(20, 10, 320, 30);
        lbTitleA = new JLabel("1. Resistencia De la roca intacta");
        lbTitleA.setBounds(20, 31, 250, 30);

        rbSpotCharge = new JRadioButton("Índice de resistencia de carga puntual (ls)");
        rbSpotCharge.setBounds(20, 55, 280, 20);
        rbSpotCharge.addActionListener(this);

        txSpotCharge = new JTextField();
        txSpotCharge.setBounds(300, 54, 50, 20);

        rblCompression = new JRadioButton("Resistencia a la compresión uniaxial");
        rblCompression.setBounds(20, 75, 280, 20);
        rblCompression.addActionListener(this);

        txCompression = new JTextField();
        txCompression.setBounds(300, 76, 50, 20);

        
        btnGroup = new ButtonGroup();
        btnGroup.add(rbSpotCharge);
        btnGroup.add(rblCompression);
        
    }

    private void addComponents() {

        add(lbA_Classification);
        add(lbTitleA);
        add(rbSpotCharge);
        add(txSpotCharge);
        add(rblCompression);
        add(txCompression);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rbSpotCharge) {
            txSpotCharge.setEnabled(true);
            txSpotCharge.setText("");
            txCompression.setEnabled(false);
        }
        if (e.getSource() == rblCompression) {
            txSpotCharge.setEnabled(false);
            txCompression.setEnabled(true);
            txCompression.setText("");
        }

    }

}
