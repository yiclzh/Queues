import javax.xml.stream.events.StartDocument;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] s;
    private int N = 0;
    private int size;

    //construct empty randomized queue
    public RandomizedQueue() {
        s = (Item[]) new Object[10];
    }

    //is the randomized queue empty?
    public boolean isEmpty() { return N == 0; }

    //returns the number of items on the randomized queue
    public int size() { return size; }

    //add the item
    public void enqueue(Item item) {
        s[N++] = item;
    }

    //remove and return a random item
    public Item dequeue() {

    }

    //return a random item (but do not remove it)
    public Item sample() {

    }

    //return an independent iterator over items in random order
    public Iterator<Item> iterator() {

    }

    public static void main(String[] args) {

    }
}
