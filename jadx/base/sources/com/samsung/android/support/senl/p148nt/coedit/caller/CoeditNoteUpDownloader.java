package com.samsung.android.support.senl.p148nt.coedit.caller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.app.notes.sync.contentsharing.sessession.SocialException;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncProgressListener;
import com.samsung.android.support.senl.p148nt.coedit.caller.handler.DeleteHandler;
import com.samsung.android.support.senl.p148nt.coedit.caller.handler.ExternalAccessibleChecker;
import com.samsung.android.support.senl.p148nt.coedit.caller.handler.InternalImportHandler;
import com.samsung.android.support.senl.p148nt.coedit.caller.handler.PollingHandler;
import com.samsung.android.support.senl.p148nt.coedit.caller.handler.ServiceConnectHandler;
import com.samsung.android.support.senl.p148nt.coedit.caller.handler.UpDownloaderContract;
import com.samsung.android.support.senl.p148nt.coedit.caller.handler.WaitForDownloadHandler;
import com.samsung.android.support.senl.p148nt.coedit.caller.handler.WaitForSyncHandler;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.DownloadNoteCallback;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.DownloadResponse;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.ExternalAccessCallback;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.ImportResult;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.model.domain.coedit.DeleteCoeditNoteUseCase;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import p028G.InterfaceC0102a;
import p079T.InterfaceC0290h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditNoteUpDownloader implements UpDownloaderContract {
    private static final long DOWNLOAD_TIMEOUT_PERIOD = 1800000;
    private static final String TAG = "CoeditNoteUpDownloader";
    private static CoeditNoteUpDownloader mInstance;
    private SyncProgressListener mStopCoeditListener;
    private Handler mTimeoutHandler;
    private Runnable mTimeoutRunnable;
    private final Set<String> mRunningNoteUuids = new CopyOnWriteArraySet();
    private final Object mRunningNoteUuidsLock = new Object();
    private final PollingHandler mPollingHandler = new PollingHandler();
    private final ServiceConnectHandler mServiceConnectHandler = new ServiceConnectHandler();
    private final DeleteHandler mDeleteHandler = new DeleteHandler();
    private final ExternalAccessibleChecker mExternalAccessibleChecker = new ExternalAccessibleChecker();
    private final InternalImportHandler mInternalImportHandler = new InternalImportHandler();
    private final WaitForDownloadHandler mWaitForDownloadHandler = new WaitForDownloadHandler(this);
    private final WaitForSyncHandler mWaitForSyncHandler = new WaitForSyncHandler(this);
    private boolean isBackgroundDownloadStoppedBySync = false;

    private CoeditNoteUpDownloader() {
    }

    public static synchronized CoeditNoteUpDownloader getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new CoeditNoteUpDownloader();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.caller.handler.UpDownloaderContract
    public boolean addToRunningNoteUuids(String str, String str2) {
        synchronized (this.mRunningNoteUuidsLock) {
            try {
                if (this.mRunningNoteUuids.contains(str)) {
                    CoeditLogger.m8924w(TAG, "addToRunningNoteUuids, already exists, uuid: " + str + ", caller: " + str2);
                    return false;
                }
                this.mRunningNoteUuids.add(str);
                CoeditLogger.m8919d(TAG, "addToRunningNoteUuids, added on RunningNoteUuids : " + str + ", caller: " + str2);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void cancelAllRequestedDownload() {
        CoeditLogger.m8919d(TAG, "cancelAllRequestedDownload");
        this.mWaitForDownloadHandler.cancelAllRequestedDownload();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.caller.handler.UpDownloaderContract
    public void cancelCoeditTrimLocalSDoc() {
        this.mWaitForDownloadHandler.cancelCoeditTrimLocalSDoc();
    }

    public void cancelRequestedDownload() {
        this.mWaitForDownloadHandler.cancelRequestedDownload();
    }

    public void cancelRequestedSync() {
        this.mWaitForSyncHandler.cancelRequestedSync();
    }

    public void clearTimeoutDownloadCoedit() {
        Runnable runnable;
        CoeditLogger.m8919d(TAG, "clearTimeoutDownloadCoedit");
        Handler handler = this.mTimeoutHandler;
        if (handler != null && (runnable = this.mTimeoutRunnable) != null) {
            handler.removeCallbacks(runnable);
        }
        this.mTimeoutHandler = null;
        this.mTimeoutRunnable = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.caller.handler.UpDownloaderContract
    public void downloadSpenWNote(Context context, String str, String str2, String str3, String str4, DownloadNoteCallback downloadNoteCallback) {
        this.mServiceConnectHandler.downloadSpenWNote(context, str, str2, str3, str4, downloadNoteCallback);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.caller.handler.UpDownloaderContract
    public void externalSnapStart(Context context, String str, String str2, String str3, String str4, String str5, DownloadNoteCallback downloadNoteCallback) {
        this.mServiceConnectHandler.externalSnapStart(context, str, str2, str3, str4, str5, downloadNoteCallback);
    }

    public void finishPolling() {
        this.mPollingHandler.finishPolling();
    }

    @NonNull
    public ImportResult importNoteToCoedit(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return this.mInternalImportHandler.importNoteToCoedit(context, str, str2);
    }

    public boolean isBackgroundDownloadStoppedBySync() {
        return this.isBackgroundDownloadStoppedBySync;
    }

    public boolean isBackgroundDownloading() {
        if (!CoeditHandlerManager.getInstance().isBackgroundDownloadDisable() && CoeditHandlerManager.getInstance().isResumedBackgroundDownload()) {
            return this.mWaitForDownloadHandler.hasLowUpdatePrioritySnap() || this.mWaitForSyncHandler.hasLowUpdatePrioritySnap() || CoeditHandlerManager.getInstance().hasLowUpdatePrioritySnap();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.caller.handler.UpDownloaderContract
    public boolean isExceedRunningNoteUuids() {
        boolean z;
        synchronized (this.mRunningNoteUuidsLock) {
            z = true;
            if (this.mRunningNoteUuids.size() <= 1) {
                z = false;
            }
        }
        return z;
    }

    public boolean isExistRunningNoteUuids() {
        boolean z;
        synchronized (this.mRunningNoteUuidsLock) {
            z = !this.mRunningNoteUuids.isEmpty();
        }
        return z;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.caller.handler.UpDownloaderContract
    public boolean isRunningNoteUuids(String str) {
        boolean zContains;
        synchronized (this.mRunningNoteUuidsLock) {
            zContains = this.mRunningNoteUuids.contains(str);
        }
        return zContains;
    }

    public void registerExternalSnap(String str, String str2) {
        this.mWaitForSyncHandler.registerExternalSnap(str, str2);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.caller.handler.UpDownloaderContract
    public void removeFromRunningNoteUuids(String str, String str2) {
        synchronized (this.mRunningNoteUuidsLock) {
            try {
                this.mRunningNoteUuids.remove(str);
                CoeditLogger.m8919d(TAG, "removeFromRunningNoteUuids, removed from RunningNoteUuids : " + str + ", caller: " + str2);
                if (this.mRunningNoteUuids.isEmpty()) {
                    SyncProgressListener syncProgressListener = this.mStopCoeditListener;
                    if (syncProgressListener != null) {
                        syncProgressListener.onEnded(0);
                        this.mStopCoeditListener = null;
                    }
                    clearTimeoutDownloadCoedit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void requestBackgroundDownload() {
        CoeditLogger.m8919d(TAG, "requestBackgroundDownload");
        this.isBackgroundDownloadStoppedBySync = false;
        if (CoeditHandlerManager.getInstance().requestBackgroundDownload()) {
            setTimeoutDownloadCoedit(DOWNLOAD_TIMEOUT_PERIOD);
            this.mWaitForDownloadHandler.requestDownloadAllNotes();
            this.mWaitForSyncHandler.requestSyncAllNotes();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.caller.handler.UpDownloaderContract
    public void requestConnectSession() throws SocialException {
        C6715o.m4808q().m4796c(3);
    }

    public void requestDeleteItems(@NonNull Context context, @NonNull String str, @NonNull List<String> list, @Nullable InterfaceC0290h interfaceC0290h) {
        this.mDeleteHandler.requestDeleteItems(context, str, list, interfaceC0290h);
    }

    public void requestDeleteLocalNoteByPush(@NonNull String str, @Nullable DeleteCoeditNoteUseCase.ResultCallback resultCallback) {
        this.mDeleteHandler.requestDeleteLocalNoteByPush(str, resultCallback);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.caller.handler.UpDownloaderContract
    public void requestDisconnectSession() {
        C6715o.m4808q().m4797d(3, null);
    }

    public void requestDownload(String str, DownloadResponse downloadResponse) {
        this.mWaitForDownloadHandler.requestDownload(str, downloadResponse);
    }

    public void requestDownloadAddedNoteByPush(String str, String str2, DownloadResponse downloadResponse) {
        this.mWaitForDownloadHandler.requestDownloadAddedNoteByPush(str, str2, downloadResponse);
    }

    public void requestDownloadAddedNoteFromComposer(@NonNull String str, @NonNull String str2, @Nullable DownloadResponse downloadResponse) {
        this.mWaitForDownloadHandler.requestDownloadAddedNoteFromComposer(str, str2, downloadResponse);
    }

    public void requestDownloadByPush(String str, DownloadResponse downloadResponse) {
        this.mWaitForDownloadHandler.requestDownloadByPush(str, downloadResponse);
    }

    public void requestDownloadStandalone(DownloadResponse downloadResponse) {
        this.mWaitForDownloadHandler.requestDownloadStandalone(downloadResponse);
    }

    @SuppressLint({WarningType.NewApi})
    public void requestExternalAccessibleNotes(Context context, ArrayList<String> arrayList, ExternalAccessCallback externalAccessCallback) {
        this.mExternalAccessibleChecker.requestExternalAccessibleNotes(context, arrayList, externalAccessCallback);
    }

    public void requestSync(@NonNull List<String> list, Set<String> set) {
        this.mWaitForSyncHandler.requestSync(list, set);
    }

    public void resumeBackgroundDownload() {
        if (CoeditHandlerManager.getInstance().isBackgroundDownloadDisable()) {
            return;
        }
        CoeditLogger.m8919d(TAG, "resumeBackgroundDownload");
        this.isBackgroundDownloadStoppedBySync = false;
        CoeditHandlerManager.getInstance().resumeBackgroundDownload();
        this.mWaitForDownloadHandler.resumeBackgroundDownload();
        this.mWaitForSyncHandler.resumeBackgroundSync();
    }

    public void setStopCoeditListener(SyncProgressListener syncProgressListener) {
        this.mStopCoeditListener = syncProgressListener;
    }

    public void setTimeoutDownloadCoedit(long j) {
        if (j < 0) {
            CoeditLogger.m8919d(TAG, "setTimeoutDownloadCoedit, Ignored by invalid time");
            return;
        }
        CoeditLogger.m8919d(TAG, "setTimeoutDownloadCoedit, " + j);
        clearTimeoutDownloadCoedit();
        this.mTimeoutRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.caller.CoeditNoteUpDownloader.1
            @Override // java.lang.Runnable
            public void run() {
                CoeditLogger.m8919d(CoeditNoteUpDownloader.TAG, "cancel Requested Download & Sync");
                CoeditNoteUpDownloader.this.cancelAllRequestedDownload();
                CoeditNoteUpDownloader.this.cancelRequestedSync();
            }
        };
        Handler handler = new Handler(Looper.getMainLooper());
        this.mTimeoutHandler = handler;
        handler.postDelayed(this.mTimeoutRunnable, j);
        CoeditLogger.m8919d(TAG, "start Timeout DownloadCoedit");
    }

    public void startPolling(String str) {
        this.mPollingHandler.startPolling(str);
    }

    public void stopBackgroundDownload() {
        if (CoeditHandlerManager.getInstance().isBackgroundDownloadDisable()) {
            return;
        }
        CoeditLogger.m8919d(TAG, "stopBackgroundDownload");
        this.isBackgroundDownloadStoppedBySync = true;
        CoeditHandlerManager.getInstance().stopBackgroundDownload();
    }

    public void stopDownloadCoeditBySmartSwitch(SyncProgressListener syncProgressListener) {
        if (isExistRunningNoteUuids()) {
            setStopCoeditListener(syncProgressListener);
        } else if (syncProgressListener != null) {
            syncProgressListener.onEnded(0);
        }
        cancelAllRequestedDownload();
        cancelRequestedSync();
    }

    @NonNull
    public ImportResult importNoteToCoedit(@NonNull Context context, @NonNull List<String> list, @NonNull String str, @Nullable InterfaceC0102a interfaceC0102a) {
        return this.mInternalImportHandler.importNoteToCoedit(context, list, str, interfaceC0102a);
    }
}
