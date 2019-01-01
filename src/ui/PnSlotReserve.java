/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import model.Army;
import model.BattleField;
import model.Slot;

/**
 *
 * @author GBlue
 */
public class PnSlotReserve extends JPanel{
    Army.Unit unit;
    BattleField battleField;
    
    public JLabel lblUnit;
    JTextField txtNumberOfUnit;

    public PnSlotReserve(BattleField battleField, Army.Unit unit) {
        this.battleField = battleField;
        this.unit = unit;
        addControls();
        addEvents();
    }
    public void addControls() {
        this.setVisible(false);
        this.setLayout(null);
        this.setOpaque(false);
        lblUnit = new JLabel();
        lblUnit.setBounds(0, 0, 33, 33);
        this.add(lblUnit);
        
        txtNumberOfUnit = new JTextField(3);
        txtNumberOfUnit.setBounds(0, 35, 33, 10);
        txtNumberOfUnit.setFont(new Font("Arial", Font.BOLD, 10));
        txtNumberOfUnit.setBorder(null);
        txtNumberOfUnit.setEditable(false);
        this.add(txtNumberOfUnit);

    }
    public void addEvents() {

    }
    public void updates() {
        if(battleField.reserve.getUnit(unit).size() > 0){
            this.setVisible(true);
            lblUnit.setIcon(new javax.swing.ImageIcon(getClass().getResource(new Army().getImageOf(unit))));
            txtNumberOfUnit.setText(battleField.reserve.getUnit(unit).size() + "");
        }
        else {
            this.setVisible(false);
            
        }
    }
    
}
