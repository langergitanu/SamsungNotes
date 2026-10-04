package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.internal.BackoffPolicy;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class ExponentialBackoffPolicy implements BackoffPolicy {
    private Random random = new Random();
    private long initialBackoffNanos = TimeUnit.SECONDS.toNanos(1);
    private long maxBackoffNanos = TimeUnit.MINUTES.toNanos(2);
    private double multiplier = 1.6d;
    private double jitter = 0.2d;
    private long nextBackoffNanos = this.initialBackoffNanos;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Provider implements BackoffPolicy.Provider {
        @Override // io.grpc.internal.BackoffPolicy.Provider
        public BackoffPolicy get() {
            return new ExponentialBackoffPolicy();
        }
    }

    private long uniformRandom(double d, double d2) {
        Preconditions.checkArgument(d2 >= d);
        return (long) ((this.random.nextDouble() * (d2 - d)) + d);
    }

    @Override // io.grpc.internal.BackoffPolicy
    public long nextBackoffNanos() {
        long j = this.nextBackoffNanos;
        double d = j;
        this.nextBackoffNanos = Math.min((long) (this.multiplier * d), this.maxBackoffNanos);
        double d2 = this.jitter;
        return j + uniformRandom((-d2) * d, d2 * d);
    }

    @VisibleForTesting
    public ExponentialBackoffPolicy setInitialBackoffNanos(long j) {
        this.initialBackoffNanos = j;
        return this;
    }

    @VisibleForTesting
    public ExponentialBackoffPolicy setJitter(double d) {
        this.jitter = d;
        return this;
    }

    @VisibleForTesting
    public ExponentialBackoffPolicy setMaxBackoffNanos(long j) {
        this.maxBackoffNanos = j;
        return this;
    }

    @VisibleForTesting
    public ExponentialBackoffPolicy setMultiplier(double d) {
        this.multiplier = d;
        return this;
    }

    @VisibleForTesting
    public ExponentialBackoffPolicy setRandom(Random random) {
        this.random = random;
        return this;
    }
}
