package com.capgemini.pokecity.controllers;

import com.capgemini.pokecity.exception.URLException;
import com.capgemini.pokecity.model.PokemonByCity;
import com.capgemini.pokecity.services.PokemonService;
import com.capgemini.pokecity.services.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokecity")
@Api(value="API REST PokeCity")
@CrossOrigin(origins = "*")
public class PokecityController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PokecityController.class);

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/{city}")
    @ApiOperation(value = "Get Pokemon by City")
    public ResponseEntity<PokemonByCity> getPokemonByCity(@PathVariable String city){
        try {
            PokemonByCity pokemonByCity = weatherService.getWeather(city);
            pokemonByCity = pokemonService.getPokemon(pokemonByCity);
            LOGGER.info("End of search");
            return ResponseEntity.ok(pokemonByCity);
        }catch(URLException e){
            return new ResponseEntity("Error: " + e.getMessage()  , HttpStatus.NOT_FOUND);
        }
    }

}
