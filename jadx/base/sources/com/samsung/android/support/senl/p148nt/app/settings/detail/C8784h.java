package com.samsung.android.support.senl.p148nt.app.settings.detail;

import androidx.preference.Preference;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.detail.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8784h implements Preference.OnPreferenceClickListener, Preference.OnPreferenceChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ SettingsPasswordAndBiometricsFragment f6308a;

    public /* synthetic */ C8784h(SettingsPasswordAndBiometricsFragment settingsPasswordAndBiometricsFragment) {
        this.f6308a = settingsPasswordAndBiometricsFragment;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        return SettingsPasswordAndBiometricsFragment.mOnPreferenceChangeListener$lambda$3(this.f6308a, preference, obj);
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        return SettingsPasswordAndBiometricsFragment.mOnPreferenceClickListener$lambda$2(this.f6308a, preference);
    }
}
