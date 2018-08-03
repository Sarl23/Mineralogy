/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uptc.softMin.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Cl_Bieniawski extends JDialog implements ActionListener {

    private MainWindow mainWindow;
    private JPanel mypanel;
    private JScrollPane scroll;

    //Inicia apartado A
    private JLabel lbA_Classification;
    private JLabel lbTitleA;
    private ButtonGroup btnGroup;
    private JRadioButton rbSpotCharge;
    private JRadioButton rblCompression;
    private JTextField txSpotCharge;
    private JTextField txCompression;
    private JLabel lbRQD;
    private JTextField txRDQ;
    private JButton btnRQD;
    private JLabel lbDiscontinuity;
    private JTextField txDiscontinuity;
    private JLabel lbContinuity;
    private JRadioButton  rbS_Rough; //super rugosa
    private JRadioButton  rbL_Rough;//ligera rugosa
    private JRadioButton rbL_RoughSeparation; //ligera seperada rugosa
    private JRadioButton rbSurface_Polished;//superficie pulida
    private JRadioButton rbFilling; // rellena
    private ButtonGroup btnGroup4;
    private JLabel lbGroundWater;
    private JLabel lbFlow;
    private JTextField txFlow;
    private JLabel lbWaterPressure;
    private JTextField txWaterPressure;
    private JLabel lbG_Conditions;
    private JComboBox cbG_Conditions;
    

      
//Inicia apartado B
    private JLabel lbB_Classification;
    private JLabel lbTitleB;
    private JComboBox cbColum;
    private JComboBox cbRow;
    
    //Inicia apartado C
    private JLabel lbC_Classification;
    private JLabel lbTitleC;
    private JTextField txScore;
    

    public Cl_Bieniawski(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        setTitle("Clasificacion Bieniawski ");
        setResizable(false);
        setModal(true);
        setResizable(false);
        //setLayout(null);
        setSize(680, 550);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("resours/images/icMineria.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
        beginComponents();
        addComponents();
    }

    private void beginComponents() {
        
        mypanel = new JPanel();
        mypanel.setLayout(null);
        mypanel.setPreferredSize(new Dimension(600, 950));
        scroll = new JScrollPane();
        scroll.setBounds(5, 10, 680, 550);

        //Inicia componenrtes del apartado A
        
        lbA_Classification = new JLabel("A. Parámetros de clasificación con sus valores");
        lbA_Classification.setBounds(20, 8, 520, 30);
        lbA_Classification.setForeground(Color.BLACK);
        lbA_Classification.setFont(new Font("mi font", Font.BOLD, 18));
        lbTitleA = new JLabel("1. Resistencia De la roca intacta");
        lbTitleA.setBounds(20, 31, 250, 30);

        rbSpotCharge = new JRadioButton("Índice de resistencia de carga puntual (ls)    MPa");
        rbSpotCharge.setBounds(20, 55, 300, 20);
        rbSpotCharge.addActionListener(this);
        txSpotCharge = new JTextField();
        txSpotCharge.setBounds(320, 54, 50, 20);

        rblCompression = new JRadioButton("Resistencia a la compresión uniaxial  MPa");
        rblCompression.setBounds(20, 75, 300, 20);
        rblCompression.addActionListener(this);
        txCompression = new JTextField();
        txCompression.setBounds(320, 76, 50, 20);

        btnGroup = new ButtonGroup();
        btnGroup.add(rbSpotCharge);
        btnGroup.add(rblCompression);
        
        lbRQD = new JLabel("2. RQD%");
        lbRQD.setBounds(20, 100, 50, 30);
        txRDQ= new JTextField("");
        txRDQ.setBounds(75, 105, 50, 20);
        btnRQD= new JButton("Calcular RQD");
        btnRQD.setBounds(160, 105, 110, 20);
        btnRQD.addActionListener(this);
        
        lbDiscontinuity = new JLabel("3. Espacio de las discontinuidades");
        lbDiscontinuity.setBounds(20, 140, 250, 20);
        txDiscontinuity= new JTextField("");
        txDiscontinuity.setBounds(220, 140, 50, 20);
        
        lbContinuity = new JLabel("4. Condición de las discontinuidades(ver E)" );
        lbContinuity.setBounds(20, 180, 280, 20);
        rbS_Rough =  new JRadioButton("Superficies muy rugosas, sin continuidad, sin separación, paredes de rocas sin alteración.");
        rbS_Rough.setBounds(20, 200, 550, 20);
        rbL_Rough = new JRadioButton("Superficies ligeramente rugosas con separación < 1mm. Paredes altamente meteorizadas.");
        rbL_Rough.setBounds(20, 220, 550 , 20);
        rbL_RoughSeparation = new JRadioButton("Superficies ligeramente rugosas con separación <1mm Paredes altamente meteorizadas");
        rbL_RoughSeparation.setBounds(20, 240, 650, 20);
        rbSurface_Polished= new JRadioButton("Superficies pulidas o relleno <5mm se espesura o separación 1-5mm. Continuas.");
        rbSurface_Polished.setBounds(20, 260, 550  , 20);
        rbFilling = new JRadioButton("Relleno blando>5mm de espesor Separación >5mm continuas.");
        rbFilling.setBounds(20, 280, 400, 20);
        
        btnGroup4 = new ButtonGroup();
        btnGroup4.add(rbS_Rough);
        btnGroup4.add(rbL_Rough);
        btnGroup4.add(rbL_RoughSeparation);
        btnGroup4.add(rbSurface_Polished);
        btnGroup4.add(rbFilling);
        
        lbGroundWater = new JLabel("5. Aguas subterráneas");
        lbGroundWater.setBounds(20, 320, 180, 20);
        lbFlow = new JLabel("Flujo por cada 10 m de longitud del túnel (l/m)");
        lbFlow.setBounds(20, 340, 280, 20);
        txFlow = new JTextField("");
        txFlow.setBounds(280, 340, 50, 20);
        lbWaterPressure = new JLabel("Presión de agua en la diac (Tensión principal mayor x1)");
        lbWaterPressure. setBounds(20, 360, 340, 20);
        txWaterPressure = new JTextField();
        txWaterPressure.setBounds(350, 360, 50, 20);
        lbG_Conditions = new JLabel("Condiciones generales");
        lbG_Conditions.setBounds(20, 380   , 160, 20);
        cbG_Conditions = new JComboBox(new Object[] {"Completamente seco", "Húmendo", "Mojado", 
        "Goteo", "Flujo"});
        cbG_Conditions.setBounds(170 ,380, 150  , 20);
        
        //Finaliza componentes de A
        
        
        //Inicia Componentes de B
         lbB_Classification  =new JLabel("B. Ajuste la orientación de las discontinuidades");
        lbB_Classification.setBounds(20, 420, 550, 30);
        lbB_Classification.setForeground(Color.BLACK);
        lbB_Classification.setFont(new Font("mi font", Font.BOLD, 18));
        //los jCombobox con mattriz
        lbTitleB = new JLabel("Orientación de rumbo y  buzamiento");
        lbTitleB.setBounds(20, 460, 250, 20);
        cbRow =new JComboBox(new Object[]{"Túneles y Minas","Cimentaciones","Taludes" });
        cbRow.setBounds(240, 460, 150, 20);
        cbColum = new JComboBox(new Object[]{"Muy Favorable", "Favorable","Regular ","Desfavorable","Muy desfavorable"});
        cbColum.setBounds(410, 460, 150, 20);
        
        //Inicia Componentes de C
        lbC_Classification = new JLabel("C. Tipos de macizos rocosos determinados a partir de la valuación total");
        lbC_Classification.setBounds(20, 500, 680, 30);
        lbC_Classification.setForeground(Color.BLACK);
        lbC_Classification.setFont(new Font("mi font", Font.BOLD, 18));
        
        lbTitleC = new JLabel("Puntaje");
        
        
    }

    private void addComponents() {
        
        scroll.setViewportView(mypanel);
        
        //Añade  Componenentes de  A
        mypanel.add(lbA_Classification);
        mypanel.add(lbTitleA);
        mypanel.add(rbSpotCharge);
        mypanel.add(txSpotCharge);
        mypanel.add(rblCompression);
        mypanel.add(txCompression);
        mypanel.add(lbRQD);
        mypanel.add(txRDQ);
        mypanel.add(btnRQD);
        mypanel.add(lbDiscontinuity);
        mypanel.add(txDiscontinuity);
        mypanel.add(lbContinuity);
        mypanel.add(rbS_Rough);
        mypanel.add(rbL_Rough);
        mypanel.add(rbL_RoughSeparation);
        mypanel.add(rbSurface_Polished);
        mypanel.add(rbFilling);
        mypanel.add(lbGroundWater);
        mypanel.add(lbFlow);
        mypanel.add(txFlow);
        mypanel.add(lbWaterPressure);
        mypanel.add(txWaterPressure);
        mypanel.add(lbG_Conditions);
        mypanel.add(cbG_Conditions);
        
        //Añade componentes de B
        mypanel.add(lbB_Classification);
        mypanel.add(lbTitleB);
        mypanel.add(cbRow);
        mypanel.add(cbColum);
        
        //Añade componentes de C
        mypanel.add(lbC_Classification);
        
        
        
        add(scroll);

        
     
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
        if(e.getSource() == btnRQD){
            mainWindow.goClDeere();
            txRDQ.setText(mainWindow.getClDeere().getLbResult().getText().substring(5));
        }

    }

}
