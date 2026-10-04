package androidx.compose.foundation.layout;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.LayoutModifierNode;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J&\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/foundation/layout/PaddingValuesModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "getPaddingValues", "()Landroidx/compose/foundation/layout/PaddingValues;", "setPaddingValues", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPadding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Padding.kt\nandroidx/compose/foundation/layout/PaddingValuesModifier\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,484:1\n149#2:485\n149#2:486\n149#2:487\n149#2:488\n*S KotlinDebug\n*F\n+ 1 Padding.kt\nandroidx/compose/foundation/layout/PaddingValuesModifier\n*L\n460#1:485\n461#1:486\n462#1:487\n463#1:488\n*E\n"})
final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {

    @NotNull
    private PaddingValues paddingValues;

    public PaddingValuesModifier(@NotNull PaddingValues paddingValues) {
        this.paddingValues = paddingValues;
    }

    @NotNull
    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo15266measure3p2s80s(@NotNull final MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        float f = 0;
        if (C2256Dp.m20967compareTo0680j_4(this.paddingValues.mo15805calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection()), C2256Dp.m20968constructorimpl(f)) < 0 || C2256Dp.m20967compareTo0680j_4(this.paddingValues.getTop(), C2256Dp.m20968constructorimpl(f)) < 0 || C2256Dp.m20967compareTo0680j_4(this.paddingValues.mo15806calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()), C2256Dp.m20968constructorimpl(f)) < 0 || C2256Dp.m20967compareTo0680j_4(this.paddingValues.getBottom(), C2256Dp.m20968constructorimpl(f)) < 0) {
            throw new IllegalArgumentException("Padding must be non-negative");
        }
        int iMo15540roundToPx0680j_4 = measureScope.mo15540roundToPx0680j_4(this.paddingValues.mo15806calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection())) + measureScope.mo15540roundToPx0680j_4(this.paddingValues.mo15805calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection()));
        int iMo15540roundToPx0680j_42 = measureScope.mo15540roundToPx0680j_4(this.paddingValues.getBottom()) + measureScope.mo15540roundToPx0680j_4(this.paddingValues.getTop());
        final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(ConstraintsKt.m20940offsetNN6EwU(j, -iMo15540roundToPx0680j_4, -iMo15540roundToPx0680j_42));
        return MeasureScope.layout$default(measureScope, ConstraintsKt.m20938constrainWidthK40F9xA(j, placeableMo19855measureBRTryo0.getWidth() + iMo15540roundToPx0680j_4), ConstraintsKt.m20937constrainHeightK40F9xA(j, placeableMo19855measureBRTryo0.getHeight() + iMo15540roundToPx0680j_42), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.PaddingValuesModifier$measure$2
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
                Placeable.PlacementScope.place$default(placementScope, placeableMo19855measureBRTryo0, measureScope.mo15540roundToPx0680j_4(this.getPaddingValues().mo15805calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())), measureScope.mo15540roundToPx0680j_4(this.getPaddingValues().getTop()), 0.0f, 4, null);
            }
        }, 4, null);
    }

    public final void setPaddingValues(@NotNull PaddingValues paddingValues) {
        this.paddingValues = paddingValues;
    }
}
