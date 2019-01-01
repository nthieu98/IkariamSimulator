package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import ui.IsLandUI;

public class House {

    private int id;
    private int levelOfHouse;
    private int levelOfWall;
    private Wall wall;
    private int typeOfHouse = 3; //0: của mình, 1: của đồng minh, 2: của địch, 3: Chưa có nhà
    private Army army;
    private HashMap<Integer, PriorityQueue<SendingArmy>> sendingArmy;
    private HashMap<Integer, ArrayList<SentArmy>> sentRealArmy;
    private ArrayList<RealArmy> waitingWaveAttack;
    private BattleFieldFighting battleFieldFighting;
    private String name;

    public House() {
        army = new Army();
        wall = new Wall(0);
        sendingArmy = new HashMap<Integer, PriorityQueue<SendingArmy>>();
        battleFieldFighting = new BattleFieldFighting(id);
        waitingWaveAttack = new ArrayList<RealArmy>();
        sentRealArmy = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        battleFieldFighting = new BattleFieldFighting(id);
    }

    public House(int id) {
        this.id = id;
    }

    public HashMap<Integer, ArrayList<SentArmy>> getSentRealArmy() {
        return sentRealArmy;
    }

    public void setSentRealArmy(HashMap<Integer, ArrayList<SentArmy>> sentRealArmy) {
        this.sentRealArmy = sentRealArmy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wall getWall() {
        return wall;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }

    public int getLevelOfWall() {
        return levelOfWall;
    }

    public int getLevelOfHouse() {
        return levelOfHouse;
    }

    public void setLevelOfHouse(int levelOfHouse) {
        this.levelOfHouse = levelOfHouse;
    }

    public void setLevelOfWall(int levelOfWall) {
        this.levelOfWall = levelOfWall;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public int getTypeOfHouse() {
        return typeOfHouse;
    }

    public void setTypeOfHouse(int typeOfHouse) {
        this.typeOfHouse = typeOfHouse;
    }

    public HashMap<Integer, PriorityQueue<SendingArmy>> getSendingArmy() {
        return sendingArmy;
    }

    public void setSendingArmy(HashMap<Integer, PriorityQueue<SendingArmy>> sendingArmy) {
        this.sendingArmy = sendingArmy;
    }

    public BattleFieldFighting getBattleFieldFighting() {
        return battleFieldFighting;
    }

    public void setBattleFieldFighting(BattleFieldFighting battleFieldFighting) {
        this.battleFieldFighting = battleFieldFighting;
    }

    public ArrayList<RealArmy> getWaitingWaveAttack() {
        return waitingWaveAttack;
    }

    public void setWaitingWaveAttack(ArrayList<RealArmy> waitingWaveAttack) {
        this.waitingWaveAttack = waitingWaveAttack;
    }

    public void addArmyToBattleField(Army attackArmy, SendingArmy sendingArmy) {
        Timer timer = new Timer();
        Army defenceArmy = this.army;
        int houseID = this.getId();
        sendingArmy.setTimer(timer);        
        long percentArival = IsLandUI.setting.getSpeedArrival();
        long timeTurn = IsLandUI.setting.getSpeedTurn();
        long timeArrive = sendingArmy.getFinishTime()-sendingArmy.getStartTime();
        //long timeReal = timeArrive * percentArival / 100;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                battleFieldFighting.getAttackBattleField().addToReserve(battleFieldFighting.getAttackBattleField().getReserve(), attackArmy, houseID);
                if (!battleFieldFighting.isWar()) {
                    battleFieldFighting.getDefenceBattleField().addToReserve(battleFieldFighting.getDefenceBattleField().getReserve(), defenceArmy, houseID);
                    army.clear();
                    battleFieldFighting.setWar(true);
                    if(levelOfWall > 0) {
	                    Stack<Wall> walls = new Stack<>();
	                 
	                    for (int i = 0; i < battleFieldFighting.getDefenceBattleField().getNumberOfSlotForHI(); i++) {
	                        walls.add(new Wall(levelOfWall));
	                    }
	                    battleFieldFighting.getDefenceBattleField().getReserve().setWall(walls);
                    }
                    
                    boolean isAllWall = battleFieldFighting.getDefenceBattleField().isAllWall();
                    battleFieldFighting.getDefenceBattleField().addToField(isAllWall);
                    battleFieldFighting.getAttackBattleField().addToField(isAllWall);
                    battleFieldFighting.startAttack(timeTurn);
                }
                IsLandUI.myHouse.getSendingArmy().get(id).poll();
                JOptionPane.showMessageDialog(null, "Army arrived");
            }
        }, timeArrive);
    }

}
