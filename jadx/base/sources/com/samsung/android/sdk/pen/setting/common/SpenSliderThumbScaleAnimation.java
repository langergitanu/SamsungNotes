package com.samsung.android.sdk.pen.setting.common;

import android.view.View;
import android.widget.TextView;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\fH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbScaleAnimation;", "", "thumbView", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbView;", "<init>", "(Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbView;)V", "mSliderThumbView", "mThumbBackgroundView", "Landroid/view/View;", "mLabelHandlerTextView", "Landroid/widget/TextView;", "close", "", "startAnimation", "isScaleDown", "", "cancelAnimation", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSliderThumbScaleAnimation {
    private static final int ANIMATE_ALPHA_HIDE_DURATION = 100;
    private static final int ANIMATE_ALPHA_SHOW_DURATION = 200;
    private static final int ANIMATE_SCALE_DOWN_DURATION = 400;
    private static final int ANIMATE_SCALE_UP_DURATION = 300;
    private static final int ANIMATE_TEXT_SCALE_DURATION = 400;
    private static final float SCALE_DOWN_RATIO = 0.42f;
    private static final float SCALE_NORMAL_RATIO = 1.0f;

    @NotNull
    private static final String TAG = "SpenSliderThumbScaleAnimation";

    @Nullable
    private TextView mLabelHandlerTextView;

    @Nullable
    private SpenSliderThumbView mSliderThumbView;

    @Nullable
    private View mThumbBackgroundView;

    public SpenSliderThumbScaleAnimation(@Nullable SpenSliderThumbView spenSliderThumbView) {
        this.mSliderThumbView = spenSliderThumbView;
        if (spenSliderThumbView != null) {
            this.mThumbBackgroundView = spenSliderThumbView.getThumbBackgroundView();
            this.mLabelHandlerTextView = spenSliderThumbView.getLabelTextView();
        }
    }

    private final void cancelAnimation() {
        View view = this.mThumbBackgroundView;
        if (view != null) {
            view.animate().cancel();
        }
        TextView textView = this.mLabelHandlerTextView;
        if (textView != null) {
            textView.animate().cancel();
        }
    }

    public final void close() {
        cancelAnimation();
        SpenSliderThumbView spenSliderThumbView = this.mSliderThumbView;
        if (spenSliderThumbView != null) {
            spenSliderThumbView.close();
        }
        this.mSliderThumbView = null;
        this.mThumbBackgroundView = null;
    }

    public final void startAnimation(boolean isScaleDown) {
        View view = this.mThumbBackgroundView;
        TextView textView = this.mLabelHandlerTextView;
        if (view == null || textView == null) {
            return;
        }
        cancelAnimation();
        if (isScaleDown) {
            view.animate().scaleX(0.42f).scaleY(0.42f).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(11)).start();
            textView.animate().scaleX(0.42f).scaleY(0.42f).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(11)).start();
            textView.animate().alpha(0.0f).setDuration(100L).start();
        } else {
            view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(11)).start();
            textView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(11)).start();
            textView.animate().alpha(1.0f).setDuration(200L).start();
        }
    }
}
