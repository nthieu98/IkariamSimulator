/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
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

/**
 *
 * @author maidoanh
 */
public class RealArmy {

    private Stack<Wall> wall;

    private Stack<Hoplite> hop;
    private Stack<SteamGiant> steam;

    private Stack<Swordsman> sword;
    private Stack<Spearman> spear;

    private Stack<BalloonBombardier> bB;
    private Stack<Gyrocopter> gyrocopter;

    private Stack<Ram> ram;
    private Stack<Catapult> catapult;
    private Stack<Mortar> mortar;

    private Stack<Slinger> slinger;
    private Stack<Archer> archer;
    private Stack<SulphurCarabineer> sC;

    public RealArmy() {
        wall = new Stack<>();
        hop = new Stack<>();
        steam = new Stack<>();
        sword = new Stack<>();
        spear = new Stack<>();
        bB = new Stack<>();
        gyrocopter = new Stack<>();
        ram = new Stack<>();
        catapult = new Stack<>();
        mortar = new Stack<>();
        slinger = new Stack<>();
        archer = new Stack<>();
        sC = new Stack<>();
    }

    public Stack<Wall> getWall() {
        return wall;
    }

    public void setWall(Stack<Wall> wall) {
        this.wall = wall;
    }

    public void setbB(Stack<BalloonBombardier> bB) {
        this.bB = bB;
    }

    public void setsC(Stack<SulphurCarabineer> sC) {
        this.sC = sC;
    }

    public Stack<Hoplite> getHop() {
        return hop;
    }

    public void setHop(Stack<Hoplite> Hop) {
        this.hop = Hop;
    }

    public Stack<SteamGiant> getSteam() {
        return steam;
    }

    public void setSteam(Stack<SteamGiant> Steam) {
        this.steam = Steam;
    }

    public Stack<Swordsman> getSword() {
        return sword;
    }

    public void setSword(Stack<Swordsman> Sword) {
        this.sword = Sword;
    }

    public Stack<Spearman> getSpear() {
        return spear;
    }

    public void setSpear(Stack<Spearman> Spear) {
        this.spear = Spear;
    }

    public Stack<BalloonBombardier> getBB() {
        return bB;
    }

    public void setBB(Stack<BalloonBombardier> BB) {
        this.bB = BB;
    }

    public Stack<Gyrocopter> getGyrocopter() {
        return gyrocopter;
    }

    public void setGyrocopter(Stack<Gyrocopter> Gyrocopter) {
        this.gyrocopter = Gyrocopter;
    }

    public Stack<Ram> getRam() {
        return ram;
    }

    public void setRam(Stack<Ram> Ram) {
        this.ram = Ram;
    }

    public Stack<Catapult> getCatapult() {
        return catapult;
    }

    public void setCatapult(Stack<Catapult> Catapult) {
        this.catapult = Catapult;
    }

    public Stack<Mortar> getMortar() {
        return mortar;
    }

    public void setMortar(Stack<Mortar> Mortar) {
        this.mortar = Mortar;
    }

    public Stack<Slinger> getSlinger() {
        return slinger;
    }

    public void setSlinger(Stack<Slinger> Slinger) {
        this.slinger = Slinger;
    }

    public Stack<Archer> getArcher() {
        return archer;
    }

    public void setArcher(Stack<Archer> Archer) {
        this.archer = Archer;
    }

    public Stack<SulphurCarabineer> getSC() {
        return sC;
    }

    public void setSC(Stack<SulphurCarabineer> SC) {
        this.sC = SC;
    }

    public void pushUnits(int number, UnitFighter unit, Stack<UnitFighter> stackUnit) {
        for (int i = 0; i < number; i++) {
            stackUnit.push(unit);
        }

    }

    public Army toArmy() {
        Army army = new Army();
        army.setNumberOfArcher(this.getArcher().size());
        army.setNumberOfBB(this.getBB().size());
        army.setNumberOfCatapult(this.getCatapult().size());
        army.setNumberOfGyrocopter(this.getGyrocopter().size());
        army.setNumberOfHop(this.getHop().size());
        army.setNumberOfMotar(this.getMortar().size());
        army.setNumberOfRam(this.getRam().size());
        army.setNumberOfSC(this.getSC().size());
        army.setNumberOfSlinger(this.getSlinger().size());
        army.setNumberOfSpear(this.getSpear().size());
        army.setNumberOfSteam(this.getSteam().size());
        army.setNumberOfSword(this.getSword().size());
        return army;
    }

    public Stack getUnit(Army.Unit unit) {
        switch (unit) {

            case Archer:
                return getArcher();
            case Balloon:
                return getBB();
            case Catapult:
                return getCatapult();
            case Gyrocopter:
                return getGyrocopter();
            case Hoplite:
                return getHop();
            case Mortar:
                return getMortar();
            case Ram:
                return getRam();
            case Slinger:
                return getSlinger();
            case Spearman:
                return getSpear();
            case SteamGiant:
                return getSteam();
            case Sulfur:
                return getSC();
            case Swordsman:
                return getSword();
            default:
                return null;
        }
    }

    public void push(Army.Unit unit) {
        switch (unit) {
            case Archer:
                archer.push(new Archer());
                break;
            case Balloon:
                bB.push(new BalloonBombardier());
                break;
            case Catapult:
                catapult.push(new Catapult());
//            case Gyrocopter:
//                return setGyrocopter();
            case Hoplite:
                hop.push(new Hoplite());
                break;
            case Mortar:
                mortar.push(new Mortar());
                break;
            case Ram:
                ram.push(new Ram());
                break;
            case Slinger:
                slinger.push(new Slinger());
//            case Spearman:
//                return setSpear();
            case SteamGiant:
                steam.push(new SteamGiant());
                break;
            case Sulfur:
                sC.push(new SulphurCarabineer());
                break;
//            case Swordsman:
//                return setSword();
            default:
        }
    }

}
