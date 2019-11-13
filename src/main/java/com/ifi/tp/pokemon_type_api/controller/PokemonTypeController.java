package com.ifi.tp.pokemon_type_api.controller;

import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import com.ifi.tp.pokemon_type_api.service.PokemonTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon-types")
public class PokemonTypeController {

    PokemonTypeService pokemonTypeService;

    public PokemonTypeController(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }

    @GetMapping("/{id}")
    PokemonType getPokemonTypeFromId(@PathVariable int id){
        // TODO
        return pokemonTypeService.getPokemonType(id);
    }

    @GetMapping(value = "/", params = "name")
    PokemonType getPokemonTypeFromName(@RequestParam("name") String name){
        return pokemonTypeService.getPokemonType(name);
    }

    @GetMapping(value = "/", params = "types")
    public List<PokemonType> getPokemonTypeWithTypes(@RequestParam("types") List<String> types){
        return pokemonTypeService.getPokemonTypeWithTypes(types);
    }

    @GetMapping("/")
    public List<PokemonType> getAllPokemonTypes() {
        // TODO
        return pokemonTypeService.getAllPokemonTypes();
    }
}
