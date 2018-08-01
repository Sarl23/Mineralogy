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
import java.net.URL;

public class WindowCLMODERN extends JDialog implements ActionListener {

    private MainWindow mainWindow;
    private JLabel titleModern;
    private JLabel labimgModern;
    private JButton Bieniawski;
    private JButton Barton;
    private JButton backMO;
    private ImageIcon icon;


    public WindowCLMODERN(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setTitle("Clasificaciones Modernas");
	setModal(true);
        setLayout(null);
        setLayout(null);
        setResizable(false);
        setSize(700, 450);
        setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon("resours/images/icMineria.png");
        Image image = imageIcon.getImage();
        this.setIconImage(image);
        beginComponents();
        addComponents();


    }

    private void beginComponents() {
        titleModern = new JLabel("CLASIFICACIONES MODERNAS.");
        titleModern.setBounds(40, 60, 500, 30);
        titleModern.setForeground(Color.WHITE);
        titleModern.setFont(new Font("mi font", Font.BOLD, 30));

        labimgModern = new JLabel("");
        ImageIcon imgOLD = new ImageIcon(getClass().getResource("/uptc/softMin/imagen/mineModern.jpg"));
        Icon img = new ImageIcon(imgOLD.getImage().getScaledInstance(700, 450, Image.SCALE_DEFAULT));
        labimgModern.setIcon(img);
        labimgModern.setBounds(0, 0, 700, 450);

        Bieniawski = new JButton("Clasificación de Bieniawski.(RMR)");
        Bieniawski.setBounds(20, 310, 250, 30);
        Bieniawski.setActionCommand(HandlingEvents.BIENIAW);
        Bieniawski.addActionListener(mainWindow.getHandlingEvents());
        Bieniawski.setForeground(Color.BLACK);
        Bieniawski.setFont(new Font("mi font", Font.BOLD, 12));

        Barton = new JButton("Clasificación de Barton et al.(Q)");
        Barton.setBounds(280, 310, 220, 30);
        Barton.setForeground(Color.BLACK);
        Barton.setFont(new Font("mi font", Font.BOLD, 12));
        //Barton.setActionListener(HandlingEvents.BARTON);
        Barton.addActionListener(mainWindow.getHandlingEvents());

        backMO = new JButton("Volver");
        backMO.setBounds(20, 360, 90, 30);
        backMO.addActionListener(this);
        backMO.setIcon(new ImageIcon("resours/images/retour.gif"));
        backMO.setForeground(Color.BLACK);
        backMO.setFont(new Font("mi font", Font.BOLD, 12));

    }

    private void addComponents() {
        add(titleModern);
        add(Bieniawski);
        add(Barton);
        add(backMO);
        add(labimgModern);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backMO) {
            this.dispose();
        }
    }
}
