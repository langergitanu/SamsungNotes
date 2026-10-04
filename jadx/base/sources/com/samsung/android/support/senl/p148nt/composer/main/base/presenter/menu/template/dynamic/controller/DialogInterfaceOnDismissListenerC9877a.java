package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller;

import android.content.DialogInterface;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.dynamic.controller.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DialogInterfaceOnDismissListenerC9877a implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7037a;

    public /* synthetic */ DialogInterfaceOnDismissListenerC9877a(int i) {
        this.f7037a = i;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.f7037a) {
            case 0:
                DynamicTemplateImageController.showImagePicker$lambda$0(dialogInterface);
                break;
            default:
                DialogUtils.clearOverSizeItemsDialog();
                break;
        }
    }
}
