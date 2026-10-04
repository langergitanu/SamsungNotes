package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
abstract class Striped64 extends Number {
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    volatile transient long base;
    volatile transient int busy;

    @CheckForNull
    volatile transient Cell[] cells;
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Cell {
        private static final Unsafe UNSAFE;
        private static final long valueOffset;

        /* JADX INFO: renamed from: p0 */
        volatile long f3312p0;

        /* JADX INFO: renamed from: p1 */
        volatile long f3313p1;

        /* JADX INFO: renamed from: p2 */
        volatile long f3314p2;

        /* JADX INFO: renamed from: p3 */
        volatile long f3315p3;

        /* JADX INFO: renamed from: p4 */
        volatile long f3316p4;

        /* JADX INFO: renamed from: p5 */
        volatile long f3317p5;

        /* JADX INFO: renamed from: p6 */
        volatile long f3318p6;

        /* JADX INFO: renamed from: q0 */
        volatile long f3319q0;

        /* JADX INFO: renamed from: q1 */
        volatile long f3320q1;

        /* JADX INFO: renamed from: q2 */
        volatile long f3321q2;

        /* JADX INFO: renamed from: q3 */
        volatile long f3322q3;

        /* JADX INFO: renamed from: q4 */
        volatile long f3323q4;

        /* JADX INFO: renamed from: q5 */
        volatile long f3324q5;

        /* JADX INFO: renamed from: q6 */
        volatile long f3325q6;
        volatile long value;

        static {
            try {
                Unsafe unsafe = Striped64.getUnsafe();
                UNSAFE = unsafe;
                valueOffset = unsafe.objectFieldOffset(Cell.class.getDeclaredField("value"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        public Cell(long j) {
            this.value = j;
        }

        public final boolean cas(long j, long j2) {
            return UNSAFE.compareAndSwapLong(this, valueOffset, j, j2);
        }
    }

    static {
        try {
            Unsafe unsafe = getUnsafe();
            UNSAFE = unsafe;
            baseOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            busyOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e) {
                throw new RuntimeException("Could not initialize intrinsics", e.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.cache.Striped64.1
                @Override // java.security.PrivilegedExceptionAction
                public Unsafe run() throws IllegalAccessException {
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            });
        }
    }

    public final boolean casBase(long j, long j2) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, j, j2);
    }

    public final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    /* JADX INFO: renamed from: fn */
    public abstract long mo4282fn(long j, long j2);

    public final void internalReset(long j) {
        Cell[] cellArr = this.cells;
        this.base = j;
        if (cellArr != null) {
            for (Cell cell : cellArr) {
                if (cell != null) {
                    cell.value = j;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00f1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void retryUpdate(long j, @CheckForNull int[] iArr, boolean z) {
        int iNextInt;
        int[] iArr2;
        boolean z2;
        int length;
        boolean z3;
        int length2;
        if (iArr == null) {
            iArr2 = new int[1];
            threadHashCode.set(iArr2);
            iNextInt = rng.nextInt();
            if (iNextInt == 0) {
                iNextInt = 1;
            }
            iArr2[0] = iNextInt;
        } else {
            iNextInt = iArr[0];
            iArr2 = iArr;
        }
        boolean z4 = false;
        int i = iNextInt;
        boolean z5 = z;
        while (true) {
            Cell[] cellArr = this.cells;
            if (cellArr != null && (length = cellArr.length) > 0) {
                Cell cell = cellArr[(length - 1) & i];
                if (cell == null) {
                    if (this.busy == 0) {
                        Cell cell2 = new Cell(j);
                        if (this.busy == 0 && casBusy()) {
                            try {
                                Cell[] cellArr2 = this.cells;
                                if (cellArr2 == null || (length2 = cellArr2.length) <= 0) {
                                    z3 = false;
                                    if (!z3) {
                                        return;
                                    }
                                } else {
                                    int i2 = (length2 - 1) & i;
                                    if (cellArr2[i2] == null) {
                                        cellArr2[i2] = cell2;
                                        z3 = true;
                                    }
                                    if (!z3) {
                                    }
                                }
                            } finally {
                            }
                        }
                    }
                    z4 = false;
                } else if (z5) {
                    long j2 = cell.value;
                    if (cell.cas(j2, mo4282fn(j2, j))) {
                        return;
                    }
                    if (length >= NCPU || this.cells != cellArr) {
                        z4 = false;
                    } else if (!z4) {
                        z4 = true;
                    } else if (this.busy == 0 && casBusy()) {
                        try {
                            if (this.cells == cellArr) {
                                Cell[] cellArr3 = new Cell[length << 1];
                                for (int i4 = 0; i4 < length; i4++) {
                                    cellArr3[i4] = cellArr[i4];
                                }
                                this.cells = cellArr3;
                            }
                            this.busy = 0;
                            z4 = false;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } else {
                    z5 = true;
                }
                int i5 = i ^ (i << 13);
                int i6 = i5 ^ (i5 >>> 17);
                i = i6 ^ (i6 << 5);
                iArr2[0] = i;
            } else if (this.busy == 0 && this.cells == cellArr && casBusy()) {
                try {
                    if (this.cells == cellArr) {
                        Cell[] cellArr4 = new Cell[2];
                        cellArr4[i & 1] = new Cell(j);
                        this.cells = cellArr4;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        return;
                    }
                } finally {
                }
            } else {
                long j3 = this.base;
                if (casBase(j3, mo4282fn(j3, j))) {
                    return;
                }
            }
        }
    }
}
