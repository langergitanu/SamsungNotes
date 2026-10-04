package com.samsung.android.support.senl.p148nt.base.composer.text.checker.paragraph;

import com.samsung.android.sdk.pen.document.textspan.SpenAlignmentParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/text/checker/paragraph/AlignChecker;", "Lcom/samsung/android/support/senl/nt/base/composer/text/checker/paragraph/AbsParagraphChecker;", "selectionPStart", "", "selectionPEnd", "defaultAlign", "<init>", "(III)V", "before", "Lcom/samsung/android/sdk/pen/document/textspan/SpenAlignmentParagraph;", "getBefore", "()Lcom/samsung/android/sdk/pen/document/textspan/SpenAlignmentParagraph;", "setBefore", "(Lcom/samsung/android/sdk/pen/document/textspan/SpenAlignmentParagraph;)V", "checkParagraph", "paragraph", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "getResult", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AlignChecker extends AbsParagraphChecker {

    @Nullable
    private SpenAlignmentParagraph before;
    private final int defaultAlign;

    public AlignChecker(int i, int i2, int i4) {
        super(i, i2);
        this.defaultAlign = i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        if (r0.getAlignment() != r4.getAlignment()) goto L17;
     */
    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.checker.paragraph.AbsParagraphChecker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int checkParagraph(@NotNull SpenTextParagraphBase paragraph) {
        Intrinsics.checkNotNullParameter(paragraph, "paragraph");
        if (!getEnable()) {
            return 1;
        }
        if (paragraph.getStart() == getSelectionPStart()) {
            this.before = (SpenAlignmentParagraph) paragraph;
            return 1;
        }
        SpenAlignmentParagraph spenAlignmentParagraph = (SpenAlignmentParagraph) paragraph;
        if (this.before != null || spenAlignmentParagraph.getAlignment() == this.defaultAlign) {
            SpenAlignmentParagraph spenAlignmentParagraph2 = this.before;
            if (spenAlignmentParagraph2 != null) {
                Intrinsics.checkNotNull(spenAlignmentParagraph2);
            }
            this.before = spenAlignmentParagraph;
            return 1;
        }
        setEnable(false);
        return 0;
    }

    @Nullable
    public final SpenAlignmentParagraph getBefore() {
        return this.before;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.checker.paragraph.AbsParagraphChecker
    public int getResult() {
        if (!getEnable()) {
            return -1;
        }
        SpenAlignmentParagraph spenAlignmentParagraph = this.before;
        if (spenAlignmentParagraph == null) {
            return this.defaultAlign;
        }
        Intrinsics.checkNotNull(spenAlignmentParagraph);
        if (spenAlignmentParagraph.getEnd() != getSelectionPEnd()) {
            return -1;
        }
        SpenAlignmentParagraph spenAlignmentParagraph2 = this.before;
        Intrinsics.checkNotNull(spenAlignmentParagraph2);
        return spenAlignmentParagraph2.getAlignment();
    }

    public final void setBefore(@Nullable SpenAlignmentParagraph spenAlignmentParagraph) {
        this.before = spenAlignmentParagraph;
    }
}
