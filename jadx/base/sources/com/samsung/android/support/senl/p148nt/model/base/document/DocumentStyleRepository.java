package com.samsung.android.support.senl.p148nt.model.base.document;

import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class DocumentStyleRepository {
    private static final String TAG = ModelLogger.createTag("DocumentStyleRepository");
    private final SharedPreferencesCompat mPreference = SharedPreferencesCompat.getInstance("Settings");

    private String getTemplatePath() {
        return this.mPreference.getString(SettingsConstants.SETTINGS_PAGE_TEMPLATE, "0");
    }

    private boolean isTemplatePathType(int i) {
        return i == 11 || i == 14 || i == 17 || i == 20 || i == 23 || i == 3 || i == 5;
    }

    private void setDefaultTemplateData() {
        DataLogger.m12307i(TAG, "setDefaultTemplateData#");
        this.mPreference.putInt(SettingsConstants.SETTINGS_TEMPLATE_TYPE, 10);
        this.mPreference.putString(SettingsConstants.SETTINGS_PAGE_TEMPLATE, "0");
    }

    public void checkDefaultTemplateData() {
        String templatePath;
        if (!isTemplatePathType(getTemplateType()) || (templatePath = getTemplatePath()) == null || FileUtils.exists(templatePath)) {
            return;
        }
        setDefaultTemplateData();
    }

    public boolean deleteTemplateData(@Nullable String str) {
        if (str == null || !isTemplatePathType(getTemplateType()) || !str.equals(getTemplatePath())) {
            return false;
        }
        setDefaultTemplateData();
        return true;
    }

    public Pair<Integer, String> getDefaultTemplate() {
        checkDefaultTemplateData();
        int templateType = getTemplateType();
        String templatePath = getTemplatePath();
        int i = 0;
        if (templateType != 10 && templateType != 13 && templateType != 16 && templateType != 19 && templateType != 22) {
            if (templateType == 3) {
                i = 12;
            } else if (templateType == 11 || templateType == 14 || templateType == 17 || templateType == 20 || templateType == 23 || templateType == 5) {
                i = 16;
            } else {
                DataLogger.m12303e(TAG, "getDefaultTemplate#  type = " + templateType + " / " + templatePath);
            }
            return new Pair<>(Integer.valueOf(i), templatePath);
        }
        if (templatePath != null && !templatePath.isEmpty()) {
            i = Integer.parseInt(templatePath);
        }
        templatePath = null;
        return new Pair<>(Integer.valueOf(i), templatePath);
    }

    public int getPageStyle() {
        return SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1);
    }

    public int getTemplateType() {
        int i = this.mPreference.getInt(SettingsConstants.SETTINGS_TEMPLATE_TYPE, 10);
        if (i != 1 && i != 7) {
            return i;
        }
        DataLogger.m12307i(TAG, "getTemplateType# Legacy Template Type - reset default template");
        this.mPreference.putInt(SettingsConstants.SETTINGS_TEMPLATE_TYPE, 10);
        this.mPreference.putString(SettingsConstants.SETTINGS_PAGE_TEMPLATE, "0");
        return 10;
    }

    public boolean isBackgroundInvertibleTemplateType() {
        int templateType = getTemplateType();
        DataLogger.m12307i(TAG, "isBackgroundInvertibleTemplateType# templateType: " + templateType);
        return templateType == 10 || templateType == 13 || templateType == 16 || templateType == 19 || templateType == 22;
    }
}
