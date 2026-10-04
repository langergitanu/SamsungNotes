package com.samsung.android.support.senl.p148nt.coedit.connection.grpc;

import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface ConnectionHelperContract {
    void applyStrokeBinary(String str, String str2, byte[] bArr);

    void downloadContentFile(String str, String str2);

    String getUuid();

    String getWorkspaceId();

    void handleDownloadUrlMap(Map<String, String> map);

    void handleReceiveDeviceList(String str);

    void handleReceiveServerResponse(long j, long j2, long j3, long j5, long j6, boolean z);

    void handleResetWorkspaceResponse(long j);

    void handleWorkspaceBlock();

    boolean isConcurrencyPausedByNetwork();

    void onContentFileUploadError(int i);

    void onEditorUpdate(String str, String str2);

    void onSnapError(String str);

    void putNotifyNoteOpsBuffer(long j, List<NoteOp> list, String str);

    void reconnect(String str);

    void releaseLock(String str);

    void saveDownloadStrokeData(String str, String str2);

    void setAbnormalAckCheckPoint(long j);

    boolean setLock(String str);

    void setPausedByNetwork(String str);

    void updateSnapNoteLatestInfo(long j, long j2, String str);

    void uploadContentFile(NoteOpFileData noteOpFileData, String str, String str2);

    void wakeConcurrencyPool();
}
