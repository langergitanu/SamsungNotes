package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.SPenVersion;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.LegacyVersionException;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingSelectionInfoData extends AbsMigrationPolicy<SpenSettingSelectionInfo> {
    private static final String KEY_SETTING_SELECTION_INFO = "KEY_SETTING_SELECTION_INFO";
    private static final String TAG = Logger.createTag("SettingSelectionInfoData");
    public static final int VERSION_CODE_OF_INCLUDE_PARTIALLY_SELECTED_FORCIBLY = 440064000;
    private SpenSettingSelectionInfo mSelectionInfo;

    public SettingSelectionInfoData() {
        super(KEY_SETTING_SELECTION_INFO);
        SpenSettingSelectionInfo spenSettingSelectionInfo = new SpenSettingSelectionInfo();
        this.mSelectionInfo = spenSettingSelectionInfo;
        super.restore(spenSettingSelectionInfo);
    }

    public static void convertToSpenSettingSelectionInfo(SpenSettingSelectionInfo spenSettingSelectionInfo, String str) {
        String[] strArrSplit = str.split(":");
        spenSettingSelectionInfo.type = Integer.parseInt(strArrSplit[0]);
        spenSettingSelectionInfo.includePartiallySelected = Boolean.parseBoolean(strArrSplit[1]);
    }

    public static String convertToString(SpenSettingSelectionInfo spenSettingSelectionInfo) {
        return spenSettingSelectionInfo.type + ":" + spenSettingSelectionInfo.includePartiallySelected;
    }

    private void migrateSelectionInfoUntil_4_2(SpenSettingSelectionInfo spenSettingSelectionInfo, String str) {
        spenSettingSelectionInfo.type = Integer.parseInt(str.split(":")[0]);
        int i = SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREVIOUS_VERSION, 0);
        String str2 = TAG;
        AbstractC8014b.m7217s(i, "migrateSelectionInfoUntil_4_2# previousVersion ", str2);
        if (i < 440064000) {
            spenSettingSelectionInfo.includePartiallySelected = false;
        } else {
            spenSettingSelectionInfo.includePartiallySelected = true;
        }
        AbstractC8014b.m7222x(new StringBuilder("migrateSelectionInfoUntil_4_2# includePartiallySelected set to "), spenSettingSelectionInfo.includePartiallySelected, str2);
    }

    private void saveSelectionData() {
        String infoString = getInfoString();
        AbstractC8014b.m7197C("saveSelectionData : ", infoString, TAG);
        super.saveData(infoString);
    }

    public void close() {
        this.mSelectionInfo = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public String getInfoString() {
        return convertToString(this.mSelectionInfo);
    }

    public SpenSettingSelectionInfo getSettingSelectionInfo() {
        return this.mSelectionInfo;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public boolean replace(String str) {
        return super.replace(this.mSelectionInfo, str);
    }

    public void setSettingSelectionInfo(@NonNull SpenSettingSelectionInfo spenSettingSelectionInfo) {
        SpenSettingSelectionInfo spenSettingSelectionInfo2 = this.mSelectionInfo;
        spenSettingSelectionInfo2.type = spenSettingSelectionInfo.type;
        spenSettingSelectionInfo2.includePartiallySelected = spenSettingSelectionInfo.includePartiallySelected;
        saveSelectionData();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadDefault(SpenSettingSelectionInfo spenSettingSelectionInfo) {
        spenSettingSelectionInfo.type = 0;
        spenSettingSelectionInfo.includePartiallySelected = true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadPreference(SpenSettingSelectionInfo spenSettingSelectionInfo, String str) {
        convertToSpenSettingSelectionInfo(spenSettingSelectionInfo, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void migrate(SpenSettingSelectionInfo spenSettingSelectionInfo, LegacyVersionException legacyVersionException) {
        SPenVersion.Version version = legacyVersionException.getVersion();
        Logger.m11003i(TAG, "migrateByVersion " + version.name());
        if (version.ordinal() <= SPenVersion.Version.V4_2.ordinal()) {
            migrateSelectionInfoUntil_4_2(spenSettingSelectionInfo, legacyVersionException.getValue());
        } else {
            convertToSpenSettingSelectionInfo(spenSettingSelectionInfo, legacyVersionException.getValue());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void store(SpenSettingSelectionInfo spenSettingSelectionInfo) {
        saveSelectionData();
    }
}
