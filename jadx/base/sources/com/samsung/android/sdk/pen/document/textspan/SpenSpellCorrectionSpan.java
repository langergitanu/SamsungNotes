package com.samsung.android.sdk.pen.document.textspan;

import androidx.annotation.ColorInt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B3\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0002\u0010\u000bR\u001e\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001b¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/textspan/SpenSpellCorrectionSpan;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "<init>", "()V", "startPosition", "", "endPosition", "expansionType", "underlineColor", "originalText", "", "(IIIILjava/lang/String;)V", "textColor", "getTextColor", "()I", "setTextColor", "(I)V", "getOriginalText", "()Ljava/lang/String;", "setOriginalText", "(Ljava/lang/String;)V", "getUnderlineColor", "setUnderlineColor", "isTextColorEnabled", "", "()Z", "setTextColorEnabled", "(Z)V", "isStrikeThroughEnabled", "setStrikeThroughEnabled", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSpellCorrectionSpan extends SpenTextSpanBase {
    private boolean isStrikeThroughEnabled;
    private boolean isTextColorEnabled;

    @NotNull
    private String originalText;

    @ColorInt
    private int textColor;

    @ColorInt
    private int underlineColor;

    public SpenSpellCorrectionSpan() {
        super(22);
        this.originalText = "";
    }

    @NotNull
    public final String getOriginalText() {
        return this.originalText;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getUnderlineColor() {
        return this.underlineColor;
    }

    /* JADX INFO: renamed from: isStrikeThroughEnabled, reason: from getter */
    public final boolean getIsStrikeThroughEnabled() {
        return this.isStrikeThroughEnabled;
    }

    /* JADX INFO: renamed from: isTextColorEnabled, reason: from getter */
    public final boolean getIsTextColorEnabled() {
        return this.isTextColorEnabled;
    }

    public final void setOriginalText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originalText = str;
    }

    public final void setStrikeThroughEnabled(boolean z) {
        this.isStrikeThroughEnabled = z;
    }

    public final void setTextColor(int i) {
        this.textColor = i;
    }

    public final void setTextColorEnabled(boolean z) {
        this.isTextColorEnabled = z;
    }

    public final void setUnderlineColor(int i) {
        this.underlineColor = i;
    }

    public SpenSpellCorrectionSpan(int i, int i2, int i4, int i5, @Nullable String str) {
        super(22, i, i2, i4);
        this.originalText = "";
        this.underlineColor = i5;
        Intrinsics.checkNotNull(str);
        this.originalText = str;
    }
}
