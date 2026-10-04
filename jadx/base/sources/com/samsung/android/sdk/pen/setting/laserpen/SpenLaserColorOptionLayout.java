package com.samsung.android.sdk.pen.setting.laserpen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.common.C7558c;
import com.samsung.android.sdk.pen.setting.common.SpenRadioListLayout;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\nJ\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/laserpen/SpenLaserColorOptionLayout;", "Lcom/samsung/android/sdk/pen/setting/common/SpenRadioListLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mColorOptionChangedListener", "Lcom/samsung/android/sdk/pen/setting/laserpen/SpenLaserColorOptionLayout$OnColorOptionChangedListener;", "setColorOption", "", "colorOption", "", "setColorOptionChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "construct", "mRadioBtnListener", "Landroid/widget/RadioGroup$OnCheckedChangeListener;", "Companion", "OnColorOptionChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenLaserColorOptionLayout extends SpenRadioListLayout {

    @NotNull
    private static final String TAG = "SpenLaserColorOptionLayout";

    @Nullable
    private OnColorOptionChangedListener mColorOptionChangedListener;

    @NotNull
    private final RadioGroup.OnCheckedChangeListener mRadioBtnListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/laserpen/SpenLaserColorOptionLayout$OnColorOptionChangedListener;", "", "onColorOptionChanged", "", "type", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnColorOptionChangedListener {
        void onColorOptionChanged(int type);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenLaserColorOptionLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRadioBtnListener = new C7558c(this, 1);
        construct(context);
    }

    private final void construct(Context context) {
        View.inflate(context, C7932R.layout.setting_laser_color_option_layout, this);
        initLayout(C7932R.id.color_radio_group, this.mRadioBtnListener);
        setItem(C7932R.id.color_radio_rainbow, C7932R.id.color_radio_rainbow_ripple_view, C7932R.string.pen_string_laser_color_option_rainbow);
        setItem(C7932R.id.color_radio_single, C7932R.id.color_radio_single_ripple_view, C7932R.string.pen_string_laser_color_option_single);
        setVisibilityCheck(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRadioBtnListener$lambda$0(SpenLaserColorOptionLayout spenLaserColorOptionLayout, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(radioGroup, "<unused var>");
        Log.i(TAG, "mRadioBtnListener OnCheckedChangeListener checkedId =" + i);
        int i2 = i == C7932R.id.color_radio_rainbow ? 1 : 0;
        OnColorOptionChangedListener onColorOptionChangedListener = spenLaserColorOptionLayout.mColorOptionChangedListener;
        if (onColorOptionChangedListener != null) {
            onColorOptionChangedListener.onColorOptionChanged(i2);
        }
    }

    public final void setColorOption(int colorOption) {
        int i;
        if (colorOption == 0) {
            i = C7932R.id.color_radio_single;
        } else {
            if (colorOption != 1) {
                AbstractC2322a.m1631u(colorOption, "invalid color option ", TAG);
                return;
            }
            i = C7932R.id.color_radio_rainbow;
        }
        setInfo(i);
    }

    public final void setColorOptionChangedListener(@NotNull OnColorOptionChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mColorOptionChangedListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenLaserColorOptionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRadioBtnListener = new C7558c(this, 1);
        construct(context);
    }
}
