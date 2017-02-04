package io.muic.ooc.Calculator;

/**
 * Created by wit on 1/24/2017 AD.
 */
public class StatCalculator {
    public static int calculatePhysicalAttack(int str, int dex) {
        return (int) Math.ceil(str + 0.5*dex + 20);
    }

    public static int calculatePhysicalDefense(int str, int con) {
        return (int) Math.ceil(str + 0.5*con + 10);
    }

    public static int calculateMagicalAttack(int intel, int wis) {
        return (int) Math.ceil(intel + 0.5*wis + 20);
    }

    public static int calculateMagicalDefense(int intel, int con) {
        return (int) Math.ceil(intel + 0.5*con + 10 );
    }

    public static int calculateAccuracy(int dex, int luck) {
        return (int) Math.ceil(dex + 0.5*luck + 95);
    }

    public static int calculateDodgeChance(int dex, int luck) {
        return (int) Math.ceil(dex + 0.5*luck + 5);
    }

    public static int calculateCriticalChance(int dex, int luck) {
        return (int) Math.ceil(luck + 0.5*dex + 5);
    }

    public static int calculateMaxHp(int str, int con) {
        return (int) Math.ceil(con + 0.5*str + 50);
    }


    public static int calculateMaxMana(int intel, int wis) {
        return (int) Math.ceil(wis + 0.5*intel + 20);
    }




    public static int calculatePhysicalAttack(int str, int dex, int extra) {
        return (int) Math.ceil(str + 0.5*dex + 20 + extra);
    }

    public static int calculatePhysicalDefense(int str, int con, int extra) {
        return (int) Math.ceil(str + 0.5*con + 10 + extra);
    }

    public static int calculateMagicalAttack(int intel, int wis, int extra) {
        return (int) Math.ceil(intel + 0.5*wis + 20 + extra);
    }

    public static int calculateMagicalDefense(int intel, int con, int extra) {
        return (int) Math.ceil(intel + 0.5*con + 5 + extra);
    }

    public static int calculateAccuracy(int dex, int luck, int extra) {
        return (int) Math.ceil(dex + 0.5*luck + 5 + extra);
    }

    public static int calculateDodgeChance(int dex, int luck, int extra) {
        return (int) Math.ceil(dex + 0.5*luck + 5 + extra);
    }

    public static int calculateCriticalChance(int dex, int luck, int extra) {
        return (int) Math.ceil(luck + 0.5*dex + 5 + extra );
    }

    public static int calculateMaxHp(int str, int con, int extra) {
        return (int) Math.ceil(con + 0.5*str + 100 + extra);
    }

    public static int calculateMonsterMaxHp(int str, int con, int extra) {
        return (int) Math.ceil(con + 0.5*str + 50 + extra);
    }

    public static int calculateMaxMana(int intel, int wis, int extra) {
        return (int) Math.ceil(wis + 0.5*intel + 50 + extra);
    }

    public static int calculateMaxExp(int level){
        double exp = Math.ceil(10*1.5*level);
        return (int) exp;
    }
}
