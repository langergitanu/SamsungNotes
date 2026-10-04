package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.select;

import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.ChangeTemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.TemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.p158sa.SAManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SelectedTemplateData {
    private static final String TAG = CTLogger.createTag("SelectedTemplateData");
    private final boolean mIsSettingMode;
    private String mSelectedTemplate;
    private int mSelectedTemplateType;

    public SelectedTemplateData(Bundle bundle) {
        this.mSelectedTemplateType = bundle.getInt("template_type", 10);
        this.mSelectedTemplate = bundle.getString(ChangeTemplateConstants.ARG_TEMPLATE_NAME);
        this.mIsSettingMode = TemplateConstants.isSettingMode(bundle.getInt(ChangeTemplateConstants.ARG_PAGE_TEMPLATE_CALLER, 1));
        init();
    }

    private void init() {
        if (TextUtils.isEmpty(this.mSelectedTemplate) && this.mSelectedTemplateType == 10) {
            this.mSelectedTemplate = "1";
        }
        loggerSelectedTemplateData();
    }

    private void loggerSelectedTemplateData() {
        String str = TAG;
        StringBuilder sb = new StringBuilder("SelectedTemplateData# selectedTemplateType:");
        sb.append(this.mSelectedTemplateType);
        sb.append(", SelectedTemplate:");
        AbstractC8014b.m7213o(sb, this.mSelectedTemplate, str);
    }

    public int getItemType() {
        return !TemplateViewType.isDefaultImageType(this.mSelectedTemplateType) ? 1 : 0;
    }

    public String getSelectedTemplate() {
        return this.mSelectedTemplate;
    }

    public int getSelectedTemplateType() {
        return this.mSelectedTemplateType;
    }

    public void setDefaultTemplateData() {
        this.mSelectedTemplateType = 10;
        this.mSelectedTemplate = "0";
    }

    public void setNoTemplateData() {
        this.mSelectedTemplateType = -1;
        this.mSelectedTemplate = null;
    }

    public void setSelectedTemplateData(int i, String str) {
        this.mSelectedTemplateType = i;
        this.mSelectedTemplate = str;
        if (this.mIsSettingMode) {
            SAManager.INSTANCE.onSelectTemplate(i, str);
            SharedPreferencesCompat.getInstance("Settings").putInt(SettingsConstants.SETTINGS_TEMPLATE_TYPE, i);
            SharedPreferencesCompat.getInstance("Settings").putString(SettingsConstants.SETTINGS_PAGE_TEMPLATE, str);
        }
    }

    public SelectedTemplateData(boolean z) {
        this.mSelectedTemplateType = SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_TEMPLATE_TYPE, 10);
        this.mSelectedTemplate = SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_PAGE_TEMPLATE, "0");
        this.mIsSettingMode = z;
        init();
    }

    public SelectedTemplateData(int i, String str, boolean z) {
        this.mSelectedTemplateType = i;
        this.mSelectedTemplate = str;
        this.mIsSettingMode = z;
        init();
    }
}
