import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdjacencyList {

    public static void main(String[] args) {

        //                       0    1    2    3    4    5    6
        Character[] vertices = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        ArrayList<ArrayList<Object>> adjacencyList =
                IntStream.range(0, vertices.length)
                        .mapToObj(i -> new ArrayList<>())
                        .collect(Collectors.toCollection(ArrayList::new));
        // A
        adjacencyList.get(0).add(vertices[1]);
        // B
        adjacencyList.get(1).add(vertices[0]);
        adjacencyList.get(1).add(vertices[2]);
        //C
        adjacencyList.get(2).add(vertices[1]);
        adjacencyList.get(2).add(vertices[3]);
        adjacencyList.get(2).add(vertices[4]);
        // D
        adjacencyList.get(3).add(vertices[2]);
        adjacencyList.get(3).add(vertices[4]);
        adjacencyList.get(3).add(vertices[5]);
        adjacencyList.get(3).add(vertices[6]);
        // E
        adjacencyList.get(4).add(vertices[2]);
        adjacencyList.get(4).add(vertices[3]);
        adjacencyList.get(4).add(vertices[5]);
        // F
        adjacencyList.get(5).add(vertices[3]);
        adjacencyList.get(5).add(vertices[4]);
        // G
        adjacencyList.get(6).add(vertices[3]);

        adjacencyList.forEach(e -> System.out.println(vertices[adjacencyList.indexOf(e)] + ": " + e));

    }
}
