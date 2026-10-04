package com.samsung.android.app.notes.sync.importing.services;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import com.samsung.android.app.notes.sync.importing.core.ImportLogic;
import com.samsung.android.app.notes.sync.importing.core.types.AbstractImportType;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p148nt.base.common.constants.NotificationConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceType;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p001A.AbstractC0000a;
import p254x0.InterfaceC14511a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ImportService extends Service {
    private static final int IMPORT_NOTIFICATION = 1101;
    private static final String TAG = "ImportService";
    private ImportLogic mImportLogic;
    private final InterfaceC14511a mImportListener = new C6777a(this);
    private final CopyOnWriteArrayList<ServiceConnection> mImportServiceConnectionList = new CopyOnWriteArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public ImportService getService() {
            return ImportService.this;
        }
    }

    private int onStartCommandDL(Intent intent) {
        if (intent == null) {
            return 2;
        }
        startForegroundNotification();
        return 1;
    }

    private void startForegroundNotification() {
        Notification.Builder builderCreateNotification = NotificationUtils.createNotification(getApplicationContext(), NotificationConstants.IMPORT_NOTIFICATION_CHANNEL_ID, getString(C7943R.string.sync_tipcard_impoort_downloading_title));
        builderCreateNotification.setContentText(getString(C7943R.string.sync_tipcard_impoort_downloading_title));
        builderCreateNotification.setContentTitle(getString(C7943R.string.sync_tipcard_impoort_downloading_title));
        builderCreateNotification.setOngoing(true);
        if (Build.VERSION.SDK_INT >= 33) {
            startForeground(1101, builderCreateNotification.build(), 1);
        } else {
            startForeground(1101, builderCreateNotification.build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unbind() {
        Iterator<ServiceConnection> it = this.mImportServiceConnectionList.iterator();
        while (it.hasNext()) {
            try {
                getApplicationContext().unbindService(it.next());
            } catch (IllegalArgumentException e) {
                Debugger.m8609e(TAG, "unbind, unbindService" + e.getMessage());
            }
        }
        this.mImportServiceConnectionList.clear();
    }

    public void addConnection(ServiceConnection serviceConnection) {
        this.mImportServiceConnectionList.add(serviceConnection);
    }

    public boolean isImporting() {
        return this.mImportLogic.isImporting();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new LocalBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Debugger.m8607d(TAG, "onCreate");
        ImportLogic importLogic = new ImportLogic();
        this.mImportLogic = importLogic;
        importLogic.setSelfBind(new C6778b());
        this.mImportLogic.initImportLogic();
        this.mImportLogic.addImportListener(this.mImportListener);
        ServiceManager.INSTANCE.getInstance().registerService(this, NotificationConstants.IMPORT_NOTIFICATION_CHANNEL_ID, getResources().getString(C7943R.string.sync_tipcard_impoort_downloading_title), getResources().getString(C7943R.string.sync_tipcard_impoort_downloading_title), ServiceType.DEFAULT, 0);
        TaskState.INSTANCE.getInstance().setIsRunning("IMPORT_CLOUD_DATA_BY_SETTING", true);
    }

    @Override // android.app.Service
    public void onDestroy() {
        unbind();
        this.mImportLogic.removeImportListener(this.mImportListener);
        ServiceManager.INSTANCE.getInstance().unregisterService(this);
        TaskState.INSTANCE.getInstance().setIsRunning("IMPORT_CLOUD_DATA_BY_SETTING", false);
        Debugger.m8607d(TAG, "onDestroy");
        super.onDestroy();
    }

    public void onNetworkConnected(boolean z, boolean z2) {
        this.mImportLogic.onNetworkConnected(z, z2);
    }

    public void onNetworkConnectionFailedDialogFinish(int i, int i2) {
        this.mImportLogic.onNetworkConnectionFailedDialogFinish(i, i2);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        AbstractC0000a.m17n(i, "ImportService : onStartCommand() : flags = ", TAG);
        return onStartCommandDL(intent);
    }

    public void reTryImporting() {
        this.mImportLogic.reTryImporting();
    }

    public void startImport(AbstractImportType abstractImportType) {
        this.mImportLogic.startImportByType(abstractImportType);
    }

    public void stopImportInternal() {
        this.mImportLogic.stopImportInternal();
    }
}
