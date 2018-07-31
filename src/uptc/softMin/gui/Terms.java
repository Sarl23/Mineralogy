/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uptc.softMin.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Alejandro
 */
public class Terms extends JDialog implements ActionListener{

    private MainWindow mainWin;
    private JLabel lbTitle;
    private JTextArea txTerms;
    private JScrollPane scTerms;    
    private JCheckBox chbAcept;
    private JButton btnContinue;
    private JButton btnBack;
    
    public Terms(MainWindow mainWin){
        this.mainWin = mainWin;
        setTitle("Términos y condiciones");
	setResizable(false);
	setModal(true);
        setResizable(false);
        setLayout(null);
        setSize(500, 450);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("resours/icMineria.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
        beginComponents();
        addComponents();
    }
    
    public void beginComponents(){
        lbTitle = new JLabel("TÉRMINOS Y CONDICIONES");
        lbTitle.setBounds(150, 20, 200, 30);
        lbTitle.setFont(new Font("Andale Mono",  1, 14));
        lbTitle.setForeground(new Color(0, 0, 0));
        
        txTerms = new JTextArea("\n\n           TÉRMINOS Y CONDICIONES"
                + "\n\n           Copyright © 2018 Sergio Andres Rojas León y "
                + "Jimmy Alejandro Plazas López"
                + "\n\n           Software desarrollado por Sergio Andres Rojas León y "
                + "Jmmy Alejandro Plazas López."
                + "\n\n           Condiciones de Uso: Lea detenidamente estas condiciones de uso:"
                + "\n\n           1. Este software es de libre distribución, así que el usuario"
                + "se compromete a "
                + "\n           no utilizar este "
                + "\n           software para fines de lucro propio o de terceros."
                + "\n           2. Este software ha sido creado bajo información recopilada"
                + "\n           en la Universidad "
                + "\n           Pedagógica y Tecnológica de Colombia."
                + "\n           3. El código fuente del software permanecerá en poder de los"
                + "desarrolladores."
                + "\n           4. Estamos  dispuestos a escuchar cualquier sugerencia para la"
                + "mejora del software "
                + "\n           o posibles ERRORES que este puede haber presentado,"
                + "pero sin responsabilizarse "
                + "\n           absolutamente en nada."
        );
        txTerms.setFont(new Font("Andale Mono", 0, 10));
        txTerms.setEditable(false);
        scTerms = new JScrollPane(txTerms);
        scTerms.setBounds(30, 55, 440, 300);
        
        chbAcept = new JCheckBox("Acepto");
        chbAcept.setBounds(30, 360, 100, 25);
        chbAcept.addActionListener(this);
        
        btnContinue = new JButton("Continuar");
        btnContinue.setBounds(30, 390, 100, 25);
        btnContinue.setEnabled(false);
        btnContinue.addActionListener(this);
        
        btnBack = new JButton("No acepto");
        btnBack.setBounds(140, 390, 100, 25);
        btnBack.addActionListener(this);
    }
    
    public void addComponents(){
        add(lbTitle);
        add(scTerms);
        add(chbAcept);
        add(btnContinue);
        add(btnBack);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == chbAcept){
            if(chbAcept.isSelected()){
                btnContinue.setEnabled(true);
                btnBack.setEnabled(false);
            } else {
                btnContinue.setEnabled(false);
                btnBack.setEnabled(true);
            }
        }
        if(e.getSource() == btnContinue){
            mainWin.setAgree(true);
            this.dispose();
        }
        if(e.getSource() == btnBack){
            mainWin.setAgree(false);
            this.dispose();
        }
    }
}
