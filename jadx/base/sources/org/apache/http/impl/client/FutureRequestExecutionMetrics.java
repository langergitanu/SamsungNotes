package org.apache.http.impl.client;

import androidx.glance.AbstractC2821a;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class FutureRequestExecutionMetrics {
    private final AtomicLong activeConnections = new AtomicLong();
    private final AtomicLong scheduledConnections = new AtomicLong();
    private final DurationCounter successfulConnections = new DurationCounter();
    private final DurationCounter failedConnections = new DurationCounter();
    private final DurationCounter requests = new DurationCounter();
    private final DurationCounter tasks = new DurationCounter();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DurationCounter {
        private final AtomicLong count = new AtomicLong(0);
        private final AtomicLong cumulativeDuration = new AtomicLong(0);

        public long averageDuration() {
            long j = this.count.get();
            if (j > 0) {
                return this.cumulativeDuration.get() / j;
            }
            return 0L;
        }

        public long count() {
            return this.count.get();
        }

        public void increment(long j) {
            this.count.incrementAndGet();
            this.cumulativeDuration.addAndGet(System.currentTimeMillis() - j);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[count=");
            sb.append(count());
            sb.append(", averageDuration=");
            return AbstractC2821a.m2224o(sb, "]", averageDuration());
        }
    }

    public long getActiveConnectionCount() {
        return this.activeConnections.get();
    }

    public AtomicLong getActiveConnections() {
        return this.activeConnections;
    }

    public long getFailedConnectionAverageDuration() {
        return this.failedConnections.averageDuration();
    }

    public long getFailedConnectionCount() {
        return this.failedConnections.count();
    }

    public DurationCounter getFailedConnections() {
        return this.failedConnections;
    }

    public long getRequestAverageDuration() {
        return this.requests.averageDuration();
    }

    public long getRequestCount() {
        return this.requests.count();
    }

    public DurationCounter getRequests() {
        return this.requests;
    }

    public long getScheduledConnectionCount() {
        return this.scheduledConnections.get();
    }

    public AtomicLong getScheduledConnections() {
        return this.scheduledConnections;
    }

    public long getSuccessfulConnectionAverageDuration() {
        return this.successfulConnections.averageDuration();
    }

    public long getSuccessfulConnectionCount() {
        return this.successfulConnections.count();
    }

    public DurationCounter getSuccessfulConnections() {
        return this.successfulConnections;
    }

    public long getTaskAverageDuration() {
        return this.tasks.averageDuration();
    }

    public long getTaskCount() {
        return this.tasks.count();
    }

    public DurationCounter getTasks() {
        return this.tasks;
    }

    public String toString() {
        return "[activeConnections=" + this.activeConnections + ", scheduledConnections=" + this.scheduledConnections + ", successfulConnections=" + this.successfulConnections + ", failedConnections=" + this.failedConnections + ", requests=" + this.requests + ", tasks=" + this.tasks + "]";
    }
}
