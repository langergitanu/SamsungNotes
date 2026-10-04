package com.samsung.android.support.senl.ntnl.coedit;

import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class BaseCoeditManager implements ICoeditManager {
    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean checkSkipDownloadNote() {
        return false;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean internalSnapRefresh() {
        return false;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean isConcurrencyPaused(String str) {
        return false;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean isInitializing() {
        return false;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean isNetworkReconnecting() {
        return false;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean isRunningConcurrency() {
        return false;
    }

    public boolean isValid() {
        return false;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean isWorkingConcurrency() {
        return false;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public int pauseConcurrency(String str, Runnable runnable) {
        return 0;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean requestPermission(boolean z) {
        return false;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public int resumeConcurrency(String str) {
        return 0;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean saveCoeditCache() {
        return false;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public boolean setLock(String str) {
        return false;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public long stop() {
        return 0L;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void channelReconnected() {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void close() {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void handleWorkspaceBlock() {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void initNetworkReconnector() {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void releaseNetworkReconnector() {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void runResumeRunnable() {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void wakeConcurrencyPool() {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void handleDeviceListChange(String str) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void handleDownloadUrlMap(Map<String, String> map) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void handleResetWorkspaceResponse(long j) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void initCoeditController(ICoeditController iCoeditController) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void initGrpcController(IGrpcController iGrpcController) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void onContentFileUploadError(int i) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void onError(String str) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void onSnapError(String str) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void reconnect(String str) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void releaseLock(String str) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void runOnUiThread(long j) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void setAbnormalAckCheckPoint(long j) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void setNoteSnapServerCheckPoint(long j) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void setServerCheckPoint(long j) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void applyStrokeBinary(String str, byte[] bArr) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void downloadContentFile(String str, String str2) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void internalSnapRestart(SnapCallback snapCallback, CoeditCallback coeditCallback, String str) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void putNotifyNoteOpsBuffer(long j, List<NoteOp> list, String str) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void uploadContentFile(NoteOpFileData noteOpFileData, String str, String str2) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void externalChannelOpen(int i, String str, String str2, CoeditCallback coeditCallback) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void externalSnapDownload(int i, String str, String str2, SnapCallback snapCallback) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void externalSnapStart(int i, String str, String str2, SnapCallback snapCallback) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void externalSnapUpload(int i, String str, String str2, SnapCallback snapCallback) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void internalChannelOpen(int i, String str, String str2, CoeditCallback coeditCallback) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void internalSnapStart(int i, String str, String str2, SnapCallback snapCallback) {
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditManager
    public void handleReceiveServerResponse(long j, long j2, long j3, long j5, long j6, boolean z) {
    }
}
