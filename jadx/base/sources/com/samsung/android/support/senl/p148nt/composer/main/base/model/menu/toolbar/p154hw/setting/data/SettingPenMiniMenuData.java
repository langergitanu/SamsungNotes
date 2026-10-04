package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.SPenPreferenceResolver;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingPenMiniMenuData {
    private static final String KEY_SETTING_PEN_MINI_ENABLE = "KEY_SETTING_PEN_MINI_ENABLE";
    private static final String KEY_SETTING_PEN_MINI_VIEW_MODE = "KEY_SETTING_PEN_MINI_VIEW_MODE";
    private boolean mIsFavoriteMode = SPenPreferenceResolver.getBoolean(KEY_SETTING_PEN_MINI_VIEW_MODE, false);
    private boolean mIsPenMiniMode = SPenPreferenceResolver.getBoolean(KEY_SETTING_PEN_MINI_ENABLE, false);

    public boolean getToggledFavoriteMode() {
        boolean zIsFavoriteMode = isFavoriteMode();
        setFavoriteMode(!zIsFavoriteMode);
        return !zIsFavoriteMode;
    }

    public boolean isEnable() {
        return this.mIsPenMiniMode;
    }

    public boolean isFavoriteMode() {
        return this.mIsFavoriteMode;
    }

    public void setEnable(boolean z) {
        this.mIsPenMiniMode = z;
        SPenPreferenceResolver.setBoolean(KEY_SETTING_PEN_MINI_ENABLE, z);
    }

    public void setFavoriteMode(boolean z) {
        this.mIsFavoriteMode = z;
        SPenPreferenceResolver.setBoolean(KEY_SETTING_PEN_MINI_VIEW_MODE, z);
    }
}
