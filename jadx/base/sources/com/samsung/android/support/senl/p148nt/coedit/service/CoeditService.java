package com.samsung.android.support.senl.p148nt.coedit.service;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.ntnl.coedit.CoeditNativeLibrary;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.NotificationConstants;
import com.samsung.android.support.senl.p148nt.base.common.data.DocumentUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceMaintainer;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceType;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.coedit.C8996R;
import com.samsung.android.support.senl.p148nt.coedit.common.CoeditConstants;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditControlCallback;
import com.samsung.android.support.senl.p148nt.coedit.control.common.SnapControlCallback;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.service.task.ExternalBaseTask;
import com.samsung.android.support.senl.p148nt.coedit.service.task.SnapUploadTask;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import p079T.AbstractC0291i;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditService extends Service implements ExternalBaseTask.Contract {
    private static final String TAG = "CT/CoeditService";
    private boolean mIsServiceStarted;
    private ServiceMaintainer mMaintainer = new ServiceMaintainer(TAG);
    private final Set<String> mSubscribers = new HashSet();
    private final Executor mExternalExecutor = AbstractC4539a.m3201k("CT/CoeditService_external");
    private final Handler mUIThreadHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        void onCompleted();

        void onError(String str);

        void onRelease();

        void onStartOfflineMode(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public CoeditService getService() {
            return CoeditService.this;
        }
    }

    private String getBundleUuid(Bundle bundle) {
        String string;
        return (bundle == null || (string = bundle.getString("document_uuid")) == null) ? "" : string;
    }

    private void handleException(String str, String str2) {
        if (Constants.ACTION_COEDIT_DOC_CLOSE.equals(str)) {
            DocumentUpdateManager.getInstance().onCoEditDocumentClosed(str2);
        }
    }

    private void initCoeditNativeLibrary() {
        SpenSdkInitializer.initialize(getApplicationContext());
        CoeditNativeLibrary.initialize(getApplicationContext(), CoeditUtils.getSdkVersion());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestStopSelf() {
        CoeditLogger.m8919d(TAG, "request, stopSelf: " + hashCode());
        synchronized (this.mSubscribers) {
            try {
                if (this.mSubscribers.isEmpty() && this.mIsServiceStarted) {
                    CoeditHandlerManager.getInstance().requestStopSelf(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.service.CoeditService.7
                        @Override // java.lang.Runnable
                        public void run() {
                            CoeditService.this.stopSelf();
                        }
                    });
                }
            } finally {
            }
        }
    }

    public void checkDeleteOnlyMode(String str) {
        CoeditHandlerManager.getInstance().checkDeleteOnlyMode(str);
    }

    public void executeExternalTask(@NonNull ExternalBaseTask externalBaseTask) {
        this.mExternalExecutor.execute(externalBaseTask.setContract(this));
    }

    public void internalChannelOpen(@NonNull Activity activity, @NonNull SpenWNote spenWNote, @NonNull String str, @NonNull String str2, @NonNull String str3, final Callback callback) {
        CoeditLogger.m8919d(TAG, "internalChannelOpen()");
        CoeditHandlerManager.getInstance().internalChannelOpen(activity, spenWNote, str, str2, str3, new CoeditControlCallback() { // from class: com.samsung.android.support.senl.nt.coedit.service.CoeditService.2
            @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditControlCallback
            public void onCompleted(String str4) {
                AbstractC8014b.m7219u("onCompleted, ", str4, CoeditService.TAG);
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onCompleted();
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditControlCallback
            public void onError(String str4) {
                AbstractC8014b.m7219u("onError, ", str4, CoeditService.TAG);
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onError(str4);
                }
            }
        });
    }

    public void internalSnapRefresh(String str) {
        CoeditHandlerManager.getInstance().internalSnapRefresh(str);
    }

    public void internalSnapRestart(String str, String str2, final Callback callback, final Callback callback2) {
        CoeditLogger.m8919d(TAG, "internalSnapRestart()");
        CoeditHandlerManager.getInstance().internalSnapRestart(str, str2, new SnapControlCallback() { // from class: com.samsung.android.support.senl.nt.coedit.service.CoeditService.3
            @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.SnapControlCallback
            public void onCompleted(String str3, boolean z) {
                AbstractC8014b.m7219u("onCompleted, ", str3, CoeditService.TAG);
                Callback callback3 = callback;
                if (callback3 != null) {
                    callback3.onCompleted();
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.SnapControlCallback
            public void onError(String str3) {
                AbstractC8014b.m7219u("onError, ", str3, CoeditService.TAG);
                Callback callback3 = callback;
                if (callback3 != null) {
                    callback3.onError(str3);
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.SnapControlCallback
            public void onRelease() {
                Callback callback3 = callback;
                if (callback3 != null) {
                    callback3.onRelease();
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.SnapControlCallback
            public void onStartOfflineMode(String str3) {
                AbstractC8014b.m7219u("onStartOfflineMode, ", str3, CoeditService.TAG);
                Callback callback3 = callback;
                if (callback3 != null) {
                    callback3.onStartOfflineMode(str3);
                }
            }
        }, new CoeditControlCallback() { // from class: com.samsung.android.support.senl.nt.coedit.service.CoeditService.4
            @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditControlCallback
            public void onCompleted(String str3) {
                AbstractC8014b.m7219u("onCompleted, ", str3, CoeditService.TAG);
                Callback callback3 = callback2;
                if (callback3 != null) {
                    callback3.onCompleted();
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditControlCallback
            public void onError(String str3) {
                AbstractC8014b.m7219u("onError, ", str3, CoeditService.TAG);
                Callback callback3 = callback2;
                if (callback3 != null) {
                    callback3.onError(str3);
                }
            }
        });
    }

    public void internalSnapStart(@NonNull SpenWNote spenWNote, @NonNull String str, @NonNull final String str2, @NonNull String str3, @NonNull String str4, @NonNull final String str5, @NonNull final Callback callback, @NonNull CoeditHandlerManager.Contract contract) {
        CoeditLogger.m8919d(TAG, "internalSnapStart()");
        if (TextUtils.isEmpty(str3)) {
            callback.onError("group id is empty");
            return;
        }
        if (CoeditHandlerManager.getInstance().isCoeditWithUpDownloaderRunning(str2)) {
            callback.onError("snap is running on external");
        } else if (AbstractC0291i.m569f(str2)) {
            callback.onError("snap is isDeleting on");
        } else {
            CoeditHandlerManager.getInstance().internalSnapStart(spenWNote, str2, str, str3, str4, new SnapControlCallback() { // from class: com.samsung.android.support.senl.nt.coedit.service.CoeditService.5
                @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.SnapControlCallback
                public void onCompleted(String str6, boolean z) {
                    AbstractC8014b.m7219u("onCompleted. Success to start snap. ", str6, CoeditService.TAG);
                    if (z) {
                        SnapUploadTask.onSnapUploadCompleted(CoeditService.this.getApplicationContext(), str2, str6, str5, CoeditService.this.mUIThreadHandler);
                    }
                    CoeditService.this.mUIThreadHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.service.CoeditService.5.2
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onCompleted();
                        }
                    });
                }

                @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.SnapControlCallback
                public void onError(final String str6) {
                    AbstractC8014b.m7219u("onError. Failed to start snap. ", str6, CoeditService.TAG);
                    CoeditService.this.mUIThreadHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.service.CoeditService.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onError(str6);
                        }
                    });
                }

                @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.SnapControlCallback
                public void onRelease() {
                    callback.onRelease();
                }

                @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.SnapControlCallback
                public void onStartOfflineMode(final String str6) {
                    CoeditService.this.mUIThreadHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.service.CoeditService.5.3
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onStartOfflineMode(str6);
                        }
                    });
                }
            }, contract);
        }
    }

    public boolean isWritePermissionGranted(String str) {
        return CoeditHandlerManager.getInstance().isWritePermissionGranted(str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.mIsServiceStarted = true;
        CoeditLogger.m8919d(TAG, "onBind() uuid : " + getBundleUuid(intent.getExtras()));
        return new LocalBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        TaskState companion = TaskState.INSTANCE.getInstance();
        TaskState.Type.Companion companion2 = TaskState.Type.INSTANCE;
        companion.setIsRunning("COEDIT_SERVICE", true);
        CoeditLogger.m8919d(TAG, "onCreate: " + hashCode());
        initCoeditNativeLibrary();
        String string = getApplicationContext().getResources().getString(C8996R.string.co_edit_title);
        ServiceManager.INSTANCE.getInstance().registerService(this, NotificationConstants.COEDIT_NOTIFICATION_CHANNEL_ID, string, string, ServiceType.DEFAULT, 1);
        this.mMaintainer.setServiceMaintainerListener(new ServiceMaintainer.ServiceMaintainerListener() { // from class: com.samsung.android.support.senl.nt.coedit.service.CoeditService.1
            @Override // com.samsung.android.support.senl.nt.base.common.service.ServiceMaintainer.ServiceMaintainerListener
            public void onBind() {
                CoeditLogger.m8923i(CoeditService.TAG, "maintainConnection$onBind()");
            }

            @Override // com.samsung.android.support.senl.nt.base.common.service.ServiceMaintainer.ServiceMaintainerListener
            public void onUnbind() {
                CoeditLogger.m8923i(CoeditService.TAG, "maintainConnection$onUnbind()");
                CoeditService.this.requestStopSelf();
            }
        });
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        TaskState companion = TaskState.INSTANCE.getInstance();
        TaskState.Type.Companion companion2 = TaskState.Type.INSTANCE;
        companion.setIsRunning("COEDIT_SERVICE", false);
        CoeditLogger.m8919d(TAG, "onDestroy: " + hashCode());
        ServiceManager.INSTANCE.getInstance().unregisterService(this);
        if (this.mIsServiceStarted) {
            this.mIsServiceStarted = false;
            this.mUIThreadHandler.removeCallbacksAndMessages(null);
            List<String> allHandledUuids = CoeditHandlerManager.getInstance().getAllHandledUuids();
            if (allHandledUuids != null) {
                Iterator<String> it = allHandledUuids.iterator();
                while (it.hasNext()) {
                    releaseHandler(it.next(), "onDestroy service", null);
                }
            }
            this.mMaintainer = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.mIsServiceStarted = true;
        if (intent == null) {
            CoeditLogger.m8920e(TAG, "onStartCommand# Intent is null");
            return 2;
        }
        String action = intent.getAction();
        String bundleUuid = getBundleUuid(intent.getExtras());
        try {
            CoeditLogger.m8919d(TAG, "onStartCommand# action : " + action);
            if (Constants.ACTION_COEDIT_DOC_CLOSE.equals(action)) {
                String str = CoeditConstants.User.DocumentService.name() + '_' + bundleUuid;
                subscribe(str);
                releaseHandler(bundleUuid, "DocumentService", null);
                unsubscribe(str);
            } else {
                CoeditLogger.m8920e(TAG, "onStartCommand# unexpected action : " + action);
            }
        } catch (IllegalArgumentException e) {
            CoeditLogger.m8920e(TAG, "onStartCommand# IllegalArgumentException: " + e.getMessage());
            handleException(action, bundleUuid);
        }
        return super.onStartCommand(intent, i, i2);
    }

    public int pauseConcurrency(String str, String str2, Runnable runnable) {
        return CoeditHandlerManager.getInstance().pauseConcurrency(str, str2, runnable);
    }

    @Override // com.samsung.android.support.senl.nt.coedit.service.task.ExternalBaseTask.Contract
    public void releaseHandler(final String str, final String str2, @Nullable final Runnable runnable) {
        CoeditHandlerManager.getInstance().releaseHandler(str, new CoeditHandlerManager.IReleasePostAction() { // from class: com.samsung.android.support.senl.nt.coedit.service.CoeditService.6
            @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.IReleasePostAction
            public boolean execute(int i) {
                if (i == 2) {
                    CoeditLogger.m8923i(CoeditService.TAG, "skip releaseHandler, already closing uuid, " + str + " caller, " + str2);
                    return false;
                }
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
                DocumentUpdateManager.getInstance().onCoEditDocumentClosed(str);
                CoeditService.this.requestStopSelf();
                CoeditLogger.m8923i(CoeditService.TAG, "releaseHandler, uuid, " + str + " caller, " + str2 + " type, " + i);
                return false;
            }
        }, AbstractC0541b.m773o("CT/CoeditService/", str2, "/releaseHandler"));
    }

    public void requestReadPermission(String str) {
        CoeditHandlerManager.getInstance().requestReadPermission(str);
    }

    public int resumeConcurrency(String str, String str2) {
        return CoeditHandlerManager.getInstance().resumeConcurrency(str, str2);
    }

    public void saveCoeditCache(String str) {
        CoeditHandlerManager.getInstance().saveCoeditCache(str);
    }

    public void subscribe(String str) {
        AbstractC8014b.m7223y("subscribe, userId: ", str, TAG);
        synchronized (this.mSubscribers) {
            this.mSubscribers.add(str);
            this.mMaintainer.bind(getApplicationContext(), getClass());
        }
    }

    public void trimMemory(int i) {
        CoeditUtils.trimMemory(i);
    }

    public void unsubscribe(String str) {
        AbstractC8014b.m7223y("unsubscribe, userId: ", str, TAG);
        synchronized (this.mSubscribers) {
            try {
                this.mSubscribers.remove(str);
                if (this.mSubscribers.isEmpty() && this.mIsServiceStarted) {
                    this.mMaintainer.unbind(getApplicationContext());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
