package homeworks.lecture7.nodes;


import homeworks.lecture4.nodes.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableNode extends Node implements Iterable<IterableNode> {
    public IterableNode head = null;

    public IterableNode(int value) {
        super(value);
        head = this;
    }

    @Override
    public IterableNode getNext() {
        return (IterableNode)next;
    }

    @Override
    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public Iterator iterator() {
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator {
        private IterableNode nextNode = head;
        private IterableNode node = null;

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public IterableNode next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            node = nextNode;
            nextNode = (node != null) ? node.getNext() : null;
            return node;
        }


        @Override
        public void remove() {
            if (node == null && nextNode == null) {
                throw new NoSuchElementException();
            }

            IterableNode prevNode = getPrevNode();

            if (prevNode == null && nextNode != null) { // remove first element from initial list
                head.setValue(nextNode.getValue());
                head.setNext(nextNode.getNext());
            }

            nextNode = (nextNode != null && prevNode == null) ? node :
                            (node != null) ? node.getNext() : null;
            node = prevNode;
            if (node != null) {
                node.setNext(nextNode);
            }

            if (prevNode == null && node == null && nextNode == null) { // remove last item
                head = null;
            }

           /* System.out.println(" *** head element    = " + ((head != null) ? head.getValue() : "null"));
            System.out.println(" *** prev element    = " + ((prevNode != null) ? prevNode.getValue() : "null"));
            System.out.println(" *** current element = " + ((node != null) ? node.getValue() : "null"));
            System.out.println(" *** next element    = " + ((nextNode != null) ? nextNode.getValue() : "null"));
*/
        }

        public IterableNode getPrevNode() {
            IterableNode prevNode = null;
            if (node != null) {
                for (IterableNode node : head) {
                    if (node == this.node) { // compare points
                        break; // for
                    } else {
                        prevNode = node;
                    }
                }
            }
            return prevNode;
        }
    }

}
