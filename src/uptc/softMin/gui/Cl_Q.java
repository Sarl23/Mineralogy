/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uptc.softMin.gui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

/**
 *
 * @author Alejandro
 */
public class Cl_Q extends JDialog{
    
    private MainWindow mainWin;
    
    
    public Cl_Q(MainWindow mainWin){
        this.mainWin = mainWin;
        setTitle("Clasificacion Q");
	setResizable(false);
	setModal(true);
        setResizable(false);
        setLayout(null);
        setSize(600, 550);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("resours/icMineria.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
        beginComponents();
        addComponents();
    }
    
    public void beginComponents(){
        
    }
    
    public void addComponents(){
        
    }
    
}
