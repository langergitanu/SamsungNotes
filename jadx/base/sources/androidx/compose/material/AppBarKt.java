package androidx.compose.material;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.RectangleShapeKt;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.unit.C2256Dp;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ae\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aq\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0087\u0001\u0010\u001f\u001a\u00020\n2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\n0!¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010!¢\u0006\u0002\b\u00172\u001e\b\u0002\u0010#\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001ae\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)H\u0080\b\u001a,\u0010,\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0-2\u0006\u0010.\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010/\u001a\u00020)H\u0000\u001a\u0011\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020)H\u0082\b\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00062"}, m13886d2 = {"AppBarHeight", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "AppBarHorizontalPadding", "BottomAppBarCutoutOffset", "BottomAppBarRoundedEdgeRadius", "TitleIconModifier", "Landroidx/compose/ui/Modifier;", "TitleInsetWithoutIcon", "AppBar", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "modifier", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "AppBar-celAv9A", "(JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar", "cutoutShape", "BottomAppBar-Y1yfwus", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar", "title", "Lkotlin/Function0;", "navigationIcon", "actions", "TopAppBar-xWeB9-s", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateCutoutCircleYIntercept", "", "cutoutRadius", "verticalOffset", "calculateRoundedEdgeIntercept", "Lkotlin/Pair;", "controlPointX", "radius", "square", "x", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class AppBarKt {
    private static final float AppBarHeight = C2256Dp.m20968constructorimpl(56);
    private static final float AppBarHorizontalPadding;
    private static final float BottomAppBarCutoutOffset;
    private static final float BottomAppBarRoundedEdgeRadius;

    @NotNull
    private static final Modifier TitleIconModifier;

    @NotNull
    private static final Modifier TitleInsetWithoutIcon;

    static {
        float f = 4;
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(f);
        AppBarHorizontalPadding = fM20968constructorimpl;
        Modifier.Companion companion = Modifier.INSTANCE;
        TitleInsetWithoutIcon = SizeKt.m15904width3ABfNKs(companion, C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(16) - fM20968constructorimpl));
        TitleIconModifier = SizeKt.m15904width3ABfNKs(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(72) - fM20968constructorimpl));
        BottomAppBarCutoutOffset = C2256Dp.m20968constructorimpl(8);
        BottomAppBarRoundedEdgeRadius = C2256Dp.m20968constructorimpl(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x013b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x013c  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: AppBar-celAv9A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16586AppBarcelAv9A(final long j, final long j2, final float f, final PaddingValues paddingValues, final Shape shape, Modifier modifier, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        long j3;
        final int i4;
        long j5;
        float f4;
        Shape shape2;
        int i5;
        Modifier modifier2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1249680788);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
            j3 = j;
        } else {
            j3 = j;
            if ((i & 14) == 0) {
                i4 = (composerStartRestartGroup.changed(j3) ? 4 : 2) | i;
            } else {
                i4 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                j5 = j2;
                i4 |= composerStartRestartGroup.changed(j5) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    f4 = f;
                    i4 |= composerStartRestartGroup.changed(f4) ? 256 : 128;
                }
                if ((i2 & 8) != 0) {
                    i4 |= 3072;
                } else if ((i & 7168) == 0) {
                    i4 |= composerStartRestartGroup.changed(paddingValues) ? 2048 : 1024;
                }
                if ((i2 & 16) != 0) {
                    i4 |= 24576;
                } else {
                    if ((57344 & i) == 0) {
                        shape2 = shape;
                        i4 |= composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                    }
                    i5 = i2 & 32;
                    if (i5 != 0) {
                        if ((i & 458752) == 0) {
                            modifier2 = modifier;
                            i4 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
                        }
                        if ((i2 & 64) != 0) {
                            i4 |= 1572864;
                        } else if ((3670016 & i) == 0) {
                            i4 |= composerStartRestartGroup.changed(function3) ? 1048576 : 524288;
                        }
                        if ((2995931 & i4) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            composer2 = composerStartRestartGroup;
                            modifier3 = modifier2;
                        } else {
                            Modifier modifier4 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1249680788, i4, -1, "androidx.compose.material.AppBar (AppBar.kt:504)");
                            }
                            int i6 = i4 << 6;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m16872SurfaceFjzlyU(modifier4, shape2, j3, j5, null, f4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
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
                                public final void invoke(@Nullable Composer composer3, int i7) {
                                    if ((i7 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1027830352, i7, -1, "androidx.compose.material.AppBar.<anonymous> (AppBar.kt:519)");
                                    }
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                    final PaddingValues paddingValues2 = paddingValues;
                                    final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                    final int i8 = i4;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                        public final void invoke(@Nullable Composer composer4, int i9) {
                                            if ((i9 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1296061040, i9, -1, "androidx.compose.material.AppBar.<anonymous>.<anonymous> (AppBar.kt:520)");
                                            }
                                            Modifier modifierM15885height3ABfNKs = SizeKt.m15885height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                            int i10 = ((i8 >> 9) & 7168) | 432;
                                            composer4.startReplaceableGroup(693286680);
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer4, 54);
                                            Density density = (Density) AbstractC1038a.m1211l(composer4, -1323940314);
                                            LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15885height3ABfNKs);
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
                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                            composer4.startReplaceableGroup(-678309503);
                                            function33.invoke(RowScopeInstance.INSTANCE, composer4, Integer.valueOf(((i10 >> 6) & 112) | 6));
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, ((i4 >> 15) & 14) | 1572864 | ((i4 >> 9) & 112) | (i6 & 896) | (i6 & 7168) | ((i4 << 9) & 458752), 16);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
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

                            public final void invoke(@Nullable Composer composer3, int i7) {
                                AppBarKt.m16586AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier3, function3, composer3, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= 196608;
                    modifier2 = modifier;
                    if ((i2 & 64) != 0) {
                    }
                    if ((2995931 & i4) == 599186) {
                        if (i5 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i62 = i4 << 6;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m16872SurfaceFjzlyU(modifier4, shape2, j3, j5, null, f4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
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
                            public final void invoke(@Nullable Composer composer3, int i7) {
                                if ((i7 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1027830352, i7, -1, "androidx.compose.material.AppBar.<anonymous> (AppBar.kt:519)");
                                }
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                final int i8 = i4;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                    public final void invoke(@Nullable Composer composer4, int i9) {
                                        if ((i9 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1296061040, i9, -1, "androidx.compose.material.AppBar.<anonymous>.<anonymous> (AppBar.kt:520)");
                                        }
                                        Modifier modifierM15885height3ABfNKs = SizeKt.m15885height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                        int i10 = ((i8 >> 9) & 7168) | 432;
                                        composer4.startReplaceableGroup(693286680);
                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer4, 54);
                                        Density density = (Density) AbstractC1038a.m1211l(composer4, -1323940314);
                                        LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor = companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15885height3ABfNKs);
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
                                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                        composer4.startReplaceableGroup(-678309503);
                                        function33.invoke(RowScopeInstance.INSTANCE, composer4, Integer.valueOf(((i10 >> 6) & 112) | 6));
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, ((i4 >> 15) & 14) | 1572864 | ((i4 >> 9) & 112) | (i62 & 896) | (i62 & 7168) | ((i4 << 9) & 458752), 16);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                shape2 = shape;
                i5 = i2 & 32;
                if (i5 != 0) {
                }
                modifier2 = modifier;
                if ((i2 & 64) != 0) {
                }
                if ((2995931 & i4) == 599186) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            f4 = f;
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            shape2 = shape;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            modifier2 = modifier;
            if ((i2 & 64) != 0) {
            }
            if ((2995931 & i4) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        j5 = j2;
        if ((i2 & 4) == 0) {
        }
        f4 = f;
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        shape2 = shape;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        modifier2 = modifier;
        if ((i2 & 64) != 0) {
        }
        if ((2995931 & i4) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01d9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0127  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: BottomAppBar-Y1yfwus, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16587BottomAppBarY1yfwus(@Nullable Modifier modifier, long j, long j2, @Nullable Shape shape, float f, @Nullable PaddingValues paddingValues, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        long j3;
        long j5;
        Shape shape2;
        int i5;
        float fM16584getBottomAppBarElevationD9Ej5fM;
        int i6;
        int i7;
        long j6;
        Modifier modifier3;
        long j7;
        Shape shape3;
        float f4;
        PaddingValues contentPadding;
        final PaddingValues paddingValues2;
        final Shape shape4;
        final float f5;
        final long j8;
        final long j9;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1651948973);
        int i9 = i2 & 1;
        if (i9 != 0) {
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
                j3 = j;
                int i10 = composerStartRestartGroup.changed(j3) ? 32 : 16;
                i4 |= i10;
            } else {
                j3 = j;
            }
            i4 |= i10;
        } else {
            j3 = j;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                j5 = j2;
                int i11 = composerStartRestartGroup.changed(j5) ? 256 : 128;
                i4 |= i11;
            } else {
                j5 = j2;
            }
            i4 |= i11;
        } else {
            j5 = j2;
        }
        int i12 = i2 & 8;
        if (i12 != 0) {
            i4 |= 3072;
        } else {
            if ((i & 7168) == 0) {
                shape2 = shape;
                i4 |= composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
            }
            i5 = i2 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((57344 & i) == 0) {
                    fM16584getBottomAppBarElevationD9Ej5fM = f;
                    i4 |= composerStartRestartGroup.changed(fM16584getBottomAppBarElevationD9Ej5fM) ? 16384 : 8192;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else if ((i & 458752) == 0) {
                    i4 |= composerStartRestartGroup.changed(paddingValues) ? 131072 : 65536;
                }
                if ((i2 & 64) == 0) {
                    i8 = (i & 3670016) == 0 ? composerStartRestartGroup.changed(content) ? 1048576 : 524288 : 1572864;
                    if ((i4 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier5 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 2) != 0) {
                                long primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                j3 = primarySurface;
                            }
                            if ((i2 & 4) != 0) {
                                long jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(j3, composerStartRestartGroup, (i4 >> 3) & 14);
                                i4 &= -897;
                                j5 = jM16694contentColorForek8zF_U;
                            }
                            if (i12 != 0) {
                                shape2 = null;
                            }
                            if (i5 != 0) {
                                fM16584getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m16584getBottomAppBarElevationD9Ej5fM();
                            }
                            if (i6 == 0) {
                                long j10 = j5;
                                i7 = i4;
                                j6 = j10;
                                modifier3 = modifier5;
                                shape3 = shape2;
                                contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                                j7 = j3;
                                f4 = fM16584getBottomAppBarElevationD9Ej5fM;
                            } else {
                                long j11 = j5;
                                i7 = i4;
                                j6 = j11;
                                modifier3 = modifier5;
                                j7 = j3;
                                shape3 = shape2;
                                f4 = fM16584getBottomAppBarElevationD9Ej5fM;
                                contentPadding = paddingValues;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                            }
                            if ((i2 & 4) != 0) {
                                i4 &= -897;
                            }
                            j7 = j3;
                            shape3 = shape2;
                            f4 = fM16584getBottomAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues;
                            long j12 = j5;
                            modifier3 = modifier2;
                            i7 = i4;
                            j6 = j12;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1651948973, i7, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
                        }
                        FabPlacement fabPlacement = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
                        int i13 = i7 >> 6;
                        m16586AppBarcelAv9A(j7, j6, f4, contentPadding, (shape3 == null && fabPlacement != null && fabPlacement.getIsDocked()) ? new BottomAppBarCutoutShape(shape3, fabPlacement) : RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, ((i7 >> 3) & 126) | (i13 & 896) | (i13 & 7168) | ((i7 << 15) & 458752) | (i7 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = contentPadding;
                        shape4 = shape3;
                        Modifier modifier6 = modifier3;
                        f5 = f4;
                        j8 = j6;
                        j9 = j7;
                        modifier4 = modifier6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        paddingValues2 = paddingValues;
                        modifier4 = modifier2;
                        j9 = j3;
                        j8 = j5;
                        shape4 = shape2;
                        f5 = fM16584getBottomAppBarElevationD9Ej5fM;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$BottomAppBar$1
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
                            AppBarKt.m16587BottomAppBarY1yfwus(modifier4, j9, j8, shape4, f5, paddingValues2, content, composer2, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= i8;
                if ((i4 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 == 0) {
                        }
                        if ((i2 & 2) != 0) {
                        }
                        if ((i2 & 4) != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        FabPlacement fabPlacement2 = (FabPlacement) composerStartRestartGroup.consume(ScaffoldKt.getLocalFabPlacement());
                        if (shape3 == null) {
                            int i132 = i7 >> 6;
                            m16586AppBarcelAv9A(j7, j6, f4, contentPadding, (shape3 == null && fabPlacement2 != null && fabPlacement2.getIsDocked()) ? new BottomAppBarCutoutShape(shape3, fabPlacement2) : RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, ((i7 >> 3) & 126) | (i132 & 896) | (i132 & 7168) | ((i7 << 15) & 458752) | (i7 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            paddingValues2 = contentPadding;
                            shape4 = shape3;
                            Modifier modifier62 = modifier3;
                            f5 = f4;
                            j8 = j6;
                            j9 = j7;
                            modifier4 = modifier62;
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            fM16584getBottomAppBarElevationD9Ej5fM = f;
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            if ((i2 & 64) == 0) {
            }
            i4 |= i8;
            if ((i4 & 2995931) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        shape2 = shape;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        fM16584getBottomAppBarElevationD9Ej5fM = f;
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        if ((i2 & 64) == 0) {
        }
        i4 |= i8;
        if ((i4 & 2995931) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0188 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012c  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: TopAppBar-HsRjFd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16588TopAppBarHsRjFd4(@Nullable Modifier modifier, long j, long j2, float f, @Nullable PaddingValues paddingValues, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        long j3;
        long j5;
        float fM16585getTopAppBarElevationD9Ej5fM;
        int i5;
        PaddingValues paddingValues2;
        long primarySurface;
        float f4;
        PaddingValues contentPadding;
        long j6;
        Modifier modifier3;
        long j7;
        final float f5;
        final PaddingValues paddingValues3;
        final long j8;
        final long j9;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1897058582);
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
                j3 = j;
                int i8 = composerStartRestartGroup.changed(j3) ? 32 : 16;
                i4 |= i8;
            } else {
                j3 = j;
            }
            i4 |= i8;
        } else {
            j3 = j;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                j5 = j2;
                int i9 = composerStartRestartGroup.changed(j5) ? 256 : 128;
                i4 |= i9;
            } else {
                j5 = j2;
            }
            i4 |= i9;
        } else {
            j5 = j2;
        }
        int i10 = i2 & 8;
        if (i10 != 0) {
            i4 |= 3072;
        } else {
            if ((i & 7168) == 0) {
                fM16585getTopAppBarElevationD9Ej5fM = f;
                i4 |= composerStartRestartGroup.changed(fM16585getTopAppBarElevationD9Ej5fM) ? 2048 : 1024;
            }
            i5 = i2 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((57344 & i) == 0) {
                    paddingValues2 = paddingValues;
                    i4 |= composerStartRestartGroup.changed(paddingValues2) ? 16384 : 8192;
                }
                if ((i2 & 32) == 0) {
                    i6 = (i & 458752) == 0 ? composerStartRestartGroup.changed(content) ? 131072 : 65536 : 196608;
                    if ((374491 & i4) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier5 = i7 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 2) == 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                            } else {
                                primarySurface = j3;
                            }
                            if ((i2 & 4) != 0) {
                                long jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 3) & 14);
                                i4 &= -897;
                                j5 = jM16694contentColorForek8zF_U;
                            }
                            if (i10 != 0) {
                                fM16585getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m16585getTopAppBarElevationD9Ej5fM();
                            }
                            if (i5 == 0) {
                                contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                                f4 = fM16585getTopAppBarElevationD9Ej5fM;
                            } else {
                                f4 = fM16585getTopAppBarElevationD9Ej5fM;
                                contentPadding = paddingValues2;
                            }
                            j6 = j5;
                            modifier3 = modifier5;
                            j7 = primarySurface;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                            }
                            if ((i2 & 4) != 0) {
                                i4 &= -897;
                            }
                            j7 = j3;
                            f4 = fM16585getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            j6 = j5;
                            modifier3 = modifier2;
                        }
                        int i11 = i4;
                        long j10 = j6;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1897058582, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
                        }
                        int i12 = i11 >> 3;
                        m16586AppBarcelAv9A(j7, j10, f4, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, ((i11 << 3) & 3670016) | (i12 & 7168) | (i12 & 14) | 24576 | (i12 & 112) | (i12 & 896) | ((i11 << 15) & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f5 = f4;
                        Modifier modifier6 = modifier3;
                        paddingValues3 = contentPadding;
                        j8 = j10;
                        j9 = j7;
                        modifier4 = modifier6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        j9 = j3;
                        j8 = j5;
                        f5 = fM16585getTopAppBarElevationD9Ej5fM;
                        paddingValues3 = paddingValues2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$3
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
                            AppBarKt.m16588TopAppBarHsRjFd4(modifier4, j9, j8, f5, paddingValues3, content, composer2, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= i6;
                if ((374491 & i4) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 == 0) {
                        }
                        if ((i2 & 2) == 0) {
                        }
                        if ((i2 & 4) != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i5 == 0) {
                        }
                        j6 = j5;
                        modifier3 = modifier5;
                        j7 = primarySurface;
                        int i112 = i4;
                        long j102 = j6;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i122 = i112 >> 3;
                        m16586AppBarcelAv9A(j7, j102, f4, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, ((i112 << 3) & 3670016) | (i122 & 7168) | (i122 & 14) | 24576 | (i122 & 112) | (i122 & 896) | ((i112 << 15) & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        f5 = f4;
                        Modifier modifier62 = modifier3;
                        paddingValues3 = contentPadding;
                        j8 = j102;
                        j9 = j7;
                        modifier4 = modifier62;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            paddingValues2 = paddingValues;
            if ((i2 & 32) == 0) {
            }
            i4 |= i6;
            if ((374491 & i4) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        fM16585getTopAppBarElevationD9Ej5fM = f;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        paddingValues2 = paddingValues;
        if ((i2 & 32) == 0) {
        }
        i4 |= i6;
        if ((374491 & i4) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0127  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: TopAppBar-xWeB9-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16589TopAppBarxWeB9s(@NotNull final Function2<? super Composer, ? super Integer, Unit> title, @Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, long j, long j2, float f, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        int i6;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M16699getLambda1$material_release;
        long primarySurface;
        long jM16694contentColorForek8zF_U;
        int i7;
        int i8;
        float f4;
        final int i9;
        long j3;
        float fM16585getTopAppBarElevationD9Ej5fM;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        final long j5;
        final float f5;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2087748139);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
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
                    function22 = function2;
                    i4 |= composerStartRestartGroup.changed(function22) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 == 0) {
                    if ((i & 7168) == 0) {
                        function3M16699getLambda1$material_release = function3;
                        i4 |= composerStartRestartGroup.changed(function3M16699getLambda1$material_release) ? 2048 : 1024;
                    }
                    if ((57344 & i) != 0) {
                        if ((i2 & 16) == 0) {
                            primarySurface = j;
                            int i11 = composerStartRestartGroup.changed(primarySurface) ? 16384 : 8192;
                            i4 |= i11;
                        } else {
                            primarySurface = j;
                        }
                        i4 |= i11;
                    } else {
                        primarySurface = j;
                    }
                    if ((i & 458752) != 0) {
                        if ((i2 & 32) == 0) {
                            jM16694contentColorForek8zF_U = j2;
                            int i12 = composerStartRestartGroup.changed(jM16694contentColorForek8zF_U) ? 131072 : 65536;
                            i4 |= i12;
                        } else {
                            jM16694contentColorForek8zF_U = j2;
                        }
                        i4 |= i12;
                    } else {
                        jM16694contentColorForek8zF_U = j2;
                    }
                    i7 = i2 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                        i8 = 458752;
                        f4 = f;
                    } else {
                        i8 = 458752;
                        f4 = f;
                        if ((i & 3670016) == 0) {
                            i4 |= composerStartRestartGroup.changed(f4) ? 1048576 : 524288;
                        }
                    }
                    int i13 = i4;
                    if ((i4 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function22 = null;
                            }
                            if (i6 != 0) {
                                function3M16699getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m16699getLambda1$material_release();
                            }
                            if ((i2 & 16) == 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i9 = i13 & (-57345);
                            } else {
                                i9 = i13;
                            }
                            if ((i2 & 32) != 0) {
                                jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i9 >> 12) & 14);
                                i9 &= -458753;
                            }
                            if (i7 == 0) {
                                j3 = jM16694contentColorForek8zF_U;
                                fM16585getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m16585getTopAppBarElevationD9Ej5fM();
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2087748139, i9, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
                            }
                            int i14 = i9 >> 12;
                            composer2 = composerStartRestartGroup;
                            Modifier modifier4 = modifier2;
                            m16586AppBarcelAv9A(primarySurface, j3, fM16585getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                    invoke(rowScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@NotNull RowScope AppBar, @Nullable Composer composer3, int i15) {
                                    int i16;
                                    Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                                    if ((i15 & 14) == 0) {
                                        i16 = (composer3.changed(AppBar) ? 4 : 2) | i15;
                                    } else {
                                        i16 = i15;
                                    }
                                    if ((i16 & 91) == 18 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1484077694, i15, -1, "androidx.compose.material.TopAppBar.<anonymous> (AppBar.kt:92)");
                                    }
                                    if (function22 == null) {
                                        composer3.startReplaceableGroup(-512812651);
                                        SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer3, 6);
                                        composer3.endReplaceableGroup();
                                    } else {
                                        composer3.startReplaceableGroup(-512812592);
                                        Modifier modifier5 = AppBarKt.TitleIconModifier;
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function2<Composer, Integer, Unit> function24 = function22;
                                        int i17 = i9;
                                        composer3.startReplaceableGroup(693286680);
                                        MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composer3, 48, -1323940314);
                                        Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                        LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor = companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier5);
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
                                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
                                        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                        composer3.startReplaceableGroup(1485618042);
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function24, composer3, ((i17 >> 3) & 112) | 8);
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                    }
                                    Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                    final Function2<Composer, Integer, Unit> function25 = title;
                                    final int i18 = i9;
                                    composer3.startReplaceableGroup(693286680);
                                    MeasurePolicy measurePolicyM1207h2 = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically2, composer3, 48, -1323940314);
                                    Density density2 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
                                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1207h2, composerM18018constructorimpl2, density2));
                                    function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer3, composer3), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    composer3.startReplaceableGroup(-678309503);
                                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                    composer3.startReplaceableGroup(159489950);
                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer3, 6).getH6(), ComposableLambdaKt.composableLambda(composer3, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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
                                        public final void invoke(@Nullable Composer composer4, int i19) {
                                            if ((i19 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2021518195, i19, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:108)");
                                            }
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer4, 6)))}, function25, composer4, ((i18 << 3) & 112) | 8);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, 48);
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                    final Function3<RowScope, Composer, Integer, Unit> function33 = function3M16699getLambda1$material_release;
                                    final int i19 = i9;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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
                                        public final void invoke(@Nullable Composer composer4, int i20) {
                                            if ((i20 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1157662914, i20, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous> (AppBar.kt:116)");
                                            }
                                            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                            int i21 = (i19 & 7168) | 438;
                                            composer4.startReplaceableGroup(693286680);
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically3, composer4, 54);
                                            Density density3 = (Density) AbstractC1038a.m1211l(composer4, -1323940314);
                                            LayoutDirection layoutDirection3 = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                            if (composer4.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor3);
                                            } else {
                                                composer4.useNode();
                                            }
                                            composer4.disableReusing();
                                            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composer4);
                                            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl3, measurePolicyRowMeasurePolicy, composerM18018constructorimpl3, density3));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf3, AbstractC1038a.m1206g(companion3, composerM18018constructorimpl3, viewConfiguration3, composer4, composer4), composer4, 2058660585);
                                            composer4.startReplaceableGroup(-678309503);
                                            function34.invoke(RowScopeInstance.INSTANCE, composer4, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, (i14 & 896) | (i14 & 14) | 1600512 | (i14 & 112) | ((i9 << 12) & i8), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function23 = function22;
                            function32 = function3M16699getLambda1$material_release;
                            j5 = j3;
                            f5 = fM16585getTopAppBarElevationD9Ej5fM;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i9 = (i2 & 16) != 0 ? i13 & (-57345) : i13;
                            if ((i2 & 32) != 0) {
                                i9 &= -458753;
                            }
                        }
                        fM16585getTopAppBarElevationD9Ej5fM = f4;
                        j3 = jM16694contentColorForek8zF_U;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i142 = i9 >> 12;
                        composer2 = composerStartRestartGroup;
                        Modifier modifier42 = modifier2;
                        m16586AppBarcelAv9A(primarySurface, j3, fM16585getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier42, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                invoke(rowScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@NotNull RowScope AppBar, @Nullable Composer composer3, int i15) {
                                int i16;
                                Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                                if ((i15 & 14) == 0) {
                                    i16 = (composer3.changed(AppBar) ? 4 : 2) | i15;
                                } else {
                                    i16 = i15;
                                }
                                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1484077694, i15, -1, "androidx.compose.material.TopAppBar.<anonymous> (AppBar.kt:92)");
                                }
                                if (function22 == null) {
                                    composer3.startReplaceableGroup(-512812651);
                                    SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer3, 6);
                                    composer3.endReplaceableGroup();
                                } else {
                                    composer3.startReplaceableGroup(-512812592);
                                    Modifier modifier5 = AppBarKt.TitleIconModifier;
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function24 = function22;
                                    int i17 = i9;
                                    composer3.startReplaceableGroup(693286680);
                                    MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composer3, 48, -1323940314);
                                    Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier5);
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
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
                                    function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    composer3.startReplaceableGroup(-678309503);
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    composer3.startReplaceableGroup(1485618042);
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function24, composer3, ((i17 >> 3) & 112) | 8);
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                }
                                Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                final Function2<? super Composer, ? super Integer, Unit> function25 = title;
                                final int i18 = i9;
                                composer3.startReplaceableGroup(693286680);
                                MeasurePolicy measurePolicyM1207h2 = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically2, composer3, 48, -1323940314);
                                Density density2 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
                                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1207h2, composerM18018constructorimpl2, density2));
                                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer3, composer3), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                composer3.startReplaceableGroup(-678309503);
                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                composer3.startReplaceableGroup(159489950);
                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer3, 6).getH6(), ComposableLambdaKt.composableLambda(composer3, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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
                                    public final void invoke(@Nullable Composer composer4, int i19) {
                                        if ((i19 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2021518195, i19, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:108)");
                                        }
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer4, 6)))}, function25, composer4, ((i18 << 3) & 112) | 8);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, 48);
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function3M16699getLambda1$material_release;
                                final int i19 = i9;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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
                                    public final void invoke(@Nullable Composer composer4, int i20) {
                                        if ((i20 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1157662914, i20, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous> (AppBar.kt:116)");
                                        }
                                        Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                        Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                        int i21 = (i19 & 7168) | 438;
                                        composer4.startReplaceableGroup(693286680);
                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically3, composer4, 54);
                                        Density density3 = (Density) AbstractC1038a.m1211l(composer4, -1323940314);
                                        LayoutDirection layoutDirection3 = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                        ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                        if (composer4.getApplier() == null) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor3);
                                        } else {
                                            composer4.useNode();
                                        }
                                        composer4.disableReusing();
                                        Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composer4);
                                        Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl3, measurePolicyRowMeasurePolicy, composerM18018constructorimpl3, density3));
                                        AbstractC1038a.m1221v(0, function3MaterializerOf3, AbstractC1038a.m1206g(companion3, composerM18018constructorimpl3, viewConfiguration3, composer4, composer4), composer4, 2058660585);
                                        composer4.startReplaceableGroup(-678309503);
                                        function34.invoke(RowScopeInstance.INSTANCE, composer4, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, (i142 & 896) | (i142 & 14) | 1600512 | (i142 & 112) | ((i9 << 12) & i8), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function23 = function22;
                        function32 = function3M16699getLambda1$material_release;
                        j5 = j3;
                        f5 = fM16585getTopAppBarElevationD9Ej5fM;
                        modifier3 = modifier42;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier2;
                        function23 = function22;
                        function32 = function3M16699getLambda1$material_release;
                        f5 = f4;
                        j5 = jM16694contentColorForek8zF_U;
                    }
                    final long j6 = primarySurface;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$2
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
                            AppBarKt.m16589TopAppBarxWeB9s(title, modifier3, function23, function32, j6, j5, f5, composer3, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= 3072;
                function3M16699getLambda1$material_release = function3;
                if ((57344 & i) != 0) {
                }
                if ((i & 458752) != 0) {
                }
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                int i132 = i4;
                if ((i4 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i2 & 16) == 0) {
                        }
                        if ((i2 & 32) != 0) {
                        }
                        if (i7 == 0) {
                            fM16585getTopAppBarElevationD9Ej5fM = f4;
                            j3 = jM16694contentColorForek8zF_U;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i1422 = i9 >> 12;
                        composer2 = composerStartRestartGroup;
                        Modifier modifier422 = modifier2;
                        m16586AppBarcelAv9A(primarySurface, j3, fM16585getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier422, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                invoke(rowScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@NotNull RowScope AppBar, @Nullable Composer composer3, int i15) {
                                int i16;
                                Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                                if ((i15 & 14) == 0) {
                                    i16 = (composer3.changed(AppBar) ? 4 : 2) | i15;
                                } else {
                                    i16 = i15;
                                }
                                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1484077694, i15, -1, "androidx.compose.material.TopAppBar.<anonymous> (AppBar.kt:92)");
                                }
                                if (function22 == null) {
                                    composer3.startReplaceableGroup(-512812651);
                                    SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer3, 6);
                                    composer3.endReplaceableGroup();
                                } else {
                                    composer3.startReplaceableGroup(-512812592);
                                    Modifier modifier5 = AppBarKt.TitleIconModifier;
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function24 = function22;
                                    int i17 = i9;
                                    composer3.startReplaceableGroup(693286680);
                                    MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composer3, 48, -1323940314);
                                    Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier5);
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
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
                                    function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    composer3.startReplaceableGroup(-678309503);
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    composer3.startReplaceableGroup(1485618042);
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function24, composer3, ((i17 >> 3) & 112) | 8);
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                }
                                Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                final Function2<? super Composer, ? super Integer, Unit> function25 = title;
                                final int i18 = i9;
                                composer3.startReplaceableGroup(693286680);
                                MeasurePolicy measurePolicyM1207h2 = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically2, composer3, 48, -1323940314);
                                Density density2 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
                                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1207h2, composerM18018constructorimpl2, density2));
                                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer3, composer3), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                composer3.startReplaceableGroup(-678309503);
                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                composer3.startReplaceableGroup(159489950);
                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer3, 6).getH6(), ComposableLambdaKt.composableLambda(composer3, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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
                                    public final void invoke(@Nullable Composer composer4, int i19) {
                                        if ((i19 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2021518195, i19, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:108)");
                                        }
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer4, 6)))}, function25, composer4, ((i18 << 3) & 112) | 8);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, 48);
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function3M16699getLambda1$material_release;
                                final int i19 = i9;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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
                                    public final void invoke(@Nullable Composer composer4, int i20) {
                                        if ((i20 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1157662914, i20, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous> (AppBar.kt:116)");
                                        }
                                        Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                        Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                        int i21 = (i19 & 7168) | 438;
                                        composer4.startReplaceableGroup(693286680);
                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically3, composer4, 54);
                                        Density density3 = (Density) AbstractC1038a.m1211l(composer4, -1323940314);
                                        LayoutDirection layoutDirection3 = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                        ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                        if (composer4.getApplier() == null) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor3);
                                        } else {
                                            composer4.useNode();
                                        }
                                        composer4.disableReusing();
                                        Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composer4);
                                        Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl3, measurePolicyRowMeasurePolicy, composerM18018constructorimpl3, density3));
                                        AbstractC1038a.m1221v(0, function3MaterializerOf3, AbstractC1038a.m1206g(companion3, composerM18018constructorimpl3, viewConfiguration3, composer4, composer4), composer4, 2058660585);
                                        composer4.startReplaceableGroup(-678309503);
                                        function34.invoke(RowScopeInstance.INSTANCE, composer4, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, (i1422 & 896) | (i1422 & 14) | 1600512 | (i1422 & 112) | ((i9 << 12) & i8), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function23 = function22;
                        function32 = function3M16699getLambda1$material_release;
                        j5 = j3;
                        f5 = fM16585getTopAppBarElevationD9Ej5fM;
                        modifier3 = modifier422;
                    }
                }
                final long j62 = primarySurface;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function22 = function2;
            i6 = i2 & 8;
            if (i6 == 0) {
            }
            function3M16699getLambda1$material_release = function3;
            if ((57344 & i) != 0) {
            }
            if ((i & 458752) != 0) {
            }
            i7 = i2 & 64;
            if (i7 == 0) {
            }
            int i1322 = i4;
            if ((i4 & 2995931) == 599186) {
            }
            final long j622 = primarySurface;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        function22 = function2;
        i6 = i2 & 8;
        if (i6 == 0) {
        }
        function3M16699getLambda1$material_release = function3;
        if ((57344 & i) != 0) {
        }
        if ((i & 458752) != 0) {
        }
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        int i13222 = i4;
        if ((i4 & 2995931) == 599186) {
        }
        final long j6222 = primarySurface;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    public static final float calculateCutoutCircleYIntercept(float f, float f4) {
        return -((float) Math.sqrt((f * f) - (f4 * f4)));
    }

    @NotNull
    public static final Pair<Float, Float> calculateRoundedEdgeIntercept(float f, float f4, float f5) {
        Float fValueOf;
        Float fValueOf2;
        Pair pairM13893to;
        Float fValueOf3;
        Float fValueOf4;
        float f6 = f4 * f4;
        float f7 = f5 * f5;
        float f8 = (f * f) + f6;
        float f9 = f * f7;
        double d = (f8 - f7) * f6 * f7;
        float fSqrt = (f9 - ((float) Math.sqrt(d))) / f8;
        float fSqrt2 = (f9 + ((float) Math.sqrt(d))) / f8;
        float fSqrt3 = (float) Math.sqrt(f7 - (fSqrt * fSqrt));
        float fSqrt4 = (float) Math.sqrt(f7 - (fSqrt2 * fSqrt2));
        if (f4 > 0.0f) {
            if (fSqrt3 > fSqrt4) {
                fValueOf3 = Float.valueOf(fSqrt);
                fValueOf4 = Float.valueOf(fSqrt3);
            } else {
                fValueOf3 = Float.valueOf(fSqrt2);
                fValueOf4 = Float.valueOf(fSqrt4);
            }
            pairM13893to = TuplesKt.m13893to(fValueOf3, fValueOf4);
        } else {
            if (fSqrt3 < fSqrt4) {
                fValueOf = Float.valueOf(fSqrt);
                fValueOf2 = Float.valueOf(fSqrt3);
            } else {
                fValueOf = Float.valueOf(fSqrt2);
                fValueOf2 = Float.valueOf(fSqrt4);
            }
            pairM13893to = TuplesKt.m13893to(fValueOf, fValueOf2);
        }
        float fFloatValue = ((Number) pairM13893to.component1()).floatValue();
        float fFloatValue2 = ((Number) pairM13893to.component2()).floatValue();
        if (fFloatValue < f) {
            fFloatValue2 = -fFloatValue2;
        }
        return TuplesKt.m13893to(Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2));
    }

    private static final float square(float f) {
        return f * f;
    }
}
