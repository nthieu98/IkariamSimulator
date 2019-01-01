/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import model.Army;

/**
 *
 * @author admin
 */
public class PnSetUnitBattle extends PnSetUnit {
    
    JTextField txtMax;
    Army.Unit unit;
    
    public PnSetUnitBattle(Army.Unit unit) {
        super(unit);
        this.unit = unit;
        
        lblIcon.setBounds(150, 5, 50, 45);
        lblName.setBounds(210, 15, 100, 20);
        sld.setBounds(360, 15, 350, 20);
        txt.setBounds(750, 15, 35, 20);
        btnSetMax.setBounds(790, 15, 60, 20);
        
        txtMax = new JTextField(3);
        txtMax.setBounds(300, 15, 35, 15);
        this.add(txtMax);
        
    }

    public JSlider getSlider() {
        return sld;
    }
    public JTextField getJTextField() {
        return txt;
    }
    public JTextField getJTextFieldMax() {
        return txtMax;
    }
    
    public int getValueOfSlider() {
        return this.sld.getValue();
    }
}
