package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RocketPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void initTestpokemonFactory() {
        pokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemon() {
        Pokemon bulbasaur = pokemonFactory.createPokemon(1, 613, 64, 4000, 4);
        assertNotNull(bulbasaur);
        assertEquals(1, bulbasaur.getIndex());
        assertEquals("Bulbasaur", bulbasaur.getName());
        assertEquals(613, bulbasaur.getCp());
        assertEquals(64, bulbasaur.getHp());
        assertEquals(4000, bulbasaur.getDust());
        assertEquals(4, bulbasaur.getCandy());
        assertEquals(1, bulbasaur.getIv(), 0.01);


        Pokemon missingNo = pokemonFactory.createPokemon(999, 1000, 100, 5000, 10);
        assertNotNull(missingNo);
        assertEquals(999, missingNo.getIndex());
        assertEquals("MISSINGNO", missingNo.getName());
        assertEquals(1000, missingNo.getCp());
        assertEquals(100, missingNo.getHp());
        assertEquals(5000, missingNo.getDust());
        assertEquals(10, missingNo.getCandy());
        assertEquals(1, missingNo.getIv(), 0.01);


        Pokemon ashPikachu = pokemonFactory.createPokemon(-1, 2000, 150, 3000, 5);
        assertNotNull(ashPikachu);
        assertEquals(-1, ashPikachu.getIndex());
        assertEquals("Ash's Pikachu", ashPikachu.getName());
        assertEquals(2000, ashPikachu.getCp());
        assertEquals(150, ashPikachu.getHp());
        assertEquals(3000, ashPikachu.getDust());
        assertEquals(5, ashPikachu.getCandy());
        assertEquals(0, ashPikachu.getIv(), 0.01);
        assertEquals(1000, ashPikachu.getAttack());
        assertEquals(1000, ashPikachu.getDefense());
        assertEquals(1000, ashPikachu.getStamina());
    }
}
