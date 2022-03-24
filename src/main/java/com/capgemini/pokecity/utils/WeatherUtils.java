package com.capgemini.pokecity.utils;

import java.text.DecimalFormat;

public class WeatherUtils {
    private static final String CELSIUS_SYMBOL = "ºC";
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static String convertToCelsiusFormat(double temp){
        return df.format(temp) + CELSIUS_SYMBOL;
    }

}
