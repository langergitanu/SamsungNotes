package com.samsung.android.sdk.pen.setting.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J&\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0018\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u000eJ\u000e\u0010\"\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenGradientDrawableHelper;", "", "<init>", "()V", "mShape", "", "value", "color", "getColor", "()I", "mStrokeWidth", "strokeColor", "getStrokeColor", "mInitRadii", "", "mRectRadii", "", "setDrawableInfo", "", VMetaDataKey.META_KEY_SHAPE, "strokeWidth", "setRectRadius", "radius", "", "leftTop", "rightTop", "rightBottom", "leftBottom", "makeDrawable", "Landroid/graphics/drawable/GradientDrawable;", "setStroke", "drawable", "Landroid/graphics/drawable/Drawable;", "isShow", "applyRadius", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenGradientDrawableHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int color;
    private boolean mInitRadii;

    @NotNull
    private final float[] mRectRadii = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    private int mShape;
    private int mStrokeWidth;
    private int strokeColor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenGradientDrawableHelper$Companion;", "", "<init>", "()V", "setColor", "", "drawable", "Landroid/graphics/drawable/Drawable;", "color", "", "setRadius", "radius", "", "setRadii", "radii", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void setColor(@Nullable Drawable drawable, int color) {
            if (drawable == null || !(drawable instanceof GradientDrawable)) {
                return;
            }
            ((GradientDrawable) drawable).setColor(color);
        }

        @JvmStatic
        public final void setRadii(@Nullable Drawable drawable, @Nullable float[] radii) {
            if (drawable == null || !(drawable instanceof GradientDrawable)) {
                return;
            }
            ((GradientDrawable) drawable).setCornerRadii(radii);
        }

        @JvmStatic
        public final void setRadius(@Nullable Drawable drawable, float radius) {
            if (drawable == null || !(drawable instanceof GradientDrawable)) {
                return;
            }
            ((GradientDrawable) drawable).setCornerRadius(radius);
        }

        private Companion() {
        }
    }

    @JvmStatic
    public static final void setColor(@Nullable Drawable drawable, int i) {
        INSTANCE.setColor(drawable, i);
    }

    @JvmStatic
    public static final void setRadii(@Nullable Drawable drawable, @Nullable float[] fArr) {
        INSTANCE.setRadii(drawable, fArr);
    }

    @JvmStatic
    public static final void setRadius(@Nullable Drawable drawable, float f) {
        INSTANCE.setRadius(drawable, f);
    }

    public final void applyRadius(@NotNull GradientDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        drawable.setCornerRadii(this.mRectRadii);
    }

    public final int getColor() {
        return this.color;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    @NotNull
    public final GradientDrawable makeDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.color);
        gradientDrawable.setShape(this.mShape);
        gradientDrawable.setStroke(this.mStrokeWidth, this.strokeColor);
        if (this.mShape == 0 && this.mInitRadii) {
            gradientDrawable.setCornerRadii(this.mRectRadii);
        }
        return gradientDrawable;
    }

    public final void setDrawableInfo(int shape, int color, int strokeWidth, int strokeColor) {
        this.mShape = shape;
        this.color = color;
        this.mStrokeWidth = strokeWidth;
        this.strokeColor = strokeColor;
        this.mInitRadii = false;
    }

    public final void setRectRadius(float radius) {
        setRectRadius(radius, radius, radius, radius);
    }

    public final void setStroke(@Nullable Drawable drawable, boolean isShow) {
        if (drawable == null || !(drawable instanceof GradientDrawable)) {
            return;
        }
        if (isShow) {
            ((GradientDrawable) drawable).setStroke(this.mStrokeWidth, this.strokeColor);
        } else {
            ((GradientDrawable) drawable).setStroke(0, this.strokeColor);
        }
    }

    public final void setRectRadius(float leftTop, float rightTop, float rightBottom, float leftBottom) {
        this.mInitRadii = true;
        float[] fArr = this.mRectRadii;
        fArr[0] = leftTop;
        fArr[1] = leftTop;
        fArr[2] = rightTop;
        fArr[3] = rightTop;
        fArr[4] = rightBottom;
        fArr[5] = rightBottom;
        fArr[6] = leftBottom;
        fArr[7] = leftBottom;
    }
}
