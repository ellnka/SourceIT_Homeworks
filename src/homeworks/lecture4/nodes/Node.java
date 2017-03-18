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

    public void setValue(int value) {
        this.value = value;
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
        if (head == null) {
            return;
        }
        System.out.print(head.getValue() + " --> ");
        if (head.getNext() != null) {
            print(head.getNext());
        } else {
            System.out.println();
        }
    }

    /**
     * Removes Node from list that is located on position from head(start of the list).
     * If position is more than list size prints error message
     * @param position number of the Node starting from the head
     **/
    public void remove(int position) {
        Node removedNode = this;
        Node beforeNode = null;

        for (int i = 0; i < position; i++){
            beforeNode = removedNode;
            removedNode = removedNode.getNext();
            if (removedNode == null) {
                System.out.println("Sorry, You are trying to remove non-existent node");
                return;
            }
        }

        if (beforeNode != null) {
            beforeNode.setNext(removedNode.getNext());
            removedNode.setNext(null);
        } else {
            this.setValue(removedNode.getNext().getValue());
            this.setNext(removedNode.getNext().getNext());
        }

    }

    /**
     * Adds Node to list on position from head(start of the list).
     * If position is more than list size prints error message
     * @param position number of the Node starting from the head
     * @param node node should be inserted at position
     */
    public void addNode(int position, Node node) {
        if (position == 0) {
            Node cloneOfThis = new Node(this.getValue());
            cloneOfThis.setNext(this.getNext());

            this.setValue(node.getValue());
            this.setNext(cloneOfThis);

            return;
        }

        Node beforeNode = this;
        for (int i = 0; i < position; i++){
            if (beforeNode == null || beforeNode.getNext() == null) {
                System.out.println("Sorry, You are trying to add new node to non-existent position");
                return;
            }
            beforeNode = beforeNode.getNext();
        }
        node.setNext(beforeNode.getNext());
        beforeNode.setNext(node);

    }

    /**
     * Gets then Node that located on the position starting from the tail (end of the list)
     * if position is more than list size - prints error message
     * @param position number of the Node starting from the tail
     * @return Node that located on the position from the tail (end of list) if position exists in list
     */
    public Node getFromTail(int position) {

        Node node = this;
        int countNodes = 1;
        while (node.getNext() != null && position > 0) {
            node = node.getNext();
            countNodes++;
        }

        if (countNodes < position || position <= 0) {
            System.out.println("Sorry, You are trying to get a node from non-existent position");
            return null;
        }

        node = this;
        for (int i = 0; i < (countNodes - position); i++) {
            node = node.getNext();
        }
        return node;
    }
}
