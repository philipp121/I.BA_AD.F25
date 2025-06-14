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
package ch.hslu.ad.N4_EX_Frameworks.quicksort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import ch.hslu.ad.N4_EX_Frameworks.RandomInitTask;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Vergleich von verschiedenen Quicksort-Implementationen.
 */
public final class DemoQuicksort {

    private static final Logger LOG = LoggerFactory.getLogger(DemoQuicksort.class);

    /**
     * Privater Konstruktor.
     */
    private DemoQuicksort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int size = 100_000_000;
        long start;
        long end;
        final int[] arrayOriginal = new int[size];
        try (final ForkJoinPool pool = new ForkJoinPool()) {
            RandomInitTask initTask = new RandomInitTask(arrayOriginal, 100);
            pool.invoke(initTask);

            start = System.currentTimeMillis();
            int[] arrayTask = Arrays.copyOf(arrayOriginal, size);
            final QuicksortTask sortTask = new QuicksortTask(arrayTask);
            pool.invoke(sortTask);
            end = System.currentTimeMillis();
            LOG.info("QuicksortTask  : {} ms.", end - start);

            start = System.currentTimeMillis();
            int[] arrayRec = Arrays.copyOf(arrayOriginal, size);
            QuicksortRecursive.quicksort(arrayRec);
            end = System.currentTimeMillis();
            LOG.info("QuicksortRec.  : {} ms.", end - start);

            start = System.currentTimeMillis();
            int[] arraySort = Arrays.copyOf(arrayOriginal, size);
            Arrays.sort(arraySort);
            end = System.currentTimeMillis();
            LOG.info("Arrays.sort    : {} ms.", end - start);
        } finally {
            // Executor shutdown
        }
    }
}
