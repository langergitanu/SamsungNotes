package com.samsung.android.sdk.pen.setting;

import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.setting.SpenColorControl;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J \u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\rH\u0016J\b\u0010!\u001a\u00020\rH\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010$\u001a\u00020\rH\u0016J\b\u0010%\u001a\u00020\rH\u0016J\b\u0010&\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenColorLogCollector;", "Lcom/samsung/android/sdk/pen/setting/SpenColorControl$OnActionListener;", "<init>", "()V", "mPaletteListener", "Lcom/samsung/android/sdk/pen/setting/PenPaletteLoggingListener;", "mColorSettingListener", "Lcom/samsung/android/sdk/pen/setting/ColorSettingsLoggingListener;", "mColorPickerListener", "Lcom/samsung/android/sdk/pen/setting/ColorPickerLoggingListener;", "mEyedropperListener", "Lcom/samsung/android/sdk/pen/setting/EyedropperLoggingListener;", "setColorLogListener", "", "colorListener", "Lcom/samsung/android/sdk/pen/setting/SpenColorSAListener;", "onColorSettingDone", "selection", "", "onColorSettingCancel", "onPaletteSwipe", "direction", "onColorPickerSelected", "onColorSettingSelected", "onEyedropperSelected", "onColorSelected", "pageIndex", "childAt", "color", "onColorPickerClose", "byDone", "", "onHandlerTapped", "onSpoidClosed", "onColorPickerUsage", "type", "onColorCirclePressed", "onColorSeekBarPressed", "onRecentColorSelected", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorLogCollector implements SpenColorControl.OnActionListener {

    @NotNull
    private static final String TAG = "SpenColorLogCollector";

    @Nullable
    private ColorPickerLoggingListener mColorPickerListener;

    @Nullable
    private ColorSettingsLoggingListener mColorSettingListener;

    @Nullable
    private EyedropperLoggingListener mEyedropperListener;

    @Nullable
    private PenPaletteLoggingListener mPaletteListener;

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup.ColorPickerListener
    public void onColorCirclePressed() {
        ColorPickerLoggingListener colorPickerLoggingListener = this.mColorPickerListener;
        if (colorPickerLoggingListener != null) {
            colorPickerLoggingListener.onColorCirclePressed();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenColorControl.OnActionListener
    public void onColorPickerClose(boolean byDone) {
        if (byDone) {
            ColorPickerLoggingListener colorPickerLoggingListener = this.mColorPickerListener;
            if (colorPickerLoggingListener != null) {
                colorPickerLoggingListener.onColorPickerDone();
                return;
            }
            return;
        }
        ColorPickerLoggingListener colorPickerLoggingListener2 = this.mColorPickerListener;
        if (colorPickerLoggingListener2 != null) {
            colorPickerLoggingListener2.onColorPickerCancel();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenColorControl.OnActionListener
    public void onColorPickerSelected() {
        PenPaletteLoggingListener penPaletteLoggingListener = this.mPaletteListener;
        if (penPaletteLoggingListener != null) {
            penPaletteLoggingListener.onColorPickerSelected();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup.ColorPickerListener
    public void onColorSeekBarPressed() {
        ColorPickerLoggingListener colorPickerLoggingListener = this.mColorPickerListener;
        if (colorPickerLoggingListener != null) {
            colorPickerLoggingListener.onSeekbarChanged();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenColorControl.OnActionListener
    public void onColorSelected(int pageIndex, int childAt, int color) {
        if (this.mPaletteListener != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            AbstractC11014a.m12338w(AbstractC0622a.m1173s(pageIndex, childAt, "onColorSelected() pageIndex=", " childAt=", " color="), AbstractC2322a.m1624n("#%08X", new Object[]{Integer.valueOf(color)}, 1, "format(format, *args)"), TAG);
            PenPaletteLoggingListener penPaletteLoggingListener = this.mPaletteListener;
            if (penPaletteLoggingListener != null) {
                penPaletteLoggingListener.onColorSelected(color);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenColorControl.OnActionListener
    public void onColorSettingCancel() {
        ColorSettingsLoggingListener colorSettingsLoggingListener = this.mColorSettingListener;
        if (colorSettingsLoggingListener != null) {
            colorSettingsLoggingListener.onColorSettingCancel();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenColorControl.OnActionListener
    public void onColorSettingDone(int selection) {
        ColorSettingsLoggingListener colorSettingsLoggingListener = this.mColorSettingListener;
        if (colorSettingsLoggingListener != null) {
            colorSettingsLoggingListener.onColorSettingDone(selection);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenColorControl.OnActionListener
    public void onColorSettingSelected() {
        PenPaletteLoggingListener penPaletteLoggingListener = this.mPaletteListener;
        if (penPaletteLoggingListener != null) {
            penPaletteLoggingListener.onColorSettingSelected();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenColorControl.OnActionListener
    public void onEyedropperSelected() {
        PenPaletteLoggingListener penPaletteLoggingListener = this.mPaletteListener;
        if (penPaletteLoggingListener != null) {
            penPaletteLoggingListener.onEyedropperSelected();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout.ActionListener
    public void onHandlerTapped() {
        EyedropperLoggingListener eyedropperLoggingListener = this.mEyedropperListener;
        if (eyedropperLoggingListener != null) {
            eyedropperLoggingListener.onEyedropperHandlerTapped();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenColorControl.OnActionListener
    public void onPaletteSwipe(int direction) {
        if (this.mPaletteListener != null) {
            AbstractC2322a.m1631u(direction, "onPaletteSwipe()  direction=", TAG);
            int i = direction < 0 ? 1 : 2;
            PenPaletteLoggingListener penPaletteLoggingListener = this.mPaletteListener;
            if (penPaletteLoggingListener != null) {
                penPaletteLoggingListener.onPaletteSwiped(i);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup.ColorPickerListener
    public void onRecentColorSelected() {
        ColorPickerLoggingListener colorPickerLoggingListener = this.mColorPickerListener;
        if (colorPickerLoggingListener != null) {
            colorPickerLoggingListener.onRecentColorSelected();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout.ActionListener
    public void onSpoidClosed() {
        EyedropperLoggingListener eyedropperLoggingListener = this.mEyedropperListener;
        if (eyedropperLoggingListener != null) {
            eyedropperLoggingListener.onEyedropperClosed();
        }
    }

    public final void setColorLogListener(@Nullable SpenColorSAListener colorListener) {
        this.mPaletteListener = colorListener;
        this.mColorSettingListener = colorListener;
        this.mColorPickerListener = colorListener;
        this.mEyedropperListener = colorListener;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup.ColorPickerListener
    public void onColorPickerUsage(int type) {
    }
}
