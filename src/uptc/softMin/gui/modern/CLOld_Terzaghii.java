/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uptc.softMin.gui.old;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import uptc.softMin.gui.MainWindow;

/**
 *
 * @author Sergio and Jimmy 
 * 
 */
public class CLOld_Terzaghii extends JDialog implements ActionListener, KeyListener  {
    MainWindow mainWindow;
    //Components
   private JComboBox cbRockCondition;
   private JLabel lbRockCondition;
   private JLabel lbFretaLevel;
   private JRadioButton rbyesFrestLevel;
   private JRadioButton rbnoFrestLevel;
   private JLabel lbB;
   private JTextField txfB;
   private JLabel lbH;
   private JTextField txfH;
   
   
   
   
    
    
    public CLOld_Terzaghii(MainWindow mainWindow){
        this.mainWindow= mainWindow;
        setTitle("Clasificacion Terzaghi");
        setResizable(false);
        setModal(true);
        setResizable(false);
        setLayout(null);
        setSize(550, 350);
        setLocationRelativeTo(null);
       ImageIcon ImageIcon = new ImageIcon("resours/images/icMineria.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
        beginComponents();
        addComponents();
        
    }

   
    
    
    private void beginComponents() {
        
        
        lbRockCondition= new JLabel("Condicion de la Roca");
        lbRockCondition.setBounds(20,10,500, 20);
        
        cbRockCondition = new JComboBox(new Object[]{"1. Dura e intacta","2. Dura pero estratificada o esquistosa",
        "3. Masiva ligeramente fracturada","4. Moderadamente fraturada en bloques abiertos","5. Muy blocosa fisurada y fracmentada","6. Completamente trozada",
        "7. Grava y arena  densa","7.1 Grava y arena ","8. Comprimida Profundidad  moderada ","9. Comprimida  gran profundidad ", "10. Expansiva " });
        cbRockCondition.setBounds(20, 30 , 400, 30);
        
        lbFretaLevel = new JLabel("Nivel Fretasico");
        lbFretaLevel.setBounds(20, 65, 100, 30);
        
        rbyesFrestLevel= new JRadioButton("Si");
        rbyesFrestLevel.setBounds(150, 65, 50, 30);
        rbnoFrestLevel= new JRadioButton("No");
        rbnoFrestLevel.setBounds(200, 65, 50, 30);
        
        lbB = new JLabel ("B: ");
        lbB.setBounds(20, 105, 50, 20);
        txfB = new JTextField();
        txfB.setBounds(40, 105, 70, 20);
        
        lbH = new JLabel ("Ht: ");
        lbH.setBounds(150, 105, 50, 20);
        txfH = new JTextField();
        txfH.setBounds(180, 105, 70, 20);
        
        
        
    }

    private void addComponents() {
        add(lbRockCondition);
        add(cbRockCondition);
        add(lbFretaLevel);
        add(rbyesFrestLevel);
        add(rbnoFrestLevel);
        add(lbB);
        add(txfB);
        add(lbH);
        add(txfH);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
