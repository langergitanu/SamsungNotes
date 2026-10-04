package com.samsung.android.support.senl.p148nt.app.converter;

import android.content.DialogInterface;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseBiometricView;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseOldBiometricView;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.converter.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DialogInterfaceOnCancelListenerC8050a implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6102a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6103b;

    public /* synthetic */ DialogInterfaceOnCancelListenerC8050a(Object obj, int i) {
        this.f6102a = i;
        this.f6103b = obj;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        switch (this.f6102a) {
            case 0:
                ((ConverterDialogManager) this.f6103b).lambda$showProgressDialog$0(dialogInterface);
                break;
            case 1:
                ((AbsBaseBiometricView) this.f6103b).lambda$showTimerDialog$1(dialogInterface);
                break;
            default:
                ((AbsBaseOldBiometricView) this.f6103b).lambda$showTimerDialog$1(dialogInterface);
                break;
        }
    }
}
