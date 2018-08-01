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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URI;
import javax.swing.JOptionPane;

public class HandlingEvents implements WindowListener, ActionListener {

    public MainWindow mainWindow;
    public WindowCLOLD windowCLOLD;
    public static final String clOLD = "Antiguas";
    public static final String clMODERN = "Modernas";
    public static final String clSCALAB = "Scalab";
    public static final String EXIT = "Salir";
    public static final String gpPAGE = "Pagina";

    public static final String TERZAGHI = "terzaghi";
    public static final String DEERE = "deere";
    public static final String WICKHAM = "wickham";

    public static final String BARTON = "barton";
    public static final String BIENIAW = "bieniaw";

    public HandlingEvents(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Antiguas":
                mainWindow.goOLD();
                break;
            case "Modernas":
                mainWindow.goModern();
                break;
            case "Scalab":
                mainWindow.goScalab();
                break;
            case "Salir":
                exit();
                break;
            case "Pagina":
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/Sarl23/Mineralogy/graphs/contributors"));
                } catch (Exception ex) {
                }
                System.out.println("madar a pagina del grupo");
                break;
            // Begin old actions
            case "terzaghi":
                mainWindow.goCLTerzaghi();
                break;
            case "deere":
                mainWindow.goClDeere();
                break;
            case "wickham":
                mainWindow.goClRSR();
                break;

            // Begin modern actions
            case "barton":
                mainWindow.goBarton();
                break;
            case "bieniaw":
                mainWindow.goBieniawski();
                break;
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        exit();

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public void exit() {

        int option = new JOptionPane().showConfirmDialog(null, "¿ Desea salir del aplicativo ?", "Exit", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }
}
