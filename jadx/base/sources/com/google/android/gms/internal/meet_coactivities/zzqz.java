package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.internal.meet_coactivities.zzqy;
import com.google.android.gms.internal.meet_coactivities.zzqz;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzqz<MessageType extends zzqz<MessageType, BuilderType>, BuilderType extends zzqy<MessageType, BuilderType>> implements zzue {
    protected int zza = 0;

    public int zzv(zzuq zzuqVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzue
    public final zzrq zzw() {
        try {
            int iZzz = zzz();
            zzrq zzrqVar = zzrq.zzb;
            byte[] bArr = new byte[iZzz];
            zzry zzryVar = new zzry(bArr, 0, iZzz);
            zzS(zzryVar);
            return zzrm.zza(zzryVar, bArr);
        } catch (IOException e) {
            throw new RuntimeException(AbstractC0541b.m773o("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzue
    public final byte[] zzx() {
        try {
            int iZzz = zzz();
            byte[] bArr = new byte[iZzz];
            zzry zzryVar = new zzry(bArr, 0, iZzz);
            zzS(zzryVar);
            zzryVar.zzC();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(AbstractC0541b.m773o("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }
}
