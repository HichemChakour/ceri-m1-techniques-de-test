package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory;
    IPokemonFactory pokemonFactory;
    IPokemonMetadataProvider metadataProvider;

    @Before
    public void initTestPokedexFactory() {
        pokedexFactory = new PokedexFactory();
        pokemonFactory = new PokemonFactory();
        metadataProvider = new PokemonMetadataProvider();
    }

    @Test
    public void testCreatePokedex() {
        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(createdPokedex);
        assertTrue(createdPokedex instanceof Pokedex);
    }
}
