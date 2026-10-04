package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzuo implements zzub {
    private final zzue zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zzuo(zzue zzueVar, String str, Object[] objArr) {
        this.zza = zzueVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 1;
        int i4 = 13;
        while (true) {
            int i5 = i2 + 1;
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 < 55296) {
                this.zzd = i | (cCharAt2 << i4);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i4;
                i4 += 13;
                i2 = i5;
            }
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzub
    public final zzue zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzub
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzub
    public final int zzc() {
        int i = this.zzd;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}
