package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10244n implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7138a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7139b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f7140c;

    public /* synthetic */ RunnableC10244n(Object obj, Object obj2, int i) {
        this.f7138a = i;
        this.f7139b = obj;
        this.f7140c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7138a) {
            case 0:
                ((RenameDialogCommonFragment.C101919) this.f7139b).lambda$afterTextChanged$0((Editable) this.f7140c);
                break;
            case 1:
                ((DirectWriteSettingDialogFragment) this.f7139b).lambda$initLayoutToAddLanguage$0((Activity) this.f7140c);
                break;
            default:
                ((RenameDialogCommonFragment) this.f7139b).lambda$initEditText$0((Bundle) this.f7140c);
                break;
        }
    }
}
