package com.google.android.gms.internal.auth;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzee implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzee zzb = new zzeb(zzez.zzd);
    private static final zzed zzd;
    private int zzc = 0;

    static {
        int i = zzdr.zza;
        zzd = new zzed(null);
        zza = new zzdw();
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

    public static zzee zzk(byte[] bArr, int i, int i2) {
        zzi(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzeb(bArr2);
    }

    public static zzee zzl(String str) {
        return new zzeb(str.getBytes(zzez.zzb));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZze = this.zzc;
        if (iZze == 0) {
            int iZzd = zzd();
            iZze = zze(iZzd, 0, iZzd);
            if (iZze == 0) {
                iZze = 1;
            }
            this.zzc = iZze;
        }
        return iZze;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzdv(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        return AbstractC0622a.m1170p(zzd() <= 50 ? zzgw.zza(this) : zzgw.zza(zzf(0, 47)).concat("..."), "\">", AbstractC0541b.m780v("<ByteString@", zzd(), hexString, " size=", " contents=\""));
    }

    public abstract byte zza(int i);

    public abstract byte zzb(int i);

    public abstract int zzd();

    public abstract int zze(int i, int i2, int i4);

    public abstract zzee zzf(int i, int i2);

    public abstract String zzg(Charset charset);

    public abstract boolean zzh();

    public final int zzj() {
        return this.zzc;
    }

    public final String zzm(Charset charset) {
        return zzd() == 0 ? "" : zzg(charset);
    }
}
