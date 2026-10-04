package com.nimbusds.jose.util.health;

import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.util.events.Event;
import java.util.Objects;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public class HealthReport<S, C extends SecurityContext> implements Event<S, C> {
    private final C context;
    private final Exception exception;
    private final S source;
    private final HealthStatus status;
    private final long timestamp;

    public HealthReport(S s, HealthStatus healthStatus, long j, C c) {
        this(s, healthStatus, null, j, c);
    }

    @Override // com.nimbusds.jose.util.events.Event
    public C getContext() {
        return this.context;
    }

    public Exception getException() {
        return this.exception;
    }

    public HealthStatus getHealthStatus() {
        return this.status;
    }

    @Override // com.nimbusds.jose.util.events.Event
    public S getSource() {
        return this.source;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        return "HealthReport{source=" + this.source + ", status=" + this.status + ", exception=" + this.exception + ", timestamp=" + this.timestamp + ", context=" + this.context + '}';
    }

    public HealthReport(S s, HealthStatus healthStatus, Exception exc, long j, C c) {
        Objects.requireNonNull(s);
        this.source = s;
        Objects.requireNonNull(healthStatus);
        this.status = healthStatus;
        if (exc != null && HealthStatus.HEALTHY.equals(healthStatus)) {
            throw new IllegalArgumentException("Exception not accepted for a healthy status");
        }
        this.exception = exc;
        this.timestamp = j;
        this.context = c;
    }
}
