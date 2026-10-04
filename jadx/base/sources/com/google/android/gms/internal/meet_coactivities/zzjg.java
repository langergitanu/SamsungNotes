package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzjg extends zzjt {
    private final Object zza;
    private final Object zzb;

    public zzjg(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("Null state");
        }
        this.zza = obj;
        if (obj2 == null) {
            throw new NullPointerException("Null metadata");
        }
        this.zzb = obj2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzjt) {
            zzjt zzjtVar = (zzjt) obj;
            if (this.zza.equals(zzjtVar.zzb()) && this.zzb.equals(zzjtVar.zza())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    public final String toString() {
        return AbstractC0541b.m775q("ThinLocalStateResult{state=", this.zza.toString(), ", metadata=", this.zzb.toString(), "}");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzjt
    public final Object zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzjt
    public final Object zzb() {
        return this.zza;
    }
}
