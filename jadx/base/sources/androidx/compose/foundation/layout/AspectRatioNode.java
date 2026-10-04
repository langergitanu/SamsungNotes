package androidx.compose.foundation.layout;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.IntrinsicMeasurable;
import androidx.compose.p109ui.layout.IntrinsicMeasureScope;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.LayoutModifierNode;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J&\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001c\u0010$\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010%\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J \u0010&\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)J \u0010*\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010)J \u0010,\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010)J \u0010.\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u0010)R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, m13886d2 = {"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "(FZ)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAspectRatio.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AspectRatio.kt\nandroidx/compose/foundation/layout/AspectRatioNode\n+ 2 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,236:1\n26#2:237\n26#2:238\n26#2:239\n26#2:240\n26#2:242\n26#2:243\n26#2:244\n26#2:245\n1#3:241\n*S KotlinDebug\n*F\n+ 1 AspectRatio.kt\nandroidx/compose/foundation/layout/AspectRatioNode\n*L\n129#1:237\n138#1:238\n147#1:239\n156#1:240\n187#1:242\n201#1:243\n214#1:244\n226#1:245\n*E\n"})
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public AspectRatioNode(float f, boolean z) {
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
    }

    /* JADX INFO: renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m15751findSizeToXhtMw(long j) {
        if (this.matchHeightConstraintsFirst) {
            long jM15753tryMaxHeightJN0ABg$default = m15753tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            IntSize.Companion companion = IntSize.INSTANCE;
            if (!IntSize.m21136equalsimpl0(jM15753tryMaxHeightJN0ABg$default, companion.m21143getZeroYbymL2g())) {
                return jM15753tryMaxHeightJN0ABg$default;
            }
            long jM15755tryMaxWidthJN0ABg$default = m15755tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m21136equalsimpl0(jM15755tryMaxWidthJN0ABg$default, companion.m21143getZeroYbymL2g())) {
                return jM15755tryMaxWidthJN0ABg$default;
            }
            long jM15757tryMinHeightJN0ABg$default = m15757tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m21136equalsimpl0(jM15757tryMinHeightJN0ABg$default, companion.m21143getZeroYbymL2g())) {
                return jM15757tryMinHeightJN0ABg$default;
            }
            long jM15759tryMinWidthJN0ABg$default = m15759tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m21136equalsimpl0(jM15759tryMinWidthJN0ABg$default, companion.m21143getZeroYbymL2g())) {
                return jM15759tryMinWidthJN0ABg$default;
            }
            long jM15752tryMaxHeightJN0ABg = m15752tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m21136equalsimpl0(jM15752tryMaxHeightJN0ABg, companion.m21143getZeroYbymL2g())) {
                return jM15752tryMaxHeightJN0ABg;
            }
            long jM15754tryMaxWidthJN0ABg = m15754tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m21136equalsimpl0(jM15754tryMaxWidthJN0ABg, companion.m21143getZeroYbymL2g())) {
                return jM15754tryMaxWidthJN0ABg;
            }
            long jM15756tryMinHeightJN0ABg = m15756tryMinHeightJN0ABg(j, false);
            if (!IntSize.m21136equalsimpl0(jM15756tryMinHeightJN0ABg, companion.m21143getZeroYbymL2g())) {
                return jM15756tryMinHeightJN0ABg;
            }
            long jM15758tryMinWidthJN0ABg = m15758tryMinWidthJN0ABg(j, false);
            if (!IntSize.m21136equalsimpl0(jM15758tryMinWidthJN0ABg, companion.m21143getZeroYbymL2g())) {
                return jM15758tryMinWidthJN0ABg;
            }
        } else {
            long jM15755tryMaxWidthJN0ABg$default2 = m15755tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            IntSize.Companion companion2 = IntSize.INSTANCE;
            if (!IntSize.m21136equalsimpl0(jM15755tryMaxWidthJN0ABg$default2, companion2.m21143getZeroYbymL2g())) {
                return jM15755tryMaxWidthJN0ABg$default2;
            }
            long jM15753tryMaxHeightJN0ABg$default2 = m15753tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m21136equalsimpl0(jM15753tryMaxHeightJN0ABg$default2, companion2.m21143getZeroYbymL2g())) {
                return jM15753tryMaxHeightJN0ABg$default2;
            }
            long jM15759tryMinWidthJN0ABg$default2 = m15759tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m21136equalsimpl0(jM15759tryMinWidthJN0ABg$default2, companion2.m21143getZeroYbymL2g())) {
                return jM15759tryMinWidthJN0ABg$default2;
            }
            long jM15757tryMinHeightJN0ABg$default2 = m15757tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m21136equalsimpl0(jM15757tryMinHeightJN0ABg$default2, companion2.m21143getZeroYbymL2g())) {
                return jM15757tryMinHeightJN0ABg$default2;
            }
            long jM15754tryMaxWidthJN0ABg2 = m15754tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m21136equalsimpl0(jM15754tryMaxWidthJN0ABg2, companion2.m21143getZeroYbymL2g())) {
                return jM15754tryMaxWidthJN0ABg2;
            }
            long jM15752tryMaxHeightJN0ABg2 = m15752tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m21136equalsimpl0(jM15752tryMaxHeightJN0ABg2, companion2.m21143getZeroYbymL2g())) {
                return jM15752tryMaxHeightJN0ABg2;
            }
            long jM15758tryMinWidthJN0ABg2 = m15758tryMinWidthJN0ABg(j, false);
            if (!IntSize.m21136equalsimpl0(jM15758tryMinWidthJN0ABg2, companion2.m21143getZeroYbymL2g())) {
                return jM15758tryMinWidthJN0ABg2;
            }
            long jM15756tryMinHeightJN0ABg2 = m15756tryMinHeightJN0ABg(j, false);
            if (!IntSize.m21136equalsimpl0(jM15756tryMinHeightJN0ABg2, companion2.m21143getZeroYbymL2g())) {
                return jM15756tryMinHeightJN0ABg2;
            }
        }
        return IntSize.INSTANCE.m21143getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m15752tryMaxHeightJN0ABg(long j, boolean z) {
        int iRound;
        int iM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(j);
        if (iM20920getMaxHeightimpl != Integer.MAX_VALUE && (iRound = Math.round(iM20920getMaxHeightimpl * this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iRound, iM20920getMaxHeightimpl);
            if (!z || ConstraintsKt.m20939isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m21143getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg$default, reason: not valid java name */
    public static /* synthetic */ long m15753tryMaxHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m15752tryMaxHeightJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m15754tryMaxWidthJN0ABg(long j, boolean z) {
        int iRound;
        int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j);
        if (iM20921getMaxWidthimpl != Integer.MAX_VALUE && (iRound = Math.round(iM20921getMaxWidthimpl / this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iM20921getMaxWidthimpl, iRound);
            if (!z || ConstraintsKt.m20939isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m21143getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg$default, reason: not valid java name */
    public static /* synthetic */ long m15755tryMaxWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m15754tryMaxWidthJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m15756tryMinHeightJN0ABg(long j, boolean z) {
        int iM20922getMinHeightimpl = Constraints.m20922getMinHeightimpl(j);
        int iRound = Math.round(iM20922getMinHeightimpl * this.aspectRatio);
        if (iRound > 0) {
            long jIntSize = IntSizeKt.IntSize(iRound, iM20922getMinHeightimpl);
            if (!z || ConstraintsKt.m20939isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m21143getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg$default, reason: not valid java name */
    public static /* synthetic */ long m15757tryMinHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m15756tryMinHeightJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m15758tryMinWidthJN0ABg(long j, boolean z) {
        int iM20923getMinWidthimpl = Constraints.m20923getMinWidthimpl(j);
        int iRound = Math.round(iM20923getMinWidthimpl / this.aspectRatio);
        if (iRound > 0) {
            long jIntSize = IntSizeKt.IntSize(iM20923getMinWidthimpl, iRound);
            if (!z || ConstraintsKt.m20939isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m21143getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg$default, reason: not valid java name */
    public static /* synthetic */ long m15759tryMinWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m15758tryMinWidthJN0ABg(j, z);
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i / this.aspectRatio) : intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i * this.aspectRatio) : intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo15266measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        long jM15751findSizeToXhtMw = m15751findSizeToXhtMw(j);
        if (!IntSize.m21136equalsimpl0(jM15751findSizeToXhtMw, IntSize.INSTANCE.m21143getZeroYbymL2g())) {
            j = Constraints.INSTANCE.m20931fixedJhjzzOo(IntSize.m21138getWidthimpl(jM15751findSizeToXhtMw), IntSize.m21137getHeightimpl(jM15751findSizeToXhtMw));
        }
        final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo19855measureBRTryo0.getWidth(), placeableMo19855measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AspectRatioNode$measure$1
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
        return i != Integer.MAX_VALUE ? Math.round(i / this.aspectRatio) : intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i * this.aspectRatio) : intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    public final void setMatchHeightConstraintsFirst(boolean z) {
        this.matchHeightConstraintsFirst = z;
    }
}
