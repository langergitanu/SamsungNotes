package com.samsung.android.sdk.pen.setting.quicktool;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\b\u0080\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003JE\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001c\"\u0004\b\u001f\u0010\u001e¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenPenViewInfo;", "", "name", "", "color", "", "sizeLevel", "particleSize", "", "isFixedWidth", "", "isFixedOpacity", "<init>", "(Ljava/lang/String;IIFZZ)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getColor", "()I", "setColor", "(I)V", "getSizeLevel", "setSizeLevel", "getParticleSize", "()F", "setParticleSize", "(F)V", "()Z", "setFixedWidth", "(Z)V", "setFixedOpacity", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class SpenPenViewInfo {
    private int color;
    private boolean isFixedOpacity;
    private boolean isFixedWidth;

    @NotNull
    private String name;
    private float particleSize;
    private int sizeLevel;

    public SpenPenViewInfo(@NotNull String name, int i, int i2, float f, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.color = i;
        this.sizeLevel = i2;
        this.particleSize = f;
        this.isFixedWidth = z;
        this.isFixedOpacity = z2;
    }

    public static /* synthetic */ SpenPenViewInfo copy$default(SpenPenViewInfo spenPenViewInfo, String str, int i, int i2, float f, boolean z, boolean z2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = spenPenViewInfo.name;
        }
        if ((i4 & 2) != 0) {
            i = spenPenViewInfo.color;
        }
        if ((i4 & 4) != 0) {
            i2 = spenPenViewInfo.sizeLevel;
        }
        if ((i4 & 8) != 0) {
            f = spenPenViewInfo.particleSize;
        }
        if ((i4 & 16) != 0) {
            z = spenPenViewInfo.isFixedWidth;
        }
        if ((i4 & 32) != 0) {
            z2 = spenPenViewInfo.isFixedOpacity;
        }
        boolean z3 = z;
        boolean z4 = z2;
        return spenPenViewInfo.copy(str, i, i2, f, z3, z4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSizeLevel() {
        return this.sizeLevel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getParticleSize() {
        return this.particleSize;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsFixedWidth() {
        return this.isFixedWidth;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsFixedOpacity() {
        return this.isFixedOpacity;
    }

    @NotNull
    public final SpenPenViewInfo copy(@NotNull String name, int color, int sizeLevel, float particleSize, boolean isFixedWidth, boolean isFixedOpacity) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new SpenPenViewInfo(name, color, sizeLevel, particleSize, isFixedWidth, isFixedOpacity);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpenPenViewInfo)) {
            return false;
        }
        SpenPenViewInfo spenPenViewInfo = (SpenPenViewInfo) other;
        return Intrinsics.areEqual(this.name, spenPenViewInfo.name) && this.color == spenPenViewInfo.color && this.sizeLevel == spenPenViewInfo.sizeLevel && Float.compare(this.particleSize, spenPenViewInfo.particleSize) == 0 && this.isFixedWidth == spenPenViewInfo.isFixedWidth && this.isFixedOpacity == spenPenViewInfo.isFixedOpacity;
    }

    public final int getColor() {
        return this.color;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final float getParticleSize() {
        return this.particleSize;
    }

    public final int getSizeLevel() {
        return this.sizeLevel;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isFixedOpacity) + AbstractC0622a.m1160f(this.isFixedWidth, AbstractC0622a.m1156b(this.particleSize, AbstractC0622a.m1157c(this.sizeLevel, AbstractC0622a.m1157c(this.color, this.name.hashCode() * 31, 31), 31), 31), 31);
    }

    public final boolean isFixedOpacity() {
        return this.isFixedOpacity;
    }

    public final boolean isFixedWidth() {
        return this.isFixedWidth;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final void setFixedOpacity(boolean z) {
        this.isFixedOpacity = z;
    }

    public final void setFixedWidth(boolean z) {
        this.isFixedWidth = z;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setParticleSize(float f) {
        this.particleSize = f;
    }

    public final void setSizeLevel(int i) {
        this.sizeLevel = i;
    }

    @NotNull
    public String toString() {
        String str = this.name;
        int i = this.color;
        int i2 = this.sizeLevel;
        float f = this.particleSize;
        boolean z = this.isFixedWidth;
        boolean z2 = this.isFixedOpacity;
        StringBuilder sbM780v = AbstractC0541b.m780v("SpenPenViewInfo(name=", i, str, ", color=", ", sizeLevel=");
        sbM780v.append(i2);
        sbM780v.append(", particleSize=");
        sbM780v.append(f);
        sbM780v.append(", isFixedWidth=");
        sbM780v.append(z);
        sbM780v.append(", isFixedOpacity=");
        sbM780v.append(z2);
        sbM780v.append(")");
        return sbM780v.toString();
    }

    public /* synthetic */ SpenPenViewInfo(String str, int i, int i2, float f, boolean z, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, f, (i4 & 16) != 0 ? false : z, (i4 & 32) != 0 ? false : z2);
    }
}
