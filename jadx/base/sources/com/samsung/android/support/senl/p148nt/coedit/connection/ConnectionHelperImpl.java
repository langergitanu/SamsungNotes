package com.samsung.android.support.senl.p148nt.coedit.connection;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import coeditCoreMessage.CatchupResponse;
import coeditCoreMessage.CatchupType;
import coeditCoreMessage.CheckPointCoeditOpPair;
import coeditCoreMessage.DeviceInfo;
import coeditCoreMessage.EventType;
import coeditCoreMessage.ObjectInfo;
import coeditCoreMessage.PermissionResponse;
import coeditCoreMessage.PermissionType;
import coeditCoreMessage.ResetWorkspaceResponse;
import coeditCoreMessage.ServerCmd;
import coeditCoreMessage.ServerMsg;
import coeditCoreMessage.SubmitResponse;
import coeditObjectMessage.DownloadStrokeResponse;
import coeditOperation.CoeditOperation;
import com.samsung.android.support.senl.ntnl.coedit.OperationPair;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.coedit.common.CoeditConstants;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.CoeditGrpcManager;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.SnapGrpcManager;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcDataContract;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditTransformDataContract;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.CoeditGrpcMethod;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.data.SnapGrpcDataContract;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.ProtoBufUtils;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import io.grpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ConnectionHelperImpl extends ConnectionHelper {
    private static final String TAG = "ConnectionHelperImpl";
    private ConnectionHelperContract mConnectionHelperContract;
    private GrpcRunnable.Contract mGrpcRunnableContract;
    private final SnapGrpcManager mSnapGrpcManager = new SnapGrpcManager();
    private final CoeditGrpcManager mCoeditGrpcManager = new CoeditGrpcManager();

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.coedit.connection.ConnectionHelperImpl$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C90141 {
        static final /* synthetic */ int[] $SwitchMap$coeditCoreMessage$EventType;
        static final /* synthetic */ int[] $SwitchMap$coeditCoreMessage$ServerCmd;

        static {
            int[] iArr = new int[EventType.values().length];
            $SwitchMap$coeditCoreMessage$EventType = iArr;
            try {
                iArr[EventType.UPDATE_DOCUMENT_XML_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$coeditCoreMessage$EventType[EventType.UPDATE_APP_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$coeditCoreMessage$EventType[EventType.IS_SERVER_UNDER_MAINTENANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$coeditCoreMessage$EventType[EventType.DELETE_NOTE_RESOURCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$coeditCoreMessage$EventType[EventType.CHANGE_MEMBER_PERMISSION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$coeditCoreMessage$EventType[EventType.DELETE_MEMBER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[ServerCmd.values().length];
            $SwitchMap$coeditCoreMessage$ServerCmd = iArr2;
            try {
                iArr2[ServerCmd.RESPONSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$coeditCoreMessage$ServerCmd[ServerCmd.RESPOND_DEVICE_LIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$coeditCoreMessage$ServerCmd[ServerCmd.DISCONNECT_BY_EVENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$coeditCoreMessage$ServerCmd[ServerCmd.WORKSPACE_BLOCK_STATE_CHANGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$coeditCoreMessage$ServerCmd[ServerCmd.NOTIFY.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$coeditCoreMessage$ServerCmd[ServerCmd.HEALTH_CHECK.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$coeditCoreMessage$ServerCmd[ServerCmd.UNRECOGNIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CoeditGrpcDataContractImpl implements CoeditGrpcDataContract {
        public /* synthetic */ CoeditGrpcDataContractImpl(ConnectionHelperImpl connectionHelperImpl, int i) {
            this();
        }

        private void putCoeditDataNotifyBuffer(ServerMsg serverMsg) {
            try {
                CheckPointCoeditOpPair checkpointCoeditopPair = serverMsg.getCheckpointCoeditopPair();
                if (checkpointCoeditopPair == null) {
                    return;
                }
                ConnectionHelperImpl.this.handleCheckPointCoeditOpPair(checkpointCoeditopPair.getCheckpoint(), checkpointCoeditopPair.getCoeditOperationList(), checkpointCoeditopPair.getExtraData());
                ConnectionHelperImpl.this.coeditDataRequestDownloadFileData(checkpointCoeditopPair.getObjectInfoList());
            } catch (Exception e) {
                AbstractC8014b.m7218t(e, new StringBuilder("Failed to putCoeditDataNotifyBuffer. "), ConnectionHelperImpl.TAG);
            }
            ConnectionHelperImpl.this.requestRetryFailedData();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcDataContract
        public void downloadContentFile(ObjectInfo objectInfo) {
            if (ConnectionHelperImpl.this.isChannelDisableState("downloadContentFile")) {
                return;
            }
            ConnectionHelperImpl.this.mConnectionHelperContract.downloadContentFile(objectInfo.getObjId(), objectInfo.getDownloadSignedUrl());
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcDataContract
        public String getWorkspaceId() {
            return ConnectionHelperImpl.this.isChannelDisableState("getWorkspaceId") ? "" : ConnectionHelperImpl.this.mConnectionHelperContract.getWorkspaceId();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcDataContract
        public boolean isConcurrencyPausedByNetwork() {
            if (ConnectionHelperImpl.this.isChannelDisableState("isConcurrencyPausedByNetwork")) {
                return false;
            }
            return ConnectionHelperImpl.this.mConnectionHelperContract.isConcurrencyPausedByNetwork();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcDataContract
        public void notify(ServerMsg serverMsg) {
            if (ConnectionHelperImpl.this.isChannelDisableState("notify")) {
                return;
            }
            putCoeditDataNotifyBuffer(serverMsg);
            ConnectionHelperImpl.this.mConnectionHelperContract.onEditorUpdate(serverMsg.getCheckpointCoeditopPair().getDeviceInfo().getDvcId(), serverMsg.getCheckpointCoeditopPair().getDeviceInfo().getUid());
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcDataContract
        public void reconnect(String str) {
            if (ConnectionHelperImpl.this.isChannelDisableState("reconnect")) {
                return;
            }
            ConnectionHelperImpl.this.mConnectionHelperContract.reconnect(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcDataContract
        public void releaseLock(String str) {
            if (ConnectionHelperImpl.this.isChannelDisableState("releaseLock")) {
                return;
            }
            ConnectionHelperImpl.this.mConnectionHelperContract.releaseLock(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcDataContract
        public void setPausedByNetwork(String str) {
            if (ConnectionHelperImpl.this.isChannelDisableState("setPausedByNetwork")) {
                return;
            }
            ConnectionHelperImpl.this.mConnectionHelperContract.setPausedByNetwork(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcDataContract
        public void uploadContentFile(NoteOpFileData noteOpFileData, String str, String str2) {
            if (ConnectionHelperImpl.this.isChannelDisableState("uploadContentFile")) {
                return;
            }
            ConnectionHelperImpl.this.mConnectionHelperContract.uploadContentFile(noteOpFileData, str, str2);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcDataContract
        public void wakeConcurrencyPool() {
            if (ConnectionHelperImpl.this.isChannelDisableState("wakeConcurrencyPool")) {
                return;
            }
            ConnectionHelperImpl.this.mConnectionHelperContract.wakeConcurrencyPool();
        }

        private CoeditGrpcDataContractImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CoeditTransformDataContractImpl implements CoeditTransformDataContract {
        public /* synthetic */ CoeditTransformDataContractImpl(ConnectionHelperImpl connectionHelperImpl, int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditTransformDataContract
        public String getWorkspaceId() {
            return ConnectionHelperImpl.this.mConnectionHelperContract.getWorkspaceId();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditTransformDataContract
        public void reconnect(String str) {
            if (!ConnectionHelperImpl.this.isChannelDisableState("reconnect") && ConnectionHelperImpl.this.mConnectionHelperContract.isConcurrencyPausedByNetwork()) {
                ConnectionHelperImpl.this.mConnectionHelperContract.reconnect(str);
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditTransformDataContract
        public void releaseLock(String str) {
            ConnectionHelperImpl.this.mConnectionHelperContract.releaseLock(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditTransformDataContract
        public void setPausedByNetwork(String str) {
            if (ConnectionHelperImpl.this.isChannelDisableState("setPausedByNetwork")) {
                return;
            }
            ConnectionHelperImpl.this.mConnectionHelperContract.setPausedByNetwork(str);
        }

        private CoeditTransformDataContractImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SnapGrpcDataContractImpl implements SnapGrpcDataContract {
        public /* synthetic */ SnapGrpcDataContractImpl(ConnectionHelperImpl connectionHelperImpl, int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.data.SnapGrpcDataContract
        public void downloadContentFile(String str) {
            ConnectionHelperImpl.this.mConnectionHelperContract.downloadContentFile("", str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.data.SnapGrpcDataContract
        public void handleDownloadUrlMap(Map<String, String> map) {
            ConnectionHelperImpl.this.mConnectionHelperContract.handleDownloadUrlMap(map);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.data.SnapGrpcDataContract
        public void onContentFileUploadError(int i) {
            ConnectionHelperImpl.this.mConnectionHelperContract.onContentFileUploadError(i);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.data.SnapGrpcDataContract
        public void updateSnapNoteLatestInfo(long j, long j2, String str) {
            ConnectionHelperImpl.this.mConnectionHelperContract.updateSnapNoteLatestInfo(j, j2, str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.data.SnapGrpcDataContract
        public void uploadContentFileData(NoteOpFileData noteOpFileData, String str, String str2) {
            ConnectionHelperImpl.this.mConnectionHelperContract.uploadContentFile(noteOpFileData, str, str2);
        }

        private SnapGrpcDataContractImpl() {
        }
    }

    public ConnectionHelperImpl() {
        CoeditLogger.m8919d(TAG, "ConnectionHelperImpl validation : " + CoeditConstants.IS_VALIDATION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coeditDataRequestDownloadFileData(@NonNull List<ObjectInfo> list) {
        if (!isChannelConnectedState("coeditDataRequestDownloadFileData") || list.isEmpty()) {
            return;
        }
        for (ObjectInfo objectInfo : list) {
            if (objectInfo != null) {
                if (CoeditServiceConstants.MimeType.OBJECT_STROKE.equals(objectInfo.getBinaryInfo().getMimetype())) {
                    requestDownloadStroke(objectInfo.getObjId(), objectInfo.getBinaryInfo().getHash());
                } else {
                    this.mCoeditGrpcManager.requestDownloadObject(objectInfo);
                }
            }
        }
    }

    private void coeditDataRequestUploadObjects(@NonNull List<NoteOpFileData> list) {
        if (!isChannelConnectedState("coeditDataRequestUploadObjects") || list.isEmpty()) {
            return;
        }
        this.mCoeditGrpcManager.coeditDataRequestUploadObjects(list);
    }

    private void coeditDataRequestUploadStrokes(@NonNull List<NoteOpFileData> list) {
        for (NoteOpFileData noteOpFileData : list) {
            try {
                this.mCoeditGrpcManager.putCoeditDataUploadStrokeMsgQueue(noteOpFileData.getId(), noteOpFileData.getBinarySize(), noteOpFileData.getMimeType(), noteOpFileData.getBinaryData());
                uploadStroke(CoeditGrpcMethod.Caller.UploadStroke);
            } catch (Exception e) {
                AbstractC8014b.m7218t(e, new StringBuilder("coeditDataRequestUploadStrokes, Error: "), TAG);
            }
        }
    }

    @Nullable
    private Object getCoeditDataReceiveMsgData() {
        synchronized (this) {
            if (isCoeditDataReceiveMsgEmpty()) {
                return null;
            }
            try {
                return this.mCoeditGrpcManager.getCoeditDataReceiveMsgData();
            } catch (InterruptedException e) {
                CoeditLogger.m8920e(TAG, "getCoeditDataReceiveMsgData# " + e.getMessage());
                return null;
            }
        }
    }

    private boolean getCoeditObjectInfo(List<ObjectInfo> list, List<NoteOp> list2, List<NoteOpFileData> list3) {
        if (!this.mCoeditGrpcManager.isChannelConnected()) {
            return false;
        }
        if (!list3.isEmpty()) {
            this.mCoeditGrpcManager.initUploadedStroke(list3);
            coeditDataRequestUploadStrokes(list3);
            if (!this.mCoeditGrpcManager.isUploadStrokeFinished()) {
                CoeditLogger.m8919d(TAG, "uploadStrokes. wait to response");
                if (!this.mConnectionHelperContract.setLock("UploadStrokes")) {
                    return false;
                }
            }
            if (this.mCoeditGrpcManager.isUploadStrokeFailed()) {
                return false;
            }
        }
        this.mCoeditGrpcManager.setObjectInfo(list, list2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCheckPointCoeditOpPair(long j, List<CoeditOperation> list, String str) {
        this.mCoeditGrpcManager.setCoeditDataNotifyCheckPoint(Math.max(getCoeditDataNotifyCheckPoint(), j));
        this.mConnectionHelperContract.putNotifyNoteOpsBuffer(j, ProtoBufUtils.deserialize(list), str);
    }

    private void handleCoeditDataReceiveMessage(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (obj instanceof ServerMsg) {
                handleReceiveServerMessage((ServerMsg) obj);
            } else if (obj instanceof SubmitResponse) {
                handleReceiveSubmitResponse((SubmitResponse) obj);
            } else if (obj instanceof CatchupResponse) {
                handleReceiveCatchupResponse((CatchupResponse) obj);
            } else if (obj instanceof DownloadStrokeResponse) {
                handleReceiveDownloadStrokeResponse((DownloadStrokeResponse) obj);
            } else if (obj instanceof ResetWorkspaceResponse) {
                handleResetWorkspaceResponse((ResetWorkspaceResponse) obj);
            } else {
                if (obj instanceof PermissionResponse) {
                    return;
                }
                CoeditLogger.m8924w(TAG, "handleCoeditDataReceiveMessage# unused msgObj: " + obj);
            }
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("Failed to handleCoeditDataReceiveMessage. "), TAG);
        }
        requestRetryFailedData();
    }

    private void handleReceiveCatchupResponse(CatchupResponse catchupResponse) {
        String userId;
        String deviceId;
        try {
            String uuid = this.mConnectionHelperContract.getUuid();
            boolean z = CoeditCacheUtils.getAbnormalReleased(uuid) == 4;
            if (z) {
                userId = RequestToSamsungAccountManager.INSTANCE.getUserId();
                deviceId = CoeditCacheUtils.getDeviceId(uuid);
            } else {
                userId = "";
                deviceId = "";
            }
            List<CheckPointCoeditOpPair> checkpointCoeditopPairList = catchupResponse.getCheckpointCoeditopPairList();
            if (checkpointCoeditopPairList == null) {
                return;
            }
            for (CheckPointCoeditOpPair checkPointCoeditOpPair : checkpointCoeditopPairList) {
                if (checkPointCoeditOpPair != null) {
                    long checkpoint = checkPointCoeditOpPair.getCheckpoint();
                    if (z && userId != null && userId.equals(checkPointCoeditOpPair.getDeviceInfo().getUid()) && deviceId != null && deviceId.equals(checkPointCoeditOpPair.getDeviceInfo().getDvcId())) {
                        this.mConnectionHelperContract.setAbnormalAckCheckPoint(checkpoint);
                        z = false;
                    } else {
                        handleCheckPointCoeditOpPair(checkpoint, checkPointCoeditOpPair.getCoeditOperationList(), checkPointCoeditOpPair.getExtraData());
                        coeditDataRequestDownloadFileData(checkPointCoeditOpPair.getObjectInfoList());
                    }
                }
            }
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("Failed to putNotifyBuffer. "), TAG);
        }
    }

    private void handleReceiveDownloadStrokeResponse(DownloadStrokeResponse downloadStrokeResponse) {
        if (this.mCoeditGrpcManager.isChannelConnected() && downloadStrokeResponse.hasBinary()) {
            try {
                byte[] byteArray = downloadStrokeResponse.getBinary().getChunk().toByteArray();
                CoeditGrpcData.StrokeData strokeDataFindStrokeData = this.mCoeditGrpcManager.findStrokeData(byteArray);
                if (strokeDataFindStrokeData == null) {
                    CoeditLogger.m8919d(TAG, "handleReceiveDownloadStrokeResponse, strokeData null");
                    return;
                }
                String objId = strokeDataFindStrokeData.getObjId();
                this.mConnectionHelperContract.applyStrokeBinary(objId, strokeDataFindStrokeData.getObjectBinaryHash(), byteArray);
                this.mCoeditGrpcManager.removeDownloadStrokeData(objId);
            } catch (Exception e) {
                AbstractC8014b.m7218t(e, new StringBuilder("handleReceiveDownloadStrokeResponse, onCompleted: releaseByteArrayOutputStream error :"), TAG);
            }
        }
    }

    private void handleReceiveResponseDeviceList(ServerMsg serverMsg) {
        JSONArray jSONArray = new JSONArray();
        for (DeviceInfo deviceInfo : serverMsg.getDeviceInfoList()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CoeditServiceConstants.ServerResponse.DEVICE_INFO_DEVICE_ID, deviceInfo.getDvcId());
                jSONObject.put("uid", deviceInfo.getUid());
                if (deviceInfo.getDeviceInfoChangeTypeValue() == 0 || deviceInfo.getDeviceInfoChangeTypeValue() == 2) {
                    jSONObject.put(CoeditServiceConstants.ServerResponse.DEVICE_INFO_CONNECTION_TYPE, true);
                    jSONObject.put(CoeditServiceConstants.ServerResponse.DEVICE_INFO_PERMISSION_TYPE, deviceInfo.getPermissionType() == PermissionType.EDIT);
                } else {
                    jSONObject.put(CoeditServiceConstants.ServerResponse.DEVICE_INFO_CONNECTION_TYPE, false);
                    jSONObject.put(CoeditServiceConstants.ServerResponse.DEVICE_INFO_PERMISSION_TYPE, false);
                }
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                CoeditLogger.m8920e(TAG, "handleReceiveDeviceList for DeviceInfo, JSONException: " + e.getMessage());
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(CoeditServiceConstants.ServerResponse.DEVICE_INFO_LIST, jSONArray);
        } catch (JSONException e2) {
            CoeditLogger.m8920e(TAG, "handleReceiveDeviceList for DeviceInfoList, JSONException: " + e2.getMessage());
        }
        this.mConnectionHelperContract.handleReceiveDeviceList(jSONObject2.toString());
    }

    private void handleReceiveResponseDisconnectByEvent(ServerMsg serverMsg) {
        EventType eventType = serverMsg.getEventInfo().getEventType();
        CoeditLogger.m8919d(TAG, "handleReceiveResponseDisconnectByEvent, " + serverMsg);
        switch (C90141.$SwitchMap$coeditCoreMessage$EventType[eventType.ordinal()]) {
            case 1:
                this.mGrpcRunnableContract.onError(CoeditServiceConstants.ServerError.UPDATE_XML_VERSION);
                break;
            case 2:
                this.mGrpcRunnableContract.onError(CoeditServiceConstants.ServerError.UPDATE_APP_VERSION);
                break;
            case 3:
                this.mGrpcRunnableContract.onError(CoeditServiceConstants.ServerError.MAINTENANCE);
                break;
            case 4:
            case 5:
            case 6:
                CoeditLogger.m8924w(TAG, "handleReceiveServerMessage, unused eventType :" + eventType);
                break;
            default:
                CoeditLogger.m8920e(TAG, "handleReceiveServerMessage, unexpected eventType " + eventType);
                break;
        }
    }

    private void handleReceiveServerMessage(ServerMsg serverMsg) {
        switch (C90141.$SwitchMap$coeditCoreMessage$ServerCmd[serverMsg.getServerCmd().ordinal()]) {
            case 1:
                handleReceiveServerResponseMsg(serverMsg);
                break;
            case 2:
                handleReceiveResponseDeviceList(serverMsg);
                break;
            case 3:
                handleReceiveResponseDisconnectByEvent(serverMsg);
                break;
            case 4:
                CoeditLogger.m8919d(TAG, "handleReceiveResponseWorkspaceBlockStateChange, isWorkspaceBlocked: " + serverMsg.getWorkspaceBlocked() + ", workspaceVersion: " + serverMsg.getWorkspaceVersion());
                this.mConnectionHelperContract.handleWorkspaceBlock();
                break;
            case 5:
            case 6:
            case 7:
                break;
            default:
                CoeditLogger.m8924w(TAG, "handleReceiveServerMessage, unused server cmd used ");
                break;
        }
    }

    private void handleReceiveServerResponseMsg(ServerMsg serverMsg) {
        int code = serverMsg.getResponseResult().getCode();
        if (code == Status.Code.ALREADY_EXISTS.value() || code == Status.Code.ABORTED.value()) {
            CoeditLogger.m8919d(TAG, "handleReceiveServerResponseMsg return : " + code);
            return;
        }
        String dvcId = serverMsg.getDvcId();
        if (!TextUtils.isEmpty(dvcId)) {
            CoeditCacheUtils.setDeviceId(this.mConnectionHelperContract.getUuid(), dvcId);
        }
        boolean workspaceBlocked = serverMsg.getWorkspaceBlocked();
        long workspaceVersion = serverMsg.getWorkspaceVersion();
        if (!workspaceBlocked) {
            long workspaceVersion2 = this.mCoeditGrpcManager.getWorkspaceVersion();
            if (workspaceVersion > workspaceVersion2) {
                StringBuilder sbM1323p = AbstractC1974b.m1323p(workspaceVersion, "handleReceiveServerResponseMsg, responseWorkspaceVersion: ", ", cachedWorkspaceVersion:");
                sbM1323p.append(workspaceVersion2);
                sbM1323p.append(", mismatched, set isWorkspaceBlock true");
                CoeditLogger.m8924w(TAG, sbM1323p.toString());
                workspaceBlocked = true;
            }
        }
        boolean z = workspaceBlocked;
        this.mCoeditGrpcManager.setResponsedWorkspaceVersion(workspaceVersion);
        this.mConnectionHelperContract.handleReceiveServerResponse(serverMsg.getSessionValidTime() * 1000, serverMsg.getCheckpointCoeditopPair().getCheckpoint(), serverMsg.getConnectedDeviceCnt(), serverMsg.hasPolicyInfo() ? serverMsg.getPolicyInfo().getMaxEditableDeviceCnt() : -1L, serverMsg.hasPolicyInfo() ? serverMsg.getPolicyInfo().getMaxConnectableDeviceCnt() : -1L, z);
    }

    private void handleReceiveSubmitResponse(SubmitResponse submitResponse) {
        if (submitResponse.getCheckpoint() != 0) {
            this.mCoeditGrpcManager.setCoeditDataSubmitCheckPoint(submitResponse.getCheckpoint());
        }
    }

    private void handleResetWorkspaceResponse(ResetWorkspaceResponse resetWorkspaceResponse) {
        String workspaceId = resetWorkspaceResponse.getWorkspaceId();
        long latestSnapshotCheckpoint = resetWorkspaceResponse.getLatestSnapshotCheckpoint();
        long workspaceVersion = resetWorkspaceResponse.getWorkspaceVersion();
        boolean isBlocked = resetWorkspaceResponse.getIsBlocked();
        StringBuilder sb = new StringBuilder("handleResetWorkspaceResponse, workspaceId: [");
        sb.append(workspaceId);
        sb.append("], lastSnapshotCheckPoint: [");
        sb.append(latestSnapshotCheckpoint);
        AbstractC1038a.m1223x(sb, "], workspaceVersion: [", workspaceVersion, "], isWorkspaceBlocked: [");
        sb.append(isBlocked);
        sb.append("]");
        CoeditLogger.m8919d(TAG, sb.toString());
        this.mConnectionHelperContract.handleResetWorkspaceResponse(latestSnapshotCheckpoint);
    }

    private boolean isChannelConnectedState(String str) {
        boolean z = !isNotOpenedState() && this.mCoeditGrpcManager.isChannelConnected();
        if (!z) {
            CoeditLogger.m8919d(TAG, "isChannelConnectedState ignore state : " + getState() + " , caller : " + str);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChannelDisableState(String str) {
        boolean z = isAlreadyStopped() || isUndefinedState();
        if (!z) {
            CoeditLogger.m8919d(TAG, "isChannelEnableState ignore state : " + getState() + " , caller : " + str);
        }
        return z;
    }

    private boolean isJwtInvalid(String str) {
        if (!CoeditServiceConstants.ServerError.UNEXPECTED.equals(str) && !CoeditServiceConstants.ServerError.UPDATE_XML_VERSION.equals(str) && !CoeditServiceConstants.ServerError.UPDATE_APP_VERSION.equals(str) && !CoeditServiceConstants.ServerError.MAINTENANCE.equals(str) && !CoeditServiceConstants.ServerError.AUTH_TOKEN_EXPIRED.equals(str) && !CoeditServiceConstants.ServerError.UNKNOWN.equals(str)) {
            return false;
        }
        this.mConnectionHelperContract.onSnapError(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestRetryFailedData() {
        if (this.mCoeditGrpcManager.isChannelConnected()) {
            coeditDataRequestUploadObjects(this.mCoeditGrpcManager.getUnuploadedNoteOpFileDatas());
            coeditDataRequestDownloadFileData(this.mCoeditGrpcManager.getUndownloadedObjectInfo());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void catchup(String str, long j, long j2) {
        if (isChannelConnectedState(CoeditGrpcMethod.Caller.GetDeviceList)) {
            this.mCoeditGrpcManager.requestCatchup(j, j2);
            this.mCoeditGrpcManager.requestCoedit(str, 110);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void clearMultipleTransformData() {
        this.mCoeditGrpcManager.clearMultipleTransformData();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void clearSubmitData() {
        this.mCoeditGrpcManager.clearSubmitData();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void clearTransformData() {
        this.mCoeditGrpcManager.clearTransformData();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void clearTransformWithMultipleData() {
        this.mCoeditGrpcManager.clearTransformWithMultipleData();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void close() {
        if (!isAlreadyClosed() && !isUndefinedState()) {
            this.mCoeditGrpcManager.requestCoedit(CoeditGrpcMethod.Caller.CLOSE, 3);
            setClosedState();
        } else {
            CoeditLogger.m8919d(TAG, "ignore close request, state : " + getState());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void compose(String str) {
        if (isChannelConnectedState(CoeditGrpcMethod.Caller.Compose)) {
            this.mCoeditGrpcManager.requestCoeditTransform(str, 109);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void connect(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
            CoeditLogger.m8920e(TAG, "connect, ignore, data network failed or wifi mode enabled");
        } else {
            if (isJwtInvalid(str5)) {
                CoeditLogger.m8920e(TAG, "connect, ignore, invalid JWT!");
                return;
            }
            int i = 0;
            this.mCoeditGrpcManager.createChannel(str, str2, str3, str4, str5, str6, str7, this.mGrpcRunnableContract, new CoeditGrpcDataContractImpl(this, i), new CoeditTransformDataContractImpl(this, i));
            setStartedState();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean connectSnap(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i = 0;
        if (isJwtInvalid(str5)) {
            return false;
        }
        this.mSnapGrpcManager.createChannel(str, str2, str3, str4, str5, str6, str7, this.mGrpcRunnableContract, new SnapGrpcDataContractImpl(this, i));
        this.mSnapGrpcManager.requestSnap("Start - Snap Set Finished State false", 0);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void disconnectSnap() {
        this.mSnapGrpcManager.requestSnap("Stop - Shutdown Channel", 4);
        this.mSnapGrpcManager.release();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void downloadNote(String str) {
        this.mSnapGrpcManager.requestSnap(str, 103);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public long getCoeditDataNotifyCheckPoint() {
        return this.mCoeditGrpcManager.getCoeditDataNotifyCheckPoint();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public int getCoeditDataResultCode() {
        return this.mCoeditGrpcManager.getCoeditDataResultCode();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public long getCoeditDataSubmitCheckPoint() {
        return this.mCoeditGrpcManager.getCoeditDataSubmitCheckPoint();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    @Nullable
    public List<NoteOp> getComposedOps() {
        return this.mCoeditGrpcManager.getComposedOps();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void getDeviceList() {
        if (isChannelConnectedState(CoeditGrpcMethod.Caller.GetDeviceList)) {
            this.mCoeditGrpcManager.requestCoedit(CoeditGrpcMethod.Caller.GetDeviceList, 111);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public int getDownloadXmlDataSize() {
        return this.mSnapGrpcManager.getDownloadXmlDataSize();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    @Nullable
    public OperationPair getMultipleTransformedOps() {
        return this.mCoeditGrpcManager.getMultipleTransformedOps();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void getNoteSnapLatestInfo(String str) {
        this.mSnapGrpcManager.requestSnap(str, 104);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public byte[] getSnapDataDownloadStroke(String str) {
        return this.mSnapGrpcManager.getSnapDataDownloadStroke(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public Set<String> getSnapDataDownloadStrokeMapKeySet() {
        return this.mSnapGrpcManager.getSnapDataDownloadStrokeMapKeySet();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public String getSnapDataDownloadXmlData() {
        return this.mSnapGrpcManager.getSnapDataDownloadXmlData();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public String getSnapDataResourceId() {
        return this.mSnapGrpcManager.getSnapDataResourceId();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    @Nullable
    public OperationPair<List<NoteOp>> getTransformedOps() {
        return this.mCoeditGrpcManager.getTransformedOps();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    @Nullable
    public OperationPair<List<List<NoteOp>>> getTransformedWithMultipleOps() {
        return this.mCoeditGrpcManager.getTransformedWithMultipleOps();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void handleCoeditDataReceiveMessages() {
        while (true) {
            Object coeditDataReceiveMsgData = getCoeditDataReceiveMsgData();
            if (coeditDataReceiveMsgData == null) {
                return;
            } else {
                handleCoeditDataReceiveMessage(coeditDataReceiveMsgData);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void initialize(GrpcRunnable.Contract contract, ConnectionHelperContract connectionHelperContract) {
        this.mGrpcRunnableContract = contract;
        this.mConnectionHelperContract = connectionHelperContract;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean isChannelConnected() {
        return this.mCoeditGrpcManager.isChannelConnected();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean isCoeditDataReceiveMsgEmpty() {
        return this.mCoeditGrpcManager.isCoeditDataReceiveMsgEmpty();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean isCoeditDataResultDeadlineExceeded() {
        return this.mCoeditGrpcManager.isCoeditDataResultDeadlineExceeded();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean isCoeditDataResultNotFound() {
        return this.mCoeditGrpcManager.isCoeditDataResultNotFound();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean isCoeditDataResultOk() {
        return this.mCoeditGrpcManager.isCoeditDataResultOk();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean isCoeditDataResultUnavailable() {
        return this.mCoeditGrpcManager.isCoeditDataResultUnavailable();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean isSnapDataResultOk() {
        return this.mSnapGrpcManager.isSnapDataResultOk();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean isVaildState() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void multipleTransform(String str) {
        if (isChannelConnectedState(CoeditGrpcMethod.Caller.MultipleTransform)) {
            this.mCoeditGrpcManager.requestCoeditTransform(str, 107);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void open() {
        if (isStartedState()) {
            setOpenedState();
            this.mCoeditGrpcManager.requestCoedit(CoeditGrpcMethod.Caller.OPEN, 1);
        } else {
            CoeditLogger.m8919d(TAG, "ignore open request, state : " + getState());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean putCoeditDataSubmitRequest(long j, List<NoteOp> list, List<NoteOpFileData> list2, List<NoteOpFileData> list3, String str) throws InterruptedException {
        if (!this.mCoeditGrpcManager.isChannelConnected()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        if (!getCoeditObjectInfo(arrayList, list, list2)) {
            return false;
        }
        coeditDataRequestUploadObjects(list3);
        this.mCoeditGrpcManager.putSubmitRequest(list, j, str, arrayList);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void putComposeRequest(List<List<NoteOp>> list) throws InterruptedException {
        this.mCoeditGrpcManager.putComposeRequest(list);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void putMultipleTransformRequest(List<List<NoteOp>> list, List<NoteOp> list2) throws InterruptedException {
        this.mCoeditGrpcManager.putMultipleTransformRequest(list, list2);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void putSnapDataUploadNoteRequest(String str, String str2, int i) throws InterruptedException, IOException {
        this.mSnapGrpcManager.putUploadNoteRequest(str, str2, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void putSnapDataUploadStrokeRequest(String str, String str2, byte[] bArr, long j) throws InterruptedException {
        this.mSnapGrpcManager.putSnapDataUploadStrokeRequest(str, str2, bArr, j);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void putTransformRequest(List<NoteOp> list, List<NoteOp> list2) throws InterruptedException {
        this.mCoeditGrpcManager.putTransformRequest(list, list2);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void putTransformWithMultipleRequest(List<NoteOp> list, List<List<NoteOp>> list2) throws InterruptedException {
        this.mCoeditGrpcManager.putTransformWithMultipleRequest(list, list2);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void reOpen(String str) {
        if (this.mCoeditGrpcManager.isChannelConnected()) {
            setOpenedState();
            this.mCoeditGrpcManager.requestCoedit(CoeditGrpcMethod.Caller.REOPEN, 1);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void refresh() {
        if (isChannelConnectedState(CoeditGrpcMethod.Caller.REFRESH)) {
            this.mCoeditGrpcManager.requestCoedit(CoeditGrpcMethod.Caller.REFRESH, 2);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void refreshForReopen() {
        this.mCoeditGrpcManager.refreshForReopen();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void releaseContinuousMessageThread(String str) {
        this.mCoeditGrpcManager.releaseContinuousMessageThread(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void removeUndownloadedObjectInfo(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mCoeditGrpcManager.isChannelConnected()) {
            this.mCoeditGrpcManager.removeUndownloadedObjectInfo(str, z);
        } else if (this.mSnapGrpcManager.isChannelConnected()) {
            this.mSnapGrpcManager.removeUndownloadedObjectInfo(str, z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean removeUnuploadedContentFileData(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.mCoeditGrpcManager.isChannelConnected()) {
            return this.mCoeditGrpcManager.removeUnuploadedContentFileData(str);
        }
        if (this.mSnapGrpcManager.isChannelConnected()) {
            return this.mSnapGrpcManager.removeUnuploadedContentFileData(str);
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void requestDownloadStroke(String str, String str2) {
        if (isChannelConnectedState(CoeditGrpcMethod.Caller.DownloadStroke)) {
            try {
                this.mConnectionHelperContract.saveDownloadStrokeData(str, str2);
                this.mCoeditGrpcManager.putDownloadStrokeData(str, str2);
                this.mCoeditGrpcManager.putCoeditDataDownloadStrokeMsgQueue(str);
            } catch (InterruptedException e) {
                CoeditLogger.m8920e(TAG, "Failed to DownloadStroke. " + e.getMessage());
            }
            this.mCoeditGrpcManager.requestCoedit(CoeditGrpcMethod.Caller.DownloadStroke, 105);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean requestPermission(boolean z) {
        if (!isChannelConnectedState(CoeditGrpcMethod.Caller.RequestPermission)) {
            return false;
        }
        try {
            this.mCoeditGrpcManager.putPermissionRequest(z);
            this.mCoeditGrpcManager.requestCoedit("requestPermission, ".concat(z ? "EDIT" : "VIEW"), 112);
            return isCoeditDataResultOk();
        } catch (InterruptedException e) {
            CoeditLogger.m8920e(TAG, "ignore requestPermission request. error : " + e.getMessage());
            return false;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void requestResetWorkspace(String str) {
        if (isChannelConnectedState(CoeditGrpcMethod.Caller.ResetWorkspace)) {
            CoeditGrpcManager coeditGrpcManager = this.mCoeditGrpcManager;
            StringBuilder sbM781w = AbstractC0541b.m781w(str, "_ ");
            sbM781w.append(this.mCoeditGrpcManager.getWorkspaceId());
            coeditGrpcManager.requestCoedit(sbM781w.toString(), 113);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void setCoeditDataAbnormalNotifyLostCatchType() {
        this.mCoeditGrpcManager.setCoeditDataCatchupType(CatchupType.ABNORMAL_NOTIFY_LOST);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void setCoeditDataAbnormalSubmitAckLostCatchupType() {
        this.mCoeditGrpcManager.setCoeditDataCatchupType(CatchupType.ABNORMAL_SUBMIT_ACK_LOST);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void setCoeditDataNormalNewMemberCatchType() {
        this.mCoeditGrpcManager.setCoeditDataCatchupType(CatchupType.NORMAL_NEW_MEMBER);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public boolean snapDataRequestUploadFileData(List<NoteOpFileData> list) {
        return this.mSnapGrpcManager.snapDataRequestUploadFileData(list);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void stop() {
        if (isChannelDisableState("stop")) {
            return;
        }
        this.mCoeditGrpcManager.stopChannel();
        setStoppedState();
        this.mGrpcRunnableContract = null;
        this.mConnectionHelperContract = null;
        this.mCoeditGrpcManager.release();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void submit(String str) {
        if (isChannelConnectedState(CoeditGrpcMethod.Caller.Submit)) {
            this.mCoeditGrpcManager.requestCoedit(str, 103);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void transform(String str) {
        if (isChannelConnectedState(CoeditGrpcMethod.Caller.Transform)) {
            this.mCoeditGrpcManager.requestCoeditTransform(str, 106);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void transformWithMultiple(String str) {
        if (isChannelConnectedState(CoeditGrpcMethod.Caller.TransformWithMultiple)) {
            this.mCoeditGrpcManager.requestCoeditTransform(str, 108);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void uploadNote(String str) {
        this.mSnapGrpcManager.requestSnap(str, 102);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection
    public void uploadStroke(String str) {
        if (isChannelConnectedState(CoeditGrpcMethod.Caller.UploadStroke)) {
            this.mCoeditGrpcManager.requestCoedit(str, 104);
        }
    }
}
