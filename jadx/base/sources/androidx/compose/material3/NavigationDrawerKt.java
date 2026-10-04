package androidx.compose.material3;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.RectangleShapeKt;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.C2256Dp;
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
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import opennlp.tools.tokenize.TokenizerME;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ao\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001aQ\u0010\u001a\u001a\u00020\b2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u00162\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010!\u001am\u0010\"\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001ao\u0010%\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0019\u001ac\u0010'\u001a\u00020\b2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u00162\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010(\u001a\u00020\u000e2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u008c\u0001\u0010+\u001a\u00020\b2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u00162\u0006\u0010-\u001a\u00020 2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u001c¢\u0006\u0002\b\u00162\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u001c¢\u0006\u0002\b\u00162\b\b\u0002\u00101\u001a\u00020\f2\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u000205H\u0007¢\u0006\u0002\u00106\u001ao\u00107\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u0010\u0019\u001a=\u00109\u001a\u00020\b2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u00162\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010:\u001aA\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020 2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c2\u0006\u0010?\u001a\u00020\u000eH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a \u0010B\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u0002H\u0002\u001a+\u0010F\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020H2\u0014\b\u0002\u0010I\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020 0\u0014H\u0007¢\u0006\u0002\u0010J\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006K"}, m13886d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DrawerVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "MinimumDrawerWidth", "DismissibleDrawerSheet", "", "modifier", "Landroidx/compose/ui/Modifier;", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerContainerColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerTonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DismissibleDrawerSheet-afqeVBk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleNavigationDrawer", "drawerContent", "Lkotlin/Function0;", "drawerState", "Landroidx/compose/material3/DrawerState;", "gesturesEnabled", "", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DrawerSheet", "DrawerSheet-vywBR7E", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet", "ModalDrawerSheet-afqeVBk", "ModalNavigationDrawer", "scrimColor", "ModalNavigationDrawer-FHprtrg", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "NavigationDrawerItem", "label", "selected", "onClick", "icon", "badge", VMetaDataKey.META_KEY_SHAPE, "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/NavigationDrawerItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "PermanentDrawerSheet", "PermanentDrawerSheet-afqeVBk", "PermanentNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", AbstractCircuitBreaker.PROPERTY_NAME, "onClose", "fraction", "color", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberDrawerState", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DrawerState;", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NavigationDrawerKt {
    private static final float DrawerVelocityThreshold = C2256Dp.m20968constructorimpl(400);
    private static final float MinimumDrawerWidth = C2256Dp.m20968constructorimpl(240);

    @NotNull
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f9  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: DismissibleDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17240DismissibleDrawerSheetafqeVBk(@Nullable Modifier modifier, @Nullable Shape shape, long j, long j2, float f, @Nullable WindowInsets windowInsets, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        Shape rectangleShape;
        long jM17062getSurface0d7_KjU;
        long jM17098contentColorForek8zF_U;
        int i5;
        float fM17139getDismissibleDrawerElevationD9Ej5fM;
        int i6;
        WindowInsets windowInsets2;
        final Modifier modifier3;
        WindowInsets windowInsets3;
        final Shape shape2;
        final long j3;
        final long j5;
        final float f4;
        final WindowInsets windowInsets4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-588600583);
        int i8 = i2 & 1;
        if (i8 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                rectangleShape = shape;
                i4 |= composerStartRestartGroup.changed(rectangleShape) ? 32 : 16;
            }
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    jM17062getSurface0d7_KjU = j;
                    int i10 = composerStartRestartGroup.changed(jM17062getSurface0d7_KjU) ? 256 : 128;
                    i4 |= i10;
                } else {
                    jM17062getSurface0d7_KjU = j;
                }
                i4 |= i10;
            } else {
                jM17062getSurface0d7_KjU = j;
            }
            if ((i & 7168) != 0) {
                if ((i2 & 8) == 0) {
                    jM17098contentColorForek8zF_U = j2;
                    int i11 = composerStartRestartGroup.changed(jM17098contentColorForek8zF_U) ? 2048 : 1024;
                    i4 |= i11;
                } else {
                    jM17098contentColorForek8zF_U = j2;
                }
                i4 |= i11;
            } else {
                jM17098contentColorForek8zF_U = j2;
            }
            i5 = i2 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((i & 57344) == 0) {
                    fM17139getDismissibleDrawerElevationD9Ej5fM = f;
                    i4 |= composerStartRestartGroup.changed(fM17139getDismissibleDrawerElevationD9Ej5fM) ? 16384 : 8192;
                }
                if ((i & 458752) == 0) {
                    i6 = 57344;
                    windowInsets2 = windowInsets;
                    i4 |= ((i2 & 32) == 0 && composerStartRestartGroup.changed(windowInsets2)) ? 131072 : 65536;
                } else {
                    i6 = 57344;
                    windowInsets2 = windowInsets;
                }
                if ((i2 & 64) == 0) {
                    i7 = (i & 3670016) == 0 ? composerStartRestartGroup.changed(content) ? 1048576 : 524288 : 1572864;
                    if ((i4 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier4 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i9 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 4) != 0) {
                                jM17062getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m17062getSurface0d7_KjU();
                                i4 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                jM17098contentColorForek8zF_U = ColorSchemeKt.m17098contentColorForek8zF_U(jM17062getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 6) & 14);
                                i4 &= -7169;
                            }
                            if (i5 != 0) {
                                fM17139getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m17139getDismissibleDrawerElevationD9Ej5fM();
                            }
                            if ((i2 & 32) == 0) {
                                i4 &= -458753;
                                modifier3 = modifier4;
                                windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                                shape2 = rectangleShape;
                                long j6 = jM17098contentColorForek8zF_U;
                                int i12 = i4;
                                j3 = jM17062getSurface0d7_KjU;
                                j5 = j6;
                                f4 = fM17139getDismissibleDrawerElevationD9Ej5fM;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-588600583, i12, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:496)");
                                }
                                int i13 = i12 << 3;
                                m17241DrawerSheetvywBR7E(windowInsets3, modifier3, shape2, j3, j5, f4, content, composerStartRestartGroup, (i12 & 3670016) | ((i12 >> 15) & 14) | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (i13 & i6) | (i13 & 458752), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                windowInsets4 = windowInsets3;
                            } else {
                                modifier3 = modifier4;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i4 &= -7169;
                            }
                            if ((i2 & 32) != 0) {
                                i4 &= -458753;
                            }
                            modifier3 = modifier2;
                        }
                        shape2 = rectangleShape;
                        windowInsets3 = windowInsets2;
                        long j62 = jM17098contentColorForek8zF_U;
                        int i122 = i4;
                        j3 = jM17062getSurface0d7_KjU;
                        j5 = j62;
                        f4 = fM17139getDismissibleDrawerElevationD9Ej5fM;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i132 = i122 << 3;
                        m17241DrawerSheetvywBR7E(windowInsets3, modifier3, shape2, j3, j5, f4, content, composerStartRestartGroup, (i122 & 3670016) | ((i122 >> 15) & 14) | (i132 & 112) | (i132 & 896) | (i132 & 7168) | (i132 & i6) | (i132 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        windowInsets4 = windowInsets3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = jM17062getSurface0d7_KjU;
                        j5 = jM17098contentColorForek8zF_U;
                        windowInsets4 = windowInsets2;
                        f4 = fM17139getDismissibleDrawerElevationD9Ej5fM;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$1
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

                        public final void invoke(@Nullable Composer composer2, int i14) {
                            NavigationDrawerKt.m17240DismissibleDrawerSheetafqeVBk(modifier3, shape2, j3, j5, f4, windowInsets4, content, composer2, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= i7;
                if ((i4 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 == 0) {
                        }
                        if (i9 != 0) {
                        }
                        if ((i2 & 4) != 0) {
                        }
                        if ((i2 & 8) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i2 & 32) == 0) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            fM17139getDismissibleDrawerElevationD9Ej5fM = f;
            if ((i & 458752) == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            i4 |= i7;
            if ((i4 & 2995931) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        rectangleShape = shape;
        if ((i & 896) != 0) {
        }
        if ((i & 7168) != 0) {
        }
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        fM17139getDismissibleDrawerElevationD9Ej5fM = f;
        if ((i & 458752) == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        i4 |= i7;
        if ((i4 & 2995931) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03df A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01e2  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DismissibleNavigationDrawer(@NotNull final Function2<? super Composer, ? super Integer, Unit> drawerContent, @Nullable Modifier modifier, @Nullable DrawerState drawerState, boolean z, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        DrawerState drawerState2;
        int i5;
        boolean z2;
        final DrawerState drawerStateRememberDrawerState;
        Modifier modifier3;
        boolean z3;
        Object objRememberedValue;
        Composer composer2;
        final DrawerState drawerState3;
        final Modifier modifier4;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Function2<? super Composer, ? super Integer, Unit> content = function2;
        Intrinsics.checkNotNullParameter(drawerContent, "drawerContent");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(398812198);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(drawerContent) ? 4 : 2) | i;
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
                if ((i2 & 4) == 0) {
                    drawerState2 = drawerState;
                    int i7 = composerStartRestartGroup.changed(drawerState2) ? 256 : 128;
                    i4 |= i7;
                } else {
                    drawerState2 = drawerState;
                }
                i4 |= i7;
            } else {
                drawerState2 = drawerState;
            }
            i5 = i2 & 8;
            if (i5 != 0) {
                if ((i & 7168) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((i2 & 16) != 0) {
                    i4 |= 24576;
                } else if ((57344 & i) == 0) {
                    i4 |= composerStartRestartGroup.changed(content) ? 16384 : 8192;
                }
                if ((46811 & i4) == 9362 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier2;
                    drawerState3 = drawerState2;
                    z4 = z2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier modifier5 = i6 == 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) == 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i4 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        modifier3 = modifier5;
                        if (i5 == 0) {
                            z3 = true;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(398812198, i4, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:346)");
                        }
                        float f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(NavigationDrawerTokens.INSTANCE.m17745getContainerWidthD9Ej5fM());
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup), composerStartRestartGroup);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        final String strM17317getStringNWtq28 = Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17314getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                        Map mapMapOf = MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(f), DrawerValue.Closed), TuplesKt.m13893to(Float.valueOf(0.0f), DrawerValue.Open));
                        Modifier modifierM17335swipeablepPrIpRY = SwipeableKt.m17335swipeablepPrIpRY(modifier3, drawerStateRememberDrawerState.getSwipeableState$material3_release(), mapMapOf, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : new Function2<DrawerValue, DrawerValue, ThresholdConfig>() { // from class: androidx.compose.material3.NavigationDrawerKt.DismissibleNavigationDrawer.1
                            @Override // kotlin.jvm.functions.Function2
                            @NotNull
                            public final ThresholdConfig invoke(@NotNull DrawerValue drawerValue, @NotNull DrawerValue drawerValue2) {
                                Intrinsics.checkNotNullParameter(drawerValue, "<anonymous parameter 0>");
                                Intrinsics.checkNotNullParameter(drawerValue2, "<anonymous parameter 1>");
                                return new FractionalThreshold(0.5f);
                            }
                        }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapMapOf.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m17334getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        Alignment.Companion companion = Alignment.INSTANCE;
                        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion, false, composerStartRestartGroup, 0, -1323940314);
                        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM17335swipeablepPrIpRY);
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
                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(254773804);
                        MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2
                            @Override // androidx.compose.p109ui.layout.MeasurePolicy
                            @NotNull
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope Layout, @NotNull List<? extends Measurable> measurables, long j) {
                                Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                                Intrinsics.checkNotNullParameter(measurables, "measurables");
                                final Placeable placeableMo19855measureBRTryo0 = measurables.get(0).mo19855measureBRTryo0(j);
                                final Placeable placeableMo19855measureBRTryo02 = measurables.get(1).mo19855measureBRTryo0(j);
                                int width = placeableMo19855measureBRTryo02.getWidth();
                                int height = placeableMo19855measureBRTryo02.getHeight();
                                final DrawerState drawerState4 = drawerStateRememberDrawerState;
                                return MeasureScope.layout$default(Layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$measure$1
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
                                    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
                                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                        Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo02, MathKt.roundToInt(drawerState4.getOffset().getValue().floatValue()) + placeableMo19855measureBRTryo0.getWidth(), 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, MathKt.roundToInt(drawerState4.getOffset().getValue().floatValue()), 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                        int i8 = i4;
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(companion3);
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
                        Updater.m18025setimpl(composerM18018constructorimpl2, measurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m18025setimpl(composerM18018constructorimpl2, density2, companion2.getSetDensity());
                        Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, companion2.getSetLayoutDirection());
                        function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(1983447907);
                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1
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
                                SemanticsPropertiesKt.setPaneTitle(semantics, strM17317getStringNWtq28);
                                if (drawerStateRememberDrawerState.isOpen()) {
                                    final DrawerState drawerState4 = drawerStateRememberDrawerState;
                                    final CoroutineScope coroutineScope2 = coroutineScope;
                                    SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1.1

                                        /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1, reason: invalid class name */
                                        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                        @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                        @DebugMetadata(m14020c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1", m14021f = "NavigationDrawer.kt", m14022i = {}, m14023l = {385}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ DrawerState $drawerState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            public AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                                super(2, continuation);
                                                this.$drawerState = drawerState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            @NotNull
                                            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                return new AnonymousClass1(this.$drawerState, continuation);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            @Nullable
                                            public final Object invokeSuspend(@NotNull Object obj) {
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                int i = this.label;
                                                if (i == 0) {
                                                    ResultKt.throwOnFailure(obj);
                                                    DrawerState drawerState = this.$drawerState;
                                                    this.label = 1;
                                                    if (drawerState.close(this) == coroutine_suspended) {
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
                                            if (drawerState4.getSwipeableState$material3_release().getConfirmStateChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(drawerState4, null), 3, null);
                                            }
                                            return Boolean.TRUE;
                                        }
                                    }, 1, null);
                                }
                            }
                        }, 1, null);
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion, false, composerStartRestartGroup, 0, -1323940314);
                        Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierSemantics$default);
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
                        Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl3, measurePolicyM1210k2, composerM18018constructorimpl3, density3));
                        function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                        AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, -170061591);
                        drawerContent.invoke(composerStartRestartGroup, Integer.valueOf(i8 & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, composerStartRestartGroup, 0);
                        Density density4 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                        LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        Function0<ComposeUiNode> constructor4 = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(companion3);
                        if (composerStartRestartGroup.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor4);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM18018constructorimpl4 = Updater.m18018constructorimpl(composerStartRestartGroup);
                        Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl4, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl4, density4));
                        function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl4, viewConfiguration4, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                        AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, 115715936);
                        content = function2;
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 12) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
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
                        composer2 = composerStartRestartGroup;
                        drawerState3 = drawerStateRememberDrawerState;
                        modifier4 = modifier3;
                        z4 = z3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i4 &= -897;
                        }
                        modifier3 = modifier2;
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    z3 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    float f4 = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(NavigationDrawerTokens.INSTANCE.m17745getContainerWidthD9Ej5fM());
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    final String strM17317getStringNWtq282 = Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17314getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                    Map mapMapOf2 = MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(f4), DrawerValue.Closed), TuplesKt.m13893to(Float.valueOf(0.0f), DrawerValue.Open));
                    Modifier modifierM17335swipeablepPrIpRY2 = SwipeableKt.m17335swipeablepPrIpRY(modifier3, drawerStateRememberDrawerState.getSwipeableState$material3_release(), mapMapOf2, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : new Function2<DrawerValue, DrawerValue, ThresholdConfig>() { // from class: androidx.compose.material3.NavigationDrawerKt.DismissibleNavigationDrawer.1
                        @Override // kotlin.jvm.functions.Function2
                        @NotNull
                        public final ThresholdConfig invoke(@NotNull DrawerValue drawerValue, @NotNull DrawerValue drawerValue2) {
                            Intrinsics.checkNotNullParameter(drawerValue, "<anonymous parameter 0>");
                            Intrinsics.checkNotNullParameter(drawerValue2, "<anonymous parameter 1>");
                            return new FractionalThreshold(0.5f);
                        }
                    }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapMapOf2.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m17334getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    Alignment.Companion companion4 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyM1210k3 = AbstractC1038a.m1210k(companion4, false, composerStartRestartGroup, 0, -1323940314);
                    Density density5 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection5 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration5 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor5 = companion22.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierM17335swipeablepPrIpRY2);
                    if (composerStartRestartGroup.getApplier() == null) {
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM18018constructorimpl5 = Updater.m18018constructorimpl(composerStartRestartGroup);
                    Updater.m18025setimpl(composerM18018constructorimpl5, layoutDirection5, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion22, composerM18018constructorimpl5, measurePolicyM1210k3, composerM18018constructorimpl5, density5));
                    function3MaterializerOf5.invoke(AbstractC1038a.m1206g(companion22, composerM18018constructorimpl5, viewConfiguration5, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(254773804);
                    MeasurePolicy measurePolicy2 = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2
                        @Override // androidx.compose.p109ui.layout.MeasurePolicy
                        @NotNull
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope Layout, @NotNull List<? extends Measurable> measurables, long j) {
                            Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                            Intrinsics.checkNotNullParameter(measurables, "measurables");
                            final Placeable placeableMo19855measureBRTryo0 = measurables.get(0).mo19855measureBRTryo0(j);
                            final Placeable placeableMo19855measureBRTryo02 = measurables.get(1).mo19855measureBRTryo0(j);
                            int width = placeableMo19855measureBRTryo02.getWidth();
                            int height = placeableMo19855measureBRTryo02.getHeight();
                            final DrawerState drawerState4 = drawerStateRememberDrawerState;
                            return MeasureScope.layout$default(Layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$measure$1
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
                                public final void invoke2(@NotNull Placeable.PlacementScope layout) {
                                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo02, MathKt.roundToInt(drawerState4.getOffset().getValue().floatValue()) + placeableMo19855measureBRTryo0.getWidth(), 0, 0.0f, 4, null);
                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, MathKt.roundToInt(drawerState4.getOffset().getValue().floatValue()), 0, 0.0f, 4, null);
                                }
                            }, 4, null);
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Modifier.Companion companion32 = Modifier.INSTANCE;
                    Density density22 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection22 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration22 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
                    int i82 = i4;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf22 = LayoutKt.materializerOf(companion32);
                    if (composerStartRestartGroup.getApplier() == null) {
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM18018constructorimpl22 = Updater.m18018constructorimpl(composerStartRestartGroup);
                    Updater.m18025setimpl(composerM18018constructorimpl22, measurePolicy2, companion22.getSetMeasurePolicy());
                    Updater.m18025setimpl(composerM18018constructorimpl22, density22, companion22.getSetDensity());
                    Updater.m18025setimpl(composerM18018constructorimpl22, layoutDirection22, companion22.getSetLayoutDirection());
                    function3MaterializerOf22.invoke(AbstractC1038a.m1206g(companion22, composerM18018constructorimpl22, viewConfiguration22, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(1983447907);
                    Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(companion32, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1
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
                            SemanticsPropertiesKt.setPaneTitle(semantics, strM17317getStringNWtq282);
                            if (drawerStateRememberDrawerState.isOpen()) {
                                final DrawerState drawerState4 = drawerStateRememberDrawerState;
                                final CoroutineScope coroutineScope22 = coroutineScope2;
                                SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1.1

                                    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1, reason: invalid class name */
                                    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                    @DebugMetadata(m14020c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1", m14021f = "NavigationDrawer.kt", m14022i = {}, m14023l = {385}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ DrawerState $drawerState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        public AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$drawerState = drawerState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        @NotNull
                                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$drawerState, continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        @Nullable
                                        public final Object invokeSuspend(@NotNull Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                DrawerState drawerState = this.$drawerState;
                                                this.label = 1;
                                                if (drawerState.close(this) == coroutine_suspended) {
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
                                        if (drawerState4.getSwipeableState$material3_release().getConfirmStateChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new AnonymousClass1(drawerState4, null), 3, null);
                                        }
                                        return Boolean.TRUE;
                                    }
                                }, 1, null);
                            }
                        }
                    }, 1, null);
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyM1210k22 = AbstractC1038a.m1210k(companion4, false, composerStartRestartGroup, 0, -1323940314);
                    Density density32 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection32 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration32 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor32 = companion22.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf32 = LayoutKt.materializerOf(modifierSemantics$default2);
                    if (composerStartRestartGroup.getApplier() == null) {
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM18018constructorimpl32 = Updater.m18018constructorimpl(composerStartRestartGroup);
                    Updater.m18025setimpl(composerM18018constructorimpl32, layoutDirection32, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion22, composerM18018constructorimpl32, measurePolicyM1210k22, composerM18018constructorimpl32, density32));
                    function3MaterializerOf32.invoke(AbstractC1038a.m1206g(companion22, composerM18018constructorimpl32, viewConfiguration32, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                    AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, -170061591);
                    drawerContent.invoke(composerStartRestartGroup, Integer.valueOf(i82 & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion4.getTopStart(), false, composerStartRestartGroup, 0);
                    Density density42 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                    LayoutDirection layoutDirection42 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration42 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor42 = companion22.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf42 = LayoutKt.materializerOf(companion32);
                    if (composerStartRestartGroup.getApplier() == null) {
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM18018constructorimpl42 = Updater.m18018constructorimpl(composerStartRestartGroup);
                    Updater.m18025setimpl(composerM18018constructorimpl42, layoutDirection42, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion22, composerM18018constructorimpl42, measurePolicyRememberBoxMeasurePolicy2, composerM18018constructorimpl42, density42));
                    function3MaterializerOf42.invoke(AbstractC1038a.m1206g(companion22, composerM18018constructorimpl42, viewConfiguration42, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                    AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, 115715936);
                    content = function2;
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i82 >> 12) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = composerStartRestartGroup;
                    drawerState3 = drawerStateRememberDrawerState;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt.DismissibleNavigationDrawer.3
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

                    public final void invoke(@Nullable Composer composer3, int i9) {
                        NavigationDrawerKt.DismissibleNavigationDrawer(drawerContent, modifier4, drawerState3, z4, content, composer3, i | 1, i2);
                    }
                });
                return;
            }
            i4 |= 3072;
            z2 = z;
            if ((i2 & 16) != 0) {
            }
            if ((46811 & i4) == 9362) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 == 0) {
                    }
                    if ((i2 & 4) == 0) {
                    }
                    modifier3 = modifier5;
                    if (i5 == 0) {
                        z3 = z2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    float f42 = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(NavigationDrawerTokens.INSTANCE.m17745getContainerWidthD9Ej5fM());
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    final CoroutineScope coroutineScope22 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    final String strM17317getStringNWtq2822 = Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17314getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                    Map mapMapOf22 = MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(f42), DrawerValue.Closed), TuplesKt.m13893to(Float.valueOf(0.0f), DrawerValue.Open));
                    Modifier modifierM17335swipeablepPrIpRY22 = SwipeableKt.m17335swipeablepPrIpRY(modifier3, drawerStateRememberDrawerState.getSwipeableState$material3_release(), mapMapOf22, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : new Function2<DrawerValue, DrawerValue, ThresholdConfig>() { // from class: androidx.compose.material3.NavigationDrawerKt.DismissibleNavigationDrawer.1
                        @Override // kotlin.jvm.functions.Function2
                        @NotNull
                        public final ThresholdConfig invoke(@NotNull DrawerValue drawerValue, @NotNull DrawerValue drawerValue2) {
                            Intrinsics.checkNotNullParameter(drawerValue, "<anonymous parameter 0>");
                            Intrinsics.checkNotNullParameter(drawerValue2, "<anonymous parameter 1>");
                            return new FractionalThreshold(0.5f);
                        }
                    }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapMapOf22.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m17334getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    Alignment.Companion companion42 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyM1210k32 = AbstractC1038a.m1210k(companion42, false, composerStartRestartGroup, 0, -1323940314);
                    Density density52 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection52 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration52 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor52 = companion222.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf52 = LayoutKt.materializerOf(modifierM17335swipeablepPrIpRY22);
                    if (composerStartRestartGroup.getApplier() == null) {
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM18018constructorimpl52 = Updater.m18018constructorimpl(composerStartRestartGroup);
                    Updater.m18025setimpl(composerM18018constructorimpl52, layoutDirection52, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion222, composerM18018constructorimpl52, measurePolicyM1210k32, composerM18018constructorimpl52, density52));
                    function3MaterializerOf52.invoke(AbstractC1038a.m1206g(companion222, composerM18018constructorimpl52, viewConfiguration52, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(254773804);
                    MeasurePolicy measurePolicy22 = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2
                        @Override // androidx.compose.p109ui.layout.MeasurePolicy
                        @NotNull
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope Layout, @NotNull List<? extends Measurable> measurables, long j) {
                            Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                            Intrinsics.checkNotNullParameter(measurables, "measurables");
                            final Placeable placeableMo19855measureBRTryo0 = measurables.get(0).mo19855measureBRTryo0(j);
                            final Placeable placeableMo19855measureBRTryo02 = measurables.get(1).mo19855measureBRTryo0(j);
                            int width = placeableMo19855measureBRTryo02.getWidth();
                            int height = placeableMo19855measureBRTryo02.getHeight();
                            final DrawerState drawerState4 = drawerStateRememberDrawerState;
                            return MeasureScope.layout$default(Layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$measure$1
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
                                public final void invoke2(@NotNull Placeable.PlacementScope layout) {
                                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo02, MathKt.roundToInt(drawerState4.getOffset().getValue().floatValue()) + placeableMo19855measureBRTryo0.getWidth(), 0, 0.0f, 4, null);
                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, MathKt.roundToInt(drawerState4.getOffset().getValue().floatValue()), 0, 0.0f, 4, null);
                                }
                            }, 4, null);
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Modifier.Companion companion322 = Modifier.INSTANCE;
                    Density density222 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection222 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration222 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor222 = companion222.getConstructor();
                    int i822 = i4;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf222 = LayoutKt.materializerOf(companion322);
                    if (composerStartRestartGroup.getApplier() == null) {
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM18018constructorimpl222 = Updater.m18018constructorimpl(composerStartRestartGroup);
                    Updater.m18025setimpl(composerM18018constructorimpl222, measurePolicy22, companion222.getSetMeasurePolicy());
                    Updater.m18025setimpl(composerM18018constructorimpl222, density222, companion222.getSetDensity());
                    Updater.m18025setimpl(composerM18018constructorimpl222, layoutDirection222, companion222.getSetLayoutDirection());
                    function3MaterializerOf222.invoke(AbstractC1038a.m1206g(companion222, composerM18018constructorimpl222, viewConfiguration222, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(1983447907);
                    Modifier modifierSemantics$default22 = SemanticsModifierKt.semantics$default(companion322, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1
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
                            SemanticsPropertiesKt.setPaneTitle(semantics, strM17317getStringNWtq2822);
                            if (drawerStateRememberDrawerState.isOpen()) {
                                final DrawerState drawerState4 = drawerStateRememberDrawerState;
                                final CoroutineScope coroutineScope222 = coroutineScope22;
                                SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1.1

                                    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1, reason: invalid class name */
                                    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                    @DebugMetadata(m14020c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1", m14021f = "NavigationDrawer.kt", m14022i = {}, m14023l = {385}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ DrawerState $drawerState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        public AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$drawerState = drawerState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        @NotNull
                                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$drawerState, continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        @Nullable
                                        public final Object invokeSuspend(@NotNull Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                DrawerState drawerState = this.$drawerState;
                                                this.label = 1;
                                                if (drawerState.close(this) == coroutine_suspended) {
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
                                        if (drawerState4.getSwipeableState$material3_release().getConfirmStateChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope222, null, null, new AnonymousClass1(drawerState4, null), 3, null);
                                        }
                                        return Boolean.TRUE;
                                    }
                                }, 1, null);
                            }
                        }
                    }, 1, null);
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyM1210k222 = AbstractC1038a.m1210k(companion42, false, composerStartRestartGroup, 0, -1323940314);
                    Density density322 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection322 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration322 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor322 = companion222.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf322 = LayoutKt.materializerOf(modifierSemantics$default22);
                    if (composerStartRestartGroup.getApplier() == null) {
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM18018constructorimpl322 = Updater.m18018constructorimpl(composerStartRestartGroup);
                    Updater.m18025setimpl(composerM18018constructorimpl322, layoutDirection322, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion222, composerM18018constructorimpl322, measurePolicyM1210k222, composerM18018constructorimpl322, density322));
                    function3MaterializerOf322.invoke(AbstractC1038a.m1206g(companion222, composerM18018constructorimpl322, viewConfiguration322, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                    AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, -170061591);
                    drawerContent.invoke(composerStartRestartGroup, Integer.valueOf(i822 & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(companion42.getTopStart(), false, composerStartRestartGroup, 0);
                    Density density422 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                    LayoutDirection layoutDirection422 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration422 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor422 = companion222.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf422 = LayoutKt.materializerOf(companion322);
                    if (composerStartRestartGroup.getApplier() == null) {
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM18018constructorimpl422 = Updater.m18018constructorimpl(composerStartRestartGroup);
                    Updater.m18025setimpl(composerM18018constructorimpl422, layoutDirection422, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion222, composerM18018constructorimpl422, measurePolicyRememberBoxMeasurePolicy22, composerM18018constructorimpl422, density422));
                    function3MaterializerOf422.invoke(AbstractC1038a.m1206g(companion222, composerM18018constructorimpl422, viewConfiguration422, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                    AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, 115715936);
                    content = function2;
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i822 >> 12) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = composerStartRestartGroup;
                    drawerState3 = drawerStateRememberDrawerState;
                    modifier4 = modifier3;
                    z4 = z3;
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z2 = z;
        if ((i2 & 16) != 0) {
        }
        if ((46811 & i4) == 9362) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011f  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: DrawerSheet-vywBR7E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17241DrawerSheetvywBR7E(final WindowInsets windowInsets, Modifier modifier, Shape shape, long j, long j2, float f, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        final int i4;
        Modifier modifier2;
        int i5;
        Shape rectangleShape;
        long jM17062getSurface0d7_KjU;
        long jM17098contentColorForek8zF_U;
        int i6;
        int i7;
        final float f4;
        float fM17142getPermanentDrawerElevationD9Ej5fM;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape2;
        final long j3;
        final long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(175072821);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(windowInsets) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
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
                    rectangleShape = shape;
                    i4 |= composerStartRestartGroup.changed(rectangleShape) ? 256 : 128;
                }
                if ((i & 7168) == 0) {
                    jM17062getSurface0d7_KjU = j;
                    i4 |= ((i2 & 8) == 0 && composerStartRestartGroup.changed(jM17062getSurface0d7_KjU)) ? 2048 : 1024;
                } else {
                    jM17062getSurface0d7_KjU = j;
                }
                if ((i & 57344) == 0) {
                    if ((i2 & 16) == 0) {
                        jM17098contentColorForek8zF_U = j2;
                        int i10 = composerStartRestartGroup.changed(jM17098contentColorForek8zF_U) ? 16384 : 8192;
                        i4 |= i10;
                    } else {
                        jM17098contentColorForek8zF_U = j2;
                    }
                    i4 |= i10;
                } else {
                    jM17098contentColorForek8zF_U = j2;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                    i7 = 57344;
                    f4 = f;
                } else {
                    i7 = 57344;
                    f4 = f;
                    if ((i & 458752) == 0) {
                        i4 |= composerStartRestartGroup.changed(f4) ? 131072 : 65536;
                    }
                }
                if ((i2 & 64) == 0) {
                    i8 = (i & 3670016) == 0 ? composerStartRestartGroup.changed(function3) ? 1048576 : 524288 : 1572864;
                    if ((i4 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 8) != 0) {
                                jM17062getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m17062getSurface0d7_KjU();
                                i4 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                jM17098contentColorForek8zF_U = ColorSchemeKt.m17098contentColorForek8zF_U(jM17062getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 9) & 14);
                                i4 &= -57345;
                            }
                            if (i6 == 0) {
                                fM17142getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m17142getPermanentDrawerElevationD9Ej5fM();
                            }
                            long j6 = jM17098contentColorForek8zF_U;
                            long j7 = jM17062getSurface0d7_KjU;
                            Shape shape3 = rectangleShape;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(175072821, i4, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:559)");
                            }
                            int i11 = i4 >> 3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m17325SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(SizeKt.m15903sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m17140getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null), shape3, j7, j6, fM17142getPermanentDrawerElevationD9Ej5fM, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1
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
                                    if ((i12 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(959363152, i12, -1, "androidx.compose.material3.DrawerSheet.<anonymous> (NavigationDrawer.kt:579)");
                                    }
                                    Modifier modifierWindowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.m15903sizeInqDBjuR0$default(Modifier.INSTANCE, NavigationDrawerKt.MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m17140getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), windowInsets);
                                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                    int i13 = (i4 >> 9) & 7168;
                                    composer3.startReplaceableGroup(-483455358);
                                    MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer3, 0, -1323940314);
                                    Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierWindowInsetsPadding);
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
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                    composer3.startReplaceableGroup(-1163856341);
                                    function32.invoke(ColumnScopeInstance.INSTANCE, composer3, Integer.valueOf(((i13 >> 6) & 112) | 6));
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, (i11 & 112) | 12582912 | (i11 & 896) | (i11 & 7168) | (i11 & i7), 96);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            shape2 = shape3;
                            j3 = j7;
                            j5 = j6;
                            f4 = fM17142getPermanentDrawerElevationD9Ej5fM;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i4 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i4 &= -57345;
                            }
                        }
                        fM17142getPermanentDrawerElevationD9Ej5fM = f4;
                        long j62 = jM17098contentColorForek8zF_U;
                        long j72 = jM17062getSurface0d7_KjU;
                        Shape shape32 = rectangleShape;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i112 = i4 >> 3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m17325SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(SizeKt.m15903sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m17140getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null), shape32, j72, j62, fM17142getPermanentDrawerElevationD9Ej5fM, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1
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
                                if ((i12 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(959363152, i12, -1, "androidx.compose.material3.DrawerSheet.<anonymous> (NavigationDrawer.kt:579)");
                                }
                                Modifier modifierWindowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.m15903sizeInqDBjuR0$default(Modifier.INSTANCE, NavigationDrawerKt.MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m17140getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), windowInsets);
                                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                int i13 = (i4 >> 9) & 7168;
                                composer3.startReplaceableGroup(-483455358);
                                MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer3, 0, -1323940314);
                                Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierWindowInsetsPadding);
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
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                composer3.startReplaceableGroup(-1163856341);
                                function32.invoke(ColumnScopeInstance.INSTANCE, composer3, Integer.valueOf(((i13 >> 6) & 112) | 6));
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, (i112 & 112) | 12582912 | (i112 & 896) | (i112 & 7168) | (i112 & i7), 96);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier2;
                        shape2 = shape32;
                        j3 = j72;
                        j5 = j62;
                        f4 = fM17142getPermanentDrawerElevationD9Ej5fM;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = jM17062getSurface0d7_KjU;
                        j5 = jM17098contentColorForek8zF_U;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$2
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
                            NavigationDrawerKt.m17241DrawerSheetvywBR7E(windowInsets, modifier3, shape2, j3, j5, f4, function3, composer3, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= i8;
                if ((i4 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i2 & 8) != 0) {
                        }
                        if ((i2 & 16) != 0) {
                        }
                        if (i6 == 0) {
                            fM17142getPermanentDrawerElevationD9Ej5fM = f4;
                        }
                        long j622 = jM17098contentColorForek8zF_U;
                        long j722 = jM17062getSurface0d7_KjU;
                        Shape shape322 = rectangleShape;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i1122 = i4 >> 3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m17325SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(SizeKt.m15903sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m17140getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null), shape322, j722, j622, fM17142getPermanentDrawerElevationD9Ej5fM, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1
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
                                if ((i12 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(959363152, i12, -1, "androidx.compose.material3.DrawerSheet.<anonymous> (NavigationDrawer.kt:579)");
                                }
                                Modifier modifierWindowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.m15903sizeInqDBjuR0$default(Modifier.INSTANCE, NavigationDrawerKt.MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m17140getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), windowInsets);
                                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                int i13 = (i4 >> 9) & 7168;
                                composer3.startReplaceableGroup(-483455358);
                                MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer3, 0, -1323940314);
                                Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierWindowInsetsPadding);
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
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                composer3.startReplaceableGroup(-1163856341);
                                function32.invoke(ColumnScopeInstance.INSTANCE, composer3, Integer.valueOf(((i13 >> 6) & 112) | 6));
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, (i1122 & 112) | 12582912 | (i1122 & 896) | (i1122 & 7168) | (i1122 & i7), 96);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier2;
                        shape2 = shape322;
                        j3 = j722;
                        j5 = j622;
                        f4 = fM17142getPermanentDrawerElevationD9Ej5fM;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            rectangleShape = shape;
            if ((i & 7168) == 0) {
            }
            if ((i & 57344) == 0) {
            }
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            if ((i2 & 64) == 0) {
            }
            i4 |= i8;
            if ((i4 & 2995931) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        rectangleShape = shape;
        if ((i & 7168) == 0) {
        }
        if ((i & 57344) == 0) {
        }
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        if ((i2 & 64) == 0) {
        }
        i4 |= i8;
        if ((i4 & 2995931) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01b8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f6  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ModalDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17242ModalDrawerSheetafqeVBk(@Nullable Modifier modifier, @Nullable Shape shape, long j, long j2, float f, @Nullable WindowInsets windowInsets, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        Shape shape2;
        long jM17062getSurface0d7_KjU;
        long jM17098contentColorForek8zF_U;
        float fM17141getModalDrawerElevationD9Ej5fM;
        int i5;
        WindowInsets windowInsets2;
        final Modifier modifier3;
        WindowInsets windowInsets3;
        final Shape shape3;
        final float f4;
        final long j3;
        final long j5;
        final WindowInsets windowInsets4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1001163336);
        int i7 = i2 & 1;
        if (i7 != 0) {
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
                shape2 = shape;
                int i8 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i4 |= i8;
            } else {
                shape2 = shape;
            }
            i4 |= i8;
        } else {
            shape2 = shape;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                jM17062getSurface0d7_KjU = j;
                int i9 = composerStartRestartGroup.changed(jM17062getSurface0d7_KjU) ? 256 : 128;
                i4 |= i9;
            } else {
                jM17062getSurface0d7_KjU = j;
            }
            i4 |= i9;
        } else {
            jM17062getSurface0d7_KjU = j;
        }
        if ((i & 7168) == 0) {
            jM17098contentColorForek8zF_U = j2;
            i4 |= ((i2 & 8) == 0 && composerStartRestartGroup.changed(jM17098contentColorForek8zF_U)) ? 2048 : 1024;
        } else {
            jM17098contentColorForek8zF_U = j2;
        }
        int i10 = i2 & 16;
        if (i10 != 0) {
            i4 |= 24576;
        } else {
            if ((i & 57344) == 0) {
                fM17141getModalDrawerElevationD9Ej5fM = f;
                i4 |= composerStartRestartGroup.changed(fM17141getModalDrawerElevationD9Ej5fM) ? 16384 : 8192;
            }
            if ((i & 458752) != 0) {
                i5 = 57344;
                windowInsets2 = windowInsets;
                i4 |= ((i2 & 32) == 0 && composerStartRestartGroup.changed(windowInsets2)) ? 131072 : 65536;
            } else {
                i5 = 57344;
                windowInsets2 = windowInsets;
            }
            if ((i2 & 64) != 0) {
                i6 = (i & 3670016) == 0 ? composerStartRestartGroup.changed(content) ? 1048576 : 524288 : 1572864;
                if ((i4 & 2995931) == 599186 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j3 = jM17062getSurface0d7_KjU;
                    j5 = jM17098contentColorForek8zF_U;
                    windowInsets4 = windowInsets2;
                    f4 = fM17141getModalDrawerElevationD9Ej5fM;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier modifier4 = i7 == 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 2) != 0) {
                            Shape shape4 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                            shape2 = shape4;
                        }
                        if ((i2 & 4) != 0) {
                            jM17062getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m17062getSurface0d7_KjU();
                            i4 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM17098contentColorForek8zF_U = ColorSchemeKt.m17098contentColorForek8zF_U(jM17062getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i10 != 0) {
                            fM17141getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m17141getModalDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) == 0) {
                            i4 &= -458753;
                            modifier3 = modifier4;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            shape3 = shape2;
                            f4 = fM17141getModalDrawerElevationD9Ej5fM;
                            long j6 = jM17098contentColorForek8zF_U;
                            int i11 = i4;
                            j3 = jM17062getSurface0d7_KjU;
                            j5 = j6;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1001163336, i11, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:458)");
                            }
                            int i12 = i11 << 3;
                            m17241DrawerSheetvywBR7E(windowInsets3, modifier3, shape3, j3, j5, f4, content, composerStartRestartGroup, (i11 & 3670016) | ((i11 >> 15) & 14) | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (i12 & i5) | (i12 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            windowInsets4 = windowInsets3;
                        } else {
                            modifier3 = modifier4;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                        }
                        if ((i2 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i4 &= -7169;
                        }
                        if ((i2 & 32) != 0) {
                            i4 &= -458753;
                        }
                        modifier3 = modifier2;
                    }
                    shape3 = shape2;
                    windowInsets3 = windowInsets2;
                    f4 = fM17141getModalDrawerElevationD9Ej5fM;
                    long j62 = jM17098contentColorForek8zF_U;
                    int i112 = i4;
                    j3 = jM17062getSurface0d7_KjU;
                    j5 = j62;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i122 = i112 << 3;
                    m17241DrawerSheetvywBR7E(windowInsets3, modifier3, shape3, j3, j5, f4, content, composerStartRestartGroup, (i112 & 3670016) | ((i112 >> 15) & 14) | (i122 & 112) | (i122 & 896) | (i122 & 7168) | (i122 & i5) | (i122 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    windowInsets4 = windowInsets3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalDrawerSheet$1
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

                    public final void invoke(@Nullable Composer composer2, int i13) {
                        NavigationDrawerKt.m17242ModalDrawerSheetafqeVBk(modifier3, shape3, j3, j5, f4, windowInsets4, content, composer2, i | 1, i2);
                    }
                });
                return;
            }
            i4 |= i6;
            if ((i4 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 == 0) {
                    }
                    if ((i2 & 2) != 0) {
                    }
                    if ((i2 & 4) != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i2 & 32) == 0) {
                    }
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        fM17141getModalDrawerElevationD9Ej5fM = f;
        if ((i & 458752) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        i4 |= i6;
        if ((i4 & 2995931) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0424 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0160  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ModalNavigationDrawer-FHprtrg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17243ModalNavigationDrawerFHprtrg(@NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Modifier modifier, @Nullable DrawerState drawerState, boolean z, long j, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        DrawerState drawerStateRememberDrawerState;
        int i5;
        boolean z2;
        Integer num;
        long j2;
        Modifier modifier3;
        final DrawerState drawerState2;
        boolean z3;
        long scrimColor;
        Object objRememberedValue;
        Composer.Companion companion;
        final float f;
        boolean zChanged;
        Object objRememberedValue2;
        boolean zChanged2;
        Object objRememberedValue3;
        final Modifier modifier4;
        final long j3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        final Function2<? super Composer, ? super Integer, Unit> drawerContent = function2;
        Float fValueOf = Float.valueOf(0.0f);
        Intrinsics.checkNotNullParameter(drawerContent, "drawerContent");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1169303680);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(drawerContent) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    drawerStateRememberDrawerState = drawerState;
                    int i8 = composerStartRestartGroup.changed(drawerStateRememberDrawerState) ? 256 : 128;
                    i4 |= i8;
                } else {
                    drawerStateRememberDrawerState = drawerState;
                }
                i4 |= i8;
            } else {
                drawerStateRememberDrawerState = drawerState;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((i & 57344) == 0) {
                    num = 0;
                    j2 = j;
                    i4 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(j2)) ? 16384 : 8192;
                } else {
                    num = 0;
                    j2 = j;
                }
                if ((i2 & 32) == 0) {
                    i6 = (i & 458752) == 0 ? composerStartRestartGroup.changed(content) ? 131072 : 65536 : 196608;
                    if ((i4 & 374491) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                i4 &= -897;
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) == 0) {
                                i4 &= -57345;
                                modifier3 = modifier2;
                                drawerState2 = drawerStateRememberDrawerState;
                                z3 = z2;
                                scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1169303680, i4, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:255)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup), composerStartRestartGroup);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            final String strM17317getStringNWtq28 = Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17314getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                            f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(NavigationDrawerTokens.INSTANCE.m17745getContainerWidthD9Ej5fM());
                            Map mapMapOf = MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(f), DrawerValue.Closed), TuplesKt.m13893to(fValueOf, DrawerValue.Open));
                            Modifier modifierM17335swipeablepPrIpRY = SwipeableKt.m17335swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), drawerState2.getSwipeableState$material3_release(), mapMapOf, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : new Function2<DrawerValue, DrawerValue, ThresholdConfig>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1
                                @Override // kotlin.jvm.functions.Function2
                                @NotNull
                                public final ThresholdConfig invoke(@NotNull DrawerValue drawerValue, @NotNull DrawerValue drawerValue2) {
                                    Intrinsics.checkNotNullParameter(drawerValue, "<anonymous parameter 0>");
                                    Intrinsics.checkNotNullParameter(drawerValue2, "<anonymous parameter 1>");
                                    return new FractionalThreshold(0.5f);
                                }
                            }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapMapOf.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m17334getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                            final boolean z5 = z3;
                            composerStartRestartGroup.startReplaceableGroup(733328855);
                            Alignment.Companion companion2 = Alignment.INSTANCE;
                            Modifier modifier5 = modifier3;
                            int i9 = i4;
                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composerStartRestartGroup, 0, -1323940314);
                            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion3.getConstructor();
                            long j5 = scrimColor;
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM17335swipeablepPrIpRY);
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
                            Integer num2 = num;
                            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, num2);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            composerStartRestartGroup.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-1313342074);
                            composerStartRestartGroup.startReplaceableGroup(733328855);
                            Modifier.Companion companion4 = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion2, false, composerStartRestartGroup, 0, -1323940314);
                            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(companion4);
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
                            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, num2);
                            AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, 573344012);
                            content.invoke(composerStartRestartGroup, Integer.valueOf((i9 >> 15) & 14));
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            boolean zIsOpen = drawerState2.isOpen();
                            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2

                                /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1 */
                                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                @DebugMetadata(m14020c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1", m14021f = "NavigationDrawer.kt", m14022i = {}, m14023l = {295}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                public static final class C18161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ DrawerState $drawerState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public C18161(DrawerState drawerState, Continuation<? super C18161> continuation) {
                                        super(2, continuation);
                                        this.$drawerState = drawerState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    @NotNull
                                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                        return new C18161(this.$drawerState, continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    @Nullable
                                    public final Object invokeSuspend(@NotNull Object obj) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            DrawerState drawerState = this.$drawerState;
                                            this.label = 1;
                                            if (drawerState.close(this) == coroutine_suspended) {
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
                                        return ((C18161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                    if (z5 && drawerState2.getSwipeableState$material3_release().getConfirmStateChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C18161(drawerState2, null), 3, null);
                                    }
                                }
                            };
                            Float fValueOf2 = Float.valueOf(f);
                            composerStartRestartGroup.startReplaceableGroup(1618982084);
                            zChanged = composerStartRestartGroup.changed(fValueOf) | composerStartRestartGroup.changed(fValueOf2) | composerStartRestartGroup.changed(drawerState2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                                final float f4 = 0.0f;
                                objRememberedValue2 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    @NotNull
                                    public final Float invoke() {
                                        return Float.valueOf(NavigationDrawerKt.calculateFraction(f, f4, drawerState2.getOffset().getValue().floatValue()));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            m17245ScrimBx497Mc(zIsOpen, function0, (Function0) objRememberedValue2, j5, composerStartRestartGroup, (i9 >> 3) & 7168);
                            composerStartRestartGroup.startReplaceableGroup(1157296644);
                            zChanged2 = composerStartRestartGroup.changed(drawerState2);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                                objRememberedValue3 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                                        return IntOffset.m21087boximpl(m17248invokeBjo55l4(density3));
                                    }

                                    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                                    public final long m17248invokeBjo55l4(@NotNull Density offset) {
                                        Intrinsics.checkNotNullParameter(offset, "$this$offset");
                                        return IntOffsetKt.IntOffset(MathKt.roundToInt(drawerState2.getOffset().getValue().floatValue()), 0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion4, (Function1) objRememberedValue3), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5
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
                                    SemanticsPropertiesKt.setPaneTitle(semantics, strM17317getStringNWtq28);
                                    if (drawerState2.isOpen()) {
                                        final DrawerState drawerState3 = drawerState2;
                                        final CoroutineScope coroutineScope2 = coroutineScope;
                                        SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5.1

                                            /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1, reason: invalid class name */
                                            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                            @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                            @DebugMetadata(m14020c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1", m14021f = "NavigationDrawer.kt", m14022i = {}, m14023l = {314}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ DrawerState $drawerState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                public AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                                    super(2, continuation);
                                                    this.$drawerState = drawerState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                @NotNull
                                                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                    return new AnonymousClass1(this.$drawerState, continuation);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                @Nullable
                                                public final Object invokeSuspend(@NotNull Object obj) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    int i = this.label;
                                                    if (i == 0) {
                                                        ResultKt.throwOnFailure(obj);
                                                        DrawerState drawerState = this.$drawerState;
                                                        this.label = 1;
                                                        if (drawerState.close(this) == coroutine_suspended) {
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
                                                if (drawerState3.getSwipeableState$material3_release().getConfirmStateChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                                }
                                                return Boolean.TRUE;
                                            }
                                        }, 1, null);
                                    }
                                }
                            }, 1, null);
                            composerStartRestartGroup.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyM1210k3 = AbstractC1038a.m1210k(companion2, false, composerStartRestartGroup, 0, -1323940314);
                            Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierSemantics$default);
                            if (composerStartRestartGroup.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.useNode();
                            } else {
                                composerStartRestartGroup.createNode(constructor3);
                            }
                            composerStartRestartGroup.disableReusing();
                            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composerStartRestartGroup);
                            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl3, measurePolicyM1210k3, composerM18018constructorimpl3, density3));
                            function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, num2);
                            AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, 381037187);
                            drawerContent = function2;
                            drawerContent.invoke(composerStartRestartGroup, Integer.valueOf(i9 & 14));
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
                            modifier4 = modifier5;
                            j3 = j5;
                            z4 = z5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i2 & 16) != 0) {
                                i4 &= -57345;
                            }
                        }
                        long j6 = j2;
                        drawerState2 = drawerStateRememberDrawerState;
                        scrimColor = j6;
                        modifier3 = modifier2;
                        z3 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        final String strM17317getStringNWtq282 = Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17314getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                        f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(NavigationDrawerTokens.INSTANCE.m17745getContainerWidthD9Ej5fM());
                        Map mapMapOf2 = MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(f), DrawerValue.Closed), TuplesKt.m13893to(fValueOf, DrawerValue.Open));
                        Modifier modifierM17335swipeablepPrIpRY2 = SwipeableKt.m17335swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), drawerState2.getSwipeableState$material3_release(), mapMapOf2, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : new Function2<DrawerValue, DrawerValue, ThresholdConfig>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1
                            @Override // kotlin.jvm.functions.Function2
                            @NotNull
                            public final ThresholdConfig invoke(@NotNull DrawerValue drawerValue, @NotNull DrawerValue drawerValue2) {
                                Intrinsics.checkNotNullParameter(drawerValue, "<anonymous parameter 0>");
                                Intrinsics.checkNotNullParameter(drawerValue2, "<anonymous parameter 1>");
                                return new FractionalThreshold(0.5f);
                            }
                        }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapMapOf2.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m17334getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                        final boolean z52 = z3;
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        Alignment.Companion companion22 = Alignment.INSTANCE;
                        Modifier modifier52 = modifier3;
                        int i92 = i4;
                        MeasurePolicy measurePolicyM1210k4 = AbstractC1038a.m1210k(companion22, false, composerStartRestartGroup, 0, -1323940314);
                        Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor4 = companion32.getConstructor();
                        long j52 = scrimColor;
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierM17335swipeablepPrIpRY2);
                        if (composerStartRestartGroup.getApplier() == null) {
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM18018constructorimpl4 = Updater.m18018constructorimpl(composerStartRestartGroup);
                        Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion32, composerM18018constructorimpl4, measurePolicyM1210k4, composerM18018constructorimpl4, density4));
                        Integer num22 = num;
                        function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion32, composerM18018constructorimpl4, viewConfiguration4, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, num22);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-1313342074);
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        Modifier.Companion companion42 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyM1210k22 = AbstractC1038a.m1210k(companion22, false, composerStartRestartGroup, 0, -1323940314);
                        Density density22 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection22 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration22 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        Function0<ComposeUiNode> constructor22 = companion32.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf22 = LayoutKt.materializerOf(companion42);
                        if (composerStartRestartGroup.getApplier() == null) {
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM18018constructorimpl22 = Updater.m18018constructorimpl(composerStartRestartGroup);
                        Updater.m18025setimpl(composerM18018constructorimpl22, layoutDirection22, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion32, composerM18018constructorimpl22, measurePolicyM1210k22, composerM18018constructorimpl22, density22));
                        function3MaterializerOf22.invoke(AbstractC1038a.m1206g(companion32, composerM18018constructorimpl22, viewConfiguration22, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, num22);
                        AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, 573344012);
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i92 >> 15) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        boolean zIsOpen2 = drawerState2.isOpen();
                        Function0<Unit> function02 = new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2

                            /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1 */
                            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                            @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                            @DebugMetadata(m14020c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1", m14021f = "NavigationDrawer.kt", m14022i = {}, m14023l = {295}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                            public static final class C18161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public C18161(DrawerState drawerState, Continuation<? super C18161> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                @NotNull
                                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                    return new C18161(this.$drawerState, continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                @Nullable
                                public final Object invokeSuspend(@NotNull Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        DrawerState drawerState = this.$drawerState;
                                        this.label = 1;
                                        if (drawerState.close(this) == coroutine_suspended) {
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
                                    return ((C18161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                if (z52 && drawerState2.getSwipeableState$material3_release().getConfirmStateChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C18161(drawerState2, null), 3, null);
                                }
                            }
                        };
                        Float fValueOf22 = Float.valueOf(f);
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(fValueOf) | composerStartRestartGroup.changed(fValueOf22) | composerStartRestartGroup.changed(drawerState2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            final float f42 = 0.0f;
                            objRememberedValue2 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                @NotNull
                                public final Float invoke() {
                                    return Float.valueOf(NavigationDrawerKt.calculateFraction(f, f42, drawerState2.getOffset().getValue().floatValue()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            composerStartRestartGroup.endReplaceableGroup();
                            m17245ScrimBx497Mc(zIsOpen2, function02, (Function0) objRememberedValue2, j52, composerStartRestartGroup, (i92 >> 3) & 7168);
                            composerStartRestartGroup.startReplaceableGroup(1157296644);
                            zChanged2 = composerStartRestartGroup.changed(drawerState2);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2) {
                                objRememberedValue3 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density32) {
                                        return IntOffset.m21087boximpl(m17248invokeBjo55l4(density32));
                                    }

                                    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                                    public final long m17248invokeBjo55l4(@NotNull Density offset) {
                                        Intrinsics.checkNotNullParameter(offset, "$this$offset");
                                        return IntOffsetKt.IntOffset(MathKt.roundToInt(drawerState2.getOffset().getValue().floatValue()), 0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                composerStartRestartGroup.endReplaceableGroup();
                                Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion42, (Function1) objRememberedValue3), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5
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
                                        SemanticsPropertiesKt.setPaneTitle(semantics, strM17317getStringNWtq282);
                                        if (drawerState2.isOpen()) {
                                            final DrawerState drawerState3 = drawerState2;
                                            final CoroutineScope coroutineScope22 = coroutineScope2;
                                            SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5.1

                                                /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1, reason: invalid class name */
                                                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                                @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                                @DebugMetadata(m14020c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1", m14021f = "NavigationDrawer.kt", m14022i = {}, m14023l = {314}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ DrawerState $drawerState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    public AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                                        super(2, continuation);
                                                        this.$drawerState = drawerState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    @NotNull
                                                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                                        return new AnonymousClass1(this.$drawerState, continuation);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    @Nullable
                                                    public final Object invokeSuspend(@NotNull Object obj) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        int i = this.label;
                                                        if (i == 0) {
                                                            ResultKt.throwOnFailure(obj);
                                                            DrawerState drawerState = this.$drawerState;
                                                            this.label = 1;
                                                            if (drawerState.close(this) == coroutine_suspended) {
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
                                                    if (drawerState3.getSwipeableState$material3_release().getConfirmStateChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                                    }
                                                    return Boolean.TRUE;
                                                }
                                            }, 1, null);
                                        }
                                    }
                                }, 1, null);
                                composerStartRestartGroup.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyM1210k32 = AbstractC1038a.m1210k(companion22, false, composerStartRestartGroup, 0, -1323940314);
                                Density density32 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection32 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration32 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                Function0<ComposeUiNode> constructor32 = companion32.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf32 = LayoutKt.materializerOf(modifierSemantics$default2);
                                if (composerStartRestartGroup.getApplier() == null) {
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                }
                                composerStartRestartGroup.disableReusing();
                                Composer composerM18018constructorimpl32 = Updater.m18018constructorimpl(composerStartRestartGroup);
                                Updater.m18025setimpl(composerM18018constructorimpl32, layoutDirection32, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion32, composerM18018constructorimpl32, measurePolicyM1210k32, composerM18018constructorimpl32, density32));
                                function3MaterializerOf32.invoke(AbstractC1038a.m1206g(companion32, composerM18018constructorimpl32, viewConfiguration32, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, num22);
                                AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, 381037187);
                                drawerContent = function2;
                                drawerContent.invoke(composerStartRestartGroup, Integer.valueOf(i92 & 14));
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
                                }
                                modifier4 = modifier52;
                                j3 = j52;
                                z4 = z52;
                            }
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j3 = j2;
                        modifier4 = modifier2;
                        drawerState2 = drawerStateRememberDrawerState;
                        z4 = z2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num3) {
                            invoke(composer2, num3.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer2, int i10) {
                            NavigationDrawerKt.m17243ModalNavigationDrawerFHprtrg(drawerContent, modifier4, drawerState2, z4, j3, content, composer2, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= i6;
                if ((i4 & 374491) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                        }
                        if ((i2 & 4) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i2 & 16) == 0) {
                            long j62 = j2;
                            drawerState2 = drawerStateRememberDrawerState;
                            scrimColor = j62;
                            modifier3 = modifier2;
                            z3 = z2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        final CoroutineScope coroutineScope22 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        final String strM17317getStringNWtq2822 = Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17314getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                        f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(NavigationDrawerTokens.INSTANCE.m17745getContainerWidthD9Ej5fM());
                        Map mapMapOf22 = MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(f), DrawerValue.Closed), TuplesKt.m13893to(fValueOf, DrawerValue.Open));
                        Modifier modifierM17335swipeablepPrIpRY22 = SwipeableKt.m17335swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), drawerState2.getSwipeableState$material3_release(), mapMapOf22, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : new Function2<DrawerValue, DrawerValue, ThresholdConfig>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1
                            @Override // kotlin.jvm.functions.Function2
                            @NotNull
                            public final ThresholdConfig invoke(@NotNull DrawerValue drawerValue, @NotNull DrawerValue drawerValue2) {
                                Intrinsics.checkNotNullParameter(drawerValue, "<anonymous parameter 0>");
                                Intrinsics.checkNotNullParameter(drawerValue2, "<anonymous parameter 1>");
                                return new FractionalThreshold(0.5f);
                            }
                        }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapMapOf22.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m17334getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                        final boolean z522 = z3;
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        Alignment.Companion companion222 = Alignment.INSTANCE;
                        Modifier modifier522 = modifier3;
                        int i922 = i4;
                        MeasurePolicy measurePolicyM1210k42 = AbstractC1038a.m1210k(companion222, false, composerStartRestartGroup, 0, -1323940314);
                        Density density42 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection42 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration42 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion322 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor42 = companion322.getConstructor();
                        long j522 = scrimColor;
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf42 = LayoutKt.materializerOf(modifierM17335swipeablepPrIpRY22);
                        if (composerStartRestartGroup.getApplier() == null) {
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM18018constructorimpl42 = Updater.m18018constructorimpl(composerStartRestartGroup);
                        Updater.m18025setimpl(composerM18018constructorimpl42, layoutDirection42, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion322, composerM18018constructorimpl42, measurePolicyM1210k42, composerM18018constructorimpl42, density42));
                        Integer num222 = num;
                        function3MaterializerOf42.invoke(AbstractC1038a.m1206g(companion322, composerM18018constructorimpl42, viewConfiguration42, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, num222);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-1313342074);
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        Modifier.Companion companion422 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyM1210k222 = AbstractC1038a.m1210k(companion222, false, composerStartRestartGroup, 0, -1323940314);
                        Density density222 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection222 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration222 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        Function0<ComposeUiNode> constructor222 = companion322.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf222 = LayoutKt.materializerOf(companion422);
                        if (composerStartRestartGroup.getApplier() == null) {
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM18018constructorimpl222 = Updater.m18018constructorimpl(composerStartRestartGroup);
                        Updater.m18025setimpl(composerM18018constructorimpl222, layoutDirection222, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion322, composerM18018constructorimpl222, measurePolicyM1210k222, composerM18018constructorimpl222, density222));
                        function3MaterializerOf222.invoke(AbstractC1038a.m1206g(companion322, composerM18018constructorimpl222, viewConfiguration222, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, num222);
                        AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, 573344012);
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i922 >> 15) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        boolean zIsOpen22 = drawerState2.isOpen();
                        Function0<Unit> function022 = new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2

                            /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1 */
                            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                            @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                            @DebugMetadata(m14020c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1", m14021f = "NavigationDrawer.kt", m14022i = {}, m14023l = {295}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                            public static final class C18161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public C18161(DrawerState drawerState, Continuation<? super C18161> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                @NotNull
                                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                    return new C18161(this.$drawerState, continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                @Nullable
                                public final Object invokeSuspend(@NotNull Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        DrawerState drawerState = this.$drawerState;
                                        this.label = 1;
                                        if (drawerState.close(this) == coroutine_suspended) {
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
                                    return ((C18161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                if (z522 && drawerState2.getSwipeableState$material3_release().getConfirmStateChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new C18161(drawerState2, null), 3, null);
                                }
                            }
                        };
                        Float fValueOf222 = Float.valueOf(f);
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(fValueOf) | composerStartRestartGroup.changed(fValueOf222) | composerStartRestartGroup.changed(drawerState2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 57344) == 0) {
            }
            if ((i2 & 32) == 0) {
            }
            i4 |= i6;
            if ((i4 & 374491) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i & 57344) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        i4 |= i6;
        if ((i4 & 374491) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0283 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationDrawerItem(@NotNull final Function2<? super Composer, ? super Integer, Unit> label, final boolean z, @NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Shape shape, @Nullable NavigationDrawerItemColors navigationDrawerItemColors, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Shape shape2;
        NavigationDrawerItemColors navigationDrawerItemColors2;
        int i7;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        Shape shape3;
        NavigationDrawerItemColors navigationDrawerItemColorsM17239colorsoq7We08;
        int i9;
        int i10;
        Shape shape4;
        Composer composer2;
        final Shape shape5;
        final MutableInteractionSource mutableInteractionSource3;
        final NavigationDrawerItemColors navigationDrawerItemColors3;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1304626543);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(label) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(onClick) ? 256 : 128;
        }
        int i11 = i2 & 8;
        if (i11 != 0) {
            i4 |= 3072;
        } else {
            if ((i & 7168) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i5 = i2 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((i & 57344) == 0) {
                    function23 = function2;
                    i4 |= composerStartRestartGroup.changed(function23) ? 16384 : 8192;
                }
                i6 = i2 & 32;
                if (i6 == 0) {
                    if ((458752 & i) == 0) {
                        function24 = function22;
                        i4 |= composerStartRestartGroup.changed(function24) ? 131072 : 65536;
                    }
                    if ((3670016 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            shape2 = shape;
                            int i12 = composerStartRestartGroup.changed(shape2) ? 1048576 : 524288;
                            i4 |= i12;
                        } else {
                            shape2 = shape;
                        }
                        i4 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    if ((29360128 & i) != 0) {
                        if ((i2 & 128) == 0) {
                            navigationDrawerItemColors2 = navigationDrawerItemColors;
                            int i13 = composerStartRestartGroup.changed(navigationDrawerItemColors2) ? 8388608 : 4194304;
                            i4 |= i13;
                        } else {
                            navigationDrawerItemColors2 = navigationDrawerItemColors;
                        }
                        i4 |= i13;
                    } else {
                        navigationDrawerItemColors2 = navigationDrawerItemColors;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i4 |= 100663296;
                        i8 = i11;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        i8 = i11;
                        mutableInteractionSource2 = mutableInteractionSource;
                        if ((i & 234881024) == 0) {
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432;
                        }
                    }
                    if ((i4 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            modifier3 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function27 = i5 == 0 ? null : function23;
                            Function2<? super Composer, ? super Integer, Unit> function28 = i6 == 0 ? null : function24;
                            if ((i2 & 64) == 0) {
                                i4 &= -3670017;
                                shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            } else {
                                shape3 = shape2;
                            }
                            int i14 = i4;
                            if ((i2 & 128) == 0) {
                                navigationDrawerItemColorsM17239colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m17239colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                                composerStartRestartGroup = composerStartRestartGroup;
                                i9 = i14 & (-29360129);
                            } else {
                                navigationDrawerItemColorsM17239colorsoq7We08 = navigationDrawerItemColors2;
                                i9 = i14;
                            }
                            if (i7 == 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                int i15 = i9;
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                i10 = i15;
                                function23 = function27;
                                function24 = function28;
                                shape4 = shape3;
                            } else {
                                i10 = i9;
                                function23 = function27;
                                function24 = function28;
                                shape4 = shape3;
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 64) != 0) {
                                i4 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i4 &= -29360129;
                            }
                            i10 = i4;
                            modifier3 = modifier2;
                            shape4 = shape2;
                            navigationDrawerItemColorsM17239colorsoq7We08 = navigationDrawerItemColors2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:659)");
                        }
                        int i16 = i10 >> 3;
                        final int i17 = i10;
                        final NavigationDrawerItemColors navigationDrawerItemColors4 = navigationDrawerItemColorsM17239colorsoq7We08;
                        final Function2<? super Composer, ? super Integer, Unit> function29 = function23;
                        final Function2<? super Composer, ? super Integer, Unit> function210 = function24;
                        MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                        Modifier modifier5 = modifier3;
                        SurfaceKt.m17326Surfaced85dljk(z, onClick, SizeKt.fillMaxWidth$default(SizeKt.m15885height3ABfNKs(modifier3, NavigationDrawerTokens.INSTANCE.m17743getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColorsM17239colorsoq7We08.containerColor(z, composerStartRestartGroup, (i16 & 14) | ((i10 >> 18) & 112)).getValue().m18535unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource4, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt.NavigationDrawerItem.2
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
                            public final void invoke(@Nullable Composer composer3, int i18) {
                                if ((i18 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(191488423, i18, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:679)");
                                }
                                Modifier.Companion companion = Modifier.INSTANCE;
                                Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(companion, C2256Dp.m20968constructorimpl(16), 0.0f, C2256Dp.m20968constructorimpl(24), 0.0f, 10, null);
                                Alignment.Companion companion2 = Alignment.INSTANCE;
                                Alignment.Vertical centerVertically = companion2.getCenterVertically();
                                Function2<Composer, Integer, Unit> function211 = function29;
                                NavigationDrawerItemColors navigationDrawerItemColors5 = navigationDrawerItemColors4;
                                boolean z2 = z;
                                int i19 = i17;
                                Function2<Composer, Integer, Unit> function212 = function210;
                                Function2<Composer, Integer, Unit> function213 = label;
                                composer3.startReplaceableGroup(693286680);
                                MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composer3, 48, -1323940314);
                                Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
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
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
                                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                composer3.startReplaceableGroup(-678309503);
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                composer3.startReplaceableGroup(1789891011);
                                composer3.startReplaceableGroup(-1538531826);
                                if (function211 != null) {
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(navigationDrawerItemColors5.iconColor(z2, composer3, ((i19 >> 3) & 14) | ((i19 >> 18) & 112)).getValue().m18535unboximpl()))}, function211, composer3, ((i19 >> 9) & 112) | 8);
                                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, C2256Dp.m20968constructorimpl(12)), composer3, 6);
                                }
                                composer3.endReplaceableGroup();
                                Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
                                composer3.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composer3, 0, -1323940314);
                                Density density2 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                                if (composer3.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor2);
                                } else {
                                    composer3.useNode();
                                }
                                composer3.disableReusing();
                                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer3);
                                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer3, composer3), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                composer3.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer3.startReplaceableGroup(-1847258627);
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(navigationDrawerItemColors5.textColor(z2, composer3, ((i19 >> 3) & 14) | ((i19 >> 18) & 112)).getValue().m18535unboximpl()))}, function213, composer3, ((i19 << 3) & 112) | 8);
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (function212 != null) {
                                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, C2256Dp.m20968constructorimpl(12)), composer3, 6);
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(navigationDrawerItemColors5.badgeColor(z2, composer3, ((i19 >> 3) & 14) | ((i19 >> 18) & 112)).getValue().m18535unboximpl()))}, function212, composer3, ((i19 >> 12) & 112) | 8);
                                }
                                if (AbstractC1038a.m1225z(composer3)) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composerStartRestartGroup, (i16 & 126) | ((i17 >> 6) & 57344), ((i17 >> 24) & 14) | 48, 968);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape5 = shape4;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        navigationDrawerItemColors3 = navigationDrawerItemColors4;
                        modifier4 = modifier5;
                        function25 = function29;
                        function26 = function210;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier2;
                        function25 = function23;
                        function26 = function24;
                        shape5 = shape2;
                        composer2 = composerStartRestartGroup;
                        navigationDrawerItemColors3 = navigationDrawerItemColors2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt.NavigationDrawerItem.3
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

                        public final void invoke(@Nullable Composer composer3, int i18) {
                            NavigationDrawerKt.NavigationDrawerItem(label, z, onClick, modifier4, function25, function26, shape5, navigationDrawerItemColors3, mutableInteractionSource3, composer3, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= 196608;
                function24 = function22;
                if ((3670016 & i) != 0) {
                }
                if ((29360128 & i) != 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                if ((i4 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 64) == 0) {
                        }
                        int i142 = i4;
                        if ((i2 & 128) == 0) {
                        }
                        if (i7 == 0) {
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i162 = i10 >> 3;
                        final int i172 = i10;
                        final NavigationDrawerItemColors navigationDrawerItemColors42 = navigationDrawerItemColorsM17239colorsoq7We08;
                        final Function2<? super Composer, ? super Integer, Unit> function292 = function23;
                        final Function2<? super Composer, ? super Integer, Unit> function2102 = function24;
                        MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                        Modifier modifier52 = modifier3;
                        SurfaceKt.m17326Surfaced85dljk(z, onClick, SizeKt.fillMaxWidth$default(SizeKt.m15885height3ABfNKs(modifier3, NavigationDrawerTokens.INSTANCE.m17743getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColorsM17239colorsoq7We08.containerColor(z, composerStartRestartGroup, (i162 & 14) | ((i10 >> 18) & 112)).getValue().m18535unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource42, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt.NavigationDrawerItem.2
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
                            public final void invoke(@Nullable Composer composer3, int i18) {
                                if ((i18 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(191488423, i18, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:679)");
                                }
                                Modifier.Companion companion = Modifier.INSTANCE;
                                Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(companion, C2256Dp.m20968constructorimpl(16), 0.0f, C2256Dp.m20968constructorimpl(24), 0.0f, 10, null);
                                Alignment.Companion companion2 = Alignment.INSTANCE;
                                Alignment.Vertical centerVertically = companion2.getCenterVertically();
                                Function2<Composer, Integer, Unit> function211 = function292;
                                NavigationDrawerItemColors navigationDrawerItemColors5 = navigationDrawerItemColors42;
                                boolean z2 = z;
                                int i19 = i172;
                                Function2<Composer, Integer, Unit> function212 = function2102;
                                Function2<Composer, Integer, Unit> function213 = label;
                                composer3.startReplaceableGroup(693286680);
                                MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composer3, 48, -1323940314);
                                Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
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
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
                                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                composer3.startReplaceableGroup(-678309503);
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                composer3.startReplaceableGroup(1789891011);
                                composer3.startReplaceableGroup(-1538531826);
                                if (function211 != null) {
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(navigationDrawerItemColors5.iconColor(z2, composer3, ((i19 >> 3) & 14) | ((i19 >> 18) & 112)).getValue().m18535unboximpl()))}, function211, composer3, ((i19 >> 9) & 112) | 8);
                                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, C2256Dp.m20968constructorimpl(12)), composer3, 6);
                                }
                                composer3.endReplaceableGroup();
                                Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
                                composer3.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composer3, 0, -1323940314);
                                Density density2 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                                if (composer3.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor2);
                                } else {
                                    composer3.useNode();
                                }
                                composer3.disableReusing();
                                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer3);
                                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer3, composer3), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                composer3.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer3.startReplaceableGroup(-1847258627);
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(navigationDrawerItemColors5.textColor(z2, composer3, ((i19 >> 3) & 14) | ((i19 >> 18) & 112)).getValue().m18535unboximpl()))}, function213, composer3, ((i19 << 3) & 112) | 8);
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (function212 != null) {
                                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, C2256Dp.m20968constructorimpl(12)), composer3, 6);
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(navigationDrawerItemColors5.badgeColor(z2, composer3, ((i19 >> 3) & 14) | ((i19 >> 18) & 112)).getValue().m18535unboximpl()))}, function212, composer3, ((i19 >> 12) & 112) | 8);
                                }
                                if (AbstractC1038a.m1225z(composer3)) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composerStartRestartGroup, (i162 & 126) | ((i172 >> 6) & 57344), ((i172 >> 24) & 14) | 48, 968);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        shape5 = shape4;
                        mutableInteractionSource3 = mutableInteractionSource42;
                        navigationDrawerItemColors3 = navigationDrawerItemColors42;
                        modifier4 = modifier52;
                        function25 = function292;
                        function26 = function2102;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function23 = function2;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            function24 = function22;
            if ((3670016 & i) != 0) {
            }
            if ((29360128 & i) != 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            if ((i4 & 191739611) == 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        function23 = function2;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        function24 = function22;
        if ((3670016 & i) != 0) {
        }
        if ((29360128 & i) != 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        if ((i4 & 191739611) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f9  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: PermanentDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17244PermanentDrawerSheetafqeVBk(@Nullable Modifier modifier, @Nullable Shape shape, long j, long j2, float f, @Nullable WindowInsets windowInsets, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        Shape rectangleShape;
        long jM17062getSurface0d7_KjU;
        long jM17098contentColorForek8zF_U;
        int i5;
        float fM17142getPermanentDrawerElevationD9Ej5fM;
        int i6;
        WindowInsets windowInsets2;
        Modifier modifier3;
        WindowInsets windowInsets3;
        final Shape shape2;
        final long j3;
        final long j5;
        final float f4;
        final String strM17317getStringNWtq28;
        boolean zChanged;
        Object objRememberedValue;
        final WindowInsets windowInsets4;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1733353241);
        int i8 = i2 & 1;
        if (i8 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                rectangleShape = shape;
                i4 |= composerStartRestartGroup.changed(rectangleShape) ? 32 : 16;
            }
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    jM17062getSurface0d7_KjU = j;
                    int i10 = composerStartRestartGroup.changed(jM17062getSurface0d7_KjU) ? 256 : 128;
                    i4 |= i10;
                } else {
                    jM17062getSurface0d7_KjU = j;
                }
                i4 |= i10;
            } else {
                jM17062getSurface0d7_KjU = j;
            }
            if ((i & 7168) != 0) {
                if ((i2 & 8) == 0) {
                    jM17098contentColorForek8zF_U = j2;
                    int i11 = composerStartRestartGroup.changed(jM17098contentColorForek8zF_U) ? 2048 : 1024;
                    i4 |= i11;
                } else {
                    jM17098contentColorForek8zF_U = j2;
                }
                i4 |= i11;
            } else {
                jM17098contentColorForek8zF_U = j2;
            }
            i5 = i2 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((i & 57344) == 0) {
                    fM17142getPermanentDrawerElevationD9Ej5fM = f;
                    i4 |= composerStartRestartGroup.changed(fM17142getPermanentDrawerElevationD9Ej5fM) ? 16384 : 8192;
                }
                if ((i & 458752) == 0) {
                    i6 = 57344;
                    windowInsets2 = windowInsets;
                    i4 |= ((i2 & 32) == 0 && composerStartRestartGroup.changed(windowInsets2)) ? 131072 : 65536;
                } else {
                    i6 = 57344;
                    windowInsets2 = windowInsets;
                }
                if ((i2 & 64) == 0) {
                    i7 = (i & 3670016) == 0 ? composerStartRestartGroup.changed(content) ? 1048576 : 524288 : 1572864;
                    if ((i4 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier5 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i9 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 4) != 0) {
                                jM17062getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m17062getSurface0d7_KjU();
                                i4 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                jM17098contentColorForek8zF_U = ColorSchemeKt.m17098contentColorForek8zF_U(jM17062getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 6) & 14);
                                i4 &= -7169;
                            }
                            if (i5 != 0) {
                                fM17142getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m17142getPermanentDrawerElevationD9Ej5fM();
                            }
                            if ((i2 & 32) == 0) {
                                i4 &= -458753;
                                modifier3 = modifier5;
                                windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                                shape2 = rectangleShape;
                                long j6 = jM17098contentColorForek8zF_U;
                                int i12 = i4;
                                j3 = jM17062getSurface0d7_KjU;
                                j5 = j6;
                                f4 = fM17142getPermanentDrawerElevationD9Ej5fM;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1733353241, i12, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:534)");
                                }
                                strM17317getStringNWtq28 = Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17314getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                                composerStartRestartGroup.startReplaceableGroup(1157296644);
                                zChanged = composerStartRestartGroup.changed(strM17317getStringNWtq28);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
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
                                            SemanticsPropertiesKt.setPaneTitle(semantics, strM17317getStringNWtq28);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, null);
                                int i13 = i12 << 3;
                                m17241DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default, shape2, j3, j5, f4, content, composerStartRestartGroup, (i12 & 3670016) | ((i12 >> 15) & 14) | (i13 & 896) | (i13 & 7168) | (i13 & i6) | (i13 & 458752), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                windowInsets4 = windowInsets3;
                                modifier4 = modifier3;
                            } else {
                                modifier3 = modifier5;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i4 &= -7169;
                            }
                            if ((i2 & 32) != 0) {
                                i4 &= -458753;
                            }
                            modifier3 = modifier2;
                        }
                        shape2 = rectangleShape;
                        windowInsets3 = windowInsets2;
                        long j62 = jM17098contentColorForek8zF_U;
                        int i122 = i4;
                        j3 = jM17062getSurface0d7_KjU;
                        j5 = j62;
                        f4 = fM17142getPermanentDrawerElevationD9Ej5fM;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        strM17317getStringNWtq28 = Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17314getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(strM17317getStringNWtq28);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
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
                                    SemanticsPropertiesKt.setPaneTitle(semantics, strM17317getStringNWtq28);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, null);
                            int i132 = i122 << 3;
                            m17241DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default2, shape2, j3, j5, f4, content, composerStartRestartGroup, (i122 & 3670016) | ((i122 >> 15) & 14) | (i132 & 896) | (i132 & 7168) | (i132 & i6) | (i132 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            windowInsets4 = windowInsets3;
                            modifier4 = modifier3;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        shape2 = rectangleShape;
                        j3 = jM17062getSurface0d7_KjU;
                        j5 = jM17098contentColorForek8zF_U;
                        windowInsets4 = windowInsets2;
                        f4 = fM17142getPermanentDrawerElevationD9Ej5fM;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$2
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

                        public final void invoke(@Nullable Composer composer2, int i14) {
                            NavigationDrawerKt.m17244PermanentDrawerSheetafqeVBk(modifier4, shape2, j3, j5, f4, windowInsets4, content, composer2, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= i7;
                if ((i4 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 == 0) {
                        }
                        if (i9 != 0) {
                        }
                        if ((i2 & 4) != 0) {
                        }
                        if ((i2 & 8) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i2 & 32) == 0) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            fM17142getPermanentDrawerElevationD9Ej5fM = f;
            if ((i & 458752) == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            i4 |= i7;
            if ((i4 & 2995931) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        rectangleShape = shape;
        if ((i & 896) != 0) {
        }
        if ((i & 7168) != 0) {
        }
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        fM17142getPermanentDrawerElevationD9Ej5fM = f;
        if ((i & 458752) == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        i4 |= i7;
        if ((i4 & 2995931) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01cd  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PermanentNavigationDrawer(@NotNull final Function2<? super Composer, ? super Integer, Unit> drawerContent, @Nullable Modifier modifier, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(drawerContent, "drawerContent");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-276843608);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(drawerContent) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i4 |= 384;
            } else if ((i & 896) == 0) {
                i4 |= composerStartRestartGroup.changed(content) ? 256 : 128;
            }
            if ((i4 & 731) == 146 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-276843608, i4, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:427)");
                }
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
                composerStartRestartGroup.startReplaceableGroup(693286680);
                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                Alignment.Companion companion = Alignment.INSTANCE;
                MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(companion, start, composerStartRestartGroup, 0, -1323940314);
                Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxSize$default);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(constructor);
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1208i, composerM18018constructorimpl, density));
                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-678309503);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(109704460);
                drawerContent.invoke(composerStartRestartGroup, Integer.valueOf(i4 & 14));
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Modifier.Companion companion3 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion, false, composerStartRestartGroup, 0, -1323940314);
                Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(companion3);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(constructor2);
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(612624658);
                content.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 6) & 14));
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
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt.PermanentNavigationDrawer.2
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

                public final void invoke(@Nullable Composer composer2, int i6) {
                    NavigationDrawerKt.PermanentNavigationDrawer(drawerContent, modifier3, content, composer2, i | 1, i2);
                }
            });
            return;
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i2 & 4) == 0) {
        }
        if ((i4 & 731) == 146) {
            if (i5 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
            composerStartRestartGroup.startReplaceableGroup(693286680);
            Arrangement.Horizontal start2 = Arrangement.INSTANCE.getStart();
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyM1208i2 = AbstractC1038a.m1208i(companion4, start2, composerStartRestartGroup, 0, -1323940314);
            Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor3 = companion22.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxSize$default2);
            if (composerStartRestartGroup.getApplier() == null) {
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion22, composerM18018constructorimpl3, measurePolicyM1208i2, composerM18018constructorimpl3, density3));
            function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion22, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-678309503);
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(109704460);
            drawerContent.invoke(composerStartRestartGroup, Integer.valueOf(i4 & 14));
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Modifier.Companion companion32 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion4, false, composerStartRestartGroup, 0, -1323940314);
            Density density22 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection22 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration22 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf22 = LayoutKt.materializerOf(companion32);
            if (composerStartRestartGroup.getApplier() == null) {
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl22 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl22, layoutDirection22, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion22, composerM18018constructorimpl22, measurePolicyM1210k2, composerM18018constructorimpl22, density22));
            function3MaterializerOf22.invoke(AbstractC1038a.m1206g(companion22, composerM18018constructorimpl22, viewConfiguration22, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(612624658);
            content.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 6) & 14));
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
            }
            modifier3 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Scrim-Bx497Mc, reason: not valid java name */
    public static final void m17245ScrimBx497Mc(final boolean z, final Function0<Unit> function0, final Function0<Float> function02, final long j, Composer composer, final int i) {
        int i2;
        Modifier modifierSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(2106487387);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(function02) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i2 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2106487387, i2, -1, "androidx.compose.material3.Scrim (NavigationDrawer.kt:854)");
            }
            final String strM17317getStringNWtq28 = Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17307getCloseDraweradMyvUU(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1858703137);
            if (z) {
                Modifier.Companion companion = Modifier.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                boolean zChanged = composerStartRestartGroup.changed(function0);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new NavigationDrawerKt$Scrim$dismissDrawer$1$1(function0, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                boolean zChanged2 = composerStartRestartGroup.changed(strM17317getStringNWtq28) | composerStartRestartGroup.changed(function0);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$Scrim$dismissDrawer$2$1
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
                            SemanticsPropertiesKt.setContentDescription(semantics, strM17317getStringNWtq28);
                            final Function0<Unit> function03 = function0;
                            SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$Scrim$dismissDrawer$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                @NotNull
                                public final Boolean invoke() {
                                    function03.invoke();
                                    return Boolean.TRUE;
                                }
                            }, 1, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                modifierSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) objRememberedValue2);
            } else {
                modifierSemantics = Modifier.INSTANCE;
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(modifierSemantics);
            Color colorM18515boximpl = Color.m18515boximpl(j);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged3 = composerStartRestartGroup.changed(colorM18515boximpl) | composerStartRestartGroup.changed(function02);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$Scrim$1$1
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
                        DrawScope.m19070drawRectnJ9OG0$default(Canvas, j, 0L, 0L, function02.invoke().floatValue(), null, null, 0, 118, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$Scrim$2
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
                NavigationDrawerKt.m17245ScrimBx497Mc(z, function0, function02, j, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float f, float f4, float f5) {
        return RangesKt.coerceIn((f5 - f) / (f4 - f), 0.0f, 1.0f);
    }

    @Composable
    @ExperimentalMaterial3Api
    @NotNull
    public static final DrawerState rememberDrawerState(@NotNull final DrawerValue initialValue, @Nullable final Function1<? super DrawerValue, Boolean> function1, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        composer.startReplaceableGroup(2098699222);
        if ((i2 & 2) != 0) {
            function1 = new Function1<DrawerValue, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt.rememberDrawerState.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull DrawerValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.TRUE;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2098699222, i, -1, "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:225)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.Companion.Saver(function1);
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(initialValue) | composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0<DrawerState>() { // from class: androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final DrawerState invoke() {
                    return new DrawerState(initialValue, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m18111rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) objRememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return drawerState;
    }
}
