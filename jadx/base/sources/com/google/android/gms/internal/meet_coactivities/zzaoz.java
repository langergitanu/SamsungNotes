package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaoz implements zzzy {
    private static final ThreadLocal zza = new ThreadLocal();
    private final zzul zzb;
    private final zzue zzc;

    public zzaoz(zzue zzueVar, int i) {
        this.zzc = (zzue) Preconditions.checkNotNull(zzueVar, "defaultInstance cannot be null");
        this.zzb = zzueVar.zzI();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.meet_coactivities.zzzy
    public final /* bridge */ /* synthetic */ InputStream zza(Object obj) {
        return new zzaoy(obj, this.zzb);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzy
    public final /* bridge */ /* synthetic */ Object zzb(InputStream inputStream) {
        zzrw zzrwVarZzI;
        byte[] bArr;
        try {
            int iAvailable = inputStream.available();
            if (iAvailable > 0 && iAvailable <= 4194304) {
                ThreadLocal threadLocal = zza;
                Reference reference = (Reference) threadLocal.get();
                if (reference == null || (bArr = (byte[]) reference.get()) == null || bArr.length < iAvailable) {
                    bArr = new byte[iAvailable];
                    threadLocal.set(new WeakReference(bArr));
                }
                int i = iAvailable;
                while (i > 0) {
                    int i2 = inputStream.read(bArr, iAvailable - i, i);
                    if (i2 == -1) {
                        break;
                    }
                    i -= i2;
                }
                if (i != 0) {
                    throw new RuntimeException("size inaccurate: " + iAvailable + " != " + (iAvailable - i));
                }
                zzrwVarZzI = zzrw.zzJ(bArr, 0, iAvailable);
            } else {
                if (iAvailable == 0) {
                    return this.zzc;
                }
                zzrwVarZzI = null;
            }
            if (zzrwVarZzI == null) {
                zzrwVarZzI = zzrw.zzI(inputStream, 4096);
            }
            zzrwVarZzI.zzG(Integer.MAX_VALUE);
            try {
                Object objZza = this.zzb.zza(zzrwVarZzI, zzapa.zza);
                try {
                    zzrwVarZzI.zzz(0);
                    return objZza;
                } catch (zzti e) {
                    throw e;
                }
            } catch (zzti e2) {
                throw new zzabf(zzabd.zzj.zze("Invalid protobuf byte sequence").zzd(e2), null);
            }
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }
}
