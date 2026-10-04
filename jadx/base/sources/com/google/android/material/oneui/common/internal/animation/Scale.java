package com.google.android.material.oneui.common.internal.animation;

import androidx.collection.AbstractC0622a;
import kotlin.Metadata;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m13886d2 = {"Lcom/google/android/material/oneui/common/internal/animation/Scale;", "", "scaleX", "", "scaleY", "(FF)V", "getScaleX", "()F", "setScaleX", "(F)V", "getScaleY", "setScaleY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class Scale {
    private float scaleX;
    private float scaleY;

    public Scale(float f, float f4) {
        this.scaleX = f;
        this.scaleY = f4;
    }

    public static /* synthetic */ Scale copy$default(Scale scale, float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = scale.scaleX;
        }
        if ((i & 2) != 0) {
            f4 = scale.scaleY;
        }
        return scale.copy(f, f4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getScaleX() {
        return this.scaleX;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getScaleY() {
        return this.scaleY;
    }

    @NotNull
    public final Scale copy(float scaleX, float scaleY) {
        return new Scale(scaleX, scaleY);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Scale)) {
            return false;
        }
        Scale scale = (Scale) other;
        return Float.compare(this.scaleX, scale.scaleX) == 0 && Float.compare(this.scaleY, scale.scaleY) == 0;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public int hashCode() {
        return Float.hashCode(this.scaleY) + (Float.hashCode(this.scaleX) * 31);
    }

    public final void setScaleX(float f) {
        this.scaleX = f;
    }

    public final void setScaleY(float f) {
        this.scaleY = f;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("Scale(scaleX=");
        sb.append(this.scaleX);
        sb.append(", scaleY=");
        return AbstractC0622a.m1171q(sb, this.scaleY, PropertyUtils.MAPPED_DELIM2);
    }
}
