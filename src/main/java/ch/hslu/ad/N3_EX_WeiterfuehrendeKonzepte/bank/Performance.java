package ch.hslu.ad.N3_EX_WeiterfuehrendeKonzepte.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Performance {

    private static final Logger LOG = LoggerFactory.getLogger(Performance.class);

    public static void main(String[] args) {
        final Performance perf = new Performance();
        final int amount = 100_000;
        final int number = 10;
        final int passes = 10;

        long sumAtom = 0;
        for (int i = 0; i < passes; i++) {
            sumAtom += perf.measureAtomic(amount, number);
        }

        long sumSync = 0;
        for (int i = 0; i < passes; i++) {
            sumSync += perf.measureSync(amount, number);
        }

        LOG.info("Atom BankAccount average test duration = {} ms", sumAtom / (float) passes);
        LOG.info("Sync BankAccount average test duration = {} ms", sumSync / (float) passes);

    }

    public long measureAtomic(final int amount, final int number){
        long start = System.nanoTime();
        final ArrayList<BankAccount> source = new ArrayList<>();
        final ArrayList<BankAccount> target = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            source.add(new BankAccount(amount));
            target.add(new BankAccount());
        }
        // Account Tasks starten...
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < number; i++) {
            BankAccount src = source.get(i);
            BankAccount tgt = target.get(i);
            executor.submit(new AccountTask(src, tgt, amount));
            executor.submit(new AccountTask(tgt, src, amount)); // zurücküberweisen
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        LOG.info("Bank accounts (Atomic) after transfers");
//        for (int i = 0; i < number; i++) {
//            LOG.info("[Atomic] source({}) = {}; target({}) = {};", i, source.get(i).getBalance(), i, target.get(i).getBalance());
//        }

        long end = System.nanoTime();
        return TimeUnit.NANOSECONDS.toMillis(end - start);
    }

    public long measureSync(final int amount, final int number) {
        long start = System.nanoTime();
        final ArrayList<ch.hslu.ad.N1_EX_ThreadsSynch.bank.BankAccount> source = new ArrayList<>();
        final ArrayList<ch.hslu.ad.N1_EX_ThreadsSynch.bank.BankAccount> target = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            source.add(new ch.hslu.ad.N1_EX_ThreadsSynch.bank.BankAccount(amount));
            target.add(new ch.hslu.ad.N1_EX_ThreadsSynch.bank.BankAccount());
        }
        final Thread[] threads = new Thread[number * 2];
        for (int i = 0; i < number; i++) {
            threads[i] = new Thread(new ch.hslu.ad.N1_EX_ThreadsSynch.bank.AccountTask(source.get(i), target.get(i), amount));
            threads[i + number] = new Thread(new ch.hslu.ad.N1_EX_ThreadsSynch.bank.AccountTask(target.get(i), source.get(i), amount));
        }
        for (final Thread thread : threads) {
            thread.start();
        }
        try {
            waitForCompletion(threads);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        LOG.info("Bank accounts (Sync) after transfers");
//        for (int i = 0; i < number; i++) {
//            LOG.info("[Sync] source({}) = {}; target({}) = {};", i, source.get(i).getBalance(), i, target.get(i).getBalance());
//        }
        long end = System.nanoTime();
        return TimeUnit.NANOSECONDS.toMillis(end - start);
    }

    private static void waitForCompletion(final Thread[] threads) throws InterruptedException {
        for (final Thread thread : threads) {
            thread.join();
        }
    }
}
