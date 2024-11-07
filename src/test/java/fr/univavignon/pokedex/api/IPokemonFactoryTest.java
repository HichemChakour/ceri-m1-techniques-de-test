package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    IPokemonFactory pokemonFactory;

    @Before
    public void initTestpokemonFactory() {
        pokemonFactory =  new PokemonFactory();
    }

    @Test
    public void testCreatePokemon() {


        Pokemon Bulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(Bulbizarre);
        assertEquals(0, Bulbizarre.getIndex());
        assertEquals("Pokemon0", Bulbizarre.getName());
        assertEquals(613, Bulbizarre.getCp());
        assertEquals(64, Bulbizarre.getHp());
        assertEquals(4000, Bulbizarre.getDust());
        assertEquals(4, Bulbizarre.getCandy());
        assertTrue(Bulbizarre.getIv() >= 0 && Bulbizarre.getIv() <= 100);

        Pokemon Aquali = pokemonFactory.createPokemon(186, 2729, 202, 5000, 4);
        assertNotNull(Aquali);
        assertEquals(186, Aquali.getIndex());
        assertEquals("Pokemon186", Aquali.getName());
        assertEquals(2729, Aquali.getCp());
        assertEquals(202, Aquali.getHp());
        assertEquals(5000, Aquali.getDust());
        assertEquals(4, Aquali.getCandy());
        assertTrue(Aquali.getIv() >= 0 && Aquali.getIv() <= 100);
    }
}
