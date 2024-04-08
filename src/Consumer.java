class Consumer implements Runnable {
    private final Manage manage;
    private final int totalProducts;

    public Consumer(Manage manage, int totalProducts) {
        this.manage = manage;
        this.totalProducts = totalProducts;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < totalProducts; i++) {
                manage.consume(i);
                Thread.sleep(200); // Simulating consumption time
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}