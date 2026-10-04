package androidx.compose.material3;

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
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p109ui.graphics.GraphicsLayerScope;
import androidx.compose.p109ui.graphics.TransformOrigin;
import androidx.compose.p109ui.graphics.TransformOriginKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.text.TextStyle;
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
import androidx.compose.runtime.ProvidableCompositionLocal;
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
@Metadata(m13885d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aT\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u0080\u0001\u0010\u001d\u001a\u00020\u000e2\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u000e0\u001f¢\u0006\u0002\b\u001a2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u001f2\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001f¢\u0006\u0002\b\u001a2\u0013\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001f¢\u0006\u0002\b\u001a2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\u0010*\u001a \u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0000ø\u0001\u0000¢\u0006\u0002\u0010/\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\n\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007\"\u000e\u0010\f\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00060"}, m13886d2 = {"DropdownMenuItemDefaultMaxWidth", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "()F", "InTransitionDuration", "", "MenuVerticalMargin", "getMenuVerticalMargin", "OutTransitionDuration", "DropdownMenuContent", "", "expandedStates", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItemContent", "text", "Lkotlin/Function0;", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "calculateTransformOrigin", "parentBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class MenuKt {
    public static final int InTransitionDuration = 120;
    public static final int OutTransitionDuration = 75;
    private static final float MenuVerticalMargin = C2256Dp.m20968constructorimpl(48);
    private static final float DropdownMenuItemHorizontalPadding = C2256Dp.m20968constructorimpl(12);
    private static final float DropdownMenuVerticalPadding = C2256Dp.m20968constructorimpl(8);
    private static final float DropdownMenuItemDefaultMinWidth = C2256Dp.m20968constructorimpl(112);
    private static final float DropdownMenuItemDefaultMaxWidth = C2256Dp.m20968constructorimpl(280);

    /* JADX WARN: Removed duplicated region for block: B:103:0x0260 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0261  */
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
    /* JADX WARN: Removed duplicated region for block: B:99:0x0256  */
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
        Composer composerStartRestartGroup = composer.startRestartGroup(-159754260);
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
                    ComposerKt.traceEventStart(-159754260, i5, -1, "androidx.compose.material3.DropdownMenuContent (Menu.kt:65)");
                }
                Transition transitionUpdateTransition = TransitionKt.updateTransition((MutableTransitionState) expandedStates, "DropDownMenu", composerStartRestartGroup, MutableTransitionState.$stable | 48 | (i5 & 14), 0);
                MenuKt$DropdownMenuContent$scale$2 menuKt$DropdownMenuContent$scale$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$scale$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    @NotNull
                    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<Boolean> animateFloat, @Nullable Composer composer2, int i7) {
                        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                        composer2.startReplaceableGroup(839979861);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(839979861, i7, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:75)");
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
                composerStartRestartGroup.startReplaceableGroup(1808111696);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1808111696, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:90)");
                }
                float f = !zBooleanValue ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf = Float.valueOf(f);
                boolean zBooleanValue2 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
                composerStartRestartGroup.startReplaceableGroup(1808111696);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1808111696, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:90)");
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
                MenuKt$DropdownMenuContent$alpha$2 menuKt$DropdownMenuContent$alpha$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$alpha$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    @NotNull
                    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<Boolean> animateFloat, @Nullable Composer composer2, int i7) {
                        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                        composer2.startReplaceableGroup(896631233);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(896631233, i7, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:101)");
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
                composerStartRestartGroup.startReplaceableGroup(1864763068);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1864763068, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:110)");
                }
                float f5 = !zBooleanValue3 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf3 = Float.valueOf(f5);
                boolean zBooleanValue4 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
                composerStartRestartGroup.startReplaceableGroup(1864763068);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1864763068, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:110)");
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
                    objRememberedValue = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$1$1
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
                            graphicsLayer.setScaleX(MenuKt.m17218DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                            graphicsLayer.setScaleY(MenuKt.m17218DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                            graphicsLayer.setAlpha(MenuKt.m17219DropdownMenuContent$lambda3(stateCreateTransitionAnimation2));
                            graphicsLayer.mo18718setTransformOrigin__ExYCQ(transformOriginState.getValue().getPackedValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue);
                MenuTokens menuTokens = MenuTokens.INSTANCE;
                SurfaceKt.m17325SurfaceT9BRK9s(modifierGraphicsLayer, ShapesKt.toShape(menuTokens.getContainerShape(), composerStartRestartGroup, 6), ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), menuTokens.getContainerColor()), 0L, menuTokens.m17734getContainerElevationD9Ej5fM(), menuTokens.m17734getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1651673913, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt.DropdownMenuContent.2
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
                            ComposerKt.traceEventStart(-1651673913, i7, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:130)");
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
                }), composerStartRestartGroup, 12804096, 72);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt.DropdownMenuContent.3
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
            MenuKt$DropdownMenuContent$scale$2 menuKt$DropdownMenuContent$scale$22 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$scale$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                @NotNull
                public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<Boolean> animateFloat, @Nullable Composer composer2, int i7) {
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    composer2.startReplaceableGroup(839979861);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(839979861, i7, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:75)");
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
            composerStartRestartGroup.startReplaceableGroup(1808111696);
            if (ComposerKt.isTraceInProgress()) {
            }
            if (!zBooleanValue5) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf4 = Float.valueOf(f);
            boolean zBooleanValue22 = ((Boolean) transitionUpdateTransition2.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(1808111696);
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
            MenuKt$DropdownMenuContent$alpha$2 menuKt$DropdownMenuContent$alpha$22 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$alpha$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                @NotNull
                public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<Boolean> animateFloat, @Nullable Composer composer2, int i7) {
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    composer2.startReplaceableGroup(896631233);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(896631233, i7, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:101)");
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
            composerStartRestartGroup.startReplaceableGroup(1864763068);
            if (ComposerKt.isTraceInProgress()) {
            }
            if (!zBooleanValue32) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf32 = Float.valueOf(f5);
            boolean zBooleanValue42 = ((Boolean) transitionUpdateTransition2.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(1864763068);
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
                objRememberedValue = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$1$1
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
                        graphicsLayer.setScaleX(MenuKt.m17218DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                        graphicsLayer.setScaleY(MenuKt.m17218DropdownMenuContent$lambda1(stateCreateTransitionAnimation));
                        graphicsLayer.setAlpha(MenuKt.m17219DropdownMenuContent$lambda3(stateCreateTransitionAnimation2));
                        graphicsLayer.mo18718setTransformOrigin__ExYCQ(transformOriginState.getValue().getPackedValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierGraphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(companion2, (Function1) objRememberedValue);
                MenuTokens menuTokens2 = MenuTokens.INSTANCE;
                SurfaceKt.m17325SurfaceT9BRK9s(modifierGraphicsLayer2, ShapesKt.toShape(menuTokens2.getContainerShape(), composerStartRestartGroup, 6), ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), menuTokens2.getContainerColor()), 0L, menuTokens2.m17734getContainerElevationD9Ej5fM(), menuTokens2.m17734getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1651673913, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt.DropdownMenuContent.2
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
                            ComposerKt.traceEventStart(-1651673913, i7, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:130)");
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
                }), composerStartRestartGroup, 12804096, 72);
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
    public static final float m17218DropdownMenuContent$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: DropdownMenuContent$lambda-3, reason: not valid java name */
    public static final float m17219DropdownMenuContent$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void DropdownMenuItemContent(@NotNull final Function2<? super Composer, ? super Integer, Unit> text, @NotNull final Function0<Unit> onClick, @NotNull final Modifier modifier, @Nullable final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable final Function2<? super Composer, ? super Integer, Unit> function22, final boolean z, @NotNull final MenuItemColors colors, @NotNull final PaddingValues contentPadding, @NotNull final MutableInteractionSource interactionSource, @Nullable Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1564716777);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(onClick) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(function2) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(function22) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            z2 = z;
            i2 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
        } else {
            z2 = z;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(colors) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(contentPadding) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(interactionSource) ? 67108864 : 33554432;
        }
        if ((191739611 & i2) == 38347922 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1564716777, i2, -1, "androidx.compose.material3.DropdownMenuItemContent (Menu.kt:142)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(ClickableKt.m15440clickableO2vRcR0$default(modifier, interactionSource, RippleKt.m16977rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), z2, null, null, onClick, 24, null), 0.0f, 1, null);
            float f = DropdownMenuItemDefaultMinWidth;
            float f4 = DropdownMenuItemDefaultMaxWidth;
            MenuTokens menuTokens = MenuTokens.INSTANCE;
            Modifier modifierPadding = PaddingKt.padding(SizeKt.m15903sizeInqDBjuR0$default(modifierFillMaxWidth$default, f, menuTokens.m17735getListItemContainerHeightD9Ej5fM(), f4, 0.0f, 8, null), contentPadding);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composerStartRestartGroup, 48, -1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
            composerStartRestartGroup.startReplaceableGroup(-678309503);
            final RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-837672837);
            TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), menuTokens.getListItemLabelTextFont());
            composer2 = composerStartRestartGroup;
            final int i4 = i2;
            TextKt.ProvideTextStyle(textStyleFromToken, ComposableLambdaKt.composableLambda(composer2, 1065051884, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1
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
                public final void invoke(@Nullable Composer composer3, int i5) {
                    if ((i5 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1065051884, i5, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous> (Menu.kt:171)");
                    }
                    composer3.startReplaceableGroup(1426254055);
                    if (function2 != null) {
                        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                        MenuItemColors menuItemColors = colors;
                        boolean z3 = z;
                        int i6 = i4;
                        ProvidedValue[] providedValueArr = {localContentColor.provides(menuItemColors.leadingIconColor$material3_release(z3, composer3, ((i6 >> 15) & 112) | ((i6 >> 15) & 14)).getValue())};
                        final Function2<Composer, Integer, Unit> function23 = function2;
                        final int i7 = i4;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2035552199, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1.1
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
                            public final void invoke(@Nullable Composer composer4, int i8) {
                                if ((i8 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2035552199, i8, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:175)");
                                }
                                Modifier modifierM15884defaultMinSizeVpY3zN4$default = SizeKt.m15884defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, MenuTokens.INSTANCE.m17736getListItemLeadingIconSizeD9Ej5fM(), 0.0f, 2, null);
                                Function2<Composer, Integer, Unit> function24 = function23;
                                int i9 = i7;
                                composer4.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer4, 0, -1323940314);
                                Density density2 = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection2 = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15884defaultMinSizeVpY3zN4$default);
                                if (composer4.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor2);
                                } else {
                                    composer4.useNode();
                                }
                                composer4.disableReusing();
                                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer4);
                                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                                AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer4, composer4), composer4, 2058660585);
                                composer4.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer4.startReplaceableGroup(1667854413);
                                if (AbstractC1038a.m1199D(composer4, (i9 >> 9) & 14, function24)) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, 56);
                    }
                    composer3.endReplaceableGroup();
                    ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                    MenuItemColors menuItemColors2 = colors;
                    boolean z4 = z;
                    int i8 = i4;
                    ProvidedValue[] providedValueArr2 = {localContentColor2.provides(menuItemColors2.textColor$material3_release(z4, composer3, ((i8 >> 15) & 112) | ((i8 >> 15) & 14)).getValue())};
                    final RowScope rowScope = rowScopeInstance;
                    final Function2<Composer, Integer, Unit> function24 = function2;
                    final Function2<Composer, Integer, Unit> function25 = function22;
                    final Function2<Composer, Integer, Unit> function26 = text;
                    final int i9 = i4;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr2, ComposableLambdaKt.composableLambda(composer3, -1728894036, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1.2
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
                        public final void invoke(@Nullable Composer composer4, int i10) {
                            if ((i10 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1728894036, i10, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:181)");
                            }
                            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), function24 != null ? MenuKt.DropdownMenuItemHorizontalPadding : C2256Dp.m20968constructorimpl(0), 0.0f, function25 != null ? MenuKt.DropdownMenuItemHorizontalPadding : C2256Dp.m20968constructorimpl(0), 0.0f, 10, null);
                            Function2<Composer, Integer, Unit> function27 = function26;
                            int i11 = i9;
                            composer4.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer4, 0, -1323940314);
                            Density density2 = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection2 = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
                            if (composer4.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor2);
                            } else {
                                composer4.useNode();
                            }
                            composer4.disableReusing();
                            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer4);
                            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                            AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer4, composer4), composer4, 2058660585);
                            composer4.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer4.startReplaceableGroup(-1301783630);
                            if (AbstractC1038a.m1199D(composer4, i11 & 14, function27)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer3, 56);
                    if (function22 != null) {
                        ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                        MenuItemColors menuItemColors3 = colors;
                        boolean z5 = z;
                        int i10 = i4;
                        ProvidedValue[] providedValueArr3 = {localContentColor3.provides(menuItemColors3.trailingIconColor$material3_release(z5, composer3, ((i10 >> 15) & 112) | ((i10 >> 15) & 14)).getValue())};
                        final Function2<Composer, Integer, Unit> function27 = function22;
                        final int i11 = i4;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr3, ComposableLambdaKt.composableLambda(composer3, 580312062, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1.3
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
                            public final void invoke(@Nullable Composer composer4, int i12) {
                                if ((i12 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(580312062, i12, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:204)");
                                }
                                Modifier modifierM15884defaultMinSizeVpY3zN4$default = SizeKt.m15884defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, MenuTokens.INSTANCE.m17737getListItemTrailingIconSizeD9Ej5fM(), 0.0f, 2, null);
                                Function2<Composer, Integer, Unit> function28 = function27;
                                int i13 = i11;
                                composer4.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer4, 0, -1323940314);
                                Density density2 = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection2 = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15884defaultMinSizeVpY3zN4$default);
                                if (composer4.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor2);
                                } else {
                                    composer4.useNode();
                                }
                                composer4.disableReusing();
                                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer4);
                                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                                AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer4, composer4), composer4, 2058660585);
                                composer4.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer4.startReplaceableGroup(-589942012);
                                if (AbstractC1038a.m1199D(composer4, (i13 >> 12) & 14, function28)) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, 56);
                    }
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
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt.DropdownMenuItemContent.2
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

            public final void invoke(@Nullable Composer composer3, int i5) {
                MenuKt.DropdownMenuItemContent(text, onClick, modifier, function2, function22, z, colors, contentPadding, interactionSource, composer3, i | 1);
            }
        });
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
