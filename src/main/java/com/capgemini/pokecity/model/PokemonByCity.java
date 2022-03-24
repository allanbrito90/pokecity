package com.capgemini.pokecity.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PokemonByCity {

    @JsonProperty("temperatura")
    private String temperature;

    @JsonProperty("chovendo")
    private boolean raining;

    @JsonProperty("nome_pokemon")
    private String pokemonName;
}
