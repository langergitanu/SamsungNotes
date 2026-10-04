package com.samsung.android.support.senl.p148nt.base.composer.text.span;

import androidx.annotation.Size;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FontSize extends AbsStoredIntegerSpan {
    public static final int DEFAULT_CELL_FONT_SIZE = 15;
    public static final int DEFAULT_FONT_MIN_SIZE = 1;
    public static final int DEFAULT_FONT_SIZE = 15;
    public static final int INVALID_FONT_SIZE = -1;
    protected int deltaSize;

    public FontSize(String str, String str2, int i) {
        super(str, str2, 15);
        this.deltaSize = i;
        setEnable(false);
    }

    private int getWithinMin(int i) {
        int i2 = this.deltaSize;
        return i + i2 < 1 ? 1 - i2 : i;
    }

    public void applySPenSpan(@Size(2) int[] iArr, SpenObjectShape spenObjectShape) {
        spenObjectShape.appendTextSpan(new SpenFontSizeSpan(iArr[0], iArr[1], 3, getValue()));
    }

    public int getDefaultValue() {
        return 15;
    }

    public int getDeltaSize() {
        return this.deltaSize;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsStoredIntegerSpan, com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public int getValue() {
        try {
            return getWithinMin(getStoredSpan());
        } catch (Exception unused) {
            return 15;
        }
    }

    public int getViewValue() {
        return getDeltaSize() + getValue();
    }

    public void reset() {
        setValue(getDefaultValue());
    }

    public FontSize(String str, String str2, int i, int i2) {
        super(str, str2, i2);
        this.deltaSize = i;
        setEnable(false);
    }
}
