package com.ifi.tp.pokemon_type_api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTypeRepositoryImplTest {

    private PokemonTypeRepositoryImpl repository = new PokemonTypeRepositoryImpl();

    @Test
    void findPokemonTypeById_with25_shouldReturnPikachu(){
        var pikachu = repository.findPokemonTypeById(25);
        assertNotNull(pikachu);
        assertEquals("pikachu", pikachu.getName());
        assertEquals(25, pikachu.getId());
    }

    @Test
    void findPokemonTypeById_with145_shouldReturnZapdos(){
        var zapdos = repository.findPokemonTypeById(145);
        assertNotNull(zapdos);
        assertEquals("zapdos", zapdos.getName());
        assertEquals(145, zapdos.getId());
    }

    @Test
    void findPokemonTypeByName_withEevee_shouldReturnEevee(){
        var eevee = repository.findPokemonTypeByName("eevee");
        assertNotNull(eevee);
        assertEquals("eevee", eevee.getName());
        assertEquals(133, eevee.getId());
    }

    @Test
    void findPokemonTypeByName_withMewTwo_shouldReturnMewTwo(){
        var mewtwo = repository.findPokemonTypeByName("mewtwo");
        assertNotNull(mewtwo);
        assertEquals("mewtwo", mewtwo.getName());
        assertEquals(150, mewtwo.getId());
    }

    @Test
    void findPokemonTypeWithTypeElectric(){
        var electricPokemons = repository.findPokemonTypeWithTypes("electric", null);
        var pikachu = repository.findPokemonTypeByName("pikachu");
        var zapdos = repository.findPokemonTypeByName("zapdos");
        var mew = repository.findPokemonTypeByName("mew");
        assertEquals(9, electricPokemons.size());
        assertTrue(electricPokemons.contains(pikachu)); // type electric
        assertTrue(electricPokemons.contains(zapdos)); // type electric/fly
        assertFalse(electricPokemons.contains(mew)); // type psy
    }

    @Test
    void findPokemonTypeWithTypeDragonAndFly(){
        var dragonFlyPokemons = repository.findPokemonTypeWithTypes("dragon", "flying");
        var pikachu = repository.findPokemonTypeByName("pikachu");
        var dragonite = repository.findPokemonTypeByName("dragonite");
        var dratini = repository.findPokemonTypeByName("dratini");

        assertEquals(1, dragonFlyPokemons.size());
        assertFalse(dragonFlyPokemons.contains(pikachu)); // type electric
        assertTrue(dragonFlyPokemons.contains(dragonite)); // type dragon/fly
        assertFalse(dragonFlyPokemons.contains(dratini)); // type dragon
    }

    @Test
    void findAllPokemonType_shouldReturn151Pokemons(){
        var pokemons = repository.findAllPokemonType();
        assertNotNull(pokemons);
        assertEquals(151, pokemons.size());
    }

    @Test
    void applicationContext_shouldLoadPokemonRepository(){

        var context = new AnnotationConfigApplicationContext("com.ifi.tp.pokemon_type_api.repository");
        var repoByName = context.getBean("pokemonTypeRepositoryImpl");
        var repoByClass = context.getBean(PokemonTypeRepository.class);

        assertEquals(repoByName, repoByClass);
        assertNotNull(repoByName);
        assertNotNull(repoByClass);
    }

}