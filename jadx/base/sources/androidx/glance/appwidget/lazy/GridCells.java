package androidx.glance.appwidget.lazy;

import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/appwidget/lazy/GridCells;", "", "()V", "Adaptive", "Fixed", "Landroidx/glance/appwidget/lazy/GridCells$Adaptive;", "Landroidx/glance/appwidget/lazy/GridCells$Fixed;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class GridCells {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, m13886d2 = {"Landroidx/glance/appwidget/lazy/GridCells$Adaptive;", "Landroidx/glance/appwidget/lazy/GridCells;", "minSize", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinSize-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "equals", "", "other", "", "hashCode", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @RequiresApi(31)
    public static final class Adaptive extends GridCells {
        public static final int $stable = 0;
        private final float minSize;

        public /* synthetic */ Adaptive(float f, DefaultConstructorMarker defaultConstructorMarker) {
            this(f);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(Adaptive.class, other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.glance.appwidget.lazy.GridCells.Adaptive");
            return C2256Dp.m20973equalsimpl0(this.minSize, ((Adaptive) other).minSize);
        }

        /* JADX INFO: renamed from: getMinSize-D9Ej5fM, reason: not valid java name and from getter */
        public final float getMinSize() {
            return this.minSize;
        }

        public int hashCode() {
            return C2256Dp.m20974hashCodeimpl(this.minSize);
        }

        private Adaptive(float f) {
            super(null);
            this.minSize = f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, m13886d2 = {"Landroidx/glance/appwidget/lazy/GridCells$Fixed;", "Landroidx/glance/appwidget/lazy/GridCells;", "count", "", "(I)V", "getCount", "()I", "equals", "", "other", "", "hashCode", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Fixed extends GridCells {
        public static final int $stable = 0;
        private final int count;

        public Fixed(int i) {
            super(null);
            this.count = i;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(Fixed.class, other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.glance.appwidget.lazy.GridCells.Fixed");
            return this.count == ((Fixed) other).count;
        }

        public final int getCount() {
            return this.count;
        }

        public int hashCode() {
            return this.count;
        }
    }

    public /* synthetic */ GridCells(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GridCells() {
    }
}
