package com.samsung.android.support.senl.p148nt.coedit.control.controller;

import androidx.annotation.Nullable;
import com.samsung.android.support.senl.ntnl.coedit.IGrpcController;
import com.samsung.android.support.senl.ntnl.coedit.OperationPair;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.coedit.connection.ConnectionHelper;
import com.samsung.android.support.senl.p148nt.coedit.connection.ConnectionHelperImpl;
import com.samsung.android.support.senl.p148nt.coedit.connection.DummyConnectionHelperImpl;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.GrpcControllerContractImpl;
import com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract;
import com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract;
import com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ViewControllerContract;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class GrpcController implements IGrpcController {
    private static final String TAG = "GrpcController";
    private ObjectBuilder<ConnectionHelper> mConnectionHelper;
    private final ObjectBuilder<GrpcControllerContractImpl> mGrpcControllerState;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ConnectionHelperContractImpl implements ConnectionHelperContract {
        public ConnectionHelperContractImpl() {
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void applyStrokeBinary(String str, String str2, byte[] bArr) {
            if (((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).isImplementation()) {
                CoeditCacheUtils.removeUndownloadedStrokeInfo(getUuid(), str);
                if (CoeditCacheUtils.saveDownloadedStrokeInfo(getUuid(), str2, bArr)) {
                    ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).applyStrokeBinary(str2, bArr);
                    return;
                }
                StringBuilder sbM15l = AbstractC0000a.m15l("applyStrokeBinary. can't saveDownloadedStrokeInfo id = ", str, ", size = ");
                sbM15l.append(bArr.length);
                CoeditLogger.m8924w(GrpcController.TAG, sbM15l.toString());
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void downloadContentFile(String str, String str2) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).downloadContentFile(str, str2);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public String getUuid() {
            return ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).getUuid();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public String getWorkspaceId() {
            return ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).getWorkspaceId();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void handleDownloadUrlMap(Map<String, String> map) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).handleDownloadUrlMap(map);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void handleReceiveDeviceList(String str) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).handleDeviceListChange(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void handleReceiveServerResponse(long j, long j2, long j3, long j5, long j6, boolean z) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).handleReceiveServerResponse(j, j2, j3, j5, j6, z);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void handleResetWorkspaceResponse(long j) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).handleResetWorkspaceResponse(j);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void handleWorkspaceBlock() {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).handleWorkspaceBlock();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public boolean isConcurrencyPausedByNetwork() {
            return ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).isConcurrencyPausedByNetwork();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void onContentFileUploadError(int i) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).onContentFileUploadError(i);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void onEditorUpdate(String str, String str2) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).onEditorUpdate(str, str2);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void onSnapError(String str) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).onSnapError(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void putNotifyNoteOpsBuffer(long j, List<NoteOp> list, String str) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).putNotifyNoteOpsBuffer(j, list, str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void reconnect(String str) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).reconnect(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void releaseLock(String str) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).releaseLock(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void saveDownloadStrokeData(String str, String str2) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).saveUndownloadedStrokeInfo(str, str2);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void setAbnormalAckCheckPoint(long j) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).setAbnormalAckCheckPoint(j);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public boolean setLock(String str) {
            return ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).setLock(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void setPausedByNetwork(String str) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).setPausedByNetwork(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void updateSnapNoteLatestInfo(long j, long j2, String str) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).updateSnapNoteLatestInfo(j, j2, str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void uploadContentFile(NoteOpFileData noteOpFileData, String str, String str2) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).uploadContentFile(noteOpFileData, str, str2);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.ConnectionHelperContract
        public void wakeConcurrencyPool() {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).wakeConcurrencyPool();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class GrpcRunnableContractImpl implements GrpcRunnable.Contract {
        public GrpcRunnableContractImpl() {
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.task.GrpcRunnable.Contract
        public boolean isClosing() {
            return ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).isClosing();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.task.GrpcRunnable.Contract
        public void onError(String str) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).onError(str);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.task.GrpcRunnable.Contract
        public void showToast(String str) {
            ((GrpcControllerContractImpl) GrpcController.this.mGrpcControllerState.getInstance()).showToast(str);
        }
    }

    public GrpcController(ConnectionControllerContract connectionControllerContract, ViewControllerContract viewControllerContract, ManagerControllerContract managerControllerContract) {
        ObjectBuilder<GrpcControllerContractImpl> objectBuilder = new ObjectBuilder<GrpcControllerContractImpl>() { // from class: com.samsung.android.support.senl.nt.coedit.control.controller.GrpcController.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
            public GrpcControllerContractImpl build() {
                return new GrpcControllerContractImpl();
            }
        };
        this.mGrpcControllerState = objectBuilder;
        this.mConnectionHelper = new ObjectBuilder<ConnectionHelper>() { // from class: com.samsung.android.support.senl.nt.coedit.control.controller.GrpcController.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
            public ConnectionHelper build() {
                return new DummyConnectionHelperImpl();
            }
        };
        createConnectionHelpers();
        objectBuilder.getInstance().setGrpcContract(connectionControllerContract, viewControllerContract, managerControllerContract);
    }

    private void createConnectionHelpers() {
        if (this.mConnectionHelper.isValid()) {
            this.mConnectionHelper.release();
        }
        this.mConnectionHelper = new ObjectBuilder<ConnectionHelper>() { // from class: com.samsung.android.support.senl.nt.coedit.control.controller.GrpcController.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
            public ConnectionHelper build() {
                return new ConnectionHelperImpl();
            }
        };
    }

    private ConnectionControllerContract.JwtResultItem getJWT(String str, String str2, String str3, String str4) {
        return this.mGrpcControllerState.getInstance().getJWT(str, str2, str3, str4);
    }

    private boolean isAlreadySnapReleased() {
        return this.mGrpcControllerState.getInstance().isAlreadySnapReleased();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void catchup(String str, long j, long j2) {
        this.mConnectionHelper.getInstance().catchup(str, j, j2);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void clearMultipleTransformData() {
        this.mConnectionHelper.getInstance().clearMultipleTransformData();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void clearSubmitData() {
        this.mConnectionHelper.getInstance().clearSubmitData();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void clearTransformData() {
        this.mConnectionHelper.getInstance().clearTransformData();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void clearTransformWithMultipleData() {
        this.mConnectionHelper.getInstance().clearTransformWithMultipleData();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void closeHelper() {
        this.mConnectionHelper.getInstance().stop();
        this.mConnectionHelper.release();
        this.mConnectionHelper = new ObjectBuilder<ConnectionHelper>() { // from class: com.samsung.android.support.senl.nt.coedit.control.controller.GrpcController.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
            public ConnectionHelper build() {
                return new DummyConnectionHelperImpl();
            }
        };
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void compose(String str) {
        this.mConnectionHelper.getInstance().compose(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void connect(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.mConnectionHelper.getInstance().isVaildState()) {
            if (!isAlreadySnapReleased()) {
                CoeditLogger.m8919d(TAG, "connect, pause");
                pauseConcurrency(CoeditServiceConstants.CONCURRNCY_KEY.INFINITY.SNAP_UPLOADING);
            } else {
                CoeditLogger.m8919d(TAG, "connect, isAlreadySnapReleased");
                ConnectionControllerContract.JwtResultItem jwt = getJWT(str4, str5, str6, "connect");
                this.mConnectionHelper.getInstance().connect(jwt.getRegionDomain(), str, str2, str3, jwt.getJwt(), str4, str6);
                this.mGrpcControllerState.getInstance().resumeConcurrency(CoeditServiceConstants.CONCURRNCY_KEY.INFINITY.SNAP_UPLOADING);
            }
        }
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public int connectSnap(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        ConnectionControllerContract.JwtResultItem jwt = getJWT(str4, str5, str6, "connectSnap");
        if (this.mConnectionHelper.getInstance().connectSnap(jwt.getRegionDomain(), str, str2, str3, jwt.getJwt(), str4, str6)) {
            return this.mGrpcControllerState.getInstance().getJwtMode(str4);
        }
        return -1;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void disconnect() {
        this.mConnectionHelper.getInstance().close();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void disconnectSnap() {
        this.mConnectionHelper.getInstance().disconnectSnap();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void downloadNote(String str) {
        this.mConnectionHelper.getInstance().downloadNote(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public long getCoeditDataNotifyCheckPoint() {
        return this.mConnectionHelper.getInstance().getCoeditDataNotifyCheckPoint();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public int getCoeditDataResultCode() {
        return this.mConnectionHelper.getInstance().getCoeditDataResultCode();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public long getCoeditDataSubmitCheckPoint() {
        return this.mConnectionHelper.getInstance().getCoeditDataSubmitCheckPoint();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    @Nullable
    public List<NoteOp> getComposedOps() {
        try {
            return this.mConnectionHelper.getInstance().getComposedOps();
        } catch (InterruptedException e) {
            CoeditLogger.m8920e(TAG, "getComposedOps. " + e.getMessage());
            return null;
        }
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void getDeviceList() {
        this.mConnectionHelper.getInstance().getDeviceList();
    }

    public int getDownloadXmlDataSize() {
        return this.mConnectionHelper.getInstance().getDownloadXmlDataSize();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    @Nullable
    public OperationPair<List<List<NoteOp>>> getMultipleTransformedOps() {
        try {
            return this.mConnectionHelper.getInstance().getMultipleTransformedOps();
        } catch (InterruptedException e) {
            CoeditLogger.m8920e(TAG, "getMultipleTransformedOps. " + e.getMessage());
            return null;
        }
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void getNoteSnapLatestInfo(String str) {
        this.mConnectionHelper.getInstance().getNoteSnapLatestInfo(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public byte[] getSnapDataDownloadStroke(String str) {
        return this.mConnectionHelper.getInstance().getSnapDataDownloadStroke(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public Set<String> getSnapDataDownloadStrokeMapKeySet() {
        return this.mConnectionHelper.getInstance().getSnapDataDownloadStrokeMapKeySet();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public String getSnapDataDownloadXmlData() {
        return this.mConnectionHelper.getInstance().getSnapDataDownloadXmlData();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public String getSnapDataResourceId() {
        return this.mConnectionHelper.getInstance().getSnapDataResourceId();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    @Nullable
    public OperationPair<List<NoteOp>> getTransformedOps() {
        try {
            return this.mConnectionHelper.getInstance().getTransformedOps();
        } catch (InterruptedException e) {
            CoeditLogger.m8920e(TAG, "getTransformedOps. " + e.getMessage());
            return null;
        }
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    @Nullable
    public OperationPair<List<List<NoteOp>>> getTransformedWithMultipleOps() {
        try {
            return this.mConnectionHelper.getInstance().getTransformedWithMultipleOps();
        } catch (InterruptedException e) {
            CoeditLogger.m8920e(TAG, "getTransformedWithMultipleOps. " + e.getMessage());
            return null;
        }
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void handleCoeditDataReceiveMessages() {
        this.mConnectionHelper.getInstance().handleCoeditDataReceiveMessages();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void initialize() {
        this.mConnectionHelper.getInstance().initialize(new GrpcRunnableContractImpl(), new ConnectionHelperContractImpl());
    }

    public boolean isChannelConnected() {
        return this.mConnectionHelper.getInstance().isChannelConnected();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public boolean isCoeditDataReceiveMsgEmpty() {
        return this.mConnectionHelper.getInstance().isCoeditDataReceiveMsgEmpty();
    }

    public boolean isCoeditDataResultDeadlineExceeded() {
        return this.mConnectionHelper.getInstance().isCoeditDataResultDeadlineExceeded();
    }

    public boolean isCoeditDataResultNotFound() {
        return this.mConnectionHelper.getInstance().isCoeditDataResultNotFound();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public boolean isCoeditDataResultOk() {
        return this.mConnectionHelper.getInstance().isCoeditDataResultOk();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public boolean isCoeditDataResultUnavailable() {
        return this.mConnectionHelper.getInstance().isCoeditDataResultUnavailable();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public boolean isSnapDataResultOk() {
        return this.mConnectionHelper.getInstance().isSnapDataResultOk();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void multipleTransform(String str) {
        this.mConnectionHelper.getInstance().multipleTransform(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void onStrokeApplied(String str) {
        CoeditCacheUtils.onStrokeApplied(this.mGrpcControllerState.getInstance().getUuid(), str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void open() {
        this.mConnectionHelper.getInstance().open();
    }

    public void pauseConcurrency(String str) {
        this.mGrpcControllerState.getInstance().pauseConcurrency(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public boolean putCoeditDataSubmitRequest(long j, List<NoteOp> list, List<NoteOpFileData> list2, List<NoteOpFileData> list3, String str) {
        try {
            return this.mConnectionHelper.getInstance().putCoeditDataSubmitRequest(j, list, list2, list3, str);
        } catch (InterruptedException e) {
            CoeditLogger.m8920e(TAG, "putCoeditDataSubmitRequest. " + e.getMessage());
            return false;
        }
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void putComposeRequest(List<List<NoteOp>> list) {
        try {
            this.mConnectionHelper.getInstance().putComposeRequest(list);
        } catch (InterruptedException e) {
            CoeditLogger.m8920e(TAG, "putComposeRequest. " + e.getMessage());
        }
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void putMultipleTransformRequest(List<List<NoteOp>> list, List<NoteOp> list2) {
        try {
            this.mConnectionHelper.getInstance().putMultipleTransformRequest(list, list2);
        } catch (InterruptedException e) {
            CoeditLogger.m8920e(TAG, "putMultipleTransformRequest. " + e.getMessage());
        }
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void putSnapDataUploadNoteRequest(String str, String str2, int i) {
        try {
            this.mConnectionHelper.getInstance().putSnapDataUploadNoteRequest(str, str2, i);
        } catch (IOException | InterruptedException e) {
            AbstractC8014b.m7218t(e, new StringBuilder("putSnapDataUploadNoteRequest. "), TAG);
        }
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void putSnapDataUploadStrokeRequest(String str, String str2, byte[] bArr, long j) {
        try {
            this.mConnectionHelper.getInstance().putSnapDataUploadStrokeRequest(str, str2, bArr, j);
        } catch (InterruptedException e) {
            CoeditLogger.m8920e(TAG, "putSnapDataUploadStrokeRequest. " + e.getMessage());
        }
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void putTransformRequest(List<NoteOp> list, List<NoteOp> list2) {
        try {
            this.mConnectionHelper.getInstance().putTransformRequest(list, list2);
        } catch (InterruptedException e) {
            CoeditLogger.m8920e(TAG, "putTransformRequest. " + e.getMessage());
        }
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void putTransformWithMultipleRequest(List<NoteOp> list, List<List<NoteOp>> list2) {
        try {
            this.mConnectionHelper.getInstance().putTransformWithMultipleRequest(list, list2);
        } catch (InterruptedException e) {
            CoeditLogger.m8920e(TAG, "putMultipleTransformRequest. " + e.getMessage());
        }
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void reOpen(String str) {
        this.mConnectionHelper.getInstance().reOpen(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void refresh() {
        this.mConnectionHelper.getInstance().refresh();
    }

    public void refreshForReopen() {
        this.mConnectionHelper.getInstance().refreshForReopen();
    }

    public void release() {
        this.mGrpcControllerState.getInstance().release();
        this.mGrpcControllerState.release();
        this.mConnectionHelper.release();
    }

    public void releaseContinuousMessageThread(String str) {
        this.mConnectionHelper.getInstance().releaseContinuousMessageThread(str + "/releaseContinuousMessageThread");
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void removeUndownloadedObjectInfo(String str, boolean z) {
        this.mConnectionHelper.getInstance().removeUndownloadedObjectInfo(str, z);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public boolean removeUnuploadedContentFileData(String str) {
        return this.mConnectionHelper.getInstance().removeUnuploadedContentFileData(str);
    }

    public void requestDownloadStroke(String str, String str2) {
        this.mConnectionHelper.getInstance().requestDownloadStroke(str, str2);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public boolean requestPermission(boolean z) {
        return this.mConnectionHelper.getInstance().requestPermission(z);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void requestResetWorkspace(String str) {
        this.mConnectionHelper.getInstance().requestResetWorkspace(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void runResumeRunnable() {
        this.mGrpcControllerState.getInstance().runResumeRunnable();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void setCoeditDataAbnormalNotifyLostCatchType() {
        this.mConnectionHelper.getInstance().setCoeditDataAbnormalNotifyLostCatchType();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void setCoeditDataAbnormalSubmitAckLostCatchupType() {
        this.mConnectionHelper.getInstance().setCoeditDataAbnormalSubmitAckLostCatchupType();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void setCoeditDataNormalNewMemberCatchType() {
        this.mConnectionHelper.getInstance().setCoeditDataNormalNewMemberCatchType();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public boolean snapDataRequestUploadFileData(List<NoteOpFileData> list) {
        CoeditLogger.m8919d(TAG, "snapDataRequestUploadFileData size : " + list.size());
        return this.mConnectionHelper.getInstance().snapDataRequestUploadFileData(list);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void submit(String str) {
        this.mConnectionHelper.getInstance().submit(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void transform(String str) {
        this.mConnectionHelper.getInstance().transform(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void transformWithMultiple(String str) {
        this.mConnectionHelper.getInstance().transformWithMultiple(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void uploadNote(String str) {
        this.mConnectionHelper.getInstance().uploadNote(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.IGrpcController
    public void uploadStroke(String str) {
        this.mConnectionHelper.getInstance().uploadStroke(str);
    }
}
