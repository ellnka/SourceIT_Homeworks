package homeworks.lecture7.nodes;


import java.util.Iterator;

public class MyIterableExample {
    public static void main(String[] args) {
        IterableNode head = new IterableNode(5);
        head.setNext(new IterableNode(6));
        head.getNext().setNext(new IterableNode(12));
        head.add(new IterableNode(13));
        head.add(new IterableNode(14));
        head.print(head);
        System.out.println("");

        for (IterableNode node : head) {
            System.out.print(node.getValue() + "-->");
        }
        System.out.println("");

        Iterator<IterableNode> iterator = head.iterator();
        while (iterator.hasNext()) {
            IterableNode node = iterator.next();
            System.out.print(node.getValue() + "-->");
            if(node.getValue() == 12) {
                iterator.remove();
                System.out.print("*removed*");
            }
        }


        System.out.println("");
        for (IterableNode node : head) {
            System.out.print(node.getValue() + "-->");
        }




    }
}
