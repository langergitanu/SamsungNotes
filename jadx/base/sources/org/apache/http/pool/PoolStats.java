package org.apache.http.pool;

import androidx.glance.AbstractC2821a;
import org.apache.http.annotation.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class PoolStats {
    private final int available;
    private final int leased;
    private final int max;
    private final int pending;

    public PoolStats(int i, int i2, int i4, int i5) {
        this.leased = i;
        this.pending = i2;
        this.available = i4;
        this.max = i5;
    }

    public int getAvailable() {
        return this.available;
    }

    public int getLeased() {
        return this.leased;
    }

    public int getMax() {
        return this.max;
    }

    public int getPending() {
        return this.pending;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[leased: ");
        sb.append(this.leased);
        sb.append("; pending: ");
        sb.append(this.pending);
        sb.append("; available: ");
        sb.append(this.available);
        sb.append("; max: ");
        return AbstractC2821a.m2223n(sb, "]", this.max);
    }
}
