package com.google.android.gms.internal.fido;

import java.io.IOException;
import javax.annotation.CheckForNull;
import net.lingala.zip4j.crypto.PBKDF2.BinTools;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzce extends zzcg {
    final char[] zza;

    private zzce(zzcd zzcdVar) {
        super(zzcdVar, null);
        this.zza = new char[512];
        zzap.zzc(zzcdVar.zzf.length == 16);
        for (int i = 0; i < 256; i++) {
            this.zza[i] = zzcdVar.zza(i >>> 4);
            this.zza[i | 256] = zzcdVar.zza(i & 15);
        }
    }

    @Override // com.google.android.gms.internal.fido.zzcg
    public final zzch zza(zzcd zzcdVar, @CheckForNull Character ch) {
        return new zzce(zzcdVar);
    }

    @Override // com.google.android.gms.internal.fido.zzcg, com.google.android.gms.internal.fido.zzch
    public final void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzap.zze(0, i2, bArr.length);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = bArr[i4] & 255;
            appendable.append(this.zza[i5]);
            appendable.append(this.zza[i5 | 256]);
        }
    }

    public zzce(String str, String str2) {
        this(new zzcd("base16()", BinTools.hex.toCharArray()));
    }
}
