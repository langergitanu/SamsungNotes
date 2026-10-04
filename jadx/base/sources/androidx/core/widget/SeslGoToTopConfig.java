package androidx.core.widget;

import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class SeslGoToTopConfig {

    @NonNull
    private Drawable mBackgroundBlur;
    private int mBackgroundColorBlur;

    @NonNull
    private Drawable mBackgroundDark;

    @NonNull
    private Drawable mBackgroundLight;
    private int mDefaultPaddingBottom;
    private float mElevation;

    @NonNull
    private Interpolator mFadeInInterpolator;

    @NonNull
    private Interpolator mFadeOutInterpolator;

    @NonNull
    private Drawable mIconDark;

    @NonNull
    private Drawable mIconLight;
    private boolean mIsDefaultPaddingBottomSet;
    private int mOverlayFeatureHiddenHeightPx;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mScrollToTopDurationMs;
    private int mSize;
    private boolean mSizeChanged;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private Drawable backgroundBlur;
        private int backgroundColorBlur;
        private Drawable backgroundDark;
        private Drawable backgroundLight;
        private float elevation;
        private Interpolator fadeInInterpolator;
        private Interpolator fadeOutInterpolator;
        private Drawable iconDark;
        private Drawable iconLight;
        private boolean isSizeChanged;
        private int overlayFeatureHiddenHeightPx;
        private int paddingBottom;
        private int paddingLeft;
        private int paddingRight;
        private int scrollToTopDurationMs;
        private int size;

        public SeslGoToTopConfig build() {
            Drawable drawable;
            Drawable drawable2;
            Drawable drawable3;
            Drawable drawable4;
            Interpolator interpolator;
            Drawable drawable5 = this.iconLight;
            if (drawable5 == null || (drawable = this.iconDark) == null || (drawable2 = this.backgroundLight) == null || (drawable3 = this.backgroundDark) == null || (drawable4 = this.backgroundBlur) == null) {
                throw new IllegalStateException("All drawables must be provided");
            }
            int i = this.backgroundColorBlur;
            if (i == -1) {
                throw new IllegalStateException("All colors must be provided");
            }
            Interpolator interpolator2 = this.fadeInInterpolator;
            if (interpolator2 == null || (interpolator = this.fadeOutInterpolator) == null) {
                throw new IllegalStateException("Fade interpolators must be provided");
            }
            int i2 = this.size;
            if (i2 <= 0) {
                throw new IllegalStateException("size must be > 0");
            }
            float f = this.elevation;
            if (f < 0.0f) {
                throw new IllegalStateException("elevation must be >= 0");
            }
            SeslGoToTopConfig seslGoToTopConfig = new SeslGoToTopConfig(drawable5, drawable, drawable2, drawable3, drawable4, i, this.paddingBottom, this.paddingLeft, this.paddingRight, i2, f, this.overlayFeatureHiddenHeightPx, this.isSizeChanged, interpolator2, interpolator);
            seslGoToTopConfig.mScrollToTopDurationMs = this.scrollToTopDurationMs;
            return seslGoToTopConfig;
        }

        public Builder setBackgroundBlur(Drawable drawable) {
            this.backgroundBlur = drawable;
            return this;
        }

        public Builder setBackgroundColorBlur(int i) {
            this.backgroundColorBlur = i;
            return this;
        }

        public Builder setBackgroundDark(Drawable drawable) {
            this.backgroundDark = drawable;
            return this;
        }

        public Builder setBackgroundLight(Drawable drawable) {
            this.backgroundLight = drawable;
            return this;
        }

        public Builder setElevation(float f) {
            this.elevation = f;
            return this;
        }

        public Builder setFadeInInterpolator(@NonNull Interpolator interpolator) {
            this.fadeInInterpolator = interpolator;
            return this;
        }

        public Builder setFadeOutInterpolator(@NonNull Interpolator interpolator) {
            this.fadeOutInterpolator = interpolator;
            return this;
        }

        public Builder setIconDark(Drawable drawable) {
            this.iconDark = drawable;
            return this;
        }

        public Builder setIconLight(Drawable drawable) {
            this.iconLight = drawable;
            return this;
        }

        public Builder setOverlayFeatureHiddenHeightPx(int i) {
            this.overlayFeatureHiddenHeightPx = i;
            return this;
        }

        public Builder setPaddingBottom(int i) {
            this.paddingBottom = i;
            return this;
        }

        public Builder setPaddingLeft(int i) {
            this.paddingLeft = i;
            return this;
        }

        public Builder setPaddingRight(int i) {
            this.paddingRight = i;
            return this;
        }

        public Builder setScrollToTopDurationMs(int i) {
            this.scrollToTopDurationMs = i;
            return this;
        }

        public Builder setSize(int i) {
            this.size = i;
            return this;
        }

        public Builder setSizeChanged(boolean z) {
            this.isSizeChanged = z;
            return this;
        }
    }

    @NonNull
    public Drawable getBackgroundBlur() {
        return this.mBackgroundBlur;
    }

    public int getBackgroundColorBlur() {
        return this.mBackgroundColorBlur;
    }

    @NonNull
    public Drawable getBackgroundDark() {
        return this.mBackgroundDark;
    }

    @NonNull
    public Drawable getBackgroundLight() {
        return this.mBackgroundLight;
    }

    public int getDefaultPaddingBottom() {
        return this.mDefaultPaddingBottom;
    }

    public float getElevation() {
        return this.mElevation;
    }

    @NonNull
    public Interpolator getFadeInInterpolator() {
        return this.mFadeInInterpolator;
    }

    @NonNull
    public Interpolator getFadeOutInterpolator() {
        return this.mFadeOutInterpolator;
    }

    @NonNull
    public Drawable getIcon(boolean z) {
        return z ? this.mIconLight : this.mIconDark;
    }

    @NonNull
    public Drawable getIconDark() {
        return this.mIconDark;
    }

    @NonNull
    public Drawable getIconLight() {
        return this.mIconLight;
    }

    public int getOverlayFeatureHiddenHeightPx() {
        return this.mOverlayFeatureHiddenHeightPx;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getScrollToTopDurationMs() {
        return this.mScrollToTopDurationMs;
    }

    public int getSize() {
        return this.mSize;
    }

    public boolean hasDefaultBottomPadding() {
        return this.mIsDefaultPaddingBottomSet;
    }

    public boolean isSizeChanged() {
        return this.mSizeChanged;
    }

    public void setBackgroundBlur(@NonNull Drawable drawable) {
        this.mBackgroundBlur = drawable;
    }

    public void setBackgroundDark(@NonNull Drawable drawable) {
        this.mBackgroundDark = drawable;
    }

    public void setBackgroundLight(@NonNull Drawable drawable) {
        this.mBackgroundLight = drawable;
    }

    public void setElevation(float f) {
        this.mElevation = f;
    }

    public void setIconDark(@NonNull Drawable drawable) {
        this.mIconDark = drawable;
    }

    public void setIconLight(@NonNull Drawable drawable) {
        this.mIconLight = drawable;
    }

    public void setOverlayFeatureHiddenHeightPx(int i) {
        this.mOverlayFeatureHiddenHeightPx = i;
    }

    public void setPaddingBottom(int i) {
        if (!this.mIsDefaultPaddingBottomSet) {
            this.mDefaultPaddingBottom = i;
            this.mIsDefaultPaddingBottomSet = true;
        }
        this.mPaddingBottom = i;
        this.mSizeChanged = true;
    }

    public void setPaddingLeft(int i) {
        this.mPaddingLeft = i;
        this.mSizeChanged = true;
    }

    public void setPaddingRight(int i) {
        this.mPaddingRight = i;
        this.mSizeChanged = true;
    }

    public void setSize(int i) {
        this.mSize = i;
        this.mSizeChanged = true;
    }

    public void setSizeChanged(boolean z) {
        this.mSizeChanged = z;
    }

    private SeslGoToTopConfig(@NonNull Drawable drawable, @NonNull Drawable drawable2, @NonNull Drawable drawable3, @NonNull Drawable drawable4, @NonNull Drawable drawable5, int i, int i2, int i4, int i5, int i6, float f, int i7, boolean z, @NonNull Interpolator interpolator, @NonNull Interpolator interpolator2) {
        this.mIconLight = drawable;
        this.mIconDark = drawable2;
        this.mBackgroundLight = drawable3;
        this.mBackgroundDark = drawable4;
        this.mBackgroundBlur = drawable5;
        this.mBackgroundColorBlur = i;
        this.mPaddingBottom = i2;
        this.mPaddingLeft = i4;
        this.mPaddingRight = i5;
        this.mDefaultPaddingBottom = i2;
        this.mIsDefaultPaddingBottomSet = true;
        this.mSize = i6;
        this.mElevation = f;
        this.mOverlayFeatureHiddenHeightPx = i7;
        this.mSizeChanged = z;
        this.mFadeInInterpolator = interpolator;
        this.mFadeOutInterpolator = interpolator2;
    }
}
