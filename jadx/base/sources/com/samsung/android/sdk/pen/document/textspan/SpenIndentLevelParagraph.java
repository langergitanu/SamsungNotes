package com.samsung.android.sdk.pen.document.textspan;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/textspan/SpenIndentLevelParagraph;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "<init>", "()V", "startPosition", "", "endPosition", "level", "(III)V", "indentLevel", "getIndentLevel", "()I", "setIndentLevel", "(I)V", "direction", "getDirection", "setDirection", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenIndentLevelParagraph extends SpenTextParagraphBase {
    public static final int DIRECTION_LTR = 1;
    public static final int DIRECTION_MAX = 3;
    public static final int DIRECTION_NONE = 0;
    public static final int DIRECTION_RTL = 2;
    private int direction;
    private int indentLevel;

    public SpenIndentLevelParagraph() {
        super(2);
        this.direction = 1;
    }

    public final int getDirection() {
        return this.direction;
    }

    public final int getIndentLevel() {
        return this.indentLevel;
    }

    public final void setDirection(int i) {
        this.direction = i;
    }

    public final void setIndentLevel(int i) {
        this.indentLevel = i;
    }

    public SpenIndentLevelParagraph(int i, int i2, int i4) {
        super(2, i, i2);
        this.direction = 1;
        this.indentLevel = i4;
    }
}
