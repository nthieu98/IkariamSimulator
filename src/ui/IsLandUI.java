/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.House;
import model.Setting;
/**
 *
 * @author Dat Ngo
 */
public class IsLandUI extends JFrame{
    JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btnWaveAttack;
    JTextField txt0, txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10, txt11, txt12, txt13, txt14, txt15, txt16, txt17;
    JLabel lblIsLand;
	public final int ISLAND_WIDTH = 1280;
	public final int ISLAND_HEIGHT = 660;
	public int speedArrival = 100;
	public int speedTurn = 900;
    public static JButton currentButton;
    public static House currentHouse;
    public static JTextField currentTextField;
    public HouseInfoUI houseInfoUI;
    public static House[] house;
    public static Setting setting;
    public static House myHouse;
    public static BattleFieldFightingUI bffUI;
    public JScrollPane scrollPane;
    public static final Color BROWN = new Color(153,62,0);
	private PanelOverview ovFloat;

    public IsLandUI(String title){
        super(title);
        house = new House[18];
        currentHouse = new House();
        currentButton = new JButton();
        for(int i=0; i<18; i++){
            house[i] = new House();
            house[i].setName("House"+i);
            house[i].setId(i);
        }
        setting = new Setting();
        setting.setSpeedArrival(100);
        setting.setSpeedTurn(900);
        houseInfoUI = new HouseInfoUI();
        addControls();
        addEvents();
    }
    
    public void addControls(){
        Container con = getContentPane();
		ovFloat = new PanelOverview();

        JPanel pnMain = new JPanel();
        
        pnMain.setLayout(new BorderLayout());
        scrollPane = new JScrollPane(pnMain);
		scrollPane.getViewport().setViewPosition(new Point(75, 150));
		scrollPane.setFocusable(false);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        con.add(scrollPane);
        
        ovFloat.setLocation(500, 0);
//		this.add(scrollPane);
		this.getLayeredPane().add(ovFloat, JLayeredPane.PALETTE_LAYER);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
//        con.add(ovFloat, JLayeredPane.PALETTE_LAYER);
//   		con.setLayout(new BoxLayout(con.getContentPane(), BoxLayout.PAGE_AXIS));     
   		
        btn0 = new MyJButtonFlag();
        btn0.setBounds(142, 573, 70, 70);
        txt0 = new JTextField();
        txt0.setBounds(132, 643, 90, 20);
        txt0.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt0.setEditable(false);
        txt0.setVisible(false);
        txt0.setHorizontalAlignment(JTextField.CENTER);
        txt0.setForeground(BROWN);
        pnMain.add(btn0);
        pnMain.add(txt0);
        
        btn1 = new MyJButtonFlag();
        btn1.setBounds(182, 379, 70, 70);
        txt1 = new JTextField();
        txt1.setBounds(172, 449, 90, 20);
        txt1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt1.setEditable(false);
        txt1.setVisible(false);
        txt1.setHorizontalAlignment(JTextField.CENTER);
        txt1.setForeground(BROWN);
        pnMain.add(btn1);
        pnMain.add(txt1);
        
        btn2 = new MyJButtonFlag();
        btn2.setBounds(225, 265, 70 ,70);
        txt2 = new JTextField();
        txt2.setBounds(215, 335, 90, 20);
        txt2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt2.setEditable(false);
        txt2.setVisible(false);
        txt2.setHorizontalAlignment(JTextField.CENTER);
        txt2.setForeground(BROWN);
        pnMain.add(txt2);
        pnMain.add(btn2);
        
        btn3 = new MyJButtonFlag();
        btn3.setBounds(303, 638, 70 ,70);
        txt3 = new JTextField();
        txt3.setBounds(293, 708, 90, 20);
        txt3.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt3.setEditable(false);
        txt3.setVisible(false);
        txt3.setHorizontalAlignment(JTextField.CENTER);
        txt3.setForeground(BROWN);
        pnMain.add(txt3);
        pnMain.add(btn3);
        
        btn4 = new MyJButtonFlag();
        btn4.setBounds(377, 292, 70 ,70);
        txt4 = new JTextField();
        txt4.setBounds(367, 362, 90, 20);
        txt4.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt4.setEditable(false);
        txt4.setVisible(false);
        txt4.setHorizontalAlignment(JTextField.CENTER);
        txt4.setForeground(BROWN);
        pnMain.add(txt4);
        pnMain.add(btn4);
        
        btn5 = new MyJButtonFlag();
        btn5.setBounds(453, 600, 70 ,70);
        txt5 = new JTextField();
        txt5.setBounds(443, 670, 90, 20);
        txt5.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt5.setEditable(false);
        txt5.setVisible(false);
        txt5.setHorizontalAlignment(JTextField.CENTER);
        txt5.setForeground(BROWN);
        pnMain.add(txt5);
        pnMain.add(btn5);
        
        btn6 = new MyJButtonFlag();
        btn6.setBounds(486, 225, 70 ,70);
        txt6 = new JTextField();
        txt6.setBounds(476, 295, 90, 20);
        txt6.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt6.setEditable(false);
        txt6.setVisible(false);
        txt6.setHorizontalAlignment(JTextField.CENTER);
        txt6.setForeground(BROWN);
        pnMain.add(txt6);
        pnMain.add(btn6);
        
        btn7 = new MyJButtonFlag();
        btn7.setBounds(516, 730, 70 ,70);
        txt7 = new JTextField();
        txt7.setBounds(506, 800, 90, 20);
        txt7.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt7.setEditable(false);
        txt7.setVisible(false);
        txt7.setHorizontalAlignment(JTextField.CENTER);
        txt7.setForeground(BROWN);
        pnMain.add(txt7);
        pnMain.add(btn7);
        
        btn8 = new MyJButtonFlag();
        btn8.setBounds(641, 141, 70 ,70);
        txt8 = new JTextField();
        txt8.setBounds(631, 211, 90, 20);
        txt8.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt8.setEditable(false);
        txt8.setVisible(false);
        txt8.setHorizontalAlignment(JTextField.CENTER);
        txt8.setForeground(BROWN);
        pnMain.add(txt8);
        pnMain.add(btn8);
        
        btn9 = new MyJButtonFlag();
        btn9.setBounds(718, 338, 70 ,70);
        txt9 = new JTextField();
        txt9.setBounds(708, 408, 90, 20);
        txt9.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt9.setEditable(false);
        txt9.setVisible(false);
        txt9.setHorizontalAlignment(JTextField.CENTER);
        txt9.setForeground(BROWN);
        pnMain.add(txt9);
        pnMain.add(btn9);
        
        btn10 = new MyJButtonFlag();
        btn10.setBounds(825, 680, 70 ,70);
        txt10 = new JTextField();
        txt10.setBounds(815, 750, 90, 20);
        txt10.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt10.setEditable(false);
        txt10.setVisible(false);
        txt10.setHorizontalAlignment(JTextField.CENTER);
        txt10.setForeground(BROWN);
        pnMain.add(txt10);
        pnMain.add(btn10);
        
        btn11 = new MyJButtonFlag();
        btn11.setBounds(884, 127, 70 ,70);
        txt11 = new JTextField();
        txt11.setBounds(874, 197, 90, 20);
        txt11.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt11.setEditable(false);
        txt11.setVisible(false);
        txt11.setHorizontalAlignment(JTextField.CENTER);
        txt11.setForeground(BROWN);
        pnMain.add(txt11);
        pnMain.add(btn11);
        
        btn12 = new MyJButtonFlag();
        btn12.setBounds(920, 342, 70 ,70);
        txt12 = new JTextField();
        txt12.setBounds(910, 412, 90, 20);
        txt12.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt12.setEditable(false);
        txt12.setVisible(false);
        txt12.setHorizontalAlignment(JTextField.CENTER);
        txt12.setForeground(BROWN);
        pnMain.add(txt12);
        pnMain.add(btn12);
        
        btn13 = new MyJButtonFlag();
        btn13.setBounds(974, 606, 70 ,70);
        txt13 = new JTextField();
        txt13.setBounds(964, 676, 90, 20);
        txt13.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt13.setEditable(false);
        txt13.setVisible(false);
        txt13.setHorizontalAlignment(JTextField.CENTER);
        txt13.setForeground(BROWN);
        pnMain.add(txt13);
        pnMain.add(btn13);
        
        btn14 = new MyJButtonFlag();
        btn14.setBounds(1043, 196, 70 ,70);
        txt14 = new JTextField();
        txt14.setBounds(1033, 266, 90, 20);
        txt14.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt14.setEditable(false);
        txt14.setVisible(false);
        txt14.setHorizontalAlignment(JTextField.CENTER);
        txt14.setForeground(BROWN);
        pnMain.add(txt14);
        pnMain.add(btn14);
        
        btn15 = new MyJButtonFlag();
        btn15.setBounds(1103, 335, 70 ,70);
        txt15 = new JTextField();
        txt15.setBounds(1093, 405, 90, 20);
        txt15.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt15.setEditable(false);
        txt15.setVisible(false);
        txt15.setHorizontalAlignment(JTextField.CENTER);
        txt15.setForeground(BROWN);
        pnMain.add(txt15);
        pnMain.add(btn15);
        
        btn16 = new MyJButtonFlag();
        btn16.setBounds(1127, 454, 70 ,70);
        txt16 = new JTextField();
        txt16.setBounds(1117, 534, 90, 20);
        txt16.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt16.setEditable(false);
        txt16.setVisible(false);
        txt16.setHorizontalAlignment(JTextField.CENTER);
        txt16.setForeground(BROWN);
        pnMain.add(txt16);
        pnMain.add(btn16);
        
        btn17 = new MyJButtonFlag();
        btn17.setBounds(1135, 573, 70 ,70);
        txt17 = new JTextField();
        txt17.setBounds(1125, 643, 90, 30);
        txt17.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txt17.setEditable(false);
        txt17.setVisible(false);
        txt17.setHorizontalAlignment(JTextField.CENTER);
        txt17.setForeground(BROWN);
        pnMain.add(txt17);
        pnMain.add(btn17);
        
        btnWaveAttack = new JButton("");
        btnWaveAttack.setBounds(1114, 14, 84, 112);
        btnWaveAttack.setOpaque(false);
        btnWaveAttack.setContentAreaFilled(false);
        btnWaveAttack.setBorder(null);
        pnMain.add(btnWaveAttack);
        
        lblIsLand = new JLabel();
        lblIsLand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/island1.jpg")));
        pnMain.add(lblIsLand);
        lblIsLand.setBounds(0, 10, 1000, 665);

    }
    
    public void addEvents(){
		ovFloat.militaryBtn.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (myHouse != null)
					new WaveAttackUI("WaveAttack", myHouse.getSentRealArmy(), myHouse.getSendingArmy())
							.setVisible(true);
			}
		});
		ovFloat.btnSpeed.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				IsLandUI.setting.setSpeedArrival((Integer.parseInt(ovFloat.txtSpeed.getText())));
				IsLandUI.setting.setSpeedTurn((Integer.parseInt(ovFloat.txtTurn.getText())));
			}
		});
		

//        btnWaveAttack.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(myHouse!=null)
//                    new WaveAttackUI("WaveAttack", myHouse.getSentRealArmy(), myHouse.getSendingArmy()).setVisible(true);
//            }
//        });
        
        
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[0];
                currentButton = btn0;
                currentTextField = txt0;
                houseInfoUI.showWindow();
            }
        });
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[1];
                currentButton = btn1;
                currentTextField = txt1;
                houseInfoUI.showWindow();
            }
        });
        
        
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[2];
                currentButton = btn2;
                currentTextField = txt2;
                houseInfoUI.showWindow();
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[3];
                currentButton = btn3;
                currentTextField = txt3;
                houseInfoUI.showWindow();
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[4];
                currentButton = btn4;
                currentTextField = txt4;
                houseInfoUI.showWindow();
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[5];
                currentButton = btn5;
                currentTextField = txt5;
                houseInfoUI.showWindow();
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[6];
                currentButton = btn6;
                currentTextField = txt6;
                houseInfoUI.showWindow();
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[7];
                currentButton = btn7;
                currentTextField = txt7;
                houseInfoUI.showWindow();
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[8];
                currentButton = btn8;
                currentTextField = txt8;
                houseInfoUI.showWindow();
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[9];
                currentButton = btn9;
                currentTextField = txt9;
                houseInfoUI.showWindow();
            }
        });
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[10];
                currentButton = btn10;
                currentTextField = txt10;
                houseInfoUI.showWindow();
            }
        });
        btn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[11];
                currentButton = btn11;
                currentTextField = txt11;
                houseInfoUI.showWindow();
            }
        });
        btn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[12];
                currentButton = btn12;
                currentTextField = txt12;
                houseInfoUI.showWindow();
            }
        });
        btn13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[13];
                currentButton = btn13;
                currentTextField = txt13;
                houseInfoUI.showWindow();
            }
        });
        btn14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[14];
                currentButton = btn14;
                currentTextField = txt14;
                houseInfoUI.showWindow();
            }
        });
        btn15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[15];
                currentButton = btn15;
                currentTextField = txt15;
                houseInfoUI.showWindow();
            }
        });
        btn16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[16];
                currentButton = btn16;
                currentTextField = txt16;
                houseInfoUI.showWindow();
            }
        });
        btn17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[17];
                currentButton = btn17;
                currentTextField = txt17;
                houseInfoUI.showWindow();
            }
        });
    }
    
    public void showWindow(){
    	Dimension windowSize = new Dimension(ISLAND_WIDTH, ISLAND_HEIGHT);
		this.setMinimumSize(windowSize);
		this.setSize(windowSize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }          
}
