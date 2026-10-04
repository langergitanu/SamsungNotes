package com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc;

import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DummyConnectionController implements ConnectionControllerContract {
    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
    public ConnectionControllerContract.JwtResultItem getJWT(String str, String str2, String str3, String str4) {
        return new ConnectionControllerContract.JwtResultItem(CoeditServiceConstants.ServerError.UNEXPECTED, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
    public int getJwtMode(String str) {
        return -1;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
    public String getUuid() {
        return "";
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
    public boolean isAlreadySnapReleased() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
    public void onContentFileUploadError(int i) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
    public int pauseConcurrency(String str) {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
    public void reconnect(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
    public int resumeConcurrency(String str) {
        return 0;
    }
}
