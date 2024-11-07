package fr.univavignon.pokedex.api;

/**
 * Implementation of the IPokemonFactory interface.
 *
 * @author Hichem Chakour
 */
public class PokemonFactory implements IPokemonFactory {

    /**
     * Creates a Pokemon instance computing its IVs.
     *
     * @param index Pokemon index.
     * @param cp Pokemon CP.
     * @param hp Pokemon HP.
     * @param dust Required dust for upgrading Pokemon.
     * @param candy Required candy for upgrading Pokemon.
     * @return Created Pokemon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // For simplicity, we'll use random values for individual values (IVs) here.
        double iv = Math.random() * 100.0; // IV is usually a percentage between 0 and 100.
        return new Pokemon(index, "Pokemon" + index, 0, 0, 0, cp, hp, dust, candy, iv);
    }
}
