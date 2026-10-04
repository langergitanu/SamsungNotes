package androidx.compose.material3;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.LayoutIdKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
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
@Metadata(m13885d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001ah\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001aj\u0010\u0018\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0017\u001am\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u009c\u0001\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006-"}, m13886d2 = {"ContainerMaxWidth", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "HeightToFirstLine", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "dismissAction", "actionTextStyle", "Landroidx/compose/ui/text/TextStyle;", "actionContentColor", "Landroidx/compose/ui/graphics/Color;", "dismissActionContentColor", "NewLineButtonSnackbar-kKq0p4A", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JJLandroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "actionTextColor", "dismissActionColor", "OneRowSnackbar-kKq0p4A", "Snackbar", "snackbarData", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "containerColor", "contentColor", "actionColor", "Snackbar-sDKtq54", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJJJLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-eQBnUkQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SnackbarKt {
    private static final float HorizontalSpacingButtonSide;
    private static final float TextEndExtraSpacing;
    private static final float ContainerMaxWidth = C2256Dp.m20968constructorimpl(600);
    private static final float HeightToFirstLine = C2256Dp.m20968constructorimpl(30);
    private static final float HorizontalSpacing = C2256Dp.m20968constructorimpl(16);
    private static final float SeparateButtonExtraY = C2256Dp.m20968constructorimpl(2);
    private static final float SnackbarVerticalPadding = C2256Dp.m20968constructorimpl(6);
    private static final float LongButtonVerticalOffset = C2256Dp.m20968constructorimpl(12);

    static {
        float f = 8;
        HorizontalSpacingButtonSide = C2256Dp.m20968constructorimpl(f);
        TextEndExtraSpacing = C2256Dp.m20968constructorimpl(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v31 */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: NewLineButtonSnackbar-kKq0p4A, reason: not valid java name */
    public static final void m17294NewLineButtonSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final TextStyle textStyle, final long j, final long j2, Composer composer, final int i) {
        int i2;
        ?? r8;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1332496681);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(function22) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(function23) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 131072 : 65536;
        }
        if ((374491 & i2) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1332496681, i2, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:248)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            int i4 = i2;
            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m15906widthInVpY3zN4$default(companion, 0.0f, ContainerMaxWidth, 1, null), 0.0f, 1, null), HorizontalSpacing, 0.0f, 0.0f, SeparateButtonExtraY, 6, null);
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(companion2, top, composerStartRestartGroup, 0, -1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
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
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-1163856341);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-363148767);
            Modifier modifierM15708paddingFromBaselineVpY3zN4 = AlignmentLineKt.m15708paddingFromBaselineVpY3zN4(companion, HeightToFirstLine, LongButtonVerticalOffset);
            float fM20968constructorimpl = HorizontalSpacingButtonSide;
            Modifier modifierM15858paddingqDBjuR0$default2 = PaddingKt.m15858paddingqDBjuR0$default(modifierM15708paddingFromBaselineVpY3zN4, 0.0f, 0.0f, fM20968constructorimpl, 0.0f, 11, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composerStartRestartGroup, 0, -1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default2);
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
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(74621659);
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i4 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierAlign = columnScopeInstance.align(companion, companion2.getEnd());
            if (function23 == null) {
                r8 = 0;
            } else {
                r8 = 0;
                fM20968constructorimpl = C2256Dp.m20968constructorimpl(0);
            }
            Modifier modifierM15858paddingqDBjuR0$default3 = PaddingKt.m15858paddingqDBjuR0$default(modifierAlign, 0.0f, 0.0f, fM20968constructorimpl, 0.0f, 11, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion2, r8, composerStartRestartGroup, r8, -1323940314);
            Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default3);
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
            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl3, measurePolicyM1210k2, composerM18018constructorimpl3, density3));
            function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            composerStartRestartGroup.startReplaceableGroup(1640608516);
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(companion2, arrangement.getStart(), composerStartRestartGroup, 0, -1323940314);
            Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(companion);
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
            Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl4, measurePolicyM1208i, composerM18018constructorimpl4, density4));
            function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl4, viewConfiguration4, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-678309503);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-1595822816);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle)}, function22, composerStartRestartGroup, (i4 & 112) | 8);
            if (function23 != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j2))}, function23, composerStartRestartGroup, ((i4 >> 3) & 112) | 8);
            }
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$NewLineButtonSnackbar$2
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
                SnackbarKt.m17294NewLineButtonSnackbarkKq0p4A(function2, function22, function23, textStyle, j, j2, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: OneRowSnackbar-kKq0p4A, reason: not valid java name */
    public static final void m17295OneRowSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, final TextStyle textStyle, final long j, final long j2, Composer composer, final int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Composer composerStartRestartGroup = composer.startRestartGroup(-903235475);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(function22) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(function23) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 131072 : 65536;
        }
        if ((374491 & i2) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            function24 = function23;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903235475, i2, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:293)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(companion, HorizontalSpacing, 0.0f, function23 == null ? HorizontalSpacingButtonSide : C2256Dp.m20968constructorimpl(0), 0.0f, 10, null);
            final String str = "action";
            final String str2 = "dismissAction";
            int i4 = i2;
            final String str3 = "text";
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2
                /* JADX WARN: Removed duplicated region for block: B:58:0x0130 A[PHI: r3 r7
                  0x0130: PHI (r3v10 int) = (r3v9 int), (r3v15 int), (r3v15 int) binds: [B:61:0x0152, B:54:0x0121, B:56:0x012b] A[DONT_GENERATE, DONT_INLINE]
                  0x0130: PHI (r7v14 int) = (r7v13 int), (r7v18 int), (r7v18 int) binds: [B:61:0x0152, B:54:0x0121, B:56:0x012b] A[DONT_GENERATE, DONT_INLINE]] */
                @Override // androidx.compose.p109ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> measurables, long j3) {
                    Object next;
                    Object next2;
                    int iMo15540roundToPx0680j_4;
                    int iMax;
                    int iM1197B;
                    int i5;
                    MeasureScope Layout = measureScope;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    int iMin = Math.min(Constraints.m20921getMaxWidthimpl(j3), Layout.mo15540roundToPx0680j_4(SnackbarKt.ContainerMaxWidth));
                    List<? extends Measurable> list = measurables;
                    String str4 = str;
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next), str4)) {
                            break;
                        }
                    }
                    Measurable measurable = (Measurable) next;
                    Placeable placeableMo19855measureBRTryo0 = measurable != null ? measurable.mo19855measureBRTryo0(j3) : null;
                    String str5 = str2;
                    Iterator<T> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next2), str5)) {
                            break;
                        }
                    }
                    Measurable measurable2 = (Measurable) next2;
                    final Placeable placeableMo19855measureBRTryo02 = measurable2 != null ? measurable2.mo19855measureBRTryo0(j3) : null;
                    int width = placeableMo19855measureBRTryo0 != null ? placeableMo19855measureBRTryo0.getWidth() : 0;
                    int height = placeableMo19855measureBRTryo0 != null ? placeableMo19855measureBRTryo0.getHeight() : 0;
                    int width2 = placeableMo19855measureBRTryo02 != null ? placeableMo19855measureBRTryo02.getWidth() : 0;
                    int height2 = placeableMo19855measureBRTryo02 != null ? placeableMo19855measureBRTryo02.getHeight() : 0;
                    int iCoerceAtLeast = RangesKt.coerceAtLeast(((iMin - width) - width2) - (width2 == 0 ? Layout.mo15540roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing) : 0), Constraints.m20923getMinWidthimpl(j3));
                    String str6 = str3;
                    for (Measurable measurable3 : list) {
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), str6)) {
                            int i6 = height2;
                            final Placeable placeableMo19855measureBRTryo03 = measurable3.mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j3, 0, iCoerceAtLeast, 0, 0, 9, null));
                            int i7 = placeableMo19855measureBRTryo03.get(androidx.compose.p109ui.layout.AlignmentLineKt.getFirstBaseline());
                            if (i7 == Integer.MIN_VALUE) {
                                throw new IllegalArgumentException("No baselines for text");
                            }
                            int i8 = placeableMo19855measureBRTryo03.get(androidx.compose.p109ui.layout.AlignmentLineKt.getLastBaseline());
                            if (i8 == Integer.MIN_VALUE) {
                                throw new IllegalArgumentException("No baselines for text");
                            }
                            boolean z = i7 == i8;
                            final int i9 = iMin - width2;
                            final int i10 = i9 - width;
                            if (z) {
                                iMax = Math.max(Layout.mo15540roundToPx0680j_4(SnackbarTokens.INSTANCE.m17889getSingleLineContainerHeightD9Ej5fM()), Math.max(height, i6));
                                iMo15540roundToPx0680j_4 = AbstractC1038a.m1197B(placeableMo19855measureBRTryo03, iMax, 2);
                                iM1197B = (placeableMo19855measureBRTryo0 == null || (i5 = placeableMo19855measureBRTryo0.get(androidx.compose.p109ui.layout.AlignmentLineKt.getFirstBaseline())) == Integer.MIN_VALUE) ? 0 : (i7 + iMo15540roundToPx0680j_4) - i5;
                            } else {
                                iMo15540roundToPx0680j_4 = Layout.mo15540roundToPx0680j_4(SnackbarKt.HeightToFirstLine) - i7;
                                iMax = Math.max(Layout.mo15540roundToPx0680j_4(SnackbarTokens.INSTANCE.m17890getTwoLinesContainerHeightD9Ej5fM()), placeableMo19855measureBRTryo03.getHeight() + iMo15540roundToPx0680j_4);
                                if (placeableMo19855measureBRTryo0 != null) {
                                    iM1197B = AbstractC1038a.m1197B(placeableMo19855measureBRTryo0, iMax, 2);
                                }
                            }
                            final int i11 = iM1197B;
                            final int i12 = iMo15540roundToPx0680j_4;
                            final int iM1197B2 = placeableMo19855measureBRTryo02 != null ? AbstractC1038a.m1197B(placeableMo19855measureBRTryo02, iMax, 2) : 0;
                            final Placeable placeable = placeableMo19855measureBRTryo0;
                            return MeasureScope.layout$default(Layout, iMin, iMax, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$measure$4
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
                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo03, 0, i12, 0.0f, 4, null);
                                    Placeable placeable2 = placeableMo19855measureBRTryo02;
                                    if (placeable2 != null) {
                                        Placeable.PlacementScope.placeRelative$default(layout, placeable2, i9, iM1197B2, 0.0f, 4, null);
                                    }
                                    Placeable placeable3 = placeable;
                                    if (placeable3 != null) {
                                        Placeable.PlacementScope.placeRelative$default(layout, placeable3, i10, i11, 0.0f, 4, null);
                                    }
                                }
                            }, 4, null);
                        }
                        Layout = measureScope;
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            };
            Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
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
            Updater.m18025setimpl(composerM18018constructorimpl, measurePolicy, companion2.getSetMeasurePolicy());
            Updater.m18025setimpl(composerM18018constructorimpl, density, companion2.getSetDensity());
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-1961334364);
            Modifier modifierM15856paddingVpY3zN4$default = PaddingKt.m15856paddingVpY3zN4$default(LayoutIdKt.layoutId(companion, "text"), 0.0f, SnackbarVerticalPadding, 1, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion3, false, composerStartRestartGroup, 0, -1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15856paddingVpY3zN4$default);
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
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-789862614);
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i4 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-167734710);
            if (function22 != null) {
                Modifier modifierLayoutId = LayoutIdKt.layoutId(companion, "action");
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion3, false, composerStartRestartGroup, 0, -1323940314);
                Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierLayoutId);
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
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                composerStartRestartGroup.startReplaceableGroup(801714373);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle)}, function22, composerStartRestartGroup, (i4 & 112) | 8);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (function23 != null) {
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(companion, "dismissAction");
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k3 = AbstractC1038a.m1210k(companion3, false, composerStartRestartGroup, 0, -1323940314);
                Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor4 = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierLayoutId2);
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
                Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl4, measurePolicyM1210k3, composerM18018constructorimpl4, density4));
                function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl4, viewConfiguration4, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                composerStartRestartGroup.startReplaceableGroup(88411260);
                function24 = function23;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j2))}, function24, composerStartRestartGroup, ((i4 >> 3) & 112) | 8);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                function24 = function23;
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$3
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
                SnackbarKt.m17295OneRowSnackbarkKq0p4A(function2, function22, function25, textStyle, j, j2, composer2, i | 1);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x026d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0110  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Snackbar-eQBnUkQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17296SnackbareQBnUkQ(@Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, boolean z, @Nullable Shape shape, long j, long j2, long j3, long j5, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i6;
        boolean z2;
        Shape shape2;
        int i7;
        long dismissActionContentColor;
        int i8;
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function25;
        boolean z3;
        Shape shape3;
        long color;
        long contentColor;
        long actionContentColor;
        Modifier modifier3;
        Composer composer2;
        final long j6;
        final boolean z4;
        final Shape shape4;
        final long j7;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1235788955);
        int i9 = i2 & 1;
        if (i9 != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                function23 = function2;
                i4 |= composerStartRestartGroup.changed(function23) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    function24 = function22;
                    i4 |= composerStartRestartGroup.changed(function24) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 7168) == 0) {
                        z2 = z;
                        i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                    }
                    if ((57344 & i) != 0) {
                        if ((i2 & 16) == 0) {
                            shape2 = shape;
                            int i11 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                            i4 |= i11;
                        } else {
                            shape2 = shape;
                        }
                        i4 |= i11;
                    } else {
                        shape2 = shape;
                    }
                    if ((458752 & i) != 0) {
                        i7 = i9;
                        i4 |= ((i2 & 32) == 0 && composerStartRestartGroup.changed(j)) ? 131072 : 65536;
                    } else {
                        i7 = i9;
                    }
                    if ((3670016 & i) == 0) {
                        i4 |= ((i2 & 64) == 0 && composerStartRestartGroup.changed(j2)) ? 1048576 : 524288;
                    }
                    if ((29360128 & i) == 0) {
                        i4 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(j3)) ? 8388608 : 4194304;
                    }
                    if ((234881024 & i) != 0) {
                        dismissActionContentColor = j5;
                        i4 |= ((i2 & 256) == 0 && composerStartRestartGroup.changed(dismissActionContentColor)) ? 67108864 : 33554432;
                    } else {
                        dismissActionContentColor = j5;
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            i8 = composerStartRestartGroup.changed(content) ? 536870912 : 268435456;
                        }
                        if ((1533916891 & i4) == 306783378 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            actionContentColor = j3;
                            composer2 = composerStartRestartGroup;
                            shape4 = shape2;
                            modifier3 = modifier;
                            j6 = dismissActionContentColor;
                            function26 = function24;
                            z4 = z2;
                            color = j;
                            j7 = j2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                modifier2 = i7 == 0 ? Modifier.INSTANCE : modifier;
                                if (i10 != 0) {
                                    function23 = null;
                                }
                                function25 = i5 == 0 ? function24 : null;
                                z3 = i6 == 0 ? false : z2;
                                if ((i2 & 16) == 0) {
                                    shape3 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                    i4 &= -57345;
                                } else {
                                    shape3 = shape2;
                                }
                                if ((i2 & 32) == 0) {
                                    color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                    i4 &= -458753;
                                } else {
                                    color = j;
                                }
                                if ((i2 & 64) == 0) {
                                    contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                    i4 &= -3670017;
                                } else {
                                    contentColor = j2;
                                }
                                if ((i2 & 128) == 0) {
                                    actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                    i4 &= -29360129;
                                } else {
                                    actionContentColor = j3;
                                }
                                if ((i2 & 256) != 0) {
                                    dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                    i4 &= -234881025;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i4 &= -234881025;
                                }
                                modifier2 = modifier;
                                contentColor = j2;
                                actionContentColor = j3;
                                function25 = function24;
                                z3 = z2;
                                shape3 = shape2;
                                color = j;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1235788955, i4, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:91)");
                            }
                            final long j8 = dismissActionContentColor;
                            final int i12 = i4;
                            final boolean z5 = z3;
                            final Function2<? super Composer, ? super Integer, Unit> function27 = function23;
                            final Function2<? super Composer, ? super Integer, Unit> function28 = function25;
                            final long j9 = actionContentColor;
                            int i13 = 12779520 | (i4 & 14);
                            int i14 = i4 >> 9;
                            Modifier modifier4 = modifier2;
                            SurfaceKt.m17325SurfaceT9BRK9s(modifier4, shape3, color, contentColor, 0.0f, SnackbarTokens.INSTANCE.m17887getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                                public final void invoke(@Nullable Composer composer3, int i15) {
                                    if ((i15 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1829663446, i15, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:109)");
                                    }
                                    MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                                    Typography typography = materialTheme.getTypography(composer3, 6);
                                    SnackbarTokens snackbarTokens = SnackbarTokens.INSTANCE;
                                    TextStyle textStyleFromToken = TypographyKt.fromToken(typography, snackbarTokens.getSupportingTextFont());
                                    final TextStyle textStyleFromToken2 = TypographyKt.fromToken(materialTheme.getTypography(composer3, 6), snackbarTokens.getActionLabelTextFont());
                                    ProvidedValue[] providedValueArr = {TextKt.getLocalTextStyle().provides(textStyleFromToken)};
                                    final Function2<Composer, Integer, Unit> function29 = function27;
                                    final Function2<Composer, Integer, Unit> function210 = content;
                                    final Function2<Composer, Integer, Unit> function211 = function28;
                                    final long j10 = j9;
                                    final long j11 = j8;
                                    final int i16 = i12;
                                    final boolean z6 = z5;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
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
                                        public final void invoke(@Nullable Composer composer4, int i17) {
                                            if ((i17 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(835891690, i17, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:112)");
                                            }
                                            if (function29 == null) {
                                                composer4.startReplaceableGroup(-2104362770);
                                                Function2<Composer, Integer, Unit> function212 = function210;
                                                Function2<Composer, Integer, Unit> function213 = function211;
                                                TextStyle textStyle = textStyleFromToken2;
                                                long j12 = j10;
                                                long j13 = j11;
                                                int i18 = i16;
                                                SnackbarKt.m17295OneRowSnackbarkKq0p4A(function212, null, function213, textStyle, j12, j13, composer4, (57344 & (i18 >> 9)) | ((i18 >> 27) & 14) | 48 | (i18 & 896) | (458752 & (i18 >> 9)));
                                                composer4.endReplaceableGroup();
                                            } else if (z6) {
                                                composer4.startReplaceableGroup(-2104362456);
                                                Function2<Composer, Integer, Unit> function214 = function210;
                                                Function2<Composer, Integer, Unit> function215 = function29;
                                                Function2<Composer, Integer, Unit> function216 = function211;
                                                TextStyle textStyle2 = textStyleFromToken2;
                                                long j14 = j10;
                                                long j15 = j11;
                                                int i19 = i16;
                                                SnackbarKt.m17294NewLineButtonSnackbarkKq0p4A(function214, function215, function216, textStyle2, j14, j15, composer4, (57344 & (i19 >> 9)) | ((i19 >> 27) & 14) | (i19 & 112) | (i19 & 896) | (458752 & (i19 >> 9)));
                                                composer4.endReplaceableGroup();
                                            } else {
                                                composer4.startReplaceableGroup(-2104362176);
                                                Function2<Composer, Integer, Unit> function217 = function210;
                                                Function2<Composer, Integer, Unit> function218 = function29;
                                                Function2<Composer, Integer, Unit> function219 = function211;
                                                TextStyle textStyle3 = textStyleFromToken2;
                                                long j16 = j10;
                                                long j17 = j11;
                                                int i20 = i16;
                                                SnackbarKt.m17295OneRowSnackbarkKq0p4A(function217, function218, function219, textStyle3, j16, j17, composer4, (57344 & (i20 >> 9)) | ((i20 >> 27) & 14) | (i20 & 112) | (i20 & 896) | (458752 & (i20 >> 9)));
                                                composer4.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, (i14 & 7168) | i13 | (i14 & 112) | (i14 & 896), 80);
                            modifier3 = modifier4;
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j6 = dismissActionContentColor;
                            z4 = z3;
                            shape4 = shape3;
                            j7 = contentColor;
                            function26 = function25;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        final Modifier modifier5 = modifier3;
                        final Function2<? super Composer, ? super Integer, Unit> function29 = function23;
                        final long j10 = color;
                        final long j11 = actionContentColor;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$2
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

                            public final void invoke(@Nullable Composer composer3, int i15) {
                                SnackbarKt.m17296SnackbareQBnUkQ(modifier5, function29, function26, z4, shape4, j10, j7, j11, j6, content, composer3, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i8 = DriveFile.MODE_READ_WRITE;
                    i4 |= i8;
                    if ((1533916891 & i4) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i7 == 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i5 == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 16) == 0) {
                            }
                            if ((i2 & 32) == 0) {
                            }
                            if ((i2 & 64) == 0) {
                            }
                            if ((i2 & 128) == 0) {
                            }
                            if ((i2 & 256) != 0) {
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final long j82 = dismissActionContentColor;
                            final int i122 = i4;
                            final boolean z52 = z3;
                            final Function2<? super Composer, ? super Integer, Unit> function272 = function23;
                            final Function2<? super Composer, ? super Integer, Unit> function282 = function25;
                            final long j92 = actionContentColor;
                            int i132 = 12779520 | (i4 & 14);
                            int i142 = i4 >> 9;
                            Modifier modifier42 = modifier2;
                            SurfaceKt.m17325SurfaceT9BRK9s(modifier42, shape3, color, contentColor, 0.0f, SnackbarTokens.INSTANCE.m17887getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                                public final void invoke(@Nullable Composer composer3, int i15) {
                                    if ((i15 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1829663446, i15, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:109)");
                                    }
                                    MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                                    Typography typography = materialTheme.getTypography(composer3, 6);
                                    SnackbarTokens snackbarTokens = SnackbarTokens.INSTANCE;
                                    TextStyle textStyleFromToken = TypographyKt.fromToken(typography, snackbarTokens.getSupportingTextFont());
                                    final TextStyle textStyleFromToken2 = TypographyKt.fromToken(materialTheme.getTypography(composer3, 6), snackbarTokens.getActionLabelTextFont());
                                    ProvidedValue[] providedValueArr = {TextKt.getLocalTextStyle().provides(textStyleFromToken)};
                                    final Function2<? super Composer, ? super Integer, Unit> function292 = function272;
                                    final Function2<? super Composer, ? super Integer, Unit> function210 = content;
                                    final Function2<? super Composer, ? super Integer, Unit> function211 = function282;
                                    final long j102 = j92;
                                    final long j112 = j82;
                                    final int i16 = i122;
                                    final boolean z6 = z52;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
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
                                        public final void invoke(@Nullable Composer composer4, int i17) {
                                            if ((i17 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(835891690, i17, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:112)");
                                            }
                                            if (function292 == null) {
                                                composer4.startReplaceableGroup(-2104362770);
                                                Function2<Composer, Integer, Unit> function212 = function210;
                                                Function2<Composer, Integer, Unit> function213 = function211;
                                                TextStyle textStyle = textStyleFromToken2;
                                                long j12 = j102;
                                                long j13 = j112;
                                                int i18 = i16;
                                                SnackbarKt.m17295OneRowSnackbarkKq0p4A(function212, null, function213, textStyle, j12, j13, composer4, (57344 & (i18 >> 9)) | ((i18 >> 27) & 14) | 48 | (i18 & 896) | (458752 & (i18 >> 9)));
                                                composer4.endReplaceableGroup();
                                            } else if (z6) {
                                                composer4.startReplaceableGroup(-2104362456);
                                                Function2<Composer, Integer, Unit> function214 = function210;
                                                Function2<Composer, Integer, Unit> function215 = function292;
                                                Function2<Composer, Integer, Unit> function216 = function211;
                                                TextStyle textStyle2 = textStyleFromToken2;
                                                long j14 = j102;
                                                long j15 = j112;
                                                int i19 = i16;
                                                SnackbarKt.m17294NewLineButtonSnackbarkKq0p4A(function214, function215, function216, textStyle2, j14, j15, composer4, (57344 & (i19 >> 9)) | ((i19 >> 27) & 14) | (i19 & 112) | (i19 & 896) | (458752 & (i19 >> 9)));
                                                composer4.endReplaceableGroup();
                                            } else {
                                                composer4.startReplaceableGroup(-2104362176);
                                                Function2<Composer, Integer, Unit> function217 = function210;
                                                Function2<Composer, Integer, Unit> function218 = function292;
                                                Function2<Composer, Integer, Unit> function219 = function211;
                                                TextStyle textStyle3 = textStyleFromToken2;
                                                long j16 = j102;
                                                long j17 = j112;
                                                int i20 = i16;
                                                SnackbarKt.m17295OneRowSnackbarkKq0p4A(function217, function218, function219, textStyle3, j16, j17, composer4, (57344 & (i20 >> 9)) | ((i20 >> 27) & 14) | (i20 & 112) | (i20 & 896) | (458752 & (i20 >> 9)));
                                                composer4.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, (i142 & 7168) | i132 | (i142 & 112) | (i142 & 896), 80);
                            modifier3 = modifier42;
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            j6 = dismissActionContentColor;
                            z4 = z3;
                            shape4 = shape3;
                            j7 = contentColor;
                            function26 = function25;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z2 = z;
                if ((57344 & i) != 0) {
                }
                if ((458752 & i) != 0) {
                }
                if ((3670016 & i) == 0) {
                }
                if ((29360128 & i) == 0) {
                }
                if ((234881024 & i) != 0) {
                }
                if ((i2 & 512) != 0) {
                }
                i4 |= i8;
                if ((1533916891 & i4) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function24 = function22;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            z2 = z;
            if ((57344 & i) != 0) {
            }
            if ((458752 & i) != 0) {
            }
            if ((3670016 & i) == 0) {
            }
            if ((29360128 & i) == 0) {
            }
            if ((234881024 & i) != 0) {
            }
            if ((i2 & 512) != 0) {
            }
            i4 |= i8;
            if ((1533916891 & i4) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function23 = function2;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        function24 = function22;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        z2 = z;
        if ((57344 & i) != 0) {
        }
        if ((458752 & i) != 0) {
        }
        if ((3670016 & i) == 0) {
        }
        if ((29360128 & i) == 0) {
        }
        if ((234881024 & i) != 0) {
        }
        if ((i2 & 512) != 0) {
        }
        i4 |= i8;
        if ((1533916891 & i4) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010e  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Snackbar-sDKtq54, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17297SnackbarsDKtq54(@NotNull final SnackbarData snackbarData, @Nullable Modifier modifier, boolean z, @Nullable Shape shape, long j, long j2, long j3, long j5, long j6, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        Shape shape2;
        int i6;
        long j7;
        int i7;
        int i8;
        long j8;
        int i9;
        int i10;
        int i11;
        int i12;
        final Modifier modifier3;
        Shape shape3;
        long color;
        long contentColor;
        long actionColor;
        long actionContentColor;
        long dismissActionContentColor;
        boolean z3;
        long j9;
        int i13;
        long j10;
        int i14;
        Shape shape4;
        long j11;
        final String actionLabel;
        final int i15;
        final SnackbarData snackbarData2;
        ComposableLambda composableLambda;
        Composer composer2;
        final long j12;
        final boolean z4;
        final Shape shape5;
        final long j13;
        final long j14;
        final long j15;
        final long j16;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(snackbarData, "snackbarData");
        Composer composerStartRestartGroup = composer.startRestartGroup(274621471);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(snackbarData) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i16 = i2 & 2;
        if (i16 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 != 0) {
                if ((i & 896) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i17 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i4 |= i17;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i17;
                } else {
                    shape2 = shape;
                }
                if ((i & 57344) == 0) {
                    i4 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(j)) ? 16384 : 8192;
                }
                if ((i & 458752) == 0) {
                    i6 = 57344;
                    j7 = j2;
                    i4 |= ((i2 & 32) == 0 && composerStartRestartGroup.changed(j7)) ? 131072 : 65536;
                } else {
                    i6 = 57344;
                    j7 = j2;
                }
                if ((i & 3670016) == 0) {
                    i7 = 3670016;
                    if ((i2 & 64) == 0) {
                        i8 = 458752;
                        j8 = j3;
                        int i18 = composerStartRestartGroup.changed(j8) ? 1048576 : 524288;
                        i4 |= i18;
                    } else {
                        i8 = 458752;
                        j8 = j3;
                    }
                    i4 |= i18;
                } else {
                    i7 = 3670016;
                    i8 = 458752;
                    j8 = j3;
                }
                if ((i & 29360128) == 0) {
                    i10 = i8;
                    int i19 = i4;
                    if ((i2 & 128) == 0) {
                        i11 = i16;
                        int i20 = composerStartRestartGroup.changed(j5) ? 8388608 : 4194304;
                        i9 = i19 | i20;
                    } else {
                        i11 = i16;
                    }
                    i9 = i19 | i20;
                } else {
                    i9 = i4;
                    i10 = i8;
                    i11 = i16;
                }
                if ((i & 234881024) == 0) {
                    i9 |= ((i2 & 256) == 0 && composerStartRestartGroup.changed(j6)) ? 67108864 : 33554432;
                }
                i12 = i9;
                if ((191739611 & i12) == 38347922 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    snackbarData2 = snackbarData;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape5 = shape2;
                    j14 = j7;
                    j12 = j8;
                    j13 = j;
                    j15 = j5;
                    j16 = j6;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        modifier3 = i11 == 0 ? Modifier.INSTANCE : modifier2;
                        boolean z5 = i5 == 0 ? false : z2;
                        if ((i2 & 8) == 0) {
                            shape3 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i12 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 16) == 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i12 &= -57345;
                        } else {
                            color = j;
                        }
                        if ((i2 & 32) == 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i12 &= -458753;
                        } else {
                            contentColor = j7;
                        }
                        if ((i2 & 64) == 0) {
                            actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                            i12 &= -3670017;
                        } else {
                            actionColor = j8;
                        }
                        if ((i2 & 128) == 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i12 &= -29360129;
                        } else {
                            actionContentColor = j5;
                        }
                        if ((i2 & 256) == 0) {
                            i12 &= -234881025;
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        } else {
                            dismissActionContentColor = j6;
                        }
                        z3 = z5;
                        j9 = actionContentColor;
                        i13 = 234881024;
                        j10 = color;
                        i14 = 274621471;
                        shape4 = shape3;
                        j11 = contentColor;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i12 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i12 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i12 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                        }
                        if ((i2 & 256) != 0) {
                            i12 &= -234881025;
                        }
                        j10 = j;
                        j9 = j5;
                        dismissActionContentColor = j6;
                        modifier3 = modifier2;
                        z3 = z2;
                        j11 = j7;
                        actionColor = j8;
                        i13 = 234881024;
                        i14 = 274621471;
                        shape4 = shape2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i14, i12, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:194)");
                    }
                    actionLabel = snackbarData.getVisuals().getActionLabel();
                    if (actionLabel == null) {
                        final int i21 = i12;
                        final long j17 = actionColor;
                        Function2<Composer, Integer, Unit> function2 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            public final void invoke(@Nullable Composer composer3, int i22) {
                                if ((i22 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1378313599, i22, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:207)");
                                }
                                ButtonColors buttonColorsM17017textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m17017textButtonColorsro_MJ88(0L, j17, 0L, 0L, composer3, ((i21 >> 15) & 112) | 24576, 13);
                                final SnackbarData snackbarData3 = snackbarData;
                                composer3.startReplaceableGroup(1157296644);
                                boolean zChanged = composer3.changed(snackbarData3);
                                Object objRememberedValue = composer3.rememberedValue();
                                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$1$1
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
                                            snackbarData3.performAction();
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue);
                                }
                                composer3.endReplaceableGroup();
                                Function0 function0 = (Function0) objRememberedValue;
                                final String str = actionLabel;
                                ButtonKt.TextButton(function0, null, false, null, buttonColorsM17017textButtonColorsro_MJ88, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 521110564, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                        invoke(rowScope, composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@NotNull RowScope TextButton, @Nullable Composer composer4, int i23) {
                                        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                                        if ((i23 & 81) == 16 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(521110564, i23, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:211)");
                                        }
                                        TextKt.m17400TextfLXpl1I(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer4, 0, 0, 65534);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, DriveFile.MODE_READ_WRITE, 494);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        };
                        i15 = i21;
                        snackbarData2 = snackbarData;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1378313599, true, function2);
                    } else {
                        i15 = i12;
                        snackbarData2 = snackbarData;
                        composableLambda = null;
                    }
                    int i22 = i15 << 3;
                    composer2 = composerStartRestartGroup;
                    m17296SnackbareQBnUkQ(PaddingKt.m15854padding3ABfNKs(modifier3, C2256Dp.m20968constructorimpl(12)), composableLambda, !snackbarData2.getVisuals().getWithDismissAction() ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1812633777, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        public final void invoke(@Nullable Composer composer3, int i23) {
                            if ((i23 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1812633777, i23, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:219)");
                            }
                            final SnackbarData snackbarData3 = snackbarData2;
                            composer3.startReplaceableGroup(1157296644);
                            boolean zChanged = composer3.changed(snackbarData3);
                            Object objRememberedValue = composer3.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1$1$1
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
                                        snackbarData3.dismiss();
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            composer3.endReplaceableGroup();
                            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, ComposableSingletons$SnackbarKt.INSTANCE.m17121getLambda1$material3_release(), composer3, 196608, 30);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }) : null, z3, shape4, j10, j11, j9, dismissActionContentColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
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
                        public final void invoke(@Nullable Composer composer3, int i23) {
                            if ((i23 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1266389126, i23, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:243)");
                            }
                            TextKt.m17400TextfLXpl1I(snackbarData2.getVisuals().getMessage(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer3, 0, 0, 65534);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, (i22 & i7) | (i22 & 7168) | DriveFile.MODE_READ_WRITE | (i22 & i6) | (i22 & i10) | (i15 & 29360128) | (i13 & i15), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j12 = actionColor;
                    z4 = z3;
                    shape5 = shape4;
                    j13 = j10;
                    j14 = j11;
                    j15 = j9;
                    j16 = dismissActionContentColor;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer3, int i23) {
                        SnackbarKt.m17297SnackbarsDKtq54(snackbarData2, modifier3, z4, shape5, j13, j14, j12, j15, j16, composer3, i | 1, i2);
                    }
                });
                return;
            }
            i4 |= 384;
            z2 = z;
            if ((i & 7168) == 0) {
            }
            if ((i & 57344) == 0) {
            }
            if ((i & 458752) == 0) {
            }
            if ((i & 3670016) == 0) {
            }
            if ((i & 29360128) == 0) {
            }
            if ((i & 234881024) == 0) {
            }
            i12 = i9;
            if ((191739611 & i12) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 == 0) {
                    }
                    if (i5 == 0) {
                    }
                    if ((i2 & 8) == 0) {
                    }
                    if ((i2 & 16) == 0) {
                    }
                    if ((i2 & 32) == 0) {
                    }
                    if ((i2 & 64) == 0) {
                    }
                    if ((i2 & 128) == 0) {
                    }
                    if ((i2 & 256) == 0) {
                    }
                    z3 = z5;
                    j9 = actionContentColor;
                    i13 = 234881024;
                    j10 = color;
                    i14 = 274621471;
                    shape4 = shape3;
                    j11 = contentColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    actionLabel = snackbarData.getVisuals().getActionLabel();
                    if (actionLabel == null) {
                    }
                    int i222 = i15 << 3;
                    composer2 = composerStartRestartGroup;
                    m17296SnackbareQBnUkQ(PaddingKt.m15854padding3ABfNKs(modifier3, C2256Dp.m20968constructorimpl(12)), composableLambda, !snackbarData2.getVisuals().getWithDismissAction() ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1812633777, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        public final void invoke(@Nullable Composer composer3, int i23) {
                            if ((i23 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1812633777, i23, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:219)");
                            }
                            final SnackbarData snackbarData3 = snackbarData2;
                            composer3.startReplaceableGroup(1157296644);
                            boolean zChanged = composer3.changed(snackbarData3);
                            Object objRememberedValue = composer3.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1$1$1
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
                                        snackbarData3.dismiss();
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            composer3.endReplaceableGroup();
                            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, ComposableSingletons$SnackbarKt.INSTANCE.m17121getLambda1$material3_release(), composer3, 196608, 30);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }) : null, z3, shape4, j10, j11, j9, dismissActionContentColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
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
                        public final void invoke(@Nullable Composer composer3, int i23) {
                            if ((i23 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1266389126, i23, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:243)");
                            }
                            TextKt.m17400TextfLXpl1I(snackbarData2.getVisuals().getMessage(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer3, 0, 0, 65534);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, (i222 & i7) | (i222 & 7168) | DriveFile.MODE_READ_WRITE | (i222 & i6) | (i222 & i10) | (i15 & 29360128) | (i13 & i15), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    j12 = actionColor;
                    z4 = z3;
                    shape5 = shape4;
                    j13 = j10;
                    j14 = j11;
                    j15 = j9;
                    j16 = dismissActionContentColor;
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 != 0) {
        }
        z2 = z;
        if ((i & 7168) == 0) {
        }
        if ((i & 57344) == 0) {
        }
        if ((i & 458752) == 0) {
        }
        if ((i & 3670016) == 0) {
        }
        if ((i & 29360128) == 0) {
        }
        if ((i & 234881024) == 0) {
        }
        i12 = i9;
        if ((191739611 & i12) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
