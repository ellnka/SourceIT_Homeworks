package homeworks.lecture4.nodes;

import java.util.HashMap;

public class NodeTest {
    public static void main(String[] args) {
        Node head = new Node(3);
        head.add(new Node(4));
        head.add(new Node(5));


        head.print(head);
        Node newNode = new Node(10);
        head.addNode(1, newNode);
        head.addNode(4, newNode);
        head.print(head);

        System.out.println("----------------------------------- ");

        head.print(head);
        head.remove(0);
        head.remove(4);
        head.print(head);

        System.out.println("----------------------------------- ");

        head.print(head);
        Node node = head.getFromTail(1);
        head.print(node);
    }

}
