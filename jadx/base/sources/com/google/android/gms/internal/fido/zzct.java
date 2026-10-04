package com.google.android.gms.internal.fido;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzct extends zzcw {
    private final int zzc;
    private final int zzd;

    public zzct(byte[] bArr, int i, int i2) {
        super(bArr);
        zzcz.zzj(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.fido.zzcw, com.google.android.gms.internal.fido.zzcz
    public final byte zza(int i) {
        int i2 = this.zzd;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zza[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(AbstractC0000a.m11h(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(AbstractC1038a.m1214o(i, i2, "Index > length: ", SQLKeyword.COMMA));
    }

    @Override // com.google.android.gms.internal.fido.zzcw, com.google.android.gms.internal.fido.zzcz
    public final byte zzb(int i) {
        return this.zza[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.fido.zzcw
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.fido.zzcw, com.google.android.gms.internal.fido.zzcz
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.fido.zzcw, com.google.android.gms.internal.fido.zzcz
    public final void zze(byte[] bArr, int i, int i2, int i4) {
        System.arraycopy(this.zza, this.zzc, bArr, 0, i4);
    }
}
