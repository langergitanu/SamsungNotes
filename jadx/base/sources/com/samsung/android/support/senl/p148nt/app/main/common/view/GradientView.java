package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.RenderEffect;
import android.graphics.RuntimeShader;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import org.intellij.lang.annotations.Language;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GradientView extends FrameLayout {

    @Language("AGSL")
    private static final String AGSL_SRC = "uniform shader content;                      \nuniform vec2 uNoiseIntensity;                   \nuniform float uScale;                       \nuniform float uTime;                        \nuniform float uRandomSeed;                        \nuniform vec2 uViewToNormalize;              \nuniform vec2 uViewSize;                     \nuniform vec4 uFpuErrCorrection;             \nfloat rand(vec2 p, float seed) {    return fract(cos(dot(p, vec2(23.0224, 81.0618))) * (55000.1030 + seed  * 200.0));\n}\nvec4 main(vec2 fragCoord) {\n  vec2 normalizedFragCoord = fragCoord * uViewToNormalize;\n  vec2 noiseUv = vec2(rand(normalizedFragCoord + uTime, uRandomSeed), rand(normalizedFragCoord + uTime, uRandomSeed+1.0)) * 2.0 - 1.0;\n  vec2 disolvedUv = normalizedFragCoord + noiseUv.xy * uNoiseIntensity;\n  vec4 viewTexture = content.eval( clamp(disolvedUv, uFpuErrCorrection.xy, uFpuErrCorrection.zw) * uViewSize );\n  return vec4(viewTexture.rgb , 1.0);\n}";

    @SuppressLint({WarningType.NewApi})
    private final Runnable applyDitheringFilter;
    private GradientViewEntry mEntry;
    private GradientViewNoiseParams mGradientViewNoiseParams;
    private float mPrevHeight;
    private float mPrevMeasureHeight;
    private float mPrevMeasureWidth;
    private float mPrevWidth;

    public GradientView(@NonNull Context context) {
        super(context);
        this.applyDitheringFilter = new RunnableC7599e(this, 22);
        this.mPrevWidth = 0.0f;
        this.mPrevHeight = 0.0f;
        this.mPrevMeasureWidth = 0.0f;
        this.mPrevMeasureHeight = 0.0f;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyInternal() {
        if (NotesUtils.isSupportDitheringFilter) {
            float width = getWidth();
            float height = getHeight();
            float measuredWidth = getMeasuredWidth();
            float measuredHeight = getMeasuredHeight();
            if (width <= 0.0f || height <= 0.0f || measuredWidth <= 0.0f || measuredHeight <= 0.0f) {
                return;
            }
            if (this.mPrevWidth == 0.0f && this.mPrevHeight == 0.0f && this.mPrevMeasureWidth == 0.0f && this.mPrevMeasureHeight == 0.0f) {
                this.mPrevWidth = width;
                this.mPrevHeight = height;
                this.mPrevMeasureWidth = measuredWidth;
                this.mPrevMeasureHeight = measuredHeight;
            }
            float alpha = getAlpha();
            if (width == this.mPrevWidth && height == this.mPrevHeight && measuredWidth == this.mPrevMeasureWidth && measuredHeight == this.mPrevMeasureHeight && ((alpha <= 0.0f || alpha >= 1.0f) && !isDirty())) {
                this.mGradientViewNoiseParams.intensity = 0.035f;
            } else {
                this.mGradientViewNoiseParams.intensity = 0.0f;
            }
            this.mPrevWidth = width;
            this.mPrevHeight = height;
            this.mPrevMeasureWidth = measuredWidth;
            this.mPrevMeasureHeight = measuredHeight;
            float f = 1.0f / width;
            float f4 = 1.0f / height;
            GradientViewEntry gradientViewEntry = this.mEntry;
            RuntimeShader runtimeShader = gradientViewEntry.shader;
            float f5 = gradientViewEntry.params.intensity;
            runtimeShader.setFloatUniform("uNoiseIntensity", f5, (width / height) * f5);
            GradientViewEntry gradientViewEntry2 = this.mEntry;
            gradientViewEntry2.shader.setFloatUniform("uScale", 1.0f / gradientViewEntry2.params.scale);
            GradientViewEntry gradientViewEntry3 = this.mEntry;
            gradientViewEntry3.shader.setFloatUniform("uTime", gradientViewEntry3.params.time % 1.0f);
            float f6 = f * 2.0f;
            float f7 = 2.0f * f4;
            this.mEntry.shader.setFloatUniform("uFpuErrCorrection", f6, f7, 1.0f - f6, 1.0f - f7);
            GradientViewEntry gradientViewEntry4 = this.mEntry;
            gradientViewEntry4.shader.setFloatUniform("uRandomSeed", gradientViewEntry4.params.seed);
            this.mEntry.shader.setFloatUniform("uViewToNormalize", f, f4);
            this.mEntry.shader.setFloatUniform("uViewSize", width, height);
            RenderEffect renderEffectCreateRuntimeShaderEffect = RenderEffect.createRuntimeShaderEffect(this.mEntry.shader, "content");
            RenderEffect renderEffect = this.mEntry.preRenderEffect;
            if (renderEffect != null) {
                setRenderEffect(RenderEffect.createChainEffect(renderEffectCreateRuntimeShaderEffect, renderEffect));
            } else {
                setRenderEffect(renderEffectCreateRuntimeShaderEffect);
            }
            invalidate();
            if (this.mGradientViewNoiseParams.intensity == 0.0f) {
                requestLayout();
            }
        }
    }

    private void init() {
        if (NotesUtils.isSupportDitheringFilter) {
            this.mGradientViewNoiseParams = new GradientViewNoiseParams(0.035f, 1.0f, 0.0f);
            this.mEntry = new GradientViewEntry(AbstractC8238d.m7570f(), this.mGradientViewNoiseParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        super.onLayout(z, i, i2, i4, i5);
        if (NotesUtils.isSupportDitheringFilter) {
            if (z) {
                this.applyDitheringFilter.run();
            }
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.view.GradientView.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    GradientView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    GradientView.this.applyDitheringFilter.run();
                }
            });
        }
    }

    public GradientView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.applyDitheringFilter = new RunnableC7599e(this, 22);
        this.mPrevWidth = 0.0f;
        this.mPrevHeight = 0.0f;
        this.mPrevMeasureWidth = 0.0f;
        this.mPrevMeasureHeight = 0.0f;
        init();
    }

    public GradientView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.applyDitheringFilter = new RunnableC7599e(this, 22);
        this.mPrevWidth = 0.0f;
        this.mPrevHeight = 0.0f;
        this.mPrevMeasureWidth = 0.0f;
        this.mPrevMeasureHeight = 0.0f;
        init();
    }
}
