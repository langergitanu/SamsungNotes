package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import coeditCoreMessage.CatchupRequest;
import coeditCoreMessage.CatchupResponse;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionLogger;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CatchupRunnable extends GrpcRunnable {
    private static final String TAG = "CatchupRunnable";
    private final CoeditGrpcData mData;

    public CatchupRunnable(@NonNull CoeditGrpcData coeditGrpcData, GrpcRunnable.Contract contract) {
        super(contract);
        this.mData = coeditGrpcData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void catchupFailed(String str, String str2, CatchupRequest catchupRequest) {
        setResultCode(Status.Code.UNAVAILABLE.value());
        if (CoeditServiceConstants.ServerResponseCode.isWorkspaceBlocked(str)) {
            onError(CoeditServiceConstants.WorkspaceError.BLOCK);
            return;
        }
        if (CoeditServiceConstants.ServerResponseCode.isRetryNeeded(str)) {
            retryCatchup(str2, catchupRequest);
        } else if (!CoeditServiceConstants.ServerResponseCode.isConnectNeeded(str)) {
            onError(CoeditServiceConstants.ConcurrencyError.CATCHUP_FAILED);
        } else {
            this.mData.reconnect(str);
            retryCatchup(str2, catchupRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void catchupSuccess(String str) {
        this.mData.setCatchupStartCheckPoint(-2L);
        this.mData.setCatchupEndCheckPoint(-2L);
        this.mData.releaseLock(str);
    }

    private void printRequest(CatchupRequest catchupRequest, String str) {
        if (catchupRequest == null) {
            return;
        }
        String tag = getTag();
        StringBuilder sbM15l = AbstractC0000a.m15l("Request# requestId: [", str, "], catchupType: [");
        sbM15l.append(catchupRequest.getCatchupType());
        sbM15l.append("], workspaceVersion: [");
        sbM15l.append(catchupRequest.getWorkspaceVersion());
        sbM15l.append("], startCheckPoint: [");
        sbM15l.append(catchupRequest.getStartCheckpoint());
        sbM15l.append("], endCheckPoint: [");
        sbM15l.append(catchupRequest.getEndCheckpoint());
        sbM15l.append("]");
        CoeditLogger.m8923i(tag, sbM15l.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printResponse(CatchupResponse catchupResponse) {
        if (catchupResponse == null) {
            return;
        }
        long checkpointCoeditopPairCount = catchupResponse.getCheckpointCoeditopPairCount();
        CoeditLogger.m8923i(TAG, "Response# checkPointCoeditPairCount: " + checkpointCoeditopPairCount);
        for (int i = 0; i < checkpointCoeditopPairCount; i++) {
            OtDetectionLogger.printCheckPointOperationPair(this, AbstractC0541b.m767i(i, "Response# coeditOpPair(", ")"), catchupResponse.getCheckpointCoeditopPair(i));
        }
        if (catchupResponse.hasResponseResult()) {
            CoeditLogger.m8923i(TAG, "Response# " + OtDetectionLogger.getResponseResultLog(catchupResponse.getResponseResult()));
        }
    }

    private void retryCatchup(String str, CatchupRequest catchupRequest) {
        if (catchupRequest == null) {
            this.mData.releaseLock("retryCatchup no request");
            return;
        }
        if (this.mData.isConcurrencyPausedByNetwork()) {
            this.mData.releaseLock("retryCatchup network disconnect");
            return;
        }
        if (2 <= getRetryCount()) {
            onError(CoeditServiceConstants.ConcurrencyError.CATCHUP_FAILED);
            return;
        }
        try {
            CoeditLogger.m8919d(TAG, "retryCatchup getRetryCount : " + getRetryCount());
            increaseRetryCount();
            printRequest(catchupRequest, str);
            Thread.sleep(1000L);
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("retryCatchup, Failed reason: "), TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, java.lang.Runnable
    public void run() {
        super.run();
        if (!this.mData.isCatchupRequestDataValid()) {
            catchupSuccess("CatchupRunnable skip, Catchup Request Data is invalid");
            return;
        }
        try {
            final String requestNumber = CoeditUtils.getRequestNumber(this.mData.getWorkspaceId());
            final CatchupRequest catchupRequestBuild = CatchupRequest.newBuilder().setStartCheckpoint(this.mData.getCatchupStartCheckPoint()).setEndCheckpoint(this.mData.getCatchupEndCheckPoint()).setCatchupType(this.mData.getCatchupType()).setWorkspaceVersion(this.mData.getWorkspaceVersion()).build();
            printRequest(catchupRequestBuild, requestNumber);
            this.mData.asyncCatchup(requestNumber, catchupRequestBuild, new StreamObserver<CatchupResponse>() { // from class: com.samsung.android.support.senl.nt.coedit.connection.grpc.service.coedit.method.CatchupRunnable.1
                @Override // io.grpc.stub.StreamObserver
                public void onCompleted() {
                    CatchupRunnable.this.catchupSuccess("CatchupRunnable response");
                }

                @Override // io.grpc.stub.StreamObserver
                public void onError(Throwable th) {
                    String str = "Response, onError : " + th.getMessage();
                    CoeditLogger.m8920e(CatchupRunnable.TAG, str);
                    OtDetectionLogger.printCancellationCause(CatchupRunnable.this);
                    CatchupRunnable.this.showToast(str);
                    CatchupRunnable.this.catchupFailed(str, requestNumber, catchupRequestBuild);
                }

                @Override // io.grpc.stub.StreamObserver
                public void onNext(CatchupResponse catchupResponse) {
                    CatchupRunnable.this.printResponse(catchupResponse);
                    try {
                        CatchupRunnable.this.mData.putReceiveMsg(catchupResponse);
                    } catch (Exception e) {
                        AbstractC8014b.m7218t(e, new StringBuilder("Failed to process catchup response. "), CatchupRunnable.TAG);
                    }
                    CatchupRunnable.this.setResultCode(catchupResponse.getResponseResult().getCode());
                }
            });
        } catch (Exception e) {
            CoeditLogger.m8920e(TAG, e.getMessage());
            setResultCode(Status.Code.UNAVAILABLE.value());
            if (CoeditServiceConstants.ServerResponseCode.isWorkspaceBlocked(e.getMessage())) {
                onError(CoeditServiceConstants.WorkspaceError.BLOCK);
            } else if (this.mData.isConcurrencyPausedByNetwork()) {
                this.mData.releaseLock(e.getMessage());
            } else {
                onError(CoeditServiceConstants.ConcurrencyError.CATCHUP_FAILED);
            }
        }
    }
}
