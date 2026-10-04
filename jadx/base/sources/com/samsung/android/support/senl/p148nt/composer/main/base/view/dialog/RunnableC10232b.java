package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10232b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7114a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ConvertSettingDialogFragment f7115b;

    public /* synthetic */ RunnableC10232b(ConvertSettingDialogFragment convertSettingDialogFragment, int i) {
        this.f7114a = i;
        this.f7115b = convertSettingDialogFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7114a) {
            case 0:
                this.f7115b.addLanguage();
                break;
            default:
                this.f7115b.addLanguage();
                break;
        }
    }
}
