package queue;

public class Node <T extends Comparable<T>> {

    protected T element;

    protected Node<T> left;

    protected Node<T> right;

    public Node() {
        left = right = null;
    }

    public Node(T element) {
        this(element, null, null);
    }

    public Node(T element, Node<T> left, Node<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

}
