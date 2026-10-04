package com.samsung.android.app.notes.sync.coedit.controllers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.samsung.android.app.notes.sync.coedit.service.CoeditShareOldService;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.List;
import p033H0.C0112b;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.coedit.controllers.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6666b {

    /* JADX INFO: renamed from: a */
    public Context f3945a;

    /* JADX INFO: renamed from: a */
    public final void m4728a(String str, List list) {
        final C0112b c0112b = new C0112b(str, list);
        Context context = this.f3945a;
        if (context != null) {
            Intent intent = new Intent(context, (Class<?>) CoeditShareOldService.class);
            Debugger.m8607d("CoeditShareOldServiceController", "bindService");
            context.bindService(intent, new ServiceConnection() { // from class: com.samsung.android.app.notes.sync.coedit.controllers.CoeditShareOldServiceController$9
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Debugger.m8607d("CoeditShareOldServiceController", "onServiceConnected()");
                    if (c0112b != null) {
                        CoeditShareOldService service = ((CoeditShareOldService.LocalBinder) iBinder).getService();
                        C0112b c0112b2 = (C0112b) c0112b;
                        c0112b2.getClass();
                        Debugger.m8607d("CoeditShareOldServiceController", "onReady() for request delete");
                        service.requestDelete((String) c0112b2.f363b, (List) c0112b2.f362a);
                        Debugger.m8607d("CoeditShareOldServiceController", "unbindService");
                        this.this$0.f3945a.unbindService(this);
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    Debugger.m8607d("CoeditShareOldServiceController", "onServiceDisconnected()");
                }
            }, 1);
        }
    }
}
