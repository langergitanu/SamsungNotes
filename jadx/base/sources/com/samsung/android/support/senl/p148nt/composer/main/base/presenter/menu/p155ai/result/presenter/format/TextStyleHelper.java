package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format;

import androidx.annotation.Size;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenAlignmentParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenBackgroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenBoldSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenForegroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenIndentLevelParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenItalicSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenUnderlineSpan;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Task;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TextStyleHelper {
    SpenObjectTextBox mObjectTextBox;

    public TextStyleHelper(SpenObjectTextBox spenObjectTextBox) {
        this.mObjectTextBox = spenObjectTextBox;
    }

    public SpenObjectTextBox getObjectTextBox() {
        return this.mObjectTextBox;
    }

    public void removeIndent(@Size(2) int[] iArr) {
        int[] paragraphIndex = TextUtil.getParagraphIndex(this.mObjectTextBox, iArr);
        this.mObjectTextBox.removeTextParagraph(new SpenIndentLevelParagraph(paragraphIndex[0], paragraphIndex[1], 1));
    }

    public void removeTask(@Size(2) int[] iArr) {
        Task task = new Task();
        task.setValue(8);
        this.mObjectTextBox.removeTextParagraph(task.getSPenSpan(TextUtil.getParagraphIndex(this.mObjectTextBox, iArr)));
    }

    public void setAlign(int i, @Size(2) int[] iArr) {
        int[] paragraphIndex = TextUtil.getParagraphIndex(this.mObjectTextBox, iArr);
        this.mObjectTextBox.appendTextParagraph(new SpenAlignmentParagraph(paragraphIndex[0], paragraphIndex[1], i));
    }

    public void setBold(boolean z, @Size(2) int[] iArr) {
        this.mObjectTextBox.appendTextSpan(new SpenBoldSpan(iArr[0], iArr[1], 3, z));
    }

    public void setFontSize(int i, @Size(2) int[] iArr) {
        this.mObjectTextBox.appendTextSpan(new SpenFontSizeSpan(iArr[0], iArr[1], 3, i));
    }

    public void setIndent(@Size(2) int[] iArr) {
        int[] paragraphIndex = TextUtil.getParagraphIndex(this.mObjectTextBox, iArr);
        this.mObjectTextBox.appendTextParagraph(new SpenIndentLevelParagraph(paragraphIndex[0], paragraphIndex[1], 1));
    }

    public void setItalic(boolean z, @Size(2) int[] iArr) {
        this.mObjectTextBox.appendTextSpan(new SpenItalicSpan(iArr[0], iArr[1], 3, z));
    }

    public void setTask(@Size(2) int[] iArr) {
        Task task = new Task();
        task.setValue(8);
        this.mObjectTextBox.appendTextParagraph(task.getSPenSpan(TextUtil.getParagraphIndex(this.mObjectTextBox, iArr)));
    }

    public void setTextBgColor(int i, @Size(2) int[] iArr) {
        this.mObjectTextBox.appendTextSpan(new SpenBackgroundColorSpan(iArr[0], iArr[1], 3, i));
    }

    public void setTextColor(int i, @Size(2) int[] iArr) {
        this.mObjectTextBox.appendTextSpan(new SpenForegroundColorSpan(iArr[0], iArr[1], 3, i));
    }

    public void setUnderline(boolean z, @Size(2) int[] iArr) {
        this.mObjectTextBox.appendTextSpan(new SpenUnderlineSpan(iArr[0], iArr[1], 3, z));
    }
}
