package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import ui.IsLandUI;

public class Setting {

    private int speedArrival;
    private int speedTurn;


    public Setting() {

    }

    public int getSpeedArrival() {
        return speedArrival;
    }

    public void setSpeedArrival(int speedArrival) {
        this.speedArrival = speedArrival;
    }

    public int getSpeedTurn() {
        return speedTurn*1000;
    }

    public void setSpeedTurn(int speedTurn) {
        this.speedTurn = speedTurn;
    }





}
