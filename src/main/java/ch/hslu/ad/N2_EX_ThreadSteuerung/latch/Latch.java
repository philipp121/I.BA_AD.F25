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

/**
 * Eine Synchronisationshilfe, die es ermöglicht, einen oder mehrere Threads warten zu lassen, bis
 * diese durch andere Threads aufgeweckt werden. Latches sperren so lange, bis sie einmal ausgelöst
 * werden. Danach sind sie frei passierbar.
 */
public final class Latch implements Synch {

    private boolean released = false;
    private static final Object LOCK = new Object();

    /**
     * Erzeugt ein Latch.
     */
    public Latch() {
    }
    
    @Override
    public void acquire() throws InterruptedException {
        synchronized (LOCK) {
            while (!released) {
                LOCK.wait();
            }
        }
    }

    @Override
    public void release() {
        released = true;
        synchronized (LOCK){
            LOCK.notifyAll();
        }

    }
}
