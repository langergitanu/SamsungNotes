package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
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
import androidx.compose.runtime.ComposableInferredTarget;
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
import kotlinx.coroutines.CoroutineScope;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u009d\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00012.\b\u0002\u0010\u0011\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u00182\u0013\b\u0002\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u00182\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0093\u0001\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2.\b\u0002\u0010\u0011\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u00182\u0013\b\u0002\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u00182\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, m13886d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "ScrollableTabRowPadding", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "ScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "divider", "Lkotlin/Function0;", "tabs", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TabRow", "TabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = C2256Dp.m20968constructorimpl(90);
    private static final float ScrollableTabRowPadding = C2256Dp.m20968constructorimpl(52);

    @NotNull
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* JADX WARN: Removed duplicated region for block: B:107:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01df A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0117  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_]]")
    /* JADX INFO: renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17357ScrollableTabRowsKfQg0A(final int i, @Nullable Modifier modifier, long j, long j2, float f, @Nullable Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @NotNull final Function2<? super Composer, ? super Integer, Unit> tabs, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        long containerColor;
        long contentColor;
        int i6;
        float f4;
        int i7;
        int i8;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3ComposableLambda;
        Function2<? super Composer, ? super Integer, Unit> function2M17123getLambda2$material3_release;
        Composer composer2;
        final float f5;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        final Modifier modifier3;
        final long j3;
        final long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        Composer composerStartRestartGroup = composer.startRestartGroup(-497821003);
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
                    containerColor = j;
                    int i10 = composerStartRestartGroup.changed(containerColor) ? 256 : 128;
                    i5 |= i10;
                } else {
                    containerColor = j;
                }
                i5 |= i10;
            } else {
                containerColor = j;
            }
            if ((i2 & 7168) != 0) {
                if ((i4 & 8) == 0) {
                    contentColor = j2;
                    int i11 = composerStartRestartGroup.changed(contentColor) ? 2048 : 1024;
                    i5 |= i11;
                } else {
                    contentColor = j2;
                }
                i5 |= i11;
            } else {
                contentColor = j2;
            }
            i6 = i4 & 16;
            if (i6 != 0) {
                if ((57344 & i2) == 0) {
                    f4 = f;
                    i5 |= composerStartRestartGroup.changed(f4) ? 16384 : 8192;
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
                if ((i4 & 128) != 0) {
                    i5 |= 12582912;
                } else if ((29360128 & i2) == 0) {
                    i5 |= composerStartRestartGroup.changed(tabs) ? 8388608 : 4194304;
                }
                if ((23967451 & i5) == 4793490 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier2;
                    j3 = containerColor;
                    j5 = contentColor;
                    f5 = f4;
                    function32 = function3;
                    function22 = function2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i4 & 4) != 0) {
                            containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i5 &= -897;
                        }
                        if ((i4 & 8) != 0) {
                            contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i5 &= -7169;
                        }
                        if (i6 != 0) {
                            f4 = ScrollableTabRowPadding;
                        }
                        function3ComposableLambda = i7 == 0 ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -913748678, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$1
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
                            public final void invoke(@NotNull List<TabPosition> tabPositions, @Nullable Composer composer3, int i12) {
                                Intrinsics.checkNotNullParameter(tabPositions, "tabPositions");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-913748678, i12, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:227)");
                                }
                                TabRowDefaults tabRowDefaults = TabRowDefaults.INSTANCE;
                                tabRowDefaults.m17354Indicator9IZ8Weo(tabRowDefaults.tabIndicatorOffset(Modifier.INSTANCE, tabPositions.get(i)), 0.0f, 0L, composer3, 3072, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }) : function3;
                        if (i8 == 0) {
                            function2M17123getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m17123getLambda2$material3_release();
                        }
                        Modifier modifier4 = modifier2;
                        long j6 = containerColor;
                        long j7 = contentColor;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-497821003, i5, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:221)");
                        }
                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function3ComposableLambda;
                        final int i12 = i5;
                        final Function2<? super Composer, ? super Integer, Unit> function23 = function2M17123getLambda2$material3_release;
                        final float f6 = f4;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m17325SurfaceT9BRK9s(modifier4, null, j6, j7, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 286469328, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$2
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
                            public final void invoke(@Nullable Composer composer3, int i13) {
                                if ((i13 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(286469328, i13, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:241)");
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
                                final float f7 = f6;
                                final Function2<Composer, Integer, Unit> function24 = tabs;
                                final Function2<Composer, Integer, Unit> function25 = function23;
                                final int i14 = i;
                                final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function33;
                                final int i15 = i12;
                                SubcomposeLayoutKt.SubcomposeLayout(modifierClipToBounds, new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                        return m17359invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                    }

                                    @NotNull
                                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                    public final MeasureResult m17359invoke0kLqBqw(@NotNull final SubcomposeMeasureScope SubcomposeLayout, final long j8) {
                                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                        int iMo15540roundToPx0680j_4 = SubcomposeLayout.mo15540roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
                                        final int iMo15540roundToPx0680j_42 = SubcomposeLayout.mo15540roundToPx0680j_4(f7);
                                        List<Measurable> listSubcompose = SubcomposeLayout.subcompose(TabSlots.Tabs, function24);
                                        Iterator<T> it = listSubcompose.iterator();
                                        int iMax = 0;
                                        while (it.hasNext()) {
                                            iMax = Math.max(iMax, ((Measurable) it.next()).maxIntrinsicHeight(Integer.MAX_VALUE));
                                        }
                                        long jM20912copyZbe2FdA$default = Constraints.m20912copyZbe2FdA$default(j8, iMo15540roundToPx0680j_4, 0, iMax, 0, 10, null);
                                        final int i16 = iMax;
                                        final ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(listSubcompose));
                                        Iterator<T> it2 = listSubcompose.iterator();
                                        while (it2.hasNext()) {
                                            arrayList.add(((Measurable) it2.next()).mo19855measureBRTryo0(jM20912copyZbe2FdA$default));
                                        }
                                        Iterator it3 = arrayList.iterator();
                                        final int width = iMo15540roundToPx0680j_42 * 2;
                                        while (it3.hasNext()) {
                                            width += ((Placeable) it3.next()).getWidth();
                                        }
                                        final Function2<Composer, Integer, Unit> function26 = function25;
                                        final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                        final int i17 = i14;
                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function35 = function34;
                                        final int i18 = i15;
                                        return MeasureScope.layout$default(SubcomposeLayout, width, i16, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRow.2.1.1
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
                                                int i19 = iMo15540roundToPx0680j_42;
                                                List<Placeable> list = arrayList;
                                                SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                                int width2 = i19;
                                                for (Placeable placeable : list) {
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeable, width2, 0, 0.0f, 4, null);
                                                    arrayList2.add(new TabPosition(subcomposeMeasureScope.mo15543toDpu2uoSUM(width2), subcomposeMeasureScope.mo15543toDpu2uoSUM(placeable.getWidth()), null));
                                                    width2 += placeable.getWidth();
                                                }
                                                List<Measurable> listSubcompose2 = SubcomposeLayout.subcompose(TabSlots.Divider, function26);
                                                long j9 = j8;
                                                int i20 = width;
                                                int i21 = i16;
                                                Iterator<T> it4 = listSubcompose2.iterator();
                                                while (it4.hasNext()) {
                                                    long j10 = j9;
                                                    Placeable placeableMo19855measureBRTryo0 = ((Measurable) it4.next()).mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j9, i20, i20, 0, 0, 8, null));
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, 0, i21 - placeableMo19855measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                    j9 = j10;
                                                    i20 = i20;
                                                }
                                                SubcomposeMeasureScope subcomposeMeasureScope2 = SubcomposeLayout;
                                                TabSlots tabSlots = TabSlots.Indicator;
                                                final Function3<List<TabPosition>, Composer, Integer, Unit> function36 = function35;
                                                final int i22 = i18;
                                                List<Measurable> listSubcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(963343607, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRow.2.1.1.3
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
                                                    public final void invoke(@Nullable Composer composer4, int i23) {
                                                        if ((i23 & 11) == 2 && composer4.getSkipping()) {
                                                            composer4.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(963343607, i23, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:301)");
                                                        }
                                                        function36.invoke(arrayList2, composer4, Integer.valueOf(((i22 >> 12) & 112) | 8));
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }));
                                                int i23 = width;
                                                int i24 = i16;
                                                Iterator<T> it5 = listSubcompose3.iterator();
                                                while (it5.hasNext()) {
                                                    Placeable.PlacementScope.placeRelative$default(layout, ((Measurable) it5.next()).mo19855measureBRTryo0(Constraints.INSTANCE.m20931fixedJhjzzOo(i23, i24)), 0, 0, 0.0f, 4, null);
                                                }
                                                scrollableTabData2.onLaidOut(SubcomposeLayout, iMo15540roundToPx0680j_42, arrayList2, i17);
                                            }
                                        }, 4, null);
                                    }
                                }, composer3, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 12582912 | ((i5 >> 3) & 14) | (i5 & 896) | (i5 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f5 = f6;
                        function32 = function33;
                        function22 = function2M17123getLambda2$material3_release;
                        modifier3 = modifier4;
                        j3 = j6;
                        j5 = j7;
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
                    function2M17123getLambda2$material3_release = function2;
                    Modifier modifier42 = modifier2;
                    long j62 = containerColor;
                    long j72 = contentColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function332 = function3ComposableLambda;
                    final int i122 = i5;
                    final Function2<? super Composer, ? super Integer, Unit> function232 = function2M17123getLambda2$material3_release;
                    final float f62 = f4;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m17325SurfaceT9BRK9s(modifier42, null, j62, j72, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 286469328, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$2
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
                        public final void invoke(@Nullable Composer composer3, int i13) {
                            if ((i13 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(286469328, i13, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:241)");
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
                            final float f7 = f62;
                            final Function2<? super Composer, ? super Integer, Unit> function24 = tabs;
                            final Function2<? super Composer, ? super Integer, Unit> function25 = function232;
                            final int i14 = i;
                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function332;
                            final int i15 = i122;
                            SubcomposeLayoutKt.SubcomposeLayout(modifierClipToBounds, new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                    return m17359invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                }

                                @NotNull
                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m17359invoke0kLqBqw(@NotNull final SubcomposeMeasureScope SubcomposeLayout, final long j8) {
                                    Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                    int iMo15540roundToPx0680j_4 = SubcomposeLayout.mo15540roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
                                    final int iMo15540roundToPx0680j_42 = SubcomposeLayout.mo15540roundToPx0680j_4(f7);
                                    List<Measurable> listSubcompose = SubcomposeLayout.subcompose(TabSlots.Tabs, function24);
                                    Iterator<T> it = listSubcompose.iterator();
                                    int iMax = 0;
                                    while (it.hasNext()) {
                                        iMax = Math.max(iMax, ((Measurable) it.next()).maxIntrinsicHeight(Integer.MAX_VALUE));
                                    }
                                    long jM20912copyZbe2FdA$default = Constraints.m20912copyZbe2FdA$default(j8, iMo15540roundToPx0680j_4, 0, iMax, 0, 10, null);
                                    final int i16 = iMax;
                                    final List<? extends Placeable> arrayList = new ArrayList(CollectionsKt.m13952k(listSubcompose));
                                    Iterator<T> it2 = listSubcompose.iterator();
                                    while (it2.hasNext()) {
                                        arrayList.add(((Measurable) it2.next()).mo19855measureBRTryo0(jM20912copyZbe2FdA$default));
                                    }
                                    Iterator it3 = arrayList.iterator();
                                    final int width = iMo15540roundToPx0680j_42 * 2;
                                    while (it3.hasNext()) {
                                        width += ((Placeable) it3.next()).getWidth();
                                    }
                                    final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                                    final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                    final int i17 = i14;
                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                    final int i18 = i15;
                                    return MeasureScope.layout$default(SubcomposeLayout, width, i16, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRow.2.1.1
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
                                            int i19 = iMo15540roundToPx0680j_42;
                                            List<Placeable> list = arrayList;
                                            SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                            int width2 = i19;
                                            for (Placeable placeable : list) {
                                                Placeable.PlacementScope.placeRelative$default(layout, placeable, width2, 0, 0.0f, 4, null);
                                                arrayList2.add(new TabPosition(subcomposeMeasureScope.mo15543toDpu2uoSUM(width2), subcomposeMeasureScope.mo15543toDpu2uoSUM(placeable.getWidth()), null));
                                                width2 += placeable.getWidth();
                                            }
                                            List<Measurable> listSubcompose2 = SubcomposeLayout.subcompose(TabSlots.Divider, function26);
                                            long j9 = j8;
                                            int i20 = width;
                                            int i21 = i16;
                                            Iterator<T> it4 = listSubcompose2.iterator();
                                            while (it4.hasNext()) {
                                                long j10 = j9;
                                                Placeable placeableMo19855measureBRTryo0 = ((Measurable) it4.next()).mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j9, i20, i20, 0, 0, 8, null));
                                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, 0, i21 - placeableMo19855measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                j9 = j10;
                                                i20 = i20;
                                            }
                                            SubcomposeMeasureScope subcomposeMeasureScope2 = SubcomposeLayout;
                                            TabSlots tabSlots = TabSlots.Indicator;
                                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                            final int i22 = i18;
                                            List<Measurable> listSubcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(963343607, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRow.2.1.1.3
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
                                                public final void invoke(@Nullable Composer composer4, int i23) {
                                                    if ((i23 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(963343607, i23, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:301)");
                                                    }
                                                    function36.invoke(arrayList2, composer4, Integer.valueOf(((i22 >> 12) & 112) | 8));
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }));
                                            int i23 = width;
                                            int i24 = i16;
                                            Iterator<T> it5 = listSubcompose3.iterator();
                                            while (it5.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(layout, ((Measurable) it5.next()).mo19855measureBRTryo0(Constraints.INSTANCE.m20931fixedJhjzzOo(i23, i24)), 0, 0, 0.0f, 4, null);
                                            }
                                            scrollableTabData2.onLaidOut(SubcomposeLayout, iMo15540roundToPx0680j_42, arrayList2, i17);
                                        }
                                    }, 4, null);
                                }
                            }, composer3, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 12582912 | ((i5 >> 3) & 14) | (i5 & 896) | (i5 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f5 = f62;
                    function32 = function332;
                    function22 = function2M17123getLambda2$material3_release;
                    modifier3 = modifier42;
                    j3 = j62;
                    j5 = j72;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$3
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

                    public final void invoke(@Nullable Composer composer3, int i13) {
                        TabRowKt.m17357ScrollableTabRowsKfQg0A(i, modifier3, j3, j5, f5, function32, function22, tabs, composer3, i2 | 1, i4);
                    }
                });
                return;
            }
            i5 |= 24576;
            f4 = f;
            i7 = i4 & 32;
            if (i7 != 0) {
            }
            i8 = i4 & 64;
            if (i8 != 0) {
            }
            if ((i4 & 128) != 0) {
            }
            if ((23967451 & i5) == 4793490) {
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
                    }
                    if (i8 == 0) {
                        function2M17123getLambda2$material3_release = function2;
                    }
                    Modifier modifier422 = modifier2;
                    long j622 = containerColor;
                    long j722 = contentColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3322 = function3ComposableLambda;
                    final int i1222 = i5;
                    final Function2<? super Composer, ? super Integer, Unit> function2322 = function2M17123getLambda2$material3_release;
                    final float f622 = f4;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m17325SurfaceT9BRK9s(modifier422, null, j622, j722, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 286469328, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$2
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
                        public final void invoke(@Nullable Composer composer3, int i13) {
                            if ((i13 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(286469328, i13, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:241)");
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
                            final float f7 = f622;
                            final Function2<? super Composer, ? super Integer, Unit> function24 = tabs;
                            final Function2<? super Composer, ? super Integer, Unit> function25 = function2322;
                            final int i14 = i;
                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function3322;
                            final int i15 = i1222;
                            SubcomposeLayoutKt.SubcomposeLayout(modifierClipToBounds, new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                    return m17359invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                }

                                @NotNull
                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m17359invoke0kLqBqw(@NotNull final SubcomposeMeasureScope SubcomposeLayout, final long j8) {
                                    Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                    int iMo15540roundToPx0680j_4 = SubcomposeLayout.mo15540roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
                                    final int iMo15540roundToPx0680j_42 = SubcomposeLayout.mo15540roundToPx0680j_4(f7);
                                    List<Measurable> listSubcompose = SubcomposeLayout.subcompose(TabSlots.Tabs, function24);
                                    Iterator<T> it = listSubcompose.iterator();
                                    int iMax = 0;
                                    while (it.hasNext()) {
                                        iMax = Math.max(iMax, ((Measurable) it.next()).maxIntrinsicHeight(Integer.MAX_VALUE));
                                    }
                                    long jM20912copyZbe2FdA$default = Constraints.m20912copyZbe2FdA$default(j8, iMo15540roundToPx0680j_4, 0, iMax, 0, 10, null);
                                    final int i16 = iMax;
                                    final List<? extends Placeable> arrayList = new ArrayList(CollectionsKt.m13952k(listSubcompose));
                                    Iterator<T> it2 = listSubcompose.iterator();
                                    while (it2.hasNext()) {
                                        arrayList.add(((Measurable) it2.next()).mo19855measureBRTryo0(jM20912copyZbe2FdA$default));
                                    }
                                    Iterator it3 = arrayList.iterator();
                                    final int width = iMo15540roundToPx0680j_42 * 2;
                                    while (it3.hasNext()) {
                                        width += ((Placeable) it3.next()).getWidth();
                                    }
                                    final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                                    final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                    final int i17 = i14;
                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                    final int i18 = i15;
                                    return MeasureScope.layout$default(SubcomposeLayout, width, i16, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRow.2.1.1
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
                                            int i19 = iMo15540roundToPx0680j_42;
                                            List<Placeable> list = arrayList;
                                            SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                            int width2 = i19;
                                            for (Placeable placeable : list) {
                                                Placeable.PlacementScope.placeRelative$default(layout, placeable, width2, 0, 0.0f, 4, null);
                                                arrayList2.add(new TabPosition(subcomposeMeasureScope.mo15543toDpu2uoSUM(width2), subcomposeMeasureScope.mo15543toDpu2uoSUM(placeable.getWidth()), null));
                                                width2 += placeable.getWidth();
                                            }
                                            List<Measurable> listSubcompose2 = SubcomposeLayout.subcompose(TabSlots.Divider, function26);
                                            long j9 = j8;
                                            int i20 = width;
                                            int i21 = i16;
                                            Iterator<T> it4 = listSubcompose2.iterator();
                                            while (it4.hasNext()) {
                                                long j10 = j9;
                                                Placeable placeableMo19855measureBRTryo0 = ((Measurable) it4.next()).mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j9, i20, i20, 0, 0, 8, null));
                                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, 0, i21 - placeableMo19855measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                j9 = j10;
                                                i20 = i20;
                                            }
                                            SubcomposeMeasureScope subcomposeMeasureScope2 = SubcomposeLayout;
                                            TabSlots tabSlots = TabSlots.Indicator;
                                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                            final int i22 = i18;
                                            List<Measurable> listSubcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(963343607, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRow.2.1.1.3
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
                                                public final void invoke(@Nullable Composer composer4, int i23) {
                                                    if ((i23 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(963343607, i23, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:301)");
                                                    }
                                                    function36.invoke(arrayList2, composer4, Integer.valueOf(((i22 >> 12) & 112) | 8));
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }));
                                            int i23 = width;
                                            int i24 = i16;
                                            Iterator<T> it5 = listSubcompose3.iterator();
                                            while (it5.hasNext()) {
                                                Placeable.PlacementScope.placeRelative$default(layout, ((Measurable) it5.next()).mo19855measureBRTryo0(Constraints.INSTANCE.m20931fixedJhjzzOo(i23, i24)), 0, 0, 0.0f, 4, null);
                                            }
                                            scrollableTabData2.onLaidOut(SubcomposeLayout, iMo15540roundToPx0680j_42, arrayList2, i17);
                                        }
                                    }, 4, null);
                                }
                            }, composer3, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 12582912 | ((i5 >> 3) & 14) | (i5 & 896) | (i5 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f5 = f622;
                    function32 = function3322;
                    function22 = function2M17123getLambda2$material3_release;
                    modifier3 = modifier422;
                    j3 = j622;
                    j5 = j722;
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 896) != 0) {
        }
        if ((i2 & 7168) != 0) {
        }
        i6 = i4 & 16;
        if (i6 != 0) {
        }
        f4 = f;
        i7 = i4 & 32;
        if (i7 != 0) {
        }
        i8 = i4 & 64;
        if (i8 != 0) {
        }
        if ((i4 & 128) != 0) {
        }
        if ((23967451 & i5) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x019d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011d  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_]]")
    /* JADX INFO: renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17358TabRowpAZo6Ak(final int i, @Nullable Modifier modifier, long j, long j2, @Nullable Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @NotNull final Function2<? super Composer, ? super Integer, Unit> tabs, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        long containerColor;
        long contentColor;
        int i6;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3ComposableLambda;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function22;
        final int i8;
        long j3;
        final Function2<? super Composer, ? super Integer, Unit> function2M17122getLambda1$material3_release;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        long j5;
        Composer composer2;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Modifier modifier3;
        final long j6;
        final long j7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1199178586);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i10 = i4 & 2;
        if (i10 != 0) {
            i5 |= 48;
        } else {
            if ((i2 & 112) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 896) != 0) {
                if ((i4 & 4) == 0) {
                    containerColor = j;
                    int i11 = composerStartRestartGroup.changed(containerColor) ? 256 : 128;
                    i5 |= i11;
                } else {
                    containerColor = j;
                }
                i5 |= i11;
            } else {
                containerColor = j;
            }
            if ((i2 & 7168) != 0) {
                contentColor = j2;
                i5 |= ((i4 & 8) == 0 && composerStartRestartGroup.changed(contentColor)) ? 2048 : 1024;
            } else {
                contentColor = j2;
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
                if (i7 != 0) {
                    i5 |= 196608;
                } else {
                    if ((458752 & i2) == 0) {
                        function22 = function2;
                        i5 |= composerStartRestartGroup.changed(function22) ? 131072 : 65536;
                    }
                    if ((i4 & 64) != 0) {
                        i9 = (i2 & 3670016) == 0 ? composerStartRestartGroup.changed(tabs) ? 1048576 : 524288 : 1572864;
                        if ((i5 & 2995931) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            composer2 = composerStartRestartGroup;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = contentColor;
                            function33 = function3ComposableLambda;
                            function23 = function22;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i10 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i4 & 4) != 0) {
                                    containerColor = TabRowDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i5 &= -897;
                                }
                                if ((i4 & 8) != 0) {
                                    contentColor = TabRowDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                    i5 &= -7169;
                                }
                                if (i6 != 0) {
                                    function3ComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2052073983, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$1
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
                                        public final void invoke(@NotNull List<TabPosition> tabPositions, @Nullable Composer composer3, int i12) {
                                            Intrinsics.checkNotNullParameter(tabPositions, "tabPositions");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2052073983, i12, -1, "androidx.compose.material3.TabRow.<anonymous> (TabRow.kt:130)");
                                            }
                                            TabRowDefaults tabRowDefaults = TabRowDefaults.INSTANCE;
                                            tabRowDefaults.m17354Indicator9IZ8Weo(tabRowDefaults.tabIndicatorOffset(Modifier.INSTANCE, tabPositions.get(i)), 0.0f, 0L, composer3, 3072, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                }
                                if (i7 == 0) {
                                    i8 = i5;
                                    j3 = contentColor;
                                    function2M17122getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m17122getLambda1$material3_release();
                                    function32 = function3ComposableLambda;
                                    j5 = containerColor;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1199178586, i8, -1, "androidx.compose.material3.TabRow (TabRow.kt:125)");
                                }
                                composer2 = composerStartRestartGroup;
                                SurfaceKt.m17325SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j5, j3, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$2
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
                                            ComposerKt.traceEventStart(1273256619, i12, -1, "androidx.compose.material3.TabRow.<anonymous> (TabRow.kt:144)");
                                        }
                                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        final Function2<Composer, Integer, Unit> function24 = tabs;
                                        final Function2<Composer, Integer, Unit> function25 = function2M17122getLambda1$material3_release;
                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function32;
                                        final int i13 = i8;
                                        composer3.startReplaceableGroup(1618982084);
                                        boolean zChanged = composer3.changed(function24) | composer3.changed(function25) | composer3.changed(function34);
                                        Object objRememberedValue = composer3.rememberedValue();
                                        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$TabRow$2$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                                    return m17360invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                                }

                                                @NotNull
                                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                                public final MeasureResult m17360invoke0kLqBqw(@NotNull final SubcomposeMeasureScope SubcomposeLayout, final long j8) {
                                                    Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                                    final int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j8);
                                                    List<Measurable> listSubcompose = SubcomposeLayout.subcompose(TabSlots.Tabs, function24);
                                                    int size = listSubcompose.size();
                                                    final int i14 = iM20921getMaxWidthimpl / size;
                                                    List<Measurable> list = listSubcompose;
                                                    Iterator<T> it = list.iterator();
                                                    final int iMax = 0;
                                                    while (it.hasNext()) {
                                                        iMax = Math.max(((Measurable) it.next()).maxIntrinsicHeight(i14), iMax);
                                                    }
                                                    final ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
                                                    for (Measurable measurable : list) {
                                                        int i15 = i14;
                                                        long jM20912copyZbe2FdA$default = Constraints.m20912copyZbe2FdA$default(j8, i15, i14, iMax, 0, 8, null);
                                                        i14 = i15;
                                                        arrayList.add(measurable.mo19855measureBRTryo0(jM20912copyZbe2FdA$default));
                                                    }
                                                    final ArrayList arrayList2 = new ArrayList(size);
                                                    for (int i16 = 0; i16 < size; i16++) {
                                                        arrayList2.add(new TabPosition(C2256Dp.m20968constructorimpl(SubcomposeLayout.mo15543toDpu2uoSUM(i14) * i16), SubcomposeLayout.mo15543toDpu2uoSUM(i14), null));
                                                    }
                                                    final Function2<Composer, Integer, Unit> function26 = function25;
                                                    final Function3<List<TabPosition>, Composer, Integer, Unit> function35 = function34;
                                                    final int i17 = i13;
                                                    return MeasureScope.layout$default(SubcomposeLayout, iM20921getMaxWidthimpl, iMax, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$2$1$1.1
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
                                                            int i18 = i14;
                                                            int i19 = 0;
                                                            for (Object obj : list2) {
                                                                int i20 = i19 + 1;
                                                                if (i19 < 0) {
                                                                    CollectionsKt.throwIndexOverflow();
                                                                }
                                                                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) obj, i19 * i18, 0, 0.0f, 4, null);
                                                                placementScope = layout;
                                                                i19 = i20;
                                                            }
                                                            List<Measurable> listSubcompose2 = SubcomposeLayout.subcompose(TabSlots.Divider, function26);
                                                            long j9 = j8;
                                                            int i21 = iMax;
                                                            Iterator<T> it2 = listSubcompose2.iterator();
                                                            while (it2.hasNext()) {
                                                                Placeable placeableMo19855measureBRTryo0 = ((Measurable) it2.next()).mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j9, 0, 0, 0, 0, 11, null));
                                                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, 0, i21 - placeableMo19855measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                                j9 = j9;
                                                            }
                                                            SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                                            TabSlots tabSlots = TabSlots.Indicator;
                                                            final Function3<List<TabPosition>, Composer, Integer, Unit> function36 = function35;
                                                            final List<TabPosition> list3 = arrayList2;
                                                            final int i22 = i17;
                                                            List<Measurable> listSubcompose3 = subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-976887453, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.TabRow.2.1.1.1.3
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
                                                                public final void invoke(@Nullable Composer composer4, int i23) {
                                                                    if ((i23 & 11) == 2 && composer4.getSkipping()) {
                                                                        composer4.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-976887453, i23, -1, "androidx.compose.material3.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:178)");
                                                                    }
                                                                    function36.invoke(list3, composer4, Integer.valueOf(((i22 >> 9) & 112) | 8));
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }));
                                                            int i23 = iM20921getMaxWidthimpl;
                                                            int i24 = iMax;
                                                            Iterator<T> it3 = listSubcompose3.iterator();
                                                            while (it3.hasNext()) {
                                                                Placeable.PlacementScope.placeRelative$default(layout, ((Measurable) it3.next()).mo19855measureBRTryo0(Constraints.INSTANCE.m20931fixedJhjzzOo(i23, i24)), 0, 0, 0.0f, 4, null);
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
                                }), composer2, 12582912 | (i8 & 896) | (i8 & 7168), 114);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function33 = function32;
                                function23 = function2M17122getLambda1$material3_release;
                                modifier3 = modifier2;
                                j6 = j5;
                                j7 = j3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i4 & 4) != 0) {
                                    i5 &= -897;
                                }
                                if ((i4 & 8) != 0) {
                                    i5 &= -7169;
                                }
                            }
                            i8 = i5;
                            function32 = function3ComposableLambda;
                            function2M17122getLambda1$material3_release = function22;
                            j5 = containerColor;
                            j3 = contentColor;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m17325SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j5, j3, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$2
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
                                        ComposerKt.traceEventStart(1273256619, i12, -1, "androidx.compose.material3.TabRow.<anonymous> (TabRow.kt:144)");
                                    }
                                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    final Function2<? super Composer, ? super Integer, Unit> function24 = tabs;
                                    final Function2<? super Composer, ? super Integer, Unit> function25 = function2M17122getLambda1$material3_release;
                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function32;
                                    final int i13 = i8;
                                    composer3.startReplaceableGroup(1618982084);
                                    boolean zChanged = composer3.changed(function24) | composer3.changed(function25) | composer3.changed(function34);
                                    Object objRememberedValue = composer3.rememberedValue();
                                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$TabRow$2$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                                return m17360invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                            }

                                            @NotNull
                                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                            public final MeasureResult m17360invoke0kLqBqw(@NotNull final SubcomposeMeasureScope SubcomposeLayout, final long j8) {
                                                Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                                final int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j8);
                                                List<Measurable> listSubcompose = SubcomposeLayout.subcompose(TabSlots.Tabs, function24);
                                                int size = listSubcompose.size();
                                                final int i14 = iM20921getMaxWidthimpl / size;
                                                List<Measurable> list = listSubcompose;
                                                Iterator<T> it = list.iterator();
                                                final int iMax = 0;
                                                while (it.hasNext()) {
                                                    iMax = Math.max(((Measurable) it.next()).maxIntrinsicHeight(i14), iMax);
                                                }
                                                final List<? extends Placeable> arrayList = new ArrayList(CollectionsKt.m13952k(list));
                                                for (Measurable measurable : list) {
                                                    int i15 = i14;
                                                    long jM20912copyZbe2FdA$default = Constraints.m20912copyZbe2FdA$default(j8, i15, i14, iMax, 0, 8, null);
                                                    i14 = i15;
                                                    arrayList.add(measurable.mo19855measureBRTryo0(jM20912copyZbe2FdA$default));
                                                }
                                                final List<TabPosition> arrayList2 = new ArrayList(size);
                                                for (int i16 = 0; i16 < size; i16++) {
                                                    arrayList2.add(new TabPosition(C2256Dp.m20968constructorimpl(SubcomposeLayout.mo15543toDpu2uoSUM(i14) * i16), SubcomposeLayout.mo15543toDpu2uoSUM(i14), null));
                                                }
                                                final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                                final int i17 = i13;
                                                return MeasureScope.layout$default(SubcomposeLayout, iM20921getMaxWidthimpl, iMax, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$2$1$1.1
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
                                                        int i18 = i14;
                                                        int i19 = 0;
                                                        for (Object obj : list2) {
                                                            int i20 = i19 + 1;
                                                            if (i19 < 0) {
                                                                CollectionsKt.throwIndexOverflow();
                                                            }
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) obj, i19 * i18, 0, 0.0f, 4, null);
                                                            placementScope = layout;
                                                            i19 = i20;
                                                        }
                                                        List<Measurable> listSubcompose2 = SubcomposeLayout.subcompose(TabSlots.Divider, function26);
                                                        long j9 = j8;
                                                        int i21 = iMax;
                                                        Iterator<T> it2 = listSubcompose2.iterator();
                                                        while (it2.hasNext()) {
                                                            Placeable placeableMo19855measureBRTryo0 = ((Measurable) it2.next()).mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j9, 0, 0, 0, 0, 11, null));
                                                            Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, 0, i21 - placeableMo19855measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                            j9 = j9;
                                                        }
                                                        SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                                        TabSlots tabSlots = TabSlots.Indicator;
                                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                                        final List<TabPosition> list3 = arrayList2;
                                                        final int i22 = i17;
                                                        List<Measurable> listSubcompose3 = subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-976887453, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.TabRow.2.1.1.1.3
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
                                                            public final void invoke(@Nullable Composer composer4, int i23) {
                                                                if ((i23 & 11) == 2 && composer4.getSkipping()) {
                                                                    composer4.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-976887453, i23, -1, "androidx.compose.material3.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:178)");
                                                                }
                                                                function36.invoke(list3, composer4, Integer.valueOf(((i22 >> 9) & 112) | 8));
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }));
                                                        int i23 = iM20921getMaxWidthimpl;
                                                        int i24 = iMax;
                                                        Iterator<T> it3 = listSubcompose3.iterator();
                                                        while (it3.hasNext()) {
                                                            Placeable.PlacementScope.placeRelative$default(layout, ((Measurable) it3.next()).mo19855measureBRTryo0(Constraints.INSTANCE.m20931fixedJhjzzOo(i23, i24)), 0, 0, 0.0f, 4, null);
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
                            }), composer2, 12582912 | (i8 & 896) | (i8 & 7168), 114);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function33 = function32;
                            function23 = function2M17122getLambda1$material3_release;
                            modifier3 = modifier2;
                            j6 = j5;
                            j7 = j3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$3
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
                                TabRowKt.m17358TabRowpAZo6Ak(i, modifier3, j6, j7, function33, function23, tabs, composer3, i2 | 1, i4);
                            }
                        });
                        return;
                    }
                    i5 |= i9;
                    if ((i5 & 2995931) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i10 != 0) {
                            }
                            if ((i4 & 4) != 0) {
                            }
                            if ((i4 & 8) != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 == 0) {
                                i8 = i5;
                                function32 = function3ComposableLambda;
                                function2M17122getLambda1$material3_release = function22;
                                j5 = containerColor;
                                j3 = contentColor;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m17325SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j5, j3, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1273256619, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$2
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
                                        ComposerKt.traceEventStart(1273256619, i12, -1, "androidx.compose.material3.TabRow.<anonymous> (TabRow.kt:144)");
                                    }
                                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    final Function2<? super Composer, ? super Integer, Unit> function24 = tabs;
                                    final Function2<? super Composer, ? super Integer, Unit> function25 = function2M17122getLambda1$material3_release;
                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function32;
                                    final int i13 = i8;
                                    composer3.startReplaceableGroup(1618982084);
                                    boolean zChanged = composer3.changed(function24) | composer3.changed(function25) | composer3.changed(function34);
                                    Object objRememberedValue = composer3.rememberedValue();
                                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$TabRow$2$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                                return m17360invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                            }

                                            @NotNull
                                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                            public final MeasureResult m17360invoke0kLqBqw(@NotNull final SubcomposeMeasureScope SubcomposeLayout, final long j8) {
                                                Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                                final int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j8);
                                                List<Measurable> listSubcompose = SubcomposeLayout.subcompose(TabSlots.Tabs, function24);
                                                int size = listSubcompose.size();
                                                final int i14 = iM20921getMaxWidthimpl / size;
                                                List<Measurable> list = listSubcompose;
                                                Iterator<T> it = list.iterator();
                                                final int iMax = 0;
                                                while (it.hasNext()) {
                                                    iMax = Math.max(((Measurable) it.next()).maxIntrinsicHeight(i14), iMax);
                                                }
                                                final List<? extends Placeable> arrayList = new ArrayList(CollectionsKt.m13952k(list));
                                                for (Measurable measurable : list) {
                                                    int i15 = i14;
                                                    long jM20912copyZbe2FdA$default = Constraints.m20912copyZbe2FdA$default(j8, i15, i14, iMax, 0, 8, null);
                                                    i14 = i15;
                                                    arrayList.add(measurable.mo19855measureBRTryo0(jM20912copyZbe2FdA$default));
                                                }
                                                final List<TabPosition> arrayList2 = new ArrayList(size);
                                                for (int i16 = 0; i16 < size; i16++) {
                                                    arrayList2.add(new TabPosition(C2256Dp.m20968constructorimpl(SubcomposeLayout.mo15543toDpu2uoSUM(i14) * i16), SubcomposeLayout.mo15543toDpu2uoSUM(i14), null));
                                                }
                                                final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                                final int i17 = i13;
                                                return MeasureScope.layout$default(SubcomposeLayout, iM20921getMaxWidthimpl, iMax, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$2$1$1.1
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
                                                        int i18 = i14;
                                                        int i19 = 0;
                                                        for (Object obj : list2) {
                                                            int i20 = i19 + 1;
                                                            if (i19 < 0) {
                                                                CollectionsKt.throwIndexOverflow();
                                                            }
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) obj, i19 * i18, 0, 0.0f, 4, null);
                                                            placementScope = layout;
                                                            i19 = i20;
                                                        }
                                                        List<Measurable> listSubcompose2 = SubcomposeLayout.subcompose(TabSlots.Divider, function26);
                                                        long j9 = j8;
                                                        int i21 = iMax;
                                                        Iterator<T> it2 = listSubcompose2.iterator();
                                                        while (it2.hasNext()) {
                                                            Placeable placeableMo19855measureBRTryo0 = ((Measurable) it2.next()).mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j9, 0, 0, 0, 0, 11, null));
                                                            Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, 0, i21 - placeableMo19855measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                            j9 = j9;
                                                        }
                                                        SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                                        TabSlots tabSlots = TabSlots.Indicator;
                                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                                        final List<TabPosition> list3 = arrayList2;
                                                        final int i22 = i17;
                                                        List<Measurable> listSubcompose3 = subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-976887453, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.TabRow.2.1.1.1.3
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
                                                            public final void invoke(@Nullable Composer composer4, int i23) {
                                                                if ((i23 & 11) == 2 && composer4.getSkipping()) {
                                                                    composer4.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-976887453, i23, -1, "androidx.compose.material3.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:178)");
                                                                }
                                                                function36.invoke(list3, composer4, Integer.valueOf(((i22 >> 9) & 112) | 8));
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }));
                                                        int i23 = iM20921getMaxWidthimpl;
                                                        int i24 = iMax;
                                                        Iterator<T> it3 = listSubcompose3.iterator();
                                                        while (it3.hasNext()) {
                                                            Placeable.PlacementScope.placeRelative$default(layout, ((Measurable) it3.next()).mo19855measureBRTryo0(Constraints.INSTANCE.m20931fixedJhjzzOo(i23, i24)), 0, 0, 0.0f, 4, null);
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
                            }), composer2, 12582912 | (i8 & 896) | (i8 & 7168), 114);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function33 = function32;
                            function23 = function2M17122getLambda1$material3_release;
                            modifier3 = modifier2;
                            j6 = j5;
                            j7 = j3;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function22 = function2;
                if ((i4 & 64) != 0) {
                }
                i5 |= i9;
                if ((i5 & 2995931) == 599186) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function3ComposableLambda = function3;
            i7 = i4 & 32;
            if (i7 != 0) {
            }
            function22 = function2;
            if ((i4 & 64) != 0) {
            }
            i5 |= i9;
            if ((i5 & 2995931) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
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
        if (i7 != 0) {
        }
        function22 = function2;
        if ((i4 & 64) != 0) {
        }
        i5 |= i9;
        if ((i5 & 2995931) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
