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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    //ComboBox
    private JComboBox cbDescriptionRQD;
    private JComboBox cbDescriptionJn;
    private JComboBox cbDescriptionJr;
    private JComboBox cbDescriptionJa;
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
    //RadioButton
    private ButtonGroup groupJn;
    private ButtonGroup groupJa;
    private JRadioButton rbTunnel;
    private JRadioButton rbPortal;
    private JRadioButton rbNone;
    private JRadioButton rbOptionAJa;
    private JRadioButton rbOptionBJa;
    private JRadioButton rbOptionCJa;
    
    
    public Cl_Q(MainWindow mainWin){
        this.mainWin = mainWin;
        setTitle("Clasificacion Q");
        setResizable(false);
        setModal(true);
        setResizable(false);
        setLayout(null);
        setSize(650, 550);
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
