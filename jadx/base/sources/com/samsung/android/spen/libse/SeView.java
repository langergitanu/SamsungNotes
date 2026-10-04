package com.samsung.android.spen.libse;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.HapticFeedbackConstants;
import android.view.PointerIcon;
import android.view.View;
import com.samsung.android.feature.SemFloatingFeature;
import com.samsung.android.spen.libinterface.HoverPopupWindowInterface;
import com.samsung.android.spen.libinterface.ViewInterface;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SeView implements ViewInterface {
    private static final int HAPTIC_INDEX_DRAG_DROP_EFFECT_TICK = 41;
    private static final int HAPTIC_INDEX_DRAG_DROP_FLOATING = 110;
    private static final int HAPTIC_INDEX_DRAG_DROP_START = 108;
    private static final int HAPTIC_INDEX_ONLY_FOR_DC = 100;
    private static final int VALID_HAPTIC_PATTERN = 50;
    private View instance;
    private Boolean mIsSupportDcHaptic = null;

    public SeView(View view) {
        this.instance = view;
    }

    private void performDCHapticFeedback(Vibrator vibrator) {
        if (Settings.System.getInt(this.instance.getContext().getContentResolver(), "haptic_feedback_enabled", 0) == 1) {
            vibrator.vibrate(VibrationEffect.semCreateWaveform(HapticFeedbackConstants.semGetVibrationIndex(100), -1, VibrationEffect.SemMagnitudeType.TYPE_TOUCH));
        }
    }

    @Override // com.samsung.android.spen.libinterface.ViewInterface
    public void extractSmartClipData() {
    }

    @Override // com.samsung.android.spen.libinterface.ViewInterface
    public HoverPopupWindowInterface getHoverPopupWindow() {
        return new SeHoverPopupWindow(this.instance.semGetHoverPopup(true));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isSupportDcHaptic() {
        if (this.mIsSupportDcHaptic == null) {
            if (SemFloatingFeature.getInstance().getBoolean("SEC_FLOATING_FEATURE_AUDIO_SUPPORT_DC_MOTOR_HAPTIC_FEEDBACK")) {
                Vibrator vibrator = (Vibrator) this.instance.getContext().getSystemService("vibrator");
                if (vibrator != null) {
                    boolean z = vibrator.semGetSupportedVibrationType() == 1;
                    this.mIsSupportDcHaptic = Boolean.valueOf(z);
                }
            } else {
                this.mIsSupportDcHaptic = Boolean.FALSE;
            }
        }
        return this.mIsSupportDcHaptic.booleanValue();
    }

    @Override // com.samsung.android.spen.libinterface.ViewInterface
    public void performHapticFeedback(int i) {
        if (Build.VERSION.SEM_INT >= 2803) {
            Vibrator vibrator = (Vibrator) this.instance.getContext().getSystemService("vibrator");
            if (vibrator.semGetNumberOfSupportedPatterns() >= 50) {
                if (!isSupportDcHaptic()) {
                    this.instance.performHapticFeedback(HapticFeedbackConstants.semGetVibrationIndex(i), 1);
                    return;
                } else {
                    if (i == 41) {
                        return;
                    }
                    performDCHapticFeedback(vibrator);
                    return;
                }
            }
        }
        this.instance.performHapticFeedback(0);
    }

    @Override // com.samsung.android.spen.libinterface.ViewInterface
    public void requestAccessibilityFocus() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = View.class.getMethod("semRequestAccessibilityFocus", null);
        method.setAccessible(true);
        method.invoke(this.instance, null);
    }

    @Override // com.samsung.android.spen.libinterface.ViewInterface
    public void setHoverPopupType(int i) {
        this.instance.semSetHoverPopupType(i);
    }

    @Override // com.samsung.android.spen.libinterface.ViewInterface
    public void setPointerIcon(Context context, int i) {
        this.instance.semSetPointerIcon(2, PointerIcon.getSystemIcon(context, i));
    }

    @Override // com.samsung.android.spen.libinterface.ViewInterface
    public void setPointerIcon(int i, PointerIcon pointerIcon) {
        this.instance.semSetPointerIcon(i, pointerIcon);
    }

    @Override // com.samsung.android.spen.libinterface.ViewInterface
    public void setPointerIcon(Resources resources, Bitmap bitmap, float f, float f4) {
        this.instance.semSetPointerIcon(2, PointerIcon.create(bitmap, f, f4));
    }
}
