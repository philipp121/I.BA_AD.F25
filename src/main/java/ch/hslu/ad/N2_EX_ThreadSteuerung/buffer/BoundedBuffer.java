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
package ch.hslu.ad.N2_EX_ThreadSteuerung.buffer;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Puffer nach dem First In First Out Prinzip mit einer begrenzten Kapazität.
 * Der Puffer ist thread sicher.
 *
 * @param <T> Elememente des Buffers
 */
public final class BoundedBuffer<T> implements Buffer<T> {

    private final ArrayDeque<T> queue;
    private final Semaphore putSema;
    private final Semaphore takeSema;
    private int size = 0;

    /**
     * Erzeugt einen Puffer mit bestimmter Kapazität.
     *
     * @param n Kapazität des Puffers
     */
    public BoundedBuffer(final int n) {
        queue = new ArrayDeque<>(n);
        putSema = new Semaphore(n);
        takeSema = new Semaphore(0);
    }

    @Override
    public void add(final T elem) throws InterruptedException {
        putSema.acquire();
        synchronized (queue) {
            queue.addFirst(elem);
            size++;
        }
        takeSema.release();
    }

    @Override
    public T remove() throws InterruptedException {
        takeSema.acquire();
        T elem;
        synchronized (queue) {
            elem = queue.removeLast();
            size--;
        }
        putSema.release();
        return elem;
    }

    @Override
    public boolean add(T elem, long millis) throws InterruptedException {
        if (putSema.tryAcquire(millis, TimeUnit.MILLISECONDS)) {
            synchronized (queue) {
                queue.addFirst(elem);
                size++;
            }
            takeSema.release();
            return true;
        }
        return false; // Timeout
    }

    @Override
    public T remove(long millis) throws InterruptedException {
        if (takeSema.tryAcquire(millis, TimeUnit.MILLISECONDS)){
            T elem;
            synchronized (queue) {
                elem = queue.removeLast();
                size--;
            }
            putSema.release();
            return elem;
        }
        return null; // timeout
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public boolean full() {
        return size == queue.size();
    }

    @Override
    public int size() {
        return size;
    }
}
