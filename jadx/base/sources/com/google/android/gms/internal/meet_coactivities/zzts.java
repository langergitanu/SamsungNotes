package com.google.android.gms.internal.meet_coactivities;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzts extends zzrc implements RandomAccess, zztf {
    private long[] zza;
    private int zzb;

    static {
        new zzts(new long[0], 0, false);
    }

    public zzts() {
        this(new long[10], 0, true);
    }

    private final String zzg(int i) {
        return AbstractC1038a.m1214o(i, this.zzb, "Index:", ", Size:");
    }

    private final void zzh(int i) {
        if (i < 0 || i >= this.zzb) {
            throw new IndexOutOfBoundsException(zzg(i));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long jLongValue = ((Long) obj).longValue();
        zza();
        if (i < 0 || i > (i2 = this.zzb)) {
            throw new IndexOutOfBoundsException(zzg(i));
        }
        int i4 = i + 1;
        long[] jArr = this.zza;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i4, i2 - i);
        } else {
            long[] jArr2 = new long[AbstractC2322a.m1611a(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zza, i, jArr2, i4, this.zzb - i);
            this.zza = jArr2;
        }
        this.zza[i] = jLongValue;
        this.zzb++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zztg.zzb;
        collection.getClass();
        if (!(collection instanceof zzts)) {
            return super.addAll(collection);
        }
        zzts zztsVar = (zzts) collection;
        int i = zztsVar.zzb;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzb;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i4 = i2 + i;
        long[] jArr = this.zza;
        if (i4 > jArr.length) {
            this.zza = Arrays.copyOf(jArr, i4);
        }
        System.arraycopy(zztsVar.zza, 0, this.zza, this.zzb, zztsVar.zzb);
        this.zzb = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzts)) {
            return super.equals(obj);
        }
        zzts zztsVar = (zzts) obj;
        if (this.zzb != zztsVar.zzb) {
            return false;
        }
        long[] jArr = zztsVar.zza;
        for (int i = 0; i < this.zzb; i++) {
            if (this.zza[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzh(i);
        return Long.valueOf(this.zza[i]);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            long j = this.zza[i2];
            byte[] bArr = zztg.zzb;
            i = (i * 31) + ((int) (j ^ (j >>> 32)));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i = this.zzb;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zza[i2] == jLongValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        zzh(i);
        long[] jArr = this.zza;
        long j = jArr[i];
        if (i < this.zzb - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.zzb--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        zza();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.zza;
        System.arraycopy(jArr, i2, jArr, i, this.zzb - i2);
        this.zzb -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zza();
        zzh(i);
        long[] jArr = this.zza;
        long j = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zztf
    public final /* bridge */ /* synthetic */ zztf zzd(int i) {
        if (i >= this.zzb) {
            return new zzts(Arrays.copyOf(this.zza, i), this.zzb, true);
        }
        throw new IllegalArgumentException();
    }

    public final long zze(int i) {
        zzh(i);
        return this.zza[i];
    }

    public final void zzf(long j) {
        zza();
        int i = this.zzb;
        long[] jArr = this.zza;
        if (i == jArr.length) {
            long[] jArr2 = new long[AbstractC2322a.m1611a(i, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zza = jArr2;
        }
        long[] jArr3 = this.zza;
        int i2 = this.zzb;
        this.zzb = i2 + 1;
        jArr3[i2] = j;
    }

    private zzts(long[] jArr, int i, boolean z) {
        super(z);
        this.zza = jArr;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Long) obj).longValue());
        return true;
    }
}
