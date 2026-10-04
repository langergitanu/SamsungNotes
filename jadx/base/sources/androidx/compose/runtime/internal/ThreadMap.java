package androidx.compose.runtime.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/runtime/internal/ThreadMap;", "", "size", "", "keys", "", "values", "", "(I[J[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "find", "key", "", "get", "newWith", "value", "trySet", "", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nThreadMap.jvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadMap.jvm.kt\nandroidx/compose/runtime/internal/ThreadMap\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,112:1\n12904#2,3:113\n*S KotlinDebug\n*F\n+ 1 ThreadMap.jvm.kt\nandroidx/compose/runtime/internal/ThreadMap\n*L\n42#1:113,3\n*E\n"})
public final class ThreadMap {
    public static final int $stable = 8;

    @NotNull
    private final long[] keys;
    private final int size;

    @NotNull
    private final Object[] values;

    public ThreadMap(int i, @NotNull long[] jArr, @NotNull Object[] objArr) {
        this.size = i;
        this.keys = jArr;
        this.values = objArr;
    }

    private final int find(long key) {
        int i = this.size - 1;
        if (i != -1) {
            int i2 = 0;
            if (i != 0) {
                while (i2 <= i) {
                    int i4 = (i2 + i) >>> 1;
                    long j = this.keys[i4] - key;
                    if (j < 0) {
                        i2 = i4 + 1;
                    } else {
                        if (j <= 0) {
                            return i4;
                        }
                        i = i4 - 1;
                    }
                }
                return -(i2 + 1);
            }
            long j2 = this.keys[0];
            if (j2 == key) {
                return 0;
            }
            if (j2 > key) {
                return -2;
            }
        }
        return -1;
    }

    @Nullable
    public final Object get(long key) {
        int iFind = find(key);
        if (iFind >= 0) {
            return this.values[iFind];
        }
        return null;
    }

    @NotNull
    public final ThreadMap newWith(long key, @Nullable Object value) {
        int i = this.size;
        int i2 = 0;
        int i4 = 0;
        for (Object obj : this.values) {
            if (obj != null) {
                i4++;
            }
        }
        int i5 = i4 + 1;
        long[] jArr = new long[i5];
        Object[] objArr = new Object[i5];
        if (i5 > 1) {
            int i6 = 0;
            while (true) {
                if (i2 >= i5 || i6 >= i) {
                    break;
                }
                long j = this.keys[i6];
                Object obj2 = this.values[i6];
                if (j > key) {
                    jArr[i2] = key;
                    objArr[i2] = value;
                    i2++;
                    break;
                }
                if (obj2 != null) {
                    jArr[i2] = j;
                    objArr[i2] = obj2;
                    i2++;
                }
                i6++;
            }
            if (i6 == i) {
                jArr[i4] = key;
                objArr[i4] = value;
            } else {
                while (i2 < i5) {
                    long j2 = this.keys[i6];
                    Object obj3 = this.values[i6];
                    if (obj3 != null) {
                        jArr[i2] = j2;
                        objArr[i2] = obj3;
                        i2++;
                    }
                    i6++;
                }
            }
        } else {
            jArr[0] = key;
            objArr[0] = value;
        }
        return new ThreadMap(i5, jArr, objArr);
    }

    public final boolean trySet(long key, @Nullable Object value) {
        int iFind = find(key);
        if (iFind < 0) {
            return false;
        }
        this.values[iFind] = value;
        return true;
    }
}
