package com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.p137ui;

import androidx.annotation.ColorInt;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/ui/CapsuleColor;", "", "backgroundColor", "", "textColor", "pressedBackgroundColor", "pressedTextColor", "rippleColor", "(IIIII)V", "getBackgroundColor", "()I", "getPressedBackgroundColor", "getPressedTextColor", "getRippleColor", "getTextColor", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class CapsuleColor {
    private final int backgroundColor;
    private final int pressedBackgroundColor;
    private final int pressedTextColor;
    private final int rippleColor;
    private final int textColor;

    public CapsuleColor(@ColorInt int i, @ColorInt int i2, @ColorInt int i4, @ColorInt int i5, @ColorInt int i6) {
        this.backgroundColor = i;
        this.textColor = i2;
        this.pressedBackgroundColor = i4;
        this.pressedTextColor = i5;
        this.rippleColor = i6;
    }

    public static /* synthetic */ CapsuleColor copy$default(CapsuleColor capsuleColor, int i, int i2, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = capsuleColor.backgroundColor;
        }
        if ((i7 & 2) != 0) {
            i2 = capsuleColor.textColor;
        }
        if ((i7 & 4) != 0) {
            i4 = capsuleColor.pressedBackgroundColor;
        }
        if ((i7 & 8) != 0) {
            i5 = capsuleColor.pressedTextColor;
        }
        if ((i7 & 16) != 0) {
            i6 = capsuleColor.rippleColor;
        }
        int i8 = i6;
        int i9 = i4;
        return capsuleColor.copy(i, i2, i9, i5, i8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPressedBackgroundColor() {
        return this.pressedBackgroundColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPressedTextColor() {
        return this.pressedTextColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getRippleColor() {
        return this.rippleColor;
    }

    @NotNull
    public final CapsuleColor copy(@ColorInt int backgroundColor, @ColorInt int textColor, @ColorInt int pressedBackgroundColor, @ColorInt int pressedTextColor, @ColorInt int rippleColor) {
        return new CapsuleColor(backgroundColor, textColor, pressedBackgroundColor, pressedTextColor, rippleColor);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CapsuleColor)) {
            return false;
        }
        CapsuleColor capsuleColor = (CapsuleColor) other;
        return this.backgroundColor == capsuleColor.backgroundColor && this.textColor == capsuleColor.textColor && this.pressedBackgroundColor == capsuleColor.pressedBackgroundColor && this.pressedTextColor == capsuleColor.pressedTextColor && this.rippleColor == capsuleColor.rippleColor;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getPressedBackgroundColor() {
        return this.pressedBackgroundColor;
    }

    public final int getPressedTextColor() {
        return this.pressedTextColor;
    }

    public final int getRippleColor() {
        return this.rippleColor;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public int hashCode() {
        return Integer.hashCode(this.rippleColor) + AbstractC0622a.m1157c(this.pressedTextColor, AbstractC0622a.m1157c(this.pressedBackgroundColor, AbstractC0622a.m1157c(this.textColor, Integer.hashCode(this.backgroundColor) * 31, 31), 31), 31);
    }

    @NotNull
    public String toString() {
        int i = this.backgroundColor;
        int i2 = this.textColor;
        int i4 = this.pressedBackgroundColor;
        int i5 = this.pressedTextColor;
        int i6 = this.rippleColor;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "CapsuleColor(backgroundColor=", ", textColor=", ", pressedBackgroundColor=");
        AbstractC2821a.m2235z(sbM1173s, i4, i5, ", pressedTextColor=", ", rippleColor=");
        return AbstractC2821a.m2223n(sbM1173s, ")", i6);
    }
}
