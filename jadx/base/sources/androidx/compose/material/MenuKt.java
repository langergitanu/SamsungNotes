package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p109ui.graphics.GraphicsLayerScope;
import androidx.compose.p109ui.graphics.TransformOrigin;
import androidx.compose.p109ui.graphics.TransformOriginKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntRect;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aT\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00100\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001aa\u0010\u001f\u001a\u00020\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100!2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\"\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0001¢\u0006\u0002\u0010(\u001a \u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0000ø\u0001\u0000¢\u0006\u0002\u0010-\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0006\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\t\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000\"\u0013\u0010\u000b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\f\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\r\u0010\b\"\u000e\u0010\u000e\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, m13886d2 = {"DropdownMenuItemDefaultMaxWidth", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "DropdownMenuItemDefaultMinHeight", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "()F", "InTransitionDuration", "", "MenuElevation", "MenuVerticalMargin", "getMenuVerticalMargin", "OutTransitionDuration", "DropdownMenuContent", "", "expandedStates", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItemContent", "onClick", "Lkotlin/Function0;", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateTransformOrigin", "parentBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class MenuKt {
    private static final float DropdownMenuItemDefaultMinHeight;
    private static final float DropdownMenuVerticalPadding;
    public static final int InTransitionDuration = 120;
    private static final float MenuElevation;
    private static final float MenuVerticalMargin;
    public static final int OutTransitionDuration = 75;
    private static final float DropdownMenuItemHorizontalPadding = C2256Dp.m20968constructorimpl(16);
    private static final float DropdownMenuItemDefaultMinWidth = C2256Dp.m20968constructorimpl(112);
    private static final float DropdownMenuItemDefaultMaxWidth = C2256Dp.m20968constructorimpl(280);

    static {
        float f = 8;
        MenuElevation = C2256Dp.m20968constructorimpl(f);
        float f4 = 48;
        MenuVerticalMargin = C2256Dp.m20968constructorimpl(f4);
        DropdownMenuVerticalPadding = C2256Dp.m20968constructorimpl(f);
        DropdownMenuItemDefaultMinHeight = C2256Dp.m20968constructorimpl(f4);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0241 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0237  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DropdownMenuContent(@NotNull final MutableTransitionState<Boolean> expandedStates, @NotNull final MutableState<TransformOrigin> transformOriginState, @Nullable Modifier modifier, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        final int i5;
        final State stateCreateTransitionAnimation;
        final State stateCreateTransitionAnimation2;
        boolean zChanged;
        Object objRememberedValue;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(expandedStates, "expandedStates");
        Intrinsics.checkNotNullParameter(transformOriginState, "transformOriginState");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1164283597);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(expandedStates) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(transformOriginState) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 7168) == 0) {
                i4 |= composerStartRestartGroup.changed(content) ? 2048 : 1024;
            }
            i5 = i4;
            if ((i5 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                if (i6 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1164283597, i5, -1, "androidx.compose.material.DropdownMenuContent (Menu.kt:61)");
                }
                Transition transitionUpdateTransition = TransitionKt.updateTransition((MutableTransitionState) expandedStates, "DropDownMenu", composerStartRestartGroup, MutableTransitionState.$stable | 48 | (i5 & 14), 0);
                MenuKt$DropdownMenuContent$scale$2 menuKt$DropdownMenuContent$scale$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$scale$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    @NotNull
                    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<Boolean> animateFloat, @Nullable Composer composer2, int i7) {
                        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                        composer2.startReplaceableGroup(365249092);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(365249092, i7, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:71)");
                        }
                        TweenSpec tweenSpecTween$default = animateFloat.isTransitioningTo(Boolean.FALSE, Boolean.TRUE) ? AnimationSpecKt.tween$default(120, 0, EasingKt.getLinearOutSlowInEasing(), 2, null) : AnimationSpecKt.tween$default(1, 74, null, 4, null);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceableGroup();
                        return tweenSpecTween$default;
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(1399891485);
                FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
                TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                composerStartRestartGroup.startReplaceableGroup(1847725064);
                boolean zBooleanValue = ((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue();
                composerStartRestartGroup.startReplaceableGroup(-1958825495);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1958825495, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:86)");
                }
                float f = !zBooleanValue ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf = Float.valueOf(f);
                boolean zBooleanValue2 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
                composerStartRestartGroup.startReplaceableGroup(-1958825495);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1958825495, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:86)");
                }
                float f4 = zBooleanValue2 ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf2 = Float.valueOf(f4);
                FiniteAnimationSpec<Float> finiteAnimationSpecInvoke = menuKt$DropdownMenuContent$scale$2.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0);
                final Modifier modifier4 = modifier2;
                stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, fValueOf2, finiteAnimationSpecInvoke, vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                MenuKt$DropdownMenuContent$alpha$2 menuKt$DropdownMenuContent$alpha$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$alpha$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    @NotNull
                    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<Boolean> animateFloat, @Nullable Composer composer2, int i7) {
                        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                        composer2.startReplaceableGroup(782718552);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(782718552, i7, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:97)");
                        }
                        TweenSpec tweenSpecTween$default = animateFloat.isTransitioningTo(Boolean.FALSE, Boolean.TRUE) ? AnimationSpecKt.tween$default(30, 0, null, 6, null) : AnimationSpecKt.tween$default(75, 0, null, 6, null);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceableGroup();
                        return tweenSpecTween$default;
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(1399891485);
                TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                composerStartRestartGroup.startReplaceableGroup(1847725064);
                boolean zBooleanValue3 = ((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue();
                composerStartRestartGroup.startReplaceableGroup(-1541356035);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1541356035, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:106)");
                }
                float f5 = !zBooleanValue3 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf3 = Float.valueOf(f5);
                boolean zBooleanValue4 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
                composerStartRestartGroup.startReplaceableGroup(-1541356035);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1541356035, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:106)");
                }
                float f6 = zBooleanValue4 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf3, Float.valueOf(f6), menuKt$DropdownMenuContent$alpha$2.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "FloatAnimation", composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier.Companion companion = Modifier.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(stateCreateTransitionAnimation) | composerStartRestartGroup.changed(stateCreateTransitionAnimation2) | composerStartRestartGroup.changed(transformOriginState);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$1$1
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
                        public final void invoke2(@NotNull GraphicsLayerScope graphicsLayer) {
                            Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                            graphicsLayer.setScaleX(MenuKt.m16783DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                            graphicsLayer.setScaleY(MenuKt.m16783DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                            graphicsLayer.setAlpha(MenuKt.m16784DropdownMenuContent$lambda3(stateCreateTransitionAnimation2));
                            graphicsLayer.mo18718setTransformOrigin__ExYCQ(transformOriginState.getValue().getPackedValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CardKt.m16639CardFjzlyU(GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue), null, 0L, 0L, null, MenuElevation, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -242468534, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuContent.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i7) {
                        if ((i7 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-242468534, i7, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:123)");
                        }
                        Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(IntrinsicKt.width(PaddingKt.m15856paddingVpY3zN4$default(modifier4, 0.0f, MenuKt.getDropdownMenuVerticalPadding(), 1, null), IntrinsicSize.Max), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null);
                        Function3<ColumnScope, Composer, Integer, Unit> function3 = content;
                        int i8 = i5 & 7168;
                        composer2.startReplaceableGroup(-483455358);
                        MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer2, 0, -1323940314);
                        Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierVerticalScroll$default);
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        composer2.disableReusing();
                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                        composer2.startReplaceableGroup(-1163856341);
                        function3.invoke(ColumnScopeInstance.INSTANCE, composer2, Integer.valueOf(((i8 >> 6) & 112) | 6));
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 1769472, 30);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i7) {
                    MenuKt.DropdownMenuContent(expandedStates, transformOriginState, modifier3, content, composer2, i | 1, i2);
                }
            });
            return;
        }
        i4 |= 384;
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        i5 = i4;
        if ((i5 & 5851) == 1170) {
            if (i6 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Transition transitionUpdateTransition2 = TransitionKt.updateTransition((MutableTransitionState) expandedStates, "DropDownMenu", composerStartRestartGroup, MutableTransitionState.$stable | 48 | (i5 & 14), 0);
            MenuKt$DropdownMenuContent$scale$2 menuKt$DropdownMenuContent$scale$22 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$scale$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                @NotNull
                public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<Boolean> animateFloat, @Nullable Composer composer2, int i7) {
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    composer2.startReplaceableGroup(365249092);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(365249092, i7, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:71)");
                    }
                    TweenSpec tweenSpecTween$default = animateFloat.isTransitioningTo(Boolean.FALSE, Boolean.TRUE) ? AnimationSpecKt.tween$default(120, 0, EasingKt.getLinearOutSlowInEasing(), 2, null) : AnimationSpecKt.tween$default(1, 74, null, 4, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceableGroup();
                    return tweenSpecTween$default;
                }
            };
            composerStartRestartGroup.startReplaceableGroup(1399891485);
            FloatCompanionObject floatCompanionObject2 = FloatCompanionObject.INSTANCE;
            TwoWayConverter<Float, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(floatCompanionObject2);
            composerStartRestartGroup.startReplaceableGroup(1847725064);
            boolean zBooleanValue5 = ((Boolean) transitionUpdateTransition2.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1958825495);
            if (ComposerKt.isTraceInProgress()) {
            }
            if (!zBooleanValue5) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf4 = Float.valueOf(f);
            boolean zBooleanValue22 = ((Boolean) transitionUpdateTransition2.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1958825495);
            if (ComposerKt.isTraceInProgress()) {
            }
            if (zBooleanValue22) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf22 = Float.valueOf(f4);
            FiniteAnimationSpec<Float> finiteAnimationSpecInvoke2 = menuKt$DropdownMenuContent$scale$22.invoke(transitionUpdateTransition2.getSegment(), composerStartRestartGroup, 0);
            final Modifier modifier42 = modifier2;
            stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition2, fValueOf4, fValueOf22, finiteAnimationSpecInvoke2, vectorConverter3, "FloatAnimation", composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            MenuKt$DropdownMenuContent$alpha$2 menuKt$DropdownMenuContent$alpha$22 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$alpha$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                @NotNull
                public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<Boolean> animateFloat, @Nullable Composer composer2, int i7) {
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    composer2.startReplaceableGroup(782718552);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(782718552, i7, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:97)");
                    }
                    TweenSpec tweenSpecTween$default = animateFloat.isTransitioningTo(Boolean.FALSE, Boolean.TRUE) ? AnimationSpecKt.tween$default(30, 0, null, 6, null) : AnimationSpecKt.tween$default(75, 0, null, 6, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceableGroup();
                    return tweenSpecTween$default;
                }
            };
            composerStartRestartGroup.startReplaceableGroup(1399891485);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter22 = VectorConvertersKt.getVectorConverter(floatCompanionObject2);
            composerStartRestartGroup.startReplaceableGroup(1847725064);
            boolean zBooleanValue32 = ((Boolean) transitionUpdateTransition2.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1541356035);
            if (ComposerKt.isTraceInProgress()) {
            }
            if (!zBooleanValue32) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf32 = Float.valueOf(f5);
            boolean zBooleanValue42 = ((Boolean) transitionUpdateTransition2.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1541356035);
            if (ComposerKt.isTraceInProgress()) {
            }
            if (zBooleanValue42) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition2, fValueOf32, Float.valueOf(f6), menuKt$DropdownMenuContent$alpha$22.invoke(transitionUpdateTransition2.getSegment(), composerStartRestartGroup, 0), vectorConverter22, "FloatAnimation", composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            zChanged = composerStartRestartGroup.changed(stateCreateTransitionAnimation) | composerStartRestartGroup.changed(stateCreateTransitionAnimation2) | composerStartRestartGroup.changed(transformOriginState);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuContent$1$1
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
                    public final void invoke2(@NotNull GraphicsLayerScope graphicsLayer) {
                        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                        graphicsLayer.setScaleX(MenuKt.m16783DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                        graphicsLayer.setScaleY(MenuKt.m16783DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                        graphicsLayer.setAlpha(MenuKt.m16784DropdownMenuContent$lambda3(stateCreateTransitionAnimation2));
                        graphicsLayer.mo18718setTransformOrigin__ExYCQ(transformOriginState.getValue().getPackedValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                composerStartRestartGroup.endReplaceableGroup();
                CardKt.m16639CardFjzlyU(GraphicsLayerModifierKt.graphicsLayer(companion2, (Function1) objRememberedValue), null, 0L, 0L, null, MenuElevation, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -242468534, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuContent.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i7) {
                        if ((i7 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-242468534, i7, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:123)");
                        }
                        Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(IntrinsicKt.width(PaddingKt.m15856paddingVpY3zN4$default(modifier42, 0.0f, MenuKt.getDropdownMenuVerticalPadding(), 1, null), IntrinsicSize.Max), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null);
                        Function3<ColumnScope, Composer, Integer, Unit> function3 = content;
                        int i8 = i5 & 7168;
                        composer2.startReplaceableGroup(-483455358);
                        MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer2, 0, -1323940314);
                        Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion22.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierVerticalScroll$default);
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        composer2.disableReusing();
                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion22, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion22, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                        composer2.startReplaceableGroup(-1163856341);
                        function3.invoke(ColumnScopeInstance.INSTANCE, composer2, Integer.valueOf(((i8 >> 6) & 112) | 6));
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 1769472, 30);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier42;
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: DropdownMenuContent$lambda-1, reason: not valid java name */
    public static final float m16783DropdownMenuContent$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: DropdownMenuContent$lambda-3, reason: not valid java name */
    public static final float m16784DropdownMenuContent$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0214 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01a5  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DropdownMenuItemContent(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable PaddingValues paddingValues, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        PaddingValues dropdownMenuItemContentPadding;
        int i7;
        MutableInteractionSource mutableInteractionSource2;
        final int i8;
        Composer composer2;
        final boolean z3;
        final Modifier modifier3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(87134531);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 7168) == 0) {
                        dropdownMenuItemContentPadding = paddingValues;
                        i4 |= composerStartRestartGroup.changed(dropdownMenuItemContentPadding) ? 2048 : 1024;
                    }
                    i7 = i2 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else {
                        if ((57344 & i) == 0) {
                            mutableInteractionSource2 = mutableInteractionSource;
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                        }
                        if ((i2 & 32) == 0) {
                            i9 = (458752 & i) == 0 ? composerStartRestartGroup.changed(content) ? 131072 : 65536 : 196608;
                            i8 = i4;
                            if ((374491 & i8) == 74898 || !composerStartRestartGroup.getSkipping()) {
                                Modifier modifier4 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                                boolean z4 = i5 == 0 ? true : z2;
                                if (i6 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                }
                                if (i7 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(87134531, i8, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                                }
                                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                composer2 = composerStartRestartGroup;
                                Modifier modifier5 = modifier4;
                                final boolean z5 = z4;
                                Modifier modifierPadding = PaddingKt.padding(SizeKt.m15903sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m15440clickableO2vRcR0$default(modifier5, mutableInteractionSource4, RippleKt.m16977rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z5, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), dropdownMenuItemContentPadding);
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                composer2.startReplaceableGroup(693286680);
                                MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composer2, 48, -1323940314);
                                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                if (composer2.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.useNode();
                                } else {
                                    composer2.createNode(constructor);
                                }
                                composer2.disableReusing();
                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                composer2.startReplaceableGroup(-678309503);
                                final RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(1664959143);
                                final int i11 = 6;
                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composer2, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer3, int i12) {
                                        float disabled;
                                        if ((i12 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1190489496, i12, -1, "androidx.compose.material.DropdownMenuItemContent.<anonymous>.<anonymous> (Menu.kt:163)");
                                        }
                                        if (z5) {
                                            composer3.startReplaceableGroup(-1945695285);
                                            disabled = ContentAlpha.INSTANCE.getHigh(composer3, 6);
                                        } else {
                                            composer3.startReplaceableGroup(-1945695262);
                                            disabled = ContentAlpha.INSTANCE.getDisabled(composer3, 6);
                                        }
                                        composer3.endReplaceableGroup();
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                        final Function3<RowScope, Composer, Integer, Unit> function3 = content;
                                        final RowScope rowScope = rowScopeInstance;
                                        final int i13 = i11;
                                        final int i14 = i8;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                            @Composable
                                            public final void invoke(@Nullable Composer composer4, int i15) {
                                                if ((i15 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1705995688, i15, -1, "androidx.compose.material.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:165)");
                                                }
                                                function3.invoke(rowScope, composer4, Integer.valueOf((i13 & 14) | ((i14 >> 12) & 112)));
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer3, 56);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer2, 48);
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z3 = z5;
                                modifier3 = modifier5;
                                mutableInteractionSource3 = mutableInteractionSource4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                z3 = z2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                composer2 = composerStartRestartGroup;
                            }
                            final PaddingValues paddingValues2 = dropdownMenuItemContentPadding;
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt.DropdownMenuItemContent.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@Nullable Composer composer3, int i12) {
                                    MenuKt.DropdownMenuItemContent(onClick, modifier3, z3, paddingValues2, mutableInteractionSource3, content, composer3, i | 1, i2);
                                }
                            });
                            return;
                        }
                        i4 |= i9;
                        i8 = i4;
                        if ((374491 & i8) == 74898) {
                            if (i10 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                            composer2 = composerStartRestartGroup;
                            Modifier modifier52 = modifier4;
                            final boolean z52 = z4;
                            Modifier modifierPadding2 = PaddingKt.padding(SizeKt.m15903sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m15440clickableO2vRcR0$default(modifier52, mutableInteractionSource42, RippleKt.m16977rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z52, null, null, onClick, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), dropdownMenuItemContentPadding);
                            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                            composer2.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyM1207h2 = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically2, composer2, 48, -1323940314);
                            Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierPadding2);
                            if (composer2.getApplier() == null) {
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                            }
                            composer2.disableReusing();
                            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer2);
                            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1207h2, composerM18018constructorimpl2, density2));
                            AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 2058660585);
                            composer2.startReplaceableGroup(-678309503);
                            final RowScope rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(1664959143);
                            final int i112 = 6;
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composer2, 1190489496, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer3, int i12) {
                                    float disabled;
                                    if ((i12 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1190489496, i12, -1, "androidx.compose.material.DropdownMenuItemContent.<anonymous>.<anonymous> (Menu.kt:163)");
                                    }
                                    if (z52) {
                                        composer3.startReplaceableGroup(-1945695285);
                                        disabled = ContentAlpha.INSTANCE.getHigh(composer3, 6);
                                    } else {
                                        composer3.startReplaceableGroup(-1945695262);
                                        disabled = ContentAlpha.INSTANCE.getDisabled(composer3, 6);
                                    }
                                    composer3.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))};
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final RowScope rowScope = rowScopeInstance2;
                                    final int i13 = i112;
                                    final int i14 = i8;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1705995688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i15) {
                                            if ((i15 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1705995688, i15, -1, "androidx.compose.material.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:165)");
                                            }
                                            function3.invoke(rowScope, composer4, Integer.valueOf((i13 & 14) | ((i14 >> 12) & 112)));
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 48);
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            z3 = z52;
                            modifier3 = modifier52;
                            mutableInteractionSource3 = mutableInteractionSource42;
                        }
                        final PaddingValues paddingValues22 = dropdownMenuItemContentPadding;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i2 & 32) == 0) {
                    }
                    i4 |= i9;
                    i8 = i4;
                    if ((374491 & i8) == 74898) {
                    }
                    final PaddingValues paddingValues222 = dropdownMenuItemContentPadding;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                dropdownMenuItemContentPadding = paddingValues;
                i7 = i2 & 16;
                if (i7 == 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 32) == 0) {
                }
                i4 |= i9;
                i8 = i4;
                if ((374491 & i8) == 74898) {
                }
                final PaddingValues paddingValues2222 = dropdownMenuItemContentPadding;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            dropdownMenuItemContentPadding = paddingValues;
            i7 = i2 & 16;
            if (i7 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 32) == 0) {
            }
            i4 |= i9;
            i8 = i4;
            if ((374491 & i8) == 74898) {
            }
            final PaddingValues paddingValues22222 = dropdownMenuItemContentPadding;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        dropdownMenuItemContentPadding = paddingValues;
        i7 = i2 & 16;
        if (i7 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 32) == 0) {
        }
        i4 |= i9;
        i8 = i4;
        if ((374491 & i8) == 74898) {
        }
        final PaddingValues paddingValues222222 = dropdownMenuItemContentPadding;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long calculateTransformOrigin(@NotNull IntRect parentBounds, @NotNull IntRect menuBounds) {
        float fMin;
        Intrinsics.checkNotNullParameter(parentBounds, "parentBounds");
        Intrinsics.checkNotNullParameter(menuBounds, "menuBounds");
        float fMin2 = 1.0f;
        if (menuBounds.getLeft() < parentBounds.getRight()) {
            if (menuBounds.getRight() <= parentBounds.getLeft()) {
                fMin = 1.0f;
            } else if (menuBounds.getWidth() == 0) {
                fMin = 0.0f;
            } else {
                fMin = (((Math.min(parentBounds.getRight(), menuBounds.getRight()) + Math.max(parentBounds.getLeft(), menuBounds.getLeft())) / 2) - menuBounds.getLeft()) / menuBounds.getWidth();
            }
        }
        if (menuBounds.getTop() < parentBounds.getBottom()) {
            if (menuBounds.getBottom() > parentBounds.getTop()) {
                if (menuBounds.getHeight() == 0) {
                    fMin2 = 0.0f;
                } else {
                    fMin2 = (((Math.min(parentBounds.getBottom(), menuBounds.getBottom()) + Math.max(parentBounds.getTop(), menuBounds.getTop())) / 2) - menuBounds.getTop()) / menuBounds.getHeight();
                }
            }
        }
        return TransformOriginKt.TransformOrigin(fMin, fMin2);
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }
}
