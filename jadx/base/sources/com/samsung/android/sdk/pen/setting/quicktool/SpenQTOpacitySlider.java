package com.samsung.android.sdk.pen.setting.quicktool;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayoutInterface;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSlider;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilOpacity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0002\u001f B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000eJ\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0019H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTOpacitySlider;", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider;", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenOpacityLayoutInterface;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mColor", "", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenOpacityLayoutInterface$OnDataChangedListener;", "mAnimationListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTOpacitySlider$OnAnimationListener;", "close", "", "setColor", "color", "setDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAnimationListener", "setVisibility", "visibility", "animation", "", "updateColor", "setCurrentAlpha", "alpha", "startThumbAnimation", "isShow", "Companion", "OnAnimationListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenQTOpacitySlider extends SpenCurvedSlider implements SpenPenOpacityLayoutInterface {

    @NotNull
    private static final String TAG = "SpenQTOpacitySlider";

    @Nullable
    private OnAnimationListener mAnimationListener;
    private int mColor;

    @Nullable
    private SpenPenOpacityLayoutInterface.OnDataChangedListener mDataChangedListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTOpacitySlider$OnAnimationListener;", "", "onAnimationEnd", "", "isShowAnimation", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnAnimationListener {
        void onAnimationEnd(boolean isShowAnimation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenQTOpacitySlider(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setSupportCheckBg(true);
        setOnChangedListener(new SpenCurvedSlider.OnChangedListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTOpacitySlider.1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSlider.OnChangedListener
            public void onChanged(int value, boolean fromUser) {
                AbstractC6670b.m4754o("onChanged() value=", value, " fromUser=", fromUser, SpenQTOpacitySlider.TAG);
                int percentToAlpha = SpenSettingUtilOpacity.getPercentToAlpha(value);
                SpenQTOpacitySlider spenQTOpacitySlider = SpenQTOpacitySlider.this;
                spenQTOpacitySlider.updateColor(spenQTOpacitySlider.setCurrentAlpha(spenQTOpacitySlider.mColor, percentToAlpha));
                SpenPenOpacityLayoutInterface.OnDataChangedListener onDataChangedListener = SpenQTOpacitySlider.this.mDataChangedListener;
                if (onDataChangedListener != null) {
                    onDataChangedListener.onAlphaChanged(percentToAlpha, fromUser);
                }
            }
        });
        setOnAnimationListener(new SpenCurvedSlider.OnAnimationListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTOpacitySlider.2
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSlider.OnAnimationListener
            public void onAnimationEnd(boolean isShowAnimation) {
                OnAnimationListener onAnimationListener = SpenQTOpacitySlider.this.mAnimationListener;
                if (onAnimationListener != null) {
                    onAnimationListener.onAnimationEnd(isShowAnimation);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int setCurrentAlpha(int color, int alpha) {
        return (color & 16777215) | ((alpha << 24) & (-16777216));
    }

    private final void startThumbAnimation(boolean isShow) {
        float f = isShow ? 1.0f : 0.0f;
        SpenCurvedSliderThumbView mThumbView = getMThumbView();
        if (mThumbView != null) {
            mThumbView.animate().scaleX(f).scaleY(f).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setDuration(isShow ? 400L : 350L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateColor(int color) {
        setProgressColor(new int[]{16777215 & color, (-16777216) | color});
        this.mColor = color;
    }

    @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSlider, com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayoutInterface
    public void close() {
        super.close();
        this.mDataChangedListener = null;
        this.mAnimationListener = null;
    }

    public final void setAnimationListener(@NotNull OnAnimationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mAnimationListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayoutInterface
    public void setColor(int color) {
        int alphaToPercent = SpenSettingUtilOpacity.getAlphaToPercent(Color.alpha(color));
        AbstractC6670b.m4744e(color, alphaToPercent, "setColor() color=", " value=", TAG);
        setValue(alphaToPercent);
        updateColor(color);
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayoutInterface
    public void setDataChangedListener(@Nullable SpenPenOpacityLayoutInterface.OnDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSlider
    public void setVisibility(int visibility, boolean animation) {
        if (animation) {
            startThumbAnimation(visibility == 0);
        }
        super.setVisibility(visibility, animation);
    }
}
