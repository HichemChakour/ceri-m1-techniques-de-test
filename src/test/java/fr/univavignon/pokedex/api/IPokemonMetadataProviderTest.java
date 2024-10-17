package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider pokemonMetadataProvider ;



    @Before
    public void initTestpokemonMetadata() {
        pokemonMetadataProvider =  Mockito.mock( IPokemonMetadataProvider.class );
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata Bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        PokemonMetadata Aquali =new PokemonMetadata(186,"Aquali",168,168,260);

        Mockito.when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(Bulbizarre);
        Mockito.when(pokemonMetadataProvider.getPokemonMetadata(186)).thenReturn(Aquali);

        assert(pokemonMetadataProvider.getPokemonMetadata(0).getName().equals("Bulbizarre"));
        assert(pokemonMetadataProvider.getPokemonMetadata(186).getName().equals("Aquali"));

        assert(pokemonMetadataProvider.getPokemonMetadata(0).getAttack() == 126);
        assert(pokemonMetadataProvider.getPokemonMetadata(186).getAttack() == 168);

        assert(pokemonMetadataProvider.getPokemonMetadata(0).getDefense() == 126);
        assert(pokemonMetadataProvider.getPokemonMetadata(186).getDefense() == 168);

        assert(pokemonMetadataProvider.getPokemonMetadata(0).getStamina() == 90);
        assert(pokemonMetadataProvider.getPokemonMetadata(186).getStamina() == 260);


    }

}
