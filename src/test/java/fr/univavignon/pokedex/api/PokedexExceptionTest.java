package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class PokedexExceptionTest {

    @Test
    public void testPokedexExceptionMessage() {
        // Le message d'erreur que nous voulons tester
        String errorMessage = "Test error message";

        // Création de l'exception avec le message d'erreur
        PokedexException exception = new PokedexException(errorMessage);

        // Vérification que le message est bien passé au constructeur de Exception
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void testPokedexExceptionThrown() {
        // Vérifie que l'exception est bien lancée avec le bon message
        String errorMessage = "Another test error message";

        Exception exception = assertThrows(PokedexException.class, () -> {
            throw new PokedexException(errorMessage);
        });

        // Vérifie que le message d'erreur correspond bien à ce qui a été passé dans le constructeur
        assertEquals(errorMessage, exception.getMessage());
    }
}
