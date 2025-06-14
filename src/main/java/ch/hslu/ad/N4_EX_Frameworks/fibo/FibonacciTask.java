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
package ch.hslu.ad.N4_EX_Frameworks.fibo;

import java.util.concurrent.RecursiveTask;

/**
 * Codevorlage für ein klassisches Beispiel zur Berechnung von Fibonacci Zahlen.
 */
@SuppressWarnings("serial")
public final class FibonacciTask extends RecursiveTask<Long> {

    /**
     * Gegebene Zahl für die gesuchte Fibonacci Zahl.
     */
    private final int n;
    private static final int THRESHOLD = 19;

    /**
     * Erzeugt einen Fibonacci Task.
     *
     * @param n für die Fibonacci Berechnung.
     */
    public FibonacciTask(final int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n <= 1) {
            return (long) n;
        }

        // Schwelle einbauen (optional, z. B. ab n <= 10 sequentiell rechnen)
        if (n <= THRESHOLD) {
            return FibonacciCalc.fiboIterative(n);
        }

        // Rekursive Aufgaben aufteilen
        FibonacciTask task1 = new FibonacciTask(n - 1);
        task1.fork(); // parallel starten
        FibonacciTask task2 = new FibonacciTask(n - 2);
        long result2 = task2.invoke(); // n-2 → läuft synchron im aktuellen Thread
        long result1 = task1.join();    // auf Ergebnis von task1 warten

        return result1 + result2;

    }
}
