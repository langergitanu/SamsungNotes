package com.samsung.android.support.senl.p148nt.base.winset.app.picker.color;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingPopup;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ColorSetting {
    private String TAG = Logger.createTag("CP$ColorSetting");
    private SpenColorSettingPopup mColorSettingPopup;
    private ColorSettingViewListener mColorSettingViewListener;
    private final Context mContext;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ColorSettingViewListener {
        void onCancel();

        void onChangeSelected(List<Integer> list);

        void onDone();

        void onSelectItemChanged(int i, boolean z);

        void onVisibilityChanged(int i);
    }

    public ColorSetting(Context context) {
        this.mContext = context;
    }

    public boolean dismissColorSetting() {
        SpenColorSettingPopup spenColorSettingPopup = this.mColorSettingPopup;
        if (spenColorSettingPopup == null || !spenColorSettingPopup.isShowing()) {
            return false;
        }
        this.mColorSettingPopup.dismiss();
        return true;
    }

    public boolean isShowingColorSetting() {
        SpenColorSettingPopup spenColorSettingPopup = this.mColorSettingPopup;
        if (spenColorSettingPopup != null) {
            return spenColorSettingPopup.isShowing();
        }
        return false;
    }

    public void setColorSettingViewListener(ColorSettingViewListener colorSettingViewListener) {
        this.mColorSettingViewListener = colorSettingViewListener;
    }

    public void setTag(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.TAG = str;
    }

    public void showColorSettingPopup(List<Integer> list, int i) {
        Logger.m8697d(this.TAG, "showColorSettingPopup mPaletteList : " + list.size());
        SpenColorSettingPopup spenColorSettingPopup = new SpenColorSettingPopup(this.mContext, ColorPaletteData.getDefaultSwatchList(), 4);
        this.mColorSettingPopup = spenColorSettingPopup;
        spenColorSettingPopup.setColorTheme(i);
        this.mColorSettingPopup.setSelectPaletteList(list);
        this.mColorSettingPopup.setOnSelectItemEventListener(new OnSelectItemEventListener() { // from class: com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorSetting.1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener
            public void onSelectItemChanged(int i2, boolean z) {
                ColorSetting.this.mColorSettingViewListener.onSelectItemChanged(i2, z);
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener
            public void onSelectItemUnchanged(int i2, OnSelectItemEventListener.UnchangedReason unchangedReason) {
                if (OnSelectItemEventListener.UnchangedReason.MAX_VALUE_LIMIT.equals(unchangedReason)) {
                    ToastHandler.show(ColorSetting.this.mContext, ColorSetting.this.mContext.getResources().getQuantityString(C8875R.plurals.colorset_toast_max_restriction, 4, 4), 0);
                } else if (OnSelectItemEventListener.UnchangedReason.MIN_VALUE_LIMIT.equals(unchangedReason)) {
                    ToastHandler.show(ColorSetting.this.mContext, C8875R.string.colorset_toast_min_restriction, 0);
                }
            }
        });
        this.mColorSettingPopup.setEventListener(new SpenColorSettingPopup.IEventListener() { // from class: com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorSetting.2
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingPopup.IEventListener
            public void onChangeSelected(List<Integer> list2) {
                if (ColorSetting.this.mColorSettingViewListener != null) {
                    ColorSetting.this.mColorSettingViewListener.onChangeSelected(list2);
                }
            }
        });
        this.mColorSettingPopup.show();
        ColorSettingViewListener colorSettingViewListener = this.mColorSettingViewListener;
        if (colorSettingViewListener != null) {
            colorSettingViewListener.onVisibilityChanged(0);
        }
        this.mColorSettingPopup.setOnActionListener(new SpenColorSettingPopup.OnActionListener() { // from class: com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorSetting.3
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingPopup.OnActionListener
            public void OnDone(int i2) {
                if (ColorSetting.this.mColorSettingViewListener != null) {
                    ColorSetting.this.mColorSettingViewListener.onDone();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingPopup.OnActionListener
            public void onCancel() {
                if (ColorSetting.this.mColorSettingViewListener != null) {
                    ColorSetting.this.mColorSettingViewListener.onCancel();
                }
            }
        });
        this.mColorSettingPopup.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorSetting.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (ColorSetting.this.mColorSettingViewListener != null) {
                    ColorSetting.this.mColorSettingViewListener.onVisibilityChanged(8);
                }
            }
        });
    }
}
