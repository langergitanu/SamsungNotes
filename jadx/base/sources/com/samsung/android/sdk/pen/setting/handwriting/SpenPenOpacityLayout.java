package com.samsung.android.sdk.pen.setting.handwriting;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.common.SpenSlider;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayoutInterface;
import com.samsung.android.spen.C7932R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001d\b\u0010\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0002/0B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B!\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012J\u001d\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0000¢\u0006\u0002\b#J\r\u0010$\u001a\u00020\u0014H\u0000¢\u0006\u0002\b%J \u0010&\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0002J\u0010\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0002J\u0018\u0010+\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0002J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\bH\u0002J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\bH\u0002R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u00061"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenOpacityLayout;", "Landroid/widget/FrameLayout;", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenOpacityLayoutInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "sliderLayoutId", "", "useUserLabelSlider", "", "(Landroid/content/Context;IZ)V", "mColor", "mSlider", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider;", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenOpacityLayoutInterface$OnDataChangedListener;", "mSliderTrackListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenOpacityLayout$OnSliderTrackListener;", "close", "", "setColor", "color", "setDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSliderTrackListener", "sliderView", "getSliderView$SDK_fullRelease", "()Lcom/samsung/android/sdk/pen/setting/common/SpenSlider;", "isRunningShowHideAnimation", "isRunningShowHideAnimation$SDK_fullRelease", "()Z", "showOpacityAnimation", "fromValue", "toValue", "showOpacityAnimation$SDK_fullRelease", "hideOpacityAnimation", "hideOpacityAnimation$SDK_fullRelease", "initView", "getPercentToAlpha", "percent", "getAlphaToPercent", "alpha", "setCurrentAlpha", "updateValue", "value", "updateColor", "Companion", "OnSliderTrackListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenPenOpacityLayout extends FrameLayout implements SpenPenOpacityLayoutInterface {

    @NotNull
    private static final String TAG = "SpenPenOpacityLayout";
    private int mColor;

    @Nullable
    private SpenPenOpacityLayoutInterface.OnDataChangedListener mDataChangedListener;

    @Nullable
    private SpenSlider mSlider;

    @Nullable
    private OnSliderTrackListener mSliderTrackListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenOpacityLayout$OnSliderTrackListener;", "", "onStartTrackingTouch", "", "onStopTrackingTouch", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnSliderTrackListener {
        void onStartTrackingTouch();

        void onStopTrackingTouch();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenOpacityLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context, 0, false);
    }

    private final int getAlphaToPercent(int alpha) {
        if (alpha < 0 || alpha >= 256) {
            return -1;
        }
        return Math.round((alpha / 255.0f) * 100.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getPercentToAlpha(int percent) {
        if (percent < 0 || percent >= 101) {
            return -1;
        }
        return Math.round((percent * 255.0f) / 100.0f);
    }

    private final void initView(Context context, int sliderLayoutId, boolean useUserLabelSlider) {
        Context context2;
        SpenSlider spenSlider;
        if (useUserLabelSlider) {
            context2 = context;
            SpenUserLabelSlider spenUserLabelSlider = sliderLayoutId == 0 ? new SpenUserLabelSlider(context2, false, 1, 100, C7932R.string.pen_string_opacity_decrease, C7932R.string.pen_string_opacity_increase, SpenSlider.SliderType.CONTINUOUS) : new SpenUserLabelSlider(context2, false, sliderLayoutId, 1, 100, C7932R.string.pen_string_opacity_decrease, C7932R.string.pen_string_opacity_increase, SpenSlider.SliderType.CONTINUOUS);
            this.mSlider = spenUserLabelSlider;
            Intrinsics.checkNotNull(spenUserLabelSlider, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider");
            spenUserLabelSlider.setThumbAnimationEnable(false);
        } else {
            if (sliderLayoutId == 0) {
                spenSlider = new SpenSlider(context, false, 1, 100, C7932R.string.pen_string_opacity_decrease, C7932R.string.pen_string_opacity_increase, SpenSlider.SliderType.CONTINUOUS);
                context2 = context;
            } else {
                context2 = context;
                spenSlider = new SpenSlider(context2, false, sliderLayoutId, 1, 100, C7932R.string.pen_string_opacity_decrease, C7932R.string.pen_string_opacity_increase, SpenSlider.SliderType.CONTINUOUS);
            }
            this.mSlider = spenSlider;
        }
        Resources resources = context2.getResources();
        SpenSlider spenSlider2 = this.mSlider;
        if (spenSlider2 != null) {
            spenSlider2.setTrackMinHeight(resources.getDimensionPixelSize(C7932R.dimen.setting_slider_opacity_progress_height));
        }
        SpenSlider spenSlider3 = this.mSlider;
        if (spenSlider3 != null) {
            spenSlider3.setLabelFormat("%d%%");
        }
        SpenSlider spenSlider4 = this.mSlider;
        if (spenSlider4 != null) {
            spenSlider4.setAccessibilityPostfix(resources.getString(C7932R.string.pen_string_opacity));
        }
        addView(this.mSlider);
        SpenSlider spenSlider5 = this.mSlider;
        if (spenSlider5 != null) {
            spenSlider5.setOnChangedListener(new SpenSlider.OnChangedListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayout.initView.1
                @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnChangedListener
                public void onChanged(int value, boolean fromUser) {
                    AbstractC6670b.m4754o("onChanged=", value, " fromUser=", fromUser, SpenPenOpacityLayout.TAG);
                    int percentToAlpha = SpenPenOpacityLayout.this.getPercentToAlpha(value);
                    SpenPenOpacityLayout spenPenOpacityLayout = SpenPenOpacityLayout.this;
                    spenPenOpacityLayout.updateColor(spenPenOpacityLayout.setCurrentAlpha(spenPenOpacityLayout.mColor, percentToAlpha));
                    if (SpenPenOpacityLayout.this.mDataChangedListener != null) {
                        SpenPenOpacityLayoutInterface.OnDataChangedListener onDataChangedListener = SpenPenOpacityLayout.this.mDataChangedListener;
                        Intrinsics.checkNotNull(onDataChangedListener);
                        onDataChangedListener.onAlphaChanged(percentToAlpha, fromUser);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int setCurrentAlpha(int color, int alpha) {
        return (color & 16777215) | ((alpha << 24) & (-16777216));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateColor(int color) {
        SpenSlider spenSlider = this.mSlider;
        if (spenSlider != null) {
            spenSlider.setProgressBackgroundColors(Arrays.copyOf(new int[]{(-16777216) | color, 16777215 & color}, 2));
            spenSlider.setColor(color);
            this.mColor = color;
        }
    }

    private final void updateValue(int value) {
        SpenSlider spenSlider = this.mSlider;
        if (spenSlider != null) {
            spenSlider.setValue(value, true);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayoutInterface
    public void close() {
        this.mDataChangedListener = null;
        this.mSliderTrackListener = null;
        SpenSlider spenSlider = this.mSlider;
        if (spenSlider != null) {
            spenSlider.close();
        }
        this.mSlider = null;
    }

    @Nullable
    /* JADX INFO: renamed from: getSliderView$SDK_fullRelease, reason: from getter */
    public final SpenSlider getMSlider() {
        return this.mSlider;
    }

    public final void hideOpacityAnimation$SDK_fullRelease() {
        SpenSlider spenSlider = this.mSlider;
        if (spenSlider != null) {
            spenSlider.setHideAnimationListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayout$hideOpacityAnimation$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    this.this$0.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            });
        }
        SpenSlider spenSlider2 = this.mSlider;
        if (spenSlider2 != null) {
            spenSlider2.startHideAnimation();
        }
    }

    public final boolean isRunningShowHideAnimation$SDK_fullRelease() {
        SpenSlider spenSlider = this.mSlider;
        if (spenSlider != null) {
            return spenSlider.isRunningShowHideAnimation();
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayoutInterface
    public void setColor(int color) {
        Log.i(TAG, "setColor() color=" + color);
        updateValue(getAlphaToPercent(Color.alpha(color)));
        updateColor(color);
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayoutInterface
    public void setDataChangedListener(@Nullable SpenPenOpacityLayoutInterface.OnDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    public final void setSliderTrackListener(@Nullable OnSliderTrackListener listener) {
        SpenSlider spenSlider = this.mSlider;
        if (spenSlider == null) {
            return;
        }
        this.mSliderTrackListener = listener;
        if (listener == null) {
            if (spenSlider != null) {
                spenSlider.setOnTrackListener(null);
            }
        } else if (spenSlider != null) {
            spenSlider.setOnTrackListener(new SpenSlider.OnSliderTrackListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayout.setSliderTrackListener.1
                @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
                public void onStartTrackingTouch() {
                    OnSliderTrackListener onSliderTrackListener = SpenPenOpacityLayout.this.mSliderTrackListener;
                    if (onSliderTrackListener != null) {
                        onSliderTrackListener.onStartTrackingTouch();
                    }
                }

                @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
                public void onStopTrackingTouch() {
                    OnSliderTrackListener onSliderTrackListener = SpenPenOpacityLayout.this.mSliderTrackListener;
                    if (onSliderTrackListener != null) {
                        onSliderTrackListener.onStopTrackingTouch();
                    }
                }
            });
        }
    }

    public final void showOpacityAnimation$SDK_fullRelease(int fromValue, int toValue) {
        SpenSlider spenSlider = this.mSlider;
        if (spenSlider != null) {
            spenSlider.setValue(fromValue, false);
        }
        SpenSlider spenSlider2 = this.mSlider;
        if (spenSlider2 != null) {
            spenSlider2.setValue(toValue, true);
        }
        int currentAlpha = setCurrentAlpha(this.mColor, getPercentToAlpha(fromValue));
        SpenSlider spenSlider3 = this.mSlider;
        if (spenSlider3 != null) {
            spenSlider3.startShowAnimation(currentAlpha, this.mColor);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenOpacityLayout(@NotNull Context context, int i, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context, i, z);
    }
}
