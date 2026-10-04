package androidx.compose.p109ui.graphics.layer;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.p109ui.graphics.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005J\u001d\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\bJ+\u0010\u0011\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0086\bR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "", "()V", "dependenciesSet", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "dependency", "oldDependenciesSet", "oldDependency", "trackingInProgress", "", "onDependencyAdded", "graphicsLayer", "removeDependencies", "", "block", "Lkotlin/Function1;", "withTracking", "onDependencyRemoved", "Lkotlin/Function0;", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nChildLayerDependenciesTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChildLayerDependenciesTracker.kt\nandroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker\n+ 2 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 4 InlineClassHelper.kt\nandroidx/compose/ui/graphics/InlineClassHelperKt\n*L\n1#1,117:1\n267#2,4:118\n237#2,7:122\n248#2,3:130\n251#2,2:134\n272#2,2:136\n254#2,6:138\n274#2:144\n267#2,4:152\n237#2,7:156\n248#2,3:164\n251#2,2:168\n272#2,2:170\n254#2,6:172\n274#2:178\n1810#3:129\n1672#3:133\n1810#3:163\n1672#3:167\n33#4,7:145\n*S KotlinDebug\n*F\n+ 1 ChildLayerDependenciesTracker.kt\nandroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker\n*L\n63#1:118,4\n63#1:122,7\n63#1:130,3\n63#1:134,2\n63#1:136,2\n63#1:138,6\n63#1:144\n112#1:152,4\n112#1:156,7\n112#1:164,3\n112#1:168,2\n112#1:170,2\n112#1:172,6\n112#1:178\n63#1:129\n63#1:133\n112#1:163\n112#1:167\n73#1:145,7\n*E\n"})
public final class ChildLayerDependenciesTracker {

    @Nullable
    private MutableScatterSet<GraphicsLayer> dependenciesSet;

    @Nullable
    private GraphicsLayer dependency;

    @Nullable
    private MutableScatterSet<GraphicsLayer> oldDependenciesSet;

    @Nullable
    private GraphicsLayer oldDependency;
    private boolean trackingInProgress;

    public final boolean onDependencyAdded(@NotNull GraphicsLayer graphicsLayer) {
        if (!this.trackingInProgress) {
            InlineClassHelperKt.throwIllegalArgumentException("Only add dependencies during a tracking");
        }
        MutableScatterSet<GraphicsLayer> mutableScatterSet = this.dependenciesSet;
        if (mutableScatterSet != null) {
            Intrinsics.checkNotNull(mutableScatterSet);
            mutableScatterSet.add(graphicsLayer);
        } else if (this.dependency != null) {
            MutableScatterSet<GraphicsLayer> mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
            GraphicsLayer graphicsLayer2 = this.dependency;
            Intrinsics.checkNotNull(graphicsLayer2);
            mutableScatterSetMutableScatterSetOf.add(graphicsLayer2);
            mutableScatterSetMutableScatterSetOf.add(graphicsLayer);
            this.dependenciesSet = mutableScatterSetMutableScatterSetOf;
            this.dependency = null;
        } else {
            this.dependency = graphicsLayer;
        }
        MutableScatterSet<GraphicsLayer> mutableScatterSet2 = this.oldDependenciesSet;
        if (mutableScatterSet2 != null) {
            Intrinsics.checkNotNull(mutableScatterSet2);
            return !mutableScatterSet2.remove(graphicsLayer);
        }
        if (this.oldDependency != graphicsLayer) {
            return true;
        }
        this.oldDependency = null;
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void removeDependencies(@NotNull Function1<? super GraphicsLayer, Unit> block) {
        ChildLayerDependenciesTracker childLayerDependenciesTracker;
        GraphicsLayer graphicsLayer = this.dependency;
        if (graphicsLayer != null) {
            block.invoke(graphicsLayer);
            childLayerDependenciesTracker = this;
            childLayerDependenciesTracker.dependency = null;
        } else {
            childLayerDependenciesTracker = this;
        }
        MutableScatterSet mutableScatterSet = childLayerDependenciesTracker.dependenciesSet;
        if (mutableScatterSet != null) {
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i4 = 0; i4 < i2; i4++) {
                            if ((255 & j) < 128) {
                                block.invoke(objArr[(i << 3) + i4]);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i == length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            mutableScatterSet.clear();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void withTracking(@NotNull Function1<? super GraphicsLayer, Unit> onDependencyRemoved, @NotNull Function0<Unit> block) {
        this.oldDependency = this.dependency;
        MutableScatterSet mutableScatterSet = this.dependenciesSet;
        if (mutableScatterSet != null && mutableScatterSet.isNotEmpty()) {
            MutableScatterSet mutableScatterSetMutableScatterSetOf = this.oldDependenciesSet;
            if (mutableScatterSetMutableScatterSetOf == null) {
                mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
                this.oldDependenciesSet = mutableScatterSetMutableScatterSetOf;
            }
            mutableScatterSetMutableScatterSetOf.addAll(mutableScatterSet);
            mutableScatterSet.clear();
        }
        this.trackingInProgress = true;
        block.invoke();
        this.trackingInProgress = false;
        GraphicsLayer graphicsLayer = this.oldDependency;
        if (graphicsLayer != null) {
            onDependencyRemoved.invoke(graphicsLayer);
        }
        MutableScatterSet mutableScatterSet2 = this.oldDependenciesSet;
        if (mutableScatterSet2 == null || !mutableScatterSet2.isNotEmpty()) {
            return;
        }
        Object[] objArr = mutableScatterSet2.elements;
        long[] jArr = mutableScatterSet2.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128) {
                            onDependencyRemoved.invoke(objArr[(i << 3) + i4]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    } else if (i == length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        mutableScatterSet2.clear();
    }
}
