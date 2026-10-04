package com.samsung.android.sesl.widget;

import android.content.Context;
import android.graphics.RuntimeShader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sesl.C7834R;
import com.samsung.android.sesl.outerGlow.AGSLShaderView;
import com.samsung.android.sesl.outerGlow.ShaderLayer;
import com.samsung.android.sesl.outerGlow.data.AnimationParams;
import com.samsung.android.sesl.outerGlow.data.BlurParams;
import com.samsung.android.sesl.outerGlow.data.ColorParams;
import com.samsung.android.sesl.outerGlow.data.ImageAdjustmentParams;
import com.samsung.android.sesl.outerGlow.data.OuterGlowParams;
import com.samsung.android.sesl.outerGlow.data.OuterGlowType;
import com.samsung.android.sesl.outerGlow.data.ViewParams;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0014\u001a\u00020\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0017\u001a\u00020\u0016H\u0007J0\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0015J(\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0015J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&H\u0007J\u000e\u0010'\u001a\u00020\u00162\u0006\u0010%\u001a\u00020(J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010%\u001a\u00020*H\u0007J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010%\u001a\u00020,H\u0007J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010%\u001a\u00020.H\u0007J@\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\fJ\u000e\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u000208R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, m13886d2 = {"Lcom/samsung/android/sesl/widget/OuterGlowView;", "Lcom/samsung/android/sesl/outerGlow/AGSLShaderView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", SearchConstants.TargetContents.TAG, "", "contentPaddingHorizontal", "", "contentPaddingVertical", "cornerRadius", "lineThickness", "shaderResourceId", "squirclePower", "type", "Lcom/samsung/android/sesl/outerGlow/data/OuterGlowType;", "getShaderResourceId", "initialize", "", "invalidateSize", "onLayout", "changed", "", "left", "top", "right", "bottom", "onSizeChanged", "w", "h", "oldw", "oldh", "updateAnimationParams", ActionHandler.PARAMS, "Lcom/samsung/android/sesl/outerGlow/data/AnimationParams;", "updateBlurParams", "Lcom/samsung/android/sesl/outerGlow/data/BlurParams;", "updateColorParams", "Lcom/samsung/android/sesl/outerGlow/data/ColorParams;", "updateImageAdjustmentParams", "Lcom/samsung/android/sesl/outerGlow/data/ImageAdjustmentParams;", "updateParams", "Lcom/samsung/android/sesl/outerGlow/data/OuterGlowParams;", "updateSizeInDp", "viewWidthInDp", "viewHeightInDp", "contentPaddingHorizontalInDp", "contentPaddingVerticalInDp", "cornerRadiusInDp", "lineThicknessInDp", "updateSizeParams", "param", "Lcom/samsung/android/sesl/outerGlow/data/ViewParams;", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nOuterGlowView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OuterGlowView.kt\ncom/samsung/android/sesl/widget/OuterGlowView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,612:1\n1#2:613\n*E\n"})
public final class OuterGlowView extends AGSLShaderView {

    @NotNull
    private String TAG;
    private float contentPaddingHorizontal;
    private float contentPaddingVertical;
    private float cornerRadius;
    private float lineThickness;
    private int shaderResourceId;
    private float squirclePower;

    @NotNull
    private OuterGlowType type;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OuterGlowView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final int getShaderResourceId() {
        return this.shaderResourceId;
    }

    @RequiresApi(35)
    public final void initialize(@NotNull Context context, @NotNull OuterGlowType type) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        if (type == OuterGlowType.RoundRect) {
            initWithRaw(context, C7834R.raw.agsl_now_bar_roundrect);
        } else if (type == OuterGlowType.Squircle) {
            initWithRaw(context, C7834R.raw.agsl_now_bar_squircle);
        }
    }

    @RequiresApi(33)
    public final void invalidateSize() {
        RuntimeShader shader;
        float width = getWidth();
        float height = getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            Log.w(this.TAG, AbstractC0541b.m770l("invalidateSize: Invalid view size (", width, "x", height, ")"));
            return;
        }
        float f = 2;
        float f4 = width - (this.contentPaddingHorizontal * f);
        float f5 = height - (f * this.contentPaddingVertical);
        float f6 = f4 / width;
        float f7 = f5 / height;
        float f8 = this.lineThickness / height;
        float f9 = this.cornerRadius / height;
        int size = getRuntimeShaderList().size();
        float f10 = f4 + f5;
        float fCoerceIn = RangesKt.coerceIn((((f10 - 200.0f) / 800.0f) * 35.0f) + 10.0f, 10.0f, 45.0f);
        if (size <= 0 || (shader = getRuntimeShaderList().get(0).getShader()) == null) {
            return;
        }
        try {
            shader.setFloatUniform("uRectWidth", f6);
            shader.setFloatUniform("uRectHeight", f7);
            shader.setFloatUniform("uThickness", f8);
            OuterGlowType outerGlowType = this.type;
            if (outerGlowType == OuterGlowType.RoundRect) {
                shader.setFloatUniform("uCornerRadius", f9);
            } else if (outerGlowType == OuterGlowType.Squircle) {
                shader.setFloatUniform("uSquirclePower", this.squirclePower);
            }
            shader.setFloatUniform("uSegments", fCoerceIn);
            Log.i("invalidateSize", "contentWidth:" + f4 + ",contentHeight:" + f5 + ", sum:" + f10 + ", segments:" + fCoerceIn);
            String str = this.TAG;
            StringBuilder sb = new StringBuilder("Size uniforms updated: width=");
            sb.append(f6);
            sb.append(", height=");
            sb.append(f7);
            sb.append(", thickness=");
            sb.append(f8);
            Log.d(str, sb.toString());
        } catch (Exception e) {
            Log.e(this.TAG, "Failed to update size uniforms", e);
        }
    }

    @Override // com.samsung.android.sesl.outerGlow.AGSLShaderView, android.view.View
    @RequiresApi(33)
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        invalidateSize();
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override // com.samsung.android.sesl.outerGlow.AGSLShaderView, android.view.View
    @RequiresApi(33)
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        invalidateSize();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @RequiresApi(33)
    public final void updateAnimationParams(@NotNull AnimationParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (getRuntimeShaderList().isEmpty()) {
            Log.w(this.TAG, "updateAnimationParams: Shader not initialized");
            return;
        }
        RuntimeShader shader = getRuntimeShaderList().get(0).getShader();
        if (shader != null) {
            try {
                shader.setFloatUniform("uSpeed", params.getSpeed());
                shader.setFloatUniform("uTailLength", params.getTailLength());
                shader.setFloatUniform("uHeadThin", params.getHeadThin());
                shader.setFloatUniform("uTailThin", params.getTailThin());
                shader.setFloatUniform("uFeather", params.getFeather());
                shader.setFloatUniform("uTailFadePow", params.getTailFadePower());
                Log.d(this.TAG, "Animation params updated: speed=" + params.getSpeed() + ", segments=" + params.getSegments());
            } catch (Exception e) {
                Log.e(this.TAG, "Failed to update animation params", e);
            }
        }
    }

    public final void updateBlurParams(@NotNull BlurParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (getRuntimeShaderList().size() < 2) {
            Log.w(this.TAG, "updateBlurParams: Blur layer not available");
            return;
        }
        ShaderLayer data = getRuntimeShaderList().get(1).getData();
        if (data != null) {
            try {
                data.setRadiusX(params.getBlurRadius());
                data.setRadiusY(params.getBlurRadius());
                Log.d(this.TAG, "Blur params updated: radius=" + params.getBlurRadius());
            } catch (Exception e) {
                Log.e(this.TAG, "Failed to update blur params", e);
            }
        }
    }

    @RequiresApi(33)
    public final void updateColorParams(@NotNull ColorParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (getRuntimeShaderList().isEmpty()) {
            Log.w(this.TAG, "updateColorParams: Shader not initialized");
            return;
        }
        RuntimeShader shader = getRuntimeShaderList().get(0).getShader();
        if (shader != null) {
            try {
                shader.setFloatUniform("uColor1", params.getColor1());
                shader.setFloatUniform("uColor2", params.getColor2());
                shader.setFloatUniform("uColor1Weight", params.getColor1Weight());
                shader.setFloatUniform("uColor2Weight", params.getColor2Weight());
                shader.setFloatUniform("u2Color1", params.getColor2Set1());
                shader.setFloatUniform("u2Color2", params.getColor2Set2());
                shader.setFloatUniform("u2Color1Weight", params.getColor2Set1Weight());
                shader.setFloatUniform("u2Color2Weight", params.getColor2Set2Weight());
                Log.d(this.TAG, "Color params updated");
            } catch (Exception e) {
                Log.e(this.TAG, "Failed to update color params", e);
            }
        }
    }

    @RequiresApi(33)
    public final void updateImageAdjustmentParams(@NotNull ImageAdjustmentParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (getRuntimeShaderList().isEmpty()) {
            Log.w(this.TAG, "updateImageAdjustmentParams: Shader not initialized");
            return;
        }
        RuntimeShader shader = getRuntimeShaderList().get(0).getShader();
        if (shader != null) {
            try {
                shader.setFloatUniform("uSaturation", params.getSaturation());
                shader.setFloatUniform("uBrightness", params.getBrightness());
                shader.setFloatUniform("uContrast", params.getContrast());
                Log.d(this.TAG, "Image adjustment params updated: sat=" + params.getSaturation() + ", bright=" + params.getBrightness() + ", contrast=" + params.getContrast());
            } catch (Exception e) {
                Log.w(this.TAG, "Image adjustment uniforms may not be supported by this shader", e);
            }
        }
    }

    @RequiresApi(33)
    public final void updateParams(@NotNull OuterGlowParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        updateSizeParams(params.getViewParams());
        updateAnimationParams(params.getAnimationParams());
        updateColorParams(params.getColorParams());
        updateBlurParams(params.getBlurParams());
        ImageAdjustmentParams imageAdjustmentParams = params.getImageAdjustmentParams();
        if (imageAdjustmentParams != null) {
            updateImageAdjustmentParams(imageAdjustmentParams);
        }
    }

    public final void updateSizeInDp(int viewWidthInDp, int viewHeightInDp, int contentPaddingHorizontalInDp, int contentPaddingVerticalInDp, int cornerRadiusInDp, int lineThicknessInDp, float squirclePower) {
        float f = getResources().getDisplayMetrics().density;
        this.contentPaddingHorizontal = contentPaddingHorizontalInDp * f;
        this.contentPaddingVertical = contentPaddingVerticalInDp * f;
        this.lineThickness = lineThicknessInDp * f;
        OuterGlowType outerGlowType = this.type;
        if (outerGlowType == OuterGlowType.RoundRect) {
            this.cornerRadius = cornerRadiusInDp * f;
        } else if (outerGlowType == OuterGlowType.Squircle) {
            this.squirclePower = squirclePower;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = (int) (viewWidthInDp * f);
        layoutParams.height = (int) (viewHeightInDp * f);
        setLayoutParams(layoutParams);
    }

    public final void updateSizeParams(@NotNull ViewParams param) {
        Intrinsics.checkNotNullParameter(param, "param");
        updateSizeInDp(param.getViewWidth(), param.getViewHeight(), param.getContentPaddingHorizontal(), param.getContentPaddingVertical(), param.getCornerRadius(), param.getLineThickness(), param.getSquirclePower());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OuterGlowView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ OuterGlowView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OuterGlowView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "OuterGlowView";
        this.contentPaddingHorizontal = 10.0f;
        this.contentPaddingVertical = 10.0f;
        this.lineThickness = 4.0f;
        this.cornerRadius = 1.0f;
        this.squirclePower = 3.0f;
        this.type = OuterGlowType.RoundRect;
    }
}
