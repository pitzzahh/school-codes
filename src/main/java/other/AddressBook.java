package other;

import java.util.Arrays;
import java.util.Objects;

public class AddressBook {
    private AddressBookEntry[] ENTRIES = new AddressBookEntry[10];
    private AddressBookEntry book;
    private boolean isAdding = false;

    public void addEntry(AddressBookEntry entry) {
        if (ENTRIES.length > 100) throw new IllegalStateException("Exceeded max entries");
        book = entry;
        System.out.println("book = " + book);
        addToEntry();
    }

    private void addToEntry() {
        Objects.requireNonNull(book);

        final var SIZE_OF_ARRAY = ENTRIES.length; // 10

        var currentSize = Arrays  // 0
                .stream(ENTRIES)
                .filter(Objects::nonNull)
                .count();
        var isFull = currentSize >= SIZE_OF_ARRAY;
        if (isFull) increaseArraySize();

        isAdding = true;

        ENTRIES[(int) currentSize] = book;
    }

    private void increaseArraySize() {
        if (isAdding) {
            ENTRIES = Arrays.copyOf(ENTRIES, ENTRIES.length + 10);
        }
    }

    public AddressBookEntry[] getENTRIES() {
        return ENTRIES;
    }

    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();

        for (int i = 0; i < 15; i++) {
            addressBook.addEntry(new AddressBookEntry());
        }
        AddressBookEntry[] entries = addressBook.getENTRIES();
        System.out.println(Arrays.toString(entries));
    }
}
