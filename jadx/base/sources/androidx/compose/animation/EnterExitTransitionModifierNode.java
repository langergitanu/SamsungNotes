package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.graphics.GraphicsLayerScope;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\b\u0010J\u001a\u00020KH\u0016J \u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ \u0010Q\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bR\u0010PJ \u0010S\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bT\u0010PJ&\u0010U\u001a\u00020V*\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020.H\u0016ø\u0001\u0000¢\u0006\u0004\b[\u0010\\R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0019\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010*\"\u0004\b+\u0010,R&\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020.@BX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\"\u0004\b0\u00101R\u000e\u00103\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\u00020\u0007X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00102R2\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R2\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00106\"\u0004\b:\u00108R.\u0010;\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040=\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070>0<¢\u0006\u0002\b?¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR2\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00106\"\u0004\bC\u00108R.\u0010D\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040=\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0>0<¢\u0006\u0002\b?¢\u0006\b\n\u0000\u001a\u0004\bE\u0010AR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006]"}, m13886d2 = {"Landroidx/compose/animation/EnterExitTransitionModifierNode;", "Landroidx/compose/animation/LayoutModifierNodeWithPassThroughIntrinsics;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "offsetAnimation", "Landroidx/compose/ui/unit/IntOffset;", "slideAnimation", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "isEnabled", "Lkotlin/Function0;", "", "graphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "alignment", "Landroidx/compose/ui/Alignment;", "getAlignment", "()Landroidx/compose/ui/Alignment;", "currentAlignment", "getCurrentAlignment", "setCurrentAlignment", "(Landroidx/compose/ui/Alignment;)V", "getEnter", "()Landroidx/compose/animation/EnterTransition;", "setEnter", "(Landroidx/compose/animation/EnterTransition;)V", "getExit", "()Landroidx/compose/animation/ExitTransition;", "setExit", "(Landroidx/compose/animation/ExitTransition;)V", "getGraphicsLayerBlock", "()Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "setGraphicsLayerBlock", "(Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "value", "Landroidx/compose/ui/unit/Constraints;", "lookaheadConstraints", "setLookaheadConstraints-BRTryo0", "(J)V", "J", "lookaheadConstraintsAvailable", "lookaheadSize", "getOffsetAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setOffsetAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "getSizeAnimation", "setSizeAnimation", "sizeTransitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "getSizeTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "getSlideAnimation", "setSlideAnimation", "slideSpec", "getSlideSpec", "getTransition", "()Landroidx/compose/animation/core/Transition;", "setTransition", "(Landroidx/compose/animation/core/Transition;)V", "onAttach", "", "sizeByState", "targetState", "fullSize", "sizeByState-Uzc_VyU", "(Landroidx/compose/animation/EnterExitState;J)J", "slideTargetValueByState", "slideTargetValueByState-oFUgxo0", "targetOffsetByState", "targetOffsetByState-oFUgxo0", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class EnterExitTransitionModifierNode extends LayoutModifierNodeWithPassThroughIntrinsics {

    @Nullable
    private Alignment currentAlignment;

    @NotNull
    private EnterTransition enter;

    @NotNull
    private ExitTransition exit;

    @NotNull
    private GraphicsLayerBlockForEnterExit graphicsLayerBlock;

    @NotNull
    private Function0<Boolean> isEnabled;
    private boolean lookaheadConstraintsAvailable;

    @Nullable
    private Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation;

    @Nullable
    private Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;

    @Nullable
    private Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> slideAnimation;

    @NotNull
    private Transition<EnterExitState> transition;
    private long lookaheadSize = AnimationModifierKt.getInvalidSize();
    private long lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);

    @NotNull
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> sizeTransitionSpec = new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$sizeTransitionSpec$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final FiniteAnimationSpec<IntSize> invoke(@NotNull Transition.Segment<EnterExitState> segment) {
            EnterExitState enterExitState = EnterExitState.PreEnter;
            EnterExitState enterExitState2 = EnterExitState.Visible;
            FiniteAnimationSpec<IntSize> animationSpec = null;
            if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
                ChangeSize changeSize = this.this$0.getEnter().getData().getChangeSize();
                if (changeSize != null) {
                    animationSpec = changeSize.getAnimationSpec();
                }
            } else if (segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                ChangeSize changeSize2 = this.this$0.getExit().getData().getChangeSize();
                if (changeSize2 != null) {
                    animationSpec = changeSize2.getAnimationSpec();
                }
            } else {
                animationSpec = EnterExitTransitionKt.DefaultSizeAnimationSpec;
            }
            return animationSpec == null ? EnterExitTransitionKt.DefaultSizeAnimationSpec : animationSpec;
        }
    };

    @NotNull
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> slideSpec = new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$slideSpec$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final FiniteAnimationSpec<IntOffset> invoke(@NotNull Transition.Segment<EnterExitState> segment) {
            FiniteAnimationSpec<IntOffset> animationSpec;
            FiniteAnimationSpec<IntOffset> animationSpec2;
            EnterExitState enterExitState = EnterExitState.PreEnter;
            EnterExitState enterExitState2 = EnterExitState.Visible;
            if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
                Slide slide = this.this$0.getEnter().getData().getSlide();
                return (slide == null || (animationSpec2 = slide.getAnimationSpec()) == null) ? EnterExitTransitionKt.DefaultOffsetAnimationSpec : animationSpec2;
            }
            if (!segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
            }
            Slide slide2 = this.this$0.getExit().getData().getSlide();
            return (slide2 == null || (animationSpec = slide2.getAnimationSpec()) == null) ? EnterExitTransitionKt.DefaultOffsetAnimationSpec : animationSpec;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            try {
                iArr[EnterExitState.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnterExitState.PreEnter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnterExitState.PostExit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public EnterExitTransitionModifierNode(@NotNull Transition<EnterExitState> transition, @Nullable Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation, @Nullable Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation2, @Nullable Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation3, @NotNull EnterTransition enterTransition, @NotNull ExitTransition exitTransition, @NotNull Function0<Boolean> function0, @NotNull GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit) {
        this.transition = transition;
        this.sizeAnimation = deferredAnimation;
        this.offsetAnimation = deferredAnimation2;
        this.slideAnimation = deferredAnimation3;
        this.enter = enterTransition;
        this.exit = exitTransition;
        this.isEnabled = function0;
        this.graphicsLayerBlock = graphicsLayerBlockForEnterExit;
    }

    /* JADX INFO: renamed from: setLookaheadConstraints-BRTryo0, reason: not valid java name */
    private final void m15265setLookaheadConstraintsBRTryo0(long j) {
        this.lookaheadConstraintsAvailable = true;
        this.lookaheadConstraints = j;
    }

    @Nullable
    public final Alignment getAlignment() {
        Alignment alignment;
        Alignment alignment2;
        if (this.transition.getSegment().isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
            ChangeSize changeSize = this.enter.getData().getChangeSize();
            if (changeSize != null && (alignment2 = changeSize.getAlignment()) != null) {
                return alignment2;
            }
            ChangeSize changeSize2 = this.exit.getData().getChangeSize();
            if (changeSize2 != null) {
                return changeSize2.getAlignment();
            }
            return null;
        }
        ChangeSize changeSize3 = this.exit.getData().getChangeSize();
        if (changeSize3 != null && (alignment = changeSize3.getAlignment()) != null) {
            return alignment;
        }
        ChangeSize changeSize4 = this.enter.getData().getChangeSize();
        if (changeSize4 != null) {
            return changeSize4.getAlignment();
        }
        return null;
    }

    @Nullable
    public final Alignment getCurrentAlignment() {
        return this.currentAlignment;
    }

    @NotNull
    public final EnterTransition getEnter() {
        return this.enter;
    }

    @NotNull
    public final ExitTransition getExit() {
        return this.exit;
    }

    @NotNull
    public final GraphicsLayerBlockForEnterExit getGraphicsLayerBlock() {
        return this.graphicsLayerBlock;
    }

    @Nullable
    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getOffsetAnimation() {
        return this.offsetAnimation;
    }

    @Nullable
    public final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
        return this.sizeAnimation;
    }

    @NotNull
    public final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> getSizeTransitionSpec() {
        return this.sizeTransitionSpec;
    }

    @Nullable
    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getSlideAnimation() {
        return this.slideAnimation;
    }

    @NotNull
    public final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> getSlideSpec() {
        return this.slideSpec;
    }

    @NotNull
    public final Transition<EnterExitState> getTransition() {
        return this.transition;
    }

    @NotNull
    public final Function0<Boolean> isEnabled() {
        return this.isEnabled;
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult mo15266measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        State<IntOffset> stateAnimate;
        State<IntOffset> stateAnimate2;
        if (this.transition.getCurrentState() == this.transition.getTargetState()) {
            this.currentAlignment = null;
        } else if (this.currentAlignment == null) {
            Alignment alignment = getAlignment();
            if (alignment == null) {
                alignment = Alignment.INSTANCE.getTopStart();
            }
            this.currentAlignment = alignment;
        }
        if (measureScope.isLookingAhead()) {
            final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(j);
            long jIntSize = IntSizeKt.IntSize(placeableMo19855measureBRTryo0.getWidth(), placeableMo19855measureBRTryo0.getHeight());
            this.lookaheadSize = jIntSize;
            m15265setLookaheadConstraintsBRTryo0(j);
            return MeasureScope.layout$default(measureScope, IntSize.m21138getWidthimpl(jIntSize), IntSize.m21137getHeightimpl(jIntSize), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$1
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
        if (!this.isEnabled.invoke().booleanValue()) {
            final Placeable placeableMo19855measureBRTryo02 = measurable.mo19855measureBRTryo0(j);
            return MeasureScope.layout$default(measureScope, placeableMo19855measureBRTryo02.getWidth(), placeableMo19855measureBRTryo02.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$3$1
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
                    Placeable.PlacementScope.place$default(placementScope, placeableMo19855measureBRTryo02, 0, 0, 0.0f, 4, null);
                }
            }, 4, null);
        }
        final Function1<GraphicsLayerScope, Unit> function1Init = this.graphicsLayerBlock.init();
        final Placeable placeableMo19855measureBRTryo03 = measurable.mo19855measureBRTryo0(j);
        long jIntSize2 = IntSizeKt.IntSize(placeableMo19855measureBRTryo03.getWidth(), placeableMo19855measureBRTryo03.getHeight());
        final long j2 = AnimationModifierKt.m15244isValidozmzZPI(this.lookaheadSize) ? this.lookaheadSize : jIntSize2;
        Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation = this.sizeAnimation;
        State<IntSize> stateAnimate3 = deferredAnimation != null ? deferredAnimation.animate(this.sizeTransitionSpec, new Function1<EnterExitState, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$animSize$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(EnterExitState enterExitState) {
                return IntSize.m21130boximpl(m15270invokeYEO4UFw(enterExitState));
            }

            /* JADX INFO: renamed from: invoke-YEO4UFw, reason: not valid java name */
            public final long m15270invokeYEO4UFw(@NotNull EnterExitState enterExitState) {
                return this.this$0.m15267sizeByStateUzc_VyU(enterExitState, j2);
            }
        }) : null;
        if (stateAnimate3 != null) {
            jIntSize2 = stateAnimate3.getValue().getPackedValue();
        }
        long jM20935constrain4WqzIAM = ConstraintsKt.m20935constrain4WqzIAM(j, jIntSize2);
        Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation2 = this.offsetAnimation;
        final long jM21106getZeronOccac = (deferredAnimation2 == null || (stateAnimate2 = deferredAnimation2.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$offsetDelta$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final FiniteAnimationSpec<IntOffset> invoke(@NotNull Transition.Segment<EnterExitState> segment) {
                return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
            }
        }, new Function1<EnterExitState, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$offsetDelta$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(EnterExitState enterExitState) {
                return IntOffset.m21087boximpl(m15271invokeBjo55l4(enterExitState));
            }

            /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
            public final long m15271invokeBjo55l4(@NotNull EnterExitState enterExitState) {
                return this.this$0.m15269targetOffsetByStateoFUgxo0(enterExitState, j2);
            }
        })) == null) ? IntOffset.INSTANCE.m21106getZeronOccac() : stateAnimate2.getValue().getPackedValue();
        Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation3 = this.slideAnimation;
        long jM21106getZeronOccac2 = (deferredAnimation3 == null || (stateAnimate = deferredAnimation3.animate(this.slideSpec, new Function1<EnterExitState, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$slideOffset$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(EnterExitState enterExitState) {
                return IntOffset.m21087boximpl(m15272invokeBjo55l4(enterExitState));
            }

            /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
            public final long m15272invokeBjo55l4(@NotNull EnterExitState enterExitState) {
                return this.this$0.m15268slideTargetValueByStateoFUgxo0(enterExitState, j2);
            }
        })) == null) ? IntOffset.INSTANCE.m21106getZeronOccac() : stateAnimate.getValue().getPackedValue();
        Alignment alignment2 = this.currentAlignment;
        final long jM21100plusqkQi6aY = IntOffset.m21100plusqkQi6aY(alignment2 != null ? alignment2.mo18130alignKFBX0sM(j2, jM20935constrain4WqzIAM, LayoutDirection.Ltr) : IntOffset.INSTANCE.m21106getZeronOccac(), jM21106getZeronOccac2);
        return MeasureScope.layout$default(measureScope, IntSize.m21138getWidthimpl(jM20935constrain4WqzIAM), IntSize.m21137getHeightimpl(jM20935constrain4WqzIAM), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                placementScope.placeWithLayer(placeableMo19855measureBRTryo03, IntOffset.m21096getXimpl(jM21106getZeronOccac) + IntOffset.m21096getXimpl(jM21100plusqkQi6aY), IntOffset.m21097getYimpl(jM21106getZeronOccac) + IntOffset.m21097getYimpl(jM21100plusqkQi6aY), 0.0f, function1Init);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        this.lookaheadConstraintsAvailable = false;
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
    }

    public final void setCurrentAlignment(@Nullable Alignment alignment) {
        this.currentAlignment = alignment;
    }

    public final void setEnabled(@NotNull Function0<Boolean> function0) {
        this.isEnabled = function0;
    }

    public final void setEnter(@NotNull EnterTransition enterTransition) {
        this.enter = enterTransition;
    }

    public final void setExit(@NotNull ExitTransition exitTransition) {
        this.exit = exitTransition;
    }

    public final void setGraphicsLayerBlock(@NotNull GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit) {
        this.graphicsLayerBlock = graphicsLayerBlockForEnterExit;
    }

    public final void setOffsetAnimation(@Nullable Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation) {
        this.offsetAnimation = deferredAnimation;
    }

    public final void setSizeAnimation(@Nullable Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation) {
        this.sizeAnimation = deferredAnimation;
    }

    public final void setSlideAnimation(@Nullable Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation) {
        this.slideAnimation = deferredAnimation;
    }

    public final void setTransition(@NotNull Transition<EnterExitState> transition) {
        this.transition = transition;
    }

    /* JADX INFO: renamed from: sizeByState-Uzc_VyU, reason: not valid java name */
    public final long m15267sizeByStateUzc_VyU(@NotNull EnterExitState targetState, long fullSize) {
        Function1<IntSize, IntSize> size;
        Function1<IntSize, IntSize> size2;
        int i = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
        if (i != 1) {
            if (i == 2) {
                ChangeSize changeSize = this.enter.getData().getChangeSize();
                if (changeSize != null && (size = changeSize.getSize()) != null) {
                    return size.invoke(IntSize.m21130boximpl(fullSize)).getPackedValue();
                }
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                ChangeSize changeSize2 = this.exit.getData().getChangeSize();
                if (changeSize2 != null && (size2 = changeSize2.getSize()) != null) {
                    return size2.invoke(IntSize.m21130boximpl(fullSize)).getPackedValue();
                }
            }
        }
        return fullSize;
    }

    /* JADX INFO: renamed from: slideTargetValueByState-oFUgxo0, reason: not valid java name */
    public final long m15268slideTargetValueByStateoFUgxo0(@NotNull EnterExitState targetState, long fullSize) {
        Function1<IntSize, IntOffset> slideOffset;
        Function1<IntSize, IntOffset> slideOffset2;
        Slide slide = this.enter.getData().getSlide();
        long jM21106getZeronOccac = (slide == null || (slideOffset2 = slide.getSlideOffset()) == null) ? IntOffset.INSTANCE.m21106getZeronOccac() : slideOffset2.invoke(IntSize.m21130boximpl(fullSize)).getPackedValue();
        Slide slide2 = this.exit.getData().getSlide();
        long jM21106getZeronOccac2 = (slide2 == null || (slideOffset = slide2.getSlideOffset()) == null) ? IntOffset.INSTANCE.m21106getZeronOccac() : slideOffset.invoke(IntSize.m21130boximpl(fullSize)).getPackedValue();
        int i = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
        if (i == 1) {
            return IntOffset.INSTANCE.m21106getZeronOccac();
        }
        if (i == 2) {
            return jM21106getZeronOccac;
        }
        if (i == 3) {
            return jM21106getZeronOccac2;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: targetOffsetByState-oFUgxo0, reason: not valid java name */
    public final long m15269targetOffsetByStateoFUgxo0(@NotNull EnterExitState targetState, long fullSize) {
        if (this.currentAlignment == null) {
            return IntOffset.INSTANCE.m21106getZeronOccac();
        }
        if (getAlignment() == null) {
            return IntOffset.INSTANCE.m21106getZeronOccac();
        }
        if (Intrinsics.areEqual(this.currentAlignment, getAlignment())) {
            return IntOffset.INSTANCE.m21106getZeronOccac();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
        if (i == 1) {
            return IntOffset.INSTANCE.m21106getZeronOccac();
        }
        if (i == 2) {
            return IntOffset.INSTANCE.m21106getZeronOccac();
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        ChangeSize changeSize = this.exit.getData().getChangeSize();
        if (changeSize == null) {
            return IntOffset.INSTANCE.m21106getZeronOccac();
        }
        long packedValue = changeSize.getSize().invoke(IntSize.m21130boximpl(fullSize)).getPackedValue();
        Alignment alignment = getAlignment();
        Intrinsics.checkNotNull(alignment);
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        long jMo18130alignKFBX0sM = alignment.mo18130alignKFBX0sM(fullSize, packedValue, layoutDirection);
        Alignment alignment2 = this.currentAlignment;
        Intrinsics.checkNotNull(alignment2);
        return IntOffset.m21099minusqkQi6aY(jMo18130alignKFBX0sM, alignment2.mo18130alignKFBX0sM(fullSize, packedValue, layoutDirection));
    }
}
