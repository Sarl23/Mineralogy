/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uptc.softMin.gui;


import javax.swing.*;
import java.awt.*;


public class PanelMainwindow extends JPanel {

    private MainWindow mainWindow;
    private JLabel titleSoft;
    private JButton clOld;
    private JButton clModern;
    private JButton clScala;
    private JButton grouppage;
    private JButton exit;


    public PanelMainwindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setLayout(null);
        beginComponents();
        addComponents();

    }

    @Override
    public void paintComponent(Graphics g){
        Dimension dimension= getSize();
        ImageIcon ImageIcon = new ImageIcon("resours/images/mainWind.png");
        Image image = ImageIcon.getImage();
        g.drawImage(image, 0,0,dimension.width,dimension.height,null);
    }
    
    private void beginComponents() {

        titleSoft = new JLabel("MINING TOOLS Y CLASIFICACIONES GEOMECANICAS");
        titleSoft.setBounds(20, 35, 690, 30);
        titleSoft.setForeground(Color.GREEN);
        titleSoft.setFont(new Font("mi font", Font.BOLD, 25));

        clOld = new JButton("Clasificaciones Antiguas");
        clOld.setBounds(40, 330, 185, 30);
        clOld.setActionCommand(HandlingEvents.clOLD);
        clOld.addActionListener(mainWindow.getHandlingEvents());
        clOld.setForeground(Color.BLACK);
        clOld.setFont(new Font("mi font", Font.BOLD, 12));

        clModern = new JButton("Clasificaciones Modernas");
        clModern.setBounds(252, 330, 185, 30);
        clModern.setActionCommand(HandlingEvents.clMODERN);
        clModern.addActionListener(mainWindow.getHandlingEvents());
        clModern.setForeground(Color.BLACK);
        clModern.setFont(new Font("mi font", Font.BOLD, 12));

        clScala = new JButton("Clasificaciones Escalonadas");
        clScala.setBounds(460, 330, 200, 30);
        clScala.setActionCommand(HandlingEvents.clSCALAB);
        clScala.addActionListener(mainWindow.getHandlingEvents());
        clScala.setForeground(Color.BLACK);
        clScala.setFont(new Font("mi font", Font.BOLD, 12));

        grouppage = new JButton("Pagina del grupo");
        grouppage.setBounds(340, 370, 180, 30);
        grouppage.setActionCommand(HandlingEvents.gpPAGE);
        grouppage.addActionListener(mainWindow.getHandlingEvents());
        grouppage.setIcon(new ImageIcon("resours/inter.png"));
        grouppage.setForeground(Color.BLACK);
        grouppage.setFont(new Font("mi font", Font.BOLD, 12));

        exit = new JButton("SALIR");
        exit.setBounds(210, 370, 100, 30);
        exit.setActionCommand(HandlingEvents.EXIT);
        exit.addActionListener(mainWindow.getHandlingEvents());
        exit.setIcon(new ImageIcon("resours/images/icExit.png"));
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("mi font", Font.BOLD, 12));

    }

    private void addComponents() {
        add(titleSoft);
        add(clOld);
        add(clModern);
        add(clScala);
        add(grouppage);
        add(exit);
    }


}

