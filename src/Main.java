
public class Main {
    public static void main(String[] args) {
        int manageCapacity = 2;
        int totalProducts = 10;

        Manage manage = new Manage(manageCapacity);

        Thread producerThread = new Thread(new Producer(manage, totalProducts));
        Thread consumerThread = new Thread(new Consumer(manage, totalProducts));

        producerThread.start();
        consumerThread.start();
    }


}