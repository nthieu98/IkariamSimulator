/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.BattleField;
import model.BattleFieldFighting;
import model.RealArmy;
import model.Wall;

import ui.PanelBattlefield;
import ui.BattleFieldUI;

/**
 *
 * @author admin
 */
public class HouseInfoUI extends JDialog {

    JPanel pnMain, pnTitle, pnLvHou, pnLvWall, pnTypeOfHou, pnButton;
    JLabel lblLvHou, lblLvWall, lblTypeOfHou, lblHouseName;
    JLabel lblImg, lblTitle, lblImgTitle;
    JSlider sldLevelHouse, sldLevelWall;
    JTextField txtLevelHouse, txtLevelWall, txtHouseName;
    JComboBox<String> cbo;
    JButton btnDispose, btnPillage, btnBarrack, btnOK, btnBattleFighting, btnUpgradeUnit;

    public HouseInfoUI() throws HeadlessException {
        addControls();
        addEvents();
    }

    public void addControls() {
        Container con = getContentPane();
        con.setLayout(null);
        lblImgTitle = new JLabel(new ImageIcon(getClass().getResource("/image/lblHouTitle.png")));
        lblImgTitle.setBounds(20, 0, 60, 60);
        con.add(lblImgTitle);

        pnMain = new JPanel(null);
        pnMain.setBounds(0, 30, 600, 500);
        pnMain.setBackground(new Color(253, 247, 221));

        pnTitle = new JPanel(null);
        pnTitle.setBounds(0, 0, 600, 20);
        pnTitle.setBackground(new Color(215, 172, 116));
        pnMain.add(pnTitle);
        lblTitle = new JLabel("House's Information");
        lblTitle.setBounds(250, 0, 125, 15);
        pnTitle.add(lblTitle);
        btnDispose = new JButton(new ImageIcon(getClass().getResource("/image/xButton.png")));
        btnDispose.setBounds(580, 0, 20, 20);
        pnTitle.add(btnDispose);

        pnLvHou = new JPanel(null);
        pnLvHou.setBounds(0, 50, 600, 50);
        pnLvHou.setBackground(new Color(251, 232, 193));
        pnMain.add(pnLvHou);
        lblLvHou = new JLabel("Level of House");
        lblLvHou.setBounds(50, 15, 90, 20);
        pnLvHou.add(lblLvHou);
        sldLevelHouse = new JSlider(0, 40);
        sldLevelHouse.setBounds(180, 15, 300, 20);
        sldLevelHouse.setBackground(new Color(251, 232, 193));
        pnLvHou.add(sldLevelHouse);
        txtLevelHouse = new JTextField(40);
        txtLevelHouse.setBounds(500, 15, 20, 20);
        pnLvHou.add(txtLevelHouse);

        pnLvWall = new JPanel(null);
        pnLvWall.setBounds(0, 130, 600, 50);
        pnLvWall.setBackground(new Color(251, 232, 193));
        pnMain.add(pnLvWall);
        lblLvWall = new JLabel("Level of Wall");
        lblLvWall.setBounds(50, 15, 90, 20);
        pnLvWall.add(lblLvWall);
        sldLevelWall = new JSlider(0, 42);
        sldLevelWall.setBounds(180, 15, 300, 20);
        sldLevelWall.setBackground(new Color(251, 232, 193));
        pnLvWall.add(sldLevelWall);
        txtLevelWall = new JTextField(40);
        txtLevelWall.setBounds(500, 15, 20, 20);
        pnLvWall.add(txtLevelWall);

        pnTypeOfHou = new JPanel(null);
        pnTypeOfHou.setBounds(0, 210, 600, 50);
        pnTypeOfHou.setBackground(new Color(251, 232, 193));
        pnMain.add(pnTypeOfHou);
        lblTypeOfHou = new JLabel("Type of House");
        lblTypeOfHou.setBounds(50, 15, 90, 20);
        pnTypeOfHou.add(lblTypeOfHou);
        cbo = new JComboBox<>();
        cbo.setBounds(200, 15, 200, 20);
        cbo.addItem("My House");
        cbo.addItem("My Ally");
        cbo.addItem("Enemy");
        cbo.addItem("Moor");
        pnTypeOfHou.add(cbo);
        
        lblHouseName = new JLabel("Name of house:");
        lblHouseName.setBounds(200, 260, 100, 35);
        txtHouseName = new JTextField(100);
        txtHouseName.setBounds(200, 300, 200, 20);
        pnMain.add(lblHouseName);
        pnMain.add(txtHouseName);

        btnPillage = new JButton();
        btnPillage.setBounds(50, 290, 50, 35);
        btnPillage.setIcon(new ImageIcon(getClass().getResource("/image/Pillage_Enabled.png")));
        pnMain.add(btnPillage);

        btnBarrack = new JButton("Set Barrack");
        btnBarrack.setBounds(50, 350, 110, 30);
        btnBarrack.setBackground(new Color(248, 222, 164));
        pnMain.add(btnBarrack);

        btnBattleFighting = new JButton("Fighting");
        btnBattleFighting.setBounds(50, 400, 110, 30);
        btnBattleFighting.setBackground(new Color(248, 222, 164));
        pnMain.add(btnBattleFighting);

        btnUpgradeUnit = new JButton("Upgrade Unit");
        btnUpgradeUnit.setBounds(50, 440, 110, 30);
        btnUpgradeUnit.setBackground(new Color(248, 222, 164));
        pnMain.add(btnUpgradeUnit);

        lblImg = new JLabel(new ImageIcon(getClass().getResource("/image/HouseInfo.png")));
        lblImg.setBounds(370, 270, 200, 200);
        pnMain.add(lblImg);

        btnOK = new JButton("OK");
        btnOK.setBounds(240, 450, 110, 30);
        btnOK.setBackground(new Color(248, 222, 164));
        pnMain.add(btnOK);

        con.add(pnMain);

    }

    public void addEvents() {
        this.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                sldLevelHouse.setValue(IsLandUI.currentHouse.getLevelOfHouse());
                sldLevelWall.setValue(IsLandUI.currentHouse.getLevelOfWall());
                cbo.setSelectedIndex(IsLandUI.currentHouse.getTypeOfHouse());
                txtHouseName.setText(IsLandUI.currentHouse.getName());
                if (IsLandUI.currentHouse.getTypeOfHouse() == 2) {
                    btnPillage.setEnabled(true);
                    btnPillage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Pillage_Enabled.png")));
                } else {
                    btnPillage.setEnabled(false);
                    btnPillage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Pillage_Disabled.png")));
                }
                if (IsLandUI.currentHouse.getBattleFieldFighting().isWar()) {
                    sldLevelHouse.setEnabled(false);
                    sldLevelWall.setEnabled(false);
                } else {
                    sldLevelHouse.setEnabled(true);
                    sldLevelWall.setEnabled(true);
                }

            }
        });

        btnDispose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        sldLevelHouse.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                txtLevelHouse.setText(String.valueOf(sldLevelHouse.getValue()));
            }
        });

        txtLevelHouse.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String StringVal = txtLevelHouse.getText();
                Integer IntVal = 0;
                try {
                    IntVal = Integer.valueOf(StringVal);
                } catch (NumberFormatException e) {
                    txtLevelHouse.setText("0");
                }
                if (IntVal < 0) {
                    txtLevelHouse.setText("0");
                } else if (IntVal >= 40) {
                    txtLevelHouse.setText("40");
                }
                sldLevelHouse.setValue(Integer.valueOf(txtLevelHouse.getText()));
            }
        });
        

        sldLevelWall.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                txtLevelWall.setText(String.valueOf(sldLevelWall.getValue()));
            }
        });

        txtLevelWall.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String StringVal = txtLevelWall.getText();
                Integer IntVal = 0;
                try {
                    IntVal = Integer.valueOf(StringVal);
                } catch (NumberFormatException e) {
                    txtLevelWall.setText("0");
                }
                if (IntVal < 0) {
                    txtLevelWall.setText("0");
                } else if (IntVal >= 40) {
                    txtLevelWall.setText("42");
                }
                sldLevelWall.setValue(Integer.valueOf(txtLevelWall.getText()));
            }
        });


        cbo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (cbo.getSelectedIndex() == 3) {
                    sldLevelHouse.setValue(0);
                    sldLevelHouse.setValue(0);
                    sldLevelWall.setEnabled(false);
                    sldLevelHouse.setEnabled(false);
                    txtLevelHouse.setEnabled(false);
                    txtLevelWall.setEnabled(false);
                    btnBarrack.setEnabled(false);
                    txtHouseName.setEnabled(false);
                } else {
                    sldLevelHouse.setMinimum(1);
                    sldLevelWall.setMinimum(0);
                    sldLevelWall.setEnabled(true);
                    sldLevelHouse.setEnabled(true);
                    txtLevelHouse.setEnabled(true);
                    txtLevelWall.setEnabled(true);
                    btnBarrack.setEnabled(true);
                    txtHouseName.setEnabled(true);
                }
                if (cbo.getSelectedIndex() == 2) {
                    btnPillage.setEnabled(true);
                    btnPillage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Pillage_Enabled.png")));
                } else {
                    btnPillage.setEnabled(false);
                    btnPillage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Pillage_Disabled.png")));
                }
            }
        });
        btnOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setHouseInfo();
            }
        });
        btnPillage.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnPillage.setBorder(new BevelBorder(BevelBorder.RAISED));
            }

            public void mouseExited(MouseEvent evt) {
                btnPillage.setBorder(null);
            }

            public void mouseClicked(MouseEvent evt) {
                if (IsLandUI.myHouse == null) {
                    JOptionPane.showMessageDialog(null, "Chưa có các thông số của My house");
                } else {
//                    setHouseInfo();
                    setHouseInfo();
                    BattleFieldUI ui = new BattleFieldUI();
                    ui.showWindow();

                }
            }
        });
        btnBarrack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setHouseInfo();
                setBarrackInfo();
            }
        });
        btnBattleFighting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!IsLandUI.currentHouse.getBattleFieldFighting().isWar()) {
                    JOptionPane.showMessageDialog(null, "War haven't happened");
                } else {
//                    IsLandUI.bffUI = new BattleFieldFightingUI(IsLandUI.currentHouse.getBattleFieldFighting());
                    System.out.println("" + IsLandUI.currentHouse.getBattleFieldFighting().getAttackBattleField().reserve.getArcher().size());
                    IsLandUI.bffUI = new BattleFieldFightingUI(IsLandUI.currentHouse.getBattleFieldFighting());
                    IsLandUI.bffUI.showWindow();

                }
            }
        });

        btnUpgradeUnit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setHouseInfo();
                UpgradeUnitUI upgradeUnit = new UpgradeUnitUI();
                upgradeUnit.showWindow();
            }
        });

        cbo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (cbo.getSelectedItem().equals("My House")) {
                    IsLandUI.currentHouse.setTypeOfHouse(0);
                }
                if (cbo.getSelectedItem().equals("My Ally")) {
                    IsLandUI.currentHouse.setTypeOfHouse(1);
                }
                if (cbo.getSelectedItem().equals("Enemy")) {
                    IsLandUI.currentHouse.setTypeOfHouse(2);
                }
                if (cbo.getSelectedItem().equals("Moor")) {
                    IsLandUI.currentHouse.setTypeOfHouse(3);
                }
            }
        });

    }

    protected void setBarrackInfo() {
        SetUnitJDialog ui = new SetUnitJDialog();
        ui.showWindows();
    }

    //Set house's attributes
    protected void setHouseInfo() {
        IsLandUI.currentHouse.setLevelOfHouse(Integer.parseInt(txtLevelHouse.getText()));
        IsLandUI.currentHouse.setLevelOfWall(Integer.parseInt(txtLevelWall.getText()));
//        Wall wall = new Wall(Integer.parseInt(txtLevelWall.getText()));
        IsLandUI.currentHouse.setName(txtHouseName.getText());
        if (!IsLandUI.currentHouse.getBattleFieldFighting().isWar()) {
            if (IsLandUI.currentHouse.getBattleFieldFighting().getAttackBattleField() == null) {
                IsLandUI.currentHouse.getBattleFieldFighting().setAttackBattleField(
                        new BattleField(IsLandUI.currentHouse.getLevelOfHouse(), BattleField.TypeOfBattleField.ATTACK));
            } else {
                RealArmy realArmy = IsLandUI.currentHouse.getBattleFieldFighting().getAttackBattleField().getReserve();
                IsLandUI.currentHouse.getBattleFieldFighting().getAttackBattleField().resetAll(IsLandUI.currentHouse.getLevelOfHouse());
                IsLandUI.currentHouse.getBattleFieldFighting().getAttackBattleField().setReserve(realArmy);
            }
            if (IsLandUI.currentHouse.getBattleFieldFighting().getDefenceBattleField() == null) {
                IsLandUI.currentHouse.getBattleFieldFighting().setDefenceBattleField(
                        new BattleField(IsLandUI.currentHouse.getLevelOfHouse(), BattleField.TypeOfBattleField.DEFENCE));
            } else {
                RealArmy realArmy = IsLandUI.currentHouse.getBattleFieldFighting().getDefenceBattleField().getReserve();
                IsLandUI.currentHouse.getBattleFieldFighting().getDefenceBattleField().resetAll(IsLandUI.currentHouse.getLevelOfHouse());
                IsLandUI.currentHouse.getBattleFieldFighting().getDefenceBattleField().setReserve(realArmy);
            }

        }
//        IsLandUI.currentHouse.setWall(wall);
//        if(!IsLandUI.currentHouse.getBattleField().isSetBattleField())
//            IsLandUI.currentHouse.getBattleField().resetAll(IsLandUI.currentHouse.getLevelOfHouse());
        String type = cbo.getSelectedItem().toString();
        if (type.equals("My House")) {
            IsLandUI.currentHouse.setTypeOfHouse(0);
            setIconHouse();
            IsLandUI.myHouse = IsLandUI.currentHouse;
        } else if (type.equals("My Ally")) {
            IsLandUI.currentHouse.setTypeOfHouse(1);
            setIconHouse();
        } else if (type.equals("Enemy")) {
            IsLandUI.currentHouse.setTypeOfHouse(2);
            setIconHouse();
        } else {
            IsLandUI.currentHouse.setTypeOfHouse(3);
            IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/flag.png")));
        }
        IsLandUI.currentTextField.setText(IsLandUI.currentHouse.getName());
        IsLandUI.currentTextField.setVisible(true);
        this.dispose();

    }

    private void setIconHouse() {
        if (IsLandUI.currentHouse.getLevelOfHouse() == 1) {
        	if(IsLandUI.currentHouse.getTypeOfHouse() == 0) {
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House/blue1.png")));
        	}
        	else{
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House/red1.png")));
        	}
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 2 && IsLandUI.currentHouse.getLevelOfHouse() <= 3) {
        	if(IsLandUI.currentHouse.getTypeOfHouse() == 0) {
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House/blue2.png")));
        	}
        	else{
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House/red2.png")));
        	}
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 4 && IsLandUI.currentHouse.getLevelOfHouse() <= 6) {
        	if(IsLandUI.currentHouse.getTypeOfHouse() == 0) {
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House/blue3.png")));
        	}
        	else{
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House/red3.png")));
        	}
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 7 && IsLandUI.currentHouse.getLevelOfHouse() <= 9) {
        	if(IsLandUI.currentHouse.getTypeOfHouse() == 0) {
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House/blue4.png")));
        	}
        	else{
        	IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House/red4.png")));
        	}
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 10 && IsLandUI.currentHouse.getLevelOfHouse() <= 12) {
        	if(IsLandUI.currentHouse.getTypeOfHouse() == 0) {
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House/blue5.png")));
        	}
        	else{
        	IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House/red5.png")));
        	}
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 13 && IsLandUI.currentHouse.getLevelOfHouse() <= 15) {
        	if(IsLandUI.currentHouse.getTypeOfHouse() == 0) {
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House/blue6.png")));
        	}
        	else{
        	IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House/red6.png")));
        	}
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() == 16 || IsLandUI.currentHouse.getLevelOfHouse() == 17) {
        	if(IsLandUI.currentHouse.getTypeOfHouse() == 0) {
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House/blue7.png")));
        	}
        	else{
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House/red7.png")));
        	}
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 18) {
        	if(IsLandUI.currentHouse.getTypeOfHouse() == 0) {
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House/blue8.png")));
        	}
        	else{
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/House/red8.png")));
        	}
        }
    }

    //Show the HouseInfoUI dialog
    public void showWindow() {
        this.setSize(600, 530);
        setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //pnTranparent.setOpaque(false);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setVisible(true);
    }
}
