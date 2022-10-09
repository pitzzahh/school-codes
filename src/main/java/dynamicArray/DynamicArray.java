package dynamicArray;

import static java.util.Objects.requireNonNull;
import static java.util.stream.IntStream.range;
import java.util.stream.StreamSupport;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import static java.util.Arrays.*;
import java.util.stream.Stream;
import java.io.Serializable;
import java.util.*;

/**
 * Class that functions same as an array but the size increases.
 * @param <T> the type of the dynamic array.
 */
public class DynamicArray<T> implements Serializable {

    /**
     * The array where the elements are stored.
     * Called balloon because balloon expands as you add air to it.
     */
    transient Object[] balloon;

    /**
     * Default size of the dynamic array.
     */
    private final int DEFAULT_SIZE = 10;

    /**
     * No args dynamic array. Sets the dynamic array size to default size of 10.
     */
    public DynamicArray() {
        this.balloon = new Object[DEFAULT_SIZE];
    }

    /**
     * Creates a {@code DynamicArray} object with an initial size
     * @param initialSize the initial size of the array.
     */
    public DynamicArray(int initialSize) {
        if (initialSize > 0) this.balloon = new Object[initialSize];
        else if (initialSize == 0) this.balloon = new Object[]{};
        else throw new IllegalArgumentException("Illegal Capacity: " + initialSize);
    }

    /**
     * Insert an element in the dynamic array.
     * @param element the element to be inserted.
     * @return {@code true} if inserted successfully.
     */
    public boolean insert(T element) {
        this.add(element);
        return true;
    }

    /**
     * Inserts an array of elements in the dynamic array.
     * @param elements the element to be inserted.
     * @return {@code true} if inserted successfully.
     */
    @SafeVarargs
    public final boolean insert(T... elements) {
        range(0, elements.length)
                .forEach(i -> this.add(elements[i]));
        return true;
    }

    /**
     * Removes an element in the dynamic array.
     * @param element the element to be removed.
     * @return {@code true} if removed successfully.
     */
    public boolean remove(T element) {
        requireNonNull(element, "Argument cannot be null");
        var index = getIndex(element);
        if (index == -1) return false;
        this.balloon[index] = null;
        trimAndGrow();
        return true;
    }

    /**
     * Removes an element in a specific index.
     * @param index the index of the element to be removed.
     * @return {@code true} if the element has been removed.
     */
    public boolean remove(int index) {
        checkBounds(index);
        this.balloon[index] = null;
        trimAndGrow();
        return true;
    }

    /**
     * Removes all the elements in the dynamicArray.
     * @return {@code true} if all the elements are removed.
     */
    public boolean removeAll() {
        this.balloon = new Object[]{};
        return true;
    }

    /**
     * Returns the index of the element in the dynamic array.
     * @param element the element to search for the index.
     * @return the index of the element in the dynamic array. If index is not present, returns -1.
     */
    public int indexOf(T element) {
        requireNonNull(element, "Argument cannot be null");
        return getIndex(element);
    }

    /**
     * Get the element at a specific index.
     * @param index the index of the element.
     * @return the element {@link  T} in the dynamic array.
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkBounds(index);
        return (T) this.balloon[index];
    }

    /**
     * Get the size of the dynamic array.
     * @return {@code int} contains the size of the dynamic array.
     */
    public int size() {
        return this.balloon.length;
    }

    /**
     * Sorts the dynamic array.
     * @param ascending if sorting is ascending.
     */
    public void sort(boolean ascending) {
        removeNulls();
        if (!ascending) this.balloon = this.stream()
                .sorted(Collections.reverseOrder())
                .toArray();
        else this.balloon = this.stream()
                .sorted()
                .toArray();
    }

    /**
     * Puts the object to abstraction.
     * @return a {@code Stream<T>} of objects.
     * @see Stream
     * @see Spliterators
     * @see StreamSupport
     */
    public Stream<T> stream() {
        return StreamSupport.stream(
                Spliterators.spliterator(
                        this.balloon,
                        0,
                        size(),
                        Spliterator.ORDERED | Spliterator.IMMUTABLE
                ), false
        );
    }

    // Internal implementation of getting the index of an element in the dynamic array.
    private int getIndex(T element) {
        return range(0, size())
                .filter(i -> this.balloon[i] != null)
                .filter(i -> this.balloon[i].equals(element))
                .findAny()
                .orElse(-1);
    }

    // Internal implementation of adding element in the dynamic array.
    private void add(T element) {
        requireNonNull(element, "Argument cannot be null");
        var size = getCurrentSize.get();
        if (isFull.test(size)) trimAndGrow();
        balloon[size] = element;
    }

    // Internal implementation that trims the dynamic array and grow the length by 10.
    private void trimAndGrow() {
        var size = getCurrentSize.get();
        removeNulls();
        this.balloon = copyOf(
                this.stream()
                        .parallel()
                        .toArray(),
                size + 10
        );
    }

    // Internal implementation that removes null from the dynamic array.
    private void removeNulls() {
        this.balloon = this.stream()
                .parallel()
                .filter(Objects::nonNull)
                .toArray();
    }

    // Internal utility method, checks if index is out of bound.
    private void checkBounds(int index) {
        if (isOutOfBounds.apply(index)) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    // Internal implementation that checks filters non-null objects and count them.
    private final Supplier<Integer> getCurrentSize = () -> (int) this.stream()
            .parallel()
            .filter(Objects::nonNull)
            .count();

    // Internal implementation that checks if the dynamic array is full.
    private final Predicate<Integer> isFull = currentElements -> currentElements >= size();

    // Internal implementation that checks if the index is out of bounds.
    private final Function<Integer, Boolean> isOutOfBounds = index -> index > getCurrentSize.get() || index < 0;

    @Override
    public String toString() {
        return this.stream()
                .filter(Objects::nonNull)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
