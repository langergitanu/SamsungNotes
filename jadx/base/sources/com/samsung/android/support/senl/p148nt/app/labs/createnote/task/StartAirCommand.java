package com.samsung.android.support.senl.p148nt.app.labs.createnote.task;

import android.content.Intent;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class StartAirCommand extends Task {
    private static final String ACTION_MEMO_AIRCOMMAND = "com.samsung.action.ACTION_MEMO_AIRCOMMAND";
    private static final String TAG = "StartAirCommand";

    @Override // java.lang.Runnable
    public void run() {
        Logger.m7100d(TAG, "run");
        Intent intent = new Intent("com.samsung.action.ACTION_MEMO_AIRCOMMAND");
        intent.setComponent(createComponentName());
        ServiceManager.INSTANCE.getInstance().startServiceAsUser(BaseUtils.getApplicationContext(), intent);
    }
}
