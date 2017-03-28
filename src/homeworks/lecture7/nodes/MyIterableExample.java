package homeworks.lecture7.nodes;


import java.util.Iterator;

public class MyIterableExample {
    public static void main(String[] args) {
        IterableNode head = new IterableNode(5);
        head.setNext(new IterableNode(6));
        head.getNext().setNext(new IterableNode(12));
        head.add(new IterableNode(13));
        head.add(new IterableNode(14));

        System.out.println("Print via Node.print function: ");
        head.print(head);

        System.out.println("\nPrint using foreach");
        for (IterableNode node : head) {
            System.out.print(node.getValue() + "-->");
        }

        System.out.println("\nRemove element = 12");
       Iterator<IterableNode> iterator = head.iterator();
        while (iterator.hasNext()) {
            IterableNode node = iterator.next();
            if(node.getValue() == 12) {
                iterator.remove();
            }
        }

        for (IterableNode node : head) {
            System.out.print(node.getValue() + "-->");
        }




    }
}
