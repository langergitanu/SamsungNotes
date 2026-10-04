package com.google.android.gms.internal.meet_coactivities;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class zzrp extends zzro {
    protected final byte[] zza;

    public zzrp(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrq
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzrq) || zzd() != ((zzrq) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzrp)) {
            return obj.equals(this);
        }
        zzrp zzrpVar = (zzrp) obj;
        int iZzj = zzj();
        int iZzj2 = zzrpVar.zzj();
        if (iZzj != 0 && iZzj2 != 0 && iZzj != iZzj2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzrpVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzrpVar.zzd()) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(iZzd, zzrpVar.zzd(), "Ran off end of other: 0, ", SQLKeyword.COMMA));
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzrpVar.zza;
        zzrpVar.zzc();
        int i = 0;
        int i2 = 0;
        while (i < iZzd) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrq
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrq
    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrq
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrq
    public void zze(byte[] bArr, int i, int i2, int i4) {
        System.arraycopy(this.zza, 0, bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrq
    public final int zzf(int i, int i2, int i4) {
        return zztg.zzb(i, this.zza, 0, i4);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrq
    public final zzrq zzg(int i, int i2) {
        int iZzi = zzrq.zzi(0, i2, zzd());
        return iZzi == 0 ? zzrq.zzb : new zzrk(this.zza, 0, iZzi);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrq
    public final void zzh(zzrh zzrhVar) {
        ((zzry) zzrhVar).zzc(this.zza, 0, zzd());
    }
}
