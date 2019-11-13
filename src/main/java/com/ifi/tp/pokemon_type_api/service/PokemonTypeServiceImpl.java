package com.ifi.tp.pokemon_type_api.service;

import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import com.ifi.tp.pokemon_type_api.repository.PokemonTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    PokemonTypeRepository pokemonTypeRepository;

    public PokemonTypeServiceImpl(PokemonTypeRepository pokemonTypeRepository){ // TODO
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    @Override
    public PokemonType getPokemonType(int id) {
        // TODO
        return pokemonTypeRepository.findPokemonTypeById(id);

    }

    @Override
    public PokemonType getPokemonType(String name) {
        return pokemonTypeRepository.findPokemonTypeByName(name);
    }

    @Override
    public List<PokemonType> getPokemonTypeWithTypes(List<String> types) {
        String type1 = types.get(0), type2 = null;
        if(types.size() == 2){
            type2 = types.get(1);
        }

        return pokemonTypeRepository.findPokemonTypeWithTypes(type1, type2);
    }

    @Override
    public List<PokemonType> getAllPokemonTypes(){
        // TODO
        return pokemonTypeRepository.findAllPokemonType();
    }
}
