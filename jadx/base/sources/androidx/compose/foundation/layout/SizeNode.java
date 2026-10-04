package androidx.compose.foundation.layout;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.IntrinsicMeasurable;
import androidx.compose.p109ui.layout.IntrinsicMeasureScope;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.LayoutModifierNode;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020 H\u0016J\u001c\u0010%\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010&\u001a\u00020 H\u0016J&\u0010'\u001a\u00020(*\u00020)2\u0006\u0010\"\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001c\u0010.\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020 H\u0016J\u001c\u0010/\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010&\u001a\u00020 H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0007\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0005\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R\"\u0010\u0003\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001e\u0010\u001a\u001a\u00020\u001b*\u00020\u001c8BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, m13886d2 = {"Landroidx/compose/foundation/layout/SizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEnforceIncoming", "()Z", "setEnforceIncoming", "(Z)V", "getMaxHeight-D9Ej5fM", "()F", "setMaxHeight-0680j_4", "(F)V", TokenizerME.NO_SPLIT, "getMaxWidth-D9Ej5fM", "setMaxWidth-0680j_4", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "getMinWidth-D9Ej5fM", "setMinWidth-0680j_4", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public /* synthetic */ SizeNode(float f, float f4, float f5, float f6, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, f5, f6, z);
    }

    /* JADX INFO: renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    private final long m15907getTargetConstraintsOenEA2s(Density density) {
        int iCoerceAtLeast;
        int iCoerceAtLeast2;
        float f = this.maxWidth;
        C2256Dp.Companion companion = C2256Dp.INSTANCE;
        int i = 0;
        int iCoerceAtLeast3 = !C2256Dp.m20973equalsimpl0(f, companion.m20988getUnspecifiedD9Ej5fM()) ? RangesKt.coerceAtLeast(density.mo15540roundToPx0680j_4(this.maxWidth), 0) : Integer.MAX_VALUE;
        int iCoerceAtLeast4 = !C2256Dp.m20973equalsimpl0(this.maxHeight, companion.m20988getUnspecifiedD9Ej5fM()) ? RangesKt.coerceAtLeast(density.mo15540roundToPx0680j_4(this.maxHeight), 0) : Integer.MAX_VALUE;
        if (C2256Dp.m20973equalsimpl0(this.minWidth, companion.m20988getUnspecifiedD9Ej5fM()) || (iCoerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(density.mo15540roundToPx0680j_4(this.minWidth), iCoerceAtLeast3), 0)) == Integer.MAX_VALUE) {
            iCoerceAtLeast = 0;
        }
        if (!C2256Dp.m20973equalsimpl0(this.minHeight, companion.m20988getUnspecifiedD9Ej5fM()) && (iCoerceAtLeast2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(density.mo15540roundToPx0680j_4(this.minHeight), iCoerceAtLeast4), 0)) != Integer.MAX_VALUE) {
            i = iCoerceAtLeast2;
        }
        return ConstraintsKt.Constraints(iCoerceAtLeast, iCoerceAtLeast3, i, iCoerceAtLeast4);
    }

    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMaxHeight() {
        return this.maxHeight;
    }

    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMaxWidth() {
        return this.maxWidth;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinHeight() {
        return this.minHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinWidth() {
        return this.minWidth;
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM15907getTargetConstraintsOenEA2s = m15907getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m20918getHasFixedHeightimpl(jM15907getTargetConstraintsOenEA2s) ? Constraints.m20920getMaxHeightimpl(jM15907getTargetConstraintsOenEA2s) : ConstraintsKt.m20937constrainHeightK40F9xA(jM15907getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicHeight(i));
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM15907getTargetConstraintsOenEA2s = m15907getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m20919getHasFixedWidthimpl(jM15907getTargetConstraintsOenEA2s) ? Constraints.m20921getMaxWidthimpl(jM15907getTargetConstraintsOenEA2s) : ConstraintsKt.m20938constrainWidthK40F9xA(jM15907getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo15266measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        long jConstraints;
        long jM15907getTargetConstraintsOenEA2s = m15907getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            jConstraints = ConstraintsKt.m20936constrainN9IONVI(j, jM15907getTargetConstraintsOenEA2s);
        } else {
            float f = this.minWidth;
            C2256Dp.Companion companion = C2256Dp.INSTANCE;
            jConstraints = ConstraintsKt.Constraints(!C2256Dp.m20973equalsimpl0(f, companion.m20988getUnspecifiedD9Ej5fM()) ? Constraints.m20923getMinWidthimpl(jM15907getTargetConstraintsOenEA2s) : RangesKt.coerceAtMost(Constraints.m20923getMinWidthimpl(j), Constraints.m20921getMaxWidthimpl(jM15907getTargetConstraintsOenEA2s)), !C2256Dp.m20973equalsimpl0(this.maxWidth, companion.m20988getUnspecifiedD9Ej5fM()) ? Constraints.m20921getMaxWidthimpl(jM15907getTargetConstraintsOenEA2s) : RangesKt.coerceAtLeast(Constraints.m20921getMaxWidthimpl(j), Constraints.m20923getMinWidthimpl(jM15907getTargetConstraintsOenEA2s)), !C2256Dp.m20973equalsimpl0(this.minHeight, companion.m20988getUnspecifiedD9Ej5fM()) ? Constraints.m20922getMinHeightimpl(jM15907getTargetConstraintsOenEA2s) : RangesKt.coerceAtMost(Constraints.m20922getMinHeightimpl(j), Constraints.m20920getMaxHeightimpl(jM15907getTargetConstraintsOenEA2s)), !C2256Dp.m20973equalsimpl0(this.maxHeight, companion.m20988getUnspecifiedD9Ej5fM()) ? Constraints.m20920getMaxHeightimpl(jM15907getTargetConstraintsOenEA2s) : RangesKt.coerceAtLeast(Constraints.m20920getMaxHeightimpl(j), Constraints.m20922getMinHeightimpl(jM15907getTargetConstraintsOenEA2s)));
        }
        final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(jConstraints);
        return MeasureScope.layout$default(measureScope, placeableMo19855measureBRTryo0.getWidth(), placeableMo19855measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.SizeNode$measure$1
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
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo19855measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM15907getTargetConstraintsOenEA2s = m15907getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m20918getHasFixedHeightimpl(jM15907getTargetConstraintsOenEA2s) ? Constraints.m20920getMaxHeightimpl(jM15907getTargetConstraintsOenEA2s) : ConstraintsKt.m20937constrainHeightK40F9xA(jM15907getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM15907getTargetConstraintsOenEA2s = m15907getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m20919getHasFixedWidthimpl(jM15907getTargetConstraintsOenEA2s) ? Constraints.m20921getMaxWidthimpl(jM15907getTargetConstraintsOenEA2s) : ConstraintsKt.m20938constrainWidthK40F9xA(jM15907getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicWidth(i));
    }

    public final void setEnforceIncoming(boolean z) {
        this.enforceIncoming = z;
    }

    /* JADX INFO: renamed from: setMaxHeight-0680j_4, reason: not valid java name */
    public final void m15912setMaxHeight0680j_4(float f) {
        this.maxHeight = f;
    }

    /* JADX INFO: renamed from: setMaxWidth-0680j_4, reason: not valid java name */
    public final void m15913setMaxWidth0680j_4(float f) {
        this.maxWidth = f;
    }

    /* JADX INFO: renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m15914setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    /* JADX INFO: renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m15915setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    public /* synthetic */ SizeNode(float f, float f4, float f5, float f6, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM() : f4, (i & 4) != 0 ? C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM() : f5, (i & 8) != 0 ? C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM() : f6, z, null);
    }

    private SizeNode(float f, float f4, float f5, float f6, boolean z) {
        this.minWidth = f;
        this.minHeight = f4;
        this.maxWidth = f5;
        this.maxHeight = f6;
        this.enforceIncoming = z;
    }
}
