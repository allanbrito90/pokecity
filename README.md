## Pokecity

API REST to find the best Pokémon based on the weather of a selected city.

All you need to do is call a endpoint telling what city you want to know. The system will select a random Pokémon in different category.

## Technologies Used

- Java <img align="center" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" />  
- Spring Framework <img align="center" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg" />
- GitHub <img align="center" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original-wordmark.svg" />
- Swagger
- JUnit
- Mockito
- Lombok

## Running

- Download the source code
- Open GitBash anmd navigate to the project's root directory
- Type ` mvn clean install `
- Navigate to target/ directory and type `java -jar Pokecity.jar`

This API runs on port 8080.

## Endpoint

#### `http://{YourIP}:8080/pokecity/{city}`

Where:
- YourIP: Host IP (commonly localhost)
- city: Name of the City

OR

#### `http://{YourIP}:8080/swagger-ui.html`

To use endpoint by SWAGGER

## Result

Result will be:

~~~~JSON
{
    "temperatura": "0,00°C",
    "chovendo": false,
    "nome_pokemon": "pokemonName"
}
~~~~

Where:
- temperatura : Temperature of the city (degrees Celsius (°C))
- chovendo : If is raining or not
- nome_pokemon : Name of the Pokémon

## Conditions

The Pokémon will be selected following the criteria of temperature (and weather):
- If the temperature is below 5°C, the Pokémon selected it'll be of type ICE.
- If the temperature is between 5°C and 10°C, the Pokémon selected it'll be of type WATER.
- If the temperature is between 12°C and 15°C, the Pokémon selected it'll be of type GRASS.
- If the temperature is between 15°C and 21°C, the Pokémon selected it'll be of type GROUND.
- If the temperature is between 23°C and 27°C, the Pokémon selected it'll be of type BUG.
- If the temperature is between 27°C and 33°C, the Pokémon selected it'll be of type ROCK.
- If the temperature is above 33°C, the Pokémon selected it'll be of type FIRE.
- If the temperature is none of listed above, the Pokémon selected it'll be of type NORMAL.
- If is raining in the city, the Pokémon selected it'll be of type ELECTRIC.
