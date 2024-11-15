package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private final Map<Integer, PokemonMetadata> metadataMap;

    public PokemonMetadataProvider() {
        this.metadataMap = new HashMap<>();
        metadataMap.put(0, new PokemonMetadata(0, "Bulbasaur", 126, 126, 90));
        metadataMap.put(1, new PokemonMetadata(1, "Ivysaur", 156, 158, 120));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!metadataMap.containsKey(index)) {
            throw new PokedexException("Invalid Pokemon index: " + index);
        }
        return metadataMap.get(index);
    }

}
