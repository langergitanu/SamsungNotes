package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.data;

import coeditObject.DownloaderGrpc;
import coeditObject.UploaderGrpc;
import com.google.protobuf.ByteString;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import noteSnap.DownloaderGrpc;
import noteSnap.NoteInfoGetterGrpc;
import noteSnap.UploaderGrpc;
import noteSnapMessage.Binary;
import noteSnapMessage.BinaryInfo;
import noteSnapMessage.DownloadRequest;
import noteSnapMessage.DownloadResponse;
import noteSnapMessage.NoteInfoRequest;
import noteSnapMessage.NoteInfoResponse;
import noteSnapMessage.UploadRequest;
import noteSnapMessage.UploadResponse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SnapGrpcData extends CoeditGrpcData {
    private static final String TAG = "SnapGrpcData";
    private SnapGrpcDataContract mContract;
    private Map<String, byte[]> mDownloadStrokeMap;
    private String mDownloadXmlData;
    private long mDownloadXmlDataSize;
    private final LinkedBlockingQueue<UploadRequest> mUploadNoteMsgQueue = new LinkedBlockingQueue<>();

    public SnapGrpcData() {
        setDownloadStrokeMap(new LinkedHashMap());
    }

    private void putUploadRequest(UploadRequest uploadRequest) throws InterruptedException {
        this.mUploadNoteMsgQueue.put(uploadRequest);
    }

    private void setDownloadStrokeMap(Map<String, byte[]> map) {
        this.mDownloadStrokeMap = map;
    }

    public void asyncDownloadNote(String str, StreamObserver<DownloadResponse> streamObserver) {
        DownloaderGrpc.DownloaderStub downloaderStub = (DownloaderGrpc.DownloaderStub) MetadataUtils.attachHeaders(DownloaderGrpc.newStub(this.mChannel), this.mMetadata);
        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.m13734of("requestId", Metadata.ASCII_STRING_MARSHALLER), str);
        ((DownloaderGrpc.DownloaderStub) MetadataUtils.attachHeaders(downloaderStub, metadata)).downloadNote(DownloadRequest.newBuilder().build(), streamObserver);
    }

    public StreamObserver<UploadRequest> asyncUploadNote(String str, StreamObserver<UploadResponse> streamObserver) {
        UploaderGrpc.UploaderStub uploaderStub = (UploaderGrpc.UploaderStub) MetadataUtils.attachHeaders(UploaderGrpc.newStub(this.mChannel), this.mMetadata);
        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.m13734of("requestId", Metadata.ASCII_STRING_MARSHALLER), str);
        return ((UploaderGrpc.UploaderStub) MetadataUtils.attachHeaders(uploaderStub, metadata)).uploadNote(streamObserver);
    }

    public byte[] getDownloadStroke(String str) {
        return this.mDownloadStrokeMap.get(str);
    }

    public Set<String> getDownloadStrokeMapKeySet() {
        return this.mDownloadStrokeMap.keySet();
    }

    public String getDownloadXmlData() {
        return this.mDownloadXmlData;
    }

    public int getDownloadXmlDataSize() {
        return (int) this.mDownloadXmlDataSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NoteInfoResponse getLatestNoteInfo(String str, NoteInfoRequest noteInfoRequest) {
        NoteInfoGetterGrpc.NoteInfoGetterBlockingStub noteInfoGetterBlockingStub = (NoteInfoGetterGrpc.NoteInfoGetterBlockingStub) MetadataUtils.attachHeaders(NoteInfoGetterGrpc.newBlockingStub(this.mChannel), this.mMetadata);
        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.m13734of("requestId", Metadata.ASCII_STRING_MARSHALLER), str);
        return ((NoteInfoGetterGrpc.NoteInfoGetterBlockingStub) ((NoteInfoGetterGrpc.NoteInfoGetterBlockingStub) MetadataUtils.attachHeaders(noteInfoGetterBlockingStub, metadata)).withDeadlineAfter(10000L, TimeUnit.MILLISECONDS)).getLatestNoteInfo(noteInfoRequest);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.data.GrpcData
    public String getTag() {
        return TAG;
    }

    public void handleDownloadUrlMap(Map<String, String> map) {
        SnapGrpcDataContract snapGrpcDataContract = this.mContract;
        if (snapGrpcDataContract == null) {
            return;
        }
        snapGrpcDataContract.handleDownloadUrlMap(map);
    }

    public void initialize(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, SnapGrpcDataContract snapGrpcDataContract) {
        super.initialize(str, str2, str3, str4, str5, str6);
        setWorkspaceId(str8);
        setNoteId(str7);
        this.mContract = snapGrpcDataContract;
        this.mObjectUploaderStub = (UploaderGrpc.UploaderBlockingStub) MetadataUtils.attachHeaders(coeditObject.UploaderGrpc.newBlockingStub(this.mChannel), this.mMetadata);
        this.mObjectDownloaderStub = (DownloaderGrpc.DownloaderBlockingStub) MetadataUtils.attachHeaders(coeditObject.DownloaderGrpc.newBlockingStub(this.mChannel), this.mMetadata);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.data.GrpcData
    public boolean isInvalidStub() {
        return true;
    }

    public boolean isUploadRequestQueueEmpty() {
        return this.mUploadNoteMsgQueue.isEmpty();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData
    public void onContentFileUploadError(int i) {
        SnapGrpcDataContract snapGrpcDataContract = this.mContract;
        if (snapGrpcDataContract == null) {
            return;
        }
        snapGrpcDataContract.onContentFileUploadError(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData
    public void putDownloadStrokeData(String str, byte[] bArr) {
        this.mDownloadStrokeMap.put(str, bArr);
    }

    public void putUploadNoteRequest(String str, String str2, int i) throws InterruptedException, IOException {
        putUploadRequest(UploadRequest.newBuilder().setBinaryInfo(BinaryInfo.newBuilder().setName(str).setType(CoeditServiceConstants.MimeType.NOTE_TYPE_XML).setLength(i).build()).build());
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str2.getBytes(StandardCharsets.UTF_8));
        byte[] bArr = new byte[2097152];
        while (true) {
            int i2 = byteArrayInputStream.read(bArr);
            if (i2 <= 0) {
                return;
            } else {
                putUploadRequest(UploadRequest.newBuilder().setBinary(Binary.newBuilder().setChunk(ByteString.copyFrom(bArr, 0, i2)).setReadSize(i2).build()).build());
            }
        }
    }

    public void putUploadStrokeRequest(String str, String str2, byte[] bArr, long j) throws InterruptedException {
        putUploadRequest(UploadRequest.newBuilder().setBinaryInfo(BinaryInfo.newBuilder().setName(str).setType(CoeditServiceConstants.MimeType.OBJECT_STROKE).setLength(j).setHash(str2).setSize(j).build()).build());
        putUploadRequest(UploadRequest.newBuilder().setBinary(Binary.newBuilder().setChunk(ByteString.copyFrom(bArr)).setReadSize((int) j).build()).build());
    }

    public void setDownloadXmlData(String str) {
        this.mDownloadXmlData = str;
    }

    public void setDownloadXmlDataSize(long j) {
        this.mDownloadXmlDataSize = j;
    }

    public UploadRequest takeUploadRequest() {
        return this.mUploadNoteMsgQueue.take();
    }

    public void updateSnapNoteLatestInfo(long j, long j2, String str) {
        SnapGrpcDataContract snapGrpcDataContract = this.mContract;
        if (snapGrpcDataContract == null) {
            return;
        }
        snapGrpcDataContract.updateSnapNoteLatestInfo(j, j2, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData
    public void uploadContentFileData(NoteOpFileData noteOpFileData, String str, String str2) {
        SnapGrpcDataContract snapGrpcDataContract = this.mContract;
        if (snapGrpcDataContract == null) {
            return;
        }
        snapGrpcDataContract.uploadContentFileData(noteOpFileData, str, str2);
    }
}
