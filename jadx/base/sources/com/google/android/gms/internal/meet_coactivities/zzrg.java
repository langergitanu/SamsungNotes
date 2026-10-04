package com.google.android.gms.internal.meet_coactivities;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzrg extends zzrc implements RandomAccess, zztf {
    private boolean[] zza;
    private int zzb;

    static {
        new zzrg(new boolean[0], 0, false);
    }

    public zzrg() {
        this(new boolean[10], 0, true);
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
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zza();
        if (i < 0 || i > (i2 = this.zzb)) {
            throw new IndexOutOfBoundsException(zzg(i));
        }
        int i4 = i + 1;
        boolean[] zArr = this.zza;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i4, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[AbstractC2322a.m1611a(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zza, i, zArr2, i4, this.zzb - i);
            this.zza = zArr2;
        }
        this.zza[i] = zBooleanValue;
        this.zzb++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zztg.zzb;
        collection.getClass();
        if (!(collection instanceof zzrg)) {
            return super.addAll(collection);
        }
        zzrg zzrgVar = (zzrg) collection;
        int i = zzrgVar.zzb;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzb;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i4 = i2 + i;
        boolean[] zArr = this.zza;
        if (i4 > zArr.length) {
            this.zza = Arrays.copyOf(zArr, i4);
        }
        System.arraycopy(zzrgVar.zza, 0, this.zza, this.zzb, zzrgVar.zzb);
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
        if (!(obj instanceof zzrg)) {
            return super.equals(obj);
        }
        zzrg zzrgVar = (zzrg) obj;
        if (this.zzb != zzrgVar.zzb) {
            return false;
        }
        boolean[] zArr = zzrgVar.zza;
        for (int i = 0; i < this.zzb; i++) {
            if (this.zza[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzh(i);
        return Boolean.valueOf(this.zza[i]);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZza = 1;
        for (int i = 0; i < this.zzb; i++) {
            iZza = (iZza * 31) + zztg.zza(this.zza[i]);
        }
        return iZza;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i = this.zzb;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zza[i2] == zBooleanValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        zzh(i);
        boolean[] zArr = this.zza;
        boolean z = zArr[i];
        if (i < this.zzb - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (r2 - i) - 1);
        }
        this.zzb--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        zza();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zza;
        System.arraycopy(zArr, i2, zArr, i, this.zzb - i2);
        this.zzb -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zza();
        zzh(i);
        boolean[] zArr = this.zza;
        boolean z = zArr[i];
        zArr[i] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zztf
    public final /* bridge */ /* synthetic */ zztf zzd(int i) {
        if (i >= this.zzb) {
            return new zzrg(Arrays.copyOf(this.zza, i), this.zzb, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(boolean z) {
        zza();
        int i = this.zzb;
        boolean[] zArr = this.zza;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[AbstractC2322a.m1611a(i, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.zza = zArr2;
        }
        boolean[] zArr3 = this.zza;
        int i2 = this.zzb;
        this.zzb = i2 + 1;
        zArr3[i2] = z;
    }

    public final boolean zzf(int i) {
        zzh(i);
        return this.zza[i];
    }

    private zzrg(boolean[] zArr, int i, boolean z) {
        super(z);
        this.zza = zArr;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Boolean) obj).booleanValue());
        return true;
    }
}
