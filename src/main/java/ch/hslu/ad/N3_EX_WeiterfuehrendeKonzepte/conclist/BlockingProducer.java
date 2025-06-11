package ch.hslu.ad.N3_EX_WeiterfuehrendeKonzepte.conclist;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class BlockingProducer implements Callable<Long> {
    private final BlockingQueue<Integer> queue;
    private final int count;

    public BlockingProducer(BlockingQueue<Integer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    @Override
    public Long call() throws InterruptedException {
        long sum = 0;
        for (int i = 0; i < count; i++) {
            queue.put(i); // blockiert bei vollem Puffer
            sum += i;
        }
        return sum;
    }
}

