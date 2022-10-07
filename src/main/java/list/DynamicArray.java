package list;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

// TODO: continue functionalities
public class DynamicArray<T> {

    transient Object[] array;

    private final int DEFAULT_SIZE = 10;

    private int size;

    public DynamicArray() {
        this.array = new Object[]{};
    }

    public DynamicArray(int initialSize) {
        if (initialSize > 0) this.array = new Object[initialSize];
        else if (initialSize == 0) this.array = new Object[]{};
        else throw new IllegalArgumentException("Illegal Capacity: " + initialSize);
    }

    private final Consumer<T> insert = this::add;

    private final Supplier<Integer> getCurrentSize = () -> (int) Arrays.stream(array)
            .filter(Objects::nonNull)
            .count();

    private final Supplier<Boolean> isFull = () -> getCurrentSize.get() >= size;

    public boolean insert(T element) {
        this.insert.accept(element);
        return true;
    }

    public boolean insert(T element, int position) {
        this.insert.accept(element);
        return true;
    }

    private void add(T element) {
        Objects.requireNonNull(element, "Argument cannot be null");
        if (isFull.get()) array = Arrays.copyOf(array, getCurrentSize.get() + 5);
        array[getCurrentSize.get()] = element;
    }

    @Override
    public String toString() {
        return Arrays.stream(array)
                .filter(Objects::nonNull)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
