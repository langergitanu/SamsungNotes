package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzl extends zzj {
    private static final WeakReference zza = new WeakReference(null);
    private WeakReference zzb;

    public zzl(byte[] bArr) {
        super(bArr);
        this.zzb = zza;
    }

    public abstract byte[] zzb();

    @Override // com.google.android.gms.common.zzj
    public final byte[] zzf() {
        byte[] bArrZzb;
        synchronized (this) {
            try {
                bArrZzb = (byte[]) this.zzb.get();
                if (bArrZzb == null) {
                    bArrZzb = zzb();
                    this.zzb = new WeakReference(bArrZzb);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrZzb;
    }
}
