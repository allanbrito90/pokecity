package com.capgemini.pokecity.services;

import com.capgemini.pokecity.enumeration.EnumPokemonType;
import com.capgemini.pokecity.exception.URLException;
import com.capgemini.pokecity.model.PokemonByCity;
import com.capgemini.pokecity.dto.pokeapi.RootPokemonDto;
import com.capgemini.pokecity.utils.PokemonUtils;
import com.capgemini.pokecity.utils.RestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.capgemini.pokecity.utils.PokemonUtils.convertTotemperature;

@Service
public class PokemonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PokemonService.class);

    @Value("${api.pokeapi}")
    private String url;

    public PokemonByCity getPokemon(PokemonByCity pokemonByCity) throws URLException {
        StringBuilder completeUrl = new StringBuilder(url).append("/type/").append(getPokemonCode(pokemonByCity).getCode());
        LOGGER.info("Searching for Pokemon for this city");
        RootPokemonDto pokemonList = (RootPokemonDto) RestUtils.getRestResponse(completeUrl.toString(), RootPokemonDto.class);

        Integer randomPokemonNumber= PokemonUtils.getRandomNumber(pokemonList.getPokemon().size());
        pokemonByCity.setPokemonName(pokemonList.getPokemon().get(randomPokemonNumber).getPokemon().getName());
        LOGGER.info("Pokemon Found : " + pokemonByCity.getPokemonName());
        return pokemonByCity;
    }

    private EnumPokemonType getPokemonCode(PokemonByCity pokemonByCity){
        if(pokemonByCity.isRaining()) return EnumPokemonType.ELECTRIC;

        Double temp = convertTotemperature(pokemonByCity.getTemperature());
        if (temp < 5) return EnumPokemonType.ICE;
        else if(temp >= 5 && temp < 10) return EnumPokemonType.WATER;
        else if(temp >= 12 && temp < 15) return EnumPokemonType.GRASS;
        else if(temp >= 15 && temp < 21) return EnumPokemonType.GROUND;
        else if(temp >= 23 && temp < 27) return EnumPokemonType.BUG;
        else if(temp >= 27 && temp < 33) return EnumPokemonType.ROCK;
        else if(temp >= 33) return EnumPokemonType.FIRE;
        else return EnumPokemonType.NORMAL;
    }

}
