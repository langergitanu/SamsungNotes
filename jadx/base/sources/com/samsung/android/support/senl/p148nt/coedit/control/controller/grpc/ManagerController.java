package com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc;

import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ManagerController implements ManagerControllerContract {
    private ManagerControllerContract mManagerContract;

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void applyStrokeBinary(String str, byte[] bArr) {
        this.mManagerContract.applyStrokeBinary(str, bArr);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void downloadContentFile(String str, String str2) {
        this.mManagerContract.downloadContentFile(str, str2);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public String getWorkspaceId() {
        return this.mManagerContract.getWorkspaceId();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void handleDownloadUrlMap(Map<String, String> map) {
        this.mManagerContract.handleDownloadUrlMap(map);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void handleReceiveServerResponse(long j, long j2, long j3, long j5, long j6, boolean z) {
        this.mManagerContract.handleReceiveServerResponse(j, j2, j3, j5, j6, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void handleResetWorkspaceResponse(long j) {
        this.mManagerContract.handleResetWorkspaceResponse(j);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void handleWorkspaceBlock() {
        this.mManagerContract.handleWorkspaceBlock();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public boolean isClosing() {
        return this.mManagerContract.isClosing();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public boolean isConcurrencyPausedByNetwork() {
        return this.mManagerContract.isConcurrencyPausedByNetwork();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void onError(String str) {
        this.mManagerContract.onError(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void onSnapError(String str) {
        this.mManagerContract.onSnapError(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void putNotifyNoteOpsBuffer(long j, List<NoteOp> list, String str) {
        this.mManagerContract.putNotifyNoteOpsBuffer(j, list, str);
    }

    public void releaseGrpcContract() {
        this.mManagerContract = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void releaseLock(String str) {
        this.mManagerContract.releaseLock(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void runResumeRunnable() {
        this.mManagerContract.runResumeRunnable();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void setAbnormalAckCheckPoint(long j) {
        this.mManagerContract.setAbnormalAckCheckPoint(j);
    }

    public void setGrpcContract(ManagerControllerContract managerControllerContract) {
        this.mManagerContract = managerControllerContract;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public boolean setLock(String str) {
        return this.mManagerContract.setLock(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void setPausedByNetwork(String str) {
        this.mManagerContract.setPausedByNetwork(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void updateSnapNoteLatestInfo(long j, long j2, String str) {
        this.mManagerContract.updateSnapNoteLatestInfo(j, j2, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void uploadContentFile(NoteOpFileData noteOpFileData, String str, String str2) {
        this.mManagerContract.uploadContentFile(noteOpFileData, str, str2);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void wakeConcurrencyPool() {
        this.mManagerContract.wakeConcurrencyPool();
    }
}
