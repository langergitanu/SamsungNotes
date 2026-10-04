package androidx.compose.foundation.layout;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.AlignmentLine;
import androidx.compose.p109ui.layout.HorizontalAlignmentLine;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.platform.InspectableValueKt;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.p109ui.unit.TextUnitKt;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a>\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a*\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, m13886d2 = {"horizontal", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getHorizontal", "(Landroidx/compose/ui/layout/AlignmentLine;)Z", "alignmentLineOffsetMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "alignmentLine", "before", "Landroidx/compose/ui/unit/Dp;", "after", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "alignmentLineOffsetMeasure-tjqqzMA", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/AlignmentLine;FFLandroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "paddingFrom", "Landroidx/compose/ui/Modifier;", "paddingFrom-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/TextUnit;", "paddingFrom-Y_r0B1c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;JJ)Landroidx/compose/ui/Modifier;", "paddingFromBaseline", "top", "bottom", "paddingFromBaseline-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "paddingFromBaseline-wCyjxdI", "(Landroidx/compose/ui/Modifier;JJ)Landroidx/compose/ui/Modifier;", "foundation-layout_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAlignmentLine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlignmentLine.kt\nandroidx/compose/foundation/layout/AlignmentLineKt\n+ 2 InspectableValue.kt\nandroidx/compose/ui/platform/InspectableValueKt\n*L\n1#1,366:1\n135#2:367\n135#2:368\n*S KotlinDebug\n*F\n+ 1 AlignmentLine.kt\nandroidx/compose/foundation/layout/AlignmentLineKt\n*L\n75#1:367\n121#1:368\n*E\n"})
public final class AlignmentLineKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: alignmentLineOffsetMeasure-tjqqzMA, reason: not valid java name */
    public static final MeasureResult m15703alignmentLineOffsetMeasuretjqqzMA(MeasureScope measureScope, final AlignmentLine alignmentLine, final float f, float f4, Measurable measurable, long j) {
        final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(getHorizontal(alignmentLine) ? Constraints.m20912copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null) : Constraints.m20912copyZbe2FdA$default(j, 0, 0, 0, 0, 14, null));
        int i = placeableMo19855measureBRTryo0.get(alignmentLine);
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        int height = getHorizontal(alignmentLine) ? placeableMo19855measureBRTryo0.getHeight() : placeableMo19855measureBRTryo0.getWidth();
        int iM20920getMaxHeightimpl = getHorizontal(alignmentLine) ? Constraints.m20920getMaxHeightimpl(j) : Constraints.m20921getMaxWidthimpl(j);
        C2256Dp.Companion companion = C2256Dp.INSTANCE;
        int i2 = iM20920getMaxHeightimpl - height;
        final int iCoerceIn = RangesKt.coerceIn((!C2256Dp.m20973equalsimpl0(f, companion.m20988getUnspecifiedD9Ej5fM()) ? measureScope.mo15540roundToPx0680j_4(f) : 0) - i, 0, i2);
        final int iCoerceIn2 = RangesKt.coerceIn(((!C2256Dp.m20973equalsimpl0(f4, companion.m20988getUnspecifiedD9Ej5fM()) ? measureScope.mo15540roundToPx0680j_4(f4) : 0) - height) + i, 0, i2 - iCoerceIn);
        int width = getHorizontal(alignmentLine) ? placeableMo19855measureBRTryo0.getWidth() : Math.max(placeableMo19855measureBRTryo0.getWidth() + iCoerceIn + iCoerceIn2, Constraints.m20923getMinWidthimpl(j));
        final int iMax = getHorizontal(alignmentLine) ? Math.max(placeableMo19855measureBRTryo0.getHeight() + iCoerceIn + iCoerceIn2, Constraints.m20922getMinHeightimpl(j)) : placeableMo19855measureBRTryo0.getHeight();
        final int i4 = width;
        return MeasureScope.layout$default(measureScope, i4, iMax, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$alignmentLineOffsetMeasure$1
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
                int width2;
                if (AlignmentLineKt.getHorizontal(alignmentLine)) {
                    width2 = 0;
                } else {
                    width2 = !C2256Dp.m20973equalsimpl0(f, C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM()) ? iCoerceIn : (i4 - iCoerceIn2) - placeableMo19855measureBRTryo0.getWidth();
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo19855measureBRTryo0, width2, AlignmentLineKt.getHorizontal(alignmentLine) ? !C2256Dp.m20973equalsimpl0(f, C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM()) ? iCoerceIn : (iMax - iCoerceIn2) - placeableMo19855measureBRTryo0.getHeight() : 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHorizontal(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: paddingFrom-4j6BHR0, reason: not valid java name */
    public static final Modifier m15704paddingFrom4j6BHR0(@NotNull Modifier modifier, @NotNull final AlignmentLine alignmentLine, final float f, final float f4) {
        return modifier.then(new AlignmentLineOffsetDpElement(alignmentLine, f, f4, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("paddingFrom");
                inspectorInfo.getProperties().set("alignmentLine", alignmentLine);
                AbstractC0622a.m1162h(f, inspectorInfo.getProperties(), "before", inspectorInfo).set("after", C2256Dp.m20966boximpl(f4));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: paddingFrom-4j6BHR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15705paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f, float f4, int i, Object obj) {
        if ((i & 2) != 0) {
            f = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f4 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        return m15704paddingFrom4j6BHR0(modifier, alignmentLine, f, f4);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c, reason: not valid java name */
    public static final Modifier m15706paddingFromY_r0B1c(@NotNull Modifier modifier, @NotNull final AlignmentLine alignmentLine, long j, long j2) {
        AlignmentLine alignmentLine2;
        final long j3;
        final long j5;
        Function1<InspectorInfo, Unit> noInspectorInfo;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            j3 = j;
            j5 = j2;
            noInspectorInfo = new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-Y_r0B1c$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    invoke2(inspectorInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("paddingFrom");
                    inspectorInfo.getProperties().set("alignmentLine", alignmentLine);
                    inspectorInfo.getProperties().set("before", TextUnit.m21151boximpl(j3));
                    inspectorInfo.getProperties().set("after", TextUnit.m21151boximpl(j5));
                }
            };
            alignmentLine2 = alignmentLine;
        } else {
            alignmentLine2 = alignmentLine;
            j3 = j;
            j5 = j2;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new AlignmentLineOffsetTextUnitElement(alignmentLine2, j3, j5, noInspectorInfo, null));
    }

    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15707paddingFromY_r0B1c$default(Modifier modifier, AlignmentLine alignmentLine, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE();
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE();
        }
        return m15706paddingFromY_r0B1c(modifier, alignmentLine, j3, j2);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4, reason: not valid java name */
    public static final Modifier m15708paddingFromBaselineVpY3zN4(@NotNull Modifier modifier, float f, float f4) {
        C2256Dp.Companion companion = C2256Dp.INSTANCE;
        return modifier.then(!C2256Dp.m20973equalsimpl0(f, companion.m20988getUnspecifiedD9Ej5fM()) ? m15705paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.p109ui.layout.AlignmentLineKt.getFirstBaseline(), f, 0.0f, 4, null) : Modifier.INSTANCE).then(!C2256Dp.m20973equalsimpl0(f4, companion.m20988getUnspecifiedD9Ej5fM()) ? m15705paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.p109ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, f4, 2, null) : Modifier.INSTANCE);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15709paddingFromBaselineVpY3zN4$default(Modifier modifier, float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        return m15708paddingFromBaselineVpY3zN4(modifier, f, f4);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI, reason: not valid java name */
    public static final Modifier m15710paddingFromBaselinewCyjxdI(@NotNull Modifier modifier, long j, long j2) {
        return modifier.then(!TextUnitKt.m21179isUnspecifiedR2X_6o(j) ? m15707paddingFromY_r0B1c$default(Modifier.INSTANCE, androidx.compose.p109ui.layout.AlignmentLineKt.getFirstBaseline(), j, 0L, 4, null) : Modifier.INSTANCE).then(!TextUnitKt.m21179isUnspecifiedR2X_6o(j2) ? m15707paddingFromY_r0B1c$default(Modifier.INSTANCE, androidx.compose.p109ui.layout.AlignmentLineKt.getLastBaseline(), 0L, j2, 2, null) : Modifier.INSTANCE);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15711paddingFromBaselinewCyjxdI$default(Modifier modifier, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE();
        }
        if ((i & 2) != 0) {
            j2 = TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE();
        }
        return m15710paddingFromBaselinewCyjxdI(modifier, j, j2);
    }
}
