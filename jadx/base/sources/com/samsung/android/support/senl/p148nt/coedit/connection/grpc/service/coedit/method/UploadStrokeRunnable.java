package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import coeditCoreMessage.ObjectInfo;
import coeditObjectMessage.BinaryInfo;
import coeditObjectMessage.UploadStrokeRequest;
import coeditObjectMessage.UploadStrokeResponse;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionLogger;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class UploadStrokeRunnable extends GrpcRunnable {
    private static final int DELAYS_FOR_RETRY_TIME_MILLIS = 1000;
    private static final int MAX_UPLOAD_STROKE_RETRY_COUNT = 3;
    private static final String TAG = "UploadStrokeRunnable";
    private final CoeditGrpcData mData;

    public UploadStrokeRunnable(@NonNull CoeditGrpcData coeditGrpcData, GrpcRunnable.Contract contract) {
        super(contract);
        this.mData = coeditGrpcData;
    }

    private void checkRetryUploadStroke(Pair<UploadStrokeRequest, UploadStrokeRequest> pair) {
        if (getResultCode() == Status.Code.OK.value() || getResultCode() == Status.Code.ALREADY_EXISTS.value()) {
            this.mData.increaseUploadStrokeCompleteSize();
            return;
        }
        if (isInterrupt()) {
            CoeditLogger.m8924w(TAG, "checkRetryUploadStroke, invalid result, but retry ignore, already interrupted");
            this.mData.increaseUploadStrokeFailedSize();
            return;
        }
        if (3 <= getRetryCount()) {
            this.mData.setPausedByNetwork(getTag() + " exceed retry count");
            this.mData.increaseUploadStrokeFailedSize();
            return;
        }
        CoeditLogger.m8919d(TAG, "checkRetryUploadStroke, retry UploadStroke");
        try {
            Thread.sleep(1000L);
            this.mData.putUploadStrokeRequest((UploadStrokeRequest) pair.first, (UploadStrokeRequest) pair.second);
        } catch (InterruptedException e) {
            CoeditLogger.m8924w(TAG, "checkRetryUploadStroke, InterruptedException: " + e.getMessage());
        }
        increaseRetryCount();
        requestUploadStroke();
    }

    private void printRequest(UploadStrokeRequest uploadStrokeRequest, UploadStrokeRequest uploadStrokeRequest2) {
        StringBuilder sb = new StringBuilder("Request# ");
        if (uploadStrokeRequest.hasBinaryInfo()) {
            sb.append("BinaryInfo: {size: [");
            BinaryInfo binaryInfo = uploadStrokeRequest.getBinaryInfo();
            sb.append(binaryInfo.getSize());
            sb.append("]");
            if (!TextUtils.isEmpty(binaryInfo.getHash())) {
                sb.append(", hash: [");
                sb.append(binaryInfo.getHash());
                sb.append("]");
            }
            if (!TextUtils.isEmpty(binaryInfo.getMimetype())) {
                sb.append(", mimeType: [");
                sb.append(binaryInfo.getMimetype());
                sb.append("]");
            }
            sb.append("}");
        }
        if (uploadStrokeRequest2.hasBinary()) {
            sb.append(", Binary: {readSize: [");
            sb.append(uploadStrokeRequest2.getBinary().getReadSize());
            sb.append("]}");
        }
        CoeditLogger.m8923i(getTag(), sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printResponse(UploadStrokeResponse uploadStrokeResponse) {
        StringBuilder sb = new StringBuilder("Response# objectId: [");
        sb.append(uploadStrokeResponse.getObjId());
        sb.append("]");
        if (uploadStrokeResponse.hasResponseResult()) {
            sb.append(SQLKeyword.COMMA);
            sb.append(OtDetectionLogger.getResponseResultLog(uploadStrokeResponse.getResponseResult()));
        }
        CoeditLogger.m8923i(getTag(), sb.toString());
    }

    private void requestUploadStroke() {
        if (this.mData.isUploadStrokeRequestQueueEmpty()) {
            return;
        }
        Pair<UploadStrokeRequest, UploadStrokeRequest> pairTakeUploadStrokeRequest = null;
        try {
            try {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                pairTakeUploadStrokeRequest = this.mData.takeUploadStrokeRequest();
                final UploadStrokeRequest uploadStrokeRequest = (UploadStrokeRequest) pairTakeUploadStrokeRequest.first;
                UploadStrokeRequest uploadStrokeRequest2 = (UploadStrokeRequest) pairTakeUploadStrokeRequest.second;
                StreamObserver<UploadStrokeRequest> asyncUploadStroke = this.mData.getAsyncUploadStroke(new StreamObserver<UploadStrokeResponse>() { // from class: com.samsung.android.support.senl.nt.coedit.connection.grpc.service.coedit.method.UploadStrokeRunnable.1
                    private void handleUploadedStrokeObjectId(String str) {
                        if (TextUtils.isEmpty(str)) {
                            CoeditLogger.m8924w(UploadStrokeRunnable.TAG, "handleUploadedStrokeObjectId, objectId is empty.");
                        } else {
                            UploadStrokeRunnable.this.mData.addUploadedStrokeObjectInfo(ObjectInfo.newBuilder().setBinaryInfo(coeditCoreMessage.BinaryInfo.newBuilder().setHash(uploadStrokeRequest.getBinaryInfo().getHash()).setSize(uploadStrokeRequest.getBinaryInfo().getSize()).setMimetype(uploadStrokeRequest.getBinaryInfo().getMimetype()).build()).setObjId(str).build());
                        }
                    }

                    @Override // io.grpc.stub.StreamObserver
                    public void onCompleted() {
                        countDownLatch.countDown();
                    }

                    @Override // io.grpc.stub.StreamObserver
                    public void onError(Throwable th) {
                        CoeditLogger.m8920e(UploadStrokeRunnable.TAG, "responseObserver, onError : " + th.getMessage());
                        OtDetectionLogger.printCancellationCause(UploadStrokeRunnable.this);
                        UploadStrokeRunnable.this.setResultCode(Status.Code.UNAVAILABLE.value());
                        countDownLatch.countDown();
                    }

                    @Override // io.grpc.stub.StreamObserver
                    public void onNext(UploadStrokeResponse uploadStrokeResponse) {
                        UploadStrokeRunnable.this.printResponse(uploadStrokeResponse);
                        UploadStrokeRunnable.this.setResultCode(uploadStrokeResponse.getResponseResult().getCode());
                        handleUploadedStrokeObjectId(uploadStrokeResponse.getObjId());
                    }
                });
                try {
                    setResultCode(Status.Code.UNKNOWN.value());
                    printRequest(uploadStrokeRequest, uploadStrokeRequest2);
                    asyncUploadStroke.onNext(uploadStrokeRequest);
                    asyncUploadStroke.onNext(uploadStrokeRequest2);
                    asyncUploadStroke.onCompleted();
                } catch (Exception e) {
                    CoeditLogger.m8920e(TAG, "run(), requestObserver.onNext() error : " + e.getMessage());
                    asyncUploadStroke.onError(e);
                }
                try {
                    if (!countDownLatch.await(1L, TimeUnit.MINUTES)) {
                        throw new RuntimeException("Could not finish rpc within 1 minute, the server is likely down");
                    }
                } catch (Exception e2) {
                    CoeditLogger.m8920e(TAG, "run(), finishLatch.await() error : " + e2.getMessage());
                    setResultCode(Status.Code.UNAVAILABLE.value());
                }
            } catch (Exception e3) {
                CoeditLogger.m8920e(TAG, "Failed to request stroke. " + e3.getMessage());
                showToast("stroke request error. " + e3.getMessage());
            }
        } finally {
            checkRetryUploadStroke(pairTakeUploadStrokeRequest);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, java.lang.Runnable
    public void run() {
        super.run();
        requestUploadStroke();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable
    public void setResultCode(int i) {
        super.setResultCode(i);
        this.mData.setResultCode(i);
    }
}
