package androidx.compose.foundation.gestures;

import androidx.collection.ObjectFloatMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0017\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u001f\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J@\u0010\u0014\u001a\u00020\u001526\u0010\u0016\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00150\u0017H\u0016J\u0015\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\fH\u0016J\u0015\u0010!\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020$H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006%"}, m13886d2 = {"Landroidx/compose/foundation/gestures/MapDraggableAnchors;", "T", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "anchors", "Landroidx/collection/ObjectFloatMap;", "(Landroidx/collection/ObjectFloatMap;)V", "size", "", "getSize", "()I", "closestAnchor", "position", "", "(F)Ljava/lang/Object;", "searchUpwards", "", "(FZ)Ljava/lang/Object;", "equals", "other", "", "forEach", "", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "anchor", "hasAnchorFor", "value", "(Ljava/lang/Object;)Z", "hashCode", "maxAnchor", "minAnchor", "positionOf", "(Ljava/lang/Object;)F", "toString", "", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAnchoredDraggable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnchoredDraggable.kt\nandroidx/compose/foundation/gestures/MapDraggableAnchors\n+ 2 ObjectFloatMap.kt\nandroidx/collection/ObjectFloatMap\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1220:1\n401#2,4:1221\n373#2,6:1225\n383#2,3:1232\n386#2,2:1236\n406#2,2:1238\n389#2,6:1240\n408#2:1246\n401#2,4:1247\n373#2,6:1251\n383#2,3:1258\n386#2,2:1262\n406#2,2:1264\n389#2,6:1266\n408#2:1272\n401#2,4:1273\n373#2,6:1277\n383#2,3:1284\n386#2,2:1288\n406#2,2:1290\n389#2,6:1292\n408#2:1298\n1810#3:1231\n1672#3:1235\n1810#3:1257\n1672#3:1261\n1810#3:1283\n1672#3:1287\n*S KotlinDebug\n*F\n+ 1 AnchoredDraggable.kt\nandroidx/compose/foundation/gestures/MapDraggableAnchors\n*L\n1142#1:1221,4\n1142#1:1225,6\n1142#1:1232,3\n1142#1:1236,2\n1142#1:1238,2\n1142#1:1240,6\n1142#1:1246\n1158#1:1247,4\n1158#1:1251,6\n1158#1:1258,3\n1158#1:1262,2\n1158#1:1264,2\n1158#1:1266,6\n1158#1:1272\n1188#1:1273,4\n1188#1:1277,6\n1188#1:1284,3\n1188#1:1288,2\n1188#1:1290,2\n1188#1:1292,6\n1188#1:1298\n1142#1:1231\n1142#1:1235\n1158#1:1257\n1158#1:1261\n1188#1:1283\n1188#1:1287\n*E\n"})
final class MapDraggableAnchors<T> implements DraggableAnchors<T> {

    @NotNull
    private final ObjectFloatMap<T> anchors;

    public MapDraggableAnchors(@NotNull ObjectFloatMap<T> objectFloatMap) {
        this.anchors = objectFloatMap;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    @Nullable
    public T closestAnchor(float position) {
        ObjectFloatMap<T> objectFloatMap = this.anchors;
        Object[] objArr = objectFloatMap.keys;
        float[] fArr = objectFloatMap.values;
        long[] jArr = objectFloatMap.metadata;
        int length = jArr.length - 2;
        T t = null;
        if (length >= 0) {
            float f = Float.POSITIVE_INFINITY;
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            Object obj = objArr[i5];
                            float fAbs = Math.abs(position - fArr[i5]);
                            if (fAbs <= f) {
                                f = fAbs;
                                t = (T) obj;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return t;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return t;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MapDraggableAnchors) {
            return Intrinsics.areEqual(this.anchors, ((MapDraggableAnchors) other).anchors);
        }
        return false;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public void forEach(@NotNull Function2<? super T, ? super Float, Unit> block) {
        ObjectFloatMap<T> objectFloatMap = this.anchors;
        Object[] objArr = objectFloatMap.keys;
        float[] fArr = objectFloatMap.values;
        long[] jArr = objectFloatMap.metadata;
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
                        int i5 = (i << 3) + i4;
                        block.invoke(objArr[i5], Float.valueOf(fArr[i5]));
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

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public int getSize() {
        return this.anchors.get_size();
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public boolean hasAnchorFor(T value) {
        return this.anchors.containsKey(value);
    }

    public int hashCode() {
        return this.anchors.hashCode() * 31;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float maxAnchor() {
        return AnchoredDraggableKt.maxValueOrNaN(this.anchors);
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float minAnchor() {
        return AnchoredDraggableKt.minValueOrNaN(this.anchors);
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float positionOf(T value) {
        return this.anchors.getOrDefault(value, Float.NaN);
    }

    @NotNull
    public String toString() {
        return "MapDraggableAnchors(" + this.anchors + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    @Nullable
    public T closestAnchor(float position, boolean searchUpwards) {
        ObjectFloatMap<T> objectFloatMap = this.anchors;
        Object[] objArr = objectFloatMap.keys;
        float[] fArr = objectFloatMap.values;
        long[] jArr = objectFloatMap.metadata;
        int length = jArr.length - 2;
        T t = null;
        if (length >= 0) {
            float f = Float.POSITIVE_INFINITY;
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            Object obj = objArr[i5];
                            float f4 = fArr[i5];
                            float f5 = searchUpwards ? f4 - position : position - f4;
                            if (f5 < 0.0f) {
                                f5 = Float.POSITIVE_INFINITY;
                            }
                            if (f5 <= f) {
                                f = f5;
                                t = (T) obj;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return t;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return t;
    }
}
