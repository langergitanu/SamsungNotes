package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.UiComposable;
import androidx.compose.p109ui.ZIndexModifierKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p109ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.p109ui.graphics.RectangleShapeKt;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.graphics.TransformOrigin;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.layout.SubcomposeLayoutKt;
import androidx.compose.p109ui.layout.SubcomposeMeasureScope;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntOffsetKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0003¢\u0006\u0002\u0010\u000b\u001aõ\u0001\u0010\f\u001a\u00020\u00042\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u001a2\b\b\u0002\u0010!\u001a\u00020\u001a2\u0019\b\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040#¢\u0006\u0002\b\tH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001ah\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t¢\u0006\u0002\b)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0#2\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0002\b\t¢\u0006\u0002\b)H\u0003ø\u0001\u0000¢\u0006\u0002\u0010/\u001a3\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u001a2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u00103\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aE\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u00062\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020.092\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140#2\b\b\u0002\u0010;\u001a\u00020$H\u0007¢\u0006\u0002\u0010<\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006="}, m13886d2 = {"AnimationSlideOffset", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "BackLayerTransition", "", "target", "Landroidx/compose/material/BackdropValue;", "appBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/material/BackdropValue;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BackdropScaffold", "backLayerContent", "frontLayerContent", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BackdropScaffoldState;", "gesturesEnabled", "", "peekHeight", "headerHeight", "persistentAppBar", "stickyFrontLayer", "backLayerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "backLayerContentColor", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "frontLayerElevation", "frontLayerBackgroundColor", "frontLayerContentColor", "frontLayerScrimColor", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "BackdropScaffold-BZszfkY", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BackdropScaffoldState;ZFFZZJJLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BackdropStack", "backLayer", "Landroidx/compose/ui/UiComposable;", "calculateBackLayerConstraints", "Landroidx/compose/ui/unit/Constraints;", "frontLayer", "Lkotlin/Function2;", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberBackdropScaffoldState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "snackbarHostState", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BackdropScaffoldState;", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = C2256Dp.m20968constructorimpl(20);

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void BackLayerTransition(final BackdropValue backdropValue, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-950970976);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(backdropValue) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(function22) ? 256 : 128;
        }
        int i4 = i2;
        if ((i4 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-950970976, i4, -1, "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:414)");
            }
            State stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(backdropValue == BackdropValue.Revealed ? 0.0f : 2.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, composerStartRestartGroup, 0, 12);
            float fMo15546toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(AnimationSlideOffset);
            float f = 1;
            float fCoerceIn = RangesKt.coerceIn(m16594BackLayerTransition$lambda7(stateAnimateFloatAsState) - f, 0.0f, 1.0f);
            float fCoerceIn2 = RangesKt.coerceIn(f - m16594BackLayerTransition$lambda7(stateAnimateFloatAsState), 0.0f, 1.0f);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Modifier.Companion companion = Modifier.INSTANCE;
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composerStartRestartGroup, 0, -1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
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
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(2065804710);
            Modifier modifierM18687graphicsLayerpANQ8Wg = GraphicsLayerModifierKt.m18687graphicsLayerpANQ8Wg(ZIndexModifierKt.zIndex(companion, fCoerceIn), (65528 & 1) != 0 ? 1.0f : 0.0f, (65528 & 2) != 0 ? 1.0f : 0.0f, (65528 & 4) == 0 ? fCoerceIn : 1.0f, (65528 & 8) != 0 ? 0.0f : 0.0f, (65528 & 16) != 0 ? 0.0f : (f - fCoerceIn) * fMo15546toPx0680j_4, (65528 & 32) != 0 ? 0.0f : 0.0f, (65528 & 64) != 0 ? 0.0f : 0.0f, (65528 & 128) != 0 ? 0.0f : 0.0f, (65528 & 256) == 0 ? 0.0f : 0.0f, (65528 & 512) != 0 ? 8.0f : 0.0f, (65528 & 1024) != 0 ? TransformOrigin.INSTANCE.m18916getCenterSzJe1aQ() : 0L, (65528 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : null, (65528 & 4096) != 0 ? false : false, (65528 & 8192) != 0 ? null : null, (65528 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (65528 & 32768) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion2, false, composerStartRestartGroup, 0, -1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM18687graphicsLayerpANQ8Wg);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1210k2, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, -1057690836);
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 3) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierM18687graphicsLayerpANQ8Wg2 = GraphicsLayerModifierKt.m18687graphicsLayerpANQ8Wg(ZIndexModifierKt.zIndex(companion, fCoerceIn2), (65528 & 1) != 0 ? 1.0f : 0.0f, (65528 & 2) != 0 ? 1.0f : 0.0f, (65528 & 4) == 0 ? fCoerceIn2 : 1.0f, (65528 & 8) != 0 ? 0.0f : 0.0f, (65528 & 16) != 0 ? 0.0f : (f - fCoerceIn2) * (-fMo15546toPx0680j_4), (65528 & 32) != 0 ? 0.0f : 0.0f, (65528 & 64) != 0 ? 0.0f : 0.0f, (65528 & 128) != 0 ? 0.0f : 0.0f, (65528 & 256) == 0 ? 0.0f : 0.0f, (65528 & 512) != 0 ? 8.0f : 0.0f, (65528 & 1024) != 0 ? TransformOrigin.INSTANCE.m18916getCenterSzJe1aQ() : 0L, (65528 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : null, (65528 & 4096) != 0 ? false : false, (65528 & 8192) != 0 ? null : null, (65528 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (65528 & 32768) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k3 = AbstractC1038a.m1210k(companion2, false, composerStartRestartGroup, 0, -1323940314);
            Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM18687graphicsLayerpANQ8Wg2);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl3, measurePolicyM1210k3, composerM18018constructorimpl3, density3));
            function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, -676544093);
            function22.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 6) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackLayerTransition.2
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

            public final void invoke(@Nullable Composer composer2, int i5) {
                BackdropScaffoldKt.BackLayerTransition(backdropValue, function2, function22, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: renamed from: BackLayerTransition$lambda-7, reason: not valid java name */
    private static final float m16594BackLayerTransition$lambda7(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x04d8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0142  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: BackdropScaffold-BZszfkY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16595BackdropScaffoldBZszfkY(@NotNull final Function2<? super Composer, ? super Integer, Unit> appBar, @NotNull final Function2<? super Composer, ? super Integer, Unit> backLayerContent, @NotNull final Function2<? super Composer, ? super Integer, Unit> frontLayerContent, @Nullable Modifier modifier, @Nullable BackdropScaffoldState backdropScaffoldState, boolean z, float f, float f4, boolean z2, boolean z3, long j, long j2, @Nullable Shape shape, float f5, long j3, long j5, long j6, @Nullable Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        int i6;
        boolean z4;
        int i7;
        float f6;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Shape shape2;
        int i15;
        int i16;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32;
        int i17;
        int i18;
        int i19;
        Composer composer2;
        int i20;
        final BackdropScaffoldState backdropScaffoldStateRememberBackdropScaffoldState;
        float fM16593getPeekHeightD9Ej5fM;
        boolean z5;
        long jM16676getPrimary0d7_KjU;
        long jM16694contentColorForek8zF_U;
        Shape frontLayerShape;
        float f7;
        long jM16680getSurface0d7_KjU;
        long jM16694contentColorForek8zF_U2;
        long j7;
        long frontLayerScrimColor;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3M16700getLambda1$material_release;
        final boolean z6;
        int i21;
        long j8;
        int i22;
        final float f8;
        final long j9;
        float f9;
        final boolean z7;
        Modifier modifier2;
        long j10;
        long j11;
        final float fMo15546toPx0680j_4;
        boolean zChanged;
        Object objRememberedValue;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function33;
        final long j12;
        final long j13;
        final long j14;
        final Modifier modifier3;
        Composer composer3;
        final float f10;
        final float f11;
        final boolean z8;
        final Shape shape3;
        final boolean z9;
        final BackdropScaffoldState backdropScaffoldState2;
        final float f12;
        final long j15;
        final long j16;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(appBar, "appBar");
        Intrinsics.checkNotNullParameter(backLayerContent, "backLayerContent");
        Intrinsics.checkNotNullParameter(frontLayerContent, "frontLayerContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(1397420093);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(appBar) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(backLayerContent) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(frontLayerContent) ? 256 : 128;
        }
        int i23 = i4 & 8;
        if (i23 != 0) {
            i5 |= 3072;
        } else {
            if ((i & 7168) == 0) {
                i5 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
            }
            int i24 = 8192;
            if ((i & 57344) == 0) {
                i5 |= ((i4 & 16) == 0 && composerStartRestartGroup.changed(backdropScaffoldState)) ? 16384 : 8192;
            }
            i6 = i4 & 32;
            if (i6 == 0) {
                i5 |= 196608;
                z4 = z;
            } else {
                z4 = z;
                if ((i & 458752) == 0) {
                    i5 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
                }
            }
            i7 = i4 & 64;
            if (i7 == 0) {
                i5 |= 1572864;
                f6 = f;
            } else {
                f6 = f;
                if ((i & 3670016) == 0) {
                    i5 |= composerStartRestartGroup.changed(f6) ? 1048576 : 524288;
                }
            }
            i8 = i4 & 128;
            if (i8 == 0) {
                i5 |= 12582912;
            } else if ((i & 29360128) == 0) {
                i5 |= composerStartRestartGroup.changed(f4) ? 8388608 : 4194304;
            }
            i9 = i4 & 256;
            if (i9 == 0) {
                i5 |= 100663296;
            } else {
                if ((i & 234881024) == 0) {
                    i10 = i9;
                    i5 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
                }
                i11 = i4 & 512;
                if (i11 != 0) {
                    i13 = i5 | DriveFile.MODE_READ_WRITE;
                    i12 = i11;
                } else {
                    if ((i & 1879048192) == 0) {
                        i12 = i11;
                        i5 |= composerStartRestartGroup.changed(z3) ? 536870912 : 268435456;
                    } else {
                        i12 = i11;
                    }
                    i13 = i5;
                }
                if ((i2 & 14) == 0) {
                    i14 = i2 | (((i4 & 1024) == 0 && composerStartRestartGroup.changed(j)) ? 4 : 2);
                } else {
                    i14 = i2;
                }
                if ((i2 & 112) == 0) {
                    i14 |= ((i4 & 2048) == 0 && composerStartRestartGroup.changed(j2)) ? 32 : 16;
                }
                if ((i2 & 896) == 0) {
                    if ((i4 & 4096) == 0) {
                        shape2 = shape;
                        int i25 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                        i14 |= i25;
                    } else {
                        shape2 = shape;
                    }
                    i14 |= i25;
                } else {
                    shape2 = shape;
                }
                i15 = i4 & 8192;
                if (i15 == 0) {
                    if ((i2 & 7168) == 0) {
                        i14 |= composerStartRestartGroup.changed(f5) ? 2048 : 1024;
                    }
                    if ((i2 & 57344) == 0) {
                        if ((i4 & 16384) == 0 && composerStartRestartGroup.changed(j3)) {
                            i24 = 16384;
                        }
                        i14 |= i24;
                    }
                    if ((458752 & i2) == 0) {
                        i14 |= ((i4 & 32768) == 0 && composerStartRestartGroup.changed(j5)) ? 131072 : 65536;
                    }
                    if ((3670016 & i2) == 0) {
                        i14 |= ((i4 & 65536) == 0 && composerStartRestartGroup.changed(j6)) ? 1048576 : 524288;
                    }
                    i16 = i4 & 131072;
                    if (i16 == 0) {
                        i14 |= 12582912;
                        function32 = function3;
                    } else {
                        function32 = function3;
                        if ((i2 & 29360128) == 0) {
                            i14 |= composerStartRestartGroup.changed(function32) ? 8388608 : 4194304;
                        }
                    }
                    i17 = i14;
                    if ((i13 & 1533916891) != 306783378 && (i17 & 23967451) == 4793490 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        backdropScaffoldState2 = backdropScaffoldState;
                        z8 = z2;
                        z9 = z3;
                        f10 = f5;
                        j15 = j3;
                        j13 = j5;
                        j12 = j6;
                        function33 = function32;
                        composer3 = composerStartRestartGroup;
                        z7 = z4;
                        f12 = f6;
                        f11 = f4;
                        j14 = j2;
                        shape3 = shape2;
                        j16 = j;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier4 = i23 == 0 ? Modifier.INSTANCE : modifier;
                            if ((i4 & 16) == 0) {
                                i20 = i15;
                                i18 = i16;
                                i19 = 6;
                                backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                                composer2 = composerStartRestartGroup;
                                i13 &= -57345;
                            } else {
                                i18 = i16;
                                i19 = 6;
                                composer2 = composerStartRestartGroup;
                                i20 = i15;
                                backdropScaffoldStateRememberBackdropScaffoldState = backdropScaffoldState;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            fM16593getPeekHeightD9Ej5fM = i7 == 0 ? BackdropScaffoldDefaults.INSTANCE.m16593getPeekHeightD9Ej5fM() : f6;
                            float fM16592getHeaderHeightD9Ej5fM = i8 == 0 ? BackdropScaffoldDefaults.INSTANCE.m16592getHeaderHeightD9Ej5fM() : f4;
                            z5 = i10 == 0 ? true : z2;
                            boolean z10 = i12 == 0 ? true : z3;
                            if ((i4 & 1024) == 0) {
                                jM16676getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composer2, i19).m16676getPrimary0d7_KjU();
                                i17 &= -15;
                            } else {
                                jM16676getPrimary0d7_KjU = j;
                            }
                            if ((i4 & 2048) == 0) {
                                jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16676getPrimary0d7_KjU, composer2, i17 & 14);
                                i17 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                            } else {
                                jM16694contentColorForek8zF_U = j2;
                            }
                            int i26 = i17;
                            if ((i4 & 4096) == 0) {
                                frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composer2, 6);
                                i26 &= -897;
                            } else {
                                frontLayerShape = shape;
                            }
                            float fM16591getFrontLayerElevationD9Ej5fM = i20 == 0 ? BackdropScaffoldDefaults.INSTANCE.m16591getFrontLayerElevationD9Ej5fM() : f5;
                            Shape shape4 = frontLayerShape;
                            if ((i4 & 16384) == 0) {
                                f7 = fM16591getFrontLayerElevationD9Ej5fM;
                                jM16680getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composer2, 6).m16680getSurface0d7_KjU();
                                i26 &= -57345;
                            } else {
                                f7 = fM16591getFrontLayerElevationD9Ej5fM;
                                jM16680getSurface0d7_KjU = j3;
                            }
                            if ((i4 & 32768) == 0) {
                                jM16694contentColorForek8zF_U2 = ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composer2, (i26 >> 12) & 14);
                                i26 &= -458753;
                            } else {
                                jM16694contentColorForek8zF_U2 = j5;
                            }
                            if ((i4 & 65536) == 0) {
                                j7 = jM16680getSurface0d7_KjU;
                                frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composer2, 6);
                                i26 &= -3670017;
                            } else {
                                j7 = jM16680getSurface0d7_KjU;
                                frontLayerScrimColor = j6;
                            }
                            if (i18 == 0) {
                                z6 = z10;
                                i21 = i26;
                                function3M16700getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m16700getLambda1$material_release();
                            } else {
                                function3M16700getLambda1$material_release = function3;
                                z6 = z10;
                                i21 = i26;
                            }
                            j8 = jM16694contentColorForek8zF_U;
                            i22 = i13;
                            f8 = f7;
                            j9 = frontLayerScrimColor;
                            f9 = fM16592getHeaderHeightD9Ej5fM;
                            z7 = z4;
                            modifier2 = modifier4;
                            long j17 = jM16676getPrimary0d7_KjU;
                            shape2 = shape4;
                            j10 = j7;
                            j11 = j17;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 16) != 0) {
                                i13 &= -57345;
                            }
                            if ((i4 & 1024) != 0) {
                                i17 &= -15;
                            }
                            if ((i4 & 2048) != 0) {
                                i17 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                            }
                            int i27 = i17;
                            if ((i4 & 4096) != 0) {
                                i27 &= -897;
                            }
                            if ((i4 & 16384) != 0) {
                                i27 &= -57345;
                            }
                            if ((i4 & 32768) != 0) {
                                i27 &= -458753;
                            }
                            if ((i4 & 65536) != 0) {
                                i27 &= -3670017;
                            }
                            modifier2 = modifier;
                            backdropScaffoldStateRememberBackdropScaffoldState = backdropScaffoldState;
                            f9 = f4;
                            z5 = z2;
                            z6 = z3;
                            j11 = j;
                            j8 = j2;
                            jM16694contentColorForek8zF_U2 = j5;
                            j9 = j6;
                            function3M16700getLambda1$material_release = function3;
                            composer2 = composerStartRestartGroup;
                            z7 = z4;
                            fM16593getPeekHeightD9Ej5fM = f6;
                            f8 = f5;
                            j10 = j3;
                            i21 = i27;
                            i22 = i13;
                        }
                        composer2.endDefaults();
                        final Modifier modifier5 = modifier2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1397420093, i22, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
                        }
                        final float fMo15546toPx0680j_42 = ((Density) composer2.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(fM16593getPeekHeightD9Ej5fM);
                        fMo15546toPx0680j_4 = ((Density) composer2.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(f9);
                        final int i28 = i22;
                        final BackdropScaffoldState backdropScaffoldState3 = backdropScaffoldStateRememberBackdropScaffoldState;
                        final boolean z11 = z5;
                        final float f13 = fM16593getPeekHeightD9Ej5fM;
                        final ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, 1744778315, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1
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
                            public final void invoke(@Nullable Composer composer4, int i29) {
                                if ((i29 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1744778315, i29, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:278)");
                                }
                                if (z11) {
                                    composer4.startReplaceableGroup(-1017265331);
                                    Function2<Composer, Integer, Unit> function2 = appBar;
                                    int i30 = i28;
                                    Function2<Composer, Integer, Unit> function22 = backLayerContent;
                                    composer4.startReplaceableGroup(-483455358);
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer4, 0, -1323940314);
                                    Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
                                    if (composer4.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor);
                                    } else {
                                        composer4.useNode();
                                    }
                                    composer4.disableReusing();
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer4);
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                    composer4.startReplaceableGroup(-1163856341);
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    composer4.startReplaceableGroup(-18835878);
                                    function2.invoke(composer4, Integer.valueOf(i30 & 14));
                                    function22.invoke(composer4, Integer.valueOf((i30 >> 3) & 14));
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                } else {
                                    composer4.startReplaceableGroup(-1017265219);
                                    BackdropValue targetValue = backdropScaffoldState3.getTargetValue();
                                    Function2<Composer, Integer, Unit> function23 = appBar;
                                    Function2<Composer, Integer, Unit> function24 = backLayerContent;
                                    int i31 = i28;
                                    BackdropScaffoldKt.BackLayerTransition(targetValue, function23, function24, composer4, ((i31 << 3) & 896) | ((i31 << 3) & 112));
                                    composer4.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        Float fValueOf = Float.valueOf(fMo15546toPx0680j_4);
                        composer2.startReplaceableGroup(1157296644);
                        zChanged = composer2.changed(fValueOf);
                        objRememberedValue = composer2.rememberedValue();
                        if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1<Constraints, Constraints>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Constraints invoke(Constraints constraints) {
                                    return Constraints.m20909boximpl(m16602invokeZezNO4M(constraints.getValue()));
                                }

                                /* JADX INFO: renamed from: invoke-ZezNO4M, reason: not valid java name */
                                public final long m16602invokeZezNO4M(long j18) {
                                    return ConstraintsKt.m20941offsetNN6EwU$default(Constraints.m20912copyZbe2FdA$default(j18, 0, 0, 0, 0, 10, null), 0, -MathKt.roundToInt(fMo15546toPx0680j_4), 1, null);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        final Function1 function1 = (Function1) objRememberedValue;
                        final Shape shape5 = shape2;
                        final float f14 = f9;
                        final long j18 = jM16694contentColorForek8zF_U2;
                        final int i29 = i21;
                        final long j19 = j10;
                        Composer composer4 = composer2;
                        int i30 = i29 << 6;
                        long j20 = j11;
                        long j21 = j8;
                        SurfaceKt.m16872SurfaceFjzlyU(null, null, j20, j21, null, 0.0f, ComposableLambdaKt.composableLambda(composer4, -1049909631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                invoke(composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer5, int i31) {
                                if ((i31 & 11) == 2 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1049909631, i31, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:296)");
                                }
                                composer5.startReplaceableGroup(773894976);
                                composer5.startReplaceableGroup(-492369756);
                                Object objRememberedValue2 = composer5.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer5), composer5);
                                }
                                composer5.endReplaceableGroup();
                                final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                                composer5.endReplaceableGroup();
                                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier5, 0.0f, 1, null);
                                Function2<Composer, Integer, Unit> function2 = composableLambda;
                                Function1<Constraints, Constraints> function12 = function1;
                                final float f15 = fMo15546toPx0680j_4;
                                final boolean z12 = z6;
                                final boolean z13 = z7;
                                final BackdropScaffoldState backdropScaffoldState4 = backdropScaffoldStateRememberBackdropScaffoldState;
                                final float f16 = fMo15546toPx0680j_42;
                                final int i32 = i28;
                                final Shape shape6 = shape5;
                                final long j22 = j19;
                                final long j23 = j18;
                                final float f17 = f8;
                                final int i33 = i29;
                                final float f18 = f14;
                                final float f19 = f13;
                                final Function2<Composer, Integer, Unit> function22 = frontLayerContent;
                                final long j24 = j9;
                                final Function3<SnackbarHostState, Composer, Integer, Unit> function34 = function3M16700getLambda1$material_release;
                                BackdropScaffoldKt.BackdropStack(modifierFillMaxSize$default, function2, function12, ComposableLambdaKt.composableLambda(composer5, 1800047509, true, new Function4<Constraints, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(Constraints constraints, Float f20, Composer composer6, Integer num) {
                                        m16600invokejYbf7pk(constraints.getValue(), f20.floatValue(), composer6, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    /* JADX INFO: renamed from: invoke-jYbf7pk, reason: not valid java name */
                                    public final void m16600invokejYbf7pk(long j25, float f20, @Nullable Composer composer6, int i34) {
                                        int i35;
                                        if ((i34 & 14) == 0) {
                                            i35 = (composer6.changed(j25) ? 4 : 2) | i34;
                                        } else {
                                            i35 = i34;
                                        }
                                        if ((i34 & 112) == 0) {
                                            i35 |= composer6.changed(f20) ? 32 : 16;
                                        }
                                        if ((i35 & 731) == 146 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1800047509, i34, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous> (BackdropScaffold.kt:302)");
                                        }
                                        float fM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(j25);
                                        float fMin = fM20920getMaxHeightimpl - f15;
                                        if (z12) {
                                            fMin = Math.min(fMin, f20);
                                        }
                                        float f21 = fMin;
                                        Modifier modifierNestedScroll$default = z13 ? NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, backdropScaffoldState4.getNestedScrollConnection(), null, 2, null) : Modifier.INSTANCE;
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        Modifier modifierThen = companion.then(modifierNestedScroll$default);
                                        BackdropScaffoldState backdropScaffoldState5 = backdropScaffoldState4;
                                        Map mapMapOf = MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(f16), BackdropValue.Concealed), TuplesKt.m13893to(Float.valueOf(f21), BackdropValue.Revealed));
                                        Modifier modifierM16882swipeablepPrIpRY = SwipeableKt.m16882swipeablepPrIpRY(modifierThen, backdropScaffoldState5, mapMapOf, Orientation.Vertical, (32 & 8) != 0 ? true : z13, (32 & 16) != 0 ? false : false, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? new Function2() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                                            @Override // kotlin.jvm.functions.Function2
                                            @NotNull
                                            public final FixedThreshold invoke(Object obj, Object obj2) {
                                                return new FixedThreshold(C2256Dp.m20968constructorimpl(56), null);
                                            }
                                        } : null, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m16881getVelocityThresholdD9Ej5fM() : 0.0f);
                                        final BackdropScaffoldState backdropScaffoldState6 = backdropScaffoldState4;
                                        final CoroutineScope coroutineScope2 = coroutineScope;
                                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM16882swipeablepPrIpRY, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                                if (backdropScaffoldState6.isConcealed()) {
                                                    final BackdropScaffoldState backdropScaffoldState7 = backdropScaffoldState6;
                                                    final CoroutineScope coroutineScope3 = coroutineScope2;
                                                    SemanticsPropertiesKt.collapse$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1.1

                                                        /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$1$1, reason: invalid class name */
                                                        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                                        @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                                        @DebugMetadata(m14020c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$1$1", m14021f = "BackdropScaffold.kt", m14022i = {}, m14023l = {330}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                            final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                            int label;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            public AnonymousClass1(BackdropScaffoldState backdropScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                                                super(2, continuation);
                                                                this.$scaffoldState = backdropScaffoldState;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            @NotNull
                                                            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                                return new AnonymousClass1(this.$scaffoldState, continuation);
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            @Nullable
                                                            public final Object invokeSuspend(@NotNull Object obj) {
                                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                int i = this.label;
                                                                if (i == 0) {
                                                                    ResultKt.throwOnFailure(obj);
                                                                    BackdropScaffoldState backdropScaffoldState = this.$scaffoldState;
                                                                    this.label = 1;
                                                                    if (backdropScaffoldState.reveal(this) == coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                } else {
                                                                    if (i != 1) {
                                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                    }
                                                                    ResultKt.throwOnFailure(obj);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            @Nullable
                                                            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                            }
                                                        }

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        @NotNull
                                                        public final Boolean invoke() {
                                                            if (backdropScaffoldState7.getConfirmStateChange$material_release().invoke(BackdropValue.Revealed).booleanValue()) {
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(backdropScaffoldState7, null), 3, null);
                                                            }
                                                            return Boolean.TRUE;
                                                        }
                                                    }, 1, null);
                                                } else {
                                                    final BackdropScaffoldState backdropScaffoldState8 = backdropScaffoldState6;
                                                    final CoroutineScope coroutineScope4 = coroutineScope2;
                                                    SemanticsPropertiesKt.expand$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1.2

                                                        /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$2$1, reason: invalid class name */
                                                        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                                        @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                                        @DebugMetadata(m14020c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$2$1", m14021f = "BackdropScaffold.kt", m14022i = {}, m14023l = {336}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                            final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                            int label;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            public AnonymousClass1(BackdropScaffoldState backdropScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                                                super(2, continuation);
                                                                this.$scaffoldState = backdropScaffoldState;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            @NotNull
                                                            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                                return new AnonymousClass1(this.$scaffoldState, continuation);
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            @Nullable
                                                            public final Object invokeSuspend(@NotNull Object obj) {
                                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                int i = this.label;
                                                                if (i == 0) {
                                                                    ResultKt.throwOnFailure(obj);
                                                                    BackdropScaffoldState backdropScaffoldState = this.$scaffoldState;
                                                                    this.label = 1;
                                                                    if (backdropScaffoldState.conceal(this) == coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                } else {
                                                                    if (i != 1) {
                                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                    }
                                                                    ResultKt.throwOnFailure(obj);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            @Nullable
                                                            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                            }
                                                        }

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        @NotNull
                                                        public final Boolean invoke() {
                                                            if (backdropScaffoldState8.getConfirmStateChange$material_release().invoke(BackdropValue.Concealed).booleanValue()) {
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new AnonymousClass1(backdropScaffoldState8, null), 3, null);
                                                            }
                                                            return Boolean.TRUE;
                                                        }
                                                    }, 1, null);
                                                }
                                            }
                                        }, 1, null);
                                        final BackdropScaffoldState backdropScaffoldState7 = backdropScaffoldState4;
                                        composer6.startReplaceableGroup(1157296644);
                                        boolean zChanged2 = composer6.changed(backdropScaffoldState7);
                                        Object objRememberedValue3 = composer6.rememberedValue();
                                        if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue3 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$1$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                                    return IntOffset.m21087boximpl(m16601invokeBjo55l4(density));
                                                }

                                                /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                                                public final long m16601invokeBjo55l4(@NotNull Density offset) {
                                                    Intrinsics.checkNotNullParameter(offset, "$this$offset");
                                                    return IntOffsetKt.IntOffset(0, MathKt.roundToInt(backdropScaffoldState7.getOffset().getValue().floatValue()));
                                                }
                                            };
                                            composer6.updateRememberedValue(objRememberedValue3);
                                        }
                                        composer6.endReplaceableGroup();
                                        Modifier modifierThen2 = OffsetKt.offset(companion, (Function1) objRememberedValue3).then(modifierSemantics$default);
                                        Shape shape7 = shape6;
                                        long j26 = j22;
                                        long j27 = j23;
                                        float f22 = f17;
                                        final float f23 = f19;
                                        final Function2<Composer, Integer, Unit> function23 = function22;
                                        final int i36 = i32;
                                        final long j28 = j24;
                                        final BackdropScaffoldState backdropScaffoldState8 = backdropScaffoldState4;
                                        final int i37 = i33;
                                        final boolean z14 = z13;
                                        final CoroutineScope coroutineScope3 = coroutineScope;
                                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer6, -1065299503, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackdropScaffold.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                                invoke(composer7, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                            @Composable
                                            public final void invoke(@Nullable Composer composer7, int i38) {
                                                if ((i38 & 11) == 2 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1065299503, i38, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:350)");
                                                }
                                                Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, f23, 7, null);
                                                Function2<Composer, Integer, Unit> function24 = function23;
                                                int i39 = i36;
                                                long j29 = j28;
                                                final BackdropScaffoldState backdropScaffoldState9 = backdropScaffoldState8;
                                                int i40 = i37;
                                                final boolean z15 = z14;
                                                final CoroutineScope coroutineScope4 = coroutineScope3;
                                                composer7.startReplaceableGroup(733328855);
                                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer7, 0, -1323940314);
                                                Density density = (Density) composer7.consume(CompositionLocalsKt.getLocalDensity());
                                                LayoutDirection layoutDirection = (LayoutDirection) composer7.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer7.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
                                                if (composer7.getApplier() == null) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer7.startReusableNode();
                                                if (composer7.getInserting()) {
                                                    composer7.createNode(constructor);
                                                } else {
                                                    composer7.useNode();
                                                }
                                                composer7.disableReusing();
                                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer7);
                                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer7, composer7), composer7, 2058660585);
                                                composer7.startReplaceableGroup(-2137368960);
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                composer7.startReplaceableGroup(-1889954677);
                                                function24.invoke(composer7, Integer.valueOf((i39 >> 6) & 14));
                                                BackdropScaffoldKt.m16596Scrim3JVO9M(j29, new Function0<Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1

                                                    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1 */
                                                    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                                    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                                    @DebugMetadata(m14020c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1", m14021f = "BackdropScaffold.kt", m14022i = {}, m14023l = {358}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                                    public static final class C14721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                        final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                        int label;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        public C14721(BackdropScaffoldState backdropScaffoldState, Continuation<? super C14721> continuation) {
                                                            super(2, continuation);
                                                            this.$scaffoldState = backdropScaffoldState;
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        @NotNull
                                                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                            return new C14721(this.$scaffoldState, continuation);
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        @Nullable
                                                        public final Object invokeSuspend(@NotNull Object obj) {
                                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                            int i = this.label;
                                                            if (i == 0) {
                                                                ResultKt.throwOnFailure(obj);
                                                                BackdropScaffoldState backdropScaffoldState = this.$scaffoldState;
                                                                this.label = 1;
                                                                if (backdropScaffoldState.conceal(this) == coroutine_suspended) {
                                                                    return coroutine_suspended;
                                                                }
                                                            } else {
                                                                if (i != 1) {
                                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                }
                                                                ResultKt.throwOnFailure(obj);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        @Nullable
                                                        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                                            return ((C14721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                        }
                                                    }

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                                        invoke2();
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2() {
                                                        if (z15 && backdropScaffoldState9.getConfirmStateChange$material_release().invoke(BackdropValue.Concealed).booleanValue()) {
                                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new C14721(backdropScaffoldState9, null), 3, null);
                                                        }
                                                    }
                                                }, backdropScaffoldState9.getTargetValue() == BackdropValue.Revealed, composer7, (i40 >> 18) & 14);
                                                if (AbstractC1038a.m1225z(composer7)) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                        int i38 = i33;
                                        int i39 = i38 >> 6;
                                        SurfaceKt.m16872SurfaceFjzlyU(modifierThen2, shape7, j26, j27, null, f22, composableLambda2, composer6, ((i38 << 6) & 458752) | ((i38 >> 3) & 112) | 1572864 | (i39 & 896) | (i39 & 7168), 16);
                                        Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, (backdropScaffoldState4.isRevealed() && f21 == fM20920getMaxHeightimpl - f15) ? f18 : C2256Dp.m20968constructorimpl(0), 7, null);
                                        Alignment bottomCenter = Alignment.INSTANCE.getBottomCenter();
                                        Function3<SnackbarHostState, Composer, Integer, Unit> function35 = function34;
                                        BackdropScaffoldState backdropScaffoldState9 = backdropScaffoldState4;
                                        int i40 = i33;
                                        composer6.startReplaceableGroup(733328855);
                                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(bottomCenter, false, composer6, 6);
                                        Density density = (Density) AbstractC1038a.m1211l(composer6, -1323940314);
                                        LayoutDirection layoutDirection = (LayoutDirection) composer6.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer6.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
                                        if (composer6.getApplier() == null) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer6.startReusableNode();
                                        if (composer6.getInserting()) {
                                            composer6.createNode(constructor);
                                        } else {
                                            composer6.useNode();
                                        }
                                        composer6.disableReusing();
                                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer6);
                                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer6, composer6), composer6, 2058660585);
                                        composer6.startReplaceableGroup(-2137368960);
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        composer6.startReplaceableGroup(1815906203);
                                        function35.invoke(backdropScaffoldState9.getSnackbarHostState(), composer6, Integer.valueOf((i40 >> 18) & 112));
                                        composer6.endReplaceableGroup();
                                        composer6.endReplaceableGroup();
                                        composer6.endReplaceableGroup();
                                        composer6.endNode();
                                        composer6.endReplaceableGroup();
                                        composer6.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer5, 3120);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer4, (i30 & 7168) | (i30 & 896) | 1572864, 51);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function33 = function3M16700getLambda1$material_release;
                        j12 = j9;
                        j13 = j18;
                        j14 = j21;
                        modifier3 = modifier5;
                        composer3 = composer4;
                        f10 = f8;
                        f11 = f14;
                        z8 = z11;
                        shape3 = shape5;
                        z9 = z6;
                        backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                        f12 = f13;
                        j15 = j19;
                        j16 = j20;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                            invoke(composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer5, int i31) {
                            BackdropScaffoldKt.m16595BackdropScaffoldBZszfkY(appBar, backLayerContent, frontLayerContent, modifier3, backdropScaffoldState2, z7, f12, f11, z8, z9, j16, j14, shape3, f10, j15, j13, j12, function33, composer5, i | 1, i2, i4);
                        }
                    });
                    return;
                }
                i14 |= 3072;
                if ((i2 & 57344) == 0) {
                }
                if ((458752 & i2) == 0) {
                }
                if ((3670016 & i2) == 0) {
                }
                i16 = i4 & 131072;
                if (i16 == 0) {
                }
                i17 = i14;
                if ((i13 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i23 == 0) {
                        }
                        if ((i4 & 16) == 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if ((i4 & 1024) == 0) {
                        }
                        if ((i4 & 2048) == 0) {
                        }
                        int i262 = i17;
                        if ((i4 & 4096) == 0) {
                        }
                        if (i20 == 0) {
                        }
                        Shape shape42 = frontLayerShape;
                        if ((i4 & 16384) == 0) {
                        }
                        if ((i4 & 32768) == 0) {
                        }
                        if ((i4 & 65536) == 0) {
                        }
                        if (i18 == 0) {
                        }
                        j8 = jM16694contentColorForek8zF_U;
                        i22 = i13;
                        f8 = f7;
                        j9 = frontLayerScrimColor;
                        f9 = fM16592getHeaderHeightD9Ej5fM;
                        z7 = z4;
                        modifier2 = modifier4;
                        long j172 = jM16676getPrimary0d7_KjU;
                        shape2 = shape42;
                        j10 = j7;
                        j11 = j172;
                        composer2.endDefaults();
                        final Modifier modifier52 = modifier2;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final float fMo15546toPx0680j_422 = ((Density) composer2.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(fM16593getPeekHeightD9Ej5fM);
                        fMo15546toPx0680j_4 = ((Density) composer2.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(f9);
                        final int i282 = i22;
                        final BackdropScaffoldState backdropScaffoldState32 = backdropScaffoldStateRememberBackdropScaffoldState;
                        final boolean z112 = z5;
                        final float f132 = fM16593getPeekHeightD9Ej5fM;
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda2 = ComposableLambdaKt.composableLambda(composer2, 1744778315, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer42, Integer num) {
                                invoke(composer42, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer42, int i292) {
                                if ((i292 & 11) == 2 && composer42.getSkipping()) {
                                    composer42.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1744778315, i292, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:278)");
                                }
                                if (z112) {
                                    composer42.startReplaceableGroup(-1017265331);
                                    Function2<Composer, Integer, Unit> function2 = appBar;
                                    int i302 = i282;
                                    Function2<Composer, Integer, Unit> function22 = backLayerContent;
                                    composer42.startReplaceableGroup(-483455358);
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer42, 0, -1323940314);
                                    Density density = (Density) composer42.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer42.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer42.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
                                    if (composer42.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer42.startReusableNode();
                                    if (composer42.getInserting()) {
                                        composer42.createNode(constructor);
                                    } else {
                                        composer42.useNode();
                                    }
                                    composer42.disableReusing();
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer42);
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer42, composer42), composer42, 2058660585);
                                    composer42.startReplaceableGroup(-1163856341);
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    composer42.startReplaceableGroup(-18835878);
                                    function2.invoke(composer42, Integer.valueOf(i302 & 14));
                                    function22.invoke(composer42, Integer.valueOf((i302 >> 3) & 14));
                                    composer42.endReplaceableGroup();
                                    composer42.endReplaceableGroup();
                                    composer42.endReplaceableGroup();
                                    composer42.endNode();
                                    composer42.endReplaceableGroup();
                                    composer42.endReplaceableGroup();
                                    composer42.endReplaceableGroup();
                                } else {
                                    composer42.startReplaceableGroup(-1017265219);
                                    BackdropValue targetValue = backdropScaffoldState32.getTargetValue();
                                    Function2<Composer, Integer, Unit> function23 = appBar;
                                    Function2<Composer, Integer, Unit> function24 = backLayerContent;
                                    int i31 = i282;
                                    BackdropScaffoldKt.BackLayerTransition(targetValue, function23, function24, composer42, ((i31 << 3) & 896) | ((i31 << 3) & 112));
                                    composer42.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        Float fValueOf2 = Float.valueOf(fMo15546toPx0680j_4);
                        composer2.startReplaceableGroup(1157296644);
                        zChanged = composer2.changed(fValueOf2);
                        objRememberedValue = composer2.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new Function1<Constraints, Constraints>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Constraints invoke(Constraints constraints) {
                                    return Constraints.m20909boximpl(m16602invokeZezNO4M(constraints.getValue()));
                                }

                                /* JADX INFO: renamed from: invoke-ZezNO4M, reason: not valid java name */
                                public final long m16602invokeZezNO4M(long j182) {
                                    return ConstraintsKt.m20941offsetNN6EwU$default(Constraints.m20912copyZbe2FdA$default(j182, 0, 0, 0, 0, 10, null), 0, -MathKt.roundToInt(fMo15546toPx0680j_4), 1, null);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                            composer2.endReplaceableGroup();
                            final Function1<? super Constraints, Constraints> function12 = (Function1) objRememberedValue;
                            final Shape shape52 = shape2;
                            final float f142 = f9;
                            final long j182 = jM16694contentColorForek8zF_U2;
                            final int i292 = i21;
                            final long j192 = j10;
                            Composer composer42 = composer2;
                            int i302 = i292 << 6;
                            long j202 = j11;
                            long j212 = j8;
                            SurfaceKt.m16872SurfaceFjzlyU(null, null, j202, j212, null, 0.0f, ComposableLambdaKt.composableLambda(composer42, -1049909631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer5, int i31) {
                                    if ((i31 & 11) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1049909631, i31, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:296)");
                                    }
                                    composer5.startReplaceableGroup(773894976);
                                    composer5.startReplaceableGroup(-492369756);
                                    Object objRememberedValue2 = composer5.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer5), composer5);
                                    }
                                    composer5.endReplaceableGroup();
                                    final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                                    composer5.endReplaceableGroup();
                                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier52, 0.0f, 1, null);
                                    Function2<Composer, Integer, Unit> function2 = composableLambda2;
                                    Function1<Constraints, Constraints> function122 = function12;
                                    final float f15 = fMo15546toPx0680j_4;
                                    final boolean z12 = z6;
                                    final boolean z13 = z7;
                                    final BackdropScaffoldState backdropScaffoldState4 = backdropScaffoldStateRememberBackdropScaffoldState;
                                    final float f16 = fMo15546toPx0680j_422;
                                    final int i32 = i282;
                                    final Shape shape6 = shape52;
                                    final long j22 = j192;
                                    final long j23 = j182;
                                    final float f17 = f8;
                                    final int i33 = i292;
                                    final float f18 = f142;
                                    final float f19 = f132;
                                    final Function2<? super Composer, ? super Integer, Unit> function22 = frontLayerContent;
                                    final long j24 = j9;
                                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34 = function3M16700getLambda1$material_release;
                                    BackdropScaffoldKt.BackdropStack(modifierFillMaxSize$default, function2, function122, ComposableLambdaKt.composableLambda(composer5, 1800047509, true, new Function4<Constraints, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(Constraints constraints, Float f20, Composer composer6, Integer num) {
                                            m16600invokejYbf7pk(constraints.getValue(), f20.floatValue(), composer6, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        /* JADX INFO: renamed from: invoke-jYbf7pk, reason: not valid java name */
                                        public final void m16600invokejYbf7pk(long j25, float f20, @Nullable Composer composer6, int i34) {
                                            int i35;
                                            if ((i34 & 14) == 0) {
                                                i35 = (composer6.changed(j25) ? 4 : 2) | i34;
                                            } else {
                                                i35 = i34;
                                            }
                                            if ((i34 & 112) == 0) {
                                                i35 |= composer6.changed(f20) ? 32 : 16;
                                            }
                                            if ((i35 & 731) == 146 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1800047509, i34, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous> (BackdropScaffold.kt:302)");
                                            }
                                            float fM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(j25);
                                            float fMin = fM20920getMaxHeightimpl - f15;
                                            if (z12) {
                                                fMin = Math.min(fMin, f20);
                                            }
                                            float f21 = fMin;
                                            Modifier modifierNestedScroll$default = z13 ? NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, backdropScaffoldState4.getNestedScrollConnection(), null, 2, null) : Modifier.INSTANCE;
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            Modifier modifierThen = companion.then(modifierNestedScroll$default);
                                            BackdropScaffoldState backdropScaffoldState5 = backdropScaffoldState4;
                                            Map mapMapOf = MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(f16), BackdropValue.Concealed), TuplesKt.m13893to(Float.valueOf(f21), BackdropValue.Revealed));
                                            Modifier modifierM16882swipeablepPrIpRY = SwipeableKt.m16882swipeablepPrIpRY(modifierThen, backdropScaffoldState5, mapMapOf, Orientation.Vertical, (32 & 8) != 0 ? true : z13, (32 & 16) != 0 ? false : false, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? new Function2() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                                                @Override // kotlin.jvm.functions.Function2
                                                @NotNull
                                                public final FixedThreshold invoke(Object obj, Object obj2) {
                                                    return new FixedThreshold(C2256Dp.m20968constructorimpl(56), null);
                                                }
                                            } : null, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m16881getVelocityThresholdD9Ej5fM() : 0.0f);
                                            final BackdropScaffoldState backdropScaffoldState6 = backdropScaffoldState4;
                                            final CoroutineScope coroutineScope2 = coroutineScope;
                                            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM16882swipeablepPrIpRY, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    invoke2(semanticsPropertyReceiver);
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                                    if (backdropScaffoldState6.isConcealed()) {
                                                        final BackdropScaffoldState backdropScaffoldState7 = backdropScaffoldState6;
                                                        final CoroutineScope coroutineScope3 = coroutineScope2;
                                                        SemanticsPropertiesKt.collapse$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1.1

                                                            /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$1$1, reason: invalid class name */
                                                            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                                            @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                                            @DebugMetadata(m14020c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$1$1", m14021f = "BackdropScaffold.kt", m14022i = {}, m14023l = {330}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                                int label;

                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                public AnonymousClass1(BackdropScaffoldState backdropScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                                                    super(2, continuation);
                                                                    this.$scaffoldState = backdropScaffoldState;
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                @NotNull
                                                                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                                    return new AnonymousClass1(this.$scaffoldState, continuation);
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                @Nullable
                                                                public final Object invokeSuspend(@NotNull Object obj) {
                                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                    int i = this.label;
                                                                    if (i == 0) {
                                                                        ResultKt.throwOnFailure(obj);
                                                                        BackdropScaffoldState backdropScaffoldState = this.$scaffoldState;
                                                                        this.label = 1;
                                                                        if (backdropScaffoldState.reveal(this) == coroutine_suspended) {
                                                                            return coroutine_suspended;
                                                                        }
                                                                    } else {
                                                                        if (i != 1) {
                                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                        }
                                                                        ResultKt.throwOnFailure(obj);
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                @Nullable
                                                                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                }
                                                            }

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // kotlin.jvm.functions.Function0
                                                            @NotNull
                                                            public final Boolean invoke() {
                                                                if (backdropScaffoldState7.getConfirmStateChange$material_release().invoke(BackdropValue.Revealed).booleanValue()) {
                                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(backdropScaffoldState7, null), 3, null);
                                                                }
                                                                return Boolean.TRUE;
                                                            }
                                                        }, 1, null);
                                                    } else {
                                                        final BackdropScaffoldState backdropScaffoldState8 = backdropScaffoldState6;
                                                        final CoroutineScope coroutineScope4 = coroutineScope2;
                                                        SemanticsPropertiesKt.expand$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1.2

                                                            /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$2$1, reason: invalid class name */
                                                            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                                            @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                                            @DebugMetadata(m14020c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$2$1", m14021f = "BackdropScaffold.kt", m14022i = {}, m14023l = {336}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                                int label;

                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                public AnonymousClass1(BackdropScaffoldState backdropScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                                                    super(2, continuation);
                                                                    this.$scaffoldState = backdropScaffoldState;
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                @NotNull
                                                                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                                    return new AnonymousClass1(this.$scaffoldState, continuation);
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                @Nullable
                                                                public final Object invokeSuspend(@NotNull Object obj) {
                                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                    int i = this.label;
                                                                    if (i == 0) {
                                                                        ResultKt.throwOnFailure(obj);
                                                                        BackdropScaffoldState backdropScaffoldState = this.$scaffoldState;
                                                                        this.label = 1;
                                                                        if (backdropScaffoldState.conceal(this) == coroutine_suspended) {
                                                                            return coroutine_suspended;
                                                                        }
                                                                    } else {
                                                                        if (i != 1) {
                                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                        }
                                                                        ResultKt.throwOnFailure(obj);
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                @Nullable
                                                                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                }
                                                            }

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // kotlin.jvm.functions.Function0
                                                            @NotNull
                                                            public final Boolean invoke() {
                                                                if (backdropScaffoldState8.getConfirmStateChange$material_release().invoke(BackdropValue.Concealed).booleanValue()) {
                                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new AnonymousClass1(backdropScaffoldState8, null), 3, null);
                                                                }
                                                                return Boolean.TRUE;
                                                            }
                                                        }, 1, null);
                                                    }
                                                }
                                            }, 1, null);
                                            final BackdropScaffoldState backdropScaffoldState7 = backdropScaffoldState4;
                                            composer6.startReplaceableGroup(1157296644);
                                            boolean zChanged2 = composer6.changed(backdropScaffoldState7);
                                            Object objRememberedValue3 = composer6.rememberedValue();
                                            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue3 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$1$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                                        return IntOffset.m21087boximpl(m16601invokeBjo55l4(density));
                                                    }

                                                    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                                                    public final long m16601invokeBjo55l4(@NotNull Density offset) {
                                                        Intrinsics.checkNotNullParameter(offset, "$this$offset");
                                                        return IntOffsetKt.IntOffset(0, MathKt.roundToInt(backdropScaffoldState7.getOffset().getValue().floatValue()));
                                                    }
                                                };
                                                composer6.updateRememberedValue(objRememberedValue3);
                                            }
                                            composer6.endReplaceableGroup();
                                            Modifier modifierThen2 = OffsetKt.offset(companion, (Function1) objRememberedValue3).then(modifierSemantics$default);
                                            Shape shape7 = shape6;
                                            long j26 = j22;
                                            long j27 = j23;
                                            float f22 = f17;
                                            final float f23 = f19;
                                            final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
                                            final int i36 = i32;
                                            final long j28 = j24;
                                            final BackdropScaffoldState backdropScaffoldState8 = backdropScaffoldState4;
                                            final int i37 = i33;
                                            final boolean z14 = z13;
                                            final CoroutineScope coroutineScope3 = coroutineScope;
                                            ComposableLambda composableLambda22 = ComposableLambdaKt.composableLambda(composer6, -1065299503, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackdropScaffold.1.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                                    invoke(composer7, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                public final void invoke(@Nullable Composer composer7, int i38) {
                                                    if ((i38 & 11) == 2 && composer7.getSkipping()) {
                                                        composer7.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1065299503, i38, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:350)");
                                                    }
                                                    Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, f23, 7, null);
                                                    Function2<Composer, Integer, Unit> function24 = function23;
                                                    int i39 = i36;
                                                    long j29 = j28;
                                                    final BackdropScaffoldState backdropScaffoldState9 = backdropScaffoldState8;
                                                    int i40 = i37;
                                                    final boolean z15 = z14;
                                                    final CoroutineScope coroutineScope4 = coroutineScope3;
                                                    composer7.startReplaceableGroup(733328855);
                                                    MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer7, 0, -1323940314);
                                                    Density density = (Density) composer7.consume(CompositionLocalsKt.getLocalDensity());
                                                    LayoutDirection layoutDirection = (LayoutDirection) composer7.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer7.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
                                                    if (composer7.getApplier() == null) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer7.startReusableNode();
                                                    if (composer7.getInserting()) {
                                                        composer7.createNode(constructor);
                                                    } else {
                                                        composer7.useNode();
                                                    }
                                                    composer7.disableReusing();
                                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer7);
                                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer7, composer7), composer7, 2058660585);
                                                    composer7.startReplaceableGroup(-2137368960);
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    composer7.startReplaceableGroup(-1889954677);
                                                    function24.invoke(composer7, Integer.valueOf((i39 >> 6) & 14));
                                                    BackdropScaffoldKt.m16596Scrim3JVO9M(j29, new Function0<Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1

                                                        /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1 */
                                                        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                                        @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                                        @DebugMetadata(m14020c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1", m14021f = "BackdropScaffold.kt", m14022i = {}, m14023l = {358}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                                        public static final class C14721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                            final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                            int label;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            public C14721(BackdropScaffoldState backdropScaffoldState, Continuation<? super C14721> continuation) {
                                                                super(2, continuation);
                                                                this.$scaffoldState = backdropScaffoldState;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            @NotNull
                                                            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                                return new C14721(this.$scaffoldState, continuation);
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            @Nullable
                                                            public final Object invokeSuspend(@NotNull Object obj) {
                                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                int i = this.label;
                                                                if (i == 0) {
                                                                    ResultKt.throwOnFailure(obj);
                                                                    BackdropScaffoldState backdropScaffoldState = this.$scaffoldState;
                                                                    this.label = 1;
                                                                    if (backdropScaffoldState.conceal(this) == coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                } else {
                                                                    if (i != 1) {
                                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                    }
                                                                    ResultKt.throwOnFailure(obj);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            @Nullable
                                                            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                                                return ((C14721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                            }
                                                        }

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                                            invoke2();
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2() {
                                                            if (z15 && backdropScaffoldState9.getConfirmStateChange$material_release().invoke(BackdropValue.Concealed).booleanValue()) {
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new C14721(backdropScaffoldState9, null), 3, null);
                                                            }
                                                        }
                                                    }, backdropScaffoldState9.getTargetValue() == BackdropValue.Revealed, composer7, (i40 >> 18) & 14);
                                                    if (AbstractC1038a.m1225z(composer7)) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                            int i38 = i33;
                                            int i39 = i38 >> 6;
                                            SurfaceKt.m16872SurfaceFjzlyU(modifierThen2, shape7, j26, j27, null, f22, composableLambda22, composer6, ((i38 << 6) & 458752) | ((i38 >> 3) & 112) | 1572864 | (i39 & 896) | (i39 & 7168), 16);
                                            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, (backdropScaffoldState4.isRevealed() && f21 == fM20920getMaxHeightimpl - f15) ? f18 : C2256Dp.m20968constructorimpl(0), 7, null);
                                            Alignment bottomCenter = Alignment.INSTANCE.getBottomCenter();
                                            Function3<SnackbarHostState, Composer, Integer, Unit> function35 = function34;
                                            BackdropScaffoldState backdropScaffoldState9 = backdropScaffoldState4;
                                            int i40 = i33;
                                            composer6.startReplaceableGroup(733328855);
                                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(bottomCenter, false, composer6, 6);
                                            Density density = (Density) AbstractC1038a.m1211l(composer6, -1323940314);
                                            LayoutDirection layoutDirection = (LayoutDirection) composer6.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer6.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
                                            if (composer6.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer6.startReusableNode();
                                            if (composer6.getInserting()) {
                                                composer6.createNode(constructor);
                                            } else {
                                                composer6.useNode();
                                            }
                                            composer6.disableReusing();
                                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer6);
                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer6, composer6), composer6, 2058660585);
                                            composer6.startReplaceableGroup(-2137368960);
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            composer6.startReplaceableGroup(1815906203);
                                            function35.invoke(backdropScaffoldState9.getSnackbarHostState(), composer6, Integer.valueOf((i40 >> 18) & 112));
                                            composer6.endReplaceableGroup();
                                            composer6.endReplaceableGroup();
                                            composer6.endReplaceableGroup();
                                            composer6.endNode();
                                            composer6.endReplaceableGroup();
                                            composer6.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer5, 3120);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer42, (i302 & 7168) | (i302 & 896) | 1572864, 51);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function33 = function3M16700getLambda1$material_release;
                            j12 = j9;
                            j13 = j182;
                            j14 = j212;
                            modifier3 = modifier52;
                            composer3 = composer42;
                            f10 = f8;
                            f11 = f142;
                            z8 = z112;
                            shape3 = shape52;
                            z9 = z6;
                            backdropScaffoldState2 = backdropScaffoldStateRememberBackdropScaffoldState;
                            f12 = f132;
                            j15 = j192;
                            j16 = j202;
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i10 = i9;
            i11 = i4 & 512;
            if (i11 != 0) {
            }
            if ((i2 & 14) == 0) {
            }
            if ((i2 & 112) == 0) {
            }
            if ((i2 & 896) == 0) {
            }
            i15 = i4 & 8192;
            if (i15 == 0) {
            }
            if ((i2 & 57344) == 0) {
            }
            if ((458752 & i2) == 0) {
            }
            if ((3670016 & i2) == 0) {
            }
            i16 = i4 & 131072;
            if (i16 == 0) {
            }
            i17 = i14;
            if ((i13 & 1533916891) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        int i242 = 8192;
        if ((i & 57344) == 0) {
        }
        i6 = i4 & 32;
        if (i6 == 0) {
        }
        i7 = i4 & 64;
        if (i7 == 0) {
        }
        i8 = i4 & 128;
        if (i8 == 0) {
        }
        i9 = i4 & 256;
        if (i9 == 0) {
        }
        i10 = i9;
        i11 = i4 & 512;
        if (i11 != 0) {
        }
        if ((i2 & 14) == 0) {
        }
        if ((i2 & 112) == 0) {
        }
        if ((i2 & 896) == 0) {
        }
        i15 = i4 & 8192;
        if (i15 == 0) {
        }
        if ((i2 & 57344) == 0) {
        }
        if ((458752 & i2) == 0) {
        }
        if ((3670016 & i2) == 0) {
        }
        i16 = i4 & 131072;
        if (i16 == 0) {
        }
        i17 = i14;
        if ((i13 & 1533916891) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @UiComposable
    public static final void BackdropStack(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function1<? super Constraints, Constraints> function1, final Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i) {
        final int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1248995194);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(function1) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(function4) ? 2048 : 1024;
        }
        if ((i2 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1248995194, i2, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:451)");
            }
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            boolean zChanged = composerStartRestartGroup.changed(function2) | composerStartRestartGroup.changed(function1) | composerStartRestartGroup.changed(function4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m16603invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    @NotNull
                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m16603invoke0kLqBqw(@NotNull SubcomposeMeasureScope SubcomposeLayout, final long j) {
                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                        final Placeable placeableMo19855measureBRTryo0 = ((Measurable) CollectionsKt.first((List) SubcomposeLayout.subcompose(BackdropLayers.Back, function2))).mo19855measureBRTryo0(function1.invoke(Constraints.m20909boximpl(j)).getValue());
                        final float height = placeableMo19855measureBRTryo0.getHeight();
                        BackdropLayers backdropLayers = BackdropLayers.Front;
                        final Function4<Constraints, Float, Composer, Integer, Unit> function42 = function4;
                        final int i4 = i2;
                        List<Measurable> listSubcompose = SubcomposeLayout.subcompose(backdropLayers, ComposableLambdaKt.composableLambdaInstance(-1222642649, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1$placeables$1
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

                            @Composable
                            public final void invoke(@Nullable Composer composer2, int i5) {
                                if ((i5 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1222642649, i5, -1, "androidx.compose.material.BackdropStack.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:465)");
                                }
                                function42.invoke(Constraints.m20909boximpl(j), Float.valueOf(height), composer2, Integer.valueOf((i4 >> 3) & 896));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        final ArrayList arrayList = new ArrayList(listSubcompose.size());
                        int size = listSubcompose.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            arrayList.add(listSubcompose.get(i5).mo19855measureBRTryo0(j));
                        }
                        int iMax = Math.max(Constraints.m20923getMinWidthimpl(j), placeableMo19855measureBRTryo0.getWidth());
                        int iMax2 = Math.max(Constraints.m20922getMinHeightimpl(j), placeableMo19855measureBRTryo0.getHeight());
                        int size2 = arrayList.size();
                        int iMax3 = iMax;
                        int iMax4 = iMax2;
                        for (int i6 = 0; i6 < size2; i6++) {
                            Placeable placeable = (Placeable) arrayList.get(i6);
                            iMax3 = Math.max(iMax3, placeable.getWidth());
                            iMax4 = Math.max(iMax4, placeable.getHeight());
                        }
                        return MeasureScope.layout$default(SubcomposeLayout, iMax3, iMax4, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1.2
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
                            public final void invoke2(@NotNull Placeable.PlacementScope layout) {
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, 0, 0, 0.0f, 4, null);
                                List<Placeable> list = arrayList;
                                int size3 = list.size();
                                for (int i7 = 0; i7 < size3; i7++) {
                                    Placeable.PlacementScope.placeRelative$default(layout, list.get(i7), 0, 0, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) objRememberedValue, composerStartRestartGroup, i2 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackdropStack.2
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

            public final void invoke(@Nullable Composer composer2, int i4) {
                BackdropScaffoldKt.BackdropStack(modifier, function2, function1, function4, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m16596Scrim3JVO9M(final long j, final Function0<Unit> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier modifierPointerInput;
        Composer composerStartRestartGroup = composer.startRestartGroup(-92141505);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-92141505, i2, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:382)");
            }
            if (j != Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
                final State stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, composerStartRestartGroup, 0, 12);
                composerStartRestartGroup.startReplaceableGroup(1010547004);
                if (z) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Unit unit = Unit.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    boolean zChanged = composerStartRestartGroup.changed(function0);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(function0, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue);
                } else {
                    modifierPointerInput = Modifier.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(modifierPointerInput);
                Color colorM18515boximpl = Color.m18515boximpl(j);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                boolean zChanged2 = composerStartRestartGroup.changed(colorM18515boximpl) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$1$1
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
                            DrawScope.m19070drawRectnJ9OG0$default(Canvas, j, 0L, 0L, BackdropScaffoldKt.m16597Scrim_3J_VO9M$lambda4(stateAnimateFloatAsState), null, null, 0, 118, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i4) {
                BackdropScaffoldKt.m16596Scrim3JVO9M(j, function0, z, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Scrim_3J_VO9M$lambda-4, reason: not valid java name */
    public static final float m16597Scrim_3J_VO9M$lambda4(State<Float> state) {
        return state.getValue().floatValue();
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final BackdropScaffoldState rememberBackdropScaffoldState(@NotNull final BackdropValue initialValue, @Nullable final AnimationSpec<Float> animationSpec, @Nullable final Function1<? super BackdropValue, Boolean> function1, @Nullable final SnackbarHostState snackbarHostState, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        composer.startReplaceableGroup(-862178912);
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<BackdropValue, Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt.rememberBackdropScaffoldState.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull BackdropValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.TRUE;
                }
            };
        }
        if ((i2 & 8) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) objRememberedValue;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-862178912, i, -1, "androidx.compose.material.rememberBackdropScaffoldState (BackdropScaffold.kt:167)");
        }
        BackdropScaffoldState backdropScaffoldState = (BackdropScaffoldState) RememberSaveableKt.m18111rememberSaveable(new Object[]{animationSpec, function1, snackbarHostState}, (Saver) BackdropScaffoldState.INSTANCE.Saver(animationSpec, function1, snackbarHostState), (String) null, (Function0) new Function0<BackdropScaffoldState>() { // from class: androidx.compose.material.BackdropScaffoldKt.rememberBackdropScaffoldState.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BackdropScaffoldState invoke() {
                return new BackdropScaffoldState(initialValue, animationSpec, function1, snackbarHostState);
            }
        }, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return backdropScaffoldState;
    }
}
