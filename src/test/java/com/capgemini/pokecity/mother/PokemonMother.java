package com.capgemini.pokecity.mother;

import com.capgemini.pokecity.model.PokemonByCity;

public class PokemonMother {

    public static PokemonByCity getPokemonByCityWithoutPokemonNoRaining(){
        PokemonByCity pokemonByCity = new PokemonByCity();
        pokemonByCity.setTemperature("25ºC");
        pokemonByCity.setRaining(false);
        return pokemonByCity;
    }

    public static PokemonByCity getPokemonByCityWithoutPokemonRaining(){
        PokemonByCity pokemonByCity = new PokemonByCity();
        pokemonByCity.setTemperature("25ºC");
        pokemonByCity.setRaining(true);
        return pokemonByCity;
    }

    public static PokemonByCity getPokemonByCityCompleteNoRaining(){
        PokemonByCity pokemonByCity = new PokemonByCity();
        pokemonByCity.setTemperature("20ºC");
        pokemonByCity.setRaining(false);
        pokemonByCity.setPokemonName("charizard");
        return pokemonByCity;
    }

    public static PokemonByCity getPokemonByCityCompleteRaining(){
        PokemonByCity pokemonByCity = new PokemonByCity();
        pokemonByCity.setTemperature("20ºC");
        pokemonByCity.setRaining(true);
        pokemonByCity.setPokemonName("pikachu");
        return pokemonByCity;
    }

}
