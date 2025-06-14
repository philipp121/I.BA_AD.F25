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

import ch.hslu.ad.N4_EX_Frameworks.mergesort.MergesortRecursive;
import ch.hslu.ad.N4_EX_Frameworks.mergesort.MergesortTask;

import java.util.concurrent.RecursiveAction;

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
@SuppressWarnings("serial")
public final class QuicksortTask extends RecursiveAction {

    private static final int THRESHOLD = 100_000;
    /**
     * Zu sortierendes Array.
     */
    private final int[] array;
    /**
     * Unterer Array-Index des Sortierbereichs.
     */
    private final int min;
    /**
     * Oberer Array-Index des Sortierbereichs.
     */
    private final int max;

    /**
     * Erzeugt einen Array-Sortier Task.
     *
     * @param array Interger-Array.
     */
    public QuicksortTask(int[] array) {
        this(array, 0, array.length - 1);
    }

    private QuicksortTask(final int[] array, final int min, final int max) {
        this.array = array;
        this.min = min;
        this.max = max;
    }

    @Override
    protected void compute() {
        if (max - min < THRESHOLD) {
            QuicksortRecursive.quicksort(array, min, max);
        } else {
            final int pivot = QuicksortRecursive.partition(array, min, max);
            invokeAll(
                    new QuicksortTask(array, min, pivot),
                    new QuicksortTask(array, pivot + 1, max));
        }
    }
}
