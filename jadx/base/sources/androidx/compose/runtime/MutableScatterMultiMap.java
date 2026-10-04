package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0083@\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0003B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0088\u0001\u0004¨\u0006 "}, m13886d2 = {"Landroidx/compose/runtime/MutableScatterMultiMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "map", "Landroidx/collection/MutableScatterMap;", "constructor-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "equals", "", "other", "equals-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/collection/MutableScatterMap;)I", "pop", "key", "pop-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Ljava/lang/Object;", "put", "", "value", "put-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)V", "toString", "", "toString-impl", "(Landroidx/collection/MutableScatterMap;)Ljava/lang/String;", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmInline
@SourceDebugExtension({"SMAP\nComposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/MutableScatterMultiMap\n+ 2 ScatterMap.kt\nandroidx/collection/MutableScatterMap\n*L\n1#1,4584:1\n876#2,18:4585\n*S KotlinDebug\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/MutableScatterMultiMap\n*L\n4254#1:4585,18\n*E\n"})
final class MutableScatterMultiMap<K, V> {

    @NotNull
    private final MutableScatterMap<K, Object> map;

    private /* synthetic */ MutableScatterMultiMap(MutableScatterMap mutableScatterMap) {
        this.map = mutableScatterMap;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ MutableScatterMultiMap m17998boximpl(MutableScatterMap mutableScatterMap) {
        return new MutableScatterMultiMap(mutableScatterMap);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m18000equalsimpl(MutableScatterMap<K, Object> mutableScatterMap, Object obj) {
        return (obj instanceof MutableScatterMultiMap) && Intrinsics.areEqual(mutableScatterMap, ((MutableScatterMultiMap) obj).getMap());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m18001equalsimpl0(MutableScatterMap<K, Object> mutableScatterMap, MutableScatterMap<K, Object> mutableScatterMap2) {
        return Intrinsics.areEqual(mutableScatterMap, mutableScatterMap2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m18002hashCodeimpl(MutableScatterMap<K, Object> mutableScatterMap) {
        return mutableScatterMap.hashCode();
    }

    @Nullable
    /* JADX INFO: renamed from: pop-impl, reason: not valid java name */
    public static final V m18003popimpl(MutableScatterMap<K, Object> mutableScatterMap, K k) {
        V v = (V) mutableScatterMap.get(k);
        if (v == null) {
            return null;
        }
        if (TypeIntrinsics.isMutableList(v)) {
            List listAsMutableList = TypeIntrinsics.asMutableList(v);
            Object objRemove = listAsMutableList.remove(0);
            if (listAsMutableList.isEmpty()) {
                mutableScatterMap.remove(k);
            }
            v = (V) objRemove;
        } else {
            mutableScatterMap.remove(k);
        }
        Intrinsics.checkNotNull(v, "null cannot be cast to non-null type V of androidx.compose.runtime.MutableScatterMultiMap.pop_impl$lambda$1");
        return v;
    }

    /* JADX INFO: renamed from: put-impl, reason: not valid java name */
    public static final void m18004putimpl(MutableScatterMap<K, Object> mutableScatterMap, K k, @NotNull V v) {
        int iFindInsertIndex = mutableScatterMap.findInsertIndex(k);
        boolean z = iFindInsertIndex < 0;
        Object obj = z ? null : mutableScatterMap.values[iFindInsertIndex];
        if (obj != null) {
            if (TypeIntrinsics.isMutableList(obj)) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableList<V of androidx.compose.runtime.MutableScatterMultiMap.put_impl$lambda$0>");
                List listAsMutableList = TypeIntrinsics.asMutableList(obj);
                listAsMutableList.add(v);
                v = (V) listAsMutableList;
            } else {
                v = (V) CollectionsKt.mutableListOf(obj, v);
            }
        }
        if (!z) {
            mutableScatterMap.values[iFindInsertIndex] = v;
            return;
        }
        int i = ~iFindInsertIndex;
        mutableScatterMap.keys[i] = k;
        mutableScatterMap.values[i] = v;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m18005toStringimpl(MutableScatterMap<K, Object> mutableScatterMap) {
        return "MutableScatterMultiMap(map=" + mutableScatterMap + PropertyUtils.MAPPED_DELIM2;
    }

    public boolean equals(Object obj) {
        return m18000equalsimpl(this.map, obj);
    }

    @NotNull
    public final MutableScatterMap<K, Object> getMap() {
        return this.map;
    }

    public int hashCode() {
        return m18002hashCodeimpl(this.map);
    }

    public String toString() {
        return m18005toStringimpl(this.map);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ MutableScatterMap getMap() {
        return this.map;
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <K, V> MutableScatterMap<K, Object> m17999constructorimpl(@NotNull MutableScatterMap<K, Object> mutableScatterMap) {
        return mutableScatterMap;
    }
}
