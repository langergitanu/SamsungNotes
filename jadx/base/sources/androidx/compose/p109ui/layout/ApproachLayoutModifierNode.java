package androidx.compose.p109ui.layout;

import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.LayoutModifierNode;
import androidx.compose.p109ui.node.NodeMeasuringIntrinsics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u0003*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u001c\u0010\u001a\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0016H\u0016J&\u0010\u001c\u001a\u00020\t*\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001c\u0010 \u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u001c\u0010!\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0016H\u0016ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\"À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "isMeasurementApproachInProgress", "", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "approachMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "isPlacementApproachInProgress", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "lookaheadCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "maxApproachIntrinsicHeight", "", "Landroidx/compose/ui/layout/ApproachIntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxApproachIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureScope;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minApproachIntrinsicHeight", "minApproachIntrinsicWidth", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface ApproachLayoutModifierNode extends LayoutModifierNode {
    @NotNull
    /* JADX INFO: renamed from: approachMeasure-3p2s80s */
    MeasureResult mo15278approachMeasure3p2s80s(@NotNull ApproachMeasureScope approachMeasureScope, @NotNull Measurable measurable, long j);

    /* JADX INFO: renamed from: isMeasurementApproachInProgress-ozmzZPI */
    boolean mo15279isMeasurementApproachInProgressozmzZPI(long lookaheadSize);

    default boolean isPlacementApproachInProgress(@NotNull Placeable.PlacementScope placementScope, @NotNull LayoutCoordinates layoutCoordinates) {
        return false;
    }

    default int maxApproachIntrinsicHeight(@NotNull ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release(new NodeMeasuringIntrinsics.ApproachMeasureBlock() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode.maxApproachIntrinsicHeight.1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.ApproachMeasureBlock
            @NotNull
            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
            public final MeasureResult mo19831measure3p2s80s(@NotNull ApproachMeasureScope approachMeasureScope, @NotNull Measurable measurable, long j) {
                return ApproachLayoutModifierNode.this.mo15278approachMeasure3p2s80s(approachMeasureScope, measurable, j);
            }
        }, approachIntrinsicMeasureScope, intrinsicMeasurable, i);
    }

    default int maxApproachIntrinsicWidth(@NotNull ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release(new NodeMeasuringIntrinsics.ApproachMeasureBlock() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode.maxApproachIntrinsicWidth.1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.ApproachMeasureBlock
            @NotNull
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo19831measure3p2s80s(@NotNull ApproachMeasureScope approachMeasureScope, @NotNull Measurable measurable, long j) {
                return ApproachLayoutModifierNode.this.mo15278approachMeasure3p2s80s(approachMeasureScope, measurable, j);
            }
        }, approachIntrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    default MeasureResult mo15266measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo19855measureBRTryo0.getWidth(), placeableMo19855measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode$measure$1$1
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
                Placeable.PlacementScope.place$default(placementScope, placeableMo19855measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    default int minApproachIntrinsicHeight(@NotNull ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release(new NodeMeasuringIntrinsics.ApproachMeasureBlock() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode.minApproachIntrinsicHeight.1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.ApproachMeasureBlock
            @NotNull
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo19831measure3p2s80s(@NotNull ApproachMeasureScope approachMeasureScope, @NotNull Measurable measurable, long j) {
                return ApproachLayoutModifierNode.this.mo15278approachMeasure3p2s80s(approachMeasureScope, measurable, j);
            }
        }, approachIntrinsicMeasureScope, intrinsicMeasurable, i);
    }

    default int minApproachIntrinsicWidth(@NotNull ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release(new NodeMeasuringIntrinsics.ApproachMeasureBlock() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode.minApproachIntrinsicWidth.1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.ApproachMeasureBlock
            @NotNull
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo19831measure3p2s80s(@NotNull ApproachMeasureScope approachMeasureScope, @NotNull Measurable measurable, long j) {
                return ApproachLayoutModifierNode.this.mo15278approachMeasure3p2s80s(approachMeasureScope, measurable, j);
            }
        }, approachIntrinsicMeasureScope, intrinsicMeasurable, i);
    }
}
