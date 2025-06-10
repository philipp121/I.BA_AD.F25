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
package ch.hslu.ad.N2_EX_ThreadSteuerung.signal;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Demonstration verschiedener Initialisierungen eines nach oben begrenzten
 * Semaphors.
 */
public final class DemoSema {

    private static final Logger LOG = LoggerFactory.getLogger(DemoSema.class);

    /**
     * Privater Konstruktor.
     */
    private DemoSema() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn das warten unterbrochen wird.
     */
    public static void main(final String[] args) throws InterruptedException {
        try {
            new Semaphore(4, 3);
        } catch (IllegalArgumentException e) {
            LOG.debug(e.getMessage());
        }
        try {
            Semaphore sema = new Semaphore(3, 3);
            sema.release();
        } catch (ArithmeticException e) {
            LOG.debug(e.getMessage());
        }
        try {
            Semaphore sema = new Semaphore(0, 3);
            sema.release(4);
        } catch (ArithmeticException e) {
            LOG.debug(e.getMessage());
        }
        try {
            Semaphore sema = new Semaphore(3, 3);
            sema.acquire(4);
        } catch (ArithmeticException e) {
            LOG.debug(e.getMessage());
        }
        try {
            Semaphore sema = new Semaphore(3, 3);
            sema.acquire(-1);
        } catch (IllegalArgumentException e) {
            LOG.debug(e.getMessage());
        }
        try {
            Semaphore sema = new Semaphore(1, 3);
            sema.release(-1);
        } catch (IllegalArgumentException e) {
            LOG.debug(e.getMessage());
        }
    }
}
