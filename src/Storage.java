import java.util.concurrent.Semaphore;

class Storage {
    private final Semaphore producerSemaphore;
    private final Semaphore consumerSemaphore;
    private final int capacity;
    private boolean isProducing;

    public Storage(int capacity) {
        this.capacity = capacity;
        this.producerSemaphore = new Semaphore(capacity);
        this.consumerSemaphore = new Semaphore(0);
        this.isProducing = true; // Виробництво можливе спочатку
    }

    public void produce(int item) throws InterruptedException {
        if (!isProducing) {
            System.out.println("Storage is full. Production is halted.");
            return;
        }
        producerSemaphore.acquire(); // Спроба отримати доступ на запис
        System.out.println("Produced item: " + item + ". Remaining space: " + producerSemaphore.availablePermits());
        consumerSemaphore.release(); // Вивільнення споживача
        if (producerSemaphore.availablePermits() == 0) {
            isProducing = false; // Зупинка виробництва, якщо сховище повне
        }
    }

    public int consume() throws InterruptedException {
        consumerSemaphore.acquire(); // Спроба отримати доступ на читання
        System.out.println("Consumed item. Remaining space: " + (capacity - producerSemaphore.availablePermits()));
        producerSemaphore.release(); // Вивільнення виробника
        if (!isProducing) {
            isProducing = true; // Відновлення виробництва, якщо знову є доступне місце
        }
        return 0;
    }
}

