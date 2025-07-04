/*
 * Copyright 2025 Hochschule Luzern - Informatik.
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
package ch.hslu.ad.N3_EX_WeiterfuehrendeKonzepte.count;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thread-sicherer Zähler mit AtomicInteger.
 */
public final class AtomicCounter implements Counter {

    private final AtomicInteger counter;

    /**
     * Erzeugt einen atomaren Zähler mit Startwert 0.
     */
    public AtomicCounter() {
        this.counter = new AtomicInteger(0);
    }
    
    /**
     * Zähler um 1 addieren.
     *
     * @return gibt den neuen Zählerstand zurück.
     */
    @Override
    public int increment() {
        return counter.incrementAndGet();
    }

    /**
     * Zähler um 1 subtrahieren.
     *
     * @return gibt den neuen Zählerstand zurück.
     */
    @Override
    public int decrement() {
        return counter.decrementAndGet();
    }

    /**
     * Liefert den Zählerstand.
     *
     * @return aktueller Zählerstand.
     */
    @Override
    public int get() {
        return counter.get();
    }
}
