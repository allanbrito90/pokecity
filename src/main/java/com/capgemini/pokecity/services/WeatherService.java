package com.capgemini.pokecity.services;

import com.capgemini.pokecity.exception.URLException;
import com.capgemini.pokecity.model.PokemonByCity;
import com.capgemini.pokecity.dto.weather.RootWeatherDto;
import com.capgemini.pokecity.utils.RestUtils;
import com.capgemini.pokecity.utils.WeatherUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherService.class);

    @Value("${api.weather}")
    private String url;

    @Value("${api.weatherkey}")
    private String chave;

    public PokemonByCity getWeather(String cityName) throws URLException {
        StringBuilder completeUrl = new StringBuilder(url).append("?q=").append(cityName).append("&appid=").append(chave).append("&units=metric");
        LOGGER.info("Searching for Pokemon for " + cityName);
        RootWeatherDto rootWeather = (RootWeatherDto) RestUtils.getRestResponse(completeUrl.toString(), RootWeatherDto.class);

        PokemonByCity pokeCity = new PokemonByCity();
        pokeCity.setRaining(rootWeather.getWeather().get(0).getMain().equals("Rain"));
        pokeCity.setTemperature(WeatherUtils.convertToCelsiusFormat(rootWeather.getMain().getTemp()));

        LOGGER.info("Found temperature: " + pokeCity.getTemperature());
        LOGGER.info("Raining: " + pokeCity.isRaining());

        return pokeCity;
    }

}
