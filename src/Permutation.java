import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue randomizedQueue = new RandomizedQueue();
        System.out.println(StdIn.readAll());
        String input = StdIn.readString();
        randomizedQueue.enqueue(input);
        System.out.println(randomizedQueue);
    }
}
