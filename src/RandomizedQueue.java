import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] s;
    private int N = 0;
    private int size;

    //construct empty randomized queue
    public RandomizedQueue() {
        s = (Item[]) new Object[5];
        size = 5;
    }

    //is the randomized queue empty?
    public boolean isEmpty() { return N == 0; }

    //returns the number of items on the randomized queue
    public int size() { return N; }

    //add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Argument cannot be null.");
        }
        if (N == s.length) {
            resize(2 * s.length);
        }
        s[N] = item;
        N++;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        size = capacity;
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    //remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        int randomIndex = StdRandom.uniform(0, N+1);
        Item item = s[randomIndex];
        int numMoved = size - randomIndex - 1;
        System.arraycopy(s, randomIndex + 1, s, randomIndex, numMoved);
        s[--N] = null;
        if (N > 0 && N == s.length/4) {
            resize(s.length/2);
        }
        return item;
    }

    //return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return s[StdRandom.uniform(0, N+1)];
    }

    //return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public void remove() { throw new UnsupportedOperationException("Remove is not supported"); }
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more items to return.");
            }
            i--;
            return s[StdRandom.uniform(0, N+1)];
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Item i : s) {
            stringBuilder.append(i);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        RandomizedQueue randomizedQueue = new RandomizedQueue();
        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue(9);
        randomizedQueue.enqueue(11);
        randomizedQueue.enqueue(111);
        randomizedQueue.enqueue(21);
        randomizedQueue.enqueue(53);
        System.out.println("This is sample: "+ randomizedQueue.sample());
        System.out.println(randomizedQueue);
        while (!randomizedQueue.isEmpty()) {
            System.out.println(randomizedQueue.dequeue());
            System.out.println(randomizedQueue);
        }

    }
}
