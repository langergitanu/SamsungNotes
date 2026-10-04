package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzrq implements Iterable, Serializable {
    public static final zzrq zzb = new zzrp(zztg.zzb);
    private int zza = 0;

    static {
        int i = zzrd.zza;
    }

    public static int zzi(int i, int i2, int i4) {
        int i5 = i2 - i;
        if ((i | i2 | i5 | (i4 - i2)) >= 0) {
            return i5;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(AbstractC0541b.m767i(i, "Beginning index: ", " < 0"));
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException(AbstractC1038a.m1214o(i, i2, "Beginning index larger than ending index: ", SQLKeyword.COMMA));
        }
        throw new IndexOutOfBoundsException(AbstractC1038a.m1214o(i2, i4, "End index: ", " >= "));
    }

    public static zzrq zzk(byte[] bArr, int i, int i2) {
        zzi(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzrp(bArr2);
    }

    public static zzrq zzl(String str) {
        return new zzrp(str.getBytes(zztg.zza));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzf = this.zza;
        if (iZzf == 0) {
            int iZzd = zzd();
            iZzf = zzf(iZzd, 0, iZzd);
            if (iZzf == 0) {
                iZzf = 1;
            }
            this.zza = iZzf;
        }
        return iZzf;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzri(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        return AbstractC0622a.m1170p(zzd() <= 50 ? zzvc.zza(this) : zzvc.zza(zzg(0, 47)).concat("..."), "\">", AbstractC0541b.m780v("<ByteString@", zzd(), hexString, " size=", " contents=\""));
    }

    public abstract byte zza(int i);

    public abstract byte zzb(int i);

    public abstract int zzd();

    public abstract void zze(byte[] bArr, int i, int i2, int i4);

    public abstract int zzf(int i, int i2, int i4);

    public abstract zzrq zzg(int i, int i2);

    public abstract void zzh(zzrh zzrhVar);

    public final int zzj() {
        return this.zza;
    }

    public final boolean zzm() {
        return zzd() == 0;
    }

    public final byte[] zzn() {
        int iZzd = zzd();
        if (iZzd == 0) {
            return zztg.zzb;
        }
        byte[] bArr = new byte[iZzd];
        zze(bArr, 0, 0, iZzd);
        return bArr;
    }
}
