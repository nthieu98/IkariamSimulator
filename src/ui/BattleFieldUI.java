/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Timer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.Army;
import model.BattleField;
import model.BattleFieldFighting;
import model.SendingArmy;
import model.Slot;
import model.unit.Archer;
import model.unit.BalloonBombardier;
import model.unit.Catapult;
import model.unit.Gyrocopter;
import model.unit.Hoplite;
import model.unit.Mortar;
import model.unit.Slinger;
import model.unit.Spearman;
import model.unit.SteamGiant;
import model.unit.SulphurCarabineer;
import model.unit.Swordsman;

/**
 *
 * @author admin
 */
public class BattleFieldUI extends JDialog {
    
    PanelBattlefield pnBattlefield;
    JButton btnOK, btnRun;
    BattleField battleField;
    JPanel reservePanel;
    Army sentedArmy, army;
    ArrayList<SendingArmy> sendingArmy;
    Timer timer = new Timer();
    
    public static JTabbedPane pnTab;
    
    JPanel pnMain, pnTitle, pnButton, pnContent;
    JLabel lblImg, lblTitle, lblImgTitle;
    JButton btnDispose;
    
    PnSetUnitBattle[] pnSetUnitBattle;
    BattleFieldFighting battleFieldFighting;
    
    public BattleFieldUI() {
        sendingArmy = new ArrayList<SendingArmy>();
        battleField = new BattleField(IsLandUI.currentHouse.getLevelOfHouse(), BattleField.TypeOfBattleField.ATTACK);
        pnSetUnitBattle = new PnSetUnitBattle[12];
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
        pnMain.setPreferredSize(new Dimension(600, 1560));
        pnMain.setBackground(new Color(253, 247, 221));
        
        JScrollPane scDialog = new JScrollPane(pnMain, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scDialog.getVerticalScrollBar().setUnitIncrement(16);
        scDialog.setBounds(0, 50, 980, 480);//
        con.add(scDialog);

        int d = 0; //d is the distance between 2 panel
        for (Army.Unit unit: Army.Unit.values()) {
            if (unit.ordinal() == 12) break;
            pnSetUnitBattle[unit.ordinal()] = new PnSetUnitBattle(unit);
            pnSetUnitBattle[unit.ordinal()].setBounds(0, 30 + d, 980, 50);
            pnMain.add(pnSetUnitBattle[unit.ordinal()]);
            d +=80;
        }

        /*DAT LAM*/
        JPanel pnMain2 = new JPanel();
        pnMain2.setBounds(100, 1000, 980, 600);
        pnMain.add(pnMain2);
        pnMain2.setBackground((new Color(253, 247, 221)));
        pnMain2.setLayout(null);
        
        Border border = BorderFactory.createLineBorder(Color.blue);
        
        JPanel pn1 = new JPanel();
        pn1.setBorder(border);
        pn1.setPreferredSize(new Dimension(750, 60));
        pn1.setBounds(10, 10, 750, 60);
        pn1.setLayout(null);
        btnRun = new JButton();
        btnRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/smallPlay.png")));
        btnRun.setPreferredSize(new Dimension(50, 50));
        btnRun.setBounds(650, 5, 50, 50);
        pn1.add(btnRun);
        pn1.setBackground(new Color(253, 247, 221));
        pnMain2.add(pn1);
        
        JPanel pnField = new JPanel();
        pnField.setBorder(border);
        pnField.setPreferredSize(new Dimension(750, 400));
        pnField.setBounds(10, 150, 780, 400);
        pnField.setBackground(new Color(253, 247, 221));
        pnField.setLayout(null);
        
        JLabel lblPreView = new JLabel("Preview of Battlefield");
        Font fontPreview = new Font("arial", Font.BOLD, 15);
        lblPreView.setFont(fontPreview);
        lblPreView.setForeground(Color.DARK_GRAY);
        lblPreView.setPreferredSize(new Dimension(240, 50));
        lblPreView.setBounds(300, 10, 240, 50);
        pnField.add(lblPreView);
        pnBattlefield = new PanelBattlefield(battleField);
        pnBattlefield.setBounds(10, 70, 763, 192);
        pnBattlefield.setBackground(new Color(253, 247, 221));
        pnField.add(pnBattlefield);
                
        JLabel lblReserve = new JLabel("Reserve:");
        lblReserve.setBounds(10, 250, 100, 50);
        pnField.add(lblReserve);
        
        reservePanel = new JPanel();
        reservePanel.setBounds(10, 300, 700, 60);
        reservePanel.setLayout(null);
        reservePanel.setBackground(new Color(253, 247, 221));
        pnField.add(reservePanel);
        pnMain2.add(pnField);
    }
    
    public void addEvents() {
        this.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                for (Army.Unit unit : Army.Unit.values()) {
                    if (unit.ordinal() == 12) break;
                    Army army = IsLandUI.myHouse.getArmy();
                    pnSetUnitBattle[unit.ordinal()].getSld().setMaximum(army.getNumberOf(unit));
                    pnSetUnitBattle[unit.ordinal()].getJTextFieldMax().setText(String.valueOf(army.getNumberOf(unit)));
                    pnSetUnitBattle[unit.ordinal()].getSld().setValue(0);
                }
            }
        });
        for (Army.Unit unit : Army.Unit.values()) {
            if (unit.ordinal() == 12) break;
            pnSetUnitBattle[unit.ordinal()].getSld().addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    pnSetUnitBattle[unit.ordinal()].getJTextField().setText(String.valueOf(pnSetUnitBattle[unit.ordinal()].getSld().getValue()));
                     setBattleField(unit);
                    addToReserves();
                }
            });
//            pnSetUnitBattle[unit.ordinal()].getSld().addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseReleased(MouseEvent e) {
//                    setBattleField(unit);
//                    addToReserves();
//                    
//                }
//});
        }
        
        btnDispose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveArmyAndSentedArmy();
                battleField.resetAll(battleField.getLevelOfHouse());
                pnBattlefield.resetAll();
                pnBattlefield.updateUI();
//                IsLandUI.currentHouse.addArmyToBattleField(army);
//                battleFieldFighting.setMyBattleField(battleField);
              //  battleFieldFighting.setEnemyBattleField(battleField);
            }
        });
    }
    
    private void saveArmyAndSentedArmy() {
        SendingArmy temp = new SendingArmy();
        
        army = IsLandUI.myHouse.getArmy();
        temp.getArmy().setArmourUpgrade(army.getArmourUpgrade());
        temp.getArmy().setDamageUpgrade(army.getDamageUpgrade());
        for (Army.Unit unit : Army.Unit.values()) {
            if (unit.ordinal() == 12) break;
            temp.getArmy().setNumberOf(unit, pnSetUnitBattle[unit.ordinal()].getSld().getValue());
            army.setNumberOf(unit, army.getNumberOf(unit) - pnSetUnitBattle[unit.ordinal()].getSld().getValue());
            pnSetUnitBattle[unit.ordinal()].getJTextFieldMax().setText(String.valueOf(army.getNumberOf(unit)));
            pnSetUnitBattle[unit.ordinal()].getSld().setMaximum(army.getNumberOf(unit));
            pnSetUnitBattle[unit.ordinal()].getSld().setValue(0);
        }
      //  sendingArmy.add(temp);
        PriorityQueue<SendingArmy>  tempArrayList = IsLandUI.myHouse.getSendingArmy().get(IsLandUI.currentHouse.getId());
        if(tempArrayList == null)
            IsLandUI.myHouse.getSendingArmy().put(IsLandUI.currentHouse.getId(), new PriorityQueue<SendingArmy>());
        //IsLandUI.myHouse.getSendingArmy().get(IsLandUI.currentHouse.getId()) = new ArrayList<Object>();
        IsLandUI.myHouse.getSendingArmy().get(IsLandUI.currentHouse.getId()).add(temp);
        IsLandUI.myHouse.setArmy(army);
//        IsLandUI.currentHouse.addArmyToBattleField(temp.getArmy());
        temp.setStartTime(System.currentTimeMillis());
        temp.setFinishTime(temp.getStartTime()+ temp.getArmy().getSpeedTimeForWholeRoute() * IsLandUI.setting.getSpeedArrival() / 100);
        IsLandUI.currentHouse.addArmyToBattleField(temp.getArmy(), temp);
        
        
    }
    
     public void setBattleField(Army.Unit unit) {
        switch (unit) {
            case Archer:
                battleField.reserve.getArcher().clear();
                battleField.resetUnitSlot(battleField, battleField.longRangeFighter, Army.Unit.Archer);
                
                for (int i = 0; i < pnSetUnitBattle[unit.ordinal()].getSld().getValue(); i++) {
                    battleField.reserve.getArcher().push(new Archer());
                }
                battleField.setLongRange();
                pnBattlefield.updates(pnBattlefield.pnLongRangeFighter, 0);

                break;
            case Balloon:
                battleField.reserve.getBB().clear();
                battleField.resetUnitSlot(battleField, battleField.bomber, Army.Unit.Balloon);
                for (int i = 0; i < pnSetUnitBattle[unit.ordinal()].getSld().getValue(); i++) {
                    battleField.reserve.getBB().push(new BalloonBombardier());
                }
                battleField.setBB();
                pnBattlefield.updates(pnBattlefield.pnBomber, 0);
                break;
            case Catapult:
                battleField.reserve.getCatapult().clear();
                battleField.resetUnitSlot(battleField, battleField.artillery, Army.Unit.Catapult);
                pnBattlefield.updates(pnBattlefield.pnArtillery, 0);
                for (int i = 0; i < pnSetUnitBattle[unit.ordinal()].getSld().getValue(); i++) {
                    battleField.reserve.getCatapult().push(new Catapult());
                }
                battleField.setArtilleryClass();
                pnBattlefield.updates(pnBattlefield.pnArtillery, 0);
                break;
            case Gyrocopter:
                battleField.reserve.getGyrocopter().clear();
                battleField.resetUnitSlot(battleField, battleField.airDefence, Army.Unit.Gyrocopter);
                for (int i = 0; i < pnSetUnitBattle[unit.ordinal()].getSld().getValue(); i++) {
                    battleField.reserve.getGyrocopter().push(new Gyrocopter());
                }
                battleField.setAirDefence();
                pnBattlefield.updates(pnBattlefield.pnAirDefence, 0);
                break;
            case Hoplite:
                battleField.reserve.getHop().clear();
                battleField.resetUnitSlot(battleField, battleField.front, Army.Unit.Hoplite);
                pnBattlefield.updates(pnBattlefield.pnFront, 0);
                for (int i = 0; i < pnSetUnitBattle[unit.ordinal()].getSld().getValue(); i++) {
                    battleField.reserve.getHop().push(new Hoplite());
                }
                battleField.setFrontLine();
                pnBattlefield.updates(pnBattlefield.pnFront, 0);
                break;
            case Mortar:
                battleField.reserve.getMortar().clear();
                battleField.resetUnitSlot(battleField, battleField.artillery, Army.Unit.Mortar);
                pnBattlefield.updates(pnBattlefield.pnArtillery, 0);
                for (int i = 0; i < pnSetUnitBattle[unit.ordinal()].getSld().getValue(); i++) {
                    battleField.reserve.getMortar().push(new Mortar());
                }
                battleField.setArtilleryClass();
                pnBattlefield.updates(pnBattlefield.pnArtillery, 0);
                break;
            case Ram:
                battleField.reserve.getRam().clear();
                battleField.resetUnitSlot(battleField, battleField.artillery, Army.Unit.Ram);
                pnBattlefield.updates(pnBattlefield.pnArtillery, 0);
                for (int i = 0; i < pnSetUnitBattle[unit.ordinal()].getSld().getValue(); i++) {
                    battleField.reserve.getArcher().push(new Archer());
                }
                battleField.setArtilleryClass();
                pnBattlefield.updates(pnBattlefield.pnArtillery, 0);
                break;
            case Slinger:
                battleField.reserve.getSlinger().clear();
                battleField.resetUnitSlot(battleField, battleField.longRangeFighter, Army.Unit.Slinger);
                
                for (int i = 0; i < pnSetUnitBattle[unit.ordinal()].getSld().getValue(); i++) {
                    battleField.reserve.getSlinger().push(new Slinger());
                }
                battleField.setLongRange();
                pnBattlefield.updates(pnBattlefield.pnLongRangeFighter, 0);
                break;
            case Spearman:
                battleField.reserve.getSpear().clear();
                battleField.resetUnitSlot(battleField, battleField.flank, Army.Unit.Spearman);
                for (int i = 0; i < pnSetUnitBattle[unit.ordinal()].getSld().getValue(); i++) {
                    battleField.reserve.getSpear().push(new Spearman());
                }
                battleField.setFlankToSlot(false);
                pnBattlefield.updates(pnBattlefield.pnFlank, 0);
                break;
            case SteamGiant:
                battleField.reserve.getSteam().clear();
                battleField.resetUnitSlot(battleField, battleField.front, Army.Unit.SteamGiant);
                pnBattlefield.updates(pnBattlefield.pnFront, 0);
                for (int i = 0; i < pnSetUnitBattle[unit.ordinal()].getSld().getValue(); i++) {
                    battleField.reserve.getSteam().push(new SteamGiant());
                }
                battleField.setFrontLine();
                pnBattlefield.updates(pnBattlefield.pnFront, 0);
                break;
            case Sulfur:
                battleField.reserve.getSC().clear();
                battleField.resetUnitSlot(battleField, battleField.longRangeFighter, Army.Unit.Sulfur);
                for (int i = 0; i < pnSetUnitBattle[unit.ordinal()].getSld().getValue(); i++) {
                    battleField.reserve.getSC().push(new SulphurCarabineer());
                }
                battleField.setLongRange();
                pnBattlefield.updates(pnBattlefield.pnLongRangeFighter, 0);
                break;
            case Swordsman:
                battleField.reserve.getSword().clear();
                battleField.resetUnitSlot(battleField, battleField.flank, Army.Unit.Swordsman);
                for (int i = 0; i < pnSetUnitBattle[unit.ordinal()].getSld().getValue(); i++) {
                    battleField.reserve.getSword().push(new Swordsman());
                }
                battleField.setFlankToSlot(false);
                pnBattlefield.updates(pnBattlefield.pnFlank, 0);
                break;
            default:
        }
    }
      private void addToReserves() {
        reservePanel.removeAll();
        int i = 0;
        PnSlotReserve[] pnslotReserve = new PnSlotReserve[12];
        for (Army.Unit unit : Army.Unit.values()) {
            if (unit.ordinal() == 12) break;
            pnslotReserve[unit.ordinal()] = new PnSlotReserve(battleField, unit);
            if(pnslotReserve[unit.ordinal()].battleField.reserve.getUnit(unit).size() == 0) continue;
            pnslotReserve[unit.ordinal()].setBounds(52 * i, 10, 50, 45);
            reservePanel.add(pnslotReserve[unit.ordinal()]);
            pnslotReserve[unit.ordinal()].updates();
            i++;
        }
    }

    //Show the HouseInfoUI dialog
    public void showWindow() {
        setSize(980, 530);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setModal(true);
        setVisible(true);
    }
}