package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.layout.IntrinsicMeasurable;
import androidx.compose.p109ui.layout.IntrinsicMeasureScope;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\b\u001a\u00020\u0004HÂ\u0003J\t\u0010\t\u001a\u00020\u0006HÂ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J=\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J*\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J\t\u0010 \u001a\u00020\u000eHÖ\u0001Jg\u0010!\u001a\u00020\"2\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010(2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010.J(\u0010/\u001a\u0002002\u0006\u0010)\u001a\u00020\u000e2\u0006\u00101\u001a\u00020(2\u0006\u0010'\u001a\u00020(2\u0006\u0010%\u001a\u00020&H\u0016J\t\u00102\u001a\u000203HÖ\u0001J\f\u00104\u001a\u00020\u000e*\u00020\u001bH\u0016J\f\u00105\u001a\u00020\u000e*\u00020\u001bH\u0016J\"\u00106\u001a\u00020\u000e*\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020:092\u0006\u0010;\u001a\u00020\u000eH\u0016J\"\u0010<\u001a\u00020\u000e*\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020:092\u0006\u0010=\u001a\u00020\u000eH\u0016J,\u0010>\u001a\u00020\"*\u00020&2\f\u00108\u001a\b\u0012\u0004\u0012\u00020?092\u0006\u0010@\u001a\u00020\fH\u0016ø\u0001\u0001¢\u0006\u0004\bA\u0010BJ\"\u0010C\u001a\u00020\u000e*\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020:092\u0006\u0010;\u001a\u00020\u000eH\u0016J\"\u0010D\u001a\u00020\u000e*\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020:092\u0006\u0010=\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006E"}, m13886d2 = {"Landroidx/compose/foundation/layout/RowMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;)V", "component1", "component2", "copy", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "isPrioritizing", "", "createConstraints-xF2OJ5Q", "(IIIIZ)J", "equals", "other", "", "getCrossAxisPosition", "placeable", "Landroidx/compose/ui/layout/Placeable;", "parentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "crossAxisLayoutSize", "beforeCrossAxisAlignmentLine", "hashCode", "placeHelper", "Landroidx/compose/ui/layout/MeasureResult;", "placeables", "", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "mainAxisPositions", "", "mainAxisLayoutSize", "crossAxisOffset", "currentLineIndex", TextConst.KEY_START_INDEX, TextConst.KEY_END_INDEX, "([Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/MeasureScope;I[III[IIII)Landroidx/compose/ui/layout/MeasureResult;", "populateMainAxisPositions", "", "childrenMainAxisSize", "toString", "", "crossAxisSize", "mainAxisSize", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class RowMeasurePolicy implements MeasurePolicy, RowColumnMeasurePolicy {
    public static final int $stable = 0;

    @NotNull
    private final Arrangement.Horizontal horizontalArrangement;

    @NotNull
    private final Alignment.Vertical verticalAlignment;

    public RowMeasurePolicy(@NotNull Arrangement.Horizontal horizontal, @NotNull Alignment.Vertical vertical) {
        this.horizontalArrangement = horizontal;
        this.verticalAlignment = vertical;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final Alignment.Vertical getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public static /* synthetic */ RowMeasurePolicy copy$default(RowMeasurePolicy rowMeasurePolicy, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, int i, Object obj) {
        if ((i & 1) != 0) {
            horizontal = rowMeasurePolicy.horizontalArrangement;
        }
        if ((i & 2) != 0) {
            vertical = rowMeasurePolicy.verticalAlignment;
        }
        return rowMeasurePolicy.copy(horizontal, vertical);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCrossAxisPosition(Placeable placeable, RowColumnParentData parentData, int crossAxisLayoutSize, int beforeCrossAxisAlignmentLine) {
        CrossAxisAlignment crossAxisAlignment = parentData != null ? parentData.getCrossAxisAlignment() : null;
        return crossAxisAlignment != null ? crossAxisAlignment.align$foundation_layout_release(crossAxisLayoutSize - placeable.getHeight(), LayoutDirection.Ltr, placeable, beforeCrossAxisAlignmentLine) : this.verticalAlignment.align(0, crossAxisLayoutSize - placeable.getHeight());
    }

    @NotNull
    public final RowMeasurePolicy copy(@NotNull Arrangement.Horizontal horizontalArrangement, @NotNull Alignment.Vertical verticalAlignment) {
        return new RowMeasurePolicy(horizontalArrangement, verticalAlignment);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    /* JADX INFO: renamed from: createConstraints-xF2OJ5Q */
    public long mo15769createConstraintsxF2OJ5Q(int mainAxisMin, int crossAxisMin, int mainAxisMax, int crossAxisMax, boolean isPrioritizing) {
        return RowKt.createRowConstraints(isPrioritizing, mainAxisMin, crossAxisMin, mainAxisMax, crossAxisMax);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int crossAxisSize(@NotNull Placeable placeable) {
        return placeable.getHeight();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RowMeasurePolicy)) {
            return false;
        }
        RowMeasurePolicy rowMeasurePolicy = (RowMeasurePolicy) other;
        return Intrinsics.areEqual(this.horizontalArrangement, rowMeasurePolicy.horizontalArrangement) && Intrinsics.areEqual(this.verticalAlignment, rowMeasurePolicy.verticalAlignment);
    }

    public int hashCode() {
        return this.verticalAlignment.hashCode() + (this.horizontalArrangement.hashCode() * 31);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int mainAxisSize(@NotNull Placeable placeable) {
        return placeable.getWidth();
    }

    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMaxHeight(list, i, intrinsicMeasureScope.mo15540roundToPx0680j_4(this.horizontalArrangement.getSpacing()));
    }

    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMaxWidth(list, i, intrinsicMeasureScope.mo15540roundToPx0680j_4(this.horizontalArrangement.getSpacing()));
    }

    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        return RowColumnMeasurePolicyKt.measure(this, Constraints.m20923getMinWidthimpl(j), Constraints.m20922getMinHeightimpl(j), Constraints.m20921getMaxWidthimpl(j), Constraints.m20920getMaxHeightimpl(j), measureScope.mo15540roundToPx0680j_4(this.horizontalArrangement.getSpacing()), measureScope, list, new Placeable[list.size()], 0, list.size(), (3072 & 1024) != 0 ? null : null, (3072 & 2048) != 0 ? 0 : 0);
    }

    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMinHeight(list, i, intrinsicMeasureScope.mo15540roundToPx0680j_4(this.horizontalArrangement.getSpacing()));
    }

    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMinWidth(list, i, intrinsicMeasureScope.mo15540roundToPx0680j_4(this.horizontalArrangement.getSpacing()));
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    @NotNull
    public MeasureResult placeHelper(@NotNull final Placeable[] placeables, @NotNull MeasureScope measureScope, final int beforeCrossAxisAlignmentLine, @NotNull final int[] mainAxisPositions, int mainAxisLayoutSize, final int crossAxisLayoutSize, @Nullable int[] crossAxisOffset, int currentLineIndex, int startIndex, int endIndex) {
        return MeasureScope.layout$default(measureScope, mainAxisLayoutSize, crossAxisLayoutSize, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.RowMeasurePolicy$placeHelper$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                Placeable[] placeableArr = placeables;
                RowMeasurePolicy rowMeasurePolicy = this;
                int i = crossAxisLayoutSize;
                int i2 = beforeCrossAxisAlignmentLine;
                int[] iArr = mainAxisPositions;
                int length = placeableArr.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    Placeable placeable = placeableArr[i4];
                    Intrinsics.checkNotNull(placeable);
                    Placeable.PlacementScope.place$default(placementScope, placeable, iArr[i5], rowMeasurePolicy.getCrossAxisPosition(placeable, RowColumnImplKt.getRowColumnParentData(placeable), i, i2), 0.0f, 4, null);
                    i4++;
                    i5++;
                }
            }
        }, 4, null);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public void populateMainAxisPositions(int mainAxisLayoutSize, @NotNull int[] childrenMainAxisSize, @NotNull int[] mainAxisPositions, @NotNull MeasureScope measureScope) {
        this.horizontalArrangement.arrange(measureScope, mainAxisLayoutSize, childrenMainAxisSize, measureScope.getLayoutDirection(), mainAxisPositions);
    }

    @NotNull
    public String toString() {
        return "RowMeasurePolicy(horizontalArrangement=" + this.horizontalArrangement + ", verticalAlignment=" + this.verticalAlignment + PropertyUtils.MAPPED_DELIM2;
    }
}
