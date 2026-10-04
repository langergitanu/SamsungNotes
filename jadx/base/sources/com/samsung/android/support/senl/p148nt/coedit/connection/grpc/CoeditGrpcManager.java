package com.samsung.android.support.senl.p148nt.coedit.connection.grpc;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import coeditCoreMessage.BinaryInfo;
import coeditCoreMessage.CatchupType;
import coeditCoreMessage.ObjectInfo;
import coeditOtMessage.IdxCedOpsPair;
import coeditOtMessage.MultipleTransformResponse;
import coeditOtMessage.TransformResponse;
import coeditOtMessage.TransformWithMultipleResponse;
import com.samsung.android.support.senl.ntnl.coedit.OperationPair;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.CoeditGrpcClient;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.CoeditTransformClient;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcDataContract;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditTransformDataContract;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.CoeditGrpcMethod;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.ProtoBufUtils;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditGrpcManager {
    private static final String TAG = "CoeditGrpcManager";
    private CoeditGrpcClient mCoeditClient;
    private CoeditTransformClient mCoeditTransformClient;

    public void addUploadContentFileData(NoteOpFileData noteOpFileData) {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient == null) {
            return;
        }
        coeditGrpcClient.getCoeditData().addUploadContentFileData(noteOpFileData);
        requestCoedit(CoeditGrpcMethod.Caller.GetObjectUploadUrl, 101);
    }

    public void clearComposeData() {
        this.mCoeditTransformClient.getTransformData().clearComposeRequestQueue();
        this.mCoeditTransformClient.getTransformData().clearComposeResponseQueue();
    }

    public void clearMultipleTransformData() {
        this.mCoeditTransformClient.getTransformData().clearMultipleTransformRequestQueue();
        this.mCoeditTransformClient.getTransformData().clearMultipleTransformResponseQueue();
    }

    public void clearSubmitData() {
        this.mCoeditClient.getCoeditData().clearSubmitRequestQueue();
    }

    public void clearTransformData() {
        this.mCoeditTransformClient.getTransformData().clearTransformRequestQueue();
        this.mCoeditTransformClient.getTransformData().clearTransformResponseQueue();
    }

    public void clearTransformWithMultipleData() {
        this.mCoeditTransformClient.getTransformData().clearTransformWithMultipleRequestQueue();
        this.mCoeditTransformClient.getTransformData().clearTransformWithMultipleResponseQueue();
    }

    public void coeditDataRequestUploadObjects(List<NoteOpFileData> list) {
        Iterator<NoteOpFileData> it = list.iterator();
        while (it.hasNext()) {
            addUploadContentFileData(it.next());
        }
    }

    public void createChannel(String str, String str2, String str3, String str4, String str5, String str6, String str7, GrpcRunnable.Contract contract, CoeditGrpcDataContract coeditGrpcDataContract, CoeditTransformDataContract coeditTransformDataContract) {
        CoeditLogger.m8919d(TAG, "createChannel workspaceId : " + str7);
        this.mCoeditClient = new CoeditGrpcClient(str, "443", str2, str3, str4, str5, str6, str7, coeditGrpcDataContract, contract);
        this.mCoeditTransformClient = new CoeditTransformClient(str, "443", str2, str3, str4, str5, str7, coeditTransformDataContract, contract);
        requestCoedit("createChannel", 0);
        requestCoeditTransform("createChannel", 0);
    }

    public CoeditGrpcData.StrokeData findStrokeData(byte[] bArr) {
        return this.mCoeditClient.getCoeditData().findStrokeData(bArr);
    }

    public long getCoeditDataNotifyCheckPoint() {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient == null) {
            return -2L;
        }
        return coeditGrpcClient.getCoeditData().getNotifyCheckPoint();
    }

    public Object getCoeditDataReceiveMsgData() {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient == null) {
            return null;
        }
        return coeditGrpcClient.getCoeditData().takeReceiveMsg();
    }

    public int getCoeditDataResultCode() {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        return coeditGrpcClient == null ? Status.Code.UNAVAILABLE.value() : coeditGrpcClient.getCoeditData().getResultCode();
    }

    public long getCoeditDataSubmitCheckPoint() {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient == null) {
            return -2L;
        }
        return coeditGrpcClient.getCoeditData().getSubmitCheckPoint();
    }

    @Nullable
    public List<NoteOp> getComposedOps() {
        if (!this.mCoeditTransformClient.getTransformData().isComposeResponseEmpty()) {
            return ProtoBufUtils.deserialize(this.mCoeditTransformClient.getTransformData().takeComposeResponse().getPairs().getCedOps().getCoeditOperationList());
        }
        CoeditLogger.m8920e(TAG, "getComposeResponse is empty");
        return null;
    }

    @Nullable
    public OperationPair getMultipleTransformedOps() {
        if (this.mCoeditTransformClient.getTransformData().isMultipleTransformResponseEmpty()) {
            CoeditLogger.m8920e(TAG, "getMultipleTransformedOps is empty");
            return null;
        }
        MultipleTransformResponse multipleTransformResponseTakeMultipleTransformResponse = this.mCoeditTransformClient.getTransformData().takeMultipleTransformResponse();
        ArrayList arrayList = new ArrayList();
        Iterator<IdxCedOpsPair> it = multipleTransformResponseTakeMultipleTransformResponse.getFirstList().iterator();
        while (it.hasNext()) {
            arrayList.add(ProtoBufUtils.deserialize(it.next().getCedOps().getCoeditOperationList()));
        }
        return new OperationPair(arrayList, ProtoBufUtils.deserialize(multipleTransformResponseTakeMultipleTransformResponse.getSecond().getCedOps().getCoeditOperationList()));
    }

    @Nullable
    public OperationPair<List<NoteOp>> getTransformedOps() {
        if (this.mCoeditTransformClient.getTransformData().isTransformResponseEmpty()) {
            CoeditLogger.m8920e(TAG, "TransformedOps is empty");
            return null;
        }
        TransformResponse transformResponseTakeTransformResponse = this.mCoeditTransformClient.getTransformData().takeTransformResponse();
        return new OperationPair<>(ProtoBufUtils.deserialize(transformResponseTakeTransformResponse.getFirstTransformed().getCedOps().getCoeditOperationList()), ProtoBufUtils.deserialize(transformResponseTakeTransformResponse.getSecondTransformed().getCedOps().getCoeditOperationList()));
    }

    @Nullable
    public OperationPair getTransformedWithMultipleOps() {
        if (this.mCoeditTransformClient.getTransformData().isTransformWithMultipleResponseEmpty()) {
            CoeditLogger.m8920e(TAG, "getTransformedWithMultipleOps is empty");
            return null;
        }
        TransformWithMultipleResponse transformWithMultipleResponseTakeTransformWithMultipleResponse = this.mCoeditTransformClient.getTransformData().takeTransformWithMultipleResponse();
        ArrayList arrayList = new ArrayList();
        Iterator<IdxCedOpsPair> it = transformWithMultipleResponseTakeTransformWithMultipleResponse.getSecondList().iterator();
        while (it.hasNext()) {
            arrayList.add(ProtoBufUtils.deserialize(it.next().getCedOps().getCoeditOperationList()));
        }
        return new OperationPair(ProtoBufUtils.deserialize(transformWithMultipleResponseTakeTransformWithMultipleResponse.getFirst().getCedOps().getCoeditOperationList()), arrayList);
    }

    public List<ObjectInfo> getUndownloadedObjectInfo() {
        return this.mCoeditClient.getCoeditData().getUndownloadedObjectInfo();
    }

    public List<NoteOpFileData> getUnuploadedNoteOpFileDatas() {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        return coeditGrpcClient == null ? new ArrayList() : coeditGrpcClient.getCoeditData().getUnuploadedNoteOpFileDatas();
    }

    public String getWorkspaceId() {
        return this.mCoeditClient.getCoeditData().getWorkspaceId();
    }

    public long getWorkspaceVersion() {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient != null) {
            return coeditGrpcClient.getCoeditData().getWorkspaceVersion();
        }
        CoeditLogger.m8924w(TAG, "getWorkspaceVersion. CoeditClient is invalid");
        return 0L;
    }

    public void initUploadedStroke(List<NoteOpFileData> list) {
        this.mCoeditClient.getCoeditData().initUploadedStrokeObjectInfos();
        this.mCoeditClient.getCoeditData().initUploadStrokeRequestSize(list.size());
    }

    public boolean isChannelConnected() {
        return this.mCoeditClient != null;
    }

    public boolean isCoeditDataReceiveMsgEmpty() {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient == null) {
            return true;
        }
        return coeditGrpcClient.getCoeditData().isReceiveMsgQueueEmpty();
    }

    public boolean isCoeditDataResultDeadlineExceeded() {
        return getCoeditDataResultCode() == Status.Code.DEADLINE_EXCEEDED.value();
    }

    public boolean isCoeditDataResultNotFound() {
        return getCoeditDataResultCode() == Status.Code.NOT_FOUND.value();
    }

    public boolean isCoeditDataResultOk() {
        return getCoeditDataResultCode() == Status.Code.OK.value();
    }

    public boolean isCoeditDataResultUnavailable() {
        return getCoeditDataResultCode() == Status.Code.UNAVAILABLE.value();
    }

    public boolean isUploadStrokeFailed() {
        return this.mCoeditClient.getCoeditData().isUploadStrokeFailed();
    }

    public boolean isUploadStrokeFinished() {
        return this.mCoeditClient.getCoeditData().isUploadStrokeFinished();
    }

    public void putCoeditDataDownloadStrokeMsgQueue(String str) throws InterruptedException {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient == null) {
            return;
        }
        coeditGrpcClient.getCoeditData().putDownloadStrokeRequest(str);
    }

    public void putCoeditDataUploadStrokeMsgQueue(String str, long j, String str2, byte[] bArr) throws InterruptedException {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient == null) {
            return;
        }
        coeditGrpcClient.getCoeditData().putUploadStrokeRequest(str, j, str2, bArr);
    }

    public void putComposeRequest(List<List<NoteOp>> list) throws InterruptedException {
        clearComposeData();
        this.mCoeditTransformClient.getTransformData().putComposeRequest(list);
    }

    public void putDownloadStrokeData(String str, String str2) {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient != null) {
            coeditGrpcClient.getCoeditData().putDownloadStrokeData(str, str2);
        }
    }

    public void putMultipleTransformRequest(List<List<NoteOp>> list, List<NoteOp> list2) throws InterruptedException {
        this.mCoeditTransformClient.getTransformData().putMultipleTransformRequest(list, list2);
    }

    public void putPermissionRequest(boolean z) throws InterruptedException {
        this.mCoeditClient.getCoeditData().putPermissionRequest(z);
    }

    public void putSubmitRequest(List<NoteOp> list, long j, String str, List<ObjectInfo> list2) throws InterruptedException {
        this.mCoeditClient.getCoeditData().putSubmitRequest(list, j, str, list2);
    }

    public void putTransformRequest(List<NoteOp> list, List<NoteOp> list2) throws InterruptedException {
        this.mCoeditTransformClient.getTransformData().putTransformRequest(list, list2);
    }

    public void putTransformWithMultipleRequest(List<NoteOp> list, List<List<NoteOp>> list2) throws InterruptedException {
        this.mCoeditTransformClient.getTransformData().putTransformWithMultipleRequest(list, list2);
    }

    public void refreshForReopen() {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient != null) {
            coeditGrpcClient.refreshForReopen();
        }
        CoeditTransformClient coeditTransformClient = this.mCoeditTransformClient;
        if (coeditTransformClient != null) {
            coeditTransformClient.refreshForReopen();
        }
    }

    public void release() {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient != null) {
            coeditGrpcClient.release();
            this.mCoeditClient = null;
        }
        CoeditTransformClient coeditTransformClient = this.mCoeditTransformClient;
        if (coeditTransformClient != null) {
            coeditTransformClient.release();
            this.mCoeditTransformClient = null;
        }
    }

    public void releaseContinuousMessageThread(String str) {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient == null) {
            return;
        }
        coeditGrpcClient.releaseContinuousMessageThread("releaseContinuousMessageThread/" + str);
    }

    public void removeDownloadStrokeData(String str) {
        this.mCoeditClient.getCoeditData().removeDownloadStrokeData(str);
    }

    public void removeUndownloadedObjectInfo(String str, boolean z) {
        this.mCoeditClient.getCoeditData().removeUndownloadedObjectInfo(str, z);
    }

    public boolean removeUnuploadedContentFileData(String str) {
        return this.mCoeditClient.getCoeditData().removeUnuploadedContentFileData(str);
    }

    public void requestCatchup(long j, long j2) {
        this.mCoeditClient.getCoeditData().setCatchupStartCheckPoint(j);
        this.mCoeditClient.getCoeditData().setCatchupEndCheckPoint(j2);
    }

    public void requestCoedit(String str, int i) {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient != null) {
            coeditGrpcClient.request(str, i);
            return;
        }
        CoeditLogger.m8924w(TAG, "requestCoedit, skip, CoeditClient is invalid, message : " + str + ", method : " + i);
    }

    public void requestCoeditTransform(String str, int i) {
        CoeditTransformClient coeditTransformClient = this.mCoeditTransformClient;
        if (coeditTransformClient != null) {
            coeditTransformClient.request(str, i);
            return;
        }
        CoeditLogger.m8924w(TAG, "requestCoeditTransform, skip, CoeditTransformClient is invalid, message : " + str + ", method : " + i);
    }

    public void requestDownloadObject(ObjectInfo objectInfo) {
        this.mCoeditClient.getCoeditData().addDownloadContentFileObjectInfo(objectInfo);
        requestCoedit(CoeditGrpcMethod.Caller.GetSignedDownloadUrl, 102);
    }

    public void setCoeditDataCatchupType(CatchupType catchupType) {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient == null) {
            return;
        }
        coeditGrpcClient.getCoeditData().setCatchupType(catchupType);
    }

    public void setCoeditDataNotifyCheckPoint(long j) {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient == null) {
            return;
        }
        coeditGrpcClient.getCoeditData().setNotifyCheckPoint(j);
    }

    public void setCoeditDataSubmitCheckPoint(long j) {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient == null) {
            return;
        }
        coeditGrpcClient.getCoeditData().setSubmitCheckPoint(j);
    }

    public void setObjectInfo(List<ObjectInfo> list, List<NoteOp> list2) {
        List<ObjectInfo> uploadedStrokeObjectInfos = this.mCoeditClient.getCoeditData().getUploadedStrokeObjectInfos();
        for (NoteOp noteOp : list2) {
            boolean zIsEmpty = TextUtils.isEmpty(noteOp.getObjectId());
            if (zIsEmpty) {
                if (noteOp.getFileData() != null) {
                    Iterator<ObjectInfo> it = uploadedStrokeObjectInfos.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ObjectInfo next = it.next();
                        if (next.getBinaryInfo().getHash().equals(noteOp.getFileData().getId())) {
                            noteOp.setBinaryHash(next.getBinaryInfo().getHash());
                            noteOp.setBinarySize(next.getBinaryInfo().getSize());
                            noteOp.setBinaryMimeType(next.getBinaryInfo().getMimetype());
                            noteOp.setObjectId(next.getObjId());
                            zIsEmpty = false;
                            break;
                        }
                    }
                }
            }
            if (!zIsEmpty) {
                list.add(ObjectInfo.newBuilder().setBinaryInfo(BinaryInfo.newBuilder().setHash(noteOp.getBinaryHash()).setSize(noteOp.getBinarySize()).setMimetype(noteOp.getBinaryMimeType()).build()).setObjId(noteOp.getObjectId()).build());
            }
        }
    }

    public void setResponsedWorkspaceVersion(long j) {
        CoeditGrpcClient coeditGrpcClient = this.mCoeditClient;
        if (coeditGrpcClient != null) {
            coeditGrpcClient.getCoeditData().setResponsedWorkspaceVersion(j);
        }
    }

    public void stopChannel() {
        requestCoeditTransform("stopChannel", 4);
        requestCoedit("stopChannel", 4);
    }
}
