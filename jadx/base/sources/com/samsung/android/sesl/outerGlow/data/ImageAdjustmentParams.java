package com.samsung.android.sesl.outerGlow.data;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sesl/outerGlow/data/ImageAdjustmentParams;", "", "saturation", "", "brightness", "contrast", "(FFF)V", "getBrightness", "()F", "getContrast", "getSaturation", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class ImageAdjustmentParams {
    private final float brightness;
    private final float contrast;
    private final float saturation;

    public ImageAdjustmentParams() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    public static /* synthetic */ ImageAdjustmentParams copy$default(ImageAdjustmentParams imageAdjustmentParams, float f, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f = imageAdjustmentParams.saturation;
        }
        if ((i & 2) != 0) {
            f4 = imageAdjustmentParams.brightness;
        }
        if ((i & 4) != 0) {
            f5 = imageAdjustmentParams.contrast;
        }
        return imageAdjustmentParams.copy(f, f4, f5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getSaturation() {
        return this.saturation;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getBrightness() {
        return this.brightness;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getContrast() {
        return this.contrast;
    }

    @NotNull
    public final ImageAdjustmentParams copy(float saturation, float brightness, float contrast) {
        return new ImageAdjustmentParams(saturation, brightness, contrast);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageAdjustmentParams)) {
            return false;
        }
        ImageAdjustmentParams imageAdjustmentParams = (ImageAdjustmentParams) other;
        return Float.compare(this.saturation, imageAdjustmentParams.saturation) == 0 && Float.compare(this.brightness, imageAdjustmentParams.brightness) == 0 && Float.compare(this.contrast, imageAdjustmentParams.contrast) == 0;
    }

    public final float getBrightness() {
        return this.brightness;
    }

    public final float getContrast() {
        return this.contrast;
    }

    public final float getSaturation() {
        return this.saturation;
    }

    public int hashCode() {
        return Float.hashCode(this.contrast) + AbstractC0622a.m1156b(this.brightness, Float.hashCode(this.saturation) * 31, 31);
    }

    @NotNull
    public String toString() {
        float f = this.saturation;
        float f4 = this.brightness;
        return AbstractC1038a.m1217r(AbstractC0622a.m1176v("ImageAdjustmentParams(saturation=", f, ", brightness=", f4, ", contrast="), ")", this.contrast);
    }

    public ImageAdjustmentParams(float f, float f4, float f5) {
        this.saturation = f;
        this.brightness = f4;
        this.contrast = f5;
    }

    public /* synthetic */ ImageAdjustmentParams(float f, float f4, float f5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 0.0f : f4, (i & 4) != 0 ? 1.0f : f5);
    }
}
