package com.google.android.gms.internal.fido;

import java.io.IOException;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzcf extends zzcg {
    private zzcf(zzcd zzcdVar, @CheckForNull Character ch) {
        super(zzcdVar, ch);
        zzap.zzc(zzcdVar.zzf.length == 64);
    }

    @Override // com.google.android.gms.internal.fido.zzcg
    public final zzch zza(zzcd zzcdVar, @CheckForNull Character ch) {
        return new zzcf(zzcdVar, ch);
    }

    @Override // com.google.android.gms.internal.fido.zzcg, com.google.android.gms.internal.fido.zzch
    public final void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i4 = 0;
        zzap.zze(0, i2, bArr.length);
        for (int i5 = i2; i5 >= 3; i5 -= 3) {
            int i6 = bArr[i4] & 255;
            int i7 = ((bArr[i4 + 1] & 255) << 8) | (i6 << 16) | (bArr[i4 + 2] & 255);
            appendable.append(this.zzb.zza(i7 >>> 18));
            appendable.append(this.zzb.zza((i7 >>> 12) & 63));
            appendable.append(this.zzb.zza((i7 >>> 6) & 63));
            appendable.append(this.zzb.zza(i7 & 63));
            i4 += 3;
        }
        if (i4 < i2) {
            zze(appendable, bArr, i4, i2 - i4);
        }
    }

    public zzcf(String str, String str2, @CheckForNull Character ch) {
        this(new zzcd(str, str2.toCharArray()), ch);
    }
}
