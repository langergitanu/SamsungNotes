package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import coeditCoreMessage.ClientCmd;
import coeditCoreMessage.ClientMsg;
import coeditCoreMessage.DeviceInfo;
import coeditCoreMessage.ServerCmd;
import coeditCoreMessage.ServerMsg;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionLogger;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContinuousMessageRunnable extends GrpcRunnable {
    private static final String DUPLICATE_CONNECT_TRY = "[handleConnect] duplicate connect try";
    private static final String GET_DEVICE_LIST_NEED_TO_CONNECT = "Need to connect before GET_DEVICE_LIST request";
    private static final String TAG = "ContinuousMessageRunnable";
    private Connection mConnectionState;
    private final CoeditGrpcData mData;
    private boolean mIsCheckingClientMsg;
    private StreamObserver<ClientMsg> mRequestObserver;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.coedit.connection.grpc.service.coedit.method.ContinuousMessageRunnable$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C90182 {
        static final /* synthetic */ int[] $SwitchMap$coeditCoreMessage$ServerCmd;

        static {
            int[] iArr = new int[ServerCmd.values().length];
            $SwitchMap$coeditCoreMessage$ServerCmd = iArr;
            try {
                iArr[ServerCmd.RESPONSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$coeditCoreMessage$ServerCmd[ServerCmd.NOTIFY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$coeditCoreMessage$ServerCmd[ServerCmd.RESPOND_DEVICE_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$coeditCoreMessage$ServerCmd[ServerCmd.DISCONNECT_BY_EVENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$coeditCoreMessage$ServerCmd[ServerCmd.WORKSPACE_BLOCK_STATE_CHANGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Connection {
        Disconnected,
        Connecting,
        Connected,
        Error
    }

    public ContinuousMessageRunnable(@NonNull CoeditGrpcData coeditGrpcData, GrpcRunnable.Contract contract) {
        super(contract);
        this.mConnectionState = Connection.Disconnected;
        this.mData = coeditGrpcData;
    }

    private void createStreamObserver() {
        this.mRequestObserver = this.mData.asyncContinuousMessage(new StreamObserver<ServerMsg>() { // from class: com.samsung.android.support.senl.nt.coedit.connection.grpc.service.coedit.method.ContinuousMessageRunnable.1
            @Override // io.grpc.stub.StreamObserver
            public void onCompleted() {
                if (Thread.currentThread().isInterrupted()) {
                    CoeditLogger.m8924w(ContinuousMessageRunnable.TAG, "responseObserver, onCompleted ignore already interrupted");
                    return;
                }
                CoeditLogger.m8919d(ContinuousMessageRunnable.TAG, "responseObserver, onCompleted");
                if (ContinuousMessageRunnable.this.getResultCode() == Status.Code.ALREADY_EXISTS.value() || ContinuousMessageRunnable.this.getResultCode() == Status.Code.ABORTED.value()) {
                    ContinuousMessageRunnable.this.mData.reconnect("ContinuousMessageRunnable Completed but Invalid(" + ContinuousMessageRunnable.this.getResultCode() + ")");
                }
                ContinuousMessageRunnable.this.setConnectedState();
            }

            @Override // io.grpc.stub.StreamObserver
            public void onError(Throwable th) {
                String message = th.getMessage();
                OtDetectionLogger.printCancellationCause(ContinuousMessageRunnable.this);
                if (Thread.currentThread().isInterrupted()) {
                    CoeditLogger.m8924w(ContinuousMessageRunnable.TAG, "responseObserver, onError ignore already interrupted, message: " + message);
                    return;
                }
                CoeditLogger.m8920e(ContinuousMessageRunnable.TAG, "responseObserver, onError : [" + message + "]");
                if (TextUtils.isEmpty(message) || (!message.contains(ContinuousMessageRunnable.GET_DEVICE_LIST_NEED_TO_CONNECT) && !message.contains(ContinuousMessageRunnable.DUPLICATE_CONNECT_TRY))) {
                    ContinuousMessageRunnable.this.mData.reconnect("ContinuousMessageRunnable Error");
                }
                ContinuousMessageRunnable.this.setErrorState();
            }

            @Override // io.grpc.stub.StreamObserver
            public void onNext(ServerMsg serverMsg) {
                ContinuousMessageRunnable.this.printServerMsg(serverMsg);
                int i = C90182.$SwitchMap$coeditCoreMessage$ServerCmd[serverMsg.getServerCmd().ordinal()];
                if (i == 1) {
                    ContinuousMessageRunnable.this.handleNextResponse(serverMsg);
                } else if (i == 2) {
                    ContinuousMessageRunnable.this.handleNextNotify(serverMsg);
                } else if (i == 3) {
                    ContinuousMessageRunnable.this.handleNextRespondDeviceList(serverMsg);
                } else if (i == 4) {
                    ContinuousMessageRunnable.this.handleNextDisconnectEvent(serverMsg);
                } else if (i != 5) {
                    ContinuousMessageRunnable.this.handleNextDefaultMessage(serverMsg);
                } else {
                    ContinuousMessageRunnable.this.handleWorkspaceBlockStateChanged(serverMsg);
                }
                ContinuousMessageRunnable.this.setConnectedState();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNextDefaultMessage(ServerMsg serverMsg) {
        setResultCode(serverMsg.getResponseResult().getCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.samsung.android.support.senl.nt.coedit.connection.grpc.service.coedit.method.ContinuousMessageRunnable, com.samsung.android.support.senl.nt.coedit.connection.grpc.task.GrpcRunnable] */
    /* JADX WARN: Type inference failed for: r5v0, types: [coeditCoreMessage.ServerMsg, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [coeditCoreMessage.ServerMsg] */
    /* JADX WARN: Type inference failed for: r5v5, types: [int] */
    public void handleNextDisconnectEvent(ServerMsg serverMsg) {
        try {
            try {
                this.mData.putReceiveMsg(serverMsg);
            } catch (Exception e) {
                CoeditLogger.m8920e(TAG, "handleNextDisconnectEvent, Failed to process response. " + e.getMessage());
            }
        } finally {
            setResultCode(serverMsg.getResponseResult().getCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.samsung.android.support.senl.nt.coedit.connection.grpc.service.coedit.method.ContinuousMessageRunnable, com.samsung.android.support.senl.nt.coedit.connection.grpc.task.GrpcRunnable] */
    /* JADX WARN: Type inference failed for: r5v0, types: [coeditCoreMessage.ServerMsg] */
    /* JADX WARN: Type inference failed for: r5v1, types: [coeditCoreMessage.ServerMsg] */
    /* JADX WARN: Type inference failed for: r5v5, types: [int] */
    public void handleNextNotify(ServerMsg serverMsg) {
        try {
            try {
                this.mData.notify(serverMsg);
            } catch (Exception e) {
                CoeditLogger.m8920e(TAG, "handleNextNotify, Failed to process notify. " + e.getMessage());
            }
        } finally {
            setResultCode(serverMsg.getResponseResult().getCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.samsung.android.support.senl.nt.coedit.connection.grpc.service.coedit.method.ContinuousMessageRunnable, com.samsung.android.support.senl.nt.coedit.connection.grpc.task.GrpcRunnable] */
    /* JADX WARN: Type inference failed for: r5v0, types: [coeditCoreMessage.ServerMsg, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [coeditCoreMessage.ServerMsg] */
    /* JADX WARN: Type inference failed for: r5v5, types: [int] */
    public void handleNextRespondDeviceList(ServerMsg serverMsg) {
        try {
            try {
                this.mData.putReceiveMsg(serverMsg);
            } catch (Exception e) {
                CoeditLogger.m8920e(TAG, "handleNextRespondDeviceList, Failed to process response device list. " + e.getMessage());
            }
        } finally {
            setResultCode(serverMsg.getResponseResult().getCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.samsung.android.support.senl.nt.coedit.connection.grpc.service.coedit.method.ContinuousMessageRunnable, com.samsung.android.support.senl.nt.coedit.connection.grpc.task.GrpcRunnable] */
    /* JADX WARN: Type inference failed for: r5v0, types: [coeditCoreMessage.ServerMsg, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [coeditCoreMessage.ServerMsg] */
    /* JADX WARN: Type inference failed for: r5v5, types: [int] */
    public void handleNextResponse(ServerMsg serverMsg) {
        try {
            try {
                this.mData.putReceiveMsg(serverMsg);
            } catch (Exception e) {
                CoeditLogger.m8920e(TAG, "handleNextResponse, Failed to process response. " + e.getMessage());
            }
        } finally {
            setResultCode(serverMsg.getResponseResult().getCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.samsung.android.support.senl.nt.coedit.connection.grpc.service.coedit.method.ContinuousMessageRunnable, com.samsung.android.support.senl.nt.coedit.connection.grpc.task.GrpcRunnable] */
    /* JADX WARN: Type inference failed for: r5v0, types: [coeditCoreMessage.ServerMsg, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [coeditCoreMessage.ServerMsg] */
    /* JADX WARN: Type inference failed for: r5v5, types: [int] */
    public void handleWorkspaceBlockStateChanged(ServerMsg serverMsg) {
        try {
            try {
                this.mData.putReceiveMsg(serverMsg);
            } catch (Exception e) {
                CoeditLogger.m8920e(TAG, "handleWorkspaceBlockStateChanged, Failed to process response. " + e.getMessage());
            }
        } finally {
            setResultCode(serverMsg.getResponseResult().getCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printServerMsg(ServerMsg serverMsg) {
        if (serverMsg == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        ServerCmd serverCmd = serverMsg.getServerCmd();
        if (serverMsg.hasResponseResult()) {
            sb.append("ServerMsg# ");
            sb.append(serverCmd.name());
            sb.append("# uuid: [");
            sb.append(this.mData.getNoteId());
            sb.append("], ");
            sb.append(OtDetectionLogger.getResponseResultLog(serverMsg.getResponseResult()));
        }
        if (serverCmd == ServerCmd.RESPONSE) {
            sb.append("ServerMsg# ");
            sb.append(serverCmd.name());
            sb.append("# checkPoint: [");
            sb.append(serverMsg.getCheckpointCoeditopPair().getCheckpoint());
            sb.append("], sessionValidTime: [");
            sb.append(serverMsg.getSessionValidTime());
            sb.append("], connectedDeviceCnt: [");
            sb.append(serverMsg.getConnectedDeviceCnt());
            sb.append("], workspaceVersion: [");
            sb.append(serverMsg.getWorkspaceVersion());
            sb.append("]");
            if (serverMsg.hasPolicyInfo()) {
                sb.append(", MaxEditableDeviceCnt: [");
                sb.append(serverMsg.getPolicyInfo().getMaxEditableDeviceCnt());
                sb.append("], MaxConnectableDeviceCnt: [");
                sb.append(serverMsg.getPolicyInfo().getMaxConnectableDeviceCnt());
                sb.append("]");
            }
        }
        if (serverMsg.hasEventInfo()) {
            sb.append("\nServerMsg# ");
            sb.append(serverCmd.name());
            sb.append("# EventInfo, eventType: [");
            sb.append(serverMsg.getEventInfo().getEventType());
            sb.append("], writable: [");
            sb.append(serverMsg.getEventInfo().getWritable());
            sb.append("]");
        }
        int deviceInfoCount = serverMsg.getDeviceInfoCount();
        if (deviceInfoCount > 0) {
            sb.append("\nServerMsg# ");
            sb.append(serverCmd.name());
            sb.append("# DeviceInfo, deviceInfoCount: ");
            sb.append(deviceInfoCount);
            for (int i = 0; i < deviceInfoCount; i++) {
                DeviceInfo deviceInfo = serverMsg.getDeviceInfo(i);
                sb.append("\nServerMsg# ");
                sb.append(serverCmd.name());
                sb.append("{deviceInfo [");
                sb.append(i);
                sb.append("] {uid: [");
                sb.append(deviceInfo.getUid());
                sb.append("], dvcId: [");
                sb.append(deviceInfo.getDvcId());
                sb.append("], deviceInfoChangeType: [");
                sb.append(deviceInfo.getDeviceInfoChangeType());
                sb.append("], PermissionType: [");
                sb.append(deviceInfo.getPermissionType());
                sb.append("]}}");
            }
        }
        if (serverMsg.getServerCmd().equals(ServerCmd.WORKSPACE_BLOCK_STATE_CHANGE)) {
            sb.append("\nServerMsg# ");
            sb.append(serverCmd.name());
            sb.append("# isWorkspaceBlocked: [");
            sb.append(serverMsg.getWorkspaceBlocked());
            sb.append("], workspaceVersion: [");
            sb.append(serverMsg.getWorkspaceVersion());
            sb.append("]");
        }
        if (sb.length() > 0) {
            CoeditLogger.m8923i(getTag(), sb.toString());
        }
        if (serverMsg.hasCheckpointCoeditopPair()) {
            OtDetectionLogger.printCheckPointOperationPair(this, "ServerMsg# " + serverCmd.name(), serverMsg.getCheckpointCoeditopPair());
        }
    }

    public synchronized void checkClientMsg() {
        ClientMsg clientMsgTakeClientMsg;
        try {
            this.mIsCheckingClientMsg = true;
            while (true) {
                if (this.mData.isClientMsgEmpty()) {
                    break;
                }
                Connection connection = this.mConnectionState;
                Connection connection2 = Connection.Connecting;
                if (connection == connection2) {
                    break;
                }
                if (Thread.currentThread().isInterrupted()) {
                    CoeditLogger.m8920e(TAG, "checkClientMsg, already Interrupted");
                    break;
                }
                if (this.mRequestObserver == null) {
                    CoeditLogger.m8919d(TAG, "checkClientMsg requestObserver is invalid need to create");
                    createStreamObserver();
                }
                try {
                    clientMsgTakeClientMsg = this.mData.takeClientMsg();
                } catch (Exception e) {
                    CoeditLogger.m8920e(TAG, "streaming(), requestObserver.onNext() error : " + e.getMessage());
                    StreamObserver<ClientMsg> streamObserver = this.mRequestObserver;
                    if (streamObserver != null) {
                        streamObserver.onError(e);
                    }
                }
                if (clientMsgTakeClientMsg.getClientCmd() == ClientCmd.CONNECT) {
                    if (this.mConnectionState == Connection.Disconnected) {
                        this.mConnectionState = connection2;
                    }
                }
                setResultCode(Status.Code.UNKNOWN.value());
                CoeditLogger.m8923i(TAG, "checkClientMsg requestObserver.onNext(). ClientMsg cmd : " + clientMsgTakeClientMsg.getClientCmd());
                this.mRequestObserver.onNext(clientMsgTakeClientMsg);
            }
            this.mIsCheckingClientMsg = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener
    public String getTag() {
        return TAG;
    }

    public boolean isCheckingClientMsg() {
        return this.mIsCheckingClientMsg;
    }

    public void release(String str) {
        AbstractC8014b.m7223y("release, caller: ", str, TAG);
        StreamObserver<ClientMsg> streamObserver = this.mRequestObserver;
        if (streamObserver == null) {
            return;
        }
        streamObserver.onCompleted();
        this.mRequestObserver = null;
        Thread.currentThread().interrupt();
    }

    public void setConnectedState() {
        if (this.mConnectionState == Connection.Connecting) {
            this.mConnectionState = Connection.Connected;
        }
        if (this.mIsCheckingClientMsg) {
            return;
        }
        checkClientMsg();
    }

    public void setErrorState() {
        this.mConnectionState = Connection.Error;
        if (this.mIsCheckingClientMsg) {
            return;
        }
        checkClientMsg();
    }
}
