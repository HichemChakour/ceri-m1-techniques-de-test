package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Objects;

public class IPokedexTest {

    IPokedex pokedex;

    @Before
    public void initTestPokedex() {
        pokedex =  Mockito.mock( IPokedex.class );
    }

    @Test
    public void testSize() {
        Mockito.when(pokedex.size()).thenReturn(0);
        assert(pokedex.size() == 0);

        Mockito.when(pokedex.size()).thenReturn(2);
        assert(pokedex.size() == 2);

    }

    @Test
    public void testAddPokemon() {
        Pokemon Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 4);
        Pokemon Aquali = new Pokemon(186, "Aquali", 168, 168, 260, 2729, 202, 5000, 4, 4);

        Mockito.when(pokedex.addPokemon(Bulbizarre)).thenReturn(0);
        Mockito.when(pokedex.addPokemon(Aquali)).thenReturn(186);

        assert(pokedex.addPokemon(Bulbizarre) == 0);
        assert(pokedex.addPokemon(Aquali) == 186);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 4);
        Pokemon Aquali = new Pokemon(186, "Aquali", 168, 168, 260, 2729, 202, 5000, 4, 4);

        Mockito.when(pokedex.getPokemon(0)).thenReturn(Bulbizarre);
        Mockito.when(pokedex.getPokemon(186)).thenReturn(Aquali);

        assert(pokedex.getPokemon(0).getName().equals("Bulbizarre"));
        assert(pokedex.getPokemon(186).getName().equals("Aquali"));

        assert(pokedex.getPokemon(0).getIndex() == 0);
        assert(pokedex.getPokemon(186).getIndex() == 186);

        assert(pokedex.getPokemon(0).getCp() == 613);
        assert(pokedex.getPokemon(186).getCp() == 2729);

        assert(pokedex.getPokemon(0).getHp() == 64);
        assert(pokedex.getPokemon(186).getHp() == 202);

        assert(pokedex.getPokemon(0).getDust() == 4000);
        assert(pokedex.getPokemon(186).getDust() == 5000);

        assert(pokedex.getPokemon(0).getCandy() == 4);
        assert(pokedex.getPokemon(186).getCandy() == 4);
    }

    @Test
    public void testGetPokemons() {
        Pokemon Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 4);
        Pokemon Aquali = new Pokemon(186, "Aquali", 168, 168, 260, 2729, 202, 5000, 4, 4);

        pokedex.addPokemon(Bulbizarre);
        pokedex.addPokemon(Aquali);

        Mockito.when(pokedex.getPokemons()).thenReturn(new ArrayList<Pokemon>() {{
            add(Bulbizarre);
            add(Aquali);
        }});
        assert(Objects.equals(pokedex.getPokemons(), new ArrayList<Pokemon>() {{
            add(Bulbizarre);
            add(Aquali);
        }}));
    }
}
