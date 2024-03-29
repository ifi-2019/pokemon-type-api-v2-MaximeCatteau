package com.ifi.tp.pokemon_type_api.repository;

import com.ifi.tp.pokemon_type_api.bo.PokemonType;

import java.util.List;

public interface PokemonTypeRepository {
    PokemonType findPokemonTypeById(int id);
    PokemonType findPokemonTypeByName(String name);
    List<PokemonType> findPokemonTypeWithTypes(String type1, String type2);
    List<PokemonType> findAllPokemonType();
}
