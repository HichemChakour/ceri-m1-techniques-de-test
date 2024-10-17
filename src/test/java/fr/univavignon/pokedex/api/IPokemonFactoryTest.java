package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class IPokemonFactoryTest {

    IPokemonFactory pokemonFactory;

    @Before
    public void initTestpokemonFactory() {
        pokemonFactory =  Mockito.mock( IPokemonFactory.class );
    }

    @Test
    public void testCreatePokemon() {
        Pokemon Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 4);
        Pokemon Aquali = new Pokemon(186, "Aquali", 168, 168, 260, 2729, 202, 5000, 4, 4);

        Mockito.when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(Bulbizarre);
        Mockito.when(pokemonFactory.createPokemon(186, 2729, 202, 5000, 4)).thenReturn(Aquali);

        assert (pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getName().equals("Bulbizarre"));
        assert (pokemonFactory.createPokemon(186, 2729, 202, 5000, 4).getName().equals("Aquali"));

        assert (pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getIndex() == 0);
        assert (pokemonFactory.createPokemon(186, 2729, 202, 5000, 4).getIndex() == 186);

        assert (pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCp() == 613);
        assert (pokemonFactory.createPokemon(186, 2729, 202, 5000, 4).getCp() == 2729);

        assert (pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getHp() == 64);
        assert (pokemonFactory.createPokemon(186, 2729, 202, 5000, 4).getHp() == 202);

        assert (pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getDust() == 4000);
        assert (pokemonFactory.createPokemon(186, 2729, 202, 5000, 4).getDust() == 5000);

        assert (pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCandy() == 4);
        assert (pokemonFactory.createPokemon(186, 2729, 202, 5000, 4).getCandy() == 4);
    }
}
