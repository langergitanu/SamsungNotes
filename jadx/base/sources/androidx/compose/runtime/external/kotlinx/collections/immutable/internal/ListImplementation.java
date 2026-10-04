package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\bJ\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\nJ%\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u000eJ%\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0001¢\u0006\u0002\b\u0014J\u0019\u0010\u0015\u001a\u00020\u00062\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0001¢\u0006\u0002\b\u0016¨\u0006\u0017"}, m13886d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/ListImplementation;", "", "()V", "checkElementIndex", "", "index", "", "size", "checkElementIndex$runtime_release", "checkPositionIndex", "checkPositionIndex$runtime_release", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$runtime_release", "orderedEquals", "", "c", "", "other", "orderedEquals$runtime_release", "orderedHashCode", "orderedHashCode$runtime_release", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ListImplementation {
    public static final int $stable = 0;

    @NotNull
    public static final ListImplementation INSTANCE = new ListImplementation();

    private ListImplementation() {
    }

    @JvmStatic
    public static final void checkElementIndex$runtime_release(int index, int size) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(AbstractC1038a.m1214o(index, size, "index: ", ", size: "));
        }
    }

    @JvmStatic
    public static final void checkPositionIndex$runtime_release(int index, int size) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(AbstractC1038a.m1214o(index, size, "index: ", ", size: "));
        }
    }

    @JvmStatic
    public static final void checkRangeIndexes$runtime_release(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0 || toIndex > size) {
            StringBuilder sbM1173s = AbstractC0622a.m1173s(fromIndex, toIndex, "fromIndex: ", ", toIndex: ", ", size: ");
            sbM1173s.append(size);
            throw new IndexOutOfBoundsException(sbM1173s.toString());
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(fromIndex, toIndex, "fromIndex: ", " > toIndex: "));
        }
    }

    @JvmStatic
    public static final boolean orderedEquals$runtime_release(@NotNull Collection<?> c, @NotNull Collection<?> other) {
        if (c.size() != other.size()) {
            return false;
        }
        Iterator<?> it = other.iterator();
        Iterator<?> it2 = c.iterator();
        while (it2.hasNext()) {
            if (!Intrinsics.areEqual(it2.next(), it.next())) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final int orderedHashCode$runtime_release(@NotNull Collection<?> c) {
        Iterator<?> it = c.iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
        }
        return iHashCode;
    }
}
