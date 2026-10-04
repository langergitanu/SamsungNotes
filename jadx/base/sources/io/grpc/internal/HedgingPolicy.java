package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import io.grpc.Status;
import java.util.Collection;
import java.util.Set;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Immutable
final class HedgingPolicy {
    final long hedgingDelayNanos;
    final int maxAttempts;
    final Set<Status.Code> nonFatalStatusCodes;

    public HedgingPolicy(int i, long j, Set<Status.Code> set) {
        this.maxAttempts = i;
        this.hedgingDelayNanos = j;
        this.nonFatalStatusCodes = ImmutableSet.copyOf((Collection) set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && HedgingPolicy.class == obj.getClass()) {
            HedgingPolicy hedgingPolicy = (HedgingPolicy) obj;
            if (this.maxAttempts == hedgingPolicy.maxAttempts && this.hedgingDelayNanos == hedgingPolicy.hedgingDelayNanos && Objects.equal(this.nonFatalStatusCodes, hedgingPolicy.nonFatalStatusCodes)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.maxAttempts), Long.valueOf(this.hedgingDelayNanos), this.nonFatalStatusCodes);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("maxAttempts", this.maxAttempts).add("hedgingDelayNanos", this.hedgingDelayNanos).add("nonFatalStatusCodes", this.nonFatalStatusCodes).toString();
    }
}
