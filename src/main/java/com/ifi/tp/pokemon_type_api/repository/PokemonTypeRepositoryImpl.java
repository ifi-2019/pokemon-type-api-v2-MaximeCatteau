package com.ifi.tp.pokemon_type_api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PokemonTypeRepositoryImpl implements PokemonTypeRepository {

    private List<PokemonType> pokemons;

    public PokemonTypeRepositoryImpl() {
        try {
            var pokemonsStream = new ClassPathResource("pokemons.json").getInputStream();

            var objectMapper = new ObjectMapper();
            var pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PokemonType findPokemonTypeById(int id) {
        System.out.println("Loading Pokemon information for Pokemon id " + id);

        // TODO
        for(PokemonType p : pokemons){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public PokemonType findPokemonTypeByName(String name) {
        System.out.println("Loading Pokemon information for Pokemon name " + name);

        // TODO
        for(PokemonType p : pokemons){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<PokemonType> findPokemonTypeWithTypes(String type1, String type2) {
        List<PokemonType> finalList = new ArrayList<>();

        for(PokemonType p : pokemons){
            if(type2 == null){
                if(p.getTypes().contains(type1)){
                    finalList.add(p);
                }
            } else {
                if(p.getTypes().contains(type1) && p.getTypes().contains(type2)){
                    finalList.add(p);
                }
            }
        }

        return finalList;
    }

    @Override
    public List<PokemonType> findAllPokemonType() {
        // TODO
        return pokemons;
    }
}