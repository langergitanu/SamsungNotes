package com.samsung.android.support.senl.p148nt.coedit.connection;

import androidx.annotation.Nullable;
import com.samsung.android.support.senl.ntnl.coedit.OperationPair;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import io.grpc.Status;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DummyConnectionHelperImpl extends ConnectionHelper {
    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void catchup(String str, long j, long j2) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void clearMultipleTransformData() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void clearSubmitData() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void clearTransformData() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void clearTransformWithMultipleData() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void close() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void compose(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void connect(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean connectSnap(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void disconnectSnap() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void downloadNote(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public long getCoeditDataNotifyCheckPoint() {
        return -2L;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public int getCoeditDataResultCode() {
        return Status.Code.UNAVAILABLE.value();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public long getCoeditDataSubmitCheckPoint() {
        return -2L;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    @Nullable
    public List<NoteOp> getComposedOps() {
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void getDeviceList() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public int getDownloadXmlDataSize() {
        return -1;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    @Nullable
    public OperationPair<List<List<NoteOp>>> getMultipleTransformedOps() {
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void getNoteSnapLatestInfo(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public byte[] getSnapDataDownloadStroke(String str) {
        return new byte[0];
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public Set<String> getSnapDataDownloadStrokeMapKeySet() {
        return new HashSet();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public String getSnapDataDownloadXmlData() {
        return "";
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public String getSnapDataResourceId() {
        return "";
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    @Nullable
    public OperationPair<List<NoteOp>> getTransformedOps() {
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    @Nullable
    public OperationPair<List<List<NoteOp>>> getTransformedWithMultipleOps() {
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void handleCoeditDataReceiveMessages() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void initialize(GrpcRunnable.Contract contract, ConnectionHelperContract connectionHelperContract) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean isChannelConnected() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean isCoeditDataReceiveMsgEmpty() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean isCoeditDataResultDeadlineExceeded() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean isCoeditDataResultNotFound() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean isCoeditDataResultOk() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean isCoeditDataResultUnavailable() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean isSnapDataResultOk() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean isVaildState() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void multipleTransform(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void open() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean putCoeditDataSubmitRequest(long j, List<NoteOp> list, List<NoteOpFileData> list2, List<NoteOpFileData> list3, String str) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void putComposeRequest(List<List<NoteOp>> list) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void putMultipleTransformRequest(List<List<NoteOp>> list, List<NoteOp> list2) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void putSnapDataUploadNoteRequest(String str, String str2, int i) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void putSnapDataUploadStrokeRequest(String str, String str2, byte[] bArr, long j) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void putTransformRequest(List<NoteOp> list, List<NoteOp> list2) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void putTransformWithMultipleRequest(List<NoteOp> list, List<List<NoteOp>> list2) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void reOpen(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void refresh() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void refreshForReopen() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void releaseContinuousMessageThread(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void removeUndownloadedObjectInfo(String str, boolean z) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean removeUnuploadedContentFileData(String str) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void requestDownloadStroke(String str, String str2) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean requestPermission(boolean z) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void requestResetWorkspace(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void setCoeditDataAbnormalNotifyLostCatchType() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void setCoeditDataAbnormalSubmitAckLostCatchupType() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void setCoeditDataNormalNewMemberCatchType() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean snapDataRequestUploadFileData(List<NoteOpFileData> list) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void stop() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void submit(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void transform(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void transformWithMultiple(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void uploadNote(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void uploadStroke(String str) {
    }
}
