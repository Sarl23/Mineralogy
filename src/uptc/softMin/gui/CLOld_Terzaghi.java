/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uptc.softMin.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class CLOld_Terzaghi extends JDialog implements ActionListener, KeyListener {

    MainWindow mainWindow;
    //Buttons
    private JButton help;
    private JButton calculate;
    //Labels
    private JLabel labtitle;
    private JLabel labConstant;
    private JLabel labWTunnel;
    private JLabel labHTunnel;
    private JLabel labAngle;
    private JLabel labDoor;
    private JLabel lbTitle2;
    private JLabel lbHp;
    private JLabel lbA3;
    private JLabel lbL;
    private JLabel lbA2;
    private JLabel lbA1;
    private JLabel lbH2;
    private JLabel lbValHp;
    private JLabel lbValA3;
    private JLabel lbValL;
    private JLabel lbValA2;
    private JLabel lbValA1;
    private JLabel lbValH2;
    //TextFields
    private JTextField txtConstant;
    private JTextField txtWTunnel;
    private JTextField txtHTunnel;
    private JTextField txtAngle;
    private JTextField txtDoor;


    public CLOld_Terzaghi(MainWindow mainWindow) {

        this.mainWindow = mainWindow;
        setTitle("Clasificacion Terzaghi");
	setResizable(false);
	setModal(true);
        setResizable(false);
        setLayout(null);
        setSize(550, 350);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("resours/icMineria.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
        beginComponents();
        addComponents();
    }

    private void beginComponents() {
        labtitle = new JLabel("Ingrese los datos para la Clasificación Terzaghi");
        labtitle.setBounds(20, 10, 280, 30);
        
        lbTitle2 = new JLabel("Resultados");
        lbTitle2.setBounds(350, 10, 80, 30);

        labConstant = new JLabel("Constante de Terzaghi");
        labConstant.setBounds(20, 40, 150, 30);
        txtConstant = new JTextField("");
        txtConstant.addKeyListener(this);
        txtConstant.setBounds(220, 45, 90, 20);
        
        lbHp = new JLabel("Hp: ");
        lbHp.setBounds(350, 45, 40, 20);
        lbValHp = new JLabel("");
        lbValHp.setBounds(380, 45, 90, 20);

        labWTunnel = new JLabel("Ancho medio del túnel (B)");
        labWTunnel.setBounds(20, 70, 160, 30);
        txtWTunnel = new JTextField("");
        txtWTunnel.addKeyListener(this);
        txtWTunnel.setBounds(220, 75, 90, 20);
        
        lbH2 = new JLabel("H2: ");
        lbH2.setBounds(350, 75, 40, 20);
        lbValH2 = new JLabel("");
        lbValH2.setBounds(380, 75, 90, 20);
        
        labHTunnel = new JLabel("Altura media del túnel (H)");
        labHTunnel.setBounds(20, 100, 160, 30);
        txtHTunnel = new JTextField("");
        txtHTunnel.addKeyListener(this);
        txtHTunnel.setBounds(220, 105, 90, 20);
        
        lbL = new JLabel("L: ");
        lbL.setBounds(350, 105, 40, 20);
        lbValL = new JLabel("");
        lbValL.setBounds(380, 105, 90, 20);

        labAngle = new JLabel("Ángulo de fricción interna de(ᶲ)");
        labAngle.setBounds(20, 130, 210, 30);
        txtAngle = new JTextField("");
        txtAngle.addKeyListener(this);
        txtAngle.setBounds(220, 135, 90, 20);
        
        lbA1 = new JLabel("A1: ");
        lbA1.setBounds(350, 135, 40, 20);
        lbValA1 = new JLabel("");
        lbValA1.setBounds(380, 135, 90, 20);

        labDoor = new JLabel("Separación de puertas.(a)");
        labDoor.setBounds(20, 160, 190, 30);
        txtDoor = new JTextField("");
        txtDoor.addActionListener(this);
        txtDoor.setBounds(220, 165, 90, 20);

        lbA2 = new JLabel("A2: ");
        lbA2.setBounds(350, 165, 40, 20);
        lbValA2 = new JLabel("");
        lbValA2.setBounds(380, 165, 90, 20);
        
        lbA3 = new JLabel("A3: ");
        lbA3.setBounds(350, 195, 40, 20);
        lbValA3 = new JLabel("");
        lbValA3.setBounds(380, 195, 90, 20);
        
        calculate = new JButton("Calcular (Reporte)");
        calculate.setBounds(20, 240, 150, 30);
        calculate.addActionListener(this);

        help = new JButton("Ayuda");
        help.setBounds(190, 240, 80, 30);
        help.addActionListener(this);
    }

    private void addComponents() {
        add(labtitle);
        add(lbTitle2);
        add(labConstant);
        add(txtConstant);
        add(labAngle);
        add(txtAngle);
        add(labHTunnel);
        add(txtHTunnel);
        add(labWTunnel);
        add(txtWTunnel);
        add(labDoor);
        add(txtDoor);
        add(lbHp);
        add(lbH2);
        add(lbL);
        add(lbA1);
        add(lbA2);
        add(lbA3);
        add(lbValHp);
        add(lbValH2);
        add(lbValL);
        add(lbValA1);
        add(lbValA2);
        add(lbValA3);
        add(calculate);
        add(help);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculate) {
            addCalculate();
        } else if (e.getSource() == help) {
            helpJDialog();
        } else {
            this.dispose();
        }
    }

    //Metodo que abre el pdf de ayuda
    private void helpJDialog() {
        try{
            File path = new File("resours/Files/ayudaTerzaghi.pdf");
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCalculate() {
        if (validateFields()) {
            double constant = Double.parseDouble(txtConstant.getText());
            double wTunnel = Double.parseDouble(txtWTunnel.getText());
            double hTunnel = Double.parseDouble(txtHTunnel.getText());
            double angle = Double.parseDouble(txtAngle.getText());
            double door = Double.parseDouble(txtDoor.getText());
            lbValA1.setText( String.valueOf(mainWindow.getManagementOld().calculateA1(hTunnel, angle)) );
            lbValA2.setText( String.valueOf(mainWindow.getManagementOld().calculateA2(constant, wTunnel, hTunnel, angle, door)) );
            lbValA3.setText( String.valueOf(mainWindow.getManagementOld().calculateA3(wTunnel, hTunnel)) );
            lbValH2.setText( String.valueOf(mainWindow.getManagementOld().calculateH2(hTunnel, wTunnel, angle)) );
            lbValHp.setText( String.valueOf(mainWindow.getManagementOld().calculateHp(constant, wTunnel, hTunnel, angle, door)) );
            lbValL.setText( String.valueOf(mainWindow.getManagementOld().calculateL(wTunnel, hTunnel, angle)) );
        } else {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cleanFields() {
        txtConstant.setText("");
        txtAngle.setText("");
        txtWTunnel.setText("");
        txtHTunnel.setText("");
        txtDoor.setText("");
        lbValA1.setText("");
        lbValA2.setText("");
        lbValA3.setText("");
        lbValH2.setText("");
        lbValHp.setText("");
        lbValL.setText("");                
    }

    private boolean validateFields() {
        return txtConstant.getText().length() + txtDoor.getText().length() > 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char pla = e.getKeyChar();
        if (e.getSource() == txtConstant) {
            if (pla < '0' || pla > '9') {
                getToolkit().beep();
                e.consume();
            }

        } else if (e.getSource() == txtHTunnel) {
            if (pla < '0' || pla > '9') {
                getToolkit().beep();
                e.consume();
            }

        } else if (e.getSource() == txtWTunnel) {
            if (pla < '0' || pla > '9') {
                getToolkit().beep();
                e.consume();
            }

        }else if(e.getSource()==txtAngle){
            if (pla < '0' || pla > '9') {
                getToolkit().beep();
                e.consume();
            }
        }
        else if(e.getSource() == txtDoor){
            if (pla < '0' || pla > '9') {
                getToolkit().beep();
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
