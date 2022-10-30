package queue;

import static io.github.pitzzahh.util.utilities.Print.println;
import static java.util.stream.Collectors.joining;
import java.util.LinkedList;

public class CNode <T extends Comparable<T>> extends Node<T> {
    protected  Node<T> root;
    protected LinkedList<T> linkedList = new LinkedList<>();
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
        linkedList.add(previous.element);
        println(linkedList.stream()
                .map(String::valueOf)
                .collect(joining(", ")));
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
        var root = new Node<>("B");

        var e = new Node<>("E");
        var r = new Node<>("R");
        var o = new Node<>("O");
        var n = new Node<>("N");
        var i = new Node<>("I");
        var k = new Node<>("K");
        var a = new Node<>("A");
        var q = new Node<>("Q");
        var t = new Node<>("T");

        root.left = e;
        root.right = r;

        e.left = o;
        e.right = n;

        r.left = i;
        r.right = k;

        o.left = a;
        o.right = q;

        n.left = t;

        var cNode = new CNode<>(root);
        cNode.breadFirst();
    }
}
