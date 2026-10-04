package com.samsung.android.support.senl.ntnl.coedit;

import com.samsung.android.support.senl.ntnl.base.NtnlLogger;
import com.samsung.android.support.senl.ntnl.coedit.base.CoeditLogger;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class CoeditManager extends BaseCoeditManager {
    protected long mHandle;
    final Map<String, Runnable> mResumeRunnableMap = new HashMap();
    public static final String TAG = CoeditLogger.createTag("CoeditManager");
    public static int MODE_NONE = 0;
    public static int MODE_UPLOAD = 1;
    public static int MODE_DOWNLOAD = 2;
    public static int MODE_OPEN = 4;
    public static int MODE_SHARE = 8;
    public static int MODE_UNDEFINED = 1 | 2;

    public CoeditManager(String str, boolean z) {
        this.mHandle = CoeditManager_construct(str, z);
        NtnlLogger.m12806d(TAG, "CoeditManager : handle = " + Long.toHexString(this.mHandle));
    }

    private native void CoeditManager_applyStrokeBinary(long j, String str, byte[] bArr);

    private native void CoeditManager_channelReconnected(long j);

    private native boolean CoeditManager_checkSkipDownloadNote(long j);

    private native void CoeditManager_close(long j);

    private native long CoeditManager_construct(String str, boolean z);

    private native void CoeditManager_downloadContentFile(long j, String str, String str2);

    private native void CoeditManager_externalChannelOpen(long j, int i, String str, String str2, CoeditCallback coeditCallback);

    private native void CoeditManager_externalSnapDownload(long j, int i, String str, String str2, SnapCallback snapCallback);

    private native void CoeditManager_externalSnapStart(long j, int i, String str, String str2, SnapCallback snapCallback);

    private native void CoeditManager_externalSnapUpload(long j, int i, String str, String str2, SnapCallback snapCallback);

    private native void CoeditManager_handleDeviceListChange(long j, String str);

    private native void CoeditManager_handleDownloadUrlMap(long j, Map<String, String> map);

    private native void CoeditManager_handleReceiveServerResponse(long j, long j2, long j3, long j5, long j6, long j7, boolean z);

    private native void CoeditManager_handleResetWorkspaceResponse(long j, long j2);

    private native void CoeditManager_handleWorkspaceBlock(long j);

    private native void CoeditManager_initCoeditController(long j, ICoeditController iCoeditController);

    private native void CoeditManager_initGrpcController(long j, IGrpcController iGrpcController);

    private native void CoeditManager_initNetworkReconnector(long j);

    private native void CoeditManager_internalChannelOpen(long j, int i, String str, String str2, CoeditCallback coeditCallback);

    private native boolean CoeditManager_internalSnapRefresh(long j);

    private native void CoeditManager_internalSnapRestart(long j, SnapCallback snapCallback, CoeditCallback coeditCallback, String str);

    private native void CoeditManager_internalSnapStart(long j, int i, String str, String str2, SnapCallback snapCallback);

    private native boolean CoeditManager_isConcurrencyPaused(long j, String str);

    private native boolean CoeditManager_isInitializing(long j);

    private native boolean CoeditManager_isNetworkReconnecting(long j);

    private native boolean CoeditManager_isRunningConcurrency(long j);

    private native boolean CoeditManager_isWorkingConcurrency(long j);

    private native void CoeditManager_onContentFileUploadError(long j, int i);

    private native void CoeditManager_onError(long j, String str);

    private native void CoeditManager_onSnapError(long j, String str);

    private native int CoeditManager_pauseConcurrency(long j, String str);

    private native void CoeditManager_putNotifyNoteOpsBuffer(long j, long j2, List<NoteOp> list, String str);

    private native void CoeditManager_reconnect(long j, String str);

    private native void CoeditManager_releaseLock(long j, String str);

    private native void CoeditManager_releaseNetworkReconnector(long j);

    private native boolean CoeditManager_requestPermission(long j, boolean z);

    private native int CoeditManager_resumeConcurrency(long j, String str);

    private native void CoeditManager_runOnUiThread(long j);

    private native boolean CoeditManager_saveCoeditCache(long j);

    private native void CoeditManager_setAbnormalAckCheckPoint(long j, long j2);

    private native boolean CoeditManager_setLock(long j, String str);

    private native void CoeditManager_setNoteSnapServerCheckPoint(long j, long j2);

    private native void CoeditManager_setServerCheckPoint(long j, long j2);

    private native long CoeditManager_stop(long j);

    private native void CoeditManager_uploadContentFile(long j, long j2, String str, String str2);

    private native void CoeditManager_wakeConcurrencyPool(long j);

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void applyStrokeBinary(String str, byte[] bArr) {
        CoeditManager_applyStrokeBinary(this.mHandle, str, bArr);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void channelReconnected() {
        CoeditManager_channelReconnected(this.mHandle);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean checkSkipDownloadNote() {
        return CoeditManager_checkSkipDownloadNote(this.mHandle);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void close() {
        NtnlLogger.m12806d(TAG, "CoeditManager : close handle = " + Long.toHexString(this.mHandle));
        CoeditManager_close(this.mHandle);
        this.mHandle = 0L;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void downloadContentFile(String str, String str2) {
        CoeditManager_downloadContentFile(this.mHandle, str, str2);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void externalChannelOpen(int i, String str, String str2, CoeditCallback coeditCallback) {
        CoeditManager_externalChannelOpen(this.mHandle, i, str, str2, coeditCallback);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void externalSnapDownload(int i, String str, String str2, SnapCallback snapCallback) {
        CoeditManager_externalSnapDownload(this.mHandle, i, str, str2, snapCallback);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void externalSnapStart(int i, String str, String str2, SnapCallback snapCallback) {
        CoeditManager_externalSnapStart(this.mHandle, i, str, str2, snapCallback);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void externalSnapUpload(int i, String str, String str2, SnapCallback snapCallback) {
        CoeditManager_externalSnapUpload(this.mHandle, i, str, str2, snapCallback);
    }

    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void handleDeviceListChange(String str) {
        CoeditManager_handleDeviceListChange(this.mHandle, str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void handleDownloadUrlMap(Map<String, String> map) {
        CoeditManager_handleDownloadUrlMap(this.mHandle, map);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void handleReceiveServerResponse(long j, long j2, long j3, long j5, long j6, boolean z) {
        CoeditManager_handleReceiveServerResponse(this.mHandle, j, j2, j3, j5, j6, z);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void handleResetWorkspaceResponse(long j) {
        CoeditManager_handleResetWorkspaceResponse(this.mHandle, j);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void handleWorkspaceBlock() {
        CoeditManager_handleWorkspaceBlock(this.mHandle);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void initCoeditController(ICoeditController iCoeditController) {
        CoeditManager_initCoeditController(this.mHandle, iCoeditController);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void initGrpcController(IGrpcController iGrpcController) {
        CoeditManager_initGrpcController(this.mHandle, iGrpcController);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void initNetworkReconnector() {
        CoeditManager_initNetworkReconnector(this.mHandle);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void internalChannelOpen(int i, String str, String str2, CoeditCallback coeditCallback) {
        CoeditManager_internalChannelOpen(this.mHandle, i, str, str2, coeditCallback);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean internalSnapRefresh() {
        return CoeditManager_internalSnapRefresh(this.mHandle);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void internalSnapRestart(SnapCallback snapCallback, CoeditCallback coeditCallback, String str) {
        CoeditManager_internalSnapRestart(this.mHandle, snapCallback, coeditCallback, str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void internalSnapStart(int i, String str, String str2, SnapCallback snapCallback) {
        CoeditManager_internalSnapStart(this.mHandle, i, str, str2, snapCallback);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean isConcurrencyPaused(String str) {
        return CoeditManager_isConcurrencyPaused(this.mHandle, str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean isInitializing() {
        return CoeditManager_isInitializing(this.mHandle);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean isNetworkReconnecting() {
        return CoeditManager_isNetworkReconnecting(this.mHandle);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean isRunningConcurrency() {
        return CoeditManager_isRunningConcurrency(this.mHandle);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager
    public boolean isValid() {
        return true;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean isWorkingConcurrency() {
        return CoeditManager_isWorkingConcurrency(this.mHandle);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void onContentFileUploadError(int i) {
        CoeditManager_onContentFileUploadError(this.mHandle, i);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void onError(String str) {
        CoeditManager_onError(this.mHandle, str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void onSnapError(String str) {
        CoeditManager_onSnapError(this.mHandle, str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public int pauseConcurrency(String str, Runnable runnable) {
        if (runnable != null) {
            this.mResumeRunnableMap.put(str, runnable);
        }
        return CoeditManager_pauseConcurrency(this.mHandle, str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void putNotifyNoteOpsBuffer(long j, List<NoteOp> list, String str) {
        CoeditManager_putNotifyNoteOpsBuffer(this.mHandle, j, list, str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void reconnect(String str) {
        CoeditManager_reconnect(this.mHandle, str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void releaseLock(String str) {
        CoeditManager_releaseLock(this.mHandle, str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void releaseNetworkReconnector() {
        CoeditManager_releaseNetworkReconnector(this.mHandle);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean requestPermission(boolean z) {
        return CoeditManager_requestPermission(this.mHandle, z);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public int resumeConcurrency(String str) {
        return CoeditManager_resumeConcurrency(this.mHandle, str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void runOnUiThread(long j) {
        CoeditManager_runOnUiThread(j);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void runResumeRunnable() {
        NtnlLogger.m12806d(TAG, "runResumeRunnable - start");
        for (Runnable runnable : this.mResumeRunnableMap.values()) {
            if (runnable != null) {
                runnable.run();
            }
        }
        NtnlLogger.m12806d(TAG, "runResumeRunnable - end");
        this.mResumeRunnableMap.clear();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean saveCoeditCache() {
        return CoeditManager_saveCoeditCache(this.mHandle);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void setAbnormalAckCheckPoint(long j) {
        CoeditManager_setAbnormalAckCheckPoint(this.mHandle, j);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean setLock(String str) {
        return CoeditManager_setLock(this.mHandle, str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void setNoteSnapServerCheckPoint(long j) {
        CoeditManager_setNoteSnapServerCheckPoint(this.mHandle, j);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void setServerCheckPoint(long j) {
        CoeditManager_setServerCheckPoint(this.mHandle, j);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public long stop() {
        long jCoeditManager_stop = CoeditManager_stop(this.mHandle);
        this.mResumeRunnableMap.clear();
        return jCoeditManager_stop;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void uploadContentFile(NoteOpFileData noteOpFileData, String str, String str2) {
        CoeditManager_uploadContentFile(this.mHandle, noteOpFileData.getHandle(), str, str2);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager, com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void wakeConcurrencyPool() {
        CoeditManager_wakeConcurrencyPool(this.mHandle);
    }
}
