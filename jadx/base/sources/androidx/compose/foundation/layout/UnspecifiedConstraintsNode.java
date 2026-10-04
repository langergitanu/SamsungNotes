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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J&\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010\u001e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u001f\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000fH\u0016R\"\u0010\u0005\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, m13886d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinHeight-D9Ej5fM", "()F", "setMinHeight-0680j_4", "(F)V", TokenizerME.NO_SPLIT, "getMinWidth-D9Ej5fM", "setMinWidth-0680j_4", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {
    private float minHeight;
    private float minWidth;

    public /* synthetic */ UnspecifiedConstraintsNode(float f, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4);
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
        return RangesKt.coerceAtLeast(intrinsicMeasurable.maxIntrinsicHeight(i), !C2256Dp.m20973equalsimpl0(this.minHeight, C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo15540roundToPx0680j_4(this.minHeight) : 0);
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return RangesKt.coerceAtLeast(intrinsicMeasurable.maxIntrinsicWidth(i), !C2256Dp.m20973equalsimpl0(this.minWidth, C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo15540roundToPx0680j_4(this.minWidth) : 0);
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo15266measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        float f = this.minWidth;
        C2256Dp.Companion companion = C2256Dp.INSTANCE;
        final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(ConstraintsKt.Constraints((C2256Dp.m20973equalsimpl0(f, companion.m20988getUnspecifiedD9Ej5fM()) || Constraints.m20923getMinWidthimpl(j) != 0) ? Constraints.m20923getMinWidthimpl(j) : RangesKt.coerceAtLeast(RangesKt.coerceAtMost(measureScope.mo15540roundToPx0680j_4(this.minWidth), Constraints.m20921getMaxWidthimpl(j)), 0), Constraints.m20921getMaxWidthimpl(j), (C2256Dp.m20973equalsimpl0(this.minHeight, companion.m20988getUnspecifiedD9Ej5fM()) || Constraints.m20922getMinHeightimpl(j) != 0) ? Constraints.m20922getMinHeightimpl(j) : RangesKt.coerceAtLeast(RangesKt.coerceAtMost(measureScope.mo15540roundToPx0680j_4(this.minHeight), Constraints.m20920getMaxHeightimpl(j)), 0), Constraints.m20920getMaxHeightimpl(j)));
        return MeasureScope.layout$default(measureScope, placeableMo19855measureBRTryo0.getWidth(), placeableMo19855measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.UnspecifiedConstraintsNode$measure$1
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
        return RangesKt.coerceAtLeast(intrinsicMeasurable.minIntrinsicHeight(i), !C2256Dp.m20973equalsimpl0(this.minHeight, C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo15540roundToPx0680j_4(this.minHeight) : 0);
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return RangesKt.coerceAtLeast(intrinsicMeasurable.minIntrinsicWidth(i), !C2256Dp.m20973equalsimpl0(this.minWidth, C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo15540roundToPx0680j_4(this.minWidth) : 0);
    }

    /* JADX INFO: renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m15920setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    /* JADX INFO: renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m15921setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    public /* synthetic */ UnspecifiedConstraintsNode(float f, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM() : f4, null);
    }

    private UnspecifiedConstraintsNode(float f, float f4) {
        this.minWidth = f;
        this.minHeight = f4;
    }
}
