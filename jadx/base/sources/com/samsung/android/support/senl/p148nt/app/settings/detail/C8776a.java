package com.samsung.android.support.senl.p148nt.app.settings.detail;

import androidx.preference.Preference;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SwitchPreference;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.detail.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8776a implements Preference.OnPreferenceClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6291a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SwitchPreference f6292b;

    public /* synthetic */ C8776a(SwitchPreference switchPreference, int i) {
        this.f6291a = i;
        this.f6292b = switchPreference;
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public final boolean onPreferenceClick(Preference preference) {
        switch (this.f6291a) {
            case 0:
                return SettingsAutoTranscribePrefFragment.initAutoTranscribeSwitch$lambda$2(this.f6292b, preference);
            default:
                return SettingsNotesAssistPrefFragment.initNotesAssistSwitch$lambda$6(this.f6292b, preference);
        }
    }
}
