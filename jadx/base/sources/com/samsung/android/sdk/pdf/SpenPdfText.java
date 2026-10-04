package com.samsung.android.sdk.pdf;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenPdfText;", "", "<init>", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "style", "Lcom/samsung/android/sdk/pdf/SpenPdfTextStyle;", "getStyle", "()Lcom/samsung/android/sdk/pdf/SpenPdfTextStyle;", "setStyle", "(Lcom/samsung/android/sdk/pdf/SpenPdfTextStyle;)V", "matrix", "", "getMatrix", "()[F", "setMatrix", "([F)V", "visibility", "", "getVisibility", "()Z", "setVisibility", "(Z)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPdfText {

    @Nullable
    private float[] matrix;

    @Nullable
    private SpenPdfTextStyle style;

    @Nullable
    private String text;
    private boolean visibility;

    @Nullable
    public final float[] getMatrix() {
        return this.matrix;
    }

    @Nullable
    public final SpenPdfTextStyle getStyle() {
        return this.style;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public final boolean getVisibility() {
        return this.visibility;
    }

    public final void setMatrix(@Nullable float[] fArr) {
        this.matrix = fArr;
    }

    public final void setStyle(@Nullable SpenPdfTextStyle spenPdfTextStyle) {
        this.style = spenPdfTextStyle;
    }

    public final void setText(@Nullable String str) {
        this.text = str;
    }

    public final void setVisibility(boolean z) {
        this.visibility = z;
    }
}
