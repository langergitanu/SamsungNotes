package com.samsung.android.sdk.pen.recogengine.hme;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0012J\u0006\u0010\u001b\u001a\u00020\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hme/SpenHmeRendererSettings;", "", "<init>", "()V", "textColor", "", "getTextColor", "()I", "setTextColor", "(I)V", "bgColor", "getBgColor", "setBgColor", "mOutline", "", "value", "outlineColor", "getOutlineColor", "", "outlineWidth", "getOutlineWidth", "()F", "setOutline", "", "outline", "color", "width", "hasOutline", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHmeRendererSettings {
    private int bgColor;
    private boolean mOutline;
    private int textColor = -16777216;
    private int outlineColor = -1;
    private float outlineWidth = 1.0f;

    public final int getBgColor() {
        return this.bgColor;
    }

    public final int getOutlineColor() {
        return this.outlineColor;
    }

    public final float getOutlineWidth() {
        return this.outlineWidth;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: hasOutline, reason: from getter */
    public final boolean getMOutline() {
        return this.mOutline;
    }

    public final void setBgColor(int i) {
        this.bgColor = i;
    }

    public final void setOutline(boolean outline, int color, float width) {
        this.mOutline = outline;
        this.outlineColor = color;
        this.outlineWidth = width;
    }

    public final void setTextColor(int i) {
        this.textColor = i;
    }
}
