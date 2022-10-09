package dynamicArray;

import static io.github.pitzzahh.utilities.Print.println;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DynamicArrayTest {

    private final DynamicArray<Integer> array = new DynamicArray<>();

    @Test
    @Order(1)
    void shouldInsertElements() {
        var inserted = insert();
        assertTrue(inserted);
    }

    @Test
    @Order(2)
    void shouldRemoveAllElements() {
        var removed = array.removeAll();
        assertTrue(removed);
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
        assertEquals(5, array.size());
    }

    public boolean insert() {
        return array.insert(1, 2, 3, 4, 5);
    }
}