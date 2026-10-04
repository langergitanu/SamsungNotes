package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method;

import androidx.annotation.NonNull;
import coeditCoreMessage.ResetWorkspaceResponse;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionLogger;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ResetWorkspaceRunnable extends GrpcRunnable {
    private static final String TAG = "ResetWorkspaceRunnable";
    private final CoeditGrpcData mData;

    public ResetWorkspaceRunnable(@NonNull CoeditGrpcData coeditGrpcData, GrpcRunnable.Contract contract) {
        super(contract);
        this.mData = coeditGrpcData;
    }

    private void printResponse(@NonNull ResetWorkspaceResponse resetWorkspaceResponse) {
        StringBuilder sb = new StringBuilder("Response# workspaceId: [");
        sb.append(resetWorkspaceResponse.getWorkspaceId());
        sb.append("], workspaceVersion: [");
        sb.append(resetWorkspaceResponse.getWorkspaceVersion());
        sb.append("], latestSnapShotCheckPoint: [");
        sb.append(resetWorkspaceResponse.getLatestSnapshotCheckpoint());
        sb.append("], isBlocked: [");
        sb.append(resetWorkspaceResponse.getIsBlocked());
        sb.append("]");
        if (resetWorkspaceResponse.hasResponseResult()) {
            sb.append(SQLKeyword.COMMA);
            sb.append(OtDetectionLogger.getResponseResultLog(resetWorkspaceResponse.getResponseResult()));
        }
        CoeditLogger.m8923i(getTag(), sb.toString());
    }

    private void requestResetWorkspace() {
        ResetWorkspaceResponse resetWorkspaceResponseRequestResetWorkspace;
        boolean z;
        while (true) {
            resetWorkspaceResponseRequestResetWorkspace = null;
            if (getRetryCount() >= 3) {
                z = false;
                break;
            }
            z = true;
            try {
                String requestNumber = CoeditUtils.getRequestNumber(this.mData.getWorkspaceId());
                CoeditLogger.m8919d(TAG, "run(), requestResetWorkspace, requestId: " + requestNumber);
                resetWorkspaceResponseRequestResetWorkspace = this.mData.requestResetWorkspace(requestNumber);
            } catch (Exception e) {
                String message = e.getMessage();
                showToast("requestResetWorkspace error. " + message);
                CoeditLogger.m8920e(TAG, "requestResetWorkspace, error: " + message);
                if (!CoeditServiceConstants.ServerResponseCode.isResetNotNeeded(message)) {
                    if (CoeditServiceConstants.ServerResponseCode.isConnectNeeded(message)) {
                        this.mData.reconnect(message);
                    }
                    increaseRetryCount();
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused) {
                        CoeditLogger.m8920e(TAG, "requestResetWorkspace, finally handle response");
                    }
                }
            }
        }
        try {
            if (resetWorkspaceResponseRequestResetWorkspace != null) {
                try {
                    printResponse(resetWorkspaceResponseRequestResetWorkspace);
                    this.mData.putReceiveMsg(resetWorkspaceResponseRequestResetWorkspace);
                    setResultCode(resetWorkspaceResponseRequestResetWorkspace.getResponseResult().getCode());
                } catch (InterruptedException unused2) {
                    CoeditLogger.m8920e(TAG, "requestResetWorkspace, finally handle response");
                }
            }
            if (!z) {
                onError(CoeditServiceConstants.WorkspaceError.RESET_WORKSPACE_DURATION);
            } else if (resetWorkspaceResponseRequestResetWorkspace != null) {
                CoeditCacheUtils.setWorkspaceVersion(this.mData.getNoteId(), resetWorkspaceResponseRequestResetWorkspace.getWorkspaceVersion());
            } else {
                CoeditCacheUtils.setWorkspaceVersion(this.mData.getNoteId(), this.mData.getResponsedWorkspaceVersion());
            }
        } finally {
            this.mData.setResultCode(getResultCode());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, java.lang.Runnable
    public void run() {
        super.run();
        requestResetWorkspace();
    }
}
