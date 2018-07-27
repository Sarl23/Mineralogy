/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uptc.softMin.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Alejandro y Sergio
 */
public class ClDeere extends JDialog implements ActionListener{
    
    private MainWindow mainWin;
    private Font font;
    private JLabel lbInformation;
    private JLabel lbEquation1;
    private JLabel lbEquation2;
    private JLabel lbEquation3;
    private JLabel lbInput1;
    private JLabel lbInput2;
    private JLabel lbResult;
    private ButtonGroup btnGroup;
    private JRadioButton rbEquation1;
    private JRadioButton rbEquation2;
    private JRadioButton rbEquation3;    
    private JButton btnCalculate;    
    private JTextField txInput1;
    private JTextField txInput2;
    
    public ClDeere(MainWindow mainWin){
        this.mainWin = mainWin;setTitle("Clasificación Deere (RQD)");
	setResizable(false);
	setModal(true);
        setResizable(false);
        setLayout(null);
        setSize(600, 400);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("resours/icMineria.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
        beginComponents();
        addComponents();
    }
    
    public void beginComponents(){
        font = new Font("Comic Sans MS", Font.BOLD, 15);
        lbInformation = new JLabel("Elija la formula con la que desea realizar el cálculo");
        lbInformation.setBounds(20, 20, 300, 25);
        lbEquation1 = new JLabel(new ImageIcon("resours/images/Equation1.png"));
        lbEquation1.setBounds(35, 60, 400, 50);
        lbEquation2 = new JLabel(new ImageIcon("resours/images/Equation2.png"));
        lbEquation2.setBounds(37, 108, 180, 50);
        lbEquation3 = new JLabel(new ImageIcon("resours/images/Equation3.png"));
        lbEquation3.setBounds(32, 140, 150, 50);
        
        rbEquation1 = new JRadioButton();
        rbEquation1.setBounds(15, 75, 20, 20);
        rbEquation1.addActionListener(this);
                
        rbEquation2 = new JRadioButton();
        rbEquation2.setBounds(15, 120, 20, 20);
        rbEquation2.addActionListener(this);
        
        rbEquation3 = new JRadioButton();
        rbEquation3.setBounds(15, 154, 20, 20);
        rbEquation3.addActionListener(this);
        btnGroup = new ButtonGroup();
        btnGroup.add(rbEquation1);
        btnGroup.add(rbEquation2);
        btnGroup.add(rbEquation3);
        
        lbInput1 = new JLabel();
        lbInput1.setBounds(15, 200, 350, 25);
        txInput1 = new JTextField();
        txInput1.setBounds(25, 225, 70, 25);
        txInput1.setEnabled(false);
        
        lbInput2 = new JLabel();
        lbInput2.setBounds(15, 250, 350, 25);
        txInput2 = new JTextField();
        txInput2.setBounds(25, 275, 70, 25);
        txInput2.setEnabled(false);
        
        lbResult = new JLabel("RQD: ");
        lbResult.setBounds(350, 240, 200, 30);
        lbResult.setFont(font);
        
        btnCalculate = new JButton("Calcular");
        btnCalculate.setBounds(25, 325, 120, 25);
        btnCalculate.addActionListener(this);
    }
    
    public void addComponents(){
        add(lbInformation);
        add(lbEquation1);
        add(lbEquation2);
        add(lbEquation3);
        add(rbEquation1);
        add(rbEquation2);
        add(rbEquation3);
        add(lbInput1);
        add(lbInput2);
        add(txInput1);
        add(txInput2);
        add(lbResult);
        add(btnCalculate);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rbEquation1){
            lbInput1.setText("Ingrese el valor del numerador:");
            txInput1.setEnabled(true);
            txInput1.setText("");
            lbInput2.setText("Ingrese el valor del denominador:");
            txInput2.setText("");
            txInput2.setEnabled(true);
        }
        if(e.getSource() == rbEquation2){
            lbInput1.setText("Ingrese la frecuencia de discontinuidad:");
            txInput1.setEnabled(true);
            lbInput2.setText("");
            txInput1.setText("");
            txInput2.setText("");
            txInput2.setEnabled(false);
        }
        if(e.getSource() == rbEquation3){
            lbInput1.setText("Ingrese el total de discontinuidades por metro cúbico:");
            txInput1.setEnabled(true);
            lbInput2.setText("");
            txInput2.setEnabled(false);
            txInput1.setText("");
            txInput2.setText("");
        }
        if(e.getSource() == btnCalculate){
                if(rbEquation1.isSelected()){
                    if(txInput1.getText().length() > 0 && txInput2.getText().length() > 0){
                        lbResult.setText( lbResult.getText() + String.valueOf( 
                                mainWin.getManagementOld().calculateEquation1(
                                Double.parseDouble(txInput1.getText()), 
                                        Double.parseDouble(txInput2.getText())) ) );                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Hay campos vacíos", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if(rbEquation2.isSelected()){
                    if(txInput1.getText().length() > 0 ){
                        lbResult.setText( lbResult.getText() + String.valueOf(
                                
                            mainWin.getManagementOld().calculateEquation2(
                            Double.parseDouble(txInput1.getText()) ) ));
                    } else {
                        JOptionPane.showMessageDialog(null, "Hay campos vacíos", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if(rbEquation3.isSelected()){
                    if(txInput1.getText().length() > 0 ){
                        lbResult.setText( lbResult.getText() + String.valueOf(
                            mainWin.getManagementOld().calculateEquation3(
                            Double.parseDouble(txInput1.getText()) ) ));
                    } else {
                        JOptionPane.showMessageDialog(null, "Hay campos vacíos", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
        }
    }

    public void cleanFields(){
        txInput1.setText("");
        txInput1.setEnabled(false);
        txInput2.setText("");
        txInput2.setEnabled(false);
        lbInput1.setText("");
        lbInput2.setText("");
        lbResult.setText("RQD: ");
        rbEquation1.setSelected(false);
        rbEquation2.setSelected(false);
        rbEquation3.setSelected(false);
    }
}
