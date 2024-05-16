import java.util.concurrent.LinkedBlockingQueue;

public class ProdCons {
    public static void main(String[] args) throws InterruptedException {
        var queue = new LinkedBlockingQueue<Integer>();
        var producer = new Thread(() -> {
            for (int i = 0; i < 1000;i++) {
                queue.add(1);
            }
            queue.add(-1);
        });
        var consumer = new Thread(() -> {
            int sum = 0;
            while (true) {
                Integer value = null;
                try {
                    value = queue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (value == -1) {
                    break;
                }
                sum += value;
            }
            System.out.println(sum);
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
