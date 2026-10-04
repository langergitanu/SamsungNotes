package com.samsung.android.support.senl.p148nt.base.winset.app.picker.color;

import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ColorPicker {
    private static final int POPUP_ALPHA_DURATION = 300;
    private static final String PREFS_KEY_FOR_COLOR_PICKER_VIEW_MODE = "KEY_RICHTEXT_COLOR_PICKER_VIEW_MODE";
    private static final String PREFS_NAME_COLOR = "color_shared_preferences";
    private ColorPickerViewListener mColorPickerVisibilityListener;
    private final Context mContext;
    private final Contract mContract;
    private int mOrientation;
    private final View mParentView;
    private SpenColorPickerPopup mSpenColorPickerPopup;
    private String TAG = Logger.createTag("CP$ColorPicker");
    private boolean mSpenColorPickerPopupDoneClick = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ColorPickerViewListener {
        void onVisibilityChanged(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void onColorChangedByPicker(int i);

        void release();
    }

    public ColorPicker(Context context, View view, Contract contract) {
        this.mContext = context;
        this.mParentView = view;
        this.mContract = contract;
    }

    public void close() {
        SpenColorPickerPopup spenColorPickerPopup = this.mSpenColorPickerPopup;
        if (spenColorPickerPopup != null) {
            spenColorPickerPopup.close();
            this.mSpenColorPickerPopup = null;
        }
    }

    public boolean dismissColorPicker() {
        if (!isShowingColorPicker()) {
            return false;
        }
        this.mSpenColorPickerPopup.dismiss();
        return true;
    }

    public boolean isShowingColorPicker() {
        SpenColorPickerPopup spenColorPickerPopup = this.mSpenColorPickerPopup;
        return spenColorPickerPopup != null && spenColorPickerPopup.isShowing();
    }

    public void setColorPickerVisibilityListener(ColorPickerViewListener colorPickerViewListener) {
        this.mColorPickerVisibilityListener = colorPickerViewListener;
    }

    public void setOrientationMode(int i) {
        this.mOrientation = i;
        if (isShowingColorPicker()) {
            this.mSpenColorPickerPopup.setOrientationMode(this.mOrientation);
        }
    }

    public void setTAG(String str) {
        this.TAG = str;
    }

    public void showColorPickerPopup(@Nullable final View view, int i, int i2, int i4, boolean z) {
        String str = this.TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "showColorPickerPopup currentColor : ", " bgColor:", " colorTheme:");
        sbM1173s.append(i4);
        sbM1173s.append(" hasCloseButton: ");
        sbM1173s.append(z);
        Logger.m8697d(str, sbM1173s.toString());
        if (view != null) {
            view.animate().alpha(0.0f).setDuration(300L);
        }
        float[] fArr = new float[3];
        if (i == 0) {
            Color.colorToHSV(i2, fArr);
        } else {
            Color.colorToHSV(i, fArr);
        }
        dismissColorPicker();
        SpenColorPickerPopup spenColorPickerPopup = new SpenColorPickerPopup(this.mContext, SharedPreferencesCompat.getInstance(PREFS_NAME_COLOR).getInt(PREFS_KEY_FOR_COLOR_PICKER_VIEW_MODE, 2), fArr, false);
        this.mSpenColorPickerPopup = spenColorPickerPopup;
        spenColorPickerPopup.setColorTheme(i4);
        if (z) {
            this.mSpenColorPickerPopup.setCloseButton(new SpenColorPickerPopup.OnCloseClickListener() { // from class: com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorPicker.1
                @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup.OnCloseClickListener
                public void onCloseButtonClick() {
                    ColorPicker.this.dismissColorPicker();
                }
            });
        }
        this.mSpenColorPickerPopup.setColorPickerChangeListener(new SpenColorPickerPopup.ColorPickerChangedListener() { // from class: com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorPicker.2
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup.ColorPickerChangedListener, com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataChangedListener
            public void onColorChanged(int i5, float[] fArr2) {
                ColorPicker.this.mContract.onColorChangedByPicker(i5);
                ColorPicker.this.mSpenColorPickerPopupDoneClick = true;
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup.ColorPickerChangedListener, com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerViewModeChangedListener
            public void onViewModeChanged(int i5) {
                SharedPreferencesCompat.getInstance(ColorPicker.PREFS_NAME_COLOR).putInt(ColorPicker.PREFS_KEY_FOR_COLOR_PICKER_VIEW_MODE, i5);
            }
        });
        this.mSpenColorPickerPopup.setOrientationMode(this.mOrientation);
        if ((this.mContext instanceof Service) && this.mSpenColorPickerPopup.getWindow() != null) {
            this.mSpenColorPickerPopup.getWindow().setType(2038);
        }
        this.mSpenColorPickerPopup.show(this.mParentView);
        ColorPickerViewListener colorPickerViewListener = this.mColorPickerVisibilityListener;
        if (colorPickerViewListener != null) {
            colorPickerViewListener.onVisibilityChanged(0);
        }
        this.mSpenColorPickerPopup.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorPicker.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                Logger.m8702i(ColorPicker.this.TAG, "ColorPicker# onDismiss");
                View view2 = view;
                if (view2 != null) {
                    view2.animate().alpha(1.0f).setDuration(300L);
                }
                if (ColorPicker.this.mSpenColorPickerPopupDoneClick) {
                    ColorPicker.this.mContract.release();
                }
                if (ColorPicker.this.mColorPickerVisibilityListener != null) {
                    ColorPicker.this.mColorPickerVisibilityListener.onVisibilityChanged(8);
                }
            }
        });
    }
}
