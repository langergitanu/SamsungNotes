package com.samsung.android.support.senl.p148nt.base.composer.text.span;

import androidx.annotation.Size;
import com.samsung.android.sdk.pen.document.textspan.SpenAlignmentParagraph;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class Alignment extends AbsStoredIntegerSpan {
    public static final int ALIGN_CENTER = 2;
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_NONE = -1;
    public static final int ALIGN_RIGHT = 1;
    private int mAlign;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AlignType {
    }

    public Alignment(String str, String str2) {
        super(str, str2, getDefaultAlign());
        this.mAlign = -1;
    }

    private static boolean checkValid(int i) {
        return i == 0 || i == 1 || i == 2;
    }

    public static int getDefaultAlign() {
        return LocaleUtils.isRTLMode() ? 1 : 0;
    }

    public static int getStoredValue(String str, String str2) {
        try {
            int storedSpan = AbsStoredIntegerSpan.getStoredSpan(str, str2);
            return !checkValid(storedSpan) ? getDefaultAlign() : storedSpan;
        } catch (NoSuchElementException unused) {
            return getDefaultAlign();
        }
    }

    public SpenAlignmentParagraph getSPenSpan(@Size(2) int[] iArr) {
        return new SpenAlignmentParagraph(iArr[0], iArr[1], getValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsStoredIntegerSpan, com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public int getValue() {
        if (this.mAlign == -1) {
            try {
                int storedSpan = getStoredSpan();
                this.mAlign = storedSpan;
                if (!checkValid(storedSpan)) {
                    this.mAlign = getDefaultAlign();
                }
            } catch (NoSuchElementException unused) {
                return getDefaultAlign();
            }
        }
        return this.mAlign;
    }

    public boolean isCenter() {
        return 2 == getValue();
    }

    public boolean isLeft() {
        return getValue() == 0;
    }

    public boolean isRight() {
        return 1 == getValue();
    }

    public void reset() {
        setValue(getDefaultAlign());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsStoredIntegerSpan, com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public void setValue(int i) {
        this.mAlign = i;
        super.setValue(i);
    }

    public Alignment(String str, String str2, int i) {
        super(str, str2, getDefaultAlign());
        this.mAlign = -1;
        setValue(i);
    }
}
