package com.google.android.gms.internal.meet_coactivities;

import androidx.compose.foundation.layout.AbstractC1038a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzlj extends zzlk {
    private final String zzb;
    private final String zzc;
    private final int zzd;
    private final String zze;
    private int zzf = 0;

    public /* synthetic */ zzlj(String str, String str2, int i, String str3, zzli zzliVar) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = i;
        this.zze = str3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzlj) {
            zzlj zzljVar = (zzlj) obj;
            if (this.zzc.equals(zzljVar.zzc) && this.zzd == zzljVar.zzd && zzb().equals(zzljVar.zzb())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzf;
        if (i != 0) {
            return i;
        }
        int iM1202c = AbstractC1038a.m1202c(4867, 31, this.zzc) + this.zzd;
        this.zzf = iM1202c;
        return iM1202c;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlk
    public final int zza() {
        return (char) this.zzd;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlk
    public final String zzb() {
        return this.zzb.replace('/', '.');
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlk
    public final String zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlk
    public final String zzd() {
        return this.zzc;
    }
}
