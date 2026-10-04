package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method;

import androidx.annotation.NonNull;
import coeditCoreMessage.SubmitRequest;
import coeditCoreMessage.SubmitResponse;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionLogger;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.grpc.Status;
import java.nio.charset.StandardCharsets;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SubmitRunnable extends GrpcRunnable {
    private static final String SUCESS = "Success";
    private static final String TAG = "SubmitRunnable";
    private final CoeditGrpcData mData;

    public SubmitRunnable(@NonNull CoeditGrpcData coeditGrpcData, GrpcRunnable.Contract contract) {
        super(contract);
        this.mData = coeditGrpcData;
    }

    private void printRequest(String str, SubmitRequest submitRequest) {
        if (submitRequest == null) {
            return;
        }
        String tag = getTag();
        StringBuilder sbM15l = AbstractC0000a.m15l("Request# RequestId: [", str, "], uuid: [");
        sbM15l.append(this.mData.getNoteId());
        sbM15l.append("], requestByte Size: ");
        sbM15l.append(submitRequest.toString().getBytes(StandardCharsets.UTF_8).length);
        CoeditLogger.m8923i(tag, sbM15l.toString());
        CoeditLogger.m8923i(getTag(), "Request# clientCmd: [" + submitRequest.getClientCmd() + "], isValidate: [" + submitRequest.getIsValidate() + "], workspaceVersion: [" + submitRequest.getWorkspaceVersion() + "]");
        OtDetectionLogger.printCheckPointOperationPair(this, "Request", submitRequest.getCheckpointCoeditopPair());
    }

    private void printResponse(SubmitResponse submitResponse) {
        StringBuilder sb = new StringBuilder("Response# uuid: [");
        sb.append(this.mData.getNoteId());
        sb.append("], checkPoint: [");
        sb.append(submitResponse.getCheckpoint());
        sb.append("]");
        if (submitResponse.hasResponseResult()) {
            sb.append(SQLKeyword.COMMA);
            sb.append(OtDetectionLogger.getResponseResultLog(submitResponse.getResponseResult()));
        }
        CoeditLogger.m8923i(getTag(), sb.toString());
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, java.lang.Runnable
    public void run() {
        super.run();
        try {
            try {
                if (!this.mData.hasSubmitRequestQueue()) {
                    CoeditLogger.m8919d(TAG, SUCESS);
                    this.mData.setResultCode(getResultCode());
                    if (CoeditServiceConstants.ServerResponseCode.isWorkspaceBlocked(SUCESS)) {
                        onError(CoeditServiceConstants.WorkspaceError.BLOCK);
                        return;
                    }
                    if (CoeditServiceConstants.ServerResponseCode.isUnavailable(SUCESS)) {
                        this.mData.setPausedByNetwork(SUCESS);
                        this.mData.releaseLock(SUCESS);
                        return;
                    }
                    if (CoeditServiceConstants.ServerResponseCode.isRetryNeeded(SUCESS)) {
                        this.mData.releaseLock(SUCESS);
                        return;
                    }
                    if (CoeditServiceConstants.ServerResponseCode.isConnectNeeded(SUCESS)) {
                        this.mData.reconnect(SUCESS);
                        this.mData.releaseLock(SUCESS);
                        return;
                    } else if (CoeditServiceConstants.ServerResponseCode.isUploadNeeded(SUCESS)) {
                        onError(CoeditServiceConstants.ConcurrencyError.UPLOAD_FAILED);
                        return;
                    } else {
                        this.mData.releaseLock(SUCESS);
                        return;
                    }
                }
                SubmitRequest submitRequestTakeSubmitRequest = this.mData.takeSubmitRequest();
                String requestNumber = CoeditUtils.getRequestNumber(this.mData.getWorkspaceId());
                printRequest(requestNumber, submitRequestTakeSubmitRequest);
                SubmitResponse submitResponseSubmitRequest = this.mData.submitRequest(requestNumber, submitRequestTakeSubmitRequest);
                printResponse(submitResponseSubmitRequest);
                this.mData.putReceiveMsg(submitResponseSubmitRequest);
                this.mData.setSubmitCheckPoint(submitResponseSubmitRequest.getCheckpoint());
                setResultCode(submitResponseSubmitRequest.getResponseResult().getCode());
                CoeditLogger.m8919d(TAG, SUCESS);
                this.mData.setResultCode(getResultCode());
                if (CoeditServiceConstants.ServerResponseCode.isWorkspaceBlocked(SUCESS)) {
                    onError(CoeditServiceConstants.WorkspaceError.BLOCK);
                    return;
                }
                if (CoeditServiceConstants.ServerResponseCode.isUnavailable(SUCESS)) {
                    this.mData.setPausedByNetwork(SUCESS);
                    this.mData.releaseLock(SUCESS);
                    return;
                }
                if (CoeditServiceConstants.ServerResponseCode.isRetryNeeded(SUCESS)) {
                    this.mData.releaseLock(SUCESS);
                    return;
                }
                if (CoeditServiceConstants.ServerResponseCode.isConnectNeeded(SUCESS)) {
                    this.mData.reconnect(SUCESS);
                    this.mData.releaseLock(SUCESS);
                } else if (CoeditServiceConstants.ServerResponseCode.isUploadNeeded(SUCESS)) {
                    onError(CoeditServiceConstants.ConcurrencyError.UPLOAD_FAILED);
                } else {
                    this.mData.releaseLock(SUCESS);
                }
            } catch (Exception e) {
                setResultCode(Status.Code.UNAVAILABLE.value());
                String message = e.getMessage();
                CoeditLogger.m8919d(TAG, message);
                this.mData.setResultCode(getResultCode());
                if (CoeditServiceConstants.ServerResponseCode.isWorkspaceBlocked(message)) {
                    onError(CoeditServiceConstants.WorkspaceError.BLOCK);
                    return;
                }
                if (CoeditServiceConstants.ServerResponseCode.isUnavailable(message)) {
                    this.mData.setPausedByNetwork(message);
                    this.mData.releaseLock(message);
                    return;
                }
                if (CoeditServiceConstants.ServerResponseCode.isRetryNeeded(message)) {
                    this.mData.releaseLock(message);
                    return;
                }
                if (CoeditServiceConstants.ServerResponseCode.isConnectNeeded(message)) {
                    this.mData.reconnect(message);
                    this.mData.releaseLock(message);
                } else if (CoeditServiceConstants.ServerResponseCode.isUploadNeeded(message)) {
                    onError(CoeditServiceConstants.ConcurrencyError.UPLOAD_FAILED);
                } else if (SUCESS.equals(message)) {
                    this.mData.releaseLock(message);
                } else {
                    onError(CoeditServiceConstants.ConcurrencyError.SUBMIT_FAILED);
                }
            }
        } catch (Throwable th) {
            CoeditLogger.m8919d(TAG, SUCESS);
            this.mData.setResultCode(getResultCode());
            if (CoeditServiceConstants.ServerResponseCode.isWorkspaceBlocked(SUCESS)) {
                onError(CoeditServiceConstants.WorkspaceError.BLOCK);
            } else if (CoeditServiceConstants.ServerResponseCode.isUnavailable(SUCESS)) {
                this.mData.setPausedByNetwork(SUCESS);
                this.mData.releaseLock(SUCESS);
            } else if (CoeditServiceConstants.ServerResponseCode.isRetryNeeded(SUCESS)) {
                this.mData.releaseLock(SUCESS);
            } else if (CoeditServiceConstants.ServerResponseCode.isConnectNeeded(SUCESS)) {
                this.mData.reconnect(SUCESS);
                this.mData.releaseLock(SUCESS);
            } else if (CoeditServiceConstants.ServerResponseCode.isUploadNeeded(SUCESS)) {
                onError(CoeditServiceConstants.ConcurrencyError.UPLOAD_FAILED);
            } else {
                this.mData.releaseLock(SUCESS);
            }
            throw th;
        }
    }
}
