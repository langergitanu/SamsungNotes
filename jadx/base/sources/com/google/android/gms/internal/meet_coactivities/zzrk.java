package com.google.android.gms.internal.meet_coactivities;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzrk extends zzrp {
    private final int zzc;

    public zzrk(byte[] bArr, int i, int i2) {
        super(bArr);
        zzrq.zzi(0, i2, bArr.length);
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrp, com.google.android.gms.internal.meet_coactivities.zzrq
    public final byte zza(int i) {
        int i2 = this.zzc;
        if (((i2 - (i + 1)) | i) >= 0) {
            return ((zzrp) this).zza[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(AbstractC0000a.m11h(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(AbstractC1038a.m1214o(i, i2, "Index > length: ", SQLKeyword.COMMA));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrp, com.google.android.gms.internal.meet_coactivities.zzrq
    public final byte zzb(int i) {
        return ((zzrp) this).zza[i];
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrp
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrp, com.google.android.gms.internal.meet_coactivities.zzrq
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrp, com.google.android.gms.internal.meet_coactivities.zzrq
    public final void zze(byte[] bArr, int i, int i2, int i4) {
        System.arraycopy(((zzrp) this).zza, 0, bArr, 0, i4);
    }
}
