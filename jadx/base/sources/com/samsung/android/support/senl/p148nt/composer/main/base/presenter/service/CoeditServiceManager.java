package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.SystemClock;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.coedit.common.CoeditConstants;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.service.CoeditService;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.CoeditAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.sync.resolver.NoteDbResolver;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditServiceManager implements CoeditAdapter.ICoeditController {
    private static final String TAG = Logger.createTag("CoeditServiceManager");
    private Activity mActivity;
    private ServiceConnection mConnection;
    private CoeditAdapter.ConnectionCallback mConnectionCallback;
    private String mGroupId;
    private boolean mPreviousIsWritePermissionGranted;
    private String mResourceId;
    private CoeditService mService;
    private long mTimeIsWritePermissionGranted;
    private String mUuid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CoeditServiceAdapterCallback implements CoeditService.Callback {
        CoeditAdapter.ActionCallback mAdapterCallback;

        public CoeditServiceAdapterCallback(CoeditAdapter.ActionCallback actionCallback) {
            this.mAdapterCallback = actionCallback;
        }

        @Override // com.samsung.android.support.senl.nt.coedit.service.CoeditService.Callback
        public void onCompleted() {
            Logger.m10999d(CoeditServiceManager.TAG, "CoeditServiceAdapterCallback#onCompleted# ");
            CoeditAdapter.ActionCallback actionCallback = this.mAdapterCallback;
            if (actionCallback != null) {
                actionCallback.onCompleted();
                this.mAdapterCallback = null;
            }
        }

        @Override // com.samsung.android.support.senl.nt.coedit.service.CoeditService.Callback
        public void onError(String str) {
            AbstractC8014b.m7198D("CoeditServiceAdapterCallback#onError# ", str, CoeditServiceManager.TAG);
            CoeditAdapter.ActionCallback actionCallback = this.mAdapterCallback;
            if (actionCallback != null) {
                actionCallback.onError(str);
                this.mAdapterCallback = null;
            }
        }

        @Override // com.samsung.android.support.senl.nt.coedit.service.CoeditService.Callback
        public void onRelease() {
            this.mAdapterCallback = null;
        }

        @Override // com.samsung.android.support.senl.nt.coedit.service.CoeditService.Callback
        public void onStartOfflineMode(String str) {
            CoeditAdapter.ActionCallback actionCallback = this.mAdapterCallback;
            if (actionCallback != null) {
                actionCallback.onStartOfflineMode(str);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void checkDeleteOnlyMode() {
        CoeditService coeditService = this.mService;
        if (coeditService != null) {
            coeditService.checkDeleteOnlyMode(this.mUuid);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void clearCoeditCallback() {
        CoeditLogger.m8919d(TAG, "clearCoeditCallback() uuid : " + this.mUuid);
        this.mConnectionCallback = null;
    }

    public void connect(Activity activity, String str) {
        AbstractC8014b.m7219u("connect() CoeditService uuid: ", str, TAG);
        this.mActivity = activity;
        this.mUuid = str;
        Intent intent = new Intent(activity, (Class<?>) CoeditService.class);
        intent.putExtra("document_uuid", str);
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.service.CoeditServiceManager.1
            @Override // android.content.ServiceConnection
            public void onNullBinding(ComponentName componentName) {
                CoeditServiceManager coeditServiceManager = CoeditServiceManager.this;
                coeditServiceManager.disconnect(coeditServiceManager.mActivity);
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                CoeditLogger.m8919d(CoeditServiceManager.TAG, "ServiceConnection, onServiceConnected()");
                if (iBinder == null) {
                    CoeditLogger.m8919d(CoeditServiceManager.TAG, "ServiceConnection, onServiceConnected() CoeditService is unavailable");
                    return;
                }
                CoeditServiceManager.this.mService = ((CoeditService.LocalBinder) iBinder).getService();
                CoeditServiceManager.this.mService.subscribe(CoeditConstants.User.Internal.name());
                if (CoeditServiceManager.this.mConnectionCallback == null) {
                    CoeditLogger.m8924w(CoeditServiceManager.TAG, "ServiceConnection, onServiceConnected() ConnectionCallback is invalid");
                } else {
                    CoeditServiceManager.this.mConnectionCallback.onConnected();
                    CoeditServiceManager.this.mConnectionCallback = null;
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                CoeditLogger.m8919d(CoeditServiceManager.TAG, "ServiceConnection, onServiceDisconnected()");
                CoeditServiceManager.this.mService = null;
            }
        };
        this.mConnection = serviceConnection;
        activity.bindService(intent, serviceConnection, 1);
    }

    public void disconnect(Activity activity) {
        if (this.mConnection == null) {
            CoeditLogger.m8919d(TAG, "disconnect() CoeditService, service is not connected");
            return;
        }
        CoeditLogger.m8919d(TAG, "disconnect() CoeditService");
        CoeditService coeditService = this.mService;
        if (coeditService != null) {
            coeditService.unsubscribe(CoeditConstants.User.Internal.name());
        }
        try {
            activity.unbindService(this.mConnection);
        } catch (IllegalArgumentException unused) {
            CoeditLogger.m8920e(TAG, "unbindService() CoeditServiceManager, service is not bind");
        }
        this.mConnection = null;
        this.mConnectionCallback = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public String getWorkspaceId() {
        String workspaceId = new NoteDbResolver(this.mUuid).getWorkspaceId();
        this.mResourceId = workspaceId;
        if (workspaceId == null) {
            this.mResourceId = "";
        }
        return this.mResourceId;
    }

    public boolean hasConnection() {
        return this.mConnection != null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void internalChannelOpen(SpenWNote spenWNote, CoeditAdapter.ActionCallback actionCallback) {
        CoeditLogger.m8919d(TAG, "internalChannelOpen() uuid : " + this.mUuid + ", groupId = " + this.mGroupId + ", resourceId = " + this.mResourceId);
        this.mService.internalChannelOpen(this.mActivity, spenWNote, this.mUuid, this.mGroupId, this.mResourceId, new CoeditServiceAdapterCallback(actionCallback));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void internalSnapRefresh() {
        CoeditLogger.m8919d(TAG, "internalSnapRefresh() uuid : " + this.mUuid + ", groupId = " + this.mGroupId + ", resourceId = " + this.mResourceId);
        this.mService.internalSnapRefresh(this.mUuid);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void internalSnapRestart(String str, CoeditAdapter.ActionCallback actionCallback, CoeditAdapter.ActionCallback actionCallback2) {
        CoeditLogger.m8919d(TAG, "internalSnapRestart() uuid : " + this.mUuid + ", groupId = " + this.mGroupId + ", resourceId = " + this.mResourceId + ", msg = " + str);
        this.mService.internalSnapRestart(this.mUuid, str, new CoeditServiceAdapterCallback(actionCallback), new CoeditServiceAdapterCallback(actionCallback2));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void internalSnapStart(SpenWNote spenWNote, String str, String str2, String str3, CoeditAdapter.ActionCallback actionCallback, CoeditHandlerManager.Contract contract) {
        this.mGroupId = str2;
        String workspaceId = getWorkspaceId();
        String str4 = TAG;
        StringBuilder sb = new StringBuilder("internalSnapStart() : uuid = ");
        sb.append(this.mUuid);
        sb.append(", groupId = ");
        AbstractC2821a.m2207B(sb, this.mGroupId, ", resourceId = ", workspaceId, ", spaceId = ");
        sb.append(str3);
        CoeditLogger.m8919d(str4, sb.toString());
        this.mService.internalSnapStart(spenWNote, str, this.mUuid, this.mGroupId, workspaceId, str3, new CoeditServiceAdapterCallback(actionCallback), contract);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public boolean isCoeditMode() {
        CoeditLogger.m8919d(TAG, "isCoeditMode(), uuid : " + this.mUuid);
        return CoeditHandlerManager.getInstance().isCoeditWithComposerRunning(this.mUuid);
    }

    public boolean isConnected() {
        return this.mService != null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public boolean isWritePermissionGranted() {
        if (this.mService == null) {
            return true;
        }
        if (SystemClock.uptimeMillis() < this.mTimeIsWritePermissionGranted + 1000) {
            Logger.m10999d(TAG, "isWritePermissionGranted# frequently called");
            return this.mPreviousIsWritePermissionGranted;
        }
        this.mPreviousIsWritePermissionGranted = this.mService.isWritePermissionGranted(this.mUuid);
        this.mTimeIsWritePermissionGranted = SystemClock.uptimeMillis();
        return this.mPreviousIsWritePermissionGranted;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public int pauseConcurrency(String str, CoeditAdapter.PauseTimeoutCallback pauseTimeoutCallback) {
        CoeditService coeditService = this.mService;
        if (coeditService == null) {
            return 0;
        }
        return coeditService.pauseConcurrency(this.mUuid, str, pauseTimeoutCallback);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void readyCoedit(Activity activity, String str) {
        connect(activity, str);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void requestReadPermission() {
        CoeditService coeditService = this.mService;
        if (coeditService == null) {
            return;
        }
        coeditService.requestReadPermission(this.mUuid);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public int resumeConcurrency(String str) {
        CoeditService coeditService = this.mService;
        if (coeditService == null) {
            return 0;
        }
        return coeditService.resumeConcurrency(this.mUuid, str);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void saveCoeditCache() {
        CoeditService coeditService = this.mService;
        if (coeditService != null) {
            coeditService.saveCoeditCache(this.mUuid);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void trimMemory(int i) {
        CoeditService coeditService = this.mService;
        if (coeditService != null) {
            coeditService.trimMemory(i);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public boolean waitConnection(CoeditAdapter.ConnectionCallback connectionCallback) {
        if (!hasConnection()) {
            return false;
        }
        if (isConnected()) {
            connectionCallback.onConnected();
            return true;
        }
        Logger.m10999d(TAG, "waitConnection# not connected");
        this.mConnectionCallback = connectionCallback;
        return true;
    }
}
