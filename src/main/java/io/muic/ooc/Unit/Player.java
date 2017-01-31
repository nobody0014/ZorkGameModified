package io.muic.ooc.Unit;

/**
 * Created by wit on 1/12/2017 AD.
 */
public class Player extends Unit {

    private int statPoints;

    private int currentExp;
    private int maxExp;

    //For equipped items
    private int extraStr;
    private int extraDex;
    private int extraInt;
    private int extraWis;
    private int extraCon;
    private int extraLuck;




    public Player(){
        setLevel(1);
        setBaseCon(5);
        setBaseDex(5);
        setBaseInt(5);
        setBaseLuck(5);
        setBaseStr(5);
        setBaseDex(5);
        updateStatus();
    }


    @Override
    public void updateStatus(){
        super.updateStatus();
        setMaxExp(getLevel());
    }

    public void levelUp(){
        setLevel(getLevel()+1);
        setCurrentHp(getMaxHp());
        setCurrentMana(getMaxMana());
        setStatPoints(getStatPoints()+10);
    }



    public void incrementBaseStr(){setBaseStr(getBaseStr()+1);}

    public void incrementBaseCon(){setBaseCon(getBaseCon()+1);}

    public void incrementBaseInt(){setBaseInt(getBaseInt()+1);}

    public void incrementBaseLuck(){setBaseLuck(getBaseLuck()+1);}

    public void incrementBaseWis(){setBaseWis(getBaseWis()+1);}

    public void incrementBaseDex(){setBaseDex(getBaseDex()+1);}

    public void decrementStatPoints(){setStatPoints(getStatPoints()-1);}


    public int getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public int getMaxExp() {
        return maxExp;
    }
    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }

    public int getExtraStr() {
        return extraStr;
    }

    public void setExtraStr(int extraStr) {
        this.extraStr = extraStr;
    }

    public int getExtraDex() {
        return extraDex;
    }

    public void setExtraDex(int extraDex) {
        this.extraDex = extraDex;
    }

    public int getExtraInt() {
        return extraInt;
    }

    public void setExtraInt(int extraInt) {
        this.extraInt = extraInt;
    }

    public int getExtraWis() {
        return extraWis;
    }

    public void setExtraWis(int extraWis) {
        this.extraWis = extraWis;
    }

    public int getExtraCon() {
        return extraCon;
    }

    public void setExtraCon(int extraCon) {
        this.extraCon = extraCon;
    }

    public int getExtraLuck() {
        return extraLuck;
    }

    public void setExtraLuck(int extraLuck) {
        this.extraLuck = extraLuck;
    }

    public int getStatPoints() {return statPoints;}

    public void setStatPoints(int statPoints) {this.statPoints = statPoints;}
}
