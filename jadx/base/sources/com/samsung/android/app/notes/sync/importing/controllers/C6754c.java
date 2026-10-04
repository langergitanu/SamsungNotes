package com.samsung.android.app.notes.sync.importing.controllers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.samsung.android.app.notes.sync.importing.services.ImportService;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p086V.C0322h;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.importing.controllers.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6754c {
    /* JADX INFO: renamed from: a */
    public final void m4894a(final InterfaceC6755d interfaceC6755d, final boolean z) {
        final Context appContext = C0322h.m670a().f815a.getAppContext();
        appContext.bindService(new Intent(appContext, (Class<?>) ImportService.class), new ServiceConnection() { // from class: com.samsung.android.app.notes.sync.importing.controllers.ImportController$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Debugger.m8607d("ImportController", "bindImportServiceAndExecute - onServiceConnected().");
                if (interfaceC6755d != null) {
                    ImportService service = ((ImportService.LocalBinder) iBinder).getService();
                    interfaceC6755d.mo4893b(service);
                    if (z) {
                        appContext.unbindService(this);
                    } else {
                        this.this$0.getClass();
                        service.addConnection(this);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Debugger.m8607d("ImportController", "bindImportServiceAndExecute - nServiceDisconnected().");
                this.this$0.getClass();
            }
        }, 1);
    }
}
