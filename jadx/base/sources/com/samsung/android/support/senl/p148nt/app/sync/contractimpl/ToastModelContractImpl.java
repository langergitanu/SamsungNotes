package com.samsung.android.support.senl.p148nt.app.sync.contractimpl;

import android.content.Context;
import com.samsung.android.app.notes.sync.infos.ModelType;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.toast.ToastModelHelper;
import p120b0.InterfaceC4176a;
import p260z0.C14518a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ToastModelContractImpl implements InterfaceC4176a {
    public void showError(Context context, C14518a c14518a) {
        new ToastModelHelper().showError(context, c14518a);
    }

    @Override // p120b0.InterfaceC4176a
    public void showInfo(Context context, ModelType modelType, String str) {
        new ToastModelHelper().showInfo(context, modelType, str);
    }
}
