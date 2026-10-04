package com.samsung.android.support.senl.p148nt.coedit.caller.updownloader;

import android.content.ServiceConnection;
import com.samsung.android.support.senl.p148nt.coedit.service.CoeditService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CoeditServiceConnection implements ServiceConnection {
    protected CoeditService mService;

    public void unsubscribe(String str) {
        CoeditService coeditService = this.mService;
        if (coeditService != null) {
            coeditService.unsubscribe(str);
            this.mService = null;
        }
    }
}
