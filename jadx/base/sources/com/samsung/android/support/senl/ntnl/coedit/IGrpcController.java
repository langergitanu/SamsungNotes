package com.samsung.android.support.senl.ntnl.coedit;

import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface IGrpcController {
    void catchup(String str, long j, long j2);

    void clearMultipleTransformData();

    void clearSubmitData();

    void clearTransformData();

    void clearTransformWithMultipleData();

    void closeHelper();

    void compose(String str);

    void connect(String str, String str2, String str3, String str4, String str5, String str6);

    int connectSnap(String str, String str2, String str3, String str4, String str5, String str6, int i);

    void disconnect();

    void disconnectSnap();

    void downloadNote(String str);

    long getCoeditDataNotifyCheckPoint();

    int getCoeditDataResultCode();

    long getCoeditDataSubmitCheckPoint();

    List<NoteOp> getComposedOps();

    void getDeviceList();

    OperationPair<List<List<NoteOp>>> getMultipleTransformedOps();

    void getNoteSnapLatestInfo(String str);

    byte[] getSnapDataDownloadStroke(String str);

    Set<String> getSnapDataDownloadStrokeMapKeySet();

    String getSnapDataDownloadXmlData();

    String getSnapDataResourceId();

    OperationPair<List<NoteOp>> getTransformedOps();

    OperationPair<List<List<NoteOp>>> getTransformedWithMultipleOps();

    void handleCoeditDataReceiveMessages();

    void initialize();

    boolean isCoeditDataReceiveMsgEmpty();

    boolean isCoeditDataResultOk();

    boolean isCoeditDataResultUnavailable();

    boolean isSnapDataResultOk();

    void multipleTransform(String str);

    void onStrokeApplied(String str);

    void open();

    boolean putCoeditDataSubmitRequest(long j, List<NoteOp> list, List<NoteOpFileData> list2, List<NoteOpFileData> list3, String str);

    void putComposeRequest(List<List<NoteOp>> list);

    void putMultipleTransformRequest(List<List<NoteOp>> list, List<NoteOp> list2);

    void putSnapDataUploadNoteRequest(String str, String str2, int i);

    void putSnapDataUploadStrokeRequest(String str, String str2, byte[] bArr, long j);

    void putTransformRequest(List<NoteOp> list, List<NoteOp> list2);

    void putTransformWithMultipleRequest(List<NoteOp> list, List<List<NoteOp>> list2);

    void reOpen(String str);

    void refresh();

    void removeUndownloadedObjectInfo(String str, boolean z);

    boolean removeUnuploadedContentFileData(String str);

    boolean requestPermission(boolean z);

    void requestResetWorkspace(String str);

    void runResumeRunnable();

    void setCoeditDataAbnormalNotifyLostCatchType();

    void setCoeditDataAbnormalSubmitAckLostCatchupType();

    void setCoeditDataNormalNewMemberCatchType();

    boolean snapDataRequestUploadFileData(List<NoteOpFileData> list);

    void submit(String str);

    void transform(String str);

    void transformWithMultiple(String str);

    void uploadNote(String str);

    void uploadStroke(String str);
}
