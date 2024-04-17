public class Main {
    public static void main(String[] args) {
        int manageCapacity = 2;
        int totalProducts = 10;
        int totalProducers = 3;
        int totalConsumers = 4; 

        Manage manage = new Manage(manageCapacity);

        // Створюємо та запускаємо потоки продюсерів
        for (int i = 0; i < totalProducers; i++) {
            Thread producerThread = new Thread(new Producer(manage, totalProducts));
            producerThread.start();
        }

        // Створюємо та запускаємо потоки консюмерів
        for (int i = 0; i < totalConsumers; i++) {
            Thread consumerThread = new Thread(new Consumer(manage, totalProducts));
            consumerThread.start();
        }
    }
}
