package com.example;

import java.util.List;

public class LionAlex extends Lion {
    private boolean hasMane;
    private String placeOfLiving;

    public LionAlex(String sex, Feline feline) throws Exception {
        super(sex, feline);
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else {
            throw new Exception("Используйте допустимые значения пола животного. Лев Алекс - Самец ");
        }

    }
    @Override
    public int getKittens() {
        return 0;
    }
    @Override
    public boolean doesHaveMane (){
        return hasMane ;
    }
    @Override
     public List<String> getFood() throws Exception {
         return super.getFood();
     }
     public List<String> getFriends(){
        return List.of("Зебра Марти"," Бегемотиха Глория","Жираф Мелман");
     }
     public String getPlaceOfLiving(){
        placeOfLiving = "Нью-Йорский зоопарк";
        return placeOfLiving ;
     }
}
