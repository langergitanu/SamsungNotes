package com.samsung.android.app.notes.sync.synchronization.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p026F1.C0099c;
import p101Z.InterfaceC0349a;
import p249v1.C14499b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SyncOldService extends Service {
    private static final String TAG = "SyncOldService";
    static InterfaceC0349a mBindServiceContract;
    private C14499b mSyncLogic;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public SyncOldService getService() {
            return SyncOldService.this;
        }
    }

    public static void setServiceContract(InterfaceC0349a interfaceC0349a) {
        mBindServiceContract = interfaceC0349a;
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return new LocalBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Debugger.m8615i(TAG, "[Service] onCreate()");
        C14499b c14499b = new C14499b();
        this.mSyncLogic = c14499b;
        C14499b.f10317k = mBindServiceContract;
        c14499b.m15088d();
        Debugger.m8615i(TAG, "[Service] onCreate() finish");
    }

    @Override // android.app.Service
    public void onDestroy() {
        Debugger.m8615i(TAG, "[Service] onDestroy()");
        InterfaceC0349a interfaceC0349a = mBindServiceContract;
        if (interfaceC0349a != null) {
            interfaceC0349a.onDestroy();
        } else {
            Debugger.m8609e(TAG, "[Service] onDestroy() : mBindServiceContract == null!");
        }
        this.mSyncLogic.getClass();
        C14499b.m15082a();
        Debugger.m8615i(TAG, "[Service] onDestroy() finish");
        super.onDestroy();
    }

    public void requestSync(C0099c c0099c) {
        this.mSyncLogic.m15089g(c0099c);
    }

    public void stopSync(int i) {
        this.mSyncLogic.getClass();
        C14499b.m15087h(i);
    }
}
