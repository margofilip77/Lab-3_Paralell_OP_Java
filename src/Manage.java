import java.util.concurrent.Semaphore;

class Manage {
    private final Semaphore producerSemaphore;
    private final Semaphore consumerSemaphore;
    private final int capacity;

    public Manage(int capacity) {
        this.capacity = capacity;
        this.producerSemaphore = new Semaphore(capacity);
        this.consumerSemaphore = new Semaphore(0);
    }

    public void produce(int product) throws InterruptedException {
        producerSemaphore.acquire();
        System.out.println("Producer produced: " + product);
        consumerSemaphore.release();
    }

    public void consume(int product) throws InterruptedException {
        consumerSemaphore.acquire();
        System.out.println("Consumer consumed: " + product);
        producerSemaphore.release();
    }
}
