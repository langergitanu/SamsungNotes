package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzit;
import com.google.android.gms.internal.drive.zziu;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class zzit<MessageType extends zzit<MessageType, BuilderType>, BuilderType extends zziu<MessageType, BuilderType>> implements zzlq {
    private static boolean zznf = false;
    protected int zzne = 0;

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzcx()];
            zzjr zzjrVarZzb = zzjr.zzb(bArr);
            zzb(zzjrVarZzb);
            zzjrVarZzb.zzcb();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder("byte array".length() + name.length() + 62);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    @Override // com.google.android.gms.internal.drive.zzlq
    public final zzjc zzbl() {
        try {
            zzjk zzjkVarZzu = zzjc.zzu(zzcx());
            zzb(zzjkVarZzu.zzby());
            return zzjkVarZzu.zzbx();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder("ByteString".length() + name.length() + 62);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public int zzbm() {
        throw new UnsupportedOperationException();
    }

    public void zzo(int i) {
        throw new UnsupportedOperationException();
    }
}
