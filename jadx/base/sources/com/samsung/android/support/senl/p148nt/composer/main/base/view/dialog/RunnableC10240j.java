package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.HwBeautifierLanguageDialogFragment;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10240j implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7130a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7131b;

    public /* synthetic */ RunnableC10240j(Object obj, int i) {
        this.f7130a = i;
        this.f7131b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f7130a;
        Object obj = this.f7131b;
        switch (i) {
            case 0:
                int i2 = HwBeautifierLanguageDialogFragment.AddLanguageHolder.f7111a;
                ((HwBeautifierLanguageDialogFragment) obj).openLanguageDownloader();
                break;
            default:
                ((DialogContract.IVoiceDialogPresenter) obj).cancelRecording();
                break;
        }
    }
}
