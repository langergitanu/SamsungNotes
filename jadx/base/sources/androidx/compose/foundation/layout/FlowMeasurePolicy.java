package androidx.compose.foundation.layout;

import androidx.collection.AbstractC0622a;
import androidx.collection.IntIntPair;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.p109ui.layout.IntrinsicMeasurable;
import androidx.compose.p109ui.layout.IntrinsicMeasureScope;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.MultiContentMeasurePolicy;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\u0016\u0010+\u001a\u00020\nHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\t\u0010.\u001a\u00020\fHÆ\u0003J\u0016\u0010/\u001a\u00020\nHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010-J\t\u00101\u001a\u00020\u000fHÂ\u0003J\t\u00102\u001a\u00020\u000fHÂ\u0003J\t\u00103\u001a\u00020\u0012HÂ\u0003Jm\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106J\u0013\u00107\u001a\u00020\u00042\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u000fHÖ\u0001JD\u0010;\u001a\u00020\u000f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001c0=2\u0006\u0010>\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J$\u0010@\u001a\u00020\u000f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001c0=2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fJD\u0010C\u001a\u00020\u000f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001c0=2\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010E\u001a\u00020FHÖ\u0001J(\u0010G\u001a\u00020\u000f*\u00020H2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0=0=2\u0006\u0010I\u001a\u00020\u000fH\u0016J(\u0010J\u001a\u00020\u000f*\u00020H2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0=0=2\u0006\u0010A\u001a\u00020\u000fH\u0016J2\u0010K\u001a\u00020L*\u00020M2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0=0=2\u0006\u0010O\u001a\u00020PH\u0016ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ(\u0010S\u001a\u00020\u000f*\u00020H2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0=0=2\u0006\u0010I\u001a\u00020\u000fH\u0016J(\u0010T\u001a\u00020\u000f*\u00020H2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0=0=2\u0006\u0010A\u001a\u00020\u000fH\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\r\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0019R\u0016\u0010\t\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0016R.\u0010\u001a\u001a\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010 \u001a\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001d¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR.\u0010\"\u001a\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001d¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR.\u0010$\u001a\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001d¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006U"}, m13886d2 = {"Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "isHorizontal", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisArrangementSpacing", "maxItemsInMainAxis", "", "maxLines", "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", TokenizerME.NO_SPLIT, "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "()Z", "maxCrossAxisIntrinsicItemSize", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "Lkotlin/ExtensionFunctionType;", "getMaxCrossAxisIntrinsicItemSize", "()Lkotlin/jvm/functions/Function3;", "maxMainAxisIntrinsicItemSize", "getMaxMainAxisIntrinsicItemSize", "minCrossAxisIntrinsicItemSize", "getMinCrossAxisIntrinsicItemSize", "minMainAxisIntrinsicItemSize", "getMinMainAxisIntrinsicItemSize", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "component1", "component2", "component3", "component4", "component4-D9Ej5fM", "()F", "component5", "component6", "component6-D9Ej5fM", "component7", "component8", "component9", "copy", "copy-QuyCDyQ", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "equals", "other", "", "hashCode", "intrinsicCrossAxisSize", "measurables", "", "mainAxisAvailable", "crossAxisSpacing", "maxIntrinsicMainAxisSize", "height", "arrangementSpacing", "minIntrinsicMainAxisSize", "crossAxisAvailable", "toString", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final /* data */ class FlowMeasurePolicy implements MultiContentMeasurePolicy, FlowLineMeasurePolicy {

    @NotNull
    private final CrossAxisAlignment crossAxisAlignment;
    private final float crossAxisArrangementSpacing;

    @NotNull
    private final Arrangement.Horizontal horizontalArrangement;
    private final boolean isHorizontal;
    private final float mainAxisSpacing;

    @NotNull
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxCrossAxisIntrinsicItemSize;
    private final int maxItemsInMainAxis;
    private final int maxLines;

    @NotNull
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxMainAxisIntrinsicItemSize;

    @NotNull
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minCrossAxisIntrinsicItemSize;

    @NotNull
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minMainAxisIntrinsicItemSize;

    @NotNull
    private final FlowLayoutOverflowState overflow;

    @NotNull
    private final Arrangement.Vertical verticalArrangement;

    public /* synthetic */ FlowMeasurePolicy(boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment, float f4, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, horizontal, vertical, f, crossAxisAlignment, f4, i, i2, flowLayoutOverflowState);
    }

    /* JADX INFO: renamed from: component4-D9Ej5fM, reason: not valid java name and from getter */
    private final float getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    /* JADX INFO: renamed from: component6-D9Ej5fM, reason: not valid java name and from getter */
    private final float getCrossAxisArrangementSpacing() {
        return this.crossAxisArrangementSpacing;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    private final int getMaxItemsInMainAxis() {
        return this.maxItemsInMainAxis;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    private final int getMaxLines() {
        return this.maxLines;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    private final FlowLayoutOverflowState getOverflow() {
        return this.overflow;
    }

    /* JADX INFO: renamed from: copy-QuyCDyQ$default, reason: not valid java name */
    public static /* synthetic */ FlowMeasurePolicy m15800copyQuyCDyQ$default(FlowMeasurePolicy flowMeasurePolicy, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment, float f4, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = flowMeasurePolicy.isHorizontal;
        }
        if ((i4 & 2) != 0) {
            horizontal = flowMeasurePolicy.horizontalArrangement;
        }
        if ((i4 & 4) != 0) {
            vertical = flowMeasurePolicy.verticalArrangement;
        }
        if ((i4 & 8) != 0) {
            f = flowMeasurePolicy.mainAxisSpacing;
        }
        if ((i4 & 16) != 0) {
            crossAxisAlignment = flowMeasurePolicy.crossAxisAlignment;
        }
        if ((i4 & 32) != 0) {
            f4 = flowMeasurePolicy.crossAxisArrangementSpacing;
        }
        if ((i4 & 64) != 0) {
            i = flowMeasurePolicy.maxItemsInMainAxis;
        }
        if ((i4 & 128) != 0) {
            i2 = flowMeasurePolicy.maxLines;
        }
        if ((i4 & 256) != 0) {
            flowLayoutOverflowState = flowMeasurePolicy.overflow;
        }
        int i5 = i2;
        FlowLayoutOverflowState flowLayoutOverflowState2 = flowLayoutOverflowState;
        float f5 = f4;
        int i6 = i;
        CrossAxisAlignment crossAxisAlignment2 = crossAxisAlignment;
        Arrangement.Vertical vertical2 = vertical;
        return flowMeasurePolicy.m15801copyQuyCDyQ(z, horizontal, vertical2, f, crossAxisAlignment2, f5, i6, i5, flowLayoutOverflowState2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsHorizontal() {
        return this.isHorizontal;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-QuyCDyQ, reason: not valid java name */
    public final FlowMeasurePolicy m15801copyQuyCDyQ(boolean isHorizontal, @NotNull Arrangement.Horizontal horizontalArrangement, @NotNull Arrangement.Vertical verticalArrangement, float mainAxisSpacing, @NotNull CrossAxisAlignment crossAxisAlignment, float crossAxisArrangementSpacing, int maxItemsInMainAxis, int maxLines, @NotNull FlowLayoutOverflowState overflow) {
        return new FlowMeasurePolicy(isHorizontal, horizontalArrangement, verticalArrangement, mainAxisSpacing, crossAxisAlignment, crossAxisArrangementSpacing, maxItemsInMainAxis, maxLines, overflow, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowMeasurePolicy)) {
            return false;
        }
        FlowMeasurePolicy flowMeasurePolicy = (FlowMeasurePolicy) other;
        return this.isHorizontal == flowMeasurePolicy.isHorizontal && Intrinsics.areEqual(this.horizontalArrangement, flowMeasurePolicy.horizontalArrangement) && Intrinsics.areEqual(this.verticalArrangement, flowMeasurePolicy.verticalArrangement) && C2256Dp.m20973equalsimpl0(this.mainAxisSpacing, flowMeasurePolicy.mainAxisSpacing) && Intrinsics.areEqual(this.crossAxisAlignment, flowMeasurePolicy.crossAxisAlignment) && C2256Dp.m20973equalsimpl0(this.crossAxisArrangementSpacing, flowMeasurePolicy.crossAxisArrangementSpacing) && this.maxItemsInMainAxis == flowMeasurePolicy.maxItemsInMainAxis && this.maxLines == flowMeasurePolicy.maxLines && Intrinsics.areEqual(this.overflow, flowMeasurePolicy.overflow);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    @NotNull
    public CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    @NotNull
    public Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    @NotNull
    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxCrossAxisIntrinsicItemSize() {
        return this.maxCrossAxisIntrinsicItemSize;
    }

    @NotNull
    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxMainAxisIntrinsicItemSize() {
        return this.maxMainAxisIntrinsicItemSize;
    }

    @NotNull
    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinCrossAxisIntrinsicItemSize() {
        return this.minCrossAxisIntrinsicItemSize;
    }

    @NotNull
    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinMainAxisIntrinsicItemSize() {
        return this.minMainAxisIntrinsicItemSize;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    @NotNull
    public Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    public int hashCode() {
        return this.overflow.hashCode() + AbstractC0622a.m1157c(this.maxLines, AbstractC0622a.m1157c(this.maxItemsInMainAxis, AbstractC0622a.m1153C(this.crossAxisArrangementSpacing, (this.crossAxisAlignment.hashCode() + AbstractC0622a.m1153C(this.mainAxisSpacing, (this.verticalArrangement.hashCode() + ((this.horizontalArrangement.hashCode() + (Boolean.hashCode(this.isHorizontal) * 31)) * 31)) * 31, 31)) * 31, 31), 31), 31);
    }

    public final int intrinsicCrossAxisSize(@NotNull List<? extends IntrinsicMeasurable> measurables, int mainAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, @NotNull FlowLayoutOverflowState overflow) {
        return IntIntPair.m15204getFirstimpl(FlowLayoutKt.intrinsicCrossAxisSize((List<? extends IntrinsicMeasurable>) measurables, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) this.minMainAxisIntrinsicItemSize, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) this.minCrossAxisIntrinsicItemSize, mainAxisAvailable, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis, maxLines, overflow));
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    @Override // androidx.compose.p109ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        flowLayoutOverflowState.m15784setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3) : null, isHorizontal(), ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        if (isHorizontal()) {
            List<? extends IntrinsicMeasurable> listEmptyList = (List) CollectionsKt.firstOrNull((List) list);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return intrinsicCrossAxisSize(listEmptyList, i, intrinsicMeasureScope.mo15540roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo15540roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        List<? extends IntrinsicMeasurable> listEmptyList2 = (List) CollectionsKt.firstOrNull((List) list);
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        return maxIntrinsicMainAxisSize(listEmptyList2, i, intrinsicMeasureScope.mo15540roundToPx0680j_4(this.mainAxisSpacing));
    }

    public final int maxIntrinsicMainAxisSize(@NotNull List<? extends IntrinsicMeasurable> measurables, int height, int arrangementSpacing) {
        return FlowLayoutKt.maxIntrinsicMainAxisSize(measurables, this.maxMainAxisIntrinsicItemSize, height, arrangementSpacing, this.maxItemsInMainAxis);
    }

    @Override // androidx.compose.p109ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        flowLayoutOverflowState.m15784setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3) : null, isHorizontal(), ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        if (isHorizontal()) {
            List<? extends IntrinsicMeasurable> listEmptyList = (List) CollectionsKt.firstOrNull((List) list);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return maxIntrinsicMainAxisSize(listEmptyList, i, intrinsicMeasureScope.mo15540roundToPx0680j_4(this.mainAxisSpacing));
        }
        List<? extends IntrinsicMeasurable> listEmptyList2 = (List) CollectionsKt.firstOrNull((List) list);
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        return intrinsicCrossAxisSize(listEmptyList2, i, intrinsicMeasureScope.mo15540roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo15540roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    @Override // androidx.compose.p109ui.layout.MultiContentMeasurePolicy
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult mo15802measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends List<? extends Measurable>> list, long j) {
        if (this.maxLines == 0 || this.maxItemsInMainAxis == 0 || list.isEmpty() || (Constraints.m20920getMaxHeightimpl(j) == 0 && this.overflow.getType$foundation_layout_release() != FlowLayoutOverflow.OverflowType.Visible)) {
            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$measure$1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }, 4, null);
        }
        List list2 = (List) CollectionsKt.first((List) list);
        if (list2.isEmpty()) {
            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$measure$2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }, 4, null);
        }
        List list3 = (List) CollectionsKt.getOrNull(list, 1);
        Measurable measurable = list3 != null ? (Measurable) CollectionsKt.firstOrNull(list3) : null;
        List list4 = (List) CollectionsKt.getOrNull(list, 2);
        Measurable measurable2 = list4 != null ? (Measurable) CollectionsKt.firstOrNull(list4) : null;
        this.overflow.setItemCount$foundation_layout_release(list2.size());
        this.overflow.m15783setOverflowMeasurableshBUhpc$foundation_layout_release(this, measurable, measurable2, j);
        return FlowLayoutKt.m15779breakDownItemsdi9J0FM(measureScope, this, list2.iterator(), this.mainAxisSpacing, this.crossAxisArrangementSpacing, OrientationIndependentConstraints.m15823constructorimpl(j, isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    @Override // androidx.compose.p109ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        flowLayoutOverflowState.m15784setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3) : null, isHorizontal(), ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        if (isHorizontal()) {
            List<? extends IntrinsicMeasurable> listEmptyList = (List) CollectionsKt.firstOrNull((List) list);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return intrinsicCrossAxisSize(listEmptyList, i, intrinsicMeasureScope.mo15540roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo15540roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        List<? extends IntrinsicMeasurable> listEmptyList2 = (List) CollectionsKt.firstOrNull((List) list);
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        return minIntrinsicMainAxisSize(listEmptyList2, i, intrinsicMeasureScope.mo15540roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo15540roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    public final int minIntrinsicMainAxisSize(@NotNull List<? extends IntrinsicMeasurable> measurables, int crossAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, @NotNull FlowLayoutOverflowState overflow) {
        return FlowLayoutKt.minIntrinsicMainAxisSize(measurables, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, crossAxisAvailable, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis, maxLines, overflow);
    }

    @Override // androidx.compose.p109ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        flowLayoutOverflowState.m15784setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3) : null, isHorizontal(), ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        if (isHorizontal()) {
            List<? extends IntrinsicMeasurable> listEmptyList = (List) CollectionsKt.firstOrNull((List) list);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return minIntrinsicMainAxisSize(listEmptyList, i, intrinsicMeasureScope.mo15540roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo15540roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        List<? extends IntrinsicMeasurable> listEmptyList2 = (List) CollectionsKt.firstOrNull((List) list);
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        return intrinsicCrossAxisSize(listEmptyList2, i, intrinsicMeasureScope.mo15540roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo15540roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("FlowMeasurePolicy(isHorizontal=");
        sb.append(this.isHorizontal);
        sb.append(", horizontalArrangement=");
        sb.append(this.horizontalArrangement);
        sb.append(", verticalArrangement=");
        sb.append(this.verticalArrangement);
        sb.append(", mainAxisSpacing=");
        AbstractC0622a.m1151A(sb, ", crossAxisAlignment=", this.mainAxisSpacing);
        sb.append(this.crossAxisAlignment);
        sb.append(", crossAxisArrangementSpacing=");
        AbstractC0622a.m1151A(sb, ", maxItemsInMainAxis=", this.crossAxisArrangementSpacing);
        sb.append(this.maxItemsInMainAxis);
        sb.append(", maxLines=");
        sb.append(this.maxLines);
        sb.append(", overflow=");
        sb.append(this.overflow);
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }

    private FlowMeasurePolicy(boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment, float f4, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState) {
        this.isHorizontal = z;
        this.horizontalArrangement = horizontal;
        this.verticalArrangement = vertical;
        this.mainAxisSpacing = f;
        this.crossAxisAlignment = crossAxisAlignment;
        this.crossAxisArrangementSpacing = f4;
        this.maxItemsInMainAxis = i;
        this.maxLines = i2;
        this.overflow = flowLayoutOverflowState;
        this.maxMainAxisIntrinsicItemSize = isHorizontal() ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$maxMainAxisIntrinsicItemSize$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i4, int i5) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i5));
            }
        } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$maxMainAxisIntrinsicItemSize$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i4, int i5) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i5));
            }
        };
        this.maxCrossAxisIntrinsicItemSize = isHorizontal() ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$maxCrossAxisIntrinsicItemSize$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i4, int i5) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i5));
            }
        } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$maxCrossAxisIntrinsicItemSize$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i4, int i5) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i5));
            }
        };
        this.minCrossAxisIntrinsicItemSize = isHorizontal() ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$minCrossAxisIntrinsicItemSize$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i4, int i5) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i5));
            }
        } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$minCrossAxisIntrinsicItemSize$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i4, int i5) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i5));
            }
        };
        this.minMainAxisIntrinsicItemSize = isHorizontal() ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$minMainAxisIntrinsicItemSize$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i4, int i5) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i5));
            }
        } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$minMainAxisIntrinsicItemSize$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i4, int i5) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i5));
            }
        };
    }
}
