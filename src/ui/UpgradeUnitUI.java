/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.Army;

/**
 *
 * @author NgocAnh
 */
public class UpgradeUnitUI extends JDialog{
    
    JPanel pnMain, pnTitle;
    JLabel lblImgTitle, lblTitle;
    JButton btnDispose, btnOK;
    MyPanel[] panelUpgradeUnit;
    
    public UpgradeUnitUI(){
        panelUpgradeUnit = new MyPanel[13];
        addControl();
        addEvents();
    }
    public void addControl(){
        Container con = getContentPane();
        con.setLayout(null);
        lblImgTitle = new JLabel();
        lblImgTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblHouTitle.png")));
        lblImgTitle.setBounds(70, 0, 60, 60);
        con.add(lblImgTitle);

        pnTitle = new JPanel(null);
        pnTitle.setBounds(0, 30, 700, 20);
        pnTitle.setBackground(new Color(215, 172, 116));
        con.add(pnTitle);
        lblTitle = new JLabel("Upgrade Unit");
        lblTitle.setBounds(300, 0, 125, 15);
        pnTitle.add(lblTitle);
        btnDispose = new JButton(new ImageIcon(getClass().getResource("/Image/xButton.PNG")));
        btnDispose.setBounds(680, 0, 20, 20);
        pnTitle.add(btnDispose);

        pnMain = new JPanel();
        pnMain.setLayout(null);
        pnMain.setPreferredSize(new Dimension(700, 1050));
        pnMain.setBackground(new Color(253, 247, 221));

        JScrollPane scDialog = new JScrollPane(pnMain, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scDialog.getVerticalScrollBar().setUnitIncrement(16);
        scDialog.setBounds(0, 50, 700, 520);
        con.add(scDialog);

        int d = 0; //d is the distance between 2 panel
        
        for (Army.Unit unit : Army.Unit.values()) {
            if (unit.ordinal() == 12)
                break;
            panelUpgradeUnit[unit.ordinal()] = new MyPanel(unit);
            panelUpgradeUnit[unit.ordinal()].setBounds(0, 30 + d, 700, 50);
            pnMain.add(panelUpgradeUnit[unit.ordinal()]);
            d += 80;
        }

        btnOK = new JButton("OK");
        btnOK.setBounds(280, 1010, 110, 30);
        btnOK.setBackground(new Color(248, 222, 164));
        pnMain.add(btnOK);

    }
    
    public void addEvents(){
        this.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt){
                int[] armourUpgrade = IsLandUI.currentHouse.getArmy().getArmourUpgrade();
                int[] damageUpgrade = IsLandUI.currentHouse.getArmy().getDamageUpgrade();
                for(int i=0; i<armourUpgrade.length; i++){
                    panelUpgradeUnit[i].getTxtAmour().setText(String.valueOf(armourUpgrade[i]));
                    panelUpgradeUnit[i].getTxtDamage().setText(String.valueOf(damageUpgrade[i]));
                }
            }
        });
        
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Army army = new Army();
                int [] damage = new int[12];
                int [] amour = new int[12];
                for (int i = 0; i < 12; i++) {
                    if(panelUpgradeUnit[i].getTxtDamage().getText().equals("")){
                        damage[i] = 0;
                    }
                    else
                        damage[i] = Integer.valueOf(panelUpgradeUnit[i].getTxtDamage().getText());
                    if(panelUpgradeUnit[i].getTxtAmour().getText().equals(""))
                        amour[i] = 0;
                    else
                        amour[i] = Integer.valueOf(panelUpgradeUnit[i].getTxtAmour().getText());
                    //army.getArmourUpgrade()[unit.ordinal()] = panelUpgradeUnit[i].getAmour();                    
                }
                IsLandUI.currentHouse.getArmy().setDamageUpgrade(damage);
                IsLandUI.currentHouse.getArmy().setArmourUpgrade(amour);
                dispose();
            }
        });
        
        btnDispose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
    public void showWindow(){
        this.setSize(700, 570);
        setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setVisible(true);
    }
}
