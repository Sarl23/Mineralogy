/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uptc.softMin.gui;

import java.awt.Image;
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
public class Cl_Q extends JDialog{
    
    private MainWindow mainWin;
    private JButton btnGetRQD;    
    //ComboBox
    private JComboBox cbDescriptionRQD;
    //Text Area
    private JTextArea txvalueRQD;
    //Label
    private JLabel lbDescriptionRQD;
    private JLabel lbValueRQD;
    
    
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
        lbDescriptionRQD = new JLabel("Descripción");
        lbDescriptionRQD.setBounds(30, 25, 100, 25);
        cbDescriptionRQD = new JComboBox(new Object[] {"Muy mala", "Mala", "Regular", 
        "Buena", "Excelente"});
        cbDescriptionRQD.setBounds(30, 50, 80, 25);
        
        lbValueRQD = new JLabel("Valor RQD");
        lbValueRQD.setBounds(120, 25, 90, 25);
        txvalueRQD = new JTextArea();
        txvalueRQD.setBounds(120, 50, 60, 20);
        
        btnGetRQD = new JButton("Calcular RQD");
    }
    
    public void addComponents(){
        add(lbDescriptionRQD);
        add(cbDescriptionRQD);
        add(lbValueRQD);
        add(txvalueRQD);
    }
    
}
