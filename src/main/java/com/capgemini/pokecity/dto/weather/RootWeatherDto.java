package com.capgemini.pokecity.dto.weather;

import lombok.Data;

import java.util.ArrayList;

@Data
public class RootWeatherDto {
    private ArrayList<WeatherDto> weather;
    private MainDto main;
}
