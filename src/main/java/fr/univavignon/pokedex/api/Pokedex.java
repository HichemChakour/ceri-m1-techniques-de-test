package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implementation of the IPokedex interface.
 *
 * @author Hichem Chakour
 */
public class Pokedex implements IPokedex {
    private final List<Pokemon> pokemons;
    private final IPokemonMetadataProvider metadataProvider;
    private final IPokemonFactory pokemonFactory;

    /**
     * Constructor for Pokedex.
     *
     * @param metadataProvider An instance of IPokemonMetadataProvider.
     * @param pokemonFactory   An instance of IPokemonFactory.
     */
    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory, List<Pokemon> pokemons) {
        this.pokemons = pokemons;
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemon.getIndex();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 ) {
            throw new PokedexException("Invalid Pokemon index: " + id);
        }
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getIndex() == id) {
                return pokemon;
            }
        }
        throw new PokedexException("Invalid Pokemon index: " + id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemons);
        sortedList.sort(order);
        return Collections.unmodifiableList(sortedList);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }
}
