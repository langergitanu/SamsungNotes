package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzakx {
    static final zzwb zza = zzwb.zza("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");
    final Long zzb;
    final Boolean zzc;
    final Integer zzd;
    final Integer zze;
    final zzans zzf;
    final zzahw zzg;

    public zzakx(Map map, boolean z, int i, int i2) {
        long j;
        zzans zzansVar;
        zzahw zzahwVar;
        this.zzb = zzaiu.zzd(map, "timeout");
        this.zzc = zzaiu.zza(map, "waitForReady");
        Integer numZzc = zzaiu.zzc(map, "maxResponseMessageBytes");
        this.zzd = numZzc;
        if (numZzc != null) {
            Preconditions.checkArgument(numZzc.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", numZzc);
        }
        Integer numZzc2 = zzaiu.zzc(map, "maxRequestMessageBytes");
        this.zze = numZzc2;
        if (numZzc2 != null) {
            Preconditions.checkArgument(numZzc2.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", numZzc2);
        }
        Map mapZzj = z ? zzaiu.zzj(map, "retryPolicy") : null;
        if (mapZzj == null) {
            j = 0;
            zzansVar = null;
        } else {
            int iIntValue = ((Integer) Preconditions.checkNotNull(zzaiu.zzc(mapZzj, "maxAttempts"), "maxAttempts cannot be empty")).intValue();
            Preconditions.checkArgument(iIntValue >= 2, "maxAttempts must be greater than 1: %s", iIntValue);
            int iMin = Math.min(iIntValue, 5);
            long jLongValue = ((Long) Preconditions.checkNotNull(zzaiu.zzd(mapZzj, "initialBackoff"), "initialBackoff cannot be empty")).longValue();
            Preconditions.checkArgument(jLongValue > 0, "initialBackoffNanos must be greater than 0: %s", jLongValue);
            long jLongValue2 = ((Long) Preconditions.checkNotNull(zzaiu.zzd(mapZzj, "maxBackoff"), "maxBackoff cannot be empty")).longValue();
            Preconditions.checkArgument(jLongValue2 > 0, "maxBackoff must be greater than 0: %s", jLongValue2);
            Double d = (Double) Preconditions.checkNotNull(zzaiu.zzb(mapZzj, "backoffMultiplier"), "backoffMultiplier cannot be empty");
            double dDoubleValue = d.doubleValue();
            j = 0;
            Preconditions.checkArgument(dDoubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", d);
            Long lZzd = zzaiu.zzd(mapZzj, "perAttemptRecvTimeout");
            Preconditions.checkArgument(lZzd == null || lZzd.longValue() >= 0, "perAttemptRecvTimeout cannot be negative: %s", lZzd);
            Set setZzb = zzaok.zzb(mapZzj);
            Preconditions.checkArgument((lZzd == null && setZzb.isEmpty()) ? false : true, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            zzansVar = new zzans(iMin, jLongValue, jLongValue2, dDoubleValue, lZzd, setZzb);
        }
        this.zzf = zzansVar;
        Map mapZzj2 = z ? zzaiu.zzj(map, "hedgingPolicy") : null;
        if (mapZzj2 == null) {
            zzahwVar = null;
        } else {
            int iIntValue2 = ((Integer) Preconditions.checkNotNull(zzaiu.zzc(mapZzj2, "maxAttempts"), "maxAttempts cannot be empty")).intValue();
            Preconditions.checkArgument(iIntValue2 >= 2, "maxAttempts must be greater than 1: %s", iIntValue2);
            int iMin2 = Math.min(iIntValue2, 5);
            long jLongValue3 = ((Long) Preconditions.checkNotNull(zzaiu.zzd(mapZzj2, "hedgingDelay"), "hedgingDelay cannot be empty")).longValue();
            Preconditions.checkArgument(jLongValue3 >= j, "hedgingDelay must not be negative: %s", jLongValue3);
            zzahwVar = new zzahw(iMin2, jLongValue3, zzaok.zza(mapZzj2));
        }
        this.zzg = zzahwVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzakx)) {
            return false;
        }
        zzakx zzakxVar = (zzakx) obj;
        return Objects.equal(this.zzb, zzakxVar.zzb) && Objects.equal(this.zzc, zzakxVar.zzc) && Objects.equal(this.zzd, zzakxVar.zzd) && Objects.equal(this.zze, zzakxVar.zze) && Objects.equal(this.zzf, zzakxVar.zzf) && Objects.equal(this.zzg, zzakxVar.zzg);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("timeoutNanos", this.zzb).add("waitForReady", this.zzc).add("maxInboundMessageSize", this.zzd).add("maxOutboundMessageSize", this.zze).add("retryPolicy", this.zzf).add("hedgingPolicy", this.zzg).toString();
    }
}
