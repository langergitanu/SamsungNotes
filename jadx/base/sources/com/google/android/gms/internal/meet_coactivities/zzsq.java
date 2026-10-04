package com.google.android.gms.internal.meet_coactivities;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzsq extends zzrc implements RandomAccess, zztf {
    private float[] zza;
    private int zzb;

    static {
        new zzsq(new float[0], 0, false);
    }

    public zzsq() {
        this(new float[10], 0, true);
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
        float fFloatValue = ((Float) obj).floatValue();
        zza();
        if (i < 0 || i > (i2 = this.zzb)) {
            throw new IndexOutOfBoundsException(zzg(i));
        }
        int i4 = i + 1;
        float[] fArr = this.zza;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i4, i2 - i);
        } else {
            float[] fArr2 = new float[AbstractC2322a.m1611a(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zza, i, fArr2, i4, this.zzb - i);
            this.zza = fArr2;
        }
        this.zza[i] = fFloatValue;
        this.zzb++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zztg.zzb;
        collection.getClass();
        if (!(collection instanceof zzsq)) {
            return super.addAll(collection);
        }
        zzsq zzsqVar = (zzsq) collection;
        int i = zzsqVar.zzb;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzb;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i4 = i2 + i;
        float[] fArr = this.zza;
        if (i4 > fArr.length) {
            this.zza = Arrays.copyOf(fArr, i4);
        }
        System.arraycopy(zzsqVar.zza, 0, this.zza, this.zzb, zzsqVar.zzb);
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
        if (!(obj instanceof zzsq)) {
            return super.equals(obj);
        }
        zzsq zzsqVar = (zzsq) obj;
        if (this.zzb != zzsqVar.zzb) {
            return false;
        }
        float[] fArr = zzsqVar.zza;
        for (int i = 0; i < this.zzb; i++) {
            if (Float.floatToIntBits(this.zza[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzh(i);
        return Float.valueOf(this.zza[i]);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i = 0; i < this.zzb; i++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.zza[i]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i = this.zzb;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zza[i2] == fFloatValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        zzh(i);
        float[] fArr = this.zza;
        float f = fArr[i];
        if (i < this.zzb - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (r2 - i) - 1);
        }
        this.zzb--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        zza();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.zza;
        System.arraycopy(fArr, i2, fArr, i, this.zzb - i2);
        this.zzb -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        zza();
        zzh(i);
        float[] fArr = this.zza;
        float f = fArr[i];
        fArr[i] = fFloatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zztf
    public final /* bridge */ /* synthetic */ zztf zzd(int i) {
        if (i >= this.zzb) {
            return new zzsq(Arrays.copyOf(this.zza, i), this.zzb, true);
        }
        throw new IllegalArgumentException();
    }

    public final float zze(int i) {
        zzh(i);
        return this.zza[i];
    }

    public final void zzf(float f) {
        zza();
        int i = this.zzb;
        float[] fArr = this.zza;
        if (i == fArr.length) {
            float[] fArr2 = new float[AbstractC2322a.m1611a(i, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.zza = fArr2;
        }
        float[] fArr3 = this.zza;
        int i2 = this.zzb;
        this.zzb = i2 + 1;
        fArr3[i2] = f;
    }

    private zzsq(float[] fArr, int i, boolean z) {
        super(z);
        this.zza = fArr;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Float) obj).floatValue());
        return true;
    }
}
