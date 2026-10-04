package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.HwBeautifierLanguageDialogFragment;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10241k implements HwBeautifierLanguageDialogFragment.AdapterContract, TextRecognitionLanguageDownloadHelper.InitFinishedListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7132a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7133b;

    public /* synthetic */ C10241k(Object obj, int i) {
        this.f7132a = i;
        this.f7133b = obj;
    }

    @Override // com.samsung.android.support.senl.nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper.InitFinishedListener
    public void onInitFinished() {
        switch (this.f7132a) {
            case 1:
                ((ConvertSettingDialogFragment) this.f7133b).lambda$updateLayout$5();
                break;
            case 2:
                ((DirectWriteSettingDialogFragment) this.f7133b).lambda$onResume$4();
                break;
            default:
                ((HwBeautifierLanguageDialogFragment) this.f7133b).updateLanguageList();
                break;
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.HwBeautifierLanguageDialogFragment.AdapterContract
    public void onSelectItem(int i) {
        ((HwBeautifierLanguageDialogFragment.RecognitionLanguageAdapter) this.f7133b).lambda$onCreateViewHolder$0(i);
    }
}
