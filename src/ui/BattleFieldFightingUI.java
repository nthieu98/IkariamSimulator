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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import model.BattleFieldFighting;

/**
 *
 * @author GBlue
 */
public class BattleFieldFightingUI extends JDialog{
    
    public static JTabbedPane pnTab;
    
    JPanel pnMain, pnTitle, pnButton, pnContent;
    JLabel lblImg, lblTitle, lblImgTitle;
    JButton btnDispose;
    PnBattleFieldFighting pnAttack, pnDefence;
    BattleFieldFighting battleFieldFighting; 
    
    public BattleFieldFightingUI(BattleFieldFighting battleFieldFighting) {
        this.battleFieldFighting = battleFieldFighting;
        addControls();
        addEvents();
    }
    
    public void addControls() {
        Container con = getContentPane();
        con.setLayout(null);
        
        lblImgTitle = new JLabel();
        lblImgTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblHouTitle.png")));
        lblImgTitle.setBounds(210, 0, 60, 60);
        con.add(lblImgTitle);
        
        pnTitle = new JPanel(null);
        con.add(pnTitle);
        pnTitle.setBounds(0, 30, 980, 20);
        pnTitle.setBackground(new Color(215, 172, 116));
        
        lblTitle = new JLabel("Battle Field");
        lblTitle.setBounds(420, 0, 125, 15);
        pnTitle.add(lblTitle);
        btnDispose = new JButton(new ImageIcon(getClass().getResource("/Image/xButton.PNG")));
        btnDispose.setBounds(960, 0, 20, 20);
        pnTitle.add(btnDispose);
        
        pnMain = new JPanel();
        pnMain.setLayout(null);
        pnMain.setBounds(0, 50, 980, 480);
        pnMain.setBackground(new Color(253, 247, 221));
        con.add(pnMain);
        
        pnAttack = new PnBattleFieldFighting(battleFieldFighting.getAttackBattleField());
        pnDefence = new PnBattleFieldFighting(battleFieldFighting.getDefenceBattleField());
        pnAttack.setBounds(10, 50, 946, 179);
        pnDefence.setBounds(10, 235, 946, 179);
        pnAttack.addToReserves();
        pnDefence.addToReserves();
        pnMain.add(pnAttack);
        pnMain.add(pnDefence);
        
        //    lblImageField.setIcon(new javax.swing.ImageIcon(getClass().getResource(battleField.getImage())));
    }
    
    public void addEvents() {

//         for(Army.Unit unit: Army.Unit.values()){
       
        
        btnDispose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
     
    }
    public void showWindow() {
        setSize(980, 530);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setModal(true);
        setVisible(true);
    }

    public BattleFieldFighting getBattleFieldFighting() {
        return battleFieldFighting;
    }

    public void setBattleFieldFighting(BattleFieldFighting battleFieldFighting) {
        this.battleFieldFighting = battleFieldFighting;
    }
    
    public void resetBattleFieldFightingUI(BattleFieldFighting battleFieldFighting){
        pnMain.removeAll();
       this.battleFieldFighting = battleFieldFighting;
       pnAttack = new PnBattleFieldFighting(battleFieldFighting.getAttackBattleField());
       pnDefence = new PnBattleFieldFighting(battleFieldFighting.getDefenceBattleField());
        pnAttack.setBounds(10, 50, 946, 179);
        pnDefence.setBounds(10, 235, 946, 179);
      pnAttack.addToReserves();
        pnDefence.addToReserves();
        pnMain.add(pnAttack);
        pnMain.add(pnDefence);
        pnMain.updateUI();
    }
    
}
     

//
//      private void addToReserves() {
//        reservePanel.removeAll();
//        int i = 0;
//        PnSlotReserve[] pnslotReserve = new PnSlotReserve[12];
//        for (Army.Unit unit : Army.Unit.values()) {
//            
//            pnslotReserve[unit.ordinal()] = new PnSlotReserve(battleField, unit);
//            if(pnslotReserve[unit.ordinal()].battleField.reserve.getUnit(unit).size() == 0) continue;
//            pnslotReserve[unit.ordinal()].setBounds(52 * i, 10, 50, 45);
//            reservePanel.add(pnslotReserve[unit.ordinal()]);
//            pnslotReserve[unit.ordinal()].updates();
//            i++;
//        }
//
//    }
    //Show the HouseInfoUI dialog
    

