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
package ch.hslu.ad.N1_EX_ThreadsSynch.balls;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Demonstration von Bällen.
 */
public final class DemoBalls {

    private static final int BALL_COUNT = 50;

    /**
     * Privater Konstruktor.
     */
    private DemoBalls() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final String[] colors = {"red", "black", "blue", "yellow", "green", "magenta"};

        final Canvas canvas = Canvas.getCanvas();
        final int canvasWidth = canvas.getWidth();

        for (int i = 0; i < BALL_COUNT; i++) {
            int size = ThreadLocalRandom.current().nextInt(20, 51); // 20–50
            int x = ThreadLocalRandom.current().nextInt(0, canvasWidth - size);
            int y = 0;
            String color = colors[ThreadLocalRandom.current().nextInt(colors.length)];

            Ball ball = new Ball(size, x, y, color);
            //Thread thread = new Thread(ball);
            //thread.start();
            Thread.startVirtualThread(ball);
        }
    }
}
