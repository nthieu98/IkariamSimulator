/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.Army;

/**
 *
 * @author admin
 */
public class MyPanel extends JPanel{

    JLabel lblIcon,lblDamage, lblAmour;
    protected JTextField txtDamage, txtAmour;
    String urlImg; //name is the unit's name, urlImg is the image'name of the unit
    JButton btnImproveDamage, btnImproveAmour;
    Army.Unit nameUnit;
    protected int damage = 0;
    protected int amour = 0;
    
    public MyPanel(Army.Unit nameUnit) {
        this.nameUnit = nameUnit;
//        this.urlImg = urlImg;
        addControls();
        addEvents();                
    }

    public void addControls() {
        this.setLayout(null);
        this.setBackground(new Color(251,232,193));
        lblIcon = new JLabel(new ImageIcon(getClass().getResource("/image/" + nameUnit + ".png")));
        lblIcon.setBounds(10, 5, 50, 45);
        this.add(lblIcon);
        
        lblDamage = new JLabel("Damage +");
        lblDamage.setBounds(100, 15, 70, 20);
        this.add(lblDamage);
        
        txtDamage = new JTextField(3);
        txtDamage.setEditable(false);
        txtDamage.setBounds(180, 15, 30, 20);
        this.add(txtDamage);
        
        btnImproveDamage = new JButton();
        btnImproveDamage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Improve.png")));
        btnImproveDamage.setBounds(250, 15, 77, 24);
        this.add(btnImproveDamage);
        
        lblAmour = new JLabel("Amour +");
        lblAmour.setBounds(380, 15, 70, 20);
        this.add(lblAmour);
        
        txtAmour = new JTextField(3);
        txtAmour.setEditable(false);
        txtAmour.setBounds(460, 15, 30, 20);
        this.add(txtAmour);
        
        btnImproveAmour = new JButton();
        btnImproveAmour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Improve.png")));
        btnImproveAmour.setBounds(530, 15, 77, 24);
        this.add(btnImproveAmour);

    }
    
    public void addEvents(){
        btnImproveDamage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(damage < 3){
                    damage++;                                    
                }
                txtDamage.setText(String.valueOf(damage));
            }
        });
        
        btnImproveAmour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(amour < 3)
                    amour++;
                txtAmour.setText(String.valueOf(amour));
            }
        });
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAmour() {
        return amour;
    }

    public void setAmour(int amour) {
        this.amour = amour;
    }

    public JTextField getTxtDamage() {
        return txtDamage;
    }

    public JTextField getTxtAmour() {
        return txtAmour;
    }
}
