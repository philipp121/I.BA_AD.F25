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
package ch.hslu.ad.N1_EX_ThreadsSynch.joins;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Parametrierbarer Task, der auf einen fremden Thread wartet und danach für
 * eine bestimmte Zeit schläft.
 */
public class JoinAndSleepTask implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(JoinAndSleepTask.class);
    private final String taskName;
    private final Thread joinFor;
    private final int sleepTime;

    /**
     * Erzeugt einen Task mit Namen.
     * 
     * @param taskName der Name des Tasks.
     * @param sleepTime die Zeit in mSec die der Task schläft.
     */
    public JoinAndSleepTask(final String taskName, final int sleepTime) {
        this.taskName = taskName;
        this.joinFor = null;
        this.sleepTime = sleepTime;
    }

    /**
     * Erzeugt einen Task mit Namen.
     *
     * @param taskName der Name des Tasks.
     * @param sleepTime die Zeit in mSec die der Task schläft.
     */
    public JoinAndSleepTask(final String taskName, final int sleepTime, final Thread joinFor) {
        this.taskName = taskName;
        this.joinFor = joinFor;
        this.sleepTime = sleepTime;
    }

    /**
     * Hier wird auf das Ende des fremden Threads gewartet und danach für eine
     * bestimmte Zeit geschlafen. Beide Teile können unterbrochen werden.
     */
    @Override
    public void run() {
        LOG.info(taskName + " was started.");
        try {
            if (joinFor != null) {
                try {
                    joinFor.join();
                    LOG.info(taskName + " finished JOIN normally.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    LOG.warn(taskName + " was interrupted during JOIN.");
                    return;
                }
            }
            try {
                LOG.info(taskName + " is sleeping.");
                Thread.sleep(sleepTime);
                LOG.info(taskName + " finished SLEEP normally.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOG.warn(taskName + " was interrupted during SLEEP.");
                return;
            }
        } catch (Exception e) {
            LOG.error(taskName + " encountered unexpected error: {}", e.getMessage());
        }
        LOG.debug(taskName + " completed normally.");
    }
}
