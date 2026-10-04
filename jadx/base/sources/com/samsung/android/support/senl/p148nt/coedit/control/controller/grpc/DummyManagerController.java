package com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc;

import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DummyManagerController implements ManagerControllerContract {
    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void applyStrokeBinary(String str, byte[] bArr) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void downloadContentFile(String str, String str2) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public String getWorkspaceId() {
        return "";
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void handleDownloadUrlMap(Map<String, String> map) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void handleReceiveServerResponse(long j, long j2, long j3, long j5, long j6, boolean z) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void handleResetWorkspaceResponse(long j) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void handleWorkspaceBlock() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public boolean isClosing() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public boolean isConcurrencyPausedByNetwork() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void onError(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void onSnapError(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void putNotifyNoteOpsBuffer(long j, List<NoteOp> list, String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void releaseLock(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void runResumeRunnable() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void setAbnormalAckCheckPoint(long j) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public boolean setLock(String str) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void setPausedByNetwork(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void updateSnapNoteLatestInfo(long j, long j2, String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void uploadContentFile(NoteOpFileData noteOpFileData, String str, String str2) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
    public void wakeConcurrencyPool() {
    }
}
