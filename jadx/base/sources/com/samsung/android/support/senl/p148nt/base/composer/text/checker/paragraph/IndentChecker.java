package com.samsung.android.support.senl.p148nt.base.composer.text.checker.paragraph;

import com.samsung.android.sdk.pen.document.textspan.SpenIndentLevelParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/text/checker/paragraph/IndentChecker;", "Lcom/samsung/android/support/senl/nt/base/composer/text/checker/paragraph/AbsParagraphChecker;", "selectionPStart", "", "selectionPEnd", "<init>", "(II)V", "indentLevel", "Ljava/lang/Integer;", "checkParagraph", "paragraph", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "getResult", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class IndentChecker extends AbsParagraphChecker {

    @Nullable
    private Integer indentLevel;

    public IndentChecker(int i, int i2) {
        super(i, i2);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.checker.paragraph.AbsParagraphChecker
    public int checkParagraph(@NotNull SpenTextParagraphBase paragraph) {
        Intrinsics.checkNotNullParameter(paragraph, "paragraph");
        if (!getEnable()) {
            return 1;
        }
        SpenIndentLevelParagraph spenIndentLevelParagraph = (SpenIndentLevelParagraph) paragraph;
        Integer num = this.indentLevel;
        if (num == null) {
            this.indentLevel = Integer.valueOf(spenIndentLevelParagraph.getIndentLevel());
            return 1;
        }
        int indentLevel = spenIndentLevelParagraph.getIndentLevel();
        if (num == null || num.intValue() != indentLevel) {
            this.indentLevel = 1;
            setEnable(false);
        }
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.checker.paragraph.AbsParagraphChecker
    public int getResult() {
        Integer num = this.indentLevel;
        if (num == null) {
            return 0;
        }
        Intrinsics.checkNotNull(num);
        return num.intValue();
    }
}
