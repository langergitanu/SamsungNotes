package com.google.android.gms.internal.drive;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes5.dex */
class zzjm extends zzjl {
    protected final byte[] zzny;

    public zzjm(byte[] bArr) {
        bArr.getClass();
        this.zzny = bArr;
    }

    @Override // com.google.android.gms.internal.drive.zzjc
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzjc) || size() != ((zzjc) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzjm)) {
            return obj.equals(this);
        }
        zzjm zzjmVar = (zzjm) obj;
        int iZzbv = zzbv();
        int iZzbv2 = zzjmVar.zzbv();
        if (iZzbv == 0 || iZzbv2 == 0 || iZzbv == iZzbv2) {
            return zza(zzjmVar, 0, size());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.drive.zzjc
    public int size() {
        return this.zzny.length;
    }

    @Override // com.google.android.gms.internal.drive.zzjc
    public final zzjc zza(int i, int i2) {
        int iZzb = zzjc.zzb(0, i2, size());
        return iZzb == 0 ? zzjc.zznq : new zzjh(this.zzny, zzbw(), iZzb);
    }

    @Override // com.google.android.gms.internal.drive.zzjc
    public final boolean zzbu() {
        int iZzbw = zzbw();
        return zznf.zze(this.zzny, iZzbw, size() + iZzbw);
    }

    public int zzbw() {
        return 0;
    }

    @Override // com.google.android.gms.internal.drive.zzjc
    public byte zzs(int i) {
        return this.zzny[i];
    }

    @Override // com.google.android.gms.internal.drive.zzjc
    public byte zzt(int i) {
        return this.zzny[i];
    }

    @Override // com.google.android.gms.internal.drive.zzjc
    public final void zza(zzjb zzjbVar) {
        zzjbVar.zza(this.zzny, zzbw(), size());
    }

    @Override // com.google.android.gms.internal.drive.zzjc
    public final String zza(Charset charset) {
        return new String(this.zzny, zzbw(), size(), charset);
    }

    @Override // com.google.android.gms.internal.drive.zzjl
    public final boolean zza(zzjc zzjcVar, int i, int i2) {
        if (i2 <= zzjcVar.size()) {
            if (i2 <= zzjcVar.size()) {
                if (zzjcVar instanceof zzjm) {
                    zzjm zzjmVar = (zzjm) zzjcVar;
                    byte[] bArr = this.zzny;
                    byte[] bArr2 = zzjmVar.zzny;
                    int iZzbw = zzbw() + i2;
                    int iZzbw2 = zzbw();
                    int iZzbw3 = zzjmVar.zzbw();
                    while (iZzbw2 < iZzbw) {
                        if (bArr[iZzbw2] != bArr2[iZzbw3]) {
                            return false;
                        }
                        iZzbw2++;
                        iZzbw3++;
                    }
                    return true;
                }
                return zzjcVar.zza(0, i2).equals(zza(0, i2));
            }
            int size = zzjcVar.size();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: 0, ");
            sb.append(i2);
            sb.append(SQLKeyword.COMMA);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int size2 = size();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i2);
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.drive.zzjc
    public final int zza(int i, int i2, int i4) {
        return zzkm.zza(i, this.zzny, zzbw(), i4);
    }
}
