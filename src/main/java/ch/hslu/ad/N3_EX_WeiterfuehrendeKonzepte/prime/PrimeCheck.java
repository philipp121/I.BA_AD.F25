/*
 * Copyright 2025 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.N3_EX_WeiterfuehrendeKonzepte.prime;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * 100 grosse Primzahlen finden.
 */
public final class PrimeCheck {

    private static final Logger LOG = LoggerFactory.getLogger(PrimeCheck.class);

    /**
     * Privater Konstruktor.
     */
    private PrimeCheck() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Set<BigInteger> primes = ConcurrentHashMap.newKeySet(); // threadsicheres Set
        AtomicInteger counter = new AtomicInteger(0);
        long start = System.nanoTime();
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            executor.submit(() -> {
                while (true) {
                    // Exit früh prüfen
                    if (counter.get() >= 100) {
                        break;
                    }

                    BigInteger bi = new BigInteger(1024, new SecureRandom());
                    if (bi.isProbablePrime(100)) {
                        if (primes.add(bi)) {
                            int index = counter.incrementAndGet();
                            if (index <= 100) {
                                LOG.info("{} : {}...", index, bi.toString().substring(0, 20));
                            }
                        } else {
                            // Auch bei Duplikat prüfen, ob fertig
                            if (counter.get() >= 100) {
                                break;
                            }
                        }
                    }
                }
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        long end = System.nanoTime();
        System.out.println("Gebrauchte Zeit in ms: " + TimeUnit.NANOSECONDS.toMillis((end - start)));
    }
}
