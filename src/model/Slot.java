/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.unit.UnitFighter;

/**
 *
 * @author maidoanh
 */
public class Slot {

    private ArrayList<UnitFighter> unit;
    private int totalHitpoint;
    private int totalMunition;
    private String imageUrl;
    private int size;
    private Army.Unit unitType;
    private int initNumUnit; // số quân ban đầu.
    private int initHitpointUnit; // máu mỗi quẫn ban đầu.

    public Slot() {
        initNumUnit = 0;
        totalHitpoint = 100;
        totalMunition = 100;
        imageUrl = "";
        initHitpointUnit = 0;
        unit = new ArrayList<UnitFighter>();
        size = 0;
    }

    public ArrayList<UnitFighter> getUnit() {
        return unit;
    }

    public void setUnit(ArrayList unit) {
        this.unit = unit;
    }

    public void setTotalHitpoint(int totalHitpoint) {
        this.totalHitpoint = totalHitpoint;
    }

    public int getTotalMunition() {
        return totalMunition;
    }

    public void setTotalMunition(int totalMunition) {
        this.totalMunition = totalMunition;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Army.Unit getUnitType() {
        return unitType;
    }

    public void setUnitType(Army.Unit unitType) {
        this.unitType = unitType;
    }

    public int getInitNumUnit() {
        return initNumUnit;
    }

    public void setInitNumUnit(int initNumUnit) {
        this.initNumUnit = initNumUnit;
    }

    public int getInitHitpointUnit() {
        return initHitpointUnit;
    }

    public void setInitHitpointUnit(int initHitpointUnit) {
        this.initHitpointUnit = initHitpointUnit;
    }
    
    
    public int getTotalHitpoint() {
        int totalPercent, totalHitpoint = 0;
        for (UnitFighter unitFighter : unit) {                
            totalHitpoint += unitFighter.getHitPoint();
        }
        if (getUnitAlive() == 0)
            return 0;
        else {
            return totalHitpoint * 100/(getUnitAlive() * initHitpointUnit);
        }
    }
    public int getTotalHitpointNotPercent() {
        int totalHitpoint = 0;
        for (UnitFighter unitFighter : unit) {                
            totalHitpoint += unitFighter.getHitPoint();
       
        }
         return totalHitpoint;
    }
     public int getUnitAlive() {
        int count = 0;
        for (UnitFighter unitFighter : unit) {
            if (unitFighter.getHitPoint() > 0) 
                count++;
        }
        return count;
    }
}
