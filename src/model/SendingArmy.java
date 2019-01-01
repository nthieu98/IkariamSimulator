/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Timer;
import model.Army;

/**
 *
 * @author Dat Ngo
 */
public class SendingArmy implements Comparable<SendingArmy>{
    private Army army;
    private long startTime;
    private long finishTime;
    private Timer timer;
    public SendingArmy() {
        army = new Army();
    }
    
    public SendingArmy(Army army, long startTime, long finishTime) {
        this.army = army;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public Army getArmy() {
        return army;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public int compareTo(SendingArmy o) {
        return (int) (this.finishTime - o.finishTime);
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
    
    
}
