package com.samsung.android.support.senl.p145cm.base.framework.view;

import android.view.SemBlurInfo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataPredefinedShape;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/SemBlurInfoCompat;", "", "<init>", "()V", "Companion", "Builder", "ColorCurve", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SemBlurInfoCompat {
    public static final int BLUR_MODE_CANVAS = 2;
    public static final int BLUR_MODE_WINDOW = 0;
    public static final int BLUR_UI_LOW_REGULAR_DARK = 118;
    public static final int BLUR_UI_LOW_REGULAR_LIGHT = 103;
    public static final int BLUR_UI_MEDIUM_ULTRA_THICK_DARK = 125;
    public static final int BLUR_UI_MEDIUM_ULTRA_THICK_LIGHT = 110;
    private static final int FLAG_SET_BACKGROUND_BLUR_COLOR = 16;
    private static final int FLAG_SET_BACKGROUND_BLUR_CORNER_RADIUS = 8;
    private static final int FLAG_SET_BLUR_RADIUS = 2;
    private static final int FLAG_SET_COLOR_CURVE = 4;
    private static final int FLAG_SET_PRESET = 1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003J6\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/SemBlurInfoCompat$Builder;", "", "blurMode", "", "<init>", "(I)V", "builderFieldsSet", "colorCurvePreset", "blurRadius", "cornerRadius", "", "backgroundColor", "colorCurve", "Lcom/samsung/android/support/senl/cm/base/framework/view/SemBlurInfoCompat$ColorCurve;", "setColorCurvePreset", "setRadius", "setColorCurve", "saturation", VMetaDataPredefinedShape.CURVE, "minX", "maxX", "minY", "maxY", "setBackgroundCornerRadius", "setBackgroundColor", "build", "Landroid/view/SemBlurInfo;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Builder {
        private int backgroundColor;
        private int blurMode;
        private int blurRadius;
        private int builderFieldsSet;

        @Nullable
        private ColorCurve colorCurve;
        private int colorCurvePreset;
        private float cornerRadius;

        public Builder(int i) {
            this.blurMode = i;
        }

        @NotNull
        public final SemBlurInfo build() {
            ColorCurve colorCurve;
            SemBlurInfo.Builder builder = new SemBlurInfo.Builder(this.blurMode);
            if ((this.builderFieldsSet & 1) != 0) {
                builder.setColorCurvePreset(this.colorCurvePreset);
            }
            if ((this.builderFieldsSet & 2) != 0) {
                builder.setRadius(this.blurRadius);
            }
            if ((this.builderFieldsSet & 4) != 0 && (colorCurve = this.colorCurve) != null) {
                builder.setColorCurve(colorCurve.getSaturation(), colorCurve.getCurve(), colorCurve.getMinX(), colorCurve.getMaxX(), colorCurve.getMinY(), colorCurve.getMaxY());
            }
            if ((this.builderFieldsSet & 8) != 0) {
                builder.setBackgroundCornerRadius(this.cornerRadius);
            }
            if ((this.builderFieldsSet & 16) != 0) {
                builder.setBackgroundColor(this.backgroundColor);
            }
            SemBlurInfo semBlurInfoBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(semBlurInfoBuild, "build(...)");
            return semBlurInfoBuild;
        }

        @NotNull
        public final Builder setBackgroundColor(int backgroundColor) {
            this.builderFieldsSet |= 16;
            this.backgroundColor = backgroundColor;
            return this;
        }

        @NotNull
        public final Builder setBackgroundCornerRadius(float cornerRadius) {
            this.builderFieldsSet |= 8;
            this.cornerRadius = cornerRadius;
            return this;
        }

        @NotNull
        public final Builder setColorCurve(float saturation, float curve, float minX, float maxX, float minY, float maxY) {
            this.builderFieldsSet |= 4;
            this.colorCurve = new ColorCurve(saturation, curve, minX, maxX, minY, maxY);
            return this;
        }

        @NotNull
        public final Builder setColorCurvePreset(int colorCurvePreset) {
            this.builderFieldsSet |= 1;
            this.colorCurvePreset = colorCurvePreset;
            return this;
        }

        @NotNull
        public final Builder setRadius(int blurRadius) {
            this.builderFieldsSet |= 2;
            this.blurRadius = blurRadius;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/SemBlurInfoCompat$ColorCurve;", "", "saturation", "", VMetaDataPredefinedShape.CURVE, "minX", "maxX", "minY", "maxY", "<init>", "(FFFFFF)V", "getSaturation", "()F", "setSaturation", "(F)V", "getCurve", "setCurve", "getMinX", "setMinX", "getMaxX", "setMaxX", "getMinY", "setMinY", "getMaxY", "setMaxY", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ColorCurve {
        private float curve;
        private float maxX;
        private float maxY;
        private float minX;
        private float minY;
        private float saturation;

        public ColorCurve(float f, float f4, float f5, float f6, float f7, float f8) {
            this.saturation = f;
            this.curve = f4;
            this.minX = f5;
            this.maxX = f6;
            this.minY = f7;
            this.maxY = f8;
        }

        public final float getCurve() {
            return this.curve;
        }

        public final float getMaxX() {
            return this.maxX;
        }

        public final float getMaxY() {
            return this.maxY;
        }

        public final float getMinX() {
            return this.minX;
        }

        public final float getMinY() {
            return this.minY;
        }

        public final float getSaturation() {
            return this.saturation;
        }

        public final void setCurve(float f) {
            this.curve = f;
        }

        public final void setMaxX(float f) {
            this.maxX = f;
        }

        public final void setMaxY(float f) {
            this.maxY = f;
        }

        public final void setMinX(float f) {
            this.minX = f;
        }

        public final void setMinY(float f) {
            this.minY = f;
        }

        public final void setSaturation(float f) {
            this.saturation = f;
        }
    }
}
