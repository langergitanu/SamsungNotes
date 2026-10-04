package com.google.common.util.concurrent;

import com.adobe.internal.xmp.XMPConst;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.primitives.ImmutableLongArray;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLongArray longs;

    public AtomicDoubleArray(int i) {
        this.longs = new AtomicLongArray(i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        ImmutableLongArray.Builder builder = ImmutableLongArray.builder();
        for (int i2 = 0; i2 < i; i2++) {
            builder.add(Double.doubleToRawLongBits(objectInputStream.readDouble()));
        }
        this.longs = new AtomicLongArray(builder.build().toArray());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int length = length();
        objectOutputStream.writeInt(length);
        for (int i = 0; i < length; i++) {
            objectOutputStream.writeDouble(get(i));
        }
    }

    @CanIgnoreReturnValue
    public double addAndGet(int i, double d) {
        while (true) {
            long j = this.longs.get(i);
            double dLongBitsToDouble = Double.longBitsToDouble(j) + d;
            int i2 = i;
            if (this.longs.compareAndSet(i2, j, Double.doubleToRawLongBits(dLongBitsToDouble))) {
                return dLongBitsToDouble;
            }
            i = i2;
        }
    }

    public final boolean compareAndSet(int i, double d, double d2) {
        return this.longs.compareAndSet(i, Double.doubleToRawLongBits(d), Double.doubleToRawLongBits(d2));
    }

    public final double get(int i) {
        return Double.longBitsToDouble(this.longs.get(i));
    }

    @CanIgnoreReturnValue
    public final double getAndAdd(int i, double d) {
        while (true) {
            long j = this.longs.get(i);
            double dLongBitsToDouble = Double.longBitsToDouble(j);
            int i2 = i;
            if (this.longs.compareAndSet(i2, j, Double.doubleToRawLongBits(dLongBitsToDouble + d))) {
                return dLongBitsToDouble;
            }
            i = i2;
        }
    }

    public final double getAndSet(int i, double d) {
        return Double.longBitsToDouble(this.longs.getAndSet(i, Double.doubleToRawLongBits(d)));
    }

    public final void lazySet(int i, double d) {
        this.longs.lazySet(i, Double.doubleToRawLongBits(d));
    }

    public final int length() {
        return this.longs.length();
    }

    public final void set(int i, double d) {
        this.longs.set(i, Double.doubleToRawLongBits(d));
    }

    public String toString() {
        int length = length();
        int i = length - 1;
        if (i == -1) {
            return XMPConst.ARRAY_ITEM_NAME;
        }
        StringBuilder sb = new StringBuilder(length * 19);
        sb.append(PropertyUtils.INDEXED_DELIM);
        int i2 = 0;
        while (true) {
            sb.append(Double.longBitsToDouble(this.longs.get(i2)));
            if (i2 == i) {
                sb.append(PropertyUtils.INDEXED_DELIM2);
                return sb.toString();
            }
            sb.append(SQLKeyword.COMMA);
            i2++;
        }
    }

    public final boolean weakCompareAndSet(int i, double d, double d2) {
        return this.longs.weakCompareAndSet(i, Double.doubleToRawLongBits(d), Double.doubleToRawLongBits(d2));
    }

    public AtomicDoubleArray(double[] dArr) {
        int length = dArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = Double.doubleToRawLongBits(dArr[i]);
        }
        this.longs = new AtomicLongArray(jArr);
    }
}
