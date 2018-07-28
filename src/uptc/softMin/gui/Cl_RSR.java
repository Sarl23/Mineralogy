/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uptc.softMin.gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Alejandro
 */
public class Cl_RSR extends JDialog implements ActionListener{
    
    private MainWindow mainWin;
    private Font font;
    //JLabel
    private JLabel lbParameterA;
    private JLabel lbTypeOfRock;
    private JLabel lbHardness;
    private JLabel lbStructure;
    private JLabel lbParameterB;
    private JLabel lbFractureSpacing;
    private JLabel lbPerpendicular;
    private JLabel lbDirectionAdvance;
    //JComboBox
    private JComboBox cbTypeOfRock;
    private JComboBox cbHardness;
    private JComboBox cbDirection;
    //JRadioButton
    private ButtonGroup groupStructure;
    private ButtonGroup groupFracture;
    private JRadioButton rbMassive;
    private JRadioButton rbLight;
    private JRadioButton rbModerate;
    private JRadioButton rbIntense;
    private JRadioButton rbInches;
    private JRadioButton rbFeet;
    //TextField
    private JTextField txFracture;
    
    public Cl_RSR(MainWindow mainWin){
        this.mainWin = mainWin;
        setTitle("Clasificacion RSR");
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
        font = new Font("Comic Sans MS", Font.BOLD, 15);
        lbParameterA = new JLabel("Parametro A");
        lbParameterA.setFont(font);
        lbParameterA.setBounds(25, 25, 150, 25);
        
        lbTypeOfRock = new JLabel("Tipo de roca");
        lbTypeOfRock.setBounds(30, 60, 150, 20);
        cbTypeOfRock = new JComboBox( new Object[]{"Ignea", "Metamórfica", "Sedimentaria"} );
        cbTypeOfRock.setBounds(30, 90, 100, 25);
        cbTypeOfRock.addActionListener(this);
        
        lbHardness = new JLabel("Dureza");
        lbHardness.setBounds(180, 60, 100, 20);
        cbHardness = new JComboBox(new Object[]{"Dura", "Media", "Blanda", "Descompuesta"});
        cbHardness.addActionListener(this);
        cbHardness.setBounds(180, 90, 100, 25);
        
        lbStructure = new JLabel("Estructura geológica");
        lbStructure.setBounds(320, 60, 180, 20);
        rbMassive = new JRadioButton("Masiva.");
        rbMassive.setBounds(320, 90, 150, 20);
        rbMassive.addActionListener(this);
        
        rbLight = new JRadioButton("Ligeramente fracturada/plegada.");
        rbLight.setBounds(320, 120, 250, 20);
        rbLight.addActionListener(this);
        
        rbModerate = new JRadioButton("Moderadamente fracturada/plegada.");
        rbModerate.setBounds(320, 150, 250, 20);
        rbModerate.addActionListener(this);
        
        rbIntense = new JRadioButton("Intensamente fracturada/plegada.");
        rbIntense.setBounds(320, 180, 250, 20);
        rbIntense.addActionListener(this);
        groupStructure = new ButtonGroup();
        groupStructure.add(rbMassive);
        groupStructure.add(rbLight);
        groupStructure.add(rbModerate);
        groupStructure.add(rbIntense);
        
        lbParameterB = new JLabel("Parametro B");
        lbParameterB.setFont(font);
        lbParameterB.setBounds(25, 205, 150, 25);
        
        lbFractureSpacing = new JLabel("Espaciado de fracuras");
        lbFractureSpacing.setBounds(30, 240, 150, 20);
        rbInches = new JRadioButton("Pulgadas.");
        rbInches.setBounds(30, 265, 100, 20);
        rbInches.addActionListener(this);
        rbFeet = new JRadioButton("Pies.");
        rbFeet.setBounds(30, 285, 100, 20);
        rbFeet.addActionListener(this);
        groupFracture = new ButtonGroup();
        groupFracture.add(rbInches);
        groupFracture.add(rbFeet);
        txFracture = new JTextField("");
        txFracture.setBounds(30, 310, 60, 20);
        
        lbPerpendicular = new JLabel("Perpendicular al eje");
        lbPerpendicular.setBounds(200, 240, 150, 20);
        lbDirectionAdvance = new JLabel("Dirección de avance");
        lbDirectionAdvance.setBounds(200, 270, 150, 20);
        cbDirection = new JComboBox(new Object[]{"Ambos", "Con buzamiento", "Contra buzamiento"});
        cbDirection.setBounds(200, 300, 130, 20);
        cbDirection.addActionListener(this);
    }
    
    public void addComponents(){
        add(lbParameterA);
        add(lbTypeOfRock);
        add(cbTypeOfRock);
        add(lbHardness);
        add(cbHardness);
        add(lbStructure);
        add(rbMassive);
        add(rbLight);
        add(rbModerate);
        add(rbIntense);
        add(lbParameterB);
        add(lbFractureSpacing);
        add(rbInches);
        add(rbFeet);
        add(txFracture);
        add(lbPerpendicular);
        add(lbDirectionAdvance);
        add(cbDirection);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
