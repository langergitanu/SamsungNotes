package com.samsung.android.sdk.pdf;

import androidx.annotation.ColorInt;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenPdfTextStyle;", "", "<init>", "()V", "fontSize", "", "getFontSize", "()D", "setFontSize", "(D)V", "color", "", "getColor", "()I", "setColor", "(I)V", "isBold", "", "()Z", "setBold", "(Z)V", "isItalic", "setItalic", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPdfTextStyle {

    @ColorInt
    private int color;
    private double fontSize;
    private boolean isBold;
    private boolean isItalic;

    public final int getColor() {
        return this.color;
    }

    public final double getFontSize() {
        return this.fontSize;
    }

    /* JADX INFO: renamed from: isBold, reason: from getter */
    public final boolean getIsBold() {
        return this.isBold;
    }

    /* JADX INFO: renamed from: isItalic, reason: from getter */
    public final boolean getIsItalic() {
        return this.isItalic;
    }

    public final void setBold(boolean z) {
        this.isBold = z;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final void setFontSize(double d) {
        this.fontSize = d;
    }

    public final void setItalic(boolean z) {
        this.isItalic = z;
    }
}
