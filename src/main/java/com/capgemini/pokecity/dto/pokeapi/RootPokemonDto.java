package com.capgemini.pokecity.dto.pokeapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class RootPokemonDto {
    @JsonProperty("pokemon")
    public ArrayList<SinglePokemonDto> pokemon;
}
