package com.samsung.android.support.senl.p148nt.app.settings.detail;

import androidx.preference.Preference;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.detail.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8782f implements Preference.OnPreferenceClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6304a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SettingsNotesAssistPrefFragment f6305b;

    public /* synthetic */ C8782f(SettingsNotesAssistPrefFragment settingsNotesAssistPrefFragment, int i) {
        this.f6304a = i;
        this.f6305b = settingsNotesAssistPrefFragment;
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public final boolean onPreferenceClick(Preference preference) {
        switch (this.f6304a) {
            case 0:
                return SettingsNotesAssistPrefFragment.initNotesAssistMoreAdvancedIntelligenceFeature$lambda$17(this.f6305b, preference);
            case 1:
                return SettingsNotesAssistPrefFragment.updateAutoTranscribe$lambda$12(this.f6305b, preference);
            case 2:
                return SettingsNotesAssistPrefFragment.initNotesAssistOnDevice$lambda$13(this.f6305b, preference);
            default:
                return SettingsNotesAssistPrefFragment.initNotesAssistLanguagePackForDownload$lambda$14(this.f6305b, preference);
        }
    }
}
