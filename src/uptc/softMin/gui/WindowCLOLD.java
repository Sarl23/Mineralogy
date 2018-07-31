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

public class WindowCLOLD extends JDialog implements ActionListener {

    private MainWindow mainWindow;
    private JLabel labimgOld;
    private JLabel titleOLD;
    private JButton terzaghi;
    private JButton deere;
    private JButton wickham;
    private JButton back;


    public WindowCLOLD(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setTitle("Clasificaciones Antiguas");
        setLayout(null);
        setSize(700, 450);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("resours/images/icMineria.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
        beginComponents();
        addComponents();


    }


    private void beginComponents() {
        titleOLD = new JLabel("CLASIFICACIONES ANTIGUAS.");
        titleOLD.setBounds(40, 60, 500, 30);
        titleOLD.setForeground(Color.WHITE);
        titleOLD.setFont(new Font("mi font", Font.BOLD, 30));


        labimgOld = new JLabel("");
        ImageIcon imgOLD = new ImageIcon(getClass().getResource("/uptc/softMin/imagen/mineOLD.jpg"));
        Icon img = new ImageIcon(imgOLD.getImage().getScaledInstance(700, 450, Image.SCALE_DEFAULT));
        labimgOld.setIcon(img);
        labimgOld.setBounds(0, 0, 700, 450);


        terzaghi = new JButton("Clasificación de Terzaghi");
        terzaghi.setBounds(20, 310, 180, 30);
        terzaghi.setActionCommand(HandlingEvents.TERZAGHI);
        terzaghi.addActionListener(mainWindow.getHandlingEvents());
        terzaghi.setForeground(Color.BLACK);
        terzaghi.setFont(new Font("mi font", Font.BOLD, 12));

        deere = new JButton("Clasificación de Deere (RQD)");
        deere.setBounds(218, 310, 210, 30);
        deere.setActionCommand(HandlingEvents.DEERE);
        deere.addActionListener(mainWindow.getHandlingEvents());
        deere.setForeground(Color.BLACK);
        deere.setFont(new Font("mi font", Font.BOLD, 12));

        wickham = new JButton("Clasificación de Wickham (RSR)");
        wickham.setBounds(440, 310, 230, 30);
        wickham.setActionCommand(HandlingEvents.WICKHAM);
        wickham.addActionListener(mainWindow.getHandlingEvents());
        wickham.setForeground(Color.BLACK);
        wickham.setFont(new Font("mi font", Font.BOLD, 12));


        back = new JButton("Volver");
        back.setBounds(20, 360, 90, 30);
        back.addActionListener(this);
        back.setIcon(new ImageIcon("resours/images/retour.gif"));
        back.setForeground(Color.BLACK);
        back.setFont(new Font("mi font", Font.BOLD, 12));


    }

    private void addComponents() {
        add(titleOLD);
        add(terzaghi);
        add(deere);
        add(wickham);
        add(back);
        add(labimgOld);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.dispose();
        }
    }
}
