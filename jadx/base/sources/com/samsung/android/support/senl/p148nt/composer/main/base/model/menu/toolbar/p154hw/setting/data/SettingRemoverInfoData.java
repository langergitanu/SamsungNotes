package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.LegacyVersionException;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingRemoverInfoData extends AbsMigrationPolicy<SpenSettingRemoverInfo> {
    private static final String KEY_SETTING_REMOVER_INFO = "KEY_SETTING_REMOVER_INFO";
    private static final String TAG = Logger.createTag("SettingRemoverInfoData");
    private SpenSettingRemoverInfo mRemoverInfo;

    public SettingRemoverInfoData() {
        super(KEY_SETTING_REMOVER_INFO);
        SpenSettingRemoverInfo spenSettingRemoverInfo = new SpenSettingRemoverInfo();
        this.mRemoverInfo = spenSettingRemoverInfo;
        super.restore(spenSettingRemoverInfo);
    }

    public static void convertToSpenSettingRemoverInfo(SpenSettingRemoverInfo spenSettingRemoverInfo, String str) {
        String[] strArrSplit = str.split(":");
        spenSettingRemoverInfo.type = Integer.parseInt(strArrSplit[0]);
        spenSettingRemoverInfo.target = Integer.parseInt(strArrSplit[1]);
        spenSettingRemoverInfo.size = Float.parseFloat(strArrSplit[2]);
    }

    public static String convertToString(SpenSettingRemoverInfo spenSettingRemoverInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(spenSettingRemoverInfo.type);
        sb.append(":");
        sb.append(spenSettingRemoverInfo.target);
        sb.append(":");
        return AbstractC1038a.m1217r(sb, ":", spenSettingRemoverInfo.size);
    }

    private void loadDefaultInfo(SpenSettingRemoverInfo spenSettingRemoverInfo) {
        spenSettingRemoverInfo.type = 1;
        spenSettingRemoverInfo.target = 0;
        spenSettingRemoverInfo.size = 1.0f;
    }

    private void loadPreferenceRemoverInfo(SpenSettingRemoverInfo spenSettingRemoverInfo, String str) {
        Logger.m11003i(TAG, "loadPreferenceRemoverInfo buf = " + str);
        convertToSpenSettingRemoverInfo(spenSettingRemoverInfo, str);
    }

    private void saveRemoverData() {
        String infoString = getInfoString();
        AbstractC8014b.m7197C("saveRemoverData : ", infoString, TAG);
        super.saveData(infoString);
    }

    public void close() {
        this.mRemoverInfo = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public String getInfoString() {
        return convertToString(this.mRemoverInfo);
    }

    public SpenSettingRemoverInfo getSettingRemoverInfoSelected() {
        return this.mRemoverInfo;
    }

    public void initSettingDataForCoEdit() {
        this.mRemoverInfo.type = 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public boolean replace(String str) {
        return super.replace(this.mRemoverInfo, str);
    }

    public void setSettingRemoverInfo(SpenSettingRemoverInfo spenSettingRemoverInfo) {
        this.mRemoverInfo = spenSettingRemoverInfo;
        saveRemoverData();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadDefault(SpenSettingRemoverInfo spenSettingRemoverInfo) {
        loadDefaultInfo(spenSettingRemoverInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadPreference(SpenSettingRemoverInfo spenSettingRemoverInfo, String str) {
        loadPreferenceRemoverInfo(spenSettingRemoverInfo, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void migrate(SpenSettingRemoverInfo spenSettingRemoverInfo, LegacyVersionException legacyVersionException) {
        loadPreferenceRemoverInfo(spenSettingRemoverInfo, legacyVersionException.getValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void store(SpenSettingRemoverInfo spenSettingRemoverInfo) {
        saveRemoverData();
    }
}
