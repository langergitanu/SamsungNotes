package com.samsung.android.support.senl.p148nt.app.settings.detail;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.detail.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8777b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6293a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SettingsAutoTranscribePrefFragment f6294b;

    public /* synthetic */ RunnableC8777b(SettingsAutoTranscribePrefFragment settingsAutoTranscribePrefFragment, int i) {
        this.f6293a = i;
        this.f6294b = settingsAutoTranscribePrefFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6293a) {
            case 0:
                this.f6294b.updateLanguageList();
                break;
            default:
                this.f6294b.updateAutoTranscriptionLanguageSummary();
                break;
        }
    }
}
