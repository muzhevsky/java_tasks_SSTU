package com.muzhevsky.core.fighters;

import java.util.ArrayList;
import java.util.List;

public class Karate {
    private String name;
    private List<Punch> punchCombination;

    public static ArrayList<Punch2<Karate>> punch2Collection = new ArrayList<Punch2<Karate>>();

    static {
        punch2Collection.add(x -> x.doFistPunch());
        punch2Collection.add(x -> x.doJumpPunch());
        punch2Collection.add(x -> x.doLegPunch());
    }

    public ArrayList<Punch2<Karate>> punch2Combination = new ArrayList<>();

    public void doPunch2Combination() {
        for (Punch2<Karate> punch : punch2Combination) {
            punch.Punch(this);
        }
    }

    public Karate(String name, Punch... combination) {
        if (name == null)
            throw new IllegalArgumentException("name is null");
        this.name = name;

        punchCombination = new ArrayList<>();
        for (Punch punch : combination) {
            punchCombination.add(punch);
        }
    }

    public Punch[] getCombination() {
        return (Punch[]) punchCombination.toArray();
    }

    public String getName() {
        return name;
    }

    public void addPunch(Punch punch) {
        if (punch == null)
            throw new IllegalArgumentException("punch is null");

        punchCombination.add(punch);
    }

    public void doCombination() {
        while (punchCombination.size() > 0) {
            punchCombination.get(0).doHit(this);
            punchCombination.remove(0);
        }
    }

    void doFistPunch() {
        System.out.println(name + " бах");
    }

    void doLegPunch() {
        System.out.println(name + " бдыщ");
    }

    void doJumpPunch() {
        System.out.println(name + " вжух");
    }

    public void removePunch(int index) {
        punchCombination.remove(index);
    }
}
