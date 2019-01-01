/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Army;
import model.BattleField;

/**
 *
 * @author GBlue
 */
public class PnBattleFieldFighting extends JPanel {

    public PnSlotReserve[] pnSlotReserve;
    BattleField battleField;
    JPanel pnReserve;
    PanelBattlefield pnBattleField;
    JLabel lblReserve;

    public PnBattleFieldFighting(BattleField battleField) {
        this.battleField = battleField;
        addControls();
        addEvents();
    }

    public void addControls() {
        this.setLayout(null);
        pnSlotReserve = new PnSlotReserve[12];

        pnReserve = new JPanel();
        pnReserve.setBounds(0, 0, 175, 192);
        pnReserve.setLayout(null);

        this.add(pnReserve);

        pnBattleField = new PanelBattlefield(battleField);
        pnBattleField.setBounds(175, 0, 763, 192);
        this.add(pnBattleField);

    }

    public void addEvents() {

    }

    public void addToReserves() {
        pnReserve.removeAll();
        lblReserve = new JLabel();

        int x = 0;
        int y = 0;
        for (Army.Unit unit : Army.Unit.values()) {
            if (unit.ordinal() == 12) {
                break;
            }
            pnSlotReserve[unit.ordinal()] = new PnSlotReserve(battleField, unit);
            if (pnSlotReserve[unit.ordinal()].battleField.reserve.getUnit(unit).size() == 0) {
                continue;
            }
            pnSlotReserve[unit.ordinal()].setBounds(10 + x, 35 + y, 37, 45);
            pnReserve.add(pnSlotReserve[unit.ordinal()]);
            pnSlotReserve[unit.ordinal()].updates();
            System.out.println("ui.PnBattleFieldFighting.addToReserves()" + pnSlotReserve[unit.ordinal()].getName());
            x += 37;
            if (x == 148) {
                x = 0;
                y += 50;
            }

        }
        lblReserve.setBounds(0, 0, 175, 192);
        lblReserve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reservePanel.png")));
        pnReserve.add(lblReserve);
    }

    public void updates(PnSlot[] pn) {
        for (int i = 0; i < pn.length; i++) {
            pn[i].updates(1);
        }
    }

}
