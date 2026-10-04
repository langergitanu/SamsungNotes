package com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc;

import com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ConnectionController implements ConnectionControllerContract {
    private ConnectionControllerContract mConnectionContract;

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
    public ConnectionControllerContract.JwtResultItem getJWT(String str, String str2, String str3, String str4) {
        return this.mConnectionContract.getJWT(str, str2, str3, str4);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
    public int getJwtMode(String str) {
        return this.mConnectionContract.getJwtMode(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
    public String getUuid() {
        return this.mConnectionContract.getUuid();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
    public boolean isAlreadySnapReleased() {
        return this.mConnectionContract.isAlreadySnapReleased();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
    public void onContentFileUploadError(int i) {
        this.mConnectionContract.onContentFileUploadError(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
    public int pauseConcurrency(String str) {
        return this.mConnectionContract.pauseConcurrency(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
    public void reconnect(String str) {
        this.mConnectionContract.reconnect(str);
    }

    public void releaseGrpcContract() {
        this.mConnectionContract = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
    public int resumeConcurrency(String str) {
        return this.mConnectionContract.resumeConcurrency(str);
    }

    public void setGrpcContract(ConnectionControllerContract connectionControllerContract) {
        this.mConnectionContract = connectionControllerContract;
    }
}
