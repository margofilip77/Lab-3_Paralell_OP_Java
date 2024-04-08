class Producer implements Runnable {
    private final Manage manage;
    private final int totalProducts;

    public Producer(Manage manage, int totalProducts) {
        this.manage = manage;
        this.totalProducts = totalProducts;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < totalProducts; i++) {
                manage.produce(i);
                Thread.sleep(100); // Simulating production time
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}