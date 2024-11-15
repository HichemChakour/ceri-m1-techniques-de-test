package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
/**
 * Pokemon PokemonMetadataProvider.
 *
 * @author Hichem Chakour
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private final Map<Integer, PokemonMetadata> metadataMap;

    /**
     * Default constructor.
     */
    public PokemonMetadataProvider() {
        this.metadataMap = new HashMap<>();
        metadataMap.put(0, new PokemonMetadata(0, "Bulbasaur", 126, 126, 90));
        metadataMap.put(1, new PokemonMetadata(1, "Ivysaur", 156, 158, 120));
    }

    /**
     * Get Pokemon metadata from the index.
     *
     * @param index Pokemon index.
     * @return Pokemon metadata.
     * @throws PokedexException If the given index is invalid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!metadataMap.containsKey(index)) {
            throw new PokedexException("Invalid Pokemon index: " + index);
        }
        return metadataMap.get(index);
    }

}
