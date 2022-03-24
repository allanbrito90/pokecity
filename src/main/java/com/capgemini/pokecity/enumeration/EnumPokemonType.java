package com.capgemini.pokecity.enumeration;

public enum EnumPokemonType {
    NORMAL(1),
    GROUND(5),
    ROCK(6),
    BUG(7),
    FIRE(10),
    WATER(11),
    GRASS(12),
    ELECTRIC(13),
    ICE(15);

    private Integer code;

    EnumPokemonType(Integer code){
        this.code = code;
    };

    public Integer getCode() {
        return code;
    }
}
