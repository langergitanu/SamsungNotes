package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.SPenPreferenceResolver;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingColorPickerData {
    private static final String KEY_SETTING_COLOR_PICKER_VIEW_MODE = "KEY_SETTING_COLOR_PICKER_VIEW_MODE";
    private static final String TAG = Logger.createTag("SettingColorPickerData");
    private int mColorPickerViewMode;

    public SettingColorPickerData() {
        loadColorPickerViewModeData();
        saveColorPickerViewModeData();
    }

    private void loadColorPickerViewModeData() {
        this.mColorPickerViewMode = SPenPreferenceResolver.getInt(KEY_SETTING_COLOR_PICKER_VIEW_MODE, 2);
        AbstractC8014b.m7195A(new StringBuilder("ColorPickerViewMode : "), TAG, this.mColorPickerViewMode);
    }

    private void saveColorPickerViewModeData() {
        Logger.m11003i(TAG, "saveColorPickerViewModeData : " + getColorPickerViewMode());
        SPenPreferenceResolver.setInt(KEY_SETTING_COLOR_PICKER_VIEW_MODE, getColorPickerViewMode());
    }

    public int getColorPickerViewMode() {
        return this.mColorPickerViewMode;
    }

    public void setColorPickerViewMode(int i) {
        this.mColorPickerViewMode = i;
        saveColorPickerViewModeData();
    }
}
