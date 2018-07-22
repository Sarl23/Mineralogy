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

public class WindowSCALAB extends JDialog implements ActionListener {
    private MainWindow mainWindow;
    private JLabel titleSCALAB;
    private JLabel labimgScalb;
    private JButton romana;
    private JButton atkinson;
    private JButton weaver;
    private JButton kirsten;
    private JButton singh;
    private JButton scoble;
    private JButton hadjigeorgiou;
    private JButton backSC;


    public WindowSCALAB(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setTitle("Clasificaciones según Excavabilidad");
        setLayout(null);
        setSize(700, 500);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("resours/images/icMineria.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
        beginComponents();
        addComponents();


    }


    private void beginComponents() {

        titleSCALAB = new JLabel("CLASIFICACIONES SEGÚN EXCAVABILIDAD");
        titleSCALAB.setBounds(10, 60, 700, 30);
        titleSCALAB.setForeground(Color.WHITE);
        titleSCALAB.setFont(new Font("mi font", Font.BOLD, 30));

        labimgScalb = new JLabel("");
        ImageIcon imgOLD = new ImageIcon(getClass().getResource("/uptc/softMin/imagen/mineSca.jpg"));
        Icon img = new ImageIcon(imgOLD.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT));
        labimgScalb.setIcon(img);
        labimgScalb.setBounds(0, 0, 700, 500);


        romana = new JButton("Clasificación de Romana");
        romana.setBounds(20, 280, 250, 30);
        romana.setForeground(Color.BLACK);
        romana.setFont(new Font("mi font", Font.BOLD, 12));

        atkinson = new JButton("Clasificación de Atkinson");
        atkinson.setBounds(20, 325, 250, 30);
        atkinson.setForeground(Color.BLACK);
        atkinson.setFont(new Font("mi font", Font.BOLD, 12));

        weaver = new JButton("Clasificación de Weaver");
        weaver.setBounds(20, 370, 250, 30);
        weaver.setForeground(Color.BLACK);
        weaver.setFont(new Font("mi font", Font.BOLD, 12));

        kirsten = new JButton("Clasificación de kirsten");
        kirsten.setBounds(310, 280, 300, 30);
        kirsten.setForeground(Color.BLACK);
        kirsten.setFont(new Font("mi font", Font.BOLD, 12));

        singh = new JButton("Clasificación de Singh");
        singh.setBounds(310, 325, 300, 30);
        singh.setForeground(Color.BLACK);
        singh.setFont(new Font("mi font", Font.BOLD, 12));

        scoble = new JButton("Clasificación de Scoble y Maftuoglu");
        scoble.setBounds(310, 370, 300, 30);
        scoble.setForeground(Color.BLACK);
        scoble.setFont(new Font("mi font", Font.BOLD, 12));

        hadjigeorgiou = new JButton("Clasificación de Hadjigeorgiou y Scoble");
        hadjigeorgiou.setBounds(310, 420, 300, 30);
        hadjigeorgiou.setForeground(Color.BLACK);
        hadjigeorgiou.setFont(new Font("mi font", Font.BOLD, 12));

        backSC = new JButton("Volver");
        backSC.setBounds(20, 420, 90, 30);
        backSC.addActionListener(this);
        backSC.setIcon(new ImageIcon("resours/images/retour.gif"));
        backSC.setForeground(Color.BLACK);
        backSC.setFont(new Font("mi font", Font.BOLD, 12));

    }

    private void addComponents() {
        add(titleSCALAB);
        add(romana);
        add(atkinson);
        add(weaver);
        add(kirsten);
        add(singh);
        add(scoble);
        add(hadjigeorgiou);
        add(backSC);
        add(labimgScalb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backSC) ;
        this.dispose();

    }
}
