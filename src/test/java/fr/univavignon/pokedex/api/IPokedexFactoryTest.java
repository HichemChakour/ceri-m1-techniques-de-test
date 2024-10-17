package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory;
    IPokedex pokedex;

    IPokemonFactory pokemonFactory;

    IPokemonMetadataProvider  metadataProvider;

    @Before
    public void initTestPokedexFactory() {

        pokedexFactory =  Mockito.mock( IPokedexFactory.class );
        pokedex =  Mockito.mock( IPokedex.class );
        pokemonFactory =  Mockito.mock( IPokemonFactory.class );
        metadataProvider =  Mockito.mock( IPokemonMetadataProvider.class );

    }

    @Test
    public void testCreatePokedex() {

        Mockito.when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        assert(pokedexFactory.createPokedex(metadataProvider, pokemonFactory) == pokedex);

    }
}
