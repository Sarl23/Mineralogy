/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uptc.softMin.gui;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author Alejandro
 */
public class ClDeere extends JDialog{
    
    private MainWindow mainWin;
    private JLabel lbInformation;
    private JLabel lbEquation1;
    private JLabel lbEquation2;
    private JLabel lbEquation3;
    private ButtonGroup btnGroup;
    private JRadioButton rbEquation1;
    private JRadioButton rbEquation2;
    private JRadioButton rbEquation3;
    
    public ClDeere(MainWindow mainWin){
        this.mainWin = mainWin;setTitle("Clasificación Deere (RQD)");
	setResizable(false);
	setModal(true);
        setResizable(false);
        setLayout(null);
        setSize(600, 350);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("resours/icMineria.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
        beginComponents();
        addComponents();
    }
    
    public void beginComponents(){
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
        rbEquation2 = new JRadioButton();
        rbEquation2.setBounds(15, 120, 20, 20);
        rbEquation3 = new JRadioButton();
        rbEquation3.setBounds(15, 154, 20, 20);
        btnGroup = new ButtonGroup();
        btnGroup.add(rbEquation1);
        btnGroup.add(rbEquation2);
        btnGroup.add(rbEquation3);
    }
    
    public void addComponents(){
        add(lbInformation);
        add(lbEquation1);
        add(lbEquation2);
        add(lbEquation3);
        add(rbEquation1);
        add(rbEquation2);
        add(rbEquation3);
    }
    
}
