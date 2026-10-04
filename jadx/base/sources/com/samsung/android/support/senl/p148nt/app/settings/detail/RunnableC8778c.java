package com.samsung.android.support.senl.p148nt.app.settings.detail;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.detail.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8778c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6295a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SettingsDefaultNoteStyleFragment f6296b;

    public /* synthetic */ RunnableC8778c(SettingsDefaultNoteStyleFragment settingsDefaultNoteStyleFragment, int i) {
        this.f6295a = i;
        this.f6296b = settingsDefaultNoteStyleFragment;
    }

    @Override // java.lang.Runnable
    public final void run() throws Exception {
        switch (this.f6295a) {
            case 0:
                SettingsDefaultNoteStyleFragment.updateBlur$lambda$3(this.f6296b);
                break;
            default:
                SettingsDefaultNoteStyleFragment.setNestedScrollViewToFloatingView$lambda$9(this.f6296b);
                break;
        }
    }
}
