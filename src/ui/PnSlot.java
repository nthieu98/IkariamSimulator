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
import model.Slot;
import model.BattleField;

/**
 *
 * @author admin
 */
public class PnSlot extends JPanel {
    Army.ClassUnit classUnit;
    BattleField battleField;
    int index;
    
    Slot slot;
    public JLabel lblUnit;
    JProgressBar prgHitPoint, prgMunition;
    JTextField txtNumberOfUnit;

    public PnSlot(BattleField battleField, Army.ClassUnit classUnit, int index) {
        this.battleField = battleField;
        this.classUnit = classUnit;
        this.index = index;
        this.slot = battleField.getMyClassUnit(classUnit)[index];
        addControls();
        addEvents();
    }
    public void addControls() {
        this.setVisible(false);
        this.setLayout(null);
        this.setOpaque(false);
        lblUnit = new JLabel();
        lblUnit.setBounds(0, 0, 33, 33);
        if(slot.getImageUrl() != ""){
            lblUnit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ArcherBB.png")));
        }
        this.add(lblUnit);
        
        prgHitPoint = new JProgressBar(1,0, 100);
        prgHitPoint.setBounds(35, 0, 8, 33);
        prgHitPoint.setForeground(new Color(72, 215, 76));
        prgHitPoint.setBackground(new Color(164, 28, 19));
        this.add(prgHitPoint);
        
        prgMunition = new JProgressBar(1, 0, 100);
        prgMunition.setBounds(44, 0, 8, 33);
        prgMunition.setForeground(new Color(78, 173, 235));
        prgMunition.setBackground(new Color(53, 24, 2));
        this.add(prgMunition);
        
        txtNumberOfUnit = new JTextField(3);
        txtNumberOfUnit.setBounds(0, 35, 33, 10);
        txtNumberOfUnit.setFont(new Font("Arial", Font.BOLD, 10));
        txtNumberOfUnit.setBorder(null);
        txtNumberOfUnit.setEditable(false);
        this.add(txtNumberOfUnit);

    }
    public void addEvents() {

    }
    
    //preveiwOrReal = 0,1: 0--> battlePreview, 1--> realBattle
    public void updates(int previewOrReal) {
        if(!"".equals(slot.getImageUrl())){
            this.setVisible(true);
            this.updateUI();
            lblUnit.setIcon(new javax.swing.ImageIcon(getClass().getResource(slot.getImageUrl())));
            txtNumberOfUnit.setText(slot.getUnitAlive() + "/" + slot.getInitNumUnit());
            if (previewOrReal == 1) {
                prgHitPoint.setValue(slot.getTotalHitpoint());
                prgMunition.setValue(slot.getTotalMunition());
            }
            else {
                 prgHitPoint.setVisible(false);
                 prgMunition.setVisible(false);
            }
            if (slot.getUnitType().ordinal() == Army.Unit.Hoplite.ordinal()
                || slot.getUnitType().ordinal() ==  Army.Unit.Swordsman.ordinal()
                || slot.getUnitType().ordinal() == Army.Unit.Spearman.ordinal()
                || slot.getUnitType().ordinal() == Army.Unit.SteamGiant.ordinal()
                || slot.getUnitType().ordinal() == Army.Unit.Wall.ordinal())
            prgMunition.setVisible(false);
        }
        else {
            this.setVisible(false);
//            lblUnit.setIcon(new ImageIcon());
//            txtNumberOfUnit.setText("");
        }
//        if (previewOrReal == 0) {
//            prgHitPoint.setVisible(false);
//            prgMunition.setVisible(false);
//        }  
//        if (slot.getUnitType() == null) return;
        
              
    }
    
}
