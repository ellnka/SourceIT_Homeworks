package homeworks.lecture4.nodes;

public class Node {
    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void add(Node node) {
        Node last = this;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        last.setNext(node);
    }

    public void removeLast() {
        Node last = this;
        while (last.getNext().getNext() != null) {
            last = last.getNext();
        }
        last.setNext(null);
    }

    public void print(Node head) {
        System.out.print(head.getValue() + " --> ");
        if (head.getNext() != null) {
            print(head.getNext());
        }
        System.out.println();
    }

    /**
     * Removes Node from list that is located on position from head(start of the list).
     * If position is more than list size prints error message
     * @param position number of the Node starting from the head
     **/
    public void remove(int position) {
        /* assume that we start from a head
        *  how can we reach a head with this structure if we do not know where we are?
        *  Can we store a point to a previous element?
        *  Can we store a head and a tail?
        * */
        Node removedNode = this;
        Node previuosNode = null;

        for (int i = 0; i < position; i++){
            previuosNode = removedNode;
            removedNode = removedNode.getNext();
            if (removedNode == null) {
                System.out.println("Sorry, You are trying to remove non-existent node");
                return;
            }
        }

        Node nextNode = removedNode.getNext();
        if (previuosNode != null) {
            previuosNode.setNext(nextNode);
            removedNode.setNext(null);
        } else {
            this.value = removedNode.getNext().getValue();
            this.next = removedNode.getNext().getNext();
        }

    }

    /**
     * Adds Node to list on position from head(start of the list).
     * If position is more than list size prints error message
     * @param position number of the Node starting from the head
     * @param node node should be inserted at position
     */
    public void addNode(int position, Node node) {
        /*Your code here*/
    }

    /**
     * Gets then Node that located on the position starting from the tail (end of the list)
     * if position is more than list size - prints error message
     * @param position number of the Node starting from the tail
     * @return Node that located on the position from the tail (end of list) if position exists in list
     */
    public Node getFromTail(int position) {
        /*Your code here and please remove "return null". I've put it for ability to compile code*/
        return null;
    }
}
