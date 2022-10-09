package dynamicArray;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DynamicArrayTest {

    private final DynamicArray<Integer> array = new DynamicArray<>();

    @Test
    @Order(1)
    void shouldInsertElements() {
        assertTrue(insert());
    }

    @Test
    @Order(2)
    void shouldRemoveAllElements() {
        array.removeAll();
    }

    @Test
    @Order(3)
    void shouldPassIfIndexIsTheSame() {
        assertTrue(insert());
        assertEquals(0, array.indexOf(1));
    }

    @Test
    @Order(4)
    void shouldPassIfSizeIsTheSame() {
        assertTrue(insert());
        assertEquals(11, array.size());
    }

    private boolean insert() {
        return array.insert(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
    }
}