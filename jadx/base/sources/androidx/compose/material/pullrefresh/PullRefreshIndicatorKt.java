package androidx.compose.material.pullrefresh;

import androidx.collection.AbstractC0622a;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.ExperimentalMaterialApi;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.graphics.AndroidPath_androidKt;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.PathFillType;
import androidx.compose.p109ui.graphics.StrokeCap;
import androidx.compose.p109ui.graphics.drawscope.DrawContext;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.drawscope.Stroke;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002\u001a-\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aM\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u00162\b\b\u0002\u0010\u001f\u001a\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u001dH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a9\u0010#\u001a\u00020\u0012*\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u000fH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\r\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006,"}, m13886d2 = {"ArcRadius", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "Elevation", "IndicatorSize", "MaxProgressArc", "", "SpinnerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "StrokeWidth", "ArrowValues", "Landroidx/compose/material/pullrefresh/ArrowValues;", "progress", "CircularArrowIndicator", "", "state", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "color", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "CircularArrowIndicator-iJQMabo", "(Landroidx/compose/material/pullrefresh/PullRefreshState;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "PullRefreshIndicator", "refreshing", "", "backgroundColor", "contentColor", WiggleAnimationConfig.KEY_SCALE, "PullRefreshIndicator-jB83MbM", "(ZLandroidx/compose/material/pullrefresh/PullRefreshState;Landroidx/compose/ui/Modifier;JJZLandroidx/compose/runtime/Composer;II)V", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "values", "drawArrow-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JLandroidx/compose/material/pullrefresh/ArrowValues;)V", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class PullRefreshIndicatorKt {
    private static final int CrossfadeDurationMs = 100;
    private static final float MaxProgressArc = 0.8f;
    private static final float IndicatorSize = C2256Dp.m20968constructorimpl(40);

    @NotNull
    private static final RoundedCornerShape SpinnerShape = RoundedCornerShapeKt.getCircleShape();
    private static final float ArcRadius = C2256Dp.m20968constructorimpl((float) 7.5d);
    private static final float StrokeWidth = C2256Dp.m20968constructorimpl((float) 2.5d);
    private static final float ArrowWidth = C2256Dp.m20968constructorimpl(10);
    private static final float ArrowHeight = C2256Dp.m20968constructorimpl(5);
    private static final float Elevation = C2256Dp.m20968constructorimpl(6);

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrowValues ArrowValues(float f) {
        float fMax = (Math.max(Math.min(1.0f, f) - 0.4f, 0.0f) * 5) / 3;
        float fCoerceIn = RangesKt.coerceIn(Math.abs(f) - 1.0f, 0.0f, 2.0f);
        float fPow = fCoerceIn - (((float) Math.pow(fCoerceIn, 2)) / 4);
        float fCoerceIn2 = RangesKt.coerceIn(f, 0.0f, 1.0f);
        float f4 = (((0.4f * fMax) - 0.25f) + fPow) * 0.5f;
        float f5 = PopOverActivityWrapper.DEFAULT_WIDTH;
        return new ArrowValues(fCoerceIn2, f4, f4 * f5, ((0.8f * fMax) + f4) * f5, Math.min(1.0f, fMax));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterialApi
    /* JADX INFO: renamed from: CircularArrowIndicator-iJQMabo, reason: not valid java name */
    public static final void m16956CircularArrowIndicatoriJQMabo(final PullRefreshState pullRefreshState, final long j, final Modifier modifier, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-486016981);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-486016981, i, -1, "androidx.compose.material.pullrefresh.CircularArrowIndicator (PullRefreshIndicator.kt:120)");
        }
        composerStartRestartGroup.startReplaceableGroup(-492369756);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        Object obj = objRememberedValue;
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Path Path = AndroidPath_androidKt.Path();
            Path.mo18418setFillTypeoQ8Xj4U(PathFillType.INSTANCE.m18807getEvenOddRgk1Os());
            composerStartRestartGroup.updateRememberedValue(Path);
            obj = Path;
        }
        composerStartRestartGroup.endReplaceableGroup();
        final Path path = (Path) obj;
        CanvasKt.Canvas(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                SemanticsPropertiesKt.setContentDescription(semantics, "Refreshing");
            }
        }, 1, null), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DrawScope Canvas) {
                Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                ArrowValues ArrowValues = PullRefreshIndicatorKt.ArrowValues(pullRefreshState.getProgress());
                float rotation = ArrowValues.getRotation();
                long j2 = j;
                Path path2 = path;
                long jMo19075getCenterF1C5BW0 = Canvas.mo19075getCenterF1C5BW0();
                DrawContext drawContext = Canvas.getDrawContext();
                long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
                drawContext.getCanvas().save();
                drawContext.getTransform().mo19003rotateUv8p0NA(rotation, jMo19075getCenterF1C5BW0);
                float fMo15546toPx0680j_4 = (Canvas.mo15546toPx0680j_4(PullRefreshIndicatorKt.StrokeWidth) / 2.0f) + Canvas.mo15546toPx0680j_4(PullRefreshIndicatorKt.ArcRadius);
                Rect rect = new Rect(Offset.m18284getXimpl(SizeKt.m18363getCenteruvyYCjk(Canvas.mo19076getSizeNHjbRc())) - fMo15546toPx0680j_4, Offset.m18285getYimpl(SizeKt.m18363getCenteruvyYCjk(Canvas.mo19076getSizeNHjbRc())) - fMo15546toPx0680j_4, Offset.m18284getXimpl(SizeKt.m18363getCenteruvyYCjk(Canvas.mo19076getSizeNHjbRc())) + fMo15546toPx0680j_4, Offset.m18285getYimpl(SizeKt.m18363getCenteruvyYCjk(Canvas.mo19076getSizeNHjbRc())) + fMo15546toPx0680j_4);
                DrawScope.m19055drawArcyD3GUKo$default(Canvas, j2, ArrowValues.getStartAngle(), ArrowValues.getEndAngle() - ArrowValues.getStartAngle(), false, rect.m18319getTopLeftF1C5BW0(), rect.m18317getSizeNHjbRc(), ArrowValues.getAlpha(), new Stroke(Canvas.mo15546toPx0680j_4(PullRefreshIndicatorKt.StrokeWidth), 0.0f, StrokeCap.INSTANCE.m18880getSquareKaPHkGw(), 0, null, 26, null), null, 0, 768, null);
                PullRefreshIndicatorKt.m16961drawArrow42QJj7c(Canvas, path2, rect, j2, ArrowValues);
                AbstractC0622a.m1179y(drawContext, jMo18997getSizeNHjbRc);
            }
        }, composerStartRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i2) {
                PullRefreshIndicatorKt.m16956CircularArrowIndicatoriJQMabo(pullRefreshState, j, modifier, composer2, i | 1);
            }
        });
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterialApi
    /* JADX INFO: renamed from: PullRefreshIndicator-jB83MbM, reason: not valid java name */
    public static final void m16957PullRefreshIndicatorjB83MbM(final boolean z, @NotNull final PullRefreshState state, @Nullable Modifier modifier, long j, long j2, boolean z2, @Nullable Composer composer, int i, final int i2) {
        int i4;
        long jM16680getSurface0d7_KjU;
        int i5;
        long j3;
        final boolean z3;
        Object objDerivedStateOf;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(308716636);
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
        if ((i2 & 8) != 0) {
            jM16680getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16680getSurface0d7_KjU();
            i4 = i;
            i5 = i4 & (-7169);
        } else {
            i4 = i;
            jM16680getSurface0d7_KjU = j;
            i5 = i4;
        }
        if ((i2 & 16) != 0) {
            long jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composerStartRestartGroup, (i5 >> 9) & 14);
            i5 &= -57345;
            j3 = jM16694contentColorForek8zF_U;
        } else {
            j3 = j2;
        }
        boolean z4 = (i2 & 32) != 0 ? false : z2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(308716636, i5, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator (PullRefreshIndicator.kt:71)");
        }
        Boolean boolValueOf = Boolean.valueOf(z);
        composerStartRestartGroup.startReplaceableGroup(511388516);
        boolean zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(state);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            z3 = z;
            objDerivedStateOf = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$showElevation$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    return Boolean.valueOf(z3 || state.getPosition$material_release() > 0.5f);
                }
            });
            composerStartRestartGroup.updateRememberedValue(objDerivedStateOf);
        } else {
            objDerivedStateOf = objRememberedValue;
            z3 = z;
        }
        composerStartRestartGroup.endReplaceableGroup();
        final int i6 = i5;
        final boolean z5 = z3;
        final long j5 = j3;
        SurfaceKt.m16872SurfaceFjzlyU(PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform(androidx.compose.foundation.layout.SizeKt.m15899size3ABfNKs(modifier2, IndicatorSize), state, z4), SpinnerShape, jM16680getSurface0d7_KjU, 0L, null, m16958PullRefreshIndicator_jB83MbM$lambda1((State) objDerivedStateOf) ? Elevation : C2256Dp.m20968constructorimpl(0), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -194757728, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ComposerKt.traceEventStart(-194757728, i7, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator.<anonymous> (PullRefreshIndicator.kt:90)");
                }
                Boolean boolValueOf2 = Boolean.valueOf(z5);
                TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(100, 0, null, 6, null);
                final long j6 = j5;
                final int i8 = i6;
                final PullRefreshState pullRefreshState = state;
                CrossfadeKt.Crossfade(boolValueOf2, null, tweenSpecTween$default, ComposableLambdaKt.composableLambda(composer2, -2067838016, true, new Function3<Boolean, Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer3, Integer num) {
                        invoke(bool.booleanValue(), composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(boolean z6, @Nullable Composer composer3, int i9) {
                        int i10;
                        if ((i9 & 14) == 0) {
                            i10 = (composer3.changed(z6) ? 4 : 2) | i9;
                        } else {
                            i10 = i9;
                        }
                        if ((i10 & 91) == 18 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2067838016, i9, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator.<anonymous>.<anonymous> (PullRefreshIndicator.kt:94)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        Modifier modifierFillMaxSize$default = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        long j7 = j6;
                        int i11 = i8;
                        PullRefreshState pullRefreshState2 = pullRefreshState;
                        composer3.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer3, 6);
                        Density density = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                        LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxSize$default);
                        if (composer3.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        composer3.disableReusing();
                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                        composer3.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer3.startReplaceableGroup(831079366);
                        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(PullRefreshIndicatorKt.StrokeWidth + PullRefreshIndicatorKt.ArcRadius) * 2);
                        if (z6) {
                            composer3.startReplaceableGroup(-2035147616);
                            ProgressIndicatorKt.m16814CircularProgressIndicatoraMcp0Q(androidx.compose.foundation.layout.SizeKt.m15899size3ABfNKs(companion, fM20968constructorimpl), j7, PullRefreshIndicatorKt.StrokeWidth, composer3, ((i11 >> 9) & 112) | 390, 0);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(-2035147362);
                            PullRefreshIndicatorKt.m16956CircularArrowIndicatoriJQMabo(pullRefreshState2, j7, androidx.compose.foundation.layout.SizeKt.m15899size3ABfNKs(companion, fM20968constructorimpl), composer3, ((i11 >> 9) & 112) | 392);
                            composer3.endReplaceableGroup();
                        }
                        if (AbstractC1038a.m1225z(composer3)) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (i6 & 14) | 3456, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, ((i5 >> 3) & 896) | 1572912, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final long j6 = jM16680getSurface0d7_KjU;
        final Modifier modifier3 = modifier2;
        final int i7 = i4;
        final boolean z6 = z4;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i8) {
                PullRefreshIndicatorKt.m16957PullRefreshIndicatorjB83MbM(z, state, modifier3, j6, j5, z6, composer2, i7 | 1, i2);
            }
        });
    }

    /* JADX INFO: renamed from: PullRefreshIndicator_jB83MbM$lambda-1, reason: not valid java name */
    private static final boolean m16958PullRefreshIndicator_jB83MbM$lambda1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawArrow-42QJj7c, reason: not valid java name */
    public static final void m16961drawArrow42QJj7c(DrawScope drawScope, Path path, Rect rect, long j, ArrowValues arrowValues) {
        path.reset();
        path.moveTo(0.0f, 0.0f);
        float f = ArrowWidth;
        path.lineTo(drawScope.mo15546toPx0680j_4(f) * arrowValues.getScale(), 0.0f);
        path.lineTo((drawScope.mo15546toPx0680j_4(f) * arrowValues.getScale()) / 2, drawScope.mo15546toPx0680j_4(ArrowHeight) * arrowValues.getScale());
        path.mo18420translatek4lQ0M(OffsetKt.Offset((Offset.m18284getXimpl(rect.m18314getCenterF1C5BW0()) + (Math.min(rect.getWidth(), rect.getHeight()) / 2.0f)) - ((drawScope.mo15546toPx0680j_4(f) * arrowValues.getScale()) / 2.0f), (drawScope.mo15546toPx0680j_4(StrokeWidth) / 2.0f) + Offset.m18285getYimpl(rect.m18314getCenterF1C5BW0())));
        path.close();
        float endAngle = arrowValues.getEndAngle();
        long jMo19075getCenterF1C5BW0 = drawScope.mo19075getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo19003rotateUv8p0NA(endAngle, jMo19075getCenterF1C5BW0);
        DrawScope.m19066drawPathLG529CI$default(drawScope, path, j, arrowValues.getAlpha(), null, null, 0, 56, null);
        AbstractC0622a.m1179y(drawContext, jMo18997getSizeNHjbRc);
    }
}
