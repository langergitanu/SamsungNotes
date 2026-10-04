package com.samsung.android.support.senl.p148nt.word.common;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\bJ\b\u0010+\u001a\u00020\u001dH\u0016R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/common/SpanAttributes;", "", "mStart", "", "mEnd", "<init>", "(II)V", "clone", "(IILcom/samsung/android/support/senl/nt/word/common/SpanAttributes;)V", "start", "getStart", "()I", "setStart", "(I)V", "end", "getEnd", "setEnd", "isBold", "", "()Z", "setBold", "(Z)V", "isItalic", "setItalic", "isUnderline", "setUnderline", "isStrikethrough", "setStrikethrough", "foregroundColor", "", "getForegroundColor", "()Ljava/lang/String;", "setForegroundColor", "(Ljava/lang/String;)V", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "fontSize", "", "getFontSize", "()D", "setFontSize", "(D)V", "toString", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpanAttributes {

    @Nullable
    private String backgroundColor;
    private int end;
    private double fontSize;

    @Nullable
    private String foregroundColor;
    private boolean isBold;
    private boolean isItalic;
    private boolean isStrikethrough;
    private boolean isUnderline;
    private int start;

    public SpanAttributes(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    @Nullable
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getEnd() {
        return this.end;
    }

    public final double getFontSize() {
        return this.fontSize;
    }

    @Nullable
    public final String getForegroundColor() {
        return this.foregroundColor;
    }

    public final int getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: isBold, reason: from getter */
    public final boolean getIsBold() {
        return this.isBold;
    }

    /* JADX INFO: renamed from: isItalic, reason: from getter */
    public final boolean getIsItalic() {
        return this.isItalic;
    }

    /* JADX INFO: renamed from: isStrikethrough, reason: from getter */
    public final boolean getIsStrikethrough() {
        return this.isStrikethrough;
    }

    /* JADX INFO: renamed from: isUnderline, reason: from getter */
    public final boolean getIsUnderline() {
        return this.isUnderline;
    }

    public final void setBackgroundColor(@Nullable String str) {
        this.backgroundColor = str;
    }

    public final void setBold(boolean z) {
        this.isBold = z;
    }

    public final void setEnd(int i) {
        this.end = i;
    }

    public final void setFontSize(double d) {
        this.fontSize = d;
    }

    public final void setForegroundColor(@Nullable String str) {
        this.foregroundColor = str;
    }

    public final void setItalic(boolean z) {
        this.isItalic = z;
    }

    public final void setStart(int i) {
        this.start = i;
    }

    public final void setStrikethrough(boolean z) {
        this.isStrikethrough = z;
    }

    public final void setUnderline(boolean z) {
        this.isUnderline = z;
    }

    @NotNull
    public String toString() {
        int i = this.start;
        int i2 = this.end;
        boolean z = this.isBold;
        boolean z2 = this.isItalic;
        boolean z3 = this.isUnderline;
        boolean z4 = this.isStrikethrough;
        String str = this.foregroundColor;
        String str2 = this.backgroundColor;
        double d = this.fontSize;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "SpanAttributes{mStart=", ", mEnd=", ", mIsBold=");
        AbstractC2821a.m2208C(sbM1173s, z, ", mIsItalic=", z2, ", mIsUnderline=");
        AbstractC2821a.m2208C(sbM1173s, z3, ", mIsStrikethrough=", z4, ", mForegroundColor='");
        AbstractC2821a.m2207B(sbM1173s, str, "', mBackgroundColor='", str2, "', mFontSize=");
        sbM1173s.append(d);
        sbM1173s.append("}");
        return sbM1173s.toString();
    }

    public SpanAttributes(int i, int i2, @NotNull SpanAttributes clone) {
        Intrinsics.checkNotNullParameter(clone, "clone");
        this.start = i;
        this.end = i2;
        this.isBold = clone.isBold;
        this.isItalic = clone.isItalic;
        this.isUnderline = clone.isUnderline;
        this.isStrikethrough = clone.isStrikethrough;
        this.fontSize = clone.fontSize;
        this.foregroundColor = clone.foregroundColor;
        this.backgroundColor = clone.backgroundColor;
    }
}
