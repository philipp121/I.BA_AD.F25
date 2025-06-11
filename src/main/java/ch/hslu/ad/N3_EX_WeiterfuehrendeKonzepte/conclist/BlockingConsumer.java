package ch.hslu.ad.N3_EX_WeiterfuehrendeKonzepte.conclist;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class BlockingConsumer implements Callable<Long> {
    private final BlockingQueue<Integer> queue;

    public BlockingConsumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public Long call() throws InterruptedException {
        long sum = 0;
        while (true) {
            Integer value = queue.poll(100, TimeUnit.MILLISECONDS); // Timeout, falls nichts mehr kommt
            if (value == null) break;
            sum += value;
        }
        return sum;
    }
}

