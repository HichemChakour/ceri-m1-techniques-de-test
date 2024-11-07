package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class PokedexExceptionTest {

    @Test
    public void testPokedexExceptionMessage() {

        String errorMessage = "Test error message";

        PokedexException exception = new PokedexException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void testPokedexExceptionThrown() {
        String errorMessage = "Another test error message";

        Exception exception = assertThrows(PokedexException.class, () -> {
            throw new PokedexException(errorMessage);
        });

        assertEquals(errorMessage, exception.getMessage());
    }
}
