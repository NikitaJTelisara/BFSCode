
public class Queue {
    Node first, last;

    public void enQueue(Node n) {
        if (first != null) {
            last.next = n;
            last = last.next;
        } else {
            first = n;
            last = n;
        }
    }

    public Node deQueue() {
        if (first != null) {
            Node n = first;
            first = first.next;
            return n;
        }
        return null;
    }

    boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }
}
