package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

public class IPokedexTest {

    Pokedex pokedex;
    Pokemon Bulbizarre ;
    Pokemon Aquali;

    @Before
    public void initTestPokedex() {
         Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 4);
         Aquali = new Pokemon(186, "Aquali", 168, 168, 260, 2729, 202, 5000, 4, 4);
    }

    @Test
    public void testSize() {

        pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory(), new ArrayList<>());

        assert(pokedex.size() == 0);
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>() {{
            add(Bulbizarre);
            add(Aquali);
        }};

        pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory(), pokemons);



        assert(pokedex.size() == 2);

    }

    @Test
    public void testAddPokemon() {

        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>() {{
            add(Bulbizarre);
            add(Aquali);
        }};

        pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory(), pokemons);

        assert(pokedex.addPokemon(Bulbizarre) == 0);
        assert(pokedex.addPokemon(Aquali) == 186);
    }

    @Test
    public void testGetPokemon() throws PokedexException {

        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>() {{
            add(Bulbizarre);
            add(Aquali);
        }};

        pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory(), pokemons);

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

        assert(pokedex.getPokemon(0).getIv() == 4);
        assert(pokedex.getPokemon(186).getIv() == 4);
    }

    @Test
    public void testGetPokemons() {

        pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory(), new ArrayList<>());

        pokedex.addPokemon(Bulbizarre);
        pokedex.addPokemon(Aquali);

        assert(Objects.equals(pokedex.getPokemons(), new ArrayList<Pokemon>() {{
            add(Bulbizarre);
            add(Aquali);
        }}));
    }
}
