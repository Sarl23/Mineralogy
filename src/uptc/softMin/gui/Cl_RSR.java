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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * @author Sergio y Alejandro
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
    private JLabel lbDirectionAdvance;
    private JLabel lbCourse;
    private JLabel lbLevel;    
    private JLabel lbParameterC;
    private JLabel lbInfiltration;
    private JLabel lbDiscontinuity;
    private JLabel lbResult;
    //JComboBox
    private JComboBox cbTypeOfRock;
    private JComboBox cbHardness;
    private JComboBox cbDirection;
    private JComboBox cbLevel;
    private JComboBox cbDiscontinuity;
    private JComboBox cbInfiltration;
    //JRadioButton
    private ButtonGroup groupStructure;
    private ButtonGroup groupFracture;
    private ButtonGroup groupCourse;
    private JRadioButton rbMassive;
    private JRadioButton rbLight;
    private JRadioButton rbModerate;
    private JRadioButton rbIntense;
    private JRadioButton rbInches;
    private JRadioButton rbFeet;
    private JRadioButton rbPerpendicular;
    private JRadioButton rbParallel;
    //TextField
    private JTextField txFracture;
    //Buttons
    private JButton btnCalculate;
    
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
        lbParameterA = new JLabel("Parámetro A");
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
        rbMassive.setSelected(true);
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
        
        lbParameterB = new JLabel("Parámetro B");
        lbParameterB.setFont(font);
        lbParameterB.setBounds(25, 205, 150, 25);
        
        lbFractureSpacing = new JLabel("Espaciado de fracuras");
        lbFractureSpacing.setBounds(30, 240, 150, 20);
        rbInches = new JRadioButton("Pulgadas.");
        rbInches.setBounds(30, 265, 100, 20);
        rbInches.setSelected(true);
        rbInches.addActionListener(this);
        rbFeet = new JRadioButton("Pies.");
        rbFeet.setBounds(30, 285, 100, 20);
        rbFeet.addActionListener(this);
        groupFracture = new ButtonGroup();
        groupFracture.add(rbInches);
        groupFracture.add(rbFeet);
        txFracture = new JTextField("");
        txFracture.setBounds(30, 310, 60, 20);
        
        lbCourse = new JLabel("Rumbo");
        lbCourse.setBounds(200, 240, 100, 20);
        
        rbPerpendicular = new JRadioButton("Perpendicular al eje");
        rbPerpendicular.setBounds(200, 260, 150, 20);
        rbPerpendicular.setSelected(true);
        rbPerpendicular.addActionListener(this);
        rbParallel = new JRadioButton("Paralelo al eje");
        rbParallel.setBounds(200, 280, 150, 20);
        rbParallel.addActionListener(this);
        groupCourse = new ButtonGroup();
        groupCourse.add(rbPerpendicular);
        groupCourse.add(rbParallel);
        
        lbDirectionAdvance = new JLabel("Dirección de avance");
        lbDirectionAdvance.setBounds(380, 240, 150, 20);
        cbDirection = new JComboBox(new Object[]{"Ambos", "Con buzamiento", "Contra buzamiento"});
        cbDirection.setBounds(380, 260, 130, 20);
        cbDirection.addActionListener(this);
        
        lbLevel = new JLabel("Nivel");
        lbLevel.setBounds(380, 280, 80, 20);
        cbLevel = new JComboBox(new Object[]{"Bajo", "Medio", "Alto"});
        cbLevel.setBounds(380, 300, 80, 20);
        cbLevel.addActionListener(this);
        
        lbParameterC = new JLabel("Parámetro C");
        lbParameterC.setFont(font);
        lbParameterC.setBounds(25, 340, 150, 25);
        
        lbInfiltration = new JLabel("Infiltración anticipada de agua gpm en 300m de túnel:");
        lbInfiltration.setBounds(30, 370, 300, 25);
        cbInfiltration = new JComboBox(new Object[]{"Ninguna", "Ligera, < 200gpm",
        "Moderada, 200 a 1000gpm", "Alta, > 1000gpm"});
        cbInfiltration.setBounds(30, 390, 150, 20);
        cbInfiltration.addActionListener(this);
        
        lbDiscontinuity = new JLabel("Condiciones de las discontinuidades"); 
        lbDiscontinuity.setBounds(30, 410, 200, 25);
        cbDiscontinuity = new JComboBox(new Object[] {"Buena", "Regular", "Mala"});
        cbDiscontinuity.setBounds(30, 430, 90, 20);
        cbDiscontinuity.addActionListener(this);
        
        btnCalculate = new JButton("Calcular");
        btnCalculate.setBounds(30, 470, 100, 20);
        btnCalculate.addActionListener(this);
        
        lbResult = new JLabel("RSR: ");
        lbResult.setBounds(200, 465, 150, 25);
        lbResult.setFont(font);
        
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
        add(lbCourse);
        add(rbPerpendicular);
        add(rbParallel);
        add(lbDirectionAdvance);
        add(cbDirection);
        add(lbLevel);
        add(cbLevel);
        add(lbParameterC);
        add(lbInfiltration);
        add(cbInfiltration);
        add(lbDiscontinuity);
        add(cbDiscontinuity);
        add(btnCalculate);
        add(lbResult);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rbParallel){
            if(rbParallel.isSelected()){
                cbDirection.setEnabled(false);
            }
        }
        if(e.getSource() == rbPerpendicular){
            if(rbPerpendicular.isSelected()){
                cbDirection.setEnabled(true);
            }
        }
        
        if(e.getSource() == btnCalculate){
            if(validateFields()){
                lbResult.setText("RSR: ");
                //Calculate Parameter A
                int structure = 0;
                if(rbMassive.isSelected()){
                    structure = 0;
                }
                if(rbLight.isSelected()){
                    structure = 1;
                }
                if(rbModerate.isSelected()){
                    structure = 2;
                }
                if(rbIntense.isSelected()){
                    structure = 3;
                }
                mainWin.getManagementOld().calculateParameterA(
                        cbTypeOfRock.getSelectedIndex(), cbHardness.getSelectedIndex(), structure);
                /*Calculate Parameter B
                dataType = true -> Inch
                dataType = false -> foot
                */
                boolean dataType = true;
                dataType = (rbInches.isSelected()) ? true : false;
                if(rbPerpendicular.isSelected()){
                    mainWin.getManagementOld().calculateParameterB(
                            dataType, Double.parseDouble(txFracture.getText()), 
                            cbDirection.getSelectedIndex(), cbLevel.getSelectedIndex());
                } else {
                    mainWin.getManagementOld().calculateParameterB(
                            dataType, Double.parseDouble(txFracture.getText()), 
                            3, cbLevel.getSelectedIndex());
                }
                // Calculate Parameter C
                lbResult.setText(
                        lbResult.getText() + String.valueOf(
                                mainWin.getManagementOld().calculateRSR(
                                        cbInfiltration.getSelectedIndex(), 
                                        cbDiscontinuity.getSelectedIndex())
                        )
                );
            } else {
                JOptionPane.showMessageDialog(null, "Hay campos vacíos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean validateFields(){
        if(txFracture.getText().length() > 0){
            return true;
        } else {
            return false;
        }
    }
    
    public void cleanFields(){
        cbTypeOfRock.setSelectedIndex(0);
        cbHardness.setSelectedIndex(0);
        rbMassive.setSelected(true);
        rbInches.setSelected(true);
        txFracture.setText("");
        rbPerpendicular.setSelected(true);
        cbDirection.setSelectedIndex(0);
        cbDirection.setEnabled(true);
        cbLevel.setSelectedIndex(0);
        cbInfiltration.setSelectedIndex(0);
        cbDiscontinuity.setSelectedIndex(0);
        lbResult.setText("RSR: ");
    }
    
}
