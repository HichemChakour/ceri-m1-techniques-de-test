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

    /**
     * Size Pokedex.
     *
     * @return An instance of Pokedex.
     */
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * Add Pokedex.
     *
     * @return An instance of Pokedex.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemon.getIndex();
    }

    /**
     * Get Pokemon.
     *
     * @param id Pokemon index.
     * @return An instance of Pokemon.
     */
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

    /**
     * Get Pokemons.
     *
     * @return A list of Pokemons.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    /**
     * Get Pokemons.
     *
     * @param order Comparator.
     * @return A list of Pokemons.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemons);
        sortedList.sort(order);
        return Collections.unmodifiableList(sortedList);
    }

    /**
     * Get PokemonMetadata.
     *
     * @param index Pokemon index.
     * @return An instance of PokemonMetadata.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

    /**
     * Create Pokemon.
     *
     * @param index Pokemon index.
     * @param cp Pokemon CP.
     * @param hp Pokemon HP.
     * @param dust Required dust.
     * @param candy Required candy.
     * @return An instance of Pokemon.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }
}
