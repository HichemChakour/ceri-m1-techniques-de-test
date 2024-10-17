package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory pokemonTrainerFactory;
    IPokedexFactory pokedexFactory;

    IPokedex pokedex;


    @Before
    public void initTestPokemonTrainerFactory() {
        pokemonTrainerFactory =  Mockito.mock( IPokemonTrainerFactory.class );
        pokedexFactory =  Mockito.mock( IPokedexFactory.class );
        pokedexFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class));
        pokedex =  Mockito.mock( IPokedex.class );
    }

    @Test
    public void testCreateTrainer() {

        Pokemon Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 4);
        Pokemon Aquali = new Pokemon(186, "Aquali", 168, 168, 260, 2729, 202, 5000, 4, 4);

        Mockito.when(pokedex.addPokemon(Bulbizarre)).thenReturn(0);
        Mockito.when(pokedex.addPokemon(Aquali)).thenReturn(186);

        PokemonTrainer pokemonTrainer = new PokemonTrainer("Hichem", Team.MYSTIC, pokedex);

        Mockito.when(pokemonTrainerFactory.createTrainer("Hichem", Team.MYSTIC, pokedexFactory)).thenReturn(pokemonTrainer);

        assert(pokemonTrainer.getName().equals("Hichem"));
        assert(pokemonTrainer.getTeam().equals(Team.MYSTIC));
        assert(pokemonTrainer.getPokedex() == pokedex);
    }

}
