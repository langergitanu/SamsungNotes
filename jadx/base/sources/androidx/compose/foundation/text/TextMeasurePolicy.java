package androidx.compose.foundation.text;

import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003¢\u0006\u0002\u0010\bJ,\u0010\t\u001a\u00020\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/foundation/text/TextMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "placements", "", "Landroidx/compose/ui/geometry/Rect;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBasicText.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicText.kt\nandroidx/compose/foundation/text/TextMeasurePolicy\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,606:1\n235#2,3:607\n33#2,4:610\n238#2,2:614\n38#2:616\n240#2:617\n298#2,3:618\n69#2,4:621\n301#2:625\n302#2:628\n74#2:629\n303#2:630\n235#2,3:631\n33#2,4:634\n238#2,2:638\n38#2:640\n240#2:641\n26#3:626\n1#4:627\n*S KotlinDebug\n*F\n+ 1 BasicText.kt\nandroidx/compose/foundation/text/TextMeasurePolicy\n*L\n382#1:607,3\n382#1:610,4\n382#1:614,2\n382#1:616\n382#1:617\n385#1:618,3\n385#1:621,4\n385#1:625\n385#1:628\n385#1:629\n385#1:630\n402#1:631,3\n402#1:634,4\n402#1:638,2\n402#1:640\n402#1:641\n396#1:626\n385#1:627\n*E\n"})
final class TextMeasurePolicy implements MeasurePolicy {

    @NotNull
    private final Function0<List<Rect>> placements;

    @NotNull
    private final Function0<Boolean> shouldMeasureLinks;

    /* JADX WARN: Multi-variable type inference failed */
    public TextMeasurePolicy(@NotNull Function0<Boolean> function0, @NotNull Function0<? extends List<Rect>> function02) {
        this.shouldMeasureLinks = function0;
        this.placements = function02;
    }

    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = list.get(i);
            if (!(measurable.getParentData() instanceof TextRangeLayoutModifier)) {
                arrayList.add(measurable);
            }
        }
        List<Rect> listInvoke = this.placements.invoke();
        final ArrayList arrayList2 = null;
        if (listInvoke != null) {
            ArrayList arrayList3 = new ArrayList(listInvoke.size());
            int size2 = listInvoke.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Rect rect = listInvoke.get(i2);
                Pair pair = rect != null ? new Pair(((Measurable) arrayList.get(i2)).mo19855measureBRTryo0(ConstraintsKt.Constraints$default(0, (int) Math.floor(rect.getWidth()), 0, (int) Math.floor(rect.getHeight()), 5, null)), IntOffset.m21087boximpl(IntOffsetKt.IntOffset(Math.round(rect.getLeft()), Math.round(rect.getTop())))) : null;
                if (pair != null) {
                    arrayList3.add(pair);
                }
            }
            arrayList2 = arrayList3;
        }
        ArrayList arrayList4 = new ArrayList(list.size());
        int size3 = list.size();
        for (int i4 = 0; i4 < size3; i4++) {
            Measurable measurable2 = list.get(i4);
            if (measurable2.getParentData() instanceof TextRangeLayoutModifier) {
                arrayList4.add(measurable2);
            }
        }
        final List listMeasureWithTextRangeMeasureConstraints = BasicTextKt.measureWithTextRangeMeasureConstraints(arrayList4, this.shouldMeasureLinks);
        return MeasureScope.layout$default(measureScope, Constraints.m20921getMaxWidthimpl(j), Constraints.m20920getMaxHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.TextMeasurePolicy$measure$1
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
                List<Pair<Placeable, IntOffset>> list2 = arrayList2;
                if (list2 != null) {
                    int size4 = list2.size();
                    for (int i5 = 0; i5 < size4; i5++) {
                        Pair<Placeable, IntOffset> pair2 = list2.get(i5);
                        Placeable.PlacementScope.m19919place70tqf50$default(placementScope, pair2.component1(), pair2.component2().getPackedValue(), 0.0f, 2, null);
                    }
                }
                List<Pair<Placeable, Function0<IntOffset>>> list3 = listMeasureWithTextRangeMeasureConstraints;
                if (list3 != null) {
                    int size5 = list3.size();
                    for (int i6 = 0; i6 < size5; i6++) {
                        Pair<Placeable, Function0<IntOffset>> pair3 = list3.get(i6);
                        Placeable placeableComponent1 = pair3.component1();
                        Function0<IntOffset> function0Component2 = pair3.component2();
                        Placeable.PlacementScope.m19919place70tqf50$default(placementScope, placeableComponent1, function0Component2 != null ? function0Component2.invoke().getPackedValue() : IntOffset.INSTANCE.m21106getZeronOccac(), 0.0f, 2, null);
                    }
                }
            }
        }, 4, null);
    }
}
