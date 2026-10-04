package com.samsung.android.support.senl.p148nt.app.settings.detail;

import com.samsung.android.support.senl.p148nt.app.settings.common.component.SwitchPreference;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.detail.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8787k implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6314a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SwitchPreference f6315b;

    public /* synthetic */ RunnableC8787k(SwitchPreference switchPreference, int i) {
        this.f6314a = i;
        this.f6315b = switchPreference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6314a) {
            case 0:
                SettingsSyncWithSamsungAccountPrefFragment.onPreferenceClick$lambda$8$lambda$7(this.f6315b);
                break;
            default:
                SettingsSyncWithSamsungAccountPrefFragment.onActivityResult$lambda$12$lambda$11(this.f6315b);
                break;
        }
    }
}
