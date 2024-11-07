package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory pokemonTrainerFactory;
    IPokedexFactory pokedexFactory;


    @Before
    public void initTestPokemonTrainerFactory() {
        pokemonTrainerFactory =  new PokemonTrainerFactory();
        pokedexFactory =  new PokedexFactory();
    }

    @Test
    public void testCreateTrainer() {

        PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer("Hichem", Team.MYSTIC, pokedexFactory);

        assertNotNull(pokemonTrainer);
        assertEquals("Hichem", pokemonTrainer.getName());
        assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
        assertNotNull(pokemonTrainer.getPokedex());
    }

}
