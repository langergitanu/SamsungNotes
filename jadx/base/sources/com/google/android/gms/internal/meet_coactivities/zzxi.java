package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxi implements Comparable {
    public static final /* synthetic */ int zza = 0;
    private static final zzxg zzb = new zzxg(null);
    private static final long zzc;
    private static final long zzd;
    private static final long zze;
    private final zzxh zzf;
    private final long zzg;
    private volatile boolean zzh;

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        zzc = nanos;
        zzd = -nanos;
        zze = TimeUnit.SECONDS.toNanos(1L);
    }

    private zzxi(zzxh zzxhVar, long j, long j2, boolean z) {
        this.zzf = zzxhVar;
        long jMin = Math.min(zzc, Math.max(zzd, j2));
        this.zzg = j + jMin;
        this.zzh = jMin <= 0;
    }

    public static zzxi zzc(long j, TimeUnit timeUnit) {
        zzxg zzxgVar = zzb;
        if (timeUnit == null) {
            throw new NullPointerException("units");
        }
        return new zzxi(zzxgVar, System.nanoTime(), timeUnit.toNanos(j), true);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzxi)) {
            return false;
        }
        zzxi zzxiVar = (zzxi) obj;
        return this.zzf == zzxiVar.zzf && this.zzg == zzxiVar.zzg;
    }

    public final int hashCode() {
        return Arrays.asList(this.zzf, Long.valueOf(this.zzg)).hashCode();
    }

    public final String toString() {
        long jZzb = zzb(TimeUnit.NANOSECONDS);
        long jAbs = Math.abs(jZzb);
        long j = zze;
        long j2 = jAbs / j;
        long jAbs2 = Math.abs(jZzb) % j;
        StringBuilder sb = new StringBuilder();
        if (jZzb < 0) {
            sb.append('-');
        }
        sb.append(j2);
        if (jAbs2 > 0) {
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        }
        sb.append("s from now");
        zzxh zzxhVar = this.zzf;
        if (zzxhVar != zzb) {
            sb.append(" (ticker=" + zzxhVar.toString() + ")");
        }
        return sb.toString();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxi zzxiVar) {
        zzxh zzxhVar = this.zzf;
        if (zzxhVar != zzxiVar.zzf) {
            throw new AssertionError(AbstractC0541b.m775q("Tickers (", zzxhVar.toString(), " and ", zzxiVar.zzf.toString(), ") don't match. Custom Ticker should only be used in tests!"));
        }
        long j = this.zzg - zzxiVar.zzg;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    public final long zzb(TimeUnit timeUnit) {
        long jNanoTime = System.nanoTime();
        if (!this.zzh && this.zzg - jNanoTime <= 0) {
            this.zzh = true;
        }
        return timeUnit.convert(this.zzg - jNanoTime, TimeUnit.NANOSECONDS);
    }

    public final boolean zzd() {
        if (!this.zzh) {
            if (this.zzg - System.nanoTime() > 0) {
                return false;
            }
            this.zzh = true;
        }
        return true;
    }
}
