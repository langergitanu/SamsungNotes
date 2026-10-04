package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data;

import android.text.TextUtils;
import coeditOperation.CedOps;
import coeditOt.ComposerGrpc;
import coeditOt.TransformerGrpc;
import coeditOtMessage.ComposeRequest;
import coeditOtMessage.ComposeResponse;
import coeditOtMessage.IdxCedOpsPair;
import coeditOtMessage.MultipleTransformRequest;
import coeditOtMessage.MultipleTransformResponse;
import coeditOtMessage.TransformRequest;
import coeditOtMessage.TransformResponse;
import coeditOtMessage.TransformWithMultipleRequest;
import coeditOtMessage.TransformWithMultipleResponse;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.data.GrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.ProtoBufUtils;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditTransformData extends GrpcData {
    private static final int MAX_INBOUND = 8388608;
    private static final String TAG = "CoeditTransformData";
    private ComposerGrpc.ComposerBlockingStub mComposerStub;
    private CoeditTransformDataContract mContract;
    private TransformerGrpc.TransformerBlockingStub mTransformerStub;
    private String mWorkspaceId;
    private final LinkedBlockingQueue<TransformRequest> mTransformRequestQueue = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<TransformResponse> mTransformResponseQueue = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<MultipleTransformRequest> mMultipleTransformRequestQueue = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<MultipleTransformResponse> mMultipleTransformResponseQueue = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<TransformWithMultipleRequest> mTransformWithMultipleRequestQueue = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<TransformWithMultipleResponse> mTransformWithMultipleResponseQueue = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<ComposeRequest> mComposeRequestQueue = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<ComposeResponse> mComposeResponseQueue = new LinkedBlockingQueue<>();

    public void clearComposeRequestQueue() {
        this.mComposeRequestQueue.clear();
    }

    public void clearComposeResponseQueue() {
        this.mComposeResponseQueue.clear();
    }

    public void clearMultipleTransformRequestQueue() {
        this.mMultipleTransformRequestQueue.clear();
    }

    public void clearMultipleTransformResponseQueue() {
        this.mMultipleTransformResponseQueue.clear();
    }

    public void clearTransformRequestQueue() {
        this.mTransformRequestQueue.clear();
    }

    public void clearTransformResponseQueue() {
        this.mTransformResponseQueue.clear();
    }

    public void clearTransformWithMultipleRequestQueue() {
        this.mTransformWithMultipleRequestQueue.clear();
    }

    public void clearTransformWithMultipleResponseQueue() {
        this.mTransformWithMultipleResponseQueue.clear();
    }

    public ComposeResponse compose(String str, ComposeRequest composeRequest) {
        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.m13734of("requestId", Metadata.ASCII_STRING_MARSHALLER), str);
        return ((ComposerGrpc.ComposerBlockingStub) MetadataUtils.attachHeaders(this.mComposerStub, metadata)).compose(composeRequest);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.data.GrpcData
    public String getTag() {
        return TAG;
    }

    public String getWorkspaceId() {
        if (this.mContract != null && TextUtils.isEmpty(this.mWorkspaceId)) {
            this.mWorkspaceId = this.mContract.getWorkspaceId();
        }
        return this.mWorkspaceId;
    }

    public void initialize(String str, String str2, String str3, String str4, String str5, String str6, String str7, CoeditTransformDataContract coeditTransformDataContract) {
        super.initialize(str, str2, str3, str4, str5, str6);
        setWorkspaceId(str7);
        this.mContract = coeditTransformDataContract;
        this.mTransformerStub = (TransformerGrpc.TransformerBlockingStub) MetadataUtils.attachHeaders(TransformerGrpc.newBlockingStub(this.mChannel), this.mMetadata);
        this.mComposerStub = (ComposerGrpc.ComposerBlockingStub) MetadataUtils.attachHeaders(ComposerGrpc.newBlockingStub(this.mChannel), this.mMetadata);
    }

    public boolean isComposeRequestEmpty() {
        return this.mComposeRequestQueue.isEmpty();
    }

    public boolean isComposeResponseEmpty() {
        return this.mComposeResponseQueue.isEmpty();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.data.GrpcData
    public boolean isInvalidStub() {
        return this.mTransformerStub == null;
    }

    public boolean isMultipleTransformRequestEmpty() {
        return this.mMultipleTransformRequestQueue.isEmpty();
    }

    public boolean isMultipleTransformResponseEmpty() {
        return this.mMultipleTransformResponseQueue.isEmpty();
    }

    public boolean isTransformRequestEmpty() {
        return this.mTransformRequestQueue.isEmpty();
    }

    public boolean isTransformResponseEmpty() {
        return this.mTransformResponseQueue.isEmpty();
    }

    public boolean isTransformWithMultipleRequestEmpty() {
        return this.mTransformWithMultipleRequestQueue.isEmpty();
    }

    public boolean isTransformWithMultipleResponseEmpty() {
        return this.mTransformWithMultipleResponseQueue.isEmpty();
    }

    public boolean needBlockCoedit(int i) {
        if (3 > i) {
            return false;
        }
        setPausedByNetwork(getTag() + " exceed retry count");
        releaseLock("retryTransform response");
        return true;
    }

    public void putComposeRequest(List<List<NoteOp>> list) throws InterruptedException {
        ArrayList arrayList = new ArrayList();
        Iterator<List<NoteOp>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(IdxCedOpsPair.newBuilder().setIdx(arrayList.size()).setCedOps(CedOps.newBuilder().addAllCoeditOperation(ProtoBufUtils.serialize(it.next())).build()).build());
        }
        this.mComposeRequestQueue.put(ComposeRequest.newBuilder().addAllPairs(arrayList).build());
    }

    public void putComposeResponse(ComposeResponse composeResponse) throws InterruptedException {
        this.mComposeResponseQueue.put(composeResponse);
    }

    public void putMultipleTransformRequest(List<List<NoteOp>> list, List<NoteOp> list2) throws InterruptedException {
        ArrayList arrayList = new ArrayList();
        Iterator<List<NoteOp>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(IdxCedOpsPair.newBuilder().setIdx(arrayList.size()).setCedOps(CedOps.newBuilder().addAllCoeditOperation(ProtoBufUtils.serialize(it.next())).build()).build());
        }
        putMultipleTransformRequest(MultipleTransformRequest.newBuilder().addAllFirst(arrayList).setSecond(IdxCedOpsPair.newBuilder().setIdx(0L).setCedOps(CedOps.newBuilder().addAllCoeditOperation(ProtoBufUtils.serialize(list2)).build()).build()).build());
    }

    public void putMultipleTransformResponse(MultipleTransformResponse multipleTransformResponse) throws InterruptedException {
        this.mMultipleTransformResponseQueue.put(multipleTransformResponse);
    }

    public void putTransformRequest(List<NoteOp> list, List<NoteOp> list2) throws InterruptedException {
        putTransformRequest(TransformRequest.newBuilder().setFirst(IdxCedOpsPair.newBuilder().setIdx(0L).setCedOps(CedOps.newBuilder().addAllCoeditOperation(ProtoBufUtils.serialize(list)).build()).build()).setSecond(IdxCedOpsPair.newBuilder().setIdx(0L).setCedOps(CedOps.newBuilder().addAllCoeditOperation(ProtoBufUtils.serialize(list2)).build()).build()).build());
    }

    public void putTransformResponse(TransformResponse transformResponse) throws InterruptedException {
        this.mTransformResponseQueue.put(transformResponse);
    }

    public void putTransformWithMultipleRequest(List<NoteOp> list, List<List<NoteOp>> list2) throws InterruptedException {
        ArrayList arrayList = new ArrayList();
        Iterator<List<NoteOp>> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(IdxCedOpsPair.newBuilder().setIdx(arrayList.size()).setCedOps(CedOps.newBuilder().addAllCoeditOperation(ProtoBufUtils.serialize(it.next())).build()).build());
        }
        putTransformWithMultipleRequest(TransformWithMultipleRequest.newBuilder().setFirst(IdxCedOpsPair.newBuilder().setIdx(0L).setCedOps(CedOps.newBuilder().addAllCoeditOperation(ProtoBufUtils.serialize(list)).build()).build()).addAllSecond(arrayList).build());
    }

    public void putTransformWithMultipleResponse(TransformWithMultipleResponse transformWithMultipleResponse) throws InterruptedException {
        this.mTransformWithMultipleResponseQueue.put(transformWithMultipleResponse);
    }

    public void reconnect(String str) {
        CoeditLogger.m8923i(TAG, "reconnect, message: " + str + ", waiting : 100s");
        try {
            Thread.sleep(60000L);
        } catch (InterruptedException e) {
            CoeditLogger.m8920e(TAG, "reconnect waiting : " + e.getMessage());
        }
        CoeditTransformDataContract coeditTransformDataContract = this.mContract;
        if (coeditTransformDataContract == null) {
            return;
        }
        coeditTransformDataContract.reconnect(str);
    }

    public void release() {
        this.mContract = null;
    }

    public void releaseLock(String str) {
        CoeditTransformDataContract coeditTransformDataContract = this.mContract;
        if (coeditTransformDataContract == null) {
            return;
        }
        coeditTransformDataContract.releaseLock(str);
    }

    public void setPausedByNetwork(String str) {
        CoeditTransformDataContract coeditTransformDataContract = this.mContract;
        if (coeditTransformDataContract == null) {
            return;
        }
        coeditTransformDataContract.setPausedByNetwork(str);
    }

    public void setWorkspaceId(String str) {
        this.mWorkspaceId = str;
    }

    public ComposeRequest takeComposeRequest() {
        return this.mComposeRequestQueue.take();
    }

    public ComposeResponse takeComposeResponse() {
        return this.mComposeResponseQueue.take();
    }

    public MultipleTransformRequest takeMultipleTransformRequest() {
        return this.mMultipleTransformRequestQueue.take();
    }

    public MultipleTransformResponse takeMultipleTransformResponse() {
        return this.mMultipleTransformResponseQueue.take();
    }

    public TransformRequest takeTransformRequest() {
        return this.mTransformRequestQueue.take();
    }

    public TransformResponse takeTransformResponse() {
        return this.mTransformResponseQueue.take();
    }

    public TransformWithMultipleRequest takeTransformWithMultipleRequest() {
        return this.mTransformWithMultipleRequestQueue.take();
    }

    public TransformWithMultipleResponse takeTransformWithMultipleResponse() {
        return this.mTransformWithMultipleResponseQueue.take();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransformResponse transform(String str, TransformRequest transformRequest) {
        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.m13734of("requestId", Metadata.ASCII_STRING_MARSHALLER), str);
        return ((TransformerGrpc.TransformerBlockingStub) ((TransformerGrpc.TransformerBlockingStub) MetadataUtils.attachHeaders(this.mTransformerStub, metadata)).withMaxInboundMessageSize(8388608)).transform(transformRequest);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultipleTransformResponse transform(String str, MultipleTransformRequest multipleTransformRequest) {
        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.m13734of("requestId", Metadata.ASCII_STRING_MARSHALLER), str);
        return ((TransformerGrpc.TransformerBlockingStub) ((TransformerGrpc.TransformerBlockingStub) MetadataUtils.attachHeaders(this.mTransformerStub, metadata)).withMaxInboundMessageSize(8388608)).multipleTransform(multipleTransformRequest);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransformWithMultipleResponse transform(String str, TransformWithMultipleRequest transformWithMultipleRequest) {
        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.m13734of("requestId", Metadata.ASCII_STRING_MARSHALLER), str);
        return ((TransformerGrpc.TransformerBlockingStub) ((TransformerGrpc.TransformerBlockingStub) MetadataUtils.attachHeaders(this.mTransformerStub, metadata)).withMaxInboundMessageSize(8388608)).transformWithMultiple(transformWithMultipleRequest);
    }

    public void putTransformRequest(TransformRequest transformRequest) throws InterruptedException {
        this.mTransformRequestQueue.put(transformRequest);
    }

    public void putMultipleTransformRequest(MultipleTransformRequest multipleTransformRequest) throws InterruptedException {
        this.mMultipleTransformRequestQueue.put(multipleTransformRequest);
    }

    public void putTransformWithMultipleRequest(TransformWithMultipleRequest transformWithMultipleRequest) throws InterruptedException {
        this.mTransformWithMultipleRequestQueue.put(transformWithMultipleRequest);
    }
}
