/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uptc.softMin.gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Alejandro
 */
public class Cl_Q extends JDialog implements ActionListener{
    
    private MainWindow mainWin;
    private JButton btnGetRQD;    
    //ComboBox
    private JComboBox cbDescriptionRQD;
    private JComboBox cbDescriptionJn;
    //Text Area
    private JTextArea txvalueRQD;
    private JTextArea txValueJn;
    //Label
    private JLabel lbDescriptionRQD;
    private JLabel lbValueRQD;
    private JLabel lbDescriptionJn;
    private JLabel lbValueJn;
    
    
    public Cl_Q(MainWindow mainWin){
        this.mainWin = mainWin;
        setTitle("Clasificacion Q");
	setResizable(false);
	setModal(true);
        setResizable(false);
        setLayout(null);
        setSize(600, 550);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("resours/icMineria.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
        beginComponents();
        addComponents();
    }
    
    public void beginComponents(){
        lbDescriptionRQD = new JLabel("Descripción RQD");
        lbDescriptionRQD.setBounds(30, 25, 110, 25);
        cbDescriptionRQD = new JComboBox(new Object[] {"Muy mala", "Mala", "Regular", 
        "Buena", "Excelente"});
        cbDescriptionRQD.setBounds(30, 50, 90, 25);
        
        lbValueRQD = new JLabel("Valor RQD");
        lbValueRQD.setBounds(140, 25, 90, 25);
        txvalueRQD = new JTextArea();
        txvalueRQD.setBounds(140, 52, 100, 20);
        txvalueRQD.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                switch(cbDescriptionRQD.getSelectedIndex()){
                    case 0:
                        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                            e.consume(); 
                        }
                        if(txvalueRQD.getText().length() == 2){
                            e.consume();
                        }                       
                }
            }
        });
        
        btnGetRQD = new JButton("Calcular RQD");
        btnGetRQD.setBounds(260, 50, 140, 25);
        btnGetRQD.addActionListener(this);
        
        lbDescriptionJn = new JLabel("Descripción Jn");
        lbDescriptionJn.setBounds(30, 80, 110, 20);
        cbDescriptionJn = new JComboBox(new Object[] {"A. Masivo, sin o con pocas diaclasas",
        "B. Una familia de diaclasas.", "C. Una familia de diaclasas + una aislada",
        "D. Dos familias diaclasas", "E. Dos familias de diaclasas + una aislada",
        "F. Tres familias de diaclasas", "G. Tres familias de diaclasas + una aislada",
        "H. Cuatro familia de diaclasas", "I. Roca triturada, terregal"});
        cbDescriptionJn.setBounds(30, 105, 260, 25);
        cbDescriptionJn.addActionListener(this);
        
        lbValueJn = new JLabel("Valor");
        lbValueJn.setBounds(300, 80, 90, 25);
        txValueJn = new JTextArea();
        txValueJn.setBounds(300, 107, 20, 20);
        
    }
    
    public void addComponents(){
        add(lbDescriptionRQD);
        add(cbDescriptionRQD);
        add(lbValueRQD);
        add(txvalueRQD);
        add(btnGetRQD);
        add(lbDescriptionJn);
        add(cbDescriptionJn);
        add(lbValueJn);
        add(txValueJn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnGetRQD){
            mainWin.goClDeere();
            txvalueRQD.setText(mainWin.getClDeere().getLbResult().getText());
        }
        if(e.getSource() == cbDescriptionJn){
            calculateValueJn();
        }
    }
    
    private void calculateValueJn(){
        switch(cbDescriptionJn.getSelectedIndex()){
            case 0:
                txValueJn.setText("");
                txValueJn.setEditable(true);
                break;
            case 1:
                txValueJn.setText("2");
                txValueJn.setEditable(false);
                break;   
            case 2:
                txValueJn.setText("3");
                txValueJn.setEditable(false);
                break;
            case 3:
                txValueJn.setText("4");
                txValueJn.setEditable(false);
                break;
            case 4:
                txValueJn.setText("6");
                txValueJn.setEditable(false);
                break;
            case 5:
                txValueJn.setText("9");
                txValueJn.setEditable(false);
                break;
            case 6:
                txValueJn.setText("12");
                txValueJn.setEditable(false);
                break;    
            case 7:
                txValueJn.setText("15");
                txValueJn.setEditable(false);
                break;
            case 8:
                txValueJn.setText("20");
                txValueJn.setEditable(false);
                break;    
        }
    }
    
}
