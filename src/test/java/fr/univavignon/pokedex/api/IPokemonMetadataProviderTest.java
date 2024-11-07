package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void initTestPokemonMetadata() {
        pokemonMetadataProvider = new PokemonMetadataProvider();
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata Bulbasaur = new PokemonMetadata(0, "Bulbasaur", 126, 126, 90);
        PokemonMetadata Ivysaur = new PokemonMetadata(1, "Ivysaur", 156, 158, 120);

        // Test Bulbasaur metadata
        PokemonMetadata fetchedBulbasaur = pokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals(Bulbasaur.getIndex(), fetchedBulbasaur.getIndex());
        assertEquals(Bulbasaur.getName(), fetchedBulbasaur.getName());
        assertEquals(Bulbasaur.getAttack(), fetchedBulbasaur.getAttack());
        assertEquals(Bulbasaur.getDefense(), fetchedBulbasaur.getDefense());
        assertEquals(Bulbasaur.getStamina(), fetchedBulbasaur.getStamina());

        // Test Ivysaur metadata
        PokemonMetadata fetchedIvysaur = pokemonMetadataProvider.getPokemonMetadata(1);
        assertEquals(Ivysaur.getIndex(), fetchedIvysaur.getIndex());
        assertEquals(Ivysaur.getName(), fetchedIvysaur.getName());
        assertEquals(Ivysaur.getAttack(), fetchedIvysaur.getAttack());
        assertEquals(Ivysaur.getDefense(), fetchedIvysaur.getDefense());
        assertEquals(Ivysaur.getStamina(), fetchedIvysaur.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataWithInvalidIndex() throws PokedexException {
        pokemonMetadataProvider.getPokemonMetadata(999); // This should throw an exception
    }
}
