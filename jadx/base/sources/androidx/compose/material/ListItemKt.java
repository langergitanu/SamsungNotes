package androidx.compose.material;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.AlignmentLineKt;
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
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0090\u0001\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u0013\u001a:\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a?\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0013\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\tH\u0002¢\u0006\u0002\u0010\u001d\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, m13886d2 = {"BaselinesOffsetColumn", "", "offsets", "", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ListItem", "icon", "secondaryText", "singleLineSecondaryText", "", "overlineText", "trailing", "text", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OffsetToBaselineOrCenter", TypedValues.Cycle.S_WAVE_OFFSET, "OffsetToBaselineOrCenter-Kz89ssw", "(FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "applyTextStyle", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "(Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ListItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void BaselinesOffsetColumn(final List<C2256Dp> list, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1631148337);
        if ((i2 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        final Modifier modifier2 = modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1631148337, i, -1, "androidx.compose.material.BaselinesOffsetColumn (ListItem.kt:347)");
        }
        MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.ListItemKt.BaselinesOffsetColumn.1
            @Override // androidx.compose.p109ui.layout.MeasurePolicy
            @NotNull
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope Layout, @NotNull List<? extends Measurable> measurables, long j) {
                int height;
                Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                long jM20912copyZbe2FdA$default = Constraints.m20912copyZbe2FdA$default(j, 0, 0, 0, Integer.MAX_VALUE, 3, null);
                List<? extends Measurable> list2 = measurables;
                final ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list2));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Measurable) it.next()).mo19855measureBRTryo0(jM20912copyZbe2FdA$default));
                }
                Iterator it2 = arrayList.iterator();
                int iMax = 0;
                while (it2.hasNext()) {
                    iMax = Math.max(iMax, ((Placeable) it2.next()).getWidth());
                }
                int size = arrayList.size();
                final Integer[] numArr = new Integer[size];
                for (int i4 = 0; i4 < size; i4++) {
                    numArr[i4] = 0;
                }
                List<C2256Dp> list3 = list;
                int size2 = arrayList.size();
                int height2 = 0;
                for (int i5 = 0; i5 < size2; i5++) {
                    Placeable placeable = (Placeable) arrayList.get(i5);
                    if (i5 > 0) {
                        int i6 = i5 - 1;
                        height = ((Placeable) arrayList.get(i6)).getHeight() - ((Placeable) arrayList.get(i6)).get(AlignmentLineKt.getLastBaseline());
                    } else {
                        height = 0;
                    }
                    int iMax2 = Math.max(0, (Layout.mo15540roundToPx0680j_4(list3.get(i5).m20982unboximpl()) - placeable.get(AlignmentLineKt.getFirstBaseline())) - height);
                    numArr[i5] = Integer.valueOf(iMax2 + height2);
                    height2 += placeable.getHeight() + iMax2;
                }
                return MeasureScope.layout$default(Layout, iMax, height2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ListItemKt$BaselinesOffsetColumn$1$measure$2
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
                        List<Placeable> list4 = arrayList;
                        Integer[] numArr2 = numArr;
                        int size3 = list4.size();
                        for (int i7 = 0; i7 < size3; i7++) {
                            Placeable.PlacementScope.placeRelative$default(layout, list4.get(i7), 0, numArr2[i7].intValue(), 0.0f, 4, null);
                        }
                    }
                }, 4, null);
            }
        };
        Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier2);
        int i4 = (((((i >> 6) & 14) | (i & 112)) << 9) & 7168) | 6;
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
        Updater.m18025setimpl(composerM18018constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
        Updater.m18025setimpl(composerM18018constructorimpl, density, companion.getSetDensity());
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
        function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 9) & 14));
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.BaselinesOffsetColumn.2
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
                ListItemKt.BaselinesOffsetColumn(list, modifier2, function2, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0112  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][_][_][_][_]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ListItem(@Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, boolean z, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, @NotNull final Function2<? super Composer, ? super Integer, Unit> text, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i6;
        boolean z2;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<Composer, Integer, Unit> function2ApplyTextStyle;
        Function2<Composer, Integer, Unit> function2ApplyTextStyle2;
        Function2<Composer, Integer, Unit> function2ApplyTextStyle3;
        Function2<Composer, Integer, Unit> function2ApplyTextStyle4;
        Modifier modifierSemantics;
        Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final boolean z3;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-450923337);
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
        int i10 = i2 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                function25 = function2;
                i4 |= composerStartRestartGroup.changed(function25) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    function26 = function22;
                    i4 |= composerStartRestartGroup.changed(function26) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 7168) == 0) {
                        z2 = z;
                        i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                    }
                    i7 = i2 & 16;
                    if (i7 != 0) {
                        if ((57344 & i) == 0) {
                            function27 = function23;
                            i4 |= composerStartRestartGroup.changed(function27) ? 16384 : 8192;
                        }
                        i8 = i2 & 32;
                        if (i8 != 0) {
                            i4 |= 196608;
                        } else if ((i & 458752) == 0) {
                            i4 |= composerStartRestartGroup.changed(function24) ? 131072 : 65536;
                        }
                        if ((i2 & 64) != 0) {
                            i4 |= 1572864;
                        } else if ((i & 3670016) == 0) {
                            i4 |= composerStartRestartGroup.changed(text) ? 1048576 : 524288;
                        }
                        if ((i4 & 2995931) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            function213 = function24;
                            modifier3 = modifier2;
                            function212 = function25;
                            function211 = function26;
                            z3 = z2;
                            function210 = function27;
                        } else {
                            Modifier modifier4 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i10 != 0) {
                                function25 = null;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function214 = i5 == 0 ? null : function26;
                            boolean z4 = i6 == 0 ? true : z2;
                            function28 = i7 == 0 ? null : function27;
                            Function2<? super Composer, ? super Integer, Unit> function215 = i8 == 0 ? function24 : null;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-450923337, i4, -1, "androidx.compose.material.ListItem (ListItem.kt:72)");
                            }
                            Typography typography = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            TextStyle subtitle1 = typography.getSubtitle1();
                            ContentAlpha contentAlpha = ContentAlpha.INSTANCE;
                            function2ApplyTextStyle = applyTextStyle(subtitle1, contentAlpha.getHigh(composerStartRestartGroup, 6), text);
                            Intrinsics.checkNotNull(function2ApplyTextStyle);
                            function2ApplyTextStyle2 = applyTextStyle(typography.getBody2(), contentAlpha.getMedium(composerStartRestartGroup, 6), function214);
                            Function2<? super Composer, ? super Integer, Unit> function216 = function214;
                            function2ApplyTextStyle3 = applyTextStyle(typography.getOverline(), contentAlpha.getHigh(composerStartRestartGroup, 6), function28);
                            function2ApplyTextStyle4 = applyTextStyle(typography.getCaption(), contentAlpha.getHigh(composerStartRestartGroup, 6), function215);
                            modifierSemantics = SemanticsModifierKt.semantics(modifier4, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }
                            });
                            if (function2ApplyTextStyle2 == null || function2ApplyTextStyle3 != null) {
                                function29 = function25;
                                function210 = function28;
                                if ((function2ApplyTextStyle3 == null || !z4) && function2ApplyTextStyle2 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function29, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i4 & 112) | 1572864, 0);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280382);
                                    TwoLine.INSTANCE.ListItem(modifierSemantics, function29, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i4 & 112) | 1572864, 0);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280579);
                                function29 = function25;
                                function210 = function28;
                                OneLine.INSTANCE.ListItem(modifierSemantics, function29, function2ApplyTextStyle, function2ApplyTextStyle4, composerStartRestartGroup, (i4 & 112) | 24576, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function211 = function216;
                            z3 = z4;
                            function212 = function29;
                            function213 = function215;
                            modifier3 = modifier4;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                            public final void invoke(@Nullable Composer composer2, int i11) {
                                ListItemKt.ListItem(modifier3, function212, function211, z3, function210, function213, text, composer2, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= 24576;
                    function27 = function23;
                    i8 = i2 & 32;
                    if (i8 != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i4 & 2995931) == 599186) {
                        if (i9 == 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Typography typography2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        TextStyle subtitle12 = typography2.getSubtitle1();
                        ContentAlpha contentAlpha2 = ContentAlpha.INSTANCE;
                        function2ApplyTextStyle = applyTextStyle(subtitle12, contentAlpha2.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography2.getBody2(), contentAlpha2.getMedium(composerStartRestartGroup, 6), function214);
                        Function2<? super Composer, ? super Integer, Unit> function2162 = function214;
                        function2ApplyTextStyle3 = applyTextStyle(typography2.getOverline(), contentAlpha2.getHigh(composerStartRestartGroup, 6), function28);
                        function2ApplyTextStyle4 = applyTextStyle(typography2.getCaption(), contentAlpha2.getHigh(composerStartRestartGroup, 6), function215);
                        modifierSemantics = SemanticsModifierKt.semantics(modifier4, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function29 = function25;
                            function210 = function28;
                            if (function2ApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function29, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i4 & 112) | 1572864, 0);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                function211 = function2162;
                                z3 = z4;
                                function212 = function29;
                                function213 = function215;
                                modifier3 = modifier4;
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function29, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i4 & 112) | 1572864, 0);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                function211 = function2162;
                                z3 = z4;
                                function212 = function29;
                                function213 = function215;
                                modifier3 = modifier4;
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z2 = z;
                i7 = i2 & 16;
                if (i7 != 0) {
                }
                function27 = function23;
                i8 = i2 & 32;
                if (i8 != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i4 & 2995931) == 599186) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function26 = function22;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            z2 = z;
            i7 = i2 & 16;
            if (i7 != 0) {
            }
            function27 = function23;
            i8 = i2 & 32;
            if (i8 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i4 & 2995931) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function25 = function2;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        function26 = function22;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        z2 = z;
        i7 = i2 & 16;
        if (i7 != 0) {
        }
        function27 = function23;
        i8 = i2 & 32;
        if (i8 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i4 & 2995931) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: OffsetToBaselineOrCenter-Kz89ssw, reason: not valid java name */
    public static final void m16776OffsetToBaselineOrCenterKz89ssw(final float f, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1062692685);
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
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(function2) ? 256 : 128;
        }
        if ((i4 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1062692685, i4, -1, "androidx.compose.material.OffsetToBaselineOrCenter (ListItem.kt:389)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$1
                @Override // androidx.compose.p109ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope Layout, @NotNull List<? extends Measurable> measurables, long j) {
                    int iMax;
                    final int iM21097getYimpl;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    final Placeable placeableMo19855measureBRTryo0 = measurables.get(0).mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                    int i6 = placeableMo19855measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
                    if (i6 != Integer.MIN_VALUE) {
                        iM21097getYimpl = Layout.mo15540roundToPx0680j_4(f) - i6;
                        iMax = Math.max(Constraints.m20922getMinHeightimpl(j), placeableMo19855measureBRTryo0.getHeight() + iM21097getYimpl);
                    } else {
                        iMax = Math.max(Constraints.m20922getMinHeightimpl(j), placeableMo19855measureBRTryo0.getHeight());
                        iM21097getYimpl = IntOffset.m21097getYimpl(Alignment.INSTANCE.getCenter().mo18130alignKFBX0sM(IntSize.INSTANCE.m21143getZeroYbymL2g(), IntSizeKt.IntSize(0, iMax - placeableMo19855measureBRTryo0.getHeight()), Layout.getLayoutDirection()));
                    }
                    return MeasureScope.layout$default(Layout, placeableMo19855measureBRTryo0.getWidth(), iMax, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$1$measure$1
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
                            Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, 0, iM21097getYimpl, 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            };
            Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
            int i6 = ((((i4 & 112) | ((i4 >> 6) & 14)) << 9) & 7168) | 6;
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
            Updater.m18025setimpl(composerM18018constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
            Updater.m18025setimpl(composerM18018constructorimpl, density, companion.getSetDensity());
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i6 >> 9) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$2
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
                ListItemKt.m16776OffsetToBaselineOrCenterKz89ssw(f, modifier2, function2, composer2, i | 1, i2);
            }
        });
    }

    private static final Function2<Composer, Integer, Unit> applyTextStyle(final TextStyle textStyle, final float f, final Function2<? super Composer, ? super Integer, Unit> function2) {
        if (function2 == null) {
            return null;
        }
        return ComposableLambdaKt.composableLambdaInstance(-830176860, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.applyTextStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(@Nullable Composer composer, int i) {
                if ((i & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-830176860, i, -1, "androidx.compose.material.applyTextStyle.<anonymous> (ListItem.kt:422)");
                }
                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(f))};
                final TextStyle textStyle2 = textStyle;
                final Function2<Composer, Integer, Unit> function22 = function2;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer, 1665877604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.applyTextStyle.1.1
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
                    public final void invoke(@Nullable Composer composer2, int i2) {
                        if ((i2 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1665877604, i2, -1, "androidx.compose.material.applyTextStyle.<anonymous>.<anonymous> (ListItem.kt:423)");
                        }
                        TextKt.ProvideTextStyle(textStyle2, function22, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }
}
