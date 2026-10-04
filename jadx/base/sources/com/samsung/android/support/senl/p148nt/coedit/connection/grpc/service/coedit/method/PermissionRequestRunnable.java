package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method;

import androidx.annotation.NonNull;
import coeditCoreMessage.PermissionRequest;
import coeditCoreMessage.PermissionResponse;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import io.grpc.Status;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PermissionRequestRunnable extends GrpcRunnable {
    private static final String TAG = "PermissionRequestRunnable";
    private final CoeditGrpcData mData;

    public PermissionRequestRunnable(@NonNull CoeditGrpcData coeditGrpcData, GrpcRunnable.Contract contract) {
        super(contract);
        this.mData = coeditGrpcData;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, java.lang.Runnable
    public void run() {
        PermissionResponse permissionResponseRequestPermission;
        super.run();
        try {
            try {
                if (this.mData.isPermissionRequestQueueEmpty()) {
                    setResultCode(Status.Code.UNAVAILABLE.value());
                } else {
                    PermissionRequest permissionRequestTakePermissionRequest = this.mData.takePermissionRequest();
                    String requestNumber = CoeditUtils.getRequestNumber(this.mData.getWorkspaceId());
                    CoeditLogger.m8919d(TAG, "run(), permission request id : " + requestNumber);
                    permissionResponseRequestPermission = this.mData.requestPermission(requestNumber, permissionRequestTakePermissionRequest);
                    try {
                        this.mData.putReceiveMsg(permissionResponseRequestPermission);
                        setResultCode(permissionResponseRequestPermission.getResponseResult().getCode());
                        CoeditLogger.m8919d(TAG, "permission response : ".concat(getResultCode() == 0 ? "SUCCSS" : "FAIL"));
                    } catch (Exception e) {
                        e = e;
                        String message = e.getMessage();
                        if (CoeditServiceConstants.ServerResponseCode.isConnectNeeded(message)) {
                            this.mData.reconnect(message);
                            setResultCode(Status.Code.NOT_FOUND.value());
                        } else if (CoeditServiceConstants.ServerResponseCode.isDeadlineExceeded(message)) {
                            setResultCode(Status.Code.DEADLINE_EXCEEDED.value());
                        } else if (CoeditServiceConstants.ServerResponseCode.isUnavailable(message)) {
                            setResultCode(Status.Code.UNAVAILABLE.value());
                        } else {
                            setResultCode(Status.Code.UNKNOWN.value());
                        }
                        CoeditLogger.m8920e(TAG, "Failed to requestPermission. " + message + " " + String.valueOf(permissionResponseRequestPermission != null ? Integer.valueOf(permissionResponseRequestPermission.getResponseResult().getCode()) : null));
                    }
                }
            } catch (Exception e2) {
                e = e2;
                permissionResponseRequestPermission = null;
            }
        } finally {
            this.mData.setResultCode(getResultCode());
        }
    }
}
