package com.samsung.android.support.senl.p148nt.app.settings.detail;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.detail.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8783g implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6306a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SettingsNotesAssistPrefFragment f6307b;

    public /* synthetic */ RunnableC8783g(SettingsNotesAssistPrefFragment settingsNotesAssistPrefFragment, int i) {
        this.f6306a = i;
        this.f6307b = settingsNotesAssistPrefFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6306a) {
            case 0:
                this.f6307b.updateLanguageList();
                break;
            default:
                SettingsNotesAssistPrefFragment.updateLanguageList$lambda$5$lambda$4(this.f6307b);
                break;
        }
    }
}
