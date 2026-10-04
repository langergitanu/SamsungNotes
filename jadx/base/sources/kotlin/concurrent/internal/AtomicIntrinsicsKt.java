package kotlin.concurrent.internal;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0001\u001a\u001c\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a\u001c\u0010\u0000\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0001\u001a-\u0010\u0000\u001a\u0002H\t\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n2\u0006\u0010\u0003\u001a\u0002H\t2\u0006\u0010\u0004\u001a\u0002H\tH\u0001¢\u0006\u0002\u0010\u000b\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0001\u001a$\u0010\u0000\u001a\u00020\u0005*\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a5\u0010\u0000\u001a\u0002H\t\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u000f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\t2\u0006\u0010\u0004\u001a\u0002H\tH\u0001¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, m13886d2 = {"compareAndExchange", "", "Ljava/util/concurrent/atomic/AtomicInteger;", "expected", "newValue", "", "Ljava/util/concurrent/atomic/AtomicLong;", "", "Ljava/util/concurrent/atomic/AtomicBoolean;", "T", "Ljava/util/concurrent/atomic/AtomicReference;", "(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicIntegerArray;", "index", "Ljava/util/concurrent/atomic/AtomicLongArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "(Ljava/util/concurrent/atomic/AtomicReferenceArray;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AtomicIntrinsicsKt {
    @SinceKotlin(version = "2.1")
    @PublishedApi
    public static final int compareAndExchange(@NotNull AtomicInteger atomicInteger, int i, int i2) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<this>");
        do {
            int i4 = atomicInteger.get();
            if (i != i4) {
                return i4;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    @SinceKotlin(version = "2.1")
    @PublishedApi
    public static final long compareAndExchange(@NotNull AtomicLong atomicLong, long j, long j2) {
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        do {
            long j3 = atomicLong.get();
            if (j != j3) {
                return j3;
            }
        } while (!atomicLong.compareAndSet(j, j2));
        return j;
    }

    @SinceKotlin(version = "2.1")
    @PublishedApi
    public static final boolean compareAndExchange(@NotNull AtomicBoolean atomicBoolean, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<this>");
        do {
            boolean z3 = atomicBoolean.get();
            if (z != z3) {
                return z3;
            }
        } while (!atomicBoolean.compareAndSet(z, z2));
        return z;
    }

    @SinceKotlin(version = "2.1")
    @PublishedApi
    public static final <T> T compareAndExchange(@NotNull AtomicReference<T> atomicReference, T t, T t2) {
        Intrinsics.checkNotNullParameter(atomicReference, "<this>");
        while (true) {
            T t5 = atomicReference.get();
            if (t != t5) {
                return t5;
            }
            while (!atomicReference.compareAndSet(t, t2)) {
                if (atomicReference.get() != t) {
                    break;
                }
            }
            return t;
        }
    }

    @SinceKotlin(version = "2.1")
    @PublishedApi
    public static final int compareAndExchange(@NotNull AtomicIntegerArray atomicIntegerArray, int i, int i2, int i4) {
        Intrinsics.checkNotNullParameter(atomicIntegerArray, "<this>");
        do {
            int i5 = atomicIntegerArray.get(i);
            if (i2 != i5) {
                return i5;
            }
        } while (!atomicIntegerArray.compareAndSet(i, i2, i4));
        return i2;
    }

    @SinceKotlin(version = "2.1")
    @PublishedApi
    public static final long compareAndExchange(@NotNull AtomicLongArray atomicLongArray, int i, long j, long j2) {
        Intrinsics.checkNotNullParameter(atomicLongArray, "<this>");
        do {
            long j3 = atomicLongArray.get(i);
            if (j != j3) {
                return j3;
            }
        } while (!atomicLongArray.compareAndSet(i, j, j2));
        return j;
    }

    @SinceKotlin(version = "2.1")
    @PublishedApi
    public static final <T> T compareAndExchange(@NotNull AtomicReferenceArray<T> atomicReferenceArray, int i, T t, T t2) {
        Intrinsics.checkNotNullParameter(atomicReferenceArray, "<this>");
        while (true) {
            T t5 = atomicReferenceArray.get(i);
            if (t != t5) {
                return t5;
            }
            while (!atomicReferenceArray.compareAndSet(i, t, t2)) {
                if (atomicReferenceArray.get(i) != t) {
                    break;
                }
            }
            return t;
        }
    }
}
