package linkedList;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        LinkedList<String> songs = new LinkedList<>();
        LinkedList<String> artists = new LinkedList<>();
        LinkedList<String> playlist = new LinkedList<>();

        songs.add("Living Next Door to Alice");
        songs.add("Lay Back in the Arms of Someone");
        songs.add("Stuck");
        songs.add("Ain’t No Mountain High Enough");
        songs.add("I want you back");

        artists.add("Smokie");
        artists.add("Smokie");
        artists.add("Darren Espanto");
        artists.add("Marvin Gaye and Tammi Terrell");
        artists.add("Jackson 5");

        int size = songs.size();

        /*
         IntStream is an internal iterator, same as loop which is an external iterator.
         Adding each song and artists to playlist using playlist.add(), replaced with
         method reference: playlist::add
         index = 0
         It is the same as shown below.
            for (int index = 0; index < size; i++) {
                playlist.add(songs.get(i).concat(" - ").concat(artists.get(i)));
            }
        */
        IntStream.range(0, size)
                .mapToObj(index -> songs.get(index).concat(" - ").concat(artists.get(index)))
                .forEach(playlist::add);

        System.out.println(songs);
        System.out.println(artists);
        playlist.forEach(System.out::println); // looping through each object in a linked list and printing them.
    }
}
