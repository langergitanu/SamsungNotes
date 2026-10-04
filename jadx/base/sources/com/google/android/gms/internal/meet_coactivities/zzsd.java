package com.google.android.gms.internal.meet_coactivities;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzsd extends zzrc implements RandomAccess, zztf {
    private double[] zza;
    private int zzb;

    static {
        new zzsd(new double[0], 0, false);
    }

    public zzsd() {
        this(new double[10], 0, true);
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
        double dDoubleValue = ((Double) obj).doubleValue();
        zza();
        if (i < 0 || i > (i2 = this.zzb)) {
            throw new IndexOutOfBoundsException(zzg(i));
        }
        int i4 = i + 1;
        double[] dArr = this.zza;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i4, i2 - i);
        } else {
            double[] dArr2 = new double[AbstractC2322a.m1611a(i2, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zza, i, dArr2, i4, this.zzb - i);
            this.zza = dArr2;
        }
        this.zza[i] = dDoubleValue;
        this.zzb++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zztg.zzb;
        collection.getClass();
        if (!(collection instanceof zzsd)) {
            return super.addAll(collection);
        }
        zzsd zzsdVar = (zzsd) collection;
        int i = zzsdVar.zzb;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzb;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i4 = i2 + i;
        double[] dArr = this.zza;
        if (i4 > dArr.length) {
            this.zza = Arrays.copyOf(dArr, i4);
        }
        System.arraycopy(zzsdVar.zza, 0, this.zza, this.zzb, zzsdVar.zzb);
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
        if (!(obj instanceof zzsd)) {
            return super.equals(obj);
        }
        zzsd zzsdVar = (zzsd) obj;
        if (this.zzb != zzsdVar.zzb) {
            return false;
        }
        double[] dArr = zzsdVar.zza;
        for (int i = 0; i < this.zzb; i++) {
            if (Double.doubleToLongBits(this.zza[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzh(i);
        return Double.valueOf(this.zza[i]);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            long jDoubleToLongBits = Double.doubleToLongBits(this.zza[i2]);
            byte[] bArr = zztg.zzb;
            i = (i * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i = this.zzb;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zza[i2] == dDoubleValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        zzh(i);
        double[] dArr = this.zza;
        double d = dArr[i];
        if (i < this.zzb - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (r3 - i) - 1);
        }
        this.zzb--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        zza();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zza;
        System.arraycopy(dArr, i2, dArr, i, this.zzb - i2);
        this.zzb -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zza();
        zzh(i);
        double[] dArr = this.zza;
        double d = dArr[i];
        dArr[i] = dDoubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zztf
    public final /* bridge */ /* synthetic */ zztf zzd(int i) {
        if (i >= this.zzb) {
            return new zzsd(Arrays.copyOf(this.zza, i), this.zzb, true);
        }
        throw new IllegalArgumentException();
    }

    public final double zze(int i) {
        zzh(i);
        return this.zza[i];
    }

    public final void zzf(double d) {
        zza();
        int i = this.zzb;
        double[] dArr = this.zza;
        if (i == dArr.length) {
            double[] dArr2 = new double[AbstractC2322a.m1611a(i, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.zza = dArr2;
        }
        double[] dArr3 = this.zza;
        int i2 = this.zzb;
        this.zzb = i2 + 1;
        dArr3[i2] = d;
    }

    private zzsd(double[] dArr, int i, boolean z) {
        super(z);
        this.zza = dArr;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrc, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Double) obj).doubleValue());
        return true;
    }
}
