package com.samsung.android.sdk.pen;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001a\u0010%\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u00100\"\u0004\b1\u00102¨\u00063"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/SpenSettingTextInfo;", "", "<init>", "()V", "color", "", "getColor", "()I", "setColor", "(I)V", "bgColor", "getBgColor", "setBgColor", "style", "getStyle", "setStyle", "size", "", "getSize", "()F", "setSize", "(F)V", "font", "", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "direction", "getDirection", "setDirection", "align", "getAlign", "setAlign", "lineSpacingType", "getLineSpacingType", "setLineSpacingType", "lineSpacing", "getLineSpacing", "setLineSpacing", "lineIndent", "getLineIndent", "setLineIndent", "bulletType", "getBulletType", "setBulletType", "isRTLmode", "", "()Z", "setRTLmode", "(Z)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingTextInfo {
    private int align;
    private int bgColor;
    private int bulletType;
    private int direction;
    private boolean isRTLmode;
    private int lineIndent;
    private int style;
    private int color = -16777216;
    private float size = 36.0f;

    @NotNull
    private String font = "Roboto-Regular";
    private int lineSpacingType = 1;
    private float lineSpacing = 1.3f;

    public final int getAlign() {
        return this.align;
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final int getBulletType() {
        return this.bulletType;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getDirection() {
        return this.direction;
    }

    @NotNull
    public final String getFont() {
        return this.font;
    }

    public final int getLineIndent() {
        return this.lineIndent;
    }

    public final float getLineSpacing() {
        return this.lineSpacing;
    }

    public final int getLineSpacingType() {
        return this.lineSpacingType;
    }

    public final float getSize() {
        return this.size;
    }

    public final int getStyle() {
        return this.style;
    }

    /* JADX INFO: renamed from: isRTLmode, reason: from getter */
    public final boolean getIsRTLmode() {
        return this.isRTLmode;
    }

    public final void setAlign(int i) {
        this.align = i;
    }

    public final void setBgColor(int i) {
        this.bgColor = i;
    }

    public final void setBulletType(int i) {
        this.bulletType = i;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final void setDirection(int i) {
        this.direction = i;
    }

    public final void setFont(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.font = str;
    }

    public final void setLineIndent(int i) {
        this.lineIndent = i;
    }

    public final void setLineSpacing(float f) {
        this.lineSpacing = f;
    }

    public final void setLineSpacingType(int i) {
        this.lineSpacingType = i;
    }

    public final void setRTLmode(boolean z) {
        this.isRTLmode = z;
    }

    public final void setSize(float f) {
        this.size = f;
    }

    public final void setStyle(int i) {
        this.style = i;
    }
}
