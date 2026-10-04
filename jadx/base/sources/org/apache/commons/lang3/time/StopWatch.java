package org.apache.commons.lang3.time;

import androidx.appcompat.widget.AbstractC0541b;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.apache.commons.lang3.function.FailableRunnable;
import org.apache.commons.lang3.function.FailableSupplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StopWatch {
    private static final long NANO_2_MILLIS = 1000000;
    private final String message;
    private State runningState;
    private SplitState splitState;
    private Instant startInstant;
    private long startTimeNanos;
    private Instant stopInstant;
    private long stopTimeNanos;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SplitState {
        SPLIT,
        UNSPLIT
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        RUNNING { // from class: org.apache.commons.lang3.time.StopWatch.State.1
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStarted() {
                return true;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStopped() {
                return false;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isSuspended() {
                return false;
            }
        },
        STOPPED { // from class: org.apache.commons.lang3.time.StopWatch.State.2
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStarted() {
                return false;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStopped() {
                return true;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isSuspended() {
                return false;
            }
        },
        SUSPENDED { // from class: org.apache.commons.lang3.time.StopWatch.State.3
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStarted() {
                return true;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStopped() {
                return false;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isSuspended() {
                return true;
            }
        },
        UNSTARTED { // from class: org.apache.commons.lang3.time.StopWatch.State.4
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStarted() {
                return false;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStopped() {
                return true;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isSuspended() {
                return false;
            }
        };

        public abstract boolean isStarted();

        public abstract boolean isStopped();

        public abstract boolean isSuspended();
    }

    public StopWatch() {
        this(null);
    }

    public static StopWatch create() {
        return new StopWatch();
    }

    public static StopWatch createStarted() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        return stopWatch;
    }

    private long nanosToMillis(long j) {
        return j / 1000000;
    }

    private void startResume() {
        if (isStopped()) {
            start();
        } else if (isSuspended()) {
            resume();
        }
    }

    public String formatSplitTime() {
        return DurationFormatUtils.formatDurationHMS(getSplitDuration().toMillis());
    }

    public String formatTime() {
        return DurationFormatUtils.formatDurationHMS(getTime());
    }

    public <T> T get(Supplier<T> supplier) {
        startResume();
        try {
            return supplier.get();
        } finally {
            suspend();
        }
    }

    public Duration getDuration() {
        return Duration.ofNanos(getNanoTime());
    }

    public String getMessage() {
        return this.message;
    }

    public long getNanoTime() {
        long jNanoTime;
        long j;
        int iOrdinal = this.runningState.ordinal();
        if (iOrdinal == 0) {
            jNanoTime = System.nanoTime();
            j = this.startTimeNanos;
        } else {
            if (iOrdinal != 1 && iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return 0L;
                }
                throw new IllegalStateException("Illegal running state has occurred.");
            }
            jNanoTime = this.stopTimeNanos;
            j = this.startTimeNanos;
        }
        return jNanoTime - j;
    }

    public Duration getSplitDuration() {
        return Duration.ofNanos(getSplitNanoTime());
    }

    public long getSplitNanoTime() {
        if (this.splitState == SplitState.SPLIT) {
            return this.stopTimeNanos - this.startTimeNanos;
        }
        throw new IllegalStateException("Stopwatch must be split to get the split time.");
    }

    @Deprecated
    public long getSplitTime() {
        return nanosToMillis(getSplitNanoTime());
    }

    public Instant getStartInstant() {
        if (this.runningState != State.UNSTARTED) {
            return this.startInstant;
        }
        throw new IllegalStateException("Stopwatch has not been started");
    }

    @Deprecated
    public long getStartTime() {
        return getStartInstant().toEpochMilli();
    }

    public Instant getStopInstant() {
        if (this.runningState != State.UNSTARTED) {
            return this.stopInstant;
        }
        throw new IllegalStateException("Stopwatch has not been started");
    }

    @Deprecated
    public long getStopTime() {
        return getStopInstant().toEpochMilli();
    }

    public <T, E extends Throwable> T getT(FailableSupplier<T, E> failableSupplier) {
        startResume();
        try {
            return failableSupplier.get();
        } finally {
            suspend();
        }
    }

    public long getTime() {
        return nanosToMillis(getNanoTime());
    }

    public boolean isStarted() {
        return this.runningState.isStarted();
    }

    public boolean isStopped() {
        return this.runningState.isStopped();
    }

    public boolean isSuspended() {
        return this.runningState.isSuspended();
    }

    public void reset() {
        this.runningState = State.UNSTARTED;
        this.splitState = SplitState.UNSPLIT;
    }

    public void resume() {
        if (this.runningState != State.SUSPENDED) {
            throw new IllegalStateException("Stopwatch must be suspended to resume.");
        }
        this.startTimeNanos = (System.nanoTime() - this.stopTimeNanos) + this.startTimeNanos;
        this.runningState = State.RUNNING;
    }

    public void run(Runnable runnable) {
        startResume();
        try {
            runnable.run();
        } finally {
            suspend();
        }
    }

    public <E extends Throwable> void runT(FailableRunnable<E> failableRunnable) {
        startResume();
        try {
            failableRunnable.run();
        } finally {
            suspend();
        }
    }

    public void split() {
        if (this.runningState != State.RUNNING) {
            throw new IllegalStateException("Stopwatch is not running.");
        }
        this.stopTimeNanos = System.nanoTime();
        this.splitState = SplitState.SPLIT;
    }

    public void start() {
        State state = this.runningState;
        if (state == State.STOPPED) {
            throw new IllegalStateException("Stopwatch must be reset before being restarted.");
        }
        if (state != State.UNSTARTED) {
            throw new IllegalStateException("Stopwatch already started.");
        }
        this.startTimeNanos = System.nanoTime();
        this.startInstant = Instant.now();
        this.runningState = State.RUNNING;
    }

    public void stop() {
        State state = this.runningState;
        State state2 = State.RUNNING;
        if (state != state2 && state != State.SUSPENDED) {
            throw new IllegalStateException("Stopwatch is not running.");
        }
        if (state == state2) {
            this.stopTimeNanos = System.nanoTime();
            this.stopInstant = Instant.now();
        }
        this.runningState = State.STOPPED;
    }

    public void suspend() {
        if (this.runningState != State.RUNNING) {
            throw new IllegalStateException("Stopwatch must be running to suspend.");
        }
        this.stopTimeNanos = System.nanoTime();
        this.stopInstant = Instant.now();
        this.runningState = State.SUSPENDED;
    }

    public String toSplitString() {
        String string = Objects.toString(this.message, "");
        String splitTime = formatSplitTime();
        return string.isEmpty() ? splitTime : AbstractC0541b.m757C(string, " ", splitTime);
    }

    public String toString() {
        String string = Objects.toString(this.message, "");
        String time = formatTime();
        return string.isEmpty() ? time : AbstractC0541b.m757C(string, " ", time);
    }

    public void unsplit() {
        if (this.splitState != SplitState.SPLIT) {
            throw new IllegalStateException("Stopwatch has not been split.");
        }
        this.splitState = SplitState.UNSPLIT;
    }

    public StopWatch(String str) {
        this.runningState = State.UNSTARTED;
        this.splitState = SplitState.UNSPLIT;
        this.message = str;
    }

    public long getTime(TimeUnit timeUnit) {
        return timeUnit.convert(getNanoTime(), TimeUnit.NANOSECONDS);
    }
}
