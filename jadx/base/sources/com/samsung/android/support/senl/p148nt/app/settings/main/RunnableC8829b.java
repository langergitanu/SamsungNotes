package com.samsung.android.support.senl.p148nt.app.settings.main;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.main.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8829b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6330a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SettingsSyncHelper f6331b;

    public /* synthetic */ RunnableC8829b(SettingsSyncHelper settingsSyncHelper, int i) {
        this.f6330a = i;
        this.f6331b = settingsSyncHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6330a) {
            case 0:
                SettingsSyncHelper.handleSwitchPreferenceChange$lambda$5$lambda$4(this.f6331b);
                break;
            case 1:
                SettingsSyncHelper.onSCloudSettingSelected$lambda$11(this.f6331b);
                break;
            case 2:
                SettingsSyncHelper.startMicrosoftSyncSettingsActivity$lambda$8(this.f6331b);
                break;
            case 3:
                SettingsSyncHelper.startMicrosoftSyncSettingsActivity$lambda$9(this.f6331b);
                break;
            default:
                SettingsSyncHelper.handleActivityResults$lambda$12(this.f6331b);
                break;
        }
    }
}
