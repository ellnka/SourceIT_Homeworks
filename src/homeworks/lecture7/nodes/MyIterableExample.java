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
        for (IterableNode printedNode : head) {
            System.out.print(printedNode.getValue() + " --> ");
        }
        System.out.println("\n");




        Iterator<IterableNode> iterator = head.iterator();
        while (iterator.hasNext()) {
            IterableNode node = iterator.next();

            int value = node.getValue();
            // remove elements from head, middle and tail of a node-list
            if (value == 5 || value == 12 || value == 14) {
                System.out.println("\nRemove element => " + value);
                iterator.remove();
                for (IterableNode printedNode : head) {
                    System.out.print(printedNode.getValue() + " --> ");
                }
            }
        }

        System.out.println("\n\nFinal list: " );
        for (IterableNode printedNode : head) {
            System.out.print(printedNode.getValue() + " --> ");
        }




    }
}
