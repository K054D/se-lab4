package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }
    @Test
    void fire_Failure_Rate() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 1.0);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(false, result);
        assertEquals(1, store.getTorpedoCount());
    }

    @Test
    void fire_IllegalArgument_TooMany() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        assertThrows(IllegalArgumentException.class, () -> {
        store.fire(2);
        });
    }

    @Test
    void fire_IllegalArgument_LessThanOne() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act & Assert - 1-nél kevesebbet (0-t) akarunk lőni
        assertThrows(IllegalArgumentException.class, () -> {
        store.fire(0);
        });
    }

    @Test
    void isEmpty_True() {
        // Arrange - 0 torpedóval hozzuk létre
        TorpedoStore store = new TorpedoStore(0);

        // Act & Assert
        assertTrue(store.isEmpty());
    }
    
    @Test
    void isEmpty_False() {
        // Arrange - 1 torpedóval hozzuk létre
        TorpedoStore store = new TorpedoStore(1);

        // Act & Assert
        assertFalse(store.isEmpty());
    }
    
}
