package com.samsung.android.support.senl.p148nt.coedit.caller.handler;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.CoeditServiceConnection;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.DownloadNoteCallback;
import com.samsung.android.support.senl.p148nt.coedit.common.CoeditConstants;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.service.CoeditService;
import com.samsung.android.support.senl.p148nt.coedit.service.task.ExternalBaseTask;
import com.samsung.android.support.senl.p148nt.coedit.service.task.ExternalSnapDownloadTask;
import com.samsung.android.support.senl.p148nt.coedit.service.task.ExternalSnapStartTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ServiceConnectHandler {
    private static final int NUM_OF_SERVICE_CONNECT_EXECUTOR = 5;
    private static final String TAG = "ServiceConnectHandler";
    private final Executor mServiceConnectExecutor = Executors.newFixedThreadPool(5, new SenlThreadFactory("ServiceConnectHandler_service_connect_executor"));

    @SuppressLint({WarningType.NewApi})
    public boolean connectServiceToDownloadNote(final Context context, final String str, final String str2, final String str3, final String str4) {
        CoeditLogger.m8919d(TAG, "[CS7] connectServiceToDownloadNote()");
        final CompletableFuture completableFuture = new CompletableFuture();
        final String str5 = CoeditConstants.User.UpDownloader.name() + "_down_" + str2;
        Intent intent = new Intent(context, (Class<?>) CoeditService.class);
        intent.putExtra("document_uuid", str2);
        CoeditServiceConnection coeditServiceConnection = new CoeditServiceConnection() { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.ServiceConnectHandler.2
            private void downloadCoEditNoteSync() {
                CoeditLogger.m8919d(ServiceConnectHandler.TAG, "[CS7] downloadCoEditNoteSync() : uuid = " + str2);
                this.mService.executeExternalTask(new ExternalSnapDownloadTask(context, str, str2, str3, str4, new ExternalBaseTask.UpDownloadCallback() { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.ServiceConnectHandler.2.1
                    @Override // com.samsung.android.support.senl.nt.coedit.service.task.ExternalBaseTask.UpDownloadCallback
                    @SuppressLint({WarningType.NewApi})
                    public void onCompleted() {
                        CoeditLogger.m8923i(ServiceConnectHandler.TAG, "[CS7-1] downloadCoEditNoteSync() : uuid = " + str2);
                        completableFuture.complete(Boolean.TRUE);
                    }

                    @Override // com.samsung.android.support.senl.nt.coedit.service.task.ExternalBaseTask.UpDownloadCallback
                    @SuppressLint({WarningType.NewApi})
                    public void onError(int i) {
                        StringBuilder sbM778t = AbstractC0541b.m778t(i, "[CS7-2] downloadCoEditNoteSync() : fail to download, errorCode: ", ". uuid: ");
                        sbM778t.append(str2);
                        CoeditLogger.m8920e(ServiceConnectHandler.TAG, sbM778t.toString());
                        completableFuture.complete(Boolean.FALSE);
                    }
                }));
            }

            @Override // android.content.ServiceConnection
            public void onNullBinding(ComponentName componentName) {
                completableFuture.complete(Boolean.FALSE);
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                CoeditLogger.m8919d(ServiceConnectHandler.TAG, "[CS7-1] connectServiceToDownloadNote, onServiceConnected()");
                if (iBinder == null) {
                    CoeditLogger.m8920e(ServiceConnectHandler.TAG, "[CS7-2] connectServiceToDownloadNote, onServiceConnected() : CoeditService is null!");
                    completableFuture.complete(Boolean.FALSE);
                } else {
                    CoeditService service = ((CoeditService.LocalBinder) iBinder).getService();
                    this.mService = service;
                    service.subscribe(str5);
                    downloadCoEditNoteSync();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                CoeditLogger.m8919d(ServiceConnectHandler.TAG, "[CS7-1] connectServiceToDownloadNote, onServiceDisconnected()");
                this.mService = null;
            }
        };
        if (!context.bindService(intent, coeditServiceConnection, 1)) {
            completableFuture.complete(Boolean.FALSE);
        }
        try {
            try {
                boolean zBooleanValue = ((Boolean) completableFuture.get(600000L, TimeUnit.MILLISECONDS)).booleanValue();
                coeditServiceConnection.unsubscribe(str5);
                CoeditConnectionUtils.unbindService(context, coeditServiceConnection);
                return zBooleanValue;
            } catch (TimeoutException unused) {
                CoeditLogger.m8920e(TAG, "connectServiceToDownloadNote, TimeoutException");
                CoeditHandlerManager.getInstance().forceCancel(str2, "connectServiceToDownloadNote-Timeout");
                coeditServiceConnection.unsubscribe(str5);
                CoeditConnectionUtils.unbindService(context, coeditServiceConnection);
                return false;
            }
        } catch (Throwable th) {
            coeditServiceConnection.unsubscribe(str5);
            CoeditConnectionUtils.unbindService(context, coeditServiceConnection);
            throw th;
        }
    }

    public void downloadSpenWNote(final Context context, final String str, final String str2, final String str3, final String str4, final DownloadNoteCallback downloadNoteCallback) {
        AbstractC8014b.m7219u("[CS7] downloadSpenWNote() : uuid = ", str2, TAG);
        this.mServiceConnectExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.ServiceConnectHandler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        boolean zConnectServiceToDownloadNote = ServiceConnectHandler.this.connectServiceToDownloadNote(context, str, str2, str3, str4);
                        DownloadNoteCallback downloadNoteCallback2 = downloadNoteCallback;
                        if (downloadNoteCallback2 != null) {
                            if (zConnectServiceToDownloadNote) {
                                downloadNoteCallback2.onFinished(str2);
                            } else {
                                downloadNoteCallback2.onFailed();
                            }
                        }
                    } finally {
                        DownloadNoteCallback downloadNoteCallback3 = downloadNoteCallback;
                        if (downloadNoteCallback3 != null) {
                            downloadNoteCallback3.onFailed();
                        }
                    }
                } catch (InterruptedException | ExecutionException e) {
                    CoeditLogger.m8920e(ServiceConnectHandler.TAG, "[CS7-2] downloadSpenWNote, run() : fail to connectToDownloadNote, e : " + e.getMessage());
                }
            }
        });
    }

    public void externalSnapStart(final Context context, final String str, final String str2, final String str3, final String str4, final String str5, final DownloadNoteCallback downloadNoteCallback) {
        CoeditLogger.m8919d(TAG, "syncSpenWNote() ");
        this.mServiceConnectExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.ServiceConnectHandler.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                String str6 = "syncSpenWNote, ret : false";
                try {
                    try {
                        boolean zExternalSnapStart = ServiceConnectHandler.this.externalSnapStart(context, str, str2, str3, str4, str5);
                        CoeditLogger.m8923i(ServiceConnectHandler.TAG, "syncSpenWNote, ret : " + zExternalSnapStart);
                        DownloadNoteCallback downloadNoteCallback2 = downloadNoteCallback;
                        str6 = downloadNoteCallback2;
                        if (downloadNoteCallback2 != null) {
                            if (zExternalSnapStart) {
                                downloadNoteCallback2.onFinished(str3);
                            } else {
                                downloadNoteCallback2.onFailed();
                            }
                        }
                    } finally {
                        CoeditLogger.m8923i(ServiceConnectHandler.TAG, str6);
                        DownloadNoteCallback downloadNoteCallback3 = downloadNoteCallback;
                        if (downloadNoteCallback3 != null) {
                            downloadNoteCallback3.onFailed();
                        }
                    }
                } catch (InterruptedException | ExecutionException e) {
                    CoeditLogger.m8920e(ServiceConnectHandler.TAG, "[CS7-2] syncSpenWNote, in ServiceConnectExecutor, e : " + e.getMessage());
                }
            }
        });
    }

    @SuppressLint({WarningType.NewApi})
    public boolean externalSnapStart(final Context context, final String str, final String str2, final String str3, final String str4, final String str5) {
        CoeditLogger.m8919d(TAG, "externalSnapStart, CoeditService");
        final CompletableFuture completableFuture = new CompletableFuture();
        final String str6 = CoeditConstants.User.UpDownloader.name() + "_sync_" + str3;
        Intent intent = new Intent(context, (Class<?>) CoeditService.class);
        intent.putExtra("document_uuid", str3);
        CoeditServiceConnection coeditServiceConnection = new CoeditServiceConnection() { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.ServiceConnectHandler.4
            private void externalSnapStartToService() {
                CoeditLogger.m8919d(ServiceConnectHandler.TAG, "[CS7] externalSnapStartToService() uuid : " + str3);
                this.mService.executeExternalTask(new ExternalSnapStartTask(context, str, str2, str3, str4, str5, new ExternalBaseTask.UpDownloadCallback() { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.ServiceConnectHandler.4.1
                    @Override // com.samsung.android.support.senl.nt.coedit.service.task.ExternalBaseTask.UpDownloadCallback
                    @SuppressLint({WarningType.NewApi})
                    public void onCompleted() {
                        CoeditLogger.m8923i(ServiceConnectHandler.TAG, "[CS7-1] externalSnapStartToService uuid : " + str3);
                        completableFuture.complete(Boolean.TRUE);
                    }

                    @Override // com.samsung.android.support.senl.nt.coedit.service.task.ExternalBaseTask.UpDownloadCallback
                    @SuppressLint({WarningType.NewApi})
                    public void onError(int i) {
                        StringBuilder sbM778t = AbstractC0541b.m778t(i, "[CS7-2] externalSnapStartToService() fail to download, errorCode: ", ", uuid : ");
                        sbM778t.append(str3);
                        CoeditLogger.m8920e(ServiceConnectHandler.TAG, sbM778t.toString());
                        completableFuture.complete(Boolean.FALSE);
                    }
                }));
            }

            @Override // android.content.ServiceConnection
            public void onNullBinding(ComponentName componentName) {
                completableFuture.complete(Boolean.FALSE);
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                CoeditLogger.m8919d(ServiceConnectHandler.TAG, "[CS7-1] externalSnapStart, ServiceConnection, onServiceConnected()");
                if (iBinder == null) {
                    CoeditLogger.m8919d(ServiceConnectHandler.TAG, "externalSnapStart, ServiceConnection, onServiceConnected() CoeditService is unavailable");
                    completableFuture.complete(Boolean.FALSE);
                } else {
                    CoeditService service = ((CoeditService.LocalBinder) iBinder).getService();
                    this.mService = service;
                    service.subscribe(str6);
                    externalSnapStartToService();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                CoeditLogger.m8919d(ServiceConnectHandler.TAG, "[CS7-2] externalSnapStart, ServiceConnection, onServiceDisconnected()");
                this.mService = null;
            }
        };
        if (!context.bindService(intent, coeditServiceConnection, 1)) {
            completableFuture.complete(Boolean.FALSE);
        }
        try {
            try {
                boolean zBooleanValue = ((Boolean) completableFuture.get(600000L, TimeUnit.MILLISECONDS)).booleanValue();
                coeditServiceConnection.unsubscribe(str6);
                CoeditConnectionUtils.unbindService(context, coeditServiceConnection);
                return zBooleanValue;
            } catch (TimeoutException unused) {
                CoeditLogger.m8920e(TAG, "externalSnapStart, TimeoutException");
                CoeditHandlerManager.getInstance().forceCancel(str3, "externalSnapStart-Timeout");
                coeditServiceConnection.unsubscribe(str6);
                CoeditConnectionUtils.unbindService(context, coeditServiceConnection);
                return false;
            }
        } catch (Throwable th) {
            coeditServiceConnection.unsubscribe(str6);
            CoeditConnectionUtils.unbindService(context, coeditServiceConnection);
            throw th;
        }
    }
}
