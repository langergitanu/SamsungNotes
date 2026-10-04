package androidx.compose.animation;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.GraphicsLayerScope;
import androidx.compose.p109ui.graphics.TransformOriginKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.layout.ScaleFactor;
import androidx.compose.p109ui.layout.ScaleFactorKt;
import androidx.compose.p109ui.node.LayoutModifierNode;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ&\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b \u0010!R7\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0005\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R/\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, m13886d2 = {"Landroidx/compose/animation/SkipToLookaheadNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "scaleToBounds", "Landroidx/compose/animation/ScaleToBoundsImpl;", "isEnabled", "Lkotlin/Function0;", "", "(Landroidx/compose/animation/ScaleToBoundsImpl;Lkotlin/jvm/functions/Function0;)V", "<set-?>", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "isEnabled$delegate", "Landroidx/compose/runtime/MutableState;", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "setLookaheadConstraints-_Sx5XlM", "(Landroidx/compose/ui/unit/Constraints;)V", "getScaleToBounds", "()Landroidx/compose/animation/ScaleToBoundsImpl;", "setScaleToBounds", "(Landroidx/compose/animation/ScaleToBoundsImpl;)V", "scaleToBounds$delegate", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSharedTransitionScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedTransitionScope.kt\nandroidx/compose/animation/SkipToLookaheadNode\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,1337:1\n81#2:1338\n107#2,2:1339\n81#2:1341\n107#2,2:1342\n*S KotlinDebug\n*F\n+ 1 SharedTransitionScope.kt\nandroidx/compose/animation/SkipToLookaheadNode\n*L\n1209#1:1338\n1209#1:1339,2\n1212#1:1341\n1212#1:1342,2\n*E\n"})
final class SkipToLookaheadNode extends Modifier.Node implements LayoutModifierNode {

    /* JADX INFO: renamed from: isEnabled$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState isEnabled;

    @Nullable
    private Constraints lookaheadConstraints;

    /* JADX INFO: renamed from: scaleToBounds$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState scaleToBounds;

    public SkipToLookaheadNode(@Nullable ScaleToBoundsImpl scaleToBoundsImpl, @NotNull Function0<Boolean> function0) {
        this.scaleToBounds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(scaleToBoundsImpl, null, 2, null);
        this.isEnabled = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(function0, null, 2, null);
    }

    @Nullable
    /* JADX INFO: renamed from: getLookaheadConstraints-DWUhwKw, reason: not valid java name and from getter */
    public final Constraints getLookaheadConstraints() {
        return this.lookaheadConstraints;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final ScaleToBoundsImpl getScaleToBounds() {
        return (ScaleToBoundsImpl) this.scaleToBounds.getValue();
    }

    @NotNull
    public final Function0<Boolean> isEnabled() {
        return (Function0) this.isEnabled.getValue();
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo15266measure3p2s80s(@NotNull final MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        if (measureScope.isLookingAhead()) {
            this.lookaheadConstraints = Constraints.m20909boximpl(j);
        }
        Constraints constraints = this.lookaheadConstraints;
        Intrinsics.checkNotNull(constraints);
        final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(constraints.getValue());
        final long jIntSize = IntSizeKt.IntSize(placeableMo19855measureBRTryo0.getWidth(), placeableMo19855measureBRTryo0.getHeight());
        final long jM20935constrain4WqzIAM = ConstraintsKt.m20935constrain4WqzIAM(j, jIntSize);
        return MeasureScope.layout$default(measureScope, IntSize.m21138getWidthimpl(jM20935constrain4WqzIAM), IntSize.m21137getHeightimpl(jM20935constrain4WqzIAM), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SkipToLookaheadNode$measure$1
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
                ScaleToBoundsImpl scaleToBounds = this.this$0.getScaleToBounds();
                if (!this.this$0.isEnabled().invoke().booleanValue() || scaleToBounds == null) {
                    Placeable.PlacementScope.place$default(placementScope, placeableMo19855measureBRTryo0, 0, 0, 0.0f, 4, null);
                    return;
                }
                final long jScaleFactor = (IntSize.m21138getWidthimpl(jIntSize) == 0 || IntSize.m21137getHeightimpl(jIntSize) == 0) ? ScaleFactorKt.ScaleFactor(1.0f, 1.0f) : scaleToBounds.getContentScale().mo19846computeScaleFactorH7hwNQA(IntSizeKt.m21150toSizeozmzZPI(jIntSize), IntSizeKt.m21150toSizeozmzZPI(jM20935constrain4WqzIAM));
                long jMo18130alignKFBX0sM = scaleToBounds.getAlignment().mo18130alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(ScaleFactor.m19944getScaleXimpl(jScaleFactor) * IntSize.m21138getWidthimpl(jIntSize)), MathKt.roundToInt(ScaleFactor.m19945getScaleYimpl(jScaleFactor) * IntSize.m21137getHeightimpl(jIntSize))), jM20935constrain4WqzIAM, measureScope.getLayoutDirection());
                Placeable.PlacementScope.placeWithLayer$default(placementScope, placeableMo19855measureBRTryo0, IntOffset.m21096getXimpl(jMo18130alignKFBX0sM), IntOffset.m21097getYimpl(jMo18130alignKFBX0sM), 0.0f, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.SkipToLookaheadNode$measure$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull GraphicsLayerScope graphicsLayerScope) {
                        graphicsLayerScope.setScaleX(ScaleFactor.m19944getScaleXimpl(jScaleFactor));
                        graphicsLayerScope.setScaleY(ScaleFactor.m19945getScaleYimpl(jScaleFactor));
                        graphicsLayerScope.mo18718setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.0f, 0.0f));
                    }
                }, 4, (Object) null);
            }
        }, 4, null);
    }

    public final void setEnabled(@NotNull Function0<Boolean> function0) {
        this.isEnabled.setValue(function0);
    }

    /* JADX INFO: renamed from: setLookaheadConstraints-_Sx5XlM, reason: not valid java name */
    public final void m15299setLookaheadConstraints_Sx5XlM(@Nullable Constraints constraints) {
        this.lookaheadConstraints = constraints;
    }

    public final void setScaleToBounds(@Nullable ScaleToBoundsImpl scaleToBoundsImpl) {
        this.scaleToBounds.setValue(scaleToBoundsImpl);
    }
}
