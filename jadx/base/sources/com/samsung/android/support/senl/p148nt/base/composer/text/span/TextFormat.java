package com.samsung.android.support.senl.p148nt.base.composer.text.span;

import androidx.annotation.Size;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenBoldSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenLineSpacingParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenPredefinedStyleParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TextFormat extends AbsIntegerSpan {
    public static final int TEXT_FORMAT_BODY_1 = 3;
    public static final int TEXT_FORMAT_BODY_2 = -1;
    public static final int TEXT_FORMAT_HEADING_1 = 0;
    public static final int TEXT_FORMAT_HEADING_2 = 1;
    public static final int TEXT_FORMAT_HEADING_3 = 2;
    public static final int TEXT_FORMAT_NONE = -1;
    public static final int[] TEXT_FORMAT_TYPES = {0, 1, 2, 3, -1};

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FormatType {
    }

    public TextFormat() {
        super(-1);
    }

    private int getFollowingType(int i) {
        if (i == 0 || i == 1 || i == 2) {
            return 3;
        }
        return i;
    }

    private int[] getTextIndexFromParagraphIndex(SpenObjectShape spenObjectShape, int i, int i2) {
        int[] iArr = {0, 0};
        String text = spenObjectShape.getText();
        int length = text != null ? text.length() : 0;
        if (length > 0) {
            iArr[1] = length - 1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = text.charAt(i5);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i4++;
                if (i4 == i) {
                    iArr[0] = i5;
                }
                if (i4 == i2) {
                    iArr[1] = i5 - 1;
                    return iArr;
                }
            }
        }
        return iArr;
    }

    private boolean isValidValue() {
        if (this.value == -1) {
            return false;
        }
        for (int i : TEXT_FORMAT_TYPES) {
            if (i == this.value) {
                return true;
            }
        }
        return false;
    }

    public SpenPredefinedStyleParagraph getSPenParagraph(@Size(2) int[] iArr) {
        if (!isValidValue()) {
            return null;
        }
        int value = getValue();
        return new SpenPredefinedStyleParagraph(iArr[0], iArr[1], value, getFollowingType(value));
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public /* bridge */ /* synthetic */ int getType() {
        return super.getType();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public int getValue() {
        return this.value;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsSpan
    public /* bridge */ /* synthetic */ boolean isEnable() {
        return super.isEnable();
    }

    public void reset() {
        setValue(-1);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsSpan
    public /* bridge */ /* synthetic */ void setEnable(boolean z) {
        super.setEnable(z);
    }

    public void setTextFormatBody2Style(SpenObjectShape spenObjectShape, int i, int i2) {
        spenObjectShape.removeTextParagraph(i, i2, 1024);
        spenObjectShape.removeTextParagraph(i, i2, 768);
        String text = spenObjectShape.getText();
        int[] textIndexFromParagraphIndex = getTextIndexFromParagraphIndex(spenObjectShape, i, i2);
        int i4 = i > 0 ? textIndexFromParagraphIndex[0] + 1 : textIndexFromParagraphIndex[0];
        int iMin = Math.min(textIndexFromParagraphIndex[1] + 1, text != null ? text.length() : 0);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(new SpenFontSizeSpan(i4, iMin, 3, 17.0f));
        arrayList.add(new SpenBoldSpan(i4, iMin, 3, false));
        arrayList2.add(new SpenLineSpacingParagraph(i, i2, 1, 1.35f));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            spenObjectShape.appendTextSpan((SpenTextSpanBase) it.next());
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            spenObjectShape.appendTextParagraph((SpenTextParagraphBase) it2.next());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public /* bridge */ /* synthetic */ void setValue(int i) {
        super.setValue(i);
    }

    public TextFormat(int i) {
        super(i);
    }
}
