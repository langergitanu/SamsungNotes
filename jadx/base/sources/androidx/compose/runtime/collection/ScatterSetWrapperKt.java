package androidx.compose.runtime.collection;

import androidx.collection.ScatterSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\b\u001a1\u0010\u0006\u001a\u00020\u0007\"\b\b\u0000\u0010\b*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0002\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\nH\u0000¨\u0006\u000b"}, m13886d2 = {"fastAny", "", "", "", "block", "Lkotlin/Function1;", "fastForEach", "", "T", "wrapIntoSet", "Landroidx/collection/ScatterSet;", "runtime_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScatterSetWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterSetWrapper.kt\nandroidx/compose/runtime/collection/ScatterSetWrapperKt\n+ 2 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n228#2,4:64\n198#2,7:68\n209#2,3:76\n212#2,9:80\n232#2:89\n254#2,2:92\n228#2,4:94\n198#2,7:98\n209#2,3:106\n212#2,9:110\n232#2:119\n256#2:120\n1956#3:75\n1820#3:79\n1956#3:105\n1820#3:109\n1855#4,2:90\n1747#4,3:121\n*S KotlinDebug\n*F\n+ 1 ScatterSetWrapper.kt\nandroidx/compose/runtime/collection/ScatterSetWrapperKt\n*L\n50#1:64,4\n50#1:68,7\n50#1:76,3\n50#1:80,9\n50#1:89\n59#1:92,2\n59#1:94,4\n59#1:98,7\n59#1:106,3\n59#1:110,9\n59#1:119\n59#1:120\n50#1:75\n50#1:79\n59#1:105\n59#1:109\n53#1:90,2\n61#1:121,3\n*E\n"})
public final class ScatterSetWrapperKt {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean fastAny(@NotNull Set<? extends Object> set, @NotNull Function1<Object, Boolean> function1) {
        if (!(set instanceof ScatterSetWrapper)) {
            Set<? extends Object> set2 = set;
            if ((set2 instanceof Collection) && set2.isEmpty()) {
                return false;
            }
            Iterator<T> it = set2.iterator();
            while (it.hasNext()) {
                if (function1.invoke(it.next()).booleanValue()) {
                    return true;
                }
            }
            return false;
        }
        ScatterSet set$runtime_release = ((ScatterSetWrapper) set).getSet$runtime_release();
        Object[] objArr = set$runtime_release.elements;
        long[] jArr = set$runtime_release.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128 && function1.invoke(objArr[(i << 3) + i4]).booleanValue()) {
                            return true;
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return false;
    }

    public static final <T> void fastForEach(@NotNull Set<? extends T> set, @NotNull Function1<? super T, Unit> function1) {
        if (!(set instanceof ScatterSetWrapper)) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
            return;
        }
        ScatterSet<T> set$runtime_release = ((ScatterSetWrapper) set).getSet$runtime_release();
        Object[] objArr = set$runtime_release.elements;
        long[] jArr = set$runtime_release.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        function1.invoke(objArr[(i << 3) + i4]);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    @NotNull
    public static final <T> Set<T> wrapIntoSet(@NotNull ScatterSet<T> scatterSet) {
        return new ScatterSetWrapper(scatterSet);
    }
}
