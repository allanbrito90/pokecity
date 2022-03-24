package com.capgemini.pokecity.utils;

import java.util.Random;

public class PokemonUtils {
    private static final Random random = new Random();

    public static Integer getRandomNumber(int maxnumber){
        return random.nextInt(maxnumber);
    }

    public static double convertTotemperature(String tempStringformat){
        return Double.parseDouble(tempStringformat.substring(0,tempStringformat.length()-2).replace(",","."));
    }
}
