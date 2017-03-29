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
        private IterableNode currentNode = head;
        private IterableNode beforeCurrentNode = null;

        @Override
        public boolean hasNext() {
            return currentNode.getNext() != null;
        }

        @Override
        public IterableNode next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            if (beforeCurrentNode != null) {
                beforeCurrentNode = currentNode;
                currentNode = beforeCurrentNode.getNext();
            } else {
                beforeCurrentNode = currentNode;
            }
           // System.out.println("current node = " + currentNode.getValue());
            return currentNode;
        }


        @Override
        public void remove() {
            if (currentNode == null) {
                throw new NoSuchElementException();
            }

            if (beforeCurrentNode != currentNode) { // it compares points (not values)
                beforeCurrentNode.setNext(currentNode.getNext());
                currentNode.setNext(null);
            } else {
                head.setValue(currentNode.getNext().getValue());
                head.setNext(currentNode.getNext().getNext());
            }
        }


    }
/*
    public IterableNode[] toArray() {
        IterableNode[] result = new IterableNode[size];
        int i = 0;
        for (IterableNode x = this; x != null; x = x.getNext())
            result[i++] = x;
        return result;
    }
    */
}
