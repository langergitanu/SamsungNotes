package com.samsung.android.app.notes.sync.contentsharing.controllers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.samsung.android.app.notes.sync.contentsharing.service.ShareOldService;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.C6727e;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p211o0.C13567a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.controllers.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6684b {

    /* JADX INFO: renamed from: a */
    public Context f3986a;

    /* JADX INFO: renamed from: a */
    public final void m4777a(final InterfaceC6683a interfaceC6683a) {
        Context context = this.f3986a;
        if (context != null) {
            Intent intent = new Intent(context, (Class<?>) ShareOldService.class);
            Debugger.m8607d("ShareOldServiceController", "bindService");
            context.bindService(intent, new ServiceConnection() { // from class: com.samsung.android.app.notes.sync.contentsharing.controllers.ShareOldServiceController$9
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Debugger.m8607d("ShareOldServiceController", "onServiceConnected()");
                    if (interfaceC6683a != null) {
                        interfaceC6683a.mo251b(((ShareOldService.LocalBinder) iBinder).getService());
                        Debugger.m8607d("ShareOldServiceController", "unbindService");
                        this.this$0.f3986a.unbindService(this);
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    Debugger.m8607d("ShareOldServiceController", "onServiceDisconnected()");
                }
            }, 1);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m4778b(String str, boolean z) {
        Debugger.m8607d("ShareOldServiceController", "requestShareNow() : " + z);
        if (C6727e.m4819c()) {
            Debugger.m8607d("ShareOldServiceController", "Cancel share because of deletion.");
            return;
        }
        C13567a c13567a = new C13567a();
        c13567a.f9616b = str;
        c13567a.f9615a = z;
        m4777a(c13567a);
    }
}
