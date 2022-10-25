package queue;

import static io.github.pitzzahh.util.utilities.Print.print;
import static java.lang.String.valueOf;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CNode <T extends Comparable<T>> extends Node<T> {
    protected  Node<T> root;

    public CNode(Node<T> root) {
        this.root = root;
    }

    public CNode(T element, Node<T> root) {
        super(element);
        this.root = root;
    }

    public CNode(T element, Node<T> left, Node<T> right, Node<T> root) {
        super(element, left, right);
        this.root = root;
    }

    public void visit(Node<T> previous) {
        print(previous.element + ", ");
    }

    public Node<T> search(T element) {
        var previous = root;
        while (previous != null) {
            if (element.equals(previous.element)) return previous;
            else if (element.compareTo(previous.element) < 0) previous = previous.left;
            else previous = previous.right;
        }
        return null;
    }

    public void breadFirst() {
        var previous = root;
        var queue = new LinkedList<Node<T>>();
        if (previous != null) {
            queue.offer(previous);
            while (!queue.isEmpty()) {
                previous = queue.remove();
                visit(previous);
                if (previous.left != null) queue.offer(previous.left);
                if (previous.right != null) queue.offer(previous.right);
            }
        }
    }

    public static void main(String[] args) {
        var root = new Node<>(1);

        var two = new Node<>(2);
        var three = new Node<>(3);
        var four = new Node<>(4);
        var five = new Node<>(5);

        root.left = two;
        root.right = three;

        two.left = four;
        two.right = five;

        var cNode = new CNode<>(root);
        cNode.breadFirst();
    }
}
