package com.samsung.android.sdk.pen.engine.pointericon;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u0000J8\u0010'\u001a\u00020\u001d2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001a\u0010$\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/pointericon/PenIcon;", "", "<init>", "()V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "size", "", "getSize", "()F", "setSize", "(F)V", "isFixedWidth", "", "()Z", "setFixedWidth", "(Z)V", "particleSize", "getParticleSize", "setParticleSize", "style", "getStyle", "setStyle", "equals", "obj", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class PenIcon {
    private int color;

    @Nullable
    private Drawable drawable;
    private boolean isFixedWidth;

    @Nullable
    private String name;
    private float particleSize;
    private float size;
    private int style;

    public final boolean equals(@NotNull PenIcon obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        String str = this.name;
        if (str == null || obj.name == null) {
            return false;
        }
        Intrinsics.checkNotNull(str);
        String str2 = obj.name;
        Intrinsics.checkNotNull(str2);
        return str.compareTo(str2) == 0 && this.color == obj.color && this.size == obj.size && this.isFixedWidth == obj.isFixedWidth && this.particleSize == obj.particleSize && this.style == obj.style;
    }

    public final int getColor() {
        return this.color;
    }

    @Nullable
    public final Drawable getDrawable() {
        return this.drawable;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final float getParticleSize() {
        return this.particleSize;
    }

    public final float getSize() {
        return this.size;
    }

    public final int getStyle() {
        return this.style;
    }

    /* JADX INFO: renamed from: isFixedWidth, reason: from getter */
    public final boolean getIsFixedWidth() {
        return this.isFixedWidth;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final void setDrawable(@Nullable Drawable drawable) {
        this.drawable = drawable;
    }

    public final void setFixedWidth(boolean z) {
        this.isFixedWidth = z;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setParticleSize(float f) {
        this.particleSize = f;
    }

    public final void setSize(float f) {
        this.size = f;
    }

    public final void setStyle(int i) {
        this.style = i;
    }

    public final boolean equals(@Nullable String name, int color, float size, boolean isFixedWidth, float particleSize, int style) {
        String str = this.name;
        if (str == null || name == null) {
            return false;
        }
        Intrinsics.checkNotNull(str);
        return str.compareTo(name) == 0 && this.color == color && this.size == size && this.isFixedWidth == isFixedWidth && this.particleSize == particleSize && this.style == style;
    }
}
