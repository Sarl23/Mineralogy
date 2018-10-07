/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uptc.softMin.gui;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
/**
 *
 * @author Alejandro y Sergio
 */
public class Cl_Q extends JDialog implements ActionListener{
 
    private MainWindow mainWin;
    private Font font;
    private JButton btnGetRQD;
    private JButton btnTables;
    private JButton btnCalculate;
    //ComboBox
    private JComboBox cbDescriptionRQD;
    private JComboBox cbDescriptionJn;
    private JComboBox cbDescriptionJr;
    private JComboBox cbDescriptionJa;
    private JComboBox cbDescriptionJw;
    private JComboBox cbSRF;
    //Text Area
    private JTextArea txvalueRQD;
    private JTextArea txValueJn;
    //Label
    private JLabel lbDescriptionRQD;
    private JLabel lbValueRQD;
    private JLabel lbDescriptionJn;
    private JLabel lbValueJn;
    private JLabel lbDescriptionJr;
    private JLabel lbValueJr;
    private JLabel lbDescriptionJa;
    private JLabel lbValueJa;
    private JLabel lbDescriptionJw;
    private JLabel lbValueJw;
    private JLabel lbDescriptionSRF;
    private JLabel lbInstructions;
    private JLabel lbValueSRF;
    //RadioButton
    private ButtonGroup groupJn;
    private ButtonGroup groupJa;
    private ButtonGroup groupTables;
    private JRadioButton rbTunnel;
    private JRadioButton rbPortal;
    private JRadioButton rbNone;
    private JRadioButton rbOptionAJa;
    private JRadioButton rbOptionBJa;
    private JRadioButton rbOptionCJa;
    private JRadioButton rbTable1;
    private JRadioButton rbTable2;
    private JRadioButton rbTable3;
    
    
    public Cl_Q(MainWindow mainWin){
        this.mainWin = mainWin;
        setTitle("Clasificacion Q");
        setResizable(false);
        setModal(true);
        setResizable(false);
        setLayout(null);
        setSize(670, 600);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("resours/icMineria.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
        beginComponents();
        addComponents();
    }

    
    public void beginComponents(){
        font = new Font("Comic Sans MS", Font.BOLD, 14);
        lbDescriptionRQD = new JLabel("RQD");
        lbDescriptionRQD.setBounds(20, 25, 110, 25);
        lbDescriptionRQD.setFont(font);
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
                }
            }
        });
        
        btnGetRQD = new JButton("Calcular RQD");
        btnGetRQD.setBounds(260, 50, 140, 25);
        btnGetRQD.addActionListener(this);
        // Jn Components
        lbDescriptionJn = new JLabel("Descripción Jn");
        lbDescriptionJn.setBounds(20, 80, 110, 20);
        lbDescriptionJn.setFont(font);
        cbDescriptionJn = new JComboBox(new Object[] {"A. Masivo, sin o con pocas diaclasas",
        "B. Una familia de diaclasas.", "C. Una familia de diaclasas + una aislada",
        "D. Dos familias diaclasas", "E. Dos familias de diaclasas + una aislada",
        "F. Tres familias de diaclasas", "G. Tres familias de diaclasas + una aislada",
        "H. Cuatro familia de diaclasas", "I. Roca triturada, terregal"});
        cbDescriptionJn.setBounds(30, 105, 260, 25);
        cbDescriptionJn.addActionListener(this);
        
        lbValueJn = new JLabel("Valor:");
        lbValueJn.setBounds(300, 80, 90, 25);
        txValueJn = new JTextArea();
        txValueJn.setBounds(302, 107, 60, 20);
        
        rbNone = new JRadioButton("Ninguno");
        rbNone.setBounds(400, 90, 100, 20);
        rbNone.setSelected(true);
        rbNone.addActionListener(this);
        rbTunnel = new JRadioButton("Cruses en túneles");
        rbTunnel.setBounds(400, 110, 200, 20);
        rbTunnel.addActionListener(this);
        rbPortal = new JRadioButton("Portales");
        rbPortal.setBounds(400, 130, 100, 20);
        rbPortal.addActionListener(this);
        groupJn = new ButtonGroup();
        groupJn.add(rbNone);
        groupJn.add(rbTunnel);
        groupJn.add(rbPortal);
        // Jr Components
        lbDescriptionJr = new JLabel("Número de rugosidad de las diaclasas");
        lbDescriptionJr.setBounds(20, 155, 290, 20);
        lbDescriptionJr.setFont(font);
        cbDescriptionJr = new JComboBox(new Object []{
        "A. Diaclasas sin continuidad",
        "B. Rugosas e irregulares, onduladas",
        "C Ondulación suave",
        "D. Reliz de falla o superficie de fricción ondulada",
        "E. Rugosas o irregulares pero planas",
        "F. Lisas y planas",
        "G. Reliz de falla o superficie de fricción, plana",
        "<HTML>H. zona que contiene minerales arcillosos de espesor"
        + "<br>suficiente para impedir el contacto de paredes</HTML>",
        "<HTML>I. zona arenosa, de grava o de roca triturada de <br>"
        + "espesor suficiente para impedir el contacto de paredes</HTML>"
        });
        cbDescriptionJr.setBounds(30, 180, 320, 25);
        
        lbValueJr= new JLabel("Valor: ");
        lbValueJr.setBounds(380, 180, 80, 20);
        // Ja Components
        lbDescriptionJa = new JLabel("Número de alteración de las diaclasas");
        lbDescriptionJa.setBounds(20, 215, 290, 20);
        lbDescriptionJa.setFont(font);
        
        rbOptionAJa = new JRadioButton("<HTML>Contacto con las paredes"
                + "<br>de la roca</HTML>");
        rbOptionAJa.setBounds(30, 240, 200, 30);
        rbOptionAJa.setSelected(true);
        rbOptionAJa.addActionListener(this);
        
        rbOptionBJa = new JRadioButton("<HTML>Contacto en las paredes"
                + "<br>antes de un cizalleo de 10 cm</HTML>");
        rbOptionBJa.setBounds(30, 275, 200, 30);
        rbOptionBJa.addActionListener(this);
        
        rbOptionCJa = new JRadioButton("<HTML>Sin contacto de las"
                + "<br>paredes después del cizalleo</HTML>");
        rbOptionCJa.setBounds(30, 310, 200, 30);
        rbOptionCJa.addActionListener(this);
        
        groupJa = new ButtonGroup();
        groupJa.add(rbOptionAJa);
        groupJa.add(rbOptionBJa);
        groupJa.add(rbOptionCJa);
        
        cbDescriptionJa = new JComboBox(new Object []{
        "<HTML>A. Relleno soldado, duro, inablandable, relleno "
        + "<br>&nbsp &nbsp &nbsp impermeable</HTML>",
        "B. Paredes inalteradas, solo con manchas de superficie",
        "<HTML>C. Paredes ligeramente alteradas, con recubrimiento "
        + "<br>&nbsp &nbsp &nbsp de minerales inablandable, partículas "
        + "<br>&nbsp &nbsp &nbsp arenosas, roca triturada sin arcilla</HTML>",
        "<HTML>D. Recubrimientos limoso o areno arcillosos, pequeñas "
        + "<br>&nbsp &nbsp &nbsp partículas de arcilla (inablandable)</HTML>",
        "<HTML>E. Recubrimientos ablandables o con arcillas de baja "
        + "<br>&nbsp &nbsp &nbsp fricción o sea caolinita, mica, clorita, talco, "
        + "<br>&nbsp &nbsp &nbsp yeso, grafito, Etc, y pequeñas cantidades de arcillas "
        + "<br>&nbsp &nbsp &nbsp expansivas (recubrimientos sin continuidad"
        + "<br>&nbsp &nbsp &nbsp de 1 – 2mm de espesor o menos)</HTML>"
        });
        cbDescriptionJa.setBounds(250, 240, 330, 35);
        
        lbValueJa = new JLabel("Valor: ");
        lbValueJa.setBounds(250, 285, 80, 20);
        
        lbDescriptionJw = new JLabel("Factor de reducción por agua en las diaclasas");
        lbDescriptionJw.setBounds(25, 350, 350, 20);
        lbDescriptionJw.setFont(font);
        
        cbDescriptionJw = new JComboBox(new Object[]{
                "<HTML>A. Excavación seca o poca infiltración <br>"
                        + "( < 5 lit/min localmente )</HTML>",
                "<HTML>B. Infiltración o presión alta en roca <br>"
                        + "competente con diaclasas sin relleno</HTML>",
                "<HTML>C. Gran infiltración o presión alta en <br>"
                        + "roca competente con diaclasas sin relleno</HTML>",
                "<HTML>D. Gran infiltración a presión alta, lavado <br>"
                        + "importante de los rellenos</HTML>",
                "<HTML>E. Infiltración o presión excepcionalmente alta <br>"
                        + "con las voladuras, disminuyendo con el tiempo</HTML>",
                "<HTML>F. Infiltración o presión excepcionalmente alta <br>"
                        + "en todo momento</HTML>"});
        cbDescriptionJw.setBounds(30, 375, 250, 35);
        
        lbValueJw = new JLabel("Valor: ");
        lbValueJw.setBounds(310, 380, 100, 20);
        
        lbDescriptionSRF = new JLabel("SRF");
        lbDescriptionSRF.setBounds(25, 420, 80, 25);
        lbDescriptionSRF.setFont(font);
        
        lbInstructions = new JLabel("<HTML>Para hacer este cálculo debe elegir <br>"
                + "una de las tablas, si no las conoce, las puede ver en el <br>"
                + "botón de abajo.</HTML>");
        lbInstructions.setBounds(30, 450, 200, 80);
        
        btnTables = new JButton("Ver tablas");
        btnTables.setBounds(30, 540, 100, 25);
        btnTables.addActionListener(this);
        
        rbTable1 = new JRadioButton("Tabla 1");
        rbTable1.setBounds(230, 450, 80, 20);
        rbTable1.setSelected(true);
        rbTable1.addActionListener(this);
        
        rbTable2 = new JRadioButton("Tabla 2");
        rbTable2.setBounds(230, 480, 80, 20);
        rbTable2.addActionListener(this);
        
        rbTable3 = new JRadioButton("Tabla 3");
        rbTable3.setBounds(230, 510, 80, 20);
        rbTable3.addActionListener(this);
        groupTables = new ButtonGroup();
        groupTables.add(rbTable1);
        groupTables.add(rbTable2);
        groupTables.add(rbTable3);
        
        cbSRF = new JComboBox(new Object[]{
            "<HTML>A. Multiples zonas de debilidad que contengan arcilla o"
            + "<br>&nbsp &nbsp &nbsp roca químicamente desintegrada, roca circundante"
            + "<br>&nbsp &nbsp &nbsp muy suelta (Cualquier profundidad)</HTML>",
            "<HTML>B. Zonas de debilidad aisladas que contengan arcill o"
            + "<br>&nbsp &nbsp &nbsp roca químicamente desintegrada (Profundidad"
            + "<br>&nbsp &nbsp &nbsp de excavación < 50m)</HTML>",
            "<HTML>C. Zonas de debilidad aisladas que contengan arcilla o"
            + "<br>&nbsp &nbsp &nbsp roca químicamente desintegrada (Profundidad de"
            + "<br>&nbsp &nbsp &nbsp excavación > 50m)</HTML>",
            "<HTML>D. Múltiples zonas de fractura de roca competente sin"
            + "<br>&nbsp &nbsp &nbsp arcilla , roca circundante suelta, cualquier profundidad</HTML>",
            "<HTML>E. Zonas de fracturas aisladas en roca competente sin"
            + "<br>&nbsp &nbsp &nbsp arcilla, profundidad de excavación < 50m</HTML>",
            "<HTML>F. Zonas de fracturas aisladas en roca competente sin"
            + "<br>&nbsp &nbsp &nbsp arcilla, profundidad de excavación > 50m</HTML>",
            "<HTML>G. Diaclasas abiertas sueltas, diaclasado intenso"
            + "<br>&nbsp &nbsp &nbsp cualquier profundidad</HTML>"});
        cbSRF.setBounds(320, 450, 340, 50);
        
        lbValueSRF = new JLabel("Valor: ");
        lbValueSRF.setBounds(230, 510, 150, 25);
        
        btnCalculate = new JButton("Calcular");
        btnCalculate.setBounds(150, 540, 100, 25);
        btnCalculate.addActionListener(this);
        
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
        add(rbNone);
        add(rbTunnel);
        add(rbPortal);
        add(lbDescriptionJr);
        add(cbDescriptionJr);
        add(lbValueJr);
        add(rbOptionAJa);
        add(rbOptionBJa);
        add(rbOptionCJa);
        add(lbDescriptionJa);
        add(cbDescriptionJa);
        add(lbValueJa);
        add(lbDescriptionJw);
        add(cbDescriptionJw);
        add(lbValueJw);
        add(lbDescriptionSRF);
        add(lbInstructions);
        add(btnTables);
        add(rbTable1);
        add(rbTable2);
        add(rbTable3);
        add(cbSRF);
        add(lbValueSRF);
        add(btnCalculate);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnGetRQD){
            mainWin.goClDeere();
            txvalueRQD.setText(mainWin.getClDeere().getLbResult().getText().substring(5));
        }
        if(e.getSource() == cbDescriptionJn){
            calculateValueJn();
        }
        if(e.getSource() == rbOptionAJa){
            cbDescriptionJa.removeAllItems();
            cbDescriptionJa.addItem(
                "<HTML>A. Relleno soldado, duro, inablandable, relleno "
                + "<br>&nbsp &nbsp &nbsp impermeable</HTML>");
            cbDescriptionJa.addItem(
                "B. Paredes inalteradas, solo con manchas de superficie");
            cbDescriptionJa.addItem("<HTML>C. Paredes ligeramente alteradas, con recubrimiento"
                + "<br>&nbsp &nbsp &nbsp de minerales inablandable, partículas "
                + "<br>&nbsp &nbsp &nbsp arenosas, roca triturada sin arcilla</HTML>");
            cbDescriptionJa.addItem("<HTML>D. Recubrimientos limoso o areno arcillosos, pequeñas "
                + "<br>&nbsp &nbsp &nbsp partículas de arcilla (inablandable)</HTML>");
            cbDescriptionJa.addItem("<HTML>E. Recubrimientos ablandables o con arcillas de baja "
                + "<br>&nbsp &nbsp &nbsp fricción o sea caolinita, mica, clorita, talco, "
                + "<br>&nbsp &nbsp &nbsp yeso, grafito, Etc, y pequeñas cantidades de arcillas "
                + "<br>&nbsp &nbsp &nbsp expansivas (recubrimientos sin continuidad"
                + "<br>&nbsp &nbsp &nbsp de 1 – 2mm de espesor o menos)</HTML>");
        }
        if(e.getSource() == rbOptionBJa){
            cbDescriptionJa.removeAllItems();
            cbDescriptionJa.addItem(
                "<HTML>F. Partículas arenosas, roca desintegrada sin"
                + "<br>&nbsp &nbsp &nbsp arcilla</HTML>");
            cbDescriptionJa.addItem(
                "<HTML>G. Rellenos de minerales arcillosos muy consolidados"
                + "<br>&nbsp &nbsp &nbsp e inablandables (continuos ˂5mm de espesor)");
            cbDescriptionJa.addItem(
                "<HTML>H. Rellenos de minerales arcillosos de consolidación media"
                + "<br>&nbsp &nbsp &nbsp a baja, ablandables (continuos ˂5mm de espesor)</HTML>");
            cbDescriptionJa.addItem(
                "<HTML>I. Rellenos de arcillas expansivas, montmorillonita "
                + "<br>&nbsp &nbsp &nbsp (continuos ˂5mm de espesor). El valor de "
                + "<br>&nbsp &nbsp &nbsp Ja depende del porcentaje de partículas "
                + "<br>&nbsp &nbsp &nbsp expansivas y de acceso de agua</HTML>");
        }
        if(e.getSource() == rbOptionCJa){
            cbDescriptionJa.removeAllItems();
            cbDescriptionJa.addItem(
                "J. Zonas de capa de arcilla desintegrada");
            cbDescriptionJa.addItem(
                "K. Triturada (véase G, H y I");
            cbDescriptionJa.addItem(
                "L. Condiciones de arcilla");
            cbDescriptionJa.addItem(
                "<HTML>M. Zonas de capa o arcilla limosa o arenosa limosa o arenosa, "
                + "<br>&nbsp &nbsp &nbsp pequeñas fracciones de arcilla inablandable</HTML>");
            cbDescriptionJa.addItem(
                "N. Zonas de capas de arcilla");
            cbDescriptionJa.addItem(
                "O. (véase G,H,I, para condiciones de arcilla)");
        }
        
        if(e.getSource() == rbTable1){
            cbSRF.removeAllItems();
            cbSRF.addItem(
            "<HTML>A. Multiples zonas de debilidad que contengan arcilla o"
            + "<br>&nbsp &nbsp &nbsp roca químicamente desintegrada, roca circundante"
            + "<br>&nbsp &nbsp &nbsp muy suelta (Cualquier profundidad)</HTML>");
            cbSRF.addItem(
            "<HTML>B. Zonas de debilidad aisladas que contengan arcill o"
            + "<br>&nbsp &nbsp &nbsp roca químicamente desintegrada (Profundidad"
            + "<br>&nbsp &nbsp &nbsp de excavación < 50m)</HTML>");
            cbSRF.addItem(
            "<HTML>C. Zonas de debilidad aisladas que contengan arcilla o"
            + "<br>&nbsp &nbsp &nbsp roca químicamente desintegrada (Profundidad de"
            + "<br>&nbsp &nbsp &nbsp excavación > 50m)</HTML>");
            cbSRF.addItem(
            "<HTML>D. Múltiples zonas de fractura de roca competente sin"
            + "<br>&nbsp &nbsp &nbsp arcilla , roca circundante suelta, cualquier profundidad</HTML>");
            cbSRF.addItem(
            "<HTML>E. Zonas de fracturas aisladas en roca competente sin"
            + "<br>&nbsp &nbsp &nbsp arcilla, profundidad de excavación < 50m</HTML>");
            cbSRF.addItem(
            "<HTML>F. Zonas de fracturas aisladas en roca competente sin"
            + "<br>&nbsp &nbsp &nbsp arcilla, profundidad de excavación > 50m</HTML>");
            cbSRF.addItem(
            "<HTML>G. Diaclasas abiertas sueltas, diaclasado intenso"
            + "<br>&nbsp &nbsp &nbsp cualquier profundidad</HTML>");
        }
        if(e.getSource() == rbTable2){
            cbSRF.removeAllItems();
            cbSRF.addItem(
            "H. Tensiones bajas cerca de la superficie");
            cbSRF.addItem(
            "I. Tensiones de nivel medio");
            cbSRF.addItem(
            "<HTML>J. Elevado nivel de tensiones, estructura muy cerrada"
            + "<br>&nbsp &nbsp &nbsp generalmente favorable para la estabilidad, puede"
            + "<br>&nbsp &nbsp &nbsp ser desfavorable para la estabilidad de las paredes</HTML>");
            cbSRF.addItem(
            "<HTML>K. Planchoneo moderado después de una hora en roca "
            + "<br>&nbsp &nbsp &nbsp masiva</HTML>");
            cbSRF.addItem(
            "<HTML>L. Planchoneo y explosión de roca en pocis minutos en "
            + "<br>&nbsp &nbsp &nbsp roca masiva< 50m</HTML>");
            cbSRF.addItem(
            "<HTML>M. Intensa explosión de roca e inmediatamente deformación"
            + "<br>&nbsp &nbsp &nbsp dinámica en roca masiva</HTML>");
        }
        if(e.getSource() == rbTable3){
            cbSRF.removeAllItems();
            cbSRF.addItem(
            "N. Presiones compresivas moderadas");
            cbSRF.addItem(
            "O. Presiones compresivas altas");
            cbSRF.addItem(
            "P. Presiones expansivas moderadas");
            cbSRF.addItem(
            "Q. Presiones expansicas altas");
        }
        if(e.getSource() == btnTables){
            viewTables();
        }
        if(e.getSource() == btnCalculate){
            int operationJn = 0;
            int clJa = 0;
            int tableChoice = 0;
            //OperationJn
            if(rbNone.isSelected()){
                operationJn = 0;
            } else if(rbTunnel.isSelected()){
                operationJn = 1;
            } else {
                operationJn = 2;
            }
            //OperationJa
            if(rbOptionAJa.isSelected()){
                clJa = 0;
            } else if(rbOptionBJa.isSelected()){
                clJa = 1;
            } else {
                clJa = 2;
            }
            //Tables
            if(rbTable1.isSelected()){
                tableChoice = 0;
            } else if(rbTable2.isSelected()){
                tableChoice = 1;
            } else {
                tableChoice = 2;
            }
            System.out.println(mainWin.getManagementModern().calculateQ(
                    cbDescriptionRQD.getSelectedIndex(), cbDescriptionJn.getSelectedIndex(), 
                    operationJn, cbDescriptionJr.getSelectedIndex(), clJa, 
                    cbDescriptionJa.getSelectedIndex(), cbDescriptionJw.getSelectedIndex(), 
                    tableChoice, cbSRF.getSelectedIndex()));;
        }
    }
    
    private void calculateValueJn(){
        int operation = 0;
        if(rbNone.isSelected()){
            operation = 0;
        } else if(rbTunnel.isSelected()){
            operation = 1;
        } else {
            operation = 2;
        }
        switch(cbDescriptionJn.getSelectedIndex()){
            case 0:
                txValueJn.setText(
                        String.valueOf( mainWin.getManagementModern().calculateJn(0, operation) ));
                txValueJn.setEditable(true);
                break;
            case 1:txValueJn.setText(
                        String.valueOf( mainWin.getManagementModern().calculateJn(1, operation) ));
                txValueJn.setEditable(false);
                break;   
            case 2:
                txValueJn.setText(
                        String.valueOf( mainWin.getManagementModern().calculateJn(2, operation) ));
                txValueJn.setEditable(false);
                break;
            case 3:
                txValueJn.setText(
                        String.valueOf( mainWin.getManagementModern().calculateJn(3, operation) )); 
                txValueJn.setEditable(false);
                break;
            case 4:
                txValueJn.setText(
                        String.valueOf( mainWin.getManagementModern().calculateJn(4, operation) ));
                txValueJn.setEditable(false);
                break;
            case 5:
                txValueJn.setText(
                        String.valueOf( mainWin.getManagementModern().calculateJn(5, operation) ));
                txValueJn.setEditable(false);
                break;
            case 6:
                txValueJn.setText(
                        String.valueOf( mainWin.getManagementModern().calculateJn(6, operation) ));
                txValueJn.setEditable(false);
                break;    
            case 7:
                txValueJn.setText(
                        String.valueOf( mainWin.getManagementModern().calculateJn(7, operation) ));
                txValueJn.setEditable(false);
                break;
            case 8:
                txValueJn.setText(
                        String.valueOf( mainWin.getManagementModern().calculateJn(8, operation) ));
                txValueJn.setEditable(false);
                break;    
        }
    }
    
    private void viewTables() {
       try{
            File path = new File("resours/Files/TableChoice.pdf");
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
