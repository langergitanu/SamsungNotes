package androidx.compose.foundation.layout;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\b\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J,\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m13886d2 = {"Landroidx/compose/foundation/layout/BoxMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "alignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "(Landroidx/compose/ui/Alignment;Z)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Box.kt\nandroidx/compose/foundation/layout/BoxMeasurePolicy\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,339:1\n69#2,6:340\n69#2,6:346\n*S KotlinDebug\n*F\n+ 1 Box.kt\nandroidx/compose/foundation/layout/BoxMeasurePolicy\n*L\n171#1:340,6\n191#1:346,6\n*E\n"})
final /* data */ class BoxMeasurePolicy implements MeasurePolicy {

    @NotNull
    private final Alignment alignment;
    private final boolean propagateMinConstraints;

    public BoxMeasurePolicy(@NotNull Alignment alignment, boolean z) {
        this.alignment = alignment;
        this.propagateMinConstraints = z;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final Alignment getAlignment() {
        return this.alignment;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final boolean getPropagateMinConstraints() {
        return this.propagateMinConstraints;
    }

    public static /* synthetic */ BoxMeasurePolicy copy$default(BoxMeasurePolicy boxMeasurePolicy, Alignment alignment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            alignment = boxMeasurePolicy.alignment;
        }
        if ((i & 2) != 0) {
            z = boxMeasurePolicy.propagateMinConstraints;
        }
        return boxMeasurePolicy.copy(alignment, z);
    }

    @NotNull
    public final BoxMeasurePolicy copy(@NotNull Alignment alignment, boolean propagateMinConstraints) {
        return new BoxMeasurePolicy(alignment, propagateMinConstraints);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxMeasurePolicy)) {
            return false;
        }
        BoxMeasurePolicy boxMeasurePolicy = (BoxMeasurePolicy) other;
        return Intrinsics.areEqual(this.alignment, boxMeasurePolicy.alignment) && this.propagateMinConstraints == boxMeasurePolicy.propagateMinConstraints;
    }

    public int hashCode() {
        return Boolean.hashCode(this.propagateMinConstraints) + (this.alignment.hashCode() * 31);
    }

    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo15214measure3p2s80s(@NotNull final MeasureScope measureScope, @NotNull final List<? extends Measurable> list, long j) {
        long j2;
        int iM20923getMinWidthimpl;
        int iM20922getMinHeightimpl;
        Placeable placeableMo19855measureBRTryo0;
        if (list.isEmpty()) {
            return MeasureScope.layout$default(measureScope, Constraints.m20923getMinWidthimpl(j), Constraints.m20922getMinHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$1
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
        if (this.propagateMinConstraints) {
            j2 = j;
        } else {
            j2 = j;
            j = Constraints.m20912copyZbe2FdA$default(j2, 0, 0, 0, 0, 10, null);
        }
        if (list.size() == 1) {
            final Measurable measurable = list.get(0);
            if (BoxKt.getMatchesParentSize(measurable)) {
                iM20923getMinWidthimpl = Constraints.m20923getMinWidthimpl(j2);
                iM20922getMinHeightimpl = Constraints.m20922getMinHeightimpl(j2);
                placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(Constraints.INSTANCE.m20931fixedJhjzzOo(Constraints.m20923getMinWidthimpl(j2), Constraints.m20922getMinHeightimpl(j2)));
            } else {
                placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(j);
                iM20923getMinWidthimpl = Math.max(Constraints.m20923getMinWidthimpl(j2), placeableMo19855measureBRTryo0.getWidth());
                iM20922getMinHeightimpl = Math.max(Constraints.m20922getMinHeightimpl(j2), placeableMo19855measureBRTryo0.getHeight());
            }
            final Placeable placeable = placeableMo19855measureBRTryo0;
            final int i = iM20923getMinWidthimpl;
            final int i2 = iM20922getMinHeightimpl;
            return MeasureScope.layout$default(measureScope, i, i2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$2
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
                    BoxKt.placeInBox(placementScope, placeable, measurable, measureScope.getLayoutDirection(), i, i2, this.alignment);
                }
            }, 4, null);
        }
        final Placeable[] placeableArr = new Placeable[list.size()];
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = Constraints.m20923getMinWidthimpl(j2);
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = Constraints.m20922getMinHeightimpl(j2);
        int size = list.size();
        boolean z = false;
        for (int i4 = 0; i4 < size; i4++) {
            Measurable measurable2 = list.get(i4);
            if (BoxKt.getMatchesParentSize(measurable2)) {
                z = true;
            } else {
                Placeable placeableMo19855measureBRTryo02 = measurable2.mo19855measureBRTryo0(j);
                placeableArr[i4] = placeableMo19855measureBRTryo02;
                intRef.element = Math.max(intRef.element, placeableMo19855measureBRTryo02.getWidth());
                intRef2.element = Math.max(intRef2.element, placeableMo19855measureBRTryo02.getHeight());
            }
        }
        if (z) {
            int i5 = intRef.element;
            int i6 = i5 != Integer.MAX_VALUE ? i5 : 0;
            int i7 = intRef2.element;
            long jConstraints = ConstraintsKt.Constraints(i6, i5, i7 != Integer.MAX_VALUE ? i7 : 0, i7);
            int size2 = list.size();
            for (int i8 = 0; i8 < size2; i8++) {
                Measurable measurable3 = list.get(i8);
                if (BoxKt.getMatchesParentSize(measurable3)) {
                    placeableArr[i8] = measurable3.mo19855measureBRTryo0(jConstraints);
                }
            }
        }
        return MeasureScope.layout$default(measureScope, intRef.element, intRef2.element, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$5
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
                Placeable[] placeableArr2 = placeableArr;
                List<Measurable> list2 = list;
                MeasureScope measureScope2 = measureScope;
                Ref.IntRef intRef3 = intRef;
                Ref.IntRef intRef4 = intRef2;
                BoxMeasurePolicy boxMeasurePolicy = this;
                int length = placeableArr2.length;
                int i9 = 0;
                int i10 = 0;
                while (i9 < length) {
                    Placeable placeable2 = placeableArr2[i9];
                    Intrinsics.checkNotNull(placeable2, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
                    BoxKt.placeInBox(placementScope, placeable2, list2.get(i10), measureScope2.getLayoutDirection(), intRef3.element, intRef4.element, boxMeasurePolicy.alignment);
                    i9++;
                    i10++;
                }
            }
        }, 4, null);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("BoxMeasurePolicy(alignment=");
        sb.append(this.alignment);
        sb.append(", propagateMinConstraints=");
        return AbstractC0622a.m1172r(sb, this.propagateMinConstraints, PropertyUtils.MAPPED_DELIM2);
    }
}
