package androidx.compose.material;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.AlignmentLineKt;
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
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.p109ui.unit.TextUnitKt;
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
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
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
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a~\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a8\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010\u001e\u001a\u00020\t*\u00020\u001f2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010 \"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, m13886d2 = {"TextBaselineDistanceFromTitle", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextBaselineDistanceFromTop", "TextPadding", "Landroidx/compose/ui/Modifier;", "TitleBaselineDistanceFromTop", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "title", "text", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "AlertDialogContent-WMdw5o4", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/runtime/Composer;II)V", "AlertDialogFlowRow", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "AlertDialogBaselineLayout", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class AlertDialogKt {
    private static final long TextBaselineDistanceFromTitle;
    private static final long TextBaselineDistanceFromTop;

    @NotNull
    private static final Modifier TextPadding;
    private static final long TitleBaselineDistanceFromTop;

    @NotNull
    private static final Modifier TitlePadding;

    static {
        Modifier.Companion companion = Modifier.INSTANCE;
        float f = 24;
        TitlePadding = PaddingKt.m15858paddingqDBjuR0$default(companion, C2256Dp.m20968constructorimpl(f), 0.0f, C2256Dp.m20968constructorimpl(f), 0.0f, 10, null);
        TextPadding = PaddingKt.m15858paddingqDBjuR0$default(companion, C2256Dp.m20968constructorimpl(f), 0.0f, C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(28), 2, null);
        TitleBaselineDistanceFromTop = TextUnitKt.getSp(40);
        TextBaselineDistanceFromTitle = TextUnitKt.getSp(36);
        TextBaselineDistanceFromTop = TextUnitKt.getSp(38);
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void AlertDialogBaselineLayout(@NotNull final ColumnScope columnScope, @Nullable final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable final Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(-555573207);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(columnScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(function22) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-555573207, i, -1, "androidx.compose.material.AlertDialogBaselineLayout (AlertDialog.kt:92)");
            }
            Modifier modifierWeight = columnScope.weight(Modifier.INSTANCE, 1.0f, false);
            C14632 c14632 = new MeasurePolicy() { // from class: androidx.compose.material.AlertDialogKt.AlertDialogBaselineLayout.2
                /* JADX WARN: Removed duplicated region for block: B:39:0x00a9  */
                /* JADX WARN: Removed duplicated region for block: B:47:0x00c3  */
                /* JADX WARN: Removed duplicated region for block: B:56:0x00e5  */
                @Override // androidx.compose.p109ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope Layout, @NotNull List<? extends Measurable> measurables, long j) {
                    Object next;
                    long j2;
                    final Placeable placeableMo19855measureBRTryo0;
                    Object next2;
                    int iIntValue;
                    int iIntValue2;
                    int iIntValue3;
                    final int i4;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    List<? extends Measurable> list = measurables;
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next), "title")) {
                            break;
                        }
                    }
                    Measurable measurable = (Measurable) next;
                    if (measurable != null) {
                        j2 = j;
                        placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j2, 0, 0, 0, 0, 11, null));
                    } else {
                        j2 = j;
                        placeableMo19855measureBRTryo0 = null;
                    }
                    Iterator<T> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next2), "text")) {
                            break;
                        }
                    }
                    Measurable measurable2 = (Measurable) next2;
                    final Placeable placeableMo19855measureBRTryo02 = measurable2 != null ? measurable2.mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j2, 0, 0, 0, 0, 11, null)) : null;
                    int iMax = Math.max(placeableMo19855measureBRTryo0 != null ? placeableMo19855measureBRTryo0.getWidth() : 0, placeableMo19855measureBRTryo02 != null ? placeableMo19855measureBRTryo02.getWidth() : 0);
                    if (placeableMo19855measureBRTryo0 == null) {
                        iIntValue = 0;
                    } else {
                        int i5 = placeableMo19855measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
                        Integer numValueOf = i5 == Integer.MIN_VALUE ? null : Integer.valueOf(i5);
                        if (numValueOf != null) {
                            iIntValue = numValueOf.intValue();
                        }
                    }
                    if (placeableMo19855measureBRTryo0 == null) {
                        iIntValue2 = 0;
                    } else {
                        int i6 = placeableMo19855measureBRTryo0.get(AlignmentLineKt.getLastBaseline());
                        Integer numValueOf2 = i6 == Integer.MIN_VALUE ? null : Integer.valueOf(i6);
                        if (numValueOf2 != null) {
                            iIntValue2 = numValueOf2.intValue();
                        }
                    }
                    final int iMo15539roundToPxR2X_6o = Layout.mo15539roundToPxR2X_6o(AlertDialogKt.TitleBaselineDistanceFromTop) - iIntValue;
                    if (placeableMo19855measureBRTryo02 == null) {
                        iIntValue3 = 0;
                    } else {
                        int i7 = placeableMo19855measureBRTryo02.get(AlignmentLineKt.getFirstBaseline());
                        Integer numValueOf3 = i7 != Integer.MIN_VALUE ? Integer.valueOf(i7) : null;
                        if (numValueOf3 != null) {
                            iIntValue3 = numValueOf3.intValue();
                        }
                    }
                    int iMo15539roundToPxR2X_6o2 = placeableMo19855measureBRTryo0 == null ? Layout.mo15539roundToPxR2X_6o(AlertDialogKt.TextBaselineDistanceFromTop) : Layout.mo15539roundToPxR2X_6o(AlertDialogKt.TextBaselineDistanceFromTitle);
                    int height = placeableMo19855measureBRTryo0 != null ? placeableMo19855measureBRTryo0.getHeight() + iMo15539roundToPxR2X_6o : 0;
                    if (placeableMo19855measureBRTryo0 == null) {
                        i4 = iMo15539roundToPxR2X_6o2 - iIntValue3;
                    } else {
                        i4 = (iIntValue2 == 0 ? height - iIntValue3 : (iMo15539roundToPxR2X_6o + iIntValue2) - iIntValue3) + iMo15539roundToPxR2X_6o2;
                    }
                    if (placeableMo19855measureBRTryo02 != null) {
                        if (iIntValue2 == 0) {
                            height = (placeableMo19855measureBRTryo02.getHeight() + iMo15539roundToPxR2X_6o2) - iIntValue3;
                        } else {
                            height = ((placeableMo19855measureBRTryo02.getHeight() + iMo15539roundToPxR2X_6o2) - iIntValue3) - ((placeableMo19855measureBRTryo0 != null ? placeableMo19855measureBRTryo0.getHeight() : 0) - iIntValue2);
                        }
                    }
                    return MeasureScope.layout$default(Layout, iMax, height + height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2$measure$1
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
                            Placeable placeable = placeableMo19855measureBRTryo0;
                            if (placeable != null) {
                                Placeable.PlacementScope.place$default(layout, placeable, 0, iMo15539roundToPxR2X_6o, 0.0f, 4, null);
                            }
                            Placeable placeable2 = placeableMo19855measureBRTryo02;
                            if (placeable2 != null) {
                                Placeable.PlacementScope.place$default(layout, placeable2, 0, i4, 0.0f, 4, null);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierWeight);
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
            Updater.m18025setimpl(composerM18018constructorimpl, c14632, companion.getSetMeasurePolicy());
            Updater.m18025setimpl(composerM18018constructorimpl, density, companion.getSetDensity());
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            AbstractC1038a.m1220u(2058660585, 1454034642, composerStartRestartGroup, -1160646206);
            if (function2 != null) {
                Modifier modifierLayoutId = LayoutIdKt.layoutId(TitlePadding, "title");
                Alignment.Companion companion2 = Alignment.INSTANCE;
                Modifier modifierAlign = columnScope.align(modifierLayoutId, companion2.getStart());
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composerStartRestartGroup, 0, -1323940314);
                Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor2 = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierAlign);
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
                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(472489145);
                function2.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                Unit unit = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (function22 != null) {
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(TextPadding, "text");
                Alignment.Companion companion3 = Alignment.INSTANCE;
                Modifier modifierAlign2 = columnScope.align(modifierLayoutId2, companion3.getStart());
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion3, false, composerStartRestartGroup, 0, -1323940314);
                Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor3 = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierAlign2);
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
                Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl3, measurePolicyM1210k2, composerM18018constructorimpl3, density3));
                function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-272722206);
                function22.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                Unit unit2 = Unit.INSTANCE;
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt.AlertDialogBaselineLayout.3
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
                AlertDialogKt.AlertDialogBaselineLayout(columnScope, function2, function22, composer2, i | 1);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f0  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: AlertDialogContent-WMdw5o4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16579AlertDialogContentWMdw5o4(@NotNull final Function2<? super Composer, ? super Integer, Unit> buttons, @Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Shape shape, long j, long j2, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        int i6;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        Shape medium;
        long jM16680getSurface0d7_KjU;
        long jM16694contentColorForek8zF_U;
        int i7;
        final int i8;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Modifier modifier3;
        final Shape shape2;
        final long j3;
        final long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Composer composerStartRestartGroup = composer.startRestartGroup(-453679601);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(buttons) ? 4 : 2) | i;
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
                    function23 = function2;
                    i4 |= composerStartRestartGroup.changed(function23) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 == 0) {
                    if ((i & 7168) == 0) {
                        function24 = function22;
                        i4 |= composerStartRestartGroup.changed(function24) ? 2048 : 1024;
                    }
                    if ((57344 & i) != 0) {
                        if ((i2 & 16) == 0) {
                            medium = shape;
                            int i10 = composerStartRestartGroup.changed(medium) ? 16384 : 8192;
                            i4 |= i10;
                        } else {
                            medium = shape;
                        }
                        i4 |= i10;
                    } else {
                        medium = shape;
                    }
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            jM16680getSurface0d7_KjU = j;
                            int i11 = composerStartRestartGroup.changed(jM16680getSurface0d7_KjU) ? 131072 : 65536;
                            i4 |= i11;
                        } else {
                            jM16680getSurface0d7_KjU = j;
                        }
                        i4 |= i11;
                    } else {
                        jM16680getSurface0d7_KjU = j;
                    }
                    if ((3670016 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            jM16694contentColorForek8zF_U = j2;
                            int i12 = composerStartRestartGroup.changed(jM16694contentColorForek8zF_U) ? 1048576 : 524288;
                            i4 |= i12;
                        } else {
                            jM16694contentColorForek8zF_U = j2;
                        }
                        i4 |= i12;
                    } else {
                        jM16694contentColorForek8zF_U = j2;
                    }
                    int i13 = i4;
                    if ((i4 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function23 = null;
                            }
                            if (i6 != 0) {
                                function24 = null;
                            }
                            if ((i2 & 16) == 0) {
                                i7 = i13 & (-57345);
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            } else {
                                i7 = i13;
                            }
                            if ((i2 & 32) == 0) {
                                jM16680getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16680getSurface0d7_KjU();
                                i8 = i7 & (-458753);
                            } else {
                                i8 = i7;
                            }
                            if ((i2 & 64) != 0) {
                                jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 15) & 14);
                                i8 &= -3670017;
                            }
                            long j6 = jM16694contentColorForek8zF_U;
                            long j7 = jM16680getSurface0d7_KjU;
                            Shape shape3 = medium;
                            Modifier modifier4 = modifier2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-453679601, i8, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
                            }
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                                public final void invoke(@Nullable Composer composer3, int i14) {
                                    if ((i14 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(629950291, i14, -1, "androidx.compose.material.AlertDialogContent.<anonymous> (AlertDialog.kt:57)");
                                    }
                                    final Function2<Composer, Integer, Unit> function27 = function23;
                                    final Function2<Composer, Integer, Unit> function28 = function24;
                                    Function2<Composer, Integer, Unit> function29 = buttons;
                                    final int i15 = i8;
                                    composer3.startReplaceableGroup(-483455358);
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer3, 0, -1323940314);
                                    Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
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
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                    composer3.startReplaceableGroup(-1163856341);
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    composer3.startReplaceableGroup(523699273);
                                    AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function27 != null ? ComposableLambdaKt.composableLambda(composer3, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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
                                        public final void invoke(@Nullable Composer composer4, int i16) {
                                            if ((i16 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(620104160, i16, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:61)");
                                            }
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer4, 6)))};
                                            final Function2<Composer, Integer, Unit> function210 = function27;
                                            final int i17 = i15;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer4, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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
                                                public final void invoke(@Nullable Composer composer5, int i18) {
                                                    if ((i18 & 11) == 2 && composer5.getSkipping()) {
                                                        composer5.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(770166432, i18, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:62)");
                                                    }
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer5, 6).getSubtitle1(), function210, composer5, (i17 >> 3) & 112);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), composer4, 56);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }) : null, function28 != null ? ComposableLambdaKt.composableLambda(composer3, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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
                                        public final void invoke(@Nullable Composer composer4, int i16) {
                                            if ((i16 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1965858367, i16, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:69)");
                                            }
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer4, 6)))};
                                            final Function2<Composer, Integer, Unit> function210 = function28;
                                            final int i17 = i15;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer4, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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
                                                public final void invoke(@Nullable Composer composer5, int i18) {
                                                    if ((i18 & 11) == 2 && composer5.getSkipping()) {
                                                        composer5.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(2115920639, i18, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:72)");
                                                    }
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer5, 6).getBody2(), function210, composer5, (i17 >> 6) & 112);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), composer4, 56);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }) : null, composer3, 6);
                                    if (AbstractC1038a.m1199D(composer3, i15 & 14, function29)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                            int i14 = ((i8 >> 3) & 14) | 1572864;
                            int i15 = i8 >> 9;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m16872SurfaceFjzlyU(modifier4, shape3, j7, j6, null, 0.0f, composableLambda, composer2, i14 | (i15 & 112) | (i15 & 896) | (i15 & 7168), 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function25 = function23;
                            function26 = function24;
                            modifier3 = modifier4;
                            shape2 = shape3;
                            j3 = j7;
                            j5 = j6;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i8 = (i2 & 16) != 0 ? i13 & (-57345) : i13;
                            if ((i2 & 32) != 0) {
                                i8 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i8 &= -3670017;
                            }
                            long j62 = jM16694contentColorForek8zF_U;
                            long j72 = jM16680getSurface0d7_KjU;
                            Shape shape32 = medium;
                            Modifier modifier42 = modifier2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                                public final void invoke(@Nullable Composer composer3, int i142) {
                                    if ((i142 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(629950291, i142, -1, "androidx.compose.material.AlertDialogContent.<anonymous> (AlertDialog.kt:57)");
                                    }
                                    final Function2<? super Composer, ? super Integer, Unit> function27 = function23;
                                    final Function2<? super Composer, ? super Integer, Unit> function28 = function24;
                                    Function2<Composer, Integer, Unit> function29 = buttons;
                                    final int i152 = i8;
                                    composer3.startReplaceableGroup(-483455358);
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer3, 0, -1323940314);
                                    Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
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
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                    composer3.startReplaceableGroup(-1163856341);
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    composer3.startReplaceableGroup(523699273);
                                    AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function27 != null ? ComposableLambdaKt.composableLambda(composer3, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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
                                        public final void invoke(@Nullable Composer composer4, int i16) {
                                            if ((i16 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(620104160, i16, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:61)");
                                            }
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer4, 6)))};
                                            final Function2<? super Composer, ? super Integer, Unit> function210 = function27;
                                            final int i17 = i152;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer4, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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
                                                public final void invoke(@Nullable Composer composer5, int i18) {
                                                    if ((i18 & 11) == 2 && composer5.getSkipping()) {
                                                        composer5.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(770166432, i18, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:62)");
                                                    }
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer5, 6).getSubtitle1(), function210, composer5, (i17 >> 3) & 112);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), composer4, 56);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }) : null, function28 != null ? ComposableLambdaKt.composableLambda(composer3, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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
                                        public final void invoke(@Nullable Composer composer4, int i16) {
                                            if ((i16 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1965858367, i16, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:69)");
                                            }
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer4, 6)))};
                                            final Function2<? super Composer, ? super Integer, Unit> function210 = function28;
                                            final int i17 = i152;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer4, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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
                                                public final void invoke(@Nullable Composer composer5, int i18) {
                                                    if ((i18 & 11) == 2 && composer5.getSkipping()) {
                                                        composer5.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(2115920639, i18, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:72)");
                                                    }
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer5, 6).getBody2(), function210, composer5, (i17 >> 6) & 112);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), composer4, 56);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }) : null, composer3, 6);
                                    if (AbstractC1038a.m1199D(composer3, i152 & 14, function29)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                            int i142 = ((i8 >> 3) & 14) | 1572864;
                            int i152 = i8 >> 9;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m16872SurfaceFjzlyU(modifier42, shape32, j72, j62, null, 0.0f, composableLambda2, composer2, i142 | (i152 & 112) | (i152 & 896) | (i152 & 7168), 48);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function25 = function23;
                            function26 = function24;
                            modifier3 = modifier42;
                            shape2 = shape32;
                            j3 = j72;
                            j5 = j62;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier2;
                        function25 = function23;
                        function26 = function24;
                        shape2 = medium;
                        j3 = jM16680getSurface0d7_KjU;
                        j5 = jM16694contentColorForek8zF_U;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$2
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

                        public final void invoke(@Nullable Composer composer3, int i16) {
                            AlertDialogKt.m16579AlertDialogContentWMdw5o4(buttons, modifier3, function25, function26, shape2, j3, j5, composer3, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= 3072;
                function24 = function22;
                if ((57344 & i) != 0) {
                }
                if ((458752 & i) != 0) {
                }
                if ((3670016 & i) != 0) {
                }
                int i132 = i4;
                if ((i4 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i2 & 16) == 0) {
                        }
                        if ((i2 & 32) == 0) {
                        }
                        if ((i2 & 64) != 0) {
                        }
                        long j622 = jM16694contentColorForek8zF_U;
                        long j722 = jM16680getSurface0d7_KjU;
                        Shape shape322 = medium;
                        Modifier modifier422 = modifier2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposableLambda composableLambda22 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                            public final void invoke(@Nullable Composer composer3, int i1422) {
                                if ((i1422 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(629950291, i1422, -1, "androidx.compose.material.AlertDialogContent.<anonymous> (AlertDialog.kt:57)");
                                }
                                final Function2<? super Composer, ? super Integer, Unit> function27 = function23;
                                final Function2<? super Composer, ? super Integer, Unit> function28 = function24;
                                Function2<Composer, Integer, Unit> function29 = buttons;
                                final int i1522 = i8;
                                composer3.startReplaceableGroup(-483455358);
                                Modifier.Companion companion = Modifier.INSTANCE;
                                MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer3, 0, -1323940314);
                                Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
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
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                composer3.startReplaceableGroup(-1163856341);
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                composer3.startReplaceableGroup(523699273);
                                AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function27 != null ? ComposableLambdaKt.composableLambda(composer3, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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
                                    public final void invoke(@Nullable Composer composer4, int i16) {
                                        if ((i16 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(620104160, i16, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:61)");
                                        }
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer4, 6)))};
                                        final Function2<? super Composer, ? super Integer, Unit> function210 = function27;
                                        final int i17 = i1522;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer4, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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
                                            public final void invoke(@Nullable Composer composer5, int i18) {
                                                if ((i18 & 11) == 2 && composer5.getSkipping()) {
                                                    composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(770166432, i18, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:62)");
                                                }
                                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer5, 6).getSubtitle1(), function210, composer5, (i17 >> 3) & 112);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer4, 56);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : null, function28 != null ? ComposableLambdaKt.composableLambda(composer3, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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
                                    public final void invoke(@Nullable Composer composer4, int i16) {
                                        if ((i16 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1965858367, i16, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:69)");
                                        }
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer4, 6)))};
                                        final Function2<? super Composer, ? super Integer, Unit> function210 = function28;
                                        final int i17 = i1522;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer4, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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
                                            public final void invoke(@Nullable Composer composer5, int i18) {
                                                if ((i18 & 11) == 2 && composer5.getSkipping()) {
                                                    composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2115920639, i18, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:72)");
                                                }
                                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer5, 6).getBody2(), function210, composer5, (i17 >> 6) & 112);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer4, 56);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : null, composer3, 6);
                                if (AbstractC1038a.m1199D(composer3, i1522 & 14, function29)) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        int i1422 = ((i8 >> 3) & 14) | 1572864;
                        int i1522 = i8 >> 9;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m16872SurfaceFjzlyU(modifier422, shape322, j722, j622, null, 0.0f, composableLambda22, composer2, i1422 | (i1522 & 112) | (i1522 & 896) | (i1522 & 7168), 48);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function25 = function23;
                        function26 = function24;
                        modifier3 = modifier422;
                        shape2 = shape322;
                        j3 = j722;
                        j5 = j622;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function23 = function2;
            i6 = i2 & 8;
            if (i6 == 0) {
            }
            function24 = function22;
            if ((57344 & i) != 0) {
            }
            if ((458752 & i) != 0) {
            }
            if ((3670016 & i) != 0) {
            }
            int i1322 = i4;
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
        function23 = function2;
        i6 = i2 & 8;
        if (i6 == 0) {
        }
        function24 = function22;
        if ((57344 & i) != 0) {
        }
        if ((458752 & i) != 0) {
        }
        if ((3670016 & i) != 0) {
        }
        int i13222 = i4;
        if ((i4 & 2995931) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m16580AlertDialogFlowRowixp7dh8(final float f, final float f4, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(73434452);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(f4) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(content) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(73434452, i2, -1, "androidx.compose.material.AlertDialogFlowRow (AlertDialog.kt:187)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$1
                private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef intRef, MeasureScope measureScope, float f5, long j, Placeable placeable) {
                    if (list.isEmpty()) {
                        return true;
                    }
                    return placeable.getWidth() + (measureScope.mo15540roundToPx0680j_4(f5) + intRef.element) <= Constraints.m20921getMaxWidthimpl(j);
                }

                private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref.IntRef intRef, MeasureScope measureScope, float f5, List<Placeable> list2, List<Integer> list3, Ref.IntRef intRef2, List<Integer> list4, Ref.IntRef intRef3, Ref.IntRef intRef4) {
                    List<List<Placeable>> list5 = list;
                    if (!list5.isEmpty()) {
                        intRef.element = measureScope.mo15540roundToPx0680j_4(f5) + intRef.element;
                    }
                    list5.add(CollectionsKt.toList(list2));
                    list3.add(Integer.valueOf(intRef2.element));
                    list4.add(Integer.valueOf(intRef.element));
                    intRef.element += intRef2.element;
                    intRef3.element = Math.max(intRef3.element, intRef4.element);
                    list2.clear();
                    intRef4.element = 0;
                    intRef2.element = 0;
                }

                @Override // androidx.compose.p109ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo15214measure3p2s80s(@NotNull final MeasureScope measureScope, @NotNull List<? extends Measurable> measurables, long j) {
                    ArrayList arrayList;
                    ArrayList arrayList2;
                    Ref.IntRef intRef;
                    Placeable placeable;
                    Ref.IntRef intRef2;
                    Ref.IntRef intRef3;
                    MeasureScope Layout = measureScope;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = arrayList3;
                    final ArrayList arrayList6 = new ArrayList();
                    ArrayList arrayList7 = arrayList4;
                    Ref.IntRef intRef4 = new Ref.IntRef();
                    Ref.IntRef intRef5 = new Ref.IntRef();
                    ArrayList arrayList8 = new ArrayList();
                    Ref.IntRef intRef6 = new Ref.IntRef();
                    Ref.IntRef intRef7 = new Ref.IntRef();
                    long jConstraints$default = ConstraintsKt.Constraints$default(0, Constraints.m20921getMaxWidthimpl(j), 0, 0, 13, null);
                    Iterator<? extends Measurable> it = measurables.iterator();
                    while (it.hasNext()) {
                        Placeable placeableMo19855measureBRTryo0 = it.next().mo19855measureBRTryo0(jConstraints$default);
                        ArrayList arrayList9 = arrayList8;
                        arrayList8 = arrayList9;
                        if (measure_3p2s80s$canAddToCurrentSequence(arrayList9, intRef6, Layout, f, j, placeableMo19855measureBRTryo0)) {
                            Layout = measureScope;
                            arrayList = arrayList5;
                            arrayList2 = arrayList7;
                            intRef = intRef6;
                            placeable = placeableMo19855measureBRTryo0;
                            intRef2 = intRef5;
                            intRef3 = intRef7;
                        } else {
                            Layout = measureScope;
                            arrayList = arrayList5;
                            arrayList2 = arrayList7;
                            intRef = intRef6;
                            placeable = placeableMo19855measureBRTryo0;
                            intRef2 = intRef5;
                            intRef3 = intRef7;
                            measure_3p2s80s$startNewSequence(arrayList, intRef2, Layout, f4, arrayList8, arrayList2, intRef3, arrayList6, intRef4, intRef);
                        }
                        if (!arrayList8.isEmpty()) {
                            intRef.element = Layout.mo15540roundToPx0680j_4(f) + intRef.element;
                        }
                        arrayList8.add(placeable);
                        intRef.element = placeable.getWidth() + intRef.element;
                        intRef3.element = Math.max(intRef3.element, placeable.getHeight());
                        intRef5 = intRef2;
                        arrayList7 = arrayList2;
                        intRef7 = intRef3;
                        intRef6 = intRef;
                        arrayList5 = arrayList;
                    }
                    final ArrayList arrayList10 = arrayList5;
                    ArrayList arrayList11 = arrayList7;
                    Ref.IntRef intRef8 = intRef7;
                    Ref.IntRef intRef9 = intRef6;
                    Ref.IntRef intRef10 = intRef5;
                    if (!arrayList8.isEmpty()) {
                        measure_3p2s80s$startNewSequence(arrayList10, intRef10, Layout, f4, arrayList8, arrayList11, intRef8, arrayList6, intRef4, intRef9);
                    }
                    final int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j) != Integer.MAX_VALUE ? Constraints.m20921getMaxWidthimpl(j) : Math.max(intRef4.element, Constraints.m20923getMinWidthimpl(j));
                    int iMax = Math.max(intRef10.element, Constraints.m20922getMinHeightimpl(j));
                    final float f5 = f;
                    return MeasureScope.layout$default(measureScope, iM20921getMaxWidthimpl, iMax, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$1$measure$1
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
                        public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                            Placeable.PlacementScope layout = placementScope;
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                            List<List<Placeable>> list = arrayList10;
                            MeasureScope measureScope2 = measureScope;
                            float f6 = f5;
                            int i4 = iM20921getMaxWidthimpl;
                            List<Integer> list2 = arrayList6;
                            int size = list.size();
                            int i5 = 0;
                            while (i5 < size) {
                                List<Placeable> list3 = list.get(i5);
                                int size2 = list3.size();
                                int[] iArr = new int[size2];
                                int i6 = 0;
                                while (i6 < size2) {
                                    iArr[i6] = list3.get(i6).getWidth() + (i6 < CollectionsKt.getLastIndex(list3) ? measureScope2.mo15540roundToPx0680j_4(f6) : 0);
                                    i6++;
                                }
                                Arrangement.Vertical bottom = Arrangement.INSTANCE.getBottom();
                                int[] iArr2 = new int[size2];
                                for (int i7 = 0; i7 < size2; i7++) {
                                    iArr2[i7] = 0;
                                }
                                bottom.arrange(measureScope2, i4, iArr, iArr2);
                                int size3 = list3.size();
                                int i8 = 0;
                                while (i8 < size3) {
                                    Placeable.PlacementScope.place$default(layout, list3.get(i8), iArr2[i8], list2.get(i5).intValue(), 0.0f, 4, null);
                                    i8++;
                                    layout = placementScope;
                                    iArr2 = iArr2;
                                    size3 = size3;
                                    list3 = list3;
                                }
                                i5++;
                                layout = placementScope;
                            }
                        }
                    }, 4, null);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion = Modifier.INSTANCE;
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
            int i4 = ((((i2 >> 6) & 14) << 9) & 7168) | 6;
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
            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
            content.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 9) & 14));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$2
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
                AlertDialogKt.m16580AlertDialogFlowRowixp7dh8(f, f4, content, composer2, i | 1);
            }
        });
    }
}
