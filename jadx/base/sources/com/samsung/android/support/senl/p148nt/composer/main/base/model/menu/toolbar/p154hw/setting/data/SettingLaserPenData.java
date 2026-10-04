package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.SpenSettingUILaserPenInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.Default;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.LegacyVersionException;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingLaserPenData extends AbsMigrationPolicy<SpenSettingUILaserPenInfo> {
    private static final String DIVIDE = ";";
    private static final String KEY_SETTING_LASER_PEN_INFO = "KEY_SETTING_LASER_PEN_INFO_2";
    private static final String TAG = Logger.createTag("SettingLaserPenData");
    private final SpenSettingUILaserPenInfo mLaserPenInfo;

    public SettingLaserPenData() {
        super(KEY_SETTING_LASER_PEN_INFO);
        SpenSettingUILaserPenInfo spenSettingUILaserPenInfo = new SpenSettingUILaserPenInfo();
        this.mLaserPenInfo = spenSettingUILaserPenInfo;
        restore(spenSettingUILaserPenInfo);
    }

    public static void convertToSpenSettingLaserPenInfo(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo, String str) {
        String[] strArrSplit = str.split(";");
        int length = strArrSplit.length;
        spenSettingUILaserPenInfo.type = Integer.parseInt(strArrSplit[0]);
        spenSettingUILaserPenInfo.color = Integer.parseInt(strArrSplit[1]);
        spenSettingUILaserPenInfo.colorUIInfo = Integer.parseInt(strArrSplit[2]);
        spenSettingUILaserPenInfo.hsvColor[0] = Float.parseFloat(strArrSplit[3]);
        spenSettingUILaserPenInfo.hsvColor[1] = Float.parseFloat(strArrSplit[4]);
        spenSettingUILaserPenInfo.hsvColor[2] = Float.parseFloat(strArrSplit[5]);
        if (length > 6) {
            spenSettingUILaserPenInfo.fillInside = Integer.parseInt(strArrSplit[6]) == 1;
            spenSettingUILaserPenInfo.colorOption = Integer.parseInt(strArrSplit[7]);
        }
    }

    public static String convertToString(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo) {
        return spenSettingUILaserPenInfo.type + ";" + spenSettingUILaserPenInfo.color + ";" + spenSettingUILaserPenInfo.colorUIInfo + ";" + spenSettingUILaserPenInfo.hsvColor[0] + ";" + spenSettingUILaserPenInfo.hsvColor[1] + ";" + spenSettingUILaserPenInfo.hsvColor[2] + ";" + String.valueOf(spenSettingUILaserPenInfo.fillInside ? 1 : 0) + ";" + spenSettingUILaserPenInfo.colorOption;
    }

    private void saveLaserPenData() {
        if (this.mLaserPenInfo == null) {
            return;
        }
        saveData(getInfoString());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public String getInfoString() {
        return convertToString(this.mLaserPenInfo);
    }

    public SpenSettingUILaserPenInfo getLaserPenInfo() {
        return this.mLaserPenInfo;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public boolean replace(String str) {
        return super.replace(this.mLaserPenInfo, str);
    }

    public void setLaserPenInfo(@NonNull SpenSettingUILaserPenInfo spenSettingUILaserPenInfo) {
        this.mLaserPenInfo.copy(spenSettingUILaserPenInfo);
        saveLaserPenData();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadDefault(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo) {
        spenSettingUILaserPenInfo.type = 1;
        spenSettingUILaserPenInfo.fillInside = true;
        spenSettingUILaserPenInfo.colorOption = 1;
        spenSettingUILaserPenInfo.color = Default.LASER_PEN_COLOR;
        spenSettingUILaserPenInfo.colorUIInfo = Default.LASER_PEN_COLOR_UI_INFO;
        ColorCompat.colorToHSV(Default.LASER_PEN_COLOR, spenSettingUILaserPenInfo.hsvColor);
        Logger.m11003i(TAG, "loadDefault " + spenSettingUILaserPenInfo.toString());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadPreference(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo, String str) {
        convertToSpenSettingLaserPenInfo(spenSettingUILaserPenInfo, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void migrate(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo, LegacyVersionException legacyVersionException) {
        Logger.m11003i(TAG, "migrateByVersion " + legacyVersionException.getVersion().name());
        loadPreference(spenSettingUILaserPenInfo, legacyVersionException.getValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void store(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo) {
        saveLaserPenData();
    }
}
