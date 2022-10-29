package com.example;

import java.util.List;

public class  Lion  {
    private Joeys joeys;
    private Predator predator;
    boolean hasMane;

    public Lion(String sex, Feline feline) throws Exception {
        this.joeys = feline;
        this.predator = feline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - Самец или Самка");
        }
    }

    public int getKittens() {
        return joeys.getKittens();
    }
    public int getKittens(int kittensCount) {
        return kittensCount;
    }


    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}
