/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import model.Army;
import model.BattleField;
import model.Slot;

/**
 *
 * @author admin
 */
public class PanelBattlefield extends JPanel{
    public PnSlot[] pnArtillery, pnLongRangeFighter, pnFront, pnFlank, pnAirDefence, pnBomber;
    JLabel lblImageField;
    BattleField battleField;
    int x = 56; //Khoảng cách giữa hai pnSlot

    public PanelBattlefield(BattleField battleField) {
        this.setVisible(true);
        this.battleField = battleField;
        this.setLayout(null);
        
        pnArtillery = new PnSlot[battleField.getNumberOfSlotForAr()];
        pnLongRangeFighter= new PnSlot[battleField.getNumberOfSlotForLRF()];
        pnFront= new PnSlot[battleField.getNumberOfSlotForHI()];
        pnFlank = new PnSlot[battleField.getNumberOfSlotForLI()];
        pnAirDefence = new PnSlot[battleField.getNumberOfSlotForGy()];
        pnBomber = new PnSlot[battleField.getNumberOfSlotForBB()];
 
        lblImageField = new JLabel();
        
        if (battleField.getTypeOfBattleField().ordinal() == BattleField.TypeOfBattleField.ATTACK.ordinal()){
            addPanelIntoAirDefenceRow(pnAirDefence, 706, 17, Army.ClassUnit.Airdefence);
            addPanelIntoMidleRow(pnArtillery, 349, 22,  Army.ClassUnit.Artillery);
            addPanelIntoMidleRow(pnFront, 349, 130,  Army.ClassUnit.Front);
            addPanelIntoBomberRow(pnBomber, 12, 17,  Army.ClassUnit.Bomber);
            addPanelIntoMidleRow(pnLongRangeFighter, 349, 77,  Army.ClassUnit.LRF);
            addPanelIntoFlankRow(pnFlank, 618, 130, Army.ClassUnit.Flank);
            lblImageField.setIcon(new javax.swing.ImageIcon(getClass().getResource(battleField.getAttackFieldImg())));
        
        }
        else {
            addPanelIntoAirDefenceRow(pnAirDefence, 706, 129, Army.ClassUnit.Airdefence);
            addPanelIntoMidleRow(pnArtillery, 349, 132,  Army.ClassUnit.Artillery);
            addPanelIntoMidleRow(pnFront, 349, 21,  Army.ClassUnit.Front);
            addPanelIntoBomberRow(pnBomber, 12, 129,  Army.ClassUnit.Bomber);
            addPanelIntoMidleRow(pnLongRangeFighter, 349, 76,  Army.ClassUnit.LRF);
            addPanelIntoFlankRow(pnFlank, 618, 21, Army.ClassUnit.Flank);
            lblImageField.setIcon(new javax.swing.ImageIcon(getClass().getResource(battleField.getDefenceFieldImg())));
        
        }
        lblImageField.setBounds(0, 0, 763, 192);
        this.add(lblImageField);
//        addControls();
        addEvents();
    }
    
    public void addControls() {
        this.setLayout(null);   
    }
    public void addEvents() {
        updates(pnLongRangeFighter, 1);
        updates(pnAirDefence, 1);
        updates(pnArtillery, 1);
        updates(pnFront, 1);
        updates(pnBomber, 1);
        updates(pnFlank, 1);
        
    }
//     chan: 6,4,2,0,1,3,5,7.   8;
    private void addPanelIntoMidleRow(PnSlot[] pn,int firstX, int firstY, Army.ClassUnit classUnit) {
      
        int length = pn.length;
        int d = 0; //Khoảng cách từ pn[0] đến pn[i]
        if (length % 2 == 0) {
            for (int i = 0; i <= length -2; i += 2) {
                
                pn[i] = new PnSlot(battleField, classUnit, i);
                pn[i].setBounds(firstX - d, firstY, 50, 45);
                d += x;
                this.add(pn[i]);
            }
            d = x;
            for (int i = 1; i <= length - 1; i += 2) {
                pn[i] = new PnSlot(battleField, classUnit, i);
                pn[i].setBounds(firstX + d, firstY, 50, 45);
                d += x;
                this.add(pn[i]);
            }
        }
        else {
//                    le: 3,1,0,2,4;       5;
            d = x;
            for (int i = 1; i <= length - 2; i += 2) {
                pn[i] = new PnSlot(battleField, classUnit, i);
                pn[i].setBounds(firstX - d , firstY, 50, 45);
                d += x;
                this.add(pn[i]);
            }
            d = 0;
            for (int i = 0; i <= length - 1; i += 2) {
                pn[i] = new PnSlot(battleField, classUnit, i);
                pn[i].setBounds(firstX + d, firstY, 50, 45);
                d += x;
                this.add(pn[i]);
            }
        }
    }
    private void addPanelIntoBomberRow(PnSlot[] pn,int firstX, int firstY, Army.ClassUnit classUnit) {
        int length = pn.length;
        int d = 0; //Khoảng cách giữa 2 PanelBattlefield
         for (int i = 0; i < length; i ++) {
                pn[i] = new PnSlot(battleField, classUnit, i);
                pn[i].setBounds(firstX + d, firstY, 50, 45);
                d += x;
                this.add(pn[i]);
        }
    }
    private void addPanelIntoAirDefenceRow(PnSlot[] pn,int firstX, int firstY, Army.ClassUnit classUnit) {
        int length = pn.length;
        int d = 0; //Khoảng cách giữa 2 PanelBattlefield
         for (int i = 0; i < length; i ++) {
                pn[i] = new PnSlot(battleField, classUnit, i);
                pn[i].setBounds(firstX - d, firstY, 50, 45);
                d += x;
                this.add(pn[i]);
        }
    }
    private void addPanelIntoFlankRow(PnSlot[] pn,int firstX, int firstY, Army.ClassUnit classUnit) {
        int length = pn.length;
        int d = 0; //Khoảng cách giữa 2 PanelBattlefield
        x = 46;
        for (int i = 0; i <= length - 2; i += 2) {
                pn[i] = new PnSlot(battleField, classUnit, i);
                pn[i].setBounds(firstX + d, firstY, 50, 45);
                d += x;
                this.add(pn[i]);
        }
        d = 0;
        for (int i = 1; i < length; i += 2) {
                pn[i] = new PnSlot(battleField, classUnit, i);
                pn[i].setBounds(108 - d, firstY, 50, 45);
                d += x;
                this.add(pn[i]);
        }
    }
    public void updates(PnSlot[] pn, int previewOrReal) {
        for (PnSlot pn1 : pn) {
            pn1.updates(previewOrReal);
        }
        
    }
    public void resetAll() {
        for (PnSlot pnAirDefence1 : pnAirDefence) {
            pnAirDefence1.updates(0);
        }
        for (PnSlot pnArtillery1 : pnArtillery) {
            pnArtillery1.updates(0);
        }
        for (PnSlot pnBomber1 : pnBomber) {
            pnBomber1.updates(0);
        }
        for (PnSlot pnFlank1 : pnFlank) {
            pnFlank1.updates(0);
        }
        for (PnSlot pnFront1 : pnFront) {
            pnFront1.updates(0);
        }
        for (PnSlot pnLongRangeFighter1 : pnLongRangeFighter) {
            pnLongRangeFighter1.updates(0);
        }
    }
  
}