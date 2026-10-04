package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.HwBeautifierLanguageDialogFragment;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC10239i implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7128a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7129b;

    public /* synthetic */ ViewOnClickListenerC10239i(Object obj, int i) {
        this.f7128a = i;
        this.f7129b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7128a) {
            case 0:
                ((HwBeautifierLanguageDialogFragment.AddLanguageHolder) this.f7129b).lambda$new$0(view);
                break;
            case 1:
                ((HwBeautifierLanguageDialogFragment.ViewHolder) this.f7129b).lambda$new$0(view);
                break;
            case 2:
                ((ConvertSettingDialogFragment) this.f7129b).lambda$onCreateDialog$0(view);
                break;
            default:
                ((DirectWriteSettingDialogFragment) this.f7129b).lambda$initLayoutToAddLanguage$1(view);
                break;
        }
    }
}
