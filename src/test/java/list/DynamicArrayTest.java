package list;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DynamicArrayTest {

    private DynamicArray<Integer> array;

    @BeforeEach
    void setUp() {
        array = new DynamicArray<>();
    }

    @Test
    void shouldInsertElements() {
        var inserted = insert();
        assertTrue(inserted);
    }

    @Test
    void shouldRemoveAllElements() {
        var removed = array.removeAll();
        assertTrue(removed);
    }

    @Test
    void shouldPassIfIndexIsTheSame() {
        insert();
        assertEquals(0, array.indexOf(1));
    }

    @Test
    void size() {
    }

    public boolean insert() {
        return array.insert(1, 2, 3, 4);
    }
}