package fr.univavignon.pokedex.api;

import java.util.ArrayList;

/**
 * Implementation of the IPokedexFactory interface.
 *
 * @author Hichem Chakour
 */
public class PokedexFactory implements IPokedexFactory {
    /**
     * Creates a new Pokedex instance using the given metadataProvider and pokemonFactory.
     *
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory   Pokemon factory the created pokedex will use.
     * @return Created Pokedex instance.
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
          return new Pokedex(metadataProvider, pokemonFactory, new ArrayList<>());
    }
}
