package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RenderEffect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.samsung.android.sesl.REImageFilter;
import com.samsung.android.sesl.renderEffectImageFilter.ImageFilterParams;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ImageScaleView extends ImageView {
    private float mImageRatio;
    private boolean mInvalidate;
    private int mMaxHeight;
    private int mOriginWidth;
    private FrameLayout.LayoutParams mParentParams;
    private Runnable updateBlurRunnable;

    public ImageScaleView(Context context) {
        this(context, null);
    }

    private void applyBlurEffect() {
        if (NotesUtils.isSupportREImageFilter) {
            if (this.mInvalidate) {
                post(this.updateBlurRunnable);
            } else {
                setRenderEffect(null);
            }
        }
    }

    public void initGravity() {
        FrameLayout.LayoutParams layoutParams = this.mParentParams;
        if (layoutParams != null) {
            layoutParams.gravity = 0;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mImageRatio > 0.0f) {
            int size = View.MeasureSpec.getSize(i);
            float f = size;
            float f4 = this.mImageRatio;
            int minimumHeight = (int) (f * f4);
            if (this.mOriginWidth <= 0) {
                this.mOriginWidth = size;
            }
            int i4 = this.mOriginWidth;
            int i5 = (int) (i4 * f4);
            int i6 = this.mMaxHeight;
            if (i5 > i6) {
                minimumHeight = (int) ((i6 / i4) * f);
            } else if (i5 < getMinimumHeight()) {
                minimumHeight = getMinimumHeight();
            }
            i2 = View.MeasureSpec.makeMeasureSpec(minimumHeight, 1073741824);
        }
        try {
            if (this.mParentParams == null) {
                this.mParentParams = (FrameLayout.LayoutParams) ((FrameLayout) getParent()).getLayoutParams();
            }
            this.mParentParams.gravity = 17;
        } catch (Exception unused) {
        }
        super.onMeasure(i, i2);
    }

    public void onViewRecycled() {
        if (NotesUtils.isSupportREImageFilter) {
            removeCallbacks(this.updateBlurRunnable);
        }
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i, int i2, int i4, int i5) {
        if (getDrawable() != null) {
            float intrinsicWidth = (i4 - i) / getDrawable().getIntrinsicWidth();
            Matrix imageMatrix = getImageMatrix();
            imageMatrix.setScale(intrinsicWidth, intrinsicWidth, 0.0f, 0.0f);
            setImageMatrix(imageMatrix);
            applyBlurEffect();
        }
        return super.setFrame(i, i2, i4, i5);
    }

    public void setInvalidate(boolean z) {
        this.mInvalidate = z;
    }

    @Override // android.widget.ImageView
    public void setMaxHeight(int i) {
        this.mMaxHeight = i;
    }

    public void setRatio(float f) {
        this.mImageRatio = f;
    }

    public ImageScaleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageScaleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mImageRatio = 0.0f;
        this.mInvalidate = false;
        this.updateBlurRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.view.ImageScaleView.1
            @Override // java.lang.Runnable
            public void run() {
                if (NotesUtils.isSupportREImageFilter) {
                    if (!ImageScaleView.this.mInvalidate) {
                        ImageScaleView.this.setRenderEffect(null);
                        return;
                    }
                    REImageFilter rEImageFilter = new REImageFilter();
                    ImageFilterParams.GradientBlur gradientBlur = new ImageFilterParams.GradientBlur();
                    gradientBlur.percent = 0.7f;
                    gradientBlur.pivotPercent = 0.5f;
                    rEImageFilter.setGradientBlur(gradientBlur);
                    rEImageFilter.setBlurRadius(150.0f);
                    rEImageFilter.setProportionalSaturation(0.4f);
                    rEImageFilter.setCurveLevel(15.0f);
                    rEImageFilter.setCurveMinX(0.0f);
                    rEImageFilter.setCurveMaxX(255.0f);
                    rEImageFilter.setCurveMinY(0.0f);
                    rEImageFilter.setCurveMaxY(180.0f);
                    RenderEffect renderEffectBuild = rEImageFilter.build(ImageScaleView.this.getWidth(), ImageScaleView.this.getHeight());
                    ImageScaleView.this.setLayerType(2, null);
                    ImageScaleView.this.setRenderEffect(renderEffectBuild);
                    ImageScaleView.this.invalidate();
                    rEImageFilter.clear();
                }
            }
        };
    }
}
