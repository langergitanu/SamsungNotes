package com.google.android.gms.internal.drive;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class zzjc implements Serializable, Iterable<Byte> {
    public static final zzjc zznq = new zzjm(zzkm.zzsn);
    private static final zzji zznr;
    private static final Comparator<zzjc> zznt;
    private int zzns = 0;

    static {
        zzjd zzjdVar = null;
        zznr = zzix.zzbr() ? new zzjn(zzjdVar) : new zzjg(zzjdVar);
        zznt = new zzje();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zza(byte b) {
        return b & 255;
    }

    public static zzjc zzb(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzjm(zznr.zzc(bArr, i, i2));
    }

    public static zzjc zzk(String str) {
        return new zzjm(str.getBytes(zzkm.UTF_8));
    }

    public static zzjk zzu(int i) {
        return new zzjk(i, null);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZza = this.zzns;
        if (iZza == 0) {
            int size = size();
            iZza = zza(size, 0, size);
            if (iZza == 0) {
                iZza = 1;
            }
            this.zzns = iZza;
        }
        return iZza;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzjd(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract int zza(int i, int i2, int i4);

    public abstract zzjc zza(int i, int i2);

    public abstract String zza(Charset charset);

    public abstract void zza(zzjb zzjbVar);

    public final String zzbt() {
        return size() == 0 ? "" : zza(zzkm.UTF_8);
    }

    public abstract boolean zzbu();

    public final int zzbv() {
        return this.zzns;
    }

    public abstract byte zzs(int i);

    public abstract byte zzt(int i);

    public static int zzb(int i, int i2, int i4) {
        int i5 = i2 - i;
        if ((i | i2 | i5 | (i4 - i2)) >= 0) {
            return i5;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(SQLKeyword.COMMA);
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i4);
        throw new IndexOutOfBoundsException(sb3.toString());
    }
}
