package com.samsung.android.support.senl.p148nt.app.settings.detail;

import androidx.preference.Preference;
import com.samsung.android.support.senl.p148nt.app.settings.common.handler.SettingsGlobalSyncStatusHandler;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.detail.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8789m implements SettingsGlobalSyncStatusHandler.Listener, Preference.OnPreferenceChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ SettingsSyncWithSamsungAccountPrefFragment f6321a;

    public /* synthetic */ C8789m(SettingsSyncWithSamsungAccountPrefFragment settingsSyncWithSamsungAccountPrefFragment) {
        this.f6321a = settingsSyncWithSamsungAccountPrefFragment;
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.common.handler.SettingsGlobalSyncStatusHandler.Listener
    public void onGlobalSyncChanged() {
        SettingsSyncWithSamsungAccountPrefFragment.initializeGlobalSyncStatusHandler$lambda$6(this.f6321a);
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        return SettingsSyncWithSamsungAccountPrefFragment.initLayout$lambda$17$lambda$14(this.f6321a, preference, obj);
    }
}
