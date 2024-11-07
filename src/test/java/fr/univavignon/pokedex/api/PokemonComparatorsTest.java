package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class PokemonComparatorsTest {

    Pokedex pokedex;
    Pokemon Bulbizarre;
    Pokemon Aquali;

    @Before
    public void initTestPokedex() {
        Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 4);
        Aquali = new Pokemon(186, "Aquali", 168, 168, 260, 2729, 202, 5000, 4, 4);
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>() {{
            add(Bulbizarre);
            add(Aquali);
        }};
        pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory(), pokemons);
    }

    @Test
    public void testPokemonComparators() {
        List<Pokemon> sortedByName = pokedex.getPokemons(PokemonComparators.NAME);
        assertEquals(Bulbizarre, sortedByName.get(1));
        assertEquals(Aquali, sortedByName.get(0));

        List<Pokemon> sortedByIndex = pokedex.getPokemons(PokemonComparators.INDEX);
        assertEquals(Bulbizarre, sortedByIndex.get(0));
        assertEquals(Aquali, sortedByIndex.get(1));

        List<Pokemon> sortedByCp = pokedex.getPokemons(PokemonComparators.CP);
        assertEquals(Aquali, sortedByCp.get(1));
        assertEquals(Bulbizarre, sortedByCp.get(0));
    }
}
