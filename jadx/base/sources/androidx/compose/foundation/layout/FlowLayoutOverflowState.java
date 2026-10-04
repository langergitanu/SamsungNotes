package androidx.compose.foundation.layout;

import androidx.collection.AbstractC0622a;
import androidx.collection.IntIntPair;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.p109ui.layout.IntrinsicMeasurable;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010%\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b&J\u000e\u0010'\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b(J\u000e\u0010)\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b*J'\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J'\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0000¢\u0006\u0002\b1J-\u00102\u001a\u0004\u0018\u00010\r2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b3J\u0013\u00104\u001a\u00020\u00102\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0005HÖ\u0001J6\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\b\u0010 \u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010;\u001a\u00020<H\u0000ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\\\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<28\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(?\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ6\u00107\u001a\u0002082\b\u0010 \u001a\u0004\u0018\u00010B2\b\u0010\b\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\u00102\u0006\u0010;\u001a\u00020<H\u0000ø\u0001\u0000¢\u0006\u0004\b=\u0010DJ\t\u0010E\u001a\u00020FHÖ\u0001R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000RB\u0010\u000e\u001a6\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0014\u0010\u0014\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0017R\u0010\u0010 \u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\u0004\u0018\u00010\rX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, m13886d2 = {"Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "", "type", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "minLinesToShowCollapse", "", "minCrossAxisSizeToShowCollapse", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;II)V", "collapseMeasurable", "Landroidx/compose/ui/layout/Measurable;", "collapsePlaceable", "Landroidx/compose/ui/layout/Placeable;", "collapseSize", "Landroidx/collection/IntIntPair;", "getOverflowMeasurable", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isExpandable", "noOfItemsShown", "itemCount", "getItemCount$foundation_layout_release", "()I", "setItemCount$foundation_layout_release", "(I)V", "itemShown", "getItemShown$foundation_layout_release", "setItemShown$foundation_layout_release", "getMinCrossAxisSizeToShowCollapse$foundation_layout_release", "getMinLinesToShowCollapse$foundation_layout_release", "getNoOfItemsShown$foundation_layout_release", "seeMoreMeasurable", "seeMorePlaceable", "seeMoreSize", "getType$foundation_layout_release", "()Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "component1", "component1$foundation_layout_release", "component2", "component2$foundation_layout_release", "component3", "component3$foundation_layout_release", "copy", "ellipsisInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "hasNext", "lineIndex", "totalCrossAxisSize", "ellipsisInfo$foundation_layout_release", "ellipsisSize", "ellipsisSize-F35zm-w$foundation_layout_release", "equals", "other", "hashCode", "setOverflowMeasurables", "", "measurePolicy", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "setOverflowMeasurables--hBUhpc$foundation_layout_release", "(Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Landroidx/compose/ui/layout/Measurable;Landroidx/compose/ui/layout/Measurable;J)V", "numberOfItemsShown", "setOverflowMeasurables-VKLhPVY$foundation_layout_release", "(Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function2;)V", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "isHorizontal", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/layout/IntrinsicMeasurable;ZJ)V", "toString", "", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFlowLayoutOverflow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowLayoutOverflow.kt\nandroidx/compose/foundation/layout/FlowLayoutOverflowState\n+ 2 RowColumnImpl.kt\nandroidx/compose/foundation/layout/OrientationIndependentConstraints\n*L\n1#1,906:1\n232#2:907\n232#2:908\n*S KotlinDebug\n*F\n+ 1 FlowLayoutOverflow.kt\nandroidx/compose/foundation/layout/FlowLayoutOverflowState\n*L\n813#1:907\n825#1:908\n*E\n"})
public final /* data */ class FlowLayoutOverflowState {
    public static final int $stable = 8;

    @Nullable
    private Measurable collapseMeasurable;

    @Nullable
    private Placeable collapsePlaceable;

    @Nullable
    private IntIntPair collapseSize;

    @Nullable
    private Function2<? super Boolean, ? super Integer, ? extends Measurable> getOverflowMeasurable;
    private int itemCount;
    private int itemShown = -1;
    private final int minCrossAxisSizeToShowCollapse;
    private final int minLinesToShowCollapse;

    @Nullable
    private Measurable seeMoreMeasurable;

    @Nullable
    private Placeable seeMorePlaceable;

    @Nullable
    private IntIntPair seeMoreSize;

    @NotNull
    private final FlowLayoutOverflow.OverflowType type;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FlowLayoutOverflow.OverflowType.values().length];
            try {
                iArr[FlowLayoutOverflow.OverflowType.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlowLayoutOverflow.OverflowType.Clip.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FlowLayoutOverflow.OverflowType.ExpandIndicator.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FlowLayoutOverflowState(@NotNull FlowLayoutOverflow.OverflowType overflowType, int i, int i2) {
        this.type = overflowType;
        this.minLinesToShowCollapse = i;
        this.minCrossAxisSizeToShowCollapse = i2;
    }

    public static /* synthetic */ FlowLayoutOverflowState copy$default(FlowLayoutOverflowState flowLayoutOverflowState, FlowLayoutOverflow.OverflowType overflowType, int i, int i2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            overflowType = flowLayoutOverflowState.type;
        }
        if ((i4 & 2) != 0) {
            i = flowLayoutOverflowState.minLinesToShowCollapse;
        }
        if ((i4 & 4) != 0) {
            i2 = flowLayoutOverflowState.minCrossAxisSizeToShowCollapse;
        }
        return flowLayoutOverflowState.copy(overflowType, i, i2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1$foundation_layout_release, reason: from getter */
    public final FlowLayoutOverflow.OverflowType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2$foundation_layout_release, reason: from getter */
    public final int getMinLinesToShowCollapse() {
        return this.minLinesToShowCollapse;
    }

    /* JADX INFO: renamed from: component3$foundation_layout_release, reason: from getter */
    public final int getMinCrossAxisSizeToShowCollapse() {
        return this.minCrossAxisSizeToShowCollapse;
    }

    @NotNull
    public final FlowLayoutOverflowState copy(@NotNull FlowLayoutOverflow.OverflowType type, int minLinesToShowCollapse, int minCrossAxisSizeToShowCollapse) {
        return new FlowLayoutOverflowState(type, minLinesToShowCollapse, minCrossAxisSizeToShowCollapse);
    }

    @Nullable
    public final FlowLayoutBuildingBlocks.WrapEllipsisInfo ellipsisInfo$foundation_layout_release(boolean hasNext, int lineIndex, int totalCrossAxisSize) {
        Measurable measurableInvoke;
        IntIntPair intIntPair;
        Placeable placeable;
        Measurable measurable;
        Placeable placeable2;
        int i = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3 && i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (hasNext) {
                Function2<? super Boolean, ? super Integer, ? extends Measurable> function2 = this.getOverflowMeasurable;
                if (function2 == null || (measurableInvoke = function2.invoke(Boolean.TRUE, Integer.valueOf(getNoOfItemsShown$foundation_layout_release()))) == null) {
                    measurableInvoke = this.seeMoreMeasurable;
                }
                intIntPair = this.seeMoreSize;
                if (this.getOverflowMeasurable == null) {
                    placeable = this.seeMorePlaceable;
                    measurable = measurableInvoke;
                    placeable2 = placeable;
                }
                measurable = measurableInvoke;
                placeable2 = null;
            } else {
                if (lineIndex < this.minLinesToShowCollapse - 1 || totalCrossAxisSize < this.minCrossAxisSizeToShowCollapse) {
                    measurableInvoke = null;
                } else {
                    Function2<? super Boolean, ? super Integer, ? extends Measurable> function22 = this.getOverflowMeasurable;
                    if (function22 == null || (measurableInvoke = function22.invoke(Boolean.FALSE, Integer.valueOf(getNoOfItemsShown$foundation_layout_release()))) == null) {
                        measurableInvoke = this.collapseMeasurable;
                    }
                }
                intIntPair = this.collapseSize;
                if (this.getOverflowMeasurable == null) {
                    placeable = this.collapsePlaceable;
                    measurable = measurableInvoke;
                    placeable2 = placeable;
                }
                measurable = measurableInvoke;
                placeable2 = null;
            }
            if (measurable != null) {
                Intrinsics.checkNotNull(intIntPair);
                return new FlowLayoutBuildingBlocks.WrapEllipsisInfo(measurable, placeable2, intIntPair.getPackedValue(), false, 8, null);
            }
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: ellipsisSize-F35zm-w$foundation_layout_release, reason: not valid java name */
    public final IntIntPair m15782ellipsisSizeF35zmw$foundation_layout_release(boolean hasNext, int lineIndex, int totalCrossAxisSize) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3) {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                if (hasNext) {
                    return this.seeMoreSize;
                }
                if (lineIndex + 1 < this.minLinesToShowCollapse || totalCrossAxisSize < this.minCrossAxisSizeToShowCollapse) {
                    return null;
                }
                return this.collapseSize;
            }
            if (hasNext) {
                return this.seeMoreSize;
            }
        }
        return null;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowLayoutOverflowState)) {
            return false;
        }
        FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) other;
        return this.type == flowLayoutOverflowState.type && this.minLinesToShowCollapse == flowLayoutOverflowState.minLinesToShowCollapse && this.minCrossAxisSizeToShowCollapse == flowLayoutOverflowState.minCrossAxisSizeToShowCollapse;
    }

    /* JADX INFO: renamed from: getItemCount$foundation_layout_release, reason: from getter */
    public final int getItemCount() {
        return this.itemCount;
    }

    /* JADX INFO: renamed from: getItemShown$foundation_layout_release, reason: from getter */
    public final int getItemShown() {
        return this.itemShown;
    }

    public final int getMinCrossAxisSizeToShowCollapse$foundation_layout_release() {
        return this.minCrossAxisSizeToShowCollapse;
    }

    public final int getMinLinesToShowCollapse$foundation_layout_release() {
        return this.minLinesToShowCollapse;
    }

    public final int getNoOfItemsShown$foundation_layout_release() {
        int i = this.itemShown;
        if (i != -1) {
            return i;
        }
        throw new IllegalStateException("Accessing noOfItemsShown before it is set. Are you calling this in the Composition phase, rather than in the draw phase? Consider our samples on how to use it during the draw phase or consider using ContextualFlowRow/ContextualFlowColumn which initializes this method in the composition phase.");
    }

    @NotNull
    public final FlowLayoutOverflow.OverflowType getType$foundation_layout_release() {
        return this.type;
    }

    public int hashCode() {
        return Integer.hashCode(this.minCrossAxisSizeToShowCollapse) + AbstractC0622a.m1157c(this.minLinesToShowCollapse, this.type.hashCode() * 31, 31);
    }

    public final void setItemCount$foundation_layout_release(int i) {
        this.itemCount = i;
    }

    public final void setItemShown$foundation_layout_release(int i) {
        this.itemShown = i;
    }

    /* JADX INFO: renamed from: setOverflowMeasurables--hBUhpc$foundation_layout_release, reason: not valid java name */
    public final void m15784setOverflowMeasurableshBUhpc$foundation_layout_release(@Nullable IntrinsicMeasurable seeMoreMeasurable, @Nullable IntrinsicMeasurable collapseMeasurable, boolean isHorizontal, long constraints) {
        long jM15823constructorimpl = OrientationIndependentConstraints.m15823constructorimpl(constraints, isHorizontal ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical);
        if (seeMoreMeasurable != null) {
            int iMainAxisMin = FlowLayoutKt.mainAxisMin(seeMoreMeasurable, isHorizontal, Constraints.m20920getMaxHeightimpl(jM15823constructorimpl));
            this.seeMoreSize = IntIntPair.m15197boximpl(IntIntPair.m15200constructorimpl(iMainAxisMin, FlowLayoutKt.crossAxisMin(seeMoreMeasurable, isHorizontal, iMainAxisMin)));
            this.seeMoreMeasurable = seeMoreMeasurable instanceof Measurable ? (Measurable) seeMoreMeasurable : null;
            this.seeMorePlaceable = null;
        }
        if (collapseMeasurable != null) {
            int iMainAxisMin2 = FlowLayoutKt.mainAxisMin(collapseMeasurable, isHorizontal, Constraints.m20920getMaxHeightimpl(jM15823constructorimpl));
            this.collapseSize = IntIntPair.m15197boximpl(IntIntPair.m15200constructorimpl(iMainAxisMin2, FlowLayoutKt.crossAxisMin(collapseMeasurable, isHorizontal, iMainAxisMin2)));
            this.collapseMeasurable = collapseMeasurable instanceof Measurable ? (Measurable) collapseMeasurable : null;
            this.collapsePlaceable = null;
        }
    }

    /* JADX INFO: renamed from: setOverflowMeasurables-VKLhPVY$foundation_layout_release, reason: not valid java name */
    public final void m15785setOverflowMeasurablesVKLhPVY$foundation_layout_release(@NotNull FlowLineMeasurePolicy measurePolicy, long constraints, @NotNull Function2<? super Boolean, ? super Integer, ? extends Measurable> getOverflowMeasurable) {
        this.itemShown = 0;
        this.getOverflowMeasurable = getOverflowMeasurable;
        m15783setOverflowMeasurableshBUhpc$foundation_layout_release(measurePolicy, getOverflowMeasurable.invoke(Boolean.TRUE, 0), getOverflowMeasurable.invoke(Boolean.FALSE, 0), constraints);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("FlowLayoutOverflowState(type=");
        sb.append(this.type);
        sb.append(", minLinesToShowCollapse=");
        sb.append(this.minLinesToShowCollapse);
        sb.append(", minCrossAxisSizeToShowCollapse=");
        return AbstractC0000a.m13j(sb, this.minCrossAxisSizeToShowCollapse, PropertyUtils.MAPPED_DELIM2);
    }

    /* JADX INFO: renamed from: setOverflowMeasurables--hBUhpc$foundation_layout_release, reason: not valid java name */
    public final void m15783setOverflowMeasurableshBUhpc$foundation_layout_release(@NotNull final FlowLineMeasurePolicy measurePolicy, @Nullable Measurable seeMoreMeasurable, @Nullable Measurable collapseMeasurable, long constraints) {
        LayoutOrientation layoutOrientation = measurePolicy.isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical;
        long jM15836toBoxConstraintsOenEA2s = OrientationIndependentConstraints.m15836toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m15825copyyUG9Ft0$default(OrientationIndependentConstraints.m15823constructorimpl(constraints, layoutOrientation), 0, 0, 0, 0, 10, null), layoutOrientation);
        if (seeMoreMeasurable != null) {
            FlowLayoutKt.m15780measureAndCacherqJ1uqs(seeMoreMeasurable, measurePolicy, jM15836toBoxConstraintsOenEA2s, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutOverflowState$setOverflowMeasurables$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable placeable) {
                    invoke2(placeable);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Placeable placeable) {
                    int iMainAxisSize;
                    int iCrossAxisSize;
                    if (placeable != null) {
                        FlowLineMeasurePolicy flowLineMeasurePolicy = measurePolicy;
                        iMainAxisSize = flowLineMeasurePolicy.mainAxisSize(placeable);
                        iCrossAxisSize = flowLineMeasurePolicy.crossAxisSize(placeable);
                    } else {
                        iMainAxisSize = 0;
                        iCrossAxisSize = 0;
                    }
                    this.this$0.seeMoreSize = IntIntPair.m15197boximpl(IntIntPair.m15200constructorimpl(iMainAxisSize, iCrossAxisSize));
                    this.this$0.seeMorePlaceable = placeable;
                }
            });
            this.seeMoreMeasurable = seeMoreMeasurable;
        }
        if (collapseMeasurable != null) {
            FlowLayoutKt.m15780measureAndCacherqJ1uqs(collapseMeasurable, measurePolicy, jM15836toBoxConstraintsOenEA2s, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutOverflowState$setOverflowMeasurables$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable placeable) {
                    invoke2(placeable);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Placeable placeable) {
                    int iMainAxisSize;
                    int iCrossAxisSize;
                    if (placeable != null) {
                        FlowLineMeasurePolicy flowLineMeasurePolicy = measurePolicy;
                        iMainAxisSize = flowLineMeasurePolicy.mainAxisSize(placeable);
                        iCrossAxisSize = flowLineMeasurePolicy.crossAxisSize(placeable);
                    } else {
                        iMainAxisSize = 0;
                        iCrossAxisSize = 0;
                    }
                    this.this$0.collapseSize = IntIntPair.m15197boximpl(IntIntPair.m15200constructorimpl(iMainAxisSize, iCrossAxisSize));
                    this.this$0.collapsePlaceable = placeable;
                }
            });
            this.collapseMeasurable = collapseMeasurable;
        }
    }
}
