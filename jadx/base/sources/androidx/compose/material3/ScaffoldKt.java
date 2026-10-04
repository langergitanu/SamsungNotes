package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.layout.SubcomposeLayoutKt;
import androidx.compose.p109ui.layout.SubcomposeMeasureScope;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a´\u0001\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0013\b\u0002\u0010\f\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0013\b\u0002\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0013\b\u0002\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t0\u001a¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u008a\u0001\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00132\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t0\u001a¢\u0006\u0002\b\u000e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000eH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006$"}, m13886d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material3/FabPosition;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-TvnljyQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IJJLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ScaffoldLayout", "fabPosition", "snackbar", "fab", "ScaffoldLayout-FMILGgc", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ScaffoldKt {

    @NotNull
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material3.ScaffoldKt$LocalFabPlacement$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final FabPlacement invoke() {
            return null;
        }
    });
    private static final float FabSpacing = C2256Dp.m20968constructorimpl(16);

    /* JADX WARN: Removed duplicated region for block: B:100:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0279 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0117  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_][_][_]]")
    /* JADX INFO: renamed from: Scaffold-TvnljyQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17280ScaffoldTvnljyQ(@Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, int i, long j, long j2, @Nullable WindowInsets windowInsets, @NotNull final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i9;
        int i10;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function2M17116getLambda1$material3_release;
        Function2<? super Composer, ? super Integer, Unit> function2M17117getLambda2$material3_release;
        Function2<? super Composer, ? super Integer, Unit> function2M17118getLambda3$material3_release;
        Function2<? super Composer, ? super Integer, Unit> function2M17119getLambda4$material3_release;
        int iM17167getEndERTFSPs;
        int i12;
        int i13;
        long jM17038getBackground0d7_KjU;
        long jM17098contentColorForek8zF_U;
        WindowInsets contentWindowInsets;
        long j3;
        long j5;
        Modifier modifier2;
        int i14;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final int i15;
        final WindowInsets windowInsets2;
        final Modifier modifier3;
        final long j6;
        final long j7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1219521777);
        int i16 = i4 & 1;
        if (i16 != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i17 = i4 & 2;
        if (i17 != 0) {
            i5 |= 48;
        } else {
            if ((i2 & 112) == 0) {
                function25 = function2;
                i5 |= composerStartRestartGroup.changed(function25) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i2 & 896) == 0) {
                    function26 = function22;
                    i5 |= composerStartRestartGroup.changed(function26) ? 256 : 128;
                }
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i2 & 7168) == 0) {
                        function27 = function23;
                        i5 |= composerStartRestartGroup.changed(function27) ? 2048 : 1024;
                    }
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else {
                        if ((57344 & i2) == 0) {
                            function28 = function24;
                            i5 |= composerStartRestartGroup.changed(function28) ? 16384 : 8192;
                        }
                        i9 = i4 & 32;
                        if (i9 != 0) {
                            i5 |= 196608;
                        } else if ((i2 & 458752) == 0) {
                            i5 |= composerStartRestartGroup.changed(i) ? 131072 : 65536;
                        }
                        if ((i2 & 3670016) == 0) {
                            i10 = i16;
                            i5 |= ((i4 & 64) == 0 && composerStartRestartGroup.changed(j)) ? 1048576 : 524288;
                        } else {
                            i10 = i16;
                        }
                        if ((i2 & 29360128) == 0) {
                            i5 |= ((i4 & 128) == 0 && composerStartRestartGroup.changed(j2)) ? 8388608 : 4194304;
                        }
                        if ((234881024 & i2) == 0) {
                            i5 |= ((i4 & 256) == 0 && composerStartRestartGroup.changed(windowInsets)) ? 67108864 : 33554432;
                        }
                        if ((i4 & 512) == 0) {
                            if ((1879048192 & i2) == 0) {
                                i11 = composerStartRestartGroup.changed(content) ? 536870912 : 268435456;
                            }
                            if ((1533916891 & i5) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier modifier4 = i10 == 0 ? Modifier.INSTANCE : modifier;
                                    function2M17116getLambda1$material3_release = i17 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m17116getLambda1$material3_release() : function25;
                                    function2M17117getLambda2$material3_release = i6 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m17117getLambda2$material3_release() : function26;
                                    function2M17118getLambda3$material3_release = i7 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m17118getLambda3$material3_release() : function27;
                                    function2M17119getLambda4$material3_release = i8 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m17119getLambda4$material3_release() : function28;
                                    iM17167getEndERTFSPs = i9 == 0 ? FabPosition.INSTANCE.m17167getEndERTFSPs() : i;
                                    if ((i4 & 64) == 0) {
                                        i5 &= -3670017;
                                        i12 = -234881025;
                                        i13 = -29360129;
                                        jM17038getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m17038getBackground0d7_KjU();
                                    } else {
                                        i12 = -234881025;
                                        i13 = -29360129;
                                        jM17038getBackground0d7_KjU = j;
                                    }
                                    if ((i4 & 128) == 0) {
                                        jM17098contentColorForek8zF_U = ColorSchemeKt.m17098contentColorForek8zF_U(jM17038getBackground0d7_KjU, composerStartRestartGroup, (i5 >> 18) & 14);
                                        i5 &= i13;
                                    } else {
                                        jM17098contentColorForek8zF_U = j2;
                                    }
                                    int i18 = i12;
                                    if ((i4 & 256) == 0) {
                                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                        i5 &= i18;
                                    } else {
                                        contentWindowInsets = windowInsets;
                                    }
                                    j3 = jM17038getBackground0d7_KjU;
                                    j5 = jM17098contentColorForek8zF_U;
                                    modifier2 = modifier4;
                                    i14 = -1219521777;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i4 & 64) != 0) {
                                        i5 &= -3670017;
                                    }
                                    if ((i4 & 128) != 0) {
                                        i5 &= -29360129;
                                    }
                                    if ((i4 & 256) != 0) {
                                        i5 &= -234881025;
                                    }
                                    iM17167getEndERTFSPs = i;
                                    j3 = j;
                                    j5 = j2;
                                    function2M17116getLambda1$material3_release = function25;
                                    function2M17117getLambda2$material3_release = function26;
                                    function2M17118getLambda3$material3_release = function27;
                                    function2M17119getLambda4$material3_release = function28;
                                    i14 = -1219521777;
                                    modifier2 = modifier;
                                    contentWindowInsets = windowInsets;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i14, i5, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:74)");
                                }
                                final int i19 = i5;
                                final Function2<? super Composer, ? super Integer, Unit> function213 = function2M17116getLambda1$material3_release;
                                final Function2<? super Composer, ? super Integer, Unit> function214 = function2M17117getLambda2$material3_release;
                                final Function2<? super Composer, ? super Integer, Unit> function215 = function2M17118getLambda3$material3_release;
                                final Function2<? super Composer, ? super Integer, Unit> function216 = function2M17119getLambda4$material3_release;
                                final int i20 = iM17167getEndERTFSPs;
                                final WindowInsets windowInsets3 = contentWindowInsets;
                                int i21 = i5 >> 12;
                                composer2 = composerStartRestartGroup;
                                SurfaceKt.m17325SurfaceT9BRK9s(modifier2, null, j3, j5, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1
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
                                    public final void invoke(@Nullable Composer composer3, int i22) {
                                        if ((i22 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1979205334, i22, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:86)");
                                        }
                                        int i23 = i20;
                                        Function2<Composer, Integer, Unit> function217 = function213;
                                        Function3<PaddingValues, Composer, Integer, Unit> function3 = content;
                                        Function2<Composer, Integer, Unit> function218 = function215;
                                        Function2<Composer, Integer, Unit> function219 = function216;
                                        WindowInsets windowInsets4 = windowInsets3;
                                        Function2<Composer, Integer, Unit> function220 = function214;
                                        int i24 = i19;
                                        ScaffoldKt.m17281ScaffoldLayoutFMILGgc(i23, function217, function3, function218, function219, windowInsets4, function220, composer3, ((i24 >> 15) & 14) | (i24 & 112) | ((i24 >> 21) & 896) | (i24 & 7168) | (57344 & i24) | ((i24 >> 9) & 458752) | ((i24 << 12) & 3670016));
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer2, (i5 & 14) | 12582912 | (i21 & 896) | (i21 & 7168), 114);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function29 = function2M17116getLambda1$material3_release;
                                function210 = function2M17117getLambda2$material3_release;
                                function211 = function2M17118getLambda3$material3_release;
                                function212 = function2M17119getLambda4$material3_release;
                                i15 = iM17167getEndERTFSPs;
                                windowInsets2 = contentWindowInsets;
                                modifier3 = modifier2;
                                j6 = j3;
                                j7 = j5;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                windowInsets2 = windowInsets;
                                composer2 = composerStartRestartGroup;
                                function29 = function25;
                                function210 = function26;
                                function211 = function27;
                                function212 = function28;
                                modifier3 = modifier;
                                i15 = i;
                                j6 = j;
                                j7 = j2;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                                public final void invoke(@Nullable Composer composer3, int i22) {
                                    ScaffoldKt.m17280ScaffoldTvnljyQ(modifier3, function29, function210, function211, function212, i15, j6, j7, windowInsets2, content, composer3, i2 | 1, i4);
                                }
                            });
                            return;
                        }
                        i11 = DriveFile.MODE_READ_WRITE;
                        i5 |= i11;
                        if ((1533916891 & i5) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i10 == 0) {
                                }
                                if (i17 == 0) {
                                }
                                if (i6 == 0) {
                                }
                                if (i7 == 0) {
                                }
                                if (i8 == 0) {
                                }
                                if (i9 == 0) {
                                }
                                if ((i4 & 64) == 0) {
                                }
                                if ((i4 & 128) == 0) {
                                }
                                int i182 = i12;
                                if ((i4 & 256) == 0) {
                                }
                                j3 = jM17038getBackground0d7_KjU;
                                j5 = jM17098contentColorForek8zF_U;
                                modifier2 = modifier4;
                                i14 = -1219521777;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                final int i192 = i5;
                                final Function2<? super Composer, ? super Integer, Unit> function2132 = function2M17116getLambda1$material3_release;
                                final Function2<? super Composer, ? super Integer, Unit> function2142 = function2M17117getLambda2$material3_release;
                                final Function2<? super Composer, ? super Integer, Unit> function2152 = function2M17118getLambda3$material3_release;
                                final Function2<? super Composer, ? super Integer, Unit> function2162 = function2M17119getLambda4$material3_release;
                                final int i202 = iM17167getEndERTFSPs;
                                final WindowInsets windowInsets32 = contentWindowInsets;
                                int i212 = i5 >> 12;
                                composer2 = composerStartRestartGroup;
                                SurfaceKt.m17325SurfaceT9BRK9s(modifier2, null, j3, j5, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1
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
                                    public final void invoke(@Nullable Composer composer3, int i22) {
                                        if ((i22 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1979205334, i22, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:86)");
                                        }
                                        int i23 = i202;
                                        Function2<Composer, Integer, Unit> function217 = function2132;
                                        Function3<PaddingValues, Composer, Integer, Unit> function3 = content;
                                        Function2<Composer, Integer, Unit> function218 = function2152;
                                        Function2<Composer, Integer, Unit> function219 = function2162;
                                        WindowInsets windowInsets4 = windowInsets32;
                                        Function2<Composer, Integer, Unit> function220 = function2142;
                                        int i24 = i192;
                                        ScaffoldKt.m17281ScaffoldLayoutFMILGgc(i23, function217, function3, function218, function219, windowInsets4, function220, composer3, ((i24 >> 15) & 14) | (i24 & 112) | ((i24 >> 21) & 896) | (i24 & 7168) | (57344 & i24) | ((i24 >> 9) & 458752) | ((i24 << 12) & 3670016));
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer2, (i5 & 14) | 12582912 | (i212 & 896) | (i212 & 7168), 114);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                function29 = function2M17116getLambda1$material3_release;
                                function210 = function2M17117getLambda2$material3_release;
                                function211 = function2M17118getLambda3$material3_release;
                                function212 = function2M17119getLambda4$material3_release;
                                i15 = iM17167getEndERTFSPs;
                                windowInsets2 = contentWindowInsets;
                                modifier3 = modifier2;
                                j6 = j3;
                                j7 = j5;
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    function28 = function24;
                    i9 = i4 & 32;
                    if (i9 != 0) {
                    }
                    if ((i2 & 3670016) == 0) {
                    }
                    if ((i2 & 29360128) == 0) {
                    }
                    if ((234881024 & i2) == 0) {
                    }
                    if ((i4 & 512) == 0) {
                    }
                    i5 |= i11;
                    if ((1533916891 & i5) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function27 = function23;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                function28 = function24;
                i9 = i4 & 32;
                if (i9 != 0) {
                }
                if ((i2 & 3670016) == 0) {
                }
                if ((i2 & 29360128) == 0) {
                }
                if ((234881024 & i2) == 0) {
                }
                if ((i4 & 512) == 0) {
                }
                i5 |= i11;
                if ((1533916891 & i5) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function26 = function22;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            function27 = function23;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            function28 = function24;
            i9 = i4 & 32;
            if (i9 != 0) {
            }
            if ((i2 & 3670016) == 0) {
            }
            if ((i2 & 29360128) == 0) {
            }
            if ((234881024 & i2) == 0) {
            }
            if ((i4 & 512) == 0) {
            }
            i5 |= i11;
            if ((1533916891 & i5) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        function25 = function2;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        function26 = function22;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        function27 = function23;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        function28 = function24;
        i9 = i4 & 32;
        if (i9 != 0) {
        }
        if ((i2 & 3670016) == 0) {
        }
        if ((i2 & 29360128) == 0) {
        }
        if ((234881024 & i2) == 0) {
        }
        if ((i4 & 512) == 0) {
        }
        i5 |= i11;
        if ((1533916891 & i5) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_][_][_]]")
    /* JADX INFO: renamed from: ScaffoldLayout-FMILGgc, reason: not valid java name */
    public static final void m17281ScaffoldLayoutFMILGgc(final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        Object obj;
        Composer composerStartRestartGroup = composer.startRestartGroup(-975511942);
        int i4 = (i2 & 14) == 0 ? (composerStartRestartGroup.changed(i) ? 4 : 2) | i2 : i2;
        if ((i2 & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(function2) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            obj = function3;
            i4 |= composerStartRestartGroup.changed(obj) ? 256 : 128;
        } else {
            obj = function3;
        }
        if ((i2 & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(function22) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(function23) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(windowInsets) ? 131072 : 65536;
        }
        if ((3670016 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(function24) ? 1048576 : 524288;
        }
        if ((2995931 & i4) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-975511942, i4, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:113)");
            }
            Object[] objArr = {function2, function22, windowInsets, function23, FabPosition.m17159boximpl(i), function24, obj};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i5 = 0; i5 < 7; i5++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i5]);
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                final int i6 = i4;
                Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function25 = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m17283invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    @NotNull
                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m17283invoke0kLqBqw(@NotNull final SubcomposeMeasureScope SubcomposeLayout, long j) {
                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                        final int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j);
                        final int iM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(j);
                        final long jM20912copyZbe2FdA$default = Constraints.m20912copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        final Function2<Composer, Integer, Unit> function26 = function2;
                        final Function2<Composer, Integer, Unit> function27 = function22;
                        final Function2<Composer, Integer, Unit> function28 = function23;
                        final int i7 = i;
                        final WindowInsets windowInsets2 = windowInsets;
                        final Function2<Composer, Integer, Unit> function29 = function24;
                        final int i8 = i6;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        return MeasureScope.layout$default(SubcomposeLayout, iM20921getMaxWidthimpl, iM20920getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1.1
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
                                Object next;
                                Object next2;
                                Object next3;
                                final FabPlacement fabPlacement;
                                Object next4;
                                Integer numValueOf;
                                Object next5;
                                Object next6;
                                Placeable.PlacementScope layout = placementScope;
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                List<Measurable> listSubcompose = SubcomposeLayout.subcompose(ScaffoldLayoutContent.TopBar, function26);
                                long j2 = jM20912copyZbe2FdA$default;
                                final ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(listSubcompose));
                                Iterator<T> it = listSubcompose.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((Measurable) it.next()).mo19855measureBRTryo0(j2));
                                }
                                Iterator it2 = arrayList.iterator();
                                if (it2.hasNext()) {
                                    next = it2.next();
                                    if (it2.hasNext()) {
                                        int height = ((Placeable) next).getHeight();
                                        while (true) {
                                            Object next7 = it2.next();
                                            int height2 = ((Placeable) next7).getHeight();
                                            if (height < height2) {
                                                next = next7;
                                                height = height2;
                                            }
                                            if (!it2.hasNext()) {
                                                break;
                                            } else {
                                                layout = placementScope;
                                            }
                                        }
                                    }
                                } else {
                                    next = null;
                                }
                                Placeable placeable = (Placeable) next;
                                final int height3 = placeable != null ? placeable.getHeight() : 0;
                                List<Measurable> listSubcompose2 = SubcomposeLayout.subcompose(ScaffoldLayoutContent.Snackbar, function27);
                                WindowInsets windowInsets3 = windowInsets2;
                                SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                long j3 = jM20912copyZbe2FdA$default;
                                ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(listSubcompose2));
                                Iterator<T> it3 = listSubcompose2.iterator();
                                while (it3.hasNext()) {
                                    arrayList2.add(((Measurable) it3.next()).mo19855measureBRTryo0(ConstraintsKt.m20940offsetNN6EwU(j3, (-windowInsets3.getLeft(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection())) - windowInsets3.getRight(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection()), -windowInsets3.getBottom(subcomposeMeasureScope))));
                                }
                                Iterator it4 = arrayList2.iterator();
                                if (it4.hasNext()) {
                                    next2 = it4.next();
                                    if (it4.hasNext()) {
                                        int height4 = ((Placeable) next2).getHeight();
                                        while (true) {
                                            Object next8 = it4.next();
                                            int height5 = ((Placeable) next8).getHeight();
                                            if (height4 < height5) {
                                                next2 = next8;
                                                height4 = height5;
                                            }
                                            if (!it4.hasNext()) {
                                                break;
                                            } else {
                                                layout = placementScope;
                                            }
                                        }
                                    }
                                } else {
                                    next2 = null;
                                }
                                Placeable placeable2 = (Placeable) next2;
                                int height6 = placeable2 != null ? placeable2.getHeight() : 0;
                                Iterator it5 = arrayList2.iterator();
                                if (it5.hasNext()) {
                                    next3 = it5.next();
                                    if (it5.hasNext()) {
                                        int width = ((Placeable) next3).getWidth();
                                        while (true) {
                                            Object next9 = it5.next();
                                            int width2 = ((Placeable) next9).getWidth();
                                            if (width < width2) {
                                                next3 = next9;
                                                width = width2;
                                            }
                                            if (!it5.hasNext()) {
                                                break;
                                            } else {
                                                layout = placementScope;
                                            }
                                        }
                                    }
                                } else {
                                    next3 = null;
                                }
                                Placeable placeable3 = (Placeable) next3;
                                int width3 = placeable3 != null ? placeable3.getWidth() : 0;
                                List<Measurable> listSubcompose3 = SubcomposeLayout.subcompose(ScaffoldLayoutContent.Fab, function28);
                                WindowInsets windowInsets4 = windowInsets2;
                                SubcomposeMeasureScope subcomposeMeasureScope2 = SubcomposeLayout;
                                long j5 = jM20912copyZbe2FdA$default;
                                ArrayList<Placeable> arrayList3 = new ArrayList();
                                Iterator<T> it6 = listSubcompose3.iterator();
                                while (it6.hasNext()) {
                                    Placeable placeableMo19855measureBRTryo0 = ((Measurable) it6.next()).mo19855measureBRTryo0(ConstraintsKt.m20940offsetNN6EwU(j5, (-windowInsets4.getLeft(subcomposeMeasureScope2, subcomposeMeasureScope2.getLayoutDirection())) - windowInsets4.getRight(subcomposeMeasureScope2, subcomposeMeasureScope2.getLayoutDirection()), -windowInsets4.getBottom(subcomposeMeasureScope2)));
                                    if (placeableMo19855measureBRTryo0.getHeight() == 0 || placeableMo19855measureBRTryo0.getWidth() == 0) {
                                        placeableMo19855measureBRTryo0 = null;
                                    }
                                    if (placeableMo19855measureBRTryo0 != null) {
                                        arrayList3.add(placeableMo19855measureBRTryo0);
                                    }
                                }
                                if (arrayList3.isEmpty()) {
                                    fabPlacement = null;
                                } else {
                                    Iterator it7 = arrayList3.iterator();
                                    if (it7.hasNext()) {
                                        next5 = it7.next();
                                        if (it7.hasNext()) {
                                            int width4 = ((Placeable) next5).getWidth();
                                            do {
                                                Object next10 = it7.next();
                                                int width5 = ((Placeable) next10).getWidth();
                                                if (width4 < width5) {
                                                    next5 = next10;
                                                    width4 = width5;
                                                }
                                            } while (it7.hasNext());
                                        }
                                    } else {
                                        next5 = null;
                                    }
                                    Intrinsics.checkNotNull(next5);
                                    int width6 = ((Placeable) next5).getWidth();
                                    Iterator it8 = arrayList3.iterator();
                                    if (it8.hasNext()) {
                                        next6 = it8.next();
                                        if (it8.hasNext()) {
                                            int height7 = ((Placeable) next6).getHeight();
                                            do {
                                                Object next11 = it8.next();
                                                int height8 = ((Placeable) next11).getHeight();
                                                if (height7 < height8) {
                                                    next6 = next11;
                                                    height7 = height8;
                                                }
                                            } while (it8.hasNext());
                                        }
                                    } else {
                                        next6 = null;
                                    }
                                    Intrinsics.checkNotNull(next6);
                                    fabPlacement = new FabPlacement(FabPosition.m17162equalsimpl0(i7, FabPosition.INSTANCE.m17167getEndERTFSPs()) ? SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? (iM20921getMaxWidthimpl - SubcomposeLayout.mo15540roundToPx0680j_4(ScaffoldKt.FabSpacing)) - width6 : SubcomposeLayout.mo15540roundToPx0680j_4(ScaffoldKt.FabSpacing) : (iM20921getMaxWidthimpl - width6) / 2, width6, ((Placeable) next6).getHeight());
                                }
                                SubcomposeMeasureScope subcomposeMeasureScope3 = SubcomposeLayout;
                                ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                                final Function2<Composer, Integer, Unit> function210 = function29;
                                final int i9 = i8;
                                List<Measurable> listSubcompose4 = subcomposeMeasureScope3.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(-1455477816, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1
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
                                    public final void invoke(@Nullable Composer composer2, int i10) {
                                        if ((i10 & 11) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1455477816, i10, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:195)");
                                        }
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ScaffoldKt.getLocalFabPlacement().provides(fabPlacement)}, function210, composer2, ((i9 >> 15) & 112) | 8);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                                long j6 = jM20912copyZbe2FdA$default;
                                final ArrayList arrayList4 = new ArrayList(CollectionsKt.m13952k(listSubcompose4));
                                Iterator<T> it9 = listSubcompose4.iterator();
                                while (it9.hasNext()) {
                                    arrayList4.add(((Measurable) it9.next()).mo19855measureBRTryo0(j6));
                                }
                                Iterator it10 = arrayList4.iterator();
                                if (it10.hasNext()) {
                                    next4 = it10.next();
                                    if (it10.hasNext()) {
                                        int height9 = ((Placeable) next4).getHeight();
                                        while (true) {
                                            Object next12 = it10.next();
                                            int height10 = ((Placeable) next12).getHeight();
                                            if (height9 < height10) {
                                                next4 = next12;
                                                height9 = height10;
                                            }
                                            if (!it10.hasNext()) {
                                                break;
                                            } else {
                                                layout = placementScope;
                                            }
                                        }
                                    }
                                } else {
                                    next4 = null;
                                }
                                Placeable placeable4 = (Placeable) next4;
                                final Integer numValueOf2 = placeable4 != null ? Integer.valueOf(placeable4.getHeight()) : null;
                                if (fabPlacement != null) {
                                    SubcomposeMeasureScope subcomposeMeasureScope4 = SubcomposeLayout;
                                    numValueOf = Integer.valueOf(numValueOf2 == null ? windowInsets2.getBottom(subcomposeMeasureScope4) + subcomposeMeasureScope4.mo15540roundToPx0680j_4(ScaffoldKt.FabSpacing) + fabPlacement.getHeight() : subcomposeMeasureScope4.mo15540roundToPx0680j_4(ScaffoldKt.FabSpacing) + fabPlacement.getHeight() + numValueOf2.intValue());
                                } else {
                                    numValueOf = null;
                                }
                                int iIntValue = height6 != 0 ? height6 + (numValueOf != null ? numValueOf.intValue() : numValueOf2 != null ? numValueOf2.intValue() : windowInsets2.getBottom(SubcomposeLayout)) : 0;
                                final SubcomposeMeasureScope subcomposeMeasureScope5 = SubcomposeLayout;
                                ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                                final WindowInsets windowInsets5 = windowInsets2;
                                final Function3<PaddingValues, Composer, Integer, Unit> function33 = function32;
                                final int i10 = i8;
                                List<Measurable> listSubcompose5 = subcomposeMeasureScope5.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(1643221465, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1
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
                                    public final void invoke(@Nullable Composer composer2, int i11) {
                                        Integer num;
                                        if ((i11 & 11) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1643221465, i11, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:222)");
                                        }
                                        PaddingValues paddingValuesAsPaddingValues = WindowInsetsKt.asPaddingValues(windowInsets5, subcomposeMeasureScope5);
                                        function33.invoke(PaddingKt.m15850PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(paddingValuesAsPaddingValues, subcomposeMeasureScope5.getLayoutDirection()), arrayList.isEmpty() ? paddingValuesAsPaddingValues.getTop() : subcomposeMeasureScope5.mo15543toDpu2uoSUM(height3), PaddingKt.calculateEndPadding(paddingValuesAsPaddingValues, subcomposeMeasureScope5.getLayoutDirection()), (arrayList4.isEmpty() || (num = numValueOf2) == null) ? paddingValuesAsPaddingValues.getBottom() : subcomposeMeasureScope5.mo15543toDpu2uoSUM(num.intValue())), composer2, Integer.valueOf((i10 >> 3) & 112));
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                                long j7 = jM20912copyZbe2FdA$default;
                                ArrayList arrayList5 = new ArrayList(CollectionsKt.m13952k(listSubcompose5));
                                Iterator<T> it11 = listSubcompose5.iterator();
                                while (it11.hasNext()) {
                                    arrayList5.add(((Measurable) it11.next()).mo19855measureBRTryo0(j7));
                                }
                                Iterator it12 = arrayList5.iterator();
                                while (it12.hasNext()) {
                                    Placeable.PlacementScope.place$default(layout, (Placeable) it12.next(), 0, 0, 0.0f, 4, null);
                                    layout = placementScope;
                                }
                                Iterator it13 = arrayList.iterator();
                                while (it13.hasNext()) {
                                    Placeable.PlacementScope.place$default(placementScope, (Placeable) it13.next(), 0, 0, 0.0f, 4, null);
                                }
                                int i11 = iM20921getMaxWidthimpl;
                                WindowInsets windowInsets6 = windowInsets2;
                                SubcomposeMeasureScope subcomposeMeasureScope6 = SubcomposeLayout;
                                int i12 = iM20920getMaxHeightimpl;
                                Iterator it14 = arrayList2.iterator();
                                while (it14.hasNext()) {
                                    Placeable.PlacementScope.place$default(placementScope, (Placeable) it14.next(), ((i11 - width3) / 2) + windowInsets6.getLeft(subcomposeMeasureScope6, subcomposeMeasureScope6.getLayoutDirection()), i12 - iIntValue, 0.0f, 4, null);
                                    i12 = i12;
                                }
                                int i13 = iM20920getMaxHeightimpl;
                                Iterator it15 = arrayList4.iterator();
                                while (it15.hasNext()) {
                                    Placeable.PlacementScope.place$default(placementScope, (Placeable) it15.next(), 0, i13 - (numValueOf2 != null ? numValueOf2.intValue() : 0), 0.0f, 4, null);
                                }
                                if (fabPlacement != null) {
                                    int i14 = iM20920getMaxHeightimpl;
                                    for (Placeable placeable5 : arrayList3) {
                                        int left = fabPlacement.getLeft();
                                        Intrinsics.checkNotNull(numValueOf);
                                        Placeable.PlacementScope.place$default(placementScope, placeable5, left, i14 - numValueOf.intValue(), 0.0f, 4, null);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function25);
                objRememberedValue = function25;
            }
            composerStartRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) objRememberedValue, composerStartRestartGroup, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$2
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
                ScaffoldKt.m17281ScaffoldLayoutFMILGgc(i, function2, function3, function22, function23, windowInsets, function24, composer2, i2 | 1);
            }
        });
    }

    @NotNull
    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
