package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import com.samsung.android.sdk.pen.engine.SpenToastActionListener;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenToastActionListenerImpl extends SpenToastActionListener {
    @Override // com.samsung.android.sdk.pen.engine.SpenToastActionListener
    public void show(CharSequence charSequence, int i) {
        if (charSequence == null) {
            Logger.m11000e("SpenToastActionListenerImpl", "show# charSequence is null");
        } else {
            ToastHandler.show(BaseUtils.getApplicationContext(), charSequence.toString(), i);
        }
    }
}
