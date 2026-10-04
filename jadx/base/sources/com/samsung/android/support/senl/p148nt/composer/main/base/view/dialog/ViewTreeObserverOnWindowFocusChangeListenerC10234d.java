package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.view.ViewTreeObserver;
import androidx.fragment.app.DialogFragment;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewTreeObserverOnWindowFocusChangeListenerC10234d implements ViewTreeObserver.OnWindowFocusChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7118a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DialogFragment f7119b;

    public /* synthetic */ ViewTreeObserverOnWindowFocusChangeListenerC10234d(DialogFragment dialogFragment, int i) {
        this.f7118a = i;
        this.f7119b = dialogFragment;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean z) {
        switch (this.f7118a) {
            case 0:
                ((ConvertSettingDialogFragment) this.f7119b).lambda$init$2(z);
                break;
            case 1:
                ((DirectWriteSettingDialogFragment) this.f7119b).lambda$init$3(z);
                break;
            default:
                ((HwBeautifierLanguageDialogFragment) this.f7119b).lambda$init$1(z);
                break;
        }
    }
}
