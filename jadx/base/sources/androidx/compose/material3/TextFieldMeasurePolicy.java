package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p109ui.layout.AlignmentLineKt;
import androidx.compose.p109ui.layout.IntrinsicMeasurable;
import androidx.compose.p109ui.layout.IntrinsicMeasureScope;
import androidx.compose.p109ui.layout.LayoutIdKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J<\u0010\u0011\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\"\u0010\u0014\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u0015\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J/\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u001f\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, m13886d2 = {"Landroidx/compose/material3/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
final class TextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;

    @NotNull
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public TextFieldMeasurePolicy(boolean z, float f, @NotNull PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        this.singleLine = z;
        this.animationProgress = f;
        this.paddingValues = paddingValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        Object next4;
        List<? extends IntrinsicMeasurable> list2 = list;
        for (Object obj2 : list2) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), "TextField")) {
                int iIntValue = function2.invoke(obj2, Integer.valueOf(i)).intValue();
                Iterator<T> it = list2.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), "Label")) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) next;
                int iIntValue2 = intrinsicMeasurable != null ? function2.invoke(intrinsicMeasurable, Integer.valueOf(i)).intValue() : 0;
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next2), "Trailing")) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) next2;
                int iIntValue3 = intrinsicMeasurable2 != null ? function2.invoke(intrinsicMeasurable2, Integer.valueOf(i)).intValue() : 0;
                Iterator<T> it3 = list2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next3), "Leading")) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) next3;
                int iIntValue4 = intrinsicMeasurable3 != null ? function2.invoke(intrinsicMeasurable3, Integer.valueOf(i)).intValue() : 0;
                Iterator<T> it4 = list2.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        next4 = null;
                        break;
                    }
                    next4 = it4.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next4), "Hint")) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) next4;
                int iIntValue5 = intrinsicMeasurable4 != null ? function2.invoke(intrinsicMeasurable4, Integer.valueOf(i)).intValue() : 0;
                Iterator<T> it5 = list2.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next5 = it5.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next5), TextFieldImplKt.SupportingId)) {
                        obj = next5;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) obj;
                return TextFieldKt.m17392calculateHeightjCXOeKk(iIntValue, iIntValue2 > 0, iIntValue2, iIntValue4, iIntValue3, iIntValue5, intrinsicMeasurable5 != null ? function2.invoke(intrinsicMeasurable5, Integer.valueOf(i)).intValue() : 0, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> measurables, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        List<? extends IntrinsicMeasurable> list = measurables;
        for (Object obj2 : list) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), "TextField")) {
                int iIntValue = intrinsicMeasurer.invoke(obj2, Integer.valueOf(height)).intValue();
                Iterator<T> it = list.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), "Label")) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) next;
                int iIntValue2 = intrinsicMeasurable != null ? intrinsicMeasurer.invoke(intrinsicMeasurable, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next2), "Trailing")) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) next2;
                int iIntValue3 = intrinsicMeasurable2 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable2, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next3), "Leading")) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) next3;
                int iIntValue4 = intrinsicMeasurable3 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable3, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it4 = list.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Object next4 = it4.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next4), "Hint")) {
                        obj = next4;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj;
                return TextFieldKt.m17393calculateWidthVsPV1Ek(iIntValue4, iIntValue3, iIntValue, iIntValue2, intrinsicMeasurable4 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable4, Integer.valueOf(height)).intValue() : 0, TextFieldImplKt.getZeroConstraints());
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, measurables, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy.maxIntrinsicHeight.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i2));
            }
        });
    }

    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(measurables, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy.maxIntrinsicWidth.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i2));
            }
        });
    }

    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> measurables, long j) {
        Object next;
        Object next2;
        long j2;
        Placeable placeableMo19855measureBRTryo0;
        List<? extends Measurable> list;
        Object next3;
        int height;
        Object next4;
        Object next5;
        final TextFieldMeasurePolicy textFieldMeasurePolicy = this;
        final MeasureScope measure = measureScope;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        int iMo15540roundToPx0680j_4 = measure.mo15540roundToPx0680j_4(textFieldMeasurePolicy.paddingValues.getTop());
        int iMo15540roundToPx0680j_42 = measure.mo15540roundToPx0680j_4(textFieldMeasurePolicy.paddingValues.getBottom());
        final int iMo15540roundToPx0680j_43 = measure.mo15540roundToPx0680j_4(TextFieldKt.getTextFieldTopPadding());
        long jM20912copyZbe2FdA$default = Constraints.m20912copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> list2 = measurables;
        Iterator<T> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next), "Leading")) {
                break;
            }
        }
        Measurable measurable = (Measurable) next;
        Placeable placeableMo19855measureBRTryo02 = measurable != null ? measurable.mo19855measureBRTryo0(jM20912copyZbe2FdA$default) : null;
        int iWidthOrZero = TextFieldImplKt.widthOrZero(placeableMo19855measureBRTryo02);
        int iMax = Math.max(0, TextFieldImplKt.heightOrZero(placeableMo19855measureBRTryo02));
        Iterator<T> it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next2), "Trailing")) {
                break;
            }
        }
        Measurable measurable2 = (Measurable) next2;
        if (measurable2 != null) {
            j2 = jM20912copyZbe2FdA$default;
            placeableMo19855measureBRTryo0 = measurable2.mo19855measureBRTryo0(ConstraintsKt.m20941offsetNN6EwU$default(jM20912copyZbe2FdA$default, -iWidthOrZero, 0, 2, null));
        } else {
            j2 = jM20912copyZbe2FdA$default;
            placeableMo19855measureBRTryo0 = null;
        }
        int iWidthOrZero2 = TextFieldImplKt.widthOrZero(placeableMo19855measureBRTryo0) + iWidthOrZero;
        int iMax2 = Math.max(iMax, TextFieldImplKt.heightOrZero(placeableMo19855measureBRTryo0));
        int i = -iWidthOrZero2;
        final Placeable placeable = placeableMo19855measureBRTryo02;
        long jM20940offsetNN6EwU = ConstraintsKt.m20940offsetNN6EwU(j2, i, -iMo15540roundToPx0680j_42);
        Iterator<T> it3 = list2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                list = list2;
                next3 = null;
                break;
            }
            next3 = it3.next();
            list = list2;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next3), "Label")) {
                break;
            }
            list2 = list;
        }
        Measurable measurable3 = (Measurable) next3;
        Placeable placeableMo19855measureBRTryo03 = measurable3 != null ? measurable3.mo19855measureBRTryo0(jM20940offsetNN6EwU) : null;
        if (placeableMo19855measureBRTryo03 != null) {
            height = placeableMo19855measureBRTryo03.get(AlignmentLineKt.getLastBaseline());
            if (height == Integer.MIN_VALUE) {
                height = placeableMo19855measureBRTryo03.getHeight();
            }
        } else {
            height = 0;
        }
        final int iMax3 = Math.max(height, iMo15540roundToPx0680j_4);
        int i2 = placeableMo19855measureBRTryo03 != null ? iMax3 + iMo15540roundToPx0680j_43 : iMo15540roundToPx0680j_4;
        final Placeable placeable2 = placeableMo19855measureBRTryo03;
        long jM20940offsetNN6EwU2 = ConstraintsKt.m20940offsetNN6EwU(Constraints.m20912copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null), i, (-i2) - iMo15540roundToPx0680j_42);
        Iterator<T> it4 = list.iterator();
        while (true) {
            final int i4 = iMo15540roundToPx0680j_4;
            if (!it4.hasNext()) {
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            Measurable measurable4 = (Measurable) it4.next();
            final int i5 = height;
            final Placeable placeable3 = placeableMo19855measureBRTryo0;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), "TextField")) {
                final Placeable placeableMo19855measureBRTryo04 = measurable4.mo19855measureBRTryo0(jM20940offsetNN6EwU2);
                long jM20912copyZbe2FdA$default2 = Constraints.m20912copyZbe2FdA$default(jM20940offsetNN6EwU2, 0, 0, 0, 0, 14, null);
                Iterator it5 = list.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        next4 = null;
                        break;
                    }
                    next4 = it5.next();
                    Iterator it6 = it5;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next4), "Hint")) {
                        break;
                    }
                    it5 = it6;
                }
                Measurable measurable5 = (Measurable) next4;
                Placeable placeableMo19855measureBRTryo05 = measurable5 != null ? measurable5.mo19855measureBRTryo0(jM20912copyZbe2FdA$default2) : null;
                long jM20912copyZbe2FdA$default3 = Constraints.m20912copyZbe2FdA$default(ConstraintsKt.m20941offsetNN6EwU$default(j2, 0, -Math.max(iMax2, Math.max(TextFieldImplKt.heightOrZero(placeableMo19855measureBRTryo04), TextFieldImplKt.heightOrZero(placeableMo19855measureBRTryo05)) + i2 + iMo15540roundToPx0680j_42), 1, null), 0, 0, 0, 0, 11, null);
                Iterator<T> it7 = list.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        next5 = null;
                        break;
                    }
                    next5 = it7.next();
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next5), TextFieldImplKt.SupportingId)) {
                        break;
                    }
                }
                Measurable measurable6 = (Measurable) next5;
                Placeable placeableMo19855measureBRTryo06 = measurable6 != null ? measurable6.mo19855measureBRTryo0(jM20912copyZbe2FdA$default3) : null;
                int iHeightOrZero = TextFieldImplKt.heightOrZero(placeableMo19855measureBRTryo06);
                final int iM17393calculateWidthVsPV1Ek = TextFieldKt.m17393calculateWidthVsPV1Ek(TextFieldImplKt.widthOrZero(placeable), TextFieldImplKt.widthOrZero(placeable3), placeableMo19855measureBRTryo04.getWidth(), TextFieldImplKt.widthOrZero(placeable2), TextFieldImplKt.widthOrZero(placeableMo19855measureBRTryo05), j);
                final int iM17392calculateHeightjCXOeKk = TextFieldKt.m17392calculateHeightjCXOeKk(placeableMo19855measureBRTryo04.getHeight(), placeable2 != null, iMax3, TextFieldImplKt.heightOrZero(placeable), TextFieldImplKt.heightOrZero(placeable3), TextFieldImplKt.heightOrZero(placeableMo19855measureBRTryo05), TextFieldImplKt.heightOrZero(placeableMo19855measureBRTryo06), j, measure.getDensity(), textFieldMeasurePolicy.paddingValues);
                int i6 = iM17392calculateHeightjCXOeKk - iHeightOrZero;
                for (Measurable measurable7 : list) {
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable7), TextFieldImplKt.ContainerId)) {
                        final Placeable placeableMo19855measureBRTryo07 = measurable7.mo19855measureBRTryo0(ConstraintsKt.Constraints(iM17393calculateWidthVsPV1Ek != Integer.MAX_VALUE ? iM17393calculateWidthVsPV1Ek : 0, iM17393calculateWidthVsPV1Ek, i6 != Integer.MAX_VALUE ? i6 : 0, i6));
                        final Placeable placeable4 = placeableMo19855measureBRTryo06;
                        final Placeable placeable5 = placeableMo19855measureBRTryo05;
                        return MeasureScope.layout$default(measureScope, iM17393calculateWidthVsPV1Ek, iM17392calculateHeightjCXOeKk, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$measure$1
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
                                if (placeable2 == null) {
                                    TextFieldKt.placeWithoutLabel(layout, iM17393calculateWidthVsPV1Ek, iM17392calculateHeightjCXOeKk, placeableMo19855measureBRTryo04, placeable5, placeable, placeable3, placeableMo19855measureBRTryo07, placeable4, textFieldMeasurePolicy.singleLine, measure.getDensity(), textFieldMeasurePolicy.paddingValues);
                                    return;
                                }
                                int iCoerceAtLeast = RangesKt.coerceAtLeast(i4 - i5, 0);
                                TextFieldKt.placeWithLabel(layout, iM17393calculateWidthVsPV1Ek, iM17392calculateHeightjCXOeKk, placeableMo19855measureBRTryo04, placeable2, placeable5, placeable, placeable3, placeableMo19855measureBRTryo07, placeable4, textFieldMeasurePolicy.singleLine, iCoerceAtLeast, iMo15540roundToPx0680j_43 + iMax3, textFieldMeasurePolicy.animationProgress, measure.getDensity());
                            }
                        }, 4, null);
                    }
                    textFieldMeasurePolicy = this;
                    measure = measureScope;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            textFieldMeasurePolicy = this;
            measure = measureScope;
            iMo15540roundToPx0680j_4 = i4;
            height = i5;
            placeableMo19855measureBRTryo0 = placeable3;
        }
    }

    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, measurables, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy.minIntrinsicHeight.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i2));
            }
        });
    }

    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(measurables, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy.minIntrinsicWidth.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i2));
            }
        });
    }
}
