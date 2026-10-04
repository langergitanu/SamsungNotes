package com.google.android.gms.internal.fido;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzdb extends zzdd {
    private final byte[] zzb;
    private int zzc;
    private int zzd;
    private int zze;

    public /* synthetic */ zzdb(byte[] bArr, int i, int i2, boolean z, zzda zzdaVar) {
        super(null);
        this.zze = Integer.MAX_VALUE;
        this.zzb = bArr;
        this.zzc = 0;
    }

    public final int zza(int i) {
        int i2 = this.zze;
        this.zze = 0;
        int i4 = this.zzc + this.zzd;
        this.zzc = i4;
        if (i4 <= 0) {
            this.zzd = 0;
            return i2;
        }
        this.zzd = i4;
        this.zzc = 0;
        return i2;
    }
}
