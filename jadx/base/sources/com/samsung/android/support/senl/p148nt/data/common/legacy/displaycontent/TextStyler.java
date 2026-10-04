package com.samsung.android.support.senl.p148nt.data.common.legacy.displaycontent;

import android.text.Editable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.samsung.android.sdk.composer.document.sdoc.textspan.SpenTextSpan;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TextStyler {
    private final Editable mEditable;
    private final boolean mIsLastContent;

    public TextStyler(Editable editable, boolean z) {
        this.mEditable = editable;
        this.mIsLastContent = z;
    }

    private int getEndIndex(int i) {
        return (this.mIsLastContent || i != this.mEditable.length() + (-1)) ? i : i + 1;
    }

    private void setBackgroundColor(int i, int i2, int i4) {
        this.mEditable.setSpan(new BackgroundColorSpan(i), i2, i4, 33);
    }

    private void setBold(int i, int i2) {
        this.mEditable.setSpan(new StyleSpan(1), i, i2, 33);
    }

    private void setForegroundColor(int i, int i2, int i4) {
        this.mEditable.setSpan(new ForegroundColorSpan(i), i2, i4, 33);
    }

    private void setItalic(int i, int i2) {
        this.mEditable.setSpan(new StyleSpan(2), i, i2, 33);
    }

    private void setUnderLine(int i, int i2) {
        this.mEditable.setSpan(new UnderlineSpan(), i, i2, 33);
    }

    public void setTextStyle(SpenTextSpan spenTextSpan, int i, int i2) {
        int type = spenTextSpan.getType();
        if (type == 19) {
            setBackgroundColor(spenTextSpan.getBackgroundColor(), i, getEndIndex(i2));
            return;
        }
        switch (type) {
            case 11:
                setBold(i, i2);
                break;
            case 12:
                setItalic(i, i2);
                break;
            case 13:
                setUnderLine(i, i2);
                break;
            case 14:
                setForegroundColor(spenTextSpan.getForegroundColor(), i, getEndIndex(i2));
                break;
        }
    }
}
