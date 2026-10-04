package androidx.compose.animation.core;

import androidx.collection.IntList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0001¨\u0006\u0006"}, m13886d2 = {"binarySearch", "", "Landroidx/collection/IntList;", "element", "fromIndex", "toIndex", "animation-core_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nIntListExtension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntListExtension.kt\nandroidx/compose/animation/core/IntListExtensionKt\n+ 2 Preconditions.kt\nandroidx/compose/animation/core/PreconditionsKt\n*L\n1#1,75:1\n33#2,7:76\n*S KotlinDebug\n*F\n+ 1 IntListExtension.kt\nandroidx/compose/animation/core/IntListExtensionKt\n*L\n50#1:76,7\n*E\n"})
public final class IntListExtensionKt {
    @JvmOverloads
    public static final int binarySearch(@NotNull IntList intList, int i) {
        return binarySearch$default(intList, i, 0, 0, 6, null);
    }

    public static /* synthetic */ int binarySearch$default(IntList intList, int i, int i2, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = intList.getSize();
        }
        return binarySearch(intList, i, i2, i4);
    }

    @JvmOverloads
    public static final int binarySearch(@NotNull IntList intList, int i, int i2) {
        return binarySearch$default(intList, i, i2, 0, 4, null);
    }

    @JvmOverloads
    public static final int binarySearch(@NotNull IntList intList, int i, int i2, int i4) {
        if (!(i2 <= i4)) {
            PreconditionsKt.throwIllegalArgumentException("fromIndex(" + i2 + ") > toIndex(" + i4 + PropertyUtils.MAPPED_DELIM2);
        }
        if (i2 >= 0) {
            if (i4 > intList.getSize()) {
                throw new IndexOutOfBoundsException(AbstractC0000a.m11h(i4, "Index out of range: "));
            }
            int i5 = i4 - 1;
            while (i2 <= i5) {
                int i6 = (i2 + i5) >>> 1;
                int i7 = intList.get(i6);
                if (i7 < i) {
                    i2 = i6 + 1;
                } else {
                    if (i7 <= i) {
                        return i6;
                    }
                    i5 = i6 - 1;
                }
            }
            return -(i2 + 1);
        }
        throw new IndexOutOfBoundsException(AbstractC0000a.m11h(i2, "Index out of range: "));
    }
}
