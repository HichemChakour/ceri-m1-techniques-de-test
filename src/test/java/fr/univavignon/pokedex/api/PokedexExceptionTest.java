package fr.univavignon.pokedex.api;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertThrows;

public class PokedexExceptionTest {

    @Test
    public void testPokedexExceptionMessage() {

        String errorMessage = "Test error message";

        PokedexException exception = new PokedexException(errorMessage);

        assert(Objects.equals(exception.getMessage(), errorMessage));
    }

    @Test
    public void testPokedexExceptionThrown() {
        String errorMessage = "Another test error message";

        Exception exception = assertThrows(PokedexException.class, () -> {
            throw new PokedexException(errorMessage);
        });

        assert (Objects.equals(exception.getMessage(), errorMessage));
    }
}
