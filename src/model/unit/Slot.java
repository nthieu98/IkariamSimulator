/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.unit;

import java.util.ArrayList;
import model.Army;

/**
 *
 * @author Dat Ngo
 */
public class Slot {

    private ArrayList<Army.Unit> armyInSlot;

    public Slot() {
    }

    public Slot(ArrayList<Army.Unit> armyInSlot) {
        this.armyInSlot = armyInSlot;
    }

    public ArrayList<Army.Unit> getArmyInSlot() {
        return armyInSlot;
    }

    public void setArmyInSlot(ArrayList<Army.Unit> armyInSlot) {
        this.armyInSlot = armyInSlot;
    }

}
