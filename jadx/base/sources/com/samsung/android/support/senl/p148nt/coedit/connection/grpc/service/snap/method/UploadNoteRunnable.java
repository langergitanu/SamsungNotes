package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.method;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.data.SnapGrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionLogger;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import noteSnapMessage.UploadRequest;
import noteSnapMessage.UploadResponse;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class UploadNoteRunnable extends GrpcRunnable {
    private static final int CLOSED = -2;
    private static final int COMPLETED = 1;
    private static final int ERROR = -1;
    private static final int REQUESTED = 0;
    private static final String TAG = "UploadNoteRunnable";
    private final SnapGrpcData mData;
    private Throwable mFailed;
    private boolean mIsCompleted;
    private boolean mIsFinished;
    private int mState;

    public UploadNoteRunnable(@NonNull SnapGrpcData snapGrpcData, GrpcRunnable.Contract contract) {
        super(contract);
        this.mState = 0;
        this.mData = snapGrpcData;
    }

    private StreamObserver<UploadRequest> getRequestObserver(String str, final CountDownLatch countDownLatch) {
        return this.mData.asyncUploadNote(str, new StreamObserver<UploadResponse>() { // from class: com.samsung.android.support.senl.nt.coedit.connection.grpc.service.snap.method.UploadNoteRunnable.1
            @Override // io.grpc.stub.StreamObserver
            public void onCompleted() {
                CoeditLogger.m8919d(UploadNoteRunnable.TAG, "[CS5-1] responseObserver, onCompleted");
                UploadNoteRunnable.this.mState = 1;
                countDownLatch.countDown();
            }

            @Override // io.grpc.stub.StreamObserver
            public void onError(Throwable th) {
                StringBuilder sb = new StringBuilder("[CS5-2] responseObserver, onError1 : ");
                sb.append(th == null ? "null" : th.getMessage());
                CoeditLogger.m8920e(UploadNoteRunnable.TAG, sb.toString());
                OtDetectionLogger.printCancellationCause(UploadNoteRunnable.this);
                UploadNoteRunnable.this.mState = -1;
                UploadNoteRunnable.this.mData.setResultCode(UploadNoteRunnable.this.getResultCode());
                UploadNoteRunnable.this.mFailed = th;
                if (UploadNoteRunnable.this.mIsFinished) {
                    return;
                }
                countDownLatch.countDown();
                UploadNoteRunnable.this.mIsFinished = true;
            }

            @Override // io.grpc.stub.StreamObserver
            public void onNext(UploadResponse uploadResponse) {
                UploadNoteRunnable.this.printResponse(uploadResponse);
                UploadNoteRunnable.this.setResultCode(uploadResponse.getResponseResult().getCode());
                UploadNoteRunnable.this.mData.setResultCode(UploadNoteRunnable.this.getResultCode());
                UploadNoteRunnable.this.mData.setResourceId(uploadResponse.getWorkspaceId());
                UploadNoteRunnable.this.mIsFinished = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printResponse(UploadResponse uploadResponse) {
        StringBuilder sb = new StringBuilder("Response# workspaceId: [");
        sb.append(uploadResponse.getWorkspaceId());
        sb.append("]");
        if (uploadResponse.hasResponseResult()) {
            sb.append(SQLKeyword.COMMA);
            sb.append(OtDetectionLogger.getResponseResultLog(uploadResponse.getResponseResult()));
        }
        CoeditLogger.m8923i(getTag(), sb.toString());
    }

    private boolean requestNoteUpload(StreamObserver<UploadRequest> streamObserver, String str, CountDownLatch countDownLatch) throws InterruptedException {
        if (this.mIsFinished) {
            countDownLatch.countDown();
            return false;
        }
        if (isClosing()) {
            AbstractC8014b.m7223y("streaming, finish. handler is closing : ", str, TAG);
            this.mState = -2;
            countDownLatch.countDown();
            return false;
        }
        if (this.mIsCompleted || this.mData.isUploadRequestQueueEmpty()) {
            Thread.sleep(10L);
            return true;
        }
        setResultCode(Status.Code.UNKNOWN.value());
        this.mData.setResultCode(getResultCode());
        streamObserver.onNext(this.mData.takeUploadRequest());
        if (this.mData.isUploadRequestQueueEmpty()) {
            streamObserver.onCompleted();
            this.mIsCompleted = true;
        }
        return true;
    }

    private int streaming() {
        boolean zRequestNoteUpload = true;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CoeditLogger.m8919d(TAG, "[CS5] streaming(), request");
        this.mIsFinished = false;
        this.mIsCompleted = false;
        String requestNumber = CoeditUtils.getRequestNumber(this.mData.getWorkspaceId());
        StreamObserver<UploadRequest> requestObserver = getRequestObserver(requestNumber, countDownLatch);
        long jCurrentTimeMillis = System.currentTimeMillis();
        AbstractC8014b.m7219u("NoteSnapUploadNoteRequest request id : ", requestNumber, TAG);
        while (zRequestNoteUpload) {
            try {
                zRequestNoteUpload = requestNoteUpload(requestObserver, requestNumber, countDownLatch);
            } catch (Exception e) {
                CoeditLogger.m8920e(TAG, "[CS5-2] streaming(), requestObserver.onNext() error : " + e.getMessage());
                requestObserver.onError(e);
            }
        }
        try {
            if (!countDownLatch.await(1L, TimeUnit.MINUTES)) {
                throw new RuntimeException("Could not finish rpc within 1 minute, the server is likely down");
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            StringBuilder sbM15l = AbstractC0000a.m15l("streaming, requestID: ", requestNumber, ", state : ");
            sbM15l.append(this.mState);
            sbM15l.append(", duration: ");
            sbM15l.append(jCurrentTimeMillis2 - jCurrentTimeMillis);
            CoeditLogger.m8923i(TAG, sbM15l.toString());
            if (this.mFailed == null) {
                return getResultCode();
            }
            throw new RuntimeException(this.mFailed);
        } catch (Exception e2) {
            AbstractC8014b.m7218t(e2, new StringBuilder("[CS5-2] streaming(), finishLatch.await() error : "), TAG);
            return Status.Code.UNAVAILABLE.value();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, java.lang.Runnable
    public void run() {
        super.run();
        if (this.mIsCompleted || this.mData.isUploadRequestQueueEmpty()) {
            return;
        }
        try {
            CoeditLogger.m8919d(TAG, "run, result : " + streaming());
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("[CS5-2] failed to upload note. "), TAG);
        }
    }
}
