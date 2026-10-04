package com.samsung.android.support.senl.p148nt.word.common;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/common/ParagraphAttributes;", "", "<init>", "()V", "indentLevel", "", "getIndentLevel", "()I", "setIndentLevel", "(I)V", "align", "getAlign", "setAlign", "bulletType", "getBulletType", "setBulletType", "isChecked", "", "()Z", "setChecked", "(Z)V", "bulletNumber", "getBulletNumber", "setBulletNumber", "fontSize", "getFontSize", "setFontSize", "foregroundColor", "", "getForegroundColor", "()Ljava/lang/String;", "setForegroundColor", "(Ljava/lang/String;)V", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ParagraphAttributes {
    private int align;
    private int bulletNumber;
    private int bulletType;
    private int fontSize;

    @Nullable
    private String foregroundColor;
    private int indentLevel;
    private boolean isChecked;

    public final int getAlign() {
        return this.align;
    }

    public final int getBulletNumber() {
        return this.bulletNumber;
    }

    public final int getBulletType() {
        return this.bulletType;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    @Nullable
    public final String getForegroundColor() {
        return this.foregroundColor;
    }

    public final int getIndentLevel() {
        return this.indentLevel;
    }

    /* JADX INFO: renamed from: isChecked, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    public final void setAlign(int i) {
        this.align = i;
    }

    public final void setBulletNumber(int i) {
        this.bulletNumber = i;
    }

    public final void setBulletType(int i) {
        this.bulletType = i;
    }

    public final void setChecked(boolean z) {
        this.isChecked = z;
    }

    public final void setFontSize(int i) {
        this.fontSize = i;
    }

    public final void setForegroundColor(@Nullable String str) {
        this.foregroundColor = str;
    }

    public final void setIndentLevel(int i) {
        this.indentLevel = i;
    }
}
