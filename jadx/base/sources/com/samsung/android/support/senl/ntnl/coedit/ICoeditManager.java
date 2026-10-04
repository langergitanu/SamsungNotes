package com.samsung.android.support.senl.ntnl.coedit;

import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface ICoeditManager {
    void applyStrokeBinary(String str, byte[] bArr);

    void channelReconnected();

    boolean checkSkipDownloadNote();

    void close();

    void downloadContentFile(String str, String str2);

    void externalChannelOpen(int i, String str, String str2, CoeditCallback coeditCallback);

    void externalSnapDownload(int i, String str, String str2, SnapCallback snapCallback);

    void externalSnapStart(int i, String str, String str2, SnapCallback snapCallback);

    void externalSnapUpload(int i, String str, String str2, SnapCallback snapCallback);

    void handleDeviceListChange(String str);

    void handleDownloadUrlMap(Map<String, String> map);

    void handleReceiveServerResponse(long j, long j2, long j3, long j5, long j6, boolean z);

    void handleResetWorkspaceResponse(long j);

    void handleWorkspaceBlock();

    void initCoeditController(ICoeditController iCoeditController);

    void initGrpcController(IGrpcController iGrpcController);

    void initNetworkReconnector();

    void internalChannelOpen(int i, String str, String str2, CoeditCallback coeditCallback);

    boolean internalSnapRefresh();

    void internalSnapRestart(SnapCallback snapCallback, CoeditCallback coeditCallback, String str);

    void internalSnapStart(int i, String str, String str2, SnapCallback snapCallback);

    boolean isConcurrencyPaused(String str);

    boolean isInitializing();

    boolean isNetworkReconnecting();

    boolean isRunningConcurrency();

    boolean isWorkingConcurrency();

    void onContentFileUploadError(int i);

    void onError(String str);

    void onSnapError(String str);

    int pauseConcurrency(String str, Runnable runnable);

    void putNotifyNoteOpsBuffer(long j, List<NoteOp> list, String str);

    void reconnect(String str);

    void releaseLock(String str);

    void releaseNetworkReconnector();

    boolean requestPermission(boolean z);

    int resumeConcurrency(String str);

    void runOnUiThread(long j);

    void runResumeRunnable();

    boolean saveCoeditCache();

    void setAbnormalAckCheckPoint(long j);

    boolean setLock(String str);

    void setNoteSnapServerCheckPoint(long j);

    void setServerCheckPoint(long j);

    long stop();

    void uploadContentFile(NoteOpFileData noteOpFileData, String str, String str2);

    void wakeConcurrencyPool();
}
