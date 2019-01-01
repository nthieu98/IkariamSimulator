/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
public class PnSetUnit extends JPanel{
    JButton btnSetMax;
    JLabel lblName, lblIcon;
    protected JSlider sld;
    protected JTextField txt;
    String urlImg; //name is the unit's name, urlImg is the image'name of the unit
    Army.Unit nameUnit;

    public PnSetUnit(Army.Unit nameUnit) {
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
        lblName = new JLabel(nameUnit + "");
        lblName.setBounds(70, 15, 100, 20);
        this.add(lblName);
        sld = new JSlider(0, 2000);
        sld.setBounds(200, 15, 250, 20);
        sld.setBackground(new Color(251,232,193));
        this.add(sld);
        txt = new JTextField(3);
        txt.setBounds(470, 15, 35, 20);
        this.add(txt);
        btnSetMax = new JButton("Max");
        btnSetMax.setBounds(505, 15, 60, 20);
        this.add(btnSetMax);
    }
    public void addEvents() {        
        sld.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                txt.setText(String.valueOf(sld.getValue()));
            }
        });
        txt.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){
                Integer intValue = 0;
                try{
                    intValue = Integer.valueOf(txt.getText());
                }catch(Exception ex){
                    txt.setText("0");
                }
                if(intValue < 0)
                    txt.setText("0");
                else if(intValue >= 1000)
                    txt.setText("999");
                
                sld.setValue(Integer.valueOf(txt.getText()));
            }
        });
        btnSetMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sld.setValue(sld.getMaximum());
            }
        });
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
               setBackground(new Color(239, 212, 169));
               sld.setBackground(new Color(239, 212, 169));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(251,232,193));
                sld.setBackground(new Color(251,232,193));

            }
        });
    }

    public JSlider getSld() {
        return sld;
    }

    public void setSld(JSlider sld) {
        this.sld = sld;
    }
    
}
