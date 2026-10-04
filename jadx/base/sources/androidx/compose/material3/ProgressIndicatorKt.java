package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.StrokeCap;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.drawscope.Stroke;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.PermissionCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a3\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0005H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a;\u0010\"\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0005H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a3\u0010.\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010/\u001a\u00020'H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a;\u0010.\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010/\u001a\u00020'H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a9\u00104\u001a\u00020#*\u0002052\u0006\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a9\u0010<\u001a\u00020#*\u0002052\u0006\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010;\u001aA\u0010>\u001a\u00020#*\u0002052\u0006\u00106\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a9\u0010A\u001a\u00020#*\u0002052\u0006\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a)\u0010F\u001a\u00020#*\u0002052\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010H\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0004\u001a\u00020\u0005X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0014\u001a\u00020\u0005X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0015\u0010\u0007\"\u0019\u0010\u0016\u001a\u00020\u0005X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006I"}, m13886d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "getCircularIndicatorDiameter", "()F", TokenizerME.NO_SPLIT, "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "getLinearIndicatorHeight", "LinearIndicatorWidth", "getLinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "StartAngleOffset", "CircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "progress", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "trackColor", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJF)V", "drawLinearIndicatorTrack", "drawLinearIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JF)V", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;

    @NotNull
    private static final CubicBezierEasing CircularEasing;
    private static final float CircularIndicatorDiameter;
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;

    @NotNull
    private static final CubicBezierEasing FirstLineHeadEasing;
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;

    @NotNull
    private static final CubicBezierEasing FirstLineTailEasing;
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;

    @NotNull
    private static final CubicBezierEasing SecondLineHeadEasing;
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;

    @NotNull
    private static final CubicBezierEasing SecondLineTailEasing;
    private static final float StartAngleOffset = -90.0f;
    private static final float LinearIndicatorWidth = C2256Dp.m20968constructorimpl(240);
    private static final float LinearIndicatorHeight = LinearProgressIndicatorTokens.INSTANCE.m17722getTrackHeightD9Ej5fM();

    static {
        CircularProgressIndicatorTokens circularProgressIndicatorTokens = CircularProgressIndicatorTokens.INSTANCE;
        CircularIndicatorDiameter = C2256Dp.m20968constructorimpl(circularProgressIndicatorTokens.m17516getSizeD9Ej5fM() - C2256Dp.m20968constructorimpl(circularProgressIndicatorTokens.m17515getActiveIndicatorWidthD9Ej5fM() * 2));
        FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
        FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
        SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
        SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
        CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0110 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0111  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: CircularProgressIndicator-MBs18nI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17266CircularProgressIndicatorMBs18nI(final float f, @Nullable Modifier modifier, long j, float f4, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        final long circularColor;
        int i5;
        float fM17265getCircularStrokeWidthD9Ej5fM;
        Modifier modifier3;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(402841196);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) != 0) {
                circularColor = j;
                i4 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(circularColor)) ? 256 : 128;
            } else {
                circularColor = j;
            }
            i5 = i2 & 8;
            if (i5 != 0) {
                if ((i & 7168) == 0) {
                    fM17265getCircularStrokeWidthD9Ej5fM = f4;
                    i4 |= composerStartRestartGroup.changed(fM17265getCircularStrokeWidthD9Ej5fM) ? 2048 : 1024;
                }
                if ((i4 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        modifier3 = i6 == 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) != 0) {
                            circularColor = ProgressIndicatorDefaults.INSTANCE.getCircularColor(composerStartRestartGroup, 6);
                        }
                        if (i5 != 0) {
                            fM17265getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m17265getCircularStrokeWidthD9Ej5fM();
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(402841196, i, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:226)");
                    }
                    final Stroke stroke = new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(fM17265getCircularStrokeWidthD9Ej5fM), 0.0f, StrokeCap.INSTANCE.m18878getButtKaPHkGw(), 0, null, 26, null);
                    Modifier modifier5 = modifier3;
                    CanvasKt.Canvas(SizeKt.m15899size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier5, f, null, 0, 6, null), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1
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
                            ProgressIndicatorKt.m17275drawDeterminateCircularIndicator42QJj7c(Canvas, 270.0f, f * 360.0f, circularColor, stroke);
                        }
                    }, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier5;
                }
                final long j2 = circularColor;
                final float f5 = fM17265getCircularStrokeWidthD9Ej5fM;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i7) {
                        ProgressIndicatorKt.m17266CircularProgressIndicatorMBs18nI(f, modifier4, j2, f5, composer2, i | 1, i2);
                    }
                });
                return;
            }
            i4 |= 3072;
            fM17265getCircularStrokeWidthD9Ej5fM = f4;
            if ((i4 & 5851) == 1170) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 == 0) {
                    }
                    if ((i2 & 4) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Stroke stroke2 = new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(fM17265getCircularStrokeWidthD9Ej5fM), 0.0f, StrokeCap.INSTANCE.m18878getButtKaPHkGw(), 0, null, 26, null);
                    Modifier modifier52 = modifier3;
                    CanvasKt.Canvas(SizeKt.m15899size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier52, f, null, 0, 6, null), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1
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
                            ProgressIndicatorKt.m17275drawDeterminateCircularIndicator42QJj7c(Canvas, 270.0f, f * 360.0f, circularColor, stroke2);
                        }
                    }, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier52;
                }
            }
            final long j22 = circularColor;
            final float f52 = fM17265getCircularStrokeWidthD9Ej5fM;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        fM17265getCircularStrokeWidthD9Ej5fM = f4;
        if ((i4 & 5851) == 1170) {
        }
        final long j222 = circularColor;
        final float f522 = fM17265getCircularStrokeWidthD9Ej5fM;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0189 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x018a  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17267CircularProgressIndicatoraMcp0Q(@Nullable Modifier modifier, long j, float f, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        long j2;
        float f4;
        final Modifier modifier3;
        final long j3;
        float fM17265getCircularStrokeWidthD9Ej5fM;
        final float f5;
        final long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(947193756);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                j2 = j;
                int i6 = composerStartRestartGroup.changed(j2) ? 32 : 16;
                i4 |= i6;
            } else {
                j2 = j;
            }
            i4 |= i6;
        } else {
            j2 = j;
        }
        int i7 = i2 & 4;
        if (i7 == 0) {
            if ((i & 896) == 0) {
                f4 = f;
                i4 |= composerStartRestartGroup.changed(f4) ? 256 : 128;
            }
            if ((i4 & 731) == 146 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    modifier3 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                    long circularColor = (i2 & 2) == 0 ? ProgressIndicatorDefaults.INSTANCE.getCircularColor(composerStartRestartGroup, 6) : j2;
                    if (i7 == 0) {
                        j3 = circularColor;
                        fM17265getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m17265getCircularStrokeWidthD9Ej5fM();
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(947193756, i, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:261)");
                        }
                        final Stroke stroke = new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(fM17265getCircularStrokeWidthD9Ej5fM), 0.0f, StrokeCap.INSTANCE.m18880getSquareKaPHkGw(), 0, null, 26, null);
                        InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(composerStartRestartGroup, 0);
                        TwoWayConverter<Integer, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
                        InfiniteRepeatableSpec infiniteRepeatableSpecM15313infiniteRepeatable9IiC70o$default = AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null);
                        int i8 = InfiniteTransition.$stable;
                        int i9 = InfiniteRepeatableSpec.$stable;
                        final State stateAnimateValue = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition, 0, 5, vectorConverter, infiniteRepeatableSpecM15313infiniteRepeatable9IiC70o$default, composerStartRestartGroup, (i9 << 12) | i8 | 4528);
                        composerStartRestartGroup = composerStartRestartGroup;
                        final State stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, BaseRotationAngle, AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), composerStartRestartGroup, i8 | 432 | (i9 << 9));
                        final State stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, JumpRotationAngle, AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$endAngle$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                invoke2(keyframesSpecConfig);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                                Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                                keyframes.setDurationMillis(1332);
                                keyframes.with(keyframes.mo1191at(Float.valueOf(0.0f), 0), ProgressIndicatorKt.CircularEasing);
                                keyframes.mo1191at(Float.valueOf(290.0f), PermissionCode.PERMISSION_REQUEST_WRITING_TOOLKIT);
                            }
                        }), null, 0L, 6, null), composerStartRestartGroup, i8 | 432 | (i9 << 9));
                        final State stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, JumpRotationAngle, AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$startAngle$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                invoke2(keyframesSpecConfig);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                                Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                                keyframes.setDurationMillis(1332);
                                keyframes.with(keyframes.mo1191at(Float.valueOf(0.0f), PermissionCode.PERMISSION_REQUEST_WRITING_TOOLKIT), ProgressIndicatorKt.CircularEasing);
                                keyframes.mo1191at(Float.valueOf(290.0f), keyframes.getDurationMillis());
                            }
                        }), null, 0L, 6, null), composerStartRestartGroup, i8 | 432 | (i9 << 9));
                        final float f6 = fM17265getCircularStrokeWidthD9Ej5fM;
                        CanvasKt.Canvas(SizeKt.m15899size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$3
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
                                ProgressIndicatorKt.m17276drawIndeterminateCircularIndicatorhrjfTZI(Canvas, stateAnimateFloat3.getValue().floatValue() + stateAnimateFloat.getValue().floatValue() + (((stateAnimateValue.getValue().floatValue() * 216.0f) % 360.0f) - 90.0f), f6, Math.abs(stateAnimateFloat2.getValue().floatValue() - stateAnimateFloat3.getValue().floatValue()), j3, stroke);
                            }
                        }, composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f5 = f6;
                        j5 = j3;
                    } else {
                        j3 = circularColor;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = j2;
                }
                fM17265getCircularStrokeWidthD9Ej5fM = f4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Stroke stroke2 = new Stroke(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(fM17265getCircularStrokeWidthD9Ej5fM), 0.0f, StrokeCap.INSTANCE.m18880getSquareKaPHkGw(), 0, null, 26, null);
                InfiniteTransition infiniteTransitionRememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition(composerStartRestartGroup, 0);
                TwoWayConverter<Integer, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
                InfiniteRepeatableSpec infiniteRepeatableSpecM15313infiniteRepeatable9IiC70o$default2 = AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null);
                int i82 = InfiniteTransition.$stable;
                int i92 = InfiniteRepeatableSpec.$stable;
                final State<Integer> stateAnimateValue2 = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition2, 0, 5, vectorConverter2, infiniteRepeatableSpecM15313infiniteRepeatable9IiC70o$default2, composerStartRestartGroup, (i92 << 12) | i82 | 4528);
                composerStartRestartGroup = composerStartRestartGroup;
                final State<Float> stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, BaseRotationAngle, AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), composerStartRestartGroup, i82 | 432 | (i92 << 9));
                final State<Float> stateAnimateFloat22 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, JumpRotationAngle, AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$endAngle$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        invoke2(keyframesSpecConfig);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                        Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                        keyframes.setDurationMillis(1332);
                        keyframes.with(keyframes.mo1191at(Float.valueOf(0.0f), 0), ProgressIndicatorKt.CircularEasing);
                        keyframes.mo1191at(Float.valueOf(290.0f), PermissionCode.PERMISSION_REQUEST_WRITING_TOOLKIT);
                    }
                }), null, 0L, 6, null), composerStartRestartGroup, i82 | 432 | (i92 << 9));
                final State<Float> stateAnimateFloat32 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, JumpRotationAngle, AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$startAngle$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        invoke2(keyframesSpecConfig);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                        Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                        keyframes.setDurationMillis(1332);
                        keyframes.with(keyframes.mo1191at(Float.valueOf(0.0f), PermissionCode.PERMISSION_REQUEST_WRITING_TOOLKIT), ProgressIndicatorKt.CircularEasing);
                        keyframes.mo1191at(Float.valueOf(290.0f), keyframes.getDurationMillis());
                    }
                }), null, 0L, 6, null), composerStartRestartGroup, i82 | 432 | (i92 << 9));
                final float f62 = fM17265getCircularStrokeWidthD9Ej5fM;
                CanvasKt.Canvas(SizeKt.m15899size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$3
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
                        ProgressIndicatorKt.m17276drawIndeterminateCircularIndicatorhrjfTZI(Canvas, stateAnimateFloat32.getValue().floatValue() + stateAnimateFloat4.getValue().floatValue() + (((stateAnimateValue2.getValue().floatValue() * 216.0f) % 360.0f) - 90.0f), f62, Math.abs(stateAnimateFloat22.getValue().floatValue() - stateAnimateFloat32.getValue().floatValue()), j3, stroke2);
                    }
                }, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                f5 = f62;
                j5 = j3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j5 = j2;
                f5 = f4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i10) {
                    ProgressIndicatorKt.m17267CircularProgressIndicatoraMcp0Q(modifier3, j5, f5, composer2, i | 1, i2);
                }
            });
            return;
        }
        i4 |= 384;
        f4 = f;
        if ((i4 & 731) == 146) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 == 0) {
                }
                if ((i2 & 2) == 0) {
                }
                if (i7 == 0) {
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c1 A[LOOP:0: B:61:0x01bf->B:62:0x01c1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01f2  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: LinearProgressIndicator-RIQooxk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17268LinearProgressIndicatorRIQooxk(@Nullable Modifier modifier, long j, long j2, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        long j3;
        long j5;
        Modifier modifier3;
        final long j6;
        final long linearTrackColor;
        final State stateAnimateFloat;
        final State stateAnimateFloat2;
        final State stateAnimateFloat3;
        final State stateAnimateFloat4;
        int i5;
        boolean zChanged;
        Object objRememberedValue;
        final Modifier modifier4;
        Composer composer2;
        final long j7;
        final long j8;
        Composer composerStartRestartGroup = composer.startRestartGroup(585576195);
        int i6 = i2 & 1;
        if (i6 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i & 112) == 0) {
            j3 = j;
            i4 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(j3)) ? 32 : 16;
        } else {
            j3 = j;
        }
        if ((i & 896) == 0) {
            j5 = j2;
            i4 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(j5)) ? 256 : 128;
        } else {
            j5 = j2;
        }
        if ((i4 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
            modifier4 = modifier2;
            j8 = j3;
            j7 = j5;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                modifier3 = i6 != 0 ? Modifier.INSTANCE : modifier2;
                long linearColor = (i2 & 2) != 0 ? ProgressIndicatorDefaults.INSTANCE.getLinearColor(composerStartRestartGroup, 6) : j3;
                if ((i2 & 4) != 0) {
                    j6 = linearColor;
                    linearTrackColor = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(composerStartRestartGroup, 6);
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(585576195, i, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:103)");
                    }
                    InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(composerStartRestartGroup, 0);
                    InfiniteRepeatableSpec infiniteRepeatableSpecM15313infiniteRepeatable9IiC70o$default = AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            invoke2(keyframesSpecConfig);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                            Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                            keyframes.setDurationMillis(1800);
                            keyframes.with(keyframes.mo1191at(Float.valueOf(0.0f), 0), ProgressIndicatorKt.FirstLineHeadEasing);
                            keyframes.mo1191at(Float.valueOf(1.0f), 750);
                        }
                    }), null, 0L, 6, null);
                    int i7 = InfiniteTransition.$stable;
                    int i8 = InfiniteRepeatableSpec.$stable;
                    stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, infiniteRepeatableSpecM15313infiniteRepeatable9IiC70o$default, composerStartRestartGroup, i7 | 432 | (i8 << 9));
                    stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            invoke2(keyframesSpecConfig);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                            Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                            keyframes.setDurationMillis(1800);
                            keyframes.with(keyframes.mo1191at(Float.valueOf(0.0f), 333), ProgressIndicatorKt.FirstLineTailEasing);
                            keyframes.mo1191at(Float.valueOf(1.0f), 1183);
                        }
                    }), null, 0L, 6, null), composerStartRestartGroup, i7 | 432 | (i8 << 9));
                    stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            invoke2(keyframesSpecConfig);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                            Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                            keyframes.setDurationMillis(1800);
                            keyframes.with(keyframes.mo1191at(Float.valueOf(0.0f), 1000), ProgressIndicatorKt.SecondLineHeadEasing);
                            keyframes.mo1191at(Float.valueOf(1.0f), 1567);
                        }
                    }), null, 0L, 6, null), composerStartRestartGroup, i7 | 432 | (i8 << 9));
                    stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            invoke2(keyframesSpecConfig);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                            Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                            keyframes.setDurationMillis(1800);
                            keyframes.with(keyframes.mo1191at(Float.valueOf(0.0f), 1267), ProgressIndicatorKt.SecondLineTailEasing);
                            keyframes.mo1191at(Float.valueOf(1.0f), 1800);
                        }
                    }), null, 0L, 6, null), composerStartRestartGroup, i7 | 432 | (i8 << 9));
                    Modifier modifierM15901sizeVpY3zN4 = SizeKt.m15901sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(modifier3), LinearIndicatorWidth, LinearIndicatorHeight);
                    Object[] objArr = {Color.m18515boximpl(linearTrackColor), stateAnimateFloat, stateAnimateFloat2, Color.m18515boximpl(j6), stateAnimateFloat3, stateAnimateFloat4};
                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                    i5 = 0;
                    zChanged = false;
                    for (int i9 = 6; i5 < i9; i9 = 6) {
                        zChanged |= composerStartRestartGroup.changed(objArr[i5]);
                        i5++;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        Function1<DrawScope, Unit> function1 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$3$1
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
                                DrawScope drawScope;
                                Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                                float fM18350getHeightimpl = Size.m18350getHeightimpl(Canvas.mo19076getSizeNHjbRc());
                                ProgressIndicatorKt.m17278drawLinearIndicatorTrackbw27NRU(Canvas, linearTrackColor, fM18350getHeightimpl);
                                if (stateAnimateFloat.getValue().floatValue() - stateAnimateFloat2.getValue().floatValue() > 0.0f) {
                                    drawScope = Canvas;
                                    ProgressIndicatorKt.m17277drawLinearIndicator42QJj7c(drawScope, stateAnimateFloat.getValue().floatValue(), stateAnimateFloat2.getValue().floatValue(), j6, fM18350getHeightimpl);
                                } else {
                                    drawScope = Canvas;
                                }
                                if (stateAnimateFloat3.getValue().floatValue() - stateAnimateFloat4.getValue().floatValue() > 0.0f) {
                                    ProgressIndicatorKt.m17277drawLinearIndicator42QJj7c(drawScope, stateAnimateFloat3.getValue().floatValue(), stateAnimateFloat4.getValue().floatValue(), j6, fM18350getHeightimpl);
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function1);
                        objRememberedValue = function1;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(modifierM15901sizeVpY3zN4, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    composer2 = composerStartRestartGroup;
                    j7 = linearTrackColor;
                    j8 = j6;
                } else {
                    j6 = linearColor;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j6 = j3;
            }
            linearTrackColor = j5;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            InfiniteTransition infiniteTransitionRememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition(composerStartRestartGroup, 0);
            InfiniteRepeatableSpec infiniteRepeatableSpecM15313infiniteRepeatable9IiC70o$default2 = AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1800);
                    keyframes.with(keyframes.mo1191at(Float.valueOf(0.0f), 0), ProgressIndicatorKt.FirstLineHeadEasing);
                    keyframes.mo1191at(Float.valueOf(1.0f), 750);
                }
            }), null, 0L, 6, null);
            int i72 = InfiniteTransition.$stable;
            int i82 = InfiniteRepeatableSpec.$stable;
            stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, infiniteRepeatableSpecM15313infiniteRepeatable9IiC70o$default2, composerStartRestartGroup, i72 | 432 | (i82 << 9));
            stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1800);
                    keyframes.with(keyframes.mo1191at(Float.valueOf(0.0f), 333), ProgressIndicatorKt.FirstLineTailEasing);
                    keyframes.mo1191at(Float.valueOf(1.0f), 1183);
                }
            }), null, 0L, 6, null), composerStartRestartGroup, i72 | 432 | (i82 << 9));
            stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1800);
                    keyframes.with(keyframes.mo1191at(Float.valueOf(0.0f), 1000), ProgressIndicatorKt.SecondLineHeadEasing);
                    keyframes.mo1191at(Float.valueOf(1.0f), 1567);
                }
            }), null, 0L, 6, null), composerStartRestartGroup, i72 | 432 | (i82 << 9));
            stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1800);
                    keyframes.with(keyframes.mo1191at(Float.valueOf(0.0f), 1267), ProgressIndicatorKt.SecondLineTailEasing);
                    keyframes.mo1191at(Float.valueOf(1.0f), 1800);
                }
            }), null, 0L, 6, null), composerStartRestartGroup, i72 | 432 | (i82 << 9));
            Modifier modifierM15901sizeVpY3zN42 = SizeKt.m15901sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(modifier3), LinearIndicatorWidth, LinearIndicatorHeight);
            Object[] objArr2 = {Color.m18515boximpl(linearTrackColor), stateAnimateFloat, stateAnimateFloat2, Color.m18515boximpl(j6), stateAnimateFloat3, stateAnimateFloat4};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            i5 = 0;
            zChanged = false;
            while (i5 < i9) {
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                Function1<DrawScope, Unit> function12 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$3$1
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
                        DrawScope drawScope;
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        float fM18350getHeightimpl = Size.m18350getHeightimpl(Canvas.mo19076getSizeNHjbRc());
                        ProgressIndicatorKt.m17278drawLinearIndicatorTrackbw27NRU(Canvas, linearTrackColor, fM18350getHeightimpl);
                        if (stateAnimateFloat.getValue().floatValue() - stateAnimateFloat2.getValue().floatValue() > 0.0f) {
                            drawScope = Canvas;
                            ProgressIndicatorKt.m17277drawLinearIndicator42QJj7c(drawScope, stateAnimateFloat.getValue().floatValue(), stateAnimateFloat2.getValue().floatValue(), j6, fM18350getHeightimpl);
                        } else {
                            drawScope = Canvas;
                        }
                        if (stateAnimateFloat3.getValue().floatValue() - stateAnimateFloat4.getValue().floatValue() > 0.0f) {
                            ProgressIndicatorKt.m17277drawLinearIndicator42QJj7c(drawScope, stateAnimateFloat3.getValue().floatValue(), stateAnimateFloat4.getValue().floatValue(), j6, fM18350getHeightimpl);
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function12);
                objRememberedValue = function12;
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM15901sizeVpY3zN42, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                composer2 = composerStartRestartGroup;
                j7 = linearTrackColor;
                j8 = j6;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer3, int i10) {
                ProgressIndicatorKt.m17268LinearProgressIndicatorRIQooxk(modifier4, j8, j7, composer3, i | 1, i2);
            }
        });
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    public static final void m17269LinearProgressIndicatoreaDK9VM(final float f, @Nullable Modifier modifier, long j, long j2, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        long linearColor;
        long linearTrackColor;
        Modifier modifier2;
        final Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-372717133);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            linearColor = j;
            i4 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(linearColor)) ? 256 : 128;
        } else {
            linearColor = j;
        }
        if ((i & 7168) == 0) {
            linearTrackColor = j2;
            i4 |= ((i2 & 8) == 0 && composerStartRestartGroup.changed(linearTrackColor)) ? 2048 : 1024;
        } else {
            linearTrackColor = j2;
        }
        if ((i4 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                modifier2 = i5 != 0 ? Modifier.INSTANCE : modifier;
                if ((i2 & 4) != 0) {
                    linearColor = ProgressIndicatorDefaults.INSTANCE.getLinearColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i2 & 8) != 0) {
                    i4 &= -7169;
                    linearTrackColor = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(composerStartRestartGroup, 6);
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i4 &= -897;
                }
                if ((i2 & 8) != 0) {
                    i4 &= -7169;
                }
                modifier2 = modifier;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-372717133, i4, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:71)");
            }
            Modifier modifierM15901sizeVpY3zN4 = SizeKt.m15901sizeVpY3zN4(ProgressSemanticsKt.progressSemantics$default(modifier2, f, null, 0, 6, null), LinearIndicatorWidth, LinearIndicatorHeight);
            Color colorM18515boximpl = Color.m18515boximpl(linearTrackColor);
            Float fValueOf = Float.valueOf(f);
            Color colorM18515boximpl2 = Color.m18515boximpl(linearColor);
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            boolean zChanged = composerStartRestartGroup.changed(colorM18515boximpl) | composerStartRestartGroup.changed(fValueOf) | composerStartRestartGroup.changed(colorM18515boximpl2);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                final long j3 = linearColor;
                final long j5 = linearTrackColor;
                objRememberedValue = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1$1
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
                        float fM18350getHeightimpl = Size.m18350getHeightimpl(Canvas.mo19076getSizeNHjbRc());
                        ProgressIndicatorKt.m17278drawLinearIndicatorTrackbw27NRU(Canvas, j5, fM18350getHeightimpl);
                        ProgressIndicatorKt.m17277drawLinearIndicator42QJj7c(Canvas, 0.0f, f, j3, fM18350getHeightimpl);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierM15901sizeVpY3zN4, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
        }
        final long j6 = linearColor;
        final long j7 = linearTrackColor;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i6) {
                ProgressIndicatorKt.m17269LinearProgressIndicatoreaDK9VM(f, modifier3, j6, j7, composer2, i | 1, i2);
            }
        });
    }

    /* JADX INFO: renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m17274drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f4, long j, Stroke stroke) {
        float f5 = 2;
        float width = stroke.getWidth() / f5;
        float fM18353getWidthimpl = Size.m18353getWidthimpl(drawScope.mo19076getSizeNHjbRc()) - (f5 * width);
        DrawScope.m19055drawArcyD3GUKo$default(drawScope, j, f, f4, false, OffsetKt.Offset(width, width), androidx.compose.p109ui.geometry.SizeKt.Size(fM18353getWidthimpl, fM18353getWidthimpl), 0.0f, stroke, null, 0, 832, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m17275drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f, float f4, long j, Stroke stroke) {
        m17274drawCircularIndicator42QJj7c(drawScope, f, f4, j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    public static final void m17276drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f, float f4, float f5, long j, Stroke stroke) {
        m17274drawCircularIndicator42QJj7c(drawScope, (((f4 / C2256Dp.m20968constructorimpl(CircularIndicatorDiameter / 2)) * 57.29578f) / 2.0f) + f, Math.max(f5, 0.1f), j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawLinearIndicator-42QJj7c, reason: not valid java name */
    public static final void m17277drawLinearIndicator42QJj7c(DrawScope drawScope, float f, float f4, long j, float f5) {
        float fM18353getWidthimpl = Size.m18353getWidthimpl(drawScope.mo19076getSizeNHjbRc());
        float fM18350getHeightimpl = Size.m18350getHeightimpl(drawScope.mo19076getSizeNHjbRc()) / 2;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Ltr;
        DrawScope.m19062drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset((z ? f : 1.0f - f4) * fM18353getWidthimpl, fM18350getHeightimpl), OffsetKt.Offset((z ? f4 : 1.0f - f) * fM18353getWidthimpl, fM18350getHeightimpl), f5, 0, null, 0.0f, null, 0, 496, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawLinearIndicatorTrack-bw27NRU, reason: not valid java name */
    public static final void m17278drawLinearIndicatorTrackbw27NRU(DrawScope drawScope, long j, float f) {
        m17277drawLinearIndicator42QJj7c(drawScope, 0.0f, 1.0f, j, f);
    }

    public static final float getCircularIndicatorDiameter() {
        return CircularIndicatorDiameter;
    }

    public static final float getLinearIndicatorHeight() {
        return LinearIndicatorHeight;
    }

    public static final float getLinearIndicatorWidth() {
        return LinearIndicatorWidth;
    }
}
