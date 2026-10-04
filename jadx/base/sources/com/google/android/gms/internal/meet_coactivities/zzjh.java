package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzjh extends zzju {
    private final zzpx zza;
    private final int zzb;

    public zzjh(int i, zzpx zzpxVar) {
        this.zzb = i;
        if (zzpxVar == null) {
            throw new NullPointerException("Null update");
        }
        this.zza = zzpxVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzju) {
            zzju zzjuVar = (zzju) obj;
            if (this.zzb == zzjuVar.zzb() && this.zza.equals(zzjuVar.zza())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zzb ^ 1000003) * 1000003) ^ this.zza.hashCode();
    }

    public final String toString() {
        return AbstractC0541b.m775q("ThinLocalStateUpdateResult{outcome=", this.zzb != 1 ? "UPDATED" : "NO_OP", ", update=", this.zza.toString(), "}");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzju
    public final zzpx zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzju
    public final int zzb() {
        return this.zzb;
    }
}
