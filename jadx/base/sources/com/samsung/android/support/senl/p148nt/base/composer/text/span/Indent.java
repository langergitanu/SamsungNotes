package com.samsung.android.support.senl.p148nt.base.composer.text.span;

import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenIndentLevelParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class Indent extends AbsIntegerSpan {
    private static final int DEFAULT = 0;
    private static final String TAG = Logger.createTag("Indent");
    private int indentMax;

    public Indent(int i) {
        this(i, 0);
    }

    public void appendIndentParagraph(int[] iArr, SpenObjectShape spenObjectShape, boolean z, int i, SpenIndentLevelParagraph[] spenIndentLevelParagraphArr) {
        int i2;
        int i4 = iArr[0];
        if (i4 >= 0 && (i2 = iArr[1]) >= 0 && spenIndentLevelParagraphArr.length >= i4 && spenIndentLevelParagraphArr.length >= i2) {
            spenObjectShape.adjustIndentLevelParagraph(i4, i2, z ? 1 : -1, i, this.indentMax);
            return;
        }
        Logger.m8698e(TAG, "out of array index " + iArr[0] + " and " + iArr[1] + " from " + spenIndentLevelParagraphArr.length);
    }

    public int getIndentMax() {
        return this.indentMax;
    }

    @NonNull
    public SpenIndentLevelParagraph[] getSpenIndentLevelParagraphs(int[] iArr, SpenObjectShape spenObjectShape) {
        ArrayList<SpenTextParagraphBase> textParagraph = spenObjectShape.getTextParagraph();
        SpenIndentLevelParagraph[] spenIndentLevelParagraphArr = new SpenIndentLevelParagraph[iArr[1]];
        if (textParagraph != null) {
            for (SpenTextParagraphBase spenTextParagraphBase : textParagraph) {
                if (spenTextParagraphBase.getType() == 2 && spenTextParagraphBase.getEnd() > iArr[0] && spenTextParagraphBase.getStart() < iArr[1]) {
                    spenIndentLevelParagraphArr[spenTextParagraphBase.getStart()] = (SpenIndentLevelParagraph) spenTextParagraphBase;
                }
            }
        }
        return spenIndentLevelParagraphArr;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public /* bridge */ /* synthetic */ int getType() {
        return super.getType();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public /* bridge */ /* synthetic */ int getValue() {
        return super.getValue();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsSpan
    public /* bridge */ /* synthetic */ boolean isEnable() {
        return super.isEnable();
    }

    public void reset() {
        setValue(0);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsSpan
    public /* bridge */ /* synthetic */ void setEnable(boolean z) {
        super.setEnable(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public /* bridge */ /* synthetic */ void setValue(int i) {
        super.setValue(i);
    }

    public Indent(int i, int i2) {
        super(i2);
        this.indentMax = i;
    }
}
