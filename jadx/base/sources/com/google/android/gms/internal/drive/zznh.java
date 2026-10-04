package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes5.dex */
abstract class zznh {
    public abstract int zzb(int i, byte[] bArr, int i2, int i4);

    public abstract int zzb(CharSequence charSequence, byte[] bArr, int i, int i2);

    public final boolean zze(byte[] bArr, int i, int i2) {
        return zzb(0, bArr, i, i2) == 0;
    }

    public abstract String zzg(byte[] bArr, int i, int i2);
}
