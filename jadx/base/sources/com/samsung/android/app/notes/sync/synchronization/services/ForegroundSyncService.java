package com.samsung.android.app.notes.sync.synchronization.services;

import android.app.Notification;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.NotificationConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceType;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import p001A.AbstractC0000a;
import p026F1.C0099c;
import p101Z.InterfaceC0349a;
import p249v1.C14499b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ForegroundSyncService extends SyncOldService {
    private static final int DIGITAL_LEGACY_NOTIFICATION = 1102;
    private static final String TAG = "ForegroundSyncService";
    static InterfaceC0349a mBindServiceContract;
    private C14499b mSyncLogic;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public ForegroundSyncService getService() {
            return ForegroundSyncService.this;
        }
    }

    private boolean isDigitalLegacyMode() {
        return UserManagerCompat.getInstance().isDigitalLegacyMode(getApplicationContext());
    }

    public static void setServiceContract(InterfaceC0349a interfaceC0349a) {
        mBindServiceContract = interfaceC0349a;
    }

    private void startForegroundNotification() {
        Notification.Builder builderCreateNotification = NotificationUtils.createNotification(getApplicationContext(), NotificationConstants.FOREGROUND_SYNC_NOTIFICATION_CHANNEL_ID, getString(C7943R.string.sync_tipcard_impoort_downloading_title));
        builderCreateNotification.setContentText(getString(C7943R.string.sync_tipcard_impoort_downloading_title));
        builderCreateNotification.setContentTitle(getString(C7943R.string.sync_tipcard_impoort_downloading_title));
        builderCreateNotification.setOngoing(true);
        if (Build.VERSION.SDK_INT >= 33) {
            startForeground(1102, builderCreateNotification.build(), 1);
        } else {
            startForeground(1102, builderCreateNotification.build());
        }
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.services.SyncOldService, android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return new LocalBinder();
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.services.SyncOldService, android.app.Service
    public void onCreate() {
        super.onCreate();
        Debugger.m8615i(TAG, "[Service] onCreate()");
        C14499b c14499b = new C14499b();
        this.mSyncLogic = c14499b;
        C14499b.f10317k = mBindServiceContract;
        c14499b.m15088d();
        if (isDigitalLegacyMode()) {
            try {
                ServiceManager.INSTANCE.getInstance().registerService(this, NotificationConstants.FOREGROUND_SYNC_NOTIFICATION_CHANNEL_ID, getResources().getString(C7943R.string.sync_tipcard_impoort_downloading_title), getResources().getString(C7943R.string.sync_tipcard_impoort_downloading_title), ServiceType.FOREGROUND, 0);
            } catch (RuntimeException unused) {
                ServiceManager.INSTANCE.getInstance().registerService(this, NotificationConstants.FOREGROUND_SYNC_NOTIFICATION_CHANNEL_ID, getResources().getString(C7943R.string.sync_tipcard_impoort_downloading_title), getResources().getString(C7943R.string.sync_tipcard_impoort_downloading_title), ServiceType.DEFAULT, 0);
            }
        }
        Debugger.m8615i(TAG, "[Service] onCreate() finish");
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.services.SyncOldService, android.app.Service
    public void onDestroy() {
        Debugger.m8615i(TAG, "[Service] onDestroy()");
        if (isDigitalLegacyMode()) {
            ServiceManager.INSTANCE.getInstance().unregisterService(this);
        }
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

    @Override // com.samsung.android.app.notes.sync.synchronization.services.SyncOldService
    public void requestSync(C0099c c0099c) {
        if (isDigitalLegacyMode()) {
            try {
                startForegroundNotification();
            } catch (Exception e) {
                AbstractC0000a.m22s("[Service] ForegroundService start failed : ", e, TAG);
            }
        }
        this.mSyncLogic.m15089g(c0099c);
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.services.SyncOldService
    public void stopSync(int i) {
        this.mSyncLogic.getClass();
        C14499b.m15087h(i);
    }
}
