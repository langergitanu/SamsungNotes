package com.samsung.android.app.sdk.deepsky.textextraction.translate.data.p138ui;

import android.text.Layout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, m13886d2 = {"getExplicitAlignment", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ui/ExplicitLayoutAlignment;", "Landroid/text/Layout;", "getLineExplicitAlignment", "line", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAccurateWidthTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccurateWidthTextView.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ui/AccurateWidthTextViewKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,135:1\n1603#2,9:136\n1855#2:145\n1856#2:147\n1612#2:148\n1#3:146\n*S KotlinDebug\n*F\n+ 1 AccurateWidthTextView.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ui/AccurateWidthTextViewKt\n*L\n107#1:136,9\n107#1:145\n107#1:147\n107#1:148\n107#1:146\n*E\n"})
public final class AccurateWidthTextViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ExplicitLayoutAlignment getExplicitAlignment(Layout layout) {
        if (layout.getLineCount() == 0) {
            return ExplicitLayoutAlignment.LEFT;
        }
        IntRange intRangeUntil = RangesKt.until(0, layout.getLineCount());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            ExplicitLayoutAlignment lineExplicitAlignment = getLineExplicitAlignment(layout, ((IntIterator) it).nextInt());
            if (lineExplicitAlignment != null) {
                arrayList.add(lineExplicitAlignment);
            }
        }
        List listDistinct = CollectionsKt.distinct(arrayList);
        if (listDistinct.size() > 1) {
            return ExplicitLayoutAlignment.MIXED;
        }
        ExplicitLayoutAlignment explicitLayoutAlignment = (ExplicitLayoutAlignment) CollectionsKt.firstOrNull(listDistinct);
        return explicitLayoutAlignment == null ? ExplicitLayoutAlignment.LEFT : explicitLayoutAlignment;
    }

    private static final ExplicitLayoutAlignment getLineExplicitAlignment(Layout layout, int i) {
        if (i < 0 || i >= layout.getLineCount()) {
            return null;
        }
        boolean z = layout.getParagraphDirection(i) == 1;
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i);
        return Intrinsics.areEqual(paragraphAlignment.name(), LayoutAlignmentName.ALIGN_RIGHT) ? ExplicitLayoutAlignment.RIGHT : Intrinsics.areEqual(paragraphAlignment.name(), LayoutAlignmentName.ALIGN_LEFT) ? ExplicitLayoutAlignment.LEFT : paragraphAlignment == Layout.Alignment.ALIGN_CENTER ? ExplicitLayoutAlignment.CENTER : (z && paragraphAlignment == Layout.Alignment.ALIGN_NORMAL) ? ExplicitLayoutAlignment.LEFT : (z && paragraphAlignment == Layout.Alignment.ALIGN_OPPOSITE) ? ExplicitLayoutAlignment.RIGHT : paragraphAlignment == Layout.Alignment.ALIGN_NORMAL ? ExplicitLayoutAlignment.RIGHT : ExplicitLayoutAlignment.LEFT;
    }
}
