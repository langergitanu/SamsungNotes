package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer;

import android.annotation.SuppressLint;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.support.senl.p148nt.base.composer.text.checker.paragraph.ParagraphChecker;
import com.samsung.android.support.senl.p148nt.base.composer.text.checker.span.SpanChecker;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtChecker {
    private final ParagraphChecker mParagraphChecker = new ParagraphChecker();
    private final SpanChecker mSpanChecker = new SpanChecker();
    private final Comparator<SpenTextSpanBase> mComparator = new Comparator<SpenTextSpanBase>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.composer.RtChecker.1
        @Override // java.util.Comparator
        public int compare(SpenTextSpanBase spenTextSpanBase, SpenTextSpanBase spenTextSpanBase2) {
            return spenTextSpanBase.getStart() - spenTextSpanBase2.getStart();
        }
    };

    @SuppressLint({"UseSparseArrays"})
    public int[] checkParagraph(SpenObjectShape spenObjectShape, int i, int i2, int i4) {
        return this.mParagraphChecker.checkParagraph(spenObjectShape, i, i2, i4);
    }

    public int checkSingleParagraphTask(SpenObjectShape spenObjectShape, int i, int i2) {
        return this.mParagraphChecker.checkSingleParagraphTask(spenObjectShape, i, i2);
    }

    @SuppressLint({"UseSparseArrays"})
    public SpanStates updateRtSpans(SpenObjectShape spenObjectShape, int i, SpanStates spanStates) {
        return this.mSpanChecker.updateRtSpans(spenObjectShape, i, spanStates);
    }

    @SuppressLint({"UseSparseArrays"})
    public SpanStates updateRtSpans(SpenObjectShape spenObjectShape, int i, int i2, SpanStates spanStates) {
        return this.mSpanChecker.updateRtSpans(spenObjectShape, i, i2, spanStates);
    }
}
