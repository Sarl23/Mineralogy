/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uptc.softMin.gui;
import javax.swing.*;
import java.awt.*;
import uptc.softMin.logic.ManagementOld;

public class MainWindow extends JFrame {


    private PanelMainwindow pnlMainwindow;
    private ManagementOld mgOld;
    private WindowCLOLD winOld;
    private HandlingEvents handlingEvents;
    private CLOld_Terzaghi clOldTerzaghi;
    private ClDeere clDeere;
    private Cl_RSR clRSR;


    public MainWindow() {
        setTitle("MINING TOOLS y  CLASIFICACIONES GEOMECANICAS");
        setSize(700, 450);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
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
        winOld = new WindowCLOLD(this);
        mgOld = new ManagementOld();
        clOldTerzaghi = new CLOld_Terzaghi(this);
        clDeere = new ClDeere(this);
        clRSR = new Cl_RSR(this);
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
    
    public ManagementOld getManagementOld() {
        return mgOld;
    }

    public void goModern() {
        new WindowCLMODERN(this).setVisible(true);
    }

    public void goOLD() {
        winOld.setVisible(true);
    }

    public void goScalab() {
        new WindowSCALAB(this).setVisible(true);
    }

    public void goCLTerzaghi() {
        clOldTerzaghi.cleanFields();
        clOldTerzaghi.setVisible(true);
    }
    
    public void goClDeere() {
        clDeere.cleanFields();
        clDeere.setVisible(true);
    }
    
    public void goClRSR() {
        clRSR.setVisible(true);
    }
}
