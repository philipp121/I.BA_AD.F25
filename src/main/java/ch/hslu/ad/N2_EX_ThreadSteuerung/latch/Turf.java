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
package ch.hslu.ad.N2_EX_ThreadSteuerung.latch;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.concurrent.CountDownLatch;

/**
 * Eine Rennbahn für das Pferderennen.
 */
public final class Turf {

    private static final Logger LOG = LoggerFactory.getLogger(Turf.class);
    private static final int HORSES = 5;


    /**
     * Privater Konstruktor.
     */
    private Turf() {
    }

    /**
     * Main-Demo.
     * @param args not used.
     */
    public static void main(final String[] args) throws InterruptedException{
        final Synch starterBox = new Latch();
        final CountDownLatch ready = new CountDownLatch(HORSES);
        for (int i = 1; i <= HORSES; i++) {
            final String name = "Horse " + i;
            Thread.startVirtualThread(() -> {
                ready.countDown();
                new RaceHorse(starterBox, name).run();
            });
        }
        //Thread.sleep(1000);
        ready.await();
        LOG.info("Start...");
        starterBox.release();

        Thread.sleep(4000);
    }
}
