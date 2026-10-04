package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.UiComposable;
import androidx.compose.p109ui.draw.ClipKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.layout.SubcomposeLayoutKt;
import androidx.compose.p109ui.layout.SubcomposeMeasureScope;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a¬\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000123\b\u0002\u0010\u0010\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a¢\u0001\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r23\b\u0002\u0010\u0010\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, m13886d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "ScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "divider", "Lkotlin/Function0;", "tabs", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TabRow", "TabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = C2256Dp.m20968constructorimpl(90);

    @NotNull
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* JADX WARN: Removed duplicated region for block: B:106:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01f5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0116  */
    @Composable
    @UiComposable
    /* JADX INFO: renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16908ScrollableTabRowsKfQg0A(final int i, @Nullable Modifier modifier, long j, long j2, float f, @Nullable Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @NotNull final Function2<? super Composer, ? super Integer, Unit> tabs, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        long primarySurface;
        long jM16694contentColorForek8zF_U;
        int i6;
        float fM16905getScrollableTabRowPaddingD9Ej5fM;
        int i7;
        int i8;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3ComposableLambda;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function2M16708getLambda2$material_release;
        Modifier modifier3;
        long j3;
        int i10;
        int i11;
        long j5;
        Composer composer2;
        final float f4;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        final Modifier modifier4;
        final long j6;
        final long j7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i12;
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1473476840);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i13 = i4 & 2;
        if (i13 != 0) {
            i5 |= 48;
        } else {
            if ((i2 & 112) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 896) != 0) {
                if ((i4 & 4) == 0) {
                    primarySurface = j;
                    int i14 = composerStartRestartGroup.changed(primarySurface) ? 256 : 128;
                    i5 |= i14;
                } else {
                    primarySurface = j;
                }
                i5 |= i14;
            } else {
                primarySurface = j;
            }
            if ((i2 & 7168) != 0) {
                if ((i4 & 8) == 0) {
                    jM16694contentColorForek8zF_U = j2;
                    int i15 = composerStartRestartGroup.changed(jM16694contentColorForek8zF_U) ? 2048 : 1024;
                    i5 |= i15;
                } else {
                    jM16694contentColorForek8zF_U = j2;
                }
                i5 |= i15;
            } else {
                jM16694contentColorForek8zF_U = j2;
            }
            i6 = i4 & 16;
            if (i6 == 0) {
                i5 |= 24576;
            } else {
                if ((57344 & i2) == 0) {
                    fM16905getScrollableTabRowPaddingD9Ej5fM = f;
                    i5 |= composerStartRestartGroup.changed(fM16905getScrollableTabRowPaddingD9Ej5fM) ? 16384 : 8192;
                }
                i7 = i4 & 32;
                if (i7 != 0) {
                    i5 |= 196608;
                } else if ((i2 & 458752) == 0) {
                    i5 |= composerStartRestartGroup.changed(function3) ? 131072 : 65536;
                }
                i8 = i4 & 64;
                if (i8 != 0) {
                    i5 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    i5 |= composerStartRestartGroup.changed(function2) ? 1048576 : 524288;
                }
                if ((i4 & 128) == 0) {
                    i12 = (29360128 & i2) == 0 ? composerStartRestartGroup.changed(tabs) ? 8388608 : 4194304 : 12582912;
                    if ((23967451 & i5) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i4 & 4) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i5 &= -897;
                            }
                            if ((i4 & 8) != 0) {
                                jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i5 >> 6) & 14);
                                i5 &= -7169;
                            }
                            if (i6 != 0) {
                                fM16905getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m16905getScrollableTabRowPaddingD9Ej5fM();
                            }
                            function3ComposableLambda = i7 == 0 ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -655609869, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer3, Integer num) {
                                    invoke((List<TabPosition>) list, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@NotNull List<TabPosition> tabPositions, @Nullable Composer composer3, int i16) {
                                    Intrinsics.checkNotNullParameter(tabPositions, "tabPositions");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-655609869, i16, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:229)");
                                    }
                                    TabRowDefaults tabRowDefaults = TabRowDefaults.INSTANCE;
                                    tabRowDefaults.m16902Indicator9IZ8Weo(tabRowDefaults.tabIndicatorOffset(Modifier.INSTANCE, tabPositions.get(i)), 0.0f, 0L, composer3, 3072, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }) : function3;
                            if (i8 == 0) {
                                Modifier modifier5 = modifier2;
                                i9 = i5;
                                function2M16708getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m16708getLambda2$material_release();
                                modifier3 = modifier5;
                                j3 = primarySurface;
                                i10 = 1572864;
                                i11 = -1473476840;
                                j5 = jM16694contentColorForek8zF_U;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i11, i9, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)");
                            }
                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function3ComposableLambda;
                            final Function2<? super Composer, ? super Integer, Unit> function23 = function2M16708getLambda2$material_release;
                            final int i16 = i9;
                            final float f5 = fM16905getScrollableTabRowPaddingD9Ej5fM;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m16872SurfaceFjzlyU(modifier3, null, j3, j5, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2
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
                                public final void invoke(@Nullable Composer composer3, int i17) {
                                    if ((i17 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1455860572, i17, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:244)");
                                    }
                                    ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composer3, 0, 1);
                                    composer3.startReplaceableGroup(773894976);
                                    composer3.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composer3.rememberedValue();
                                    Composer.Companion companion = Composer.INSTANCE;
                                    if (objRememberedValue == companion.getEmpty()) {
                                        objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3), composer3);
                                    }
                                    composer3.endReplaceableGroup();
                                    CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                                    composer3.endReplaceableGroup();
                                    composer3.startReplaceableGroup(511388516);
                                    boolean zChanged = composer3.changed(scrollStateRememberScrollState) | composer3.changed(coroutineScope);
                                    Object objRememberedValue2 = composer3.rememberedValue();
                                    if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                                        objRememberedValue2 = new ScrollableTabData(scrollStateRememberScrollState, coroutineScope);
                                        composer3.updateRememberedValue(objRememberedValue2);
                                    }
                                    composer3.endReplaceableGroup();
                                    final ScrollableTabData scrollableTabData = (ScrollableTabData) objRememberedValue2;
                                    Modifier modifierClipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), scrollStateRememberScrollState, false, null, false, 14, null)));
                                    final float f6 = f5;
                                    final Function2<Composer, Integer, Unit> function24 = tabs;
                                    final Function2<Composer, Integer, Unit> function25 = function23;
                                    final int i18 = i;
                                    final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function33;
                                    final int i19 = i16;
                                    SubcomposeLayoutKt.SubcomposeLayout(modifierClipToBounds, new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                            return m16910invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                        }

                                        @NotNull
                                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                        public final MeasureResult m16910invoke0kLqBqw(@NotNull final SubcomposeMeasureScope SubcomposeLayout, final long j8) {
                                            Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                            int iMo15540roundToPx0680j_4 = SubcomposeLayout.mo15540roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
                                            final int iMo15540roundToPx0680j_42 = SubcomposeLayout.mo15540roundToPx0680j_4(f6);
                                            long jM20912copyZbe2FdA$default = Constraints.m20912copyZbe2FdA$default(j8, iMo15540roundToPx0680j_4, 0, 0, 0, 14, null);
                                            List<Measurable> listSubcompose = SubcomposeLayout.subcompose(TabSlots.Tabs, function24);
                                            final ArrayList<Placeable> arrayList = new ArrayList(CollectionsKt.m13952k(listSubcompose));
                                            Iterator<T> it = listSubcompose.iterator();
                                            while (it.hasNext()) {
                                                arrayList.add(((Measurable) it.next()).mo19855measureBRTryo0(jM20912copyZbe2FdA$default));
                                            }
                                            final Ref.IntRef intRef = new Ref.IntRef();
                                            intRef.element = iMo15540roundToPx0680j_42 * 2;
                                            final Ref.IntRef intRef2 = new Ref.IntRef();
                                            for (Placeable placeable : arrayList) {
                                                intRef.element = placeable.getWidth() + intRef.element;
                                                intRef2.element = Math.max(intRef2.element, placeable.getHeight());
                                            }
                                            int i20 = intRef.element;
                                            int i21 = intRef2.element;
                                            final Function2<Composer, Integer, Unit> function26 = function25;
                                            final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                            final int i22 = i18;
                                            final Function3<List<TabPosition>, Composer, Integer, Unit> function35 = function34;
                                            final int i23 = i19;
                                            return MeasureScope.layout$default(SubcomposeLayout, i20, i21, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2
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
                                                    final ArrayList arrayList2 = new ArrayList();
                                                    int i24 = iMo15540roundToPx0680j_42;
                                                    List<Placeable> list = arrayList;
                                                    SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                                    int width = i24;
                                                    for (Placeable placeable2 : list) {
                                                        Placeable.PlacementScope.placeRelative$default(layout, placeable2, width, 0, 0.0f, 4, null);
                                                        arrayList2.add(new TabPosition(subcomposeMeasureScope.mo15543toDpu2uoSUM(width), subcomposeMeasureScope.mo15543toDpu2uoSUM(placeable2.getWidth()), null));
                                                        width += placeable2.getWidth();
                                                    }
                                                    List<Measurable> listSubcompose2 = SubcomposeLayout.subcompose(TabSlots.Divider, function26);
                                                    long j9 = j8;
                                                    Ref.IntRef intRef3 = intRef;
                                                    Ref.IntRef intRef4 = intRef2;
                                                    for (Measurable measurable : listSubcompose2) {
                                                        int i25 = intRef3.element;
                                                        long j10 = j9;
                                                        Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j9, i25, i25, 0, 0, 8, null));
                                                        Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, 0, intRef4.element - placeableMo19855measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                        j9 = j10;
                                                    }
                                                    SubcomposeMeasureScope subcomposeMeasureScope2 = SubcomposeLayout;
                                                    TabSlots tabSlots = TabSlots.Indicator;
                                                    final Function3<List<TabPosition>, Composer, Integer, Unit> function36 = function35;
                                                    final int i26 = i23;
                                                    List<Measurable> listSubcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(230769237, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2.3
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

                                                        @Composable
                                                        public final void invoke(@Nullable Composer composer4, int i27) {
                                                            if ((i27 & 11) == 2 && composer4.getSkipping()) {
                                                                composer4.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(230769237, i27, -1, "androidx.compose.material.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:300)");
                                                            }
                                                            function36.invoke(arrayList2, composer4, Integer.valueOf(((i26 >> 12) & 112) | 8));
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }));
                                                    Ref.IntRef intRef5 = intRef;
                                                    Ref.IntRef intRef6 = intRef2;
                                                    Iterator<T> it2 = listSubcompose3.iterator();
                                                    while (it2.hasNext()) {
                                                        Placeable.PlacementScope.placeRelative$default(layout, ((Measurable) it2.next()).mo19855measureBRTryo0(Constraints.INSTANCE.m20931fixedJhjzzOo(intRef5.element, intRef6.element)), 0, 0, 0.0f, 4, null);
                                                    }
                                                    scrollableTabData2.onLaidOut(SubcomposeLayout, iMo15540roundToPx0680j_42, arrayList2, i22);
                                                }
                                            }, 4, null);
                                        }
                                    }, composer3, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, ((i16 >> 3) & 14) | i10 | (i16 & 896) | (i16 & 7168), 50);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f4 = f5;
                            function32 = function33;
                            function22 = function23;
                            modifier4 = modifier3;
                            j6 = j3;
                            j7 = j5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 4) != 0) {
                                i5 &= -897;
                            }
                            if ((i4 & 8) != 0) {
                                i5 &= -7169;
                            }
                            function3ComposableLambda = function3;
                        }
                        modifier3 = modifier2;
                        j3 = primarySurface;
                        i10 = 1572864;
                        i11 = -1473476840;
                        i9 = i5;
                        j5 = jM16694contentColorForek8zF_U;
                        function2M16708getLambda2$material_release = function2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function332 = function3ComposableLambda;
                        final Function2<? super Composer, ? super Integer, Unit> function232 = function2M16708getLambda2$material_release;
                        final int i162 = i9;
                        final float f52 = fM16905getScrollableTabRowPaddingD9Ej5fM;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m16872SurfaceFjzlyU(modifier3, null, j3, j5, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2
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
                            public final void invoke(@Nullable Composer composer3, int i17) {
                                if ((i17 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1455860572, i17, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:244)");
                                }
                                ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composer3, 0, 1);
                                composer3.startReplaceableGroup(773894976);
                                composer3.startReplaceableGroup(-492369756);
                                Object objRememberedValue = composer3.rememberedValue();
                                Composer.Companion companion = Composer.INSTANCE;
                                if (objRememberedValue == companion.getEmpty()) {
                                    objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3), composer3);
                                }
                                composer3.endReplaceableGroup();
                                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                                composer3.endReplaceableGroup();
                                composer3.startReplaceableGroup(511388516);
                                boolean zChanged = composer3.changed(scrollStateRememberScrollState) | composer3.changed(coroutineScope);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                                    objRememberedValue2 = new ScrollableTabData(scrollStateRememberScrollState, coroutineScope);
                                    composer3.updateRememberedValue(objRememberedValue2);
                                }
                                composer3.endReplaceableGroup();
                                final ScrollableTabData scrollableTabData = (ScrollableTabData) objRememberedValue2;
                                Modifier modifierClipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), scrollStateRememberScrollState, false, null, false, 14, null)));
                                final float f6 = f52;
                                final Function2<? super Composer, ? super Integer, Unit> function24 = tabs;
                                final Function2<? super Composer, ? super Integer, Unit> function25 = function232;
                                final int i18 = i;
                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function332;
                                final int i19 = i162;
                                SubcomposeLayoutKt.SubcomposeLayout(modifierClipToBounds, new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                        return m16910invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                    }

                                    @NotNull
                                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                    public final MeasureResult m16910invoke0kLqBqw(@NotNull final SubcomposeMeasureScope SubcomposeLayout, final long j8) {
                                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                        int iMo15540roundToPx0680j_4 = SubcomposeLayout.mo15540roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
                                        final int iMo15540roundToPx0680j_42 = SubcomposeLayout.mo15540roundToPx0680j_4(f6);
                                        long jM20912copyZbe2FdA$default = Constraints.m20912copyZbe2FdA$default(j8, iMo15540roundToPx0680j_4, 0, 0, 0, 14, null);
                                        List<Measurable> listSubcompose = SubcomposeLayout.subcompose(TabSlots.Tabs, function24);
                                        final List<? extends Placeable> arrayList = new ArrayList(CollectionsKt.m13952k(listSubcompose));
                                        Iterator<T> it = listSubcompose.iterator();
                                        while (it.hasNext()) {
                                            arrayList.add(((Measurable) it.next()).mo19855measureBRTryo0(jM20912copyZbe2FdA$default));
                                        }
                                        final Ref.IntRef intRef = new Ref.IntRef();
                                        intRef.element = iMo15540roundToPx0680j_42 * 2;
                                        final Ref.IntRef intRef2 = new Ref.IntRef();
                                        for (Placeable placeable : arrayList) {
                                            intRef.element = placeable.getWidth() + intRef.element;
                                            intRef2.element = Math.max(intRef2.element, placeable.getHeight());
                                        }
                                        int i20 = intRef.element;
                                        int i21 = intRef2.element;
                                        final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                                        final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                        final int i22 = i18;
                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                        final int i23 = i19;
                                        return MeasureScope.layout$default(SubcomposeLayout, i20, i21, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2
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
                                                final List<TabPosition> arrayList2 = new ArrayList();
                                                int i24 = iMo15540roundToPx0680j_42;
                                                List<Placeable> list = arrayList;
                                                SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                                int width = i24;
                                                for (Placeable placeable2 : list) {
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeable2, width, 0, 0.0f, 4, null);
                                                    arrayList2.add(new TabPosition(subcomposeMeasureScope.mo15543toDpu2uoSUM(width), subcomposeMeasureScope.mo15543toDpu2uoSUM(placeable2.getWidth()), null));
                                                    width += placeable2.getWidth();
                                                }
                                                List<Measurable> listSubcompose2 = SubcomposeLayout.subcompose(TabSlots.Divider, function26);
                                                long j9 = j8;
                                                Ref.IntRef intRef3 = intRef;
                                                Ref.IntRef intRef4 = intRef2;
                                                for (Measurable measurable : listSubcompose2) {
                                                    int i25 = intRef3.element;
                                                    long j10 = j9;
                                                    Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j9, i25, i25, 0, 0, 8, null));
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, 0, intRef4.element - placeableMo19855measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                    j9 = j10;
                                                }
                                                SubcomposeMeasureScope subcomposeMeasureScope2 = SubcomposeLayout;
                                                TabSlots tabSlots = TabSlots.Indicator;
                                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                                final int i26 = i23;
                                                List<Measurable> listSubcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(230769237, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2.3
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

                                                    @Composable
                                                    public final void invoke(@Nullable Composer composer4, int i27) {
                                                        if ((i27 & 11) == 2 && composer4.getSkipping()) {
                                                            composer4.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(230769237, i27, -1, "androidx.compose.material.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:300)");
                                                        }
                                                        function36.invoke(arrayList2, composer4, Integer.valueOf(((i26 >> 12) & 112) | 8));
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }));
                                                Ref.IntRef intRef5 = intRef;
                                                Ref.IntRef intRef6 = intRef2;
                                                Iterator<T> it2 = listSubcompose3.iterator();
                                                while (it2.hasNext()) {
                                                    Placeable.PlacementScope.placeRelative$default(layout, ((Measurable) it2.next()).mo19855measureBRTryo0(Constraints.INSTANCE.m20931fixedJhjzzOo(intRef5.element, intRef6.element)), 0, 0, 0.0f, 4, null);
                                                }
                                                scrollableTabData2.onLaidOut(SubcomposeLayout, iMo15540roundToPx0680j_42, arrayList2, i22);
                                            }
                                        }, 4, null);
                                    }
                                }, composer3, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, ((i162 >> 3) & 14) | i10 | (i162 & 896) | (i162 & 7168), 50);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        f4 = f52;
                        function32 = function332;
                        function22 = function232;
                        modifier4 = modifier3;
                        j6 = j3;
                        j7 = j5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier2;
                        j6 = primarySurface;
                        j7 = jM16694contentColorForek8zF_U;
                        f4 = fM16905getScrollableTabRowPaddingD9Ej5fM;
                        function32 = function3;
                        function22 = function2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$3
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

                        public final void invoke(@Nullable Composer composer3, int i17) {
                            TabRowKt.m16908ScrollableTabRowsKfQg0A(i, modifier4, j6, j7, f4, function32, function22, tabs, composer3, i2 | 1, i4);
                        }
                    });
                    return;
                }
                i5 |= i12;
                if ((23967451 & i5) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i13 != 0) {
                        }
                        if ((i4 & 4) != 0) {
                        }
                        if ((i4 & 8) != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i8 == 0) {
                            modifier3 = modifier2;
                            j3 = primarySurface;
                            i10 = 1572864;
                            i11 = -1473476840;
                            i9 = i5;
                            j5 = jM16694contentColorForek8zF_U;
                            function2M16708getLambda2$material_release = function2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3322 = function3ComposableLambda;
                        final Function2<? super Composer, ? super Integer, Unit> function2322 = function2M16708getLambda2$material_release;
                        final int i1622 = i9;
                        final float f522 = fM16905getScrollableTabRowPaddingD9Ej5fM;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m16872SurfaceFjzlyU(modifier3, null, j3, j5, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1455860572, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2
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
                            public final void invoke(@Nullable Composer composer3, int i17) {
                                if ((i17 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1455860572, i17, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:244)");
                                }
                                ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composer3, 0, 1);
                                composer3.startReplaceableGroup(773894976);
                                composer3.startReplaceableGroup(-492369756);
                                Object objRememberedValue = composer3.rememberedValue();
                                Composer.Companion companion = Composer.INSTANCE;
                                if (objRememberedValue == companion.getEmpty()) {
                                    objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3), composer3);
                                }
                                composer3.endReplaceableGroup();
                                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                                composer3.endReplaceableGroup();
                                composer3.startReplaceableGroup(511388516);
                                boolean zChanged = composer3.changed(scrollStateRememberScrollState) | composer3.changed(coroutineScope);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                                    objRememberedValue2 = new ScrollableTabData(scrollStateRememberScrollState, coroutineScope);
                                    composer3.updateRememberedValue(objRememberedValue2);
                                }
                                composer3.endReplaceableGroup();
                                final ScrollableTabData scrollableTabData = (ScrollableTabData) objRememberedValue2;
                                Modifier modifierClipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), scrollStateRememberScrollState, false, null, false, 14, null)));
                                final float f6 = f522;
                                final Function2<? super Composer, ? super Integer, Unit> function24 = tabs;
                                final Function2<? super Composer, ? super Integer, Unit> function25 = function2322;
                                final int i18 = i;
                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function3322;
                                final int i19 = i1622;
                                SubcomposeLayoutKt.SubcomposeLayout(modifierClipToBounds, new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                        return m16910invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                    }

                                    @NotNull
                                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                    public final MeasureResult m16910invoke0kLqBqw(@NotNull final SubcomposeMeasureScope SubcomposeLayout, final long j8) {
                                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                        int iMo15540roundToPx0680j_4 = SubcomposeLayout.mo15540roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
                                        final int iMo15540roundToPx0680j_42 = SubcomposeLayout.mo15540roundToPx0680j_4(f6);
                                        long jM20912copyZbe2FdA$default = Constraints.m20912copyZbe2FdA$default(j8, iMo15540roundToPx0680j_4, 0, 0, 0, 14, null);
                                        List<Measurable> listSubcompose = SubcomposeLayout.subcompose(TabSlots.Tabs, function24);
                                        final List<? extends Placeable> arrayList = new ArrayList(CollectionsKt.m13952k(listSubcompose));
                                        Iterator<T> it = listSubcompose.iterator();
                                        while (it.hasNext()) {
                                            arrayList.add(((Measurable) it.next()).mo19855measureBRTryo0(jM20912copyZbe2FdA$default));
                                        }
                                        final Ref.IntRef intRef = new Ref.IntRef();
                                        intRef.element = iMo15540roundToPx0680j_42 * 2;
                                        final Ref.IntRef intRef2 = new Ref.IntRef();
                                        for (Placeable placeable : arrayList) {
                                            intRef.element = placeable.getWidth() + intRef.element;
                                            intRef2.element = Math.max(intRef2.element, placeable.getHeight());
                                        }
                                        int i20 = intRef.element;
                                        int i21 = intRef2.element;
                                        final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                                        final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                        final int i22 = i18;
                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                        final int i23 = i19;
                                        return MeasureScope.layout$default(SubcomposeLayout, i20, i21, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2
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
                                                final List<TabPosition> arrayList2 = new ArrayList();
                                                int i24 = iMo15540roundToPx0680j_42;
                                                List<Placeable> list = arrayList;
                                                SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                                int width = i24;
                                                for (Placeable placeable2 : list) {
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeable2, width, 0, 0.0f, 4, null);
                                                    arrayList2.add(new TabPosition(subcomposeMeasureScope.mo15543toDpu2uoSUM(width), subcomposeMeasureScope.mo15543toDpu2uoSUM(placeable2.getWidth()), null));
                                                    width += placeable2.getWidth();
                                                }
                                                List<Measurable> listSubcompose2 = SubcomposeLayout.subcompose(TabSlots.Divider, function26);
                                                long j9 = j8;
                                                Ref.IntRef intRef3 = intRef;
                                                Ref.IntRef intRef4 = intRef2;
                                                for (Measurable measurable : listSubcompose2) {
                                                    int i25 = intRef3.element;
                                                    long j10 = j9;
                                                    Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j9, i25, i25, 0, 0, 8, null));
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, 0, intRef4.element - placeableMo19855measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                    j9 = j10;
                                                }
                                                SubcomposeMeasureScope subcomposeMeasureScope2 = SubcomposeLayout;
                                                TabSlots tabSlots = TabSlots.Indicator;
                                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                                final int i26 = i23;
                                                List<Measurable> listSubcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(230769237, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2.3
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

                                                    @Composable
                                                    public final void invoke(@Nullable Composer composer4, int i27) {
                                                        if ((i27 & 11) == 2 && composer4.getSkipping()) {
                                                            composer4.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(230769237, i27, -1, "androidx.compose.material.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:300)");
                                                        }
                                                        function36.invoke(arrayList2, composer4, Integer.valueOf(((i26 >> 12) & 112) | 8));
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }));
                                                Ref.IntRef intRef5 = intRef;
                                                Ref.IntRef intRef6 = intRef2;
                                                Iterator<T> it2 = listSubcompose3.iterator();
                                                while (it2.hasNext()) {
                                                    Placeable.PlacementScope.placeRelative$default(layout, ((Measurable) it2.next()).mo19855measureBRTryo0(Constraints.INSTANCE.m20931fixedJhjzzOo(intRef5.element, intRef6.element)), 0, 0, 0.0f, 4, null);
                                                }
                                                scrollableTabData2.onLaidOut(SubcomposeLayout, iMo15540roundToPx0680j_42, arrayList2, i22);
                                            }
                                        }, 4, null);
                                    }
                                }, composer3, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, ((i1622 >> 3) & 14) | i10 | (i1622 & 896) | (i1622 & 7168), 50);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        f4 = f522;
                        function32 = function3322;
                        function22 = function2322;
                        modifier4 = modifier3;
                        j6 = j3;
                        j7 = j5;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            fM16905getScrollableTabRowPaddingD9Ej5fM = f;
            i7 = i4 & 32;
            if (i7 != 0) {
            }
            i8 = i4 & 64;
            if (i8 != 0) {
            }
            if ((i4 & 128) == 0) {
            }
            i5 |= i12;
            if ((23967451 & i5) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 896) != 0) {
        }
        if ((i2 & 7168) != 0) {
        }
        i6 = i4 & 16;
        if (i6 == 0) {
        }
        fM16905getScrollableTabRowPaddingD9Ej5fM = f;
        i7 = i4 & 32;
        if (i7 != 0) {
        }
        i8 = i4 & 64;
        if (i8 != 0) {
        }
        if ((i4 & 128) == 0) {
        }
        i5 |= i12;
        if ((23967451 & i5) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0117  */
    @Composable
    @UiComposable
    /* JADX INFO: renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16909TabRowpAZo6Ak(final int i, @Nullable Modifier modifier, long j, long j2, @Nullable Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @NotNull final Function2<? super Composer, ? super Integer, Unit> tabs, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        long primarySurface;
        long jM16694contentColorForek8zF_U;
        int i6;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3ComposableLambda;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function22;
        final Function2<? super Composer, ? super Integer, Unit> function2M16707getLambda1$material_release;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        long j3;
        final int i8;
        Composer composer2;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Modifier modifier3;
        final long j5;
        final long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        Composer composerStartRestartGroup = composer.startRestartGroup(-249175289);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i9 = i4 & 2;
        if (i9 != 0) {
            i5 |= 48;
        } else {
            if ((i2 & 112) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 896) != 0) {
                if ((i4 & 4) == 0) {
                    primarySurface = j;
                    int i10 = composerStartRestartGroup.changed(primarySurface) ? 256 : 128;
                    i5 |= i10;
                } else {
                    primarySurface = j;
                }
                i5 |= i10;
            } else {
                primarySurface = j;
            }
            if ((i2 & 7168) != 0) {
                jM16694contentColorForek8zF_U = j2;
                i5 |= ((i4 & 8) == 0 && composerStartRestartGroup.changed(jM16694contentColorForek8zF_U)) ? 2048 : 1024;
            } else {
                jM16694contentColorForek8zF_U = j2;
            }
            i6 = i4 & 16;
            if (i6 == 0) {
                i5 |= 24576;
            } else {
                if ((57344 & i2) == 0) {
                    function3ComposableLambda = function3;
                    i5 |= composerStartRestartGroup.changed(function3ComposableLambda) ? 16384 : 8192;
                }
                i7 = i4 & 32;
                if (i7 == 0) {
                    if ((458752 & i2) == 0) {
                        function22 = function2;
                        i5 |= composerStartRestartGroup.changed(function22) ? 131072 : 65536;
                    }
                    if ((i4 & 64) == 0) {
                        i5 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        i5 |= composerStartRestartGroup.changed(tabs) ? 1048576 : 524288;
                    }
                    if ((i5 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i4 & 4) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i5 &= -897;
                            }
                            if ((i4 & 8) != 0) {
                                jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i5 >> 6) & 14);
                                i5 &= -7169;
                            }
                            if (i6 != 0) {
                                function3ComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -553782708, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer3, Integer num) {
                                        invoke((List<TabPosition>) list, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@NotNull List<TabPosition> tabPositions, @Nullable Composer composer3, int i11) {
                                        Intrinsics.checkNotNullParameter(tabPositions, "tabPositions");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-553782708, i11, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:134)");
                                        }
                                        TabRowDefaults tabRowDefaults = TabRowDefaults.INSTANCE;
                                        tabRowDefaults.m16902Indicator9IZ8Weo(tabRowDefaults.tabIndicatorOffset(Modifier.INSTANCE, tabPositions.get(i)), 0.0f, 0L, composer3, 3072, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                            }
                            if (i7 == 0) {
                                int i11 = i5;
                                function2M16707getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m16707getLambda1$material_release();
                                function32 = function3ComposableLambda;
                                j3 = primarySurface;
                                i8 = i11;
                            }
                            long j7 = jM16694contentColorForek8zF_U;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-249175289, i8, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
                            }
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m16872SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, j3, j7, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2
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
                                        ComposerKt.traceEventStart(-1961746365, i12, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:149)");
                                    }
                                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    final Function2<Composer, Integer, Unit> function24 = tabs;
                                    final Function2<Composer, Integer, Unit> function25 = function2M16707getLambda1$material_release;
                                    final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function32;
                                    final int i13 = i8;
                                    composer3.startReplaceableGroup(1618982084);
                                    boolean zChanged = composer3.changed(function24) | composer3.changed(function25) | composer3.changed(function34);
                                    Object objRememberedValue = composer3.rememberedValue();
                                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                                return m16911invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                            }

                                            @NotNull
                                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                            public final MeasureResult m16911invoke0kLqBqw(@NotNull final SubcomposeMeasureScope SubcomposeLayout, final long j8) {
                                                Object next;
                                                Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                                final int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j8);
                                                List<Measurable> listSubcompose = SubcomposeLayout.subcompose(TabSlots.Tabs, function24);
                                                int size = listSubcompose.size();
                                                final int i14 = iM20921getMaxWidthimpl / size;
                                                List<Measurable> list = listSubcompose;
                                                final ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
                                                Iterator<T> it = list.iterator();
                                                while (it.hasNext()) {
                                                    arrayList.add(((Measurable) it.next()).mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j8, i14, i14, 0, 0, 12, null)));
                                                }
                                                Iterator it2 = arrayList.iterator();
                                                if (it2.hasNext()) {
                                                    next = it2.next();
                                                    if (it2.hasNext()) {
                                                        int height = ((Placeable) next).getHeight();
                                                        do {
                                                            Object next2 = it2.next();
                                                            int height2 = ((Placeable) next2).getHeight();
                                                            if (height < height2) {
                                                                next = next2;
                                                                height = height2;
                                                            }
                                                        } while (it2.hasNext());
                                                    }
                                                } else {
                                                    next = null;
                                                }
                                                Placeable placeable = (Placeable) next;
                                                final int height3 = placeable != null ? placeable.getHeight() : 0;
                                                final ArrayList arrayList2 = new ArrayList(size);
                                                for (int i15 = 0; i15 < size; i15++) {
                                                    arrayList2.add(new TabPosition(C2256Dp.m20968constructorimpl(SubcomposeLayout.mo15543toDpu2uoSUM(i14) * i15), SubcomposeLayout.mo15543toDpu2uoSUM(i14), null));
                                                }
                                                final Function2<Composer, Integer, Unit> function26 = function25;
                                                final Function3<List<TabPosition>, Composer, Integer, Unit> function35 = function34;
                                                final int i16 = i13;
                                                return MeasureScope.layout$default(SubcomposeLayout, iM20921getMaxWidthimpl, height3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1.1
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
                                                        Placeable.PlacementScope placementScope = layout;
                                                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                                        List<Placeable> list2 = arrayList;
                                                        int i17 = i14;
                                                        int i18 = 0;
                                                        for (Object obj : list2) {
                                                            int i19 = i18 + 1;
                                                            if (i18 < 0) {
                                                                CollectionsKt.throwIndexOverflow();
                                                            }
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) obj, i18 * i17, 0, 0.0f, 4, null);
                                                            placementScope = layout;
                                                            i18 = i19;
                                                        }
                                                        List<Measurable> listSubcompose2 = SubcomposeLayout.subcompose(TabSlots.Divider, function26);
                                                        long j9 = j8;
                                                        int i20 = height3;
                                                        Iterator<T> it3 = listSubcompose2.iterator();
                                                        while (it3.hasNext()) {
                                                            Placeable placeableMo19855measureBRTryo0 = ((Measurable) it3.next()).mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j9, 0, 0, 0, 0, 11, null));
                                                            Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, 0, i20 - placeableMo19855measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                            j9 = j9;
                                                        }
                                                        SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                                        TabSlots tabSlots = TabSlots.Indicator;
                                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function36 = function35;
                                                        final List<TabPosition> list3 = arrayList2;
                                                        final int i21 = i16;
                                                        List<Measurable> listSubcompose3 = subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-1341594997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.TabRow.2.1.1.1.3
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

                                                            @Composable
                                                            public final void invoke(@Nullable Composer composer4, int i22) {
                                                                if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                                                    composer4.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-1341594997, i22, -1, "androidx.compose.material.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:175)");
                                                                }
                                                                function36.invoke(list3, composer4, Integer.valueOf(((i21 >> 9) & 112) | 8));
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }));
                                                        int i22 = iM20921getMaxWidthimpl;
                                                        int i23 = height3;
                                                        Iterator<T> it4 = listSubcompose3.iterator();
                                                        while (it4.hasNext()) {
                                                            Placeable.PlacementScope.placeRelative$default(layout, ((Measurable) it4.next()).mo19855measureBRTryo0(Constraints.INSTANCE.m20931fixedJhjzzOo(i22, i23)), 0, 0, 0.0f, 4, null);
                                                        }
                                                    }
                                                }, 4, null);
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue);
                                    }
                                    composer3.endReplaceableGroup();
                                    SubcomposeLayoutKt.SubcomposeLayout(modifierFillMaxWidth$default, (Function2) objRememberedValue, composer3, 6, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, (i8 & 896) | 1572864 | (i8 & 7168), 50);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function33 = function32;
                            function23 = function2M16707getLambda1$material_release;
                            modifier3 = modifier2;
                            j5 = j3;
                            j6 = j7;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 4) != 0) {
                                i5 &= -897;
                            }
                            if ((i4 & 8) != 0) {
                                i5 &= -7169;
                            }
                        }
                        function32 = function3ComposableLambda;
                        j3 = primarySurface;
                        i8 = i5;
                        function2M16707getLambda1$material_release = function22;
                        long j72 = jM16694contentColorForek8zF_U;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m16872SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, j3, j72, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2
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
                                    ComposerKt.traceEventStart(-1961746365, i12, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:149)");
                                }
                                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                final Function2<? super Composer, ? super Integer, Unit> function24 = tabs;
                                final Function2<? super Composer, ? super Integer, Unit> function25 = function2M16707getLambda1$material_release;
                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function32;
                                final int i13 = i8;
                                composer3.startReplaceableGroup(1618982084);
                                boolean zChanged = composer3.changed(function24) | composer3.changed(function25) | composer3.changed(function34);
                                Object objRememberedValue = composer3.rememberedValue();
                                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                            return m16911invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                        }

                                        @NotNull
                                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                        public final MeasureResult m16911invoke0kLqBqw(@NotNull final SubcomposeMeasureScope SubcomposeLayout, final long j8) {
                                            Object next;
                                            Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                            final int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j8);
                                            List<Measurable> listSubcompose = SubcomposeLayout.subcompose(TabSlots.Tabs, function24);
                                            int size = listSubcompose.size();
                                            final int i14 = iM20921getMaxWidthimpl / size;
                                            List<Measurable> list = listSubcompose;
                                            final List<? extends Placeable> arrayList = new ArrayList(CollectionsKt.m13952k(list));
                                            Iterator<T> it = list.iterator();
                                            while (it.hasNext()) {
                                                arrayList.add(((Measurable) it.next()).mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j8, i14, i14, 0, 0, 12, null)));
                                            }
                                            Iterator it2 = arrayList.iterator();
                                            if (it2.hasNext()) {
                                                next = it2.next();
                                                if (it2.hasNext()) {
                                                    int height = ((Placeable) next).getHeight();
                                                    do {
                                                        Object next2 = it2.next();
                                                        int height2 = ((Placeable) next2).getHeight();
                                                        if (height < height2) {
                                                            next = next2;
                                                            height = height2;
                                                        }
                                                    } while (it2.hasNext());
                                                }
                                            } else {
                                                next = null;
                                            }
                                            Placeable placeable = (Placeable) next;
                                            final int height3 = placeable != null ? placeable.getHeight() : 0;
                                            final List<TabPosition> arrayList2 = new ArrayList(size);
                                            for (int i15 = 0; i15 < size; i15++) {
                                                arrayList2.add(new TabPosition(C2256Dp.m20968constructorimpl(SubcomposeLayout.mo15543toDpu2uoSUM(i14) * i15), SubcomposeLayout.mo15543toDpu2uoSUM(i14), null));
                                            }
                                            final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                            final int i16 = i13;
                                            return MeasureScope.layout$default(SubcomposeLayout, iM20921getMaxWidthimpl, height3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1.1
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
                                                    Placeable.PlacementScope placementScope = layout;
                                                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                                    List<Placeable> list2 = arrayList;
                                                    int i17 = i14;
                                                    int i18 = 0;
                                                    for (Object obj : list2) {
                                                        int i19 = i18 + 1;
                                                        if (i18 < 0) {
                                                            CollectionsKt.throwIndexOverflow();
                                                        }
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) obj, i18 * i17, 0, 0.0f, 4, null);
                                                        placementScope = layout;
                                                        i18 = i19;
                                                    }
                                                    List<Measurable> listSubcompose2 = SubcomposeLayout.subcompose(TabSlots.Divider, function26);
                                                    long j9 = j8;
                                                    int i20 = height3;
                                                    Iterator<T> it3 = listSubcompose2.iterator();
                                                    while (it3.hasNext()) {
                                                        Placeable placeableMo19855measureBRTryo0 = ((Measurable) it3.next()).mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j9, 0, 0, 0, 0, 11, null));
                                                        Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, 0, i20 - placeableMo19855measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                        j9 = j9;
                                                    }
                                                    SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                                    TabSlots tabSlots = TabSlots.Indicator;
                                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                                    final List<TabPosition> list3 = arrayList2;
                                                    final int i21 = i16;
                                                    List<Measurable> listSubcompose3 = subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-1341594997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.TabRow.2.1.1.1.3
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

                                                        @Composable
                                                        public final void invoke(@Nullable Composer composer4, int i22) {
                                                            if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                                                composer4.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1341594997, i22, -1, "androidx.compose.material.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:175)");
                                                            }
                                                            function36.invoke(list3, composer4, Integer.valueOf(((i21 >> 9) & 112) | 8));
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }));
                                                    int i22 = iM20921getMaxWidthimpl;
                                                    int i23 = height3;
                                                    Iterator<T> it4 = listSubcompose3.iterator();
                                                    while (it4.hasNext()) {
                                                        Placeable.PlacementScope.placeRelative$default(layout, ((Measurable) it4.next()).mo19855measureBRTryo0(Constraints.INSTANCE.m20931fixedJhjzzOo(i22, i23)), 0, 0, 0.0f, 4, null);
                                                    }
                                                }
                                            }, 4, null);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue);
                                }
                                composer3.endReplaceableGroup();
                                SubcomposeLayoutKt.SubcomposeLayout(modifierFillMaxWidth$default, (Function2) objRememberedValue, composer3, 6, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, (i8 & 896) | 1572864 | (i8 & 7168), 50);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function33 = function32;
                        function23 = function2M16707getLambda1$material_release;
                        modifier3 = modifier2;
                        j5 = j3;
                        j6 = j72;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier2;
                        j5 = primarySurface;
                        j6 = jM16694contentColorForek8zF_U;
                        function33 = function3ComposableLambda;
                        function23 = function22;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$3
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
                            TabRowKt.m16909TabRowpAZo6Ak(i, modifier3, j5, j6, function33, function23, tabs, composer3, i2 | 1, i4);
                        }
                    });
                    return;
                }
                i5 |= 196608;
                function22 = function2;
                if ((i4 & 64) == 0) {
                }
                if ((i5 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i9 != 0) {
                        }
                        if ((i4 & 4) != 0) {
                        }
                        if ((i4 & 8) != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 == 0) {
                            function32 = function3ComposableLambda;
                            j3 = primarySurface;
                            i8 = i5;
                            function2M16707getLambda1$material_release = function22;
                        }
                        long j722 = jM16694contentColorForek8zF_U;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m16872SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, j3, j722, null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1961746365, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2
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
                                    ComposerKt.traceEventStart(-1961746365, i12, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:149)");
                                }
                                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                final Function2<? super Composer, ? super Integer, Unit> function24 = tabs;
                                final Function2<? super Composer, ? super Integer, Unit> function25 = function2M16707getLambda1$material_release;
                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function32;
                                final int i13 = i8;
                                composer3.startReplaceableGroup(1618982084);
                                boolean zChanged = composer3.changed(function24) | composer3.changed(function25) | composer3.changed(function34);
                                Object objRememberedValue = composer3.rememberedValue();
                                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                            return m16911invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                        }

                                        @NotNull
                                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                        public final MeasureResult m16911invoke0kLqBqw(@NotNull final SubcomposeMeasureScope SubcomposeLayout, final long j8) {
                                            Object next;
                                            Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                            final int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j8);
                                            List<Measurable> listSubcompose = SubcomposeLayout.subcompose(TabSlots.Tabs, function24);
                                            int size = listSubcompose.size();
                                            final int i14 = iM20921getMaxWidthimpl / size;
                                            List<Measurable> list = listSubcompose;
                                            final List<? extends Placeable> arrayList = new ArrayList(CollectionsKt.m13952k(list));
                                            Iterator<T> it = list.iterator();
                                            while (it.hasNext()) {
                                                arrayList.add(((Measurable) it.next()).mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j8, i14, i14, 0, 0, 12, null)));
                                            }
                                            Iterator it2 = arrayList.iterator();
                                            if (it2.hasNext()) {
                                                next = it2.next();
                                                if (it2.hasNext()) {
                                                    int height = ((Placeable) next).getHeight();
                                                    do {
                                                        Object next2 = it2.next();
                                                        int height2 = ((Placeable) next2).getHeight();
                                                        if (height < height2) {
                                                            next = next2;
                                                            height = height2;
                                                        }
                                                    } while (it2.hasNext());
                                                }
                                            } else {
                                                next = null;
                                            }
                                            Placeable placeable = (Placeable) next;
                                            final int height3 = placeable != null ? placeable.getHeight() : 0;
                                            final List<TabPosition> arrayList2 = new ArrayList(size);
                                            for (int i15 = 0; i15 < size; i15++) {
                                                arrayList2.add(new TabPosition(C2256Dp.m20968constructorimpl(SubcomposeLayout.mo15543toDpu2uoSUM(i14) * i15), SubcomposeLayout.mo15543toDpu2uoSUM(i14), null));
                                            }
                                            final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                            final int i16 = i13;
                                            return MeasureScope.layout$default(SubcomposeLayout, iM20921getMaxWidthimpl, height3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1.1
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
                                                    Placeable.PlacementScope placementScope = layout;
                                                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                                    List<Placeable> list2 = arrayList;
                                                    int i17 = i14;
                                                    int i18 = 0;
                                                    for (Object obj : list2) {
                                                        int i19 = i18 + 1;
                                                        if (i18 < 0) {
                                                            CollectionsKt.throwIndexOverflow();
                                                        }
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) obj, i18 * i17, 0, 0.0f, 4, null);
                                                        placementScope = layout;
                                                        i18 = i19;
                                                    }
                                                    List<Measurable> listSubcompose2 = SubcomposeLayout.subcompose(TabSlots.Divider, function26);
                                                    long j9 = j8;
                                                    int i20 = height3;
                                                    Iterator<T> it3 = listSubcompose2.iterator();
                                                    while (it3.hasNext()) {
                                                        Placeable placeableMo19855measureBRTryo0 = ((Measurable) it3.next()).mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j9, 0, 0, 0, 0, 11, null));
                                                        Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, 0, i20 - placeableMo19855measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                        j9 = j9;
                                                    }
                                                    SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                                    TabSlots tabSlots = TabSlots.Indicator;
                                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                                    final List<TabPosition> list3 = arrayList2;
                                                    final int i21 = i16;
                                                    List<Measurable> listSubcompose3 = subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-1341594997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.TabRow.2.1.1.1.3
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

                                                        @Composable
                                                        public final void invoke(@Nullable Composer composer4, int i22) {
                                                            if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                                                composer4.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1341594997, i22, -1, "androidx.compose.material.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:175)");
                                                            }
                                                            function36.invoke(list3, composer4, Integer.valueOf(((i21 >> 9) & 112) | 8));
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }));
                                                    int i22 = iM20921getMaxWidthimpl;
                                                    int i23 = height3;
                                                    Iterator<T> it4 = listSubcompose3.iterator();
                                                    while (it4.hasNext()) {
                                                        Placeable.PlacementScope.placeRelative$default(layout, ((Measurable) it4.next()).mo19855measureBRTryo0(Constraints.INSTANCE.m20931fixedJhjzzOo(i22, i23)), 0, 0, 0.0f, 4, null);
                                                    }
                                                }
                                            }, 4, null);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue);
                                }
                                composer3.endReplaceableGroup();
                                SubcomposeLayoutKt.SubcomposeLayout(modifierFillMaxWidth$default, (Function2) objRememberedValue, composer3, 6, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, (i8 & 896) | 1572864 | (i8 & 7168), 50);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function33 = function32;
                        function23 = function2M16707getLambda1$material_release;
                        modifier3 = modifier2;
                        j5 = j3;
                        j6 = j722;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function3ComposableLambda = function3;
            i7 = i4 & 32;
            if (i7 == 0) {
            }
            function22 = function2;
            if ((i4 & 64) == 0) {
            }
            if ((i5 & 2995931) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 896) != 0) {
        }
        if ((i2 & 7168) != 0) {
        }
        i6 = i4 & 16;
        if (i6 == 0) {
        }
        function3ComposableLambda = function3;
        i7 = i4 & 32;
        if (i7 == 0) {
        }
        function22 = function2;
        if ((i4 & 64) == 0) {
        }
        if ((i5 & 2995931) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
