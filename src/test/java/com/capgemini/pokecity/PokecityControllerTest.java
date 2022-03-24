package com.capgemini.pokecity;

import com.capgemini.pokecity.controllers.PokecityController;
import com.capgemini.pokecity.exception.URLException;
import com.capgemini.pokecity.model.PokemonByCity;
import com.capgemini.pokecity.services.PokemonService;
import com.capgemini.pokecity.services.WeatherService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static com.capgemini.pokecity.mother.PokemonMother.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PokecityControllerTest {

    @InjectMocks
    private PokecityController pokecityController;

    @Mock
    private WeatherService weatherService;

    @Mock
    private PokemonService pokemonService;

    @Test
    public void shouldFindNotEletricPokemon() throws URLException {
        PokemonByCity pokemonByCityWithoutPokemon = getPokemonByCityCompleteNoRaining();
        PokemonByCity pokemonByCityComplete = getPokemonByCityCompleteNoRaining();

        when(weatherService.getWeather(any(String.class))).thenReturn(pokemonByCityWithoutPokemon);
        when(pokemonService.getPokemon(any(PokemonByCity.class))).thenReturn(pokemonByCityComplete);

        ResponseEntity<PokemonByCity> controllerReturn = pokecityController.getPokemonByCity("Guarulhos");
        assertEquals(controllerReturn.getBody().getPokemonName(),(pokemonByCityComplete.getPokemonName()));
        verify(weatherService,times(1)).getWeather(any(String.class));
    }

    @Test
    public void shouldFindEletricPokemon() throws URLException {
        PokemonByCity pokemonByCityWithoutPokemon = getPokemonByCityWithoutPokemonRaining();
        PokemonByCity pokemonByCityComplete = getPokemonByCityCompleteRaining();

        when(weatherService.getWeather(any(String.class))).thenReturn(pokemonByCityWithoutPokemon);
        when(pokemonService.getPokemon(any(PokemonByCity.class))).thenReturn(pokemonByCityComplete);

        ResponseEntity<PokemonByCity> controllerReturn = pokecityController.getPokemonByCity("Guarulhos");
        assertTrue(controllerReturn.getBody().getPokemonName().equals(pokemonByCityComplete.getPokemonName()));
        verify(weatherService,times(1)).getWeather(any(String.class));
    }

    @Test
    public void shouldNotFindCity() throws URLException {
        when(weatherService.getWeather(any(String.class))).thenThrow(URLException.class);
        ResponseEntity<PokemonByCity> controllerReturn = pokecityController.getPokemonByCity("NOT A DECLARED CITY");
        assertEquals(controllerReturn.getStatusCodeValue(), 404);
    }

}
