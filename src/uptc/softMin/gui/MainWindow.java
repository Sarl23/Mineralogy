/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uptc.softMin.gui;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {


    private PanelMainwindow pnlMainwindow;
    private HandlingEvents handlingEvents;


    public MainWindow() {
        setTitle("MINING TOOLS y  CLASIFICACIONES GEOMECANICAS");
        setSize(700, 450);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon ImageIcon = new ImageIcon("resours/images/icMineria.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);

    }


    public void begin() {
        beginComponents();
        addComponents();
        addWindowListener(handlingEvents);


    }

    public void beginComponents() {
        handlingEvents = new HandlingEvents(this);
        pnlMainwindow = new PanelMainwindow(this);

    }

    public void addComponents() {

        add(pnlMainwindow, BorderLayout.CENTER);


    }


    public static void main(String[] args) {
        MainWindow mywWindow = new MainWindow();
        mywWindow.begin();
        mywWindow.setVisible(true);

    }

    public PanelMainwindow getPnlMainwindow() {
        return pnlMainwindow;
    }

    public HandlingEvents getHandlingEvents() {
        return handlingEvents;
    }



    public void goModern() {
        new WindowCLMODERN(this).setVisible(true);
    }

    public void goOLD() {
        new WindowCLOLD(this).setVisible(true);
    }


    public void goScalab() {
        new WindowSCALAB(this).setVisible(true);
    }

    public void goCLTerzaghi() {new CLOld_Terzaghi(this).setVisible(true);
    }
}
