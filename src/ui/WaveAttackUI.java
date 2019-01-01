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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import model.Army;
import model.RealArmy;
import model.SendingArmy;
import model.SentArmy;

/**
 *
 * @author Dat Ngo
 */
public class WaveAttackUI extends JDialog {

    int size = 0;
    int wei = 0;
    JLabel[] lblTitle;
    PnWaveAttack[] pnWave;
    HashMap<Integer, ArrayList<SentArmy>> sentRealArmy;
    HashMap<Integer, PriorityQueue<SendingArmy>> sendingArmy;
    int count = 0;

    public WaveAttackUI(String title, HashMap<Integer, ArrayList<SentArmy>> sentRealArmy, HashMap<Integer, PriorityQueue<SendingArmy>> sendingArmy) {
        setTitle(title);
        setSize(820, 500);
        setLocationRelativeTo(null);

        lblTitle = new JLabel[7];
        sentRealArmy.forEach((key, arrList) -> {
            size += arrList.size();
        }
        );
        sendingArmy.forEach((key, queue) -> {
            wei += queue.size();
        });
        pnWave = new PnWaveAttack[size + wei];
        this.sentRealArmy = sentRealArmy;
        this.sendingArmy = sendingArmy;
        addControls();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private void addControls() {
        Container con = getContentPane();
        JPanel pnMain = new JPanel();
        JScrollPane sc = new JScrollPane(pnMain, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        con.add(sc);
        pnMain.setLayout(null);
        pnMain.setBackground(new Color(221, 176, 109));
        for (int i = 0; i < 7; i++) {
            lblTitle[i] = new JLabel();
            lblTitle[i].setBounds(30 + 110 * i, 20, 100, 50);
            pnMain.add(lblTitle[i]);
        }
        lblTitle[0].setText("Mission");
        lblTitle[1].setText("Arrival time");
        lblTitle[2].setText("Munition");
        lblTitle[3].setText("Unit");
        lblTitle[4].setText("Origin");
        lblTitle[5].setText("Target");
        lblTitle[6].setText("Action");

        sentRealArmy.forEach((key, arrList) -> {
            for (int j = 0; j < arrList.size(); j++) {
                int numberOfUnit = 0;
                SentArmy sentArmy = arrList.get(arrList.size() - j - 1);
                for (int k = 0; k < sentArmy.getRealArmy().getArcher().size(); k++) {
                    if (sentArmy.getRealArmy().getArcher().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getBB().size(); k++) {
                    if (sentArmy.getRealArmy().getBB().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getCatapult().size(); k++) {
                    if (sentArmy.getRealArmy().getCatapult().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getHop().size(); k++) {
                    if (sentArmy.getRealArmy().getHop().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getMortar().size(); k++) {
                    if (sentArmy.getRealArmy().getMortar().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getRam().size(); k++) {
                    if (sentArmy.getRealArmy().getRam().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getSC().size(); k++) {
                    if (sentArmy.getRealArmy().getSC().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getSlinger().size(); k++) {
                    if (sentArmy.getRealArmy().getSlinger().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getSpear().size(); k++) {
                    if (sentArmy.getRealArmy().getSpear().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getSteam().size(); k++) {
                    if (sentArmy.getRealArmy().getSteam().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getSword().size(); k++) {
                    if (sentArmy.getRealArmy().getSword().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getGyrocopter().size(); k++) {
                    if (sentArmy.getRealArmy().getGyrocopter().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                int temp = count;
                if (numberOfUnit != 0) {
                    pnWave[count] = new PnWaveAttack(sentArmy, key);
                    pnWave[count].getLblOrigin().setText(IsLandUI.myHouse.getName());
                    pnWave[count].getLblTarget().setText(IsLandUI.house[key].getName());
                    pnWave[count].getLblUnit().setText(numberOfUnit + "");
                    pnWave[count].getLblMission().setIcon(new ImageIcon(getClass().getResource("/Image/Pillage_Enabled.PNG")));
                    long time = System.currentTimeMillis() + IsLandUI.setting.getSpeedTurn();
                    SimpleDateFormat ft = new SimpleDateFormat("mm:ss");
                    Timer dongho = new Timer(1000, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            pnWave[temp].getLblArrivalTime().setText(ft.format(new Date(time - System.currentTimeMillis())));
                        }
                    });
                    dongho.start();

                    pnWave[count].setBounds(20, 60 * count + 75, 820, 50);
                    pnMain.add(pnWave[count]);
                    count++;
                }

            }

        }
        );

        sendingArmy.forEach((key, queue) -> {
            Iterator<SendingArmy> iterator = queue.iterator();
            while (iterator.hasNext()) {
                int numberOfUnit = 0;
                SendingArmy sendingArmy = iterator.next();

                Army army = sendingArmy.getArmy();

                for (Army.Unit unit : Army.Unit.values()) {
                    numberOfUnit += army.getNumberOf(unit);
                }
                int temp = count;
                if (numberOfUnit != 0) {
                    pnWave[count] = new PnWaveAttack(sendingArmy, key, this.sendingArmy.get(key));
                    pnWave[count].getLblOrigin().setText(IsLandUI.myHouse.getName());
                    pnWave[count].getLblTarget().setText(IsLandUI.house[key].getName());
                    pnWave[count].getLblUnit().setText(numberOfUnit + "");
                    pnWave[count].getLblMission().setIcon(new ImageIcon(getClass().getResource("/Image/arival.PNG")));
                    SimpleDateFormat ft = new SimpleDateFormat("mm:ss");
                    Timer dongho = new Timer(1000, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            pnWave[temp].getLblArrivalTime().setText(ft.format(new Date(sendingArmy.getFinishTime() - System.currentTimeMillis())));
                        }
                    });
                    dongho.start();

                    pnWave[count].setBounds(20, 60 * (count) + 75, 820, 50);
                    pnMain.add(pnWave[count]);
                    count++;
                }
            }

        });

    }
}
