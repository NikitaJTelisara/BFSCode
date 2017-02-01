import java.util.ArrayList;

public class BreathFirstSearch {

    /*
    40------>20->50
    |  _ _//  |   |
    v v   v   v   v
    10-->30->60->70
    */

    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node n1 = new Node(40);
        nodes.add(n1);
        Node n2 = new Node(10);
        nodes.add(n2);
        Node n3 = new Node(20);
        nodes.add(n3);
        Node n4 = new Node(30);
        nodes.add(n4);
        Node n5 = new Node(60);
        nodes.add(n5);
        Node n6 = new Node(50);
        nodes.add(n6);
        Node n7 = new Node(70);
        nodes.add(n7);

        // arrayList = 40 10 20 30 60 50 70

        int[][] adjacentNodes = {
                {0, 1, 1, 0, 0, 0, 0},  // Node 1: 40
                {0, 0, 0, 1, 0, 0, 0},  // Node 2 :10
                {0, 1, 0, 1, 1, 1, 0},  // Node 3: 20
                {0, 0, 0, 0, 1, 0, 0}, // Node 4: 30
                {0, 0, 0, 0, 0, 0, 1}, // Node 5: 60
                {0, 0, 0, 0, 0, 0, 1}, // Node 6: 50
                {0, 0, 0, 0, 0, 0, 0}, // Node 7: 70
        };

        ArrayList neighbours = findNeighbours(adjacentNodes, n1, nodes);
        System.out.println("Neighbours of " + n1.data);
        for (int i = 0; i < neighbours.size(); i++) {
            Node n = (Node) neighbours.get(i);
            System.out.println(n.data);
        }
        System.out.println("bfs using queue");
        bfsUsingQueue(n1, adjacentNodes, nodes);

    }

    public static ArrayList<Node> findNeighbours(int[][] m, Node n, ArrayList<Node> nodes) {
        ArrayList<Node> neighbours = new ArrayList<Node>();
        int indexNode = -1;
        for (int i = 0; i < nodes.size(); i++) {
            Node n1 = nodes.get(i);
            if (n1 == n) {
                indexNode = i;
                break;
            }
        }
        if (indexNode != -1) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[indexNode][j] == 1) {
                    neighbours.add(nodes.get(j));
                }
            }
        }
        return neighbours;
    }

    public static void clearFlags(ArrayList<Node> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).visited) {
                nodes.get(i).visited = false;
            }
        }
    }

    //Iterative bfs using stack
    public static void bfsUsingQueue(Node n, int[][] m, ArrayList<Node> nodes) {
        Queue q = new Queue();
        q.enQueue(n);
        n.visited = true;
        while (!q.isEmpty()) {
            Node element = q.deQueue();
            System.out.println(element.data);
            ArrayList<Node> neighbours = findNeighbours(m, element, nodes);
            for (int i = 0; i < neighbours.size(); i++) {
                Node n1 = neighbours.get(i);
                if (n1 != null && !n1.visited) {
                    q.enQueue(n1);
                    n1.visited = true;
                }
            }
        }
    }
}
