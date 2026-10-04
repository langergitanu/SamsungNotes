package com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc;

import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract;
import com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract;
import com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ViewControllerContract;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class GrpcControllerContractImpl {
    private final DummyConnectionController mDummyConnectionController = new DummyConnectionController();
    private final ConnectionController mConnectionController = new ConnectionController();
    private final DummyViewController mDummyViewController = new DummyViewController();
    private final ViewController mViewController = new ViewController();
    private final DummyManagerController mDummyManagerController = new DummyManagerController();
    private final ManagerController mManagerController = new ManagerController();
    private boolean mImplementation = false;

    public void applyStrokeBinary(String str, byte[] bArr) {
        getManager().applyStrokeBinary(str, bArr);
    }

    public void downloadContentFile(String str, String str2) {
        getManager().downloadContentFile(str, str2);
    }

    public synchronized ConnectionControllerContract getConnection() {
        if (this.mImplementation) {
            return this.mConnectionController;
        }
        return this.mDummyConnectionController;
    }

    public ConnectionControllerContract.JwtResultItem getJWT(String str, String str2, String str3, String str4) {
        return getConnection().getJWT(str, str2, str3, str4);
    }

    public int getJwtMode(String str) {
        return getConnection().getJwtMode(str);
    }

    public synchronized ManagerControllerContract getManager() {
        if (this.mImplementation) {
            return this.mManagerController;
        }
        return this.mDummyManagerController;
    }

    public String getUuid() {
        return getConnection().getUuid();
    }

    public synchronized ViewControllerContract getViewer() {
        if (this.mImplementation) {
            return this.mViewController;
        }
        return this.mDummyViewController;
    }

    public String getWorkspaceId() {
        return getManager().getWorkspaceId();
    }

    public void handleDeviceListChange(String str) {
        getViewer().handleDeviceListChange(str);
    }

    public void handleDownloadUrlMap(Map<String, String> map) {
        getManager().handleDownloadUrlMap(map);
    }

    public void handleReceiveServerResponse(long j, long j2, long j3, long j5, long j6, boolean z) {
        getManager().handleReceiveServerResponse(j, j2, j3, j5, j6, z);
    }

    public void handleResetWorkspaceResponse(long j) {
        getManager().handleResetWorkspaceResponse(j);
    }

    public void handleWorkspaceBlock() {
        getManager().handleWorkspaceBlock();
    }

    public boolean isAlreadySnapReleased() {
        return getConnection().isAlreadySnapReleased();
    }

    public boolean isClosing() {
        return getManager().isClosing();
    }

    public boolean isConcurrencyPausedByNetwork() {
        return getManager().isConcurrencyPausedByNetwork();
    }

    public boolean isImplementation() {
        return this.mImplementation;
    }

    public void onContentFileUploadError(int i) {
        getConnection().onContentFileUploadError(i);
    }

    public void onEditorUpdate(String str, String str2) {
        getViewer().onEditorUpdate(str, str2);
    }

    public void onError(String str) {
        getManager().onError(str);
    }

    public void onSnapError(String str) {
        getManager().onSnapError(str);
    }

    public void pauseConcurrency(String str) {
        getConnection().pauseConcurrency(str);
    }

    public void putNotifyNoteOpsBuffer(long j, List<NoteOp> list, String str) {
        getManager().putNotifyNoteOpsBuffer(j, list, str);
    }

    public void reconnect(String str) {
        getConnection().reconnect(str);
    }

    public void release() {
        this.mConnectionController.releaseGrpcContract();
        this.mViewController.releaseGrpcContract();
        this.mManagerController.releaseGrpcContract();
        this.mImplementation = false;
    }

    public void releaseLock(String str) {
        getManager().releaseLock(str);
    }

    public void resumeConcurrency(String str) {
        getConnection().resumeConcurrency(str);
    }

    public void runResumeRunnable() {
        getManager().runResumeRunnable();
    }

    public void saveUndownloadedStrokeInfo(String str, String str2) {
        getViewer().saveUndownloadedStrokeInfo(str, str2);
    }

    public void setAbnormalAckCheckPoint(long j) {
        getManager().setAbnormalAckCheckPoint(j);
    }

    public void setGrpcContract(ConnectionControllerContract connectionControllerContract, ViewControllerContract viewControllerContract, ManagerControllerContract managerControllerContract) {
        this.mConnectionController.setGrpcContract(connectionControllerContract);
        this.mViewController.setGrpcContract(viewControllerContract);
        this.mManagerController.setGrpcContract(managerControllerContract);
        this.mImplementation = true;
    }

    public boolean setLock(String str) {
        return getManager().setLock(str);
    }

    public void setPausedByNetwork(String str) {
        getManager().setPausedByNetwork(str);
    }

    public void showToast(String str) {
        getViewer().showToast(str);
    }

    public void updateSnapNoteLatestInfo(long j, long j2, String str) {
        getManager().updateSnapNoteLatestInfo(j, j2, str);
    }

    public void uploadContentFile(NoteOpFileData noteOpFileData, String str, String str2) {
        getManager().uploadContentFile(noteOpFileData, str, str2);
    }

    public void wakeConcurrencyPool() {
        getManager().wakeConcurrencyPool();
    }
}
