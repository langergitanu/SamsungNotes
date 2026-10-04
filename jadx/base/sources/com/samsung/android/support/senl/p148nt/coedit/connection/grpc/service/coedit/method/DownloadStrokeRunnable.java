package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method;

import androidx.annotation.NonNull;
import coeditObjectMessage.DownloadStrokeRequest;
import coeditObjectMessage.DownloadStrokeResponse;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionLogger;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DownloadStrokeRunnable extends GrpcRunnable {
    private static final String TAG = "DownloadStrokeRunnable";
    private final CoeditGrpcData mData;

    public DownloadStrokeRunnable(@NonNull CoeditGrpcData coeditGrpcData, GrpcRunnable.Contract contract) {
        super(contract);
        this.mData = coeditGrpcData;
    }

    private void printResponse(DownloadStrokeResponse downloadStrokeResponse) {
        StringBuilder sb = new StringBuilder("Response# ");
        if (downloadStrokeResponse.hasBinary()) {
            sb.append("size: [");
            sb.append(downloadStrokeResponse.getBinary().getReadSize());
            sb.append("]");
        }
        if (downloadStrokeResponse.hasResponseResult()) {
            sb.append(SQLKeyword.COMMA);
            sb.append(OtDetectionLogger.getResponseResultLog(downloadStrokeResponse.getResponseResult()));
        }
        CoeditLogger.m8923i(getTag(), sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readDownloadResponse(String str, DownloadStrokeResponse downloadStrokeResponse) {
        if (downloadStrokeResponse.hasResponseResult()) {
            setResultCode(downloadStrokeResponse.getResponseResult().getCode());
        }
        printResponse(downloadStrokeResponse);
        try {
            if (downloadStrokeResponse.hasBinary()) {
                this.mData.putDownloadStrokeData(str, downloadStrokeResponse.getBinary().getChunk().toByteArray());
            }
            this.mData.putReceiveMsg(downloadStrokeResponse);
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("readDownloadResponse, Failed to DownloadStrokeResponse. "), TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, java.lang.Runnable
    public void run() {
        super.run();
        if (this.mData.isDownloadStrokeRequestQueueEmpty()) {
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            final DownloadStrokeRequest downloadStrokeRequestTakeDownloadStrokeRequest = this.mData.takeDownloadStrokeRequest();
            this.mData.asyncDownloadStroke(downloadStrokeRequestTakeDownloadStrokeRequest, new StreamObserver<DownloadStrokeResponse>() { // from class: com.samsung.android.support.senl.nt.coedit.connection.grpc.service.coedit.method.DownloadStrokeRunnable.1
                @Override // io.grpc.stub.StreamObserver
                public void onCompleted() {
                    countDownLatch.countDown();
                }

                @Override // io.grpc.stub.StreamObserver
                public void onError(Throwable th) {
                    String message = th == null ? "null" : th.getMessage();
                    CoeditLogger.m8920e(DownloadStrokeRunnable.TAG, "DownloadStrokeResponse, onError: " + message);
                    DownloadStrokeRunnable.this.showToast("DownloadStrokeResponse error: " + message);
                    OtDetectionLogger.printCancellationCause(DownloadStrokeRunnable.this);
                    countDownLatch.countDown();
                }

                @Override // io.grpc.stub.StreamObserver
                public void onNext(DownloadStrokeResponse downloadStrokeResponse) {
                    if (DownloadStrokeRunnable.this.isInterrupt()) {
                        throw new RuntimeException("interrupted during download stroke");
                    }
                    DownloadStrokeRunnable.this.readDownloadResponse(downloadStrokeRequestTakeDownloadStrokeRequest.getObjId(), downloadStrokeResponse);
                }
            });
            while (!this.mData.isFinished() && 0 < countDownLatch.getCount() && !isInterrupt()) {
                Thread.sleep(10L);
            }
        } catch (Exception e) {
            CoeditLogger.m8920e(TAG, "Failed to DownloadStroke. " + e.getMessage());
            showToast("DownloadStrokeResponse error: " + e.getMessage());
        }
    }
}
