package ch.hslu.ad.N3_EX_WeiterfuehrendeKonzepte.conclist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.*;

public final class DemoBlockingQueue {

    private static final Logger LOG = LoggerFactory.getLogger(DemoBlockingQueue.class);

    private DemoBlockingQueue() {
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final int passes = 10;
        long sumTimeBlocking = 0;
        long sumTimeConcurrent = 0;

        runWithBlockingQueue();
        for (int i = 0; i < passes; i++) {
            sumTimeBlocking += runWithBlockingQueue();
        }

        DemoConcurrentList.runWithConcurrentList();
        for (int i = 0; i < passes; i++) {
            sumTimeConcurrent += DemoConcurrentList.runWithConcurrentList();
        }

        LOG.info("BlockingQueue average duration = {} ms", sumTimeBlocking / (float) passes);
        LOG.info("ConcurrentList average duration = {} ms", sumTimeConcurrent / (float) passes);
    }

    private static long runWithBlockingQueue() throws InterruptedException, ExecutionException {
        long start = System.nanoTime();
        final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        final Random random = new Random();
        final ExecutorService executor = Executors.newCachedThreadPool();

        Future<Long> prod1 = executor.submit(new BlockingProducer(queue, random.nextInt(1_000)));
        Future<Long> prod2 = executor.submit(new BlockingProducer(queue, random.nextInt(1_000)));
        Future<Long> prod3 = executor.submit(new BlockingProducer(queue, random.nextInt(1_000)));

        long totProd = prod1.get() + prod2.get() + prod3.get();
        //LOG.info("prod tot = {}", totProd);

        Future<Long> cons = executor.submit(new BlockingConsumer(queue));
        long totCons = cons.get();
        //LOG.info("cons tot = {}", totCons);

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        long end = System.nanoTime();
        return TimeUnit.NANOSECONDS.toMillis(end - start);
    }
}
