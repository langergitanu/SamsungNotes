package com.samsung.android.sesl.extendImage;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class ExpandTuneData {
    private float mBitmapShaderScale;
    private float mBlurRadius;
    private float mEdgeAnalysisRatio;
    private float mGradientAnalysisRatio;
    private int mGradientSampleCount;
    private float mMaxOutpaintingTransitionDepth;
    boolean mNeedInvalidate;
    private float mOutpaintingAlphaCurve;
    private PathInterpolator mOutpaintingPathInterpolator;
    private float mOverlapAlphaCurve;
    private float mOverlapDepthMax;
    private float mOverlapDepthRatio;
    private PathInterpolator mOverlapPathInterpolator;
    private float mSampleLGap;

    public ExpandTuneData(@Nullable ExpandTuneData expandTuneData) {
        this.mEdgeAnalysisRatio = 0.02f;
        this.mGradientAnalysisRatio = 0.01f;
        this.mGradientSampleCount = 16;
        this.mOutpaintingAlphaCurve = 0.2f;
        this.mOverlapAlphaCurve = 0.8f;
        this.mOverlapDepthRatio = 0.3f;
        this.mOverlapDepthMax = 0.16f;
        this.mSampleLGap = 7.0f;
        this.mMaxOutpaintingTransitionDepth = 0.15f;
        this.mBlurRadius = 10.0f;
        this.mBitmapShaderScale = 0.5f;
        this.mNeedInvalidate = false;
        if (expandTuneData != null) {
            this.mEdgeAnalysisRatio = expandTuneData.mEdgeAnalysisRatio;
            this.mGradientAnalysisRatio = expandTuneData.mGradientAnalysisRatio;
            this.mGradientSampleCount = expandTuneData.mGradientSampleCount;
            this.mOutpaintingAlphaCurve = expandTuneData.mOutpaintingAlphaCurve;
            this.mOverlapAlphaCurve = expandTuneData.mOverlapAlphaCurve;
            this.mOverlapDepthRatio = expandTuneData.mOverlapDepthRatio;
            this.mOverlapDepthMax = expandTuneData.mOverlapDepthMax;
            this.mSampleLGap = expandTuneData.mSampleLGap;
            this.mMaxOutpaintingTransitionDepth = expandTuneData.mMaxOutpaintingTransitionDepth;
            this.mBlurRadius = expandTuneData.mBlurRadius;
            this.mBitmapShaderScale = expandTuneData.mBitmapShaderScale;
            this.mOutpaintingPathInterpolator = expandTuneData.mOutpaintingPathInterpolator;
            this.mOverlapPathInterpolator = expandTuneData.mOverlapPathInterpolator;
            this.mNeedInvalidate = expandTuneData.mNeedInvalidate;
        }
    }

    @NonNull
    public static ExpandTuneData getDebugValues(@NonNull Context context) {
        ExpandTuneData expandTuneData = new ExpandTuneData();
        expandTuneData.loadDebugValues(context);
        return expandTuneData;
    }

    public float getBitmapShaderScale() {
        return this.mBitmapShaderScale;
    }

    public float getBlurRadius() {
        return this.mBlurRadius;
    }

    public float getEdgeAnalysisRatio() {
        return this.mEdgeAnalysisRatio;
    }

    public float getGradientAnalysisRatio() {
        return this.mGradientAnalysisRatio;
    }

    public int getGradientSampleCount() {
        return this.mGradientSampleCount;
    }

    public float getMaxOutpaintingTransitionDepth() {
        return this.mMaxOutpaintingTransitionDepth;
    }

    public float getOutpaintingAlphaCurve() {
        return this.mOutpaintingAlphaCurve;
    }

    @NonNull
    public PathInterpolator getOutpaintingPathInterpolator() {
        if (this.mOutpaintingPathInterpolator == null) {
            float f = this.mOutpaintingAlphaCurve;
            this.mOutpaintingPathInterpolator = new PathInterpolator(f, 0.0f, f, 1.0f);
        }
        return this.mOutpaintingPathInterpolator;
    }

    public float getOverlapAlphaCurve() {
        return this.mOverlapAlphaCurve;
    }

    public float getOverlapDepthRatio() {
        return this.mOverlapDepthRatio;
    }

    public float getOverlapDepthRatioMax() {
        return this.mOverlapDepthMax;
    }

    @NonNull
    public PathInterpolator getOverlapPathInterpolator() {
        if (this.mOverlapPathInterpolator == null) {
            float f = this.mOverlapAlphaCurve;
            this.mOverlapPathInterpolator = new PathInterpolator(0.5f, 0.52f - (f / 2.0f), 0.5f, (f / 2.0f) + 0.48f);
        }
        return this.mOverlapPathInterpolator;
    }

    public float getSampleLGap() {
        return this.mSampleLGap;
    }

    public void loadDebugValues(@NonNull Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ExpandTuneConstant.DEBUG_PREFS_NAME, 0);
        if (sharedPreferences.contains(ExpandTuneConstant.KEY_EDGE_ANALYSIS_RATIO)) {
            this.mEdgeAnalysisRatio = sharedPreferences.getFloat(ExpandTuneConstant.KEY_EDGE_ANALYSIS_RATIO, this.mEdgeAnalysisRatio);
            this.mGradientAnalysisRatio = sharedPreferences.getFloat(ExpandTuneConstant.KEY_GRADIENT_ANALYSIS_RATIO, this.mGradientAnalysisRatio);
            this.mGradientSampleCount = sharedPreferences.getInt(ExpandTuneConstant.KEY_GRADIENT_SAMPLE_COUNT, this.mGradientSampleCount);
            this.mOutpaintingAlphaCurve = sharedPreferences.getFloat(ExpandTuneConstant.KEY_OUTPAINTING_ALPHA_CURVE, this.mOutpaintingAlphaCurve);
            this.mOverlapAlphaCurve = sharedPreferences.getFloat(ExpandTuneConstant.KEY_OVERLAP_ALPHA_CURVE, this.mOverlapAlphaCurve);
            this.mOverlapDepthRatio = sharedPreferences.getFloat(ExpandTuneConstant.KEY_OVERLAP_DEPTH_RATIO, this.mOverlapDepthRatio);
            this.mOverlapDepthMax = sharedPreferences.getFloat(ExpandTuneConstant.KEY_OVERLAP_DEPTH_MAX, this.mOverlapDepthMax);
            this.mSampleLGap = sharedPreferences.getFloat(ExpandTuneConstant.KEY_SAMPLE_L_GAP, this.mSampleLGap);
            this.mMaxOutpaintingTransitionDepth = sharedPreferences.getFloat(ExpandTuneConstant.KEY_MAX_OUTPAINTING_TRANSITION_DEPTH, this.mMaxOutpaintingTransitionDepth);
            this.mBlurRadius = sharedPreferences.getFloat(ExpandTuneConstant.KEY_BLUR_RADIUS, this.mBlurRadius);
            this.mBitmapShaderScale = sharedPreferences.getFloat(ExpandTuneConstant.KEY_BITMAP_SHADER_SCALE, this.mBitmapShaderScale);
            this.mOutpaintingPathInterpolator = null;
            this.mOverlapPathInterpolator = null;
            this.mNeedInvalidate = true;
        }
    }

    public void resetToDefaults() {
        this.mEdgeAnalysisRatio = 0.02f;
        this.mGradientAnalysisRatio = 0.01f;
        this.mGradientSampleCount = 16;
        this.mOutpaintingAlphaCurve = 0.2f;
        this.mOverlapAlphaCurve = 0.8f;
        this.mOverlapDepthRatio = 0.3f;
        this.mOverlapDepthMax = 0.16f;
        this.mSampleLGap = 7.0f;
        this.mMaxOutpaintingTransitionDepth = 0.15f;
        this.mBlurRadius = 10.0f;
        this.mBitmapShaderScale = 0.5f;
        this.mOutpaintingPathInterpolator = null;
        this.mOverlapPathInterpolator = null;
        this.mNeedInvalidate = true;
    }

    public void saveDebugValues(@NonNull Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(ExpandTuneConstant.DEBUG_PREFS_NAME, 0).edit();
        editorEdit.putFloat(ExpandTuneConstant.KEY_EDGE_ANALYSIS_RATIO, this.mEdgeAnalysisRatio);
        editorEdit.putFloat(ExpandTuneConstant.KEY_GRADIENT_ANALYSIS_RATIO, this.mGradientAnalysisRatio);
        editorEdit.putInt(ExpandTuneConstant.KEY_GRADIENT_SAMPLE_COUNT, this.mGradientSampleCount);
        editorEdit.putFloat(ExpandTuneConstant.KEY_OUTPAINTING_ALPHA_CURVE, this.mOutpaintingAlphaCurve);
        editorEdit.putFloat(ExpandTuneConstant.KEY_OVERLAP_ALPHA_CURVE, this.mOverlapAlphaCurve);
        editorEdit.putFloat(ExpandTuneConstant.KEY_OVERLAP_DEPTH_RATIO, this.mOverlapDepthRatio);
        editorEdit.putFloat(ExpandTuneConstant.KEY_OVERLAP_DEPTH_MAX, this.mOverlapDepthMax);
        editorEdit.putFloat(ExpandTuneConstant.KEY_SAMPLE_L_GAP, this.mSampleLGap);
        editorEdit.putFloat(ExpandTuneConstant.KEY_MAX_OUTPAINTING_TRANSITION_DEPTH, this.mMaxOutpaintingTransitionDepth);
        editorEdit.putFloat(ExpandTuneConstant.KEY_BLUR_RADIUS, this.mBlurRadius);
        editorEdit.putFloat(ExpandTuneConstant.KEY_BITMAP_SHADER_SCALE, this.mBitmapShaderScale);
        editorEdit.apply();
    }

    public void setBitmapShaderScale(float f) {
        float fMax = Math.max(0.1f, Math.min(1.0f, f));
        if (fMax != this.mBitmapShaderScale) {
            this.mBitmapShaderScale = fMax;
            this.mNeedInvalidate = true;
        }
    }

    public void setBlurRadius(float f) {
        float fMax = Math.max(0.0f, Math.min(100.0f, f));
        if (fMax != this.mBlurRadius) {
            this.mBlurRadius = fMax;
            this.mNeedInvalidate = true;
        }
    }

    public void setEdgeAnalysisRatio(float f) {
        float fMax = Math.max(0.001f, Math.min(0.5f, f));
        if (fMax != this.mEdgeAnalysisRatio) {
            this.mEdgeAnalysisRatio = fMax;
            this.mNeedInvalidate = true;
        }
    }

    public void setGradientAnalysisRatio(float f) {
        float fMax = Math.max(0.001f, Math.min(0.5f, f));
        if (fMax != this.mGradientAnalysisRatio) {
            this.mGradientAnalysisRatio = fMax;
            this.mNeedInvalidate = true;
        }
    }

    public void setGradientSampleCount(int i) {
        int iMax = Math.max(2, Math.min(200, i));
        if (iMax != this.mGradientSampleCount) {
            this.mGradientSampleCount = iMax;
            this.mNeedInvalidate = true;
        }
    }

    public void setMaxOutpaintingTransitionDepth(float f) {
        float fMax = Math.max(0.05f, Math.min(1.0f, f));
        if (fMax != this.mMaxOutpaintingTransitionDepth) {
            this.mMaxOutpaintingTransitionDepth = fMax;
            this.mNeedInvalidate = true;
        }
    }

    public void setOutpaintingAlphaCurve(float f) {
        float fMax = Math.max(0.1f, Math.min(10.0f, f));
        if (fMax != this.mOutpaintingAlphaCurve) {
            this.mOutpaintingAlphaCurve = fMax;
            this.mOutpaintingPathInterpolator = null;
            this.mNeedInvalidate = true;
        }
    }

    public void setOverlapAlphaCurve(float f) {
        float fMax = Math.max(0.0f, Math.min(1.0f, f));
        if (fMax != this.mOverlapAlphaCurve) {
            this.mOverlapAlphaCurve = fMax;
            this.mOverlapPathInterpolator = null;
            this.mNeedInvalidate = true;
        }
    }

    public void setOverlapDepthMax(float f) {
        float fMax = Math.max(0.0f, Math.min(0.5f, f));
        if (fMax != this.mOverlapDepthMax) {
            this.mOverlapDepthMax = fMax;
            this.mNeedInvalidate = true;
        }
    }

    public void setOverlapDepthRatio(float f) {
        float fMax = Math.max(0.01f, Math.min(0.5f, f));
        if (fMax != this.mOverlapDepthRatio) {
            this.mOverlapDepthRatio = fMax;
            this.mNeedInvalidate = true;
        }
    }

    public void setSampleLGap(float f) {
        float fMax = Math.max(0.0f, Math.min(100.0f, f));
        if (fMax != this.mSampleLGap) {
            this.mSampleLGap = fMax;
            this.mNeedInvalidate = true;
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("ExpandTuneData{needInvalidate");
        sb.append(this.mNeedInvalidate);
        sb.append("edgeAnalysisRatio=");
        sb.append(this.mEdgeAnalysisRatio);
        sb.append(", gradientAnalysisRatio=");
        sb.append(this.mGradientAnalysisRatio);
        sb.append(", gradientSampleCount=");
        sb.append(this.mGradientSampleCount);
        sb.append(", outpaintingAlphaCurve=");
        sb.append(this.mOutpaintingAlphaCurve);
        sb.append(", overlapAlphaCurve=");
        sb.append(this.mOverlapAlphaCurve);
        sb.append(", overlapDepthRatio=");
        sb.append(this.mOverlapDepthRatio);
        sb.append(", overlapDepthMax=");
        sb.append(this.mOverlapDepthMax);
        sb.append(", sampleLGap=");
        sb.append(this.mSampleLGap);
        sb.append(", maxOutpaintingTransitionDepth=");
        sb.append(this.mMaxOutpaintingTransitionDepth);
        sb.append(", blurRadius=");
        sb.append(this.mBlurRadius);
        sb.append(", bitmapShaderScale=");
        return AbstractC0622a.m1171q(sb, this.mBitmapShaderScale, '}');
    }

    public ExpandTuneData() {
        this.mEdgeAnalysisRatio = 0.02f;
        this.mGradientAnalysisRatio = 0.01f;
        this.mGradientSampleCount = 16;
        this.mOutpaintingAlphaCurve = 0.2f;
        this.mOverlapAlphaCurve = 0.8f;
        this.mOverlapDepthRatio = 0.3f;
        this.mOverlapDepthMax = 0.16f;
        this.mSampleLGap = 7.0f;
        this.mMaxOutpaintingTransitionDepth = 0.15f;
        this.mBlurRadius = 10.0f;
        this.mBitmapShaderScale = 0.5f;
        this.mNeedInvalidate = false;
    }
}
