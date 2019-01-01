package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import model.unit.Archer;
import model.unit.BalloonBombardier;
import model.unit.Catapult;
import model.unit.Gyrocopter;
import model.unit.Hoplite;
import model.unit.Mortar;
import model.unit.Ram;
import model.unit.Slinger;
import model.unit.Spearman;
import model.unit.SteamGiant;
import model.unit.SulphurCarabineer;
import model.unit.Swordsman;
import model.unit.UnitFighter;
import ui.IsLandUI;

public class BattleField {

    private int levelOfHouse;

    public static enum TypeOfBattleField {
        ATTACK, DEFENCE;
    }

    private int numberOfSlotForHI;
    private int numberOfSlotForLRF;
    private int numberOfSlotForLI;
    private int numberOfSlotForAr;
    private int numberOfSlotForBB;
    private int numberOfSlotForGy;

    private int spacePerSlotForHI;
    private int spacePerSlotForLRF;
    private int spacePerSlotForLI;
    private int spacePerSlotForAr;
    private int spacePerSlotForBB;
    private int spacePerSlotForGy;

    private String attackFieldImg;
    private String defenceFieldImg;
    public Slot[] artillery, longRangeFighter, front, flank, airDefence, bomber;
    private ArrayList<Archer> slotArcher = new ArrayList<>();
    public RealArmy reserve;
    private TypeOfBattleField typeOfBattleField;

    public int getNumberOfSlotForLRF() {
        return numberOfSlotForLRF;
    }

    public int getNumberOfSlotForAr() {
        return numberOfSlotForAr;
    }

    public int getNumberOfSlotForBB() {
        return numberOfSlotForBB;
    }

    public int getSpacePerSlotForHI() {
        return spacePerSlotForHI;
    }

    public int getSpacePerSlotForLRF() {
        return spacePerSlotForLRF;
    }

    public int getSpacePerSlotForLI() {
        return spacePerSlotForLI;
    }

    public int getSpacePerSlotForAr() {
        return spacePerSlotForAr;
    }

    public int getSpacePerSlotForBB() {
        return spacePerSlotForBB;
    }

    public int getSpacePerSlotForGy() {
        return spacePerSlotForGy;
    }

    public int getNumberOfSlotForGy() {
        return numberOfSlotForGy;
    }

    public void setNumberOfSlotForGy(int numberOfSlotForGy) {
        this.numberOfSlotForGy = numberOfSlotForGy;
    }

    public int getNumberOfSlotForHI() {
        return numberOfSlotForHI;
    }

    public void setNumberOfSlotForHI(int numberOfSlotForHI) {
        this.numberOfSlotForHI = numberOfSlotForHI;
    }

    public void setNumberOfSlotForLRF(int numberOfSlotForLRF) {
        this.numberOfSlotForLRF = numberOfSlotForLRF;
    }

    public int getNumberOfSlotForLI() {
        return numberOfSlotForLI;
    }

    public void setNumberOfSlotForLI(int numberOfSlotForLI) {
        this.numberOfSlotForLI = numberOfSlotForLI;
    }

    public void setNumberOfSlotForAr(int numberOfSlotForAr) {
        this.numberOfSlotForAr = numberOfSlotForAr;
    }

    public void setNumberOfSlotForBB(int numberOfSlotForBB) {
        this.numberOfSlotForBB = numberOfSlotForBB;
    }

    public void setBattleField(House house) {

    }

    public int getLevelOfHouse() {
        return levelOfHouse;
    }

    public void setLevelOfHouse(int levelOfHouse) {
        this.levelOfHouse = levelOfHouse;
    }

    public TypeOfBattleField getTypeOfBattleField() {
        return typeOfBattleField;
    }

    public void setTypeOfBattleField(TypeOfBattleField typeOfBattleField) {
        this.typeOfBattleField = typeOfBattleField;
    }

    public BattleField() {
//        enemyReserve = new RealArmy();
        reserve = new RealArmy();

    }

    public BattleField(int level, TypeOfBattleField typeOfBattleField) {
        levelOfHouse = level;
        reserve = new RealArmy();
        this.typeOfBattleField = typeOfBattleField;
        if (level >= 1 && level <= 4) {
            this.numberOfSlotForHI = 3;
            this.numberOfSlotForLI = 0;
            this.numberOfSlotForAr = 1;
            this.numberOfSlotForBB = 1;
            this.numberOfSlotForLRF = 3;
            this.numberOfSlotForGy = 1;

            this.spacePerSlotForHI = 30;
            this.spacePerSlotForLI = 30;
            this.spacePerSlotForAr = 30;
            this.spacePerSlotForBB = 10;
            this.spacePerSlotForLRF = 30;
            this.spacePerSlotForGy = 10;

            this.attackFieldImg = "/image/battleField/attackField1-4.png";
            this.defenceFieldImg = "/image/battleField/defenceField1-4.png";
        }
        if (level >= 5 && level <= 9) {
            this.numberOfSlotForHI = 5;
            this.numberOfSlotForLI = 2;
            this.numberOfSlotForAr = 2;
            this.numberOfSlotForBB = 1;
            this.numberOfSlotForLRF = 5;
            this.numberOfSlotForGy = 1;

            this.spacePerSlotForHI = 30;
            this.spacePerSlotForLI = 30;
            this.spacePerSlotForAr = 30;
            this.spacePerSlotForBB = 20;
            this.spacePerSlotForLRF = 30;
            this.spacePerSlotForGy = 20;

            this.attackFieldImg = "/image/battleField/attackField5-9.png";
            this.defenceFieldImg = "/image/battleField/defenceField5-9.png";
        }
        if (level >= 10 && level <= 16) {
            this.numberOfSlotForHI = 7;
            this.numberOfSlotForLI = 4;
            this.numberOfSlotForAr = 3;
            this.numberOfSlotForBB = 1;
            this.numberOfSlotForLRF = 7;
            this.numberOfSlotForGy = 1;

            this.spacePerSlotForHI = 30;
            this.spacePerSlotForLI = 30;
            this.spacePerSlotForAr = 30;
            this.spacePerSlotForBB = 30;
            this.spacePerSlotForLRF = 30;
            this.spacePerSlotForGy = 30;

            this.attackFieldImg = "/image/battleField/attackField10-16.png";
            this.defenceFieldImg = "/image/battleField/defenceField10-16.png";
        }
        if (level >= 17 && level <= 24) {
            this.numberOfSlotForHI = 7;
            this.numberOfSlotForLI = 6;
            this.numberOfSlotForAr = 4;
            this.numberOfSlotForBB = 2;
            this.numberOfSlotForLRF = 7;
            this.numberOfSlotForGy = 2;

            this.spacePerSlotForHI = 40;
            this.spacePerSlotForLI = 30;
            this.spacePerSlotForAr = 30;
            this.spacePerSlotForBB = 20;
            this.spacePerSlotForLRF = 40;
            this.spacePerSlotForGy = 20;

            this.attackFieldImg = "/image/battleField/attackField17-24.png";
            this.defenceFieldImg = "/image/battleField/defenceField17-24.png";
        }
        if (level >= 25) {
            this.numberOfSlotForHI = 7;
            this.numberOfSlotForLI = 6;
            this.numberOfSlotForAr = 5;
            this.numberOfSlotForBB = 2;
            this.numberOfSlotForLRF = 7;
            this.numberOfSlotForGy = 2;

            this.spacePerSlotForHI = 50;
            this.spacePerSlotForLI = 40;
            this.spacePerSlotForAr = 30;
            this.spacePerSlotForBB = 30;
            this.spacePerSlotForLRF = 50;
            this.spacePerSlotForGy = 30;

            this.attackFieldImg = "/image/battleField/attackField25.png";
            this.defenceFieldImg = "/image/battleField/defenceField25.png";
        }

        resetAll(level);
    }

    public void resetAll(int level) {
        artillery = new Slot[this.numberOfSlotForAr];
        for (int i = 0; i < this.numberOfSlotForAr; i++) {
            artillery[i] = new Slot();
            artillery[i].setSize(this.spacePerSlotForAr);
        }

        longRangeFighter = new Slot[this.numberOfSlotForLRF];
        for (int i = 0; i < this.numberOfSlotForLRF; i++) {
            longRangeFighter[i] = new Slot();
            longRangeFighter[i].setSize(this.spacePerSlotForLRF);
        }

        front = new Slot[this.numberOfSlotForHI];
        for (int i = 0; i < this.numberOfSlotForHI; i++) {
            front[i] = new Slot();
            front[i].setSize(this.spacePerSlotForHI);
        }

        flank = new Slot[this.numberOfSlotForLI];
        flank = new Slot[this.numberOfSlotForLI];
        for (int i = 0; i < this.numberOfSlotForLI; i++) {
            flank[i] = new Slot();
            flank[i].setSize(this.numberOfSlotForLI);
        }

        airDefence = new Slot[this.numberOfSlotForGy];
        for (int i = 0; i < this.numberOfSlotForGy; i++) {
            airDefence[i] = new Slot();
            airDefence[i].setSize(this.numberOfSlotForGy);
        }

        bomber = new Slot[this.numberOfSlotForBB];
        for (int i = 0; i < this.numberOfSlotForBB; i++) {
            bomber[i] = new Slot();
            bomber[i].setSize(this.numberOfSlotForBB);
        }
    }

    public String getAttackFieldImg() {
        return attackFieldImg;
    }

    public String getDefenceFieldImg() {
        return defenceFieldImg;
    }

    public void setArtilleryClass() {
        int index = countByType(artillery, Army.Unit.Mortar);
        int slotForMortar = (int) Math.ceil((reserve.getMortar().size() * Mortar.size) / (float) this.spacePerSlotForAr);
        for (int i = 1; i <= slotForMortar; i++) {
            if (index < this.numberOfSlotForAr) {
                if (i < slotForMortar) {
                    List<Mortar> units = reserve.getMortar().subList(0, this.spacePerSlotForAr / Mortar.size);
                    artillery[index].getUnit().addAll(units);
                    artillery[index].setImageUrl(units.get(0).getImageUrl());
                    artillery[index].setUnitType(Army.Unit.Mortar);
                    artillery[index].setInitNumUnit(artillery[index].getUnit().size());
                    artillery[index].setInitHitpointUnit(artillery[index].getUnit().get(0).getHitPoint());

                    units.clear();
                } else {
                    List<Mortar> units = reserve.getMortar();
                    artillery[index].getUnit().addAll(units);
                    artillery[index].setImageUrl(units.get(0).getImageUrl());
                    artillery[index].setUnitType(Army.Unit.Mortar);
                    artillery[index].setInitNumUnit(artillery[index].getUnit().size());
                    artillery[index].setInitHitpointUnit(artillery[index].getUnit().get(0).getHitPoint());
                    reserve.getMortar().clear();
                }
                index++;
            } else {
                break;
            }
        }
        index += countByType(artillery, Army.Unit.Catapult);
        int slotForCatapult = (int) Math.ceil((reserve.getCatapult().size() * Catapult.size) / (float) this.spacePerSlotForAr);
        for (int i = 1; i <= slotForCatapult; i++) {
            if (index < this.numberOfSlotForAr) {
                if (i < slotForCatapult) {
                    List<Catapult> units = reserve.getCatapult().subList(0, this.spacePerSlotForAr / Catapult.size);
                    artillery[index].getUnit().addAll(units);
                    artillery[index].setImageUrl(units.get(0).getImageUrl());
                    artillery[index].setUnitType(Army.Unit.Catapult);
                    artillery[index].setInitNumUnit(artillery[index].getUnit().size());
                    artillery[index].setInitHitpointUnit(artillery[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<Catapult> units = reserve.getCatapult();
                    artillery[index].getUnit().addAll(units);
                    artillery[index].setImageUrl(units.get(0).getImageUrl());
                    artillery[index].setUnitType(Army.Unit.Catapult);
                    artillery[index].setInitNumUnit(artillery[index].getUnit().size());
                    artillery[index].setInitHitpointUnit(artillery[index].getUnit().get(0).getHitPoint());
                    reserve.getCatapult().clear();
                }
                index++;
            } else {
                break;
            }
        }
        index += countByType(artillery, Army.Unit.Ram);
        int slotForRam = (int) Math.ceil((reserve.getRam().size() * Ram.size) / (float) this.spacePerSlotForAr);
        for (int i = 1; i <= slotForRam; i++) {
            if (index < this.numberOfSlotForAr) {
                if (i < slotForRam) {
                    List<Ram> units = reserve.getRam().subList(0, this.spacePerSlotForAr / Ram.size);
                    artillery[index].getUnit().addAll(units);
                    artillery[index].setImageUrl(units.get(0).getImageUrl());
                    artillery[index].setUnitType(Army.Unit.Ram);
                    artillery[index].setInitNumUnit(artillery[index].getUnit().size());
                    artillery[index].setInitHitpointUnit(artillery[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<Ram> units = reserve.getRam();
                    artillery[index].getUnit().addAll(units);
                    artillery[index].setImageUrl(units.get(0).getImageUrl());
                    artillery[index].setUnitType(Army.Unit.Ram);
                    artillery[index].setInitNumUnit(artillery[index].getUnit().size());
                    artillery[index].setInitHitpointUnit(artillery[index].getUnit().get(0).getHitPoint());
                    reserve.getRam().clear();
                }
                index++;
            } else {
                break;
            }
        }
    }

    public void setAirDefence() {
        int index = countByType(airDefence, Army.Unit.Gyrocopter);
        int slotForGyr = (int) Math.ceil((reserve.getGyrocopter().size() * Gyrocopter.size) / (float) this.spacePerSlotForGy);
        for (int i = 1; i <= slotForGyr; i++) {
            if (index < this.numberOfSlotForGy) {
                if (i < slotForGyr) {
                    List<Gyrocopter> units = reserve.getGyrocopter().subList(0, this.spacePerSlotForGy / Gyrocopter.size);
                    airDefence[index].getUnit().addAll(units);
                    airDefence[index].setImageUrl(units.get(0).getImageUrl());
                    airDefence[index].setUnitType(Army.Unit.Gyrocopter);
                    airDefence[index].setInitNumUnit(airDefence[index].getUnit().size());
                    airDefence[index].setInitHitpointUnit(airDefence[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<Gyrocopter> units = reserve.getGyrocopter();
                    airDefence[index].getUnit().addAll(units);
                    airDefence[index].setImageUrl(units.get(0).getImageUrl());
                    airDefence[index].setUnitType(Army.Unit.Gyrocopter);
                    airDefence[index].setInitNumUnit(airDefence[index].getUnit().size());
                    airDefence[index].setInitHitpointUnit(airDefence[index].getUnit().get(0).getHitPoint());
                    reserve.getGyrocopter().clear();
                }
                index++;
            } else {
                break;
            }
        }
    }

    public void setBB() {
        int index = countByType(bomber, Army.Unit.Balloon);
        int slotForBB = (int) Math.ceil((reserve.getBB().size() * BalloonBombardier.size) / (float) this.spacePerSlotForBB);
        for (int i = 1; i <= slotForBB; i++) {
            if (index < this.numberOfSlotForBB) {
                if (i < slotForBB) {
                    List<BalloonBombardier> units = reserve.getBB().subList(0, this.spacePerSlotForBB / BalloonBombardier.size);
                    bomber[index].getUnit().addAll(units);
                    bomber[index].setImageUrl(units.get(0).getImageUrl());
                    bomber[index].setUnitType(Army.Unit.Balloon);
                    bomber[index].setInitNumUnit(bomber[index].getUnit().size());
                    bomber[index].setInitHitpointUnit(bomber[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<BalloonBombardier> units = reserve.getBB();
                    bomber[index].getUnit().addAll(units);
                    bomber[index].setImageUrl(units.get(0).getImageUrl());
                    bomber[index].setUnitType(Army.Unit.Balloon);
                    bomber[index].setInitNumUnit(bomber[index].getUnit().size());
                    bomber[index].setInitHitpointUnit(bomber[index].getUnit().get(0).getHitPoint());
                    reserve.getBB().clear();
                }
                index++;
            } else {
                break;
            }
        }
    }

    public void setFlankToSlot(boolean isAllWall) {
        if(isAllWall) return;
        int index = countByType(flank, Army.Unit.Swordsman);
        int slotForSword = (int) Math.ceil((reserve.getSword().size() * Swordsman.size) / (float) this.spacePerSlotForLI);
        for (int i = 1; i <= slotForSword; i++) {
            if (index < this.numberOfSlotForLI) {
                if (i < slotForSword) {
                    List<Swordsman> units = reserve.getSword().subList(0, this.spacePerSlotForLI / Swordsman.size);
                    flank[index].getUnit().addAll(units);
                    flank[index].setImageUrl(units.get(0).getImageUrl());
                    flank[index].setUnitType(Army.Unit.Swordsman);
                    flank[index].setInitNumUnit(flank[index].getUnit().size());
                    flank[index].setInitHitpointUnit(flank[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<Swordsman> units = reserve.getSword();
                    flank[index].getUnit().addAll(units);
                    flank[index].setImageUrl(units.get(0).getImageUrl());
                    flank[index].setUnitType(Army.Unit.Swordsman);
                    flank[index].setInitNumUnit(flank[index].getUnit().size());
                    flank[index].setInitHitpointUnit(flank[index].getUnit().get(0).getHitPoint());
                    reserve.getSword().clear();
                }
                index++;
            } else {
                break;
            }
        }
        index += countByType(flank, Army.Unit.Spearman);
        int slotForSpear = (int) Math.ceil((reserve.getSpear().size() * Spearman.size) / (float) this.spacePerSlotForLI);
        for (int i = 1; i <= slotForSpear; i++) {
            if (index < this.numberOfSlotForLI) {
                if (i < slotForSpear) {
                    List<Spearman> units = reserve.getSpear().subList(0, this.spacePerSlotForLI / Spearman.size);
                    flank[index].getUnit().addAll(units);
                    flank[index].setImageUrl(units.get(0).getImageUrl());
                    flank[index].setUnitType(Army.Unit.Spearman);
                    flank[index].setInitNumUnit(flank[index].getUnit().size());
                    flank[index].setInitHitpointUnit(flank[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<Spearman> units = reserve.getSpear();
                    flank[index].getUnit().addAll(units);
                    flank[index].setImageUrl(units.get(0).getImageUrl());
                    flank[index].setUnitType(Army.Unit.Spearman);
                    flank[index].setInitNumUnit(flank[index].getUnit().size());
                    flank[index].setInitHitpointUnit(flank[index].getUnit().get(0).getHitPoint());
                    reserve.getSpear().clear();
                }
                index++;
            } else {
                break;
            }
        }
    }

    public void setLongRange() {
        int index = countByType(longRangeFighter, Army.Unit.Sulfur);
        int slotForSC = (int) Math.ceil((reserve.getSC().size() * SulphurCarabineer.size) / (float) this.spacePerSlotForLRF);
        for (int i = 1; i <= slotForSC; i++) {
            if (index < this.numberOfSlotForLRF) {
                if (i < slotForSC) {
                    List<SulphurCarabineer> units = reserve.getSC().subList(0, this.spacePerSlotForLRF / SulphurCarabineer.size);
                    longRangeFighter[index].getUnit().addAll(units);
                    longRangeFighter[index].setImageUrl(units.get(0).getImageUrl());
                    longRangeFighter[index].setUnitType(Army.Unit.Sulfur);
                    longRangeFighter[index].setInitNumUnit(longRangeFighter[index].getUnit().size());
                    longRangeFighter[index].setInitHitpointUnit(longRangeFighter[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<SulphurCarabineer> units = reserve.getSC();
                    longRangeFighter[index].getUnit().addAll(units);
                    longRangeFighter[index].setImageUrl(units.get(0).getImageUrl());
                    longRangeFighter[index].setUnitType(Army.Unit.Sulfur);
                    longRangeFighter[index].setInitNumUnit(longRangeFighter[index].getUnit().size());
                    longRangeFighter[index].setInitHitpointUnit(longRangeFighter[index].getUnit().get(0).getHitPoint());
                    reserve.getSC().clear();
                }
                index++;
            } else {
                break;
            }
        }
        index += countByType(longRangeFighter, Army.Unit.Archer);
        int slotForArcher = (int) Math.ceil((reserve.getArcher().size() * Archer.size) / (float) this.spacePerSlotForLRF);
        for (int i = 1; i <= slotForArcher; i++) {
            if (index < this.numberOfSlotForLRF) {
                if (i < slotForArcher) {
                    List<Archer> units = reserve.getArcher().subList(0, this.spacePerSlotForLRF / Archer.size);
                    longRangeFighter[index].getUnit().addAll(units);
                    slotArcher.addAll(units);
                    longRangeFighter[index].setImageUrl(Archer.imageUrl);
                    longRangeFighter[index].setUnitType(Army.Unit.Archer);
                    longRangeFighter[index].setInitNumUnit(longRangeFighter[index].getUnit().size());
                    longRangeFighter[index].setInitHitpointUnit(longRangeFighter[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<Archer> units = reserve.getArcher();
                    longRangeFighter[index].getUnit().addAll(units);
                    slotArcher.addAll(units);
                    longRangeFighter[index].setImageUrl(Archer.imageUrl);
                    longRangeFighter[index].setUnitType(Army.Unit.Archer);
                    longRangeFighter[index].setInitNumUnit(longRangeFighter[index].getUnit().size());
                    longRangeFighter[index].setInitHitpointUnit(longRangeFighter[index].getUnit().get(0).getHitPoint());
                    reserve.getArcher().clear();
                }
                index++;
            } else {
                break;
            }
        }
        index += countByType(longRangeFighter, Army.Unit.Slinger);
        int slotForSlinger = (int) Math.ceil((reserve.getSlinger().size() * Slinger.size) / (float) this.spacePerSlotForLRF);
        for (int i = 1; i <= slotForSlinger; i++) {
            if (index < this.numberOfSlotForLRF) {
                if (i < slotForSlinger) {
                    List<Slinger> units = reserve.getSlinger().subList(0, this.spacePerSlotForLRF / Slinger.size);
                    longRangeFighter[index].getUnit().addAll(units);
                    longRangeFighter[index].setImageUrl(units.get(0).getImageUrl());
                    longRangeFighter[index].setUnitType(Army.Unit.Slinger);
                    longRangeFighter[index].setInitNumUnit(longRangeFighter[index].getUnit().size());
                    longRangeFighter[index].setInitHitpointUnit(longRangeFighter[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<Slinger> units = reserve.getSlinger();
                    longRangeFighter[index].getUnit().addAll(units);
                    longRangeFighter[index].setImageUrl(units.get(0).getImageUrl());
                    longRangeFighter[index].setUnitType(Army.Unit.Slinger);
                    longRangeFighter[index].setInitNumUnit(longRangeFighter[index].getUnit().size());
                    longRangeFighter[index].setInitHitpointUnit(longRangeFighter[index].getUnit().get(0).getHitPoint());
                    reserve.getSlinger().clear();
                }
                index++;
            } else {
                break;
            }
        }
    }

    public void setFrontLine() {
        int numberOfWall = 0;
        Stack<Wall> walls = reserve.getWall();
        numberOfWall = walls.size();
        for (int i = 0; i < numberOfWall; i++) {
            Wall wall = walls.pop();
            front[i].getUnit().add(wall);
            front[i].setImageUrl(wall.getImageUrl());
            front[i].setUnitType(Army.Unit.Wall);
            front[i].setInitNumUnit(1);
            front[i].setInitHitpointUnit(wall.getHitPoint());
        }

        int index = countByType(front, Army.Unit.Hoplite) + numberOfWall;
        int slotForHop = (int) Math.ceil((reserve.getHop().size() * Hoplite.size) / (float) this.spacePerSlotForHI);
        for (int i = 1; i <= slotForHop; i++) {
            if (index < this.numberOfSlotForHI) {
                if (i < slotForHop) {
                    List<Hoplite> units = reserve.getHop().subList(0, this.spacePerSlotForHI / Hoplite.size);
                    front[index].getUnit().addAll(units);
                    front[index].setImageUrl(units.get(0).getImageUrl());
                    front[index].setUnitType(Army.Unit.Hoplite);
                    front[index].setInitNumUnit(front[index].getUnit().size());
                    front[index].setInitHitpointUnit(front[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<Hoplite> units = reserve.getHop();
                    front[index].getUnit().addAll(units);
                    front[index].setImageUrl(units.get(0).getImageUrl());
                    front[index].setUnitType(Army.Unit.Hoplite);
                    front[index].setInitNumUnit(front[index].getUnit().size());
                    front[index].setInitHitpointUnit(front[index].getUnit().get(0).getHitPoint());
                    reserve.getHop().clear();
                }
                index++;
            } else {
                break;
            }
        }
        index += countByType(front, Army.Unit.SteamGiant);
        int slotForSteam = (int) Math.ceil((reserve.getSteam().size() * SteamGiant.size) / (float) this.spacePerSlotForHI);
        for (int i = 1; i <= slotForSteam; i++) {
            if (index < this.numberOfSlotForHI) {
                if (i < slotForSteam) {
                    List<SteamGiant> units = reserve.getSteam().subList(0, this.spacePerSlotForHI / SteamGiant.size);
                    front[index].getUnit().addAll(units);
                    front[index].setImageUrl(units.get(0).getImageUrl());
                    front[index].setUnitType(Army.Unit.SteamGiant);
                    front[index].setInitNumUnit(front[index].getUnit().size());
                    front[index].setInitHitpointUnit(front[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<SteamGiant> units = reserve.getSteam();
                    front[index].getUnit().addAll(units);
                    front[index].setImageUrl(units.get(0).getImageUrl());
                    front[index].setUnitType(Army.Unit.SteamGiant);
                    front[index].setInitNumUnit(front[index].getUnit().size());
                    front[index].setInitHitpointUnit(front[index].getUnit().get(0).getHitPoint());
                    reserve.getSteam().clear();
                }
                index++;
            } else {
                break;
            }
        }
    }

    public void addToReserve(RealArmy reserve, Army sentArmy, int houseID) {
        RealArmy realArmy = new RealArmy();
        for (int i = 0; i < sentArmy.getNumberOfArcher(); i++) {
            Archer archer = new Archer();
            archer.setArmour(archer.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Archer.ordinal()]);
            archer.setDamage(archer.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Archer.ordinal()]);
            reserve.getArcher().add(archer);
            realArmy.getArcher().add(archer);
        }
        for (int i = 0; i < sentArmy.getNumberOfBB(); i++) {
            BalloonBombardier ballon = new BalloonBombardier();
            ballon.setArmour(ballon.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Balloon.ordinal()]);
            ballon.setDamage(ballon.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Balloon.ordinal()]);
            reserve.getBB().add(ballon);
            realArmy.getBB().add(ballon);
        }
        for (int i = 0; i < sentArmy.getNumberOfCatapult(); i++) {
            Catapult catapult = new Catapult();
            catapult.setArmour(catapult.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Catapult.ordinal()]);
            catapult.setDamage(catapult.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Catapult.ordinal()]);
            reserve.getCatapult().add(catapult);
            realArmy.getCatapult().add(catapult);
        }
        for (int i = 0; i < sentArmy.getNumberOfGyrocopter(); i++) {
            Gyrocopter gy = new Gyrocopter();
            gy.setArmour(gy.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Gyrocopter.ordinal()]);
            gy.setDamage(gy.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Gyrocopter.ordinal()]);
            reserve.getGyrocopter().add(gy);
            realArmy.getGyrocopter().add(gy);
        }
        for (int i = 0; i < sentArmy.getNumberOfHop(); i++) {
            Hoplite hop = new Hoplite();
            hop.setArmour(hop.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Hoplite.ordinal()]);
            hop.setDamage(hop.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Hoplite.ordinal()]);
            reserve.getHop().add(hop);
            realArmy.getHop().add(hop);
        }
        for (int i = 0; i < sentArmy.getNumberOfMotar(); i++) {
            Mortar mortar = new Mortar();
            mortar.setArmour(mortar.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Mortar.ordinal()]);
            mortar.setDamage(mortar.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Mortar.ordinal()]);
            reserve.getMortar().add(mortar);
            realArmy.getMortar().add(mortar);
        }
        for (int i = 0; i < sentArmy.getNumberOfRam(); i++) {
            Ram ram = new Ram();
            ram.setArmour(ram.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Ram.ordinal()]);
            ram.setDamage(ram.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Ram.ordinal()]);
            reserve.getRam().add(ram);
            realArmy.getRam().add(ram);
        }
        for (int i = 0; i < sentArmy.getNumberOfSC(); i++) {
            SulphurCarabineer sc = new SulphurCarabineer();
            sc.setArmour(sc.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Sulfur.ordinal()]);
            sc.setDamage(sc.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Sulfur.ordinal()]);
            reserve.getSC().add(sc);
            realArmy.getSC().add(sc);
        }
        for (int i = 0; i < sentArmy.getNumberOfSlinger(); i++) {
            Slinger slinger = new Slinger();
            slinger.setArmour(slinger.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Slinger.ordinal()]);
            slinger.setDamage(slinger.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Slinger.ordinal()]);
            reserve.getSlinger().add(slinger);
            realArmy.getSlinger().add(slinger);
        }
        for (int i = 0; i < sentArmy.getNumberOfSpear(); i++) {
            Spearman spear = new Spearman();
            spear.setArmour(spear.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Spearman.ordinal()]);
            spear.setDamage(spear.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Spearman.ordinal()]);
            reserve.getSpear().add(spear);
            realArmy.getSpear().add(spear);
        }
        for (int i = 0; i < sentArmy.getNumberOfSteam(); i++) {
            SteamGiant steam = new SteamGiant();
            steam.setArmour(steam.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.SteamGiant.ordinal()]);
            steam.setDamage(steam.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.SteamGiant.ordinal()]);
            reserve.getSteam().add(steam);
            realArmy.getSteam().add(steam);
        }
        for (int i = 0; i < sentArmy.getNumberOfSword(); i++) {
            Swordsman sword = new Swordsman();
            sword.setArmour(sword.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Swordsman.ordinal()]);
            sword.setDamage(sword.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Swordsman.ordinal()]);
            reserve.getSword().add(sword);
            realArmy.getSword().add(sword);
        }
        if (IsLandUI.myHouse.getSentRealArmy().get(houseID) == null) {
            IsLandUI.myHouse.getSentRealArmy().put(houseID, new ArrayList<>());
        }

        if (BattleField.TypeOfBattleField.ATTACK == this.typeOfBattleField) {
            IsLandUI.myHouse.getSentRealArmy().get(houseID).add(new SentArmy(realArmy,System.currentTimeMillis()+IsLandUI.setting.getSpeedTurn()));
        }
    }

    public void setUnitsBackToReserve() {
        for (Slot slot : artillery) {
            if (slot.getUnitType() == Army.Unit.Mortar) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getMortar().push((Mortar) unit);
                    }
                }
            } else if (slot.getUnitType() == Army.Unit.Ram) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getRam().push((Ram) unit);
                    }
                }
            } else if (slot.getUnitType() == Army.Unit.Catapult) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getCatapult().push((Catapult) unit);
                    }
                }
            }

        }
        for (Slot slot : front) {
            if (slot.getUnitType() == Army.Unit.Wall) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getWall().push((Wall) unit);
                    }
                }
            } else if (slot.getUnitType() == Army.Unit.Hoplite) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getHop().push((Hoplite) unit);
                    }
                }
            } else if (slot.getUnitType() == Army.Unit.SteamGiant) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getSteam().push((SteamGiant) unit);
                    }
                }
            }

        }
        for (Slot slot : airDefence) {
            if (slot.getUnitType() == Army.Unit.Gyrocopter) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getGyrocopter().push((Gyrocopter) unit);
                    }
                }

            }

        }
        for (Slot slot : bomber) {
            if (slot.getUnitType() == Army.Unit.Balloon) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getBB().push((BalloonBombardier) unit);
                    }
                }

            }

        }
        for (Slot slot : longRangeFighter) {
            if (slot.getUnitType() == Army.Unit.Sulfur) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getSC().push((SulphurCarabineer) unit);
                    }
                }

            }
            if (slot.getUnitType() == Army.Unit.Archer) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getArcher().push((Archer) unit);
                    }
                }

            }
            if (slot.getUnitType() == Army.Unit.Slinger) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getSlinger().push((Slinger) unit);
                    }
                }

            }

        }
        for (Slot slot : flank) {
            if (slot.getUnitType() == Army.Unit.Swordsman) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getSword().push((Swordsman) unit);
                    }
                }

            }
            if (slot.getUnitType() == Army.Unit.Spearman) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getSpear().push((Spearman) unit);
                    }
                }

            }
            if (slot.getUnitType() == Army.Unit.Slinger) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getSlinger().push((Slinger) unit);
                    }
                }

            }

        }
        resetAll(levelOfHouse);
        
    }

    public Slot[] getMyClassUnit(Army.ClassUnit classUnit) {
        switch (classUnit) {
            case Front:
                return getFront();
            case LRF:
                return getlongRangeFighter();
            case Artillery:
                return getArtillery();
            case Bomber:
                return getBomber();
            case Airdefence:
                return getAirDefence();
            case Flank:
                return getFlank();

            default:
                return null;
        }
    }

    public void resetUnitSlot(BattleField battleFields, Slot[] slots, Army.Unit unitType) {
        for (Slot slot : slots) {
            if (slot.getUnitType() == null) {
                continue;
            }
            if (slot.getUnitType().getPriorityInLine() > unitType.getPriorityInLine()) {
                for (int i = 0; i < slot.getUnit().size(); i++) {
                    battleFields.reserve.push(slot.getUnitType());
                }
                slot.setImageUrl("");
                slot.setSize(0);
                slot.setTotalHitpoint(0);
                slot.setUnit(new ArrayList());
                slot.setTotalMunition(0);
                slot.setUnitType(null);
            }

            if (slot.getUnitType() == null) {
                continue;
            } else if (slot.getUnitType().ordinal() == unitType.ordinal()) {
                slot.setImageUrl("");
                slot.setSize(0);
                slot.setTotalHitpoint(0);
                slot.setUnit(new ArrayList());
                slot.setTotalMunition(0);
                slot.setUnitType(null);
            }
        }

    }

    public int countByType(Slot[] slots, Army.Unit unitType) {
        int count = 0;
        for (Slot slot : slots) {
            if (slot.getUnitType() == null) {
                continue;
            }
            if (slot.getUnitType().ordinal() == unitType.ordinal()) {
                count++;
            }
        }
        return count;
    }

    public void makeArtilleryAttack(BattleField enemy) {
        int i = 0, j = 0;
        ArrayList<UnitFighter> myArtillery = new ArrayList<>();
        for (Slot slot : artillery) {
            for (UnitFighter unit : slot.getUnit()) {
                myArtillery.add(unit);
            }
        }
        ArrayList<UnitFighter> enemyFront = new ArrayList<>();
        for (Slot slot : enemy.getFront()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyFront.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyFront)) {
            j = 0;
            while (i < myArtillery.size() && !isAllDeadInArrayList(enemyFront)) {
                while (enemyFront.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyFront.size()) {
                        j = 0;
                    }
                }
                int dam = myArtillery.get(i).getDamage();
                if (!(enemyFront.get(j) instanceof Wall)) {
                    dam = 80;
                }
                while (dam > enemyFront.get(j).getArmour()) {
                    if (dam > enemyFront.get(j).getArmour() + enemyFront.get(j).getHitPoint()) {
                        dam -= enemyFront.get(j).getArmour() + enemyFront.get(j).getHitPoint();
                        enemyFront.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyFront)) {
//                            i++;
                            break;
                        } else {
                            while (enemyFront.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyFront.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyFront.get(j).setHitPoint(enemyFront.get(j).getHitPoint() - dam + enemyFront.get(j).getArmour());
                        dam = 0;
                        j++;
                        if (j == enemyFront.size()) {
                            j = 0;
                        }
                    }
                }
                i++;

            }
        }

        ArrayList<UnitFighter> enemyFlank = new ArrayList<>();
        for (Slot slot : enemy.getFlank()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyFlank.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyFlank)) {
            j = 0;
            while (i < myArtillery.size() && !isAllDeadInArrayList(enemyFlank)) {
                while (enemyFlank.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyFlank.size()) {
                        j = 0;
                    }
                }
                int dam = myArtillery.get(i).getDamage();
                while (dam > enemyFlank.get(j).getArmour()) {
                    if (dam > enemyFlank.get(j).getArmour() + enemyFlank.get(j).getHitPoint()) {
                        dam -= enemyFlank.get(j).getArmour() + enemyFlank.get(j).getHitPoint();
                        enemyFlank.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyFlank)) {
//                            i++;
                            break;
                        } else {
                            while (enemyFlank.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyFlank.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyFlank.get(j).setHitPoint(enemyFlank.get(j).getHitPoint() - dam + enemyFlank.get(j).getArmour());
                        dam = 0;
                    }
                }
                i++;
            }
        }

    }

    public void makeLongRangeAttack(BattleField enemy) {
        boolean allIsWall = true;
        int i = 0, j = 0;
        ArrayList<UnitFighter> myLongRange = new ArrayList<>();
        for (Slot slot : longRangeFighter) {
            for (UnitFighter unit : slot.getUnit()) {
                myLongRange.add(unit);
            }
        }
        ArrayList<UnitFighter> enemyFront = new ArrayList<>();
        for (Slot slot : enemy.getFront()) {
            if (slot.getUnitType() != null && slot.getUnitType().ordinal() == Army.Unit.Wall.ordinal()) {
                continue;
            } else {
                allIsWall = false;
            }
            for (UnitFighter unit : slot.getUnit()) {
                enemyFront.add(unit);
            }
        }
        if (allIsWall) {
            return;
        }
        if (!isAllDeadInArrayList(enemyFront)) {
            j = 0;
            while (i < myLongRange.size() && !isAllDeadInArrayList(enemyFront)) {
                while (enemyFront.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyFront.size()) {
                        j = 0;
                    }
                }
                int dam = myLongRange.get(i).getDamage();
                //if(!(enemyFront.get(j) instanceof Wall)) dam = 80;
                while (dam > enemyFront.get(j).getArmour()) {
                    if (dam > enemyFront.get(j).getArmour() + enemyFront.get(j).getHitPoint()) {
                        dam -= enemyFront.get(j).getArmour() + enemyFront.get(j).getHitPoint();
                        enemyFront.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyFront)) {
//                            i++;
                            break;
                        } else {
                            while (enemyFront.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyFront.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyFront.get(j).setHitPoint(enemyFront.get(j).getHitPoint() - dam + enemyFront.get(j).getArmour());
                        dam = 0;
                        j++;
                        if (j == enemyFront.size()) {
                            j = 0;
                        }
                    }
                }
                i++;

            }
        }

        ArrayList<UnitFighter> enemyFlank = new ArrayList<>();
        for (Slot slot : enemy.getFlank()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyFlank.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyFlank)) {
            j = 0;
            while (i < myLongRange.size() && !isAllDeadInArrayList(enemyFlank)) {
                while (enemyFlank.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyFlank.size()) {
                        j = 0;
                    }
                }
                int dam = myLongRange.get(i).getDamage();
                //if(!(enemyFront.get(j) instanceof Wall)) dam = 80;
                while (dam > enemyFlank.get(j).getArmour()) {
                    if (dam > enemyFlank.get(j).getArmour() + enemyFlank.get(j).getHitPoint()) {
                        dam -= enemyFlank.get(j).getArmour() + enemyFlank.get(j).getHitPoint();
                        enemyFlank.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyFlank)) {
//                            i++;
                            break;
                        } else {
                            while (enemyFlank.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyFlank.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyFlank.get(j).setHitPoint(enemyFlank.get(j).getHitPoint() - dam + enemyFlank.get(j).getArmour());
                        dam = 0;
                    }
                }
                i++;
            }
        }
        ArrayList<UnitFighter> enemyLongRange = new ArrayList<>();
        for (Slot slot : enemy.getlongRangeFighter()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyLongRange.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyLongRange)) {
            j = 0;
            while (i < myLongRange.size() && !isAllDeadInArrayList(enemyLongRange)) {
                while (enemyLongRange.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyFlank.size()) {
                        j = 0;
                    }
                }
                int dam = myLongRange.get(i).getDamage();
                //if(!(enemyLongRange.get(j) instanceof Wall)) dam = 80;
                while (dam > enemyLongRange.get(j).getArmour()) {
                    if (dam > enemyLongRange.get(j).getArmour() + enemyLongRange.get(j).getHitPoint()) {
                        dam -= enemyLongRange.get(j).getArmour() + enemyLongRange.get(j).getHitPoint();
                        enemyLongRange.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyLongRange)) {
//                            i++;
                            break;
                        } else {
                            while (enemyLongRange.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyLongRange.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyLongRange.get(j).setHitPoint(enemyLongRange.get(j).getHitPoint() - dam + enemyLongRange.get(j).getArmour());
                        dam = 0;
                    }
                }
                i++;
            }
        }

    }

    public void makeFrontLineAttack(BattleField enemy) {
        int i = 0, j = 0;
        ArrayList<UnitFighter> myFrontLine = new ArrayList<>();
        for (Slot slot : front) {
            for (UnitFighter unit : slot.getUnit()) {
                myFrontLine.add(unit);
            }
        }
        ArrayList<UnitFighter> enemyFront = new ArrayList<>();
        for (Slot slot : enemy.getFront()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyFront.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyFront)) {
            j = 0;
            while (i < myFrontLine.size() && !isAllDeadInArrayList(enemyFront)) {
                while (enemyFront.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyFront.size()) {
                        j = 0;
                    }
                }
                int dam = myFrontLine.get(i).getDamage();
                //if(!(enemyFront.get(j) instanceof Wall)) dam = 80;
                while (dam > enemyFront.get(j).getArmour()) {
                    if (dam > enemyFront.get(j).getArmour() + enemyFront.get(j).getHitPoint()) {
                        dam -= enemyFront.get(j).getArmour() + enemyFront.get(j).getHitPoint();
                        enemyFront.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyFront)) {
//                            i++;
                            break;
                        } else {
                            while (enemyFront.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyFront.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyFront.get(j).setHitPoint(enemyFront.get(j).getHitPoint() - dam + enemyFront.get(j).getArmour());
                        dam = 0;
                        j++;
                        if (j == enemyFront.size()) {
                            j = 0;
                        }
                    }
                }
                i++;

            }
        }

        ArrayList<UnitFighter> enemyLongRange = new ArrayList<>();
        for (Slot slot : enemy.getlongRangeFighter()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyLongRange.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyLongRange)) {
            j = 0;
            while (i < myFrontLine.size() && !isAllDeadInArrayList(enemyLongRange)) {
                while (enemyLongRange.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == myFrontLine.size()) {
                        j = 0;
                    }
                }
                int dam = myFrontLine.get(i).getDamage();
                //if(!(enemyLongRange.get(j) instanceof Wall)) dam = 80;
                while (dam > enemyLongRange.get(j).getArmour()) {
                    if (dam > enemyLongRange.get(j).getArmour() + enemyLongRange.get(j).getHitPoint()) {
                        dam -= enemyLongRange.get(j).getArmour() + enemyLongRange.get(j).getHitPoint();
                        enemyLongRange.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyLongRange)) {
//                            i++;
                            break;
                        } else {
                            while (enemyLongRange.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyLongRange.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyLongRange.get(j).setHitPoint(enemyLongRange.get(j).getHitPoint() - dam + enemyLongRange.get(j).getArmour());
                        dam = 0;
                    }
                }
                i++;
            }
        }

        ArrayList<UnitFighter> enemyArtilery = new ArrayList<>();
        for (Slot slot : enemy.getArtillery()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyArtilery.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyArtilery)) {
            j = 0;
            while (i < myFrontLine.size() && !isAllDeadInArrayList(enemyArtilery)) {
                while (enemyArtilery.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyArtilery.size()) {
                        j = 0;
                    }
                }
                int dam = myFrontLine.get(i).getDamage();
                //if(!(enemyFront.get(j) instanceof Wall)) dam = 80;
                while (dam > enemyArtilery.get(j).getArmour()) {
                    if (dam > enemyArtilery.get(j).getArmour() + enemyArtilery.get(j).getHitPoint()) {
                        dam -= enemyArtilery.get(j).getArmour() + enemyArtilery.get(j).getHitPoint();
                        enemyArtilery.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyArtilery)) {
//                            i++;
                            break;
                        } else {
                            while (enemyArtilery.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyArtilery.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyArtilery.get(j).setHitPoint(enemyArtilery.get(j).getHitPoint() - dam + enemyArtilery.get(j).getArmour());
                        dam = 0;
                    }
                }
                i++;
            }
        }

        ArrayList<UnitFighter> enemyFlank = new ArrayList<>();
        for (Slot slot : enemy.getFlank()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyFlank.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyFlank)) {
            j = 0;
            while (i < myFrontLine.size() && !isAllDeadInArrayList(enemyFlank)) {
                while (enemyFlank.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyFlank.size()) {
                        j = 0;
                    }
                }
                int dam = myFrontLine.get(i).getDamage();
                //if(!(enemyFront.get(j) instanceof Wall)) dam = 80;
                while (dam > enemyFlank.get(j).getArmour()) {
                    if (dam > enemyFlank.get(j).getArmour() + enemyFlank.get(j).getHitPoint()) {
                        dam -= enemyFlank.get(j).getArmour() + enemyFlank.get(j).getHitPoint();
                        enemyFlank.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyFlank)) {
//                            i++;
                            break;
                        } else {
                            while (enemyFlank.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyFlank.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyFlank.get(j).setHitPoint(enemyFlank.get(j).getHitPoint() - dam + enemyFlank.get(j).getArmour());
                        dam = 0;
                    }
                }
                i++;
            }
        }

    }

    public void makeBombersAttack(BattleField enemy) {
        int i = 0, j = 0;
        ArrayList<UnitFighter> myBombers = new ArrayList<>();
        for (Slot slot : bomber) {
            for (UnitFighter unit : slot.getUnit()) {
                myBombers.add(unit);
            }
        }

        ArrayList<UnitFighter> enemyArtillery = new ArrayList<>();
        for (Slot slot : enemy.getArtillery()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyArtillery.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyArtillery)) {
            j = 0;
            while (i < myBombers.size() && !isAllDeadInArrayList(enemyArtillery)) {
                while (enemyArtillery.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyArtillery.size()) {
                        j = 0;
                    }
                }
                int dam = myBombers.get(i).getDamage();
                while (dam > enemyArtillery.get(j).getArmour()) {
                    if (dam > enemyArtillery.get(j).getArmour() + enemyArtillery.get(j).getHitPoint()) {
                        dam -= enemyArtillery.get(j).getArmour() + enemyArtillery.get(j).getHitPoint();
                        enemyArtillery.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyArtillery)) {
//                            i++;
                            break;
                        } else {
                            while (enemyArtillery.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyArtillery.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyArtillery.get(j).setHitPoint(enemyArtillery.get(j).getHitPoint() - dam + enemyArtillery.get(j).getArmour());
                        dam = 0;
                        j++;
                        if (j == enemyArtillery.size()) {
                            j = 0;
                        }
                    }
                }
                i++;

            }
        }
        ArrayList<UnitFighter> enemyLongRangeFighter = new ArrayList<>();
        for (Slot slot : enemy.getlongRangeFighter()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyLongRangeFighter.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyLongRangeFighter)) {
            j = 0;
            while (i < myBombers.size() && !isAllDeadInArrayList(enemyLongRangeFighter)) {
                while (enemyLongRangeFighter.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyLongRangeFighter.size()) {
                        j = 0;
                    }
                }
                int dam = myBombers.get(i).getDamage();
                while (dam > enemyLongRangeFighter.get(j).getArmour()) {
                    if (dam > enemyLongRangeFighter.get(j).getArmour() + enemyLongRangeFighter.get(j).getHitPoint()) {
                        dam -= enemyLongRangeFighter.get(j).getArmour() + enemyLongRangeFighter.get(j).getHitPoint();
                        enemyLongRangeFighter.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyLongRangeFighter)) {
//                            i++;
                            break;
                        } else {
                            while (enemyLongRangeFighter.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyLongRangeFighter.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyLongRangeFighter.get(j).setHitPoint(enemyLongRangeFighter.get(j).getHitPoint() - dam + enemyLongRangeFighter.get(j).getArmour());
                        dam = 0;
                        j++;
                        if (j == enemyLongRangeFighter.size()) {
                            j = 0;
                        }
                    }
                }
                i++;

            }
        }

        ArrayList<UnitFighter> enemyFront = new ArrayList<>();
        for (Slot slot : enemy.getFront()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyFront.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyFront)) {
            j = 0;
            while (i < myBombers.size() && !isAllDeadInArrayList(enemyFront)) {
                while (enemyFront.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyFront.size()) {
                        j = 0;
                    }
                }
                int dam = myBombers.get(i).getDamage();
                while (dam > enemyFront.get(j).getArmour()) {
                    if (dam > enemyFront.get(j).getArmour() + enemyFront.get(j).getHitPoint()) {
                        dam -= enemyFront.get(j).getArmour() + enemyFront.get(j).getHitPoint();
                        enemyFront.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyFront)) {
//                            i++;
                            break;
                        } else {
                            while (enemyFront.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyFront.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyFront.get(j).setHitPoint(enemyFront.get(j).getHitPoint() - dam + enemyFront.get(j).getArmour());
                        dam = 0;
                        j++;
                        if (j == enemyFront.size()) {
                            j = 0;
                        }
                    }
                }
                i++;

            }
        }

        ArrayList<UnitFighter> enemyFlank = new ArrayList<>();
        for (Slot slot : enemy.getFlank()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyFlank.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyFlank)) {
            j = 0;
            while (i < myBombers.size() && !isAllDeadInArrayList(enemyFlank)) {
                while (enemyFlank.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyFlank.size()) {
                        j = 0;
                    }
                }
                int dam = myBombers.get(i).getDamage();
                while (dam > enemyFlank.get(j).getArmour()) {
                    if (dam > enemyFlank.get(j).getArmour() + enemyFlank.get(j).getHitPoint()) {
                        dam -= enemyFlank.get(j).getArmour() + enemyFlank.get(j).getHitPoint();
                        enemyFlank.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyFlank)) {
//                            i++;
                            break;
                        } else {
                            while (enemyFlank.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyFlank.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyFlank.get(j).setHitPoint(enemyFlank.get(j).getHitPoint() - dam + enemyFlank.get(j).getArmour());
                        dam = 0;
                    }
                }
                i++;
            }
        }

    }

    public void makeAirDefenseAttack(BattleField enemy) {
        int i = 0, j = 0;
        ArrayList<UnitFighter> myAirDefense = new ArrayList<>();
        for (Slot slot : airDefence) {
            for (UnitFighter unit : slot.getUnit()) {
                myAirDefense.add(unit);
            }
        }
        ArrayList<UnitFighter> enemyBombers = new ArrayList<>();
        for (Slot slot : enemy.getBomber()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyBombers.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyBombers)) {
            j = 0;
            while (i < myAirDefense.size() && !isAllDeadInArrayList(enemyBombers)) {
                while (enemyBombers.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyBombers.size()) {
                        j = 0;
                    }
                }
                int dam = myAirDefense.get(i).getDamage();
                while (dam > enemyBombers.get(j).getArmour()) {
                    if (dam > enemyBombers.get(j).getArmour() + enemyBombers.get(j).getHitPoint()) {
                        dam -= enemyBombers.get(j).getArmour() + enemyBombers.get(j).getHitPoint();
                        enemyBombers.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyBombers)) {
//                            i++;
                            break;
                        } else {
                            while (enemyBombers.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyBombers.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyBombers.get(j).setHitPoint(enemyBombers.get(j).getHitPoint() - dam + enemyBombers.get(j).getArmour());
                        dam = 0;
                        j++;
                        if (j == enemyBombers.size()) {
                            j = 0;
                        }
                    }
                }
                i++;

            }
        }
//
        ArrayList<UnitFighter> enemyAirDefense = new ArrayList<>();
        for (Slot slot : enemy.getAirDefence()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyAirDefense.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyAirDefense)) {
            j = 0;
            while (i < myAirDefense.size() && !isAllDeadInArrayList(enemyAirDefense)) {
                while (enemyAirDefense.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyAirDefense.size()) {
                        j = 0;
                    }
                }
                int dam = myAirDefense.get(i).getDamage();
                while (dam > enemyAirDefense.get(j).getArmour()) {
                    if (dam > enemyAirDefense.get(j).getArmour() + enemyAirDefense.get(j).getHitPoint()) {
                        dam -= enemyAirDefense.get(j).getArmour() + enemyAirDefense.get(j).getHitPoint();
                        enemyAirDefense.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyAirDefense)) {
//                            i++;
                            break;
                        } else {
                            while (enemyAirDefense.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyAirDefense.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyAirDefense.get(j).setHitPoint(enemyAirDefense.get(j).getHitPoint() - dam + enemyAirDefense.get(j).getArmour());
                        dam = 0;
                    }
                }
                i++;
            }
        }

    }

    public void makeFlanksAttack(BattleField enemy) {
        int i = 0, j = 0;
        ArrayList<UnitFighter> myFlanks = new ArrayList<>();
        for (Slot slot : flank) {
            for (UnitFighter unit : slot.getUnit()) {
                myFlanks.add(unit);
            }
        }
        ArrayList<UnitFighter> enemyFlank = new ArrayList<>();
        for (Slot slot : enemy.getFlank()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyFlank.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyFlank)) {
            j = 0;
            while (i < myFlanks.size() && !isAllDeadInArrayList(enemyFlank)) {
                while (enemyFlank.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyFlank.size()) {
                        j = 0;
                    }
                }
                int dam = myFlanks.get(i).getDamage();
                while (dam > enemyFlank.get(j).getArmour()) {
                    if (dam > enemyFlank.get(j).getArmour() + enemyFlank.get(j).getHitPoint()) {
                        dam -= enemyFlank.get(j).getArmour() + enemyFlank.get(j).getHitPoint();
                        enemyFlank.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyFlank)) {
//                            i++;
                            break;
                        } else {
                            while (enemyFlank.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyFlank.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyFlank.get(j).setHitPoint(enemyFlank.get(j).getHitPoint() - dam + enemyFlank.get(j).getArmour());
                        dam = 0;
                    }
                }
                i++;
            }
        }

        ArrayList<UnitFighter> enemyLongRangeFighter = new ArrayList<>();
        for (Slot slot : enemy.getlongRangeFighter()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyLongRangeFighter.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyLongRangeFighter)) {
            j = 0;
            while (i < myFlanks.size() && !isAllDeadInArrayList(enemyLongRangeFighter)) {
                while (enemyLongRangeFighter.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyLongRangeFighter.size()) {
                        j = 0;
                    }
                }
                int dam = myFlanks.get(i).getDamage();
                while (dam > enemyLongRangeFighter.get(j).getArmour()) {
                    if (dam > enemyLongRangeFighter.get(j).getArmour() + enemyLongRangeFighter.get(j).getHitPoint()) {
                        dam -= enemyLongRangeFighter.get(j).getArmour() + enemyLongRangeFighter.get(j).getHitPoint();
                        enemyLongRangeFighter.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyLongRangeFighter)) {
//                            i++;
                            break;
                        } else {
                            while (enemyLongRangeFighter.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyLongRangeFighter.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyLongRangeFighter.get(j).setHitPoint(enemyLongRangeFighter.get(j).getHitPoint() - dam + enemyLongRangeFighter.get(j).getArmour());
                        dam = 0;
                        j++;
                        if (j == enemyLongRangeFighter.size()) {
                            j = 0;
                        }
                    }
                }
                i++;

            }
        }

        ArrayList<UnitFighter> enemyArtillery = new ArrayList<>();
        for (Slot slot : enemy.getArtillery()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyArtillery.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyArtillery)) {
            j = 0;
            while (i < myFlanks.size() && !isAllDeadInArrayList(enemyArtillery)) {
                while (enemyArtillery.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyArtillery.size()) {
                        j = 0;
                    }
                }
                int dam = myFlanks.get(i).getDamage();
                while (dam > enemyArtillery.get(j).getArmour()) {
                    if (dam > enemyArtillery.get(j).getArmour() + enemyArtillery.get(j).getHitPoint()) {
                        dam -= enemyArtillery.get(j).getArmour() + enemyArtillery.get(j).getHitPoint();
                        enemyArtillery.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyArtillery)) {
//                            i++;
                            break;
                        } else {
                            while (enemyArtillery.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyArtillery.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyArtillery.get(j).setHitPoint(enemyArtillery.get(j).getHitPoint() - dam + enemyArtillery.get(j).getArmour());
                        dam = 0;
                        j++;
                        if (j == enemyArtillery.size()) {
                            j = 0;
                        }
                    }
                }
                i++;

            }
        }

        ArrayList<UnitFighter> enemyFront = new ArrayList<>();
        for (Slot slot : enemy.getFront()) {
            for (UnitFighter unit : slot.getUnit()) {
                enemyFront.add(unit);
            }
        }
        if (!isAllDeadInArrayList(enemyFront)) {
            j = 0;
            while (i < myFlanks.size() && !isAllDeadInArrayList(enemyFront)) {
                while (enemyFront.get(j).getHitPoint() == 0) {
                    j++;
                    if (j == enemyFront.size()) {
                        j = 0;
                    }
                }
                int dam = myFlanks.get(i).getDamage();
                while (dam > enemyFront.get(j).getArmour()) {
                    if (dam > enemyFront.get(j).getArmour() + enemyFront.get(j).getHitPoint()) {
                        dam -= enemyFront.get(j).getArmour() + enemyFront.get(j).getHitPoint();
                        enemyFront.get(j).setHitPoint(0);
                        if (isAllDeadInArrayList(enemyFront)) {
//                            i++;
                            break;
                        } else {
                            while (enemyFront.get(j).getHitPoint() == 0) {
                                j++;
                                if (j == enemyFront.size()) {
                                    j = 0;
                                }
                            }
                        }
                    } else {
                        enemyFront.get(j).setHitPoint(enemyFront.get(j).getHitPoint() - dam + enemyFront.get(j).getArmour());
                        dam = 0;
                        j++;
                        if (j == enemyFront.size()) {
                            j = 0;
                        }
                    }
                }
                i++;

            }
        }

    }

    private boolean isAllDeadInArrayList(ArrayList<UnitFighter> units) {
        for (UnitFighter unit : units) {
            if (unit.getHitPoint() != 0) {
                return false;
            }
        }
        return true;
    }

    public void addToField(boolean isAllWall) {
        setLongRange();
        setAirDefence();
        setArtilleryClass();
        setFrontLine();
        setFlankToSlot(isAllWall);
        setBB();
    }

    public boolean isAllDead() {
        if (!reserve.getArcher().empty()) {
            return false;
        }
        if (!reserve.getBB().empty()) {
            return false;
        }
        if (!reserve.getCatapult().empty()) {
            return false;
        }
        if (!reserve.getGyrocopter().empty()) {
            return false;
        }
        if (!reserve.getHop().empty()) {
            return false;
        }
        if (!reserve.getMortar().empty()) {
            return false;
        }
        if (!reserve.getRam().empty()) {
            return false;
        }
        if (!reserve.getSC().empty()) {
            return false;
        }
        if (!reserve.getSlinger().empty()) {
            return false;
        }
        if (!reserve.getSpear().empty()) {
            return false;
        }
        if (!reserve.getSteam().empty()) {
            return false;
        }
        if (!reserve.getSword().empty()) {
            return false;
        }
        if (!reserve.getWall().empty()) {
            return false;
        }
        return true;
    }

     public boolean isAllWall(){
        return this.getReserve().getWall().size()==this.getNumberOfSlotForHI();
    }


    public RealArmy getReserve() {
        return reserve;
    }

    public void setReserve(RealArmy reserve) {
        this.reserve = reserve;
    }

    public Slot[] getArtillery() {
        return artillery;
    }

    public void setArtillery(Slot[] artillery) {
        this.artillery = artillery;
    }

    public Slot[] getlongRangeFighter() {
        return longRangeFighter;
    }

    public void setlongRangeFighter(Slot[] longRangeFighter) {
        this.longRangeFighter = longRangeFighter;
    }

    public Slot[] getFront() {
        return front;
    }

    public void setFront(Slot[] front) {
        this.front = front;
    }

    public Slot[] getFlank() {
        return flank;
    }

    public void setFlank(Slot[] flank) {
        this.flank = flank;
    }

    public Slot[] getAirDefence() {
        return airDefence;
    }

    public void setAirDefence(Slot[] airDefence) {
        this.airDefence = airDefence;
    }

    public Slot[] getBomber() {
        return bomber;
    }

    public void setBomber(Slot[] bomber) {
        this.bomber = bomber;
    }

    public ArrayList<Archer> getSlotArcher() {
        return slotArcher;
    }

    public void setSlotArcher(ArrayList<Archer> slotArcher) {
        this.slotArcher = slotArcher;
    }

//Láº¥y toÃ n bá»™ mÃ¡u cá»§a táº¥t cáº£ cÃ¡c quÃ¢n trong cÃ¡c slot Ä‘á»ƒ kiá»ƒm tra chiáº¿n trÆ°á»�ng cÃ³ thay Ä‘á»•i hay khÃ´ng
     public int getTotalHitpoint()  {
        int totalHitpoint = 0;
        for (Army.ClassUnit classUnit : Army.ClassUnit.values()) {
            for (Slot slot : getMyClassUnit(classUnit)) {
                    totalHitpoint += slot.getTotalHitpointNotPercent();
            }
        }
        return totalHitpoint;
    }
}
