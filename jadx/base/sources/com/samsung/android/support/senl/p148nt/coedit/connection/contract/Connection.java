package com.samsung.android.support.senl.p148nt.coedit.connection.contract;

import androidx.annotation.Nullable;
import com.samsung.android.support.senl.ntnl.coedit.OperationPair;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface Connection {
    void catchup(String str, long j, long j2);

    void clearMultipleTransformData();

    void clearSubmitData();

    void clearTransformData();

    void clearTransformWithMultipleData();

    void close();

    void compose(String str);

    void connect(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    boolean connectSnap(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void disconnectSnap();

    void downloadNote(String str);

    long getCoeditDataNotifyCheckPoint();

    int getCoeditDataResultCode();

    long getCoeditDataSubmitCheckPoint();

    @Nullable
    List<NoteOp> getComposedOps();

    void getDeviceList();

    int getDownloadXmlDataSize();

    @Nullable
    OperationPair<List<List<NoteOp>>> getMultipleTransformedOps();

    void getNoteSnapLatestInfo(String str);

    byte[] getSnapDataDownloadStroke(String str);

    Set<String> getSnapDataDownloadStrokeMapKeySet();

    String getSnapDataDownloadXmlData();

    String getSnapDataResourceId();

    @Nullable
    OperationPair<List<NoteOp>> getTransformedOps();

    @Nullable
    OperationPair<List<List<NoteOp>>> getTransformedWithMultipleOps();

    void handleCoeditDataReceiveMessages();

    void initialize(GrpcRunnable.Contract contract, ConnectionHelperContract connectionHelperContract);

    boolean isChannelConnected();

    boolean isCoeditDataReceiveMsgEmpty();

    boolean isCoeditDataResultDeadlineExceeded();

    boolean isCoeditDataResultNotFound();

    boolean isCoeditDataResultOk();

    boolean isCoeditDataResultUnavailable();

    boolean isSnapDataResultOk();

    boolean isVaildState();

    void multipleTransform(String str);

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

    void refreshForReopen();

    void releaseContinuousMessageThread(String str);

    void removeUndownloadedObjectInfo(String str, boolean z);

    boolean removeUnuploadedContentFileData(String str);

    void requestDownloadStroke(String str, String str2);

    boolean requestPermission(boolean z);

    void requestResetWorkspace(String str);

    void setCoeditDataAbnormalNotifyLostCatchType();

    void setCoeditDataAbnormalSubmitAckLostCatchupType();

    void setCoeditDataNormalNewMemberCatchType();

    boolean snapDataRequestUploadFileData(List<NoteOpFileData> list);

    void stop();

    void submit(String str);

    void transform(String str);

    void transformWithMultiple(String str);

    void uploadNote(String str);

    void uploadStroke(String str);
}
