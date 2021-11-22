import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int size;

    //construct an empty deque
    public Deque() {
        first = null;
        size = 0;
    }

    private class Node {
        Item item;
        Node next;
    }

    //is the deque empty?
    public boolean isEmpty() { return first == null; }

    //return the number of items on the deque
    public int size() { return size; }

    //add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Null argument");
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        if (isEmpty()) {
            last = first;
        }
        else {
            first.next = oldFirst;
        }
        size++;
    }

    //add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Null argument");
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        size++;
    }

    //remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Item item = first.item;
        first = first.next;
        if (isEmpty()) { last = null; }
        size--;
        return item;
    }


    //remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Node x = first;
        while (x.next.next != null) {
            x = x.next;
        }
        Item item = x.next.item;
        x.next = null;
        size--;
        return item;
    }

    //return an iterator over items in order from front to back
    public Iterator<Item> iterator() {return new ListIterator();}

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() { return current != null; }
        public void remove() { throw new UnsupportedOperationException("Remove is not supported"); }
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more items to return");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {

    }
}
