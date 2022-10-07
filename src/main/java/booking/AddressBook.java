package booking;

import io.github.pitzzahh.utilities.Print;
import java.util.Arrays;
import java.util.Objects;
import lombok.Data;

@Data
public class AddressBook {
    private AddressBookEntry[] ENTRIES = new AddressBookEntry[10];
    private AddressBookEntry book;
    private int SIZE_OF_ARRAY = ENTRIES.length;
    private boolean isAdding = false;

    public void addEntry(AddressBookEntry entry) {
        if (ENTRIES.length > 100_000) throw new IllegalStateException("Exceeded max entries");
        book = entry;
        System.out.println("book = " + book.toString());
        addToEntry();
    }

    private void addToEntry() {
        Objects.requireNonNull(book, "book cannot be null");

        var currentSize = Arrays
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
            ENTRIES = Arrays.copyOf(ENTRIES, SIZE_OF_ARRAY += 5);
        }
    }

    public AddressBookEntry[] getENTRIES() {
        return ENTRIES;
    }

    public static void main(String[] args) {

        var addressBook = new AddressBook();

        var entry = new AddressBookEntry(
                "Peter John",
                "Earth",
                143,
                new EmailAddress("pitzzahh", "gmail.com")
        );

        addressBook.addEntry(entry);
        for (int i = 1; i <= 15; i++) {
            addressBook.addEntry(new AddressBookEntry());
        }

        var entries = addressBook.getENTRIES();

        Arrays.stream(entries)
                .forEach(Print::println);
    }
}
