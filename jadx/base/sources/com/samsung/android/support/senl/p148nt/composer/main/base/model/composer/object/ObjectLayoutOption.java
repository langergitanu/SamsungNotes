package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ObjectLayoutOption {
    public static int LAYOUT_NORMAL = 0;
    public static int LAYOUT_WRAP_TEXT_AROUND = 1;
    public static int LAYOUT_WRAP_TEXT_BEHIND = 2;
    private static final boolean SETTING_FIT_WIDTH_DEFAULT = false;
    private static final String SETTING_FIT_WIDTH_ENABLED = "setting_fit_width_enabled";
    private static final String SETTING_OBJECT_LAYOUT = "setting_object_layout";
    private final boolean mIsObjectSpanSupported;

    public ObjectLayoutOption(boolean z) {
        this.mIsObjectSpanSupported = z;
    }

    public int getLayoutType() {
        return SharedPreferencesCompat.getInstance("Composer").getInt(SETTING_OBJECT_LAYOUT, LAYOUT_WRAP_TEXT_BEHIND);
    }

    public boolean isFitWidthEnabled() {
        return SharedPreferencesCompat.getInstance("Composer").getBoolean(SETTING_FIT_WIDTH_ENABLED, false);
    }

    public boolean isObjectSpanOptionEnabled() {
        return this.mIsObjectSpanSupported && SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_ANCHOR_TO_TEXT_ENABLED, true);
    }

    public boolean isObjectSpanSupported() {
        return this.mIsObjectSpanSupported;
    }

    public void setFitWidth(boolean z) {
        SharedPreferencesCompat.getInstance("Composer").putBoolean(SETTING_FIT_WIDTH_ENABLED, z);
    }

    public void setLayoutType(int i) {
        SharedPreferencesCompat.getInstance("Composer").putInt(SETTING_OBJECT_LAYOUT, i);
    }

    public void setObjectSpanOption(boolean z) {
        SharedPreferencesCompat.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_ANCHOR_TO_TEXT_ENABLED, z);
    }

    public boolean isFitWidthEnabled(SpenObjectBase spenObjectBase) {
        return spenObjectBase.getType() == 3 && isFitWidthEnabled();
    }
}
