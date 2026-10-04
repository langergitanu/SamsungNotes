package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import coeditCore.CatcherGrpc;
import coeditCore.ContinuerGrpc;
import coeditCore.PolicyManagerGrpc;
import coeditCore.SubmitterGrpc;
import coeditCore.WorkspaceManagerGrpc;
import coeditCoreMessage.CatchupRequest;
import coeditCoreMessage.CatchupResponse;
import coeditCoreMessage.CatchupType;
import coeditCoreMessage.CheckPointCoeditOpPair;
import coeditCoreMessage.ClientCmd;
import coeditCoreMessage.ClientMsg;
import coeditCoreMessage.ObjectInfo;
import coeditCoreMessage.PermissionRequest;
import coeditCoreMessage.PermissionResponse;
import coeditCoreMessage.PermissionType;
import coeditCoreMessage.ResetWorkspaceRequest;
import coeditCoreMessage.ResetWorkspaceResponse;
import coeditCoreMessage.ServerMsg;
import coeditCoreMessage.SubmitRequest;
import coeditCoreMessage.SubmitResponse;
import coeditObject.DownloaderGrpc;
import coeditObject.UploaderGrpc;
import coeditObjectMessage.Binary;
import coeditObjectMessage.BinaryInfo;
import coeditObjectMessage.DownloadStrokeRequest;
import coeditObjectMessage.DownloadStrokeResponse;
import coeditObjectMessage.ObjUploadUrlRequest;
import coeditObjectMessage.ObjUploadUrlResponse;
import coeditObjectMessage.SignedDownloadUrlRequest;
import coeditObjectMessage.SignedDownloadUrlResponse;
import coeditObjectMessage.UploadStrokeRequest;
import coeditObjectMessage.UploadStrokeResponse;
import com.google.protobuf.ByteString;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.coedit.common.CoeditConstants;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.data.GrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.ProtoBufUtils;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditGrpcData extends GrpcData {
    private static final int MAX_INBOUND = 8388608;
    private static final String TAG = "CoeditGrpcData";
    private CatcherGrpc.CatcherStub mCatcherAsyncStub;
    private long mCatchupEndCheckPoint;
    private long mCatchupStartCheckPoint;
    private CatchupType mCatchupType;
    private CoeditGrpcDataContract mContract;
    private String mNoteId;
    private long mNotifyCheckPoint;
    protected DownloaderGrpc.DownloaderStub mObjectDownloaderAsyncStub;
    protected DownloaderGrpc.DownloaderBlockingStub mObjectDownloaderStub;
    private UploaderGrpc.UploaderStub mObjectUploaderAsyncStub;
    protected UploaderGrpc.UploaderBlockingStub mObjectUploaderStub;
    private PolicyManagerGrpc.PolicyManagerBlockingStub mPolicyStub;
    private String mResourceId;
    private int mResultCode;
    private long mSubmitCheckPoint;
    private SubmitterGrpc.SubmitterBlockingStub mSubmitterStub;
    private String mWorkspaceId;
    private WorkspaceManagerGrpc.WorkspaceManagerBlockingStub mWorkspaceStub;
    private long mResponsedWorkspaceVersion = 0;
    private long mUploadStrokeCompleteSize = 0;
    private long mUploadStrokeFailedSize = 0;
    private long mUploadStrokeRequestSize = 0;
    private final LinkedBlockingQueue<ClientMsg> mClientMsgQueue = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<SubmitRequest> mSubmitMsgQueue = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<Pair<UploadStrokeRequest, UploadStrokeRequest>> mUploadStrokeRequest = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<DownloadStrokeRequest> mDownloadStrokeRequest = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<PermissionRequest> mPermissionRequestQueue = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<Object> mReceiveMsgQueue = new LinkedBlockingQueue<>();
    private final Map<String, StrokeData> mDownloadStrokeMap = new LinkedHashMap();
    private final Set<String> mDownloadingObjectId = new HashSet();
    private final Set<String> mUploadingContentFileId = new HashSet();
    private final LinkedBlockingQueue<NoteOpFileData> mUploadContentFileDatas = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<ObjectInfo> mDownloadContentFileObjectInfos = new LinkedBlockingQueue<>();
    private final List<ObjectInfo> mUploadedStrokeObjectInfos = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StrokeData {
        byte[] mBytes;
        final String mObjId;
        final String mObjectBinaryHash;

        public StrokeData(String str, String str2) {
            this.mObjId = str;
            this.mObjectBinaryHash = str2;
        }

        public boolean findObjectBinaryHash(byte[] bArr) {
            return Arrays.equals(this.mBytes, bArr);
        }

        public String getObjId() {
            return this.mObjId;
        }

        public String getObjectBinaryHash() {
            return this.mObjectBinaryHash;
        }

        public void release() {
            this.mBytes = null;
        }

        public void setBytes(byte[] bArr) {
            this.mBytes = bArr;
        }
    }

    private synchronized void addDownloadingObjectId(String str) {
        this.mDownloadingObjectId.add(str);
    }

    private synchronized void addUploadingContentFileId(String str) {
        this.mUploadingContentFileId.add(str);
    }

    private synchronized boolean isDownloadingObjectIdExist() {
        return !this.mDownloadingObjectId.isEmpty();
    }

    private synchronized boolean isUploadingContentFileIdExist() {
        return !this.mUploadingContentFileId.isEmpty();
    }

    private synchronized void removeDownloadingObjectId(String str) {
        this.mDownloadingObjectId.remove(str);
    }

    private synchronized void removeUploadingContentFileId(String str) {
        this.mUploadingContentFileId.remove(str);
    }

    public synchronized void addDownloadContentFileObjectInfo(ObjectInfo objectInfo) {
        this.mDownloadContentFileObjectInfos.add(objectInfo);
        addDownloadingObjectId(objectInfo.getObjId());
        CoeditCacheUtils.addUndownloadedObjectInfo(this.mNoteId, objectInfo.getObjId(), objectInfo.getDownloadSignedUrl());
    }

    public synchronized void addUploadContentFileData(@NonNull NoteOpFileData noteOpFileData) {
        if (TextUtils.isEmpty(noteOpFileData.getId())) {
            return;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        this.mUploadContentFileDatas.add(noteOpFileData);
        addUploadingContentFileId(noteOpFileData.getId());
        noteOpFileData.saveCoeditCache(CoeditCacheUtils.getUnuploadedContentFileCachePath(applicationContext, this.mNoteId, noteOpFileData.getId()));
    }

    public synchronized void addUploadedStrokeObjectInfo(ObjectInfo objectInfo) {
        this.mUploadedStrokeObjectInfos.add(objectInfo);
    }

    public void asyncCatchup(String str, CatchupRequest catchupRequest, StreamObserver<CatchupResponse> streamObserver) {
        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.m13734of("requestId", Metadata.ASCII_STRING_MARSHALLER), str);
        ((CatcherGrpc.CatcherStub) MetadataUtils.attachHeaders(this.mCatcherAsyncStub, metadata)).catchup(catchupRequest, streamObserver);
    }

    public StreamObserver<ClientMsg> asyncContinuousMessage(StreamObserver<ServerMsg> streamObserver) {
        return ((ContinuerGrpc.ContinuerStub) MetadataUtils.attachHeaders(ContinuerGrpc.newStub(this.mChannel), this.mMetadata)).continuousMessage(streamObserver);
    }

    public void asyncDownloadStroke(DownloadStrokeRequest downloadStrokeRequest, StreamObserver<DownloadStrokeResponse> streamObserver) {
        this.mObjectDownloaderAsyncStub.downloadStroke(downloadStrokeRequest, streamObserver);
    }

    public void clearSubmitRequestQueue() {
        this.mSubmitMsgQueue.clear();
    }

    public synchronized void downloadContentFileObjectInfos(ObjectInfo objectInfo) {
        CoeditGrpcDataContract coeditGrpcDataContract = this.mContract;
        if (coeditGrpcDataContract == null) {
            return;
        }
        coeditGrpcDataContract.downloadContentFile(objectInfo);
    }

    public synchronized StrokeData findStrokeData(byte[] bArr) {
        for (StrokeData strokeData : this.mDownloadStrokeMap.values()) {
            if (strokeData.findObjectBinaryHash(bArr)) {
                return strokeData;
            }
        }
        return null;
    }

    public StreamObserver<UploadStrokeRequest> getAsyncUploadStroke(StreamObserver<UploadStrokeResponse> streamObserver) {
        return this.mObjectUploaderAsyncStub.uploadStroke(streamObserver);
    }

    public long getCatchupEndCheckPoint() {
        return this.mCatchupEndCheckPoint;
    }

    public long getCatchupStartCheckPoint() {
        return this.mCatchupStartCheckPoint;
    }

    public CatchupType getCatchupType() {
        return this.mCatchupType;
    }

    public String getNoteId() {
        return this.mNoteId;
    }

    public long getNotifyCheckPoint() {
        return this.mNotifyCheckPoint;
    }

    public ObjUploadUrlResponse getObjUploadUrl(ObjUploadUrlRequest objUploadUrlRequest) {
        return this.mObjectUploaderStub.getObjectUploadUrl(objUploadUrlRequest);
    }

    public String getResourceId() {
        return this.mResourceId;
    }

    public long getResponsedWorkspaceVersion() {
        return this.mResponsedWorkspaceVersion;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public SignedDownloadUrlResponse getSignedDownloadUrl(SignedDownloadUrlRequest signedDownloadUrlRequest) {
        return this.mObjectDownloaderStub.getSignedDownloadUrl(signedDownloadUrlRequest);
    }

    public long getSubmitCheckPoint() {
        return this.mSubmitCheckPoint;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.data.GrpcData
    public String getTag() {
        return TAG;
    }

    public synchronized List<ObjectInfo> getUndownloadedObjectInfo() {
        try {
            ArrayList arrayList = new ArrayList();
            if (isDownloadingObjectIdExist()) {
                return arrayList;
            }
            for (Map.Entry<String, String> entry : CoeditCacheUtils.getUndownloadedObjectInfo(this.mNoteId).entrySet()) {
                if (entry != null && !TextUtils.isEmpty(entry.getKey())) {
                    arrayList.add(ObjectInfo.newBuilder().setObjId(entry.getKey()).setDownloadSignedUrl(entry.getValue()).build());
                }
            }
            if (arrayList.size() > 0) {
                CoeditLogger.m8919d(TAG, "getUndownloadedObjectInfo: " + arrayList.size());
            }
            return arrayList;
        } catch (Throwable th) {
            throw th;
        }
    }

    public List<NoteOpFileData> getUnuploadedNoteOpFileDatas() {
        Context applicationContext;
        ArrayList arrayList = new ArrayList();
        if (!isUploadingContentFileIdExist() && (applicationContext = BaseUtils.getApplicationContext()) != null) {
            for (String str : CoeditCacheUtils.getUnuploadedContentFiles(applicationContext, this.mNoteId)) {
                NoteOpFileData noteOpFileData = new NoteOpFileData();
                noteOpFileData.loadCoeditCache(str);
                arrayList.add(noteOpFileData);
            }
            if (arrayList.size() > 0) {
                CoeditLogger.m8919d(TAG, "getUnuploadedNoteOpFileDatas: " + arrayList.size());
            }
        }
        return arrayList;
    }

    public synchronized List<ObjectInfo> getUploadedStrokeObjectInfos() {
        return this.mUploadedStrokeObjectInfos;
    }

    public String getWorkspaceId() {
        if (this.mContract != null && TextUtils.isEmpty(this.mWorkspaceId)) {
            this.mWorkspaceId = this.mContract.getWorkspaceId();
        }
        return this.mWorkspaceId;
    }

    public long getWorkspaceVersion() {
        return CoeditCacheUtils.getWorkspaceVersion(this.mNoteId);
    }

    public boolean hasSubmitRequestQueue() {
        return !this.mSubmitMsgQueue.isEmpty();
    }

    public synchronized void increaseUploadStrokeCompleteSize() {
        this.mUploadStrokeCompleteSize++;
        CoeditLogger.m8919d(TAG, "increaseUploadStrokeCompleteSize: complete[" + this.mUploadStrokeCompleteSize + "]/failed[" + this.mUploadStrokeFailedSize + "]/request[" + this.mUploadStrokeRequestSize + "]");
        if (isUploadStrokeFinished()) {
            releaseLock("UploadStroke Object Finished");
        }
    }

    public synchronized void increaseUploadStrokeFailedSize() {
        this.mUploadStrokeFailedSize++;
        CoeditLogger.m8924w(TAG, "increaseUploadStrokeFailedSize: complete[" + this.mUploadStrokeCompleteSize + "]/failed[" + this.mUploadStrokeFailedSize + "]/request[" + this.mUploadStrokeRequestSize + "]");
        if (isUploadStrokeFinished()) {
            releaseLock("UploadStroke Object Finished");
        }
    }

    public synchronized void initUploadStrokeRequestSize(long j) {
        this.mUploadStrokeCompleteSize = 0L;
        this.mUploadStrokeFailedSize = 0L;
        this.mUploadStrokeRequestSize = j;
        CoeditLogger.m8919d(TAG, "initUploadStrokeRequestSize: request[" + this.mUploadStrokeRequestSize + "]");
    }

    public synchronized void initUploadedStrokeObjectInfos() {
        this.mUploadedStrokeObjectInfos.clear();
    }

    public void initialize(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CoeditGrpcDataContract coeditGrpcDataContract) {
        super.initialize(str, str2, str3, str4, str5, str6);
        setWorkspaceId(str8);
        setNoteId(str7);
        this.mContract = coeditGrpcDataContract;
        this.mSubmitterStub = (SubmitterGrpc.SubmitterBlockingStub) MetadataUtils.attachHeaders(SubmitterGrpc.newBlockingStub(this.mChannel), this.mMetadata);
        this.mCatcherAsyncStub = (CatcherGrpc.CatcherStub) MetadataUtils.attachHeaders(CatcherGrpc.newStub(this.mChannel), this.mMetadata);
        this.mPolicyStub = (PolicyManagerGrpc.PolicyManagerBlockingStub) MetadataUtils.attachHeaders(PolicyManagerGrpc.newBlockingStub(this.mChannel), this.mMetadata);
        this.mWorkspaceStub = (WorkspaceManagerGrpc.WorkspaceManagerBlockingStub) MetadataUtils.attachHeaders(WorkspaceManagerGrpc.newBlockingStub(this.mChannel), this.mMetadata);
        this.mObjectUploaderStub = (UploaderGrpc.UploaderBlockingStub) MetadataUtils.attachHeaders(UploaderGrpc.newBlockingStub(this.mChannel), this.mMetadata);
        this.mObjectUploaderAsyncStub = (UploaderGrpc.UploaderStub) MetadataUtils.attachHeaders(UploaderGrpc.newStub(this.mChannel), this.mMetadata);
        this.mObjectDownloaderStub = (DownloaderGrpc.DownloaderBlockingStub) MetadataUtils.attachHeaders(DownloaderGrpc.newBlockingStub(this.mChannel), this.mMetadata);
        this.mObjectDownloaderAsyncStub = (DownloaderGrpc.DownloaderStub) MetadataUtils.attachHeaders(DownloaderGrpc.newStub(this.mChannel), this.mMetadata);
    }

    public boolean isCatchupRequestDataValid() {
        return (this.mCatchupStartCheckPoint == -2 || this.mCatchupEndCheckPoint == -2) ? false : true;
    }

    public boolean isClientMsgEmpty() {
        return this.mClientMsgQueue.isEmpty();
    }

    public boolean isConcurrencyPausedByNetwork() {
        CoeditGrpcDataContract coeditGrpcDataContract = this.mContract;
        if (coeditGrpcDataContract == null) {
            return false;
        }
        return coeditGrpcDataContract.isConcurrencyPausedByNetwork();
    }

    public synchronized boolean isDownloadContentFileObjectInfoExist() {
        return !this.mDownloadContentFileObjectInfos.isEmpty();
    }

    public boolean isDownloadStrokeRequestQueueEmpty() {
        return this.mDownloadStrokeRequest.isEmpty();
    }

    public boolean isInvalidAsyncCatcher() {
        return this.mCatcherAsyncStub == null;
    }

    public boolean isInvalidAsyncObjectUploader() {
        return this.mObjectUploaderAsyncStub == null;
    }

    public boolean isInvalidObjectAsyncDownloader() {
        return this.mObjectDownloaderAsyncStub == null;
    }

    public boolean isInvalidObjectDownloader() {
        return this.mObjectDownloaderStub == null;
    }

    public boolean isInvalidObjectUploader() {
        return this.mObjectUploaderStub == null;
    }

    public boolean isInvalidPolicyManager() {
        return this.mPolicyStub == null;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.data.GrpcData
    public boolean isInvalidStub() {
        return isInvalidSubmitter() || isInvalidAsyncCatcher();
    }

    public boolean isInvalidSubmitter() {
        return this.mSubmitterStub == null;
    }

    public boolean isInvalidWorkspaceManager() {
        return this.mWorkspaceStub == null;
    }

    public boolean isPermissionRequestQueueEmpty() {
        return this.mPermissionRequestQueue.isEmpty();
    }

    public boolean isReceiveMsgQueueEmpty() {
        return this.mReceiveMsgQueue.isEmpty();
    }

    public synchronized boolean isUploadContentFileDataExist() {
        return !this.mUploadContentFileDatas.isEmpty();
    }

    public synchronized boolean isUploadStrokeFailed() {
        return 0 < this.mUploadStrokeFailedSize;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isUploadStrokeFinished() {
        boolean z;
        long j = this.mUploadStrokeRequestSize;
        if (0 < j) {
            z = j <= this.mUploadStrokeCompleteSize + this.mUploadStrokeFailedSize;
        }
        return z;
    }

    public boolean isUploadStrokeRequestQueueEmpty() {
        return this.mUploadStrokeRequest.isEmpty();
    }

    public void notify(ServerMsg serverMsg) {
        CoeditGrpcDataContract coeditGrpcDataContract = this.mContract;
        if (coeditGrpcDataContract == null) {
            return;
        }
        coeditGrpcDataContract.notify(serverMsg);
    }

    public void onContentFileUploadError(int i) {
    }

    public void putClientMsg(ClientMsg clientMsg) throws InterruptedException {
        this.mClientMsgQueue.put(clientMsg);
    }

    public synchronized void putDownloadStrokeData(String str, String str2) {
        this.mDownloadStrokeMap.put(str, new StrokeData(str, str2));
    }

    public void putDownloadStrokeRequest(String str) throws InterruptedException {
        this.mDownloadStrokeRequest.put(DownloadStrokeRequest.newBuilder().setObjId(str).build());
    }

    public void putPermissionRequest(boolean z) throws InterruptedException {
        this.mPermissionRequestQueue.put(PermissionRequest.newBuilder().setPermissionType(z ? PermissionType.EDIT : PermissionType.VIEW).build());
    }

    public void putReceiveMsg(Object obj) throws InterruptedException {
        this.mReceiveMsgQueue.put(obj);
        CoeditGrpcDataContract coeditGrpcDataContract = this.mContract;
        if (coeditGrpcDataContract != null) {
            coeditGrpcDataContract.wakeConcurrencyPool();
        }
    }

    public void putSubmitRequest(List<NoteOp> list, long j, String str, List<ObjectInfo> list2) throws InterruptedException {
        this.mSubmitMsgQueue.put(SubmitRequest.newBuilder().setClientCmd(ClientCmd.SUBMIT).setCheckpointCoeditopPair(CheckPointCoeditOpPair.newBuilder().setCheckpoint(j).setExtraData(str).addAllCoeditOperation(ProtoBufUtils.serialize(list)).addAllObjectInfo(list2).build()).setIsValidate(CoeditConstants.IS_VALIDATION).setWorkspaceVersion(getWorkspaceVersion()).build());
    }

    public void putUploadStrokeRequest(String str, long j, String str2, byte[] bArr) throws InterruptedException {
        putUploadStrokeRequest(UploadStrokeRequest.newBuilder().setBinaryInfo(BinaryInfo.newBuilder().setHash(str).setSize(j).setMimetype(str2).build()).build(), UploadStrokeRequest.newBuilder().setBinary(Binary.newBuilder().setChunk(ByteString.copyFrom(bArr)).build()).build());
    }

    public void reconnect(String str) {
        CoeditGrpcDataContract coeditGrpcDataContract = this.mContract;
        if (coeditGrpcDataContract == null) {
            return;
        }
        coeditGrpcDataContract.reconnect(str);
    }

    public synchronized void refreshForReopen() {
        this.mDownloadStrokeMap.clear();
        this.mUploadedStrokeObjectInfos.clear();
        this.mDownloadContentFileObjectInfos.clear();
    }

    public void release() {
        this.mContract = null;
    }

    public void releaseLock(String str) {
        CoeditGrpcDataContract coeditGrpcDataContract = this.mContract;
        if (coeditGrpcDataContract == null) {
            return;
        }
        coeditGrpcDataContract.releaseLock(str);
    }

    public synchronized void removeDownloadStrokeData(String str) {
        StrokeData strokeData = this.mDownloadStrokeMap.get(str);
        if (strokeData == null) {
            return;
        }
        strokeData.release();
        this.mDownloadStrokeMap.remove(str);
    }

    public synchronized void removeUndownloadedObjectInfo(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        removeDownloadingObjectId(str);
        CoeditCacheUtils.removeUndownloadedObjectInfo(this.mNoteId, str, z);
    }

    public synchronized boolean removeUnuploadedContentFileData(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return false;
        }
        removeUploadingContentFileId(str);
        return CoeditCacheUtils.removeUnuploadedContentFileCache(applicationContext, this.mNoteId, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PermissionResponse requestPermission(String str, PermissionRequest permissionRequest) {
        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.m13734of("requestId", Metadata.ASCII_STRING_MARSHALLER), str);
        return ((PolicyManagerGrpc.PolicyManagerBlockingStub) ((PolicyManagerGrpc.PolicyManagerBlockingStub) MetadataUtils.attachHeaders(this.mPolicyStub, metadata)).withDeadlineAfter(AiSTTListView.USER_SCROLL_INTERVAL, TimeUnit.MILLISECONDS)).requestPermission(permissionRequest);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResetWorkspaceResponse requestResetWorkspace(String str) {
        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.m13734of("requestId", Metadata.ASCII_STRING_MARSHALLER), str);
        return ((WorkspaceManagerGrpc.WorkspaceManagerBlockingStub) ((WorkspaceManagerGrpc.WorkspaceManagerBlockingStub) MetadataUtils.attachHeaders(this.mWorkspaceStub, metadata)).withDeadlineAfter(10000L, TimeUnit.MILLISECONDS)).resetWorkspace(ResetWorkspaceRequest.newBuilder().setWorkspaceVersion(getWorkspaceVersion()).build());
    }

    public void setCatchupEndCheckPoint(long j) {
        this.mCatchupEndCheckPoint = j;
    }

    public void setCatchupStartCheckPoint(long j) {
        this.mCatchupStartCheckPoint = j;
    }

    public void setCatchupType(CatchupType catchupType) {
        this.mCatchupType = catchupType;
    }

    public void setNoteId(String str) {
        this.mNoteId = str;
    }

    public void setNotifyCheckPoint(long j) {
        this.mNotifyCheckPoint = j;
    }

    public void setPausedByNetwork(String str) {
        CoeditGrpcDataContract coeditGrpcDataContract = this.mContract;
        if (coeditGrpcDataContract == null) {
            return;
        }
        coeditGrpcDataContract.setPausedByNetwork(str);
    }

    public void setResourceId(String str) {
        this.mResourceId = str;
    }

    public void setResponsedWorkspaceVersion(long j) {
        this.mResponsedWorkspaceVersion = j;
    }

    public void setResultCode(int i) {
        this.mResultCode = i;
    }

    public void setSubmitCheckPoint(long j) {
        this.mSubmitCheckPoint = j;
    }

    public void setWorkspaceId(String str) {
        this.mWorkspaceId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubmitResponse submitRequest(String str, SubmitRequest submitRequest) {
        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.m13734of("requestId", Metadata.ASCII_STRING_MARSHALLER), str);
        return ((SubmitterGrpc.SubmitterBlockingStub) ((SubmitterGrpc.SubmitterBlockingStub) MetadataUtils.attachHeaders(this.mSubmitterStub, metadata)).withMaxInboundMessageSize(8388608)).submit(submitRequest);
    }

    public ClientMsg takeClientMsg() {
        return this.mClientMsgQueue.take();
    }

    public synchronized ObjectInfo takeDownloadContentFileObjectInfo() {
        return this.mDownloadContentFileObjectInfos.take();
    }

    public DownloadStrokeRequest takeDownloadStrokeRequest() {
        return this.mDownloadStrokeRequest.take();
    }

    public PermissionRequest takePermissionRequest() {
        return this.mPermissionRequestQueue.take();
    }

    public Object takeReceiveMsg() {
        return this.mReceiveMsgQueue.take();
    }

    public SubmitRequest takeSubmitRequest() {
        return this.mSubmitMsgQueue.take();
    }

    public synchronized NoteOpFileData takeUploadContentFileData() {
        return this.mUploadContentFileDatas.take();
    }

    public Pair<UploadStrokeRequest, UploadStrokeRequest> takeUploadStrokeRequest() {
        return this.mUploadStrokeRequest.take();
    }

    public void uploadContentFileData(NoteOpFileData noteOpFileData, String str, String str2) {
        CoeditGrpcDataContract coeditGrpcDataContract = this.mContract;
        if (coeditGrpcDataContract == null) {
            return;
        }
        coeditGrpcDataContract.uploadContentFile(noteOpFileData, str, str2);
    }

    public synchronized void putDownloadStrokeData(String str, byte[] bArr) {
        StrokeData strokeData = this.mDownloadStrokeMap.get(str);
        if (strokeData == null) {
            return;
        }
        strokeData.setBytes(Arrays.copyOf(bArr, bArr.length));
    }

    public void putUploadStrokeRequest(UploadStrokeRequest uploadStrokeRequest, UploadStrokeRequest uploadStrokeRequest2) throws InterruptedException {
        this.mUploadStrokeRequest.put(new Pair<>(uploadStrokeRequest, uploadStrokeRequest2));
    }
}
